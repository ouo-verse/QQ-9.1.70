package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import com.tencent.hippy.qq.utils.HippyCommonUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class HippyQRProcessor extends BaseQRScanResultProcessor {
    public HippyQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        if (m(i3) && HippyCommonUtils.checkHippyQRCode(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean g() {
        return super.g();
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "HippyQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(String str, String str2, ScannerParams scannerParams) {
        AppRuntime appRuntime = this.f94979a;
        if (!(appRuntime instanceof QQAppInterface)) {
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        Activity activity = (Activity) this.f94980b.getContext();
        if (HippyCommonUtils.checkHippyQRCode(str)) {
            HippyCommonUtils.checkDebugHippyUpdate(qQAppInterface, (AppActivity) activity, str);
        }
        this.f94980b.finish();
        return true;
    }
}
