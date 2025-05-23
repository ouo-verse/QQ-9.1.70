package com.tencent.turingcam;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class A0y4R {
    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Throwable) {
            return a((Throwable) obj);
        }
        return obj.toString();
    }

    public static String a(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th5.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2;
    }
}
