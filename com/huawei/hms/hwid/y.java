package com.huawei.hms.hwid;

import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static final y f37332a = new y();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f37333b = new ConcurrentHashMap();

    y() {
    }

    public static y a() {
        return f37332a;
    }

    public final AuthHuaweiId b() {
        try {
            String str = this.f37333b.get("HuaweiIdAccount");
            if (str == null) {
                return null;
            }
            return AuthHuaweiId.fromJson(str);
        } catch (Throwable th5) {
            as.d("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "getHuaweiSignInAccount faild, exception:" + th5.getClass().getSimpleName(), true);
            return null;
        }
    }

    public void c() {
        this.f37333b.clear();
    }

    public void a(AuthHuaweiId authHuaweiId, HuaweiIdAuthParams huaweiIdAuthParams) {
        String json;
        as.b("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "saveDefaultHuaweiIdSignInAccount start.", true);
        if (authHuaweiId != null) {
            try {
                json = authHuaweiId.toJson();
            } catch (Throwable th5) {
                as.d("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "store faild, exception:" + th5.getClass().getSimpleName(), true);
                return;
            }
        } else {
            json = null;
        }
        a(json, huaweiIdAuthParams != null ? huaweiIdAuthParams.toJson() : null);
    }

    private void a(String str, String str2) {
        as.b("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "saveDefaultHuaweiIdSignInAccount start.", true);
        this.f37333b.remove("HuaweiIdAccount");
        this.f37333b.remove("HuaweiIdAuthParams");
        if (str != null) {
            this.f37333b.put("HuaweiIdAccount", str);
        }
        if (str2 != null) {
            this.f37333b.put("HuaweiIdAuthParams", str2);
        }
    }
}
