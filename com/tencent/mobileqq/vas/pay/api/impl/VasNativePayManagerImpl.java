package com.tencent.mobileqq.vas.pay.api.impl;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.vas.pay.api.impl.view.NativePayPopView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import g23.b;
import mqq.util.WeakReference;

/* loaded from: classes20.dex */
public class VasNativePayManagerImpl implements IVasNativePayManager, PopupWindow.OnDismissListener, Application.ActivityLifecycleCallbacks {
    public static final String DINALTERNATE_BOLD_FONT_PATH = "fonts/DIN-NextLT-Pro-Medium.ttf";
    private static final long IS_IN_SHOW_PROCESS_RESET_DURATION_MS = 2000;
    public static final String OFFER_ID_B_DEFAULT = "1450030431";
    public static final String OFFER_ID_C = "1450030730";
    public static final String PAY_VERSION = "v1.5.0";
    private static final String TAG = "VasNativePayViewImpl";
    private static final String UNKNOWN_BUSINESS_ID = "1000";
    private static final String Z_PLAIN_BUSINESS_ID = "1009";
    private WeakReference<Activity> mActivity;
    private String mCurrentActivityClassName;
    private WeakReference<NativePayPopView> mNativePayPopView;
    private IVasNativePayManager.PayObserver mObserver;
    private static final MutableLiveData<Boolean> isInShowProcess = new MutableLiveData<>(Boolean.FALSE);
    public static boolean isFirst = true;

    static {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                VasNativePayManagerImpl.isInShowProcess.observeForever(new Observer<Boolean>() { // from class: com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl.1.1
                    @Override // androidx.lifecycle.Observer
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onChanged(Boolean bool) {
                        if (!bool.booleanValue()) {
                            return;
                        }
                        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                VasNativePayManagerImpl.isInShowProcess.setValue(Boolean.FALSE);
                            }
                        }, 2000L);
                    }
                });
            }
        });
    }

    private void changeBackground(boolean z16) {
        Activity activity;
        Window window;
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference == null || (activity = weakReference.get()) == null || (window = activity.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z16) {
            attributes.alpha = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
        } else {
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
            window.clearFlags(2);
        }
    }

    private void initDirectPayView(Activity activity, int i3, IVasNativePayManager.ReportData reportData, IVasNativePayManager.PayObserver payObserver) {
        NativePayPopView nativePayPopView = new NativePayPopView();
        nativePayPopView.j0(this);
        nativePayPopView.C(activity, i3, reportData, payObserver);
    }

    private void initView(Activity activity, String str, String str2, IVasNativePayManager.ReportData reportData, IVasNativePayManager.PayObserver payObserver) {
        NativePayPopView nativePayPopView = new NativePayPopView();
        nativePayPopView.j0(this);
        nativePayPopView.M(activity, str, str2, reportData, payObserver);
        this.mNativePayPopView = new WeakReference<>(nativePayPopView);
    }

    private boolean isLastPayPanelInOpenProcess() {
        Boolean value = isInShowProcess.getValue();
        if (value != null && value.booleanValue()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager
    public void directdPay(final Activity activity, int i3, IVasNativePayManager.ReportData reportData, IVasNativePayManager.PayObserver payObserver) {
        if (activity != null && reportData != null) {
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && Z_PLAIN_BUSINESS_ID.equals(reportData.mBusinessId)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(activity, -1, "\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u6682\u4e0d\u63d0\u4f9b\u5145\u503c\u529f\u80fd", 1).show();
                    }
                });
                if (payObserver != null) {
                    payObserver.onPayError(-1);
                    return;
                }
                return;
            }
            initDirectPayView(activity, i3, reportData, payObserver);
            return;
        }
        if (payObserver != null) {
            payObserver.onPayError(-1);
        }
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager
    public void hidePayPanel() {
        WeakReference<NativePayPopView> weakReference = this.mNativePayPopView;
        if (weakReference != null && weakReference.get() != null) {
            this.mNativePayPopView.get().I();
        }
        isInShowProcess.postValue(Boolean.FALSE);
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager
    public IVasNativePayManager initAndShowPayPanel(final Activity activity, String str, String str2, IVasNativePayManager.ReportData reportData, IVasNativePayManager.PayObserver payObserver) {
        if (activity == null || reportData == null) {
            return null;
        }
        if (isLastPayPanelInOpenProcess()) {
            QLog.e(TAG, 1, "initAndShowPayPanel() isLastPayPanelInOpenProcess return null");
            return null;
        }
        this.mObserver = payObserver;
        isInShowProcess.postValue(Boolean.TRUE);
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && Z_PLAIN_BUSINESS_ID.equals(reportData.mBusinessId)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(activity, -1, "\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u6682\u4e0d\u63d0\u4f9b\u5145\u503c\u529f\u80fd", 1).show();
                }
            });
            return null;
        }
        this.mActivity = new WeakReference<>(activity);
        this.mCurrentActivityClassName = activity.getComponentName().getClassName();
        initView(activity, str, str2, reportData, payObserver);
        return this;
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager
    public boolean isSwitchEnable() {
        return b.c().d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        hidePayPanel();
        this.mObserver = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        WeakReference<NativePayPopView> weakReference = this.mNativePayPopView;
        if (weakReference != null && weakReference.get() != null) {
            this.mNativePayPopView.get().f310167h.setFocusable(false);
            if (activity.getComponentName().getClassName().equals(this.mCurrentActivityClassName)) {
                this.mNativePayPopView.get().F();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        WeakReference<NativePayPopView> weakReference = this.mNativePayPopView;
        if (weakReference != null && weakReference.get() != null) {
            this.mNativePayPopView.get().f310167h.setFocusable(true);
            this.mNativePayPopView.get().r0(false, null);
            if (activity.getComponentName().getClassName().equals(this.mCurrentActivityClassName)) {
                this.mNativePayPopView.get().G();
            }
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference != null && weakReference.get() != null && Build.VERSION.SDK_INT >= 26) {
            try {
                changeBackground(false);
                ((Application) this.mActivity.get().getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
            }
        }
        IVasNativePayManager.PayObserver payObserver = this.mObserver;
        if (payObserver != null) {
            payObserver.onPayViewClose();
            this.mObserver = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
