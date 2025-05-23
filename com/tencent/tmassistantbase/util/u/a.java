package com.tencent.tmassistantbase.util.u;

import android.util.Log;
import com.tencent.aelight.camera.constants.AECameraConstants;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f380536a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    private boolean f380537b = true;

    /* renamed from: c, reason: collision with root package name */
    private StringBuilder f380538c = new StringBuilder();

    /* renamed from: d, reason: collision with root package name */
    private boolean f380539d = true;

    /* renamed from: e, reason: collision with root package name */
    private StringBuilder f380540e = new StringBuilder();

    a() {
    }

    public static a a() {
        return new a();
    }

    public a b(String str) {
        if (this.f380539d) {
            this.f380539d = false;
            this.f380538c.append(str);
        } else {
            StringBuilder sb5 = this.f380538c;
            sb5.append("$");
            sb5.append(str);
        }
        return this;
    }

    public void c() {
        Log.i("LogBuilder", b());
    }

    public a d() {
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i3 = 6;
        if (6 >= stackTrace.length) {
            i3 = stackTrace.length;
        }
        List subList = Arrays.asList(stackTrace).subList(2, i3);
        this.f380540e.append('[');
        for (int i16 = 0; i16 < subList.size(); i16++) {
            StringBuilder sb5 = this.f380540e;
            sb5.append(((StackTraceElement) subList.get(i16)).getFileName());
            sb5.append('-');
            sb5.append(((StackTraceElement) subList.get(i16)).getLineNumber());
            sb5.append(':');
            sb5.append(((StackTraceElement) subList.get(i16)).getMethodName());
            sb5.append(',');
        }
        this.f380540e.deleteCharAt(r0.length() - 1).append(']');
        return this;
    }

    public void a(Throwable th5) {
        Log.e("LogBuilder", b(), th5);
    }

    public a c(String str) {
        if (this.f380537b) {
            this.f380537b = false;
            this.f380536a.append(str);
        } else {
            StringBuilder sb5 = this.f380536a;
            sb5.append("$");
            sb5.append(str);
        }
        return this;
    }

    public static String a(String str) {
        String str2;
        try {
            StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
            int i3 = 2;
            while (true) {
                if (i3 >= stackTrace.length) {
                    str2 = "<unknown>";
                    break;
                }
                if (!stackTrace[i3].getClass().equals(a.class)) {
                    String className = stackTrace[i3].getClassName();
                    try {
                        String substring = className.substring(className.lastIndexOf(46) + 1);
                        className = substring.substring(substring.lastIndexOf(36) + 1);
                    } catch (NoSuchMethodError unused) {
                    }
                    str2 = className + "." + stackTrace[i3].getMethodName() + "(" + stackTrace[i3].getLineNumber() + ")";
                    break;
                }
                i3++;
            }
            return String.format("[%s:%d] %s: %s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), str2, str);
        } catch (Throwable unused2) {
            System.gc();
            return "";
        }
    }

    private String b() {
        StringBuilder sb5 = this.f380536a;
        sb5.append("|");
        sb5.append((CharSequence) this.f380538c);
        sb5.append("|");
        sb5.append((CharSequence) this.f380540e);
        sb5.append(AECameraConstants.WIDGETINFO_SEPARATE);
        return a(sb5.toString());
    }
}
