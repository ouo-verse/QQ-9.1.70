package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class k {
    public int B;
    public String D;

    /* renamed from: b, reason: collision with root package name */
    public int f37441b;

    /* renamed from: c, reason: collision with root package name */
    public String f37442c;

    /* renamed from: d, reason: collision with root package name */
    public String f37443d;

    /* renamed from: l, reason: collision with root package name */
    public String f37451l;

    /* renamed from: m, reason: collision with root package name */
    public String f37452m;

    /* renamed from: n, reason: collision with root package name */
    public String f37453n;

    /* renamed from: o, reason: collision with root package name */
    public String f37454o;

    /* renamed from: p, reason: collision with root package name */
    public String f37455p;

    /* renamed from: r, reason: collision with root package name */
    public String f37457r;

    /* renamed from: s, reason: collision with root package name */
    public String f37458s;

    /* renamed from: z, reason: collision with root package name */
    public String f37465z;

    /* renamed from: a, reason: collision with root package name */
    public String f37440a = "";

    /* renamed from: e, reason: collision with root package name */
    public String f37444e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f37445f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f37446g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f37447h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f37448i = "";

    /* renamed from: j, reason: collision with root package name */
    public String f37449j = "";

    /* renamed from: k, reason: collision with root package name */
    public String f37450k = "";

    /* renamed from: q, reason: collision with root package name */
    public String f37456q = "";

    /* renamed from: t, reason: collision with root package name */
    public int f37459t = n.STYLE_DEFAULT.ordinal();

    /* renamed from: u, reason: collision with root package name */
    public String f37460u = "";

    /* renamed from: v, reason: collision with root package name */
    public String f37461v = "";

    /* renamed from: w, reason: collision with root package name */
    public String f37462w = "";

    /* renamed from: x, reason: collision with root package name */
    public int f37463x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int f37464y = 0;
    public String A = "";
    public String C = "";
    public String E = "";
    public String F = "";

    public k(byte[] bArr, byte[] bArr2) {
        Charset charset = x.f37492a;
        this.f37457r = new String(bArr, charset);
        this.f37458s = new String(bArr2, charset);
    }

    public final JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put(VipFunCallConstants.KEY_GROUP, this.f37440a);
        jSONObject2.put("tag", this.A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.f37463x);
        jSONObject2.put("visibility", this.f37464y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.f37465z);
        return jSONObject2;
    }

    public final JSONObject b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cmd", this.f37446g);
        jSONObject2.put("content", this.f37447h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f37448i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.f37449j);
        jSONObject2.put("notifySummary", this.f37450k);
        jSONObject2.put("param", jSONObject);
        return jSONObject2;
    }

    public final void c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb5 = new StringBuilder();
            if (!TextUtils.isEmpty(string) && string.length() < 48) {
                int length = 48 - string.length();
                for (int i3 = 0; i3 < length; i3++) {
                    sb5.append("0");
                }
                sb5.append(string);
                this.f37443d = sb5.toString();
                return;
            }
            this.f37443d = string.substring(0, 48);
        }
    }

    public final boolean d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f37452m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f37442c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has(DKEngine.GlobalKey.APP_PACKAGE_NAME)) {
            this.f37451l = jSONObject.getString(DKEngine.GlobalKey.APP_PACKAGE_NAME);
            return true;
        }
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    public final boolean e(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("msgId")) {
            Object obj = jSONObject.get("msgId");
            if (obj instanceof String) {
                this.f37444e = (String) obj;
                return true;
            }
            if (!(obj instanceof Integer)) {
                return true;
            }
            this.f37444e = String.valueOf(((Integer) obj).intValue());
            return true;
        }
        HMSLog.i("PushSelfShowLog", "msgId == null");
        return false;
    }

    public final boolean f(JSONObject jSONObject) {
        HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has("style")) {
                this.f37459t = jSONObject2.getInt("style");
            }
            this.f37460u = jSONObject2.optString("bigTitle");
            this.f37461v = jSONObject2.optString("bigContent");
            this.E = jSONObject2.optString("icon");
            return true;
        } catch (JSONException e16) {
            HMSLog.i("PushSelfShowLog", e16.toString());
            return false;
        }
    }

    public final void g(JSONObject jSONObject) {
        this.f37440a = jSONObject.optString(VipFunCallConstants.KEY_GROUP);
        HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f37440a);
        this.f37463x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.d("PushSelfShowLog", "autoCancel: " + this.f37463x);
        this.f37464y = jSONObject.optInt("visibility", 0);
        this.f37465z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.A = jSONObject.optString("tag");
    }

    public final boolean h(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("param");
            if (jSONObject2.has("autoClear")) {
                this.f37441b = jSONObject2.getInt("autoClear");
            } else {
                this.f37441b = 0;
            }
            if (!"app".equals(this.f37446g) && !"cosa".equals(this.f37446g)) {
                if ("url".equals(this.f37446g)) {
                    k(jSONObject2);
                    return true;
                }
                if (!"rp".equals(this.f37446g)) {
                    return true;
                }
                j(jSONObject2);
                return true;
            }
            d(jSONObject2);
            return true;
        } catch (Exception e16) {
            HMSLog.e("PushSelfShowLog", "ParseParam error ", e16);
            return false;
        }
    }

    public final boolean i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f37446g = jSONObject2.getString("cmd");
            this.f37447h = jSONObject2.optString("content");
            this.f37448i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f37449j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f37450k = jSONObject2.optString("notifySummary");
            this.D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || f(jSONObject2)) && jSONObject2.has("param")) {
                return h(jSONObject2);
            }
        }
        return false;
    }

    public final boolean j(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(DKEngine.GlobalKey.APP_PACKAGE_NAME)) {
            this.f37451l = jSONObject.getString(DKEngine.GlobalKey.APP_PACKAGE_NAME);
        }
        if (jSONObject.has("rpt") && jSONObject.has("rpl")) {
            this.f37454o = jSONObject.getString("rpl");
            this.f37455p = jSONObject.getString("rpt");
            if (!jSONObject.has("rpct")) {
                return true;
            }
            this.f37456q = jSONObject.getString("rpct");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
        return false;
    }

    public final boolean k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("url")) {
            this.f37453n = jSONObject.getString("url");
            if (jSONObject.has(DKEngine.GlobalKey.APP_PACKAGE_NAME)) {
                this.f37451l = jSONObject.getString(DKEngine.GlobalKey.APP_PACKAGE_NAME);
            }
            if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
                return true;
            }
            this.f37454o = jSONObject.getString("rpl");
            this.f37455p = jSONObject.getString("rpt");
            if (!jSONObject.has("rpct")) {
                return true;
            }
            this.f37456q = jSONObject.getString("rpct");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "url is null");
        return false;
    }

    public String l() {
        return this.f37440a;
    }

    public String m() {
        return this.E;
    }

    public String n() {
        return this.f37442c;
    }

    public byte[] o() {
        try {
            return a(a(b(v()), r())).toString().getBytes(x.f37492a);
        } catch (JSONException e16) {
            HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", e16);
            return new byte[0];
        }
    }

    public String p() {
        HMSLog.d("PushSelfShowLog", "msgId =" + this.f37444e);
        return this.f37444e;
    }

    public String q() {
        return this.A;
    }

    public final JSONObject r() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.f37459t);
        jSONObject.put("bigTitle", this.f37460u);
        jSONObject.put("bigContent", this.f37461v);
        jSONObject.put("bigPic", this.f37462w);
        return jSONObject;
    }

    public int s() {
        return this.B;
    }

    public String t() {
        return this.f37450k;
    }

    public String u() {
        return this.f37449j;
    }

    public final JSONObject v() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.f37441b);
        jSONObject.put("url", this.f37453n);
        jSONObject.put("rpl", this.f37454o);
        jSONObject.put("rpt", this.f37455p);
        jSONObject.put("rpct", this.f37456q);
        jSONObject.put(DKEngine.GlobalKey.APP_PACKAGE_NAME, this.f37451l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f37452m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.f37442c);
        return jSONObject;
    }

    public int w() {
        return this.f37459t;
    }

    public String x() {
        return this.D;
    }

    public byte[] y() {
        return this.f37458s.getBytes(x.f37492a);
    }

    public boolean z() {
        try {
            if (TextUtils.isEmpty(this.f37457r)) {
                HMSLog.d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.f37457r);
            g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!e(jSONObject2)) {
                return false;
            }
            this.f37445f = jSONObject2.optString("dispPkgName");
            c(jSONObject2);
            this.B = jSONObject2.optInt("notifyId", -1);
            this.C = jSONObject2.optString("data");
            this.F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
            return i(jSONObject2);
        } catch (JSONException unused) {
            HMSLog.d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e16) {
            HMSLog.d("PushSelfShowLog", e16.toString());
            return false;
        }
    }

    public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f37445f);
        jSONObject3.put("msgId", this.f37444e);
        jSONObject3.put("ap", this.f37443d);
        jSONObject3.put("notifyId", this.B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, this.D);
        jSONObject3.put("data", this.C);
        return jSONObject3;
    }

    public String b() {
        return this.F;
    }

    public String d() {
        return this.f37451l;
    }

    public String g() {
        return this.f37461v;
    }

    public int e() {
        return this.f37463x;
    }

    public int f() {
        return this.f37441b;
    }

    public String j() {
        return this.f37447h;
    }

    public String c() {
        return this.f37443d;
    }

    public String k() {
        return this.f37445f;
    }

    public String h() {
        return this.f37460u;
    }

    public String i() {
        return this.f37446g;
    }

    public String a() {
        return this.f37452m;
    }

    public void a(int i3) {
        this.B = i3;
    }
}
