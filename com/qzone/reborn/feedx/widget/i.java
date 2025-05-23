package com.qzone.reborn.feedx.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.qzone.common.activities.base.QZoneFragmentHolderActivity;
import com.qzone.reborn.base.QZoneBaseActivity;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.util.cn;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static Typeface f56413a;

    public static Activity b(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static void f(TextView textView) {
        if (textView != null && textView.getContext() != null) {
            try {
                if (f56413a == null) {
                    f56413a = Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/DIN-NextLT-Pro-QQ.ttf");
                }
                if (f56413a != textView.getTypeface()) {
                    textView.setTypeface(f56413a);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("QZoneViewUtils", 1, "[fixTextViewWithQUIRedDotFont] setTypeFace error: " + e16);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                return;
            }
        }
        QLog.e("QZoneViewUtils", 1, "[setTextViewWithQUIRedDotFontType] tv or context is null");
    }

    public static void a(View view, int i3) {
        if (view == null || view.getBackground() == null) {
            return;
        }
        Drawable f16 = cn.f(view.getBackground());
        f16.setAlpha(i3);
        view.setBackground(f16);
    }

    public static Activity c(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static Fragment d(View view) {
        if (view == null) {
            return null;
        }
        if (view.getContext() instanceof QZoneBaseActivity) {
            return ((QZoneBaseActivity) view.getContext()).getQZoneBaseFragment();
        }
        if (view.getContext() instanceof QZoneFragmentHolderActivity) {
            return ((QZoneFragmentHolderActivity) view.getContext()).getQZoneBaseFragment();
        }
        try {
            return FragmentManager.findFragment(view);
        } catch (Throwable th5) {
            RFWLog.e("QZoneViewUtils", RFWLog.USR, th5);
            return null;
        }
    }

    public static void e(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setLayerType(1, null);
        } catch (Exception e16) {
            QZLog.e("QzoneTitleBarActivity", "close software false", e16);
        }
    }
}
