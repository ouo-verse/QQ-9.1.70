package com.tencent.luggage.wxa.mc;

import android.database.Cursor;
import com.tencent.luggage.wxa.tn.w0;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f134408a = new y();

    public static final h0 a(l0 l0Var, int i3) {
        Intrinsics.checkNotNullParameter(l0Var, "<this>");
        Cursor a16 = l0Var.a().a("select * from " + l0Var.b() + " where appId=? and debugType=? and pkgPath!=? order by version desc", new String[]{"@LibraryAppId", String.valueOf(i3), ""}, 2);
        if (a16 != null) {
            try {
                if (a16.moveToFirst()) {
                    h0 h0Var = new h0();
                    do {
                        h0Var.a(a16);
                        if (f134408a.a(h0Var)) {
                            CloseableKt.closeFinally(a16, null);
                            return h0Var;
                        }
                    } while (a16.moveToNext());
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(a16, null);
                } else {
                    CloseableKt.closeFinally(a16, null);
                    return null;
                }
            } finally {
            }
        }
        return null;
    }

    public final boolean a(h0 h0Var) {
        Intrinsics.checkNotNullParameter(h0Var, "<this>");
        if (999 == h0Var.f138319p) {
            long j3 = h0Var.f138325v;
            if (j3 > 0 && j3 <= w0.d()) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaCommLibVersionUtils", "checkIsValid BETA_LIBRARY expired, endTime:" + h0Var.f138325v);
                return false;
            }
        }
        if (com.tencent.luggage.wxa.cp.x.d(h0Var.f138315l)) {
            try {
                String a16 = com.tencent.mm.plugin.appbrand.appcache.a.a(new com.tencent.luggage.wxa.cp.v(h0Var.f138315l));
                Intrinsics.checkNotNull(a16);
                if (Intrinsics.areEqual(a16, h0Var.f138309f) || Intrinsics.areEqual(a16, h0Var.f138311h)) {
                    return true;
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaCommLibVersionUtils", "checkIsValid getFileMD5 failed " + e16 + ", path:" + h0Var.f138315l + ", version:" + h0Var.f138307d + ", versionType:" + h0Var.f138319p);
            }
        }
        return false;
    }
}
