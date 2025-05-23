package com.tencent.mobileqq.profilecard.more;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;
import ne0.a;

/* loaded from: classes35.dex */
public class ProfileCardMoreFragment extends QIphoneTitleBarFragment {
    private static final String TAG = "ProfileCardMoreFragment";
    private AllInOne mAllInOne;
    private AppInterface mApp;
    private ProfileCardMoreController mMoreController;

    private int getPageBackgroundColor() {
        return ThemeUtil.isNowThemeIsNight(this.mApp, false, null) ? -16777216 : -1;
    }

    private void initData() {
        this.mApp = (AppInterface) getQBaseActivity().getAppRuntime();
        Intent intent = getQBaseActivity().getIntent();
        if (intent != null) {
            this.mAllInOne = (AllInOne) intent.getParcelableExtra(ProfileCardMoreConstants.KEY_ALL_IN_ONE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null && this.titleRoot != null) {
            this.mMoreController = new ProfileCardMoreController((ViewGroup) view.findViewById(R.id.otx), this.mApp, getQBaseActivity(), this.mAllInOne);
            setTitle(getResources().getString(R.string.x5q));
            ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.owx).setBackgroundColor(getPageBackgroundColor());
            initDtPageReport();
            this.mMoreController.onCreate(layoutInflater);
            this.mMoreController.initDtElementReport(this.leftView, ProfileCardMoreConstants.DT_EM_PROFILE_MORE_BACK, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_FIRST);
            this.leftView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.more.ProfileCardMoreFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    VideoReport.reportEvent("dt_clck", ProfileCardMoreFragment.this.leftView, null);
                    ProfileCardMoreFragment.this.onBackEvent();
                }
            });
            return;
        }
        QLog.e(TAG, 1, "mContentView == null || titleRoot == null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.czb;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    public void initDtPageReport() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.titleRoot, ProfileCardMoreConstants.DT_PG_USER_PROFILE_NEW_MORE);
        HashMap hashMap = new HashMap();
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        hashMap.put("is_qq_fri", Integer.valueOf(profileCardMoreController.isFriend(profileCardMoreController.mTargetUin) ? 1 : 2));
        hashMap.put("user_profile_host_guest_type", Integer.valueOf(this.mMoreController.isSelf() ? 1 : 2));
        setPageParams(((QIphoneTitleBarFragment) this).mContentView, hashMap);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        activity.getWindow().getDecorView().setBackgroundColor(getPageBackgroundColor());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null) {
            profileCardMoreController.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null) {
            profileCardMoreController.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null) {
            profileCardMoreController.onPause();
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null) {
            profileCardMoreController.onResume();
        }
        super.onResume();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null) {
            profileCardMoreController.onStart();
        }
        super.onStart();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null) {
            profileCardMoreController.onStop();
        }
        super.onStop();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    public static void openProfileCardMore(Activity activity, Intent intent, int i3) {
        if (activity == null) {
            QLog.e(TAG, 1, "activity is null");
        } else {
            QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ProfileCardMoreFragment.class, i3);
        }
    }

    private static void setPageParams(Object obj, Map<String, Object> map) {
        if (obj == null || map == null || map.size() == 0) {
            return;
        }
        VideoReport.setPageParams(obj, new PageParams((Map<String, ?>) map));
    }
}
