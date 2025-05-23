package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VibrateNewFragment extends IphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    static String K;
    private QUISingleLineListItem C;
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> D;
    private QUISingleLineListItem E;
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> F;
    private QUISingleLineListItem G;
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> H;
    private QUISingleLineListItem I;
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.mobileqq.widget.bf {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f177507a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f177508b;

        a(int i3, boolean z16) {
            this.f177507a = i3;
            this.f177508b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VibrateNewFragment.this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void a(View view, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, Float.valueOf(f16), Float.valueOf(f17));
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void b(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void c(View view, int i3, int i16, int i17, int i18) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            int i19 = this.f177507a / 2;
            if (i16 <= 0) {
                f16 = 0.0f;
            } else if (i16 < i19) {
                f16 = (i16 * 1.0f) / i19;
            } else {
                f16 = 1.0f;
            }
            if (this.f177508b) {
                VibrateNewFragment.this.quiSecNavBar.setTitleBlurAlpha(f16);
            } else {
                VibrateNewFragment.this.quiSecNavBar.setTitleAlpha(f16);
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void d(View view, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, Float.valueOf(f16), Float.valueOf(f17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VibrateNewFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (z16) {
                    VibrateNewFragment.this.Ah(0);
                    if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(VibrateNewFragment.this.th()) == 0) {
                        ((x.c.f) VibrateNewFragment.this.F.O()).f(false);
                    } else {
                        ((x.c.f) VibrateNewFragment.this.F.O()).f(true);
                    }
                    VibrateNewFragment.this.th().setALLGeneralSettingVibrate(1);
                } else {
                    VibrateNewFragment.this.Ah(8);
                    VibrateNewFragment.this.th().setALLGeneralSettingVibrate(0);
                }
                ReportController.o(VibrateNewFragment.this.th(), "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, z16 ? 1 : 0, "", "", "", "");
                com.tencent.qqnt.notification.report.h.w("pg_bas_vibration", "em_bas_vibrating_switch", Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VibrateNewFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (z16) {
                    ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setTroopGeneralSettingVibrate(VibrateNewFragment.this.th(), 1);
                } else {
                    ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setTroopGeneralSettingVibrate(VibrateNewFragment.this.th(), 0);
                }
                com.tencent.qqnt.notification.report.h.w("pg_bas_vibration", "em_bas_group_vibration_switch", Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VibrateNewFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                VibrateNewFragment.this.zh(QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
                com.tencent.qqnt.notification.report.h.w("pg_bas_vibration", "em_bas_vibrating_switch", null);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VibrateNewFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                VibrateNewFragment.this.zh(QQNotificationManager.CHANNEL_ID_GROUP_MSG);
                com.tencent.qqnt.notification.report.h.w("pg_bas_vibration", "em_bas_group_vibration_switch", null);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            K = "setting_search_title";
        }
    }

    public VibrateNewFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah(int i3) {
        if (Build.VERSION.SDK_INT <= 28 && i3 == 0) {
            ViewUtils.setVisible(this.E, 0);
        } else {
            ViewUtils.setVisible(this.E, 8);
        }
    }

    private void Bh() {
        if (Build.VERSION.SDK_INT <= 28) {
            ViewUtils.setVisible(this.C, 0);
            ViewUtils.setVisible(this.E, 0);
            ViewUtils.setVisible(this.G, 8);
            ViewUtils.setVisible(this.I, 8);
            this.C.setBackgroundType(QUIListItemBackgroundType.TopRound);
            this.E.setBackgroundType(QUIListItemBackgroundType.BottomRound);
            com.tencent.qqnt.notification.report.h.B("pg_bas_vibration", "em_bas_vibrating_switch", Boolean.valueOf(this.D.O().getIsChecked()));
            com.tencent.qqnt.notification.report.h.B("pg_bas_vibration", "em_bas_group_vibration_switch", Boolean.valueOf(this.F.O().getIsChecked()));
        } else {
            ViewUtils.setVisible(this.C, 8);
            ViewUtils.setVisible(this.E, 8);
            ViewUtils.setVisible(this.G, 0);
            com.tencent.qqnt.notification.report.h.B("pg_bas_vibration", "em_bas_vibrating_switch", null);
            ViewUtils.setVisible(this.I, 8);
            this.G.setBackgroundType(QUIListItemBackgroundType.AllRound);
        }
        if (th().getALLGeneralSettingVibrate() != 0) {
            this.D.O().f(true);
            Ah(0);
            int troopGeneralSettingVibrate = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(th());
            if (QLog.isColorLevel()) {
                QLog.d("SoundSetting", 2, "canVibratorGroup :" + troopGeneralSettingVibrate);
            }
            if (troopGeneralSettingVibrate == 0) {
                this.F.O().f(false);
                return;
            } else {
                this.F.O().f(true);
                return;
            }
        }
        this.D.O().f(false);
        Ah(8);
    }

    private void initUI() {
        vh();
        yh();
        xh();
        wh();
        Bh();
        uh();
    }

    private void uh() {
        BounceScrollView bounceScrollView;
        if (!needBlur() || this.quiSecNavBar == null) {
            return;
        }
        View view = ((IphoneTitleBarFragment) this).mContentView;
        if (!(view instanceof BounceScrollView)) {
            return;
        }
        BounceScrollView bounceScrollView2 = (BounceScrollView) view;
        int b16 = com.tencent.biz.qui.quisecnavbar.e.b(bounceScrollView2.getContext());
        bounceScrollView2.setPadding(0, b16, 0, 0);
        bounceScrollView2.setClipToPadding(false);
        boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
        boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (isSettingPageNavNeedBlur) {
            bounceScrollView = bounceScrollView2;
        } else {
            bounceScrollView = null;
        }
        qUISecNavBar.setBlur(isSettingPageNavNeedBlur, bounceScrollView);
        if (!isSettingPageNavNeedAlpha) {
            return;
        }
        if (isSettingPageNavNeedBlur) {
            this.quiSecNavBar.setTitleBlurAlpha(0.0f);
        } else {
            this.quiSecNavBar.setTitleAlpha(0.0f);
        }
        bounceScrollView2.setScrollListener(new a(b16, isSettingPageNavNeedBlur));
    }

    private void vh() {
        QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.u2k);
        this.C = qUISingleLineListItem;
        qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.TopRound);
        this.C.setStyle(QUIListItemStyle.Card);
        boolean z16 = false;
        this.D = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d("\u6d88\u606f\u632f\u52a8\u63d0\u9192"), new x.c.f(false, null, true));
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(th()) == 0) {
            x.c.f O = this.D.O();
            if (th().getALLGeneralSettingVibrate() != 0) {
                z16 = true;
            }
            O.f(z16);
        } else {
            x.c.f O2 = this.D.O();
            if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(th()) == 1) {
                z16 = true;
            }
            O2.f(z16);
        }
        this.D.O().h(new b());
        this.C.setConfig(this.D.K(), this.D.O());
    }

    private void wh() {
        QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.vga);
        this.I = qUISingleLineListItem;
        qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.BottomRound);
        this.I.setStyle(QUIListItemStyle.Card);
        this.J = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d("\u7fa4\u6d88\u606f\u632f\u52a8\u63d0\u9192"), new x.c.g("", true, false));
        this.I.setOnClickListener(new e());
        this.I.setConfig(this.J.K(), this.J.O());
    }

    private void xh() {
        QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.vgb);
        this.G = qUISingleLineListItem;
        qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.TopRound);
        this.G.setStyle(QUIListItemStyle.Card);
        this.H = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d("\u6d88\u606f\u632f\u52a8\u63d0\u9192"), new x.c.g("", true, false));
        this.G.setOnClickListener(new d());
        this.G.setConfig(this.H.K(), this.H.O());
    }

    private void yh() {
        QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f165407vu3);
        this.E = qUISingleLineListItem;
        qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.BottomRound);
        this.E.setStyle(QUIListItemStyle.Card);
        boolean z16 = false;
        this.F = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d("\u7fa4\u6d88\u606f\u632f\u52a8\u63d0\u9192"), new x.c.f(false, null, true));
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(th()) == 0) {
            int troopGeneralSettingVibrate = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(th());
            x.c.f O = this.F.O();
            if (troopGeneralSettingVibrate != 0) {
                z16 = true;
            }
            O.f(z16);
        } else {
            x.c.f O2 = this.F.O();
            if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(th()) == 1) {
                z16 = true;
            }
            O2.f(z16);
        }
        this.F.O().h(new c());
        this.E.setConfig(this.F.K(), this.F.O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            String packageName = getBaseActivity().getPackageName();
            try {
                Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
                intent.putExtra("android.provider.extra.CHANNEL_ID", str);
                startActivity(intent);
                if (QLog.isColorLevel()) {
                    QLog.d("IphoneTitleBarFragment", 2, "go to channel setting  notificationChannelId: " + str);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                try {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.fromParts("package", packageName, null));
                    startActivity(intent2);
                    if (QLog.isColorLevel()) {
                        QLog.d("IphoneTitleBarFragment", 2, "go to system setting");
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    QLog.e("IphoneTitleBarFragment", 2, "go to setting fail");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle("\u632f\u52a8");
        initUI();
        com.tencent.qqnt.notification.report.h.o("pg_bas_vibration");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return R.layout.i3b;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        setTitle("\u632f\u52a8");
        return onCreateCenterView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDestroy();
            com.tencent.qqnt.notification.report.h.s("pg_bas_vibration");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        String stringExtra = getActivity().getIntent().getStringExtra(K);
        if (stringExtra != null && stringExtra.equals("\u6d88\u606f\u632f\u52a8\u63d0\u9192")) {
            ((ISettingApi) QRoute.api(ISettingApi.class)).checkAndStartAnimation(this.G);
            ((ISettingApi) QRoute.api(ISettingApi.class)).checkAndStartAnimation(this.C);
        }
        if (stringExtra != null && stringExtra.equals("\u7fa4\u6d88\u606f\u632f\u52a8\u63d0\u9192")) {
            ((ISettingApi) QRoute.api(ISettingApi.class)).checkAndStartAnimation(this.E);
            ((ISettingApi) QRoute.api(ISettingApi.class)).checkAndStartAnimation(this.I);
        }
    }

    public QQAppInterface th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }
}
