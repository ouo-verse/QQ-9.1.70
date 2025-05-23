package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.data.ChannelMsgEventCollection;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.k;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.group_pro_proto.msg_box.MsgBox$Channel;
import tencent.im.group_pro_proto.msg_box.MsgBox$ChannelEvent;
import tencent.im.group_pro_proto.msg_box.MsgBox$Event;
import tencent.im.group_pro_proto.msg_box.MsgBox$GetChannelEventsRsp;
import tencent.im.group_pro_proto.msg_box.MsgBox$GetRsp;
import tencent.im.group_pro_proto.msg_box.MsgBox$Guild;
import tencent.im.group_pro_proto.synclogic.synclogic$GuildNode;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMessageBoxHandler extends BaseGuildMessageHandler implements st1.c {

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f230136d;

    public GuildMessageBoxHandler(AppInterface appInterface) {
        super(appInterface);
        this.f230136d = appInterface;
    }

    private List<ChannelMsgEventCollection> D2(@NonNull List<MsgBox$Guild> list) {
        Object obj;
        IGuildMessageBoxDataService iGuildMessageBoxDataService = (IGuildMessageBoxDataService) this.f230136d.getRuntimeService(IGuildMessageBoxDataService.class, "");
        ArrayList arrayList = new ArrayList();
        for (MsgBox$Guild msgBox$Guild : list) {
            String valueOf = String.valueOf(msgBox$Guild.guild_id.get());
            for (MsgBox$Channel msgBox$Channel : msgBox$Guild.channels.get()) {
                String valueOf2 = String.valueOf(msgBox$Channel.channel_id.get());
                ChannelMsgEventCollection channelMsgEventCollection = new ChannelMsgEventCollection();
                channelMsgEventCollection.guildId = valueOf;
                channelMsgEventCollection.channelId = valueOf2;
                if (msgBox$Channel.events.has() && !msgBox$Channel.events.isEmpty()) {
                    channelMsgEventCollection.msgEventList = new ArrayList();
                }
                for (MsgBox$Event msgBox$Event : msgBox$Channel.events.get()) {
                    ChannelMsgEvent channelMsgEvent = new ChannelMsgEvent();
                    channelMsgEvent.channelId = valueOf2;
                    channelMsgEvent.eventType = msgBox$Event.event_type.get();
                    channelMsgEvent.msgSeq = msgBox$Event.msg_seq.get();
                    channelMsgEvent.tinyId = String.valueOf(msgBox$Event.from_tinyid.get());
                    channelMsgEvent.eventRandom = msgBox$Event.event_random.get();
                    channelMsgEventCollection.msgEventList.add(channelMsgEvent);
                }
                arrayList.add(channelMsgEventCollection);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("decodeAndSaveGetChannelEventsRsp. adding channelId: ");
                sb5.append(valueOf2);
                sb5.append(", msgEventList size: ");
                List<ChannelMsgEvent> list2 = channelMsgEventCollection.msgEventList;
                if (list2 != null) {
                    obj = Integer.valueOf(list2.size());
                } else {
                    obj = "0";
                }
                sb5.append(obj);
                QLog.i("GuildMessageBoxHandler", 1, sb5.toString());
                iGuildMessageBoxDataService.addChannelMsgBoxEventList(valueOf2, channelMsgEventCollection.msgEventList);
            }
        }
        return arrayList;
    }

    private void E2(@NonNull MsgBox$GetRsp msgBox$GetRsp, @NonNull List<ChannelMsgEventCollection> list) {
        for (MsgBox$ChannelEvent msgBox$ChannelEvent : msgBox$GetRsp.channel_events.get()) {
            ChannelMsgEventCollection channelMsgEventCollection = new ChannelMsgEventCollection();
            channelMsgEventCollection.guildId = String.valueOf(msgBox$ChannelEvent.guild_id.get());
            channelMsgEventCollection.channelId = String.valueOf(msgBox$ChannelEvent.channel_id.get());
            if (msgBox$ChannelEvent.events.has() && msgBox$ChannelEvent.events.size() > 0) {
                channelMsgEventCollection.msgEventList = new ArrayList();
                for (MsgBox$Event msgBox$Event : msgBox$ChannelEvent.events.get()) {
                    ChannelMsgEvent channelMsgEvent = new ChannelMsgEvent();
                    channelMsgEvent.channelId = channelMsgEventCollection.channelId;
                    channelMsgEvent.eventType = msgBox$Event.event_type.get();
                    channelMsgEvent.msgSeq = msgBox$Event.msg_seq.get();
                    channelMsgEvent.tinyId = String.valueOf(msgBox$Event.from_tinyid.get());
                    channelMsgEvent.eventRandom = msgBox$Event.event_random.get();
                    channelMsgEventCollection.msgEventList.add(channelMsgEvent);
                }
            }
            list.add(channelMsgEventCollection);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        boolean z16;
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            MsgBox$GetChannelEventsRsp msgBox$GetChannelEventsRsp = new MsgBox$GetChannelEventsRsp();
            int i3 = -1;
            try {
                msgBox$GetChannelEventsRsp.mergeFrom((byte[]) obj);
                i3 = (int) msgBox$GetChannelEventsRsp.err_code.get();
                str = msgBox$GetChannelEventsRsp.err_msg.get().toStringUtf8();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("GuildMessageBoxHandler", 1, "onFetchChannelMsgEventsResp decode error:" + e16.getMessage());
                e16.printStackTrace();
                str = "";
            }
            if (i3 == 0) {
                z16 = true;
                ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), str, Boolean.valueOf(z16));
                if (z16) {
                    QLog.e("GuildMessageBoxHandler", 1, "onFetchChannelMsgEventsResp rsp failed, errCode: " + msgBox$GetChannelEventsRsp.err_code.get() + " errMsg: " + str);
                    notifyUI(k.f230584f, false, null);
                    return;
                }
                if (!msgBox$GetChannelEventsRsp.guilds.has() || msgBox$GetChannelEventsRsp.guilds.isEmpty()) {
                    QLog.e("GuildMessageBoxHandler", 1, "onFetchChannelMsgEventsResp. guilds empty!");
                    notifyUI(k.f230584f, false, null);
                }
                List<ChannelMsgEventCollection> D2 = D2(msgBox$GetChannelEventsRsp.guilds.get());
                QLog.i("GuildMessageBoxHandler", 1, "onFetchChannelMsgEventsResp rsp success, eventList size: " + D2.size());
                notifyUI(k.f230584f, true, new Object[]{D2});
                return;
            }
            z16 = false;
            ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), str, Boolean.valueOf(z16));
            if (z16) {
            }
        } else {
            QLog.e("GuildMessageBoxHandler", 1, "onFetchChannelMsgEventsResp resp == null || res == null || data == null");
            notifyUI(k.f230584f, false, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        boolean z16;
        List<ChannelMsgEventCollection> list = null;
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            MsgBox$GetRsp msgBox$GetRsp = new MsgBox$GetRsp();
            int i3 = -1;
            try {
                msgBox$GetRsp.mergeFrom((byte[]) obj);
                i3 = (int) msgBox$GetRsp.err_code.get();
                str = msgBox$GetRsp.err_msg.get().toStringUtf8();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("GuildMessageBoxHandler", 1, "onFetchMsgEventListResp decode error:" + e16.getMessage());
                e16.printStackTrace();
                str = "";
            }
            if (i3 == 0) {
                z16 = true;
                ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(7, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), str);
                if (z16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("GuildMessageBoxHandler", 1, "onFetchMsgEventListResp rsp failed, errCode: " + msgBox$GetRsp.err_code.get() + " errMsg: " + str);
                    }
                    notifyUI(k.f230583e, false, null);
                    return;
                }
                if (msgBox$GetRsp.channel_events.has() && msgBox$GetRsp.channel_events.size() > 0) {
                    list = new ArrayList<>();
                    E2(msgBox$GetRsp, list);
                }
                H2(list);
                I2(msgBox$GetRsp);
                notifyUI(k.f230583e, true, new Object[]{list});
                return;
            }
            z16 = false;
            ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(7, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), str);
            if (z16) {
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("GuildMessageBoxHandler", 2, "onFetchMsgEventListResp resp == null || res == null");
            }
            notifyUI(k.f230583e, false, null);
        }
    }

    private void H2(List<ChannelMsgEventCollection> list) {
        int size;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[saveChannelMsgEventList] channelMsgEventList size : ");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            QLog.d("GuildMessageBoxHandler", 2, sb5.toString());
        }
        IGuildMessageBoxDataService iGuildMessageBoxDataService = (IGuildMessageBoxDataService) this.f230136d.getRuntimeService(IGuildMessageBoxDataService.class, "");
        HashSet hashSet = new HashSet();
        if (iGuildMessageBoxDataService != null && list != null) {
            for (ChannelMsgEventCollection channelMsgEventCollection : list) {
                if (channelMsgEventCollection != null) {
                    hashSet.add(channelMsgEventCollection.guildId);
                    iGuildMessageBoxDataService.addChannelMsgBoxEventList(channelMsgEventCollection.channelId, channelMsgEventCollection.msgEventList);
                }
            }
        }
    }

    private void I2(MsgBox$GetRsp msgBox$GetRsp) {
        String str;
        IGuildMessageBoxDataService iGuildMessageBoxDataService;
        try {
            str = new String(msgBox$GetRsp.cookie.get().toByteArray(), "ISO_8859_1");
        } catch (UnsupportedEncodingException e16) {
            QLog.d("GuildMessageBoxHandler", 2, "[saveMessageBoxCookie] exception : " + e16);
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildMessageBoxHandler", 2, "[saveMessageBoxCookie] cookie : " + str);
        }
        if (!TextUtils.isEmpty(str) && (iGuildMessageBoxDataService = (IGuildMessageBoxDataService) this.f230136d.getRuntimeService(IGuildMessageBoxDataService.class, "")) != null) {
            iGuildMessageBoxDataService.setMessageBoxCookie(str);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.group_pro.msg_box.MsgBox.Get");
            this.allowCmdSet.add("trpc.group_pro.msg_box.MsgBox.GetChannelEvents");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return k.class;
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildMessageBoxHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("trpc.group_pro.msg_box.MsgBox.Get".equals(fromServiceMsg.getServiceCmd())) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("trpc.group_pro.msg_box.MsgBox.GetChannelEvents".equals(fromServiceMsg.getServiceCmd())) {
                    F2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildMessageBoxHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // st1.c
    public void B0() {
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
    }

    @Override // st1.c
    public void B1(ArrayList<synclogic$GuildNode> arrayList) {
    }
}
