package com.tencent.mobileqq.flashtransfer.processor;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes33.dex */
public class FlashTransferProcessor extends BaseQRScanResultProcessor {
    public FlashTransferProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    public static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        String path = parse.getPath();
        if (host != null) {
            return ((!host.equals("qfile.qq.com") && !host.equals("test.qfile.qq.com")) || path == null || path.isEmpty()) ? false : true;
        }
        return false;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        boolean z16 = m(i3) && o(str.toLowerCase());
        QLog.d("IQRScanConst_BaseQRScanResultProcessor", 1, String.format("intercept proc=[%s] intercept=%b result=%s", getName(), Boolean.valueOf(z16), str));
        return z16;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean g() {
        return super.g();
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "FlashTransferProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(String str, String str2, ScannerParams scannerParams) {
        AppRuntime appRuntime = this.f94979a;
        if (!(appRuntime instanceof QQAppInterface)) {
            return false;
        }
        Activity activity = (Activity) this.f94980b.getContext();
        boolean z16 = scannerParams.f276518i;
        if (!((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).interceptFlashTransferUrl(activity, str, 8, 4)) {
            return false;
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.processor.FlashTransferProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                ((BaseQRScanResultProcessor) FlashTransferProcessor.this).f94980b.finish();
            }
        }, 100L);
        return true;
    }
}
