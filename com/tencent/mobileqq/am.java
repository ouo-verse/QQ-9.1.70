package com.tencent.mobileqq;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.cf;
import com.tencent.mobileqq.utils.de;
import com.tencent.mobileqq.utils.dg;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@ArgusTag(tags = {"AUTO_PRELOAD"})
@Page(business = Business.Setting, type = PageHierarchy.MainPage)
/* loaded from: classes9.dex */
public class am extends BaseQQSettingMeView {
    static IPatchRedirector $redirector_;
    private final AtomicBoolean G;
    ji3.m H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements ji3.m {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) am.this);
            }
        }

        @Override // ji3.m
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!am.this.G.get()) {
                am.this.n0();
            } else {
                QLog.i("QQSettingMeViewV3", 2, "onChange mHasSetZPlanSwitch = true");
            }
        }

        @Override // ji3.m
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                am.this.G.set(true);
                am.this.n0();
            }
        }
    }

    public am(QBaseActivity qBaseActivity, ViewGroup viewGroup) {
        super(qBaseActivity, viewGroup);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) viewGroup);
            return;
        }
        this.G = new AtomicBoolean(false);
        this.H = new a();
        QLog.d("QQSettingMeViewV3", 1, "-->QQSettingMeViewV9 construct!");
        dg.f307630a.e();
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                am.s0(view);
            }
        });
        this.E.U1(this.f274438f, this.F);
        w0();
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).setOnZPlanSettingChangeListener(1006L, this.H);
        this.E.f312699h0.observe(this.F, new Observer() { // from class: com.tencent.mobileqq.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                am.this.x0(((Boolean) obj).booleanValue());
            }
        });
    }

    public void n0() {
        QLog.d("QQSettingMeViewV3", 1, "checkAndRefresh()");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.al
            @Override // java.lang.Runnable
            public final void run() {
                am.this.q0();
            }
        }, 16, null, false);
    }

    private void o0() {
        QLog.d("QQSettingMeViewV3", 1, "checkRefreshZPlanCover()");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aj
            @Override // java.lang.Runnable
            public final void run() {
                am.this.r0();
            }
        }, 16, null, false);
    }

    private void p0() {
        if (!this.f274436d) {
            QLog.i("QQSettingMeViewV3", 1, "init");
            v0();
            VideoReport.addToDetectionWhitelist(this.f274438f);
            this.D.n(true);
            this.f274436d = true;
        }
    }

    public /* synthetic */ void q0() {
        ThreadManagerV2.getUIHandlerV2().post(new ak(this));
    }

    public /* synthetic */ void r0() {
        ThreadManagerV2.getUIHandlerV2().post(new ak(this));
    }

    public static /* synthetic */ void s0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.i("QQSettingMeViewV3", 2, "mQQSettingMeMaintainer click");
        EventCollector.getInstance().onViewClicked(view);
    }

    public /* synthetic */ void u0() {
        VideoReport.setPageId(this.f274439h, "pg_bas_drawer");
        d0();
    }

    private void v0() {
        this.E.W1(this);
        this.E.d2();
    }

    public void w0() {
        QLog.d("QQSettingMeViewV3", 1, "refreshZPlanCover()");
        x0(Boolean.TRUE.equals(this.E.f312699h0.getValue()));
    }

    public void x0(boolean z16) {
        int i3;
        if (de.f307628a.c()) {
            i3 = 0;
        } else if (z16) {
            i3 = 4;
        } else {
            i3 = 3;
        }
        QLog.i("QQSettingMeViewV3", 2, "updateDrawerMode hasCover: " + z16 + ", mode: " + i3);
        this.E.g2(i3);
    }

    private void y0() {
        if (ImmersiveUtils.isSupporImmersive() != 0 && this.f274436d) {
            if (BaseQQSettingMeView.X()) {
                QUIImmersiveHelper.s(this.f274438f, true, BaseQQSettingMeView.W());
                return;
            }
            if (this.f274437e) {
                ImmersiveUtils.adjustThemeStatusBar(this.f274438f.getWindow());
                return;
            }
            boolean equals = Boolean.TRUE.equals(this.E.f312699h0.getValue());
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (QQTheme.isDefaultTheme()) {
                ImmersiveUtils.setStatusTextColorNew(!equals, this.f274438f.getWindow());
                return;
            }
            if (((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isNowThemeIsNight(peekAppRuntime, true, null)) {
                ImmersiveUtils.setStatusTextColorNew(false, this.f274438f.getWindow());
            } else if (((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isGoldenTheme()) {
                ImmersiveUtils.setStatusTextColorNew(false, this.f274438f.getWindow());
            } else {
                ImmersiveUtils.setStatusTextColorNew(((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isDartStatusBar(this.f274438f, R.color.qq_setting_me_nightmode_color_white), this.f274438f.getWindow());
            }
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void E(com.tencent.mobileqq.activity.qqsettingme.bean.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) eVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void F(com.tencent.mobileqq.activity.qqsettingme.bean.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) fVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    @Nullable
    public List<com.tencent.mobileqq.part.a> V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return cf.f307520a.a();
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.Y();
            this.H = null;
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    public void Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.Z();
            y0();
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    public void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.a0();
            y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    public void c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.c0();
            p0();
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView, com.tencent.mobileqq.qqsettingme.a
    public QQSettingMeViewModel k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQSettingMeViewModel) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.E;
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void o(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) configuration);
        } else {
            this.E.X1();
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        QLog.d("QQSettingMeViewV3", 1, "onPostThemeChanged()");
        w0();
        this.E.N1("d_weather").e();
        d0();
        y0();
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView, com.tencent.mobileqq.qqsettingme.a
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.p();
            VideoReport.pageLogicDestroy(this.f274439h);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView, com.tencent.mobileqq.qqsettingme.a
    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.q();
        QLog.d("QQSettingMeViewV3", 1, "onResume()");
        o0();
        p0();
        com.tencent.mobileqq.processor.b N1 = this.E.N1("d_head_vip");
        if (N1 != null) {
            Card g16 = ((com.tencent.mobileqq.activity.qqsettingme.j) N1).g();
            ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).reportCoverBg(MobileQQ.sMobileQQ.peekAppRuntime(), g16);
        }
        this.f274439h.post(new Runnable() { // from class: com.tencent.mobileqq.ai
            @Override // java.lang.Runnable
            public final void run() {
                am.this.u0();
            }
        });
        ViewGroup viewGroup = this.f274439h;
        com.tencent.mobileqq.part.b bVar = this.D;
        Objects.requireNonNull(bVar);
        viewGroup.post(new aa(bVar));
        ViewGroup viewGroup2 = this.f274439h;
        QQSettingMeViewModel qQSettingMeViewModel = this.E;
        Objects.requireNonNull(qQSettingMeViewModel);
        viewGroup2.post(new z(qQSettingMeViewModel));
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        }
    }
}
