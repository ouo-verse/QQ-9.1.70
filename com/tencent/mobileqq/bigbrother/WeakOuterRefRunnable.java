package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public class WeakOuterRefRunnable implements Runnable, JefsClass.IdSetter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Object> f200368d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f200369e;

    /* renamed from: f, reason: collision with root package name */
    private String f200370f;

    /* renamed from: h, reason: collision with root package name */
    private int f200371h;

    /* renamed from: i, reason: collision with root package name */
    private int f200372i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f200373m;

    public WeakOuterRefRunnable(Runnable runnable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, runnable, Boolean.valueOf(z16));
            return;
        }
        this.f200372i = 1;
        this.f200369e = runnable;
        if (z16) {
            f();
        }
    }

    private boolean e() {
        WeakReference<Object> weakReference = this.f200368d;
        if (weakReference != null && this.f200369e != null) {
            Object obj = weakReference.get();
            if (obj == null) {
                return false;
            }
            try {
                Field declaredField = this.f200369e.getClass().getDeclaredField("this$0");
                declaredField.setAccessible(true);
                declaredField.set(this.f200369e, obj);
            } catch (IllegalAccessException e16) {
                QLog.e("WeakOuterRefRunnable", 1, e16, new Object[0]);
                return false;
            } catch (IllegalArgumentException e17) {
                QLog.e("WeakOuterRefRunnable", 1, e17, new Object[0]);
                return false;
            } catch (NoSuchFieldException e18) {
                QLog.e("WeakOuterRefRunnable", 1, e18, new Object[0]);
                return false;
            }
        }
        return true;
    }

    private void f() {
        Runnable runnable = this.f200369e;
        if (runnable == null) {
            return;
        }
        try {
            Field declaredField = runnable.getClass().getDeclaredField("this$0");
            declaredField.setAccessible(true);
            this.f200368d = new WeakReference<>(declaredField.get(this.f200369e));
            declaredField.set(this.f200369e, null);
        } catch (IllegalAccessException e16) {
            QLog.e("WeakOuterRefRunnable", 1, e16, new Object[0]);
        } catch (IllegalArgumentException e17) {
            QLog.e("WeakOuterRefRunnable", 1, e17, new Object[0]);
        } catch (NoSuchFieldException e18) {
            QLog.e("WeakOuterRefRunnable", 1, e18, new Object[0]);
        }
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f200371h = i3;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f200369e != null && e()) {
            this.f200369e.run();
            d.b().c(this.f200371h, this.f200372i);
            z16 = true;
        } else {
            d.b().c(this.f200371h, -3);
            z16 = false;
        }
        if (this.f200373m) {
            String str3 = "1";
            if (z16) {
                str = "1";
            } else {
                str = "";
            }
            if (z16) {
                str3 = "";
            }
            String str4 = this.f200370f;
            if (str4 == null) {
                str2 = "";
            } else {
                str2 = str4;
            }
            ReportController.o(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, str, str3, str2, "");
        }
    }

    @Override // com.tencent.mobileqq.haoliyou.JefsClass.IdSetter
    public void setId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f200373m = true;
            this.f200370f = str;
        }
    }

    @Override // com.tencent.mobileqq.haoliyou.JefsClass.IdSetter
    public void setJumpAction(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f200372i = i3;
        }
    }
}
