package com.tencent.imcore.message.facade.add;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static void a(MessageRecord messageRecord) {
        if (messageRecord instanceof ChatMessage) {
            ((ChatMessage) messageRecord).mPendantAnimatable = true;
        }
    }
}
