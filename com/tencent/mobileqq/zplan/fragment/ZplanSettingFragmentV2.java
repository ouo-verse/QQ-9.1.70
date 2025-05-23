package com.tencent.mobileqq.zplan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQSettingMeABTestHelper;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.zplan.aio.a;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.setting.SwitchSetting;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.mobileqq.zplan.utils.y;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanSettingOfficialGroupEntranceConfig;
import com.tencent.state.report.SquareReportConst;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Pair;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ZplanSettingFragmentV2 extends QIphoneTitleBarFragment {
    private String C;
    private RelativeLayout D;
    private QQProAvatarView E;
    private TextView F;
    private URLImageView G;
    private FormSwitchItem H;
    private FormSwitchItem I;
    private FormSwitchItem J;
    private FormSwitchItem K;
    private FormSwitchItem L;
    private FormSimpleItem M;
    private Handler N;
    private String P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements y.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FormSwitchItem f333542a;

        a(FormSwitchItem formSwitchItem) {
            this.f333542a = formSwitchItem;
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingFragmentV2.this.hi(this.f333542a, compoundButton.isChecked(), z16, onCheckedChangeListener);
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
            ZplanSettingFragmentV2.this.ii(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = ZplanSettingFragmentV2.this.getContext();
            if (context != null) {
                ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).u0(context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("url", ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZplanSettingFeedbackUrl());
            RouteUtils.startActivity(view.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("FROM", ZplanSettingFragmentV2.this.P);
            QPublicFragmentActivity.start(ZplanSettingFragmentV2.this.getQBaseActivity(), intent, NewZplanSettingAvatarShowFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QPublicFragmentActivity.start(ZplanSettingFragmentV2.this.getQBaseActivity(), ZplanSettingQualityFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QPublicFragmentActivity.start(ZplanSettingFragmentV2.this.getQBaseActivity(), ZplanSettingPrivacyFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QPublicFragmentActivity.start(ZplanSettingFragmentV2.this.getQBaseActivity(), ZplanSettingCommonFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = ZplanSettingFragmentV2.this.getContext();
            if (context == null) {
                return;
            }
            ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, "mqqapi://zplan/openPage?src_type=app&version=1.0&pageID=8&pageData=%7B%22uid%22%3A%22" + ZplanSettingFragmentV2.this.C + "%22%7D");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class j implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f333552d;

        j(String str) {
            this.f333552d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f333552d)) {
                QLog.e("ZplanSettingFragmentV2", 1, "JoinGroup url == null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("url", this.f333552d);
            RouteUtils.startActivity(view.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class l implements y.a {
        l() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingFragmentV2.this.ki(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class m implements y.a {
        m() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingFragmentV2.this.li(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class n implements y.a {
        n() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton compoundButton, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            ZplanSettingFragmentV2.this.mi(compoundButton.isChecked(), z16, onCheckedChangeListener);
        }
    }

    private void Jh() {
        Intent intent = getQBaseActivity().getActivity().getIntent();
        if (intent == null) {
            return;
        }
        if (IZPlanApi.FROM_QQ_SETTING.equals(intent.getStringExtra("FROM"))) {
            this.P = "qqsetting";
        } else {
            this.P = "setting";
        }
        t74.r.c(this.P, "feeds", "expo", null);
    }

    private void Kh() {
        if (!a.c.c(((AppInterface) getQBaseActivity().getAppRuntime()).getLongAccountUin())) {
            QLog.d("ZplanSettingFragmentV2", 1, "[aioAvatarSwitch]Judge\u4e0d\u5141\u8bb8\u5c55\u793a\u5f00\u5173");
            return;
        }
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r7s);
        this.K = formSwitchItem;
        if (formSwitchItem == null) {
            return;
        }
        FormSwitchItem formSwitchItem2 = this.J;
        if (formSwitchItem2 != null) {
            formSwitchItem2.setBgType(2);
        }
        Lh();
        formSwitchItem.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), formSwitchItem, new a(formSwitchItem)));
        formSwitchItem.setBgType(3);
        formSwitchItem.setVisibility(0);
    }

    private void Lh() {
        boolean d16 = a.c.d();
        QLog.d("ZplanSettingFragmentV2", 1, "[aioAvatarSwitch]initAioAvatarSwitch: " + d16);
        FormSwitchItem formSwitchItem = this.K;
        if (formSwitchItem != null) {
            formSwitchItem.setChecked(d16);
        }
    }

    private void Mh() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r7t, R.string.xtg);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new e());
    }

    private void Nh() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r7w, R.string.xtj);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new h());
    }

    private void Oh() {
        boolean enableZPlanFilamentBase = ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase(null);
        boolean h16 = QQSettingMeABTestHelper.e().h();
        if (enableZPlanFilamentBase && h16 && QQSettingMeABTestHelper.c()) {
            FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r7x);
            this.L = formSwitchItem;
            if (formSwitchItem == null) {
                return;
            }
            FormSwitchItem formSwitchItem2 = this.J;
            if (formSwitchItem2 != null) {
                formSwitchItem2.setBgType(2);
            }
            FormSwitchItem formSwitchItem3 = this.K;
            if (formSwitchItem3 != null) {
                formSwitchItem3.setBgType(2);
            }
            Ph();
            this.L.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.L, new b()));
            this.L.setBgType(3);
            this.L.setVisibility(0);
        }
    }

    private void Ph() {
        boolean b16 = com.tencent.mobileqq.zplan.setting.c.b();
        QLog.d("ZplanSettingFragmentV2", 2, "initDrawerSwitchChecked: " + b16);
        FormSwitchItem formSwitchItem = this.L;
        if (formSwitchItem != null) {
            formSwitchItem.setChecked(b16);
        }
    }

    private void Qh() {
        boolean h16 = com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.DYNAMIC_SETTING);
        QLog.d("ZplanSettingFragmentV2", 2, "initQzoneSwitch: " + h16);
        FormSwitchItem formSwitchItem = this.J;
        if (formSwitchItem != null) {
            formSwitchItem.setChecked(h16);
        }
    }

    private void Rh() {
        FormSimpleItem formSimpleItem = (FormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r7y);
        if (formSimpleItem == null) {
            return;
        }
        String zplanSettingFeedbackName = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZplanSettingFeedbackName();
        formSimpleItem.setLeftText(zplanSettingFeedbackName);
        formSimpleItem.setContentDescription(zplanSettingFeedbackName);
        formSimpleItem.setOnClickListener(new d());
    }

    private void Sh() {
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("key_hot_patch_version", "");
        if (string.isEmpty()) {
            return;
        }
        TextView textView = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163643r80);
        textView.setVisibility(0);
        textView.setText("\u5f53\u524d\u7248\u672c\uff1a".concat(string));
    }

    private void Th() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.f163644r81, R.string.xtr);
        if (c16 == null) {
            return;
        }
        ZPlanSettingOfficialGroupEntranceConfig settingOfficialGroupEntranceConfig = ZPlanQQMC.INSTANCE.getSettingOfficialGroupEntranceConfig();
        QLog.i("ZplanSettingFragmentV2", 1, "joinGroupConfBean=" + settingOfficialGroupEntranceConfig);
        if (settingOfficialGroupEntranceConfig.getShowEntrance() != 1) {
            c16.setVisibility(8);
            return;
        }
        c16.setLeftText(settingOfficialGroupEntranceConfig.getEntranceName());
        c16.setOnClickListener(new j(settingOfficialGroupEntranceConfig.getUrl()));
        c16.setVisibility(0);
    }

    private void Uh() {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r8b);
        this.H = formSwitchItem;
        if (formSwitchItem == null) {
            return;
        }
        boolean e16 = com.tencent.mobileqq.zplan.setting.c.e();
        QLog.d("ZplanSettingFragmentV2", 1, "initMasterSwitch: " + e16);
        this.H.setChecked(e16);
        ni(e16);
        this.H.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.H, new l()));
        this.H.setBgType(0);
    }

    private void Vh() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.f163647r84, R.string.xtu);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new g());
    }

    private void Wh() {
        boolean isZplanAccessibleWithoutSetting = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(1004L, ((AppInterface) getQBaseActivity().getAppRuntime()).getLongAccountUin());
        boolean enableZPlanNativeAppFilament = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(2);
        if (isZplanAccessibleWithoutSetting && enableZPlanNativeAppFilament) {
            FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r85);
            this.I = formSwitchItem;
            if (formSwitchItem == null) {
                return;
            }
            Yh();
            this.I.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.I, new m()));
            this.I.setBgType(1);
            this.I.setVisibility(0);
        }
    }

    private void Xh() {
        this.D = (RelativeLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qdz);
        this.E = (QQProAvatarView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.pax);
        this.F = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.q_k);
        URLImageView uRLImageView = (URLImageView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.pnc);
        this.G = uRLImageView;
        RelativeLayout relativeLayout = this.D;
        if (relativeLayout == null || this.E == null || this.F == null || uRLImageView == null) {
            return;
        }
        relativeLayout.setOnClickListener(new i());
        this.D.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.2
            @Override // java.lang.Runnable
            public void run() {
                int width = ZplanSettingFragmentV2.this.D.getWidth();
                RelativeLayout relativeLayout2 = (RelativeLayout) ((QIphoneTitleBarFragment) ZplanSettingFragmentV2.this).mContentView.findViewById(R.id.qvw);
                if (relativeLayout2 != null) {
                    width = relativeLayout2.getLeft();
                }
                ZplanSettingFragmentV2.this.F.setMaxWidth((ZplanSettingFragmentV2.this.D.getWidth() - ZplanSettingFragmentV2.this.F.getLeft()) - width);
            }
        });
        String str = this.C;
        if (str == null) {
            QLog.e("ZplanSettingFragmentV2", 1, "mUin is null");
        } else {
            this.E.w(1, str);
        }
        aw4.a aVar = new aw4.a();
        aVar.f27087a = Long.parseLong(this.C);
        jc4.d.f409800a.a(aVar, new k(), 0);
    }

    private void Yh() {
        boolean h16 = com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.PROFILE_CARD_SETTING);
        QLog.d("ZplanSettingFragmentV2", 2, "initProfileCardSwitch: " + h16);
        FormSwitchItem formSwitchItem = this.I;
        if (formSwitchItem != null) {
            formSwitchItem.setChecked(h16);
        }
    }

    private void Zh() {
        boolean enableZPlanQuality = ZPlanQQMC.INSTANCE.enableZPlanQuality();
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r86, R.string.xtz);
        this.M = c16;
        if (c16 == null) {
            return;
        }
        fi();
        this.M.setOnClickListener(new f());
        this.M.setVisibility(enableZPlanQuality ? 0 : 8);
    }

    private void ai() {
        boolean isZplanAccessibleWithoutSetting = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(Constant.FROM_ID_UNINSTALL_PLUGIN, ((AppInterface) getQBaseActivity().getAppRuntime()).getLongAccountUin());
        boolean f16 = QQSettingMeABTestHelper.e().f();
        boolean enableZPlanNativeAppFilament = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(0);
        if (isZplanAccessibleWithoutSetting && !f16 && enableZPlanNativeAppFilament) {
            FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r87);
            this.J = formSwitchItem;
            if (formSwitchItem == null) {
                return;
            }
            String zplanSettingQzoneSwitchName = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZplanSettingQzoneSwitchName();
            this.J.setText(zplanSettingQzoneSwitchName);
            this.J.setContentDescription(zplanSettingQzoneSwitchName);
            Qh();
            this.J.setOnCheckedChangeListener(com.tencent.mobileqq.zplan.utils.y.d(getQBaseActivity(), this.J, new n()));
            this.J.setBgType(3);
            this.J.setVisibility(0);
        }
    }

    private void bi() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r88, R.string.xui);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new c());
    }

    private void ci() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r8c, R.string.xtk);
        if (c16 == null) {
            return;
        }
        if (!com.tencent.mobileqq.zplan.setting.c.j()) {
            c16.setVisibility(8);
        } else {
            c16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.fragment.ac
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZplanSettingFragmentV2.this.ei(view);
                }
            });
            c16.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ei(View view) {
        Intent intent = new Intent();
        intent.putExtra("FROM", this.P);
        QPublicFragmentActivity.start(getQBaseActivity(), intent, ZplanViewContractFragment.class);
    }

    private void fi() {
        if (this.M == null) {
            return;
        }
        int c16 = com.tencent.mobileqq.zplan.setting.c.c(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, -1);
        QLog.d("ZplanSettingFragmentV2", 4, "refreshQualityRightText qualityType:" + c16);
        this.M.setRightText(getString(com.tencent.mobileqq.zplan.setting.a.a(c16)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi() {
        Qh();
        Yh();
        Lh();
        Ph();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi(final FormSwitchItem formSwitchItem, final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        a.c.e(z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.11
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingFragmentV2", 1, "setAioAvatarSwitch success=" + z18 + ", isChecked=" + z17);
                if (z18) {
                    return;
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingFragmentV2.this.getQBaseActivity(), R.string.xtm, 1);
                        AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                        com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        ZplanDataRepository.f334898a.p(1006L, z17);
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.DRAWER_SETTING, z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.13
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingFragmentV2", 1, "setDrawerSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingFragmentV2.this.getQBaseActivity(), R.string.xtm, 1);
                            com.tencent.mobileqq.zplan.utils.y.e(ZplanSettingFragmentV2.this.L, !z16, onCheckedChangeListener);
                            ZplanDataRepository.f334898a.p(1006L, !z17);
                        }
                    });
                } else {
                    com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DRAWER_SETTING, z17);
                }
            }
        });
    }

    private void initViews() {
        Xh();
        Wh();
        ai();
        Kh();
        Oh();
        Uh();
        Rh();
        Mh();
        Zh();
        bi();
        Vh();
        Nh();
        Th();
        ci();
        Sh();
    }

    private void ji() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_zplan_qq_setting");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, new PageParams(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
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
        com.tencent.mobileqq.zplan.setting.e.f335451a.g(arrayList, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.5
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingFragmentV2", 1, "setSettingMasterSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingFragmentV2.this.getQBaseActivity(), R.string.xtm, 1);
                            FormSwitchItem formSwitchItem = ZplanSettingFragmentV2.this.H;
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
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
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        ZplanSettingFragmentV2.this.ni(z17);
                        ZplanSettingFragmentV2.this.gi();
                    }
                });
                ZplanSettingFragmentV2.this.oi(z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.PROFILE_CARD_SETTING, z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.7
            @Override // nk3.a
            public void onResult(boolean z18) {
                QLog.d("ZplanSettingFragmentV2", 1, "setSettingProfileCardSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingFragmentV2.this.getQBaseActivity(), R.string.xtm, 1);
                            FormSwitchItem formSwitchItem = ZplanSettingFragmentV2.this.I;
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                        }
                    });
                    return;
                }
                com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.PROFILE_CARD_SETTING, z17);
                ZplanSettingFragmentV2.this.qi(z17, 1004L);
                ZplanDataRepository.f334898a.p(1004L, !z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(boolean z16) {
        pi(this.I, z16);
        pi(this.J, z16);
        pi(this.K, z16);
        pi(this.L, z16);
        pi(((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r89), !(this.I == null && this.J == null && this.K == null && this.L == null) && z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(boolean z16, long j3) {
        AccessibleDetail zplanAccessibleDetail = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).getZplanAccessibleDetail(j3, ((AppInterface) getQBaseActivity().getAppRuntime()).getLongAccountUin());
        if (zplanAccessibleDetail == null) {
            return;
        }
        zplanAccessibleDetail.settingPass = z16 ? 1 : 0;
        ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).updateCache(zplanAccessibleDetail);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.N = new Handler(Looper.getMainLooper());
        try {
            SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
            if (firstSimpleAccount != null) {
                this.C = firstSimpleAccount.getUin();
            }
        } catch (Throwable th5) {
            QLog.e("ZplanSettingFragmentV2", 1, "getUin() failed." + th5.getMessage(), th5.toString());
        }
        setTitle(((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZplanSettingTitle());
        this.quiSecNavBar.setBlur(false, ((QIphoneTitleBarFragment) this).mContentView);
        AppInterface appInterface = (AppInterface) getQBaseActivity().getAppRuntime();
        com.tencent.mobileqq.zplan.setting.e eVar = com.tencent.mobileqq.zplan.setting.e.f335451a;
        eVar.b(appInterface, null);
        eVar.d(new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ab
            @Override // nk3.a
            public final void onResult(boolean z16) {
                ZplanSettingFragmentV2.this.di(z16);
            }
        });
        initViews();
        Jh();
        ji();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d2q;
    }

    protected void mi(final boolean z16, final boolean z17, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.DYNAMIC_SETTING, z17, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.9
            @Override // nk3.a
            public void onResult(boolean z18) {
                String str;
                QLog.d("ZplanSettingFragmentV2", 1, "setSettingQzoneSwitch success=" + z18 + ", isChecked=" + z17);
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.zplan.utils.y.g(ZplanSettingFragmentV2.this.getQBaseActivity(), R.string.xtm, 1);
                            FormSwitchItem formSwitchItem = ZplanSettingFragmentV2.this.J;
                            AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                            com.tencent.mobileqq.zplan.utils.y.e(formSwitchItem, true ^ z16, onCheckedChangeListener);
                        }
                    });
                    return;
                }
                com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DYNAMIC_SETTING, z17);
                ZplanSettingFragmentV2.this.qi(z17, Constant.FROM_ID_UNINSTALL_PLUGIN);
                String str2 = ZplanSettingFragmentV2.this.P;
                if (z17) {
                    str = "open";
                } else {
                    str = "close";
                }
                t74.r.c(str2, "feeds", str, null);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.d("ZplanSettingFragmentV2", 1, "onDestroyView");
        this.N.removeCallbacksAndMessages(null);
        this.N = null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        fi();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean secNavBarNeedImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.d("ZplanSettingFragmentV2", 1, "onBackEvent");
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void di(boolean z16) {
        if (z16) {
            ci();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(boolean z16) {
        if (!z16) {
            qi(false, 1004L);
            qi(false, Constant.FROM_ID_UNINSTALL_PLUGIN);
        } else {
            qi(com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.PROFILE_CARD_SETTING), 1004L);
            qi(com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.DYNAMIC_SETTING), Constant.FROM_ID_UNINSTALL_PLUGIN);
        }
    }

    protected void pi(View view, boolean z16) {
        if (view == null) {
            return;
        }
        view.setVisibility(z16 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class k implements com.tencent.mobileqq.zootopia.api.e<aw4.b> {
        k() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(aw4.b bVar) {
            String str = "";
            String str2 = "";
            for (hu4.e eVar : bVar.f27088a.f406373z) {
                int i3 = eVar.f406348a;
                if (i3 == 3) {
                    str = eVar.f406349b;
                } else if (i3 == 4) {
                    str2 = eVar.f406349b;
                }
            }
            Locale locale = Locale.getDefault();
            hu4.f fVar = bVar.f27088a;
            QLog.d("ZplanSettingFragmentV2", 1, String.format(locale, "nick: %s, authenticaType: %d, personalUrl: %s, companyUrl: %s", fVar.f406351b, Integer.valueOf(fVar.f406365p), str, str2));
            ZplanSettingFragmentV2.this.F.setText(bVar.f27088a.f406351b);
            ZplanSettingFragmentV2.this.G.setURLDrawableDownListener(new a());
            int i16 = bVar.f27088a.f406365p;
            if (i16 == 1) {
                ZplanSettingFragmentV2.this.G.setImageURL(str);
                ZplanSettingFragmentV2.this.G.setVisibility(0);
            } else if (i16 != 2) {
                ZplanSettingFragmentV2.this.G.setVisibility(8);
            } else {
                ZplanSettingFragmentV2.this.G.setImageURL(str2);
                ZplanSettingFragmentV2.this.G.setVisibility(0);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int i3, String str) {
            QLog.e("ZplanSettingFragmentV2", 1, "doPersonIndexReq() failed. cmd: trpc.metaverse.ugc_store_svr.UgcStoreSvr, error: " + i3 + ", message: " + str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes34.dex */
        public class a implements URLDrawableDownListener {
            a() {
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
                int intrinsicWidth = (uRLDrawable.getIntrinsicWidth() / uRLDrawable.getIntrinsicHeight()) * ZplanSettingFragmentV2.this.G.getHeight();
                ZplanSettingFragmentV2.this.G.setMaxWidth(intrinsicWidth);
                ZplanSettingFragmentV2.this.G.setMinimumWidth(intrinsicWidth);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            }
        }
    }
}
