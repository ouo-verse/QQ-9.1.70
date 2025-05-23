package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.config.business.AlbumConfProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ac {
    static IPatchRedirector $redirector_;

    public static boolean a() {
        com.tencent.mobileqq.config.business.a a16 = AlbumConfProcessor.a();
        if (a16 == null) {
            return true;
        }
        int i3 = a16.f202479b;
        if ((i3 != 1 && i3 != 2) || i3 == 1) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        com.tencent.mobileqq.config.business.a a16 = AlbumConfProcessor.a();
        if (a16 == null) {
            return false;
        }
        int i3 = a16.f202478a;
        if ((i3 != 1 && i3 != 2) || i3 != 1) {
            return false;
        }
        return true;
    }

    public static boolean c(MessageRecord messageRecord) {
        int i3;
        if (messageRecord != null && (((i3 = messageRecord.msgtype) == -2000 || i3 == -2006) && !TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("commen_flash_pic")))) {
            return true;
        }
        return false;
    }

    public static boolean d(MessageRecord messageRecord) {
        try {
            return Boolean.valueOf(messageRecord.getExtInfoFromExtStr("commen_flash_pic")).booleanValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static void e(MessageRecord messageRecord, boolean z16) {
        if (messageRecord.msgtype == -2000) {
            messageRecord.saveExtInfoToExtStr("commen_flash_pic", z16 + "");
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("FlashPicHelper", 4, "setFlashPicFlag,troopUin:" + messageRecord.frienduin + ",isReaded:" + z16 + ",msgType:" + messageRecord.msgtype);
        }
    }

    public static void f(MessageRecord messageRecord) {
        if (messageRecord != null) {
            messageRecord.saveExtInfoToExtStr("commen_flash_pic", "true");
        }
    }

    public static boolean g(int i3, String str) {
        if (i3 == 0 && a()) {
            return true;
        }
        if (i3 == 1 && b()) {
            return true;
        }
        return false;
    }
}
