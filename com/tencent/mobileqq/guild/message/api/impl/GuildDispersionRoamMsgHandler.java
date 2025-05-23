package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.n;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import st1.o;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelMsgRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildDispersionRoamMsgHandler extends BaseGuildMessageHandler implements st1.b {

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<Long, o> f230129d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicLong f230130e;

    protected GuildDispersionRoamMsgHandler(AppInterface appInterface) {
        super(appInterface);
        this.f230129d = new ConcurrentHashMap<>();
        this.f230130e = new AtomicLong(1L);
    }

    private void D2(long j3, int i3, String str) {
        QLog.i("GuildDispersionRoamMsgHandler", 1, "fetch DispersionMsg do callbackResult pullSeq = " + j3 + " " + str + " " + i3);
        o oVar = this.f230129d.get(Long.valueOf(j3));
        if (oVar != null) {
            oVar.onResult(i3, str);
        }
    }

    @Override // st1.b
    public boolean J0(String str, String str2, List<Long> list, o oVar) {
        return true;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            this.allowCmdSet = new HashSet();
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return n.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg.extraData.getInt("roam_msg_pull_type") != 2) {
            return;
        }
        ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(3, toServiceMsg, fromServiceMsg, obj);
        long j3 = toServiceMsg.extraData.getLong("pull_dispersion_roam_msg_seq");
        String string = toServiceMsg.extraData.getString("channelId");
        int resultCode = fromServiceMsg.getResultCode();
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        if (resultCode != 1000) {
            QLog.i("GuildDispersionRoamMsgHandler", 1, "fetch DispersionMsg onReceive Error " + resultCode + " " + businessFailMsg + " " + string);
            D2(j3, resultCode, businessFailMsg);
            return;
        }
        synclogic$ChannelMsgRsp synclogic_channelmsgrsp = new synclogic$ChannelMsgRsp();
        try {
            QLog.i("GuildDispersionRoamMsgHandler", 1, "fetch DispersionMsg begin process " + string);
            synclogic_channelmsgrsp.mergeFrom((byte[]) obj);
            synchronized (((IGuildMsgFactory) this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().a(string)) {
                ((IGuildMsgFactory) this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(6).a(synclogic_channelmsgrsp);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("GuildDispersionRoamMsgHandler", 2, "<--- handleReqPullRoamMsg() mergeFrom exception ! ", e16);
            }
        }
        D2(j3, resultCode, businessFailMsg);
    }
}
