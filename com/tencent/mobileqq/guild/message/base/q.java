package com.tencent.mobileqq.guild.message.base;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.guild.message.pbdecoder.GuildMsgHeadClientIdentityDecoder;
import com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.cn;
import com.tencent.mobileqq.qqguildsdk.data.e;
import com.tencent.mobileqq.qqguildsdk.data.fi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService;
import com.tencent.mobileqq.service.message.w;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import localpb.richMsg.SafeMsg$SafeMoreInfo;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import tencent.im.group_pro_proto.common.common$ContentHead;
import tencent.im.group_pro_proto.common.common$Event;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.common.common$MsgMeta;
import tencent.im.group_pro_proto.common.common$RoutingHead;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$ExtraInfo;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes14.dex */
public class q implements s {

    /* renamed from: a, reason: collision with root package name */
    protected AppInterface f230314a;

    /* renamed from: b, reason: collision with root package name */
    protected Comparator f230315b = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Comparator<MessageRecord> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageRecord messageRecord, MessageRecord messageRecord2) {
            return (int) (messageRecord.shmsgseq - messageRecord2.shmsgseq);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f230317a;

        /* renamed from: b, reason: collision with root package name */
        String f230318b;

        /* renamed from: c, reason: collision with root package name */
        String f230319c;

        /* renamed from: d, reason: collision with root package name */
        int f230320d;

        /* renamed from: e, reason: collision with root package name */
        String f230321e;

        /* renamed from: f, reason: collision with root package name */
        String f230322f;

        /* renamed from: g, reason: collision with root package name */
        String f230323g;

        /* renamed from: h, reason: collision with root package name */
        String f230324h;

        /* renamed from: i, reason: collision with root package name */
        String f230325i;

        /* renamed from: j, reason: collision with root package name */
        IGProClientIdentityInfo f230326j;

        /* renamed from: k, reason: collision with root package name */
        long f230327k;

        b() {
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("guildId: ");
            String str = this.f230317a;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            sb5.append(str);
            sb5.append(", channelId: ");
            String str3 = this.f230318b;
            if (str3 == null) {
                str3 = "";
            }
            sb5.append(str3);
            sb5.append(", tinyId: ");
            String str4 = this.f230319c;
            if (str4 == null) {
                str4 = "";
            }
            sb5.append(str4);
            sb5.append(", roleType: ");
            sb5.append(this.f230320d);
            sb5.append(", guildRoleId: ");
            String str5 = this.f230321e;
            if (str5 == null) {
                str5 = "";
            }
            sb5.append(str5);
            sb5.append(", channelRoleId: ");
            String str6 = this.f230322f;
            if (str6 == null) {
                str6 = "";
            }
            sb5.append(str6);
            sb5.append(", nickName: ");
            String str7 = this.f230323g;
            if (str7 == null) {
                str7 = "";
            }
            sb5.append(str7);
            sb5.append(", memberName: ");
            String str8 = this.f230324h;
            if (str8 == null) {
                str8 = "";
            }
            sb5.append(str8);
            sb5.append(", avatarMeta: ");
            String str9 = this.f230325i;
            if (str9 != null) {
                str2 = str9;
            }
            sb5.append(str2);
            sb5.append(", timestamp: ");
            sb5.append(this.f230327k);
            sb5.append(", clientIdentity: ");
            IGProClientIdentityInfo iGProClientIdentityInfo = this.f230326j;
            if (iGProClientIdentityInfo != null) {
                sb5.append(iGProClientIdentityInfo.toString());
            }
            return sb5.toString();
        }
    }

    public q(AppInterface appInterface) {
        this.f230314a = appInterface;
    }

    private void C(IGPSService iGPSService, String str, int i3, common$Msg common_msg) {
        int finalMsgNotify;
        Object obj;
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str);
        if (channelInfo != null && (finalMsgNotify = channelInfo.getFinalMsgNotify()) != i3) {
            common$ContentHead common_contenthead = common_msg.head.content_head.get();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("syncGuildMsgPrintLog channelId: ");
            sb5.append(str);
            sb5.append(", currentNotifyType:");
            sb5.append(finalMsgNotify);
            sb5.append(", newNotifyType: ");
            sb5.append(i3);
            sb5.append(", shmsgseq: ");
            if (common_contenthead != null) {
                obj = Long.valueOf(common_contenthead.msg_seq.get());
            } else {
                obj = "";
            }
            sb5.append(obj);
            QLog.i("BaseGuildMessageProcessor", 1, sb5.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(ArrayList<MessageRecord> arrayList, common$Msg common_msg, long j3, String str, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.troop.data.c cVar2, im_msg_body$RichText im_msg_body_richtext, long j16) {
        boolean z16;
        String str2;
        String str3;
        String str4;
        common$ContentHead common_contenthead;
        b bVar;
        long j17;
        String str5;
        int i3;
        String str6;
        boolean z17;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        long j18;
        int i16;
        String str12;
        long j19;
        String str13;
        String str14;
        String str15 = ", channelId: ";
        String str16 = ", extstr: ";
        String str17 = "BaseGuildMessageProcessor";
        common$ContentHead common_contenthead2 = common_msg.head.content_head.get();
        common$RoutingHead common_routinghead = common_msg.head.routing_head.get();
        Iterator<MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            next.msgUid = j3;
            next.time = common_contenthead2.msg_time.get();
            next.msgseq = common_contenthead2.msg_time.get();
            next.shmsgseq = common_contenthead2.msg_seq.get();
            next.selfuin = str;
            next.istroop = 10014;
            next.senderuin = String.valueOf(common_routinghead.from_tinyid.get());
            next.frienduin = String.valueOf(common_routinghead.channel_id.get());
            next.longMsgId = 0;
            next.longMsgCount = 0;
            next.longMsgIndex = 0;
            next.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_CNT_NAME, String.valueOf(common_contenthead2.cnt_seq.get()));
            next.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_TYPE, String.valueOf(common_contenthead2.msg_type.get()));
            if (common_routinghead.direct_message_flag.get() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            su1.c.e(next, z16);
            su1.c.f(next, String.valueOf(common_routinghead.guild_id.get()));
            IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
            byte[] byteArray = common_contenthead2.msg_meta.get().toByteArray();
            iGuildMessageUtilsApi.saveMsgMetaToMr(next, byteArray);
            Iterator<MessageRecord> it5 = it;
            common$MsgMeta common_msgmeta = new common$MsgMeta();
            try {
                common_msgmeta.mergeFrom(byteArray);
                QLog.i(str17, 2, "msg_meta has() = " + common_contenthead2.msg_meta.has() + ", atAllSeq: " + common_msgmeta.at_all_seq.get());
            } catch (Exception unused) {
                QLog.e(str17, 1, "msg_meta merge exception! decodeMsg, MR: " + next.toString() + str16 + next.extStr + str15 + next.frienduin);
            }
            if (common_msg.ext_info.has()) {
                if (common_msg.ext_info.visibility.has() && !s(common_msg.ext_info.visibility.get())) {
                    next.msgtype = -2006;
                }
                if (common_msg.ext_info.from_nick.has()) {
                    next.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_FROM_NICK, common_msg.ext_info.from_nick.get().toStringUtf8());
                } else {
                    QLog.e(str17, 2, "from_nick is empty!! decodeMsg, MR: " + next.toString() + str16 + next.extStr + str15 + next.frienduin);
                }
                if (common_msg.ext_info.offline_flag.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    str7 = "1";
                } else {
                    str7 = "0";
                }
                next.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, str7);
                if (!common_msg.ext_info.bytes_member_name.has()) {
                    str8 = "";
                } else {
                    str8 = common_msg.ext_info.bytes_member_name.get().toStringUtf8();
                    next.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_GUILD_MEMBER_NAME, common_msg.ext_info.bytes_member_name.get().toStringUtf8());
                }
                if (common_msg.ext_info.uint32_timestamp.has()) {
                    long j26 = common_msg.ext_info.uint32_timestamp.get();
                    str9 = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNickNameFromMR(next);
                    str10 = next.getExtInfoFromExtStr(IGuildMessageUtilsApi.GUILD_ID_EXT_STR);
                    str11 = next.senderuin;
                    j18 = j26 * 1000;
                    common_contenthead = common_contenthead2;
                } else {
                    common_contenthead = common_contenthead2;
                    str9 = "";
                    str10 = str9;
                    str11 = str10;
                    j18 = 0;
                }
                int i17 = common_msg.ext_info.role_type.get();
                if (common_msg.ext_info.role_type.has()) {
                    i16 = common_msg.ext_info.role_type.get();
                    str2 = str15;
                    str3 = str16;
                    next.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_FROM_ROLE_TYPE, String.valueOf(i16));
                } else {
                    str2 = str15;
                    str3 = str16;
                    i16 = i17;
                }
                if (common_msg.ext_info.from_guild_role_info.has()) {
                    str4 = str17;
                    if (common_msg.ext_info.from_guild_role_info.flag.get() == 1) {
                        String valueOf = String.valueOf(common_msg.ext_info.from_guild_role_info.f435943id.get());
                        next.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_FROM_ROLE_INFO, new qu1.a(common_msg.ext_info.from_guild_role_info.get()).a());
                        str12 = valueOf;
                        if (!common_msg.ext_info.from_channel_role_info.has()) {
                            j19 = j18;
                            if (common_msg.ext_info.from_channel_role_info.flag.get() == 1) {
                                str13 = String.valueOf(common_msg.ext_info.from_channel_role_info.f435943id.get());
                                next.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_FROM_CHANNEL_ROLE_ID, str13);
                                if (i16 == 1 && common_msg.ext_info.from_channel_role_info.info.has()) {
                                    next.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_FROM_ROLE_INFO, new qu1.a(common_msg.ext_info.from_channel_role_info.get()).a());
                                }
                                if (common_msg.ext_info.freq_limit_info.has()) {
                                    String selfTinyId = ((IGPSService) this.f230314a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
                                    String str18 = next.senderuin;
                                    if (str18 != null && str18.equalsIgnoreCase(selfTinyId) && !iGuildMessageUtilsApi.isSysMsg(next)) {
                                        ((IGuildSlowModeService) this.f230314a.getRuntimeService(IGuildSlowModeService.class, "")).handleSlowModeFreqLimit(common_msg.ext_info.freq_limit_info.get(), next.frienduin);
                                    }
                                }
                                common_msg.ext_info.direct_message_member.size();
                                if (!common_msg.ext_info.from_avatar.has()) {
                                    str14 = "";
                                } else {
                                    str14 = common_msg.ext_info.from_avatar.get().toStringUtf8();
                                }
                                IGProClientIdentityInfo a16 = new GuildMsgHeadClientIdentityDecoder(this.f230314a).a(next, common_msg);
                                bVar = new b();
                                bVar.f230317a = str10;
                                bVar.f230318b = String.valueOf(common_routinghead.channel_id.get());
                                bVar.f230319c = str11;
                                bVar.f230320d = i16;
                                bVar.f230322f = str13;
                                bVar.f230321e = str12;
                                bVar.f230323g = str9;
                                bVar.f230324h = str8;
                                bVar.f230325i = str14;
                                bVar.f230326j = a16;
                                bVar.f230327k = j19;
                            }
                        } else {
                            j19 = j18;
                        }
                        str13 = "";
                        if (common_msg.ext_info.freq_limit_info.has()) {
                        }
                        common_msg.ext_info.direct_message_member.size();
                        if (!common_msg.ext_info.from_avatar.has()) {
                        }
                        IGProClientIdentityInfo a162 = new GuildMsgHeadClientIdentityDecoder(this.f230314a).a(next, common_msg);
                        bVar = new b();
                        bVar.f230317a = str10;
                        bVar.f230318b = String.valueOf(common_routinghead.channel_id.get());
                        bVar.f230319c = str11;
                        bVar.f230320d = i16;
                        bVar.f230322f = str13;
                        bVar.f230321e = str12;
                        bVar.f230323g = str9;
                        bVar.f230324h = str8;
                        bVar.f230325i = str14;
                        bVar.f230326j = a162;
                        bVar.f230327k = j19;
                    }
                } else {
                    str4 = str17;
                }
                str12 = "";
                if (!common_msg.ext_info.from_channel_role_info.has()) {
                }
                str13 = "";
                if (common_msg.ext_info.freq_limit_info.has()) {
                }
                common_msg.ext_info.direct_message_member.size();
                if (!common_msg.ext_info.from_avatar.has()) {
                }
                IGProClientIdentityInfo a1622 = new GuildMsgHeadClientIdentityDecoder(this.f230314a).a(next, common_msg);
                bVar = new b();
                bVar.f230317a = str10;
                bVar.f230318b = String.valueOf(common_routinghead.channel_id.get());
                bVar.f230319c = str11;
                bVar.f230320d = i16;
                bVar.f230322f = str13;
                bVar.f230321e = str12;
                bVar.f230323g = str9;
                bVar.f230324h = str8;
                bVar.f230325i = str14;
                bVar.f230326j = a1622;
                bVar.f230327k = j19;
            } else {
                str2 = str15;
                str3 = str16;
                str4 = str17;
                common_contenthead = common_contenthead2;
                bVar = null;
            }
            b bVar2 = bVar;
            List<common$Event> list = common_msg.ext_info.events.get();
            if (j16 > 0) {
                j17 = j16;
            } else {
                j17 = next.time;
            }
            iGuildMessageUtilsApi.saveEventFlowToMsg(next, new bu1.a(list, j17));
            ((IGuildEventFlowService) this.f230314a.getRuntimeService(IGuildEventFlowService.class, "")).processEvents(next, common_msg.ext_info.events.get(), String.valueOf(iGuildMessageUtilsApi.getGuildIdFromMR(next)), next.frienduin, next.shmsgseq);
            if (QLog.isColorLevel() && bVar2 != null && q(common_msg.head.content_head.msg_type.get(), su1.c.c(next), iGuildMessageUtilsApi.isRevokeMsg(next), bVar2.f230327k)) {
                str5 = str4;
                i3 = 2;
                QLog.i(str5, 2, "updateSimpleProfileByMsg:" + bVar2.toString());
            } else {
                str5 = str4;
                i3 = 2;
            }
            if (common_routinghead.from_appid.has()) {
                next.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_FROM_APPID, String.valueOf(common_routinghead.from_appid.get()));
            }
            if (next.msgtype == -1035) {
                ((ChatMessage) next).parse();
            }
            if (im_msg_body_richtext != null) {
                vt1.b.a().c(this.f230314a, cVar, cVar2, next);
                g(arrayList, im_msg_body_richtext.elems.get(), next);
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("decodeMsgHead, MR: ");
                sb5.append(next.toString());
                str6 = str3;
                sb5.append(str6);
                sb5.append(next.extStr);
                QLog.d(str5, i3, sb5.toString());
            } else {
                str6 = str3;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("decodeMsgHead, shmsgseq: ");
            sb6.append(next.shmsgseq);
            String str19 = str2;
            sb6.append(str19);
            sb6.append(next.frienduin);
            QLog.i(str5, 1, sb6.toString());
            str16 = str6;
            it = it5;
            common_contenthead2 = common_contenthead;
            str17 = str5;
            str15 = str19;
        }
    }

    private MessageRecord k(List<MessageRecord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            MessageRecord messageRecord = list.get(size);
            if (messageRecord.msgtype != -2006) {
                return messageRecord;
            }
        }
        return null;
    }

    private void m(ArrayList<MessageRecord> arrayList, List<im_msg_body$Elem> list, MessageRecord messageRecord, boolean z16) {
        int i3;
        MessageRecord createMsgRecordByMsgType;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (!z16 && im_msg_body_elem.extra_info.has()) {
                im_msg_body$ExtraInfo im_msg_body_extrainfo = im_msg_body_elem.extra_info.get();
                if (im_msg_body_extrainfo.uint32_msg_tail_id.has() && (i3 = im_msg_body_extrainfo.uint32_msg_tail_id.get()) > 0 && (createMsgRecordByMsgType = ((IMessageRecordFactoryService) QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(-1002)) != null) {
                    String num = Integer.toString(i3);
                    SafeMsg$SafeMoreInfo safeMsg$SafeMoreInfo = new SafeMsg$SafeMoreInfo();
                    safeMsg$SafeMoreInfo.strMsgTxt.set(num);
                    createMsgRecordByMsgType.init(messageRecord.selfuin, messageRecord.frienduin, messageRecord.senderuin, num, messageRecord.time, -1002, messageRecord.istroop, messageRecord.msgseq);
                    createMsgRecordByMsgType.isread = true;
                    createMsgRecordByMsgType.shmsgseq = messageRecord.shmsgseq;
                    createMsgRecordByMsgType.msgData = safeMsg$SafeMoreInfo.toByteArray();
                    arrayList.add(createMsgRecordByMsgType);
                }
            }
        }
    }

    private static boolean q(long j3, boolean z16, boolean z17, long j16) {
        if (j3 == 3840 && !z16 && !z17 && j16 != 0) {
            return true;
        }
        return false;
    }

    private static boolean r(AppRuntime appRuntime, MessageRecord messageRecord, boolean z16) {
        List<MessageRecord> msgList = ((IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")).getMsgList(messageRecord.frienduin, messageRecord.istroop);
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        if (msgList != null && msgList.size() > 0) {
            for (MessageRecord messageRecord2 : msgList) {
                if (iGuildMessageUtilsApi.isMsgVisible(messageRecord)) {
                    if (com.tencent.mobileqq.guild.message.p.a(appRuntime, messageRecord2, messageRecord, false, z16)) {
                        QLog.i("BaseGuildMessageProcessor", 1, "isDuplicatedMsg = true. visible msg. MR: " + messageRecord.toString() + ", channelId: " + messageRecord.frienduin);
                        return true;
                    }
                } else if (messageRecord.shmsgseq == messageRecord2.shmsgseq && !iGuildMessageUtilsApi.isLocalOnlyMsg(messageRecord2)) {
                    QLog.i("BaseGuildMessageProcessor", 1, "isDuplicatedMsg = true. invisible msg. MR: " + messageRecord.toString() + ", channelId: " + messageRecord.frienduin + ", duplicated mr: " + messageRecord2.toString());
                    return true;
                }
            }
        }
        if (!((com.tencent.mobileqq.service.message.e) appRuntime.getMsgCache()).j1(messageRecord)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseGuildMessageProcessor", 2, "isDuplicatedMsg = true. inRevokeNotifyCache. MR: " + messageRecord.toString());
        }
        return true;
    }

    private static boolean s(int i3) {
        if (i3 != 1 && i3 != 2) {
            return true;
        }
        return false;
    }

    private Boolean x(List<common$Msg> list, Boolean bool, StringBuilder sb5, Set<String> set, common$Msg common_msg) {
        if (!common_msg.head.has()) {
            return bool;
        }
        String j3 = j(common_msg);
        if (set.contains(j3)) {
            bool = Boolean.TRUE;
            if (QLog.isColorLevel()) {
                sb5.append("< duplicatedMsg:");
                sb5.append(j3);
                sb5.append(" >");
            }
        } else {
            set.add(j3);
            list.add(common_msg);
        }
        return bool;
    }

    private void z(common$Msg common_msg) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        Iterator<im_msg_body$Elem> it = common_msg.body.get().rich_text.get().elems.get().iterator();
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
        if (im_msg_body_commonelem == null) {
            return;
        }
        IGPSService iGPSService = (IGPSService) this.f230314a.getRuntimeService(IGPSService.class, "");
        if (common_msg.head.has() && common_msg.head.content_head.has()) {
            common$ContentHead common_contenthead = common_msg.head.content_head.get();
            common$RoutingHead common_routinghead = common_msg.head.routing_head.get();
            iGPSService.onSrvPushMsg((int) common_contenthead.msg_type.get(), (int) common_contenthead.sub_type.get(), new fi(String.valueOf(common_routinghead.guild_id.get()), String.valueOf(common_routinghead.channel_id.get()), "", String.valueOf(common_routinghead.from_tinyid.get()), String.valueOf(common_routinghead.guild_code.get()), common_routinghead.direct_message_flag.get()), im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageRecord A(MessageRecord messageRecord) {
        List<MessageRecord> msgList = ((IMessageFacade) this.f230314a.getRuntimeService(IMessageFacade.class, "")).getMsgList(messageRecord.frienduin, messageRecord.istroop);
        if (msgList != null && msgList.size() > 0) {
            for (MessageRecord messageRecord2 : msgList) {
                if (com.tencent.mobileqq.guild.message.p.a(this.f230314a, messageRecord2, messageRecord, false, true)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BaseGuildMessageProcessor", 2, "queryDuplicatedMsg = true. visible msg. MR: " + messageRecord.toString());
                    }
                    return messageRecord2;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(List<common$Msg> list, boolean z16) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i3;
        if (list != null && list.size() != 0) {
            IGPSService iGPSService = (IGPSService) this.f230314a.getRuntimeService(IGPSService.class, "");
            ArrayList arrayList = new ArrayList();
            for (common$Msg common_msg : list) {
                if (common_msg.head.routing_head.direct_message_flag.get() != 1) {
                    if (!common_msg.head.routing_head.guild_id.has()) {
                        str = "";
                    } else {
                        str = String.valueOf(common_msg.head.routing_head.guild_id.get());
                    }
                    if (!common_msg.head.routing_head.channel_id.has()) {
                        str2 = "";
                    } else {
                        str2 = String.valueOf(common_msg.head.routing_head.channel_id.get());
                    }
                    if (!common_msg.ext_info.channel_name.has()) {
                        str3 = "";
                    } else {
                        str3 = common_msg.ext_info.channel_name.get().toStringUtf8();
                    }
                    if (!common_msg.ext_info.guild_name.has()) {
                        str4 = "";
                    } else {
                        str4 = common_msg.ext_info.guild_name.get().toStringUtf8();
                    }
                    if (!common_msg.ext_info.from_nick.has()) {
                        str5 = "";
                    } else {
                        str5 = common_msg.ext_info.from_nick.get().toStringUtf8();
                    }
                    if (!common_msg.head.routing_head.from_tinyid.has()) {
                        str6 = "";
                    } else {
                        str6 = String.valueOf(common_msg.head.routing_head.from_tinyid.get());
                    }
                    if (common_msg.ext_info.notify_type.has()) {
                        i3 = common_msg.ext_info.notify_type.get();
                    } else {
                        i3 = -1000;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (z16) {
                        C(iGPSService, str2, i3, common_msg);
                        arrayList2.add(new e.a().l(str2).m(str3).j(str5).i(i3).k(str6).h());
                        arrayList.add(new cn.a().g(str).h(str4).f(arrayList2).e());
                        QLog.i("BaseGuildMessageProcessor", 2, "syncGuildMsg. onlinePush: GuildMsgNode id:" + str + " guildName:" + str4 + ", channelId: " + str2 + ", channelName:" + str3 + ", finalNotifyType: " + i3 + ", fromNick: " + str5);
                    } else {
                        arrayList2.add(new e.a().l(str2).j(str5).h());
                        arrayList.add(new cn.a().g(str).f(arrayList2).e());
                    }
                }
            }
            try {
                if (!arrayList.isEmpty()) {
                    QLog.e("BaseGuildMessageProcessor", 2, "!msgNodes.isEmpty() == true, \u89e6\u53d1\u4e86\u4e0d\u5e94\u8be5\u89e6\u53d1\u7684\u903b\u8f91\uff0c\u9700\u8981\u68c0\u67e5\u8c03\u7528\u6e90");
                }
            } catch (Exception e16) {
                QLog.e("BaseGuildMessageProcessor", 2, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(List<MessageRecord> list) {
        boolean z16;
        if (list != null && list.size() > 1) {
            IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                MessageRecord messageRecord = list.get(i3);
                if (iGuildMessageUtilsApi.isMsgVisible(messageRecord) && com.tencent.mobileqq.service.message.s.h(messageRecord)) {
                    if ((i3 > 0 && list.get(i3 - 1).shmsgseq == messageRecord.shmsgseq) || (i3 < list.size() - 1 && list.get(i3 + 1).shmsgseq == messageRecord.shmsgseq)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BaseGuildMessageProcessor", 2, "visibleBlankMsgFilter : removing " + messageRecord.toString() + ", channelId: " + messageRecord.frienduin);
                        }
                        arrayList.add(messageRecord);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(List<MessageRecord> list) {
        for (MessageRecord messageRecord : list) {
            if (messageRecord.shmsgseq == 1) {
                String str = messageRecord.frienduin;
                int channelType = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(this.f230314a, su1.c.b(messageRecord), str);
                if (channelType != 5 && ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isSupportTextChannleAbility(channelType)) {
                    ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).addMessageForGuildWelcome((BaseQQAppInterface) this.f230314a, str);
                    return;
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(ArrayList<MessageRecord> arrayList, MessageRecord messageRecord) {
        MessageRecord messageRecord2;
        String selfTinyId = ((IGPSService) this.f230314a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        String str = messageRecord.senderuin;
        if (str != null && str.equalsIgnoreCase(selfTinyId) && !iGuildMessageUtilsApi.isSysMsg(messageRecord)) {
            if (this.f230314a instanceof BaseQQAppInterface) {
                messageRecord2 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230314a).F(10014).y(10014).K(messageRecord.frienduin, 10014, messageRecord);
            } else {
                messageRecord2 = null;
            }
            if (messageRecord2 != null) {
                ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).handleSelfSendMsg(this.f230314a, messageRecord, messageRecord2, 2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BaseGuildMessageProcessor", 2, "checkAndHandleSelfSendMessage : findMr is NULL! set Flag: SEND_FROM_OTHER_TERMINAL");
            }
            messageRecord.isread = true;
            messageRecord.issend = 2;
            ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).setMsgReaded(this.f230314a, messageRecord);
        }
        arrayList.add(messageRecord);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(MessageRecord messageRecord) {
        if (((IGuildMsgSeqTimeService) this.f230314a.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getReadedMsgSeq(messageRecord.frienduin).f230119d >= messageRecord.shmsgseq) {
            messageRecord.isread = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<MessageRecord> e(common$Msg common_msg, String str, com.tencent.mobileqq.troop.data.c cVar, long j3) {
        im_msg_body$RichText im_msg_body_richtext;
        long f16;
        long j16;
        boolean z16;
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        if (!common_msg.head.has() || !common_msg.head.content_head.has() || !common_msg.head.routing_head.has()) {
            return null;
        }
        common$ContentHead common_contenthead = common_msg.head.content_head.get();
        common$RoutingHead common_routinghead = common_msg.head.routing_head.get();
        com.tencent.mobileqq.troop.data.c cVar2 = new com.tencent.mobileqq.troop.data.c();
        if (common_msg.body.has() && common_msg.body.rich_text.has()) {
            im_msg_body$RichText im_msg_body_richtext2 = common_msg.body.get().rich_text.get();
            if (im_msg_body_richtext2.attr.has()) {
                j16 = com.tencent.mobileqq.service.message.s.f(im_msg_body_richtext2.attr.get().random.get());
            } else {
                j16 = 0;
            }
            long j17 = j16;
            cVar2.f294891a = String.valueOf(common_routinghead.channel_id.get());
            cVar2.f294892b = 10014;
            msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
            msg_comm$MsgHead msg_comm_msghead = new msg_comm$MsgHead();
            String selfTinyId = ((IGPSService) this.f230314a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
            if (selfTinyId != null && String.valueOf(common_routinghead.from_tinyid.get()).equals(selfTinyId)) {
                try {
                    msg_comm_msghead.from_uin.set(Long.parseLong(str));
                } catch (Exception unused) {
                }
            } else {
                msg_comm_msghead.from_uin.set(common_routinghead.from_tinyid.get());
            }
            try {
                msg_comm_msghead.to_uin.set(Long.parseLong(str));
            } catch (Exception unused2) {
            }
            msg_comm_msghead.msg_type.set((int) common_contenthead.msg_type.get());
            msg_comm_msghead.msg_seq.set((int) common_contenthead.msg_seq.get());
            msg_comm_msghead.msg_time.set((int) common_contenthead.msg_time.get());
            msg_comm_msghead.msg_uid.set(common_contenthead.random.get());
            if (common_msg.ext_info.has() && common_msg.ext_info.from_nick.has()) {
                msg_comm_msghead.from_nick.set(common_msg.ext_info.from_nick.get().toStringUtf8());
            }
            msg_comm_msg.msg_head.set(msg_comm_msghead);
            msg_comm_msg.msg_body.set(common_msg.body.get());
            try {
                Long.parseLong(str);
            } catch (Exception unused3) {
            }
            com.tencent.mobileqq.service.message.a aVar = new com.tencent.mobileqq.service.message.a(0L, common_routinghead.channel_id.get(), false, false, false, false);
            aVar.f286163r = 10014;
            aVar.f286169x = common_routinghead.guild_id.get();
            aVar.f286149d = common_routinghead.from_tinyid.get();
            aVar.f286338a = common_routinghead.channel_id.get();
            aVar.b(1, this.f230314a);
            aVar.b(2, Long.valueOf(common_contenthead.msg_time.get()));
            if (common_msg.ext_info.offline_flag.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.b(3, Boolean.valueOf(z16));
            w.h(this.f230314a, arrayList, msg_comm_msg, false, false, cVar2, null, aVar);
            if (arrayList.isEmpty()) {
                QLog.e("BaseGuildMessageProcessor", 1, "decodeMsg error! inserting an empty msg! channelId: " + common_routinghead.channel_id.get() + ", shmsgseq: " + common_contenthead.msg_seq.get());
                arrayList.add(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).createEmptyMR());
            }
            f16 = j17;
            im_msg_body_richtext = im_msg_body_richtext2;
        } else {
            QLog.i("BaseGuildMessageProcessor", 1, "decodeMsg: no msg body, channelId: " + common_routinghead.channel_id.get() + ", shmsgseq: " + common_contenthead.msg_seq.get());
            arrayList.add(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).createEmptyMR());
            im_msg_body_richtext = null;
            f16 = com.tencent.mobileqq.service.message.s.f((int) common_contenthead.random.get());
        }
        f(arrayList, common_msg, f16, str, cVar, cVar2, im_msg_body_richtext, j3);
        return arrayList;
    }

    protected void g(ArrayList<MessageRecord> arrayList, List<im_msg_body$Elem> list, MessageRecord messageRecord) {
        String selfTinyId = ((IGPSService) this.f230314a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (list != null && selfTinyId != null && !TextUtils.equals(selfTinyId, messageRecord.senderuin)) {
            Iterator<im_msg_body$Elem> it = list.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (it.next().anon_group_msg.has()) {
                    z16 = true;
                }
            }
            m(arrayList, list, messageRecord, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(List<MessageRecord> list, ArrayList<MessageRecord> arrayList, ArrayList<MessageRecord> arrayList2, boolean z16) {
        for (MessageRecord messageRecord : list) {
            if (!r(this.f230314a, messageRecord, z16)) {
                arrayList.add(messageRecord);
            } else {
                arrayList2.add(messageRecord);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(List<common$Msg> list, List<common$Msg> list2, List<common$Msg> list3, boolean z16) {
        for (common$Msg common_msg : list) {
            if (common_msg.head.has() && common_msg.head.content_head.has()) {
                if (v(common_msg)) {
                    common$ContentHead common_contenthead = common_msg.head.content_head.get();
                    long j3 = common_contenthead.sub_type.get();
                    if (z16) {
                        z(common_msg);
                    }
                    int i3 = common_msg.ext_info.offline_flag.get();
                    QLog.i("BaseGuildMessageProcessor", 1, "filterSystemMsg, sub_type = " + common_contenthead.sub_type.get() + ", channleId = " + common_msg.head.routing_head.channel_id.get() + ", msg_seq = " + common_contenthead.msg_seq.get() + ", msg_time = " + common_contenthead.msg_time.get() + " offLineFlag:" + i3);
                    if (t(i3, j3)) {
                        list3.add(common_msg);
                    }
                    list2.add(common_msg);
                } else {
                    list3.add(common_msg);
                }
            }
        }
    }

    protected String j(common$Msg common_msg) {
        return String.valueOf(common_msg.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.tencent.imcore.message.f l() {
        return ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageProxy((BaseQQAppInterface) this.f230314a, 10014);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(List<common$Msg> list, List<MessageRecord> list2, int i3) {
        if ((list != null && list.size() != 0) || (list2 != null && list2.size() != 0)) {
            ((IGuildMsgFactory) this.f230314a.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(3).a(list, list2, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(common$Msg common_msg) {
        if (common_msg != null && common_msg.msg_core.has()) {
            return true;
        }
        return false;
    }

    protected boolean t(int i3, long j3) {
        if (i3 == 1 || j3 == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u(common$Msg common_msg) {
        if (common_msg == null || !common_msg.head.has() || !common_msg.head.content_head.has() || common_msg.head.content_head.get().msg_type.get() != 3842) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v(common$Msg common_msg) {
        if (common_msg == null || !common_msg.head.has() || !common_msg.head.content_head.has() || common_msg.head.content_head.get().msg_type.get() != 3841) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<Boolean, StringBuilder> w(List<common$Msg> list, List<common$Msg> list2) {
        if (list != null && list.size() != 0) {
            Boolean bool = Boolean.FALSE;
            StringBuilder sb5 = new StringBuilder();
            HashSet hashSet = new HashSet();
            Iterator<common$Msg> it = list.iterator();
            Boolean bool2 = bool;
            while (it.hasNext()) {
                bool2 = x(list2, bool2, sb5, hashSet, it.next());
            }
            return new Pair<>(bool2, sb5);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(List<MessageRecord> list) {
        MessageRecord k3 = k(list);
        if (k3 != null) {
            ((IMessageFacade) this.f230314a.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(k3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(String str) {
    }
}
