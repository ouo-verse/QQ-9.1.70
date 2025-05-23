package com.tencent.ams.mosaic.utils;

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
import android.graphics.Movie;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Vibrator;
import android.renderscript.Allocation;
import android.renderscript.BaseObj;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.facebook.soloader.SoLoader;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.mosaic.MosaicManager;
import com.tencent.ams.music.widget.SensorType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import common.config.service.QzoneConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MosaicUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f71542a;

    /* renamed from: b, reason: collision with root package name */
    private static final List<Runnable> f71543b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f71544c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f71545d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f71546e;

    /* renamed from: f, reason: collision with root package name */
    private static Boolean f71547f;

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f71548g;

    /* renamed from: h, reason: collision with root package name */
    private static Boolean f71549h;

    /* renamed from: i, reason: collision with root package name */
    private static Boolean f71550i;

    /* renamed from: j, reason: collision with root package name */
    private static Boolean f71551j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f71552k;

    /* renamed from: l, reason: collision with root package name */
    private static int f71553l;

    /* renamed from: m, reason: collision with root package name */
    private static int f71554m;

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f71555n;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59225);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f71542a = new Handler(Looper.getMainLooper());
        f71543b = new ArrayList();
        f71552k = false;
        f71555n = false;
    }

    public static boolean A() {
        Boolean bool = f71550i;
        if (bool != null) {
            return bool.booleanValue();
        }
        f71550i = Boolean.valueOf(y("com.airbnb.lottie.LottieAnimationView"));
        f.e("Utils", "isSupportLottie: " + f71550i);
        return f71550i.booleanValue();
    }

    public static boolean B() {
        Boolean bool = f71547f;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            f71547f = Boolean.valueOf(y("com.tencent.ams.music.widget.scratch.ScratchCard"));
            f.e("Utils", "tma widget library sensorType: " + f71547f);
        } catch (Throwable unused) {
            f.h("Utils", "not support TMA Widget");
            f71547f = Boolean.FALSE;
        }
        return f71547f.booleanValue();
    }

    public static boolean C() {
        Boolean bool = f71546e;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            f.e("Utils", "tma widget library sensorType: " + SensorType.MIX);
            f71546e = Boolean.TRUE;
        } catch (Throwable unused) {
            f.h("Utils", "not support TMA Widget");
            f71546e = Boolean.FALSE;
        }
        return f71546e.booleanValue();
    }

    public static boolean D() {
        Boolean bool = f71549h;
        if (bool != null) {
            return bool.booleanValue();
        }
        f71549h = Boolean.valueOf(y("com.facebook.yoga.YogaNode"));
        f.e("Utils", "isSupportYoga: " + f71549h);
        return f71549h.booleanValue();
    }

    public static float E(float f16) {
        float f17;
        Context i3 = MosaicManager.j().i();
        if (i3 != null) {
            f17 = i3.getResources().getDisplayMetrics().density;
        } else {
            f17 = Resources.getSystem().getDisplayMetrics().density;
        }
        if (com.tencent.ams.mosaic.f.k().p() != 0.0f && com.tencent.ams.mosaic.f.k().q() != 0.0f) {
            f17 = com.tencent.ams.mosaic.f.k().p() / com.tencent.ams.mosaic.f.k().q();
        }
        if (f17 == 0.0f) {
            return f16 / 2.0f;
        }
        return f16 / f17;
    }

    public static void F(Runnable runnable) {
        G(runnable, false);
    }

    public static void G(Runnable runnable, boolean z16) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread() && !z16) {
            runnable.run();
        } else {
            com.tencent.ams.mosaic.f.k().b().execute(runnable);
        }
    }

    public static void H(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!f71552k) {
            f71542a.postAtFrontOfQueue(runnable);
            return;
        }
        List<Runnable> list = f71543b;
        synchronized (list) {
            if (list.size() <= 0) {
                f71542a.postAtFrontOfQueue(runnable);
            } else if (f71544c) {
                list.add(0, runnable);
            } else {
                f71542a.postAtFrontOfQueue(runnable);
            }
        }
    }

    public static void I(Runnable runnable) {
        J(runnable, 0L);
    }

    public static void J(Runnable runnable, long j3) {
        if (runnable == null) {
            return;
        }
        if (j3 > 0) {
            f71542a.postDelayed(runnable, j3);
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            return;
        }
        if (f71552k) {
            List<Runnable> list = f71543b;
            synchronized (list) {
                list.add(runnable);
            }
            f71542a.post(new Runnable() { // from class: com.tencent.ams.mosaic.utils.MosaicUtils.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        boolean unused = MosaicUtils.f71544c = true;
                        synchronized (MosaicUtils.f71543b) {
                            if (MosaicUtils.f71543b.size() == 0) {
                                return;
                            }
                            ArrayList arrayList = new ArrayList(MosaicUtils.f71543b);
                            MosaicUtils.f71543b.clear();
                            boolean unused2 = MosaicUtils.f71544c = false;
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((Runnable) it.next()).run();
                            }
                            return;
                        }
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            });
            return;
        }
        f71542a.post(runnable);
    }

    private static void K(BaseObj baseObj) {
        if (baseObj != null) {
            try {
                baseObj.destroy();
            } catch (Throwable th5) {
                f.c("Utils", "destroy error.", th5);
            }
        }
    }

    private static void L(RenderScript renderScript) {
        if (renderScript != null) {
            try {
                renderScript.destroy();
            } catch (Throwable th5) {
                f.c("Utils", "destroy error.", th5);
            }
        }
    }

    public static int M(Map<String, ?> map, String str) {
        if (map == null) {
            return 0;
        }
        Object obj = map.get(str);
        if (obj instanceof Long) {
            return ((Long) obj).intValue();
        }
        if (!(obj instanceof Integer)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    public static String N(Map<String, ?> map, String str) {
        if (map == null) {
            return null;
        }
        Object obj = map.get(str);
        if (!(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    public static int O(String str) {
        return P(str, 0);
    }

    public static int P(String str, int i3) {
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            f.h("Utils", "safeParseColor '" + str + "' failed");
            return i3;
        }
    }

    public static void Q(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public static Bitmap R(Bitmap bitmap, int i3, int i16) {
        if (bitmap != null && ((bitmap.getWidth() != i3 || bitmap.getHeight() != i16) && i3 > 0 && i16 > 0)) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(i3 / width, i16 / height);
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Throwable th5) {
                f.h("Utils", "scaleBitmapSafe error." + th5.toString());
            }
        }
        return bitmap;
    }

    public static String S(int i3) {
        if (i3 < 1) {
            return QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT;
        }
        int i16 = i3 / 3600;
        int i17 = i3 % 3600;
        int i18 = i17 / 60;
        int i19 = i17 % 60;
        if (i16 == 0) {
            return String.format(Locale.CHINA, "%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i19));
        }
        return String.format(Locale.CHINA, "%02d:%02d:%02d", Integer.valueOf(i16), Integer.valueOf(i18), Integer.valueOf(i19));
    }

    public static String T(Context context, String str) {
        if (context != null && str != null) {
            try {
                return V(context.getResources().getAssets().open(str));
            } catch (Exception e16) {
                f.i("Utils", "stringFromAssets failed: " + str, e16);
            }
        }
        return null;
    }

    public static String U(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            try {
                return V(new FileInputStream(file));
            } catch (Throwable unused) {
                f.h("Utils", "stringFromFile failed: " + str);
            }
        }
        return null;
    }

    private static String V(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
            try {
                inputStream.close();
            } catch (Throwable unused2) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused3) {
            }
            return byteArrayOutputStream2;
        } catch (Throwable th6) {
            th = th6;
            try {
                f.i("Utils", "stringFromInputStream failed", th);
                try {
                    inputStream.close();
                } catch (Throwable unused4) {
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused5) {
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public static String W(String str, int i3) {
        return V(q(str, i3));
    }

    public static String X(byte[] bArr, String str) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            int i3 = b16 & 255;
            if (i3 < 16) {
                sb5.append("0");
                sb5.append(Integer.toHexString(i3));
                sb5.append(str);
            } else {
                sb5.append(Integer.toHexString(i3));
                sb5.append(str);
            }
        }
        return sb5.toString();
    }

    public static int Y(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th5) {
            f.c("Utils", "to integer error.", th5);
            return 0;
        }
    }

    public static String Z(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            return X(messageDigest.digest(), "");
        } catch (NoSuchAlgorithmException e16) {
            f.b("Utils", "Md5 encode failed! " + e16.getMessage());
            return null;
        }
    }

    public static void a0(Context context, int i3) {
        try {
            Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(i3);
            }
        } catch (Throwable th5) {
            f.c("Utils", "vibrate fail", th5);
        }
    }

    public static Bitmap c(Context context, String str) {
        InputStream inputStream;
        Bitmap bitmap = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            AssetManager assets = context.getAssets();
            try {
                if (assets != null) {
                    try {
                        inputStream = assets.open(str);
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                    }
                    try {
                        bitmap = BitmapFactory.decodeStream(inputStream);
                    } catch (Throwable th6) {
                        th = th6;
                        try {
                            f.i("Utils", "bitmapFromAssets error.", th);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bitmap;
                        } catch (Throwable th7) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            throw th7;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e17) {
                e17.printStackTrace();
            }
        }
        return bitmap;
    }

    public static Bitmap d(String str, float f16, float f17) {
        f.e("Utils", "bitmapFromBase64String width:" + f16 + ", height:" + f17);
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] decode = Base64.decode(str, 0);
                if (decode != null && decode.length > 0) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                    try {
                        if (decodeByteArray == null) {
                            f.h("Utils", "bitmapFromBase64StringSafe failed: decode byte array failed");
                            return null;
                        }
                        if (f16 > 0.0f && f17 > 0.0f) {
                            int width = decodeByteArray.getWidth();
                            int height = decodeByteArray.getHeight();
                            float f18 = width;
                            if (f18 != f16) {
                                float f19 = height;
                                if (f19 != f17) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(f16 / f18, f17 / f19);
                                    return Bitmap.createBitmap(decodeByteArray, 0, 0, width, height, matrix, true);
                                }
                                return decodeByteArray;
                            }
                            return decodeByteArray;
                        }
                        return decodeByteArray;
                    } catch (Throwable th5) {
                        th = th5;
                        bitmap = decodeByteArray;
                        f.h("Utils", "bitmapFromBase64String error." + th.toString());
                        return bitmap;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            f.h("Utils", "bitmapFromBase64StringSafe failed: empty base64str");
        }
        return bitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.renderscript.BaseObj, android.renderscript.ScriptIntrinsicBlur] */
    /* JADX WARN: Type inference failed for: r1v6 */
    @RequiresApi(api = 17)
    public static Bitmap e(Bitmap bitmap, float f16, Context context) {
        Allocation allocation;
        Allocation allocation2;
        Allocation allocation3;
        RenderScript renderScript = null;
        ?? r16 = 0;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            if (createBitmap == null) {
                K(null);
                K(null);
                K(null);
                L(null);
                return bitmap;
            }
            RenderScript create = RenderScript.create(context);
            try {
                allocation2 = Allocation.createFromBitmap(create, bitmap);
            } catch (Throwable th5) {
                th = th5;
                allocation2 = null;
                allocation3 = null;
            }
            try {
                allocation3 = Allocation.createTyped(create, allocation2.getType());
            } catch (Throwable th6) {
                th = th6;
                allocation3 = null;
                renderScript = create;
                allocation = allocation3;
                try {
                    f.h("Utils", "blur failed: " + th);
                    return bitmap;
                } finally {
                    K(allocation2);
                    K(allocation3);
                    K(allocation);
                    L(renderScript);
                }
            }
            try {
                r16 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                r16.setRadius(f16);
                r16.setInput(allocation2);
                r16.forEach(allocation3);
                allocation3.copyTo(createBitmap);
                f.a("Utils", "blur bitmap success, cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                K(allocation2);
                K(allocation3);
                K(r16);
                L(create);
                return createBitmap;
            } catch (Throwable th7) {
                th = th7;
                Allocation allocation4 = r16;
                renderScript = create;
                allocation = allocation4;
                f.h("Utils", "blur failed: " + th);
                return bitmap;
            }
        } catch (Throwable th8) {
            th = th8;
            allocation = null;
            allocation2 = null;
            allocation3 = null;
        }
    }

    private static byte[] f(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                inputStream.close();
            } catch (Throwable unused2) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused3) {
            }
            return byteArray;
        } catch (Throwable th6) {
            th = th6;
            try {
                f.i("Utils", "bytesFromInputStream failed", th);
                try {
                    inputStream.close();
                } catch (Throwable unused4) {
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused5) {
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public static byte[] g(String str, int i3) {
        return f(q(str, i3));
    }

    public static int h(int i3, int i16, float f16) {
        return Color.argb((int) (((((i16 >> 24) & 255) - r0) * f16) + ((i3 >> 24) & 255)), (int) (((((i16 >> 16) & 255) - r1) * f16) + ((i3 >> 16) & 255)), (int) (((((i16 >> 8) & 255) - r2) * f16) + ((i3 >> 8) & 255)), (int) ((((i16 & 255) - r6) * f16) + (i3 & 255)));
    }

    public static int i(String str, String str2) {
        int i3;
        int i16;
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty && isEmpty2) {
            return 0;
        }
        if (isEmpty) {
            return -1;
        }
        if (isEmpty2) {
            return 1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int max = Math.max(split.length, split2.length);
        for (int i17 = 0; i17 < max; i17++) {
            if (i17 < split.length) {
                i3 = Y(split[i17]);
            } else {
                i3 = 0;
            }
            if (i17 < split2.length) {
                i16 = Y(split2[i17]);
            } else {
                i16 = 0;
            }
            if (i3 > i16) {
                return 1;
            }
            if (i3 < i16) {
                return -1;
            }
        }
        return 0;
    }

    public static float j(float f16) {
        if (com.tencent.ams.mosaic.f.k().p() != 0.0f && com.tencent.ams.mosaic.f.k().q() != 0.0f) {
            return ((f16 * com.tencent.ams.mosaic.f.k().p()) / com.tencent.ams.mosaic.f.k().q()) + 0.5f;
        }
        if (MosaicManager.j().i() != null) {
            return (int) TypedValue.applyDimension(1, f16, r0.getResources().getDisplayMetrics());
        }
        return TypedValue.applyDimension(1, f16, Resources.getSystem().getDisplayMetrics());
    }

    public static Bitmap k(Drawable drawable, int i3, int i16) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static void l(Context context) {
        if (!f71555n && context != null) {
            SoLoader.g(context, false);
            f71555n = true;
        }
    }

    public static Activity m(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static float n(Context context, int i3) {
        return (p(context) * i3) / 750.0f;
    }

    public static float o(Context context) {
        if (context == null) {
            return 0.0f;
        }
        int i3 = f71554m;
        if (i3 != 0) {
            return i3;
        }
        try {
            f71554m = context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable unused) {
            f71554m = 0;
        }
        return f71554m;
    }

    public static float p(Context context) {
        if (context == null) {
            return 0.0f;
        }
        int i3 = f71553l;
        if (i3 != 0) {
            return i3;
        }
        try {
            f71553l = context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable unused) {
            f71553l = 0;
        }
        return f71553l;
    }

    private static InputStream q(String str, int i3) {
        f.e("Utils", "getStreamFromUrl :" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(i3);
            httpURLConnection.setReadTimeout(i3);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            return httpURLConnection.getInputStream();
        } catch (Exception e16) {
            f.i("Utils", "getStreamFromUrl failed", e16);
            return null;
        }
    }

    public static String r() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return System.currentTimeMillis() + "_" + Math.random();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0025, code lost:
    
        if (r3 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0027, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:
    
        if (r3 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.tencent.ams.mosaic.jsengine.component.image.b s(Context context, String str) {
        InputStream inputStream;
        if (context != null && !TextUtils.isEmpty(str)) {
            AssetManager assets = context.getAssets();
            if (assets != null) {
                try {
                    inputStream = assets.open(str);
                    try {
                        Movie decodeStream = Movie.decodeStream(inputStream);
                        if (decodeStream != null) {
                            com.tencent.ams.mosaic.jsengine.component.image.b bVar = new com.tencent.ams.mosaic.jsengine.component.image.b(str, decodeStream);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            return bVar;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    inputStream = null;
                }
            }
            f.h("Utils", "gifFromAssets failed: " + str);
        }
        return null;
    }

    public static boolean t(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean u(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean v(String str) {
        if (str != null && !"".equals(str)) {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        }
        return false;
    }

    public static boolean w() {
        if (f71548g == null) {
            try {
                f71548g = true;
            } catch (Throwable unused) {
                f71548g = Boolean.FALSE;
            }
        }
        return f71548g.booleanValue();
    }

    public static boolean x() {
        if (f71551j == null) {
            try {
                f71551j = true;
            } catch (Throwable unused) {
                f71551j = Boolean.FALSE;
            }
        }
        return f71551j.booleanValue();
    }

    public static boolean y(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean z() {
        Boolean bool = f71545d;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Logger.d("Utils", "support fusion widget sdk");
            f71545d = Boolean.TRUE;
        } catch (Throwable unused) {
            f71545d = Boolean.FALSE;
        }
        return f71545d.booleanValue();
    }
}
