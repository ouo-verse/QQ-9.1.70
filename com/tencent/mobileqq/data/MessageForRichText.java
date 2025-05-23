package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.message.RecordForTest;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class MessageForRichText extends ChatMessage {

    @RecordForTest
    public im_msg_body$RichText richText = null;

    public void prewriteForMsgbackup() {
        prewrite();
    }
}
