package com.tencent.biz.qrcode.processor;

import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class MsgBackupQRProcessor extends BaseQRScanResultProcessor {
    public MsgBackupQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    public static void n(String str, AppActivity appActivity) {
        Intent intent = new Intent();
        intent.putExtra("msgbackup_qr_sig", str);
        intent.putExtra("param_start", 4);
        QPublicFragmentActivity.start(appActivity, intent, MsgBackupTransportFragment.class);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        if (m(i3) && str.startsWith("https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate")) {
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
        return "MsgBackupQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(String str, String str2, ScannerParams scannerParams) {
        if (str.startsWith("https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate")) {
            n(str, (AppActivity) this.f94980b.getContext());
            this.f94980b.finish();
            return true;
        }
        return false;
    }
}
