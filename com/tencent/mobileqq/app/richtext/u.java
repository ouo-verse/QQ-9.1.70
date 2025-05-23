package com.tencent.mobileqq.app.richtext;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class u implements IRichTextAndMsgViaProvider {
    static IPatchRedirector $redirector_;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider
    public Object[] getRichTextAndMsgViaFromMessageRecord(AppInterface appInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, appInterface, messageRecord, im_msg_body_richtext, Integer.valueOf(i3));
        }
        int i16 = messageRecord.msgtype;
        if (i16 == -2011 || i16 == -2051 || i16 == -7002) {
            im_msg_body_richtext = com.tencent.mobileqq.service.message.p.y((MessageForStructing) messageRecord);
        }
        return new Object[]{im_msg_body_richtext, Integer.valueOf(i3)};
    }
}
