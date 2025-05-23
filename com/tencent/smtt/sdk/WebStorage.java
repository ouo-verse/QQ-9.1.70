package com.tencent.smtt.sdk;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebStorage {

    /* renamed from: a, reason: collision with root package name */
    private static WebStorage f369204a;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes23.dex */
    public interface QuotaUpdater {
        void updateQuota(long j3);
    }

    private static synchronized WebStorage a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            if (f369204a == null) {
                f369204a = new WebStorage();
            }
            webStorage = f369204a;
        }
        return webStorage;
    }

    public static WebStorage getInstance() {
        return a();
    }

    public void deleteAllData() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().n();
        } else {
            android.webkit.WebStorage.getInstance().deleteAllData();
        }
    }

    public void deleteOrigin(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().e(str);
        } else {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        }
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().a(valueCallback);
        } else {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b(str, valueCallback);
        } else {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        }
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().a(str, valueCallback);
        } else {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        }
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j3) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().a(str, j3);
        } else {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j3);
        }
    }
}
