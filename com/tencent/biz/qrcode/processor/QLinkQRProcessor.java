package com.tencent.biz.qrcode.processor;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.utils.AudioUtil;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class QLinkQRProcessor extends BaseQRScanResultProcessor {
    public QLinkQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        String lowerCase = str.toLowerCase();
        if (m(i3) && (lowerCase.startsWith("qqf2f://qf/") || "qlink".equalsIgnoreCase(scannerParams.f276515e))) {
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
        return "QLinkQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(final String str, String str2, ScannerParams scannerParams) {
        AppRuntime appRuntime = this.f94979a;
        if (!(appRuntime instanceof QQAppInterface)) {
            return false;
        }
        final QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        final AppActivity appActivity = (AppActivity) this.f94980b.getContext();
        if (str.toLowerCase().startsWith("qqf2f://qf/")) {
            if (!qQAppInterface.isRingerVibrate() && !qQAppInterface.isRingerSilent() && !qQAppInterface.isRingEqualsZero()) {
                AudioUtil.n(R.raw.f169446aa, false);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qrcode.processor.QLinkQRProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    qQAppInterface.getQQProxyForQlink().p(appActivity, str, QLinkQRProcessor.this.f94980b);
                }
            });
            return true;
        }
        if (!"qlink".equalsIgnoreCase(scannerParams.f276515e)) {
            return false;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qrcode.processor.QLinkQRProcessor.2
            @Override // java.lang.Runnable
            public void run() {
                qQAppInterface.getQQProxyForQlink().q(appActivity, QLinkQRProcessor.this.f94980b);
            }
        });
        return true;
    }
}
