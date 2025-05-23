package com.tencent.mobileqq.settings.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import javax.annotation.Nullable;

/* loaded from: classes18.dex */
public class PrivacyShowSettingFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    QQAppInterface C;
    private FormSwitchItem D;
    private FormSwitchItem E;
    private FormSwitchItem F;
    private View G;
    CompoundButton.OnCheckedChangeListener H;
    ar I;
    com.tencent.mobileqq.inputstatus.a J;
    private CardObserver K;

    /* loaded from: classes18.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrivacyShowSettingFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else if ((compoundButton == PrivacyShowSettingFragment.this.D.getSwitch() || compoundButton == PrivacyShowSettingFragment.this.E.getSwitch()) && !NetworkUtil.isNetSupportHw(BaseApplication.getContext())) {
                PrivacyShowSettingFragment.this.notifyUser(R.string.cjl, 1);
                PrivacyShowSettingFragment.this.wh(compoundButton, !z16);
            } else if (compoundButton == PrivacyShowSettingFragment.this.D.getSwitch()) {
                if (AppSetting.f99565y) {
                    PrivacyShowSettingFragment.this.D.setContentDescription(HardCodeUtil.qqStr(R.string.p0k));
                }
                PrivacyShowSettingFragment privacyShowSettingFragment = PrivacyShowSettingFragment.this;
                privacyShowSettingFragment.wh(privacyShowSettingFragment.D.getSwitch(), z16);
                PrivacyShowSettingFragment.this.C.setVisibilityForNetWorkStatus(z16, true);
                if (z16) {
                    ReportController.o(PrivacyShowSettingFragment.this.C, "dc00898", "", "", "0X800B862", "0X800B862", 1, 0, "", "", "", "");
                } else {
                    ReportController.o(PrivacyShowSettingFragment.this.C, "dc00898", "", "", "0X800B862", "0X800B862", 0, 0, "", "", "", "");
                }
            } else if (compoundButton == PrivacyShowSettingFragment.this.E.getSwitch()) {
                ReportController.o(PrivacyShowSettingFragment.this.C, "dc00898", "", "", "0X800B863", "0X800B863", z16 ? 1 : 0, 0, "", "", "", "");
                if (AppSetting.f99565y) {
                    PrivacyShowSettingFragment.this.E.setContentDescription(HardCodeUtil.qqStr(R.string.p0b));
                }
                PrivacyShowSettingFragment privacyShowSettingFragment2 = PrivacyShowSettingFragment.this;
                privacyShowSettingFragment2.wh(privacyShowSettingFragment2.E.getSwitch(), z16);
                PrivacyShowSettingFragment.this.C.setVisibilityForInputStatus(z16, true);
            } else if (compoundButton == PrivacyShowSettingFragment.this.F.getSwitch()) {
                ReportController.o(PrivacyShowSettingFragment.this.C, "dc00898", "", "", "0X800B864", "0X800B864", z16 ? 1 : 0, 0, "", "", "", "");
                if (!NetworkUtil.isNetSupport(PrivacyShowSettingFragment.this.C.getApplication().getApplicationContext())) {
                    QQToast.makeText(PrivacyShowSettingFragment.this.getBaseActivity().getApplicationContext(), R.string.hhc, 1).show();
                    PrivacyShowSettingFragment.this.wh(compoundButton, !z16);
                }
                ((CardHandler) PrivacyShowSettingFragment.this.C.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).k5(!z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* loaded from: classes18.dex */
    class b extends ar {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrivacyShowSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onGetVisibilityForNetWorkStatus(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (z16) {
                PrivacyShowSettingFragment privacyShowSettingFragment = PrivacyShowSettingFragment.this;
                privacyShowSettingFragment.wh(privacyShowSettingFragment.D.getSwitch(), z17);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onSetVisibilityForNetWorkStatus(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (!z16) {
                PrivacyShowSettingFragment.this.notifyUser(R.string.hhc, 1);
            }
            PrivacyShowSettingFragment privacyShowSettingFragment = PrivacyShowSettingFragment.this;
            privacyShowSettingFragment.wh(privacyShowSettingFragment.D.getSwitch(), z17);
        }
    }

    /* loaded from: classes18.dex */
    class c extends com.tencent.mobileqq.inputstatus.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrivacyShowSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.inputstatus.a
        protected void a(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (z16) {
                PrivacyShowSettingFragment privacyShowSettingFragment = PrivacyShowSettingFragment.this;
                privacyShowSettingFragment.wh(privacyShowSettingFragment.E.getSwitch(), z17);
            }
        }

        @Override // com.tencent.mobileqq.inputstatus.a
        protected void b(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (!z16) {
                PrivacyShowSettingFragment.this.notifyUser(R.string.hhc, 1);
                return;
            }
            PrivacyShowSettingFragment privacyShowSettingFragment = PrivacyShowSettingFragment.this;
            privacyShowSettingFragment.wh(privacyShowSettingFragment.E.getSwitch(), z17);
            QQAppInterface qQAppInterface = PrivacyShowSettingFragment.this.C;
            if (z17) {
                i3 = 2;
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009D11", "0X8009D11", 0, 0, String.valueOf(i3), "", "", "");
        }
    }

    /* loaded from: classes18.dex */
    class d extends CardObserver {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrivacyShowSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetPrettyOwnerFlag(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetMedal(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (!z16) {
                QQToast.makeText(PrivacyShowSettingFragment.this.C.getApp(), 1, PrivacyShowSettingFragment.this.getString(R.string.hhc), 3000).show(PrivacyShowSettingFragment.this.getBaseActivity().getTitleBarHeight());
                PrivacyShowSettingFragment privacyShowSettingFragment = PrivacyShowSettingFragment.this;
                privacyShowSettingFragment.wh(privacyShowSettingFragment.F.getSwitch(), true ^ PrivacyShowSettingFragment.this.F.getSwitch().isChecked());
                if (QLog.isColorLevel()) {
                    QLog.d("IphoneTitleBarFragment", 2, "PrivacyShowSettingFragment onSetMedal failed");
                    return;
                }
                return;
            }
            Card q16 = ((FriendsManager) PrivacyShowSettingFragment.this.C.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(PrivacyShowSettingFragment.this.C.getCurrentAccountUin());
            if (!PrivacyShowSettingFragment.this.getBaseActivity().isFinishing()) {
                PrivacyShowSettingFragment privacyShowSettingFragment2 = PrivacyShowSettingFragment.this;
                privacyShowSettingFragment2.wh(privacyShowSettingFragment2.F.getSwitch(), true ^ q16.medalSwitchDisable);
                if (QLog.isColorLevel()) {
                    QLog.d("IphoneTitleBarFragment", 2, "PrivacyShowSettingFragment onSetMedal medalSwitchDisable= " + q16.medalSwitchDisable);
                }
            }
            ReportController.o(PrivacyShowSettingFragment.this.C, "dc00898", "", "", "0X80073A0", "0X80073A0", q16.medalSwitchDisable ? 1 : 0, 0, "", "", "", "");
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetPrettyOwnerFlag(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (!z16) {
                return;
            }
            if (obj != null) {
                try {
                    z17 = ((Boolean) obj).booleanValue();
                } catch (Exception e16) {
                    QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onSetPrettyOwnerFlag ex:" + e16);
                    return;
                }
            }
            PrivacyShowSettingFragment.this.vh(z17);
            QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onSetPrettyOwnerFlag " + z17);
        }
    }

    public PrivacyShowSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.H = new a();
        this.I = new b();
        this.J = new c();
        this.K = new d();
    }

    private void initUI() {
        SimpleUIUtil.getSimpleUISwitch();
        FormSwitchItem formSwitchItem = (FormSwitchItem) this.G.findViewById(R.id.isu);
        this.D = formSwitchItem;
        formSwitchItem.setChecked(this.C.getVisibilityForNetWorkStatus(false));
        ReportController.o(this.C, "dc00898", "", "", "0X800B7FE", "0X800B7FE", 0, 0, "", "", "", "");
        FormSwitchItem formSwitchItem2 = (FormSwitchItem) this.G.findViewById(R.id.isq);
        this.E = formSwitchItem2;
        formSwitchItem2.setChecked(this.C.getVisibilityForInputStatus(false));
        ReportController.o(this.C, "dc00898", "", "", "0X800B7FF", "0X800B7FF", 0, 0, "", "", "", "");
        this.F = (FormSwitchItem) this.G.findViewById(R.id.eo6);
        ReportController.o(this.C, "dc00898", "", "", "0X800B800", "0X800B800", 0, 0, "", "", "", "");
        xh();
        ReportController.o(this.C, "dc00898", "", "", "0X800B806", "0X800B806", 0, 0, "", "", "", "");
        ((CardHandler) this.C.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).g3();
        TempGetProfileDetailProcessor tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(this.C, TempGetProfileDetailProcessor.class);
        if (tempGetProfileDetailProcessor != null) {
            tempGetProfileDetailProcessor.getLoginDaysSwitch();
        }
        this.D.setOnCheckedChangeListener(this.H);
        this.E.setOnCheckedChangeListener(this.H);
        this.E.setVisibility(0);
        if (AppSetting.f99565y) {
            this.D.setContentDescription(HardCodeUtil.qqStr(R.string.p0e));
            this.E.setContentDescription(HardCodeUtil.qqStr(R.string.p0c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(boolean z16) {
        ThreadManager.getSubThreadHandler().post(new Runnable(z16) { // from class: com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f286826d;

            {
                this.f286826d = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PrivacyShowSettingFragment.this, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                FriendsManager friendsManager = (FriendsManager) PrivacyShowSettingFragment.this.C.getManager(QQManagerFactory.FRIENDS_MANAGER);
                Card r16 = friendsManager.r(PrivacyShowSettingFragment.this.C.getCurrentAccountUin());
                if (r16 != null) {
                    r16.isHidePrettyGroutIdentity = !this.f286826d;
                    if (!friendsManager.p0(r16)) {
                        QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onGetPrettyOwnerFlag save card flag=" + this.f286826d + " failed");
                        return;
                    }
                    QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onGetPrettyOwnerFlag save card flag=" + this.f286826d + " success");
                    return;
                }
                QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onGetPrettyOwnerFlag save card failed because card is null");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(CompoundButton compoundButton, boolean z16) {
        compoundButton.setOnCheckedChangeListener(null);
        compoundButton.setChecked(z16);
        compoundButton.setOnCheckedChangeListener(this.H);
    }

    private void xh() {
        if (ea.x0(getBaseActivity().getApplication(), this.C.getCurrentAccountUin()) == 1) {
            this.F.setVisibility(0);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrivacyShowSettingFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    boolean z16 = ((FriendsManager) PrivacyShowSettingFragment.this.C.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(PrivacyShowSettingFragment.this.C.getCurrentAccountUin()).medalSwitchDisable;
                    if (QLog.isColorLevel()) {
                        QLog.d("IphoneTitleBarFragment", 2, "PermissionPrivacyFragment initUI medalSwitchDisable = " + z16);
                    }
                    BaseActivity baseActivity = PrivacyShowSettingFragment.this.getBaseActivity();
                    if (baseActivity == null) {
                        return;
                    }
                    baseActivity.runOnUiThread(new Runnable(z16) { // from class: com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f286824d;

                        {
                            this.f286824d = z16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(z16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            PrivacyShowSettingFragment.this.F.setOnCheckedChangeListener(null);
                            PrivacyShowSettingFragment.this.F.setChecked(!this.f286824d);
                            PrivacyShowSettingFragment.this.F.setOnCheckedChangeListener(PrivacyShowSettingFragment.this.H);
                        }
                    });
                }
            }, 5, null, true);
            this.F.setOnCheckedChangeListener(this.H);
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(getBaseActivity().getString(R.string.f2046553h));
        if (getBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            this.C = (QQAppInterface) getBaseActivity().getAppRuntime();
        }
        this.G = ((IphoneTitleBarFragment) this).mContentView;
        initUI();
        getBaseActivity().addObserver(this.J);
        getBaseActivity().addObserver(this.I);
        getBaseActivity().addObserver(this.K);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h4i;
    }

    void notifyUser(int i3, int i16) {
        QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show(getBaseActivity().getTitleBarHeight());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        if (this.K != null) {
            getBaseActivity().removeObserver(this.K);
        }
        getBaseActivity().removeObserver(this.J);
        getBaseActivity().removeObserver(this.I);
    }
}
