package com.tencent.mobileqq.guild.message;

import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.impl.onlinepush.GuildMessagePushHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.common.common$MsgMeta;

/* compiled from: P */
/* loaded from: classes14.dex */
public class q extends com.tencent.mobileqq.guild.message.base.q {

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.guild.message.api.impl.onlinepush.f f230727c;

    /* renamed from: d, reason: collision with root package name */
    private long f230728d;

    /* renamed from: e, reason: collision with root package name */
    private long f230729e;

    public q(AppInterface appInterface) {
        super(appInterface);
        this.f230727c = new com.tencent.mobileqq.guild.message.api.impl.onlinepush.f(5000);
        this.f230728d = 0L;
        this.f230729e = 0L;
    }

    private String E(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        common$MsgMeta common_msgmeta = new common$MsgMeta();
        try {
            common_msgmeta.mergeFrom(bArr);
            return " (at_all_seq: " + common_msgmeta.at_all_seq.get() + ", channel_box_seq: " + common_msgmeta.channel_box_seq.get() + ")";
        } catch (Exception unused) {
            return "error processing. msgMeta size: " + bArr.length;
        }
    }

    private void F(List<common$Msg> list, int i3) {
        Iterator<common$Msg> it;
        long j3;
        if (list != null && list.size() != 0) {
            new HashSet();
            HashMap hashMap = new HashMap();
            long uptimeMillis = SystemClock.uptimeMillis();
            Iterator<common$Msg> it5 = list.iterator();
            while (it5.hasNext()) {
                common$Msg next = it5.next();
                if (next != null && next.msg_core.has()) {
                    String valueOf = String.valueOf(next.msg_core.guild_id.get());
                    String valueOf2 = String.valueOf(next.msg_core.channel_id.get());
                    long j16 = next.msg_core.cnt_seq.get();
                    long j17 = next.msg_core.msg_seq.get();
                    long j18 = next.msg_core.msg_time.get();
                    byte[] byteArray = next.msg_core.msg_meta.get().toByteArray();
                    byte[] byteArray2 = next.msg_core.token.get().toByteArray();
                    it = it5;
                    StringBuilder sb5 = new StringBuilder();
                    j3 = uptimeMillis;
                    sb5.append("processPush. guildId: ");
                    sb5.append(valueOf);
                    sb5.append(", channelId: ");
                    sb5.append(valueOf2);
                    sb5.append(", shmsgSeq: ");
                    sb5.append(j17);
                    sb5.append(", cntSeq: ");
                    sb5.append(j16);
                    sb5.append(", msgTime: ");
                    sb5.append(j18);
                    sb5.append(", msgMeta: ");
                    sb5.append(E(byteArray));
                    QLog.i("BaseGuildMessageProcessor.GuildOnlineCoreMessageProcessor", 1, sb5.toString());
                    IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) this.f230314a.getRuntimeService(IGuildMsgSeqTimeService.class, "");
                    iGuildMsgSeqTimeService.setLastSvrMsgSeq(valueOf, valueOf2, new IGuildMsgSeqTimeService.a(j17, j16, j18, byteArray), false);
                    hashMap.put(valueOf2, valueOf);
                    iGuildMsgSeqTimeService.setLatestMsgToken(valueOf2, j17, byteArray2);
                    G(valueOf);
                } else {
                    it = it5;
                    j3 = uptimeMillis;
                    QLog.e("BaseGuildMessageProcessor.GuildOnlineCoreMessageProcessor", 1, "processPush error. msg or msgCore is null!");
                }
                it5 = it;
                uptimeMillis = j3;
            }
            this.f230728d += list.size();
            this.f230729e += SystemClock.uptimeMillis() - uptimeMillis;
            if (this.f230727c.a("processPush")) {
                QLog.i("BaseGuildMessageProcessor.GuildOnlineCoreMessageProcessor", 1, "processPush msgCounter:" + this.f230728d + " msgCostTime:" + this.f230729e);
            }
        }
    }

    private void G(String str) {
        ((GuildMessagePushHandler) this.f230314a.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildPushMsgHandlerName())).K2().s().n(str);
    }

    @Override // com.tencent.mobileqq.guild.message.base.s
    public void a(Object... objArr) {
        if (objArr != null && objArr.length == 2) {
            F((List) objArr[0], ((Integer) objArr[1]).intValue());
        } else {
            n(getClass().getName());
        }
    }
}
