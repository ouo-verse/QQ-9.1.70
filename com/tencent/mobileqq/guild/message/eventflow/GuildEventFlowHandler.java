package com.tencent.mobileqq.guild.message.eventflow;

import android.content.ContentValues;
import bu1.a;
import bu1.c;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.f;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi;
import com.tencent.mobileqq.guild.message.GuildEventFlowObserver;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.group_pro_proto.common.common$Event;
import tencent.im.group_pro_proto.eventflow.msg_event$GetRsp;
import tencent.im.group_pro_proto.eventflow.msg_event$MsgEvent;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildEventFlowHandler extends BusinessHandler implements c {

    /* renamed from: e, reason: collision with root package name */
    private static String f230552e = "GuildEventFlowHandler";

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f230553d;

    public GuildEventFlowHandler(AppInterface appInterface) {
        super(appInterface);
        this.f230553d = new ArrayList<>();
    }

    private List<MessageRecord> D2(String str, String str2, msg_event$GetRsp msg_event_getrsp) {
        f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.appRuntime).F(10014).y(10014);
        ArrayList arrayList = new ArrayList();
        Iterator<msg_event$MsgEvent> it = msg_event_getrsp.msg_events.get().iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().msg_seq.get()));
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > 0) {
            List<MessageRecord> l06 = y16.l0(str, 10014, arrayList);
            HashMap hashMap = new HashMap();
            for (MessageRecord messageRecord : l06) {
                hashMap.put(Long.valueOf(messageRecord.shmsgseq), messageRecord);
            }
            for (msg_event$MsgEvent msg_event_msgevent : msg_event_getrsp.msg_events.get()) {
                MessageRecord messageRecord2 = (MessageRecord) hashMap.get(Long.valueOf(msg_event_msgevent.msg_seq.get()));
                if (E2(str2, str, msg_event_msgevent.msg_seq.get(), messageRecord2, msg_event_msgevent.events.get()) && messageRecord2 != null) {
                    arrayList2.add(messageRecord2);
                }
            }
        }
        return arrayList2;
    }

    private boolean E2(String str, String str2, long j3, MessageRecord messageRecord, List<common$Event> list) {
        String str3;
        if (this.appRuntime instanceof BaseQQAppInterface) {
            String str4 = f230552e;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("applyEventsToMsg. channelId: ");
            sb5.append(str2);
            sb5.append(", shmsgseq: ");
            sb5.append(j3);
            sb5.append(", findMr: ");
            if (messageRecord == null) {
                str3 = "";
            } else {
                str3 = messageRecord.toString();
            }
            sb5.append(str3);
            QLog.i(str4, 2, sb5.toString());
            ((IGuildEventFlowService) this.appRuntime.getRuntimeService(IGuildEventFlowService.class, "")).processEvents(messageRecord, list, str, str2, j3);
            if (messageRecord != null) {
                return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveEventFlowToMsg(messageRecord, new a(list));
            }
            return false;
        }
        return false;
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        InvalidProtocolBufferMicroException invalidProtocolBufferMicroException;
        boolean z18;
        String str = "";
        String string = toServiceMsg.extraData.getString("channelId", "");
        String string2 = toServiceMsg.extraData.getString("guildId", "");
        QLog.i(f230552e, 1, "handlePullEventFlowRsp. resultCode: " + fromServiceMsg.getResultCode());
        int i3 = -1;
        if (fromServiceMsg.getResultCode() == 1000 && obj != null) {
            try {
                msg_event$GetRsp msg_event_getrsp = new msg_event$GetRsp();
                msg_event_getrsp.mergeFrom((byte[]) obj);
                String stringUtf8 = msg_event_getrsp.err_msg.get().toStringUtf8();
                try {
                    i3 = (int) msg_event_getrsp.err_code.get();
                    String str2 = f230552e;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("handlePullEventFlowRsp. errCode:");
                    sb5.append(msg_event_getrsp.err_code.get());
                    sb5.append(", errMsg: ");
                    if (msg_event_getrsp.err_msg.has()) {
                        str = msg_event_getrsp.err_msg.get().toStringUtf8();
                    }
                    sb5.append(str);
                    sb5.append(", errCode: ");
                    sb5.append(msg_event_getrsp.err_code.get());
                    QLog.i(str2, 2, sb5.toString());
                    if (msg_event_getrsp.err_code.get() == 0) {
                        try {
                        } catch (InvalidProtocolBufferMicroException e16) {
                            e = e16;
                            str = stringUtf8;
                            z17 = false;
                        }
                        try {
                            if (msg_event_getrsp.msg_events.has()) {
                                if (msg_event_getrsp.msg_events.size() > 0) {
                                    z18 = true;
                                    I2(string, string2, msg_event_getrsp);
                                    z16 = true;
                                }
                            }
                            I2(string, string2, msg_event_getrsp);
                            z16 = true;
                        } catch (InvalidProtocolBufferMicroException e17) {
                            e = e17;
                            z17 = z18;
                            str = stringUtf8;
                            invalidProtocolBufferMicroException = e;
                            z16 = true;
                            QLog.e(f230552e, 1, "handlePullEventFlowRsp, merge from bytes_bodybuffer, " + invalidProtocolBufferMicroException.toString());
                            ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), str, Boolean.valueOf(z16));
                            notifyUI(GuildEventFlowObserver.f230086e, z16, new Object[]{Boolean.valueOf(z17), string});
                        }
                        z18 = false;
                    } else {
                        z16 = false;
                        z18 = false;
                    }
                    z17 = z18;
                    str = stringUtf8;
                } catch (InvalidProtocolBufferMicroException e18) {
                    str = stringUtf8;
                    z17 = false;
                    invalidProtocolBufferMicroException = e18;
                    z16 = false;
                }
            } catch (InvalidProtocolBufferMicroException e19) {
                invalidProtocolBufferMicroException = e19;
                z16 = false;
                z17 = false;
            }
        } else {
            z16 = false;
            z17 = false;
        }
        ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), str, Boolean.valueOf(z16));
        notifyUI(GuildEventFlowObserver.f230086e, z16, new Object[]{Boolean.valueOf(z17), string});
    }

    private void I2(String str, String str2, msg_event$GetRsp msg_event_getrsp) {
        int i3;
        QLog.i(f230552e, 1, "processEventFlow. channelId: " + str + ", beginTime: " + msg_event_getrsp.begin_time.get() + ", endTime: " + msg_event_getrsp.end_time.get() + ", msg_events size:" + msg_event_getrsp.msg_events.size());
        this.f230553d.add(str);
        ((IGuildMsgSeqTimeService) this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "")).setEventFlowTimeItem(str2, str, msg_event_getrsp.begin_time.get(), msg_event_getrsp.end_time.get(), msg_event_getrsp.cookie.get().toByteArray());
        long currentTimeMillis = System.currentTimeMillis();
        List<MessageRecord> D2 = D2(str, str2, msg_event_getrsp);
        String str3 = f230552e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("processEventFlow. channelId: ");
        sb5.append(str);
        sb5.append("applyEventsToMsg cost time(ms): ");
        sb5.append(System.currentTimeMillis() - currentTimeMillis);
        sb5.append("eventChangeMrList size():");
        if (D2 != null) {
            i3 = D2.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        QLog.i(str3, 1, sb5.toString());
        long currentTimeMillis2 = System.currentTimeMillis();
        if (D2 != null && D2.size() > 0) {
            Iterator<MessageRecord> it = D2.iterator();
            while (it.hasNext()) {
                J2(it.next());
            }
        }
        QLog.i(f230552e, 1, "processEventFlow. channelId: " + str + "saveExtStrToDB cost time(ms): " + (System.currentTimeMillis() - currentTimeMillis2));
        this.appRuntime.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName()).notifyUI(GuildEventFlowObserver.C, true, new Object[]{str, msg_event_getrsp.msg_events.get()});
    }

    private void J2(MessageRecord messageRecord) {
        f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.appRuntime).F(10014).y(10014);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
        y16.F0(messageRecord.frienduin, 10014, messageRecord.uniseq, contentValues);
    }

    public void G2(String str, String str2) {
        uh2.c gProGuildMsgService = ((IGProSession) this.appRuntime.getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.getChannelEventFlow(new GProContact(4, str2, str));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.group_pro.msg_event.MsgEventSvc.Get");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return GuildEventFlowObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        this.f230553d.clear();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.i(f230552e, 1, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("trpc.group_pro.msg_event.MsgEventSvc.Get".equals(fromServiceMsg.getServiceCmd())) {
                H2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        QLog.i(f230552e, 1, "onReceive,resp == null or req == null");
    }

    @Override // bu1.c
    public void p(boolean z16) {
        if (z16) {
            this.f230553d.clear();
        }
        this.appRuntime.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName()).notifyUI(GuildEventFlowObserver.f230090m, true, null);
    }

    public void F2(String str, String str2, boolean z16) {
    }
}
