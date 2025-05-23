package com.tencent.mobileqq.activity.aio.tips;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GatherContactsTipsHelper {
    public static void a(final QQAppInterface qQAppInterface, final String str) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106054", false)) {
            QLog.i("GatherContactsTipsHelper", 1, "shelf  deleteUncommonlyUsedContactsAndCancelTips");
            return;
        }
        try {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.tips.GatherContactsTipsHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    for (MessageRecord messageRecord : QQAppInterface.this.getMessageFacade().Q(str, 0)) {
                        int i3 = messageRecord.msgtype;
                        if (i3 == -1026 || i3 == -1027) {
                            QQAppInterface.this.getMessageFacade().T1(str, 0, messageRecord.uniseq);
                            if (QLog.isColorLevel()) {
                                QLog.d("GatherContactsTipsHelper", 2, "deleteUncommonlyUsedContactsAndCancelTips, currentUin: " + QQAppInterface.this.getCurrentAccountUin() + " friendUin:" + str + " msgtype:" + messageRecord.msgtype);
                            }
                        }
                    }
                }
            }, 32, null, true);
        } catch (Throwable th5) {
            QLog.e("GatherContactsTipsHelper", 1, "deleteUncommonlyUsedContactsAndCancelTips fail", th5);
        }
    }

    public static void b(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            a(qQAppInterface, str);
            MessageRecord d16 = q.d(MessageRecord.MSG_TYPE_UNCOMMONLY_USED_CONTACTS_CANCEL_SET);
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            d16.init(qQAppInterface.getCurrentAccountUin(), str, str, "", K0, MessageRecord.MSG_TYPE_UNCOMMONLY_USED_CONTACTS_CANCEL_SET, 0, K0);
            d16.isread = true;
            qQAppInterface.getMessageFacade().c(d16, d16.selfuin);
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004C57", "0X8004C57", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.d("GatherContactsTipsHelper", 2, "insertUncommonlyUsedContactsCancelSetTips success, currentUin: " + qQAppInterface.getCurrentAccountUin() + " friendUin:" + str);
            }
        }
    }

    public static void c(QQAppInterface qQAppInterface, List<String> list) {
        if (qQAppInterface != null && list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                b(qQAppInterface, it.next());
            }
        }
    }

    public static void d(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            a(qQAppInterface, str);
            MessageRecord d16 = q.d(-1026);
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            d16.init(qQAppInterface.getCurrentAccountUin(), str, str, "", K0, -1026, 0, K0);
            d16.isread = true;
            qQAppInterface.getMessageFacade().c(d16, d16.selfuin);
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004C56", "0X8004C56", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.d("GatherContactsTipsHelper", 2, "insertUncommonlyUsedContactsTips success, currentUin: " + qQAppInterface.getCurrentAccountUin() + " friendUin:" + str);
            }
        }
    }

    public static void e(QQAppInterface qQAppInterface, List<String> list) {
        if (qQAppInterface != null && list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                d(qQAppInterface, it.next());
            }
        }
    }
}
