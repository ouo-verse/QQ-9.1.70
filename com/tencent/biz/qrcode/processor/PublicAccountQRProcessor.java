package com.tencent.biz.qrcode.processor;

import android.content.Intent;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class PublicAccountQRProcessor extends BaseQRScanResultProcessor {
    public PublicAccountQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        if (m(i3) && ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountManager.class).equals(scannerParams.f276515e)) {
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
        return "PublicAccountQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(String str, String str2, ScannerParams scannerParams) {
        Intent intent = new Intent(IPublicAccountManager.PA_ACTION_SCAN_RESULT);
        if (str2 != null) {
            if (str2.equalsIgnoreCase(CommonConstant.RETKEY.QR_CODE)) {
                intent.putExtra(IPublicAccountManager.PA_DATA_SCAN_RESULT_TYPE, 2);
            } else {
                intent.putExtra(IPublicAccountManager.PA_DATA_SCAN_RESULT_TYPE, 1);
            }
        }
        intent.putExtra(IPublicAccountManager.PA_DATA_SCAN_RESULT, str);
        this.f94980b.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        this.f94980b.finish();
        return true;
    }
}
