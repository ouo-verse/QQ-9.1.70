package com.tencent.luggage.wxa.v3;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public String f143096a;

    /* renamed from: b, reason: collision with root package name */
    public String f143097b;

    /* renamed from: c, reason: collision with root package name */
    public int f143098c;

    /* renamed from: d, reason: collision with root package name */
    public String f143099d;

    /* renamed from: e, reason: collision with root package name */
    public int f143100e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f143101f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f143102g;

    /* renamed from: h, reason: collision with root package name */
    public String f143103h;

    /* renamed from: i, reason: collision with root package name */
    public String f143104i;

    /* renamed from: j, reason: collision with root package name */
    public String f143105j;

    /* renamed from: k, reason: collision with root package name */
    public String f143106k;

    /* renamed from: l, reason: collision with root package name */
    public String f143107l;

    /* renamed from: m, reason: collision with root package name */
    public JSONObject f143108m;

    /* renamed from: n, reason: collision with root package name */
    public String f143109n;

    /* renamed from: o, reason: collision with root package name */
    public String f143110o;

    /* renamed from: p, reason: collision with root package name */
    public int f143111p;

    /* renamed from: q, reason: collision with root package name */
    public String f143112q;

    /* renamed from: r, reason: collision with root package name */
    public String f143113r;

    /* renamed from: s, reason: collision with root package name */
    public String f143114s;

    public i a(String str) {
        this.f143097b = str;
        return this;
    }

    public i b(String str) {
        this.f143099d = str;
        return this;
    }

    public i c(int i3) {
        this.f143100e = i3;
        return this;
    }

    public i d(String str) {
        this.f143103h = str;
        return this;
    }

    public i e(String str) {
        this.f143107l = str;
        return this;
    }

    public i f(String str) {
        this.f143096a = str;
        return this;
    }

    public i g(String str) {
        this.f143112q = str;
        return this;
    }

    public i h(String str) {
        this.f143113r = str;
        return this;
    }

    public i i(String str) {
        this.f143110o = str;
        return this;
    }

    public i j(String str) {
        this.f143109n = str;
        return this;
    }

    public i k(String str) {
        this.f143104i = str;
        return this;
    }

    public i l(String str) {
        this.f143106k = str;
        return this;
    }

    public i m(String str) {
        this.f143105j = str;
        return this;
    }

    public String toString() {
        long j3;
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("runtimeAppid");
            jSONStringer.value(this.f143104i);
            jSONStringer.key("runtimeTicket");
            jSONStringer.value(this.f143105j);
            jSONStringer.key("runtimeSessionId");
            jSONStringer.value(this.f143106k);
            jSONStringer.key("pathType");
            jSONStringer.value(this.f143100e);
            jSONStringer.key("invokeData");
            JSONStringer jSONStringer2 = new JSONStringer();
            jSONStringer2.object();
            jSONStringer2.key("name");
            jSONStringer2.value(this.f143096a);
            jSONStringer2.key("args");
            jSONStringer2.value(this.f143097b);
            jSONStringer2.key("isBridgedJsApi");
            jSONStringer2.value(this.f143101f);
            jSONStringer2.key("jsapiType");
            jSONStringer2.value(this.f143103h);
            jSONStringer2.key("isGame");
            jSONStringer2.value(this.f143102g);
            if (this.f143108m != null) {
                jSONStringer2.key("runtimeTransferAction");
                jSONStringer2.value(this.f143108m);
            }
            JSONStringer jSONStringer3 = new JSONStringer();
            jSONStringer3.object();
            jSONStringer3.key("callbackId");
            jSONStringer3.value(this.f143098c);
            jSONStringer3.key("callbackActivity");
            jSONStringer3.value(this.f143099d);
            jSONStringer3.key("isBridgedJsApi");
            if (this.f143101f) {
                j3 = 1;
            } else {
                j3 = 0;
            }
            jSONStringer3.value(j3);
            jSONStringer3.endObject();
            jSONStringer2.key("transitiveData");
            jSONStringer2.value(jSONStringer3.toString());
            jSONStringer2.key("miniprogramAppID");
            jSONStringer2.value(this.f143107l);
            jSONStringer2.key("sessionId");
            jSONStringer2.value(this.f143109n);
            jSONStringer2.key("instanceId");
            jSONStringer2.value(this.f143110o);
            jSONStringer2.key("debugMode");
            jSONStringer2.value(this.f143111p);
            if (!TextUtils.isEmpty(this.f143112q)) {
                jSONStringer2.key("path");
                jSONStringer2.value(this.f143112q);
            }
            if (!TextUtils.isEmpty(this.f143113r)) {
                jSONStringer2.key("title");
                jSONStringer2.value(this.f143113r);
            }
            if (!TextUtils.isEmpty(this.f143114s)) {
                jSONStringer2.key("currentH5Url");
                jSONStringer2.value(this.f143114s);
            }
            jSONStringer2.endObject();
            jSONStringer.value(jSONStringer2.toString());
            jSONStringer.endObject();
        } catch (JSONException e16) {
            w.b("Luggage.OpenSDKBridgedJsApiParams", "JSONException:%s", e16.getMessage());
        }
        w.g("Luggage.OpenSDKBridgedJsApiParams", "req:%s", jSONStringer.toString());
        return jSONStringer.toString();
    }

    public i a(int i3) {
        this.f143098c = i3;
        return this;
    }

    public i b(boolean z16) {
        this.f143102g = z16;
        return this;
    }

    public i c(String str) {
        this.f143114s = str;
        return this;
    }

    public i a(boolean z16) {
        this.f143101f = z16;
        return this;
    }

    public i b(int i3) {
        this.f143111p = i3;
        return this;
    }
}
