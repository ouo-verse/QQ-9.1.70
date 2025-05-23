package com.tencent.ams.fusion.widget.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.tencent.ams.fusion.widget.utils.FusionWidgetConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Utils {
    static IPatchRedirector $redirector_ = null;
    public static final Handler MAIN_HANDLER;
    private static final String TAG = "Utils";
    private static int sScreenHeightPixels;
    private static int sScreenRealHeightPixels;
    private static int sScreenRealWidthPixels;
    private static int sScreenWidthPixels;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39105);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            MAIN_HANDLER = new Handler(Looper.getMainLooper());
        }
    }

    public Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap bitmapFromAssets(Context context, String str, int i3, int i16) {
        AssetManager assetManager;
        InputStream inputStream;
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        InputStream inputStream2 = null;
        bitmap = null;
        if (context != null) {
            assetManager = context.getAssets();
        } else {
            assetManager = null;
        }
        try {
            if (assetManager != null) {
                try {
                    inputStream = assetManager.open(str);
                } catch (Exception e16) {
                    e = e16;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream2 != null) {
                    }
                    throw th;
                }
                try {
                    try {
                        bitmap = createBitmap(BitmapFactory.decodeStream(inputStream), i3, i16, true);
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e17) {
                                Logger.e("Utils", "bitmapFromAssets", e17);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    e = e18;
                    Logger.w("bitmapFromAssets error." + e.toString());
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return bitmap;
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (IOException e19) {
            Logger.e("Utils", "bitmapFromAssets", e19);
        }
        return bitmap;
    }

    public static Bitmap bitmapFromBase64String(String str, int i3, int i16) {
        Logger.i("bitmapFromBase64String width:" + i3 + ", height:" + i16);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null || decode.length <= 0) {
                return null;
            }
            return createBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length), i3, i16, true);
        } catch (Throwable th5) {
            Logger.w("bitmapFromBase64String error." + th5.toString());
            return null;
        }
    }

    public static Bitmap bitmapFromBase64StringSafe(String str, int i3, int i16) {
        Logger.i("bitmapFromBase64String width:" + i3 + ", height:" + i16);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null || decode.length <= 0) {
                return null;
            }
            return scaleBitmapSafe(BitmapFactory.decodeByteArray(decode, 0, decode.length), i3, i16);
        } catch (Throwable th5) {
            Logger.w("bitmapFromBase64String error." + th5.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap bitmapFromFile(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        BitmapFactory.Options options;
        BufferedInputStream bufferedInputStream2;
        Logger.d("Utils", "bitmapFromFile: " + str);
        boolean exists = new File(str).exists();
        Bitmap bitmap = null;
        BufferedInputStream bufferedInputStream3 = null;
        if (exists) {
            try {
                int screenWidth = getScreenWidth(context);
                int screenHeight = getScreenHeight(context);
                options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                if (screenWidth > 0 && screenHeight > 0) {
                    options.inJustDecodeBounds = true;
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                    try {
                        BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        options.inSampleSize = calculateInSampleSize(options, screenWidth, screenHeight);
                    } catch (FileNotFoundException unused) {
                        if (bufferedInputStream != null) {
                        }
                        return null;
                    } catch (IllegalArgumentException unused2) {
                        if (bufferedInputStream != null) {
                        }
                        return null;
                    } catch (OutOfMemoryError unused3) {
                        if (bufferedInputStream != null) {
                        }
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream3 = bufferedInputStream;
                        if (bufferedInputStream3 != null) {
                        }
                        throw th;
                    }
                } else {
                    bufferedInputStream = null;
                }
                Logger.d("Utils", "fromFileToBitmap, screenWidth: " + screenWidth + ", screenHeight: " + screenHeight + ", imSampleSize: " + options.inSampleSize);
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            } catch (FileNotFoundException unused4) {
                bufferedInputStream = null;
            } catch (IllegalArgumentException unused5) {
                bufferedInputStream = null;
            } catch (OutOfMemoryError unused6) {
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
            }
            try {
                options.inJustDecodeBounds = false;
                options.inDither = false;
                bitmap = BitmapFactory.decodeStream(bufferedInputStream2, null, options);
                try {
                    bufferedInputStream2.close();
                } catch (Exception unused7) {
                }
            } catch (FileNotFoundException unused8) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused9) {
                    }
                }
                return null;
            } catch (IllegalArgumentException unused10) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused11) {
                    }
                }
                return null;
            } catch (OutOfMemoryError unused12) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused13) {
                    }
                }
                return null;
            } catch (Throwable th7) {
                bufferedInputStream3 = bufferedInputStream2;
                th = th7;
                if (bufferedInputStream3 != null) {
                    try {
                        bufferedInputStream3.close();
                    } catch (Exception unused14) {
                    }
                }
                throw th;
            }
        }
        Logger.d("Utils", "fromFileToBitmap, mPath: " + str + ", bitmap: " + bitmap + ", isFileExists: " + exists);
        return bitmap;
    }

    public static Bitmap bitmapFromNet(String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        InputStream inputStream2;
        Logger.d("Utils", "bitmapFromNet: " + str);
        Bitmap bitmap = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            inputStream = null;
        }
        try {
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            try {
                inputStream2 = new BufferedInputStream(inputStream);
                try {
                    bitmap = BitmapFactory.decodeStream(inputStream2);
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        Logger.w("Utils", "Error bitmapFromNet: " + th.getMessage());
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused) {
                            }
                        }
                        safeCloseInputStream(inputStream);
                        safeCloseInputStream(inputStream2);
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream2 = null;
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            inputStream2 = inputStream;
            Logger.w("Utils", "Error bitmapFromNet: " + th.getMessage());
        }
        return bitmap;
    }

    public static int buildColorFromARGB(float f16, float f17, float f18, float f19) {
        return (((int) ((f16 * 255.0f) + 0.5f)) << 24) | (((int) ((f17 * 255.0f) + 0.5f)) << 16) | (((int) ((f18 * 255.0f) + 0.5f)) << 8) | ((int) ((f19 * 255.0f) + 0.5f));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (r5 > 1.0f) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int buildColorWithAlphaRatio(float f16, int i3) {
        int alpha = Color.alpha(i3);
        int red = Color.red(i3);
        int green = Color.green(i3);
        int blue = Color.blue(i3);
        float f17 = 0.0f;
        if (f16 >= 0.0f) {
            f17 = 1.0f;
        }
        f16 = f17;
        return buildColorFromARGB((alpha / 255.0f) * f16, red / 255.0f, green / 255.0f, blue / 255.0f);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int i17 = 1;
        if (options != null && i3 > 0 && i16 > 0) {
            int i18 = options.outHeight;
            int i19 = options.outWidth;
            if (i18 > i16 || i19 > i3) {
                int i26 = i18 / 2;
                int i27 = i19 / 2;
                while (i26 / i17 > i16 && i27 / i17 > i3) {
                    i17 *= 2;
                }
            }
        }
        return i17;
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i3, int i16, boolean z16) {
        if (bitmap != null && ((bitmap.getWidth() != i3 || bitmap.getHeight() != i16) && i3 > 0 && i16 > 0)) {
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, i16, true);
                if (createScaledBitmap != bitmap) {
                    if (z16) {
                        bitmap.recycle();
                    }
                    return createScaledBitmap;
                }
            } catch (Throwable th5) {
                Logger.w("createBitmap error." + th5.toString());
            }
        }
        return bitmap;
    }

    public static Bitmap createMaskBitmap(Bitmap bitmap, int i3, int i16, int i17, int i18) {
        float f16 = i17;
        return createMaskBitmap(bitmap, i3, i16, new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, i18);
    }

    public static float dp2px(float f16) {
        if (FusionWidgetConfig.getOutDensity() != 0.0f && FusionWidgetConfig.getOutDensityScale() != 0.0f) {
            return ((f16 * FusionWidgetConfig.getOutDensity()) / FusionWidgetConfig.getOutDensityScale()) + 0.5f;
        }
        return TypedValue.applyDimension(1, f16, Resources.getSystem().getDisplayMetrics());
    }

    public static Bitmap getAllRoundCornerBitmap(Bitmap bitmap, int i3) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            Rect rect = new Rect(0, 0, width, height);
            float f16 = i3;
            canvas.drawRoundRect(new RectF(rect), f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return createBitmap;
        } catch (Throwable th5) {
            Logger.e("Utils", th5);
            return null;
        }
    }

    public static Bitmap getBottomRoundCornerBitmap(Bitmap bitmap, int i3) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(-1);
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            float f16 = width;
            path.lineTo(f16, 0.0f);
            path.lineTo(f16, height - i3);
            int i16 = i3 * 2;
            float f17 = height - i16;
            float f18 = height;
            path.arcTo(new RectF(width - i16, f17, f16, f18), 0.0f, 90.0f, false);
            path.lineTo(i3, f18);
            path.arcTo(new RectF(0.0f, f17, i16, f18), 90.0f, 90.0f, false);
            path.close();
            canvas.drawPath(path, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            Rect rect = new Rect(0, 0, width, height);
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return createBitmap;
        } catch (Throwable th5) {
            Logger.e("Utils", th5);
            return null;
        }
    }

    public static Bitmap getCircleBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, width, height);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-1);
        canvas.drawCircle(width / 2.0f, height / 2.0f, Math.min(width, height) / 2.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    private static float getCross(PointF pointF, PointF pointF2, PointF pointF3) {
        float f16 = pointF2.x;
        float f17 = pointF.x;
        float f18 = pointF3.y;
        float f19 = pointF.y;
        return ((f16 - f17) * (f18 - f19)) - ((pointF3.x - f17) * (pointF2.y - f19));
    }

    public static Activity getCurrentActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return getCurrentActivity(((ContextWrapper) context).getBaseContext());
    }

    public static int getRelativeSize(Context context, int i3) {
        return (int) ((getScreenWidth(context) * i3) / 750.0f);
    }

    public static int getRelativeSize1334(Context context, int i3) {
        return (int) ((getScreenWidth(context) * i3) / 1334.0f);
    }

    public static int getRelativeSize375(Context context, int i3) {
        return (int) ((getScreenWidth(context) * i3) / 375.0f);
    }

    public static int getScreenHeight(Context context) {
        if (sScreenHeightPixels == 0) {
            initScreenSize(context);
        }
        return sScreenHeightPixels;
    }

    public static int getScreenOrientation(Context context) {
        try {
            return context.getResources().getConfiguration().orientation;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0;
        }
    }

    public static int getScreenRealHeight(Context context) {
        if (sScreenRealHeightPixels == 0) {
            initScreenRealSize(context);
        }
        return sScreenRealHeightPixels;
    }

    public static int getScreenRealWidth(Context context) {
        if (sScreenRealWidthPixels == 0) {
            initScreenRealSize(context);
        }
        return sScreenRealWidthPixels;
    }

    public static int getScreenWidth(Context context) {
        if (sScreenWidthPixels == 0) {
            initScreenSize(context);
        }
        return sScreenWidthPixels;
    }

    public static Rect getTextBound(float f16, String str) {
        Rect rect = new Rect();
        if (TextUtils.isEmpty(str)) {
            return rect;
        }
        Paint paint = new Paint();
        paint.setTextSize(f16);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    public static float getTextPaintBaselineToBottom(float f16) {
        Paint paint = new Paint();
        paint.setTextSize(f16);
        return Math.abs(paint.getFontMetrics().bottom);
    }

    public static float getTextPaintBaselineToTop(float f16) {
        Paint paint = new Paint();
        paint.setTextSize(f16);
        return Math.abs(paint.getFontMetrics().top);
    }

    public static float getTextPaintHeight(float f16) {
        Paint paint = new Paint();
        paint.setTextSize(f16);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return Math.abs((fontMetrics.leading + fontMetrics.bottom) - fontMetrics.top);
    }

    public static float getTextWidth(float f16, boolean z16, String str) {
        Typeface typeface;
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f16);
        if (z16) {
            typeface = Typeface.DEFAULT_BOLD;
        } else {
            typeface = Typeface.DEFAULT;
        }
        textPaint.setTypeface(typeface);
        return Layout.getDesiredWidth(str, textPaint);
    }

    public static Bitmap getTopRoundCornerBitmap(Bitmap bitmap, int i3) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(-1);
            Path path = new Path();
            path.moveTo(0.0f, i3);
            int i16 = i3 * 2;
            float f16 = i16;
            path.arcTo(new RectF(0.0f, 0.0f, f16, f16), 180.0f, 90.0f, false);
            path.lineTo(width - i3, 0.0f);
            float f17 = width - i16;
            float f18 = width;
            path.arcTo(new RectF(f17, 0.0f, f18, f16), 270.0f, 90.0f, false);
            float f19 = height;
            path.lineTo(f18, f19);
            path.lineTo(0.0f, f19);
            path.close();
            canvas.drawPath(path, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            Rect rect = new Rect(0, 0, width, height);
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return createBitmap;
        } catch (Throwable th5) {
            Logger.e("Utils", th5);
            return null;
        }
    }

    public static float getXInRootView(View view, View view2) {
        if (view == null) {
            return 0.0f;
        }
        Object parent = view.getParent();
        if (parent != null && (parent instanceof View) && !parent.equals(view2)) {
            return view.getX() + getXInRootView((View) parent, view2);
        }
        return view.getX();
    }

    public static float getYInRootView(View view, View view2) {
        if (view == null) {
            return 0.0f;
        }
        Object parent = view.getParent();
        if (parent != null && (parent instanceof View) && !parent.equals(view2)) {
            return view.getY() + getYInRootView((View) parent, view2);
        }
        return view.getY();
    }

    @RequiresApi(api = 17)
    private static void initScreenRealSize(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            int i3 = displayMetrics.widthPixels;
            int i16 = displayMetrics.heightPixels;
            sScreenRealWidthPixels = Math.min(i3, i16);
            sScreenRealHeightPixels = Math.max(i3, i16);
            Logger.i("Utils", "sScreenRealWidthPixels = " + sScreenRealWidthPixels + ",sScreenRealHeightPixels = " + sScreenRealHeightPixels);
        } catch (Throwable th5) {
            Logger.e("Utils", "initScreenRealSize error", th5);
        }
    }

    public static void initScreenSize(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i3 = displayMetrics.widthPixels;
            int i16 = displayMetrics.heightPixels;
            sScreenWidthPixels = Math.min(i3, i16);
            sScreenHeightPixels = Math.max(i3, i16);
            Logger.i("Utils", "sScreenWidthPixels = " + sScreenWidthPixels + ",sScreenHeightPixels = " + sScreenHeightPixels);
        } catch (Throwable th5) {
            Logger.e("Utils", "initScreenSize failed", th5);
        }
    }

    public static boolean isAppOnForeground(Context context) {
        AppForegroundListener appForegroundListener = FusionWidgetConfig.getAppForegroundListener();
        if (appForegroundListener != null) {
            return appForegroundListener.isOnForeground();
        }
        return true;
    }

    public static boolean isClickEvent(ViewConfiguration viewConfiguration, float f16, float f17, float f18, float f19) {
        if (viewConfiguration == null) {
            return false;
        }
        float f26 = f18 - f16;
        float f27 = f19 - f17;
        if ((f26 * f26) + (f27 * f27) > viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop()) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection != null && collection.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isInDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) == 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isLandscape(Context context) {
        if (getScreenOrientation(context) == 2) {
            return true;
        }
        return false;
    }

    public static boolean isPointInArea(float f16, float f17, RectF rectF, float f18, float f19, float f26) {
        if (rectF == null || rectF.width() == 0.0f || rectF.height() == 0.0f) {
            return false;
        }
        float f27 = rectF.left;
        float f28 = rectF.top;
        float f29 = rectF.right;
        float f36 = rectF.bottom;
        float[] fArr = {f27, f28, f29, f28, f29, f36, f27, f36};
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postRotate(f18, f19, f26);
        matrix.mapPoints(fArr);
        PointF pointF = new PointF(fArr[0], fArr[1]);
        PointF pointF2 = new PointF(fArr[2], fArr[3]);
        PointF pointF3 = new PointF(fArr[4], fArr[5]);
        PointF pointF4 = new PointF(fArr[6], fArr[7]);
        PointF pointF5 = new PointF(f16, f17);
        if (getCross(pointF, pointF2, pointF5) * getCross(pointF3, pointF4, pointF5) < 0.0f || getCross(pointF2, pointF3, pointF5) * getCross(pointF4, pointF, pointF5) < 0.0f) {
            return false;
        }
        return true;
    }

    public static boolean isPortrait(Context context) {
        if (getScreenOrientation(context) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isTouchInView(View view, float f16, float f17) {
        if (view != null) {
            Rect rect = new Rect();
            rect.left = view.getLeft();
            rect.bottom = view.getBottom();
            rect.right = view.getRight();
            rect.top = view.getTop();
            return rect.contains((int) f16, (int) f17);
        }
        return false;
    }

    public static Bitmap[] loadFrameIconBitmaps(Context context, String str, int i3, int i16) {
        File file;
        File file2;
        Logger.i("Utils", "loadFrameIconBitmaps - path: " + str);
        if (str == null) {
            return null;
        }
        try {
            file = new File(str);
        } catch (Throwable unused) {
        }
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length == 1 && (file2 = listFiles[0]) != null && file2.isDirectory()) {
                Logger.w("Utils", "loadFrameIconBitmaps: unzipFile has sub root directory - " + listFiles[0].getName());
                listFiles = listFiles[0].listFiles();
            }
            if (listFiles != null && listFiles.length != 0) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.tencent.ams.fusion.widget.utils.Utils.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    private int getIconFileIndex(File file3) {
                        if (file3 != null && file3.isFile()) {
                            try {
                                String name = file3.getName();
                                return Integer.parseInt(name.substring(0, name.lastIndexOf(".")));
                            } catch (Throwable unused2) {
                                return -1;
                            }
                        }
                        return -1;
                    }

                    @Override // java.util.Comparator
                    public int compare(File file3, File file4) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file3, (Object) file4)).intValue();
                        }
                        int iconFileIndex = getIconFileIndex(file3);
                        int iconFileIndex2 = getIconFileIndex(file4);
                        if (iconFileIndex < 0) {
                            return 1;
                        }
                        if (iconFileIndex2 < 0) {
                            return -1;
                        }
                        return iconFileIndex - iconFileIndex2;
                    }
                });
                ArrayList arrayList = new ArrayList();
                for (File file3 : listFiles) {
                    if (file3 != null) {
                        Bitmap bitmapFromFile = bitmapFromFile(context, file3.getAbsolutePath());
                        if (bitmapFromFile != null && i3 > 0 && i16 > 0) {
                            bitmapFromFile = scaleBitmapSafe(bitmapFromFile, i3, i16);
                        }
                        if (bitmapFromFile != null) {
                            arrayList.add(bitmapFromFile);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    return (Bitmap[]) arrayList.toArray(new Bitmap[0]);
                }
                return null;
            }
            Logger.w("Utils", "loadFrameIconBitmaps failed: unzipFile has no sub file");
            return null;
        }
        Logger.w("Utils", "loadFrameIconBitmaps failed: unzipFile not exist or not directory");
        return null;
    }

    public static float px2dp(float f16) {
        float f17 = Resources.getSystem().getDisplayMetrics().density;
        if (FusionWidgetConfig.getOutDensity() != 0.0f && FusionWidgetConfig.getOutDensityScale() != 0.0f) {
            f17 = FusionWidgetConfig.getOutDensity() / FusionWidgetConfig.getOutDensityScale();
        }
        if (f17 == 0.0f) {
            return f16 / 2.0f;
        }
        return (int) ((f16 / f17) + 0.5f);
    }

    public static void recycleBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (Throwable th5) {
                Logger.e("Utils", "recycleBitmap error", th5);
            }
        }
    }

    public static void removeCallbacks(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        MAIN_HANDLER.removeCallbacks(runnable);
    }

    public static Bitmap reverse(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap reverseBitmap(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, float f16, boolean z16) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f16);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (createBitmap.equals(bitmap)) {
            return createBitmap;
        }
        if (z16) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static void runOnAsyncThread(Runnable runnable) {
        runOnAsyncThread(runnable, false);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            MAIN_HANDLER.post(runnable);
        }
    }

    public static void safeCloseInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void safeCloseOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int safeParseColor(String str, int i3) {
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            Logger.w("Utils", "can't parse color: " + str + ", use default instead.");
            return i3;
        }
    }

    public static void safeRemoveChildView(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) view.getParent()).removeView(view);
            } catch (Throwable th5) {
                Logger.e("Utils", "safeRemoveChildView failed", th5);
            }
        }
    }

    public static Bitmap scaleBitmapSafe(Bitmap bitmap, int i3, int i16) {
        if (bitmap != null && ((bitmap.getWidth() != i3 || bitmap.getHeight() != i16) && i3 > 0 && i16 > 0)) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(i3 / width, i16 / height);
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Throwable th5) {
                Logger.w("scaleBitmapSafe error." + th5.toString());
            }
        }
        return bitmap;
    }

    public static String toHexString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            int i3 = b16 & 255;
            if (i3 < 16) {
                sb5.append("0" + Integer.toHexString(i3));
                sb5.append(str);
            } else {
                sb5.append(Integer.toHexString(i3));
                sb5.append(str);
            }
        }
        return sb5.toString();
    }

    public static String toMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            return toHexString(messageDigest.digest(), "");
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap createMaskBitmap(Bitmap bitmap, int i3, int i16, float[] fArr, int i17) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, i3, i16), fArr, Path.Direction.CCW);
        canvas.clipPath(path);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, i3, i16), paint);
        if (i17 != 0) {
            canvas.drawColor(i17);
        }
        return createBitmap;
    }

    public static void runOnAsyncThread(Runnable runnable, boolean z16) {
        if (runnable == null) {
            return;
        }
        if (!z16 && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            runnable.run();
            return;
        }
        FusionWidgetConfig.AsyncTaskExecutor asyncTaskExecutor = FusionWidgetConfig.getAsyncTaskExecutor();
        if (asyncTaskExecutor != null) {
            asyncTaskExecutor.execute(runnable);
        } else {
            new BaseThread(runnable).start();
        }
    }

    public static void runOnUiThread(Runnable runnable, long j3) {
        if (runnable == null) {
            return;
        }
        if (j3 <= 0) {
            runOnUiThread(runnable);
        } else {
            MAIN_HANDLER.postDelayed(runnable, j3);
        }
    }

    public static void initScreenSize(int i3, int i16) {
        sScreenWidthPixels = i3;
        sScreenHeightPixels = i16;
        sScreenRealWidthPixels = i3;
        sScreenRealHeightPixels = i16;
    }
}
