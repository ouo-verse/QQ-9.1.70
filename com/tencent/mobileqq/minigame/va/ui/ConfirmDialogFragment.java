package com.tencent.mobileqq.minigame.va.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/ui/ConfirmDialogFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "confirmDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "initWindowStyleAndAnimation", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "isAllowLandscape", "", "needImmersive", "needStatusTrans", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "setActivityFullScreen", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ConfirmDialogFragment extends QPublicBaseFragment {
    private static final String TAG = "MiniGameVAConfirmDialogFragment";
    private QQCustomDialog confirmDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(ConfirmDialogFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RestartConfirmHandler.INSTANCE.onPositiveClick();
        QQCustomDialog qQCustomDialog = this$0.confirmDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(ConfirmDialogFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RestartConfirmHandler.INSTANCE.onNegativeClick();
        QQCustomDialog qQCustomDialog = this$0.confirmDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3(ConfirmDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivityFullScreen(activity);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (this.confirmDialog == null) {
            this.confirmDialog = DialogUtil.createCustomDialog(getActivity(), 230);
        }
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null) {
            str3 = miniGameVAInterceptConfig.getRestartConfirmDialogContent();
            str = miniGameVAInterceptConfig.getRestartConfirmDialogPositiveButton();
            str2 = miniGameVAInterceptConfig.getRestartConfirmDialogNegativeButton();
        } else {
            str = "\u7ee7\u7eed\u6e38\u620f";
            str2 = "\u7acb\u5373\u91cd\u542f";
            str3 = "\u7ecf\u5178\u519c\u573a\u5df2\u66f4\u65b0\u5b8c\u6210\uff0c\u7acb\u5373\u91cd\u542f\u9700\u7b49\u5f85\u8f83\u957f\u65f6\u95f4\uff0c\u63a8\u8350\u7ee7\u7eed\u6e38\u620f\uff0c\u95f2\u65f6\u540e\u53f0\u5c06\u4e3a\u60a8\u81ea\u52a8\u5b8c\u6210\u5b89\u88c5~";
        }
        QQCustomDialog qQCustomDialog = this.confirmDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.setMessage(str3);
        }
        QQCustomDialog qQCustomDialog2 = this.confirmDialog;
        if (qQCustomDialog2 != null) {
            qQCustomDialog2.setCanceledOnTouchOutside(false);
        }
        QQCustomDialog qQCustomDialog3 = this.confirmDialog;
        if (qQCustomDialog3 != null) {
            qQCustomDialog3.setCancelable(true);
        }
        QQCustomDialog qQCustomDialog4 = this.confirmDialog;
        if (qQCustomDialog4 != null) {
            qQCustomDialog4.setPositiveButton(str, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.ui.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ConfirmDialogFragment.onCreateView$lambda$1(ConfirmDialogFragment.this, dialogInterface, i3);
                }
            });
        }
        QQCustomDialog qQCustomDialog5 = this.confirmDialog;
        if (qQCustomDialog5 != null) {
            qQCustomDialog5.setNegativeButton(str2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.ui.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ConfirmDialogFragment.onCreateView$lambda$2(ConfirmDialogFragment.this, dialogInterface, i3);
                }
            });
        }
        QQCustomDialog qQCustomDialog6 = this.confirmDialog;
        if (qQCustomDialog6 != null) {
            qQCustomDialog6.show();
        }
        QQCustomDialog qQCustomDialog7 = this.confirmDialog;
        if (qQCustomDialog7 != null) {
            qQCustomDialog7.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.minigame.va.ui.c
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ConfirmDialogFragment.onCreateView$lambda$3(ConfirmDialogFragment.this, dialogInterface);
                }
            });
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QQCustomDialog qQCustomDialog = this.confirmDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        RestartConfirmHandler.INSTANCE.onDialogClose();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setActivityFullScreen(getActivity());
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

    private final void setActivityFullScreen(Activity activity) {
        Window window;
        Window window2;
        Window window3;
        Window window4;
        Window window5;
        View decorView;
        Window window6;
        if (activity != null && (window6 = activity.getWindow()) != null) {
            window6.setFlags(1024, 1024);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (activity != null && (window5 = activity.getWindow()) != null && (decorView = window5.getDecorView()) != null) {
            decorView.setSystemUiVisibility(7942);
        }
        if (activity != null && (window4 = activity.getWindow()) != null) {
            window4.addFlags(67108864);
        }
        if (activity != null && (window3 = activity.getWindow()) != null) {
            window3.addFlags(134218752);
        }
        if (i3 >= 28) {
            WindowManager.LayoutParams attributes = (activity == null || (window2 = activity.getWindow()) == null) ? null : window2.getAttributes();
            if (attributes != null) {
                attributes.layoutInDisplayCutoutMode = 3;
                if (activity == null || (window = activity.getWindow()) == null) {
                    return;
                }
                window.setAttributes(attributes);
            }
        }
    }
}
