package com.tencent.hippy.qq.messagetabad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MessageTabAdFragment extends CommonHippyFragment {
    private static final long SHOW_UI_TIME_OUT_IN_MILLISECONDS = 3000;
    private static final String TAG = "MessageTabAdFragment";
    private long firstResumeTime = 0;

    private void closePage() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            qBaseActivity.finish();
        }
    }

    private boolean hasUI() {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null && hippyQQPreloadEngine.getHippyRootView() != null && this.mHippyQQEngine.getHippyRootView().getChildCount() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onClickRootView(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void onClickRootView(View view) {
        if (hasUI()) {
            view.setOnClickListener(null);
        } else if (System.currentTimeMillis() - this.firstResumeTime > 3000) {
            QLog.e(TAG, 1, "onClick no ui about 3s, so close it");
            reportNoUI();
            closePage();
        }
    }

    private void reportNoUI() {
        boolean z16;
        boolean z17;
        int i3;
        String str;
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            z16 = hippyQQPreloadEngine.isPreloaded();
            z17 = this.mHippyQQEngine.isPredraw();
            str = this.mHippyQQEngine.getModuleName();
            i3 = this.mHippyQQEngine.getModuleVersion();
        } else {
            z16 = false;
            z17 = false;
            i3 = 0;
            str = "";
        }
        HashMap<String, Long> generateStepCosts = generateStepCosts();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ret", 1);
        hashMap.put("errMsg", getLastStepName());
        hashMap.put("isPreload", Boolean.valueOf(z16));
        hashMap.put("isPredraw", Boolean.valueOf(z17));
        hashMap.put("from", getParameters().getString("from"));
        HippyReporter.getInstance().reportHippyLoadResult(6, str, i3, hashMap, generateStepCosts, null);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.hippy.qq.messagetabad.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageTabAdFragment.this.lambda$onCreateView$0(view);
            }
        });
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippyError(int i3, String str) {
        QLog.e(TAG, 1, "onLoadHippyError close it");
        closePage();
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.firstResumeTime == 0) {
            this.firstResumeTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
