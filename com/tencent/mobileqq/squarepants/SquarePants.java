package com.tencent.mobileqq.squarepants;

import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* loaded from: classes18.dex */
public class SquarePants {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f289651a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f289652b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<byte[]> f289653c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13490);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f289653c = new ArrayList<>();
        ShadowHook.c(new ShadowHook.b().c(ShadowHook.Mode.SHARED).b(false).d(false).a());
        try {
            System.loadLibrary("squarepants");
            f289651a = true;
        } catch (UnsatisfiedLinkError e16) {
            c.c("SquarePants", e16);
        }
    }

    public SquarePants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int a() {
        if (!f289651a) {
            c.b("SquarePants", "init failed");
            return -100;
        }
        int nativeHook = nativeHook(Build.VERSION.SDK_INT);
        c.a("SquarePants", "hook result: " + nativeHook);
        return nativeHook;
    }

    private static void b() {
        if (!f289652b) {
            f289652b = nativeInitArtHeapHook();
            Runtime.getRuntime().totalMemory();
        }
    }

    private static void c() {
        if (!hasLOSHandle()) {
            f289653c.add(new byte[12288]);
            f289653c.clear();
        }
    }

    public static int d(long j3) {
        if (j3 < 4096) {
            return -200;
        }
        if (!f289651a) {
            c.b("SquarePants", "init failed");
            return -100;
        }
        b();
        c();
        return nativeSetLargeObjectThreshold(j3, Build.VERSION.SDK_INT);
    }

    public static native long getLOSAllocated();

    public static native long getNonDetachedLOS();

    private static native boolean hasLOSHandle();

    private static native int nativeFreezeBackgroundGC(int i3, int i16);

    private static native int nativeGCClearSoftRef(int i3);

    private static native int nativeHook(int i3);

    private static native int nativeHookBackgroundGC(int i3);

    private static native boolean nativeInitArtHeapHook();

    private static native int nativeSetLargeObjectThreshold(long j3, int i3);

    public static native int stopFreezeBackgroundGC();

    public static native void unfreezeCurBackgroundGC();
}
