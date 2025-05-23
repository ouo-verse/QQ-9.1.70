package com.tencent.hippy.qq.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.detection.DetectionPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CommonHippyFragment extends BaseHippyFragment implements Handler.Callback {
    private static final int LOAD_HIPPY_TIME_OUT_TIME = 9000;
    private static final int MSG_TIME_OUT = 1;
    private Handler mHandler;
    private ViewGroup mHippyContainer;
    private boolean mIsAddNightModeMaskView;
    private LayoutInflater mLayoutInflater;
    protected ViewGroup mRootView;
    private HippyProgressBarWrapper mProgressBarWrapper = new HippyProgressBarWrapper();
    private HippyErrorViewWrapper mErrorViewWrapper = new HippyErrorViewWrapper();

    private void addNightModeMask() {
        FragmentActivity activity = getActivity();
        if (!this.mIsAddNightModeMaskView && activity != null && !getParameters().getBoolean(OpenHippyInfo.EXTRA_KEY_IS_CUSTOM_NIGHT_MODE) && QQTheme.isNowThemeIsNight()) {
            View view = new View(activity);
            view.setId(R.id.f_1);
            view.setBackgroundColor(1711276032);
            ((ViewGroup) activity.getWindow().getDecorView()).addView(view, new RelativeLayout.LayoutParams(-1, -1));
            this.mIsAddNightModeMaskView = true;
        }
    }

    private void handleFullScreen(Activity activity) {
        try {
            if (getParameters().getBoolean(OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN)) {
                activity.getWindow().addFlags(1024);
                activity.getWindow().addFlags(67108864);
                activity.getWindow().getDecorView().setSystemUiVisibility(5894);
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                if (Build.VERSION.SDK_INT >= 28) {
                    attributes.layoutInDisplayCutoutMode = 1;
                }
                activity.getWindow().setAttributes(attributes);
            }
        } catch (Throwable th5) {
            QLog.e("BaseHippyFragment", 1, th5, new Object[0]);
        }
    }

    private void prepareForDTReport() {
        if (!DetectionPolicy.isAbleToDetect(getActivity())) {
            VideoReport.addToDetectionWhitelist(getActivity());
        }
    }

    private void removeMaskView() {
        FragmentActivity activity;
        ViewGroup viewGroup;
        View findViewById;
        if (this.mIsAddNightModeMaskView && (activity = getActivity()) != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null && (findViewById = (viewGroup = (ViewGroup) activity.getWindow().getDecorView()).findViewById(R.id.f_1)) != null) {
            viewGroup.removeView(findViewById);
        }
    }

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

    private void setBackgroundColor(View view) {
        try {
            String string = getParameters().getString("backgroundColor");
            if (!TextUtils.isEmpty(string)) {
                view.setBackgroundColor(Color.parseColor(string));
            } else if (getParameters().getBoolean(OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT)) {
                view.setBackgroundColor(0);
            }
        } catch (IllegalArgumentException e16) {
            QLog.e("BaseHippyFragment", 1, "setBackgroundColor e:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    public JSONObject doBussinessInitData(JSONObject jSONObject) {
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
            QLog.e("BaseHippyFragment", 1, "doBussinessInitData:" + th5);
        }
        return jSONObject;
    }

    protected int getLayoutResId() {
        return R.layout.dqt;
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
        QLog.d("BaseHippyFragment", 1, "Hippy: load timeout");
        if (!isFragmentDestroyed()) {
            gotoErrorUrl();
        }
        if (this.mHippyQQEngine != null) {
            reportTimeOut();
        }
        return true;
    }

    protected void initNetworkErrorView(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R.id.uws);
        if (frameLayout.getVisibility() != 0) {
            frameLayout.setVisibility(0);
        }
        this.mErrorViewWrapper.initNetworkErrorView(frameLayout, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initProgressBar(ViewGroup viewGroup) {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null && !hippyQQPreloadEngine.isNeedShowLoading()) {
            return;
        }
        this.mProgressBarWrapper.initProgressBar(viewGroup);
        this.mProgressBarWrapper.startProgressBar();
    }

    protected void initViews() {
        this.mHippyContainer = (ViewGroup) this.mRootView.findViewById(R.id.x_x);
        setBackgroundColor(this.mRootView);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    @SuppressLint({"WrongConstant"})
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        setWindowFlag(getQBaseActivity(), 16777216);
        handleFullScreen(activity);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        try {
            setWindowFlag(getQBaseActivity(), 16777216);
        } catch (Throwable th5) {
            QLog.e("BaseHippyFragment", 1, "onCreateView setWindowFlag e:" + th5);
        }
        this.mHandler = new Handler(this);
        this.mLayoutInflater = layoutInflater;
        this.mRootView = (ViewGroup) layoutInflater.inflate(getLayoutResId(), (ViewGroup) null, false);
        initViews();
        loadHippy(this.mHippyContainer);
        setStatusBarImmersive();
        initProgressBar(this.mRootView);
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null && !hippyQQPreloadEngine.isPredraw()) {
            this.mHandler.sendEmptyMessageDelayed(1, MiniGamePAHippyBaseFragment.LOAD_HIPPY_TIME_OUT);
        }
        prepareForDTReport();
        ViewGroup viewGroup2 = this.mRootView;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup2);
        return viewGroup2;
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        removeMaskView();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippyError(int i3, String str) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.mProgressBarWrapper.hideProgressBar();
        initNetworkErrorView(this.mRootView, new View.OnClickListener() { // from class: com.tencent.hippy.qq.fragment.CommonHippyFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                CommonHippyFragment.this.mErrorViewWrapper.hideNetworkErrorView();
                HippyQQPreloadEngine hippyQQPreloadEngine = CommonHippyFragment.this.mHippyQQEngine;
                if (hippyQQPreloadEngine != null) {
                    hippyQQPreloadEngine.destroyEngineImmediately();
                }
                CommonHippyFragment commonHippyFragment = CommonHippyFragment.this;
                commonHippyFragment.loadHippy(commonHippyFragment.mHippyContainer);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippySuccess() {
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
            handleFullScreen(getQBaseActivity());
        }
        addNightModeMask();
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
