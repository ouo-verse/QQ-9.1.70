package com.tencent.tmediacodec.pools;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.reuse.ReusePolicy;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes26.dex */
public final class CodecWrapperPool implements Pool<ReuseCodecWrapper, FormatWrapper> {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "CodecWrapperPool";
    private PoolActionCallback actionCallback;
    private final int capacity;
    private final String name;
    private final CopyOnWriteArraySet<ReuseCodecWrapper> storeSet;

    public CodecWrapperPool(int i3, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            return;
        }
        this.storeSet = new CopyOnWriteArraySet<>();
        this.capacity = i3;
        this.name = str;
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
            if (!next.isRecycled && next.canReuse(formatWrapper) != ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO) {
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

    @Override // com.tencent.tmediacodec.pools.Pool
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        LogUtils.i("CodecWrapperPool", "CodecWrapperPool clear:" + this.storeSet);
        Iterator<ReuseCodecWrapper> it = this.storeSet.iterator();
        while (it.hasNext()) {
            ReuseCodecWrapper next = it.next();
            PoolActionCallback poolActionCallback = this.actionCallback;
            if (poolActionCallback != null) {
                poolActionCallback.onErase(next);
            }
        }
        this.storeSet.clear();
    }

    @Override // com.tencent.tmediacodec.pools.Pool
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.storeSet.isEmpty();
    }

    @Override // com.tencent.tmediacodec.pools.Pool
    public boolean isFull() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.storeSet.size() == this.capacity) {
            return true;
        }
        return false;
    }

    public final void setActionCallback(@NonNull PoolActionCallback poolActionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) poolActionCallback);
        } else {
            this.actionCallback = poolActionCallback;
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "size:" + this.storeSet.size() + " elements:" + this.storeSet;
    }

    @Override // com.tencent.tmediacodec.pools.Pool
    @Nullable
    public ReuseCodecWrapper obtain(@NonNull FormatWrapper formatWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ReuseCodecWrapper) iPatchRedirector.redirect((short) 7, (Object) this, (Object) formatWrapper);
        }
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

    @Override // com.tencent.tmediacodec.pools.Pool
    public void put(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) reuseCodecWrapper);
            return;
        }
        if (isFull()) {
            remove(getRemoveItem(reuseCodecWrapper));
        }
        this.storeSet.add(reuseCodecWrapper);
    }

    @Override // com.tencent.tmediacodec.pools.Pool
    public void remove(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) reuseCodecWrapper);
            return;
        }
        if (this.storeSet.remove(reuseCodecWrapper)) {
            PoolActionCallback poolActionCallback = this.actionCallback;
            if (poolActionCallback != null) {
                poolActionCallback.onErase(reuseCodecWrapper);
                return;
            }
            return;
        }
        LogUtils.w("CodecWrapperPool", "pool:" + this.name + " remove " + reuseCodecWrapper + " not found");
    }
}
