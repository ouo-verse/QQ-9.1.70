package com.tencent.mobileqq.microapp.sdk;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.microapp.apkg.ApkgDebugConstants;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.g;
import com.tencent.mobileqq.microapp.ext.ManagerProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.startup.step.ProcessInfoUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qwallet.plugin.FakeUrl;
import java.io.File;
import java.lang.ref.WeakReference;
import ne0.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppBridgeActivity extends PublicBaseFragment {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_LAUNCH_PARAM = "launch_param";
    public static final long MINIAPP_PROCESS_INIT_PRE_TIME = 5000;
    public static final String TAG = "MiniAppBridgeActivity";
    private MiniAppConfig fromAppConfig;
    private LaunchParam launchParam;
    private QQProgressDialog mDialog;
    private FakeUrl mFakeUrl;

    public MiniAppBridgeActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAbnormal(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleAbnormal:" + str);
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            QQToast.makeText((Context) getActivity(), (CharSequence) "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
            getActivity().finish();
        }
    }

    private boolean isFromDebugConfig(LaunchParam launchParam) {
        MiniAppConfig miniAppConfig = ApkgDebugConstants.getMiniAppConfig(launchParam.miniAppId, getActivity().app);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isFromDebugConfig :" + miniAppConfig);
        }
        if (miniAppConfig != null) {
            ThreadManager.getUIHandler().postDelayed(new Runnable(miniAppConfig) { // from class: com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ MiniAppConfig val$appConfig;

                {
                    this.val$appConfig = miniAppConfig;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniAppBridgeActivity.this, (Object) miniAppConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        MiniAppController.startApp(MiniAppBridgeActivity.this.getActivity(), MiniAppBridgeActivity.this.wrapConfig(this.val$appConfig), new ResultReceiver(new Handler(Looper.getMainLooper()), new WeakReference(MiniAppBridgeActivity.this.getActivity())) { // from class: com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.4.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ WeakReference val$activityRef;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r8);
                                this.val$activityRef = r9;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, AnonymousClass4.this, r8, r9);
                                }
                            }

                            @Override // android.os.ResultReceiver
                            protected void onReceiveResult(int i3, Bundle bundle) {
                                FragmentActivity fragmentActivity;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) bundle);
                                    return;
                                }
                                super.onReceiveResult(i3, bundle);
                                if (i3 == 0 && (fragmentActivity = (FragmentActivity) this.val$activityRef.get()) != null && !fragmentActivity.isFinishing()) {
                                    fragmentActivity.finish();
                                }
                            }
                        });
                    } catch (MiniAppException e16) {
                        e16.printStackTrace();
                    }
                }
            }, 100L);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        } else {
            view = new View(getActivity());
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
            this.mDialog.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        LaunchParam launchParam = (LaunchParam) getArguments().getSerializable(KEY_LAUNCH_PARAM);
        this.launchParam = launchParam;
        if (launchParam == null) {
            handleAbnormal("launchParam is null");
            return;
        }
        ApkgConfigManager apkgConfigManager = ManagerProxy.getApkgConfigManager(getActivity().app);
        LaunchParam launchParam2 = this.launchParam;
        if (launchParam2.scene == 1214) {
            MiniAppConfig config = apkgConfigManager.getConfig(launchParam2.fromMiniAppId);
            this.fromAppConfig = config;
            if (config == null) {
                handleAbnormal("fromAppConfig is null");
                return;
            }
        }
        if (isFromDebugConfig(this.launchParam)) {
            return;
        }
        long e16 = ProcessInfoUtil.e("com.tencent.mobileqq:miniapp");
        WeakReference weakReference = new WeakReference(getActivity());
        MiniAppConfig config2 = apkgConfigManager.getConfig(this.launchParam);
        if (config2 != null && config2.config != null && new File(g.a(config2.config)).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "miniConfig config exist and valid:" + config2);
            }
            if (this.launchParam.scene == 1214 && !ApkgConfigManager.isCanNavigate(config2, this.fromAppConfig)) {
                handleAbnormal("not support navigate 2");
                return;
            }
            if (e16 > 5000) {
                try {
                    MiniAppController.startApp(getActivity(), wrapConfig(config2), null);
                    getActivity().finish();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "miniapp process exist, launch directly");
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    handleAbnormal("start miniapp error");
                    return;
                }
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable(config2, weakReference) { // from class: com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ WeakReference val$activityRef;
                final /* synthetic */ MiniAppConfig val$miniConfig;

                {
                    this.val$miniConfig = config2;
                    this.val$activityRef = weakReference;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MiniAppBridgeActivity.this, config2, weakReference);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(MiniAppBridgeActivity.TAG, 2, "miniapp process not exist,delay to start");
                        }
                        if (MiniAppBridgeActivity.this.getActivity() != null && !MiniAppBridgeActivity.this.getActivity().isFinishing()) {
                            MiniAppController.startApp(MiniAppBridgeActivity.this.getActivity(), MiniAppBridgeActivity.this.wrapConfig(this.val$miniConfig), new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.3.1
                                static IPatchRedirector $redirector_;

                                {
                                    super(r5);
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) r5);
                                    }
                                }

                                @Override // android.os.ResultReceiver
                                protected void onReceiveResult(int i3, Bundle bundle) {
                                    FragmentActivity fragmentActivity;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this, i3, (Object) bundle);
                                        return;
                                    }
                                    super.onReceiveResult(i3, bundle);
                                    if (i3 == 0 && (fragmentActivity = (FragmentActivity) AnonymousClass3.this.val$activityRef.get()) != null && !fragmentActivity.isFinishing()) {
                                        fragmentActivity.finish();
                                    }
                                }
                            });
                        }
                    } catch (Throwable unused2) {
                        MiniAppBridgeActivity.this.handleAbnormal("start miniapp error");
                    }
                }
            }, 100L);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "miniConfig config is null or folder not exist");
        }
        apkgConfigManager.getNewestConfig(this.launchParam, 0, new ApkgConfigManager.a(weakReference, e16) { // from class: com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ WeakReference val$activityRef;
            final /* synthetic */ long val$processRuntime;

            {
                this.val$activityRef = weakReference;
                this.val$processRuntime = e16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MiniAppBridgeActivity.this, weakReference, Long.valueOf(e16));
                }
            }

            @Override // com.tencent.mobileqq.microapp.apkg.ApkgConfigManager.a
            public void onResult(int i3, MiniAppConfig miniAppConfig, String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), miniAppConfig, str, str2);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(MiniAppBridgeActivity.TAG, 2, "MiniAppBridgeActivity getNewestConfig");
                }
                FragmentActivity fragmentActivity = (FragmentActivity) this.val$activityRef.get();
                if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
                    if (MiniAppBridgeActivity.this.launchParam.scene == 1214 && !ApkgConfigManager.isCanNavigate(miniAppConfig, MiniAppBridgeActivity.this.fromAppConfig)) {
                        MiniAppBridgeActivity.this.handleAbnormal("not support navigate");
                        return;
                    }
                    if (i3 == 0) {
                        try {
                            MiniAppController.startApp(fragmentActivity, MiniAppBridgeActivity.this.wrapConfig(miniAppConfig), new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.2.1
                                static IPatchRedirector $redirector_;

                                {
                                    super(r5);
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) r5);
                                    }
                                }

                                @Override // android.os.ResultReceiver
                                protected void onReceiveResult(int i16, Bundle bundle) {
                                    FragmentActivity fragmentActivity2;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this, i16, (Object) bundle);
                                        return;
                                    }
                                    super.onReceiveResult(i16, bundle);
                                    if (i16 == 0 && (fragmentActivity2 = (FragmentActivity) AnonymousClass2.this.val$activityRef.get()) != null && !fragmentActivity2.isFinishing()) {
                                        fragmentActivity2.finish();
                                    }
                                }
                            });
                            if (this.val$processRuntime > 5000) {
                                MiniAppBridgeActivity.this.getActivity().finish();
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    } else if (!TextUtils.isEmpty(str)) {
                        MiniAppBridgeActivity.this.mFakeUrl = new FakeUrl(MiniAppBridgeActivity.this.getActivity());
                        MiniAppBridgeActivity.this.mFakeUrl.onFakePros((String) null, str, new FakeUrl.FakeListener() { // from class: com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.2.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // cooperation.qwallet.plugin.FakeUrl.FakeListener
                            public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i16) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 3)) {
                                    return ((Boolean) iPatchRedirector3.redirect((short) 3, (Object) this, (Object) fakeInfo, i16)).booleanValue();
                                }
                                MiniAppBridgeActivity.this.getActivity().finish();
                                return false;
                            }

                            @Override // cooperation.qwallet.plugin.FakeUrl.FakeListener
                            public boolean onClickUrl(String str3) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    return ((Boolean) iPatchRedirector3.redirect((short) 2, (Object) this, (Object) str3)).booleanValue();
                                }
                                MiniAppBridgeActivity.this.getActivity().finish();
                                return false;
                            }
                        });
                        MiniAppBridgeActivity.this.mDialog.dismiss();
                        return;
                    }
                    MiniAppBridgeActivity.this.handleAbnormal("return code error;" + i3 + "|" + str);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity());
        this.mDialog = qQProgressDialog;
        qQProgressDialog.setMessage("\u6b63\u5728\u52a0\u8f7d\u4e2d...");
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniAppBridgeActivity.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else if (MiniAppBridgeActivity.this.mFakeUrl == null && MiniAppBridgeActivity.this.getActivity() != null && !MiniAppBridgeActivity.this.getActivity().isFinishing()) {
                    MiniAppBridgeActivity.this.getActivity().finish();
                }
            }
        });
        this.mDialog.show();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "MiniAppBridgeActivity 00");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    public MiniAppConfig wrapConfig(MiniAppConfig miniAppConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MiniAppConfig) iPatchRedirector.redirect((short) 6, (Object) this, (Object) miniAppConfig);
        }
        if (miniAppConfig == null) {
            return null;
        }
        if (TextUtils.isEmpty(this.launchParam.entryPath)) {
            this.launchParam.entryPath = null;
        }
        miniAppConfig.launchParam = this.launchParam;
        return miniAppConfig;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return a.c(this, str, cls);
    }
}
