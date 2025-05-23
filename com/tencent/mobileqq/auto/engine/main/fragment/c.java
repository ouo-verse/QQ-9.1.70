package com.tencent.mobileqq.auto.engine.main.fragment;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabBackEvent;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabClickSelfEvent;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.main.IASFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c extends com.tencent.mobileqq.auto.engine.main.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<String, c> f199901f;

    /* renamed from: d, reason: collision with root package name */
    private IASFragment f199902d;

    /* renamed from: e, reason: collision with root package name */
    private String f199903e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41359);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f199901f = new HashMap<>();
        }
    }

    c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f199903e = str;
        }
    }

    public static synchronized c k(@NonNull String str) {
        c cVar;
        synchronized (c.class) {
            HashMap<String, c> hashMap = f199901f;
            cVar = hashMap.get(str);
            if (cVar == null) {
                cVar = new c(str);
                hashMap.put(str, cVar);
            }
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new AccountChangeEvent(z16));
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f199902d == null) {
            return false;
        }
        SimpleEventBus.getInstance().dispatchEvent(new ASEngineTabBackEvent(this.f199903e));
        QLog.d("ASDynamicEngine_back", 1, "pluginFragmentManger onBackEvent  true all ways");
        return true;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new ASEngineTabClickSelfEvent());
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        IASFragment iASFragment = this.f199902d;
        if (iASFragment == null) {
            return;
        }
        iASFragment.onDestroy();
        this.f199902d = null;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (this.f199902d == null) {
                return;
            }
            super.g();
            this.f199902d.setIsSelected(true);
            SimpleEventBus.getInstance().dispatchEvent(new ASEngineTabStatusEvent(this.f199903e, true));
            this.f199902d.onResume();
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f199902d == null) {
            return;
        }
        super.h();
        this.f199902d.setIsSelected(false);
        SimpleEventBus.getInstance().dispatchEvent(new ASEngineTabStatusEvent(this.f199903e, false));
        this.f199902d.onPause();
        this.f199902d.onStop();
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            if (this.f199902d == null) {
                return;
            }
            QLog.i("ASPluginFragmentManger", 1, "fs_lifecycle releaseFolderFragment-> to destroy");
            this.f199902d = null;
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void j(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        IASFragment iASFragment = this.f199902d;
        if (iASFragment != null) {
            iASFragment.setHostActivity(activity);
        }
    }

    public IASFragment l(Activity activity, ViewGroup viewGroup, ASEnterBean aSEnterBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IASFragment) iPatchRedirector.redirect((short) 2, this, activity, viewGroup, aSEnterBean);
        }
        if (this.f199902d == null) {
            if (com.tencent.mobileqq.auto.engine.loader.a.e(this.f199903e).j().k(aSEnterBean)) {
                this.f199902d = new d(viewGroup, aSEnterBean);
            } else if (com.tencent.mobileqq.auto.engine.loader.a.e(this.f199903e).v()) {
                this.f199902d = new a();
            } else {
                this.f199902d = new ASPluginFragment();
            }
            QLog.i("ASPluginFragmentManger", 1, "getMainFragment  init fragment:" + this.f199902d.getClass().getName());
        }
        return this.f199902d;
    }
}
