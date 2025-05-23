package com.tencent.mobileqq.qwallet;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\u000b\u001a\u00020\tJ\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020 H\u0016J\u001a\u0010#\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020\u0012H\u0016J$\u0010#\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010%\u001a\u00020\tH\u0014J\b\u0010&\u001a\u00020\u0012H\u0014J\b\u0010'\u001a\u00020\tH\u0014J\b\u0010(\u001a\u00020\tH\u0014J\u0006\u0010)\u001a\u00020\tJ\u0006\u0010*\u001a\u00020\tJ\u0012\u0010+\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010,\u001a\u00020\u0004R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qwallet/QPayBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isAllowLandscape", "isWrapContent", "Landroid/view/Window;", "getWindow", "finish", "Landroid/content/Intent;", "intent", "sendBroadcast", "", QzoneIPCModule.RESULT_CODE, "data", "setResult", "Landroid/content/BroadcastReceiver;", "receiver", "unregisterReceiver", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "window", "operateWindow", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "getFragmentAnimation", "requestCode", IAELaunchRecorder.MILESTONE_START_ACTIVITY, "options", "isStatusBarImmersive", "getStatusBarColor", "isStatusBarDarkText", "isFitSystemWindows", "needStatusTrans", "needImmersive", "onNewIntent", "dismissLoading", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "Landroid/app/Dialog;", "D", "Landroid/app/Dialog;", "loadingDialog", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class QPayBaseFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String TAG = IQWalletHelper.TAG_WALLET + getClass().getSimpleName();

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    public final void dismissLoading() {
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public void finish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.DEFAULT;
    }

    protected int getStatusBarColor() {
        return 0;
    }

    @Nullable
    public final Window getWindow() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getWindow();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
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
        return false;
    }

    protected boolean isFitSystemWindows() {
        return true;
    }

    protected boolean isStatusBarDarkText() {
        return true;
    }

    protected boolean isStatusBarImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public final boolean isWrapContent() {
        return super.isWrapContent();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public final boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public final boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QLog.i(this.TAG, 1, "onCreate@" + hashCode());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i(this.TAG, 1, "onDestroy@" + hashCode());
        dismissLoading();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(getFragmentAnimation().getCloseEnterAnimation(), getFragmentAnimation().getCloseExitAnimation());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        QLog.i(this.TAG, 1, "onNewIntent@" + hashCode() + " intent=" + intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
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
        Intrinsics.checkNotNullParameter(window, "window");
    }

    public final void sendBroadcast(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.sendBroadcast(intent);
        }
    }

    public final void setResult(int resultCode, @Nullable Intent data) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(resultCode, data);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(@Nullable Intent intent, int requestCode) {
        Unit unit;
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
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.unregisterReceiver(receiver);
            }
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "unregisterReceiver: ", th5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(@Nullable Intent intent, int requestCode, @Nullable Bundle options) {
        Unit unit;
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
