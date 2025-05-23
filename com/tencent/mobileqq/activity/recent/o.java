package com.tencent.mobileqq.activity.recent;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.Calendar;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static o f185707h;

    /* renamed from: i, reason: collision with root package name */
    private static final Object f185708i;

    /* renamed from: a, reason: collision with root package name */
    private long f185709a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, HashMap<String, String>> f185710b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, HashMap<String, String>> f185711c;

    /* renamed from: d, reason: collision with root package name */
    private String f185712d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Boolean> f185713e;

    /* renamed from: f, reason: collision with root package name */
    private StringBuffer f185714f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.mobileqq.activity.photopreview.a f185715g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37605);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f185708i = new Object();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    o() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f185712d = TuxDateStringUtils.TUX_COMMON_DATE_FORMAT;
        this.f185713e = new HashMap<>();
        this.f185714f = new StringBuffer(25);
        BaseApplication context = BaseApplication.getContext();
        this.f185710b = new HashMap<>();
        this.f185711c = new HashMap<>();
        f();
        if (context != null) {
            try {
                str = DeviceInfoMonitor.getStringSystem(context.getContentResolver(), "date_format");
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(str)) {
                this.f185712d = str;
            } else {
                this.f185712d = TuxDateStringUtils.TUX_COMMON_DATE_FORMAT;
            }
            this.f185715g = new com.tencent.mobileqq.activity.photopreview.a(Looper.getMainLooper());
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
        }
        this.f185715g = new com.tencent.mobileqq.activity.photopreview.a(Looper.getMainLooper());
    }

    private boolean a() {
        if (System.currentTimeMillis() >= this.f185709a) {
            f();
            synchronized (f185708i) {
                this.f185710b.clear();
                this.f185711c.clear();
            }
            return false;
        }
        return true;
    }

    public static o c() {
        if (f185707h == null) {
            synchronized (o.class) {
                if (f185707h == null) {
                    f185707h = new o();
                }
            }
        }
        return f185707h;
    }

    private void f() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        this.f185709a = calendar.getTimeInMillis();
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f185712d;
    }

    public String d(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
        }
        return e(str, j3, false);
    }

    public String e(String str, long j3, boolean z16) {
        boolean z17;
        HashMap<String, String> hashMap;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Boolean.valueOf(z16));
        }
        if (z16 && ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("yesterday_time_detail", true)) {
            z17 = true;
        } else {
            z17 = false;
        }
        synchronized (f185708i) {
            if (z17) {
                hashMap = this.f185711c.get(str);
            } else {
                hashMap = this.f185710b.get(str);
            }
            if (hashMap != null && a()) {
                str2 = hashMap.get(String.valueOf(j3));
                if (str2 == null) {
                    hashMap.clear();
                }
            }
            hashMap = new HashMap<>();
            if (z17) {
                this.f185711c.put(str, hashMap);
            } else {
                this.f185710b.put(str, hashMap);
            }
            str2 = null;
        }
        if (str2 == null) {
            synchronized (this.f185714f) {
                str2 = com.tencent.mobileqq.imcore.proxy.basic.c.a(this.f185714f, j3 * 1000, true, this.f185712d, z17);
                if (QLog.isDevelopLevel()) {
                    QLog.i("Q.recent", 4, "getMsgDisplayTime, " + this.f185714f.toString() + "," + str2);
                }
            }
            hashMap.put(String.valueOf(j3), str2);
        }
        return str2;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.photopreview.a aVar = this.f185715g;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.photopreview.a aVar = this.f185715g;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.photopreview.a aVar = this.f185715g;
        if (aVar != null) {
            aVar.j();
        }
    }
}
