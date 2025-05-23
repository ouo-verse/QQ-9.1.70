package com.tencent.mobileqq.app.richtext;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class s implements IRichTextAndMsgViaProvider {
    static IPatchRedirector $redirector_;

    public s() {
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
        if (messageRecord.msgtype == -2058) {
            if (messageRecord instanceof MessageForMarketFace) {
                MessageForMarketFace messageForMarketFace = (MessageForMarketFace) messageRecord;
                im_msg_body_richtext = com.tencent.mobileqq.service.message.p.r(messageForMarketFace);
                i3 = messageForMarketFace.msgVia;
            } else if (messageRecord instanceof MessageForText) {
                MessageForText messageForText = (MessageForText) messageRecord;
                im_msg_body_richtext = com.tencent.mobileqq.service.message.p.A(messageForText);
                i3 = messageForText.msgVia;
            } else if (messageRecord instanceof MessageForPic) {
                MessageForPic messageForPic = (MessageForPic) messageRecord;
                im_msg_body_richtext = com.tencent.mobileqq.service.message.p.t(messageForPic);
                i3 = messageForPic.msgVia;
            }
        }
        return new Object[]{im_msg_body_richtext, Integer.valueOf(i3)};
    }
}
