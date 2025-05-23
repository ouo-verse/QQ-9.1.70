package com.tencent.mobileqq.guild.message;

import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelMsgRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends com.tencent.mobileqq.guild.message.base.q {

    /* renamed from: c, reason: collision with root package name */
    private static com.tencent.mobileqq.guild.message.base.a f230551c;

    public e(AppInterface appInterface) {
        super(appInterface);
    }

    private void E(List<common$Msg> list, List<common$Msg> list2) {
        Pair<Boolean, StringBuilder> w3 = super.w(list, list2);
        if (((Boolean) w3.first).booleanValue() && QLog.isColorLevel()) {
            QLog.d("BaseGuildMessageProcessor.GuildDispersionRoamMessageProcessor", 2, "<---msgFilter_OnePkg " + w3.second + " inListSize:" + list.size() + " outListSize:" + list2.size());
        }
    }

    private void F(synclogic$ChannelMsgRsp synclogic_channelmsgrsp, List<common$Msg> list) {
        int size;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("processDispersionRoamMsg: size = ");
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        QLog.i("BaseGuildMessageProcessor.GuildDispersionRoamMessageProcessor", 1, sb5.toString());
        if (list != null && !list.isEmpty()) {
            B(list, false);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            i(list, arrayList, arrayList2, false);
            String currentAccountUin = this.f230314a.getCurrentAccountUin();
            long j3 = synclogic_channelmsgrsp.channel_msg.channel_id.get();
            ArrayList arrayList3 = new ArrayList();
            Iterator<common$Msg> it = arrayList2.iterator();
            while (it.hasNext()) {
                ArrayList<MessageRecord> e16 = e(it.next(), String.valueOf(currentAccountUin), new com.tencent.mobileqq.troop.data.c(), j3);
                D(arrayList3);
                arrayList3.addAll(e16);
            }
            ArrayList arrayList4 = new ArrayList();
            for (MessageRecord messageRecord : arrayList3) {
                if (l().f0(String.valueOf(j3), 10014, messageRecord.shmsgseq) == null) {
                    arrayList4.add(messageRecord);
                }
            }
            QLog.i("BaseGuildMessageProcessor.GuildDispersionRoamMessageProcessor", 1, "insertToDBMsgList size = " + arrayList4.size() + " channelId = " + j3);
            if (!arrayList4.isEmpty()) {
                Collections.sort(arrayList4, this.f230315b);
                l().d(arrayList4, null);
                return;
            }
            return;
        }
        QLog.e("BaseGuildMessageProcessor.GuildDispersionRoamMessageProcessor", 1, "msgList is empty!");
    }

    public static void G(com.tencent.mobileqq.guild.message.base.r rVar) {
        if (rVar instanceof com.tencent.mobileqq.guild.message.base.a) {
            f230551c = (com.tencent.mobileqq.guild.message.base.a) rVar;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.s
    public void a(Object... objArr) {
        if (objArr != null && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof synclogic$ChannelMsgRsp) {
                synclogic$ChannelMsgRsp synclogic_channelmsgrsp = (synclogic$ChannelMsgRsp) obj;
                ArrayList arrayList = new ArrayList();
                E(synclogic_channelmsgrsp.channel_msg.rpt_msgs.get(), arrayList);
                F(synclogic_channelmsgrsp, arrayList);
                return;
            }
        }
        n(getClass().getName());
    }
}
