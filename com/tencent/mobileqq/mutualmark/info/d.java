package com.tencent.mobileqq.mutualmark.info;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f252109a;

    /* renamed from: b, reason: collision with root package name */
    public long f252110b;

    /* renamed from: c, reason: collision with root package name */
    public float f252111c;

    /* renamed from: d, reason: collision with root package name */
    public long f252112d;

    /* renamed from: e, reason: collision with root package name */
    public long f252113e;

    /* renamed from: f, reason: collision with root package name */
    public long f252114f;

    /* renamed from: g, reason: collision with root package name */
    public long f252115g;

    /* renamed from: h, reason: collision with root package name */
    public long f252116h;

    /* renamed from: i, reason: collision with root package name */
    public long f252117i;

    /* renamed from: j, reason: collision with root package name */
    public String f252118j;

    /* renamed from: k, reason: collision with root package name */
    public String f252119k;

    /* renamed from: l, reason: collision with root package name */
    public String f252120l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f252121m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f252122n;

    /* renamed from: o, reason: collision with root package name */
    public long f252123o;

    /* renamed from: p, reason: collision with root package name */
    public String f252124p;

    /* renamed from: q, reason: collision with root package name */
    public int f252125q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f252126r;

    /* renamed from: s, reason: collision with root package name */
    public String f252127s;

    /* renamed from: t, reason: collision with root package name */
    public int f252128t;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f252118j = "";
        this.f252119k = "";
        this.f252120l = "";
        this.f252121m = false;
        this.f252124p = "";
    }

    public static ConcurrentHashMap<Long, d> c(String str) {
        if (QLog.isColorLevel() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("mutualmark_log_switch", false)) {
            QLog.i("MutualMarkInfo", 1, "parseFrom json_str:" + str);
        }
        ConcurrentHashMap<Long, d> concurrentHashMap = new ConcurrentHashMap<>();
        try {
        } catch (JSONException e16) {
            QLog.e("MutualMarkInfo", 1, "toJsonString error:" + e16.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return concurrentHashMap;
        }
        JSONArray jSONArray = new JSONArray(str);
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            d d16 = d(jSONArray.getJSONObject(i3));
            if (d16 != null) {
                concurrentHashMap.put(Long.valueOf(d16.f252109a), d16);
            }
        }
        return concurrentHashMap;
    }

    private static d d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.f252109a = jSONObject.optLong("type");
        dVar.f252110b = jSONObject.optLong("level");
        dVar.f252111c = (float) jSONObject.optDouble("count", 0.0d);
        dVar.f252112d = jSONObject.optLong("continue_days");
        dVar.f252113e = jSONObject.optLong("last_action_time");
        dVar.f252114f = jSONObject.optLong("last_change_time");
        dVar.f252115g = jSONObject.optLong("icon_status");
        dVar.f252116h = jSONObject.optLong("icon_status_end_time");
        dVar.f252117i = jSONObject.optLong("sub_level");
        dVar.f252122n = jSONObject.optBoolean("hasRemindInContact");
        dVar.f252118j = jSONObject.optString("icon_static_url");
        dVar.f252119k = jSONObject.optString("icon_dynamic_url");
        dVar.f252120l = jSONObject.optString("icon_name");
        dVar.f252121m = jSONObject.optBoolean("user_close_flag");
        dVar.f252124p = jSONObject.optString("icon_url");
        dVar.f252125q = jSONObject.optInt("mark_version");
        dVar.f252126r = jSONObject.optBoolean("is_wearing");
        dVar.f252128t = jSONObject.optInt("order_num");
        dVar.f252127s = jSONObject.optString("icon_format");
        return dVar;
    }

    public static String f(ConcurrentHashMap<Long, d> concurrentHashMap) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<Long, d> entry : concurrentHashMap.entrySet()) {
            if (entry.getValue() != null) {
                jSONArray.mo162put(entry.getValue().e());
            }
        }
        if (jSONArray.length() > 0) {
            return jSONArray.toString();
        }
        return "";
    }

    public boolean a(x.c cVar, long j3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, cVar, Long.valueOf(j3))).booleanValue();
        }
        x.c.b bVar = cVar.f180261b;
        if (bVar == null) {
            return false;
        }
        if (j3 == 11002 || j3 == 11001) {
            long j16 = this.f252113e;
            if (j16 > 0 && bVar.f180267c < j16) {
                QLog.i("MutualMarkInfo", 1, "ignore mergeFrom now.last_action_time:" + cVar.f180261b.f180267c + " last_action_time:" + this.f252113e);
                return false;
            }
        }
        if (j3 == 11003) {
            this.f252109a = cVar.f180260a;
            this.f252125q = bVar.f180284t;
            this.f252126r = bVar.f180285u;
            QLog.i("MutualMarkInfo", 1, "[MutualMarkInfo_0x7cPush]type=" + cVar.f180260a + ", markVersion=" + this.f252125q + ", isWearing=" + this.f252126r);
            return true;
        }
        long j17 = cVar.f180260a;
        this.f252109a = j17;
        long j18 = bVar.f180266b;
        this.f252110b = j18;
        long j19 = bVar.f180267c;
        if (j19 > 0) {
            this.f252113e = j19;
        }
        long j26 = bVar.f180268d;
        if (j26 > 0) {
            this.f252114f = j26;
        }
        this.f252112d = bVar.f180269e;
        long j27 = bVar.f180273i;
        this.f252115g = j27;
        if (j3 == 11002) {
            this.f252116h = bVar.f180274j;
        }
        if (j27 != 2) {
            this.f252116h = 0L;
        }
        this.f252117i = bVar.f180275k;
        String str = bVar.f180277m;
        this.f252118j = str;
        this.f252119k = bVar.f180278n;
        this.f252120l = bVar.f180281q;
        this.f252121m = bVar.f180282r;
        if (j17 == 17 && j18 > 0 && TextUtils.isEmpty(str)) {
            z16 = true;
            QLog.i("MutualMarkInfo", 1, "mergeFrom push info resource invalid: " + this);
        } else {
            z16 = true;
        }
        return z16;
    }

    public boolean b(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) eVar)).booleanValue();
        }
        long j3 = eVar.f252129a;
        this.f252109a = j3;
        long j16 = eVar.f252130b;
        this.f252110b = j16;
        this.f252111c = eVar.f252131c;
        this.f252112d = eVar.f252132d;
        this.f252113e = eVar.f252133e;
        this.f252115g = eVar.f252135g;
        this.f252116h = eVar.f252136h;
        this.f252117i = eVar.f252137i;
        String str = eVar.f252140l;
        this.f252118j = str;
        this.f252119k = eVar.f252141m;
        this.f252120l = eVar.f252144p;
        this.f252121m = eVar.f252145q;
        if (j3 == 17 && j16 > 0 && TextUtils.isEmpty(str)) {
            QLog.i("MutualMarkInfo", 1, "mergeFrom pull info resource invalid: " + this);
        }
        this.f252124p = eVar.f252146r;
        this.f252125q = eVar.f252147s;
        this.f252126r = eVar.f252148t;
        this.f252127s = eVar.f252149u;
        this.f252128t = eVar.f252150v;
        return true;
    }

    public JSONObject e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f252109a);
            jSONObject.put("level", this.f252110b);
            jSONObject.put("count", this.f252111c);
            jSONObject.put("continue_days", this.f252112d);
            jSONObject.put("last_action_time", this.f252113e);
            jSONObject.put("last_change_time", this.f252114f);
            jSONObject.put("icon_status", this.f252115g);
            jSONObject.put("icon_status_end_time", this.f252116h);
            jSONObject.put("sub_level", this.f252117i);
            jSONObject.put("hasRemindInContact", this.f252122n);
            jSONObject.put("icon_static_url", this.f252118j);
            jSONObject.put("icon_dynamic_url", this.f252119k);
            jSONObject.put("icon_name", this.f252120l);
            jSONObject.put("user_close_flag", this.f252121m);
            jSONObject.put("icon_url", this.f252124p);
            jSONObject.put("mark_version", this.f252125q);
            jSONObject.put("is_wearing", this.f252126r);
            jSONObject.put("order_num", this.f252128t);
            jSONObject.put("icon_format", this.f252127s);
        } catch (JSONException e16) {
            QLog.e("MutualMarkInfo", 1, "toJsonForStore error:" + e16.getMessage());
        }
        return jSONObject;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MutualMarkInfo{type=" + this.f252109a + ", level=" + this.f252110b + ", count=" + this.f252111c + ", continue_days=" + this.f252112d + ", last_action_time=" + this.f252113e + ", last_change_time=" + this.f252114f + ", icon_status=" + this.f252115g + ", icon_status_end_time=" + this.f252116h + ", sub_level=" + this.f252117i + ", hasRemindInContact=" + this.f252122n + ", remindAnimStartTime=" + this.f252123o + ", icon_static_url='" + this.f252118j + "', icon_dynamic_url='" + this.f252119k + "', icon_name='" + this.f252120l + "', user_close_flag=" + this.f252121m + ", icon_url=" + this.f252124p + ", mark_version=" + this.f252125q + ", is_wearing=" + this.f252126r + ", order_num=" + this.f252128t + "}";
    }
}
