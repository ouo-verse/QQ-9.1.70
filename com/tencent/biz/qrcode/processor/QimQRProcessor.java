package com.tencent.biz.qrcode.processor;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class QimQRProcessor extends BaseQRScanResultProcessor {
    public QimQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    public static void n(String str, AppActivity appActivity) {
        Intent intent = new Intent(appActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("key_isReadModeEnabled", true);
        intent.putExtra("fromQrcode", true);
        intent.putExtra("url", str);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        boolean z16;
        if (m(i3) && com.tencent.mobileqq.qrscan.utils.b.d(str)) {
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
        return "QimQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(String str, String str2, ScannerParams scannerParams) {
        AppActivity appActivity = (AppActivity) this.f94980b.getContext();
        if (com.tencent.mobileqq.qrscan.utils.b.d(str)) {
            n(str, appActivity);
            this.f94980b.finish();
            return true;
        }
        return false;
    }
}
