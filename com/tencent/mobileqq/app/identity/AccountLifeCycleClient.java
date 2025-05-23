package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AccountLifeCycleClient implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final AccountLifeCycleClient f195746e;

    /* renamed from: a, reason: collision with root package name */
    public List<c> f195747a;

    /* renamed from: b, reason: collision with root package name */
    protected AtomicBoolean f195748b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f195749c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f195750d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21569);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f195746e = new AccountLifeCycleClient();
        }
    }

    AccountLifeCycleClient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f195748b = new AtomicBoolean(true);
        this.f195749c = new AtomicBoolean(true);
        this.f195750d = new AtomicBoolean(true);
        ArrayList arrayList = new ArrayList();
        this.f195747a = arrayList;
        arrayList.add(new AccountPhoneUnityManager());
        this.f195747a.add(AccountIdentityManager.p());
        this.f195747a.add(new PhoneUpgradeManager());
        this.f195747a.add(new b());
    }

    public static AccountLifeCycleClient b() {
        return f195746e;
    }

    public c a(Class<? extends c> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (c) iPatchRedirector.redirect((short) 13, (Object) this, (Object) cls);
        }
        for (c cVar : this.f195747a) {
            if (cVar.getClass() == cls) {
                return cVar;
            }
        }
        return null;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.f195748b.get();
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (z16 != this.f195750d.get()) {
            this.f195750d.set(z16);
            QLog.d("AccountLifeCycleClient", 1, "setDestroyANRBugfixSwitch:" + z16);
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16 != this.f195749c.get()) {
            this.f195749c.set(z16);
            QLog.d("AccountLifeCycleClient", 1, "setForegroundANRBugfixSwitch:" + z16);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.c
    public void onAccountLoginOrSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f195748b.set(false);
        Iterator<c> it = this.f195747a.iterator();
        while (it.hasNext()) {
            it.next().onAccountLoginOrSwitch();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.c
    public void onActivityDestroy(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            if (this.f195750d.get()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity) { // from class: com.tencent.mobileqq.app.identity.AccountLifeCycleClient.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Activity f195751d;

                    {
                        this.f195751d = activity;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountLifeCycleClient.this, (Object) activity);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        Iterator<c> it = AccountLifeCycleClient.this.f195747a.iterator();
                        while (it.hasNext()) {
                            it.next().onActivityDestroy(this.f195751d);
                        }
                    }
                });
                return;
            }
            Iterator<c> it = this.f195747a.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroy(activity);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.identity.c
    public void onActivityResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity) { // from class: com.tencent.mobileqq.app.identity.AccountLifeCycleClient.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f195752d;

                {
                    this.f195752d = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountLifeCycleClient.this, (Object) activity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator<c> it = AccountLifeCycleClient.this.f195747a.iterator();
                    while (it.hasNext()) {
                        it.next().onActivityResume(this.f195752d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.identity.c
    public void onBackgroundSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator<c> it = this.f195747a.iterator();
        while (it.hasNext()) {
            it.next().onBackgroundSwitch();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.c
    public void onConversationResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Iterator<c> it = this.f195747a.iterator();
        while (it.hasNext()) {
            it.next().onConversationResume();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.c
    public void onForegroundSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f195748b.set(false);
        if (this.f195749c.get()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.identity.AccountLifeCycleClient.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountLifeCycleClient.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator<c> it = AccountLifeCycleClient.this.f195747a.iterator();
                    while (it.hasNext()) {
                        it.next().onForegroundSwitch();
                    }
                }
            });
            return;
        }
        Iterator<c> it = this.f195747a.iterator();
        while (it.hasNext()) {
            it.next().onForegroundSwitch();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.c
    public void onPreloadEveryLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<c> it = this.f195747a.iterator();
        while (it.hasNext()) {
            it.next().onPreloadEveryLogin();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.c
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.f195748b.set(true);
        Iterator<c> it = this.f195747a.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }
}
