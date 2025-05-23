package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.AutoSaveUtils;
import com.tencent.util.VersionUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQSettingAutoDownloadAndSaveFragment extends IphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private QQAppInterface C;
    private BounceScrollView D;
    FormSwitchItem E;
    FormSwitchItem F;
    FormSwitchItem G;
    FormSwitchItem H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingAutoDownloadAndSaveFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                SettingCloneUtil.writeValue(QQSettingAutoDownloadAndSaveFragment.this.getBaseActivity(), (String) null, QQSettingAutoDownloadAndSaveFragment.this.getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, z16);
                ReportController.o(QQSettingAutoDownloadAndSaveFragment.this.C, "CliOper", "", "", "Setting_tab", "Clk_auto_receive_pic", 0, z16 ? 1 : 0, "", "", "", "");
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingAutoDownloadAndSaveFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                ReportController.o(QQSettingAutoDownloadAndSaveFragment.this.C, "CliOper", "", "", "Setting_tab", "Download_new", 0, z16 ? 1 : 0, "", "", "", "");
                ConfigHandler configHandler = (ConfigHandler) QQSettingAutoDownloadAndSaveFragment.this.C.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
                configHandler.t3();
                ConfigHandler.w3(QQSettingAutoDownloadAndSaveFragment.this.C, z16);
                if (z16) {
                    if (com.tencent.mobileqq.upgrade.k.i().k() != 4) {
                        com.tencent.mobileqq.upgrade.k.i().y();
                    }
                    ReportController.o(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
                } else {
                    com.tencent.mobileqq.upgrade.k.i().z();
                    ReportController.o(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
                }
                configHandler.v3(z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingAutoDownloadAndSaveFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                AutoSaveUtils.i(true, z16);
                ReportController.o(null, "CliOper", "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0X800A6E3", "0X800A6E3", 0, z16 ? 1 : 0, "", "", "", "");
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingAutoDownloadAndSaveFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                AutoSaveUtils.i(false, z16);
                ReportController.o(null, "CliOper", "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0X800A6E4", "0X800A6E4", 0, z16 ? 1 : 0, "", "", "", "");
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    public QQSettingAutoDownloadAndSaveFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void initUI() {
        this.D = (BounceScrollView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ii_);
        if (VersionUtils.isGingerBread()) {
            this.D.setOverScrollMode(0);
        }
        ReportController.o(null, "dc00898", "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0X800ABAF", "0X800ABAF", 0, 1, "", "", "", "");
        this.E = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.a1l);
        this.F = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f167079kj2);
        this.G = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.l_c);
        this.H = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.l_d);
        this.E.setVisibility(0);
        this.E.setChecked(SettingCloneUtil.readValue((Context) getBaseActivity(), (String) null, getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true));
        this.E.setOnCheckedChangeListener(new a());
        this.F.setChecked(ConfigHandler.g3(this.C, false));
        this.F.setOnCheckedChangeListener(new b());
        this.G.setChecked(AutoSaveUtils.g(true));
        this.G.setOnCheckedChangeListener(new c());
        this.H.setChecked(AutoSaveUtils.g(false));
        this.H.setOnCheckedChangeListener(new d());
        if (VersionUtils.isGingerBread()) {
            this.D.setOverScrollMode(0);
        }
        if (AppSetting.f99565y) {
            this.E.setContentDescription(getString(R.string.f173108hf4));
            this.F.setContentDescription(getString(R.string.vtu));
            this.G.setContentDescription(getString(R.string.vqu));
            this.H.setContentDescription(getString(R.string.vqv));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (getBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) getBaseActivity().getAppRuntime();
            this.C = qQAppInterface;
            if (qQAppInterface != null) {
                initUI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.cbr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(getBaseActivity().getString(R.string.vqy));
        return onCreateCenterView;
    }
}
