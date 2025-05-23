package com.tencent.ecommerce.base.report.service;

import android.text.TextUtils;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/a;", "", "", "", "b", "businessId", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f100911a = new a();

    a() {
    }

    private final Map<String, String> b() {
        Map<String, String> deviceInfo = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().getDeviceInfo();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = deviceInfo.get("os_ver");
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("os_ver", str);
        String str2 = deviceInfo.get("brand");
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("brand", str2);
        String str3 = deviceInfo.get(JsonRuleKey.OPERATOR);
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put(JsonRuleKey.OPERATOR, str3);
        String str4 = deviceInfo.get("app_version");
        linkedHashMap.put("app_version", str4 != null ? str4 : "");
        return linkedHashMap;
    }

    public final Map<String, String> a(String businessId) {
        String valueOf;
        String str;
        HashMap hashMap = new HashMap();
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        hashMap.put("uin", String.valueOf(qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccount()));
        if (!TextUtils.isEmpty(businessId)) {
            valueOf = String.valueOf(businessId);
        } else {
            valueOf = String.valueOf(ug0.b.f438933d.e());
        }
        hashMap.put("bus_id", valueOf);
        if (qQEcommerceSdk.getGlobalInternalSdk().getRuntime().isPublicVersion()) {
            str = "2";
        } else if (!qQEcommerceSdk.getGlobalInternalSdk().getRuntime().isDebug()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("app_env", str);
        hashMap.put("os", "Android");
        hashMap.putAll(b());
        return hashMap;
    }
}
