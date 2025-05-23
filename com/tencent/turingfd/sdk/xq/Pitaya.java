package com.tencent.turingfd.sdk.xq;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class Pitaya {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f383019a;

    /* renamed from: b, reason: collision with root package name */
    public final JSONArray f383020b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f383021c;

    /* renamed from: d, reason: collision with root package name */
    public long f383022d;

    /* renamed from: e, reason: collision with root package name */
    public long f383023e;

    /* renamed from: f, reason: collision with root package name */
    public long f383024f;

    /* renamed from: g, reason: collision with root package name */
    public final String f383025g;

    public Pitaya(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        this.f383019a = jSONObject;
        JSONArray jSONArray = new JSONArray();
        this.f383020b = jSONArray;
        this.f383021c = jSONObject;
        this.f383022d = 0L;
        this.f383023e = 0L;
        this.f383024f = 0L;
        this.f383025g = str;
        Log.i("TuringFdJava", "ft seq: " + str);
        try {
            jSONObject.put(WadlProxyConsts.CHANNEL, Nectarine.f382928a);
            jSONObject.put("platform", 2);
            jSONObject.put("seq", str);
            jSONObject.put("buildno", 89);
            jSONObject.put(LinkReportConstant$GlobalKey.EVENTS, jSONArray);
            jSONObject.put("uuid", Plum.a(Banana.a()));
        } catch (Throwable unused) {
        }
    }

    public final void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", str);
            jSONObject.put("content", String.format(Locale.SIMPLIFIED_CHINESE, "{\"t\":%d}", Long.valueOf(j3)));
            synchronized (this.f383021c) {
                this.f383020b.mo162put(jSONObject);
            }
        } catch (JSONException unused) {
        }
    }

    public final void a(String str, long j3, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Integer.valueOf(i3), str2);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", str);
            if (TextUtils.isEmpty(str2)) {
                jSONObject.put("content", String.format(Locale.SIMPLIFIED_CHINESE, "{\"t\":%d,\"dur\":%d,\"ret\":%d}", Long.valueOf(j3), Long.valueOf(currentTimeMillis), Integer.valueOf(i3)));
            } else {
                jSONObject.put("content", String.format(Locale.SIMPLIFIED_CHINESE, "{\"t\":%d,\"dur\":%d,\"ret\":%d,\"msg\":%s}", Long.valueOf(j3), Long.valueOf(currentTimeMillis), Integer.valueOf(i3), str2));
            }
            synchronized (this.f383021c) {
                this.f383020b.mo162put(jSONObject);
            }
        } catch (JSONException unused) {
        }
    }
}
