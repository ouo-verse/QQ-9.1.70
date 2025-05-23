package com.tencent.replacemonitor.replace;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.replacemonitor.MonitorListener;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.tmassistantbase.util.r;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ReplaceMonitor {
    static IPatchRedirector $redirector_ = null;
    public static final String WASH_TAG = "WashMonitor";
    private static ReplaceMonitor sInstance;
    private com.tencent.replacemonitor.replace.e.a mRealMonitor;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    ReplaceMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mRealMonitor = new com.tencent.replacemonitor.replace.e.a();
        }
    }

    public static synchronized ReplaceMonitor get() {
        ReplaceMonitor replaceMonitor;
        synchronized (ReplaceMonitor.class) {
            if (sInstance == null) {
                sInstance = new ReplaceMonitor();
            }
            replaceMonitor = sInstance;
        }
        return replaceMonitor;
    }

    public long addTask(MonitorTask monitorTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, (Object) monitorTask)).longValue();
        }
        return this.mRealMonitor.a(monitorTask);
    }

    public void deleteTask(MonitorTask monitorTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) monitorTask);
        } else {
            this.mRealMonitor.j(monitorTask);
        }
    }

    public MonitorResult execAsync(MonitorTask monitorTask, MonitorStep monitorStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MonitorResult) iPatchRedirector.redirect((short) 9, (Object) this, (Object) monitorTask, (Object) monitorStep);
        }
        return this.mRealMonitor.b(monitorTask, monitorStep);
    }

    public void execSync(MonitorTask monitorTask, MonitorStep monitorStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) monitorTask, (Object) monitorStep);
        } else {
            this.mRealMonitor.l(monitorTask, monitorStep);
        }
    }

    public MonitorTask getTask(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.mRealMonitor.c(j3) : (MonitorTask) iPatchRedirector.redirect((short) 6, (Object) this, j3);
    }

    public void init(Context context, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) map);
        } else {
            this.mRealMonitor.f(context, map);
        }
    }

    public void onAppInstalled(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16));
            return;
        }
        try {
            this.mRealMonitor.i(str, z16);
        } catch (Exception e16) {
            r.c(NetworkUtil.TAG, e16.getMessage());
        }
    }

    public void register(MonitorListener monitorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) monitorListener);
        } else {
            this.mRealMonitor.g(monitorListener);
        }
    }

    public MonitorTask getTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.mRealMonitor.d(str) : (MonitorTask) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
    }
}
