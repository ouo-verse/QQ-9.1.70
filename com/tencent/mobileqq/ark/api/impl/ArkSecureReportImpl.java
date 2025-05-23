package com.tencent.mobileqq.ark.api.impl;

import android.net.Uri;
import android.util.Pair;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkSecureReportImpl implements IArkSecureReport {
    static final String TAG = "ArkApp.SecureReport";
    static final int URL_TYPE_RES = 1;
    static final int URL_TYPE_WEB = 2;

    static Pair<String, String> getUrlSchemePath(String str) {
        try {
            Uri parse = Uri.parse(str);
            return new Pair<>(parse.getScheme(), parse.getAuthority() + parse.getPath());
        } catch (Exception e16) {
            QLog.i(TAG, 1, "getUrlPath fail, " + e16);
            return new Pair<>("", "");
        }
    }

    static void reportArkCheckURLMonitor(String str, String str2, int i3, int i16) {
        String currentAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
        Pair<String, String> urlSchemePath = getUrlSchemePath(str2);
        HashMap hashMap = new HashMap();
        hashMap.put("appid", str);
        hashMap.put(ZPlanPublishSource.FROM_SCHEME, (String) urlSchemePath.first);
        hashMap.put("url", (String) urlSchemePath.second);
        hashMap.put("urlType", String.valueOf(i3));
        hashMap.put("result", String.valueOf(i16));
        QQBeaconReport.report(currentAccountUin, "ArkURLCheckMonitor", hashMap);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkSecureReport
    public void reportAccumulatedValidURL(String str) {
        com.tencent.mobileqq.ark.secure.a.g(str);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkSecureReport
    public void reportArkOpenUrl(String str, String str2, String str3) {
        com.tencent.mobileqq.ark.secure.a.c(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkSecureReport
    public void reportNavigateURLAccess(String str, String str2, int i3, int i16, String str3) {
        com.tencent.mobileqq.ark.secure.a.f(str, str2, i3, i16, str3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkSecureReport
    public void reportOpenURLAccess(String str, String str2, int i3, int i16, String str3) {
        com.tencent.mobileqq.ark.secure.a.d(str, str2, i3, i16, str3);
        reportArkCheckURLMonitor(str, str2, 2, i16);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkSecureReport
    public void reportResourceURLAccess(String str, String str2, int i3, int i16, String str3) {
        com.tencent.mobileqq.ark.secure.a.e(str, str2, i3, i16, str3);
        reportArkCheckURLMonitor(str, str2, 1, i16);
    }
}
