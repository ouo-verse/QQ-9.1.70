package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes5.dex */
public class UIUtils {

    /* renamed from: a, reason: collision with root package name */
    public static int f94438a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static int f94439b = -1;

    /* renamed from: e, reason: collision with root package name */
    public static Drawable f94442e;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, Bitmap> f94440c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<String, int[]> f94441d = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f94443f = new a();

    /* renamed from: g, reason: collision with root package name */
    private static Long f94444g = 0L;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements DownloadParams.DecodeHandler {
        a() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    return UIUtils.h(bitmap, iArr[2], iArr[0], iArr[1]);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        QQProgressDialog f94450a;

        b(QQProgressDialog qQProgressDialog) {
            this.f94450a = qQProgressDialog;
        }

        public void a() {
            QQProgressDialog qQProgressDialog = this.f94450a;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f94450a.dismiss();
            }
        }
    }

    public static int a(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        if (i17 > i16 || i18 > i3) {
            int i26 = i17 / 2;
            int i27 = i18 / 2;
            while (i26 / i19 > i16 && i27 / i19 > i3) {
                i19 *= 2;
            }
        }
        return i19;
    }

    public static int b(Context context, float f16) {
        return (int) ((f16 * g(context)) + 0.5f);
    }

    public static void c(final View view, final int i3, final int i16, final int i17, final int i18) {
        if (view.isEnabled() && view.getVisibility() == 0) {
            Rect rect = new Rect();
            view.setEnabled(true);
            view.getHitRect(rect);
            int i19 = rect.top;
            if (i19 == 0 && rect.bottom == 0 && rect.left == 0 && rect.right == 0) {
                ((View) view.getParent()).post(new Runnable() { // from class: com.tencent.biz.qqstory.utils.UIUtils.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Rect rect2 = new Rect();
                        view.setEnabled(true);
                        view.getHitRect(rect2);
                        rect2.top -= i3;
                        rect2.bottom += i16;
                        rect2.left -= i17;
                        rect2.right += i18;
                        TouchDelegate touchDelegate = new TouchDelegate(rect2, view);
                        if (View.class.isInstance(view.getParent())) {
                            ((View) view.getParent()).setTouchDelegate(touchDelegate);
                        }
                    }
                });
                return;
            }
            rect.top = i19 - i3;
            rect.bottom += i16;
            rect.left -= i17;
            rect.right += i18;
            TouchDelegate touchDelegate = new TouchDelegate(rect, view);
            if (View.class.isInstance(view.getParent())) {
                ((View) view.getParent()).setTouchDelegate(touchDelegate);
                return;
            }
            return;
        }
        if (View.class.isInstance(view.getParent())) {
            ((View) view.getParent()).setTouchDelegate(null);
        }
    }

    public static String d(long j3) {
        double d16 = j3;
        if (d16 > 1.0E9d) {
            return "10\u4ebf+";
        }
        if (d16 > 1.0E8d) {
            String str = ((j3 / 10000000) / 10.0d) + HardCodeUtil.qqStr(R.string.utb);
            if (str.endsWith(".0\u4ebf")) {
                return str.replace(".0", "");
            }
            return str;
        }
        if (j3 > 10000) {
            String str2 = ((j3 / 1000) / 10.0d) + HardCodeUtil.qqStr(R.string.utc);
            if (str2.endsWith(".0\u4e07")) {
                return str2.replace(".0", "");
            }
            return str2;
        }
        return String.valueOf(j3);
    }

    public static Bitmap e(Bitmap bitmap, float f16, float f17) {
        Matrix matrix = new Matrix();
        matrix.postScale(f16, f17);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e16) {
            hd0.c.g("Q.qqstory.UIViewUtils", "generateScaleBitmap error:" + e16);
            return null;
        }
    }

    public static Bitmap f(Resources resources, int i3, int i16, int i17) {
        if (resources == null || i3 <= 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i18 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(resources, i3, options);
            if (i16 > 0 || i17 > 0) {
                i18 = a(options, i16, i17);
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = i18;
            return BitmapFactory.decodeResource(resources, i3, options);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static float g(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static Bitmap h(Bitmap bitmap, float f16, int i3, int i16) {
        int i17;
        int i18;
        if (bitmap == null) {
            return null;
        }
        try {
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            float f17 = i16 / i3;
            int i19 = (int) height;
            int i26 = (int) width;
            if (height / width > f17) {
                i19 = (int) (width * f17);
                i18 = (int) ((height - i19) / 2.0f);
                i17 = 0;
            } else {
                i26 = (int) (height / f17);
                i17 = (int) ((width - i26) / 2.0f);
                i18 = 0;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            createBitmap.setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(i17, i18, i26 + i17, i19 + i18);
            Rect rect2 = new Rect(0, 0, i3, i16);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static int i(Context context) {
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(context);
        if (Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI)) {
            if (DeviceInfoMonitor.getModel().contains("MIX 2S") || DeviceInfoMonitor.getModel().contains("MI 8") || DeviceInfoMonitor.getModel().contains("MIX 2")) {
                boolean z16 = false;
                if (Settings.Global.getInt(BaseApplication.getContext().getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                    z16 = true;
                }
                if (z16) {
                    hd0.c.a("Q.qqstory.UIViewUtils", "find global screen in Xiaomi");
                    return ScreenUtil.getRealHeight(BaseApplication.getContext());
                }
                return instantScreenHeight;
            }
            return instantScreenHeight;
        }
        return instantScreenHeight;
    }

    public static int j(Context context) {
        int instantScreenWidth = ScreenUtil.getInstantScreenWidth(context);
        if (Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI)) {
            boolean z16 = false;
            if (Settings.Global.getInt(BaseApplication.getContext().getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                z16 = true;
            }
            if (z16) {
                hd0.c.a("Q.qqstory.UIViewUtils", "find global screen in Xiaomi");
                return ScreenUtil.getRealWidth(BaseApplication.getContext());
            }
            return instantScreenWidth;
        }
        return instantScreenWidth;
    }

    public static String k(int i3) {
        StringBuilder sb5 = gd0.b.f401934a.get();
        sb5.setLength(0);
        try {
            StackTraceElement[] stackTrace = new RuntimeException("getStackTrace").getStackTrace();
            for (int i16 = 2; i16 < stackTrace.length && i16 < i3; i16++) {
                sb5.append(stackTrace[i16]);
            }
            String sb6 = sb5.toString();
            sb5.setLength(0);
            return sb6;
        } catch (Exception e16) {
            AssertUtils.fail("getStackTrace" + e16.toString(), new Object[0]);
            return "{can not get stack}";
        }
    }

    public static int l(Context context) {
        int i3 = f94439b;
        if (i3 > 0) {
            return i3;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int i16 = point.y;
        f94439b = i16;
        return i16;
    }

    public static int m(Context context) {
        int i3 = f94438a;
        if (i3 > 0) {
            return i3;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int i16 = point.x;
        f94438a = i16;
        return i16;
    }

    public static boolean n() {
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = currentTimeMillis - f94444g.longValue();
        if (longValue > 0 && longValue < 800) {
            if (QLog.isColorLevel()) {
                QLog.i("isFastDoubleClick", 2, "time:" + currentTimeMillis + ", mLastClickTIme:" + f94444g + ", timeDiff:" + longValue);
            }
            return true;
        }
        f94444g = Long.valueOf(currentTimeMillis);
        return false;
    }

    public static float o(Context context, float f16) {
        return (f16 / g(context)) + 0.5f;
    }

    public static Bitmap p(Bitmap bitmap, float f16) {
        if (bitmap == null) {
            hd0.c.g("Q.qqstory.UIViewUtils", "rotateBitmap arg source is null! " + pd0.a.a(3));
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(f16);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void q(ImageView imageView, String str, int i3, int i16, int i17, Drawable drawable, String str2) {
        r(imageView, str, i3, i16, i17, drawable, str2, true);
    }

    public static void r(ImageView imageView, String str, int i3, int i16, int i17, Drawable drawable, String str2, boolean z16) {
        s(imageView, str, i3, i16, i17, drawable, str2, z16, null);
    }

    public static void s(ImageView imageView, String str, int i3, int i16, int i17, Drawable drawable, String str2, boolean z16, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (uRLDrawableOptions == null) {
            uRLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        }
        if (drawable == null) {
            drawable = imageView.getResources().getDrawable(R.drawable.al6);
        }
        if (TextUtils.isEmpty(str)) {
            if (z16) {
                imageView.setImageDrawable(drawable);
                return;
            } else {
                imageView.setBackground(drawable);
                return;
            }
        }
        try {
            new URL(str);
            uRLDrawableOptions.mLoadingDrawable = drawable;
            uRLDrawableOptions.mFailedDrawable = drawable;
            uRLDrawableOptions.mUseAutoScaleParams = false;
            if (!TextUtils.isEmpty(str2)) {
                uRLDrawableOptions.mMemoryCacheKeySuffix = str2;
            }
            URLDrawable drawable2 = URLDrawable.getDrawable(str, uRLDrawableOptions);
            drawable2.setTag(com.tencent.mobileqq.urldrawable.a.c(i3, i16, i17));
            drawable2.setDecodeHandler(f94443f);
            if (drawable2.getStatus() != 2 && drawable2.getStatus() != 3) {
                drawable2.startDownload();
            } else {
                gd0.a.c("Q.qqstory.UIViewUtils", "drawable restartDownload");
                drawable2.restartDownload();
            }
            if (z16) {
                imageView.setImageDrawable(drawable2);
            } else {
                imageView.setBackground(drawable2);
            }
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            gd0.a.b("Q.qqstory.UIViewUtils", e16.getMessage());
            if (z16) {
                imageView.setImageDrawable(drawable);
            } else {
                imageView.setBackground(drawable);
            }
        }
    }

    public static void t(ImageView imageView, String str, int i3, int i16, Drawable drawable, String str2) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (drawable == null) {
            drawable = imageView.getResources().getDrawable(R.drawable.j5h);
        }
        if (TextUtils.isEmpty(str)) {
            imageView.setImageDrawable(drawable);
            return;
        }
        try {
            URL url = new URL(str);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            obtain.mUseAutoScaleParams = false;
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
            if (!TextUtils.isEmpty(str2)) {
                obtain.mMemoryCacheKeySuffix = str2;
            }
            URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
            if (drawable2.getStatus() == 2 || drawable2.getStatus() == 3) {
                gd0.a.c("Q.qqstory.UIViewUtils", "drawable restartDownload");
                drawable2.restartDownload();
            }
            imageView.setImageDrawable(drawable2);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            gd0.a.b("Q.qqstory.UIViewUtils", e16.getMessage());
            imageView.setImageDrawable(drawable);
        }
    }

    public static b u(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            str = HardCodeUtil.qqStr(R.string.utd);
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(activity);
        qQProgressDialog.setMessage(str);
        qQProgressDialog.show();
        return new b(qQProgressDialog);
    }

    public static boolean v() {
        try {
            return TrimNative.isGetThumbnailReady();
        } catch (Throwable th5) {
            hd0.c.h("Q.qqstory.UIViewUtils", "trimNativeIsReady is failed! e=%s", th5);
            return false;
        }
    }

    public static String w(String str, String str2) {
        if (str == null) {
            return str;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (-1 == indexOf) {
            return str;
        }
        int i3 = indexOf + 1;
        Map<String, String> arguments = URLUtil.getArguments(str.substring(i3));
        if (arguments.remove(str2) == null) {
            return str;
        }
        int i16 = 0;
        String substring = str.substring(0, i3);
        for (String str3 : arguments.keySet()) {
            substring = substring + Typography.amp + URLUtil.encodeUrl(str3) + '=' + URLUtil.encodeUrl(arguments.get(str3));
            if (i16 == 0) {
                substring = substring.replace(ContainerUtils.FIELD_DELIMITER, "");
            }
            i16++;
        }
        return substring;
    }
}
