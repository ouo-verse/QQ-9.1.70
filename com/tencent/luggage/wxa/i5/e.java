package com.tencent.luggage.wxa.i5;

import com.tencent.luggage.wxa.hn.fe;
import com.tencent.luggage.wxa.hn.ge;
import com.tencent.luggage.wxa.tn.w;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.n3.e {

    /* renamed from: b, reason: collision with root package name */
    public static final e f129480b = new e();

    /* renamed from: c, reason: collision with root package name */
    public static final String f129481c = "/cgi-bin/mmbiz-bin/wxaapp_getwxauseuserinforecordlist";

    @Override // com.tencent.luggage.wxa.n3.e
    public String a() {
        return f129481c;
    }

    public static /* synthetic */ Object a(e eVar, String str, int i3, int i16, Continuation continuation, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        if ((i17 & 4) != 0) {
            i16 = 32;
        }
        return eVar.a(str, i3, i16, continuation);
    }

    public final Object a(String str, int i3, int i16, Continuation continuation) {
        w.d("MicroMsg.CgiWxaAppGetPrivacyUseRecord", "doFetch, appUsername: " + str + ", updateTime: " + i3 + ", maxFetchCount: " + i16);
        fe feVar = new fe();
        feVar.f127636e = str;
        feVar.f127637f = i3;
        feVar.f127638g = i16;
        Unit unit = Unit.INSTANCE;
        return a((String) null, feVar, ge.class, continuation);
    }
}
