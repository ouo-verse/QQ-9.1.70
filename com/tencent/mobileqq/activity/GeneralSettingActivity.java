package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.av.business.handler.MobileNetSwitchHandler;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.newsetting.business.view.GeneralSettingView;
import com.tencent.mobileqq.activity.newsetting.custom.config.a;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.mobileqq.fragment.QQStorageOverviewFragment;
import com.tencent.mobileqq.fragment.overview.QQStorageNewUiFragment;
import com.tencent.mobileqq.fragment.overview.QQStorageOptimizeUiFragment;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.message.ChatHistorySettingFragment;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableColorStateList;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class GeneralSettingActivity extends IphoneTitleBarActivity implements ModeChoiceViewContainer.k {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private GeneralSettingView f176090a0;

    /* renamed from: b0, reason: collision with root package name */
    private TopGestureLayout f176091b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f176092c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f176093d0;

    /* renamed from: e0, reason: collision with root package name */
    QQProgressDialog f176094e0;

    /* renamed from: f0, reason: collision with root package name */
    SimpleUIHandler f176095f0;

    /* renamed from: g0, reason: collision with root package name */
    private ModeChoiceViewContainer f176096g0;

    /* renamed from: h0, reason: collision with root package name */
    MobileNetSwitchHandler f176097h0;

    /* renamed from: i0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.business.group.general.d f176098i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.business.group.general.e f176099j0;

    /* renamed from: k0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.business.group.general.c f176100k0;

    /* renamed from: l0, reason: collision with root package name */
    private RedTouch f176101l0;

    /* renamed from: m0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.business.group.general.b f176102m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f176103n0;

    /* renamed from: o0, reason: collision with root package name */
    View.OnClickListener f176104o0;

    /* renamed from: p0, reason: collision with root package name */
    private final boolean f176105p0;

    /* renamed from: q0, reason: collision with root package name */
    Handler f176106q0;

    /* renamed from: r0, reason: collision with root package name */
    private com.tencent.mobileqq.app.cx f176107r0;

    /* renamed from: s0, reason: collision with root package name */
    private final lu.a f176108s0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GeneralSettingActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            QQProgressDialog qQProgressDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1 && (qQProgressDialog = GeneralSettingActivity.this.f176094e0) != null && qQProgressDialog.isShowing()) {
                    GeneralSettingActivity.this.f176094e0.cancel();
                    GeneralSettingActivity generalSettingActivity = GeneralSettingActivity.this;
                    generalSettingActivity.f176094e0.setMessage(generalSettingActivity.getString(R.string.a3f));
                    GeneralSettingActivity.this.f176094e0.setBackAndSearchFilter(true);
                    GeneralSettingActivity.this.f176094e0.showTipImageView(false);
                    GeneralSettingActivity.this.f176094e0.showProgerss(true);
                    return;
                }
                return;
            }
            if (!GeneralSettingActivity.this.isFinishing()) {
                GeneralSettingActivity generalSettingActivity2 = GeneralSettingActivity.this;
                generalSettingActivity2.f176094e0.setMessage(generalSettingActivity2.getString(R.string.a3d));
                GeneralSettingActivity.this.f176094e0.setTipImageView(R.drawable.setting_icons_correct);
                GeneralSettingActivity.this.f176094e0.showProgerss(false);
            }
            GeneralSettingActivity.this.f176106q0.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.app.cx {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GeneralSettingActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.cx
        public void c(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SecSvcObserver", 2, "onGetPhoneUnityInfo isSuc: " + z16);
            }
            if (GeneralSettingActivity.this.isResume() && bundle != null) {
                String string = bundle.getString("phone");
                StudyModeManager.K(StringUtil.isEmpty(string) ? 1 : 0, string, bundle.getString("mibao_set_url"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends lu.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GeneralSettingActivity.this);
            }
        }

        @Override // lu.a
        public void a(boolean z16, Object obj) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MobileNetSwitchObserver", 2, "onUpdateGetMobileNetSwitch isSuc: " + z16);
            }
            if (z16 && (obj instanceof Integer)) {
                Integer num = (Integer) obj;
                if (num.intValue() == 0 || num.intValue() == 2) {
                    z17 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("MobileNetSwitchObserver", 2, "onUpdateGetMobileNetSwitch switch turnOn: " + z17);
                }
                if (GeneralSettingActivity.this.f176099j0 != null) {
                    GeneralSettingActivity.this.f176099j0.j().a0(z17);
                }
                if (GeneralSettingActivity.this.getIntent() != null && "form_qav".equals(GeneralSettingActivity.this.getIntent().getStringExtra("key_from_where"))) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                ReportController.o(null, "dc00898", "", "", "0X800C2AE", "0X800C2AE", i3, 0, num + "", "", "", "");
                QQAppInterface qQAppInterface = GeneralSettingActivity.this.app;
                if (qQAppInterface != null) {
                    com.tencent.mobileqq.utils.ea.X2(qQAppInterface.getCurrentUin(), z17);
                }
            }
        }

        @Override // lu.a
        public void b(boolean z16, @Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MobileNetSwitchObserver", 2, "onUpdateSetMobileNetSwitch isSuc: " + z16);
            }
            if (z16 && (obj instanceof Boolean)) {
                if (QLog.isColorLevel()) {
                    QLog.i("MobileNetSwitchObserver", 2, "onUpdateSetMobileNetSwitch switch turnOn: " + obj);
                }
                QQAppInterface qQAppInterface = GeneralSettingActivity.this.app;
                if (qQAppInterface != null) {
                    com.tencent.mobileqq.utils.ea.X2(qQAppInterface.getCurrentUin(), ((Boolean) obj).booleanValue());
                }
            }
        }
    }

    public GeneralSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176093d0 = "";
        this.f176103n0 = false;
        this.f176104o0 = new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.ck
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeneralSettingActivity.this.lambda$new$0(view);
            }
        };
        this.f176105p0 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("my_setting_hide_notify_icon_if_disabled_9015", false);
        this.f176106q0 = new a();
        this.f176107r0 = new b();
        this.f176108s0 = new c();
    }

    private void A3() {
        SecSvcHandler secSvcHandler = (SecSvcHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
        if (secSvcHandler != null) {
            secSvcHandler.G2(3);
        }
        KidModeServlet.n(this.app);
    }

    private void B3() {
        ReportController.y(this.app, "0X800B80C");
        ReportController.y(this.app, "0X800B80B");
        ReportController.y(this.app, "0X800B810");
        ReportController.y(this.app, "0X800B80F");
        ReportController.y(this.app, "0X800B80E");
        ReportController.y(this.app, "0X800B80D");
    }

    private void C3() {
        VideoReport.setPageId(this.f176090a0, "pg_bas_general_purpose");
        VideoReport.reportEvent("dt_pgin", this.f176090a0, null);
    }

    private void D3() {
        VideoReport.setPageId(this.f176090a0, "pg_bas_general_purpose");
        VideoReport.reportEvent("dt_pgout", this.f176090a0, null);
    }

    private void E3() {
        if (this.f176098i0 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_general_purpose");
        VideoReport.setElementId(this.f176098i0.m().f183649q, "em_bas_graphic_mode");
        VideoReport.setElementClickPolicy(this.f176098i0.m().f183649q, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", this.f176098i0.m().f183649q, hashMap);
    }

    private void F3() {
        QMMKV.fromV2(this, "common_mmkv_configurations").putBoolean(AppConstants.QQSETTING_NOTIFY_IS_ALREADY_OPEN, true);
    }

    private void G3() {
        if (this.mContentView == null) {
            return;
        }
        Drawable drawable = getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg, null);
        ColorStateList colorStateList = getResources().getColorStateList(R.color.qui_common_bg_bottom_standard, null);
        GeneralSettingView generalSettingView = (GeneralSettingView) this.mContentView.findViewById(R.id.vni);
        if (drawable instanceof SkinnableBitmapDrawable) {
            generalSettingView.setBackground(drawable);
            return;
        }
        int defaultColor = colorStateList.getDefaultColor();
        QLog.e("GeneralSettingActivity", 1, "updateBg error, bg=" + drawable + ", color=" + QUIUtil.toHexEncoding(defaultColor) + ", " + (colorStateList instanceof SkinnableColorStateList));
        generalSettingView.setBackground(new ColorDrawable(defaultColor));
        if (QQTheme.isVasTheme()) {
            this.quiSecNavBar.setBackground(null);
        }
    }

    private void H3() {
        if (this.f176098i0 == null) {
            return;
        }
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.fontCfg.name(), "-1");
        if (QLog.isColorLevel()) {
            QLog.d("GeneralSettingActivity", 2, "current fontSetting dpcValue=" + featureValue);
        }
        if (ElderModeManager.j()) {
            this.f176098i0.k().h0(8);
            return;
        }
        if ("1".equals(featureValue) && FontSettingManager.isDisplayMetricNoAnswer()) {
            this.f176098i0.k().h0(0);
            return;
        }
        if ("0".equals(featureValue)) {
            this.f176098i0.k().h0(8);
            FontSettingManager.revert2SystemDensity(this);
        } else if (FontSettingManager.isSupportDevice()) {
            this.f176098i0.k().h0(0);
        } else {
            this.f176098i0.k().h0(8);
            FontSettingManager.revert2SystemDensity(this);
        }
    }

    private void I3() {
        this.f176102m0.l().f0(com.tencent.mobileqq.activity.lastclean.a.f183343a.b(this.app.getCurrentAccountUin()));
    }

    private void J3() {
        if (this.f176098i0 == null) {
            return;
        }
        if (com.tencent.qqnt.qbasealbum.utils.a.f361642a.a() == 1) {
            this.f176098i0.m().f0(getString(R.string.f1358902o));
        } else {
            this.f176098i0.m().f0(getString(R.string.f158601q2));
        }
    }

    private void V2() {
        boolean z16 = true;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notify_dialog_switch_9070", true) || !com.tencent.common.config.pad.i.b()) {
            z16 = false;
        }
        this.f176103n0 = z16;
    }

    private void W2() {
        if (this.f176098i0 == null) {
            return;
        }
        if (com.tencent.qqnt.qbasealbum.utils.a.f361642a.c()) {
            this.f176098i0.m().h0(0);
            J3();
            this.f176098i0.m().x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.cn
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GeneralSettingActivity.this.h3(view);
                }
            });
            C3();
            return;
        }
        this.f176098i0.m().h0(4);
    }

    private void Y2() {
        this.f176102m0.j().x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.cs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeneralSettingActivity.this.i3(view);
            }
        });
    }

    private void Z2() {
        com.tencent.mobileqq.activity.newsetting.business.group.general.b l3 = this.f176090a0.l();
        this.f176102m0 = l3;
        l3.l().g0(this.f176104o0);
        this.f176102m0.k().R(0);
        this.f176102m0.k().O(getResources().getString(R.string.a1c));
        this.f176102m0.k().Q(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.co
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeneralSettingActivity.this.j3(view);
            }
        });
        this.f176102m0.k().P(new a.InterfaceC7183a() { // from class: com.tencent.mobileqq.activity.cp
            @Override // com.tencent.mobileqq.activity.newsetting.custom.config.a.InterfaceC7183a
            public final void a() {
                GeneralSettingActivity.this.l3();
            }
        });
    }

    private void b3() {
        if (this.f176098i0 == null) {
            return;
        }
        if (DarkModeManager.k()) {
            this.f176098i0.j().h0(0);
            this.f176098i0.j().a0(DarkModeManager.f());
            this.f176098i0.j().e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.cv
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    GeneralSettingActivity.n3(compoundButton, z16);
                }
            });
            ReportController.y(this.app, "0X800B80A");
            return;
        }
        this.f176098i0.j().h0(8);
    }

    private void c3() {
        com.tencent.mobileqq.activity.newsetting.custom.config.b j3 = this.f176090a0.k().j();
        j3.a0(SettingCloneUtil.readValue((Context) this, (String) null, getString(R.string.cyo), AppConstants.QQSETTING_ENTER_SENDMSG_KEY, false));
        j3.e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.ct
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GeneralSettingActivity.this.p3(compoundButton, z16);
            }
        });
    }

    private void d3() {
        com.tencent.mobileqq.activity.newsetting.business.group.general.d j3 = this.f176090a0.j();
        this.f176098i0 = j3;
        if (j3 == null) {
            return;
        }
        j3.k().h0(8);
        this.f176098i0.l().h0(8);
        H3();
        this.f176098i0.k().x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.cr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeneralSettingActivity.this.r3(view);
            }
        });
        b3();
    }

    private void e3() {
        this.f176099j0 = this.f176090a0.n();
        if (com.tencent.av.utils.ax.b()) {
            this.f176099j0.j().h0(0);
            this.f176099j0.j().a0(com.tencent.mobileqq.utils.ea.n2(this.app.getCurrentAccountUin()));
            this.f176099j0.j().e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.cq
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    GeneralSettingActivity.this.s3(compoundButton, z16);
                }
            });
            return;
        }
        this.f176099j0.j().h0(8);
    }

    private void f3() {
        final com.tencent.mobileqq.activity.newsetting.custom.config.b k3 = this.f176090a0.k().k();
        boolean readValue = SettingCloneUtil.readValue((Context) this, (String) null, getString(R.string.hhh), AppConstants.QQSETTING_NOTIFY_ICON_KEY, false);
        k3.a0(readValue);
        if (!readValue && this.f176105p0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("GeneralSettingActivity", 4, "hide on going notify icon");
            }
            k3.h0(8);
        }
        k3.e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.cu
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GeneralSettingActivity.this.v3(k3, compoundButton, z16);
            }
        });
    }

    private boolean g3() {
        return QMMKV.fromV2(this, "common_mmkv_configurations").getBoolean(AppConstants.QQSETTING_NOTIFY_IS_ALREADY_OPEN, false);
    }

    private TopGestureLayout getTopGestureLayout() {
        if (this.f176091b0 == null) {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof DragFrameLayout) {
                viewGroup = (ViewGroup) childAt;
            }
            View childAt2 = viewGroup.getChildAt(0);
            if (childAt2 instanceof TopGestureLayout) {
                this.f176091b0 = (TopGestureLayout) childAt2;
            }
        }
        return this.f176091b0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.qqnt.qbasealbum.a.f360732a.n(this, true);
        E3();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.utils.u.a().b()) {
            PublicFragmentActivity.start(getActivity(), QQSettingAutoDownloadAndSaveFragment.class);
            ReportController.y(this.app, "0X800B872");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void initBlur() {
        if (needBlur()) {
            GeneralSettingView generalSettingView = (GeneralSettingView) this.mContentView.findViewById(R.id.vni);
            RecyclerView e16 = generalSettingView.e(generalSettingView);
            e16.setClipToPadding(false);
            e16.setPadding(0, com.tencent.biz.qui.quisecnavbar.e.b(this.mContentView.getContext()), 0, 0);
            QUISecNavBar qUISecNavBar = this.quiSecNavBar;
            if (qUISecNavBar != null) {
                qUISecNavBar.setBlur(true, generalSettingView);
                this.quiSecNavBar.setTitleBlurAlpha(1.0f);
            }
        }
    }

    private void initUI() {
        GeneralSettingView generalSettingView = (GeneralSettingView) this.mContentView.findViewById(R.id.vni);
        this.f176090a0 = generalSettingView;
        com.tencent.mobileqq.activity.newsetting.business.group.general.c m3 = generalSettingView.m();
        this.f176100k0 = m3;
        if (m3 != null && m3.m() != null) {
            this.f176096g0 = this.f176100k0.m().J();
        }
        Z2();
        d3();
        W2();
        Y2();
        c3();
        e3();
        f3();
        initBlur();
        B3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ReportController.y(this.app, "0X800B871");
        Intent intent = new Intent();
        intent.putExtra("set_display_type", 1);
        PublicFragmentActivity.start(getActivity(), intent, ChatHistorySettingFragment.class);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l3() {
        RedTouch S = this.f176102m0.k().S();
        this.f176101l0 = S;
        if (S != null) {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath("100190.100194");
            this.f176101l0.parseRedTouch(appInfoByPath);
            iRedTouchManager.onReportRedPointExposure(appInfoByPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("100190.100194");
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) this.app.getRuntimeService(IFeatureRuntimeService.class, "all");
        boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable("storage_circle_ui_style");
        boolean isFeatureSwitchEnable2 = iFeatureRuntimeService.isFeatureSwitchEnable("android_storage_ui_upgrade", false);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101382", false);
        Intent intent = new Intent();
        String V = this.f176102m0.l().V();
        if (isFeatureSwitchEnable) {
            intent.putExtra("extra.IMAGE_PROVIDER", new BinderWarpper(AIOImageProviderService.e3(this.app.getCurrentUin(), "", 0, null, false).asBinder()));
            intent.putExtra("OPTIMIZE_STORAGE_UI_KEY", isSwitchOn);
            if (isFeatureSwitchEnable2) {
                if (isSwitchOn) {
                    QPublicFragmentActivity.start(getActivity(), intent, QQStorageOptimizeUiFragment.class);
                    ReportController.o(this.app, "dc00898", "", "", "0X800C1AC", "0X800C1AC", 2, 0, "", "", V, "");
                } else {
                    QPublicFragmentActivity.start(getActivity(), intent, QQStorageNewUiFragment.class);
                    ReportController.o(this.app, "dc00898", "", "", "0X800C1AC", "0X800C1AC", 1, 0, "", "", V, "");
                }
            } else {
                PublicFragmentActivity.start(getActivity(), intent, QQStorageOverviewFragment.class);
            }
        } else {
            intent.putExtra("set_display_type", 1);
            PublicFragmentActivity.start(getActivity(), intent, QQSettingMsgClearFragment.class);
            ReportController.o(this.app, "dc00898", "", "", "0X800B870", "0X800B870", 0, 0, "", "", V, "");
            ReportController.o(this.app, "CliOper", "", "", "Setting_tab", "My_settab_log", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n3(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        DarkModeManager.v(z16);
        if (z16) {
            DarkModeManager.u(null);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p3(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        com.tencent.mobileqq.settings.message.ao.a(this.app, "0X800B874", z16);
        SettingCloneUtil.writeValue(this, (String) null, getString(R.string.cyo), AppConstants.QQSETTING_ENTER_SENDMSG_KEY, z16);
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(AppConstants.QQSETTING_ENTER_SENDMSG_KEY, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        startActivity(new Intent(this, (Class<?>) FontSettingActivity.class));
        ReportController.y(this.app, "0X800B86F");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s3(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (compoundButton.isPressed()) {
            w3(z16);
            if (z16) {
                ReportController.o(null, "dc00898", "", "", "0X800C2B0", "0X800C2B0", 0, 0, "", "", "", "");
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800C2AF", "0X800C2AF", 0, 0, "", "", "", "");
            }
            MobileNetSwitchHandler mobileNetSwitchHandler = this.f176097h0;
            if (mobileNetSwitchHandler != null) {
                mobileNetSwitchHandler.H2(z16);
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t3(DialogInterface dialogInterface, int i3) {
        SettingCloneUtil.writeValue((Context) this, (String) null, getString(R.string.hhh), AppConstants.QQSETTING_NOTIFY_ICON_KEY, true);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u3(com.tencent.mobileqq.activity.newsetting.custom.config.b bVar, DialogInterface dialogInterface, int i3) {
        bVar.a0(false);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v3(final com.tencent.mobileqq.activity.newsetting.custom.config.b bVar, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (this.f176103n0 && z16 && !g3()) {
            DialogUtil.createCustomDialog(this, 230, (String) null, getString(R.string.f225756mh), getString(R.string.f185783pi), getString(R.string.f185793pj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.cl
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GeneralSettingActivity.this.t3(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.cm
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GeneralSettingActivity.u3(com.tencent.mobileqq.activity.newsetting.custom.config.b.this, dialogInterface, i3);
                }
            }).show();
            F3();
        } else {
            SettingCloneUtil.writeValue(this, (String) null, getString(R.string.hhh), AppConstants.QQSETTING_NOTIFY_ICON_KEY, z16);
        }
        com.tencent.mobileqq.settings.message.ao.a(this.app, "0X800B873", z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    public static boolean x3(Context context, AppRuntime appRuntime) {
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable("storage_circle_ui_style");
        boolean isFeatureSwitchEnable2 = iFeatureRuntimeService.isFeatureSwitchEnable("android_storage_ui_upgrade", false);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101382", false);
        Intent intent = new Intent();
        if (isFeatureSwitchEnable) {
            intent.putExtra("extra.IMAGE_PROVIDER", new BinderWarpper(AIOImageProviderService.e3(appRuntime.getCurrentUin(), "", 0, null, false).asBinder()));
            intent.putExtra("OPTIMIZE_STORAGE_UI_KEY", isSwitchOn);
            if (isFeatureSwitchEnable2) {
                if (isSwitchOn) {
                    QPublicFragmentActivity.start(context, intent, QQStorageOptimizeUiFragment.class);
                } else {
                    QPublicFragmentActivity.start(context, intent, QQStorageNewUiFragment.class);
                }
            } else {
                PublicFragmentActivity.start(context, intent, QQStorageOverviewFragment.class);
            }
        } else {
            intent.putExtra("set_display_type", 1);
            PublicFragmentActivity.start(context, intent, QQSettingMsgClearFragment.class);
        }
        return isFeatureSwitchEnable;
    }

    private void z3() {
        MobileNetSwitchHandler mobileNetSwitchHandler;
        if (com.tencent.av.utils.ax.b() && (mobileNetSwitchHandler = this.f176097h0) != null) {
            mobileNetSwitchHandler.D2();
        }
    }

    public void U2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (this.leftView != null) {
            int dpToPx = ViewUtils.dpToPx(20.0f);
            BaseAIOUtils.h(this.leftView, dpToPx, dpToPx, dpToPx, dpToPx);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        ModeChoiceViewContainer modeChoiceViewContainer = this.f176096g0;
        if (modeChoiceViewContainer != null) {
            modeChoiceViewContainer.q(i3, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        V2();
        super.doOnCreate(bundle);
        super.setContentView(R.layout.h3r);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        if (!this.app.isLogin()) {
            Intent intent = new Intent();
            intent.addFlags(262144);
            RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTER_LOGIN);
            super.finish();
            return false;
        }
        super.setTitle(R.string.frw);
        this.f176093d0 = this.app.getCurrentAccountUin();
        super.setVolumeControlStream(3);
        addObserver(this.f176107r0);
        addObserver(this.f176108s0);
        this.f176095f0 = (SimpleUIHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
        this.f176097h0 = (MobileNetSwitchHandler) this.app.getBusinessHandler(MobileNetSwitchHandler.class.getName());
        initUI();
        A3();
        z3();
        U2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f176094e0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            super.dismissDialog(1);
        }
        SimpleUIHandler simpleUIHandler = this.f176095f0;
        if (simpleUIHandler != null) {
            simpleUIHandler.onDestroy();
        }
        super.doOnDestroy();
        D3();
        TopGestureLayout topGestureLayout = getTopGestureLayout();
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchEventListener(null);
        }
        removeObserver(this.f176107r0);
        removeObserver(this.f176108s0);
        ModeChoiceViewContainer modeChoiceViewContainer = this.f176096g0;
        if (modeChoiceViewContainer != null) {
            modeChoiceViewContainer.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnResume();
        y3();
        G3();
        H3();
        J3();
        I3();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.app.nthiddenchat.b.d(this);
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Dialog) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        if (i3 != 1) {
            return super.onCreateDialog(i3);
        }
        this.f176094e0 = null;
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
        this.f176094e0 = qQProgressDialog;
        qQProgressDialog.setMessage(getString(R.string.a3f));
        this.f176094e0.setBackAndSearchFilter(true);
        this.f176094e0.showTipImageView(false);
        this.f176094e0.showProgerss(true);
        return this.f176094e0;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        if (QLog.isColorLevel()) {
            QLog.i("GeneralSettingActivity", 2, String.format("%s onPostThemeChanged", "SimpleUILog"));
        }
        G3();
        W2();
        ModeChoiceViewContainer modeChoiceViewContainer = this.f176096g0;
        if (modeChoiceViewContainer != null) {
            modeChoiceViewContainer.onPostThemeChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return super.getString(R.string.cxo);
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            super.getWindow().addFlags(67108864);
        }
        return super.showPreview();
    }

    @Override // com.tencent.mobileqq.studymode.ModeChoiceViewContainer.k
    public void u1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.newsetting.business.group.general.d dVar = this.f176098i0;
        if (dVar != null) {
            dVar.j().a0(DarkModeManager.f());
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    public void w3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GeneralSettingActivity", 2, "notifyQavMobileSwitch isChecked: " + z16);
        }
        Intent intent = new Intent("com.tencent.av.MOBILE_NET_SWITCH");
        intent.putExtra("key_mobile_net_switch", z16);
        sendBroadcast(intent);
    }

    protected void y3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.f176092c0 && ModeChoiceViewContainer.I(this.app)) {
            return;
        }
        if (getTopGestureLayout() == null) {
            QLog.e("GeneralSettingActivity", 2, "processRvTouchEvent failed! topGestureLayout return null!");
        } else {
            this.f176092c0 = true;
        }
    }
}
