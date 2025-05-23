package com.qzone.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private static float f59795a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    private static float f59796b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    private static int f59797c = -1;

    public static void a(View view, int i3) {
        try {
            if (view.getBackground() != null) {
                view.getBackground().setAlpha(i3);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    a(viewGroup.getChildAt(i16), i3);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static int c(float f16) {
        float a16;
        if (GlobalDisplayMetricsManager.sOriginDisplayMetrics != null) {
            a16 = GlobalDisplayMetricsManager.sOriginDisplayMetrics.density;
        } else {
            a16 = u5.a.a();
        }
        return (int) ((f16 * a16) + 0.5f);
    }

    public static int d(float f16) {
        return (int) ((f16 * u5.a.a()) + 0.5f);
    }

    public static int e(float f16) {
        return Math.round(f16 * i());
    }

    public static Bitmap f(Drawable drawable) {
        return g(drawable, Boolean.FALSE);
    }

    public static Bitmap h(Context context, int i3, int i16, int i17) {
        Drawable drawable = context.getDrawable(i3);
        if (drawable == null) {
            QZLog.e("ViewUtils", "[getBitmapFromDefaultDrawable] drawable is null");
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static float i() {
        if (f59796b < 0.0f) {
            f59796b = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        }
        return f59796b;
    }

    public static float j() {
        if (f59797c < 0) {
            f59797c = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
        }
        return f59797c;
    }

    public static int k() {
        return ViewUtils.getScreenHeight();
    }

    public static int l() {
        return ViewUtils.getScreenWidth();
    }

    public static float m(float f16) {
        if (f59795a == 0.0f) {
            f59795a = u5.a.b();
        }
        return (f16 * f59795a) / 160.0f;
    }

    public static int n(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int o(float f16, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(f16);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static int q(float f16, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(f16);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    public static int r(float f16) {
        return Math.round(f16 / i());
    }

    public static int s(float f16) {
        return (int) ((f16 / BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int v(float f16) {
        return (int) ((f16 * BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static Bitmap b(View view, int i3, int i16) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i16, 1073741824));
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.draw(canvas);
        return createBitmap;
    }

    public static void t(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public static Bitmap g(Drawable drawable, Boolean bool) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        if (bool.booleanValue()) {
            drawable.setBounds(-1, 0, canvas.getWidth() + 1, canvas.getHeight());
        } else {
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        }
        drawable.draw(canvas);
        return createBitmap;
    }

    public static int p(TextView textView) {
        int floor;
        if (textView == null) {
            return 0;
        }
        String charSequence = textView.getText().toString();
        if (charSequence.length() == 0) {
            return 0;
        }
        float textSize = textView.getTextSize();
        Paint paint = new Paint();
        Rect rect = new Rect();
        paint.setTextSize(textSize);
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        int width = rect.width();
        int width2 = textView.getWidth();
        int length = (int) ((width * 1.0f) / charSequence.length());
        if (length == 0 || (floor = (int) Math.floor((width2 * 1.0d) / length)) == 0) {
            return 0;
        }
        return (int) Math.ceil(charSequence.length() / floor);
    }

    public static Bitmap u(View view) {
        Bitmap bitmap = null;
        if (view == null) {
            return null;
        }
        view.clearFocus();
        view.setPressed(false);
        try {
            view.layout(0, 0, view.getWidth(), view.getHeight());
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            bitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            return bitmap;
        } catch (Exception e16) {
            QLog.e("ViewUtils", 1, "showViewBitmap error:" + Log.getStackTraceString(e16));
            return bitmap;
        }
    }
}
