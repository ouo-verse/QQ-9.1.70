package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ax {
    static IPatchRedirector $redirector_;

    public static boolean a(MessageRecord messageRecord) {
        int i3;
        if (messageRecord != null && (((i3 = messageRecord.msgtype) == -2000 || i3 == -2006) && !TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("hotchat_flash_pic")))) {
            return true;
        }
        return false;
    }

    public static void b(MessageRecord messageRecord, boolean z16) {
        if (messageRecord.msgtype == -2000) {
            messageRecord.saveExtInfoToExtStr("hotchat_flash_pic", z16 + "");
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(LogTag.HOTCHAT, 4, "setFlashPicFlag,troopUin:" + messageRecord.frienduin + ",isReaded:" + z16 + ",msgType:" + messageRecord.msgtype);
        }
    }

    public static void c(MessageRecord messageRecord) {
        if (messageRecord != null) {
            messageRecord.saveExtInfoToExtStr("hotchat_flash_pic", "true");
        }
    }
}
