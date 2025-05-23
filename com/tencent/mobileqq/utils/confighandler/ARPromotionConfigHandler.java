package com.tencent.mobileqq.utils.confighandler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.f;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* loaded from: classes20.dex */
public class ARPromotionConfigHandler {

    /* loaded from: classes20.dex */
    public static class ARPromotionEntryHandler extends NormalConfigHandler<PromotionConfigInfo> {
        public ARPromotionEntryHandler(String str) {
            super(f.f196950a + 365, str, "config_qq.android.ar_", DownloadInfo.spKey_Config, "ver");
        }

        @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
        public void onGetConfigFinish(QQAppInterface qQAppInterface, String str, PromotionConfigInfo promotionConfigInfo) {
            f.a(qQAppInterface).j(qQAppInterface, str, promotionConfigInfo);
        }
    }

    /* loaded from: classes20.dex */
    public static class ARPromotionResHandler extends NormalConfigHandler<DefaultConfigInfo> {
        public ARPromotionResHandler(String str) {
            super(f.f196950a + 364, str, "res_qq.android.ar_", DownloadInfo.spKey_Config, "ver");
        }

        @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
        public void onGetConfigFinish(QQAppInterface qQAppInterface, String str, DefaultConfigInfo defaultConfigInfo) {
            f.a(qQAppInterface).k(qQAppInterface, str, defaultConfigInfo);
        }
    }
}
