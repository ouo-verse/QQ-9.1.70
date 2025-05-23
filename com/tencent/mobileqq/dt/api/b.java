package com.tencent.mobileqq.dt.api;

import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f203621a;

    /* renamed from: b, reason: collision with root package name */
    private String f203622b;

    /* renamed from: c, reason: collision with root package name */
    private int f203623c;

    /* renamed from: d, reason: collision with root package name */
    private String f203624d;

    /* renamed from: e, reason: collision with root package name */
    private int f203625e;

    /* renamed from: f, reason: collision with root package name */
    private String f203626f;

    /* renamed from: g, reason: collision with root package name */
    private String f203627g;

    /* renamed from: h, reason: collision with root package name */
    private String f203628h;

    /* renamed from: i, reason: collision with root package name */
    private String f203629i;

    /* renamed from: j, reason: collision with root package name */
    private String f203630j;

    /* renamed from: k, reason: collision with root package name */
    private String f203631k;

    /* renamed from: l, reason: collision with root package name */
    private String f203632l;

    /* renamed from: m, reason: collision with root package name */
    private String f203633m;

    /* renamed from: n, reason: collision with root package name */
    private String f203634n;

    /* renamed from: o, reason: collision with root package name */
    private String f203635o;

    /* renamed from: p, reason: collision with root package name */
    private String f203636p;

    /* renamed from: q, reason: collision with root package name */
    private Bundle f203637q;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f203624d = "";
        this.f203626f = "";
        this.f203627g = "";
        this.f203628h = "";
        this.f203629i = "";
        this.f203630j = "";
        this.f203631k = "";
        this.f203632l = "";
        this.f203633m = "";
        this.f203634n = "";
        this.f203635o = "";
        this.f203636p = "";
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f203621a;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f203624d;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f203629i;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f203622b;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f203623c;
    }

    public Bundle f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (Bundle) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.f203637q;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("appid=");
        sb5.append(this.f203621a);
        sb5.append("&eviluin=");
        sb5.append(this.f203622b);
        sb5.append("&eviluin_type=");
        sb5.append(this.f203623c);
        sb5.append("&buddyflag=");
        sb5.append(this.f203624d);
        sb5.append("&is_anonymous=");
        sb5.append(this.f203625e);
        sb5.append("&groupid=");
        sb5.append(this.f203626f);
        sb5.append("&contentid=");
        sb5.append(this.f203627g);
        sb5.append("&user_input_param=");
        sb5.append(this.f203628h);
        sb5.append("&chatuin=");
        sb5.append(this.f203629i);
        sb5.append("&groupcode=");
        sb5.append(this.f203630j);
        sb5.append("&chattype=");
        sb5.append(this.f203631k);
        sb5.append("&topicid=");
        sb5.append(this.f203632l);
        sb5.append("&uinname=");
        sb5.append(this.f203633m);
        sb5.append("&msgs=");
        sb5.append(this.f203634n);
        sb5.append("&msg_count=");
        sb5.append(this.f203635o);
        sb5.append("&srv_para=");
        sb5.append(this.f203636p);
        Bundle bundle = this.f203637q;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                sb5.append(ContainerUtils.FIELD_DELIMITER + str + ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(this.f203637q.get(str));
            }
        }
        return sb5.toString();
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.f203621a);
            jSONObject.put("eviluin", this.f203622b);
            jSONObject.put("eviluin_type", String.valueOf(this.f203623c));
            jSONObject.put("buddyflag", this.f203624d);
            jSONObject.put("is_anonymous", String.valueOf(this.f203625e));
            jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.f203626f);
            jSONObject.put(TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID, this.f203627g);
            jSONObject.put("user_input_param", this.f203628h);
            jSONObject.put("chatuin", this.f203629i);
            jSONObject.put("groupcode", this.f203630j);
            jSONObject.put("chattype", this.f203631k);
            jSONObject.put("topicid", this.f203632l);
            jSONObject.put("uinname", this.f203633m);
            jSONObject.put("msgs", this.f203634n);
            jSONObject.put("msg_count", this.f203635o);
            jSONObject.put("srv_para", this.f203636p);
            Bundle bundle = this.f203637q;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    jSONObject.put(str, String.valueOf(this.f203637q.get(str)));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f203621a = str;
        }
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f203624d = str;
        }
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.f203631k = str;
        }
    }

    public void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.f203629i = str;
        }
    }

    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.f203627g = str;
        }
    }

    public void n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f203622b = str;
        }
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f203623c = i3;
        }
    }

    public void p(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) bundle);
        } else {
            this.f203637q = bundle;
        }
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.f203630j = str;
        }
    }

    public void r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.f203626f = str;
        }
    }

    public void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f203625e = i3;
        }
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        } else {
            this.f203635o = str;
        }
    }

    public void u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
        } else {
            this.f203634n = str;
        }
    }

    public void v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        } else {
            this.f203636p = str;
        }
    }

    public void w(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        } else {
            this.f203633m = str;
        }
    }

    public void x(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.f203628h = str;
        }
    }
}
