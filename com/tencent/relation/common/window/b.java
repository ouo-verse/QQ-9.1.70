package com.tencent.relation.common.window;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Boolean> f364883a;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final b f364884a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31789);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f364884a = new b();
            }
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f364883a = new HashMap<>();
        }
    }

    private boolean a(Context context) {
        return ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(context);
    }

    public static b d() {
        return a.f364884a;
    }

    private void g(String str, boolean z16) {
        this.f364883a.put(str, Boolean.valueOf(z16));
    }

    public boolean b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        HashMap<String, Boolean> hashMap = this.f364883a;
        if (hashMap != null && hashMap.get(str) != null) {
            return this.f364883a.get(str).booleanValue();
        }
        return false;
    }

    public com.tencent.mobileqq.qqfloatingwindow.a c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.qqfloatingwindow.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).getFloatingProxyWrapper(BaseApplication.getContext(), str);
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        QLog.i("RelationFloatWindowManager", 1, "hideRelationFloatWindow: className " + str);
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(str);
        g(str, false);
    }

    public boolean f(View view, String str, FloatingScreenParams floatingScreenParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, str, floatingScreenParams)).booleanValue();
        }
        BaseApplication context = BaseApplication.getContext();
        if (!a(context)) {
            QLog.i("RelationFloatWindowManager", 1, "showRelationFloatWindow: not had window permission.");
            return false;
        }
        c(str);
        int enterCustomFloatingScreen = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterCustomFloatingScreen(context, view, floatingScreenParams, str, 0);
        QLog.i("RelationFloatWindowManager", 1, "showRelationFloatWindow: showResult " + enterCustomFloatingScreen);
        if (enterCustomFloatingScreen != 0) {
            return false;
        }
        g(str, true);
        return true;
    }
}
