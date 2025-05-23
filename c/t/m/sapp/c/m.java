package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* compiled from: P */
/* loaded from: classes.dex */
public class m implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final String f30180a = TencentLocation.class.getPackage().getName();

    /* renamed from: b, reason: collision with root package name */
    public static m f30181b = null;

    /* renamed from: c, reason: collision with root package name */
    public Context f30182c;

    /* renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f30183d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f30184e = false;

    public m(Context context) {
        this.f30182c = context;
    }

    public static m a(Context context) {
        if (f30181b == null) {
            synchronized (m.class) {
                if (f30181b == null) {
                    f30181b = new m(context);
                }
            }
        }
        return f30181b;
    }

    public final String b(Throwable th5) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th5.printStackTrace(printWriter);
            for (Throwable cause = th5.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            stringBuffer.append(stringWriter.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        if (a(th5) && this.f30182c != null) {
            String b16 = b(th5);
            if (!b16.contains("onLocationChanged") && !b16.contains("onStatusUpdate")) {
                q.d(this.f30182c, "__bad_dex_info___sapp", q.f30191d);
                q.b(this.f30182c, "__loc_sdk_run_duration___sapp", Long.valueOf(System.currentTimeMillis() - q.f30192e));
                String str = "EXP:" + q.f30191d + "," + b16;
                if (str.contains("\n")) {
                    str = str.replaceAll("\n", "\\$");
                }
                i.a(str);
                TencentLocationManager.getInstance(this.f30182c).removeUpdates(null);
                return;
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f30183d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th5);
        }
    }

    public final boolean a(Throwable th5) {
        if (th5 == null) {
            return false;
        }
        while (th5 != null) {
            for (StackTraceElement stackTraceElement : th5.getStackTrace()) {
                if ("TLSAPP".equals(stackTraceElement.getFileName())) {
                    return true;
                }
            }
            th5 = th5.getCause();
        }
        return false;
    }

    public void a() {
        if (this.f30184e) {
            return;
        }
        this.f30183d = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(f30181b);
        this.f30184e = true;
    }
}
