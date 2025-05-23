package com.tencent.ams.xsad.rewarded.report;

import android.text.TextUtils;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.ams.xsad.rewarded.utils.b;
import com.tencent.ams.xsad.rewarded.utils.c;
import com.tencent.ams.xsad.rewarded.utils.g;
import com.tencent.ams.xsad.rewarded.utils.h;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qzone.remote.ServiceConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RewardedTaskReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f71843a;

    /* renamed from: b, reason: collision with root package name */
    private String f71844b;

    /* renamed from: c, reason: collision with root package name */
    private String f71845c;

    /* renamed from: d, reason: collision with root package name */
    private String f71846d;

    /* renamed from: e, reason: collision with root package name */
    private String f71847e;

    /* renamed from: f, reason: collision with root package name */
    private int f71848f;

    /* renamed from: g, reason: collision with root package name */
    private int f71849g;

    /* renamed from: h, reason: collision with root package name */
    private int f71850h;

    /* renamed from: i, reason: collision with root package name */
    private int f71851i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class ReportTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final int f71852d;

        public ReportTask(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedTaskReporter.this, i3);
            } else {
                this.f71852d = i3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                z16 = b.a(RewardedTaskReporter.this.f71846d, Method.POST, RewardedTaskReporter.this.d(this.f71852d), true);
            } catch (Throwable unused) {
                z16 = false;
            }
            c.a("RewardedTaskReporter", "report success: " + z16);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface TaskStatus {
        public static final int FINISH = 3;
        public static final int RUNNING = 2;
        public static final int START = 1;
    }

    public RewardedTaskReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String c(String str, String str2, String str3, long j3) {
        String lowerCase = g.g(str + str2 + str3 + j3).toLowerCase();
        c.c("RewardedTaskReporter", String.format(Locale.getDefault(), "buildAppSecret - appKey:%s, userId:%s, traceId:%s, reportTime:%d, secret:%s", str, str2, str3, Long.valueOf(j3), lowerCase));
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(int i3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("app_id", this.f71843a);
        jSONObject2.put("scene_id", this.f71848f);
        jSONObject.put("app", jSONObject2);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("app_secret", c(this.f71844b, this.f71845c, this.f71847e, currentTimeMillis));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("value_type", 1);
        jSONObject3.put("str_id", this.f71845c);
        jSONObject.put(QCircleAlphaUserReporter.KEY_USER, jSONObject3);
        jSONObject.put(ServiceConst.PARA_SESSION_ID, this.f71847e);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("action_type", 1);
        jSONObject4.put(CGNonAgeReport.EVENT_TYPE, i3);
        jSONObject4.put("report_time", currentTimeMillis);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("duration", this.f71850h);
        jSONObject4.put("ext", jSONObject5);
        jSONObject.put("action", jSONObject4);
        return jSONObject.toString();
    }

    private boolean e() {
        if (this.f71843a != 0 && !TextUtils.isEmpty(this.f71844b) && !TextUtils.isEmpty(this.f71845c) && !TextUtils.isEmpty(this.f71846d) && !TextUtils.isEmpty(this.f71847e)) {
            return true;
        }
        return false;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int i3 = this.f71849g;
        if (i3 <= 0) {
            return 5;
        }
        return i3;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        c.c("RewardedTaskReporter", "reportTaskFinish");
        if (!e()) {
            c.e("RewardedTaskReporter", "reportTaskFinish failed: report params invalid");
        } else {
            h.a().b().execute(new ReportTask(3));
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        if (i3 - this.f71851i >= f() * 1000) {
            if (!e()) {
                c.e("RewardedTaskReporter", "reportTaskRunning failed: report params invalid");
                return;
            }
            h.a().b().execute(new ReportTask(2));
            this.f71851i = i3;
            c.c("RewardedTaskReporter", "reportTaskRunning do running report, position: " + i3);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        c.c("RewardedTaskReporter", "reportTaskStart");
        if (!e()) {
            c.e("RewardedTaskReporter", "reportTaskStart failed: report params invalid");
        } else {
            h.a().b().execute(new ReportTask(1));
        }
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f71843a = i3;
        }
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f71844b = str;
        }
    }

    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f71850h = i3;
        }
    }

    public void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f71849g = i3;
        }
    }

    public void n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f71846d = str;
        }
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f71848f = i3;
        }
    }

    public void p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f71847e = str;
        }
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f71845c = str;
        }
    }
}
