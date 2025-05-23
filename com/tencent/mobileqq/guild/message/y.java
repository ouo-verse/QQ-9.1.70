package com.tencent.mobileqq.guild.message;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelMsgRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class y extends com.tencent.mobileqq.guild.message.base.q {

    /* renamed from: c, reason: collision with root package name */
    private static com.tencent.mobileqq.guild.message.base.j f230883c;

    public y(AppInterface appInterface) {
        super(appInterface);
    }

    private void G(List<MessageRecord> list, List<MessageRecord> list2, List<MessageRecord> list3, List<MessageRecord> list4, List<MessageRecord> list5) {
        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "handleDeduplicationMsg svrMsgList size = " + list.size() + " filterMsgList size = " + list2.size() + " localList size = " + list3.size());
        Iterator<MessageRecord> it = list2.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            if (((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(next)) {
                QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "handleDeduplicationMsg filterMsgIterator remove seq = " + next.shmsgseq);
                it.remove();
            }
        }
        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "handleDeduplicationMsg filterMsgList size = " + list2.size());
        for (MessageRecord messageRecord : list) {
            MessageRecord messageRecord2 = null;
            boolean z16 = false;
            for (MessageRecord messageRecord3 : list2) {
                if (p.a(this.f230314a, messageRecord3, messageRecord, false, true)) {
                    z16 = true;
                    messageRecord2 = messageRecord3;
                }
            }
            if (!z16) {
                QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "handleDeduplicationMsg !isExistInDB svrMsgRecord = " + messageRecord.shmsgseq);
                list4.add(messageRecord);
                list5.add(messageRecord);
            } else {
                Iterator<MessageRecord> it5 = list3.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    MessageRecord next2 = it5.next();
                    if (!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(next2) && p.a(this.f230314a, next2, messageRecord2, false, true)) {
                        it5.remove();
                        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "handleDeduplicationMsg isExistInDB localMsgIterator remove seq = " + next2.shmsgseq);
                        break;
                    }
                }
                QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "handleDeduplicationMsg isExistInDB addToLocalList seq = " + messageRecord2.shmsgseq);
                list5.add(messageRecord2);
            }
        }
        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "handleDeduplicationMsg result  localList size = " + list3.size() + " insertList size = " + list4.size() + " addToLocalList = " + list5.size());
    }

    private void K(List<common$Msg> list, List<common$Msg> list2) {
        Pair<Boolean, StringBuilder> w3 = super.w(list, list2);
        if (((Boolean) w3.first).booleanValue() && QLog.isColorLevel()) {
            QLog.d("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 2, "<---msgFilter_OnePkg " + ((CharSequence) w3.second) + " inListSize:" + list.size() + " outListSize:" + list2.size());
        }
    }

    private void L(ToServiceMsg toServiceMsg, synclogic$ChannelMsgRsp synclogic_channelmsgrsp, ArrayList<common$Msg> arrayList, String str) {
        int size;
        synclogic$ChannelMsgRsp synclogic_channelmsgrsp2 = synclogic_channelmsgrsp;
        String string = toServiceMsg.extraData.getString("guildId");
        String string2 = toServiceMsg.extraData.getString("channelId");
        long j3 = toServiceMsg.extraData.getLong("lBeginSeq", 0L);
        long j16 = toServiceMsg.extraData.getLong("lEndSeq", 0L);
        Bundle bundle = toServiceMsg.extraData.getBundle("context");
        bundle.putLong("beginSeq", synclogic_channelmsgrsp2.channel_msg.rsp_begin_seq.get());
        bundle.putLong("endSeq", synclogic_channelmsgrsp2.channel_msg.rsp_end_seq.get());
        bundle.putBoolean("success", true);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("processRoam: size:");
        if (arrayList == null) {
            size = 0;
        } else {
            size = arrayList.size();
        }
        sb5.append(size);
        sb5.append(", original beginSeq: ");
        sb5.append(j3);
        sb5.append(", original endSeq: ");
        sb5.append(j16);
        sb5.append(", channelId: ");
        sb5.append(string2);
        sb5.append(", guildId: ");
        sb5.append(string);
        sb5.append(", svr beginSeq: ");
        sb5.append(synclogic_channelmsgrsp2.channel_msg.rsp_begin_seq.get());
        sb5.append(", svr endSeq: ");
        sb5.append(synclogic_channelmsgrsp2.channel_msg.rsp_end_seq.get());
        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, sb5.toString());
        if (arrayList != null && !arrayList.isEmpty()) {
            B(arrayList, false);
            List<common$Msg> arrayList2 = new ArrayList<>();
            List<common$Msg> arrayList3 = new ArrayList<>();
            i(arrayList, arrayList2, arrayList3, false);
            ArrayList<MessageRecord> arrayList4 = new ArrayList<>();
            ArrayList arrayList5 = new ArrayList();
            for (common$Msg common_msg : arrayList3) {
                com.tencent.mobileqq.troop.data.c cVar = new com.tencent.mobileqq.troop.data.c();
                ArrayList<MessageRecord> e16 = e(common_msg, String.valueOf(str), cVar, synclogic_channelmsgrsp2.get_msg_time.get());
                D(e16);
                b(e16);
                com.tencent.mobileqq.guild.message.base.j jVar = f230883c;
                if (jVar != null) {
                    jVar.a(this.f230314a, e16, cVar);
                }
                arrayList4.addAll(e16);
                if (v(common_msg)) {
                    arrayList5.addAll(e16);
                }
                synclogic_channelmsgrsp2 = synclogic_channelmsgrsp;
            }
            Collections.sort(arrayList4, this.f230315b);
            ArrayList<MessageRecord> arrayList6 = new ArrayList<>();
            I(String.valueOf(string2), 10014, arrayList4, arrayList6, bundle);
            o(arrayList2, arrayList5, 0);
            E(arrayList4, arrayList6);
            QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "processRoam total cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", channelId: " + string2);
            return;
        }
        QLog.e("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "msgs is empty! notify locallist");
        IMessageFacade F = F();
        List<MessageRecord> list = F.getPullCache().get(Integer.valueOf(bundle.getInt("counter")));
        F.getPullCache().remove(Integer.valueOf(bundle.getInt("counter")));
        if (list != null) {
            synchronized (list) {
                list.notify();
            }
        }
    }

    public static void M(com.tencent.mobileqq.guild.message.base.r rVar) {
        if (rVar instanceof com.tencent.mobileqq.guild.message.base.j) {
            f230883c = (com.tencent.mobileqq.guild.message.base.j) rVar;
        }
    }

    private boolean N(MessageRecord messageRecord, List<MessageRecord> list, boolean z16) {
        if (z16) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 2, "refresh roam msg rewrite sending msg  mr.senderuin: " + messageRecord.senderuin + " mr.msgtype: " + messageRecord.msgtype + " mr.frienduin: " + messageRecord.frienduin + " mr.shmsgseq: " + messageRecord.shmsgseq + " mr.time:" + messageRecord.time + " mr.msg: " + messageRecord.getLogColorContent());
        }
        String selfTinyId = ((IGPSService) this.f230314a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        String str = messageRecord.senderuin;
        if (str != null && str.equalsIgnoreCase(selfTinyId)) {
            MessageRecord y16 = l().y(list, messageRecord);
            if (y16 != null) {
                ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).updateMsgSeqAndTime(this.f230314a, y16.uniseq, messageRecord);
                return true;
            }
            messageRecord.issend = 2;
        }
        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "handleRefreshMsgDeduplicationNotExist add msg msgSeq = " + messageRecord.shmsgseq);
        messageRecord.isread = true;
        return false;
    }

    void E(ArrayList<MessageRecord> arrayList, ArrayList<MessageRecord> arrayList2) {
        f230883c.b(this.f230314a, arrayList, arrayList2);
    }

    public IMessageFacade F() {
        return (IMessageFacade) this.f230314a.getRuntimeService(IMessageFacade.class, "");
    }

    public void H(List<MessageRecord> list, List<MessageRecord> list2) {
        boolean z16;
        ListIterator<MessageRecord> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            MessageRecord next = listIterator.next();
            Iterator<MessageRecord> it = list2.iterator();
            while (true) {
                z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                if (p.a(this.f230314a, it.next(), next, false, true)) {
                    z16 = true;
                    break;
                }
            }
            if (N(next, list2, z16)) {
                listIterator.remove();
            } else {
                QLog.d("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "doRefreshMessageListHead() refresh roam step 2 , mr.msg = " + next.getLogColorContent() + " , mr.seq = " + next.shmsgseq + " , mr.msgtype = " + next.msgtype + ", isExist = " + z16 + " , extra = " + next.extraflag);
            }
        }
    }

    public void I(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, Bundle bundle) {
        long j3;
        long j16;
        int size;
        long j17;
        long j18;
        List<MessageRecord> list3;
        List<MessageRecord> list4;
        int i16;
        List<MessageRecord> list5;
        long j19;
        com.tencent.imcore.message.f fVar;
        long j26;
        boolean z16 = bundle.getBoolean("key_from_parallel_pull", false);
        IMessageFacade F = F();
        com.tencent.imcore.message.f l3 = l();
        boolean z17 = bundle.getBoolean("success");
        if (list != null && !list.isEmpty()) {
            j3 = list.get(0).shmsgseq;
            j16 = list.get(list.size() - 1).shmsgseq;
        } else {
            j3 = -1;
            j16 = -1;
        }
        List<MessageRecord> list6 = F.getPullCache().get(Integer.valueOf(bundle.getInt("counter")));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doRefreshMessageListHead() refresh roam step 1 , resultSize = ");
        int i17 = -1;
        if (list == null) {
            size = -1;
        } else {
            size = list.size();
        }
        sb5.append(size);
        sb5.append(", localListSize = ");
        if (list6 != null) {
            i17 = list6.size();
        }
        sb5.append(i17);
        sb5.append(" , success = ");
        sb5.append(z17);
        sb5.append(" , svr beginSeq = ");
        sb5.append(j3);
        sb5.append(" , svr endSeq = ");
        sb5.append(j16);
        sb5.append(" , ctx beginSeq: ");
        long j27 = j16;
        sb5.append(bundle.getLong("beginSeq", -1L));
        sb5.append(", ctx endSeq: ");
        sb5.append(bundle.getLong("endSeq", -1L));
        sb5.append(" , time = [");
        sb5.append(System.currentTimeMillis());
        sb5.append("]");
        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, sb5.toString());
        F.getPullCache().remove(Integer.valueOf(bundle.getInt("counter")));
        if (list6 != null) {
            if (list2 == null) {
                list3 = new ArrayList();
            } else {
                list3 = list2;
            }
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                long j28 = j3 - 15;
                if (j28 > 0) {
                    j26 = j28;
                } else {
                    j26 = 0;
                }
                j19 = j27;
                List<MessageRecord> o06 = l3.o0(str, i3, j26, j19);
                H(list, o06);
                list5 = list6;
                list4 = list3;
                j17 = j3;
                i16 = 1;
                fVar = l3;
                G(list, o06, list5, list4, arrayList);
                QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "handleRefreshMessageListHeadResult: svrMsgList size: " + list.size() + ", addToLocalList size: " + arrayList.size());
            } else {
                list4 = list3;
                j17 = j3;
                i16 = 1;
                list5 = list6;
                j19 = j27;
                fVar = l3;
            }
            Iterator<MessageRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
            if (!list4.isEmpty()) {
                Collections.sort(list4, this.f230315b);
                fVar.d(list4, null);
                QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", i16, "addMessageSync. insertList size: " + list4.size());
            }
            Iterator<MessageRecord> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                J(list5, it5.next());
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("handleRefreshMessageListHeadResult. notify locallist. , beginSeq: ");
            sb6.append(j17);
            sb6.append(", endSeq: ");
            j18 = j19;
            sb6.append(j18);
            sb6.append(", locallist size: ");
            sb6.append(list5.size());
            QLog.i("BaseGuildMessageProcessor.GuildRoamMessageProcessor", i16, sb6.toString());
            synchronized (list5) {
                list5.notify();
            }
        } else {
            j17 = j3;
            j18 = j27;
        }
        if (z16) {
            F.clearInAioParallerPullMsgMark(str, j17, j18);
        }
    }

    public void J(List<MessageRecord> list, MessageRecord messageRecord) {
        if (messageRecord.getId() < 0) {
            QLog.e("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "handleRefreshRoamMsg. Insert db error ! , mr.msg = " + messageRecord.getLogColorContent() + " , mr.seq = " + messageRecord.shmsgseq + " , mr.uniseq = " + messageRecord.uniseq + " , extra = " + messageRecord.extraflag);
            return;
        }
        ad.p(list, messageRecord, true);
        if (QLog.isColorLevel()) {
            QLog.d("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 2, "doRefreshMessageListHead() refresh roam step 3 , mr.msg = " + messageRecord.getLogColorContent() + " , mr.seq = " + messageRecord.shmsgseq + " , mr.uniseq = " + messageRecord.uniseq + " , extra = " + messageRecord.extraflag);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.s
    public void a(Object... objArr) {
        if (objArr != null && objArr.length == 4) {
            ArrayList<common$Msg> arrayList = new ArrayList<>();
            K((ArrayList) objArr[2], arrayList);
            L((ToServiceMsg) objArr[0], (synclogic$ChannelMsgRsp) objArr[1], arrayList, (String) objArr[3]);
            return;
        }
        n(getClass().getName());
    }

    @Override // com.tencent.mobileqq.guild.message.base.q
    public com.tencent.imcore.message.f l() {
        return ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageProxy((BaseQQAppInterface) this.f230314a, 10014);
    }
}
