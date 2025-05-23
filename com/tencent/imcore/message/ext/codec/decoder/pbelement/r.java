package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.group_pro_proto.msgpush.servtype$CommGrayTips;
import tencent.im.group_pro_proto.msgpush.servtype$EventBody;
import tencent.im.group_pro_proto.msgpush.servtype$UpdateMsg;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class r extends af {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f116627a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f116627a = "GuildSysMsgElemDecoder";
        }
    }

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(servtype$CommGrayTips servtype_commgraytips, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        long j3;
        String str;
        byte[] bArr;
        Object valueOf;
        String str2;
        long longValue = ((Long) aVar.a(2)).longValue();
        boolean booleanValue = ((Boolean) aVar.a(3)).booleanValue();
        long j16 = servtype_commgraytips.uint64_busi_type.get();
        long j17 = servtype_commgraytips.uint64_busi_id.get();
        long j18 = servtype_commgraytips.uint64_templ_id.get();
        long j19 = servtype_commgraytips.uint64_tips_seq_id.get();
        int i3 = servtype_commgraytips.uint32_ctrl_flag.get();
        String obj = servtype_commgraytips.bytes_pb_reserv.get().toString();
        QQAppInterface qQAppInterface = null;
        if (servtype_commgraytips.bytes_content.has()) {
            j3 = longValue;
            str = obj;
            bArr = servtype_commgraytips.bytes_content.get().toByteArray();
        } else {
            j3 = longValue;
            str = obj;
            bArr = null;
        }
        if (bArr != null && bArr.length > 0) {
            try {
                str2 = new String(bArr, "utf-8");
            } catch (Exception e16) {
                QLog.e(f116627a, 1, "decodeGrayTips fail! content is null. grayTips.bytes_content.has(): , bytes size: " + bArr.length + ", exception: " + e16.toString());
            }
            IGuildUniteGrayTipUtilApi iGuildUniteGrayTipUtilApi = (IGuildUniteGrayTipUtilApi) QRoute.api(IGuildUniteGrayTipUtilApi.class);
            String templParamsJson = iGuildUniteGrayTipUtilApi.getTemplParamsJson(servtype_commgraytips.rpt_msg_templ_param.get());
            int msgType = iGuildUniteGrayTipUtilApi.getMsgType(i3, booleanValue);
            QLog.i(f116627a, 1, "decodeGrayTips. content: " + str2 + ", msgtype: " + msgType + ", uint32_ctrl_flag: " + i3 + ", uint64_busi_type:" + j16 + ", uint64_busi_id: " + j17 + ", uint64_templ_id: " + j18 + ", tipSeqId: " + j19);
            if (aVar.a(1) instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) aVar.a(1);
            }
            if (qQAppInterface != null) {
                QLog.e(f116627a, 1, "decodeGrayTips fail! app is null");
                return false;
            }
            String str3 = str;
            MessageForUniteGrayTip createUniteGrayTip = iGuildUniteGrayTipUtilApi.createUniteGrayTip(qQAppInterface, String.valueOf(aVar.f286338a), String.valueOf(aVar.f286169x), 10014, msgType, j3, str2);
            if (createUniteGrayTip != null) {
                createUniteGrayTip.saveExtInfoToExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_BUSI_TYPE, String.valueOf(j16));
                createUniteGrayTip.saveExtInfoToExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_BUSI_ID, String.valueOf(j17));
                createUniteGrayTip.saveExtInfoToExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_TEMPL_ID, String.valueOf(j18));
                createUniteGrayTip.saveExtInfoToExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_CONTENT, str2);
                createUniteGrayTip.saveExtInfoToExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_SEQ_ID, String.valueOf(j19));
                createUniteGrayTip.tipParam.f213693p = String.valueOf(j19);
                createUniteGrayTip.saveExtInfoToExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_TEMPL_PARAM, templParamsJson);
                createUniteGrayTip.saveExtInfoToExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_RESERVE_DATA, str3);
                list.add(createUniteGrayTip);
                return true;
            }
            QLog.e(f116627a, 1, "decodeGrayTips.FAILED");
            return true;
        }
        String str4 = f116627a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("decodeGrayTips fail! content is null. grayTips.bytes_content.has(): ");
        sb5.append(servtype_commgraytips.bytes_content.has());
        sb5.append(", bytes size: ");
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        QLog.e(str4, 1, sb5.toString());
        str2 = "";
        IGuildUniteGrayTipUtilApi iGuildUniteGrayTipUtilApi2 = (IGuildUniteGrayTipUtilApi) QRoute.api(IGuildUniteGrayTipUtilApi.class);
        String templParamsJson2 = iGuildUniteGrayTipUtilApi2.getTemplParamsJson(servtype_commgraytips.rpt_msg_templ_param.get());
        int msgType2 = iGuildUniteGrayTipUtilApi2.getMsgType(i3, booleanValue);
        QLog.i(f116627a, 1, "decodeGrayTips. content: " + str2 + ", msgtype: " + msgType2 + ", uint32_ctrl_flag: " + i3 + ", uint64_busi_type:" + j16 + ", uint64_busi_id: " + j17 + ", uint64_templ_id: " + j18 + ", tipSeqId: " + j19);
        if (aVar.a(1) instanceof QQAppInterface) {
        }
        if (qQAppInterface != null) {
        }
    }

    private boolean e(servtype$UpdateMsg servtype_updatemsg, List<MessageRecord> list) {
        if (servtype_updatemsg.uint64_msg_seq.has()) {
            MessageRecord messageRecord = new MessageRecord();
            messageRecord.msgtype = -2006;
            list.add(messageRecord);
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        if (aVar.f286163r != 10014) {
            return false;
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.common_elem.has()) {
                    im_msg_body_commonelem = next.common_elem.get();
                    break;
                }
            } else {
                im_msg_body_commonelem = null;
                break;
            }
        }
        if (im_msg_body_commonelem == null || 500 != im_msg_body_commonelem.uint32_service_type.get()) {
            return false;
        }
        servtype$EventBody servtype_eventbody = new servtype$EventBody();
        try {
            servtype_eventbody.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            if (servtype_eventbody.msg_update_msg.has()) {
                return e(servtype_eventbody.msg_update_msg.get(), list2);
            }
            if (servtype_eventbody.msg_comm_gray_tips.has()) {
                return d(servtype_eventbody.msg_comm_gray_tips.get(), list2, aVar);
            }
            if (!servtype_eventbody.msg_app_channel.has() && !servtype_eventbody.weak_msg_app_channel.has()) {
                return false;
            }
            return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).decodeAppChannelMsg(servtype_eventbody, list2, msg_comm_msg, aVar);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(f116627a, 1, "decodeGrayTips fail! " + e16.toString());
            return false;
        }
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        if (im_msg_body_elem.common_elem.has() && im_msg_body_elem.common_elem.get().uint32_service_type.get() == 500) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1000;
    }
}
