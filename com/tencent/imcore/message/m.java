package com.tencent.imcore.message;

import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class m {
    static IPatchRedirector $redirector_;

    public static void a(AppRuntime appRuntime, String str, int i3) {
        IConversationFacade iConversationFacade = (IConversationFacade) appRuntime.getRuntimeService(IConversationFacade.class, "");
        int readUnreadMark = iConversationFacade.getReadUnreadMark(str, i3);
        if (readUnreadMark > b()) {
            QLog.e("Q.unread.Facade", 1, "Invalid Unread Mark: ", Integer.valueOf(readUnreadMark));
            iConversationFacade.setUnreadMark(str, i3, 0);
        }
    }

    public static int b() {
        return 1;
    }
}
