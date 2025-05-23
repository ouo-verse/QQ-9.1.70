package com.tencent.mobileqq.troop.navigatebar;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    static IPatchRedirector $redirector_;

    protected static String a(String str, boolean z16) {
        int i3;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 3000;
        }
        return TroopAioNavigateBarManager.g(str, i3);
    }

    protected static int b(int i3, MessageRecord messageRecord) {
        int i16;
        int i17 = -1;
        if (i3 != 27) {
            i16 = 0;
        } else {
            int i18 = messageRecord.msgtype;
            if ((i18 == -2035 || i18 == -2038) && (messageRecord instanceof MessageForDeliverGiftTips)) {
                i16 = ((MessageForDeliverGiftTips) messageRecord).giftCount;
            } else {
                i16 = -1;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getFlowersCounts, bizType = ");
            sb5.append(i3);
            sb5.append(", msgType = ");
            if (messageRecord != null) {
                i17 = messageRecord.msgtype;
            }
            sb5.append(i17);
            sb5.append(", flowersCount = ");
            sb5.append(i16);
            QLog.d("Navigate.UpdateMsgInfoUtil", 2, sb5.toString());
        }
        return i16;
    }

    @Nullable
    public static Object c(QQAppInterface qQAppInterface, String str, com.tencent.mobileqq.troop.data.c cVar, Object obj, MessageRecord messageRecord, boolean z16) {
        d(qQAppInterface, str, cVar, messageRecord, z16);
        return e(qQAppInterface, cVar, obj, messageRecord, z16);
    }

    protected static void d(QQAppInterface qQAppInterface, String str, com.tencent.mobileqq.troop.data.c cVar, MessageRecord messageRecord, boolean z16) {
        int c16 = cVar.c(z16);
        int b16 = b(c16, messageRecord);
        if ((!z16 && !com.tencent.mobileqq.troop.data.d.d(c16)) || b16 == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("Navigate.UpdateMsgInfoUtil", 2, "isTroop = " + z16 + ", bizType = " + c16 + ", flowers = " + b16 + ", troopCode = " + str + ", isTroop = " + z16);
                return;
            }
            return;
        }
        String a16 = a(str, z16);
        int b17 = NavConstants.b(c16);
        if (b17 != 102) {
            messageRecord = null;
        }
        com.tencent.mobileqq.troop.data.d dVar = cVar.f294893c;
        ((TroopAioNavigateBarManager) qQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).e(a16, b17, cVar.f294893c.f294896b, a.a(b17, dVar.f294896b, dVar.f294897c), "", b16, messageRecord);
    }

    @Nullable
    protected static Object e(QQAppInterface qQAppInterface, com.tencent.mobileqq.troop.data.c cVar, Object obj, MessageRecord messageRecord, boolean z16) {
        return null;
    }
}
