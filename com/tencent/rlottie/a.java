package com.tencent.rlottie;

import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static Context f365183a;

    /* renamed from: b, reason: collision with root package name */
    static float f365184b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f365185c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static b f365186d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private static d f365187e;

    /* compiled from: P */
    /* renamed from: com.tencent.rlottie.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C9743a {
        static IPatchRedirector $redirector_;

        public static AXrLottieDrawable a(Context context, File file, int i3, int i16, boolean z16, boolean z17) {
            return AXrLottieDrawable.U(context, file).i(i3, i16).f(z16).h(z17).b();
        }

        public static AXrLottieDrawable b(Context context, String str, int i3, int i16, boolean z16, boolean z17) {
            return a(context, new File(str), i3, i16, z16, z17);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12989);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f365184b = 60.0f;
        f365185c = false;
        f365187e = null;
    }

    @Nullable
    public static d a() {
        return f365187e;
    }

    @NonNull
    public static b b(Context context) {
        b bVar = f365186d;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = f365186d;
                if (bVar == null) {
                    if (context == null) {
                        context = f365183a;
                    }
                    bVar = new b(context);
                    f365186d = bVar;
                }
            }
        }
        return bVar;
    }

    public static float c() {
        return f365184b;
    }

    public static synchronized boolean d(Context context) {
        boolean z16;
        synchronized (a.class) {
            f365183a = context.getApplicationContext();
            e(context);
            try {
                if (!f365185c) {
                    System.loadLibrary("jlottie");
                }
                f365185c = true;
            } catch (Throwable th5) {
                f365185c = false;
                Log.e("AXrLottie", "load so fail", th5);
            }
            z16 = f365185c;
        }
        return z16;
    }

    public static void e(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            f365184b = defaultDisplay.getRefreshRate();
        }
    }
}
