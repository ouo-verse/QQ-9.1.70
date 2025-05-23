package com.tencent.mobileqq.ad.report;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f186909a;

    /* renamed from: b, reason: collision with root package name */
    public String f186910b;

    /* renamed from: c, reason: collision with root package name */
    public String f186911c;

    /* renamed from: d, reason: collision with root package name */
    public String f186912d;

    /* renamed from: e, reason: collision with root package name */
    public String f186913e;

    /* renamed from: f, reason: collision with root package name */
    public String f186914f;

    /* renamed from: g, reason: collision with root package name */
    public String f186915g;

    /* renamed from: h, reason: collision with root package name */
    public String f186916h;

    /* renamed from: i, reason: collision with root package name */
    public String f186917i;

    /* renamed from: j, reason: collision with root package name */
    public String f186918j;

    /* renamed from: k, reason: collision with root package name */
    public String f186919k;

    /* renamed from: l, reason: collision with root package name */
    public String f186920l;

    /* renamed from: m, reason: collision with root package name */
    public String f186921m;

    /* renamed from: n, reason: collision with root package name */
    public String f186922n;

    /* renamed from: o, reason: collision with root package name */
    public String f186923o;

    /* renamed from: p, reason: collision with root package name */
    public String f186924p;

    /* renamed from: q, reason: collision with root package name */
    public String f186925q;

    /* renamed from: r, reason: collision with root package name */
    public int f186926r;

    /* renamed from: s, reason: collision with root package name */
    public int f186927s;

    /* renamed from: t, reason: collision with root package name */
    public int f186928t;

    /* renamed from: u, reason: collision with root package name */
    public int f186929u;

    /* renamed from: v, reason: collision with root package name */
    public int f186930v;

    public a(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2);
            return;
        }
        this.f186909a = 0;
        this.f186910b = "2";
        this.f186911c = "";
        this.f186912d = "";
        this.f186913e = "";
        this.f186914f = "";
        this.f186915g = "";
        this.f186916h = "";
        this.f186917i = "";
        this.f186918j = "";
        this.f186919k = "";
        this.f186920l = "";
        this.f186921m = "";
        this.f186922n = "";
        this.f186923o = "";
        this.f186924p = "";
        this.f186925q = "";
        this.f186926r = 0;
        this.f186927s = 0;
        this.f186928t = 0;
        this.f186929u = 0;
        this.f186930v = 0;
        c();
        this.f186909a = i3;
        this.f186919k = str;
        this.f186917i = str2;
    }

    public static String b() {
        if (AppNetConnInfo.isWifiConn()) {
            return Global.TRACKING_WIFI;
        }
        if (AppNetConnInfo.isMobileConn()) {
            int mobileInfo = AppNetConnInfo.getMobileInfo();
            if (mobileInfo != 1) {
                if (mobileInfo != 2) {
                    if (mobileInfo != 3) {
                        if (mobileInfo == 4) {
                            return "5G";
                        }
                    } else {
                        return "4G";
                    }
                } else {
                    return "3G";
                }
            } else {
                return "2G";
            }
        }
        return "UN";
    }

    private void c() {
        this.f186911c = o.c();
        this.f186913e = b();
        this.f186914f = AppSetting.f99551k;
        this.f186915g = DeviceInfoMonitor.getModel();
        this.f186916h = String.valueOf(ah.K());
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accountType", this.f186909a);
            jSONObject.put("platform", this.f186910b);
            jSONObject.put("qimei36", this.f186911c);
            jSONObject.put("province", this.f186912d);
            jSONObject.put(JsonRuleKey.OPERATOR, this.f186913e);
            jSONObject.put("app_version", this.f186914f);
            jSONObject.put("model", this.f186915g);
            jSONObject.put("os_version", this.f186916h);
            jSONObject.put("eventCode", this.f186917i);
            jSONObject.put("operName", this.f186918j);
            jSONObject.put("module", this.f186919k);
            jSONObject.put("action", this.f186920l);
            jSONObject.put("ext1", this.f186921m);
            jSONObject.put("ext2", this.f186922n);
            jSONObject.put("ext3", this.f186923o);
            jSONObject.put("ext4", this.f186924p);
            jSONObject.put("ext5", this.f186925q);
            jSONObject.put("ext6", this.f186926r);
            jSONObject.put("ext7", this.f186927s);
            jSONObject.put("ext8", this.f186928t);
            jSONObject.put("ext9", this.f186929u);
            jSONObject.put("ext10", this.f186930v);
        } catch (JSONException e16) {
            QLog.e("SsoPushReportData", 1, "debugData error:", e16);
        }
        return jSONObject.toString();
    }
}
