package com.tencent.mobileqq.troop.troopnotification;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected static String f300637b;

    /* renamed from: a, reason: collision with root package name */
    protected AppRuntime f300638a;

    public a(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.f300638a = appRuntime;
            f300637b = b();
        }
    }

    private String b() {
        String c16 = c();
        if (TextUtils.isEmpty(c16)) {
            return "TroopNotificationController unknown";
        }
        return c16;
    }

    @CallSuper
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d(f300637b, 2, "clearAllMsgCache");
        }
    }

    @Nullable
    protected abstract String c();

    public abstract void d();
}
