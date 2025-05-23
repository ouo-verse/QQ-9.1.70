package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.CheckBox;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.util.EstablishSetting;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ViewUtils {
    private static float DEVICE_DENSITY;
    private static float density;
    private static int densityDPI;
    public static int densityDpi;
    public static float mDensity;
    private static int pixelPerCM;
    private static float scaleDensity;
    private static int screenHeight;
    private static double screenSizeCM;
    private static int screenWidth;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        private float f307366a;

        a(float f16) {
            this.f307366a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ViewUtils.dip2px(this.f307366a));
        }
    }

    static {
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        mDensity = displayMetrics.density;
        densityDpi = displayMetrics.densityDpi;
        density = -1.0f;
        scaleDensity = -1.0f;
        densityDPI = -1;
        screenWidth = -1;
        screenHeight = -1;
        screenSizeCM = 0.0d;
        pixelPerCM = 0;
    }

    @TargetApi(11)
    public static void changeTransparency(View view, int i3) {
        if (view.getBackground() != null) {
            view.getBackground().setAlpha(i3);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                changeTransparency(viewGroup.getChildAt(i16), i3);
            }
        }
    }

    public static GradientDrawable createGradientDrawable(int i3, @Nullable Integer num, int i16, GradientDrawable.Orientation orientation, float f16, int i17, @Nullable ColorStateList colorStateList) {
        int[] iArr;
        if (num != null) {
            iArr = new int[]{i3, num.intValue(), i16};
        } else {
            iArr = new int[]{i3, i16};
        }
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setGradientCenter(0.5f, 0.5f);
        gradientDrawable.setCornerRadius(f16);
        if (i17 > 0 && colorStateList != null) {
            gradientDrawable.setStroke(i17, colorStateList);
        }
        return gradientDrawable;
    }

    public static int customDip2Px(float f16) {
        return (int) ((f16 * FontSettingManager.customMetrics.density) + 0.5f);
    }

    public static GradientDrawable customRadiusDrawable(ColorStateList colorStateList, float f16, float f17, float f18, float f19) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{f16, f16, f17, f17, f18, f18, f19, f19});
        gradientDrawable.setColor(colorStateList);
        return gradientDrawable;
    }

    public static int dip2px(float f16) {
        return (int) ((f16 * mDensity) + 0.5f);
    }

    public static int dpToPx(float f16) {
        return Math.round(f16 * getDensity());
    }

    public static String getBreakString(Paint paint, String str, float f16) {
        if (paint == null) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            float f17 = 0.0f;
            float f18 = 0.0f;
            int i3 = 0;
            while (i3 < length) {
                f18 += fArr[i3];
                if (f18 > f16) {
                    break;
                }
                i3++;
            }
            if (i3 == length) {
                return str;
            }
            float measureText = paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            if (i3 <= 0) {
                return "";
            }
            if (i3 <= 1) {
                return str.substring(0, i3);
            }
            do {
                i3--;
                f17 += fArr[i3];
                if (f17 >= measureText) {
                    break;
                }
            } while (i3 > 0);
            return str.substring(0, i3) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("getBreakString", 2, "getBreakString", th5);
            }
            return str;
        }
    }

    public static void getChildPos(View view, View view2, int[] iArr) {
        if (iArr != null && iArr.length >= 2) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (view.getParent() == null) {
                    break;
                }
                i3 += view.getLeft();
                i16 += view.getTop();
                if (view.getParent() == view2) {
                    iArr[0] = i3;
                    iArr[1] = i16;
                    if (iArr.length >= 4) {
                        iArr[2] = view.getMeasuredWidth();
                        iArr[3] = view.getMeasuredHeight();
                    }
                } else {
                    try {
                        view = (View) view.getParent();
                        if (iArr.length >= 4) {
                            iArr[2] = view.getMeasuredWidth();
                            iArr[3] = view.getMeasuredHeight();
                        }
                    } catch (ClassCastException unused) {
                    }
                }
            }
            if (view2 == null) {
                iArr[0] = i3;
                iArr[1] = i16;
            }
        }
    }

    public static Point getChildPositionInParent(View view, ViewGroup viewGroup) {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect);
        viewGroup.getGlobalVisibleRect(rect2);
        return new Point(rect.left - rect2.left, rect.top - rect2.top);
    }

    public static float getDensity() {
        if (EstablishSetting.isDebugVersion()) {
            density = FontSettingManager.customMetrics.density;
        } else if (density < 0.0f) {
            density = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static float getDensityDpi() {
        if (densityDPI < 0) {
            densityDPI = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
        }
        return densityDPI;
    }

    public static int getPixelPerCM() {
        if (pixelPerCM <= 0) {
            pixelPerCM = (int) (BaseApplication.getContext().getResources().getDisplayMetrics().xdpi / 2.54d);
        }
        return pixelPerCM;
    }

    public static float getScaleDensity() {
        if (scaleDensity < 0.0f) {
            scaleDensity = BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity;
        }
        return scaleDensity;
    }

    public static int getScreenHeight() {
        if (screenHeight < 0) {
            if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
                screenHeight = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
            } else {
                screenHeight = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
            }
        }
        return screenHeight;
    }

    private static int getScreenHeightByConfig(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                return dpToPx(configuration.screenWidthDp);
            }
            return dpToPx(configuration.screenHeightDp);
        }
        return 0;
    }

    public static int getScreenHeightByContext(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static double getScreenSizeCM() {
        if (screenSizeCM <= 0.0d) {
            DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
            screenSizeCM = Math.sqrt(Math.pow(displayMetrics.widthPixels, 2.0d) + Math.pow(displayMetrics.heightPixels, 2.0d)) / getPixelPerCM();
        }
        return screenSizeCM;
    }

    public static int getScreenWidth() {
        if (screenWidth < 0) {
            if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
                screenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
            } else {
                screenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
            }
        }
        return screenWidth;
    }

    public static int getScreenWidthByConfig(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                return dpToPx(configuration.screenHeightDp);
            }
            return dpToPx(configuration.screenWidthDp);
        }
        return 0;
    }

    public static int getScreenWidthByContext(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static Drawable getShapeDrawable(int i3, int i16) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i16);
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }

    public static float getSpValue(float f16) {
        if (DEVICE_DENSITY == 0.0f) {
            DEVICE_DENSITY = densityDpi;
        }
        return (f16 * DEVICE_DENSITY) / 160.0f;
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getTextWidth(Paint paint, CharSequence charSequence) {
        if (charSequence == null || charSequence.length() <= 0) {
            return 0;
        }
        int length = charSequence.length();
        paint.getTextWidths(charSequence.toString(), new float[length]);
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            i3 += (int) Math.ceil(r2[i16]);
        }
        return i3;
    }

    public static int getViewHeightWithMargin(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (view != null && view.getVisibility() != 8) {
            int height = view.getHeight();
            if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
            return height;
        }
        return 0;
    }

    public static int getViewWidthWithMargin(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (view != null && view.getVisibility() != 8) {
            int width = view.getWidth();
            if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            }
            return width;
        }
        return 0;
    }

    public static void incrementMargins(View view, int i3, int i16, int i17, int i18) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin + i3, marginLayoutParams.topMargin + i16, marginLayoutParams.rightMargin + i17, marginLayoutParams.bottomMargin + i18);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static boolean isChildOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (isChildOf(view, viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isObscured(View view, boolean z16, boolean z17) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        Rect rect2 = new Rect();
        if (!view.getLocalVisibleRect(rect2)) {
            return true;
        }
        if (rect2.top < 0 && z17) {
            return true;
        }
        if (rect2.left < 0 && z16) {
            return true;
        }
        int abs = Math.abs(Math.abs(rect.left - rect.right) - Math.abs(rect2.left - rect2.right));
        int abs2 = Math.abs(Math.abs(rect.top - rect.bottom) - Math.abs(rect2.top - rect2.bottom));
        if ((!z16 || abs == 0) && (!z17 || abs2 == 0)) {
            return false;
        }
        return true;
    }

    public static int pxToDp(float f16) {
        return Math.round(f16 / getDensity());
    }

    public static int pxTosp(float f16) {
        return (int) ((f16 / BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void removeViewFromParent(View view) {
        ViewGroup viewGroup;
        if (view != null && view.getParent() != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
            viewGroup.removeView(view);
        }
    }

    public static void resetScreenSize() {
        screenWidth = -1;
        screenHeight = -1;
    }

    @TargetApi(11)
    public static void setAlpha(View view, float f16) {
        view.setAlpha(f16);
    }

    public static void setEnableForAllChild(View view, boolean z16) {
        if (view == null) {
            return;
        }
        view.setEnabled(z16);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            setEnableForAllChild(viewGroup.getChildAt(i3), z16);
        }
    }

    public static void setMarginBottom(View view, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.bottomMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }

    public static void setMarginTop(View view, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }

    @TargetApi(11)
    public static void setPivotX(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setPivotX(f16);
    }

    @TargetApi(11)
    public static void setPivotY(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setPivotY(f16);
    }

    @TargetApi(11)
    public static void setRotation(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setRotation(f16);
    }

    @TargetApi(11)
    public static void setScaleX(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setScaleX(f16);
    }

    @TargetApi(11)
    public static void setScaleY(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setScaleY(f16);
    }

    public static void setScreenSizeByConfig(Configuration configuration) {
        screenWidth = getScreenWidthByConfig(configuration);
        screenHeight = getScreenHeightByConfig(configuration);
    }

    @TargetApi(11)
    public static void setTranslationX(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setTranslationX(f16);
    }

    @TargetApi(11)
    public static void setTranslationY(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setTranslationY(f16);
    }

    @TargetApi(16)
    public static void setViewBackground(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public static void setViewRadius(View view, float f16) {
        view.setOutlineProvider(new a(f16));
        view.setClipToOutline(true);
    }

    public static void setViewSize(View view, int i3, int i16) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.width = i3;
            layoutParams.height = i16;
            view.setLayoutParams(layoutParams);
        }
    }

    public static boolean setViewVisibility(View view, int i3) {
        if (view != null) {
            view.setVisibility(i3);
            return true;
        }
        return false;
    }

    public static void setVisible(View view, int i3) {
        if (view != null && view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    public static int spToPx(float f16) {
        return (int) ((f16 * BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void updateLPHeight(View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    public static void updateLPWidth(View view, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i3;
        view.setLayoutParams(layoutParams);
    }

    public static void fixCheckBoxLeftPaddingBelow17(CheckBox checkBox, int i3) {
    }
}
