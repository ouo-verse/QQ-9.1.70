package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import cooperation.qwallet.plugin.IQWalletHelper;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class QWalletQRProcessor extends BaseQRScanResultProcessor {
    public QWalletQRProcessor(AppRuntime appRuntime, k kVar) {
        super(appRuntime, kVar);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        String lowerCase = str.toLowerCase();
        if (m(i3) && (com.tencent.biz.qrcode.util.h.F(lowerCase) || com.tencent.biz.qrcode.util.h.D(lowerCase) || com.tencent.biz.qrcode.util.h.z(lowerCase))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean c(int i3, int i16, Intent intent) {
        if (1 == i3) {
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
        return "QWalletQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    protected boolean j(int i3, int i16, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("retdata");
            if (!TextUtils.isEmpty(stringExtra)) {
                n((Activity) this.f94980b.getContext(), stringExtra);
            }
        }
        this.f94980b.finish();
        return true;
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
        if (com.tencent.biz.qrcode.util.h.F(lowerCase)) {
            ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).doQWalletQRCode(qQAppInterface, activity, str);
            return true;
        }
        if (com.tencent.biz.qrcode.util.h.D(lowerCase)) {
            ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).doQRCodePay(qQAppInterface, activity, str, this.f94980b);
            return true;
        }
        if (!com.tencent.biz.qrcode.util.h.z(lowerCase)) {
            return false;
        }
        ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).doF2FRedpack(qQAppInterface, activity, str);
        return true;
    }

    public void n(Activity activity, String str) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("exec_code", "-1");
                String optString2 = jSONObject.optString("url", "");
                String optString3 = jSONObject.optString("uin", "");
                int intValue = Integer.valueOf(optString).intValue();
                if (intValue != 1) {
                    if (intValue != 2) {
                        if (intValue == 3 && !TextUtils.isEmpty(optString2)) {
                            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                            intent.putExtra("url", optString2);
                            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                            activity.startActivity(intent);
                            activity.finish();
                            return;
                        }
                        return;
                    }
                    Intent aliasIntent = SplashActivity.getAliasIntent(activity);
                    aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
                    aliasIntent.setFlags(67108864);
                    activity.startActivity(aliasIntent);
                    activity.finish();
                    return;
                }
                if (!TextUtils.isEmpty(optString3)) {
                    String str2 = "mqqapi://im/chat?src_type=web&uin=" + optString3 + "&attach_content=&version=1&chat_type=c2c";
                    Intent intent2 = new Intent(activity, (Class<?>) JumpActivity.class);
                    intent2.setData(Uri.parse(str2));
                    activity.startActivity(intent2);
                    activity.finish();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
