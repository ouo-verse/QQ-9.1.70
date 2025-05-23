package com.tencent.gdtad.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.text.TextUtils;
import android.view.Display;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtUIUtils {
    private static final int ANDROID_P_API_LIMIT = 27;
    private static final String TAG = "GdtUIUtils";
    public static volatile int sLiuHaiTopHeight;
    public static volatile int sNotchHeight;
    private static int screenHeight;
    private static int screenWidth;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends ShapeDrawable.ShaderFactory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f109576a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f109577b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f109578c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f109579d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int[] f109580e;

        a(float f16, float f17, float f18, float f19, int[] iArr) {
            this.f109576a = f16;
            this.f109577b = f17;
            this.f109578c = f18;
            this.f109579d = f19;
            this.f109580e = iArr;
        }

        @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
        @Nullable
        public Shader resize(int i3, int i16) {
            float f16 = i3;
            float f17 = i16;
            return new LinearGradient(f16 * this.f109576a, f17 * this.f109577b, f16 * this.f109578c, f17 * this.f109579d, this.f109580e, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f109581a;

        b(float f16) {
            this.f109581a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ViewUtils.dip2px(this.f109581a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f109582a;

        c(int i3) {
            this.f109582a = i3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = view.getWidth();
            int height = view.getHeight();
            int i3 = this.f109582a;
            outline.setRoundRect(0, 0, width, height + i3, i3);
        }
    }

    public static boolean canLaunchApp(GdtAd gdtAd, Activity activity) {
        GdtHandler.Params params = new GdtHandler.Params();
        params.f108486ad = gdtAd;
        params.extra = new Bundle();
        params.activity = new WeakReference<>(activity);
        return GdtHandler.canLaunchApp(params);
    }

    public static float constrain(float f16, float f17, float f18) {
        return Math.max(f16, Math.min(f17, f18));
    }

    public static final int dp2px(float f16, @NonNull Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static boolean enableTopLiuHaiIfNeeded(Activity activity, int i3) {
        if (activity == null) {
            GdtLog.e(TAG, "enableTopLiuHaiIfNeeded: activity is null");
            return false;
        }
        if (i3 == 1 && hasTopLiuHai(activity)) {
            enableTopLiuhai(activity);
            return true;
        }
        GdtLog.e(TAG, "enableTopLiuHaiIfNeeded: no need to enable");
        return false;
    }

    @Deprecated
    public static void enableTopLiuhai(Activity activity) {
        if (LiuHaiUtils.enableNotch(activity)) {
            updateLiuhaiTopHeight(activity);
            GdtLog.d(TAG, "enableNotch && updateLiuhaiTopHeight " + sLiuHaiTopHeight);
        }
    }

    public static void expandViewTouchDelegate(@Nullable final View view, final int i3, final int i16, final int i17, final int i18) {
        if (view != null && view.getParent() != null) {
            ((View) view.getParent()).post(new Runnable() { // from class: com.tencent.gdtad.views.GdtUIUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    Rect rect = new Rect();
                    view.setEnabled(true);
                    view.getHitRect(rect);
                    rect.top -= i3;
                    rect.bottom += i16;
                    rect.left -= i17;
                    rect.right += i18;
                    if (QLog.isColorLevel()) {
                        QLog.d("TouchDelegate", 2, " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
                    }
                    TouchDelegate touchDelegate = new TouchDelegate(rect, view);
                    if (View.class.isInstance(view.getParent())) {
                        ((View) view.getParent()).setTouchDelegate(touchDelegate);
                    }
                }
            });
        }
    }

    public static int getColor(String str, int i3) {
        try {
            return Color.parseColor(str);
        } catch (Throwable th5) {
            GdtLog.e(TAG, "getColor error", th5);
            return i3;
        }
    }

    @NonNull
    public static String getFileSizeDesc(long j3) {
        String str;
        try {
            if (j3 < 1024) {
                str = j3 + "B";
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("##0.0");
                double d16 = j3;
                if (d16 < 1048576.0d) {
                    str = decimalFormat.format(d16 / 1024.0d) + "K";
                } else if (d16 < 1.073741824E9d) {
                    str = decimalFormat.format(d16 / 1048576.0d) + "M";
                } else {
                    str = decimalFormat.format(d16 / 1.073741824E9d) + "G";
                }
            }
            return str;
        } catch (Throwable th5) {
            AdLog.e(TAG, "getFileSizeDesc", th5);
            return "";
        }
    }

    public static int getMaxScreenSize(@Nullable Context context) {
        int i3;
        if (context != null && (context instanceof Activity)) {
            int[] portraitScreenSize = getPortraitScreenSize((Activity) context);
            i3 = Math.max(portraitScreenSize[0], portraitScreenSize[1]);
        } else {
            i3 = 1920;
        }
        if (i3 <= 0) {
            return 1920;
        }
        return i3;
    }

    public static int getMinScreenSize(@Nullable Context context) {
        int i3;
        if (context != null && (context instanceof Activity)) {
            int[] portraitScreenSize = getPortraitScreenSize((Activity) context);
            i3 = Math.min(portraitScreenSize[0], portraitScreenSize[1]);
        } else {
            i3 = 1080;
        }
        if (i3 <= 0) {
            return 1080;
        }
        return i3;
    }

    private static int getNotchInScreenHeight(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "getNotchInScreenHeight apiVersion: " + i3);
        }
        if (i3 > 27) {
            return LiuHaiUtils.getNotchInScreenHeight_AndroidP(activity);
        }
        return LiuHaiUtils.getNotchInScreenHeight_AndroidO(activity);
    }

    public static int getOffsetByBaseline(int i3, int i16, int i17) {
        try {
            return Double.valueOf(((i3 * 1.0d) * i17) / i16).intValue();
        } catch (Throwable th5) {
            AdLog.e(TAG, "getOffsetByBaseline", th5);
            return Integer.MIN_VALUE;
        }
    }

    public static int getOrientation(@Nullable Context context) {
        if (context != null && context.getResources() != null && context.getResources().getConfiguration() != null) {
            return context.getResources().getConfiguration().orientation;
        }
        return 0;
    }

    public static double getPercentageOfGlobalVisibleRect(@Nullable View view) {
        if (view == null) {
            return 0.0d;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect) || rect.left >= getScreenWidth(view.getContext()) || rect.top >= getScreenHeight(view.getContext()) || rect.right <= 0 || rect.bottom <= 0) {
            return 0.0d;
        }
        try {
            return ((rect.width() * 1.0d) * rect.height()) / (view.getWidth() * view.getHeight());
        } catch (Throwable th5) {
            AdLog.e(TAG, "getPercentageOfGlobalVisibleRect", th5);
            return -2.147483648E9d;
        }
    }

    public static int getPhysicalScreenWidth(@Nullable Context context) {
        if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            GdtLog.e(TAG, "getScreenWidth error");
            return Integer.MIN_VALUE;
        }
        int i3 = context.getResources().getDisplayMetrics().widthPixels;
        int i16 = context.getResources().getDisplayMetrics().heightPixels;
        if (i3 > i16) {
            return i16;
        }
        return i3;
    }

    @NonNull
    @TargetApi(17)
    public static int[] getPortraitScreenSize(@Nullable Activity activity) {
        Display display;
        if (activity == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getPortraitScreenSize ERROR activity == null");
            }
            return new int[]{0, 0};
        }
        if (screenWidth == 0 || screenHeight == 0) {
            WindowManager windowManager = (WindowManager) activity.getSystemService("window");
            if (windowManager != null) {
                display = windowManager.getDefaultDisplay();
            } else {
                display = null;
            }
            Point point = new Point();
            if (display != null) {
                display.getRealSize(point);
                screenWidth = point.x;
                screenHeight = point.y;
            }
        }
        int i3 = screenHeight;
        int i16 = screenWidth;
        if (i3 < i16) {
            return new int[]{i3, i16};
        }
        return new int[]{i16, i3};
    }

    public static int getScreenHeight(@Nullable Context context) {
        if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            GdtLog.e(TAG, "getScreenHeight error");
            return Integer.MIN_VALUE;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(@Nullable Context context) {
        if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            GdtLog.e(TAG, "getScreenWidth error");
            return Integer.MIN_VALUE;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String getSocialMinSeconds(int i3) {
        String valueOf;
        int i16 = i3 / 1000;
        int i17 = i16 / 60;
        int i18 = i16 % 60;
        if (i17 < 10) {
            valueOf = "0" + i17;
        } else {
            valueOf = String.valueOf(i17);
        }
        if (i18 < 10) {
            return String.format("%s:0%s", valueOf, Integer.valueOf(i18));
        }
        return String.format("%s:%s", valueOf, Integer.valueOf(i18));
    }

    @NonNull
    public static String getTotalTimeStr(long j3) {
        long j16 = j3 / 1000;
        long j17 = j16 % 60;
        long j18 = (j16 / 60) % 60;
        long j19 = j16 / 3600;
        if (j19 > 0) {
            return String.format("%d:%02d:%02d", Long.valueOf(j19), Long.valueOf(j18), Long.valueOf(j17)).toString();
        }
        return String.format("%02d:%02d", Long.valueOf(j18), Long.valueOf(j17)).toString();
    }

    public static Drawable getUrlDrawable(Resources resources, String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        try {
            obtain.mLoadingDrawable = resources.getDrawable(R.drawable.trans);
            obtain.mFailedDrawable = resources.getDrawable(R.drawable.trans);
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            if (drawable != null) {
                return drawable;
            }
            return null;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "getUrlDrawable error: " + th5);
            return null;
        }
    }

    public static String getVaildImageUrl(String str) {
        if (str.endsWith("sharp=")) {
            return str + "true";
        }
        return str;
    }

    public static String getValidAdName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.getBytes(StandardCharsets.UTF_8).length <= 36) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (char c16 : str.toCharArray()) {
            i3 += String.valueOf(c16).getBytes(StandardCharsets.UTF_8).length;
            if (i3 > 33) {
                break;
            }
            sb5.append(c16);
        }
        sb5.append("\u00b7\u00b7\u00b7");
        return sb5.toString();
    }

    public static int getValueDependsOnScreenWidth(int i3, int i16) {
        if (i3 != 0) {
            return Double.valueOf(((i16 * 1.0d) * getPhysicalScreenWidth(BaseApplication.getContext())) / i3).intValue();
        }
        return 0;
    }

    public static int getValueDependsOnScreenWidthIfPortrait(Context context, int i3, int i16) {
        int i17;
        if (getOrientation(context) == 1) {
            i17 = getScreenWidth(context);
        } else if (getOrientation(context) == 2) {
            i17 = getScreenHeight(context);
        } else {
            i17 = 0;
        }
        if (i3 == 0) {
            return 0;
        }
        return Double.valueOf(((i16 * 1.0d) * i17) / i3).intValue();
    }

    @Deprecated
    public static boolean hasTopLiuHai(Activity activity) {
        LiuHaiUtils.initLiuHaiProperty(activity);
        GdtLog.d(TAG, "hasTopLiuHai  " + LiuHaiUtils.sHasNotch);
        return LiuHaiUtils.sHasNotch;
    }

    public static boolean isFloatEqual(float f16, float f17) {
        if (Math.abs(f16 - f17) < 1.0E-13d) {
            return true;
        }
        return false;
    }

    public static boolean isMatchedMotiveVideoSize(int i3) {
        if (i3 != 185 && i3 != 585) {
            return false;
        }
        return true;
    }

    @NonNull
    public static Drawable makeCubicGradientScrimDrawable(@ColorInt int i3, int i16, int i17) {
        float f16;
        float f17;
        float f18;
        float f19;
        int max = Math.max(i16, 2);
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        int[] iArr = new int[max];
        int alpha = Color.alpha(i3);
        int i18 = 0;
        while (true) {
            f16 = 0.0f;
            if (i18 >= max) {
                break;
            }
            iArr[i18] = modifyAlpha(i3, (int) (alpha * constrain(0.0f, 1.0f, (float) Math.pow((i18 * 1.0f) / (max - 1), 3.0d))));
            i18++;
        }
        int i19 = i17 & 7;
        if (i19 != 3) {
            if (i19 != 5) {
                f17 = 0.0f;
                f18 = 0.0f;
            } else {
                f18 = 1.0f;
                f17 = 0.0f;
            }
        } else {
            f17 = 1.0f;
            f18 = 0.0f;
        }
        int i26 = i17 & 112;
        if (i26 != 48) {
            if (i26 != 80) {
                f19 = 0.0f;
            } else {
                f19 = 1.0f;
            }
        } else {
            f19 = 0.0f;
            f16 = 1.0f;
        }
        paintDrawable.setShaderFactory(new a(f17, f16, f18, f19, iArr));
        return paintDrawable;
    }

    public static int modifyAlpha(@ColorInt int i3, @IntRange(from = 0, to = 255) int i16) {
        return (i3 & 16777215) | (i16 << 24);
    }

    public static boolean needUpdateIcon(String str) {
        return str.contains("\u4e0b\u8f7d");
    }

    public static int px2dp(float f16, Resources resources) {
        float f17;
        if (resources == null) {
            return Integer.MIN_VALUE;
        }
        if (resources.getDisplayMetrics() != null) {
            f17 = resources.getDisplayMetrics().density;
        } else {
            f17 = 0.0f;
        }
        if (isFloatEqual(f17, 0.0f)) {
            return 0;
        }
        return Math.round(f16 / f17);
    }

    public static void setNightThemeByFrameLayout(@Nullable FrameLayout frameLayout) {
        if (frameLayout != null && ThemeUtil.isNowThemeIsNight(null, false, null)) {
            frameLayout.setForeground(new ColorDrawable(1996488704));
        }
    }

    public static void setNightThemeByView(@Nullable View view) {
        if (view == null) {
            return;
        }
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static void setViewRadius(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setOutlineProvider(new b(f16));
        view.setClipToOutline(true);
    }

    public static void setViewTopRadius(View view, float f16) {
        int dip2px = ViewUtils.dip2px(f16);
        if (view == null) {
            return;
        }
        view.setOutlineProvider(new c(dip2px));
        view.setClipToOutline(true);
    }

    private static void updateLiuhaiTopHeight(Activity activity) {
        sLiuHaiTopHeight = getNotchInScreenHeight(activity);
        sNotchHeight = LiuHaiUtils.sNotchHeight;
    }

    public static Drawable getUrlDrawable(String str, int i3, int i16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        try {
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            if (drawable != null) {
                return drawable;
            }
            return null;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "getUrlDrawable error: " + th5);
            return null;
        }
    }

    public static Drawable getUrlDrawable(String str) {
        String vaildImageUrl = getVaildImageUrl(str);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        try {
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            URLDrawable drawable = URLDrawable.getDrawable(vaildImageUrl, obtain);
            if (drawable != null) {
                return drawable;
            }
            return null;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "getUrlDrawable error: " + th5);
            return null;
        }
    }
}
