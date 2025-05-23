package com.tencent.mobileqq.armap.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MapLog {
    static IPatchRedirector $redirector_ = null;
    public static final int CLR = 2;
    public static final int DEBUG = 1;
    public static final String TAG = "Q.armap";

    public MapLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final void d(String str, String str2, Object... objArr) {
        String str3 = "Q.armap";
        if (!TextUtils.isEmpty(str)) {
            str3 = "Q.armap." + str;
        }
        if (objArr != null && objArr.length > 0) {
            try {
                str2 = String.format(str2, objArr);
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(str3, 4, str2);
        }
    }

    public static final void debug(int i3, String str, String str2) {
        if (str2 == null) {
            return;
        }
        QLog.d("QLOG_" + str, i3, str2 + ",Loglevel:" + i3);
    }

    public static final void i(String str, int i3, String str2, Object... objArr) {
        String str3 = "Q.armap";
        if (!TextUtils.isEmpty(str)) {
            str3 = "Q.armap." + str;
        }
        if (objArr != null && objArr.length > 0) {
            try {
                str2 = String.format(str2, objArr);
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
            }
        }
        if (i3 == 2) {
            if (QLog.isColorLevel()) {
                QLog.i(str3, 2, str2);
            }
        } else if (i3 == 4) {
            if (QLog.isDevelopLevel()) {
                QLog.i(str3, 4, str2);
            }
        } else if (i3 == 1) {
            QLog.i(str3, 1, str2);
        }
    }

    public static boolean isLoggable(int i3) {
        if (i3 == 1) {
            return QLog.isDevelopLevel();
        }
        if (i3 == 2) {
            return QLog.isColorLevel();
        }
        return false;
    }

    public static boolean needWiden(long j3) {
        if ((j3 & Long.MIN_VALUE) == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public static BigInteger toUnsignedLongValue(long j3) {
        if (!needWiden(j3)) {
            return BigInteger.valueOf(j3);
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putLong(j3);
        return new BigInteger(1, allocate.array());
    }

    public static final void i(int i3, String str, Object... objArr) {
        i(null, i3, str, objArr);
    }
}
