package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class CardQRProcessor extends BaseQRScanResultProcessor {

    /* renamed from: c, reason: collision with root package name */
    private int f94983c;

    public CardQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
        this.f94983c = -1;
    }

    public static int n(String str) {
        int i3;
        String lowerCase = str.toLowerCase();
        if (Pattern.compile("^mecard.*").matcher(lowerCase).matches() && (str.length() > 7 || str.contains(":"))) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        if (Pattern.compile("^begin:vcard[\\s\\S]*end:vcard").matcher(lowerCase).matches() && (str.length() > 21 || str.contains(":"))) {
            i3 = 1;
        }
        if (Pattern.compile("^bizcard.*;;$").matcher(lowerCase).matches()) {
            if (str.length() > 11 || str.contains(":")) {
                return 2;
            }
            return i3;
        }
        return i3;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        this.f94983c = n(str);
        QLog.d("IQRScanConst_BaseQRScanResultProcessor", 1, String.format("intercept proc=[%s] cardMode=%d result=%s", getName(), Integer.valueOf(this.f94983c), str));
        if (!m(i3) || this.f94983c == -1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean g() {
        return true;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "CardQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    public boolean k(String str, String str2, ScannerParams scannerParams) {
        AppRuntime appRuntime = this.f94979a;
        if (!(appRuntime instanceof QQAppInterface)) {
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        Activity activity = (Activity) this.f94980b.getContext();
        if (this.f94983c == -1) {
            return false;
        }
        ((IQRJumpApi) QRoute.api(IQRJumpApi.class)).displayQRCard(qQAppInterface, activity, str, this.f94983c);
        this.f94980b.finish();
        return true;
    }
}
