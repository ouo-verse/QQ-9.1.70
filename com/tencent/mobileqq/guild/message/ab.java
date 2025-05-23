package com.tencent.mobileqq.guild.message;

import android.content.ContentValues;
import android.util.Pair;
import bu1.a;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyService;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService;
import com.tencent.mobileqq.guild.main.data.SchedulerMsgData;
import com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.group_pro_proto.common.common$ContentHead;
import tencent.im.group_pro_proto.common.common$Event;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.common.common$MsgHead;
import tencent.im.group_pro_proto.common.common$MsgOpInfo;
import tencent.im.group_pro_proto.msgpush.servtype$EventBody;
import tencent.im.group_pro_proto.msgpush.servtype$MsgEvent;
import tencent.im.group_pro_proto.msgpush.servtype$ReadNotify;
import tencent.im.group_pro_proto.msgpush.servtype$SchedulerMsg;
import tencent.im.group_pro_proto.msgpush.servtype$UpdateMsg;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ab extends com.tencent.mobileqq.guild.message.base.q {

    /* renamed from: c, reason: collision with root package name */
    private static com.tencent.mobileqq.guild.message.base.m f230113c;

    public ab(AppInterface appInterface) {
        super(appInterface);
    }

    private boolean E(long j3) {
        if (j3 != 1 && j3 != 14 && j3 != 15 && j3 != 16 && j3 != 38 && j3 != 39 && j3 != 44 && j3 != 48 && j3 != 39 && j3 != 40 && j3 != 41 && j3 != 46 && j3 != 63) {
            return false;
        }
        return true;
    }

    private void F(servtype$EventBody servtype_eventbody, common$MsgHead common_msghead) {
        String valueOf = String.valueOf(common_msghead.routing_head.guild_id.get());
        String valueOf2 = String.valueOf(common_msghead.routing_head.channel_id.get());
        M(servtype_eventbody, valueOf, valueOf2);
        H(servtype_eventbody, valueOf, valueOf2);
        L(servtype_eventbody, common_msghead, valueOf, valueOf2);
    }

    private void G(servtype$EventBody servtype_eventbody) {
        if (!servtype_eventbody.feed_event.has()) {
            return;
        }
        ((IGuildFeedPersonalBoxUnreadService) this.f230314a.getRuntimeService(IGuildFeedPersonalBoxUnreadService.class, "")).onFeedsEventOnlinePush(servtype_eventbody.feed_event.get());
    }

    private boolean H(servtype$EventBody servtype_eventbody, String str, String str2) {
        if (!servtype_eventbody.msg_events.has()) {
            return false;
        }
        com.tencent.imcore.message.f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230314a).F(10014).y(10014);
        QLog.i("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "handlerMsgEvent: guildid:" + str + ", channelid:" + str2);
        List<servtype$MsgEvent> list = servtype_eventbody.msg_events.get();
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        for (servtype$MsgEvent servtype_msgevent : list) {
            QLog.i("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "handlerMsgEvent: guildid:" + str + ", channelid:" + str2 + "msgEvent: msg_seq:" + servtype_msgevent.msg_seq.get() + " event_type:" + servtype_msgevent.event_type.get() + " event_version:" + servtype_msgevent.event_version.get());
            if (servtype_msgevent.event_type.has()) {
                a.b bVar = new a.b();
                bVar.f29146a = servtype_msgevent.event_type.get();
                bVar.f29148c = servtype_msgevent.event_version.get();
                arrayList.add(new Pair(Long.valueOf(servtype_msgevent.msg_seq.get()), bVar));
                MessageRecord f06 = y16.f0(str2, 10014, servtype_msgevent.msg_seq.get());
                if (f06 != null) {
                    ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveEventToMsg(f06, bVar);
                    Q(f06);
                }
                z16 = true;
            }
        }
        if (arrayList.size() > 0) {
            this.f230314a.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName()).notifyUI(GuildEventFlowObserver.f230088h, true, new Object[]{str2, arrayList, Boolean.FALSE});
        }
        return z16;
    }

    private void I(servtype$EventBody servtype_eventbody, common$MsgHead common_msghead) {
        if (!servtype_eventbody.question_channel_system_msg.has()) {
            return;
        }
        ((IQQGameStrategyService) this.f230314a.getRuntimeService(IQQGameStrategyService.class, "")).handleSystemMsg(common_msghead.content_head.random.get(), servtype_eventbody.question_channel_system_msg.get(), String.valueOf(common_msghead.routing_head.guild_id.get()), String.valueOf(common_msghead.routing_head.channel_id.get()));
    }

    private void J(servtype$EventBody servtype_eventbody) {
        if (!servtype_eventbody.read_feed_notify.has()) {
            return;
        }
        ((IGuildFeedPersonalBoxUnreadService) this.f230314a.getRuntimeService(IGuildFeedPersonalBoxUnreadService.class, "")).onReadFeedEventPush(servtype_eventbody.read_feed_notify.get());
    }

    private void K(servtype$EventBody servtype_eventbody) {
        if (!servtype_eventbody.msg_read_notify.has()) {
            return;
        }
        servtype$ReadNotify servtype_readnotify = servtype_eventbody.msg_read_notify.get();
        if (servtype_readnotify.uint64_channel_id.has() && servtype_readnotify.uint64_guild_id.has() && servtype_readnotify.msg_read_cnt_msg_seq.has() && servtype_readnotify.msg_read_msg_seq.has()) {
            IGuildMsgReadedService iGuildMsgReadedService = (IGuildMsgReadedService) this.f230314a.getRuntimeService(IGuildMsgReadedService.class, "");
            IGuildMsgSeqTimeService.a aVar = new IGuildMsgSeqTimeService.a(servtype_readnotify.msg_read_msg_seq.uint64_seq.get(), servtype_readnotify.msg_read_cnt_msg_seq.uint64_seq.get(), servtype_readnotify.msg_read_msg_seq.uint64_time.get(), servtype_readnotify.bytes_read_msg_meta.get().toByteArray());
            iGuildMsgReadedService.onMsgReadedNotify(String.valueOf(servtype_readnotify.uint64_guild_id.get()), String.valueOf(servtype_readnotify.uint64_channel_id.get()), aVar);
            QLog.i("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "handlerReadNotify: guildid:" + servtype_readnotify.uint64_guild_id.get() + " channelid:" + servtype_readnotify.uint64_channel_id.get() + "msgSeqTimeItem:" + aVar.toString());
            return;
        }
        QLog.e("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "handlerReadNotify: error:not has seq or time");
    }

    private void L(servtype$EventBody servtype_eventbody, common$MsgHead common_msghead, String str, String str2) {
        if (!servtype_eventbody.msg_scheduler.has()) {
            return;
        }
        servtype$SchedulerMsg servtype_schedulermsg = servtype_eventbody.msg_scheduler.get();
        long j3 = servtype_schedulermsg.expire_time_ms.get();
        if (j3 > 0 && j3 < NetConnInfoCenter.getServerTimeMillis()) {
            QLog.i("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "expire abandon");
            return;
        }
        long j16 = common_msghead.content_head.msg_seq.get();
        SchedulerMsgData c16 = qy1.a.c(str, str2);
        if (c16 != null && c16.msgSeq > j16) {
            QLog.i("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "handlerScheduleMsg msgSeq abandon: guildId:" + str + ",channelId:" + str2 + ", lastMsgSeq:" + c16.msgSeq + ",newMsgSeq:" + j16);
            return;
        }
        SchedulerMsgData schedulerMsgData = new SchedulerMsgData();
        schedulerMsgData.creatorUrl = servtype_schedulermsg.creator_head_url.get().toStringUtf8();
        schedulerMsgData.wording = servtype_schedulermsg.wording.get();
        schedulerMsgData.expireTimeMs = j3;
        schedulerMsgData.channelId = str2;
        QLog.i("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "handlerScheduleMsg: guildId:" + str + ",channelId:" + str2 + ",wording:" + schedulerMsgData.wording + ",creatorUrl:" + schedulerMsgData.creatorUrl + ",time:" + schedulerMsgData.expireTimeMs + ",msgSeq:" + j16);
        SimpleEventBus.getInstance().dispatchEvent(schedulerMsgData, true);
        if (j3 > 0) {
            qy1.a.e(str, str2, schedulerMsgData, j16);
        } else {
            qy1.a.d(str, str2);
        }
        MessageRecord messageRecord = new MessageRecord();
        common$ContentHead common_contenthead = common_msghead.content_head.get();
        messageRecord.shmsgseq = common_contenthead.msg_seq.get();
        messageRecord.frienduin = str2;
        messageRecord.time = common_msghead.content_head.msg_time.get();
        messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_CNT_NAME, String.valueOf(common_contenthead.cnt_seq.get()));
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        iGuildMessageUtilsApi.saveMsgMetaToMr(messageRecord, common_contenthead.msg_meta.get().toByteArray());
        iGuildMessageUtilsApi.saveGuildIdToMR(messageRecord, str);
        S(messageRecord);
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        arrayList.add(messageRecord);
        ((IGuildMsgSeqTimeService) this.f230314a.getRuntimeService(IGuildMsgSeqTimeService.class, "")).updateLastSeqAndTime(arrayList);
    }

    private boolean M(servtype$EventBody servtype_eventbody, String str, String str2) {
        if (!servtype_eventbody.msg_update_msg.has() || !servtype_eventbody.msg_update_msg.uint64_event_type.has()) {
            return false;
        }
        servtype$UpdateMsg servtype_updatemsg = servtype_eventbody.msg_update_msg.get();
        long j3 = servtype_updatemsg.uint64_msg_seq.get();
        long j16 = servtype_updatemsg.uint64_operator_role.get();
        long j17 = servtype_updatemsg.uint64_operator_tinyid.get();
        long j18 = servtype_updatemsg.uint64_timestamp.get();
        MessageRecord f06 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230314a).F(10014).y(10014).f0(str2, 10014, j3);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handlerUpdateMsg: guildid:");
        sb5.append(str);
        sb5.append(", channelid:");
        sb5.append(str2);
        sb5.append(", shmsgseq:");
        sb5.append(j3);
        sb5.append(", findMr = ");
        sb5.append(f06 != null);
        sb5.append(", eventType: ");
        sb5.append(servtype_updatemsg.uint64_event_type.get());
        sb5.append(", eventVersion: ");
        sb5.append(servtype_updatemsg.uint64_event_version.get());
        sb5.append(", operatorRole: ");
        sb5.append(j16);
        sb5.append(", uint64_operator_tinyid: ");
        sb5.append(j17);
        sb5.append(", uint64_operator_tinyid.has: ");
        sb5.append(servtype_updatemsg.uint64_operator_tinyid.has());
        QLog.i("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 2, sb5.toString());
        IGuildEventFlowService iGuildEventFlowService = (IGuildEventFlowService) this.f230314a.getRuntimeService(IGuildEventFlowService.class, "");
        common$Event common_event = new common$Event();
        common_event.type.set(servtype_updatemsg.uint64_event_type.get());
        common_event.version.set(servtype_updatemsg.uint64_event_version.get());
        common$MsgOpInfo common_msgopinfo = new common$MsgOpInfo();
        if (servtype_updatemsg.uint64_operator_role.has()) {
            common_msgopinfo.operator_role.set(j16);
        }
        if (servtype_updatemsg.uint64_operator_tinyid.has()) {
            common_msgopinfo.operator_tinyid.set(j17);
        }
        common_msgopinfo.timestamp.set(j18);
        common_event.op_info.set(common_msgopinfo);
        boolean processEvent = iGuildEventFlowService.processEvent(f06, common_event, str, str2, j3);
        if (processEvent && f06 != null) {
            ((IMessageFacade) this.f230314a.getRuntimeService(IMessageFacade.class, "")).cancelNotificationWhenRevokeMessage(f06);
            if (((IGuildMsgSeqTimeService) this.f230314a.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getReadedMsgSeq(str2).f230120e < f06.shmsgseq) {
                ((m) ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230314a).F(10014)).V0();
            }
        }
        ArrayList arrayList = new ArrayList();
        a.b bVar = new a.b();
        bVar.f29146a = servtype_updatemsg.uint64_event_type.get();
        bVar.f29148c = servtype_updatemsg.uint64_event_version.get();
        bVar.f29149d = j16;
        bVar.f29150e = j17;
        bVar.f29151f = j18;
        arrayList.add(new Pair(Long.valueOf(j3), bVar));
        if (f06 != null) {
            ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveEventToMsg(f06, bVar);
            Q(f06);
        }
        this.f230314a.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName()).notifyUI(GuildEventFlowObserver.f230088h, true, new Object[]{str2, arrayList, Boolean.valueOf(processEvent)});
        return true;
    }

    private void N(List<common$Msg> list, List<common$Msg> list2) {
        if (list != null && list.size() != 0) {
            Pair<Boolean, StringBuilder> w3 = super.w(list, list2);
            if (((Boolean) w3.first).booleanValue() && QLog.isColorLevel()) {
                QLog.d("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 2, "<---msgFilter_OnePkg " + ((CharSequence) w3.second) + " inListSize:" + list.size() + " outListSize:" + list2.size());
            }
        }
    }

    private void O(ArrayList<common$Msg> arrayList, int i3) {
        int size;
        long j3;
        im_msg_body$CommonElem im_msg_body_commonelem;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("processSystem, msgs size = ");
        if (arrayList == null) {
            size = 0;
        } else {
            size = arrayList.size();
        }
        sb5.append(size);
        sb5.append(", fromType = ");
        sb5.append(i3);
        QLog.d("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 2, sb5.toString());
        if (arrayList == null) {
            return;
        }
        Iterator<common$Msg> it = arrayList.iterator();
        while (it.hasNext()) {
            common$Msg next = it.next();
            if (next.head.has() && next.head.content_head.has()) {
                j3 = next.head.content_head.get().sub_type.get();
            } else {
                j3 = 0;
            }
            if (E(j3)) {
                Iterator<im_msg_body$Elem> it5 = next.body.get().rich_text.get().elems.get().iterator();
                while (true) {
                    if (it5.hasNext()) {
                        im_msg_body$Elem next2 = it5.next();
                        if (next2.common_elem.has()) {
                            im_msg_body_commonelem = next2.common_elem.get();
                            break;
                        }
                    } else {
                        im_msg_body_commonelem = null;
                        break;
                    }
                }
                if (im_msg_body_commonelem != null && 500 == im_msg_body_commonelem.uint32_service_type.get() && j3 != 38) {
                    servtype$EventBody servtype_eventbody = new servtype$EventBody();
                    try {
                        servtype_eventbody.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
                        K(servtype_eventbody);
                        F(servtype_eventbody, next.head);
                        G(servtype_eventbody);
                        J(servtype_eventbody);
                        I(servtype_eventbody, next.head);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                        QLog.e("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "processSystem: error: parse EventBody");
                    }
                }
            }
        }
    }

    private void P(List<MessageRecord> list, int i3) {
        if (list != null && list.size() != 0) {
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext() && it.next() != null) {
            }
        }
    }

    private void Q(MessageRecord messageRecord) {
        com.tencent.imcore.message.f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230314a).F(10014).y(10014);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
        y16.F0(messageRecord.frienduin, 10014, messageRecord.uniseq, contentValues);
    }

    public static void R(com.tencent.mobileqq.guild.message.base.r rVar) {
        if (rVar instanceof com.tencent.mobileqq.guild.message.base.m) {
            f230113c = (com.tencent.mobileqq.guild.message.base.m) rVar;
        }
    }

    private void S(MessageRecord messageRecord) {
        IGuildAioMsgFilterApi.a aVar = new IGuildAioMsgFilterApi.a();
        try {
            aVar.f230115b = messageRecord.shmsgseq;
            aVar.f230116c = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getCntSeqFromMR(messageRecord);
            aVar.f230114a = messageRecord.uniseq;
            ((IGuildAioMsgFilterApi) QRoute.api(IGuildAioMsgFilterApi.class)).updateLatestOnlineMsgMsgSeqItem(messageRecord.frienduin, aVar, false);
        } catch (NumberFormatException e16) {
            QLog.d("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "processPushAfterDecodeMsg, e = " + e16);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.s
    public void a(Object... objArr) {
        if (objArr != null && objArr.length == 3) {
            List<common$Msg> list = (List) objArr[0];
            List<MessageRecord> list2 = (List) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            ArrayList<common$Msg> arrayList = new ArrayList<>();
            N(list, arrayList);
            O(arrayList, intValue);
            P(list2, intValue);
            return;
        }
        n(getClass().getName());
    }
}
