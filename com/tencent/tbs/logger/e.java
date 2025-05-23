package com.tencent.tbs.logger;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.tbs.logger.file.FilePrinter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private static b f374487b;

    /* renamed from: c, reason: collision with root package name */
    private static List<d> f374488c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f374489d;

    /* renamed from: a, reason: collision with root package name */
    private static volatile Boolean f374486a = Boolean.FALSE;

    /* renamed from: e, reason: collision with root package name */
    private static LogLevel f374490e = LogLevel.ALL;

    /* renamed from: f, reason: collision with root package name */
    private static String f374491f = "";

    /* renamed from: g, reason: collision with root package name */
    private static String f374492g = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f374493a;

        private void e(LogLevel logLevel, String str, String str2) {
            try {
                if (!e.a() || logLevel.getValue() < e.f374490e.getValue()) {
                    return;
                }
                c cVar = new c(System.currentTimeMillis(), logLevel, str, str2);
                if (e.f374489d) {
                    Iterator it = e.f374488c.iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).a(cVar);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(String str) {
            this.f374493a = str;
        }

        public void b(String str) {
            e(LogLevel.ERROR, this.f374493a, str);
        }

        public void c(String str) {
            e(LogLevel.INFO, this.f374493a, str);
        }

        public void d(int i3, String str) {
            e(LogLevel.valueOf(i3), this.f374493a, str);
        }

        b() {
            this.f374493a = getClass().getName();
        }
    }

    static /* synthetic */ boolean a() {
        return e();
    }

    private static boolean e() {
        if (!f374486a.booleanValue()) {
            new Throwable("TBSLogger has not been initialized, please call TBSLogger.initialize() first.").printStackTrace();
        }
        return f374486a.booleanValue();
    }

    public static d f(Context context, long j3, long j16) {
        return new FilePrinter(context, true, true, new pe4.a(), new oe4.b(j3), new ne4.b(j16));
    }

    public static void g(String str, String str2) {
        if (e()) {
            f374487b.f(str);
            f374487b.b(str2);
        }
    }

    public static String h() {
        return f374491f;
    }

    public static void i(String str, String str2) {
        if (e()) {
            f374487b.f(str);
            f374487b.c(str2);
        }
    }

    public static void j(Context context, String str, long j3, long j16) {
        k(context, str, j3, j16, false);
    }

    public static void k(Context context, String str, long j3, long j16, boolean z16) {
        try {
            if (!f374486a.booleanValue()) {
                File file = null;
                f374487b = new b();
                ArrayList arrayList = new ArrayList();
                f374488c = arrayList;
                arrayList.add(f(context.getApplicationContext(), j3, j16));
                if (z16) {
                    f374488c.add(new com.tencent.tbs.logger.a());
                }
                if (TextUtils.isEmpty(f374492g)) {
                    if ("mounted".equals(Environment.getExternalStorageState())) {
                        file = context.getExternalFilesDir(str);
                    }
                    if (file != null) {
                        f374491f = file.getAbsolutePath();
                    } else {
                        f374491f = context.getFilesDir() + File.separator + str;
                    }
                } else {
                    f374491f = f374492g;
                }
                f374490e = LogLevel.ALL;
                f374489d = true;
                f374486a = Boolean.TRUE;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void l(int i3, String str, String str2) {
        if (e()) {
            f374487b.f(str);
            f374487b.d(i3, str2);
        }
    }

    public static void m(String str) {
        f374492g = str;
    }
}
