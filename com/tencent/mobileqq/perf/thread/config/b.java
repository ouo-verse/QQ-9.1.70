package com.tencent.mobileqq.perf.thread.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public a f258122a;

    /* renamed from: b, reason: collision with root package name */
    public a f258123b;

    /* renamed from: c, reason: collision with root package name */
    public a f258124c;

    /* renamed from: d, reason: collision with root package name */
    public a f258125d;

    /* renamed from: e, reason: collision with root package name */
    public a f258126e;

    /* renamed from: f, reason: collision with root package name */
    public a f258127f;

    /* renamed from: g, reason: collision with root package name */
    public a f258128g;

    /* renamed from: h, reason: collision with root package name */
    public a f258129h;

    /* renamed from: i, reason: collision with root package name */
    public a f258130i;

    /* renamed from: j, reason: collision with root package name */
    public a f258131j;

    /* renamed from: k, reason: collision with root package name */
    public a f258132k;

    /* renamed from: l, reason: collision with root package name */
    public a f258133l;

    /* renamed from: m, reason: collision with root package name */
    public a f258134m;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a() {
        b bVar = new b();
        bVar.f258134m = a.a("serviceContentThreadCfg", 1000);
        bVar.f258128g = a.a("msfSenderThreadCfg", 1000);
        bVar.f258129h = a.a("msfReceiverThreadCfg", 1000);
        bVar.f258131j = a.a("msfBaseThreadCfg", 5000);
        bVar.f258132k = a.a("msfSubThreadCfg", 5000);
        bVar.f258133l = a.a("msfNetThreadCfg", 5000);
        return bVar;
    }

    public static b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        QLog.d("[TM]ThreadBlockConfig", 2, "[config] parse: invoked. ", " cfgJson: ", jSONObject.toString());
        try {
            if (jSONObject.has("subThreadCfg")) {
                bVar.f258122a = a.b("subThreadCfg", jSONObject.getJSONObject("subThreadCfg"));
            }
            if (jSONObject.has("qqCommonThreadCfg")) {
                bVar.f258123b = a.b("qqCommonThreadCfg", jSONObject.getJSONObject("qqCommonThreadCfg"));
            }
            if (jSONObject.has("fileThreadCfg")) {
                bVar.f258124c = a.b("fileThreadCfg", jSONObject.getJSONObject("fileThreadCfg"));
            }
            if (jSONObject.has("recentThreadCfg")) {
                bVar.f258125d = a.b("recentThreadCfg", jSONObject.getJSONObject("recentThreadCfg"));
            }
            if (jSONObject.has("msfMsgHighThreadCfg")) {
                bVar.f258126e = a.b("msfMsgHighThreadCfg", jSONObject.getJSONObject("msfMsgHighThreadCfg"));
            }
            if (jSONObject.has("msfMsgThreadCfg")) {
                bVar.f258127f = a.b("msfMsgThreadCfg", jSONObject.getJSONObject("msfMsgThreadCfg"));
            }
            if (jSONObject.has("msfSenderThreadCfg")) {
                bVar.f258128g = a.b("msfSenderThreadCfg", jSONObject.getJSONObject("msfSenderThreadCfg"));
            }
            if (jSONObject.has("msfReceiverThreadCfg")) {
                bVar.f258129h = a.b("msfReceiverThreadCfg", jSONObject.getJSONObject("msfReceiverThreadCfg"));
            }
            if (jSONObject.has("msfLightSenderThreadCfg")) {
                bVar.f258130i = a.b("msfLightSenderThreadCfg", jSONObject.getJSONObject("msfLightSenderThreadCfg"));
            }
            if (jSONObject.has("msfNetThreadCfg")) {
                bVar.f258133l = a.b("msfNetThreadCfg", jSONObject.getJSONObject("msfNetThreadCfg"));
            }
            if (jSONObject.has("serviceContentThreadCfg")) {
                bVar.f258134m = a.b("serviceContentThreadCfg", jSONObject.getJSONObject("serviceContentThreadCfg"));
            }
            if (jSONObject.has("msfBaseThreadCfg")) {
                bVar.f258131j = a.b("msfBaseThreadCfg", jSONObject.getJSONObject("msfBaseThreadCfg"));
            }
            if (jSONObject.has("msfSubThreadCfg")) {
                bVar.f258132k = a.b("msfSubThreadCfg", jSONObject.getJSONObject("msfSubThreadCfg"));
            }
        } catch (JSONException e16) {
            QLog.e("[TM]ThreadBlockConfig", 1, e16, new Object[0]);
        }
        return bVar;
    }
}
