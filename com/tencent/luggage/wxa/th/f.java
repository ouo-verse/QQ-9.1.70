package com.tencent.luggage.wxa.th;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.rc.m;
import com.tencent.luggage.wxa.tn.w;
import java.util.zip.ZipInputStream;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f141339a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f141340b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f141341a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v invoke() {
            v vVar = new v(com.tencent.luggage.wxa.db.a.e(), "wxacache");
            x.m(vVar.g());
            v vVar2 = new v(vVar, "unzip");
            x.m(vVar2.g());
            return vVar2;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f141341a);
        f141340b = lazy;
    }

    public final v a() {
        return (v) f141340b.getValue();
    }

    public final v b(com.tencent.luggage.wxa.xd.d component, String zipPath) {
        boolean z16;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        String a16 = a(component, zipPath);
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w.f("MicroMsg.AppBrand.AppBrandUnzipLogic", "getUnzipDir, unzipPathName is empty");
            return null;
        }
        return new v(a(), a16);
    }

    public final boolean a(v unzipDir) {
        Intrinsics.checkNotNullParameter(unzipDir, "unzipDir");
        return d.f141334a.c(unzipDir);
    }

    public final v a(ZipInputStream zipInputStream, v unzipDir) {
        Intrinsics.checkNotNullParameter(zipInputStream, "zipInputStream");
        Intrinsics.checkNotNullParameter(unzipDir, "unzipDir");
        int a16 = m.a(zipInputStream, unzipDir.g());
        w.d("MicroMsg.AppBrand.AppBrandUnzipLogic", "unzip, unzipRet: " + a16);
        if (a16 != 0) {
            return null;
        }
        if (d.f141334a.d(unzipDir)) {
            return unzipDir;
        }
        w.f("MicroMsg.AppBrand.AppBrandUnzipLogic", "unzip, record fail");
        return null;
    }

    public final String a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        boolean startsWith;
        boolean startsWith2;
        startsWith = StringsKt__StringsJVMKt.startsWith(str, "wxfile://", true);
        if (!startsWith) {
            startsWith2 = StringsKt__StringsJVMKt.startsWith(str, "http", true);
            if (!startsWith2) {
                str = dVar.getAppId() + util.base64_pad_url + str;
            }
        }
        w.a("MicroMsg.AppBrand.AppBrandUnzipLogic", "generateUnzipPath, rawUnzipPath: " + str);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return com.tencent.luggage.wxa.y8.c.a(bytes);
    }
}
