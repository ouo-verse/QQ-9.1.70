package c.t.m.g;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes.dex */
public class c1 {
    public static final boolean a() {
        return a0.c() || a0.b() != null;
    }

    public static void b(String str, String str2) {
        a(6, str, str2, (Throwable) null);
    }

    public static void c(String str, String str2) {
        a(1006, str, str2);
    }

    public static void a(String str, String str2) {
        a(3, str, str2, (Throwable) null);
    }

    public static void a(String str, String str2, Throwable th5) {
        try {
            a(6, str, str2, th5);
        } catch (Throwable th6) {
            if ((th6 instanceof OutOfMemoryError) || !a()) {
                return;
            }
            a("LogUtil", "", th6);
        }
    }

    public static void a(int i3, String str, String str2, Throwable th5) {
        a(str, i3, str2, th5);
        if (a0.b() != null) {
            a0.b().a(i3, str, str2, th5);
        }
    }

    public static void a(String str, int i3, String str2, Throwable th5) {
        if (a0.c()) {
            if (th5 != null) {
                str2 = str2 + ". exception: " + Log.getStackTraceString(th5);
            }
            Log.println(i3, str, str2);
        }
    }

    public static String a(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        for (Throwable th6 = th5; th6 != null; th6 = th6.getCause()) {
            if (th6 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th5.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void a(int i3, String str, String str2) {
        a(str, 3, str2, (Throwable) null);
        if (a0.a() != null) {
            a0.a().a(i3, str, str2);
        }
    }
}
