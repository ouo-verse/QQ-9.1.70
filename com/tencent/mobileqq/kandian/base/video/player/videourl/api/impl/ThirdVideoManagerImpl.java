package com.tencent.mobileqq.kandian.base.video.player.videourl.api.impl;

import com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager;
import r52.a;
import r52.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ThirdVideoManagerImpl implements IThirdVideoManager {
    @Override // com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager
    public String getUrlByVid(String str) {
        return b.b(str);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager
    public a getVidUrlObjectFromCache(String str) {
        return b.c(str);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager
    public void sendUrlToUUIDRequest(String str, s52.a aVar) {
    }
}
