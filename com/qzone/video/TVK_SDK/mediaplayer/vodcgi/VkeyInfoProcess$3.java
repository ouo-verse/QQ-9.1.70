package com.qzone.video.TVK_SDK.mediaplayer.vodcgi;

import com.qzone.video.TVK_SDK.mediaplayer.config.TencentVideo;
import com.qzone.video.TVK_SDK.mediaplayer.utils.HttpUtils;

/* loaded from: classes37.dex */
class VkeyInfoProcess$3 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f59911d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ap.d f59912e;
    final /* synthetic */ d this$0;

    @Override // java.lang.Runnable
    public void run() {
        try {
            HttpUtils.g(TencentVideo.a(), this.f59911d, d.b(null), this.f59912e, null, d.a(null));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
