package com.tencent.thumbplayer.core.codec.tmediacodec.pools;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.codec.tmediacodec.TCodecManager;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.FormatWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.reuse.ReuseHelper;
import com.tencent.thumbplayer.core.codec.tmediacodec.reuse.ReusePolicy;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes26.dex */
public final class CodecWrapperPool implements Pool<ReuseCodecWrapper, FormatWrapper> {
    public static final String TAG = "CodecWrapperPool";
    private PoolActionCallback mActionCallback;
    private final int mCapacity;
    private final String mName;
    private final CopyOnWriteArraySet<ReuseCodecWrapper> storeSet = new CopyOnWriteArraySet<>();

    public CodecWrapperPool(int i3, @NonNull String str) {
        this.mCapacity = i3;
        this.mName = str;
    }

    private ReuseCodecWrapper getFirstCodecWrapper() {
        Iterator<ReuseCodecWrapper> it = this.storeSet.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    private ReuseCodecWrapper getRemoveItem(ReuseCodecWrapper reuseCodecWrapper) {
        ReuseCodecWrapper replaceSameTypeCodec;
        Iterator<ReuseCodecWrapper> it = this.storeSet.iterator();
        if (TCodecManager.getInstance().getReusePolicy().eraseType == ReusePolicy.EraseType.SAME && (replaceSameTypeCodec = replaceSameTypeCodec(reuseCodecWrapper, it)) != null) {
            return replaceSameTypeCodec;
        }
        return getFirstCodecWrapper();
    }

    private final ReuseCodecWrapper pickSuitableCodecWrapper(FormatWrapper formatWrapper) {
        Iterator<ReuseCodecWrapper> it = this.storeSet.iterator();
        while (it.hasNext()) {
            ReuseCodecWrapper next = it.next();
            if (!next.mIsRecycled && next.canReuse(formatWrapper) != ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO) {
                return next;
            }
            next.trackCantReuse();
            if (next.needToErase()) {
                remove(next);
            }
        }
        return null;
    }

    private ReuseCodecWrapper replaceSameTypeCodec(ReuseCodecWrapper reuseCodecWrapper, Iterator it) {
        while (it.hasNext()) {
            ReuseCodecWrapper reuseCodecWrapper2 = (ReuseCodecWrapper) it.next();
            if (TextUtils.equals(reuseCodecWrapper.getCodecName(), reuseCodecWrapper2.getCodecName())) {
                return reuseCodecWrapper2;
            }
        }
        return null;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.Pool
    public void clear() {
        LogUtils.i("CodecWrapperPool", "CodecWrapperPool clear:" + this.storeSet);
        Iterator<ReuseCodecWrapper> it = this.storeSet.iterator();
        while (it.hasNext()) {
            ReuseCodecWrapper next = it.next();
            PoolActionCallback poolActionCallback = this.mActionCallback;
            if (poolActionCallback != null) {
                poolActionCallback.onErase(next);
            }
        }
        this.storeSet.clear();
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.Pool
    public boolean isEmpty() {
        return this.storeSet.isEmpty();
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.Pool
    public boolean isFull() {
        if (this.storeSet.size() == this.mCapacity) {
            return true;
        }
        return false;
    }

    public final void setActionCallback(@NonNull PoolActionCallback poolActionCallback) {
        this.mActionCallback = poolActionCallback;
    }

    @NonNull
    public String toString() {
        return "size:" + this.storeSet.size() + " elements:" + this.storeSet;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.Pool
    @Nullable
    public ReuseCodecWrapper obtain(@NonNull FormatWrapper formatWrapper) {
        ReuseCodecWrapper pickSuitableCodecWrapper = pickSuitableCodecWrapper(formatWrapper);
        if (LogUtils.isLogEnable()) {
            LogUtils.d("CodecWrapperPool", "obtain codecWrapper:" + pickSuitableCodecWrapper);
        }
        if (pickSuitableCodecWrapper == null) {
            return null;
        }
        this.storeSet.remove(pickSuitableCodecWrapper);
        return pickSuitableCodecWrapper;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.Pool
    public void put(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
        if (isFull()) {
            remove(getRemoveItem(reuseCodecWrapper));
        }
        this.storeSet.add(reuseCodecWrapper);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.Pool
    public void remove(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
        if (this.storeSet.remove(reuseCodecWrapper)) {
            PoolActionCallback poolActionCallback = this.mActionCallback;
            if (poolActionCallback != null) {
                poolActionCallback.onErase(reuseCodecWrapper);
                return;
            }
            return;
        }
        LogUtils.w("CodecWrapperPool", "pool:" + this.mName + " remove " + reuseCodecWrapper + " not found");
    }
}
