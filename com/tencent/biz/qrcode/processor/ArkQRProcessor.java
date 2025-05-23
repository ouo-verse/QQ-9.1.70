package com.tencent.biz.qrcode.processor;

import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class ArkQRProcessor extends BaseQRScanResultProcessor {
    public ArkQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        str.toLowerCase();
        if (m(i3) && "com.tencent.ark.scan".equals(scannerParams.f276515e)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean g() {
        return true;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "ArkQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(String str, String str2, ScannerParams scannerParams) {
        Intent intent = new Intent("com.tencent.mobileqq.ark.api.scanResultAction");
        intent.putExtra("com.tencent.ark.scanResultData", str);
        intent.putExtra("com.tencent.ark.scanResultType", str2);
        this.f94980b.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        this.f94980b.finish();
        return true;
    }
}
