package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class MiniAppQRProcessor extends BaseQRScanResultProcessor {
    public MiniAppQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(ScannerParams scannerParams, Activity activity, String str) {
        int i3;
        if (scannerParams.f276518i) {
            i3 = 1012;
        } else {
            i3 = 1011;
        }
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByWxCode(activity, str, ((IWxMiniHostSceneManager) QRoute.api(IWxMiniHostSceneManager.class)).convertFromRefer(i3));
        this.f94980b.finish();
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        String lowerCase = str.toLowerCase();
        if ((!m(i3) || (!"mini_app".equals(scannerParams.f276515e) && !MiniAppLauncher.isMiniAppUrl(lowerCase) && !((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(lowerCase))) && !((IWxMiniManager) QRoute.api(IWxMiniManager.class)).isWxMiniApp(lowerCase) && !((IWxMiniManager) QRoute.api(IWxMiniManager.class)).isWxCodeType(str2)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean g() {
        return super.g();
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "MiniAppQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(final String str, String str2, final ScannerParams scannerParams) {
        String lowerCase = str.toLowerCase();
        final Activity activity = (Activity) this.f94980b.getContext();
        if ("mini_app".equals(scannerParams.f276515e)) {
            Intent intent = new Intent(MiniConst.MiniAppProxyImplConst.MINI_APP_SCAN_RESULT);
            intent.putExtra(MiniConst.MiniAppProxyImplConst.MINI_APP_SCAN_RESULT_TYPE, str2);
            intent.putExtra(MiniConst.MiniAppProxyImplConst.MINI_APP_SCAN_DATA_RESULT, str);
            this.f94980b.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
            this.f94980b.finish();
            return true;
        }
        int i3 = 1012;
        if (((IWxMiniManager) QRoute.api(IWxMiniManager.class)).isWxMiniApp(str)) {
            if (!scannerParams.f276518i) {
                i3 = 1011;
            }
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByWxRawData(activity, str, ((IWxMiniHostSceneManager) QRoute.api(IWxMiniHostSceneManager.class)).convertFromRefer(i3));
            this.f94980b.finish();
            return true;
        }
        if (MiniAppLauncher.isMiniAppUrl(lowerCase)) {
            MiniAppLauncher.launchMiniAppByScanCode(activity, str);
            this.f94980b.finish();
            return true;
        }
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(lowerCase)) {
            if (!scannerParams.f276518i) {
                i3 = 1011;
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, str, ((IWxMiniHostSceneManager) QRoute.api(IWxMiniHostSceneManager.class)).convertFromRefer(i3), null);
            this.f94980b.finish();
            return true;
        }
        if (((IWxMiniManager) QRoute.api(IWxMiniManager.class)).isWxCodeType(str2)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qrcode.processor.e
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppQRProcessor.this.o(scannerParams, activity, str);
                }
            });
            return true;
        }
        return false;
    }
}
