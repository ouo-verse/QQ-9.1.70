package com.tencent.mobileqq.qqsettingme;

import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.mobileqq.activity.qqsettingme.bean.b;
import com.tencent.mobileqq.activity.qqsettingme.bean.c;
import com.tencent.mobileqq.activity.qqsettingme.bean.e;
import com.tencent.mobileqq.activity.qqsettingme.bean.f;
import com.tencent.mobileqq.activity.qqsettingme.bean.g;
import com.tencent.mobileqq.activity.qqsettingme.bean.h;
import com.tencent.mobileqq.activity.qqsettingme.bean.i;
import com.tencent.mobileqq.activity.qqsettingme.bean.j;
import com.tencent.mobileqq.activity.qqsettingme.bean.l;
import com.tencent.mobileqq.activity.qqsettingme.bean.m;
import com.tencent.mobileqq.activity.qqsettingme.bean.n;
import com.tencent.mobileqq.activity.qqsettingme.bean.o;
import com.tencent.mobileqq.activity.qqsettingme.bean.p;
import com.tencent.mobileqq.activity.qqsettingme.bean.q;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.t;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQSettingMeABTestHelper;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.argus.node.ArgusTag;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

/* compiled from: P */
@ArgusTag(tags = {"AUTO_PRELOAD"})
@Page(business = Business.Setting, type = PageHierarchy.MainPage)
/* loaded from: classes17.dex */
public class QQSettingMe extends com.tencent.mobileqq.qqsettingme.a {
    static IPatchRedirector $redirector_;
    public static boolean P;
    private BaseQQSettingMeView D;
    private t E;
    private boolean F;
    private final MessageQueue.IdleHandler G;
    private final MessageQueue.IdleHandler H;
    private final MessageQueue.IdleHandler I;
    private final MessageQueue.IdleHandler J;
    private final MessageQueue.IdleHandler K;
    private final MessageQueue.IdleHandler L;
    private final AtomicBoolean M;
    private boolean N;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMe.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QLog.i("QQSettingMe", 2, "onClick: mContent");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 47)) {
            redirector.redirect((short) 47);
        } else {
            P = true;
        }
    }

    public QQSettingMe(QBaseActivity qBaseActivity, ViewGroup viewGroup) {
        super(qBaseActivity, viewGroup);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) viewGroup);
            return;
        }
        this.G = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.qqsettingme.QQSettingMe.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMe.this);
                }
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                }
                QLog.i("QQSettingMe", 1, "preloadProcessorHandler start");
                long currentTimeMillis = System.currentTimeMillis();
                ((IDrawerApi) QRoute.api(IDrawerApi.class)).preloadProcessors();
                QLog.i("QQSettingMe", 1, "preloadProcessorHandler running cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return false;
            }
        };
        this.H = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.qqsettingme.QQSettingMe.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMe.this);
                }
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                }
                QLog.i("QQSettingMe", 1, "firstGroupDrawablePreload start");
                long currentTimeMillis = System.currentTimeMillis();
                ((IDrawerApi) QRoute.api(IDrawerApi.class)).preloadDrawable(0);
                QLog.i("QQSettingMe", 1, "firstGroupDrawablePreload running cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return false;
            }
        };
        this.I = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.qqsettingme.QQSettingMe.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMe.this);
                }
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                }
                QLog.i("QQSettingMe", 1, "secondGroupDrawablePreload start");
                long currentTimeMillis = System.currentTimeMillis();
                ((IDrawerApi) QRoute.api(IDrawerApi.class)).preloadDrawable(1);
                QLog.i("QQSettingMe", 1, "secondGroupDrawablePreload running cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return false;
            }
        };
        this.J = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.qqsettingme.QQSettingMe.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMe.this);
                }
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                }
                QLog.i("QQSettingMe", 1, "thirdGroupDrawablePreload start");
                long currentTimeMillis = System.currentTimeMillis();
                ((IDrawerApi) QRoute.api(IDrawerApi.class)).preloadDrawable(2);
                QLog.i("QQSettingMe", 1, "thirdGroupDrawablePreload running cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return false;
            }
        };
        this.K = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.qqsettingme.QQSettingMe.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMe.this);
                }
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                }
                QLog.i("QQSettingMe", 1, "firstStep firstStep");
                long currentTimeMillis = System.currentTimeMillis();
                QQSettingMe.this.a0();
                QLog.i("QQSettingMe", 1, "firstStep running cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return false;
            }
        };
        this.L = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.qqsettingme.QQSettingMe.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMe.this);
                }
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                }
                QLog.i("QQSettingMe", 1, "secondStep firstStep");
                long currentTimeMillis = System.currentTimeMillis();
                if (QQSettingMe.this.D != null) {
                    QQSettingMe.this.D.c0();
                }
                QLog.i("QQSettingMe", 1, "secondStep running cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return false;
            }
        };
        this.M = new AtomicBoolean(false);
        this.N = false;
        this.F = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("drawer_account_change_anr_bugfix", true);
        QLog.i("QQSettingMe", 1, "QQSettingMe init accountChangeANRBugfix:" + this.F);
        this.f274439h.setOnClickListener(new a());
    }

    private void X(String str) {
        boolean c16 = QQSettingMeABTestHelper.c();
        boolean needUsedV3 = ((IDrawerApi) QRoute.api(IDrawerApi.class)).needUsedV3();
        boolean needReloadUI = ((IDrawerApi) QRoute.api(IDrawerApi.class)).needReloadUI();
        boolean currentIsV3 = ((IDrawerApi) QRoute.api(IDrawerApi.class)).currentIsV3();
        QLog.i("QQSettingMe", 1, str + ":" + this.N + " -> " + c16 + ", v3:" + currentIsV3 + " -> " + needUsedV3);
        if (this.N != c16 || needUsedV3 != currentIsV3 || (needReloadUI && needUsedV3)) {
            this.N = c16;
            onPostThemeChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        if (this.M.compareAndSet(true, false)) {
            X("checkToggleAndABTestChange ");
        }
    }

    private BaseQQSettingMeView Z(boolean z16) {
        QLog.i("QQSettingMe", 1, "createBaseQQSettingMeView isV9? " + z16);
        return ((IDrawerApi) QRoute.api(IDrawerApi.class)).getQQSettingMeView(z16, this.f274438f);
    }

    public static boolean d0() {
        return com.tencent.mobileqq.qqsettingme.a.f274435m;
    }

    private void j0() {
        P = false;
        this.f274439h.post(new Runnable() { // from class: com.tencent.mobileqq.qqsettingme.QQSettingMe.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMe.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (QQSettingMe.this.D != null) {
                    QQSettingMe.this.D.q();
                }
            }
        });
    }

    private void l0() {
        boolean c16 = QQSettingMeABTestHelper.c();
        try {
            this.D = Z(c16);
        } catch (Exception e16) {
            QLog.e("QQSettingMe", 1, "updateQQSettingMeProxy exception", e16);
        }
        if (c16 && this.D == null) {
            QLog.i("QQSettingMe", 1, "updateQQSettingMeProxy create v9 fail");
            this.D = Z(false);
        }
        QLog.e("QQSettingMe", 1, "updateQQSettingMeProxy isV9? " + c16);
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            this.N = baseQQSettingMeView.n();
            this.f274439h.removeAllViews();
            this.f274439h.addView(this.D.f274439h);
        } else {
            QLog.e("QQSettingMe", 1, "updateQQSettingMeProxy addView error. qqSettingMeProxy is null");
        }
        t tVar = this.E;
        if (tVar != null) {
            tVar.a();
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void A(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) cVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.A(cVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void B(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) appInfo);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.B(appInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void C(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) appInfo);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.C(appInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void D(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) gVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.D(gVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void E(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) eVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.E(eVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void F(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) fVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.F(fVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void G(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) gVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.G(gVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.H(str);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void I(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) hVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.I(hVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void J(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, i3);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.J(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void K(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, i3);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.K(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void L(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) iVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.L(iVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void M(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) jVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.M(jVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void N(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) appInfo);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.N(appInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void O(m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) mVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.O(mVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void P(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) appInfo);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.P(appInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void Q(l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) lVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.Q(lVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void R(o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) oVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.R(oVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void S(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) pVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.S(pVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void T(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) pVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.T(pVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void U(q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) qVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.U(qVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else if (this.D != null) {
            onPostThemeChanged();
            this.D.a(z16);
        }
    }

    public void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.D == null) {
            QLog.i("QQSettingMe", 1, "initQQSettingMeProxy");
            l0();
            this.f274436d = true;
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void b(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime);
            return;
        }
        super.b(appRuntime);
        if (this.F) {
            X("fillData ");
        } else {
            BaseQQSettingMeView baseQQSettingMeView = this.D;
            if (baseQQSettingMeView != null) {
                baseQQSettingMeView.Y();
                l0();
                if (com.tencent.mobileqq.qqsettingme.a.f274435m && this.D != null) {
                    j0();
                }
            }
        }
        this.M.set(true);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqsettingme.QQSettingMe.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMe.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMe.this.Y();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 1000L);
        BaseQQSettingMeView baseQQSettingMeView2 = this.D;
        if (baseQQSettingMeView2 != null) {
            baseQQSettingMeView2.b(appRuntime);
        }
    }

    public boolean c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f274436d;
    }

    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.Y();
        }
        ((IDrawerApi) QRoute.api(IDrawerApi.class)).clearAllCache();
        Looper.myQueue().removeIdleHandler(this.G);
        Looper.myQueue().removeIdleHandler(this.H);
        Looper.myQueue().removeIdleHandler(this.I);
        Looper.myQueue().removeIdleHandler(this.J);
        Looper.myQueue().removeIdleHandler(this.K);
        Looper.myQueue().removeIdleHandler(this.L);
        this.E = null;
    }

    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.Z();
        }
    }

    public void g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (this.D != null) {
            this.f274439h.post(new Runnable() { // from class: com.tencent.mobileqq.qqsettingme.QQSettingMe.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMe.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQSettingMe.this.D.a0();
                    }
                }
            });
        }
    }

    public void i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("QQSettingMe", 1, "preload start");
        Looper.myQueue().addIdleHandler(this.G);
        Looper.myQueue().addIdleHandler(this.H);
        Looper.myQueue().addIdleHandler(this.I);
        Looper.myQueue().addIdleHandler(this.J);
        Looper.myQueue().addIdleHandler(this.K);
        Looper.myQueue().addIdleHandler(this.L);
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public View j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            return baseQQSettingMeView.j();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public QQSettingMeViewModel k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QQSettingMeViewModel) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            return baseQQSettingMeView.k();
        }
        return null;
    }

    public void k0(t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) tVar);
        } else {
            this.E = tVar;
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.m();
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            return baseQQSettingMeView.n();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void o(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) configuration);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.o(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostThemeChanged() {
        boolean z16;
        BaseQQSettingMeView baseQQSettingMeView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        boolean c16 = QQSettingMeABTestHelper.c();
        boolean needUsedV3 = ((IDrawerApi) QRoute.api(IDrawerApi.class)).needUsedV3();
        boolean currentIsV3 = ((IDrawerApi) QRoute.api(IDrawerApi.class)).currentIsV3();
        BaseQQSettingMeView baseQQSettingMeView2 = this.D;
        if (baseQQSettingMeView2 != null) {
            boolean n3 = baseQQSettingMeView2.n();
            boolean needReloadUI = ((IDrawerApi) QRoute.api(IDrawerApi.class)).needReloadUI();
            if (n3 != c16 || needUsedV3 != currentIsV3 || (needReloadUI && needUsedV3)) {
                ((IDrawerApi) QRoute.api(IDrawerApi.class)).resetReloadUI();
                z16 = true;
                if (needUsedV3 && c16) {
                    QLog.i("QQSettingMe", 1, "onPostThemeChanged change to v3");
                } else if (c16) {
                    QLog.i("QQSettingMe", 1, "onPostThemeChanged change to v9");
                } else {
                    QLog.i("QQSettingMe", 1, "onPostThemeChanged change to old");
                }
                QLog.i("QQSettingMe", 2, "onPostThemeChanged needRecreateProxy: " + z16);
                if (z16) {
                    BaseQQSettingMeView baseQQSettingMeView3 = this.D;
                    if (baseQQSettingMeView3 != null) {
                        baseQQSettingMeView3.Y();
                        this.D = null;
                    }
                    l0();
                    if (com.tencent.mobileqq.qqsettingme.a.f274435m && this.D != null) {
                        j0();
                    }
                }
                baseQQSettingMeView = this.D;
                if (baseQQSettingMeView == null) {
                    baseQQSettingMeView.onPostThemeChanged();
                    return;
                }
                return;
            }
        }
        z16 = false;
        QLog.i("QQSettingMe", 2, "onPostThemeChanged needRecreateProxy: " + z16);
        if (z16) {
        }
        baseQQSettingMeView = this.D;
        if (baseQQSettingMeView == null) {
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.p();
        P = true;
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.p();
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.q();
        Y();
        if (this.D != null) {
            j0();
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.r();
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void s(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) nVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.s(nVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.v(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.w(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void x(com.tencent.mobileqq.activity.qqsettingme.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) aVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.x(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void y(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) appInfo);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.y(str, appInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void z(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bVar);
            return;
        }
        BaseQQSettingMeView baseQQSettingMeView = this.D;
        if (baseQQSettingMeView != null) {
            baseQQSettingMeView.z(bVar);
        }
    }
}
