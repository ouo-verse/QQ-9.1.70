package com.tencent.luggage.wxa.i5;

import com.tencent.luggage.wxa.fd.b0;
import com.tencent.luggage.wxa.hn.ae;
import com.tencent.luggage.wxa.hn.zd;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.n3.e {

    /* renamed from: b, reason: collision with root package name */
    public static final c f129475b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final String f129476c = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";

    @Override // com.tencent.luggage.wxa.n3.e
    public String a() {
        return f129476c;
    }

    public final Object a(String str, Continuation continuation) {
        zd zdVar = new zd();
        zdVar.f129153e = str;
        zdVar.f129154f = b0.f125700a.a(str);
        Unit unit = Unit.INSTANCE;
        return a(null, zdVar, ae.class, continuation);
    }
}
