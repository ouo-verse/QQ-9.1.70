package com.xiaomi.push;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class er {
    public static int a(Throwable th5) {
        boolean z16 = th5 instanceof fi;
        if (z16) {
            fi fiVar = (fi) th5;
            if (fiVar.a() != null) {
                th5 = fiVar.a();
            }
        }
        String message = th5.getMessage();
        if (th5.getCause() != null) {
            message = th5.getCause().getMessage();
        }
        if (th5 instanceof SocketTimeoutException) {
            return 105;
        }
        if (th5 instanceof SocketException) {
            if (message.indexOf("Network is unreachable") != -1) {
                return 102;
            }
            if (message.indexOf("Connection refused") != -1) {
                return 103;
            }
            if (message.indexOf("Connection timed out") != -1) {
                return 105;
            }
            if (message.endsWith("EACCES (Permission denied)")) {
                return 101;
            }
            if (message.indexOf("Connection reset by peer") != -1) {
                return 109;
            }
            if (message.indexOf("Broken pipe") != -1) {
                return 110;
            }
            if (message.indexOf("No route to host") != -1) {
                return 104;
            }
            if (message.endsWith("EINVAL (Invalid argument)")) {
                return 106;
            }
            return 199;
        }
        if (th5 instanceof UnknownHostException) {
            return 107;
        }
        if (z16) {
            return 399;
        }
        return 0;
    }
}
