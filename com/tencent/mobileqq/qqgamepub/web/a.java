package com.tencent.mobileqq.qqgamepub.web;

import android.os.SystemClock;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f264795a;

    /* renamed from: b, reason: collision with root package name */
    public long f264796b;

    /* renamed from: c, reason: collision with root package name */
    public long f264797c;

    /* renamed from: d, reason: collision with root package name */
    public long f264798d;

    /* renamed from: e, reason: collision with root package name */
    public long f264799e;

    /* renamed from: f, reason: collision with root package name */
    public long f264800f;

    /* renamed from: g, reason: collision with root package name */
    public long f264801g;

    /* renamed from: h, reason: collision with root package name */
    public long f264802h;

    /* renamed from: i, reason: collision with root package name */
    private long f264803i;

    /* renamed from: j, reason: collision with root package name */
    public long f264804j;

    /* renamed from: k, reason: collision with root package name */
    public long f264805k;

    /* renamed from: l, reason: collision with root package name */
    public long f264806l;

    /* renamed from: m, reason: collision with root package name */
    public long f264807m;

    /* renamed from: n, reason: collision with root package name */
    public long f264808n;

    /* renamed from: o, reason: collision with root package name */
    public long f264809o;

    /* renamed from: p, reason: collision with root package name */
    public long f264810p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f264811q;

    /* renamed from: r, reason: collision with root package name */
    public long f264812r;

    /* renamed from: s, reason: collision with root package name */
    boolean f264813s;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f264813s = false;
        }
    }

    private String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GamePub H5 pref data=");
        stringBuffer.append("{");
        stringBuffer.append("isColdBoot=");
        stringBuffer.append(this.f264811q);
        stringBuffer.append("showWebViewTime=");
        stringBuffer.append(this.f264809o);
        stringBuffer.append("|");
        stringBuffer.append("initWebViewTime=");
        stringBuffer.append(this.f264805k);
        stringBuffer.append("|");
        stringBuffer.append("webViewLoadTime=");
        stringBuffer.append(this.f264810p);
        stringBuffer.append("|");
        stringBuffer.append("initUiTime=");
        stringBuffer.append(this.f264804j);
        stringBuffer.append("|");
        stringBuffer.append("loadUrlTime=");
        stringBuffer.append(this.f264806l);
        stringBuffer.append("|");
        stringBuffer.append("parsePageTime=");
        stringBuffer.append(this.f264807m);
        stringBuffer.append("|");
        stringBuffer.append("enterQQGamePubTime=");
        stringBuffer.append(this.f264808n);
        stringBuffer.append("|");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clickTime", this.f264796b);
            jSONObject.put("initPageTime", this.f264804j);
            jSONObject.put("showWebViewTime", this.f264805k + this.f264810p);
            jSONObject.put("initWebViewTime", this.f264805k);
            jSONObject.put("loadRequestStart", this.f264798d);
            jSONObject.put("finishLoadEnd", this.f264800f);
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!this.f264813s) {
            this.f264813s = true;
            long j3 = this.f264799e;
            long j16 = j3 - this.f264797c;
            this.f264806l = j16;
            long j17 = this.f264801g;
            long j18 = j17 - j3;
            this.f264807m = j18;
            this.f264809o = (j17 - this.f264802h) + this.f264808n;
            this.f264810p = j16 + j18;
            if (QLog.isColorLevel()) {
                QLog.d("GameWebPrefTrace", 1, a());
            }
            m();
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f264812r = SystemClock.elapsedRealtime() - this.f264802h;
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f264804j = SystemClock.elapsedRealtime() - this.f264802h;
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f264805k = SystemClock.elapsedRealtime() - this.f264803i;
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f264803i = SystemClock.elapsedRealtime();
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f264799e = SystemClock.elapsedRealtime();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f264797c = SystemClock.elapsedRealtime();
            this.f264798d = System.currentTimeMillis();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f264801g = SystemClock.elapsedRealtime();
            this.f264800f = System.currentTimeMillis();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f264802h = SystemClock.elapsedRealtime();
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.f264802h < 0) {
            return;
        }
        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f264802h) / 1000;
        if (elapsedRealtime > 0) {
            GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("769").setBussinessId("1").setPageId("160").setModuleType("76916").setOperId("206471").setExt(17, elapsedRealtime + "").report();
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        WadlReportBuilder r16 = GamePubAccountHelper.r("1");
        r16.setModuleType("76918").setOperId("206612").setExt(29, String.valueOf(this.f264811q)).setExt(30, String.valueOf(this.f264809o)).setExt(31, String.valueOf(this.f264805k)).setExt(32, String.valueOf(this.f264810p)).setExt(33, String.valueOf(this.f264804j)).setExt(34, String.valueOf(this.f264807m)).setExt(36, String.valueOf(this.f264808n)).setExt(37, String.valueOf(this.f264812r));
        r16.report();
    }

    public void n(long j3, long j16, boolean z16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), Long.valueOf(j17));
            return;
        }
        this.f264795a = j3;
        this.f264796b = j16;
        this.f264811q = z16;
        this.f264808n = j17;
    }
}
