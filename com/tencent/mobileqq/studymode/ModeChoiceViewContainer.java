package com.tencent.mobileqq.studymode;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ElderModeFragment;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.minorsmode.api.IMinorsModeApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.ModeRadioGroup;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.studymode.pwdverify.PwdVerifySuccess;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormItemConstants;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ModeChoiceViewContainer implements l.a, ModeRadioGroup.b, View.OnClickListener, SimpleEventReceiver {
    static IPatchRedirector $redirector_;
    private static HashMap<String, Boolean> P;
    private ImageView C;
    private FormSwitchSimpleItem D;
    private AlphabeticFontHandler E;
    private Dialog F;
    private QQCustomDialog G;
    private k H;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b I;
    private final int J;
    private Observer<Integer> K;
    private final com.tencent.mobileqq.studymode.c L;
    private KidModeObserver M;
    private CompoundButton.OnCheckedChangeListener N;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f290906d;

    /* renamed from: e, reason: collision with root package name */
    private QBaseActivity f290907e;

    /* renamed from: f, reason: collision with root package name */
    private View f290908f;

    /* renamed from: h, reason: collision with root package name */
    private ModeRadioGroup f290909h;

    /* renamed from: i, reason: collision with root package name */
    private FormSwitchSimpleItem f290910i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f290911m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f290916d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f290917e;

        a(int i3, int i16) {
            this.f290916d = i3;
            this.f290917e = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ModeChoiceViewContainer.this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ModeChoiceViewContainer.this.F.dismiss();
                ModeChoiceViewContainer.this.M(this.f290916d, this.f290917e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModeChoiceViewContainer.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ModeChoiceViewContainer.this.F.dismiss();
                ModeChoiceViewContainer.this.f290909h.m(3, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements DarkModeManager.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f290920a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f290921b;

        c(int i3, int i16) {
            this.f290920a = i3;
            this.f290921b = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ModeChoiceViewContainer.this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ModeChoiceViewContainer.this.n(this.f290920a, this.f290921b);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ModeChoiceViewContainer.this.X();
                ModeChoiceViewContainer.this.n(this.f290920a, this.f290921b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d extends com.tencent.mobileqq.studymode.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModeChoiceViewContainer.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.c
        protected void a(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ModeChoiceViewContainer.this.E(z17);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
        }

        @Override // com.tencent.mobileqq.studymode.c
        protected void b(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ModeChoiceViewContainer.this.E(z17);
            } else {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e extends KidModeObserver {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModeChoiceViewContainer.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void c(KidModeObserver.QueryPasswordStateResult queryPasswordStateResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) queryPasswordStateResult);
                return;
            }
            if (queryPasswordStateResult == null) {
                QLog.i("KidModeObserver", 1, "onQueryPasswordState result == null");
                return;
            }
            QLog.i("KidModeObserver", 1, "onQueryPasswordState errCode=" + queryPasswordStateResult.errCode + ",State=" + queryPasswordStateResult.passwordState + ",salt=" + com.tencent.mobileqq.studymode.f.b(queryPasswordStateResult.salt));
            if (queryPasswordStateResult.errCode == 0) {
                StudyModeManager.N(queryPasswordStateResult.passwordState, queryPasswordStateResult.salt);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void d(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (!ModeChoiceViewContainer.this.f290907e.isResume()) {
                if (QLog.isColorLevel()) {
                    QLog.d("KidModeObserver", 2, "onSendGetKidModeStatusSuccess but setting Activity is not resume");
                }
            } else if (z16) {
                StudyModeManager.L(bundle.getInt("KID_MODE_NEED_VERIFY"));
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void f(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            QLog.i("KidModeObserver", 1, "onSendSmsCodeSuccess isSuccess" + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements Observer<Integer> {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class a implements DarkModeManager.e {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Integer f290926a;

            a(Integer num) {
                this.f290926a = num;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) num);
                }
            }

            @Override // com.tencent.mobileqq.theme.DarkModeManager.e
            public void onCancel() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.theme.DarkModeManager.e
            public void onConfirm() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ModeChoiceViewContainer.this.X();
                    ModeChoiceViewContainer.this.B(this.f290926a.intValue());
                }
            }
        }

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModeChoiceViewContainer.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                return;
            }
            if (!DarkModeManager.w(ModeChoiceViewContainer.this.f290907e, SimpleUIUtil.getThemeId(num.intValue()), new a(num))) {
                ModeChoiceViewContainer.this.B(num.intValue());
            }
            ReportController.o(null, "dc00898", "", "", "0X800BF86", "0X800BF86", ModeChoiceViewContainer.this.J, num.intValue() + 1, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class g implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements DarkModeManager.e {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CompoundButton f290929a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f290930b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f290931c;

            a(CompoundButton compoundButton, boolean z16, int i3) {
                this.f290929a = compoundButton;
                this.f290930b = z16;
                this.f290931c = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, g.this, compoundButton, Boolean.valueOf(z16), Integer.valueOf(i3));
                }
            }

            @Override // com.tencent.mobileqq.theme.DarkModeManager.e
            public void onCancel() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else {
                    ModeChoiceViewContainer.this.Q(this.f290929a, false);
                }
            }

            @Override // com.tencent.mobileqq.theme.DarkModeManager.e
            public void onConfirm() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ModeChoiceViewContainer.this.X();
                    ModeChoiceViewContainer.this.w(this.f290929a, true, this.f290930b, this.f290931c);
                }
            }
        }

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModeChoiceViewContainer.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                boolean isChecked = ModeChoiceViewContainer.this.f290910i.getSwitch().isChecked();
                boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(ModeChoiceViewContainer.this.f290906d, false, null);
                int simpleUIPref = SimpleUIUtil.getSimpleUIPref();
                if (isChecked && isNowThemeIsNight) {
                    simpleUIPref = SimpleUIUtil.INDEX_OF_SIMPLE_UI_NIGHT;
                } else if (isChecked && ThemeUtil.isNowThemeIsNight(ModeChoiceViewContainer.this.f290906d, false, SimpleUIUtil.getThemeId(simpleUIPref))) {
                    simpleUIPref = SimpleUIUtil.getSimpleNoNightUIPref();
                }
                if (!z16) {
                    ModeChoiceViewContainer.this.w(compoundButton, false, isChecked, simpleUIPref);
                } else if (!DarkModeManager.w(ModeChoiceViewContainer.this.f290907e, SimpleUIUtil.getThemeId(simpleUIPref), new a(compoundButton, isChecked, simpleUIPref))) {
                    ModeChoiceViewContainer.this.w(compoundButton, true, isChecked, simpleUIPref);
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f290933d;

        h(Runnable runnable) {
            this.f290933d = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModeChoiceViewContainer.this, (Object) runnable);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (dialogInterface instanceof QQCustomDialog) {
                ((QQCustomDialog) dialogInterface).setOnDismissListener(null);
            }
            this.f290933d.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class i implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModeChoiceViewContainer.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ElderModeFragment.Dh(ModeChoiceViewContainer.this.f290907e, 3);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class j implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModeChoiceViewContainer.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("ModeChoiceViewContainer", 2, "mKidModeChatPINYINSwitch click, isChecked=", Boolean.valueOf(z16));
                }
                ModeChoiceViewContainer.this.E.H2(z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface k {
        void u1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class l implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<ModeChoiceViewContainer> f290937d;

        /* renamed from: e, reason: collision with root package name */
        WeakReference<CompoundButton> f290938e;

        l(ModeChoiceViewContainer modeChoiceViewContainer, CompoundButton compoundButton) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) modeChoiceViewContainer, (Object) compoundButton);
            } else {
                this.f290937d = new WeakReference<>(modeChoiceViewContainer);
                this.f290938e = new WeakReference<>(compoundButton);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ModeChoiceViewContainer modeChoiceViewContainer;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            WeakReference<ModeChoiceViewContainer> weakReference = this.f290937d;
            CompoundButton compoundButton = null;
            if (weakReference == null) {
                modeChoiceViewContainer = null;
            } else {
                modeChoiceViewContainer = weakReference.get();
            }
            WeakReference<CompoundButton> weakReference2 = this.f290938e;
            if (weakReference2 != null) {
                compoundButton = weakReference2.get();
            }
            if (modeChoiceViewContainer != null && compoundButton != null) {
                modeChoiceViewContainer.Q(compoundButton, false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75703);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            P = new HashMap<>();
        }
    }

    public ModeChoiceViewContainer(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, com.tencent.mobileqq.activity.newsetting.business.group.general.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, qBaseActivity, cVar);
            return;
        }
        this.L = new d();
        this.M = new e();
        this.N = new g();
        if (cVar != null) {
            com.tencent.mobileqq.activity.newsetting.custom.config.b l3 = cVar.l();
            this.I = l3;
            R(l3, 8);
        }
        this.f290906d = qQAppInterface;
        this.f290907e = qBaseActivity;
        this.J = I(qQAppInterface) ? 1 : 2;
        L();
    }

    private void A(boolean z16, boolean z17, boolean z18) {
        boolean z19;
        if (QLog.isColorLevel()) {
            QLog.d("ModeChoiceViewContainer", 2, "handleModeSelectRadioByRequest");
        }
        if (StudyModeManager.i() && this.f290909h != null) {
            int b16 = com.tencent.mobileqq.studymode.g.b(z16, z17, z18);
            ModeRadioGroup modeRadioGroup = this.f290909h;
            if (b16 == 3) {
                z19 = true;
            } else {
                z19 = false;
            }
            modeRadioGroup.m(b16, z19, false);
        }
        p(z16, SimpleUIUtil.getSimpleUIPref());
    }

    private void D() {
        com.tencent.mobileqq.studymode.l F = F();
        View findViewById = this.f290908f.findViewById(R.id.zcy);
        this.f290908f.setBackground(com.tencent.mobileqq.widget.o.g(this.f290907e.getResources(), 0, false));
        Y();
        this.f290911m.setOnClickListener(new i());
        if (StudyModeManager.i()) {
            this.f290910i.setVisibility(8);
            findViewById.setVisibility(0);
            this.f290909h.setVisibility(0);
            this.f290909h.setOnCheckChangeListener(this);
        } else {
            this.f290910i.setVisibility(0);
            findViewById.setVisibility(8);
            this.f290909h.setVisibility(8);
        }
        boolean isNowSimpleMode = SimpleUIUtil.isNowSimpleMode();
        this.f290910i.a().setVisibility(8);
        p(isNowSimpleMode, SimpleUIUtil.getSimpleUIPref());
        if (StudyModeManager.t()) {
            R(this.I, 0);
            E(this.E.D2());
        } else {
            R(this.I, 8);
            this.D.setVisibility(8);
        }
        QLog.d("ModeChoiceViewContainer", 1, "[KidMode] configSwitch: ", Boolean.valueOf(StudyModeManager.t()), " isSwitch: ", Boolean.valueOf(m.c(F)), " manager TargetType: ", Integer.valueOf(m.b(F)));
        if (StudyModeManager.i() && m.c(F)) {
            this.f290909h.i(false);
            if (com.tencent.mobileqq.studymode.g.a() == 1 && m.b(F) == 1) {
                this.f290909h.m(m.b(F), false, false);
            } else {
                this.f290909h.m(m.b(F), false, true);
            }
        } else {
            SimpleUIHandler simpleUIHandler = (SimpleUIHandler) this.f290906d.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
            simpleUIHandler.Z2();
            simpleUIHandler.a3();
            if (StudyModeManager.i()) {
                this.f290909h.m(com.tencent.mobileqq.studymode.g.a(), false, false);
            } else {
                Q(this.f290910i.getSwitch(), isNowSimpleMode);
            }
        }
        this.D.setOnCheckedChangeListener(new j());
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.I;
        if (bVar != null) {
            bVar.x(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z16) {
        FormSwitchSimpleItem formSwitchSimpleItem = this.D;
        if (formSwitchSimpleItem != null) {
            formSwitchSimpleItem.setChecked(z16);
        }
    }

    @NonNull
    private com.tencent.mobileqq.studymode.l F() {
        com.tencent.mobileqq.studymode.l lVar = (com.tencent.mobileqq.studymode.l) this.f290906d.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
        m.f(lVar, com.tencent.mobileqq.studymode.g.a());
        m.a(lVar, this);
        return lVar;
    }

    private boolean H(FormSwitchSimpleItem formSwitchSimpleItem) {
        TextView a16 = formSwitchSimpleItem.a();
        if (a16 == null || !(a16.getTag() instanceof Animatable)) {
            return false;
        }
        return true;
    }

    public static boolean I(AppInterface appInterface) {
        return n.f291004a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i3, int i16) {
        int i17;
        if (i16 == 2) {
            JumpKidModeMgr b16 = JumpKidModeMgr.b();
            QBaseActivity qBaseActivity = this.f290907e;
            if (this.J == 1) {
                i17 = 1;
            } else {
                i17 = 2;
            }
            b16.i(i16, i3, qBaseActivity, 2, i17, false);
            return;
        }
        if (i3 == 2) {
            y(i16, i3, 2);
        } else {
            r(i3, i16);
        }
    }

    private void N() {
        KidModeServlet.m(this.f290906d);
    }

    private void O(int i3, int i16) {
        String str;
        String s16 = s(i16);
        if (i16 == 1) {
            str = String.valueOf(SimpleUIUtil.getSimpleUIPref() + 1);
        } else {
            str = "";
        }
        String str2 = str;
        if (i3 == 2) {
            ReportController.o(null, "dc00898", "", "", "0X800B86D", "0X800B86D", this.J, 0, s16, str2, "", "");
        } else if (i3 == 1) {
            ReportController.o(null, "dc00898", "", "", "0X800B86C", "0X800B86C", this.J, 0, s16, str2, "", "");
        } else if (i3 == 0) {
            ReportController.o(null, "dc00898", "", "", "0X800B86B", "0X800B86B", this.J, 0, s16, str2, "", "");
        }
    }

    private void R(com.tencent.mobileqq.activity.newsetting.custom.config.b bVar, int i3) {
        if (bVar == null) {
            return;
        }
        bVar.h0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void T(boolean z16, FormSwitchSimpleItem formSwitchSimpleItem) {
        TextView a16 = formSwitchSimpleItem.a();
        if (a16 == null) {
            return;
        }
        if (z16) {
            a16.setVisibility(0);
            Drawable drawable = this.f290907e.getResources().getDrawable(R.drawable.common_loading6);
            a16.setTag(drawable);
            int f16 = BaseAIOUtils.f(19.0f, this.f290907e.getResources());
            drawable.setBounds(0, 0, f16, f16);
            a16.setCompoundDrawables(null, null, drawable, null);
            ((Animatable) drawable).start();
        } else {
            Object obj = (Drawable) a16.getTag();
            if (obj instanceof Animatable) {
                ((Animatable) obj).stop();
            }
            a16.setTag(null);
            a16.setVisibility(8);
            a16.setCompoundDrawables(null, null, null, null);
        }
        this.f290910i.getSwitch().setEnabled(!z16);
    }

    private void U(boolean z16, int i3, int i16, boolean z17) {
        if (z16) {
            if (i3 == 2 && !z17) {
                ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startKidModeAdvanceSettingFragmentForResult(this.f290907e, true, 5);
                return;
            } else {
                r(i16, i3);
                return;
            }
        }
        z("verify cancel", i16);
    }

    private void V(int i3, Intent intent) {
        if (intent == null) {
            QLog.i("ModeChoiceViewContainer", 1, "doOnActivityResult REQ_ENTER_STUDY_MODEL_FRONT_PAGE params exception, data is null");
            return;
        }
        int intExtra = intent.getIntExtra("extra_target_mode", -1);
        int intExtra2 = intent.getIntExtra("extra_old_mode", -1);
        int intExtra3 = intent.getIntExtra("extra_source", -1);
        boolean booleanExtra = intent.getBooleanExtra("key_is_jump_to_next", false);
        boolean booleanExtra2 = intent.getBooleanExtra("extra_mode_change_success", false);
        QLog.i("ModeChoiceViewContainer", 1, "doOnActivityResult REQ_ENTER_STUDY_MODEL_FRONT_PAGE resultCode=" + i3 + ", targetMode: " + intExtra + ", oldMode: " + intExtra2 + ", src: " + intExtra3 + ", jumpToNext: " + booleanExtra + ", modeChangeSuc:" + booleanExtra2);
        if (intExtra != -1 && intExtra2 != -1 && intExtra3 != -1) {
            if (intExtra3 == 5 && !booleanExtra2) {
                ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startKidModeAdvanceSettingFragment(this.f290907e, false, null);
                return;
            }
            int i16 = 2;
            if (intExtra == 2) {
                if (i3 != -1) {
                    z("front page cancel", intExtra2);
                    return;
                }
                if (booleanExtra2) {
                    if (booleanExtra) {
                        ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startKidModeAdvanceSettingFragmentForResult(this.f290907e, true, 5);
                        return;
                    }
                    JumpKidModeMgr b16 = JumpKidModeMgr.b();
                    QBaseActivity qBaseActivity = this.f290907e;
                    if (this.J == 1) {
                        i16 = 1;
                    }
                    b16.i(intExtra2, intExtra, qBaseActivity, intExtra3, i16, false);
                    return;
                }
                return;
            }
            if (i3 != -1 && intExtra3 == 2) {
                z("front page cancel", intExtra2);
            }
        }
    }

    private void W(int i3, Intent intent) {
        int i16;
        int i17;
        boolean h16 = JumpKidModeMgr.b().h();
        int d16 = JumpKidModeMgr.b().d();
        int c16 = JumpKidModeMgr.b().c();
        if (intent != null) {
            i17 = intent.getIntExtra("ExtraTargetAction", -1);
            i16 = intent.getIntExtra("extra_source", -1);
        } else {
            i16 = -1;
            i17 = -1;
        }
        boolean z16 = true;
        QLog.i("ModeChoiceViewContainer", 1, "doOnActivityResult REQ_CHANGE_STUDY_MODEL_SWITCH resultCode=" + i3 + ",lastTargetMode=" + d16 + ",lastOldMode=" + c16 + ",isJumpToStudyPwdVerify=" + h16 + ", action=" + i17 + ", src=" + i16);
        if (d16 != -1 && c16 != -1) {
            if (i3 != -1 || !StudyModeManager.z(i17, i16)) {
                if (i3 != -1) {
                    z16 = false;
                }
                U(z16, d16, c16, h16);
            }
        }
    }

    private void Y() {
        int i3;
        TextView textView = this.f290911m;
        if (ElderModeManager.j()) {
            i3 = R.string.f167952eb;
        } else {
            i3 = R.string.f167972ed;
        }
        textView.setText(i3);
        this.f290911m.setVisibility(0);
    }

    private void Z() {
        ImageView imageView = (ImageView) this.f290908f.findViewById(R.id.f83764kf);
        this.C = imageView;
        imageView.setVisibility(0);
        this.C.setImageDrawable(this.f290907e.getDrawable(R.drawable.qui_mode_selection));
    }

    private void a0(int i3, boolean z16) {
        if (z16) {
            this.f290909h.p(1);
        } else {
            this.f290909h.r(r.e(this.f290906d, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i3, int i16) {
        o(i3, i16, true, false);
    }

    private String t() {
        return this.f290907e.getResources().getString(r.d());
    }

    private String u(int i3, Object... objArr) {
        return this.f290907e.getResources().getString(i3, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(CompoundButton compoundButton, boolean z16, boolean z17, int i3) {
        String str;
        if (!AppNetConnInfo.isNetSupport()) {
            J(R.string.cjm, 1);
            Q(compoundButton, !z16);
            return;
        }
        if (compoundButton == this.f290910i.getSwitch()) {
            if (H(this.f290910i)) {
                Q(compoundButton, !z16);
                return;
            }
            Runnable runnable = new Runnable(z17, i3, compoundButton, z16) { // from class: com.tencent.mobileqq.studymode.ModeChoiceViewContainer.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f290912d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f290913e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ CompoundButton f290914f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f290915h;

                {
                    this.f290912d = z17;
                    this.f290913e = i3;
                    this.f290914f = compoundButton;
                    this.f290915h = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ModeChoiceViewContainer.this, Boolean.valueOf(z17), Integer.valueOf(i3), compoundButton, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (!((SimpleUIHandler) ModeChoiceViewContainer.this.f290906d.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).h3(this.f290912d, this.f290913e, true)) {
                        ModeChoiceViewContainer.this.J(R.string.f173120hi3, 0);
                        ModeChoiceViewContainer.this.Q(this.f290914f, !this.f290915h);
                    } else {
                        ModeChoiceViewContainer modeChoiceViewContainer = ModeChoiceViewContainer.this;
                        modeChoiceViewContainer.T(true, modeChoiceViewContainer.f290910i);
                    }
                }
            };
            if (z16) {
                SharedPreferences uinThemePreferences = ThemeUtil.getUinThemePreferences(this.f290906d);
                if (uinThemePreferences.getBoolean(ThemeConstants.KEY_SIMPLE_SHOULD_SHOW_SWITCH_DIALOG, true)) {
                    uinThemePreferences.edit().putBoolean(ThemeConstants.KEY_SIMPLE_SHOULD_SHOW_SWITCH_DIALOG, false).apply();
                    QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.f290907e, u(R.string.hhy, t()), 0, R.string.vrh, new h(runnable), null);
                    this.G = createNoTitleDialog;
                    createNoTitleDialog.setOnDismissListener(new l(this, compoundButton));
                    this.G.show();
                } else {
                    runnable.run();
                }
            } else {
                runnable.run();
            }
            if (z16) {
                str = "0X800A0FC";
            } else {
                str = "0X800A0FD";
            }
            String str2 = str;
            ReportController.o(this.f290906d, "dc00898", "", "", str2, str2, SimpleUIUtil.getSimpleUIPref(), 0, "0", "0", "", "");
        }
    }

    private void x() {
        if (!JumpKidModeMgr.b().l(-1, -1, 1, this.f290906d, this.f290907e, 2)) {
            J(R.string.cjm, 1);
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void Aa(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.d("ModeChoiceViewContainer", 1, "onModeChangeStart curType : " + i3 + ", oldType : " + i16);
        this.f290909h.i(false);
    }

    protected void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            J(R.string.cjm, 1);
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.cjm, 0).show(this.f290907e.getTitleBarHeight());
            return;
        }
        if (StudyModeManager.i()) {
            o(1, i3, false, true);
        } else if (!((SimpleUIHandler) this.f290906d.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).h3(this.f290910i.getSwitch().isChecked(), i3, false)) {
            J(R.string.f173120hi3, 0);
        } else {
            a0(i3, true);
        }
        ReportController.o(this.f290906d, "dc00898", "", "", "0X800A3D6", "0X800A3D6", i3 + 1, 0, "0", "0", "", "");
    }

    protected void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f290910i.setText(t());
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void C6(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), obj);
            return;
        }
        if (obj == null) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length != 5) {
            return;
        }
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
        int intValue = ((Integer) objArr[2]).intValue();
        String str = (String) objArr[3];
        boolean booleanValue3 = ((Boolean) objArr[4]).booleanValue();
        if (QLog.isColorLevel()) {
            QLog.i("ModeChoiceViewContainer", 2, String.format("onReqGetSimpleUISwitch suc=%b [%b,%d] %b, %b", Boolean.valueOf(z16), Boolean.valueOf(booleanValue), Integer.valueOf(intValue), Boolean.valueOf(booleanValue2), Boolean.valueOf(booleanValue3)));
        }
        if (!z16 || !this.f290906d.getCurrentAccountUin().equals(str) || H(this.f290910i)) {
            return;
        }
        SimpleUIUtil.setSimpleUIPrefInt(intValue);
        A(booleanValue, booleanValue2, booleanValue3);
    }

    protected void G(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        View inflate = View.inflate(context, R.layout.h4b, null);
        this.f290908f = inflate;
        this.f290909h = (ModeRadioGroup) inflate.findViewById(R.id.vql);
        this.f290910i = (FormSwitchSimpleItem) this.f290908f.findViewById(R.id.iwc);
        this.D = (FormSwitchSimpleItem) this.f290908f.findViewById(R.id.ybr);
        this.f290911m = (TextView) this.f290908f.findViewById(R.id.zcw);
        if (TokenResUtils.useTokenRes4()) {
            Drawable drawable = this.f290907e.getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01);
            drawable.setBounds(0, 0, FormItemConstants.WIDTH_DEFAULT_ARROW, FormItemConstants.HEIGHT_DEFAULT_ARROW);
            this.f290911m.setCompoundDrawables(null, null, drawable, null);
        }
        D();
        P();
        C();
        Z();
    }

    void J(int i3, int i16) {
        QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show(this.f290907e.getTitleBarHeight());
    }

    void K(String str, int i3) {
        QQToast.makeText(BaseApplication.getContext(), i3, str, 0).show(this.f290907e.getTitleBarHeight());
    }

    protected void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.studymode.e eVar = (com.tencent.mobileqq.studymode.e) new ViewModelProvider(this.f290907e).get(com.tencent.mobileqq.studymode.e.class);
        this.K = new f();
        eVar.L1().observe(this.f290907e, this.K);
        this.E = (AlphabeticFontHandler) this.f290906d.getBusinessHandler(BusinessHandlerFactory.TEENS_MODE_ALPHABETIC_FONT_HANDLER);
        this.f290906d.addObserver(this.L);
        this.f290906d.registObserver(this.M);
        G(this.f290907e);
        N();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    protected void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800B807", "0X800B807", this.J, 0, "", "", "", "");
        ReportController.o(null, "dc00898", "", "", "0X800B808", "0X800B808", this.J, 0, "", "", "", "");
        ReportController.o(null, "dc00898", "", "", "0X800B809", "0X800B809", this.J, 0, "", "", "", "");
    }

    protected void Q(CompoundButton compoundButton, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, compoundButton, Boolean.valueOf(z16));
            return;
        }
        compoundButton.setOnCheckedChangeListener(null);
        compoundButton.setChecked(z16);
        compoundButton.setOnCheckedChangeListener(this.N);
    }

    public void S(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Dialog dialog = this.F;
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        QBaseActivity qBaseActivity = this.f290907e;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 0, qBaseActivity.getResources().getString(R.string.bbh), this.f290907e.getResources().getString(R.string.bbf), R.string.bbe, R.string.bbg, new a(i16, i3), new b());
        this.F = createCustomDialog;
        createCustomDialog.show();
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void W1(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.d("ModeChoiceViewContainer", 1, "onSelectModeRecover curType : " + i3 + ", oldType : " + i16);
        J(R.string.hhx, 1);
        this.f290909h.i(true);
        this.f290909h.m(i16, false, false);
        this.f290909h.d(i3);
        if (i16 == 1) {
            z16 = true;
        }
        p(z16, SimpleUIUtil.getSimpleUIPref());
    }

    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        k kVar = this.H;
        if (kVar != null) {
            kVar.u1();
        }
    }

    @Override // com.tencent.mobileqq.studymode.ModeRadioGroup.b
    public void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("ModeChoiceViewContainer", 1, "onModeCheckedChanged targetType : " + i3 + ", oldType : " + i16);
        O(i3, i16);
        if (ElderModeManager.j() && i3 != 3 && ElderModeManager.d() != 18.0f) {
            S(i3, i16);
        } else {
            M(i16, i3);
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void ed(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.d("ModeChoiceViewContainer", 1, "onModeSwitching curType : " + i3 + ", oldType : " + i16);
        this.f290909h.m(i3, false, true);
        this.f290909h.i(false);
        if (i16 == 1) {
            z16 = true;
        }
        p(z16, SimpleUIUtil.getSimpleUIPref());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (ArrayList) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(PwdVerifySuccess.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void j7(boolean z16, int i3, int i16, String str) {
        boolean z17;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        QLog.d("ModeChoiceViewContainer", 1, "onModeChangeComplete isSuccess : " + z16 + ", curType : " + i3 + ", oldType : " + i16 + ", message:" + str);
        if (!TextUtils.isEmpty(str)) {
            QBaseActivity qBaseActivity = this.f290907e;
            if (z16) {
                i17 = 2;
            } else {
                i17 = 1;
            }
            QQToast.makeText(qBaseActivity, i17, str, 0).show();
        }
        this.f290909h.i(true);
        this.f290909h.d(i3);
        Y();
        if (z16) {
            this.f290909h.m(i3, false, false);
            if (i3 == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            p(z17, SimpleUIUtil.getSimpleUIPref());
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.studymode.ModeChoiceViewContainer.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ModeChoiceViewContainer.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QZoneHelper.killQZoneProcess();
                    }
                }
            }, 16, null, false);
            if (i3 != 2) {
                R(this.I, 8);
                this.D.setVisibility(8);
            } else {
                R(this.I, 0);
                E(this.E.D2());
            }
            if ((i3 == 2 || i16 == 2) && ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable(TabDataHelper.TAB_FEATURE_GUILD_UPDATE)) {
                try {
                    QLog.d("ModeChoiceViewContainer", 1, "updateGuildTabStatus");
                    ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).updateGuildTabStatus();
                } catch (Exception e16) {
                    QLog.e("ModeChoiceViewContainer", 1, "updateGuildTabStatus error: " + e16);
                }
            }
        } else {
            this.f290909h.m(i16, false, false);
            if (i16 == 1) {
                z18 = true;
            }
            p(z18, SimpleUIUtil.getSimpleUIPref());
        }
        ElderModeManager.m(z16, i3, i16, this.f290907e);
        com.tencent.mobileqq.splashad.config.c.a().f();
    }

    public void o(int i3, int i16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        com.tencent.mobileqq.studymode.l lVar = (com.tencent.mobileqq.studymode.l) this.f290906d.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
        if (lVar == null) {
            QLog.i("ModeChoiceViewContainer", 1, "manager is null, changeMode targetMode: " + i3 + ", finalBPref: " + i16 + ", bSwitchElsePref:" + z16 + ", isColor" + z17 + " failed!!! stack:" + QLog.getStackTraceString(new Throwable()));
            return;
        }
        boolean o16 = lVar.o();
        l.b f16 = lVar.f(this.f290907e, i3, i16, z16);
        if (this.f290909h == null) {
            return;
        }
        if (f16.c()) {
            QLog.d("ModeChoiceViewContainer", 1, "changeMode switchingStatus.isSwitching : true , mode : " + f16.b());
            if (z17) {
                a0(i16, true);
                this.f290909h.i(false);
            }
            this.f290909h.m(f16.b(), false, !z17);
            if (o16) {
                QQToast.makeText(BaseApplication.getContext(), 0, R.string.f173120hi3, 0).show();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ModeChoiceViewContainer", 2, "changeMode switchingStatus.isSwitching : false , mode : " + f16.a());
        }
        this.f290909h.m(f16.a(), false, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else {
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.I;
            if (bVar != null && bVar.X(view)) {
                x();
                ReportController.o(null, "dc00898", "", "", "0X800BD9C", "0X800BD9C", this.J, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.G;
        if (qQCustomDialog != null) {
            qQCustomDialog.setOnDismissListener(null);
            if (this.G.isShowing()) {
                this.G.cancel();
            }
        }
        com.tencent.mobileqq.studymode.l lVar = (com.tencent.mobileqq.studymode.l) this.f290906d.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
        m.e(lVar, this);
        m.d(lVar);
        if (this.K != null) {
            ((com.tencent.mobileqq.studymode.e) new ViewModelProvider(this.f290907e).get(com.tencent.mobileqq.studymode.e.class)).L1().removeObserver(this.K);
            this.K = null;
        }
        this.f290906d.removeObserver(this.L);
        this.f290906d.unRegistObserver(this.M);
        if (JumpKidModeMgr.b().r()) {
            KidModeServlet.p(this.f290906d, null);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f290909h.l();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof PwdVerifySuccess) {
            boolean h16 = JumpKidModeMgr.b().h();
            int d16 = JumpKidModeMgr.b().d();
            int c16 = JumpKidModeMgr.b().c();
            QLog.i("ModeChoiceViewContainer", 1, "onReceiveEvent, pwd verify suc, targetMode=" + d16 + ",oldMode=" + c16 + ",isJumpToStudyPwdVerify=" + h16);
            if (d16 != -1 && c16 != -1) {
                U(true, d16, c16, h16);
            }
        }
    }

    public void p(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ModeChoiceViewContainer", 1, "checkNeedShowSimpleUIChoice switch: ", Boolean.valueOf(z16), " bPref: ", Integer.valueOf(i3));
        }
        if (z16 && i3 == 0 && (i3 = SimpleModeHelper.g()) != 0) {
            SimpleUIUtil.setSimpleUIPrefInt(i3);
        }
        this.f290909h.setCurrentColorTextVisible(z16);
        a0(i3, false);
    }

    public void q(int i3, int i16, Intent intent) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (intent != null && p.f(intent.getIntExtra("extra_source", -1))) {
            QLog.d("ModeChoiceViewContainer", 1, "doOnActivityResult is from OuterBizToCheckPwd, return directly");
            return;
        }
        if (i3 == 2) {
            W(i16, intent);
            return;
        }
        if (i3 == 3) {
            QLog.i("ModeChoiceViewContainer", 1, "doOnActivityResult elder resultCode=" + i16);
            if (i16 == -1) {
                Y();
                this.f290909h.m(com.tencent.mobileqq.studymode.g.a(), false, false);
                return;
            }
            return;
        }
        if (i3 == 4) {
            V(i16, intent);
            return;
        }
        if (i3 == 5) {
            if (intent == null) {
                QLog.i("ModeChoiceViewContainer", 1, "doOnActivityResult REQ_ENTER_ADVANCED_SETTINGS_PAGE params exception, data is null");
                return;
            }
            int intExtra = intent.getIntExtra("extra_target_mode", -1);
            int intExtra2 = intent.getIntExtra("extra_old_mode", -1);
            int intExtra3 = intent.getIntExtra("extra_source", -1);
            QLog.i("ModeChoiceViewContainer", 1, "doOnActivityResult REQ_ENTER_ADVANCED_SETTINGS_PAGE resultCode=" + i16 + ", data: " + intent + ", targetMode: " + intExtra + ", oldMode: " + intExtra2 + ", src: " + intExtra3);
            if (intExtra != -1 && intExtra2 != -1 && intExtra3 != -1 && i16 == -1 && intExtra3 == 5) {
                JumpKidModeMgr b16 = JumpKidModeMgr.b();
                QBaseActivity qBaseActivity = this.f290907e;
                if (this.J == 1) {
                    i17 = 1;
                } else {
                    i17 = 2;
                }
                b16.i(intExtra, intExtra2, qBaseActivity, intExtra3, i17, false);
            }
        }
    }

    protected void r(int i3, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        ThemeUtil.isNowThemeIsNight(this.f290906d, false, null);
        int e16 = r.e(this.f290906d, z16);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("elder_to_simple_mode_8990_116300199", true) && i3 == 3 && i16 == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i("ModeChoiceViewContainer", 1, "appRuntime is null, can not update bPref for ModeConstantsKt.MODE_TYPE_ELDER");
            } else {
                String f16 = ElderModeManager.f(peekAppRuntime);
                if (!QQTheme.isThemeSimpleUI(f16)) {
                    QLog.i("ModeChoiceViewContainer", 1, "update bPref for ModeConstantsKt.MODE_TYPE_ELDER, bPref:" + e16 + ", oldMode:" + i3 + " -> targetType:" + i16 + ", but lastThemeId is not SimpleTheme");
                } else {
                    e16 = Math.max(SimpleUIUtil.getPrefByThemeId(f16), 0);
                    QLog.i("ModeChoiceViewContainer", 1, "update bPref for ModeConstantsKt.MODE_TYPE_ELDER, bPref:" + e16 + ", oldMode:" + i3 + " -> targetType:" + i16);
                }
            }
        }
        if (z16) {
            if (!DarkModeManager.w(this.f290907e, SimpleUIUtil.getThemeId(e16), new c(i16, e16))) {
                n(i16, e16);
                return;
            }
            return;
        }
        n(i16, e16);
    }

    protected String s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this, i3);
        }
        if (i3 == 0) {
            return "1";
        }
        if (i3 == 1) {
            return "3";
        }
        if (i3 == 2) {
            return "4";
        }
        return "";
    }

    public View v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f290908f;
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void wa(boolean z16, boolean z17, boolean z18, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ModeChoiceViewContainer", 2, String.format("%s onSwitchSimpleUICallback suc=%b bSwitchElsePref=%b hasChange=%b statusCode=%d", "SimpleUILog", Boolean.valueOf(z16), Boolean.valueOf(z18), Boolean.valueOf(z17), Integer.valueOf(i3)));
        }
        if (z18) {
            boolean isChecked = this.f290910i.getSwitch().isChecked();
            if (z16) {
                if (isChecked) {
                    K(u(R.string.f173118hi0, t(), HardCodeUtil.qqStr(R.string.n27)), 2);
                }
            } else {
                Q(this.f290910i.getSwitch(), SimpleUIUtil.getSimpleUISwitch());
                if (isChecked) {
                    i16 = R.string.f172061n25;
                } else {
                    i16 = R.string.n26;
                }
                String qqStr = HardCodeUtil.qqStr(i16);
                String u16 = u(R.string.hhz, t(), qqStr);
                if (1 == i3) {
                    u16 = t() + qqStr + HardCodeUtil.qqStr(R.string.f172059n23);
                } else if (6 == i3) {
                    u16 = u16 + HardCodeUtil.qqStr(R.string.f172057n21);
                }
                K(u16, 1);
            }
        } else if (!z16) {
            J(R.string.hhx, 1);
        }
        T(false, this.f290910i);
        p(SimpleUIUtil.getSimpleUISwitch(), SimpleUIUtil.getSimpleUIPref());
        if (z16) {
            QZoneHelper.killQZoneProcess();
        }
    }

    protected void y(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else if (!JumpKidModeMgr.b().f(i3, i16, this.f290906d, this.f290907e, i17)) {
            J(R.string.cjm, 1);
            z("handleChangeKidModeSwitch failed", i16);
        }
    }

    protected void z(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, i3);
            return;
        }
        boolean z16 = false;
        this.f290909h.m(i3, false, false);
        if (i3 == 1) {
            z16 = true;
        }
        p(z16, SimpleUIUtil.getSimpleUIPref());
        QLog.i("ModeChoiceViewContainer", 1, "handleChangeKidModeSwitchFailed tagPrefix=" + str + ",oldType=" + i3);
    }
}
