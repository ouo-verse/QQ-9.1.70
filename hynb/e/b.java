package hynb.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import com.huya.huyasdk.api.HuyaSdk;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import hynb.p.e;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b implements e {

    /* renamed from: c, reason: collision with root package name */
    public static String f406697c = "";

    /* renamed from: e, reason: collision with root package name */
    public static final HandlerThread f406699e;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f406700a = new Handler(f406699e.getLooper());

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f406696b = {72, 89, 83, 68, 75, 120, 69, 78, 67, 82, 89, 80, 84, 75, 69, 89};

    /* renamed from: d, reason: collision with root package name */
    public static final SimpleDateFormat f406698d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HuyaSDK-loggerHandlerThread");
        f406699e = baseHandlerThread;
        baseHandlerThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Object obj, String str, String str2) {
        HuyaSdk.getLogger().info(obj, c(str + str2));
    }

    @Override // hynb.p.e
    public void debug(final Object obj, final String str) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.g
            @Override // java.lang.Runnable
            public final void run() {
                HuyaSdk.getLogger().debug(obj, b16 + str);
            }
        });
    }

    @Override // hynb.p.e
    public void error(final Object obj, final String str) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.d
            @Override // java.lang.Runnable
            public final void run() {
                HuyaSdk.getLogger().error(obj, b16 + str);
            }
        });
    }

    @Override // hynb.p.e
    public void info(final Object obj, final String str) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.k
            @Override // java.lang.Runnable
            public final void run() {
                HuyaSdk.getLogger().info(obj, b16 + str);
            }
        });
    }

    public static String a() {
        if (f406697c.isEmpty()) {
            f406697c = new String(f406696b, StandardCharsets.UTF_8);
        }
        return f406697c;
    }

    @Override // hynb.p.e
    public void c(final Object obj, final String str, final Object... objArr) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.c
            @Override // java.lang.Runnable
            public final void run() {
                hynb.e.b.this.c(obj, b16, str, objArr);
            }
        });
    }

    @Override // hynb.p.e
    public void b(final Object obj, final String str, final Object... objArr) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.j
            @Override // java.lang.Runnable
            public final void run() {
                HuyaSdk.getLogger().error(obj, b16 + String.format(str, objArr));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Object obj, String str, String str2, Object[] objArr) {
        HuyaSdk.getLogger().info(obj, c(str + String.format(str2, objArr)));
    }

    @Override // hynb.p.e
    public void a(final Object obj, final String str, final Object... objArr) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.f
            @Override // java.lang.Runnable
            public final void run() {
                HuyaSdk.getLogger().info(obj, b16 + String.format(str, objArr));
            }
        });
    }

    public final String c(String str) {
        byte[] b16 = hynb.q.a.b(null, a(), str.getBytes(StandardCharsets.UTF_8));
        if (b16 == null) {
            return str;
        }
        return "HuyaEncrypted:" + hynb.o.a.b(b16);
    }

    @Override // hynb.p.e
    public void b(final String str) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.e
            @Override // java.lang.Runnable
            public final void run() {
                hynb.e.b.this.b(b16, str);
            }
        });
    }

    @Override // hynb.p.e
    public void a(final String str) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.b
            @Override // java.lang.Runnable
            public final void run() {
                HuyaSdk.getLogger().error("HuyaMtpLoggerDelegate", b16 + str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, String str2) {
        HuyaSdk.getLogger().info("HuyaMtpLoggerDelegate", c(str + str2));
    }

    public final String b() {
        return String.format("[time: %s, tId: %s]", f406698d.format(new Date(System.currentTimeMillis())), Integer.valueOf(Process.myTid()));
    }

    @Override // hynb.p.e
    public void a(final Object obj, final String str, final Throwable th5) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.h
            @Override // java.lang.Runnable
            public final void run() {
                HuyaSdk.getLogger().error(obj, b16 + str + "crash: " + Log.getStackTraceString(th5));
            }
        });
    }

    @Override // hynb.p.e
    public void a(final Object obj, final Throwable th5) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.a
            @Override // java.lang.Runnable
            public final void run() {
                HuyaSdk.getLogger().error(obj, b16 + Log.getStackTraceString(th5));
            }
        });
    }

    @Override // hynb.p.e
    public void a(final Object obj, final String str) {
        final String b16 = b();
        this.f406700a.post(new Runnable() { // from class: r15.i
            @Override // java.lang.Runnable
            public final void run() {
                hynb.e.b.this.d(obj, b16, str);
            }
        });
    }
}
