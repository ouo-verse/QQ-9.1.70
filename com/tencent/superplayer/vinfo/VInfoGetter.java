package com.tencent.superplayer.vinfo;

import android.content.Context;
import android.os.Looper;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VInfoGetter {
    private VInfoGetterListener mListener;
    private TVideoImpl mTVideoImpl;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface VInfoGetterListener {
        void onGetVInfoFailed(SuperPlayerVideoInfo superPlayerVideoInfo, int i3, int i16, String str);

        void onGetVInfoSuccess(SuperPlayerVideoInfo superPlayerVideoInfo);
    }

    public VInfoGetter(Context context, Looper looper) {
        this.mTVideoImpl = new TVideoImpl(context, looper);
    }

    public void doGetVInfo(SuperPlayerVideoInfo superPlayerVideoInfo) {
        if (superPlayerVideoInfo.getVideoSource() == 1) {
            this.mTVideoImpl.doGetVInfo(superPlayerVideoInfo);
        }
    }

    public void setListener(VInfoGetterListener vInfoGetterListener) {
        this.mTVideoImpl.setListener(vInfoGetterListener);
    }
}
