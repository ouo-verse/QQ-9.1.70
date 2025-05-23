package com.tencent.mobileqq.guild.message.pbdecoder;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.ab;
import com.tencent.mobileqq.troop.data.c;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.group_pro_proto.msg_responses_svr.MsgResponsesSvr$MsgCnt;
import tencent.im.group_pro_proto.msgindex.msgindex$CommentTransData;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype38;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements com.tencent.imcore.message.core.codec.a {

    /* renamed from: a, reason: collision with root package name */
    private static String f230726a = "GuildMsgEventDecoder";

    private boolean d(hummer_commelem$MsgElemInfo_servtype38 hummer_commelem_msgeleminfo_servtype38, List<MessageRecord> list) {
        if (!hummer_commelem_msgeleminfo_servtype38.bytes_react_data.has()) {
            QLog.d(f230726a, 2, "decodeEmojReactData: emojElem.bytes_data is EMPTY.");
            return false;
        }
        MsgResponsesSvr$MsgCnt msgResponsesSvr$MsgCnt = new MsgResponsesSvr$MsgCnt();
        try {
            msgResponsesSvr$MsgCnt.mergeFrom(hummer_commelem_msgeleminfo_servtype38.bytes_react_data.get().toByteArray());
            if (msgResponsesSvr$MsgCnt.emoji_reaction.size() == 0) {
                QLog.e(f230726a, 1, "decodeEmojReactData: emoji_reaction is EMPTY!");
                return false;
            }
            oi1.a aVar = new oi1.a();
            aVar.a(msgResponsesSvr$MsgCnt.emoji_reaction.get());
            QLog.d(f230726a, 2, "decodeEmojReactData. msgRecords size: " + list.size());
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                it.next().saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_ENOJ_REACTION, aVar.b());
            }
            return true;
        } catch (Exception e16) {
            QLog.e(f230726a, 1, "decodeEmojReactData: bytes_data invalid. " + e16.getMessage());
            return false;
        }
    }

    private boolean e(hummer_commelem$MsgElemInfo_servtype38 hummer_commelem_msgeleminfo_servtype38, List<MessageRecord> list) {
        if (!hummer_commelem_msgeleminfo_servtype38.bytes_reply_data.has()) {
            QLog.i(f230726a, 2, "decodeMsgReply: bytes_reply_data  is EMPTY.");
            return false;
        }
        msgindex$CommentTransData msgindex_commenttransdata = new msgindex$CommentTransData();
        try {
            msgindex_commenttransdata.mergeFrom(hummer_commelem_msgeleminfo_servtype38.bytes_reply_data.get().toByteArray());
            if (!msgindex_commenttransdata.comment_cnt.has()) {
                QLog.e(f230726a, 1, "decodeMsgReply: comment_cnt is EMPTY!");
                return false;
            }
            cu1.a aVar = new cu1.a();
            aVar.f391846a = msgindex_commenttransdata.comment_cnt.get();
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                it.next().saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_SELF_COMMENT_INFO, aVar.b());
            }
            return true;
        } catch (Exception e16) {
            QLog.e(f230726a, 1, "decodeMsgReply: bytes_reply_data invalid. " + e16.getMessage());
            return false;
        }
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, c cVar, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        if (list2.size() == 0) {
            QLog.e(f230726a, 1, "decodePBMsgElem msgRecords.size() == 0");
            list2.add(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).createEmptyMR());
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.common_elem.has() && next.common_elem.get().uint32_service_type.get() == 38) {
                    im_msg_body_commonelem = next.common_elem.get();
                    break;
                }
            } else {
                im_msg_body_commonelem = null;
                break;
            }
        }
        if (im_msg_body_commonelem == null) {
            QLog.e(f230726a, 1, "decodePBMsgElem. No commonElem has EmojiReaction.");
            return false;
        }
        if (list2.isEmpty()) {
            QLog.e(f230726a, 1, "msgRecords is EMPTY!");
            return false;
        }
        hummer_commelem$MsgElemInfo_servtype38 hummer_commelem_msgeleminfo_servtype38 = new hummer_commelem$MsgElemInfo_servtype38();
        try {
            hummer_commelem_msgeleminfo_servtype38.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            boolean d16 = d(hummer_commelem_msgeleminfo_servtype38, list2);
            boolean e16 = e(hummer_commelem_msgeleminfo_servtype38, list2);
            if (d16 || e16) {
                return true;
            }
            return false;
        } catch (InvalidProtocolBufferMicroException e17) {
            QLog.e(f230726a, 1, "decodePBMsgElem. bytes_pb_elem invalid: " + e17.getMessage());
            return false;
        }
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        if (im_msg_body_elem.common_elem.has() && im_msg_body_elem.common_elem.get().uint32_service_type.get() == 38) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        return -1000;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public void c(List<com.tencent.imcore.message.core.codec.a> list) {
    }
}
