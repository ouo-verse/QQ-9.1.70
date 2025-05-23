package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mm.ui.widget.WeSnackBar;
import com.tencent.mm.ui.widget.snackbar.SnackBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class SnackBarAlert {
    public static boolean IS_OPEN_WESNACKBAR = true;
    public static final int SNACKBAR_ANIMA_TIME = 2000;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f153831a = false;

    SnackBarAlert() {
    }

    public static void a(String str, String str2, Context context, SnackBar.OnMessageClickListener onMessageClickListener, SnackBar.OnVisibilityChangeListener onVisibilityChangeListener) {
        if (IS_OPEN_WESNACKBAR) {
            WeSnackBar.build(context).text(str).icon(R.raw.f169316c3).actionText(str2).onActionClickListener(onMessageClickListener).onVisibilityChangeListener(onVisibilityChangeListener).show();
        }
    }

    public static boolean isShow() {
        return f153831a;
    }

    public static void setShowMode(boolean z16) {
        f153831a = z16;
    }

    public static void showToast(Context context, View view, String str, SnackBar.OnVisibilityChangeListener onVisibilityChangeListener) {
        a(new SnackBar.Builder(context, view).withMessage(str).withDuration(1500), context, onVisibilityChangeListener);
    }

    public static void showToastWithAction(Activity activity, String str, String str2, SnackBar.OnMessageClickListener onMessageClickListener) {
        a(str, str2, activity, onMessageClickListener, null);
    }

    public static void showToastWithAction(Context context, View view, String str, String str2, SnackBar.OnMessageClickListener onMessageClickListener) {
        new SnackBar.Builder(context, view).withMessage(str).withActionMessage(str2).withDuration(2500);
        a(str, str2, context, onMessageClickListener, null);
    }

    public static void showToast(Activity activity, String str) {
        a(str, null, activity, null, null);
    }

    public static void showToastWithAction(Context context, View view, String str, String str2, SnackBar.OnMessageClickListener onMessageClickListener, SnackBar.OnVisibilityChangeListener onVisibilityChangeListener) {
        a(str, str2, context, onMessageClickListener, onVisibilityChangeListener);
    }

    public static void showToastWithAction(Activity activity, String str, String str2, SnackBar.OnMessageClickListener onMessageClickListener, SnackBar.OnVisibilityChangeListener onVisibilityChangeListener) {
        showToastWithAction(activity, str, str2, onMessageClickListener, onVisibilityChangeListener, 0);
    }

    public static void a(SnackBar.Builder builder, Context context, SnackBar.OnVisibilityChangeListener onVisibilityChangeListener) {
        if (IS_OPEN_WESNACKBAR) {
            WeSnackBar.build(context).text(builder.getMessage()).icon(R.raw.f169316c3).actionText(builder.getActionMessage()).onVisibilityChangeListener(onVisibilityChangeListener).show();
            return;
        }
        if (onVisibilityChangeListener != null) {
            builder.withVisibilityChangeListener(onVisibilityChangeListener);
        }
        builder.show();
    }

    public static void showToastWithAction(Activity activity, String str, String str2, SnackBar.OnMessageClickListener onMessageClickListener, SnackBar.OnVisibilityChangeListener onVisibilityChangeListener, int i3) {
        a(str, str2, activity, onMessageClickListener, onVisibilityChangeListener);
    }

    public static void showToastWithAction(Fragment fragment, String str, String str2, SnackBar.OnMessageClickListener onMessageClickListener, SnackBar.OnVisibilityChangeListener onVisibilityChangeListener) {
        a(str, str2, fragment.getActivity(), onMessageClickListener, onVisibilityChangeListener);
    }
}
