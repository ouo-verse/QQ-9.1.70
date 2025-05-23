package com.tencent.mobileqq.receipt;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f280222a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f280223b;

    /* renamed from: c, reason: collision with root package name */
    private static LongSparseArray<Integer> f280224c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f280222a = "ReceiptUtil";
        }
    }

    public static int a(QQAppInterface qQAppInterface) {
        if (!f280223b) {
            e(qQAppInterface);
        }
        SharedPreferences preferences = qQAppInterface.getPreferences();
        long j3 = preferences.getLong("receipt_msg_store_time", 0L);
        long serverTime = NetConnInfoCenter.getServerTime() * 1000;
        if (!f(j3, serverTime)) {
            i(qQAppInterface, 0);
            preferences.edit().putLong("receipt_msg_store_time", serverTime).apply();
        }
        if (QLog.isColorLevel()) {
            QLog.d(f280222a, 2, "getLeftNum max is " + b(qQAppInterface));
        }
        return b(qQAppInterface) - c(qQAppInterface);
    }

    public static int b(QQAppInterface qQAppInterface) {
        if (!f280223b) {
            e(qQAppInterface);
            return 0;
        }
        return 0;
    }

    private static int c(QQAppInterface qQAppInterface) {
        int intValue = f280224c.get(h(qQAppInterface.getCurrentAccountUin()), 0).intValue();
        if (QLog.isColorLevel()) {
            QLog.d(f280222a, 2, "getSentNum is " + intValue);
        }
        return intValue;
    }

    public static void d(QQAppInterface qQAppInterface) {
        if (!f280223b) {
            e(qQAppInterface);
        }
        int c16 = c(qQAppInterface) + 1;
        i(qQAppInterface, c16);
        if (QLog.isColorLevel()) {
            QLog.d(f280222a, 2, "increaseSentNum with result:  " + Integer.toString(c16));
        }
    }

    private static void e(QQAppInterface qQAppInterface) {
        SharedPreferences preferences = qQAppInterface.getPreferences();
        f280224c = new LongSparseArray<>(1);
        f280224c.put(h(qQAppInterface.getCurrentAccountUin()), Integer.valueOf(preferences.getInt("receipt_msg_sent_num", 0)));
        f280223b = true;
    }

    private static boolean f(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j16);
        boolean z16 = false;
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        Date time = calendar.getTime();
        calendar.setTimeInMillis(j3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        if (time.compareTo(calendar.getTime()) == 0) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f280222a, 2, j3 + " and " + j16 + "isToday? " + z16);
        }
        return z16;
    }

    public static boolean g(MessageRecord messageRecord) {
        if (messageRecord != null && (messageRecord instanceof MessageForStructing) && ((MessageForStructing) messageRecord).structingMsg.mMsgServiceID == 107) {
            return true;
        }
        return false;
    }

    private static long h(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f280222a, 2, QLog.getStackTraceString(e16));
                return -1L;
            }
            return -1L;
        }
    }

    private static void i(QQAppInterface qQAppInterface, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(f280222a, 2, "setSentNum: " + i3);
        }
        f280224c.put(h(qQAppInterface.getCurrentAccountUin()), Integer.valueOf(i3));
        qQAppInterface.getPreferences().edit().putInt("receipt_msg_sent_num", i3).apply();
    }
}
