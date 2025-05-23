package com.tencent.mobileqq.guild.message.api.impl;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.m;
import com.tencent.mobileqq.guild.message.n;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryAttributes;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.u;
import com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import mqq.app.MobileQQ;
import st1.h;
import tencent.im.group_pro_proto.common.common$ContentHead;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.common.common$MsgHead;
import tencent.im.group_pro_proto.common.common$MsgMeta;
import tencent.im.group_pro_proto.common.common$RoutingHead;
import tencent.im.group_pro_proto.oidb0xf62.Oidb0xf62$ReqBody;
import tencent.im.group_pro_proto.oidb0xf62.Oidb0xf62$RspBody;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildSendMessageHandler extends BaseGuildMessageHandler implements st1.h {

    /* renamed from: f, reason: collision with root package name */
    private static int f230148f = 480000;

    /* renamed from: h, reason: collision with root package name */
    private static int f230149h = 3;

    /* renamed from: d, reason: collision with root package name */
    private List<MessageRecord> f230150d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f230151e;

    public GuildSendMessageHandler(AppInterface appInterface) {
        super(appInterface);
        this.f230150d = new ArrayList();
        this.f230151e = appInterface;
        AppSetting.K = appInterface.getApp().getSharedPreferences("mobileQQ", 0).getBoolean(AppSetting.L, true);
    }

    private void F2(final MessageRecord messageRecord, boolean z16) {
        if (z16) {
            try {
                ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230151e).a(messageRecord, null);
                return;
            } catch (Exception e16) {
                QLog.e("GuildSendMessageHandler", 1, "addAndSendMessage:", e16);
                return;
            }
        }
        QLog.i("GuildSendMessageHandler", 1, "addAndSendMessage post thread");
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.GuildSendMessageHandler.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("GuildSendMessageHandler", 1, "addAndSendMessage thread run");
                try {
                    ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) GuildSendMessageHandler.this.f230151e).a(messageRecord, null);
                } catch (Exception e17) {
                    QLog.e("GuildSendMessageHandler", 1, "addAndSendMessage:", e17);
                }
            }
        }, 10, null, false);
    }

    private static void G2(MessageRecord messageRecord, ToServiceMsg toServiceMsg) {
        if (ad.I(messageRecord.msgtype)) {
            toServiceMsg.extraData.putBoolean("RichNotify", true);
        }
    }

    private static String H2(String str, ArrayList<AtTroopMemberInfo> arrayList) {
        int i3 = 0;
        for (int i16 = 0; i16 < str.length() && str.codePointAt(i16) == 0; i16++) {
            i3++;
            QLog.i("SendMsgBtn", 1, " createTextMessageToshow, at info starts with char 0");
        }
        if (i3 > 0) {
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<AtTroopMemberInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    AtTroopMemberInfo next = it.next();
                    short s16 = (short) (next.startPos - i3);
                    next.startPos = s16;
                    if (s16 < 0) {
                        QLog.e("SendMsgBtn", 1, " createTextMessageToshow error, at info starts with char 0");
                        return null;
                    }
                }
            }
            return str.substring(i3);
        }
        return str;
    }

    private boolean I2(h.a aVar) {
        if (aVar == null) {
            QLog.i("GuildSendMessageHandler", 1, " checkParamValid params = null!");
            return false;
        }
        boolean isEmpty = TextUtils.isEmpty(aVar.f434699a);
        boolean isEmpty2 = TextUtils.isEmpty(aVar.f434700b);
        boolean isEmpty3 = TextUtils.isEmpty(aVar.f434701c);
        if (!isEmpty && !isEmpty2 && !isEmpty3) {
            return true;
        }
        QLog.i("GuildSendMessageHandler", 1, " checkParamValid isGuildIdEmpty: " + isEmpty + ", isChannelIdEmpty: " + isEmpty2 + ", isMsgStrEmpty: " + isEmpty3);
        return false;
    }

    static Oidb0xf62$ReqBody J2(AppInterface appInterface, MessageRecord messageRecord) {
        long parseLong;
        long j3;
        Iterator<IRichTextAndMsgViaProvider> it = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().s().iterator();
        im_msg_body$RichText im_msg_body_richtext = null;
        int i3 = 0;
        while (it.hasNext()) {
            Object[] richTextAndMsgViaFromMessageRecord = it.next().getRichTextAndMsgViaFromMessageRecord(appInterface, messageRecord, im_msg_body_richtext, i3);
            im_msg_body$RichText im_msg_body_richtext2 = (im_msg_body$RichText) richTextAndMsgViaFromMessageRecord[0];
            i3 = ((Integer) richTextAndMsgViaFromMessageRecord[1]).intValue();
            im_msg_body_richtext = im_msg_body_richtext2;
        }
        if (im_msg_body_richtext == null) {
            return null;
        }
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        long guildIdFromMR = iGuildMessageUtilsApi.getGuildIdFromMR(messageRecord);
        try {
            String selfTinyId = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
            if (!TextUtils.isEmpty(selfTinyId) && selfTinyId.equals(messageRecord.senderuin)) {
                parseLong = Long.parseLong(appInterface.getCurrentAccountUin());
            } else {
                parseLong = Long.parseLong(messageRecord.senderuin);
            }
            long parseLong2 = Long.parseLong(messageRecord.frienduin);
            if (guildIdFromMR != 0 && parseLong2 != 0 && parseLong != 0) {
                Oidb0xf62$ReqBody oidb0xf62$ReqBody = new Oidb0xf62$ReqBody();
                common$Msg common_msg = new common$Msg();
                common$MsgHead common_msghead = new common$MsgHead();
                im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
                common$RoutingHead common_routinghead = new common$RoutingHead();
                String valueOf = String.valueOf(parseLong2);
                if (((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).hasDirectMsgFlag(valueOf)) {
                    common_routinghead.direct_message_flag.set(1);
                    j3 = ((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).getGuildId(valueOf);
                } else {
                    j3 = guildIdFromMR;
                }
                common_routinghead.guild_id.set(j3);
                common_routinghead.channel_id.set(parseLong2);
                common_routinghead.from_uin.set(parseLong);
                common_msghead.routing_head.set(common_routinghead);
                common$ContentHead common_contenthead = new common$ContentHead();
                int msgRandomByMsgUid_Hummer = iGuildMessageUtilsApi.getMsgRandomByMsgUid_Hummer(messageRecord.msgUid);
                common_contenthead.msg_type.set(3840L);
                common_contenthead.random.set(msgRandomByMsgUid_Hummer);
                common_msghead.content_head.set(common_contenthead);
                im_msg_body_msgbody.rich_text.set(im_msg_body_richtext);
                common_msg.body.set(im_msg_body_msgbody);
                common_msg.head.set(common_msghead);
                oidb0xf62$ReqBody.f435945msg.set(common_msg);
                Iterator<mu1.c> it5 = mu1.a.b().iterator();
                while (it5.hasNext()) {
                    it5.next().a(appInterface, messageRecord, oidb0xf62$ReqBody);
                }
                return oidb0xf62$ReqBody;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static MessageRecord K2(AppInterface appInterface, h.a aVar) {
        int i3;
        boolean z16;
        QLog.i("GuildSendMessageHandler", 1, " createMsgQueueAndSend start.");
        String H2 = H2(aVar.f434701c, aVar.f434702d);
        if (H2 == null) {
            QLog.i("GuildSendMessageHandler", 1, " checkMsgStartWithChar0 failed.");
            return null;
        }
        if (aVar.f434709k != 0) {
            i3 = -8018;
        } else {
            i3 = -1000;
        }
        ChatMessage chatMessage = (ChatMessage) ((IMessageRecordFactoryService) QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(i3);
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        iGuildMessageUtilsApi.saveGuildIdToMR(chatMessage, aVar.f434699a);
        ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).setSendingMsgRecordBaseInfo(appInterface, chatMessage, aVar.f434700b, null, 10014);
        if (aVar.f434707i == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        su1.c.e(chatMessage, z16);
        String d16 = s.d(H2, true, aVar.f434702d);
        int abs = Math.abs(new Random().nextInt());
        chatMessage.f203106msg = d16;
        chatMessage.msgUid = s.f(abs);
        chatMessage.longMsgCount = 0;
        chatMessage.longMsgIndex = 0;
        chatMessage.longMsgId = 0;
        chatMessage.mAnimFlag = true;
        chatMessage.mNewAnimFlag = true;
        chatMessage.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
        String selfTinyId = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (!TextUtils.isEmpty(selfTinyId) && !selfTinyId.equals("0")) {
            chatMessage.senderuin = selfTinyId;
        }
        if (aVar.f434706h) {
            chatMessage.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(1));
        }
        ArrayList<AtTroopMemberInfo> arrayList = aVar.f434702d;
        if (arrayList != null) {
            iGuildMessageUtilsApi.saveAtInfoList(chatMessage, arrayList);
        }
        if (aVar.f434709k != 0) {
            O2((MessageForAniSticker) chatMessage, aVar);
        }
        vt1.d.a();
        vt1.d.c(appInterface, chatMessage, aVar);
        return chatMessage;
    }

    private void L2(Oidb0xf62$RspBody oidb0xf62$RspBody, MessageRecord messageRecord) {
        common$ContentHead common_contenthead = oidb0xf62$RspBody.head.content_head.get();
        common$RoutingHead common_routinghead = oidb0xf62$RspBody.head.routing_head.get();
        messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_CNT_NAME, String.valueOf(common_contenthead.cnt_seq.get()));
        messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_TYPE, String.valueOf(common_contenthead.msg_type.get()));
        messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, String.valueOf(0));
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        iGuildMessageUtilsApi.saveGuildIdToMR(messageRecord, String.valueOf(common_routinghead.guild_id.get()));
        byte[] byteArray = common_contenthead.msg_meta.get().toByteArray();
        iGuildMessageUtilsApi.saveMsgMetaToMr(messageRecord, byteArray);
        common$MsgMeta common_msgmeta = new common$MsgMeta();
        try {
            common_msgmeta.mergeFrom(byteArray);
            QLog.i("GuildSendMessageHandler", 1, "msg_meta has() = " + common_contenthead.msg_meta.has() + ", atAllSeq: " + common_msgmeta.at_all_seq.get());
        } catch (Exception unused) {
            QLog.e("GuildSendMessageHandler", 1, "msg_meta merge exception! decodeMsg, MR: " + messageRecord.toString() + ", extstr: " + messageRecord.extStr);
        }
    }

    private MessageRecord M2(Oidb0xf62$RspBody oidb0xf62$RspBody) {
        if (oidb0xf62$RspBody.head.has() && oidb0xf62$RspBody.head.content_head.has() && oidb0xf62$RspBody.head.routing_head.has()) {
            MessageRecord messageRecord = new MessageRecord();
            common$ContentHead common_contenthead = oidb0xf62$RspBody.head.content_head.get();
            common$RoutingHead common_routinghead = oidb0xf62$RspBody.head.routing_head.get();
            messageRecord.msgUid = s.f((int) common_contenthead.random.get());
            messageRecord.time = common_contenthead.msg_time.get();
            messageRecord.msgseq = common_contenthead.msg_time.get();
            messageRecord.shmsgseq = common_contenthead.msg_seq.get();
            messageRecord.selfuin = this.f230151e.getCurrentAccountUin();
            messageRecord.istroop = 10014;
            messageRecord.senderuin = String.valueOf(common_routinghead.from_tinyid.get());
            messageRecord.frienduin = String.valueOf(common_routinghead.channel_id.get());
            messageRecord.longMsgId = 0;
            messageRecord.longMsgCount = 0;
            messageRecord.longMsgIndex = 0;
            L2(oidb0xf62$RspBody, messageRecord);
            return messageRecord;
        }
        return null;
    }

    private void N2(MessageRecord messageRecord) {
        if (messageRecord.atInfoList == null) {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.GUILD_AT_INFO_LIST);
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                messageRecord.atInfoList = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).parseAtInfoFromExtStr(extInfoFromExtStr);
            }
        }
    }

    private static void O2(MessageForAniSticker messageForAniSticker, h.a aVar) {
        AniStickerInfo aniStickerInfo = QQSysFaceUtil.getAniStickerInfo(aVar.f434709k);
        messageForAniSticker.sourceType = 1;
        String str = aniStickerInfo.text;
        messageForAniSticker.text = str;
        messageForAniSticker.sevrId = aniStickerInfo.sevrId;
        messageForAniSticker.packId = aniStickerInfo.aniStickerPackId;
        messageForAniSticker.stickerId = aniStickerInfo.aniStickerId;
        messageForAniSticker.stickerType = aniStickerInfo.aniStickerType;
        messageForAniSticker.mIsParsed = true;
        messageForAniSticker.f203106msg = str;
        messageForAniSticker.msgVia = aVar.f434708j;
        messageForAniSticker.msgtype = -8018;
        messageForAniSticker.msgData = messageForAniSticker.serializeMsgData();
    }

    static void P2(AppInterface appInterface, MessageRecord messageRecord, ToServiceMsg toServiceMsg, long j3, int i3, boolean z16) {
        long length;
        Oidb0xf62$ReqBody J2 = J2(appInterface, messageRecord);
        if (J2 == null) {
            QLog.i("GuildSendMessageHandler", 1, "fillSendMsgRequest : the reqBody is null! " + messageRecord.getBaseInfoString());
            return;
        }
        toServiceMsg.putWupBuffer(J2.toByteArray());
        toServiceMsg.setTimeout(j3);
        long currentTimeMillis = System.currentTimeMillis();
        String str = messageRecord.f203106msg;
        if (str == null) {
            length = 0;
        } else {
            length = str.getBytes().length;
        }
        QLog.i("GuildSendMessageHandler", 1, String.format(Locale.getDefault(), "createSendMsgRequest, uint32Seq:%d, random:%d, %s", Integer.valueOf(((short) messageRecord.msgseq) & 65535), Integer.valueOf(s.e(messageRecord.msgUid)), messageRecord.getBaseInfoString()));
        G2(messageRecord, toServiceMsg);
        toServiceMsg.extraData.putString("uin", messageRecord.frienduin);
        toServiceMsg.extraData.putLong("msgsize", length);
        toServiceMsg.extraData.putLong("uniseq", messageRecord.uniseq);
        toServiceMsg.extraData.putLong(WadlProxyConsts.PARAM_TIME_OUT, j3);
        toServiceMsg.extraData.putLong("msgSeq", messageRecord.msgseq);
        toServiceMsg.extraData.putLong("startTime", currentTimeMillis);
        toServiceMsg.extraData.putInt("retryIndex", i3);
        toServiceMsg.extraData.putInt("uintype", messageRecord.istroop);
        toServiceMsg.extraData.putInt(AppConstants.Key.COLUMN_MSG_TYPE, messageRecord.msgtype);
        toServiceMsg.extraData.putInt("send_msg_req_size", toServiceMsg.getWupBuffer().length);
        toServiceMsg.extraData.putString("guildId", String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(messageRecord)));
        toServiceMsg.addAttribute(AppConstants.Key.COLUMN_MSG_TYPE, Integer.valueOf(messageRecord.msgtype));
        toServiceMsg.addAttribute("msgSeq", Long.valueOf(messageRecord.msgseq));
        toServiceMsg.addAttribute("resend_by_user", Boolean.valueOf(z16));
        toServiceMsg.addAttribute("retryIndex", Integer.valueOf(i3));
        String str2 = messageRecord.frienduin;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        toServiceMsg.addAttribute("uin", str2);
        String str4 = messageRecord.senderuin;
        if (str4 != null) {
            str3 = str4;
        }
        toServiceMsg.addAttribute("fromUin", str3);
        toServiceMsg.addAttribute("normal_msg", Boolean.TRUE);
    }

    private boolean Q2(MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16) {
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        if (((IGPSService) this.f230151e.getRuntimeService(IGPSService.class, "")).isQQMsgListChannel(String.valueOf(iGuildMessageUtilsApi.getGuildIdFromMR(messageRecord)), messageRecord.frienduin) || ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab()) {
            return false;
        }
        QLog.e("GuildSendMessageHandler", 1, "filterRealSendMessage notshowguildtab");
        X2(String.valueOf(iGuildMessageUtilsApi.getGuildIdFromMR(messageRecord)), messageRecord.frienduin, false, messageRecord.shmsgseq, messageRecord.uniseq, 0, 0);
        return true;
    }

    private void S2(Oidb0xf62$RspBody oidb0xf62$RspBody) {
        if (oidb0xf62$RspBody.head.has() && oidb0xf62$RspBody.head.get().content_head.has() && !oidb0xf62$RspBody.head.get().content_head.get().msg_seq.has()) {
            QLog.i("GuildSendMessageHandler", 1, "handleSelfSendMessage, no msg_seq");
        } else {
            if (V2(oidb0xf62$RspBody)) {
                return;
            }
            T2(oidb0xf62$RspBody);
        }
    }

    private void T2(Oidb0xf62$RspBody oidb0xf62$RspBody) {
        MessageRecord M2 = M2(oidb0xf62$RspBody);
        if (M2 == null) {
            QLog.e("GuildSendMessageHandler", 1, "handleSelfSendMessage, mr == null");
            return;
        }
        MessageRecord K = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230151e).F(10014).y(10014).K(M2.frienduin, 10014, M2);
        if (K == null) {
            QLog.e("GuildSendMessageHandler", 1, "handleSelfSendMessage, findMr == null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("GuildSendMessageHandler", 1, "handleSelfSendMessage, mr extstr = " + M2.extStr + ", findMr extstr = " + K.extStr);
        }
        M2.extStr = K.extStr;
        M2.mExJsonObject = K.mExJsonObject;
        M2.extLong = K.extLong;
        L2(oidb0xf62$RspBody, M2);
        ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).handleSelfSendMsg(this.f230151e, M2, K, 1);
    }

    private void U2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        Oidb0xf62$RspBody oidb0xf62$RspBody;
        String str;
        String str2;
        long j3;
        Oidb0xf62$RspBody oidb0xf62$RspBody2;
        String str3;
        QLog.i("GuildSendMessageHandler", 1, "handleSendRichTextMessageResp enter");
        recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        long j16 = toServiceMsg.extraData.getLong("msgSeq");
        long j17 = toServiceMsg.extraData.getLong("uniseq");
        String string = toServiceMsg.extraData.getString("uin");
        String string2 = toServiceMsg.extraData.getString("guildId");
        if (fromServiceMsg.getResultCode() != 1000) {
            getHandlerFromQueue(j16);
            X2(string2, string, fromServiceMsg.getResultCode() == 2901, j16, j17, 0, fromServiceMsg.getResultCode());
            ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(2, toServiceMsg, fromServiceMsg, null);
            return;
        }
        Oidb0xf62$RspBody oidb0xf62$RspBody3 = new Oidb0xf62$RspBody();
        try {
            oidb0xf62$RspBody = oidb0xf62$RspBody3.mergeFrom((byte[]) obj);
            i3 = 0;
        } catch (Exception e16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleSendRichTextMessageResp:");
            sb5.append(obj == null ? "null" : Arrays.toString((byte[]) obj));
            QLog.e("GuildSendMessageHandler", 1, sb5.toString(), e16);
            i3 = 65535;
            oidb0xf62$RspBody = oidb0xf62$RspBody3;
        }
        if (oidb0xf62$RspBody.result.has()) {
            i3 = oidb0xf62$RspBody.result.get();
        }
        fromServiceMsg.extraData.putLong("ServerReplyCode", i3);
        boolean z16 = i3 == 0 || i3 == 100000;
        if (!z16) {
            QLog.e("GuildSendMessageHandler", 1, "handleSendRichTextMessageResp, FAILED! result: " + i3 + ", errType: " + oidb0xf62$RspBody.err_type.get() + ", errmsg: " + (oidb0xf62$RspBody.errmsg.has() ? oidb0xf62$RspBody.errmsg.get().toStringUtf8() : ""));
            str = string;
            str2 = "";
            j3 = j16;
            X2(string2, string, false, j16, j17, i3, 0);
            oidb0xf62$RspBody2 = oidb0xf62$RspBody;
        } else {
            Oidb0xf62$RspBody oidb0xf62$RspBody4 = oidb0xf62$RspBody;
            str = string;
            str2 = "";
            j3 = j16;
            Y2(toServiceMsg, string2, str, j3, j17, oidb0xf62$RspBody4);
            oidb0xf62$RspBody2 = oidb0xf62$RspBody4;
            S2(oidb0xf62$RspBody2);
        }
        if (oidb0xf62$RspBody2.freq_limit_info.has()) {
            str3 = str;
            ((IGuildSlowModeService) this.appRuntime.getRuntimeService(IGuildSlowModeService.class, str2)).handleSlowModeFreqLimit(oidb0xf62$RspBody2.freq_limit_info.get(), str3);
        } else {
            str3 = str;
        }
        R2(toServiceMsg, fromServiceMsg, i3, j17, z16);
        ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(2, toServiceMsg, fromServiceMsg, obj);
        QLog.i("GuildSendMessageHandler", 1, "handleSendRichTextMessageResp: ---result:" + i3 + " ssoseq:" + fromServiceMsg.getRequestSsoSeq() + " appseq:" + fromServiceMsg.getAppSeq() + ",SendTroopMessageResp : channelId:" + str3 + ",uniseq:" + j17 + ",msgSeq:" + j3);
    }

    private boolean V2(Oidb0xf62$RspBody oidb0xf62$RspBody) {
        boolean J = com.tencent.mobileqq.guild.message.s.J();
        boolean K = com.tencent.mobileqq.guild.message.s.K(this.f230151e);
        if (J && K) {
            return false;
        }
        ((IGuildMsgFactory) this.f230151e.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().f(new Object[]{oidb0xf62$RspBody});
        QLog.i("GuildSendMessageHandler", 1, "noNeedProcessSendResp : isNeedToProcess = " + J + ", isSyncFinish = " + K);
        return true;
    }

    private void W2(boolean z16, MessageRecord messageRecord) {
        if (z16) {
            N2(messageRecord);
        }
    }

    private void X2(String str, String str2, boolean z16, long j3, long j16, int i3, int i16) {
        String str3;
        e.d G1;
        QLog.e("GuildSendMessageHandler", 1, "handleSendMsgFailure, channelId: " + str2 + ", uniseq: " + j16 + ", msgseq: " + j3 + ", result: " + i3 + ", respCode: " + i16);
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j3);
        if (z16 && retrySendMessage(handlerFromQueue, "server")) {
            QLog.e("GuildSendMessageHandler", 1, "handleSendMsgFailure, retry");
            return;
        }
        Z2(str2, str, i3, i16);
        removeSendMessageHandler(j3);
        com.tencent.mobileqq.service.message.e eVar = (com.tencent.mobileqq.service.message.e) this.f230151e.getMsgCache();
        if (eVar != null && (G1 = eVar.G1(str2, 10014, j16)) != null) {
            u.b("aio_msg_send_cost", System.currentTimeMillis() - G1.f286255d, "SendMsgFailure");
        }
        if (this.f230151e instanceof BaseQQAppInterface) {
            QLog.i("GuildSendMessageHandler", 1, "updateMsgExtraFlagByUniseq: peerUin = " + MsfSdkUtils.getShortUin(str2) + " type = 10014 uniseq = " + j16);
            ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).updateMsgSendStatus(this.f230151e, str2, j16, 32768, i3);
        }
        if (i3 == 100100) {
            str3 = BaseApplication.getContext().getResources().getString(R.string.f155821ij);
        } else if (i3 == 100306) {
            str3 = BaseApplication.getContext().getResources().getString(R.string.f15194192);
        } else if (i3 == 100308) {
            str3 = BaseApplication.getContext().getResources().getString(R.string.f156871ld);
        } else if (i3 == 100701) {
            str3 = BaseApplication.getContext().getResources().getString(R.string.f146630up);
        } else if (i3 == 100702) {
            str3 = BaseApplication.getContext().getResources().getString(R.string.f1517618k);
        } else {
            str3 = "";
        }
        notifyUI(n.f230676h, false, new Object[]{str2, Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), str3});
    }

    private void Y2(ToServiceMsg toServiceMsg, String str, String str2, long j3, long j16, Oidb0xf62$RspBody oidb0xf62$RspBody) {
        a3(str2, str);
        com.tencent.mobileqq.service.message.e eVar = (com.tencent.mobileqq.service.message.e) this.f230151e.getMsgCache();
        if (eVar != null) {
            e.d G1 = eVar.G1(str2, 10014, j16);
            toServiceMsg.extraData.putBoolean("isJuhuaExist", com.tencent.mobileqq.service.message.e.r1(G1));
            if (G1 != null) {
                u.b("aio_msg_send_cost", System.currentTimeMillis() - G1.f286255d, "SendMsgSuccess");
            }
        }
        BaseQQMessageFacade messageFacade = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230151e);
        MessageRecord H = messageFacade.F(10014).y(10014).H(str2, 10014, j16);
        if (H != null) {
            H.setExtraFlag(0);
            H.setSendFailCode(0);
            H.saveExtInfoToExtStr("key_guild_sending_message_success", "1");
            EntityManager createEntityManager = this.f230151e.getEntityManagerFactory().createEntityManager();
            createEntityManager.update(H);
            createEntityManager.close();
            ((m) messageFacade.F(10014)).f1(H, null);
        }
        q(str2, j16, j3);
        vt1.d.a();
        vt1.d.e(this.f230151e, toServiceMsg.extraData.getLong("uniseq"));
    }

    private void Z2(String str, String str2, int i3, int i16) {
        if (i3 == 0) {
            if (i16 != 0) {
                i3 = i16;
            } else {
                i3 = 0;
            }
        }
        if (i3 != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(GuildTelemetryAttributes.GUILD_ID, str2);
            hashMap.put(GuildTelemetryAttributes.CHANNEL_ID, str);
            hashMap.put(GuildTelemetryAttributes.ERRORCODE, String.valueOf(i3));
            ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).telemetryReport(GuildTelemetryTask.SEND_CHANNEL_MSG, hashMap);
        }
    }

    private void a3(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(GuildTelemetryAttributes.GUILD_ID, str2);
        hashMap.put(GuildTelemetryAttributes.CHANNEL_ID, str);
        hashMap.put(GuildTelemetryAttributes.ERRORCODE, String.valueOf(0));
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).telemetryReport(GuildTelemetryTask.SEND_CHANNEL_MSG, hashMap);
    }

    private void b3(MessageRecord messageRecord) {
        com.tencent.imcore.message.f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230151e).F(10014).y(10014);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
        y16.F0(messageRecord.frienduin, 10014, messageRecord.uniseq, contentValues);
    }

    private void c3(final MessageRecord messageRecord, boolean z16) {
        if (z16) {
            try {
                ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230151e).D0(messageRecord, null);
                return;
            } catch (Exception e16) {
                QLog.e("GuildSendMessageHandler", 1, "sendMessage:", e16);
                return;
            }
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.GuildSendMessageHandler.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) GuildSendMessageHandler.this.f230151e).D0(messageRecord, null);
                } catch (Exception e17) {
                    QLog.e("GuildSendMessageHandler", 1, "sendMessage:", e17);
                }
            }
        }, 10, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3(MessageRecord messageRecord, long j3, int i3, BusinessObserver businessObserver, boolean z16) {
        ToServiceMsg createToServiceMsg = createToServiceMsg("MsgProxy.SendMsg", businessObserver);
        P2(this.f230151e, messageRecord, createToServiceMsg, j3, i3, z16);
        createToServiceMsg.setNeedRemindSlowNetwork(true);
        ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).startGuildMsgProtocolReport(createToServiceMsg);
        sendPbReq(createToServiceMsg);
    }

    private void e3(ArrayList<AtTroopMemberInfo> arrayList) {
        Iterator<AtTroopMemberInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().isResvAttr = true;
        }
    }

    @Override // st1.h
    public void C2() {
        for (Object[] objArr : ((IGuildMsgFactory) this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().d()) {
            if (objArr != null && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof Oidb0xf62$RspBody) {
                    T2((Oidb0xf62$RspBody) obj);
                }
            }
        }
        ((IGuildMsgFactory) this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().e();
    }

    @Override // st1.h
    public void O1(final MessageRecord messageRecord, final BusinessObserver businessObserver, final boolean z16) {
        QLog.i("GuildSendMessageHandler", 1, "sendRichTextMessageWith_MR. MR: " + messageRecord.toString());
        long guildIdFromMR = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(messageRecord);
        com.tencent.mobileqq.guild.main.d.d(MobileQQ.sMobileQQ.peekAppRuntime(), guildIdFromMR + "", "sendMessage");
        if (Q2(messageRecord, businessObserver, z16)) {
            return;
        }
        W2(z16, messageRecord);
        messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
        b3(messageRecord);
        SendMessageHandler sendMessageHandler = new SendMessageHandler();
        boolean addToQueue = addToQueue(messageRecord.msgseq, sendMessageHandler);
        d3(messageRecord, f230148f, 0, businessObserver, z16);
        notifyUI(n.f230678m, true, new String[]{messageRecord.frienduin});
        sendMessageHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.GuildSendMessageHandler.3
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.service.message.e eVar = (com.tencent.mobileqq.service.message.e) GuildSendMessageHandler.this.f230151e.getMsgCache();
                if (eVar != null && eVar.t1(messageRecord)) {
                    QLog.i("MsgSend", 1, "delay notify: " + com.tencent.mobileqq.service.message.e.Q0);
                    GuildSendMessageHandler.this.notifyUI(n.f230674e, true, new String[]{messageRecord.frienduin});
                }
            }
        }, com.tencent.mobileqq.service.message.e.Q0);
        if (addToQueue) {
            for (int i3 = 0; i3 < 8; i3++) {
                sendMessageHandler.d(new SendMessageHandler.SendMessageRunnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.GuildSendMessageHandler.4
                    @Override // com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable, java.lang.Runnable
                    public void run() {
                        QLog.i("GuildSendMessageHandler", 1, "--->sendRichTextMessageWith_MR : resend message");
                        GuildSendMessageHandler.this.d3(messageRecord, this.f307281e, this.D, businessObserver, z16);
                    }
                });
            }
            for (int i16 = 1; i16 < 3; i16++) {
                sendMessageHandler.f((480000 * i16) / 3, (((3 - i16) * 480000) / 3) - (i16 * 2000), "period");
            }
        }
        vt1.d.a();
        vt1.d.d(messageRecord);
        this.f230150d.add(messageRecord);
        if (this.f230150d.size() > f230149h) {
            this.f230150d.remove(0);
        }
        ((st1.g) this.f230151e.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildPushMsgHandlerName())).K1();
    }

    public void R2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3, long j3, boolean z16) {
        if (toServiceMsg.extraData.getBoolean("RichNotify", false)) {
            int i16 = toServiceMsg.extraData.getInt("retryIndex", 0);
            StatictisInfo statictisInfo = new StatictisInfo();
            if (z16) {
                statictisInfo.errCode = fromServiceMsg.getResultCode();
                statictisInfo.retryCount = i16 + 1;
            } else {
                statictisInfo.errCode = BaseConstants.CODE_SERVER_RETURN_ERROR;
                statictisInfo.detailErrorReason = i3;
                statictisInfo.retryCount = i16 + 1;
                statictisInfo.timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
            }
            statictisInfo.reportSucc = 1;
            notifyCallBack(toServiceMsg, 5006, z16, new Object[]{Long.valueOf(j3), statictisInfo});
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("MsgProxy.SendMsg");
        }
        return this.allowCmdSet;
    }

    @Override // st1.h
    public long h0(AppInterface appInterface, h.a aVar) {
        if (!I2(aVar)) {
            QLog.i("GuildSendMessageHandler", 1, " checkParamValid failed.");
            return -1L;
        }
        e3(aVar.f434702d);
        MessageRecord K2 = K2(appInterface, aVar);
        if (K2 == null) {
            QLog.i("GuildSendMessageHandler", 1, " createMessageRecord failed.");
            return -1L;
        }
        F2(K2, aVar.f434705g);
        QLog.i("GuildSendMessageHandler", 1, "sendTextMessage | addAndSendMessage, key: " + aVar.f434699a + ", channelId: " + aVar.f434700b + ", uniseq: " + K2.uniseq);
        return K2.uniseq;
    }

    @Override // st1.h
    public long j0(AppInterface appInterface, h.a aVar) {
        if (!I2(aVar)) {
            QLog.i("GuildSendMessageHandler", 1, " checkParamValid failed.");
            return -1L;
        }
        e3(aVar.f434702d);
        MessageRecord K2 = K2(appInterface, aVar);
        if (K2 == null) {
            QLog.i("GuildSendMessageHandler", 1, " createMessageRecord failed.");
            return -1L;
        }
        c3(K2, aVar.f434705g);
        if (QLog.isColorLevel()) {
            QLog.i("GuildSendMessageHandler", 1, "sendTextMessage | addAndSendMessage, key: " + aVar.f434699a + ", channelId: " + aVar.f434700b + ", uniseq: " + K2.uniseq);
        }
        return K2.uniseq;
    }

    @Override // st1.h
    public List<MessageRecord> n2() {
        return this.f230150d;
    }

    public void notifyCallBack(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj) {
        super.notifyUI(toServiceMsg, i3, z16, obj);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        com.tencent.mobileqq.service.message.e eVar = (com.tencent.mobileqq.service.message.e) this.f230151e.getMsgCache();
        if (eVar != null) {
            eVar.V();
        }
        destroySendQueue();
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                QLog.i("GuildSendMessageHandler", 1, "cmdfilter error=" + serviceCmd);
                return;
            }
            if ("MsgProxy.SendMsg".equals(fromServiceMsg.getServiceCmd())) {
                U2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        QLog.i("GuildSendMessageHandler", 1, "onReceive,resp == null or req == null");
    }

    @Override // st1.h
    public void q(String str, long j3, long j16) {
        QLog.i("GuildSendMessageHandler", 1, "handleSendMessageSuccessful, channelId: " + str + ", uniseq: " + j3 + ", msgseq: " + j16);
        ((com.tencent.mobileqq.service.message.e) this.f230151e.getMsgCache()).G1(str, 10014, j3);
        notifyUI(n.f230675f, true, new Object[]{str, Long.valueOf(j3)});
        removeSendMessageHandler(j16);
    }
}
