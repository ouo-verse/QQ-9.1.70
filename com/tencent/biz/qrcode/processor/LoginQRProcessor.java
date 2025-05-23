package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.open.agent.QrAgentLoginManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class LoginQRProcessor extends BaseQRScanResultProcessor {
    public LoginQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        boolean z16;
        String lowerCase = str.toLowerCase();
        if (m(i3) && com.tencent.biz.qrcode.util.h.L(lowerCase) && !com.tencent.biz.qrcode.util.h.E(lowerCase)) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("IQRScanConst_BaseQRScanResultProcessor", 1, String.format("intercept proc=[%s] intercept=%b result=%s", getName(), Boolean.valueOf(z16), str));
        return z16;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean g() {
        return super.g();
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "LoginQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(String str, String str2, ScannerParams scannerParams) {
        AppRuntime appRuntime = this.f94979a;
        if (!(appRuntime instanceof QQAppInterface)) {
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        Activity activity = (Activity) this.f94980b.getContext();
        String lowerCase = str.toLowerCase();
        if (!com.tencent.biz.qrcode.util.h.L(lowerCase) || com.tencent.biz.qrcode.util.h.E(lowerCase)) {
            return false;
        }
        if (QrAgentLoginManager.f339969n) {
            this.f94980b.a(true);
            QrAgentLoginManager.t().D(qQAppInterface, str, this.f94980b, scannerParams);
            return true;
        }
        this.f94980b.a(true);
        Intent intent = new Intent(this.f94980b.getContext(), (Class<?>) QRLoginAuthActivity.class);
        intent.putExtra("QR_CODE_STRING", str);
        activity.startActivity(intent);
        this.f94980b.finish();
        return true;
    }
}
