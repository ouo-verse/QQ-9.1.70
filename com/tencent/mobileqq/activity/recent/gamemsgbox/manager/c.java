package com.tencent.mobileqq.activity.recent.gamemsgbox.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends com.tencent.mobileqq.activity.recent.gamemsgbox.manager.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.activity.recent.gamemsgbox.repo.b f185542f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static c f185543a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21581);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f185543a = new c(null);
            }
        }
    }

    /* synthetic */ c(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
    }

    public static c e() {
        return b.f185543a;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.manager.a
    public void b(AppRuntime appRuntime, EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) entityManager);
            return;
        }
        super.b(appRuntime, entityManager);
        if (this.f185537d == null) {
            return;
        }
        this.f185542f.d(this.f185538e);
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.manager.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.c();
            this.f185542f.b();
        }
    }

    public void d(String str, GameSwitchConfig gameSwitchConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) gameSwitchConfig);
        } else if (!TextUtils.isEmpty(str) && gameSwitchConfig != null) {
            this.f185542f.a(str, gameSwitchConfig);
        }
    }

    public boolean f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        GameSwitchConfig c16 = this.f185542f.c(str);
        if (c16 == null || c16.mBlockSwitch != 1) {
            return false;
        }
        return true;
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f185542f = new com.tencent.mobileqq.activity.recent.gamemsgbox.repo.b();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
