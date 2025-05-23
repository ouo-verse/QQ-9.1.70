package com.tencent.mobileqq.app.richtext;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.msg.hummer.resv.generalflags$BotMetaData;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b implements IRichTextAndMsgViaProvider {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(im_msg_body$RichText im_msg_body_richtext, MessageRecord messageRecord) {
        String extInfoFromExtStr;
        if (messageRecord == null || im_msg_body_richtext == null || (extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("inline_ark_robot_appid")) == null) {
            return;
        }
        im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
        generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
        generalflags$BotMetaData generalflags_botmetadata = new generalflags$BotMetaData();
        generalflags_botmetadata.uint64_inline_bot_appid.set(Long.parseLong(extInfoFromExtStr));
        generalflags_botmetadata.uint32_msg_src.set(1);
        generalflags_resvattr.bot_meta_data.set(generalflags_botmetadata);
        im_msg_body_generalflags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(generalflags_resvattr.toByteArray()));
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.general_flags.set(im_msg_body_generalflags);
        im_msg_body_richtext.elems.get().add(im_msg_body_elem);
    }

    @Override // com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider
    public Object[] getRichTextAndMsgViaFromMessageRecord(AppInterface appInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, appInterface, messageRecord, im_msg_body_richtext, Integer.valueOf(i3));
        }
        if (messageRecord.msgtype == -5008) {
            im_msg_body_richtext = com.tencent.mobileqq.service.message.p.l((ChatMessage) messageRecord, false);
            if (!messageRecord.getExtInfoFromExtStr("inline_ark_robot_appid").isEmpty()) {
                a(im_msg_body_richtext, messageRecord);
            }
        }
        return new Object[]{im_msg_body_richtext, Integer.valueOf(i3)};
    }
}
