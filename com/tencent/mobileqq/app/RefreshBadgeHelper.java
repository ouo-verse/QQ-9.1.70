package com.tencent.mobileqq.app;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.util.ArrayList;
import java.util.Locale;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RefreshBadgeHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQAppbadgeImpl/Inject_app_badge_count.yml", version = 1)
    public static final ArrayList<Class<? extends qy2.a>> f194988f;

    /* renamed from: a, reason: collision with root package name */
    private final AppRuntime f194989a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Runnable f194990b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f194991c;

    /* renamed from: d, reason: collision with root package name */
    private qy2.a f194992d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f194993e;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class RefreshBadgeRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final int f194994d;

        RefreshBadgeRunnable(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RefreshBadgeHelper.this, i3);
            } else {
                this.f194994d = i3;
            }
        }

        private ry2.a e() {
            if (RefreshBadgeHelper.this.f194989a.isLogin() && !RefreshBadgeHelper.this.f194993e) {
                return RefreshBadgeHelper.this.f194992d.c(RefreshBadgeHelper.this.f194989a.hashCode(), this.f194994d);
            }
            return new ry2.a(0);
        }

        public void f() {
            int totalCount;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            ry2.a e16 = e();
            if (e16 == null) {
                BadgeUtils.m(RefreshBadgeHelper.this.f194989a.getApplicationContext(), 0);
            } else {
                BadgeUtils.n(RefreshBadgeHelper.this.f194989a.getApplicationContext(), e16);
            }
            if (QLog.isColorLevel()) {
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[4];
                if (e16 == null) {
                    totalCount = 0;
                } else {
                    totalCount = e16.getTotalCount();
                }
                objArr[0] = Integer.valueOf(totalCount);
                objArr[1] = Integer.valueOf(this.f194994d);
                objArr[2] = Boolean.valueOf(RefreshBadgeHelper.this.f194989a.isLogin());
                objArr[3] = Boolean.valueOf(RefreshBadgeHelper.this.f194993e);
                QLog.d("RefreshBadgeHelper", 2, String.format(locale, "unread: %d (%d) isLogin: %s isReleased: %s", objArr));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RefreshBadgeHelper.this.k(this);
                f();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32788);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        ArrayList<Class<? extends qy2.a>> arrayList = new ArrayList<>();
        f194988f = arrayList;
        arrayList.add(a.class);
        if (arrayList.size() > 0) {
            if (QLog.isColorLevel()) {
                int i3 = 0;
                while (true) {
                    ArrayList<Class<? extends qy2.a>> arrayList2 = f194988f;
                    if (i3 < arrayList2.size()) {
                        QLog.i("RefreshBadgeHelper", 2, arrayList2.get(i3).toString());
                        i3++;
                    } else {
                        return;
                    }
                }
            }
        } else {
            QLog.e("RefreshBadgeHelper", 1, "sCountInjector inject failed !");
        }
    }

    public RefreshBadgeHelper(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f194990b = null;
        this.f194991c = new Handler(ThreadManagerV2.getRecentThreadLooper());
        this.f194993e = false;
        this.f194989a = appRuntime;
        i();
    }

    private synchronized void f(RefreshBadgeRunnable refreshBadgeRunnable) {
        if (this.f194990b != null) {
            this.f194991c.removeCallbacks(this.f194990b);
            this.f194990b = null;
        }
        this.f194990b = refreshBadgeRunnable;
        this.f194991c.postDelayed(refreshBadgeRunnable, 50L);
    }

    private void g() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.app.cp
            @Override // java.lang.Runnable
            public final void run() {
                RefreshBadgeHelper.this.j();
            }
        });
    }

    private void i() {
        try {
            ArrayList<Class<? extends qy2.a>> arrayList = f194988f;
            if (arrayList.size() > 0) {
                this.f194992d = arrayList.get(0).newInstance();
            }
            g();
        } catch (Throwable th5) {
            QLog.e("RefreshBadgeHelper", 1, "initInjector Fail,", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        qy2.a aVar = this.f194992d;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k(RefreshBadgeRunnable refreshBadgeRunnable) {
        if (this.f194990b == refreshBadgeRunnable) {
            this.f194990b = null;
        }
    }

    public int h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        return this.f194992d.b(this.f194989a.hashCode(), i3);
    }

    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            f(new RefreshBadgeRunnable(i3));
        }
    }

    public void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f194993e = z16;
        }
    }
}
