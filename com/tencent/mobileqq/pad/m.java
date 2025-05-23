package com.tencent.mobileqq.pad;

import android.app.Activity;
import android.util.Size;
import android.view.KeyEvent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Multi-variable type inference failed */
    @MainThread
    public static void a(@NonNull Activity activity) {
        if (activity == 0) {
            QLog.e("QFragmentUtils", 1, "activity is null");
            return;
        }
        QLog.d("QFragmentUtils", 1, "clearAllFragment: activity = [" + activity + "]");
        if (activity instanceof l) {
            l lVar = (l) activity;
            lVar.getqFragmentStackManager().d();
            lVar.getqFragmentStackManager().e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @MainThread
    public static boolean b(@NonNull Activity activity) {
        QLog.d("QFragmentUtils", 1, "exitCurrentFragment: activity = [" + activity + "]");
        if (activity instanceof l) {
            ((l) activity).getqFragmentStackManager().p();
            return true;
        }
        return false;
    }

    @Nullable
    public static Size c(@NonNull FragmentActivity fragmentActivity) {
        if (fragmentActivity == null) {
            QLog.e("QFragmentUtils", 1, "activity is null");
            return null;
        }
        FragmentContainerView fragmentContainerView = (FragmentContainerView) fragmentActivity.findViewById(R.id.ve8);
        if (fragmentContainerView == null) {
            QLog.e("QFragmentUtils", 1, "can find function view");
            return null;
        }
        if (ViewCompat.isLaidOut(fragmentContainerView) && fragmentContainerView.getVisibility() == 0) {
            return new Size(fragmentContainerView.getWidth(), fragmentContainerView.getHeight());
        }
        QLog.e("QFragmentUtils", 1, "to early to get view's width or height");
        return null;
    }

    public static int d() {
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        if (e.a() == SplitViewState.STATE_FLAT) {
            return Math.round(e.g() * i3);
        }
        if (e.a() == SplitViewState.STATE_OVERLAP) {
            return i3;
        }
        QLog.w("QFragmentUtils", 1, "getFunctionZoneWidth currentSplitViewState invalid");
        return 0;
    }

    @Deprecated
    public static void e(@NonNull Activity activity) {
        if (QLog.isColorLevel()) {
            QLog.d("QFragmentUtils", 2, "onBackPressed");
        }
        activity.dispatchKeyEvent(new KeyEvent(0, 4));
        activity.dispatchKeyEvent(new KeyEvent(1, 4));
    }
}
