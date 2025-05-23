package com.tencent.mobileqq.pad;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static SplitViewState f257089a;

    /* renamed from: b, reason: collision with root package name */
    private static final float f257090b;

    /* renamed from: c, reason: collision with root package name */
    private static final float f257091c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        if (PadUtil.b(BaseApplication.getContext()) && PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD) {
            f257090b = 0.5f;
            f257091c = 0.5f;
        } else {
            f257090b = 0.3f;
            f257091c = 0.7f;
        }
        f257089a = SplitViewState.UNKNOWN;
    }

    public static SplitViewState a() {
        return f257089a;
    }

    @MainThread
    public static void b(@NonNull Activity activity) {
        if (!AppSetting.t(activity)) {
            QLog.w("QFragmentContainerManager", 1, "can not enter full screen mode");
        } else {
            f(activity);
        }
    }

    @MainThread
    public static void c(@NonNull Activity activity) {
        if (!AppSetting.t(activity)) {
            QLog.w("QFragmentContainerManager", 1, "can not exit full screen mode");
        } else {
            e(activity, true);
        }
    }

    @MainThread
    public static void d(Configuration configuration, Activity activity, boolean z16) {
        if (c.a(activity, configuration.orientation)) {
            e(activity, z16);
        } else {
            f(activity);
        }
    }

    private static void e(Activity activity, boolean z16) {
        QLog.d("QFragmentContainerManager", 1, "resetViewInLandscape, showBg = " + z16);
        FragmentContainerView fragmentContainerView = (FragmentContainerView) activity.findViewById(R.id.vea);
        if (fragmentContainerView == null) {
            QLog.e("QFragmentContainerManager", 1, "SplashActivity view is null,  hashcode = " + activity);
            return;
        }
        f257089a = SplitViewState.STATE_FLAT;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) fragmentContainerView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        layoutParams.horizontalWeight = f257090b;
        layoutParams.endToStart = R.id.ve8;
        fragmentContainerView.setLayoutParams(layoutParams);
        if (z16) {
            activity.findViewById(R.id.ve9).setVisibility(0);
        } else {
            activity.findViewById(R.id.ve9).setVisibility(8);
        }
        FragmentContainerView fragmentContainerView2 = (FragmentContainerView) activity.findViewById(R.id.ve_);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) fragmentContainerView2.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = -1;
        float f16 = f257091c;
        layoutParams2.horizontalWeight = f16;
        layoutParams2.startToEnd = R.id.vea;
        fragmentContainerView2.setLayoutParams(layoutParams2);
        FragmentContainerView fragmentContainerView3 = (FragmentContainerView) activity.findViewById(R.id.ve8);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) fragmentContainerView3.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = -1;
        layoutParams3.horizontalWeight = f16;
        layoutParams3.startToEnd = R.id.vea;
        fragmentContainerView3.setLayoutParams(layoutParams3);
        fragmentContainerView.bringToFront();
    }

    private static void f(Activity activity) {
        QLog.d("QFragmentContainerManager", 1, "resetViewInPortrait");
        FragmentContainerView fragmentContainerView = (FragmentContainerView) activity.findViewById(R.id.vea);
        if (fragmentContainerView == null) {
            QLog.e("QFragmentContainerManager", 1, "SplashActivity view is null,  hashcode = " + activity);
            return;
        }
        f257089a = SplitViewState.STATE_OVERLAP;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) fragmentContainerView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        layoutParams.horizontalWeight = 1.0f;
        layoutParams.endToStart = 0;
        fragmentContainerView.setLayoutParams(layoutParams);
        activity.findViewById(R.id.ve9).setVisibility(8);
        FragmentContainerView fragmentContainerView2 = (FragmentContainerView) activity.findViewById(R.id.ve_);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) fragmentContainerView2.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = -1;
        layoutParams2.horizontalWeight = 1.0f;
        layoutParams2.startToEnd = 0;
        fragmentContainerView2.setLayoutParams(layoutParams2);
        FragmentContainerView fragmentContainerView3 = (FragmentContainerView) activity.findViewById(R.id.ve8);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) fragmentContainerView3.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = -1;
        layoutParams3.horizontalWeight = 1.0f;
        layoutParams3.startToEnd = 0;
        fragmentContainerView3.setLayoutParams(layoutParams3);
        fragmentContainerView2.bringToFront();
        fragmentContainerView3.bringToFront();
    }

    public static float g() {
        return f257091c;
    }

    public static float h() {
        return f257090b;
    }
}
