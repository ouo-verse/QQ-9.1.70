package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mapsdk.internal.kq;
import com.tencent.mapsdk.internal.lb;
import com.tencent.raft.codegenmeta.utils.RLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LoggerConfig;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.File;
import java.io.FileFilter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class la extends kx {

    /* renamed from: g, reason: collision with root package name */
    private static File f149122g = null;

    /* renamed from: p, reason: collision with root package name */
    private static final int f149124p = -101;

    /* renamed from: q, reason: collision with root package name */
    private static final int f149125q = -102;

    /* renamed from: r, reason: collision with root package name */
    private static final int f149126r = -103;

    /* renamed from: c, reason: collision with root package name */
    public LoggerConfig.LogCallback f149128c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f149129d;

    /* renamed from: e, reason: collision with root package name */
    public TencentMapOptions f149130e;

    /* renamed from: h, reason: collision with root package name */
    private final Context f149131h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f149132i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f149133j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f149134k;

    /* renamed from: l, reason: collision with root package name */
    private int f149135l;

    /* renamed from: m, reason: collision with root package name */
    private String[] f149136m;

    /* renamed from: n, reason: collision with root package name */
    private final int f149137n;

    /* renamed from: o, reason: collision with root package name */
    private static final HandlerThread f149123o = new BaseHandlerThread("core-log-thread");

    /* renamed from: f, reason: collision with root package name */
    public static Handler f149121f = null;

    /* renamed from: s, reason: collision with root package name */
    private static final Handler.Callback f149127s = new Handler.Callback() { // from class: com.tencent.mapsdk.internal.la.3

        /* renamed from: a, reason: collision with root package name */
        public static final String f149140a = "LOG-";

        /* renamed from: b, reason: collision with root package name */
        public final SimpleDateFormat f149141b = new SimpleDateFormat("yyyy_MM_dd", Locale.CHINA);

        /* renamed from: c, reason: collision with root package name */
        private Pair<String, StringBuilder> f149142c;

        private String a() {
            return this.f149141b.format(new Date());
        }

        private static String b() {
            return "###########\n" + (tf.f150443j + ", " + tf.f150442i + ", " + tf.f150436c + ", " + tf.f150435b + ", " + tf.f150448o) + "\n###########\n" + (ho.h() + ", " + ho.d() + ", " + ho.e() + ", " + ho.l() + ", " + ho.c() + ", " + ho.j() + ", " + ho.f() + ", " + ho.g() + ", " + ho.m() + ", " + ho.k() + ", " + ho.o() + ", " + ho.b()) + "\n###########\n";
        }

        private String c() {
            return f149140a.concat(String.valueOf(a()));
        }

        private static void d() {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date();
            calendar.setTime(date);
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            sb5.append("(");
            sb6.append("(");
            for (int i3 = 2; i3 != 0; i3--) {
                calendar.add(2, -1);
                StringBuilder sb7 = new StringBuilder();
                sb7.append(calendar.get(1));
                String sb8 = sb7.toString();
                String format = String.format(Locale.CHINA, "%02d", Integer.valueOf(calendar.get(2) + 1));
                sb5.append(sb8);
                sb5.append("|");
                sb6.append(format);
                sb6.append("|");
                String str = sb8 + "_" + format;
                File[] e16 = kt.e(la.f149122g, "LOG.*" + str + ".*");
                if (e16 != null && e16.length > 0) {
                    kw.a(e16, la.f149122g, "archive-".concat(String.valueOf(str)));
                }
            }
            calendar.setTime(date);
            sb5.deleteCharAt(sb5.lastIndexOf("|")).append(")");
            sb6.deleteCharAt(sb6.lastIndexOf("|")).append(")");
            String str2 = "archive-" + sb5.toString() + "_" + sb6.toString() + ".zip";
            File[] e17 = kt.e(la.f149122g, "archive-.*.zip");
            if (e17 != null) {
                for (File file : e17) {
                    if (!file.getName().matches(str2)) {
                        kt.b(file);
                    }
                }
            }
            StringBuilder sb9 = new StringBuilder();
            sb9.append("(");
            String str3 = "(" + calendar.get(1) + ")";
            sb9.append(String.format(Locale.CHINA, "%02d", Integer.valueOf(calendar.get(2) + 1)));
            sb9.append(")");
            String str4 = f149140a + str3 + "_" + ((Object) sb9) + "_.*";
            File[] e18 = kt.e(la.f149122g, "LOG.*");
            if (e18 != null && e18.length > 0) {
                for (File file2 : e18) {
                    if (!file2.getName().matches(str4)) {
                        kt.b(file2);
                    }
                }
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case -103:
                    break;
                case -102:
                    a(c());
                    break;
                case -101:
                    Object obj = message.obj;
                    if (obj != null) {
                        b bVar = (b) obj;
                        String c16 = c();
                        Pair<String, StringBuilder> pair = this.f149142c;
                        if (pair != null && !((String) pair.first).equals(c16)) {
                            a((String) this.f149142c.first);
                        }
                        if (this.f149142c == null) {
                            this.f149142c = new Pair<>(c16, new StringBuilder());
                        }
                        StringBuilder sb5 = (StringBuilder) this.f149142c.second;
                        sb5.append(bVar.a());
                        sb5.append(bVar.f149150a);
                        sb5.append("\n");
                        if (sb5.length() >= 10240) {
                            a(c16, sb5.toString());
                            this.f149142c = null;
                            return false;
                        }
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
            if (la.f149122g != null) {
                d();
                return false;
            }
            return false;
        }

        private void a(b bVar) {
            String c16 = c();
            Pair<String, StringBuilder> pair = this.f149142c;
            if (pair != null && !((String) pair.first).equals(c16)) {
                a((String) this.f149142c.first);
            }
            if (this.f149142c == null) {
                this.f149142c = new Pair<>(c16, new StringBuilder());
            }
            StringBuilder sb5 = (StringBuilder) this.f149142c.second;
            sb5.append(bVar.a());
            sb5.append(bVar.f149150a);
            sb5.append("\n");
            if (sb5.length() >= 10240) {
                a(c16, sb5.toString());
                this.f149142c = null;
            }
        }

        private void a(String str) {
            Object obj;
            Pair<String, StringBuilder> pair = this.f149142c;
            if (pair == null || (obj = pair.second) == null || ((StringBuilder) obj).length() == 0) {
                return;
            }
            StringBuilder sb5 = (StringBuilder) this.f149142c.second;
            sb5.append("\n====================================== \n");
            a(str, sb5.toString());
            this.f149142c = null;
        }

        private static void a(String str, String str2) {
            File file = new File(la.f149122g, str);
            if (!file.exists()) {
                kt.a(file);
                str2 = b() + str2;
            }
            kt.c(file, str2);
        }
    };

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.la$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass2 implements FileFilter {
        AnonymousClass2() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.compile("log-.*.log").matcher(file.getName()).matches();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f149143a = Process.myPid();

        /* renamed from: b, reason: collision with root package name */
        private final String f149144b;

        /* renamed from: c, reason: collision with root package name */
        private final String f149145c;

        /* renamed from: d, reason: collision with root package name */
        private final String f149146d;

        /* renamed from: e, reason: collision with root package name */
        private final Throwable f149147e;

        /* renamed from: f, reason: collision with root package name */
        private final int f149148f;

        public a(int i3, String str, String str2, Throwable th5, int i16) {
            String str3;
            switch (i3) {
                case 2:
                    str3 = "VERBOSE";
                    break;
                case 3:
                    str3 = "DEBUG";
                    break;
                case 4:
                    str3 = "INFO";
                    break;
                case 5:
                    str3 = "WARN";
                    break;
                case 6:
                    str3 = RLog.ERROR;
                    break;
                case 7:
                    str3 = "ASSERT";
                    break;
                default:
                    str3 = "";
                    break;
            }
            this.f149144b = str3;
            this.f149145c = str;
            this.f149146d = str2;
            this.f149147e = th5;
            this.f149148f = i16;
        }

        private static String a(int i3) {
            switch (i3) {
                case 2:
                    return "VERBOSE";
                case 3:
                    return "DEBUG";
                case 4:
                    return "INFO";
                case 5:
                    return "WARN";
                case 6:
                    return RLog.ERROR;
                case 7:
                    return "ASSERT";
                default:
                    return "";
            }
        }

        private String b() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f149143a);
            sb5.append('[');
            sb5.append(Thread.currentThread().getName());
            sb5.append('-');
            sb5.append(Thread.currentThread().getId());
            sb5.append(']');
            sb5.append("[");
            sb5.append(this.f149148f);
            sb5.append("]|");
            sb5.append(this.f149144b);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f149145c);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f149146d);
            if (this.f149147e != null) {
                sb5.append('\n');
                sb5.append(Log.getStackTraceString(this.f149147e));
            }
            return sb5.toString();
        }

        public final b a() {
            b bVar = new b();
            bVar.f149150a = b();
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: b, reason: collision with root package name */
        private static final SimpleDateFormat f149149b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);

        /* renamed from: a, reason: collision with root package name */
        public String f149150a;

        /* renamed from: c, reason: collision with root package name */
        private final long f149151c = System.currentTimeMillis();

        public final String a() {
            return f149149b.format(Long.valueOf(this.f149151c)) + ProgressTracer.SEPARATOR;
        }
    }

    public la(Context context, TencentMapOptions tencentMapOptions, int i3) {
        super(context, tencentMapOptions);
        LoggerConfig loggerConfig;
        this.f149133j = false;
        this.f149134k = false;
        this.f149135l = 6;
        this.f149136m = new String[]{lb.a.f149154a, lb.a.f149155b, lb.a.f149156c, lb.a.f149157d, lb.a.f149158e, lb.a.f149159f, lb.a.f149160g, lb.a.f149161h, ky.f149099e};
        this.f149128c = null;
        this.f149129d = true;
        this.f149131h = context;
        this.f149130e = tencentMapOptions;
        this.f149137n = i3;
        if (tencentMapOptions != null && (loggerConfig = tencentMapOptions.getLoggerConfig()) != null) {
            boolean isToFile = loggerConfig.isToFile();
            boolean isToConsole = loggerConfig.isToConsole();
            int level = loggerConfig.getLevel();
            String[] tags = loggerConfig.getTags();
            LoggerConfig.LogCallback logCallback = loggerConfig.getLogCallback();
            if (this.f149129d) {
                this.f149129d = false;
                File file = new File(mz.a(context, this.f149130e).c().getAbsolutePath());
                if (kl.a("5.6.3.2", "4.3.4", 3) < 0) {
                    kt.a(file, new AnonymousClass2());
                }
                if (isToFile || isToConsole || logCallback != null) {
                    if (isToFile) {
                        f149122g = kt.a(file, "logs");
                    }
                    this.f149133j = isToFile;
                    this.f149134k = isToConsole;
                    this.f149135l = level;
                    if (tags != null && tags.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(Arrays.asList(this.f149136m));
                        arrayList.addAll(Arrays.asList(tags));
                        this.f149136m = (String[]) arrayList.toArray(new String[0]);
                    }
                    this.f149128c = logCallback;
                    HandlerThread handlerThread = f149123o;
                    if (!handlerThread.isAlive()) {
                        handlerThread.start();
                    }
                    Handler handler = new Handler(handlerThread.getLooper(), f149127s);
                    f149121f = handler;
                    handler.sendEmptyMessage(-103);
                }
            }
        }
        if (tf.f150437d) {
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.tencent.mapsdk.internal.la.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th5) {
                    kx.a(6, ky.f149098d, "UncaughtException: t[" + thread + "]", th5);
                    throw new RuntimeException(th5);
                }
            });
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void a(Context context, kq.a aVar) {
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void b(String str) {
        if (a(3, ky.f149098d)) {
            b(3, ky.f149098d, str, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void c(String str) {
        if (a(4, ky.f149098d)) {
            b(4, ky.f149098d, str, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void d(String str) {
        if (a(5, ky.f149098d)) {
            b(5, ky.f149098d, str, null);
        }
    }

    private void a(boolean z16, boolean z17, int i3, String[] strArr, LoggerConfig.LogCallback logCallback) {
        if (this.f149129d) {
            this.f149129d = false;
            File file = new File(mz.a(this.f149131h, this.f149130e).c().getAbsolutePath());
            if (kl.a("5.6.3.2", "4.3.4", 3) < 0) {
                kt.a(file, new AnonymousClass2());
            }
            if (z16 || z17 || logCallback != null) {
                if (z16) {
                    f149122g = kt.a(file, "logs");
                }
                this.f149133j = z16;
                this.f149134k = z17;
                this.f149135l = i3;
                if (strArr != null && strArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(Arrays.asList(this.f149136m));
                    arrayList.addAll(Arrays.asList(strArr));
                    this.f149136m = (String[]) arrayList.toArray(new String[0]);
                }
                this.f149128c = logCallback;
                HandlerThread handlerThread = f149123o;
                if (!handlerThread.isAlive()) {
                    handlerThread.start();
                }
                Handler handler = new Handler(handlerThread.getLooper(), f149127s);
                f149121f = handler;
                handler.sendEmptyMessage(-103);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void e(String str) {
        if (a(6, ky.f149098d)) {
            b(6, ky.f149098d, str, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void b(String str, Throwable th5) {
        if (a(3, ky.f149098d)) {
            b(3, ky.f149098d, str, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void c(String str, Throwable th5) {
        if (a(4, ky.f149098d)) {
            b(4, ky.f149098d, str, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void d(String str, Throwable th5) {
        if (a(5, ky.f149098d)) {
            b(5, ky.f149098d, str, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void e(String str, Throwable th5) {
        if (a(6, ky.f149098d)) {
            b(6, ky.f149098d, str, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void b(String str, String str2) {
        if (a(3, str)) {
            b(3, str, str2, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void c(String str, String str2) {
        if (a(4, str)) {
            b(4, str, str2, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void d(String str, String str2) {
        if (a(5, str)) {
            b(5, str, str2, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void e(String str, String str2) {
        if (a(6, str)) {
            b(6, str, str2, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void b(String str, String str2, Throwable th5) {
        if (a(3, str)) {
            b(3, str, str2, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void c(String str, String str2, Throwable th5) {
        if (a(4, str)) {
            b(4, str, str2, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void d(String str, String str2, Throwable th5) {
        if (a(5, str)) {
            b(5, str, str2, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void e(String str, String str2, Throwable th5) {
        if (a(6, str)) {
            b(6, str, str2, th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(int i3, String str, String str2, Throwable th5) {
        String str3;
        LoggerConfig.LogCallback logCallback;
        if (!ky.f149098d.equals(str)) {
            if (!TextUtils.isEmpty(str)) {
                str = "TMS-".concat(String.valueOf(str));
            } else {
                str3 = ky.f149098d;
                if (this.f149134k) {
                    c(i3, str3, str2, th5);
                }
                if (this.f149128c == null || this.f149133j) {
                    b a16 = new a(i3, str3, str2, th5, this.f149137n).a();
                    logCallback = this.f149128c;
                    if (logCallback != null) {
                        logCallback.onLog(a16.a() + a16.f149150a);
                    }
                    if (this.f149133j) {
                        return;
                    }
                    Message obtain = Message.obtain();
                    obtain.what = -101;
                    obtain.obj = a16;
                    Handler handler = f149121f;
                    if (handler != null) {
                        handler.sendMessage(obtain);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        str3 = str;
        if (this.f149134k) {
        }
        if (this.f149128c == null) {
        }
        b a162 = new a(i3, str3, str2, th5, this.f149137n).a();
        logCallback = this.f149128c;
        if (logCallback != null) {
        }
        if (this.f149133j) {
        }
    }

    private void c(int i3, String str, String str2, Throwable th5) {
        if (th5 != null) {
            switch (i3) {
                case 2:
                    Log.v(str, str2, th5);
                    break;
                case 3:
                    Log.d(str, str2, th5);
                    break;
                case 4:
                    Log.i(str, str2, th5);
                    break;
                case 5:
                    Log.w(str, str2, th5);
                    break;
                case 6:
                    Log.e(str, str2, th5);
                    break;
                case 7:
                    Log.wtf(str, str2, th5);
                    break;
            }
        } else {
            Log.println(i3, str, str2);
        }
        if (this.f149132i) {
            if (th5 != null) {
                str2 = str2 + " [error]:" + th5.getMessage();
            }
            System.out.println("[" + str + "]:" + str2);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void d() {
        if (this.f149129d) {
            return;
        }
        this.f149129d = true;
        this.f149128c = null;
        this.f149130e = null;
        Handler handler = f149121f;
        if (handler != null) {
            handler.sendEmptyMessage(-102);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final String c() {
        return f149122g.getAbsolutePath();
    }

    private boolean a(String str, int i3) {
        boolean z16 = false;
        for (String str2 : this.f149136m) {
            if (str2.equals(str)) {
                z16 = true;
            }
        }
        return z16 && i3 >= this.f149135l;
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void a(String str) {
        if (a(2, ky.f149098d)) {
            b(2, ky.f149098d, str, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void a(String str, Throwable th5) {
        if (a(2, ky.f149098d)) {
            b(2, ky.f149098d, str, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void a(String str, String str2) {
        if (a(2, str)) {
            b(2, str, str2, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void a(String str, String str2, Throwable th5) {
        if (a(2, str)) {
            b(2, str, str2, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final void a(boolean z16) {
        this.f149132i = z16;
    }

    @Override // com.tencent.mapsdk.internal.kx, com.tencent.mapsdk.internal.kz
    public final boolean a(int i3, String str) {
        boolean z16 = false;
        for (String str2 : this.f149136m) {
            if (str2.equals(str)) {
                z16 = true;
            }
        }
        return (z16 && i3 >= this.f149135l) || this.f149090b || (tf.f150437d && !kx.f149088a.contains(str));
    }
}
