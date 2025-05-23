package com.tencent.mobileqq.auto.engine.main.fragment;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import uq3.o;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static Method f199891h;

    /* renamed from: i, reason: collision with root package name */
    private static Method f199892i;

    /* renamed from: a, reason: collision with root package name */
    private View f199893a;

    /* renamed from: b, reason: collision with root package name */
    private Window f199894b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f199895c;

    /* renamed from: d, reason: collision with root package name */
    private ASEnterBean f199896d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f199897e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f199898f;

    /* renamed from: g, reason: collision with root package name */
    private LocalActivityManager f199899g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements OnApplyWindowInsetsListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WindowInsetsCompat) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) windowInsetsCompat);
            }
            return windowInsetsCompat;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41270);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = Activity.class.getDeclaredMethod("onActivityResult", cls, cls, Intent.class);
            f199891h = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = Activity.class.getDeclaredMethod("onNewIntent", Intent.class);
            f199892i = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            QLog.e("ASLocalActivityMangerProxy", 1, "getOnActivityResult error");
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean c() {
        if (Build.VERSION.SDK_INT < 35) {
            return true;
        }
        return o.d();
    }

    private void h(Bundle bundle) {
        if (bundle == null) {
            QLog.d("ASLocalActivityMangerProxy", 1, "init bundle is empty " + hashCode());
            return;
        }
        if (this.f199896d != null) {
            QLog.d("ASLocalActivityMangerProxy", 1, "mEnterBean has init " + hashCode());
            return;
        }
        n(bundle);
    }

    private void j() {
        try {
            ViewParent parent = this.f199898f.getWindow().getDecorView().getParent();
            Field declaredField = parent.getClass().getDeclaredField("mActivityConfigCallback");
            declaredField.setAccessible(true);
            declaredField.set(parent, null);
            QLog.d("ASLocalActivityMangerProxy", 1, "releaseHostWindows success");
        } catch (Exception e16) {
            QLog.d("ASLocalActivityMangerProxy", 1, "releaseHostWindows error", e16);
        }
    }

    private void k() {
        Activity activity;
        try {
            if (uq3.c.x() && c() && (activity = this.f199898f) != null && activity.getWindow() != null) {
                Window window = this.f199898f.getWindow();
                Field declaredField = Window.class.getDeclaredField("mActiveChild");
                declaredField.setAccessible(true);
                Window window2 = (Window) declaredField.get(window);
                if (window2.getContext() != null && window2.getContext().getClass().getName().equals("com.tencent.biz.qqcircle.activity.QCircleFolderActivity")) {
                    declaredField.set(window, null);
                    QLog.d("ASLocalActivityMangerProxy", 1, "releaseHostWindows success");
                    j();
                }
            }
        } catch (Exception e16) {
            QLog.d("ASLocalActivityMangerProxy", 1, "releaseHostWindows error", e16);
        }
    }

    private void l() {
        try {
            if (uq3.c.x() && c()) {
                Window window = this.f199894b;
                if (window != null) {
                    window.setCallback(null);
                    this.f199894b = null;
                }
                this.f199893a = null;
                LocalActivityManager localActivityManager = this.f199899g;
                Field declaredField = localActivityManager.getClass().getDeclaredField("mParent");
                declaredField.setAccessible(true);
                Field declaredField2 = localActivityManager.getClass().getDeclaredField("mResumed");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(localActivityManager);
                Field declaredField3 = obj.getClass().getDeclaredField("window");
                declaredField3.setAccessible(true);
                Field declaredField4 = obj.getClass().getDeclaredField(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                declaredField4.setAccessible(true);
                declaredField3.set(obj, null);
                declaredField4.set(obj, null);
                declaredField2.set(localActivityManager, null);
                declaredField.set(localActivityManager, null);
                QLog.d("ASLocalActivityMangerProxy", 1, "releaseLocalActivity success");
            }
        } catch (Exception e16) {
            QLog.d("ASLocalActivityMangerProxy", 1, "releaseLocalActivity error", e16);
        }
    }

    public void a(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        Activity activity = this.f199895c;
        if (activity == null) {
            QLog.e("ASLocalActivityMangerProxy", 1, "dispatchActivityResult but targetActivity is null");
            return;
        }
        Method method = f199891h;
        if (method == null) {
            QLog.e("ASLocalActivityMangerProxy", 1, "dispatchActivityResult but sOnActivityMethod is null");
            return;
        }
        try {
            method.invoke(activity, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            QLog.e("ASLocalActivityMangerProxy", 1, "dispatchActivityResult success " + this.f199895c);
        } catch (Throwable th5) {
            if (!RFWApplication.isDebug()) {
                QLog.e("ASLocalActivityMangerProxy", 1, "dispatchActivityResult exception " + th5.getMessage(), th5);
                return;
            }
            throw new RuntimeException("dispatchActivityResult error:" + th5.getMessage(), th5);
        }
    }

    public void b(@NonNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent);
            return;
        }
        Activity activity = this.f199895c;
        if (activity == null) {
            QLog.e("ASLocalActivityMangerProxy", 1, "dispatchOnNewIntent but targetActivity is null");
            return;
        }
        Method method = f199892i;
        if (method == null) {
            QLog.e("ASLocalActivityMangerProxy", 1, "dispatchOnNewIntent but sOnNewIntentMethod is null");
            return;
        }
        try {
            method.invoke(activity, intent);
            QLog.e("ASLocalActivityMangerProxy", 1, "dispatchOnNewIntent success " + this.f199895c);
        } catch (Throwable th5) {
            if (!RFWApplication.isDebug()) {
                QLog.e("ASLocalActivityMangerProxy", 1, "dispatchOnNewIntent exception " + th5.getMessage(), th5);
                return;
            }
            throw new RuntimeException("dispatchOnNewIntent error:" + th5.getMessage(), th5);
        }
    }

    public ASEnterBean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ASEnterBean) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f199896d;
    }

    public Activity e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Activity) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f199898f;
    }

    public LocalActivityManager f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LocalActivityManager) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f199899g == null && this.f199898f != null) {
            LocalActivityManager localActivityManager = new LocalActivityManager(this.f199898f, true);
            this.f199899g = localActivityManager;
            localActivityManager.dispatchCreate(null);
        }
        return this.f199899g;
    }

    public View g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f199893a;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f199897e;
    }

    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            h(bundle);
        }
    }

    public void n(@NonNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        if (bundle.containsKey(ASEngineConstants.ShadowEngineKey.KEY_AS_ENTER_BEAN)) {
            this.f199896d = (ASEnterBean) bundle.getSerializable(ASEngineConstants.ShadowEngineKey.KEY_AS_ENTER_BEAN);
            QLog.d("ASLocalActivityMangerProxy", 1, "ASBaseFragment fragment has enterBean" + hashCode());
            return;
        }
        QLog.d("ASLocalActivityMangerProxy", 1, "ASBaseFragment fragment params error " + hashCode());
    }

    public void o(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        if (activity == null) {
            QLog.d("ASLocalActivityMangerProxy", 1, "setTargetActivity error null");
            return;
        }
        this.f199898f = activity;
        QLog.d("ASLocalActivityMangerProxy", 1, "setTargetActivity:" + activity.getClass() + hashCode());
    }

    public void p(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (this.f199893a == null) {
            QLog.d("ASLocalActivityMangerProxy", 1, "setInnerActivityState :" + i3 + "\uff0cmTargetDecorView is empty," + hashCode());
            return;
        }
        try {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            f().dispatchDestroy(true);
                            l();
                            k();
                            com.tencent.mobileqq.auto.engine.main.c.a(this.f199898f);
                            this.f199895c = null;
                            this.f199898f = null;
                            return;
                        }
                        return;
                    }
                    f().dispatchStop();
                    com.tencent.mobileqq.auto.engine.main.c.a(this.f199898f);
                    return;
                }
                com.tencent.mobileqq.auto.engine.main.c.a(this.f199898f);
                LocalActivityManager f16 = f();
                Activity activity = this.f199898f;
                if (activity != null && activity.isFinishing()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                f16.dispatchPause(z16);
                return;
            }
            f().dispatchResume();
            com.tencent.mobileqq.auto.engine.main.c.a(this.f199898f);
        } catch (Exception e16) {
            QLog.e("ASLocalActivityMangerProxy", 1, e16, new Object[0]);
        }
    }

    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.f199897e = z16;
        }
    }

    public View r(Intent intent) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent);
        }
        if (this.f199896d != null && intent != null) {
            try {
                Window startActivity = f().startActivity(this.f199896d.getBusinessKey(), intent);
                this.f199894b = startActivity;
                if (startActivity != null) {
                    this.f199893a = startActivity.getDecorView();
                    this.f199895c = (Activity) this.f199894b.getContext();
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("startLocalActivity :has targetWinDow:");
                if (this.f199894b != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(", has targetDecorView:");
                if (this.f199893a != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append(", has targetActivity:");
                if (this.f199895c != null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                sb5.append(z18);
                sb5.append(" , hashcode:");
                sb5.append(hashCode());
                QLog.d("ASLocalActivityMangerProxy", 1, sb5.toString());
                ViewCompat.setOnApplyWindowInsetsListener(this.f199893a, new a());
            } catch (Exception e16) {
                QLog.d("ASLocalActivityMangerProxy", 1, e16, " , hashcode:" + hashCode());
            }
            return this.f199893a;
        }
        QLog.d("ASLocalActivityMangerProxy", 1, "startLocalActivity return: mEnterBean or intent is empty:" + hashCode());
        return null;
    }
}
