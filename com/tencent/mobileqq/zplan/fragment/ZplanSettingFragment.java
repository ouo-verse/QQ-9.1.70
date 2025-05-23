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
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanSettingOfficialGroupEntranceConfig;
import com.tencent.state.report.SquareReportConst;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ZplanSettingFragment extends QIphoneTitleBarFragment {
    private AppInterface C;
    private FormSimpleItem D;
    private Handler E;
    private String F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = ZplanSettingFragment.this.getContext();
            if (context != null) {
                ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).u0(context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b implements View.OnClickListener {
        b() {
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
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("FROM", ZplanSettingFragment.this.F);
            QPublicFragmentActivity.start(ZplanSettingFragment.this.getQBaseActivity(), intent, NewZplanSettingAvatarShowFragment.class);
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
            QPublicFragmentActivity.start(ZplanSettingFragment.this.getQBaseActivity(), ZplanSettingQualityFragment.class);
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
            QPublicFragmentActivity.start(ZplanSettingFragment.this.getQBaseActivity(), ZplanSettingPrivacyFragment.class);
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
            QPublicFragmentActivity.start(ZplanSettingFragment.this.getQBaseActivity(), ZplanSettingCommonFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f333513d;

        g(String str) {
            this.f333513d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f333513d)) {
                QLog.e("ZplanSettingFragment", 1, "JoinGroup url == null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("url", this.f333513d);
            RouteUtils.startActivity(view.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
        }
    }

    private void Ah() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r88, R.string.xui);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new a());
    }

    private void Bh() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r8c, R.string.xtk);
        if (c16 == null) {
            return;
        }
        if (!com.tencent.mobileqq.zplan.setting.c.j()) {
            c16.setVisibility(8);
        } else {
            c16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.fragment.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZplanSettingFragment.this.Dh(view);
                }
            });
            c16.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dh(View view) {
        Intent intent = new Intent();
        intent.putExtra("FROM", this.F);
        QPublicFragmentActivity.start(getQBaseActivity(), intent, ZplanViewContractFragment.class);
    }

    private void Eh() {
        if (this.D == null) {
            return;
        }
        int c16 = com.tencent.mobileqq.zplan.setting.c.c(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, -1);
        QLog.d("ZplanSettingFragment", 4, "refreshQualityRightText qualityType:" + c16);
        this.D.setRightText(getString(com.tencent.mobileqq.zplan.setting.a.a(c16)));
    }

    private void Fh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_zplan_qq_setting");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, new PageParams(hashMap));
    }

    private void initViews() {
        vh();
        th();
        zh();
        Ah();
        yh();
        uh();
        xh();
        Bh();
        wh();
    }

    private void sh() {
        Intent intent = getQBaseActivity().getActivity().getIntent();
        if (intent == null) {
            return;
        }
        if (IZPlanApi.FROM_QQ_SETTING.equals(intent.getStringExtra("FROM"))) {
            this.F = "qqsetting";
        } else {
            this.F = "setting";
        }
        t74.r.c(this.F, "feeds", "expo", null);
    }

    private void th() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r7t, R.string.xtg);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new c());
    }

    private void uh() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r7w, R.string.xtj);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new f());
    }

    private void vh() {
        FormSimpleItem formSimpleItem = (FormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r7y);
        if (formSimpleItem == null) {
            return;
        }
        String zplanSettingFeedbackName = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZplanSettingFeedbackName();
        formSimpleItem.setLeftText(zplanSettingFeedbackName);
        formSimpleItem.setContentDescription(zplanSettingFeedbackName);
        formSimpleItem.setOnClickListener(new b());
    }

    private void wh() {
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("key_hot_patch_version", "");
        if (string.isEmpty()) {
            return;
        }
        TextView textView = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163643r80);
        textView.setVisibility(0);
        textView.setText("\u5f53\u524d\u7248\u672c\uff1a".concat(string));
    }

    private void xh() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.f163644r81, R.string.xtr);
        if (c16 == null) {
            return;
        }
        ZPlanSettingOfficialGroupEntranceConfig settingOfficialGroupEntranceConfig = ZPlanQQMC.INSTANCE.getSettingOfficialGroupEntranceConfig();
        QLog.i("ZplanSettingFragment", 1, "joinGroupConfBean=" + settingOfficialGroupEntranceConfig);
        if (settingOfficialGroupEntranceConfig.getShowEntrance() != 1) {
            c16.setVisibility(8);
            return;
        }
        c16.setLeftText(settingOfficialGroupEntranceConfig.getEntranceName());
        c16.setOnClickListener(new g(settingOfficialGroupEntranceConfig.getUrl()));
        c16.setVisibility(0);
    }

    private void yh() {
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.f163647r84, R.string.xtu);
        if (c16 == null) {
            return;
        }
        c16.setOnClickListener(new e());
    }

    private void zh() {
        boolean enableZPlanQuality = ZPlanQQMC.INSTANCE.enableZPlanQuality();
        FormSimpleItem c16 = com.tencent.mobileqq.zplan.utils.y.c(((QIphoneTitleBarFragment) this).mContentView, R.id.r86, R.string.xtz);
        this.D = c16;
        if (c16 == null) {
            return;
        }
        Eh();
        this.D.setOnClickListener(new d());
        this.D.setVisibility(enableZPlanQuality ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = (AppInterface) getQBaseActivity().getAppRuntime();
        this.E = new Handler(Looper.getMainLooper());
        setTitle(((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZplanSettingTitle());
        com.tencent.mobileqq.zplan.setting.e eVar = com.tencent.mobileqq.zplan.setting.e.f335451a;
        eVar.b(this.C, null);
        eVar.d(new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.z
            @Override // nk3.a
            public final void onResult(boolean z16) {
                ZplanSettingFragment.this.Ch(z16);
            }
        });
        initViews();
        sh();
        Fh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d2l;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.d("ZplanSettingFragment", 1, "onDestroyView");
        this.E.removeCallbacksAndMessages(null);
        this.E = null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Eh();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.d("ZplanSettingFragment", 1, "onBackEvent");
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ch(boolean z16) {
        if (z16) {
            Bh();
        }
    }
}
