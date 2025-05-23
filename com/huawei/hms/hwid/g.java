package com.huawei.hms.hwid;

import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AuthAccount;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final g f37320a = new g();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f37321b = new ConcurrentHashMap();

    g() {
    }

    public static g a() {
        return f37320a;
    }

    public final AuthAccount b() {
        as.b("[AccountSDK]AccountAuthMemCache", "getSignInAccount start.", true);
        try {
            String str = this.f37321b.get("AccountAuth");
            if (str == null) {
                return null;
            }
            return AuthAccount.fromJson(str);
        } catch (Throwable th5) {
            as.d("[AccountSDK]AccountAuthMemCache", "getSignInAccount faild, exception:" + th5.getClass().getSimpleName(), true);
            return null;
        }
    }

    public void c() {
        this.f37321b.clear();
    }

    public void a(AuthAccount authAccount, AccountAuthParams accountAuthParams) {
        String json;
        as.b("[AccountSDK]AccountAuthMemCache", "saveDefaultAccountSignInAccount start.", true);
        if (authAccount != null) {
            try {
                json = authAccount.toJson();
            } catch (Throwable th5) {
                as.d("[AccountSDK]AccountAuthMemCache", "store faild, exception:" + th5.getClass().getSimpleName(), true);
                return;
            }
        } else {
            json = null;
        }
        a(json, accountAuthParams != null ? accountAuthParams.toJson() : null);
    }

    private void a(String str, String str2) {
        as.b("[AccountSDK]AccountAuthMemCache", "saveDefaultAccountSignInAccount start.", true);
        this.f37321b.remove("AccountAuth");
        this.f37321b.remove("AccountAuthParams");
        if (str != null) {
            this.f37321b.put("AccountAuth", str);
        }
        if (str2 != null) {
            this.f37321b.put("AccountAuthParams", str2);
        }
    }
}
