package com.tencent.mobileqq;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ce;
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
public class at extends BaseQQSettingMeView {
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) at.this);
            }
        }

        @Override // ji3.m
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!at.this.G.get()) {
                at.this.n0();
            } else {
                QLog.i("QQSettingMeViewV9", 2, "onChange mHasSetZPlanSwitch = true");
            }
        }

        @Override // ji3.m
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                at.this.G.set(true);
                at.this.n0();
            }
        }
    }

    public at(QBaseActivity qBaseActivity, ViewGroup viewGroup) {
        super(qBaseActivity, viewGroup);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) viewGroup);
            return;
        }
        this.G = new AtomicBoolean(false);
        this.H = new a();
        QLog.d("QQSettingMeViewV9", 1, "-->QQSettingMeViewV9 construct!");
        dg.f307630a.e();
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                at.s0(view);
            }
        });
        this.E.U1(this.f274438f, this.F);
        w0();
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).setOnZPlanSettingChangeListener(1006L, this.H);
        this.E.f312699h0.observe(this.F, new Observer() { // from class: com.tencent.mobileqq.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                at.this.x0(((Boolean) obj).booleanValue());
            }
        });
    }

    public void n0() {
        QLog.d("QQSettingMeViewV9", 1, "checkAndRefresh()");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ar
            @Override // java.lang.Runnable
            public final void run() {
                at.this.q0();
            }
        }, 16, null, false);
    }

    private void o0() {
        QLog.d("QQSettingMeViewV9", 1, "checkRefreshZPlanCover()");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aq
            @Override // java.lang.Runnable
            public final void run() {
                at.this.r0();
            }
        }, 16, null, false);
    }

    private void p0() {
        if (!this.f274436d) {
            QLog.i("QQSettingMeViewV9", 1, "init");
            v0();
            VideoReport.addToDetectionWhitelist(this.f274438f);
            this.D.n(true);
            this.f274436d = true;
        }
    }

    public /* synthetic */ void q0() {
        ThreadManagerV2.getUIHandlerV2().post(new as(this));
    }

    public /* synthetic */ void r0() {
        ThreadManagerV2.getUIHandlerV2().post(new as(this));
    }

    public static /* synthetic */ void s0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.i("QQSettingMeViewV9", 2, "mQQSettingMeMaintainer click");
        EventCollector.getInstance().onViewClicked(view);
    }

    public /* synthetic */ void u0() {
        VideoReport.setPageId(this.f274439h, "pg_drawer");
        d0();
    }

    private void v0() {
        this.E.W1(this);
        this.E.d2();
    }

    public void w0() {
        QLog.d("QQSettingMeViewV9", 1, "refreshZPlanCover()");
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
        QLog.i("QQSettingMeViewV9", 2, "updateDrawerMode hasCover: " + z16 + ", mode: " + i3);
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
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) eVar);
            return;
        }
        View h16 = com.tencent.mobileqq.qqsettingme.a.h("d_intimate_space");
        if (h16 != null && eVar != null) {
            if (eVar.c() && !com.tencent.mobileqq.activity.qqsettingme.utils.b.h(com.tencent.mobileqq.qqsettingme.a.c("d_intimate_space"))) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            h16.setVisibility(i3);
            View findViewById = h16.findViewById(R.id.umi);
            if (!(findViewById instanceof LinearLayout)) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) findViewById;
            QQProAvatarView qQProAvatarView = null;
            for (int i16 = 0; i16 < linearLayout.getChildCount(); i16++) {
                if (linearLayout.getChildAt(i16) instanceof QQProAvatarView) {
                    qQProAvatarView = (QQProAvatarView) linearLayout.getChildAt(i16);
                }
            }
            if (eVar.b()) {
                if (qQProAvatarView != null) {
                    qQProAvatarView.setVisibility(8);
                }
            } else {
                if (TextUtils.isEmpty(eVar.a())) {
                    return;
                }
                if (qQProAvatarView != null) {
                    qQProAvatarView.w(1, eVar.a());
                    qQProAvatarView.setVisibility(0);
                } else {
                    QQProAvatarView qQProAvatarView2 = new QQProAvatarView(this.f274438f, null);
                    qQProAvatarView2.w(1, eVar.a());
                    ((ViewGroup) findViewById).addView(qQProAvatarView2, new ViewGroup.LayoutParams(ViewUtils.dip2px(32.0f), ViewUtils.dip2px(32.0f)));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void F(com.tencent.mobileqq.activity.qqsettingme.bean.f fVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) fVar);
            return;
        }
        View h16 = com.tencent.mobileqq.qqsettingme.a.h("d_vip_card");
        if (h16 == null) {
            return;
        }
        if (fVar.f184887a && !com.tencent.mobileqq.activity.qqsettingme.utils.b.h(com.tencent.mobileqq.qqsettingme.a.c("d_vip_card"))) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        h16.setVisibility(i3);
        if (!fVar.f184887a || !LocaleManager.isLocaleCN()) {
            return;
        }
        CharSequence d16 = com.tencent.mobileqq.activity.qqsettingme.utils.b.d("d_vip_card", fVar.f184888b);
        if (!fVar.f184890d) {
            TextView textView = (TextView) h16.findViewById(R.id.umj);
            textView.setContentDescription(d16);
            textView.setText(d16);
            DrawerUtils.m((URLImageView) h16.findViewById(R.id.umf), com.tencent.mobileqq.qqsettingme.a.C.get("d_vip_card"));
        }
        AccessibilityUtil.c(h16, d16, Button.class.getName());
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    @Nullable
    public List<com.tencent.mobileqq.part.a> V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return ce.f307518a.a();
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
        QLog.d("QQSettingMeViewV9", 1, "onPostThemeChanged()");
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
        QLog.d("QQSettingMeViewV9", 1, "onResume()");
        o0();
        p0();
        Card g16 = ((com.tencent.mobileqq.activity.qqsettingme.j) this.E.N1("d_head_vip")).g();
        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).reportCoverBg(MobileQQ.sMobileQQ.peekAppRuntime(), g16);
        this.f274439h.post(new Runnable() { // from class: com.tencent.mobileqq.ap
            @Override // java.lang.Runnable
            public final void run() {
                at.this.u0();
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
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        View h16 = com.tencent.mobileqq.qqsettingme.a.h("d_smallworld");
        if (h16 == null) {
            return;
        }
        if (z16 && !com.tencent.mobileqq.activity.qqsettingme.utils.b.h(com.tencent.mobileqq.qqsettingme.a.c("d_smallworld"))) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        h16.setVisibility(i3);
    }
}
