package com.tencent.qqmini.sdk.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class ViewUtils {
    private static float DEVICE_DENSITY = 0.0f;
    private static float density = -1.0f;
    private static int densityDPI = -1;
    public static int densityDpi = 0;
    public static float mDensity = 0.0f;
    private static int pixelPerCM = 0;
    private static float scaleDensity = -1.0f;
    private static int screenHeight = -1;
    private static double screenSizeCM = 0.0d;
    private static int screenWidth = -1;

    static {
        DisplayMetrics displayMetrics = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
        mDensity = displayMetrics.density;
        densityDpi = displayMetrics.densityDpi;
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
            QMLog.e("getBreakString", "getBreakString", th5);
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
        if (density < 0.0f) {
            density = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static float getDensityDpi() {
        if (densityDPI < 0) {
            densityDPI = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().densityDpi;
        }
        return densityDPI;
    }

    public static int getPixelPerCM() {
        if (pixelPerCM <= 0) {
            pixelPerCM = (int) (AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().xdpi / 2.54d);
        }
        return pixelPerCM;
    }

    public static float getScaleDensity() {
        if (scaleDensity < 0.0f) {
            scaleDensity = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().scaledDensity;
        }
        return scaleDensity;
    }

    public static int getScreenHeight() {
        if (screenHeight < 0) {
            if (AppLoaderFactory.g().getContext().getResources().getConfiguration().orientation == 2) {
                screenHeight = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().widthPixels;
            } else {
                screenHeight = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().heightPixels;
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

    public static double getScreenSizeCM() {
        if (screenSizeCM <= 0.0d) {
            DisplayMetrics displayMetrics = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
            screenSizeCM = Math.sqrt(Math.pow(displayMetrics.widthPixels, 2.0d) + Math.pow(displayMetrics.heightPixels, 2.0d)) / getPixelPerCM();
        }
        return screenSizeCM;
    }

    public static int getScreenWidth() {
        if (screenWidth < 0) {
            if (AppLoaderFactory.g().getContext().getResources().getConfiguration().orientation == 2) {
                screenWidth = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().heightPixels;
            } else {
                screenWidth = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().widthPixels;
            }
        }
        return screenWidth;
    }

    private static int getScreenWidthByConfig(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                return dpToPx(configuration.screenHeightDp);
            }
            return dpToPx(configuration.screenWidthDp);
        }
        return 0;
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

    public static boolean isActivityInvalid(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return true;
        }
        return false;
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

    public static int pxToDp(float f16) {
        return Math.round(f16 / getDensity());
    }

    public static int pxTosp(float f16) {
        return (int) ((f16 / AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
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
        return (int) ((f16 * AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float getDensity(Activity activity) {
        if (activity != null && activity.getResources() != null) {
            activity.getResources().getDisplayMetrics();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.density;
        }
        return getDensity();
    }
}
