package com.tencent.luggage.wxa.mc;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f134407a = new x();

    public final com.tencent.luggage.wxa.rc.q a() {
        com.tencent.luggage.wxa.rc.q qVar;
        if (com.tencent.luggage.wxa.tn.z.m()) {
            try {
                qVar = a(this, null, "checkUsableReader", 0, false, 13, null);
            } catch (IllegalStateException e16) {
                com.tencent.luggage.wxa.tn.w.a("Luggage.WxaCommLibProvider", e16, "checkUsableReader", new Object[0]);
                qVar = null;
            }
            if (f.G()) {
                f fVar = f.f134287h;
                Intrinsics.checkNotNullExpressionValue(fVar, "{\n            DebugReader.INSTANCE\n        }");
                return fVar;
            }
            if (qVar != null && qVar.w() > c.f134270g.w()) {
                return qVar;
            }
            c cVar = c.f134270g;
            Intrinsics.checkNotNullExpressionValue(cVar, "{\n            AssetReader.INSTANCE\n        }");
            return cVar;
        }
        throw new IllegalStateException("Should be accessed in main process".toString());
    }

    public static /* synthetic */ com.tencent.luggage.wxa.rc.q a(x xVar, com.tencent.luggage.wxa.tk.i iVar, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            iVar = null;
        }
        if ((i16 & 2) != 0) {
            str = "";
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        return xVar.a(iVar, str, i3, z16);
    }

    public final com.tencent.luggage.wxa.rc.q a(com.tencent.luggage.wxa.tk.i iVar, String str, int i3, boolean z16) {
        l0 l0Var = (l0) com.tencent.luggage.wxa.c6.b.a(l0.class);
        WxaCommLibFileReader wxaCommLibFileReader = null;
        if (l0Var == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaCommLibProvider", "checkUsableReaderByStorage(" + str + ") NULL storage, return NULL");
            return null;
        }
        h0 a16 = y.a(l0Var, i3);
        if (a16 == null) {
            if (999 == i3 && z16) {
                l0Var.a("@LibraryAppId", i3);
            }
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaCommLibProvider", "checkUsableReaderByStorage(" + str + ") NULL record, return NULL");
            return null;
        }
        if (iVar != null) {
            iVar.f141499a = a16;
        }
        String str2 = a16.f138315l;
        boolean z17 = true;
        if (!(str2 == null || str2.length() == 0) && com.tencent.luggage.wxa.cp.x.d(a16.f138315l)) {
            String a17 = com.tencent.mm.plugin.appbrand.appcache.a.a(new com.tencent.luggage.wxa.cp.v(a16.f138315l));
            if (a17 != null && a17.length() != 0) {
                z17 = false;
            }
            if (!z17 && Intrinsics.areEqual(a17, a16.f138309f)) {
                int i16 = 999 == i3 ? 0 : a16.f138307d;
                String str3 = a16.f138315l;
                Intrinsics.checkNotNullExpressionValue(str3, "record.field_pkgPath");
                wxaCommLibFileReader = new WxaCommLibFileReader(str3, i16, a17);
                if (i3 == 0) {
                    l0Var.b("@LibraryAppId", 0, a16.f138307d);
                }
            } else {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaCommLibProvider", "checkUsableReaderByStorage(" + str + ") fileMd5(" + a17 + ") != recordMd5(" + a16.f138309f + ") , return NULL");
            }
            return wxaCommLibFileReader;
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaCommLibProvider", "checkUsableReaderByStorage(" + str + ") pkgPath(" + a16.f138315l + ") not valid, return NULL");
        return null;
    }
}
