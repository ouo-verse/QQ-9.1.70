package com.tencent.mobileqq.zplan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.utils.QQSettingMeABTestHelper;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.bf;
import com.tencent.mobileqq.zplan.aio.a;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.setting.SwitchSetting;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.mobileqq.zplan.utils.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.ArrayList;
import kotlin.Pair;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ZplanSettingAvatarShowFragment extends QIphoneTitleBarFragment {
    private AppInterface C;
    private FormSwitchItem D;
    private FormSwitchItem E;
    private FormSwitchItem F;
    private FormSwitchItem G;
    private FormSwitchItem H;
    private String I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b implements y.a {
        b() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingAvatarShowFragment.this.Qh(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class c implements y.a {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingAvatarShowFragment.this.Rh(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class d implements y.a {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingAvatarShowFragment.this.Sh(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class e implements y.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FormSwitchItem f333492a;

        e(FormSwitchItem formSwitchItem) {
            this.f333492a = formSwitchItem;
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingAvatarShowFragment.this.Oh(this.f333492a, compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class f implements y.a {
        f() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingAvatarShowFragment.this.Ph(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    private void Dh() {
        if (!a.c.c(this.C.getLongAccountUin())) {
            QLog.d("ZplanSettingAvatarShowFragment", 1, "[aioAvatarSwitch]Judge\u4e0d\u5141\u8bb8\u5c55\u793a\u5f00\u5173");
            return;
        }
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r7s);
        this.G = formSwitchItem;
        if (formSwitchItem == null) {
            return;
        }
        FormSwitchItem formSwitchItem2 = this.F;
        if (formSwitchItem2 != null) {
            formSwitchItem2.setBgType(2);
        }
        Eh();
        formSwitchItem.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), formSwitchItem, new e(formSwitchItem)));
        formSwitchItem.setBgType(3);
        formSwitchItem.setVisibility(0);
    }

    private void Eh() {
        boolean d16 = a.c.d();
        QLog.d("ZplanSettingAvatarShowFragment", 1, "[aioAvatarSwitch]initAioAvatarSwitch: " + d16);
        FormSwitchItem formSwitchItem = this.G;
        if (formSwitchItem != null) {
            formSwitchItem.setChecked(d16);
        }
    }

    private void Fh() {
        if (needBlur() && this.quiSecNavBar != null) {
            View view = ((QIphoneTitleBarFragment) this).mContentView;
            if (view instanceof BounceScrollView) {
                BounceScrollView bounceScrollView = (BounceScrollView) view;
                int b16 = com.tencent.biz.qui.quisecnavbar.e.b(bounceScrollView.getContext());
                bounceScrollView.setPadding(0, b16, 0, 0);
                bounceScrollView.setClipToPadding(false);
                boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
                boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
                this.quiSecNavBar.setBlur(isSettingPageNavNeedBlur, isSettingPageNavNeedBlur ? bounceScrollView : null);
                if (isSettingPageNavNeedAlpha) {
                    if (isSettingPageNavNeedBlur) {
                        this.quiSecNavBar.setTitleBlurAlpha(0.0f);
                    } else {
                        this.quiSecNavBar.setTitleAlpha(0.0f);
                    }
                    bounceScrollView.setScrollListener(new a(b16, isSettingPageNavNeedBlur));
                }
            }
        }
    }

    private void Gh() {
        boolean enableZPlanFilamentBase = ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase(null);
        boolean h16 = QQSettingMeABTestHelper.e().h();
        if (enableZPlanFilamentBase && h16 && QQSettingMeABTestHelper.c()) {
            FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r7x);
            this.H = formSwitchItem;
            if (formSwitchItem == null) {
                return;
            }
            FormSwitchItem formSwitchItem2 = this.F;
            if (formSwitchItem2 != null) {
                formSwitchItem2.setBgType(2);
            }
            FormSwitchItem formSwitchItem3 = this.G;
            if (formSwitchItem3 != null) {
                formSwitchItem3.setBgType(2);
            }
            Hh();
            this.H.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.H, new f()));
            this.H.setBgType(3);
            this.H.setVisibility(0);
        }
    }

    private void Hh() {
        boolean b16 = com.tencent.mobileqq.zplan.setting.c.b();
        QLog.d("ZplanSettingAvatarShowFragment", 2, "initDrawerSwitchChecked: " + b16);
        FormSwitchItem formSwitchItem = this.H;
        if (formSwitchItem != null) {
            formSwitchItem.setChecked(b16);
        }
    }

    private void Ih() {
        boolean h16 = com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.DYNAMIC_SETTING);
        QLog.d("ZplanSettingAvatarShowFragment", 2, "initQzoneSwitch: " + h16);
        FormSwitchItem formSwitchItem = this.F;
        if (formSwitchItem != null) {
            formSwitchItem.setChecked(h16);
        }
    }

    private void Jh() {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r8b);
        this.D = formSwitchItem;
        if (formSwitchItem == null) {
            return;
        }
        boolean e16 = com.tencent.mobileqq.zplan.setting.c.e();
        QLog.d("ZplanSettingAvatarShowFragment", 1, "initMasterSwitch: " + e16);
        this.D.setChecked(e16);
        Th(e16);
        this.D.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.D, new b()));
        this.D.setBgType(0);
    }

    private void Kh() {
        boolean isZplanAccessibleWithoutSetting = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(1004L, this.C.getLongAccountUin());
        boolean enableZPlanNativeAppFilament = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(2);
        if (isZplanAccessibleWithoutSetting && enableZPlanNativeAppFilament) {
            FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r85);
            this.E = formSwitchItem;
            if (formSwitchItem == null) {
                return;
            }
            Lh();
            this.E.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.E, new c()));
            this.E.setBgType(1);
            this.E.setVisibility(0);
        }
    }

    private void Lh() {
        boolean h16 = com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.PROFILE_CARD_SETTING);
        QLog.d("ZplanSettingAvatarShowFragment", 2, "initProfileCardSwitch: " + h16);
        FormSwitchItem formSwitchItem = this.E;
        if (formSwitchItem != null) {
            formSwitchItem.setChecked(h16);
        }
    }

    private void Mh() {
        boolean isZplanAccessibleWithoutSetting = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(Constant.FROM_ID_UNINSTALL_PLUGIN, this.C.getLongAccountUin());
        boolean f16 = QQSettingMeABTestHelper.e().f();
        boolean enableZPlanNativeAppFilament = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(0);
        if (isZplanAccessibleWithoutSetting && !f16 && enableZPlanNativeAppFilament) {
            FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r87);
            this.F = formSwitchItem;
            if (formSwitchItem == null) {
                return;
            }
            String zplanSettingQzoneSwitchName = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZplanSettingQzoneSwitchName();
            this.F.setText(zplanSettingQzoneSwitchName);
            this.F.setContentDescription(zplanSettingQzoneSwitchName);
            Ih();
            this.F.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.F, new d()));
            this.F.setBgType(3);
            this.F.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh() {
        Ih();
        Lh();
        Eh();
        Hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(final FormSwitchItem formSwitchItem, final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        a.c.e(z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.8
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingAvatarShowFragment", 1, "setAioAvatarSwitch success=" + z18 + ", isChecked=" + z17);
                if (z18) {
                    return;
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingAvatarShowFragment.this.getQBaseActivity(), R.string.xtm, 1);
                        AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                        com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        ZplanDataRepository.f334898a.p(1006L, z17);
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.DRAWER_SETTING, z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.10
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingAvatarShowFragment", 1, "setDrawerSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingAvatarShowFragment.this.getQBaseActivity(), R.string.xtm, 1);
                            com.tencent.mobileqq.zplan.utils.y.e(ZplanSettingAvatarShowFragment.this.H, !z16, onCheckedChangeListener);
                            ZplanDataRepository.f334898a.p(1006L, !z17);
                        }
                    });
                } else {
                    com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DRAWER_SETTING, z17);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(SwitchSetting.MASTER_SETTING, Boolean.valueOf(z17)));
        if (!z17) {
            SwitchSetting switchSetting = SwitchSetting.PROFILE_CARD_SETTING;
            Boolean bool = Boolean.FALSE;
            arrayList.add(new Pair(switchSetting, bool));
            arrayList.add(new Pair(SwitchSetting.DYNAMIC_SETTING, bool));
            arrayList.add(new Pair(SwitchSetting.AIO_AVATAR_SETTING, bool));
            arrayList.add(new Pair(SwitchSetting.DRAWER_SETTING, bool));
        }
        com.tencent.mobileqq.zplan.setting.e.f335451a.g(arrayList, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.2
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingAvatarShowFragment", 1, "setSettingMasterSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingAvatarShowFragment.this.getQBaseActivity(), R.string.xtm, 1);
                            FormSwitchItem formSwitchItem = ZplanSettingAvatarShowFragment.this.D;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                        }
                    });
                    return;
                }
                com.tencent.mobileqq.zplan.setting.c.n(z17);
                boolean z19 = z17;
                if (!z19) {
                    com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.PROFILE_CARD_SETTING, z19);
                    com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DYNAMIC_SETTING, z17);
                    com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.AIO_AVATAR_SETTING, z17);
                    com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DRAWER_SETTING, z17);
                    ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
                    zplanDataRepository.p(1006L, z17);
                    zplanDataRepository.p(1004L, z17);
                    com.tencent.mobileqq.zplan.utils.y.h(z17);
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        ZplanSettingAvatarShowFragment.this.Th(z17);
                        ZplanSettingAvatarShowFragment.this.Nh();
                    }
                });
                ZplanSettingAvatarShowFragment.this.Uh(z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.PROFILE_CARD_SETTING, z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.4
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingAvatarShowFragment", 1, "setSettingProfileCardSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingAvatarShowFragment.this.getQBaseActivity(), R.string.xtm, 1);
                            FormSwitchItem formSwitchItem = ZplanSettingAvatarShowFragment.this.E;
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                        }
                    });
                    return;
                }
                com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.PROFILE_CARD_SETTING, z17);
                ZplanSettingAvatarShowFragment.this.Wh(z17, 1004L);
                ZplanDataRepository.f334898a.p(1004L, !z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th(boolean z16) {
        Vh(this.E, z16);
        Vh(this.F, z16);
        Vh(this.G, z16);
        Vh(this.H, z16);
        Vh(((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r89), !(this.E == null && this.F == null && this.G == null && this.H == null) && z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh(boolean z16, long j3) {
        AccessibleDetail zplanAccessibleDetail = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).getZplanAccessibleDetail(j3, this.C.getLongAccountUin());
        if (zplanAccessibleDetail == null) {
            return;
        }
        zplanAccessibleDetail.settingPass = z16 ? 1 : 0;
        ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).updateCache(zplanAccessibleDetail);
    }

    private void initViews() {
        Kh();
        Mh();
        Dh();
        Gh();
        Jh();
    }

    protected void Ch() {
        Intent intent = getQBaseActivity().getActivity().getIntent();
        if (intent == null) {
            return;
        }
        if (IZPlanApi.FROM_QQ_SETTING.equals(intent.getStringExtra("FROM"))) {
            this.I = "qqsetting";
        } else {
            this.I = "setting";
        }
    }

    protected void Sh(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.DYNAMIC_SETTING, z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.6
            @Override // nk3.a
            public void onResult(boolean z18) {
                String str;
                QLog.d("ZplanSettingAvatarShowFragment", 1, "setSettingQzoneSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingAvatarShowFragment.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingAvatarShowFragment.this.getQBaseActivity(), R.string.xtm, 1);
                            FormSwitchItem formSwitchItem = ZplanSettingAvatarShowFragment.this.F;
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                        }
                    });
                    return;
                }
                com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DYNAMIC_SETTING, z17);
                ZplanSettingAvatarShowFragment.this.Wh(z17, Constant.FROM_ID_UNINSTALL_PLUGIN);
                String str2 = ZplanSettingAvatarShowFragment.this.I;
                if (z17) {
                    str = "open";
                } else {
                    str = "close";
                }
                t74.r.c(str2, "feeds", str, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = (AppInterface) getQBaseActivity().getAppRuntime();
        setTitle(getString(R.string.xth));
        initViews();
        Fh();
        Ch();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d2m;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean needBlur() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        FormSwitchItem formSwitchItem;
        super.onDestroyView();
        QLog.d("ZplanSettingAvatarShowFragment", 1, "onDestroyView");
        if (this.F == null || (formSwitchItem = this.D) == null) {
            return;
        }
        ZplanDataRepository.f334898a.q(formSwitchItem.isChecked() && this.F.isChecked());
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.d("ZplanSettingAvatarShowFragment", 1, "onBackEvent");
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh(boolean z16) {
        if (!z16) {
            Wh(false, 1004L);
            Wh(false, Constant.FROM_ID_UNINSTALL_PLUGIN);
        } else {
            Wh(com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.PROFILE_CARD_SETTING), 1004L);
            Wh(com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.DYNAMIC_SETTING), Constant.FROM_ID_UNINSTALL_PLUGIN);
        }
    }

    protected void Vh(View view, boolean z16) {
        if (view == null) {
            return;
        }
        view.setVisibility(z16 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements bf {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f333486a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f333487b;

        a(int i3, boolean z16) {
            this.f333486a = i3;
            this.f333487b = z16;
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void c(View view, int i3, int i16, int i17, int i18) {
            int i19 = this.f333486a / 2;
            float f16 = i16 <= 0 ? 0.0f : i16 < i19 ? (i16 * 1.0f) / i19 : 1.0f;
            if (this.f333487b) {
                ZplanSettingAvatarShowFragment.this.quiSecNavBar.setTitleBlurAlpha(f16);
            } else {
                ZplanSettingAvatarShowFragment.this.quiSecNavBar.setTitleAlpha(f16);
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void b(View view, int i3) {
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void a(View view, float f16, float f17) {
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void d(View view, float f16, float f17) {
        }
    }
}
