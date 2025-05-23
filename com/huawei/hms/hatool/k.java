package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class k extends u0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37152a;

        static {
            int[] iArr = new int[d0.values().length];
            f37152a = iArr;
            try {
                iArr[d0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37152a[d0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37152a[d0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected static f0 a(String str, String str2, String str3, String str4) {
        f0 a16 = u0.a(str, str2, str3, str4);
        String a17 = j.a().a(a1.c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String sha256Encrypt = SHA.sha256Encrypt(q0.f() + a17 + currentTimeMillis);
        a16.f(String.valueOf(currentTimeMillis));
        a16.g(sha256Encrypt);
        return a16;
    }

    public static Map<String, String> b(String str, String str2, String str3) {
        Map<String, String> c16 = u0.c(str, str3);
        Map<String, String> i3 = a1.i(str, str2);
        if (i3 == null) {
            return c16;
        }
        c16.putAll(i3);
        return c16;
    }

    public static h1 a(List<b1> list, String str, String str2, String str3, String str4) {
        v.c("hmsSdk", "generate UploadData");
        h1 b16 = u0.b(str, str2);
        if (b16 == null) {
            return null;
        }
        b16.a(a(m1.d().a(), str, str2, str3));
        b16.a(a(str, str2));
        b16.a(a(str2, str, str4));
        b16.a(a1.g(str, str2));
        b16.a(list);
        return b16;
    }

    protected static l a(String str, String str2) {
        l a16 = u0.a(str, str2);
        i c16 = j.a().c(str, str2);
        a16.g(j.a().a(a1.c(str, str2)));
        a16.f(a1.o(str, str2));
        a16.c(j.a().f(str, str2));
        int i3 = a.f37152a[c16.a().ordinal()];
        if (i3 == 1) {
            a16.d(c16.b());
        } else if (i3 == 2) {
            a16.b(c16.b());
        } else if (i3 == 3) {
            a16.e(c16.b());
        }
        return a16;
    }

    protected static y0 a(String str, String str2, String str3) {
        y0 a16 = u0.a(str, str2, str3);
        Pair<String, String> e16 = j.a().e(str2, str);
        a16.f((String) e16.first);
        a16.g((String) e16.second);
        a16.h(o.b());
        a16.d(j.a().d(str2, str));
        return a16;
    }
}
