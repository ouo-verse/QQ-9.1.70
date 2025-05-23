package com.tencent.matrix.hook.memory;

import android.os.Handler;
import android.os.HandlerThread;
import g51.b;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class GCSemiSpaceTrimmer {

    /* renamed from: h, reason: collision with root package name */
    public static final GCSemiSpaceTrimmer f151458h = new GCSemiSpaceTrimmer();

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f151459i = Pattern.compile("[^0-9]");

    /* renamed from: j, reason: collision with root package name */
    private static final long f151460j = TimeUnit.MINUTES.toMillis(3);

    /* renamed from: a, reason: collision with root package name */
    private float f151461a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    private long f151462b = f151460j;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f151463c = null;

    /* renamed from: d, reason: collision with root package name */
    private Handler f151464d = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f151465e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f151466f = false;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f151467g = new Runnable() { // from class: com.tencent.matrix.hook.memory.GCSemiSpaceTrimmer.1
        @Override // java.lang.Runnable
        public void run() {
            long a16 = GCSemiSpaceTrimmer.a();
            if (a16 < 0) {
                b.b("Matrix.GCSemiSpaceTrimmer", "Fail to read vss size, skip checking this time.", new Object[0]);
                GCSemiSpaceTrimmer.this.f151464d.postDelayed(this, GCSemiSpaceTrimmer.this.f151462b);
            } else {
                if (((float) a16) > GCSemiSpaceTrimmer.this.f151461a * 4.2949673E9f) {
                    b.c("Matrix.GCSemiSpaceTrimmer", "VmSize usage reaches above critical level, trigger native install. vmsize: %s, critical_ratio: %s", Long.valueOf(a16), Float.valueOf(GCSemiSpaceTrimmer.this.f151461a));
                    if (GCSemiSpaceTrimmer.this.nativeInstall()) {
                        b.c("Matrix.GCSemiSpaceTrimmer", "nativeInstall triggered successfully.", new Object[0]);
                        return;
                    } else {
                        b.c("Matrix.GCSemiSpaceTrimmer", "Fail to trigger nativeInstall.", new Object[0]);
                        return;
                    }
                }
                b.c("Matrix.GCSemiSpaceTrimmer", "VmSize usage is under critical level, check next time. vmsize: %s, critical_ratio: %s", Long.valueOf(a16), Float.valueOf(GCSemiSpaceTrimmer.this.f151461a));
                GCSemiSpaceTrimmer.this.f151464d.postDelayed(this, GCSemiSpaceTrimmer.this.f151462b);
            }
        }
    };

    GCSemiSpaceTrimmer() {
    }

    static /* synthetic */ long a() {
        return f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        r0 = java.lang.Long.parseLong(com.tencent.matrix.hook.memory.GCSemiSpaceTrimmer.f151459i.matcher(r3).replaceAll("").trim());
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        r0 = r0 * 1024;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long f() {
        long j3 = -1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/status")));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String lowerCase = readLine.toLowerCase();
                    if (lowerCase.contains("vmsize")) {
                        break;
                    }
                } finally {
                }
            }
            bufferedReader.close();
        } catch (Throwable th5) {
            b.d("Matrix.GCSemiSpaceTrimmer", th5, "read proc status failed.", new Object[0]);
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeInstall();

    private native boolean nativeIsCompatible();
}
