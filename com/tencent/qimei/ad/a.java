package com.tencent.qimei.ad;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.log.IObservableLog;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f342941a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f342942b = true;

    /* renamed from: c, reason: collision with root package name */
    public static IObservableLog f342943c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int a(StackTraceElement[] stackTraceElementArr, Class cls) {
        for (int i3 = 5; i3 < stackTraceElementArr.length; i3++) {
            String className = stackTraceElementArr[i3].getClassName();
            if (!(cls.equals(Log.class) && i3 < stackTraceElementArr.length - 1 && stackTraceElementArr[i3 + 1].getClassName().equals(Log.class.getName())) && className.equals(cls.getName())) {
                return i3 + 1;
            }
        }
        return -1;
    }

    public static boolean a() {
        boolean z16;
        synchronized (a.class) {
            z16 = f342941a;
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, Object... objArr) {
        boolean z16;
        String str2;
        String str3;
        IObservableLog iObservableLog;
        synchronized (a.class) {
            z16 = f342942b;
        }
        if (z16) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int a16 = a(stackTrace, a.class);
            StackTraceElement stackTraceElement = (a16 == -1 && (a16 = a(stackTrace, Log.class)) == -1) ? null : stackTrace[a16];
            if (stackTraceElement != null) {
                String fileName = stackTraceElement.getFileName();
                if (fileName == null) {
                    fileName = "";
                }
                String methodName = stackTraceElement.getMethodName();
                if (methodName.contains("$")) {
                    methodName = methodName.substring(methodName.indexOf("$") + 1, methodName.lastIndexOf("$") - 2);
                }
                str2 = "(" + fileName + ":" + stackTraceElement.getLineNumber() + ")" + methodName + " ";
                if (str != null) {
                    str3 = str2 + "msg is null";
                } else if (objArr == null || objArr.length == 0) {
                    str3 = str2 + str;
                } else {
                    str3 = str2 + String.format(Locale.US, str, objArr);
                }
                iObservableLog = f342943c;
                if (iObservableLog != null) {
                    iObservableLog.onLog(str3);
                }
                return str3;
            }
        }
        str2 = "";
        if (str != null) {
        }
        iObservableLog = f342943c;
        if (iObservableLog != null) {
        }
        return str3;
    }
}
