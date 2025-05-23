package com.tencent.mobileqq.tofumsg;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j implements IConfigData {
    static IPatchRedirector $redirector_;
    public static int C;
    public static int D;
    public static long E;
    public static long F;

    /* renamed from: d, reason: collision with root package name */
    public int f293259d;

    /* renamed from: e, reason: collision with root package name */
    public int f293260e;

    /* renamed from: f, reason: collision with root package name */
    public long f293261f;

    /* renamed from: h, reason: collision with root package name */
    public long f293262h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f293263i;

    /* renamed from: m, reason: collision with root package name */
    public String f293264m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75915);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        C = 1;
        D = 1;
        E = 86400000L;
        F = 86400000L;
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f293259d = C;
        this.f293260e = D;
        this.f293261f = E;
        this.f293262h = F;
        this.f293263i = true;
        this.f293264m = "";
    }

    @NonNull
    public static j b(String str) {
        QLog.d("TofuNew.TofuManagerConfig", 1, "parse config = ", str);
        if (TextUtils.isEmpty(str)) {
            return new j();
        }
        j jVar = new j();
        jVar.f293264m = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            jVar.f293259d = jSONObject.optInt("show_times_of_same_bus_one_day", C);
            jVar.f293260e = jSONObject.optInt("show_times_of_one_aio_one_day", D);
            jVar.f293261f = jSONObject.optLong("show_time", E);
            jVar.f293262h = jSONObject.optLong("interval_of_show_times", F);
            jVar.f293263i = jSONObject.optBoolean("need_limit_req_freq", true);
        } catch (JSONException e16) {
            QLog.e("TofuNew.TofuManagerConfig", 1, "parse: " + e16);
        }
        return jVar;
    }

    public String a() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("show_times_of_one_aio_one_bus_one_day", this.f293259d);
            jSONObject.put("show_times_of_one_aio_one_day", this.f293260e);
            jSONObject.put("show_time", this.f293261f);
            jSONObject.put("interval_of_show_times", this.f293262h);
            jSONObject.put("need_limit_req_freq", this.f293263i);
            jSONObject.put("useNew", a.c());
            str = jSONObject.toString();
        } catch (Exception e16) {
            if (com.tencent.mobileqq.unitedconfig_android.a.g()) {
                QLog.e("TofuNew.TofuManagerConfig", 1, "getConfigString:" + e16);
                str = "";
            } else {
                throw new RuntimeException(e16);
            }
        }
        QLog.i("TofuNew.TofuManagerConfig", 1, "getConfigString: " + str);
        return str;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TofuConfigNew{showTimesOfOneAIOOneBusOneDay=" + this.f293259d + ", showTimesOfOneAIOOneDay=" + this.f293260e + ", showTime=" + this.f293261f + ", intervalOfShowTimes=" + this.f293262h + ", needLimitReqFreq=" + this.f293263i + '}';
    }
}
