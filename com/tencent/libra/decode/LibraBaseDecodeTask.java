package com.tencent.libra.decode;

import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadContext;
import com.tencent.libra.LoadState;
import com.tencent.libra.cache.Key;
import com.tencent.libra.request.Option;
import com.tencent.libra.task.LibraBaseTask;
import com.tencent.libra.util.LibraImageUtil;
import com.tencent.libra.util.LibraLogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class LibraBaseDecodeTask extends LibraBaseTask {
    Key mDecodeRequest;

    public LibraBaseDecodeTask(LoadContext loadContext, Key key) {
        super(loadContext);
        this.mDecodeRequest = key;
    }

    private boolean isNinePatch() {
        if (this.mOption.getResultBitMap() == null || this.mOption.getResultBitMap().getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(this.mOption.getResultBitMap().getNinePatchChunk())) {
            return false;
        }
        LibraLogUtil.INSTANCE.i(getLogTag(), RFWLog.USR, this.mOption, "[isNinePatch] true");
        return true;
    }

    protected abstract void decode(Option option);

    @Override // com.tencent.libra.task.LibraBaseTask
    public void onCancel() {
        this.mPicLoader.dispatchCancelDecodeState(this.mOption);
    }

    @Override // com.tencent.libra.task.ILibraTask, java.lang.Runnable
    @CallSuper
    public void run() {
        if (this.mStatus == LoadState.STATE_CANCEL) {
            return;
        }
        this.mStatus = LoadState.STATE_DECODING;
        this.mTaskStartTime = System.currentTimeMillis();
        LibraLogUtil libraLogUtil = LibraLogUtil.INSTANCE;
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Option option = this.mOption;
        libraLogUtil.i(logTag, i3, option, "[run] decode task start cost:", Long.valueOf(this.mTaskStartTime - option.mDecodeStartTime.longValue()));
        decode(this.mOption);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPicType(BitmapFactory.Options options) {
        if (options != null && !TextUtils.isEmpty(options.outMimeType)) {
            int mimeType2PicType = LibraImageUtil.mimeType2PicType(options.outMimeType);
            if (mimeType2PicType == 5 && isNinePatch()) {
                mimeType2PicType = 2;
            }
            this.mOption.setPicType(mimeType2PicType);
        }
    }
}
