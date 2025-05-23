package com.huawei.hms.videokit.hdrability.util;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BrightnessUtil {

    /* renamed from: a, reason: collision with root package name */
    private static ContentObserver f37727a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Context f37728b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f37729c = false;

    /* renamed from: d, reason: collision with root package name */
    private static int f37730d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static int f37731e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f37732f = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            super.onChange(z16);
            int unused = BrightnessUtil.f37730d = BrightnessUtil.a();
        }
    }

    BrightnessUtil() {
    }

    static /* synthetic */ int a() {
        return c();
    }

    public static int b() {
        return f37730d;
    }

    private static int c() {
        Context context = f37728b;
        if (context == null) {
            Log.w("BrightnessUtil", "context invalid");
            return -1;
        }
        return Settings.System.getInt(context.getContentResolver(), "screen_brightness_nit", -1);
    }

    private static boolean d() {
        boolean isScreenHdr;
        if (f37728b != null && Build.VERSION.SDK_INT >= 26) {
            isScreenHdr = f37728b.getResources().getConfiguration().isScreenHdr();
            return isScreenHdr;
        }
        return false;
    }

    public static int e() {
        Log.i("BrightnessUtil", "observerScreenBrightness context:" + f37728b);
        if (f37728b == null) {
            Log.w("BrightnessUtil", "context invalid");
            return 3;
        }
        if (f37727a != null) {
            Log.w("BrightnessUtil", "screen brightness observer has register");
            return 2;
        }
        int c16 = c();
        f37730d = c16;
        if (c16 == -1) {
            Log.w("BrightnessUtil", "get screen brightness not support");
            return 1;
        }
        f37727a = new a(new Handler(Looper.getMainLooper()));
        f37728b.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness_nit"), false, f37727a);
        return 0;
    }

    public static int f() {
        Log.i("BrightnessUtil", "unObserverScreenBrightness");
        Context context = f37728b;
        if (context == null) {
            Log.w("BrightnessUtil", "context invalid");
            return 3;
        }
        if (f37727a == null) {
            Log.w("BrightnessUtil", "screen brightness observer has not register");
            return 2;
        }
        context.getContentResolver().unregisterContentObserver(f37727a);
        f37730d = -1;
        f37727a = null;
        return 0;
    }

    public static int getBrightness() {
        com.huawei.hms.videokit.hdrability.a a16 = com.huawei.hms.videokit.hdrability.util.a.a();
        int i3 = f37730d;
        if (i3 != -1) {
            return i3;
        }
        if (!a16.c() && !f37729c) {
            int i16 = f37731e;
            if (i16 != -1) {
                return i16;
            }
            return 203;
        }
        return 750;
    }

    public static int getUserBrightness() {
        return f37731e;
    }

    public static void init() {
        f37729c = d();
        if (f37732f) {
            e();
        }
        Log.i("BrightnessUtil", "init IsScreenHdr:" + f37729c);
    }

    public static void release() {
        Log.i("BrightnessUtil", "release");
        if (f37728b == null) {
            Log.w("BrightnessUtil", "release failed, context is null");
        } else {
            f37729c = false;
            f();
        }
    }

    public static int b(int i3) {
        Log.d("BrightnessUtil", "setUserBrightness: " + i3);
        if (i3 < 203 || i3 > 10000) {
            Log.e("BrightnessUtil", "setBrightness brightness is illegal");
            return 3;
        }
        f37731e = i3;
        return 0;
    }

    public static void a(Context context) {
        Log.i("BrightnessUtil", "setContext " + context);
        f37728b = context;
    }
}
