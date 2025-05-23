package com.tencent.mobileqq.wink.editor.hdr;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes21.dex */
class HDRInitUtils$1 implements Runnable {
    HDRInitUtils$1() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AE_RES_BASE_PACKAGE)) {
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).peakRequestAEBaseRes();
            ms.a.f("wink_hdr_HDRInitUtils", "will download base pkg");
        } else {
            a.b();
        }
    }
}
