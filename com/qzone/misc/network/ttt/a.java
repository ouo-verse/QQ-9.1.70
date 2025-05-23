package com.qzone.misc.network.ttt;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f48527b;

    /* renamed from: c, reason: collision with root package name */
    private static Object f48528c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Map<String, b> f48529a = new ConcurrentHashMap();

    public static a c() {
        if (f48527b == null) {
            synchronized (f48528c) {
                if (f48527b == null) {
                    f48527b = new a();
                }
            }
        }
        return f48527b;
    }

    private void g(String str) {
        b d16 = d(str);
        if (d16 != null) {
            d16.d();
        }
    }

    public void b(String str, int i3, int i16, int i17, BusinessFeedData businessFeedData, int i18, long j3) {
        b d16 = d(str);
        if (d16 != null) {
            d16.a(i3, i16, i17, businessFeedData, i18, j3);
        }
    }

    public void e(String str) {
        b d16 = d(str);
        if (d16 != null) {
            d16.c();
        }
        g(str);
    }

    public void h(String str) {
        b d16 = d(str);
        if (d16 != null) {
            d16.e();
        }
    }

    public void f(String str) {
        if (str != null) {
            this.f48529a.remove(str);
        }
    }

    private b d(String str) {
        if (str != null && this.f48529a.containsKey(str)) {
            return this.f48529a.get(str);
        }
        return null;
    }

    public void a(String str, int i3, int i16, int i17, BusinessFeedData businessFeedData, int i18) {
        b(str, i3, i16, i17, businessFeedData, i18, 0L);
    }
}
