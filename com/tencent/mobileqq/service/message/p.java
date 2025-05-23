package com.tencent.mobileqq.service.message;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MixedMsg$Elem;
import localpb.richMsg.MixedMsg$Msg;
import localpb.richMsg.RichMsg$PicRec;
import localpb.richMsg.RichMsg$VideoFile;
import msf.msgcomm.msg_comm$Msg;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import msf.msgsvc.msg_svc$RoutingHead;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.source_msg$CommentRefer;
import tencent.im.msg.hummer.resv.source_msg$ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb$ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype11;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype2;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype20;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype23;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype24;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype33;
import tencent.im.msg.im_msg_body$AnonymousGroupMsg;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$LightAppElem;
import tencent.im.msg.im_msg_body$MarketFace;
import tencent.im.msg.im_msg_body$RichMsg;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$SecretFileMsg;
import tencent.im.msg.im_msg_body$ShakeWindow;
import tencent.im.msg.im_msg_body$SourceMsg;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p {
    static IPatchRedirector $redirector_;

    public static im_msg_body$RichText A(MessageForText messageForText) {
        return B(messageForText.f203106msg, messageForText.atInfoList);
    }

    public static im_msg_body$RichText B(String str, ArrayList<AtTroopMemberInfo> arrayList) {
        return w.p(str, arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static im_msg_body$RichText C(MessageRecord messageRecord) {
        source_msg$ResvAttr source_msg_resvattr;
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info");
        String str = messageRecord.f203106msg;
        if (str == null) {
            str = "";
        }
        ArrayList<AtTroopMemberInfo> arrayList = messageRecord.atInfoList;
        String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("sens_reply_special_msg");
        String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr("sens_reply_special_at_list");
        if (!TextUtils.isEmpty(extInfoFromExtStr2) && !TextUtils.isEmpty(extInfoFromExtStr3)) {
            arrayList = MessageForText.getTroopMemberInfoFromExtrJson(extInfoFromExtStr3);
            str = extInfoFromExtStr2;
        }
        im_msg_body$RichText im_msg_body_richtext = null;
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                MessageForReplyText.SourceMsgInfo sourceMsgInfo = (MessageForReplyText.SourceMsgInfo) MessagePkgUtils.getObjectFromBytes(HexUtil.hexStr2Bytes(extInfoFromExtStr));
                if (sourceMsgInfo != null) {
                    im_msg_body$SourceMsg im_msg_body_sourcemsg = new im_msg_body$SourceMsg();
                    im_msg_body_sourcemsg.uint32_orig_seqs.add(Integer.valueOf((int) sourceMsgInfo.mSourceMsgSeq));
                    im_msg_body_sourcemsg.elems.set(B(sourceMsgInfo.mSourceMsgText, null).elems.get());
                    if (sourceMsgInfo.getSourceMsg() != null) {
                        im_msg_body_sourcemsg.bytes_src_msg.set(ByteStringMicro.copyFrom(sourceMsgInfo.getSourceMsg()));
                    }
                    if (!TextUtils.isEmpty(sourceMsgInfo.mAnonymousNickName)) {
                        im_msg_body$AnonymousGroupMsg im_msg_body_anonymousgroupmsg = new im_msg_body$AnonymousGroupMsg();
                        im_msg_body_anonymousgroupmsg.str_anon_nick.set(ByteStringMicro.copyFromUtf8(sourceMsgInfo.mAnonymousNickName));
                        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                        im_msg_body_elem.anon_group_msg.set(im_msg_body_anonymousgroupmsg);
                        im_msg_body_sourcemsg.elems.add(im_msg_body_elem);
                    }
                    if (!TextUtils.isEmpty(sourceMsgInfo.mSourceMsgTroopName)) {
                        im_msg_body_sourcemsg.bytes_troop_name.set(ByteStringMicro.copyFromUtf8(sourceMsgInfo.mSourceMsgTroopName));
                    }
                    im_msg_body_sourcemsg.uint64_sender_uin.set(sourceMsgInfo.mSourceMsgSenderUin);
                    im_msg_body_sourcemsg.uint64_to_uin.set(sourceMsgInfo.mSourceMsgToUin);
                    im_msg_body_sourcemsg.uint32_time.set(sourceMsgInfo.mSourceMsgTime);
                    im_msg_body_sourcemsg.uint32_flag.set(sourceMsgInfo.mSourceSummaryFlag);
                    im_msg_body_sourcemsg.uint32_type.set(sourceMsgInfo.mType);
                    String str2 = sourceMsgInfo.mRichMsg;
                    if (str2 != null) {
                        im_msg_body_sourcemsg.bytes_richMsg.set(ByteStringMicro.copyFromUtf8(str2));
                    }
                    if (sourceMsgInfo.oriMsgType != 0) {
                        source_msg_resvattr = new source_msg$ResvAttr();
                        source_msg_resvattr.uint32_ori_msgtype.set(sourceMsgInfo.oriMsgType);
                    } else {
                        source_msg_resvattr = null;
                    }
                    if (sourceMsgInfo.origUid != 0) {
                        if (source_msg_resvattr == null) {
                            source_msg_resvattr = new source_msg$ResvAttr();
                        }
                        source_msg_resvattr.uint64_orig_uids.add(Long.valueOf(sourceMsgInfo.origUid));
                    }
                    if (!TextUtils.isEmpty(sourceMsgInfo.origNickName)) {
                        if (source_msg_resvattr == null) {
                            source_msg_resvattr = new source_msg$ResvAttr();
                        }
                        source_msg_resvattr.bytes_guild_nick.set(ByteStringMicro.copyFromUtf8(sourceMsgInfo.origNickName));
                    }
                    source_msg$ResvAttr K = K(sourceMsgInfo, source_msg_resvattr, messageRecord);
                    if (K != null) {
                        im_msg_body_sourcemsg.bytes_pb_reserve.set(ByteStringMicro.copyFrom(K.toByteArray()));
                    }
                    im_msg_body$RichText im_msg_body_richtext2 = new im_msg_body$RichText();
                    try {
                        im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
                        im_msg_body_elem2.src_msg.set(im_msg_body_sourcemsg);
                        im_msg_body_richtext2.elems.add(im_msg_body_elem2);
                        j(im_msg_body_richtext2, str, arrayList);
                        im_msg_body_richtext = im_msg_body_richtext2;
                    } catch (Exception e16) {
                        im_msg_body_richtext = im_msg_body_richtext2;
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.MSG, 2, "getSourceMsgInfo exception:" + e.getMessage());
                        }
                        if (im_msg_body_richtext != null) {
                        }
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        if (im_msg_body_richtext != null) {
            return B(str, arrayList);
        }
        return im_msg_body_richtext;
    }

    public static im_msg_body$RichText D(MessageForTroopStory messageForTroopStory) {
        im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
        im_msg_body_commonelem.uint32_service_type.set(16);
        hummer_commelem$MsgElemInfo_servtype16 hummer_commelem_msgeleminfo_servtype16 = new hummer_commelem$MsgElemInfo_servtype16();
        hummer_commelem_msgeleminfo_servtype16.uid.set(messageForTroopStory.uid);
        hummer_commelem_msgeleminfo_servtype16.unionID.set(ByteStringMicro.copyFromUtf8(messageForTroopStory.unionId));
        hummer_commelem_msgeleminfo_servtype16.storyID.set(ByteStringMicro.copyFromUtf8(messageForTroopStory.storyId));
        hummer_commelem_msgeleminfo_servtype16.md5.set(ByteStringMicro.copyFromUtf8(messageForTroopStory.md5));
        hummer_commelem_msgeleminfo_servtype16.thumbUrl.set(ByteStringMicro.copyFromUtf8(messageForTroopStory.thumbUrl));
        hummer_commelem_msgeleminfo_servtype16.doodleUrl.set(ByteStringMicro.copyFromUtf8(messageForTroopStory.doodleUrl));
        hummer_commelem_msgeleminfo_servtype16.videoWidth.set(messageForTroopStory.videoWidth);
        hummer_commelem_msgeleminfo_servtype16.videoHeight.set(messageForTroopStory.videoHeight);
        hummer_commelem_msgeleminfo_servtype16.sourceName.set(ByteStringMicro.copyFromUtf8(messageForTroopStory.sourceName));
        hummer_commelem_msgeleminfo_servtype16.sourceActionType.set(ByteStringMicro.copyFromUtf8(messageForTroopStory.sourceActionType));
        hummer_commelem_msgeleminfo_servtype16.sourceActionData.set(ByteStringMicro.copyFromUtf8(messageForTroopStory.sourceActionData));
        hummer_commelem_msgeleminfo_servtype16.ctr_version.set(messageForTroopStory.ctrVersion);
        im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype16.toByteArray()));
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.common_elem.set(im_msg_body_commonelem);
        String str = messageForTroopStory.compatibleText;
        im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
        im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(str));
        im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
        im_msg_body_elem2.text.set(im_msg_body_text);
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        im_msg_body_richtext.elems.add(im_msg_body_elem2);
        return im_msg_body_richtext;
    }

    protected static long E(msg_comm$Msg msg_comm_msg, long j3) {
        Iterator<im_msg_body$Elem> it = msg_comm_msg.msg_body.get().rich_text.get().elems.get().iterator();
        while (it.hasNext()) {
            j3 = F(it.next(), j3);
        }
        return j3;
    }

    private static long F(im_msg_body$Elem im_msg_body_elem, long j3) {
        int i3;
        if (im_msg_body_elem.elem_flags2.has() && im_msg_body_elem.elem_flags2.uint32_custom_font.has()) {
            i3 = im_msg_body_elem.elem_flags2.get().uint32_custom_font.get();
        } else if (im_msg_body_elem.secret_file.has()) {
            im_msg_body$SecretFileMsg im_msg_body_secretfilemsg = im_msg_body_elem.secret_file;
            if (im_msg_body_secretfilemsg.elem_flags2.has() && im_msg_body_secretfilemsg.elem_flags2.uint32_custom_font.has()) {
                i3 = im_msg_body_secretfilemsg.elem_flags2.get().uint32_custom_font.get();
            } else {
                return j3;
            }
        } else {
            return j3;
        }
        return i3 & 4294967295L;
    }

    public static MessageRecord G(List<MessageRecord> list, byte[] bArr, com.tencent.mobileqq.troop.data.c cVar) {
        MixedMsg$Msg mixedMsg$Msg = new MixedMsg$Msg();
        JSONObject jSONObject = new JSONObject();
        boolean z16 = false;
        int i3 = 0;
        for (MessageRecord messageRecord : list) {
            MixedMsg$Elem mixedMsg$Elem = new MixedMsg$Elem();
            int i16 = messageRecord.msgtype;
            if (i16 == -1000) {
                if (!TextUtils.isEmpty(messageRecord.f203106msg)) {
                    mixedMsg$Elem.textMsg.set(messageRecord.f203106msg);
                    try {
                        ArrayList<AtTroopMemberInfo> arrayList = messageRecord.atInfoList;
                        if (arrayList != null && arrayList.size() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            Iterator<AtTroopMemberInfo> it = messageRecord.atInfoList.iterator();
                            int i17 = 0;
                            while (it.hasNext()) {
                                jSONArray.put(i17, it.next().toJsonObject());
                                i17++;
                            }
                            jSONObject.put("" + i3, jSONArray);
                            z16 = true;
                        }
                    } catch (JSONException e16) {
                        QLog.e("Q.msg.MessageHandler", 1, "disc mixMsg create atInfos error:", e16);
                    }
                }
            } else if (i16 == -2000) {
                try {
                    mixedMsg$Elem.picMsg.set(new RichMsg$PicRec().mergeFrom(messageRecord.msgData));
                } catch (InvalidProtocolBufferMicroException e17) {
                    QLog.e("Q.msg.MessageHandler", 1, "mergeMixedMsgContent", e17);
                }
            } else if (i16 == -1049) {
                try {
                    MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord;
                    mixedMsg$Elem.sourceMsgInfo.set(HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(messageForReplyText.mSourceMsgInfo)));
                    if (!TextUtils.isEmpty(messageForReplyText.f203106msg)) {
                        mixedMsg$Elem.textMsg.set(messageForReplyText.f203106msg);
                    }
                } catch (Exception e18) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, e18.getMessage());
                    }
                }
            } else if (i16 == -2022) {
                try {
                    mixedMsg$Elem.videoMsg.set(new RichMsg$VideoFile().mergeFrom(messageRecord.msgData));
                } catch (InvalidProtocolBufferMicroException e19) {
                    QLog.e("Q.msg.MessageHandler", 1, "mergeMixedMsgContent videoFile", e19);
                }
            }
            mixedMsg$Msg.elems.get().add(mixedMsg$Elem);
            i3++;
        }
        MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) q.d(MessageRecord.MSG_TYPE_MIX);
        messageForMixedMsg.msgtype = MessageRecord.MSG_TYPE_MIX;
        messageForMixedMsg.msgData = mixedMsg$Msg.toByteArray();
        if (cVar != null && cVar.f294892b == 3000) {
            messageForMixedMsg.frienduin = cVar.f294891a;
        } else if (cVar != null && cVar.f294892b == 10014) {
            messageForMixedMsg.istroop = 10014;
        }
        if (z16 && cVar != null) {
            com.tencent.mobileqq.troop.text.a.m(cVar.f294892b, jSONObject.toString(), messageForMixedMsg);
        }
        if (bArr != null) {
            messageForMixedMsg.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(bArr));
        }
        messageForMixedMsg.parse();
        return messageForMixedMsg;
    }

    public static int H(int i3, QQAppInterface qQAppInterface) {
        return w.v(i3, qQAppInterface);
    }

    public static void I(long j3, int i3, long j16, int i16, AppInterface appInterface) {
        w.w(appInterface, j3, i3, j16, i16);
    }

    public static void J(AppInterface appInterface, long j3, int i3, long j16, int i16, byte[] bArr) {
        w.x(appInterface, j3, i3, j16, i16, bArr);
    }

    public static source_msg$ResvAttr K(MessageForReplyText.SourceMsgInfo sourceMsgInfo, source_msg$ResvAttr source_msg_resvattr, MessageRecord messageRecord) {
        if (sourceMsgInfo.mRootMsgSeq > 0 && sourceMsgInfo.mParentMsgSeq > 0 && sourceMsgInfo.mSourceMsgSeq > 0) {
            if (source_msg_resvattr == null) {
                source_msg_resvattr = new source_msg$ResvAttr();
            }
            source_msg$CommentRefer source_msg_commentrefer = new source_msg$CommentRefer();
            source_msg_commentrefer.root_seq.set(sourceMsgInfo.mRootMsgSeq);
            source_msg_commentrefer.parent_seq.set(sourceMsgInfo.mParentMsgSeq);
            source_msg_commentrefer.refer_seq.set(sourceMsgInfo.mSourceMsgSeq);
            source_msg_resvattr.comment_refer.set(source_msg_commentrefer);
        } else {
            QLog.e("Q.msg.MessageHandler", 1, "seqError uinseq" + messageRecord.uniseq + "rootMsgSeq:" + sourceMsgInfo.mRootMsgSeq + " parentSeq:" + sourceMsgInfo.mParentMsgSeq + " sourceSeq" + sourceMsgInfo.mSourceMsgSeq);
        }
        return source_msg_resvattr;
    }

    public static boolean L(QQAppInterface qQAppInterface, MessageRecord messageRecord, msg_svc$RoutingHead msg_svc_routinghead) {
        return w.y(qQAppInterface, messageRecord, msg_svc_routinghead);
    }

    public static int M(int i3, QQAppInterface qQAppInterface) {
        return w.A(i3, qQAppInterface);
    }

    public static msg_svc$PbSendMsgReq a(AppInterface appInterface, int i3, String str, ac acVar, long j3, int i16) {
        return w.b(appInterface, i3, str, acVar, j3, i16);
    }

    @Deprecated
    public static int b(msg_comm$Msg msg_comm_msg) {
        return w.d(msg_comm_msg);
    }

    public static int c(msg_comm$Msg msg_comm_msg) {
        return w.e(msg_comm_msg);
    }

    public static int d(msg_comm$Msg msg_comm_msg) {
        return w.f(msg_comm_msg);
    }

    public static long e(msg_comm$Msg msg_comm_msg) {
        if (!msg_comm_msg.msg_body.has() || !msg_comm_msg.msg_body.get().rich_text.has()) {
            return -1L;
        }
        long E = E(msg_comm_msg, -1L);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_VipFontID: fontid = " + E);
        }
        return E;
    }

    public static void f(BaseMessageHandler baseMessageHandler, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar) {
        g(baseMessageHandler, list, msg_comm_msg, z16, z17, cVar, null, null);
    }

    public static void g(BaseMessageHandler baseMessageHandler, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, ab abVar, a aVar) {
        w.h(baseMessageHandler.getApp(), list, msg_comm_msg, z16, z17, cVar, abVar, aVar);
    }

    private static String h(String str) {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < str.length()) {
            if (str.charAt(i16) == 20 && (i3 = i16 + 1) < str.length()) {
                char charAt = str.charAt(i3);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "localeCode value:" + ((int) charAt) + ",max len:" + s.f286334c.length);
                }
                if (QQSysFaceUtil.isValidFaceId(charAt)) {
                    int convertToServer = QQSysFaceUtil.convertToServer(charAt);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "---faceIndex:" + convertToServer);
                    }
                    sb5.append(str.charAt(i16));
                    sb5.append((char) ((convertToServer / 128) + 65));
                    sb5.append((char) ((convertToServer % 128) + 65));
                    i16 = i3;
                }
            } else {
                sb5.append(str.charAt(i16));
            }
            i16++;
        }
        return sb5.toString();
    }

    public static im_msg_body$RichText i(MarkFaceMessage markFaceMessage, String str, boolean z16) {
        im_msg_body$MarketFace im_msg_body_marketface = new im_msg_body$MarketFace();
        byte[] bArr = markFaceMessage.sbufID;
        if (bArr != null) {
            im_msg_body_marketface.bytes_face_id.set(ByteStringMicro.copyFrom(bArr));
        }
        if (z16 && str != null) {
            im_msg_body_marketface.bytes_face_name.set(ByteStringMicro.copyFromUtf8(str));
        }
        byte[] bArr2 = markFaceMessage.sbfKey;
        if (bArr2 != null) {
            im_msg_body_marketface.bytes_key.set(ByteStringMicro.copyFrom(bArr2));
        }
        im_msg_body_marketface.uint32_face_info.set(markFaceMessage.cFaceInfo);
        im_msg_body_marketface.uint32_item_type.set(markFaceMessage.dwMSGItemType);
        im_msg_body_marketface.uint32_sub_type.set(markFaceMessage.cSubType);
        im_msg_body_marketface.uint32_tab_id.set(markFaceMessage.dwTabID);
        im_msg_body_marketface.uint32_media_type.set(markFaceMessage.mediaType);
        im_msg_body_marketface.uint32_image_width.set(markFaceMessage.imageWidth);
        im_msg_body_marketface.uint32_image_height.set(markFaceMessage.imageHeight);
        byte[] bArr3 = markFaceMessage.mobileparam;
        if (bArr3 != null && bArr3.length > 0) {
            im_msg_body_marketface.bytes_mobileparam.set(ByteStringMicro.copyFrom(bArr3));
        }
        byte[] bArr4 = markFaceMessage.resvAttr;
        if (bArr4 != null && bArr4.length > 0) {
            im_msg_body_marketface.bytes_pb_reserve.set(ByteStringMicro.copyFrom(bArr4));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "encodeMarketFace : mf epid = " + im_msg_body_marketface.uint32_tab_id.get() + " csubtype = " + im_msg_body_marketface.uint32_sub_type.get() + ";mediaType = " + im_msg_body_marketface.uint32_media_type.get());
        }
        im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
        if (str != null) {
            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(str));
        }
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.market_face.set(im_msg_body_marketface);
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
        im_msg_body_elem2.text.set(im_msg_body_text);
        im_msg_body_richtext.elems.add(im_msg_body_elem2);
        return im_msg_body_richtext;
    }

    public static int j(im_msg_body$RichText im_msg_body_richtext, String str, ArrayList<AtTroopMemberInfo> arrayList) {
        return w.k(im_msg_body_richtext, str, arrayList);
    }

    public static im_msg_body$RichText k(MessageForAniSticker messageForAniSticker) {
        im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
        im_msg_body_commonelem.uint32_service_type.set(37);
        im_msg_body_commonelem.uint32_business_type.set(messageForAniSticker.stickerType);
        im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(messageForAniSticker.serializeMsgBody()));
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.common_elem.set(im_msg_body_commonelem);
        String substring = messageForAniSticker.text.substring(1);
        if (TextUtils.isEmpty(substring)) {
            substring = HardCodeUtil.qqStr(R.string.f230186yg);
        }
        ByteStringMicro copyFrom = ByteStringMicro.copyFrom(String.format(HardCodeUtil.qqStr(R.string.f170333yw0), substring).getBytes());
        TextMsgExtPb$ResvAttr textMsgExtPb$ResvAttr = new TextMsgExtPb$ResvAttr();
        textMsgExtPb$ResvAttr.wording.set(copyFrom);
        im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
        im_msg_body_text.bytes_pb_reserve.set(ByteStringMicro.copyFrom(textMsgExtPb$ResvAttr.toByteArray()));
        im_msg_body_text.str.set(ByteStringMicro.copyFrom(messageForAniSticker.text.getBytes()));
        im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
        im_msg_body_elem2.text.set(im_msg_body_text);
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        im_msg_body_richtext.elems.add(im_msg_body_elem2);
        return im_msg_body_richtext;
    }

    public static im_msg_body$RichText l(ChatMessage chatMessage, boolean z16) {
        MessageForArkApp messageForArkApp;
        ArkAppMessage arkAppMessage;
        byte[] pbData;
        byte[] a16;
        im_msg_body$RichText im_msg_body_richtext;
        String str = null;
        if (chatMessage != null && (chatMessage instanceof MessageForArkApp) && (arkAppMessage = (messageForArkApp = (MessageForArkApp) chatMessage).ark_app_message) != null && (pbData = arkAppMessage.toPbData()) != null && pbData.length != 0 && (a16 = com.tencent.mobileqq.structmsg.k.a(pbData)) != null && a16.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(1);
                byteArrayOutputStream.write(a16);
                if (!TextUtils.isEmpty(messageForArkApp.resIDForLongMsg) && !z16) {
                    im_msg_body$RichText im_msg_body_richtext2 = new im_msg_body$RichText();
                    im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                    im_msg_body_elem.general_flags.long_text_flag.set(1);
                    im_msg_body_elem.general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(messageForArkApp.resIDForLongMsg));
                    im_msg_body_richtext2.elems.add(im_msg_body_elem);
                    return im_msg_body_richtext2;
                }
                MessageForStructing messageForStructing = messageForArkApp.ark_app_message.containStructMsg;
                if (messageForStructing != null) {
                    im_msg_body_richtext = y(messageForStructing);
                } else {
                    im_msg_body_richtext = new im_msg_body$RichText();
                    if (!ArkMsgUtils.isMultiMsg(messageForArkApp.ark_app_message)) {
                        if (!TextUtils.isEmpty(messageForArkApp.ark_app_message.compatibleText)) {
                            str = messageForArkApp.ark_app_message.compatibleText;
                        } else {
                            String summery = messageForArkApp.getSummery();
                            if (summery != null && summery.length() != 0) {
                                str = String.format(BaseApplication.getContext().getString(R.string.c2b), summery);
                            } else {
                                str = BaseApplication.getContext().getString(R.string.c2a);
                            }
                        }
                    }
                    if (str != null && str.length() > 0) {
                        im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
                        im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(str));
                        im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
                        im_msg_body_elem2.text.set(im_msg_body_text);
                        im_msg_body_richtext.elems.add(im_msg_body_elem2);
                    }
                }
                im_msg_body$LightAppElem im_msg_body_lightappelem = new im_msg_body$LightAppElem();
                im_msg_body_lightappelem.bytes_data.set(ByteStringMicro.copyFrom(byteArrayOutputStream.toByteArray()));
                im_msg_body$Elem im_msg_body_elem3 = new im_msg_body$Elem();
                im_msg_body_elem3.light_app.set(im_msg_body_lightappelem);
                if (im_msg_body_richtext != null) {
                    im_msg_body_richtext.elems.add(im_msg_body_elem3);
                    return im_msg_body_richtext;
                }
                return im_msg_body_richtext;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static im_msg_body$RichText m(ChatMessage chatMessage, boolean z16) {
        byte[] a16;
        im_msg_body$RichText im_msg_body_richtext = null;
        if (chatMessage == null || !(chatMessage instanceof MessageForArkBabyqReply)) {
            return null;
        }
        MessageForArkBabyqReply messageForArkBabyqReply = (MessageForArkBabyqReply) chatMessage;
        byte[] pbData = messageForArkBabyqReply.toPbData();
        if (pbData != null && pbData.length != 0 && (a16 = com.tencent.mobileqq.structmsg.k.a(pbData)) != null && a16.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 1;
            try {
                byteArrayOutputStream.write(1);
                byteArrayOutputStream.write(a16);
                im_msg_body_richtext = new im_msg_body$RichText();
                if (!TextUtils.isEmpty(messageForArkBabyqReply.resIDForLongMsg) && !z16) {
                    im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                    im_msg_body_elem.general_flags.long_text_flag.set(1);
                    im_msg_body_elem.general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(messageForArkBabyqReply.resIDForLongMsg));
                    im_msg_body_richtext.elems.add(im_msg_body_elem);
                } else {
                    hummer_commelem$MsgElemInfo_servtype19 hummer_commelem_msgeleminfo_servtype19 = new hummer_commelem$MsgElemInfo_servtype19();
                    hummer_commelem_msgeleminfo_servtype19.bytes_data.set(ByteStringMicro.copyFrom(byteArrayOutputStream.toByteArray()));
                    im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
                    im_msg_body_commonelem.uint32_service_type.set(19);
                    im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype19.toByteArray()));
                    PBUInt32Field pBUInt32Field = im_msg_body_commonelem.uint32_business_type;
                    if (!messageForArkBabyqReply.showAsBabyq) {
                        i3 = 2;
                    }
                    pBUInt32Field.set(i3);
                    im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
                    im_msg_body_elem2.common_elem.set(im_msg_body_commonelem);
                    im_msg_body_richtext.elems.add(im_msg_body_elem2);
                    String str = messageForArkBabyqReply.babyqReplyText;
                    if (str != null && str.length() > 0) {
                        im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
                        im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(str));
                        im_msg_body$Elem im_msg_body_elem3 = new im_msg_body$Elem();
                        im_msg_body_elem3.text.set(im_msg_body_text);
                        im_msg_body_richtext.elems.add(im_msg_body_elem3);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return im_msg_body_richtext;
    }

    public static im_msg_body$RichText n(ChatMessage chatMessage) {
        MessageForArkFlashChat messageForArkFlashChat;
        ArkFlashChatMessage arkFlashChatMessage;
        byte[] pbData;
        byte[] a16;
        if (chatMessage != null && (chatMessage instanceof MessageForArkFlashChat) && (arkFlashChatMessage = (messageForArkFlashChat = (MessageForArkFlashChat) chatMessage).ark_app_message) != null && (pbData = arkFlashChatMessage.toPbData()) != null && pbData.length != 0 && (a16 = com.tencent.mobileqq.structmsg.k.a(pbData)) != null && a16.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(1);
                byteArrayOutputStream.write(a16);
                hummer_commelem$MsgElemInfo_servtype14 hummer_commelem_msgeleminfo_servtype14 = new hummer_commelem$MsgElemInfo_servtype14();
                hummer_commelem_msgeleminfo_servtype14.reserve_Info.set(ByteStringMicro.copyFrom(byteArrayOutputStream.toByteArray()));
                hummer_commelem_msgeleminfo_servtype14.uint32_id.set(messageForArkFlashChat.ark_app_message.appResId);
                im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
                im_msg_body_commonelem.uint32_business_type.set(0);
                im_msg_body_commonelem.uint32_service_type.set(14);
                im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype14.toByteArray()));
                im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                im_msg_body_elem.common_elem.set(im_msg_body_commonelem);
                im_msg_body$RichText B = B(s.d(messageForArkFlashChat.getSummery(), true, null), null);
                B.elems.add(im_msg_body_elem);
                return B;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static im_msg_body$RichText o(ChatMessage chatMessage, boolean z16) {
        MessageForArkApp messageForArkApp;
        ArkAppMessage arkAppMessage;
        byte[] pbData;
        byte[] a16;
        im_msg_body$RichText im_msg_body_richtext;
        if (chatMessage != null && (chatMessage instanceof MessageForArkApp) && (arkAppMessage = (messageForArkApp = (MessageForArkApp) chatMessage).ark_app_message) != null && (pbData = arkAppMessage.toPbData()) != null && pbData.length != 0 && (a16 = com.tencent.mobileqq.structmsg.k.a(pbData)) != null && a16.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(1);
                byteArrayOutputStream.write(a16);
                if (!TextUtils.isEmpty(messageForArkApp.resIDForLongMsg) && !z16) {
                    im_msg_body$RichText im_msg_body_richtext2 = new im_msg_body$RichText();
                    im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                    im_msg_body_elem.general_flags.long_text_flag.set(1);
                    im_msg_body_elem.general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(messageForArkApp.resIDForLongMsg));
                    im_msg_body_richtext2.elems.add(im_msg_body_elem);
                    return im_msg_body_richtext2;
                }
                MessageForStructing messageForStructing = messageForArkApp.ark_app_message.containStructMsg;
                if (messageForStructing != null) {
                    im_msg_body_richtext = y(messageForStructing);
                } else {
                    im_msg_body_richtext = new im_msg_body$RichText();
                    String str = messageForArkApp.ark_app_message.compatibleText;
                    if (str == null) {
                        String summery = messageForArkApp.getSummery();
                        if (summery != null && summery.length() != 0) {
                            str = String.format(BaseApplication.getContext().getString(R.string.c2b), summery);
                        } else {
                            str = BaseApplication.getContext().getString(R.string.c2a);
                        }
                    }
                    if (str != null && str.length() > 0) {
                        im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
                        im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(str));
                        im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
                        im_msg_body_elem2.text.set(im_msg_body_text);
                        im_msg_body_richtext.elems.add(im_msg_body_elem2);
                    }
                }
                hummer_commelem$MsgElemInfo_servtype20 hummer_commelem_msgeleminfo_servtype20 = new hummer_commelem$MsgElemInfo_servtype20();
                hummer_commelem_msgeleminfo_servtype20.bytes_data.set(ByteStringMicro.copyFrom(byteArrayOutputStream.toByteArray()));
                im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
                im_msg_body_commonelem.uint32_service_type.set(20);
                im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype20.toByteArray()));
                im_msg_body_commonelem.uint32_business_type.set("1".equals(chatMessage.getExtInfoFromExtStr(i.f286262e)) ? 1 : 0);
                im_msg_body$Elem im_msg_body_elem3 = new im_msg_body$Elem();
                im_msg_body_elem3.common_elem.set(im_msg_body_commonelem);
                if (im_msg_body_richtext != null) {
                    im_msg_body_richtext.elems.add(im_msg_body_elem3);
                }
                return im_msg_body_richtext;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static im_msg_body$RichText p(ChatMessage chatMessage) {
        int i3;
        if (chatMessage != null && (chatMessage instanceof MessageForLimitChatConfirm)) {
            MessageForLimitChatConfirm messageForLimitChatConfirm = (MessageForLimitChatConfirm) chatMessage;
            im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
            im_msg_body_commonelem.uint32_service_type.set(24);
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            hummer_commelem$MsgElemInfo_servtype24 hummer_commelem_msgeleminfo_servtype24 = new hummer_commelem$MsgElemInfo_servtype24();
            if (messageForLimitChatConfirm.bEnterMsg) {
                hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.bytes_match_nick.set(ByteStringMicro.copyFromUtf8(messageForLimitChatConfirm.SenderNickName));
                hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(messageForLimitChatConfirm.tipsWording));
                hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.uint32_left_chat_time.set(messageForLimitChatConfirm.leftChatTime);
                hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.uint32_c2c_expired_time.set(messageForLimitChatConfirm.c2cExpiredTime);
                hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.uint32_match_expired_time.set(messageForLimitChatConfirm.matchExpiredTime);
                hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.uint64_match_ts.set(messageForLimitChatConfirm.timeStamp);
                hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.uint64_ready_ts.set(messageForLimitChatConfirm.readyTs);
                hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.setHasFlag(true);
            } else {
                hummer_commelem_msgeleminfo_servtype24.limit_chat_exit.uint32_exit_method.set(messageForLimitChatConfirm.leaveChatType);
                hummer_commelem_msgeleminfo_servtype24.limit_chat_exit.uint64_match_ts.set(messageForLimitChatConfirm.timeStamp);
                hummer_commelem_msgeleminfo_servtype24.limit_chat_exit.setHasFlag(true);
            }
            if (messageForLimitChatConfirm.bEnterMsg) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            im_msg_body_commonelem.uint32_business_type.set(i3, true);
            im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype24.toByteArray()), true);
            im_msg_body_elem.common_elem.set(im_msg_body_commonelem, true);
            im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
            im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.qqStr(R.string.o3_)));
            im_msg_body_elem2.text.set(im_msg_body_text);
            im_msg_body_elem2.text.setHasFlag(true);
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body_richtext.elems.add(im_msg_body_elem2);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            if (QLog.isColorLevel()) {
                QLog.d("LimitChat", 2, "getSendLimitChatConfirmMsgBody");
            }
            return im_msg_body_richtext;
        }
        return null;
    }

    public static im_msg_body$RichText q(MessageForLongTextMsg messageForLongTextMsg, boolean z16) {
        byte[] xmlBytes;
        if (messageForLongTextMsg == null) {
            return null;
        }
        if (z16) {
            StructMsgForGeneralShare structMsgForGeneralShare = messageForLongTextMsg.structingMsg;
            if (structMsgForGeneralShare == null || (xmlBytes = structMsgForGeneralShare.getXmlBytes()) == null) {
                return null;
            }
            im_msg_body$RichMsg im_msg_body_richmsg = new im_msg_body$RichMsg();
            im_msg_body_richmsg.bytes_template_1.set(ByteStringMicro.copyFrom(xmlBytes));
            im_msg_body_richmsg.uint32_service_id.set(messageForLongTextMsg.structingMsg.mMsgServiceID);
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body_elem.rich_msg.set(im_msg_body_richmsg);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            if (!TextUtils.isEmpty(messageForLongTextMsg.structingMsg.mCompatibleText)) {
                im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
                im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
                im_msg_body_text.str.set(ByteStringMicro.copyFrom(messageForLongTextMsg.structingMsg.mCompatibleText.getBytes()));
                im_msg_body_elem2.text.set(im_msg_body_text);
                im_msg_body_richtext.elems.add(im_msg_body_elem2);
                return im_msg_body_richtext;
            }
            return im_msg_body_richtext;
        }
        im_msg_body$RichText B = B(messageForLongTextMsg.f203106msg, messageForLongTextMsg.atInfoList);
        im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
        im_msg_body_generalflags.long_text_flag.set(2);
        im_msg_body$Elem im_msg_body_elem3 = new im_msg_body$Elem();
        im_msg_body_elem3.general_flags.set(im_msg_body_generalflags);
        B.elems.add(im_msg_body_elem3);
        return B;
    }

    public static im_msg_body$RichText r(MessageForMarketFace messageForMarketFace) {
        MarkFaceMessage markFaceMessage;
        String str;
        boolean z16;
        if (messageForMarketFace != null && (markFaceMessage = messageForMarketFace.mMarkFaceMessage) != null) {
            if (TextUtils.isEmpty(markFaceMessage.faceName)) {
                str = HardCodeUtil.qqStr(R.string.o37);
            } else {
                str = "[" + messageForMarketFace.mMarkFaceMessage.faceName + "]";
            }
            if (messageForMarketFace.istroop == 3000) {
                z16 = false;
            } else {
                z16 = true;
            }
            return i(messageForMarketFace.mMarkFaceMessage, str, z16);
        }
        return null;
    }

    public static im_msg_body$RichText s(MessageForMixedMsg messageForMixedMsg) {
        im_msg_body$RichText z16;
        if (messageForMixedMsg == null) {
            return null;
        }
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        int size = messageForMixedMsg.msgElemList.size();
        for (int i3 = 0; i3 < size; i3++) {
            MessageRecord messageRecord = messageForMixedMsg.msgElemList.get(i3);
            if (messageRecord instanceof MessageForText) {
                im_msg_body$RichText A = A((MessageForText) messageRecord);
                if (A == null) {
                    return null;
                }
                for (int i16 = 0; i16 < A.elems.size(); i16++) {
                    im_msg_body_richtext.elems.add(A.elems.get(i16));
                }
            } else if (messageRecord instanceof MessageForRichText) {
                im_msg_body$RichText im_msg_body_richtext2 = ((MessageForPic) messageRecord).richText;
                if (im_msg_body_richtext2 == null) {
                    return null;
                }
                im_msg_body_richtext.elems.add(im_msg_body_richtext2.elems.get(0));
            } else if ((messageRecord instanceof MessageForReplyText) && (z16 = z((MessageForReplyText) messageRecord)) != null) {
                for (int i17 = 0; i17 < z16.elems.size(); i17++) {
                    im_msg_body_richtext.elems.add(z16.elems.get(i17));
                }
            }
        }
        return im_msg_body_richtext;
    }

    public static im_msg_body$RichText t(ChatMessage chatMessage) {
        if (chatMessage != null && (chatMessage instanceof MessageForRichText)) {
            return ((MessageForRichText) chatMessage).richText;
        }
        return null;
    }

    public static im_msg_body$RichText u(ChatMessage chatMessage) {
        String format;
        String str;
        String str2;
        String str3;
        im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
        im_msg_body_commonelem.uint32_service_type.set(23);
        String qqStr = HardCodeUtil.qqStr(R.string.o3d);
        String str4 = "";
        if (chatMessage instanceof MessageForPokeEmo) {
            hummer_commelem$MsgElemInfo_servtype23 hummer_commelem_msgeleminfo_servtype23 = new hummer_commelem$MsgElemInfo_servtype23();
            MessageForPokeEmo messageForPokeEmo = (MessageForPokeEmo) chatMessage;
            int i3 = messageForPokeEmo.pokeemoId;
            int i16 = messageForPokeEmo.pokeemoPressCount;
            String str5 = messageForPokeEmo.summary;
            if (i3 == 13 && messageForPokeEmo.emoIndex >= 0) {
                hummer_commelem$MsgElemInfo_servtype33 hummer_commelem_msgeleminfo_servtype33 = new hummer_commelem$MsgElemInfo_servtype33();
                hummer_commelem_msgeleminfo_servtype33.uint32_index.set(messageForPokeEmo.emoIndex);
                str = QQSysFaceUtil.getPrueFaceDescription(QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.convertToLocal(messageForPokeEmo.emoIndex)));
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                hummer_commelem_msgeleminfo_servtype33.bytes_text.set(ByteStringMicro.copyFromUtf8(str2));
                if (str == null) {
                    str3 = "";
                } else {
                    str3 = str;
                }
                hummer_commelem_msgeleminfo_servtype33.bytes_compat.set(ByteStringMicro.copyFromUtf8(str3));
                hummer_commelem_msgeleminfo_servtype23.msg_yellow_face.set(hummer_commelem_msgeleminfo_servtype33);
                format = String.format("[%s]x%d", str, Integer.valueOf(i16));
            } else {
                format = String.format("[%s]x%d", str5, Integer.valueOf(i16));
                str = str5;
            }
            hummer_commelem_msgeleminfo_servtype23.uint32_face_type.set(i3);
            hummer_commelem_msgeleminfo_servtype23.uint32_face_bubble_count.set(i16);
            PBBytesField pBBytesField = hummer_commelem_msgeleminfo_servtype23.bytes_face_summary;
            if (str != null) {
                str4 = str;
            }
            pBBytesField.set(ByteStringMicro.copyFromUtf8(str4));
            im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype23.toByteArray()));
            im_msg_body_commonelem.uint32_business_type.set(i3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "getSendPokeEmoMsgBody pokeemoId:" + i3 + " ,pokeemoPressCount:" + i16);
            }
            qqStr = str;
            str4 = format;
        }
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.common_elem.set(im_msg_body_commonelem);
        String format2 = String.format("[%s]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u624b\u673aQQ\u4f53\u9a8c\u65b0\u529f\u80fd\u3002", qqStr);
        im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
        im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(str4));
        TextMsgExtPb$ResvAttr textMsgExtPb$ResvAttr = new TextMsgExtPb$ResvAttr();
        textMsgExtPb$ResvAttr.wording.set(ByteStringMicro.copyFromUtf8(format2));
        im_msg_body_text.bytes_pb_reserve.set(ByteStringMicro.copyFrom(textMsgExtPb$ResvAttr.toByteArray()));
        im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
        im_msg_body_elem2.text.set(im_msg_body_text);
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        im_msg_body_richtext.elems.add(im_msg_body_elem2);
        if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
        }
        return im_msg_body_richtext;
    }

    public static im_msg_body$RichText v(ChatMessage chatMessage) {
        im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
        im_msg_body_commonelem.uint32_service_type.set(2);
        if (chatMessage instanceof MessageForPoke) {
            hummer_commelem$MsgElemInfo_servtype2 hummer_commelem_msgeleminfo_servtype2 = new hummer_commelem$MsgElemInfo_servtype2();
            MessageForPoke messageForPoke = (MessageForPoke) chatMessage;
            int i3 = messageForPoke.interactType;
            int i16 = messageForPoke.doubleHitState;
            int i17 = messageForPoke.strength;
            hummer_commelem_msgeleminfo_servtype2.uint32_poke_type.set(i3);
            hummer_commelem_msgeleminfo_servtype2.uint32_double_hit.set(i16);
            hummer_commelem_msgeleminfo_servtype2.uint32_vaspoke_id.set(messageForPoke.subId);
            hummer_commelem_msgeleminfo_servtype2.bytes_vaspoke_name.set(ByteStringMicro.copyFromUtf8(messageForPoke.name));
            hummer_commelem_msgeleminfo_servtype2.bytes_vaspoke_minver.set(ByteStringMicro.copyFromUtf8(messageForPoke.minVersion));
            hummer_commelem_msgeleminfo_servtype2.uint32_poke_strength.set(i17);
            hummer_commelem_msgeleminfo_servtype2.uint32_poke_flag.set(messageForPoke.flag);
            im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype2.toByteArray()));
            im_msg_body_commonelem.uint32_business_type.set(i3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "getSendPokeMsgBody type:" + i3 + " ,doubleHitState:" + i16);
            }
        }
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.common_elem.set(im_msg_body_commonelem);
        String qqStr = HardCodeUtil.qqStr(R.string.o39);
        im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
        im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(qqStr));
        im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
        im_msg_body_elem2.text.set(im_msg_body_text);
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        im_msg_body_richtext.elems.add(im_msg_body_elem2);
        if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
        }
        return im_msg_body_richtext;
    }

    public static im_msg_body$RichText w(ChatMessage chatMessage) {
        if (chatMessage != null && (chatMessage instanceof MessageForScribble)) {
            MessageForScribble messageForScribble = (MessageForScribble) chatMessage;
            im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
            im_msg_body_commonelem.uint32_service_type.set(11);
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            hummer_commelem$MsgElemInfo_servtype11 hummer_commelem_msgeleminfo_servtype11 = new hummer_commelem$MsgElemInfo_servtype11();
            hummer_commelem_msgeleminfo_servtype11.bytes_Doodle_url.set(ByteStringMicro.copyFromUtf8(messageForScribble.combineFileUrl));
            hummer_commelem_msgeleminfo_servtype11.bytes_Doodle_md5.set(ByteStringMicro.copyFromUtf8(messageForScribble.combineFileMd5));
            hummer_commelem_msgeleminfo_servtype11.uint32_doodleData_offset.set(messageForScribble.offSet);
            hummer_commelem_msgeleminfo_servtype11.uint32_doodle_gif_id.set(messageForScribble.gifId);
            im_msg_body_commonelem.uint32_business_type.set(1);
            im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype11.toByteArray()));
            im_msg_body_elem.common_elem.set(im_msg_body_commonelem);
            im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
            im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.qqStr(R.string.o36)));
            im_msg_body_elem2.text.set(im_msg_body_text);
            im_msg_body_elem2.text.setHasFlag(true);
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body_richtext.elems.add(im_msg_body_elem2);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            if (QLog.isColorLevel()) {
                QLog.d("pap", 2, "getSendPapScribeMsgBody");
            }
            return im_msg_body_richtext;
        }
        return null;
    }

    public static im_msg_body$RichText x(MessageForShakeWindow messageForShakeWindow) {
        if (messageForShakeWindow != null && messageForShakeWindow.mShakeWindowMsg != null) {
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body$ShakeWindow im_msg_body_shakewindow = new im_msg_body$ShakeWindow();
            im_msg_body_shakewindow.uint32_type.set(messageForShakeWindow.mShakeWindowMsg.mType);
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body_elem.shake_window.set(im_msg_body_shakewindow);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            return im_msg_body_richtext;
        }
        return null;
    }

    public static im_msg_body$RichText y(MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg;
        List<AbsStructMsgElement> structMsgItemLists;
        ArrayList<AbsStructMsgElement> arrayList;
        if (messageForStructing == null || (absStructMsg = messageForStructing.structingMsg) == null) {
            return null;
        }
        im_msg_body$RichText im_msg_body_richtext = messageForStructing.richText;
        if (im_msg_body_richtext != null) {
            return im_msg_body_richtext;
        }
        byte[] xmlBytes = absStructMsg.getXmlBytes();
        if (xmlBytes == null) {
            return null;
        }
        AbsStructMsg absStructMsg2 = messageForStructing.structingMsg;
        int i3 = absStructMsg2.mMsgServiceID;
        if ((i3 == 83 || i3 == 108 || i3 == 114 || i3 == 116 || i3 == 151 || i3 == 156) && !TextUtils.isEmpty(absStructMsg2.mMsgActionData)) {
            AbsStructMsg absStructMsg3 = messageForStructing.structingMsg;
            String str = absStructMsg3.mMsgActionData;
            absStructMsg3.mMsgActionData = h(str);
            byte[] xmlBytes2 = messageForStructing.structingMsg.getXmlBytes();
            messageForStructing.structingMsg.mMsgActionData = str;
            xmlBytes = xmlBytes2;
        }
        im_msg_body$RichMsg im_msg_body_richmsg = new im_msg_body$RichMsg();
        im_msg_body_richmsg.bytes_template_1.set(ByteStringMicro.copyFrom(xmlBytes));
        im_msg_body_richmsg.uint32_service_id.set(messageForStructing.structingMsg.mMsgServiceID);
        AbsStructMsg absStructMsg4 = messageForStructing.structingMsg;
        if ((absStructMsg4 instanceof AbsShareMsg) && (structMsgItemLists = ((AbsShareMsg) absStructMsg4).getStructMsgItemLists()) != null) {
            for (AbsStructMsgElement absStructMsgElement : structMsgItemLists) {
                if ((absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a) && (arrayList = ((com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0) != null) {
                    Iterator<AbsStructMsgElement> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            AbsStructMsgElement next = it.next();
                            if (next instanceof StructMsgItemVideo) {
                                if (((StructMsgItemVideo) next).v()) {
                                    im_msg_body_richmsg.uint32_flags.set(4);
                                } else {
                                    im_msg_body_richmsg.uint32_flags.set(2);
                                }
                            }
                        }
                    }
                }
            }
        }
        im_msg_body$RichText im_msg_body_richtext2 = new im_msg_body$RichText();
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.rich_msg.set(im_msg_body_richmsg);
        im_msg_body_richtext2.elems.add(im_msg_body_elem);
        if (TextUtils.isEmpty(messageForStructing.structingMsg.mCompatibleText)) {
            AbsStructMsg absStructMsg5 = messageForStructing.structingMsg;
            absStructMsg5.mCompatibleText = absStructMsg5.mMsgUrl;
        }
        if (!TextUtils.isEmpty(messageForStructing.structingMsg.mCompatibleText)) {
            im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
            im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
            im_msg_body_text.str.set(ByteStringMicro.copyFrom(messageForStructing.structingMsg.mCompatibleText.getBytes()));
            im_msg_body_elem2.text.set(im_msg_body_text);
            im_msg_body_richtext2.elems.add(im_msg_body_elem2);
        }
        return im_msg_body_richtext2;
    }

    public static im_msg_body$RichText z(MessageForReplyText messageForReplyText) {
        String extInfoFromExtStr = messageForReplyText.getExtInfoFromExtStr("sens_msg_source_msg_info");
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                extInfoFromExtStr = HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(messageForReplyText.mSourceMsgInfo));
                if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                    messageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", extInfoFromExtStr);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, QLog.getStackTraceString(e16));
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.MSG, 2, "getSourceMsgInfo data = " + extInfoFromExtStr + ", mSourceMsgInfo = " + messageForReplyText.mSourceMsgInfo);
        }
        return C(messageForReplyText);
    }
}
