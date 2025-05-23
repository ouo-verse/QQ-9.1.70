package com.tencent.mobileqq.minigame.api.impl;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HippyJumpGuildFragment extends QPublicBaseFragment {
    private static final String TAG = "HippyJumpGuildFragment";
    private boolean isFirst = true;
    private String appId = "";
    private String businessId = "";

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.d(TAG, 2, "onCreate");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String stringExtra = activity.getIntent().getStringExtra("url");
            this.appId = activity.getIntent().getStringExtra("appId");
            this.businessId = activity.getIntent().getStringExtra("businessId");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "url:", stringExtra, " appId:", this.appId, " businessId:", this.businessId);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof BaseQQAppInterface) {
                bi.c((BaseQQAppInterface) peekAppRuntime, activity, stringExtra).b();
            } else {
                QLog.e(TAG, 1, "onCreate not support other process");
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.d(TAG, 2, "onResume");
        if (!this.isFirst) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(getContext(), this.appId, "", "", LaunchScene.LAUNCH_SCENE_GAME_CENTER_FROM_GUILD, null);
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
        }
        this.isFirst = false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
