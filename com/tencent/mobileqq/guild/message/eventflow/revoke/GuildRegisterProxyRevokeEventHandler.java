package com.tencent.mobileqq.guild.message.eventflow.revoke;

import androidx.annotation.NonNull;
import bu1.a;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.eventflow.revoke.a;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.w;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.group_pro_proto.eventflow.msg_event$GetBatchRsp;
import tencent.im.group_pro_proto.eventflow.msg_event$GuildEvents;
import tencent.im.group_pro_proto.synclogic.synclogic$GuildNode;

/* loaded from: classes14.dex */
public class GuildRegisterProxyRevokeEventHandler extends BusinessHandler implements b {

    /* renamed from: d, reason: collision with root package name */
    private final IGuildUnreadCntService f230555d;

    /* renamed from: e, reason: collision with root package name */
    private final IGuildMsgSeqTimeService f230556e;

    /* renamed from: f, reason: collision with root package name */
    private final IGuildMessageBoxDataService f230557f;

    protected GuildRegisterProxyRevokeEventHandler(AppInterface appInterface) {
        super(appInterface);
        this.f230555d = (IGuildUnreadCntService) this.appRuntime.getRuntimeService(IGuildUnreadCntService.class, "");
        this.f230556e = (IGuildMsgSeqTimeService) this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "");
        this.f230557f = (IGuildMessageBoxDataService) this.appRuntime.getRuntimeService(IGuildMessageBoxDataService.class, "");
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (QLog.isColorLevel()) {
            QLog.i("GuildRegisterProxyRevokeEventHandler", 2, "handlePullRevokeEventFlowRsp. resultCode: " + fromServiceMsg.getResultCode());
        }
        String str = "";
        int i3 = -1;
        if (fromServiceMsg.getResultCode() == 1000 && obj != null) {
            try {
                msg_event$GetBatchRsp msg_event_getbatchrsp = new msg_event$GetBatchRsp();
                msg_event_getbatchrsp.mergeFrom((byte[]) obj);
                i3 = (int) msg_event_getbatchrsp.err_code.get();
                String stringUtf8 = msg_event_getbatchrsp.err_msg.get().toStringUtf8();
                try {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("handlePullRevokeEventFlowRsp. errCode:");
                    sb5.append(msg_event_getbatchrsp.err_code.get());
                    sb5.append(", errMsg: ");
                    if (msg_event_getbatchrsp.err_msg.has()) {
                        str = msg_event_getbatchrsp.err_msg.get().toStringUtf8();
                    }
                    sb5.append(str);
                    sb5.append(", errCode: ");
                    sb5.append(msg_event_getbatchrsp.err_code.get());
                    QLog.i("GuildRegisterProxyRevokeEventHandler", 1, sb5.toString());
                    if (msg_event_getbatchrsp.err_code.get() == 0) {
                        try {
                        } catch (InvalidProtocolBufferMicroException e16) {
                            e = e16;
                            str = stringUtf8;
                            z17 = false;
                        }
                        try {
                            if (msg_event_getbatchrsp.guilds.has()) {
                                if (msg_event_getbatchrsp.guilds.size() > 0) {
                                    z17 = true;
                                    G2(msg_event_getbatchrsp);
                                    z16 = true;
                                }
                            }
                            G2(msg_event_getbatchrsp);
                            z16 = true;
                        } catch (InvalidProtocolBufferMicroException e17) {
                            e = e17;
                            str = stringUtf8;
                            z18 = true;
                            QLog.e("GuildRegisterProxyRevokeEventHandler", 1, "handlePullRevokeEventFlowRsp, merge from bytes_bodybuffer, " + e.toString());
                            z16 = z18;
                            ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), str, Boolean.valueOf(z16));
                            notifyUI(w.f230881e, z16, new Object[]{Boolean.valueOf(z17)});
                        }
                        z17 = false;
                    } else {
                        z16 = false;
                        z17 = false;
                    }
                    str = stringUtf8;
                } catch (InvalidProtocolBufferMicroException e18) {
                    e = e18;
                    str = stringUtf8;
                    z18 = false;
                    z17 = false;
                    QLog.e("GuildRegisterProxyRevokeEventHandler", 1, "handlePullRevokeEventFlowRsp, merge from bytes_bodybuffer, " + e.toString());
                    z16 = z18;
                    ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), str, Boolean.valueOf(z16));
                    notifyUI(w.f230881e, z16, new Object[]{Boolean.valueOf(z17)});
                }
            } catch (InvalidProtocolBufferMicroException e19) {
                e = e19;
            }
        } else {
            z16 = false;
            z17 = false;
        }
        ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), str, Boolean.valueOf(z16));
        notifyUI(w.f230881e, z16, new Object[]{Boolean.valueOf(z17)});
    }

    @NonNull
    private ArrayList<a> E2(msg_event$GetBatchRsp msg_event_getbatchrsp) {
        ArrayList<a> arrayList = new ArrayList<>();
        for (msg_event$GuildEvents msg_event_guildevents : msg_event_getbatchrsp.guilds.get()) {
            if (msg_event_guildevents != null) {
                a aVar = new a();
                aVar.b(msg_event_guildevents);
                arrayList.add(aVar);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildRegisterProxyRevokeEventHandler", 2, "processRevokeEventFlow. guildRevokeEventList: " + arrayList.toString());
        }
        return arrayList;
    }

    private void F2(String str, String str2, List<a.b> list) {
        for (a.b bVar : list) {
            bu1.a aVar = bVar.f230568c;
            if (aVar != null) {
                Iterator<a.b> it = aVar.f29142a.iterator();
                while (it.hasNext()) {
                    H2(str, str2, bVar, it.next());
                }
            }
        }
    }

    private void G2(msg_event$GetBatchRsp msg_event_getbatchrsp) {
        if (msg_event_getbatchrsp != null && msg_event_getbatchrsp.guilds.has()) {
            Iterator<a> it = E2(msg_event_getbatchrsp).iterator();
            while (it.hasNext()) {
                a next = it.next();
                String valueOf = String.valueOf(next.f230559a);
                for (a.C7853a c7853a : next.f230560b) {
                    F2(valueOf, String.valueOf(c7853a.f230561a), c7853a.f230565e);
                }
            }
            return;
        }
        QLog.e("GuildRegisterProxyRevokeEventHandler", 1, "processRevokeEventFlow, getBatchRsp == null");
    }

    private void H2(String str, String str2, a.b bVar, a.b bVar2) {
        long j3 = bVar2.f29146a;
        if (j3 == 1 || j3 == 2) {
            DecreaseMsgSeqInfo decreaseMsgSeqInfo = new DecreaseMsgSeqInfo();
            decreaseMsgSeqInfo.msgSeq = bVar.f230566a;
            if (bVar2.f29152g == 1) {
                decreaseMsgSeqInfo.msgType = DecreaseMsgSeqInfo.MSGTYPE_ATALL;
            }
            this.f230556e.addDecreaseMsgSeq(str, str2, decreaseMsgSeqInfo);
            ChannelMsgEvent channelMsgEvent = new ChannelMsgEvent();
            channelMsgEvent.channelId = str2;
            channelMsgEvent.eventType = 1L;
            channelMsgEvent.msgSeq = bVar.f230566a;
            this.f230557f.removeChannelMsgBoxReadEvent(channelMsgEvent);
            channelMsgEvent.eventType = 100L;
            this.f230557f.removeChannelMsgBoxReadEvent(channelMsgEvent);
            QLog.i("GuildRegisterProxyRevokeEventHandler", 1, "processRevokeEventFlow, addDecreaseMsgSeq, guildId:" + str + ", channelId:" + str2 + ", DecreaseMsgSeqInfo:" + decreaseMsgSeqInfo.toString());
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.group_pro.msg_event.MsgEventSvc.GetBatch");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return w.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildRegisterProxyRevokeEventHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("trpc.group_pro.msg_event.MsgEventSvc.GetBatch".equals(fromServiceMsg.getServiceCmd())) {
                D2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildRegisterProxyRevokeEventHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.guild.message.eventflow.revoke.b
    public void E0(ArrayList<synclogic$GuildNode> arrayList, long j3) {
    }
}
