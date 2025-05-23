package com.tencent.qq.minibox.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.minibox.proxy.CallHostCallback;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.proxy.MiniBoxHostAction;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qq/minibox/ui/MiniGameVATransparentFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/content/Intent;", "getIntent", "", "params", "", "ph", "setStatusBarImmersive", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "setActivityFullScreen", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "initWindowStyleAndAnimation", "", "needImmersive", "onResume", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniGameVATransparentFragment extends QPublicBaseFragment {
    private final Intent getIntent() {
        if (getActivity() != null) {
            Intent intent = requireActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "{\n            requireActivity().intent\n        }");
            return intent;
        }
        QLog.e("[MiniBox-callHost]MiniGameVATransparentFragment", 1, "Fragment.getActivity() is null when calling getIntent()");
        return new Intent();
    }

    private final void ph(String params) {
        if (getQBaseActivity() != null && params != null) {
            QBaseActivity qBaseActivity = getQBaseActivity();
            Intrinsics.checkNotNull(qBaseActivity);
            new MiniBoxHostAction(qBaseActivity, params, new CallHostCallback() { // from class: com.tencent.qq.minibox.ui.MiniGameVATransparentFragment$handleVAMethod$action$1
                @Override // com.tencent.minibox.proxy.CallHostCallback
                public void response(@NotNull String params2) {
                    Intrinsics.checkNotNullParameter(params2, "params");
                    QBaseActivity qBaseActivity2 = MiniGameVATransparentFragment.this.getQBaseActivity();
                    if (qBaseActivity2 != null) {
                        Intent intent = new Intent("com.tencent.mobileqq.ACTION_VA_TRANSPARENT_HANDLE");
                        intent.putExtra("va_response", params2);
                        qBaseActivity2.sendBroadcast(intent);
                    }
                    QBaseActivity qBaseActivity3 = MiniGameVATransparentFragment.this.getQBaseActivity();
                    if (qBaseActivity3 != null) {
                        qBaseActivity3.finish();
                    }
                }
            }).f();
        } else {
            QLog.e("[MiniBox-callHost]MiniGameVATransparentFragment", 1, "handleVAMethod error context");
            QBaseActivity qBaseActivity2 = getQBaseActivity();
            if (qBaseActivity2 != null) {
                qBaseActivity2.finish();
            }
        }
    }

    private final void setActivityFullScreen(Activity activity) {
        WindowManager.LayoutParams layoutParams;
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
            if (activity != null && (window2 = activity.getWindow()) != null) {
                layoutParams = window2.getAttributes();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.layoutInDisplayCutoutMode = 3;
                if (activity != null && (window = activity.getWindow()) != null) {
                    window.setAttributes(layoutParams);
                }
            }
        }
    }

    private final void setStatusBarImmersive() {
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

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivityFullScreen(activity);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setStatusBarImmersive();
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setActivityFullScreen(getActivity());
        ph(getIntent().getStringExtra("va_data"));
    }
}
