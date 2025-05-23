package com.tencent.luggage.wxa.tn;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d0 {
    public static String a() {
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                return (stackTrace[2].getClassName().substring(15) + ":" + stackTrace[2].getMethodName()) + "(" + stackTrace[2].getLineNumber() + ")";
            }
            return "";
        } catch (Throwable th5) {
            w.b("MicroMsg.Util.MMStack", "getCaller e:%s", a(th5));
            return "";
        }
    }

    public String toString() {
        return a(true);
    }

    public static String a(boolean z16) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 4) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 3; i3 < stackTrace.length; i3++) {
            if (stackTrace[i3].getClassName().contains("com.tencent.") && !stackTrace[i3].getClassName().contains("sdk.platformtools.Log")) {
                sb5.append("[");
                sb5.append(stackTrace[i3].getClassName().replace("com.tencent.mm", ""));
                sb5.append(":");
                sb5.append(stackTrace[i3].getMethodName());
                if (z16) {
                    sb5.append("(" + stackTrace[i3].getLineNumber() + ")]");
                } else {
                    sb5.append("]");
                }
            }
        }
        return sb5.toString();
    }

    public static String a(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            th5.printStackTrace(printStream);
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            printStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream2;
        } catch (Exception unused) {
            return "";
        }
    }
}
