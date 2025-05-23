package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForLimitChatTopic extends ChatMessage {
    public static final String TAG = "MessageForLimitChatTopic";

    public MessageForLimitChatTopic() {
        this.mNeedTimeStamp = false;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, String.format(Locale.getDefault(), "doParse: %s", this.f203106msg));
        }
        int i3 = this.istroop;
        if (i3 == 1044 || i3 == 1045) {
            this.isread = true;
        }
    }
}
