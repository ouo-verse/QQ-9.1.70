package com.tencent.biz.qrcode.processor;

import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class MiniCodeQRProcessor extends BaseQRScanResultProcessor {
    public MiniCodeQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        str.toLowerCase();
        return l(i3);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean g() {
        return true;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "MiniCodeQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(String str, String str2, ScannerParams scannerParams) {
        if (QLog.isColorLevel()) {
            QLog.i("BaseQRScanResultProcessor.MiniCodeProcessor", 2, String.format("jumpMiniCode result=%s", str));
        }
        if ("wx".equals(str2)) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByQQCode(this.f94980b.getContext(), str, 1048);
        } else {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchAppByMiniCode(this.f94980b.getContext(), str, 1048, null);
        }
        this.f94980b.finish();
        return true;
    }
}
