package com.tencent.mobileqq.stt.sub;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void a(String str) {
        File file = new File(str);
        if (!file.delete()) {
            file.deleteOnExit();
        }
    }

    public static long b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return -1L;
        }
        return file.length();
    }

    public static String c(MessageRecord messageRecord) {
        return messageRecord.getExtInfoFromExtStr("KEY_RICH_MEDIA_VIDEO_SUBTITLE_PATH");
    }

    public static String d(String str) {
        return str + ".srt";
    }

    public static boolean e(String str) {
        return "#SRT_EMPTY".equals(str);
    }

    public static boolean f(String str) {
        return new File(str).exists();
    }

    public static void g(MessageRecord messageRecord) {
        h(messageRecord, "#SRT_EMPTY");
    }

    public static void h(MessageRecord messageRecord, String str) {
        messageRecord.saveExtInfoToExtStr("KEY_RICH_MEDIA_VIDEO_SUBTITLE_PATH", str);
        ((IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).updateMsgFieldByUniseq(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
    }
}
