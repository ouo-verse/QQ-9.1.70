package com.tencent.luggage.wxa.v3;

import com.tencent.luggage.wxa.tn.w;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public b f143055a;

    /* renamed from: b, reason: collision with root package name */
    public String f143056b;

    /* renamed from: c, reason: collision with root package name */
    public String f143057c;

    /* renamed from: d, reason: collision with root package name */
    public int f143058d;

    /* renamed from: e, reason: collision with root package name */
    public int f143059e;

    public com.tencent.luggage.wxa.xo.d a() {
        JSONObject jSONObject;
        com.tencent.luggage.wxa.xd.o a16 = this.f143055a.a(this.f143056b);
        try {
            jSONObject = new JSONObject(this.f143057c);
        } catch (JSONException e16) {
            w.b("Luggage.BridgedJsApiInvokeProtocol.Request", "makeBridgedParams, args(%s)->argsJson failed by %s", this.f143057c, e16);
            jSONObject = new JSONObject();
        }
        if (a16 instanceof h) {
            b bVar = this.f143055a;
            if (bVar instanceof c) {
                return ((h) a16).c(((c) bVar).a(), jSONObject, this.f143058d);
            }
        }
        return com.tencent.luggage.wxa.xo.h.a(h.a(this.f143055a, this.f143056b, jSONObject, this.f143058d).toString());
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "[appId:%s,api:%s,scene:%d,callbackId:%d]", this.f143055a.getAppId(), this.f143056b, Integer.valueOf(this.f143059e), Integer.valueOf(this.f143058d));
    }
}
