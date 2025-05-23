package com.tencent.ams.fusion.widget.downloadcard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ViewUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String IMAGE_BACK_BASE64 = "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";
    private static boolean sIsDarkMode;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34660);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sIsDarkMode = false;
        }
    }

    public ViewUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static View createBackView(Context context) {
        ImageView imageView = new ImageView(context);
        int dp2px = (int) Utils.dp2px(20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp2px, dp2px);
        layoutParams.gravity = 3;
        layoutParams.topMargin = (int) Utils.dp2px(8.0f);
        layoutParams.leftMargin = (int) Utils.dp2px(8.0f);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(Utils.bitmapFromBase64StringSafe(IMAGE_BACK_BASE64, dp2px, dp2px));
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) Utils.dp2px(36.0f), (int) Utils.dp2px(36.0f));
        layoutParams2.gravity = 3;
        layoutParams2.topMargin = (int) Utils.dp2px(8.0f);
        layoutParams2.leftMargin = (int) Utils.dp2px(8.0f);
        frameLayout.setLayoutParams(layoutParams2);
        frameLayout.addView(imageView);
        return frameLayout;
    }

    public static Drawable createCornerBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float dp2px = Utils.dp2px(12.0f);
        if (sIsDarkMode) {
            gradientDrawable.setColor(-14737633);
        } else {
            gradientDrawable.setColor(-1);
        }
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }

    public static boolean isDarkMode() {
        return sIsDarkMode;
    }

    public static void setDarkMode(boolean z16) {
        sIsDarkMode = z16;
    }
}
