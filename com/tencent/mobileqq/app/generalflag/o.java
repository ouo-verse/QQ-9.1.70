package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o implements IGeneralFlagProvider {
    static IPatchRedirector $redirector_;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(MessageRecord messageRecord, boolean z16, generalflags$ResvAttr generalflags_resvattr) {
        StickerInfo m3;
        if (messageRecord.msgtype == -2058 && (m3 = EmojiStickerManager.m(messageRecord)) != null) {
            generalflags_resvattr.float_sticker_x.set(m3.f204679x);
            generalflags_resvattr.float_sticker_y.set(m3.f204680y);
            generalflags_resvattr.float_sticker_width.set(m3.width);
            generalflags_resvattr.float_sticker_height.set(m3.height);
            generalflags_resvattr.uint32_sticker_rotate.set(m3.rotate);
            if (messageRecord.istroop == 0) {
                generalflags_resvattr.uint64_sticker_host_msgseq.set(((short) m3.hostMsgSeq) & 65535);
            } else {
                generalflags_resvattr.uint64_sticker_host_msgseq.set(m3.hostMsgSeq);
            }
            generalflags_resvattr.uint64_sticker_host_msguid.set(m3.hostMsgUid);
            generalflags_resvattr.uint64_sticker_host_time.set(m3.hostMsgTime);
            if (QLog.isColorLevel()) {
                QLog.i(MessageHandlerUtils.TAG, 2, "set generalFlag for sticker info: " + m3.toString());
            }
            return true;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider
    public boolean[] getGeneralFlagElemFromMsg(AppInterface appInterface, boolean z16, boolean z17, MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), messageRecord, generalflags_resvattr, msg_svc_pbsendmsgreq, im_msg_body_generalflags);
        }
        return new boolean[]{z16, a(messageRecord, z17, generalflags_resvattr)};
    }
}
