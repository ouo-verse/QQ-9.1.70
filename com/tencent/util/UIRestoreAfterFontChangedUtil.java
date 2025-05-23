package com.tencent.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UIRestoreAfterFontChangedUtil {
    static IPatchRedirector $redirector_;

    public UIRestoreAfterFontChangedUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static float getScale(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density / FontSettingManager.systemMetrics.density;
    }

    public static void restoreTextViewTextSize(TextView textView) {
        if (textView == null) {
            return;
        }
        float scale = getScale(textView.getContext());
        textView.setTextSize((ViewUtils.pxTosp(textView.getTextSize()) / scale) / scale);
    }

    public static void restoreViewBgRadius(View view, float f16) {
        if (view != null && f16 != 0.0f) {
            float scale = getScale(view.getContext());
            if (scale != 1.0f) {
                Drawable background = view.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setCornerRadius(f16 / scale);
                }
            }
        }
    }
}
