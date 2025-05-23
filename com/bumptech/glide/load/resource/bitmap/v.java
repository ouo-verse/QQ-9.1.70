package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f31853g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f31854h;

    /* renamed from: i, reason: collision with root package name */
    private static final File f31855i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile v f31856j;

    /* renamed from: k, reason: collision with root package name */
    private static volatile int f31857k;

    /* renamed from: b, reason: collision with root package name */
    private final int f31859b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31860c;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private int f31861d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f31862e = true;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f31863f = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f31858a = f();

    static {
        boolean z16;
        int i3 = Build.VERSION.SDK_INT;
        boolean z17 = true;
        if (i3 < 29) {
            z16 = true;
        } else {
            z16 = false;
        }
        f31853g = z16;
        if (i3 < 26) {
            z17 = false;
        }
        f31854h = z17;
        f31855i = new File("/proc/self/fd");
        f31857k = -1;
    }

    @VisibleForTesting
    v() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f31859b = 20000;
            this.f31860c = 0;
        } else {
            this.f31859b = 700;
            this.f31860c = 128;
        }
    }

    private boolean a() {
        if (f31853g && !this.f31863f.get()) {
            return true;
        }
        return false;
    }

    public static v b() {
        if (f31856j == null) {
            synchronized (v.class) {
                if (f31856j == null) {
                    f31856j = new v();
                }
            }
        }
        return f31856j;
    }

    private int c() {
        if (f31857k != -1) {
            return f31857k;
        }
        return this.f31859b;
    }

    private synchronized boolean d() {
        boolean z16 = true;
        int i3 = this.f31861d + 1;
        this.f31861d = i3;
        if (i3 >= 50) {
            this.f31861d = 0;
            int length = f31855i.list().length;
            long c16 = c();
            if (length >= c16) {
                z16 = false;
            }
            this.f31862e = z16;
            if (!z16 && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + c16);
            }
        }
        return this.f31862e;
    }

    private static boolean f() {
        if (!g() && !h()) {
            return true;
        }
        return false;
    }

    private static boolean g() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        Iterator it = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
        while (it.hasNext()) {
            if (DeviceInfoMonitor.getModel().startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean h() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(DeviceInfoMonitor.getModel());
    }

    public boolean e(int i3, int i16, boolean z16, boolean z17) {
        if (!z16) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!this.f31858a) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        }
        if (!f31854h) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z17) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        int i17 = this.f31860c;
        if (i3 < i17) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
            }
            return false;
        }
        if (i16 < i17) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
            }
            return false;
        }
        if (!d()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean i(int i3, int i16, BitmapFactory.Options options, boolean z16, boolean z17) {
        Bitmap.Config config;
        boolean e16 = e(i3, i16, z16, z17);
        if (e16) {
            config = Bitmap.Config.HARDWARE;
            options.inPreferredConfig = config;
            options.inMutable = false;
        }
        return e16;
    }
}
