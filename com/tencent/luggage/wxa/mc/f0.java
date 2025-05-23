package com.tencent.luggage.wxa.mc;

import android.util.Pair;
import com.tencent.luggage.wxa.mc.e;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f0 f134289a = new f0();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        APP_READY,
        APP_MANIFEST_NULL,
        PKG_EXPIRED,
        APP_NOT_INSTALLED,
        APP_BROKEN,
        ENV_ERR
    }

    public final String a(String str) {
        return com.tencent.mm.plugin.appbrand.appcache.a.b(str);
    }

    public final Pair a(String str, int i3, int i16) {
        h0 a16;
        Pair create;
        String[] strArr = {"pkgPath", "versionMd5", "NewMd5", "version"};
        if (e.a.b(i3) && i16 > 0) {
            a16 = j0.a().a(str, i16, i3, (String[]) Arrays.copyOf(strArr, 4));
        } else {
            a16 = j0.a().a(str, i3, (String[]) Arrays.copyOf(strArr, 4));
        }
        if (a16 == null) {
            Pair create2 = Pair.create(a.APP_MANIFEST_NULL, null);
            Intrinsics.checkNotNullExpressionValue(create2, "{\n                Pair.c\u2026NULL, null)\n            }");
            return create2;
        }
        String str2 = a16.f138315l;
        boolean z16 = true;
        if (!(str2 == null || str2.length() == 0) && com.tencent.luggage.wxa.cp.x.d(a16.f138315l)) {
            String a17 = a(a16.f138315l);
            String[] strArr2 = {a16.f138309f, a16.f138311h};
            int i17 = 0;
            while (true) {
                if (i17 < 2) {
                    String str3 = strArr2[i17];
                    if (!(str3 == null || str3.length() == 0) && Intrinsics.areEqual(str3, a17)) {
                        break;
                    }
                    i17++;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                com.tencent.mm.plugin.appbrand.appcache.a aVar = new com.tencent.mm.plugin.appbrand.appcache.a();
                aVar.pkgVersion = a16.f138307d;
                aVar.f151862b = a16.f138317n;
                aVar.pkgPath = a16.f138315l;
                aVar.f151863c = false;
                aVar.f151861a = a16.f138319p;
                aVar.md5 = a17;
                create = Pair.create(a.APP_READY, aVar);
            } else {
                create = Pair.create(a.APP_BROKEN, null);
            }
            Intrinsics.checkNotNullExpressionValue(create, "{\n                val fi\u2026          }\n            }");
            return create;
        }
        Pair create3 = Pair.create(a.APP_BROKEN, null);
        Intrinsics.checkNotNullExpressionValue(create3, "{\n                Pair.c\u2026OKEN, null)\n            }");
        return create3;
    }
}
