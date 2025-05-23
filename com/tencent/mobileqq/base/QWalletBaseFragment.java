package com.tencent.mobileqq.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.view.WalletProgressDialog;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001U\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0016\u001a\u00020\u000bJ\u0016\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u000bJ\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0010J\b\u0010\"\u001a\u0004\u0018\u00010!J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0019J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0010J\b\u0010)\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\u000bH\u0016J\u001a\u0010/\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010-J\u0010\u00100\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+J \u00103\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00102\u000e\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000001H\u0016J(\u00105\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00102\u000e\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u0000012\u0006\u00104\u001a\u00020\u0019H\u0016J\u0006\u00106\u001a\u00020\u0017J\u0012\u00109\u001a\u00020\u00022\b\u00108\u001a\u0004\u0018\u000107H\u0016J\b\u0010:\u001a\u00020\u0002H\u0016J\b\u0010;\u001a\u00020\u0002H\u0016J\u0010\u0010=\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u000eH\u0016J\b\u0010?\u001a\u00020>H\u0016J\u001a\u0010@\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u00104\u001a\u00020\u0019H\u0016J$\u0010@\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u00104\u001a\u00020\u00192\b\u0010A\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010B\u001a\u00020\u000bH\u0014J\b\u0010C\u001a\u00020\u0019H\u0014J\b\u0010D\u001a\u00020\u000bH\u0014J\b\u0010E\u001a\u00020\u000bH\u0014J\u0006\u0010F\u001a\u00020\u000bJ\u0006\u0010G\u001a\u00020\u000bJ\b\u0010H\u001a\u00020\u000bH\u0014J\b\u0010I\u001a\u00020\u000bH\u0014J\u0006\u0010J\u001a\u00020\u0017J\u0012\u0010K\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010L\u001a\u00020\u0002J\u0006\u0010M\u001a\u00020\u0002R\u0014\u0010N\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "updateFullTransparent", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "isAllowLandscape", "isWrapContent", "Landroid/view/Window;", "getWindow", "Landroid/content/Intent;", "getIntent", "Landroid/content/Context;", "getApplicationContext", "Landroidx/fragment/app/FragmentActivity;", "getOutActivity", "isFinishing", "", "name", "", "mode", "Landroid/content/SharedPreferences;", "getSharedPreferences", "isResume", "finish", "intent", "sendBroadcast", "Landroid/content/res/AssetManager;", "getAssets", "Lmqq/app/AppRuntime;", "getAppRuntime", "getQWalletRuntime", QzoneIPCModule.RESULT_CODE, "setResult", "data", "doOnBackPressed", "doOnLogout", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/IntentFilter;", "intentFilter", "registerReceiver", "unregisterReceiver", "Ljava/lang/Class;", "fragmentClass", "launchFragment", "requestCode", "launchFragmentForResult", "getModuleId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "window", "operateWindow", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "getFragmentAnimation", IAELaunchRecorder.MILESTONE_START_ACTIVITY, "options", "isStatusBarImmersive", "getStatusBarColor", "isStatusBarDarkText", "isFitSystemWindows", "needStatusTrans", "needImmersive", "isFullTransparent", "isFitNavigateBar", "getCurrentUin", "onNewIntent", UIJsPlugin.EVENT_SHOW_LOADING, "dismissLoading", "TAG", "Ljava/lang/String;", "Landroid/app/Dialog;", "loadingDialog", "Landroid/app/Dialog;", "accountChangeSwitch", "Z", "com/tencent/mobileqq/base/QWalletBaseFragment$a", "accountChangeCallback", "Lcom/tencent/mobileqq/base/QWalletBaseFragment$a;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class QWalletBaseFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    @NotNull
    private final a accountChangeCallback;
    private final boolean accountChangeSwitch;

    @Nullable
    private Dialog loadingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/base/QWalletBaseFragment$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements IAccountCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QWalletBaseFragment.this);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) newRuntime);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) newRuntime);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(@Nullable Constants.LogoutReason reason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) reason);
            } else if (!QWalletBaseFragment.this.isFinishing()) {
                QWalletBaseFragment.this.finish();
            }
        }
    }

    public QWalletBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = IQWalletHelper.TAG_WALLET + getClass().getSimpleName();
        this.accountChangeSwitch = ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_ACCOUNT_CHANGE_FINISH_SWITCH, true);
        this.accountChangeCallback = new a();
    }

    private final void updateFullTransparent() {
        Window window = getWindow();
        if (window != null) {
            window.setNavigationBarColor(getResources().getColor(R.color.qui_common_bg_bottom_standard, null));
            window.setBackgroundDrawableResource(R.color.ajr);
            ImmersiveUtils.setNavigationBarIconColor(window, !QQTheme.isNowThemeIsNight());
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                RFWImmersiveUtils.setTransparentStatusBar(window);
                RFWImmersiveUtils.setImmersiveLayout(window, true);
            }
            if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor()) {
                ImmersiveUtils.setStatusTextColorNew(!QQTheme.isNowThemeIsNight(), window, false);
            }
        }
    }

    public final void dismissLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public boolean doOnLogout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return false;
    }

    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @NotNull
    public final AppRuntime getAppRuntime() {
        AppActivity appActivity;
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof AppActivity) {
            appActivity = (AppActivity) activity;
        } else {
            appActivity = null;
        }
        if (appActivity != null) {
            appRuntime = appActivity.getAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime(null)");
            return waitAppRuntime;
        }
        return appRuntime;
    }

    @NotNull
    public final Context getApplicationContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Context) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        return applicationContext;
    }

    @Nullable
    public final AssetManager getAssets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (AssetManager) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return getApplicationContext().getAssets();
    }

    @NotNull
    public final String getCurrentUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return com.tencent.mobileqq.base.a.c();
    }

    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (FragmentAnimation) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return FragmentAnimation.DEFAULT;
    }

    @Nullable
    public final Intent getIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Intent) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getIntent();
        }
        return null;
    }

    @NotNull
    public final String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return "qwallet_plugin.apk";
    }

    @Nullable
    public final FragmentActivity getOutActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (FragmentActivity) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return getActivity();
    }

    @NotNull
    public final AppRuntime getQWalletRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        AppRuntime appRuntime = getAppRuntime().getAppRuntime(getModuleId());
        Intrinsics.checkNotNullExpressionValue(appRuntime, "getAppRuntime().getAppRuntime(getModuleId())");
        return appRuntime;
    }

    @NotNull
    public final SharedPreferences getSharedPreferences(@NotNull String name, int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 12, (Object) this, (Object) name, mode);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(name, mode);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getApplicationContext().\u2026edPreferences(name, mode)");
        return sharedPreferences;
    }

    protected int getStatusBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        return 0;
    }

    @Nullable
    public final Window getWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Window) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getWindow();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(getFragmentAnimation().getOpenEnterAnimation(), getFragmentAnimation().getOpenExitAnimation());
            Window window = activity.getWindow();
            if (window != null) {
                Intrinsics.checkNotNullExpressionValue(window, "window");
                operateWindow(window);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    public final boolean isFinishing() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (isRemoving()) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            z16 = activity.isFinishing();
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    protected boolean isFitNavigateBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        return false;
    }

    protected boolean isFitSystemWindows() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean isFullTransparent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        return false;
    }

    public final boolean isResume() {
        AppActivity appActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof AppActivity) {
            appActivity = (AppActivity) activity;
        } else {
            appActivity = null;
        }
        if (appActivity != null) {
            return appActivity.isResume();
        }
        return false;
    }

    protected boolean isStatusBarDarkText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean isStatusBarImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public final boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return super.isWrapContent();
    }

    public void launchFragment(@NotNull Intent intent, @NotNull Class<? extends QWalletBaseFragment> fragmentClass) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) intent, (Object) fragmentClass);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        Context context = getContext();
        if (context != null) {
            c.f(context, intent, fragmentClass, false, 8, null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.d(this.TAG, 1, "launchFragment: context is null");
        }
    }

    public void launchFragmentForResult(@NotNull Intent intent, @NotNull Class<? extends QWalletBaseFragment> fragmentClass, int requestCode) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, intent, fragmentClass, Integer.valueOf(requestCode));
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        Context context = getContext();
        if (context != null) {
            c.i(context, intent, fragmentClass, requestCode, false, 16, null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.d(this.TAG, 1, "launchFragmentForResult: context is null");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public final boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public final boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        QLog.i(this.TAG, 1, "onCreate@" + hashCode());
        if (this.accountChangeSwitch) {
            MobileQQ.sMobileQQ.registerAccountCallback(this.accountChangeCallback);
        }
        if (isFullTransparent()) {
            try {
                updateFullTransparent();
            } catch (Exception e16) {
                QLog.i(this.TAG, 1, "updateFullTransparent error:", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        super.onDestroy();
        QLog.i(this.TAG, 1, "onDestroy@" + hashCode());
        dismissLoading();
        if (this.accountChangeSwitch) {
            MobileQQ.sMobileQQ.unregisterAccountCallback(this.accountChangeCallback);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(getFragmentAnimation().getCloseEnterAnimation(), getFragmentAnimation().getCloseExitAnimation());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        QLog.i(this.TAG, 1, "onNewIntent@" + hashCode() + " intent=" + intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        if (isFitNavigateBar()) {
            QUIImmersiveHelper.s(requireActivity(), false, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (isStatusBarImmersive()) {
            Window window = getWindow();
            if (window != null) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(getStatusBarColor());
                ImmersiveUtils.setStatusTextColor(isStatusBarDarkText(), window);
            }
            view.setFitsSystemWindows(isFitSystemWindows());
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + ImmersiveUtils.getStatusBarHeight(getActivity()), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public void operateWindow(@NotNull Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) window);
        } else {
            Intrinsics.checkNotNullParameter(window, "window");
        }
    }

    public final void registerReceiver(@Nullable BroadcastReceiver receiver, @Nullable IntentFilter intentFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) receiver, (Object) intentFilter);
            return;
        }
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.registerReceiver(receiver, intentFilter);
            }
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "registerReceiver: ", th5);
        }
    }

    public final void sendBroadcast(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.sendBroadcast(intent);
        }
    }

    public final void setResult(int resultCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, resultCode);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(resultCode);
        }
    }

    public final void showLoading() {
        Dialog dialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        boolean z16 = true;
        if (this.loadingDialog == null) {
            WalletProgressDialog walletProgressDialog = new WalletProgressDialog(getContext());
            walletProgressDialog.setCancelable(true);
            this.loadingDialog = walletProgressDialog;
        }
        Dialog dialog2 = this.loadingDialog;
        if (dialog2 == null || !dialog2.isShowing()) {
            z16 = false;
        }
        if (!z16 && (dialog = this.loadingDialog) != null) {
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(@Nullable Intent intent, int requestCode) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) intent, requestCode);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivityForResult(intent, requestCode);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.startActivityForResult(intent, requestCode);
        }
    }

    public final void unregisterReceiver(@Nullable BroadcastReceiver receiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) receiver);
            return;
        }
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.unregisterReceiver(receiver);
            }
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "unregisterReceiver: ", th5);
        }
    }

    public final void setResult(int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, resultCode, (Object) data);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(resultCode, data);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(@Nullable Intent intent, int requestCode, @Nullable Bundle options) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, intent, Integer.valueOf(requestCode), options);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivityForResult(intent, requestCode, options);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.startActivityForResult(intent, requestCode, options);
        }
    }
}
