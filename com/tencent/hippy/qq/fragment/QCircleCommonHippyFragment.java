package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mobileqq.app.QBaseActivity;
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
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QCircleCommonHippyFragment extends QCircleBaseHippyFragment implements Handler.Callback {
    private static final int LOAD_HIPPY_TIME_OUT_TIME = 9000;
    private static final int MSG_TIME_OUT = 1;
    private Handler mHandler;
    protected ViewGroup mHippyContainer;
    private boolean mIsAddNightModeMaskView;
    private LayoutInflater mLayoutInflater;
    protected ViewGroup mRootView;
    private HippyProgressBarWrapper mProgressBarWrapper = new HippyProgressBarWrapper();
    private HippyErrorViewWrapper mErrorViewWrapper = new HippyErrorViewWrapper();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setStatusBarImmersive$0() {
        QBaseActivity qBaseActivityCompatibly = getQBaseActivityCompatibly();
        if (SystemBarActivityModule.getSystemBarComp(qBaseActivityCompatibly) == null) {
            SystemBarActivityModule.setImmersiveStatus(qBaseActivityCompatibly, 0);
        } else {
            SystemBarActivityModule.getSystemBarComp(qBaseActivityCompatibly).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(qBaseActivityCompatibly).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(qBaseActivityCompatibly).setStatusColor(0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$setStatusBarImmersive$1() {
        return null;
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
            QLog.e("QCircleBaseHippyFragment", 1, "setBackgroundColor e:", e16);
        }
    }

    protected void addNightModeMask() {
        FragmentActivity activity = getActivity();
        if (!this.mIsAddNightModeMaskView && activity != null && !getParameters().getBoolean(OpenHippyInfo.EXTRA_KEY_IS_CUSTOM_NIGHT_MODE) && QQTheme.isNowThemeIsNight()) {
            View view = new View(activity);
            view.setId(R.id.f_1);
            view.setBackgroundColor(1711276032);
            ((ViewGroup) activity.getWindow().getDecorView()).addView(view, new RelativeLayout.LayoutParams(-1, -1));
            this.mIsAddNightModeMaskView = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment
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
            QLog.e("QCircleBaseHippyFragment", 1, "doBussinessInitData:" + th5);
        }
        return jSONObject;
    }

    protected int getLayoutResId() {
        return R.layout.dqt;
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        QLog.d("QCircleBaseHippyFragment", 1, "Hippy: load timeout");
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

    protected void initProgressBar(ViewGroup viewGroup) {
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
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        setWindowFlag(getActivity(), 16777216);
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        try {
            setWindowFlag(getActivity(), 16777216);
        } catch (Throwable th5) {
            QLog.e("QCircleBaseHippyFragment", 1, "onCreateView setWindowFlag e:" + th5);
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

    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        removeMaskView();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment
    public void onLoadHippyError(int i3, String str) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.mProgressBarWrapper.hideProgressBar();
        initNetworkErrorView(this.mRootView, new View.OnClickListener() { // from class: com.tencent.hippy.qq.fragment.QCircleCommonHippyFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QCircleCommonHippyFragment.this.mErrorViewWrapper.hideNetworkErrorView();
                HippyQQPreloadEngine hippyQQPreloadEngine = QCircleCommonHippyFragment.this.mHippyQQEngine;
                if (hippyQQPreloadEngine != null) {
                    hippyQQPreloadEngine.destroyEngineImmediately();
                }
                QCircleCommonHippyFragment qCircleCommonHippyFragment = QCircleCommonHippyFragment.this;
                qCircleCommonHippyFragment.loadHippy(qCircleCommonHippyFragment.mHippyContainer);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment
    public void onLoadHippySuccess() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.mProgressBarWrapper.hideProgressBar();
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            com.tencent.mobileqq.qwallet.utils.d.b(getActivity(), getParameters().getBoolean(OpenHippyInfo.EXTRA_KEY_IS_STATUSBAR_DARKFONT));
        }
        addNightModeMask();
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    protected void setStatusBarImmersive() {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            executeCompatibly(new Function0() { // from class: com.tencent.hippy.qq.fragment.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Object lambda$setStatusBarImmersive$0;
                    lambda$setStatusBarImmersive$0 = QCircleCommonHippyFragment.this.lambda$setStatusBarImmersive$0();
                    return lambda$setStatusBarImmersive$0;
                }
            }, new Function0() { // from class: com.tencent.hippy.qq.fragment.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Object lambda$setStatusBarImmersive$1;
                    lambda$setStatusBarImmersive$1 = QCircleCommonHippyFragment.lambda$setStatusBarImmersive$1();
                    return lambda$setStatusBarImmersive$1;
                }
            });
        }
    }

    protected void setWindowFlag(Activity activity, int i3) {
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().setFlags(i3, i3);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
