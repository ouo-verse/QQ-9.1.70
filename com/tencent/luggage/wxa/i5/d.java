package com.tencent.luggage.wxa.i5;

import com.tencent.luggage.wxa.hn.ne;
import com.tencent.luggage.wxa.hn.oe;
import com.tencent.luggage.wxa.hn.v6;
import com.tencent.luggage.wxa.tn.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.n3.e {

    /* renamed from: c, reason: collision with root package name */
    public static final Void f129478c = null;

    /* renamed from: b, reason: collision with root package name */
    public static final d f129477b = new d();

    /* renamed from: d, reason: collision with root package name */
    public static final String f129479d = "/cgi-bin/mmbiz-bin/wxaapp_moduseuserinfo";

    @Override // com.tencent.luggage.wxa.n3.e
    public String a() {
        return f129479d;
    }

    public final Object a(String str, String str2, Continuation continuation) {
        v6 v6Var = new v6();
        v6Var.f128893d = str;
        v6Var.f128894e = (String) f129478c;
        v6Var.f128895f = str2;
        v6Var.f128896g = 7;
        return a(v6Var, continuation);
    }

    public final Object a(String str, String str2, String str3, Continuation continuation) {
        v6 v6Var = new v6();
        v6Var.f128893d = str;
        v6Var.f128894e = str2;
        v6Var.f128895f = str3;
        v6Var.f128896g = 7;
        return a(v6Var, continuation);
    }

    public final Object a(v6 v6Var, Continuation continuation) {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(v6Var);
        return a(listOf, continuation);
    }

    public final Object a(List list, Continuation continuation) {
        ne neVar = new ne();
        neVar.f128298e.addAll(list);
        Unit unit = Unit.INSTANCE;
        w.d("MicroMsg.AppBrand.CgiRevokeUserInfoAuthorize", "doRevoke, req: " + neVar.c());
        return a((String) null, neVar, oe.class, continuation);
    }
}
