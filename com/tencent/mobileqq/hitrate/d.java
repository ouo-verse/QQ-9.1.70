package com.tencent.mobileqq.hitrate;

import android.app.ActivityManager;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f236848a;

    /* renamed from: b, reason: collision with root package name */
    public String f236849b;

    /* renamed from: c, reason: collision with root package name */
    public String f236850c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f236851d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f236852e;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        this.f236848a = str;
        this.f236849b = str2;
        this.f236850c = str3;
        f();
    }

    public static boolean e(String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (!TextUtils.isEmpty(str) && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) != null && runningAppProcesses.size() > 0) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().processName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f236851d) {
            b();
        }
        a.a(this);
        this.f236851d = true;
        if (!(this instanceof c)) {
            a.e(this.f236850c);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!this.f236851d) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(peekAppRuntime.getAccount(), this.f236849b, this.f236852e, 0L, 0L, new HashMap<>(), null);
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f236850c + this.f236848a;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            if (!this.f236851d) {
                return;
            }
            this.f236852e = true;
            if (!(this instanceof c)) {
                a.d(this.f236850c);
            }
        }
    }

    void f() {
        this.f236851d = false;
        this.f236852e = false;
    }

    public d(String str, String str2) {
        this("default", str, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
    }
}
