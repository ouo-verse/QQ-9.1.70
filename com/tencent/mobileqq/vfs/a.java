package com.tencent.mobileqq.vfs;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.CancellationSignalCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f312442a;

    /* renamed from: b, reason: collision with root package name */
    private static CopyOnWriteArrayList<Map<String, Object>> f312443b;

    /* renamed from: c, reason: collision with root package name */
    private static CopyOnWriteArrayList<Throwable> f312444c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vfs.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C8952a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f312445a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77199);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f312445a = new a();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77200);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f312442a = false;
        f312443b = new CopyOnWriteArrayList<>();
        f312444c = new CopyOnWriteArrayList<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a() {
        return C8952a.f312445a;
    }

    private String b() {
        AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return peekAppRuntime.getAccount();
    }

    private void c(Throwable th5) {
        com.tencent.qqperf.monitor.crash.catchedexception.a.b(th5);
    }

    @Override // com.tencent.mm.vfs.StatisticsCallback
    public void deleteFiles(CancellationSignalCompat cancellationSignalCompat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cancellationSignalCompat);
        }
    }

    @Override // com.tencent.mm.vfs.StatisticsCallback
    public void reportError(Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) th5);
            return;
        }
        QLog.e("VFSRegisterProxy", 1, th5, new Object[0]);
        if (f312442a) {
            c(th5);
        } else {
            f312444c.add(th5);
        }
    }

    @Override // com.tencent.mm.vfs.StatisticsCallback
    public void statistics(String str, int i3, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), map);
            return;
        }
        if (map != null) {
            try {
                map.put("id", str);
                map.put("phase", String.valueOf(i3));
                if (f312442a) {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(b(), "vfs_statistics_tag", true, 0L, 0L, (HashMap) map, null);
                } else {
                    f312443b.add(map);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("VFSRegisterProxy", 2, "report params -> " + map + ", mCanAccurReport = " + f312442a);
                }
            } catch (Exception e16) {
                QLog.d("VFSRegisterProxy", 1, "vfs report error!", e16);
            }
        }
    }
}
