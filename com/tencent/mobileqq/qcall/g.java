package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(long j3) {
        return b(d(j3));
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        int length = str.length() - 4;
        int i3 = length - 4;
        if (length < 0) {
            length = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 < length && length > 0) {
            stringBuffer.replace(i3, length, "*");
        }
        return stringBuffer.toString();
    }

    public static long c(String str) {
        try {
            return new BigInteger(str).longValue();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e(g.class.getSimpleName(), 2, "failed getLong, uin = " + str);
                return 0L;
            }
            return 0L;
        }
    }

    public static String d(long j3) {
        BigInteger valueOf = BigInteger.valueOf(j3);
        if (valueOf.signum() < 0) {
            valueOf = valueOf.add(BigInteger.ONE.shiftLeft(64));
        }
        return valueOf.toString();
    }

    public static long e(String str) {
        try {
            return new BigInteger(str).longValue();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(g.class.getSimpleName(), 2, "failed to long:" + str);
                return 0L;
            }
            return 0L;
        }
    }

    public static String f(int i3) {
        return String.valueOf(i3 & 4294967295L);
    }
}
