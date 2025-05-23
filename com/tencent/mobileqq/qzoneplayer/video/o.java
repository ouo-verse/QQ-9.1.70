package com.tencent.mobileqq.qzoneplayer.video;

import android.os.Handler;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes35.dex */
public class o implements u {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<BaseVideo> f280017a;

    public o(BaseVideo baseVideo) {
        this.f280017a = new WeakReference<>(baseVideo);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.u
    public void a(String str, int i3, String str2) {
        VideoPlayInfo videoPlayInfo;
        BaseVideo baseVideo = this.f280017a.get();
        if (baseVideo == null || i3 != -3 || TextUtils.isEmpty(str) || (videoPlayInfo = baseVideo.mVideoPlayInfo) == null || !str.equals(videoPlayInfo.videoId)) {
            return;
        }
        Handler handler = baseVideo.mHandler;
        handler.sendMessage(handler.obtainMessage(18, this));
    }
}
