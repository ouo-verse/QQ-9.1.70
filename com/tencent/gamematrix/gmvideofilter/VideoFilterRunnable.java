package com.tencent.gamematrix.gmvideofilter;

import com.tencent.gamematrix.gmvideofilter.VideoFilter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class VideoFilterRunnable implements Runnable {
    VideoFilter.Callback cb_;
    String desc_;
    int errCode_;
    int function_;
    int module_;
    int solution_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoFilterRunnable(VideoFilter.Callback callback, int i3, int i16, int i17, int i18, String str) {
        this.solution_ = i3;
        this.module_ = i16;
        this.function_ = i17;
        this.errCode_ = i18;
        this.desc_ = str;
        this.cb_ = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoFilter.Callback callback = this.cb_;
        if (callback != null) {
            callback.OnVideoFilterCallbak(this.solution_, this.module_, this.function_, this.errCode_, this.desc_);
        }
    }
}
