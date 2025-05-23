package com.tencent.mobileqq.app.message.messageclean;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.br;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ag {
    static IPatchRedirector $redirector_;

    public static void a(String str, int i3, QQAppInterface qQAppInterface) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 1000 && i3 != 1004) {
                            if (i3 != 3000) {
                                if (i3 != 10010) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("MessageDeleteUtils", 2, "cleanMessage type not support = " + i3);
                                    }
                                }
                            }
                        }
                        b(str, i3, e(str, i3, qQAppInterface), qQAppInterface);
                    }
                    b(str, i3, e(str, i3, qQAppInterface), qQAppInterface);
                } else {
                    b(str, i3, c(str, i3, qQAppInterface), qQAppInterface);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MessageDeleteUtils", 2, "cleanMessage exception = " + e16.getMessage());
                }
                e16.printStackTrace();
            }
        }
    }

    private static void b(String str, int i3, String str2, QQAppInterface qQAppInterface) {
        long j3;
        long j16;
        List<MessageRecord> Q = qQAppInterface.getMessageFacade().Q(str, i3);
        if (Q != null && !Q.isEmpty()) {
            if (Q.get(Q.size() - 1).isSendFromLocal()) {
                j3 = Q.get(Q.size() - 1).time + 2;
            } else {
                j3 = Q.get(Q.size() - 1).time;
            }
        } else {
            j3 = 0;
        }
        qQAppInterface.getMessageFacade().q(str, i3);
        qQAppInterface.getMessageFacade().m0(str, i3);
        if (str2 != null) {
            try {
                j16 = Long.parseLong(str2);
            } catch (Exception e16) {
                e16.printStackTrace();
                j16 = 0;
            }
            long max = Math.max(j16, j3);
            if (max > 0) {
                qQAppInterface.getMsgCache().A(str, i3, max);
            }
        }
    }

    private static String c(String str, int i3, QQAppInterface qQAppInterface) {
        return null;
    }

    private static int d(String str, int i3, StringBuilder sb5, QQAppInterface qQAppInterface) {
        Cursor rawQuery;
        long j3;
        SQLiteDatabase readableDatabase = qQAppInterface.getReadableDatabase();
        if (readableDatabase == null) {
            return 0;
        }
        StringBuilder c16 = br.c(MessageRecord.getOldTableName(str, i3), MessageRecord.getTableName(str, i3), readableDatabase, " where msgtype != -2006");
        if (c16 == null || (rawQuery = readableDatabase.rawQuery(c16.toString(), null)) == null) {
            return 0;
        }
        if (rawQuery.getCount() > 0 && sb5 != null) {
            rawQuery.moveToLast();
            if (i3 == 3000) {
                j3 = rawQuery.getLong(rawQuery.getColumnIndex(AppConstants.Key.COLUMN_SHMSG_SEQ));
            } else if (i3 == 0) {
                j3 = rawQuery.getLong(rawQuery.getColumnIndex("time"));
            } else if (i3 == 1) {
                j3 = rawQuery.getLong(rawQuery.getColumnIndex(AppConstants.Key.COLUMN_SHMSG_SEQ));
            } else {
                j3 = 0;
            }
            if (j3 > 0) {
                sb5.append(String.valueOf(j3));
            }
        }
        int count = rawQuery.getCount();
        rawQuery.close();
        return count;
    }

    private static String e(String str, int i3, QQAppInterface qQAppInterface) {
        StringBuilder sb5 = new StringBuilder();
        if (d(str, i3, sb5, qQAppInterface) > 0) {
            return sb5.toString();
        }
        return null;
    }
}
