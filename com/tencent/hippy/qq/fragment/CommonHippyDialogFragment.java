package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CommonHippyDialogFragment extends BaseHippyFragment implements Handler.Callback {
    private static final int LOAD_HIPPY_TIME_OUT_TIME = 9000;
    private static final int MSG_TIME_OUT = 1;
    public static final String TAG = "CommonHippyDialogFragment";
    private Handler mHandler;
    private ViewGroup mHippyContainer;
    private HippyProgressBarWrapper mProgressBarWrapper = new HippyProgressBarWrapper();
    protected ViewGroup mRootView;

    private void reportTimeOut() {
        if (this.mHippyQQEngine == null) {
            return;
        }
        HashMap<String, Long> generateStepCosts = generateStepCosts();
        HashMap<String, Object> hashMap = new HashMap<>();
        boolean z16 = false;
        hashMap.put("ret", 0);
        hashMap.put("errMsg", getLastStepName());
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            z16 = hippyQQPreloadEngine.isPreloaded();
        }
        hashMap.put("isPreload", Boolean.valueOf(z16));
        hashMap.put("from", getParameters().getString("from"));
        HippyReporter.getInstance().reportHippyLoadResult(6, this.mHippyQQEngine.getModuleName(), this.mHippyQQEngine.getModuleVersion(), hashMap, generateStepCosts, null);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    protected JSONObject doBussinessInitData(JSONObject jSONObject) {
        SerializableMap serializableMap;
        try {
            Bundle parameters = getParameters();
            if (parameters != null && (serializableMap = (SerializableMap) parameters.getSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP)) != null) {
                JSONObject wrapHashMap = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).wrapHashMap(jSONObject, serializableMap.getMap());
                if (wrapHashMap != null) {
                    return wrapHashMap;
                }
                return jSONObject;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "doBussinessInitData:" + th5);
        }
        return jSONObject;
    }

    protected int getLayoutResId() {
        return R.layout.dqs;
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        QLog.d(TAG, 1, "Hippy: load timeout");
        if (!isFragmentDestroyed()) {
            gotoErrorUrl();
        }
        if (this.mHippyQQEngine != null) {
            reportTimeOut();
        }
        return true;
    }

    protected void initProgressBar(ViewGroup viewGroup) {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null && !hippyQQPreloadEngine.isNeedShowLoading()) {
            return;
        }
        this.mProgressBarWrapper.initProgressBar(viewGroup);
        this.mProgressBarWrapper.startProgressBar();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        setWindowFlag(getQBaseActivity(), 16777216);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        QLog.d(TAG, 1, "onCreateView...");
        try {
            setWindowFlag(getQBaseActivity(), 16777216);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "onCreateView setWindowFlag e:" + th5);
        }
        this.mHandler = new Handler(this);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(getLayoutResId(), (ViewGroup) null, false);
        this.mRootView = viewGroup2;
        this.mHippyContainer = (ViewGroup) viewGroup2.findViewById(R.id.x_x);
        int i3 = getParameters().getInt(HippyQQConstants.PARAMS_PAGE_HEIGHT);
        QLog.d(TAG, 1, "onCreateView...height=" + i3);
        if (i3 > 0) {
            ViewGroup.LayoutParams layoutParams = this.mHippyContainer.getLayoutParams();
            layoutParams.height = i3;
            this.mHippyContainer.setLayoutParams(layoutParams);
        }
        loadHippy(this.mHippyContainer);
        setStatusBarImmersive();
        initProgressBar(this.mRootView);
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null && !hippyQQPreloadEngine.isPredraw()) {
            this.mHandler.sendEmptyMessageDelayed(1, MiniGamePAHippyBaseFragment.LOAD_HIPPY_TIME_OUT);
        }
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.hippy.qq.fragment.CommonHippyDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QBaseActivity qBaseActivity = CommonHippyDialogFragment.this.getQBaseActivity();
                if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                    qBaseActivity.finish();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        ViewGroup viewGroup3 = this.mRootView;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup3);
        return viewGroup3;
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    protected void onLoadHippyError(int i3, String str) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.mProgressBarWrapper.hideProgressBar();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    protected void onLoadHippySuccess() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.mProgressBarWrapper.hideProgressBar();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            com.tencent.mobileqq.qwallet.utils.d.b(getQBaseActivity(), getParameters().getBoolean(OpenHippyInfo.EXTRA_KEY_IS_STATUSBAR_DARKFONT));
        }
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    protected void setStatusBarImmersive() {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
                SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
        }
    }

    protected void setWindowFlag(Activity activity, int i3) {
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().setFlags(i3, i3);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
