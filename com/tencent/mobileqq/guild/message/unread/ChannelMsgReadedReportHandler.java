package com.tencent.mobileqq.guild.message.unread;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import tencent.im.group_pro_proto.group_pro.comm.common$MsgSeq;
import tencent.im.group_pro_proto.oidb0xf6d.Oidb0xf6d$MyChannelInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ChannelMsgReadedReportHandler extends BaseGuildMessageHandler {

    /* renamed from: d, reason: collision with root package name */
    private final String f230816d;

    /* renamed from: e, reason: collision with root package name */
    private a f230817e;

    protected ChannelMsgReadedReportHandler(AppInterface appInterface) {
        super(appInterface);
        this.f230816d = "ChannelMsgReadedReportHandler";
        this.f230817e = new a(this);
    }

    private void D2(List<Oidb0xf6d$MyChannelInfo> list, String str, String str2, int i3, boolean z16) {
        IGuildMsgSeqTimeService.a b16 = c.b(this.appRuntime, str2, c.c(i3));
        QLog.i("ChannelMsgReadedReportHandler", 1, "buildReqBody, lastSeq = " + b16.toString());
        Oidb0xf6d$MyChannelInfo oidb0xf6d$MyChannelInfo = new Oidb0xf6d$MyChannelInfo();
        oidb0xf6d$MyChannelInfo.uint64_guild_id.set(Long.parseLong(str));
        oidb0xf6d$MyChannelInfo.uint64_channel_id.set(Long.parseLong(str2));
        common$MsgSeq common_msgseq = new common$MsgSeq();
        common_msgseq.uint64_seq.set(b16.f230120e);
        common_msgseq.uint64_time.set(b16.f230121f);
        oidb0xf6d$MyChannelInfo.msg_read_cnt_msg_seq.set(common_msgseq);
        common$MsgSeq common_msgseq2 = new common$MsgSeq();
        common_msgseq2.uint64_seq.set(b16.f230119d);
        common_msgseq2.uint64_time.set(b16.f230121f);
        oidb0xf6d$MyChannelInfo.msg_read_msg_seq.set(common_msgseq2);
        if (b16.c() != null) {
            oidb0xf6d$MyChannelInfo.bytes_read_msg_meta.set(ByteStringMicro.copyFrom(b16.c()));
        }
        oidb0xf6d$MyChannelInfo.bool_has_at_me_msg.set(z16);
        list.add(oidb0xf6d$MyChannelInfo);
    }

    private void E2(List<Oidb0xf6d$MyChannelInfo> list, Set<String> set, ArrayList<String> arrayList, String str, boolean z16, int i3, boolean z17) {
        boolean z18;
        IGuildUnreadCntService iGuildUnreadCntService = (IGuildUnreadCntService) this.appRuntime.getRuntimeService(IGuildUnreadCntService.class, "");
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (iGuildUnreadCntService.getChannelUnreadCnt(next, 4).f230840d > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            z17 |= z18;
            if (L2(str, next, i3, z16)) {
                D2(list, str, next, i3, z17);
                set.add(str);
            }
        }
    }

    private void F2(@NonNull String str) {
        IGuildMessageBoxDataService iGuildMessageBoxDataService = (IGuildMessageBoxDataService) this.appRuntime.getRuntimeService(IGuildMessageBoxDataService.class, "");
        if (iGuildMessageBoxDataService != null) {
            iGuildMessageBoxDataService.clearChannelMsgBoxReadEventList(str, 1L);
            iGuildMessageBoxDataService.clearChannelMsgBoxReadEventList(str, 100L);
        }
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        this.f230817e.b(toServiceMsg, fromServiceMsg, obj);
    }

    private boolean L2(String str, String str2, int i3, boolean z16) {
        IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "");
        IGuildMsgSeqTimeService.a readedMsgSeq = iGuildMsgSeqTimeService.getReadedMsgSeq(str2);
        IGuildMsgSeqTimeService.a b16 = c.b(this.appRuntime, str2, c.c(i3));
        if (b16 != null && b16.d() && b16.f230119d != 0) {
            if (!iGuildMsgSeqTimeService.setReadedMsgSeq(str, str2, b16, false) && !z16) {
                if (i3 != 7) {
                    QLog.i("ChannelMsgReadedReportHandler", 1, "sendMsgReadedReport, setReadedMsgSeq return false; from: " + i3);
                }
                return false;
            }
            QLog.i("ChannelMsgReadedReportHandler", 1, "sendMsgReadedReport force:" + z16 + " guildid:" + str + " channelid:" + str2 + " oldReadedMsgSeq:" + readedMsgSeq.toString() + " newReadedMsgSeq:" + b16.toString() + ", from:" + i3);
            F2(str2);
            return true;
        }
        if (i3 != 7) {
            QLog.i("ChannelMsgReadedReportHandler", 1, "sendMsgReadedReport, lastSeq == null || !lastSeq.isValid()");
        }
        return false;
    }

    public void I2(String str, String str2, IGuildMsgSeqTimeService.a aVar) {
        boolean z16;
        if (aVar == null) {
            return;
        }
        IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "");
        IGuildMsgSeqTimeService.a readedMsgSeq = iGuildMsgSeqTimeService.getReadedMsgSeq(str2);
        if (((IGuildUnreadCntService) this.appRuntime.getRuntimeService(IGuildUnreadCntService.class, "")).getChannelUnreadCnt(str2, 4).f230840d > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!iGuildMsgSeqTimeService.setReadedMsgSeq(str, str2, aVar, true)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChannelMsgReadedReportHandler", 2, "sendMsgReadedReport guildid:" + str + " channelid:" + str2 + " oldReadedMsgSeq:" + readedMsgSeq.toString() + " newReadedMsgSeq:" + aVar.toString());
        }
        try {
            long longValue = Long.valueOf(str).longValue();
            long longValue2 = Long.valueOf(str2).longValue();
            Oidb0xf6d$MyChannelInfo oidb0xf6d$MyChannelInfo = new Oidb0xf6d$MyChannelInfo();
            oidb0xf6d$MyChannelInfo.uint64_guild_id.set(longValue);
            oidb0xf6d$MyChannelInfo.uint64_channel_id.set(longValue2);
            common$MsgSeq common_msgseq = new common$MsgSeq();
            common_msgseq.uint64_seq.set(aVar.f230120e);
            common_msgseq.uint64_time.set(aVar.f230121f);
            oidb0xf6d$MyChannelInfo.msg_read_cnt_msg_seq.set(common_msgseq);
            common$MsgSeq common_msgseq2 = new common$MsgSeq();
            common_msgseq2.uint64_seq.set(aVar.f230119d);
            common_msgseq2.uint64_time.set(aVar.f230121f);
            oidb0xf6d$MyChannelInfo.msg_read_msg_seq.set(common_msgseq2);
            if (aVar.c() != null) {
                oidb0xf6d$MyChannelInfo.bytes_read_msg_meta.set(ByteStringMicro.copyFrom(aVar.c()));
            }
            oidb0xf6d$MyChannelInfo.bool_has_at_me_msg.set(z16);
            ArrayList arrayList = new ArrayList();
            arrayList.add(oidb0xf6d$MyChannelInfo);
            H2(arrayList);
        } catch (Exception e16) {
            QLog.e("ChannelMsgReadedReportHandler", 2, e16.toString());
        }
    }

    public void J2(String str, ArrayList<String> arrayList, boolean z16, int i3, boolean z17) {
        if (!TextUtils.isEmpty(str) && arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            E2(arrayList2, new LinkedHashSet(), arrayList, str, z16, i3, z17);
            if (arrayList2.size() == 0) {
                return;
            }
            H2(arrayList2);
        }
    }

    public void K2(LinkedHashMap<String, ArrayList<String>> linkedHashMap, boolean z16, int i3) {
        if (linkedHashMap != null && linkedHashMap.size() != 0) {
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str : linkedHashMap.keySet()) {
                ArrayList<String> arrayList2 = linkedHashMap.get(str);
                if (arrayList2 != null && arrayList2.size() != 0) {
                    E2(arrayList, linkedHashSet, arrayList2, str, z16, i3, false);
                }
            }
            if (arrayList.size() == 0) {
                return;
            }
            H2(arrayList);
        }
    }

    public AppInterface getApp() {
        return this.appRuntime;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0xf6d_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                QLog.e("ChannelMsgReadedReportHandler", 1, "cmdfilter error=" + serviceCmd);
                return;
            }
            if ("OidbSvcTrpcTcp.0xf6d_1".equalsIgnoreCase(serviceCmd)) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        QLog.e("ChannelMsgReadedReportHandler", 1, "onReceive,resp == null or req == null");
    }

    private void H2(List<Oidb0xf6d$MyChannelInfo> list) {
    }
}
