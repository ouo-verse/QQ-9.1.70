package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private String f36771b;

    /* renamed from: c, reason: collision with root package name */
    private String f36772c;

    /* renamed from: d, reason: collision with root package name */
    private int f36773d;

    /* renamed from: g, reason: collision with root package name */
    private String f36776g;

    /* renamed from: h, reason: collision with root package name */
    private int f36777h;

    /* renamed from: i, reason: collision with root package name */
    private int f36778i;

    /* renamed from: j, reason: collision with root package name */
    private int f36779j;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f36770a = new StringBuilder();

    /* renamed from: e, reason: collision with root package name */
    private long f36774e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f36775f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i3, String str, int i16, String str2) {
        this.f36772c = "HMS";
        this.f36779j = i3;
        this.f36771b = str;
        this.f36773d = i16;
        if (str2 != null) {
            this.f36772c = str2;
        }
        b();
    }

    public static String a(int i3) {
        return i3 != 3 ? i3 != 4 ? i3 != 5 ? i3 != 6 ? String.valueOf(i3) : "E" : "W" : "I" : "D";
    }

    private e b() {
        this.f36774e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f36775f = currentThread.getId();
        this.f36777h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i3 = this.f36779j;
        if (length > i3) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            this.f36776g = stackTraceElement.getFileName();
            this.f36778i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb5 = new StringBuilder();
        b(sb5);
        return sb5.toString();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        b(sb5);
        a(sb5);
        return sb5.toString();
    }

    public <T> e a(T t16) {
        this.f36770a.append(t16);
        return this;
    }

    public e a(Throwable th5) {
        a((e) '\n').a((e) Log.getStackTraceString(th5));
        return this;
    }

    public String a() {
        StringBuilder sb5 = new StringBuilder();
        a(sb5);
        return sb5.toString();
    }

    private StringBuilder a(StringBuilder sb5) {
        sb5.append(TokenParser.SP);
        sb5.append(this.f36770a.toString());
        return sb5;
    }

    private StringBuilder b(StringBuilder sb5) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb5.append('[');
        sb5.append(simpleDateFormat.format(Long.valueOf(this.f36774e)));
        String a16 = a(this.f36773d);
        sb5.append(TokenParser.SP);
        sb5.append(a16);
        sb5.append('/');
        sb5.append(this.f36772c);
        sb5.append('/');
        sb5.append(this.f36771b);
        sb5.append(TokenParser.SP);
        sb5.append(this.f36777h);
        sb5.append(':');
        sb5.append(this.f36775f);
        sb5.append(TokenParser.SP);
        sb5.append(this.f36776g);
        sb5.append(':');
        sb5.append(this.f36778i);
        sb5.append(']');
        return sb5;
    }
}
