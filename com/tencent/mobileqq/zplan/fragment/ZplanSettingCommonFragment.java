package com.tencent.mobileqq.zplan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.zplan.setting.SwitchSetting;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.mobileqq.zplan.utils.y;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ZplanSettingCommonFragment extends QIphoneTitleBarFragment {
    private AppInterface C;
    private FormSwitchItem D;
    private FormSwitchItem E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements y.a {
        a() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingCommonFragment.this.zh(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b implements y.a {
        b() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingCommonFragment.this.yh(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    private void initViews() {
        wh();
        vh();
        uh();
    }

    private void uh() {
        FormSimpleItem formSimpleItem = (FormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r7v);
        if (formSimpleItem == null) {
            return;
        }
        final String zplanSettingCDKeyUrl = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZplanSettingCDKeyUrl();
        formSimpleItem.setLeftText(getResources().getString(R.string.xti));
        formSimpleItem.setContentDescription(getResources().getString(R.string.xti));
        if (TextUtils.isEmpty(zplanSettingCDKeyUrl)) {
            return;
        }
        formSimpleItem.setVisibility(0);
        formSimpleItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.fragment.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanSettingCommonFragment.xh(zplanSettingCDKeyUrl, view);
            }
        });
    }

    private void vh() {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163645r82);
        this.E = formSwitchItem;
        if (formSwitchItem == null) {
            return;
        }
        boolean h16 = com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.MESSAGE_NOTICE_SETTING);
        QLog.d("ZplanSettingCommonUseFragment", 1, "initMessageNoticeSwitch: " + h16);
        this.E.setChecked(h16);
        this.E.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.E, new b()));
    }

    private void wh() {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163646r83);
        this.D = formSwitchItem;
        if (formSwitchItem == null) {
            return;
        }
        formSwitchItem.setVisibility(8);
        boolean h16 = com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.OPERATOR_DOWNLOAD_SETTING);
        QLog.d("ZplanSettingCommonUseFragment", 1, "initOperatorDownloadSwitch: " + h16);
        this.D.setChecked(h16);
        this.D.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.D, new a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void xh(String str, View view) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        RouteUtils.startActivity(view.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.MESSAGE_NOTICE_SETTING, z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingCommonFragment.4
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingCommonUseFragment", 1, "setSettingMessageNoticeSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingCommonFragment.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingCommonFragment.this.getQBaseActivity(), R.string.xtm, 1);
                            FormSwitchItem formSwitchItem = ZplanSettingCommonFragment.this.E;
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                        }
                    });
                } else {
                    com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.MESSAGE_NOTICE_SETTING, z17);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.OPERATOR_DOWNLOAD_SETTING, z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingCommonFragment.2
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingCommonUseFragment", 1, "setSettingOperatorDownloadSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingCommonFragment.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingCommonFragment.this.getQBaseActivity(), R.string.xtm, 1);
                            FormSwitchItem formSwitchItem = ZplanSettingCommonFragment.this.D;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                        }
                    });
                } else {
                    com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.OPERATOR_DOWNLOAD_SETTING, z17);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = (AppInterface) getQBaseActivity().getAppRuntime();
        setTitle(getString(R.string.xtj));
        initViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d2n;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.d("ZplanSettingCommonUseFragment", 1, "onDestroyView");
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.d("ZplanSettingCommonUseFragment", 1, "onBackEvent");
        return super.onBackEvent();
    }
}
