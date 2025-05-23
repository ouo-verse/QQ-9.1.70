package com.tencent.mobileqq.settings.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activitymodule.ScreenShotActivityModule;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi;
import com.tencent.mobileqq.cardcontainer.data.CardContainerSwitchState;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.perf.startup.SpeedUpUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.fragment.AssistantMoreSettingFragment;
import com.tencent.mobileqq.settings.message.ao;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AssistantMoreSettingFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private FormSwitchItem C;
    private ActivateFriendsManager D;
    private FormSwitchItem E;
    private FormSwitchItem F;
    private FormSwitchItem G;
    private final CardObserver H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.settings.fragment.AssistantMoreSettingFragment$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistantMoreSettingFragment.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QBaseActivity qBaseActivity = AssistantMoreSettingFragment.this.getQBaseActivity();
            if (qBaseActivity == null) {
                return;
            }
            AppRuntime appRuntime = qBaseActivity.getAppRuntime();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(SettingCloneUtil.readValue((Context) qBaseActivity, (String) null, HardCodeUtil.qqStr(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false), appRuntime, qBaseActivity) { // from class: com.tencent.mobileqq.settings.fragment.AssistantMoreSettingFragment.1.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f286807d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ AppRuntime f286808e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ QBaseActivity f286809f;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.settings.fragment.AssistantMoreSettingFragment$1$1$a */
                /* loaded from: classes18.dex */
                class a implements CompoundButton.OnCheckedChangeListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) RunnableC85801.this);
                        }
                    }

                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
                        } else {
                            if (AppSetting.f99565y) {
                                AssistantMoreSettingFragment.this.C.setContentDescription(HardCodeUtil.qqStr(R.string.js8));
                            }
                            ao.a((AppInterface) RunnableC85801.this.f286808e, "0X800B889", z16);
                            RunnableC85801 runnableC85801 = RunnableC85801.this;
                            SettingCloneUtil.writeValue(runnableC85801.f286809f, (String) null, AssistantMoreSettingFragment.this.getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, z16);
                            ScreenShotActivityModule screenShotActivityModule = (ScreenShotActivityModule) RunnableC85801.this.f286809f.getModule(ScreenShotActivityModule.class);
                            if (z16) {
                                screenShotActivityModule.turnOnShake();
                            } else {
                                screenShotActivityModule.turnOffShake();
                            }
                        }
                        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
                    }
                }

                {
                    this.f286807d = r6;
                    this.f286808e = appRuntime;
                    this.f286809f = qBaseActivity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(r6), appRuntime, qBaseActivity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AssistantMoreSettingFragment.this.C.setChecked(this.f286807d);
                    AssistantMoreSettingFragment.this.C.setOnCheckedChangeListener(new a());
                    AssistantMoreSettingFragment.this.C.setContentDescription(HardCodeUtil.qqStr(R.string.jsc));
                    ReportController.y(this.f286808e, "0X800B825");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ICardContainerSwitchApi f286812d;

        a(ICardContainerSwitchApi iCardContainerSwitchApi) {
            this.f286812d = iCardContainerSwitchApi;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistantMoreSettingFragment.this, (Object) iCardContainerSwitchApi);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            CardContainerSwitchState cardContainerSwitchState;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                QLog.i("IphoneTitleBarFragment", 1, "cardContainerSwitch onCheckedChanged:" + z16);
                if (z16) {
                    cardContainerSwitchState = CardContainerSwitchState.ON;
                } else {
                    cardContainerSwitchState = CardContainerSwitchState.OFF;
                }
                this.f286812d.setRemoteCardContainerSwitchState(cardContainerSwitchState);
                AssistantMoreSettingFragment assistantMoreSettingFragment = AssistantMoreSettingFragment.this;
                if (!z16) {
                    i3 = 2;
                }
                assistantMoreSettingFragment.Dh("dt_clck", i3);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistantMoreSettingFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                AssistantMoreSettingFragment assistantMoreSettingFragment = AssistantMoreSettingFragment.this;
                assistantMoreSettingFragment.Fh(assistantMoreSettingFragment.E.getSwitch(), z16);
                if (AssistantMoreSettingFragment.this.D != null) {
                    AssistantMoreSettingFragment.this.D.L(z16, true);
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements SpeedUpUtil.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f286815a;

        c(String str) {
            this.f286815a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistantMoreSettingFragment.this, (Object) str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(String str) {
            AssistantMoreSettingFragment.this.F.setChecked(false);
            AssistantMoreSettingFragment.this.F.setEnabled(true);
            AssistantMoreSettingFragment.this.F.setText(str);
            if (SpeedUpUtil.p()) {
                QQToast.makeText(AssistantMoreSettingFragment.this.getQBaseActivity(), "\u5df2\u8fde\u7eed\u5931\u8d25 3 \u6b21\uff0c\u8be5\u673a\u5668\u53ef\u80fd\u4e0d\u6ee1\u8db3\u4f18\u5316\u6761\u4ef6\uff0c\u6b22\u8fce\u53cd\u9988\u5b98\u65b9\u8fdb\u884c\u6392\u67e5\u3002", 1).show();
            } else {
                QQToast.makeText(AssistantMoreSettingFragment.this.getQBaseActivity(), "\u672c\u6b21\u89e6\u53d1\u4f18\u5316\u5931\u8d25\uff0c\u7a0d\u540e\u53ef\u91cd\u8bd5\u3002", 1).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str, int i3) {
            AssistantMoreSettingFragment.this.F.setText(str + "(\u8fdb\u5ea6\uff1a" + i3 + "%)");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(String str) {
            AssistantMoreSettingFragment.this.F.setEnabled(true);
            AssistantMoreSettingFragment.this.F.setText(str);
            QQToast.makeText(AssistantMoreSettingFragment.this.getQBaseActivity(), "\u4f18\u5316\u6210\u529f\u5566\uff0c\u5173\u95ed\u624bQ\u540e\u518d\u6b21\u8fdb\u5165\u53ef\u4eab\u53d7\u66f4\u4f18\u4f53\u9a8c\u3002", 1).show();
        }

        @Override // com.tencent.mobileqq.perf.startup.SpeedUpUtil.a
        public void a(final int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FormSwitchItem formSwitchItem = AssistantMoreSettingFragment.this.F;
                final String str = this.f286815a;
                formSwitchItem.post(new Runnable() { // from class: com.tencent.mobileqq.settings.fragment.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AssistantMoreSettingFragment.c.this.f(str, i3);
                    }
                });
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }

        @Override // com.tencent.mobileqq.perf.startup.SpeedUpUtil.a
        public void onFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                FormSwitchItem formSwitchItem = AssistantMoreSettingFragment.this.F;
                final String str = this.f286815a;
                formSwitchItem.post(new Runnable() { // from class: com.tencent.mobileqq.settings.fragment.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AssistantMoreSettingFragment.c.this.e(str);
                    }
                });
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.mobileqq.perf.startup.SpeedUpUtil.a
        public void onSuccess(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                FormSwitchItem formSwitchItem = AssistantMoreSettingFragment.this.F;
                final String str = this.f286815a;
                formSwitchItem.post(new Runnable() { // from class: com.tencent.mobileqq.settings.fragment.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        AssistantMoreSettingFragment.c.this.g(str);
                    }
                });
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistantMoreSettingFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                AssistantMoreSettingFragment assistantMoreSettingFragment = AssistantMoreSettingFragment.this;
                assistantMoreSettingFragment.Fh(assistantMoreSettingFragment.E.getSwitch(), z16);
                if (AssistantMoreSettingFragment.this.D != null) {
                    AssistantMoreSettingFragment.this.D.L(z16, true);
                }
                ao.a((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), "0X800B88B", z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e extends CardObserver {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistantMoreSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetAllowActivateFriend(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (z16 && AssistantMoreSettingFragment.this.getQBaseActivity() != null && !AssistantMoreSettingFragment.this.getQBaseActivity().isFinishing()) {
                AssistantMoreSettingFragment assistantMoreSettingFragment = AssistantMoreSettingFragment.this;
                assistantMoreSettingFragment.Fh(assistantMoreSettingFragment.E.getSwitch(), z17);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetAllowActivateFriend(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (AssistantMoreSettingFragment.this.getQBaseActivity() != null && !AssistantMoreSettingFragment.this.getQBaseActivity().isFinishing()) {
                AssistantMoreSettingFragment assistantMoreSettingFragment = AssistantMoreSettingFragment.this;
                assistantMoreSettingFragment.Fh(assistantMoreSettingFragment.E.getSwitch(), z17);
            }
        }
    }

    public AssistantMoreSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.H = new e();
        }
    }

    private void Ah() {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ihp);
        this.C = formSwitchItem;
        ((ViewGroup.MarginLayoutParams) formSwitchItem.getLayoutParams()).topMargin = BaseAIOUtils.f(com.tencent.mobileqq.widget.o.b(), getResources());
        ThreadManagerV2.excute(new AnonymousClass1(), 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (z16) {
            this.F.setEnabled(false);
            SpeedUpUtil.e("speed-profile", 0L);
            QQToast.makeText(getQBaseActivity(), "\u6b63\u5728\u4f18\u5316\uff0c\u8017\u65f6\u7ea6 90 \u79d2\uff0c\u4e0d\u8981\u9000\u51fa\u9875\u9762\u5662\u3002", 0).show();
        } else {
            QQToast.makeText(getQBaseActivity(), "\u91cd\u590d\u89e6\u53d1\u4e0d\u4fdd\u8bc1\u4f1a\u5e26\u6765\u4f18\u5316\u5662\u3002", 1).show();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(i3));
        Eh(str, "em_bas_container_switch", hashMap);
    }

    private void Eh(final String str, String str2, Map<String, Object> map) {
        final HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_more_function_settings");
        if (str2 != null) {
            hashMap.put("dt_eid", str2);
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.settings.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                VideoReport.reportEvent(str, hashMap);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(CompoundButton compoundButton, boolean z16) {
        compoundButton.setOnCheckedChangeListener(null);
        compoundButton.setChecked(z16);
        compoundButton.setOnCheckedChangeListener(new d());
    }

    private void Gh() {
        if (!SpeedUpUtil.p() && com.tencent.mobileqq.perf.startup.a.a()) {
            if (SpeedUpUtil.j() != 0) {
                this.F.setEnabled(false);
            } else {
                this.F.setChecked(SpeedUpUtil.o());
            }
        }
    }

    private void initData() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) peekAppRuntime.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        this.D = activateFriendsManager;
        if (activateFriendsManager != null) {
            this.E.setChecked(activateFriendsManager.t(true));
        }
    }

    private void initUI() {
        Ah();
        yh();
        xh();
        zh();
    }

    private void xh() {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163946d9);
        this.E = formSwitchItem;
        formSwitchItem.setOnCheckedChangeListener(new b());
        ReportController.y(MobileQQ.sMobileQQ.peekAppRuntime(), "0X800B827");
    }

    private void yh() {
        int i3;
        this.G = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.tlz);
        ICardContainerSwitchApi iCardContainerSwitchApi = (ICardContainerSwitchApi) QRoute.api(ICardContainerSwitchApi.class);
        if (!iCardContainerSwitchApi.remoteShowCardContainerSwitch()) {
            this.G.setVisibility(8);
            return;
        }
        boolean localCardContainerSwitchShowingState = iCardContainerSwitchApi.getLocalCardContainerSwitchShowingState();
        CardContainerSwitchState remoteCardContainerSwitchState = iCardContainerSwitchApi.getRemoteCardContainerSwitchState();
        boolean z16 = true;
        QLog.i("IphoneTitleBarFragment", 1, "initCardContainerSwitch show switch:" + localCardContainerSwitchShowingState + ",current state:" + remoteCardContainerSwitchState);
        if (!localCardContainerSwitchShowingState) {
            this.G.setVisibility(8);
            return;
        }
        this.G.setVisibility(0);
        CardContainerSwitchState cardContainerSwitchState = CardContainerSwitchState.OFF;
        if (remoteCardContainerSwitchState != cardContainerSwitchState) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        Dh("dt_imp", i3);
        FormSwitchItem formSwitchItem = this.G;
        if (remoteCardContainerSwitchState == cardContainerSwitchState) {
            z16 = false;
        }
        formSwitchItem.setChecked(z16);
        this.G.setOnCheckedChangeListener(new a(iCardContainerSwitchApi));
    }

    private void zh() {
        if (!SpeedUpUtil.p() && com.tencent.mobileqq.perf.startup.a.a()) {
            FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f100985tz);
            this.F = formSwitchItem;
            formSwitchItem.setVisibility(0);
            c cVar = new c(this.F.getTextView().getText().toString());
            Gh();
            SpeedUpUtil.y(cVar);
            this.F.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.fragment.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    AssistantMoreSettingFragment.this.Bh(compoundButton, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(getString(R.string.z6i));
        initUI();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h3l;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            getQBaseActivity().addObserver(this.H);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.removeObserver(this.H);
        }
        if (SpeedUpUtil.p() || !com.tencent.mobileqq.perf.startup.a.a()) {
            SpeedUpUtil.y(null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onPause();
            Eh("dt_pgout", null, null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        Gh();
        Eh("dt_pgin", null, null);
    }
}
