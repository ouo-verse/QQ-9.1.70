package com.tencent.mobileqq.zplan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.setting.SwitchSetting;
import com.tencent.mobileqq.zplan.utils.y;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* loaded from: classes34.dex */
public class ZplanSettingPrivacyFragment extends QIphoneTitleBarFragment {
    private AppInterface C;
    private FormSwitchItem D;
    private FormSwitchItem E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a implements y.a {
        a() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingPrivacyFragment.this.Ch(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements y.a {
        b() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingPrivacyFragment.this.Dh(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startSmallHomePermissionManagerActivity(ZplanSettingPrivacyFragment.this.getQBaseActivity(), new Bundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(View view) {
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startBindingSettingActivity(getQBaseActivity(), new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(View view) {
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startFollowAndFansSettingActivity(getQBaseActivity(), new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.ADD_FRIEND_SETTING, z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingPrivacyFragment.2
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingPrivacyFragment", 1, "setSettingAddFriendSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingPrivacyFragment.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingPrivacyFragment.this.getQBaseActivity(), R.string.xtm, 1);
                            FormSwitchItem formSwitchItem = ZplanSettingPrivacyFragment.this.D;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                        }
                    });
                } else {
                    com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.ADD_FRIEND_SETTING, z17);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.SHOW_PARADISE_SCORE_SETTING, z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingPrivacyFragment.4
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingPrivacyFragment", 1, "setShowParadiseScoreSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingPrivacyFragment.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingPrivacyFragment.this.getQBaseActivity(), R.string.xtm, 1);
                            FormSwitchItem formSwitchItem = ZplanSettingPrivacyFragment.this.E;
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                        }
                    });
                } else {
                    com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.SHOW_PARADISE_SCORE_SETTING, z17);
                }
            }
        });
    }

    private void initViews() {
        vh();
        yh();
        zh();
        xh();
        wh();
    }

    private void vh() {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r7r);
        this.D = formSwitchItem;
        if (formSwitchItem == null) {
            return;
        }
        boolean h16 = com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.ADD_FRIEND_SETTING);
        QLog.d("ZplanSettingPrivacyFragment", 1, "initAddFriendSwitch: " + h16);
        this.D.setChecked(h16);
        this.D.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.D, new a()));
    }

    private void wh() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r7u, R.string.xhx);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.fragment.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanSettingPrivacyFragment.this.Ah(view);
            }
        });
    }

    private void xh() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r7z, R.string.xto);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.fragment.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanSettingPrivacyFragment.this.Bh(view);
            }
        });
    }

    private void yh() {
        this.E = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r8_);
        boolean isParadiseTabShow = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).isParadiseTabShow();
        if (this.E == null || !isParadiseTabShow) {
            return;
        }
        boolean h16 = com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.SHOW_PARADISE_SCORE_SETTING);
        QLog.d("ZplanSettingPrivacyFragment", 1, "initShowParadiseScoreSwitch: " + h16);
        this.E.setChecked(h16);
        this.E.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.E, new b()));
        this.E.setVisibility(0);
    }

    private void zh() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r8a, R.string.xtw);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = (AppInterface) getQBaseActivity().getAppRuntime();
        setTitle(getString(R.string.xtx));
        initViews();
        FragmentActivity activity = getActivity();
        if (activity == null || viewGroup == null) {
            return;
        }
        new id3.d().j(activity, viewGroup, "pg_zplan_privacy_setting", new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d2o;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.d("ZplanSettingPrivacyFragment", 1, "onDestroyView");
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.d("ZplanSettingPrivacyFragment", 1, "onBackEvent");
        return super.onBackEvent();
    }
}
