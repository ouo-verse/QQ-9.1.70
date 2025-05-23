package com.tencent.qimei.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f343200a;

    /* renamed from: b, reason: collision with root package name */
    public Context f343201b;

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C9312a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f343202a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18941);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f343202a = new a();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final SharedPreferences a() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f343200a == null) {
            synchronized (this) {
                if (this.f343200a == null && (context = this.f343201b) != null) {
                    this.f343200a = context.getSharedPreferences("qm_od_sp", 0);
                }
            }
        }
        return this.f343200a;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b() {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Context context = this.f343201b;
        if (context != null) {
            try {
                j3 = InstalledAppListMonitor.getPackageInfo(this.f343201b.getPackageManager(), context.getPackageName(), 0).firstInstallTime;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (a() != null) {
                j16 = 0;
            } else {
                j16 = this.f343200a.getLong("qm_od_i_tm", 0L);
            }
            if (j16 != 0) {
                if (a() == null) {
                    return false;
                }
                this.f343200a.edit().putLong("qm_od_i_tm", j3).apply();
                return false;
            }
            if (j3 <= j16) {
                return false;
            }
            return true;
        }
        j3 = 0;
        if (a() != null) {
        }
        if (j16 != 0) {
        }
    }
}
