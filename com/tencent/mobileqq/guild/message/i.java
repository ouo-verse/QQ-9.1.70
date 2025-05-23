package com.tencent.mobileqq.guild.message;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.ao;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.summary.GuestNextPullSummaryMsgParams;
import com.tencent.mobileqq.guild.message.summary.GuildGuestNextPullSummaryParamsRepository;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import kotlin.jvm.functions.Function0;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelMsg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i extends com.tencent.mobileqq.guild.message.base.q {

    /* renamed from: c, reason: collision with root package name */
    private static com.tencent.mobileqq.guild.message.base.b f230579c;

    public i(AppInterface appInterface) {
        super(appInterface);
    }

    private void G(ArrayList<MessageRecord> arrayList, long j3, String str, com.tencent.imcore.message.f fVar) {
        List<MessageRecord> list = fVar.I().b().get(ao.f(str, 10014));
        if (list == null) {
            return;
        }
        Lock e16 = fVar.I().e(str, 10014);
        e16.lock();
        try {
            MessageRecord messageRecord = (MessageRecord) L(list);
            if (messageRecord != null) {
                long j16 = messageRecord.shmsgseq;
                if (j3 <= j16) {
                    Iterator<MessageRecord> it = arrayList.iterator();
                    while (it.hasNext()) {
                        MessageRecord next = it.next();
                        if (next.shmsgseq > j16) {
                            ad.o(list, next, false);
                        }
                    }
                    return;
                }
            }
            list.addAll(arrayList);
        } finally {
            e16.unlock();
        }
    }

    private ArrayList<MessageRecord> H(synclogic$ChannelMsg synclogic_channelmsg) {
        final long j3 = synclogic_channelmsg.guild_id.get();
        final long j16 = synclogic_channelmsg.channel_id.get();
        Logger logger = Logger.f235387a;
        logger.a("BaseGuildMessageProcessor.GuildGuestMessageProcessor", new Function0() { // from class: com.tencent.mobileqq.guild.message.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String J;
                J = i.J(j3, j16);
                return J;
            }
        });
        ArrayList arrayList = new ArrayList();
        w(synclogic_channelmsg.get().rpt_msgs.get(), arrayList);
        if (arrayList.isEmpty()) {
            logger.a("BaseGuildMessageProcessor.GuildGuestMessageProcessor", new Function0() { // from class: com.tencent.mobileqq.guild.message.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String K;
                    K = i.K(j3, j16);
                    return K;
                }
            });
        }
        ArrayList<MessageRecord> arrayList2 = new ArrayList<>();
        Iterator<common$Msg> it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList<MessageRecord> e16 = e(it.next(), this.f230314a.getCurrentAccountUin(), new com.tencent.mobileqq.troop.data.c(), -1L);
            D(e16);
            arrayList2.addAll(e16);
        }
        Collections.sort(arrayList2, this.f230315b);
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String J(long j3, long j16) {
        return "decodeGuestMsg: guildId:" + j3 + ", channelId: " + j16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String K(long j3, long j16) {
        return "decodeGuestMsg: guildId:" + j3 + ", channelId: " + j16 + "processGuestMsg: size null";
    }

    private void M(Bundle bundle, ArrayList<MessageRecord> arrayList) {
        if (bundle == null) {
            return;
        }
        IMessageFacade iMessageFacade = (IMessageFacade) this.f230314a.getRuntimeService(IMessageFacade.class, "");
        List<MessageRecord> list = iMessageFacade.getPullCache().get(Integer.valueOf(bundle.getInt("counter")));
        iMessageFacade.getPullCache().remove(Integer.valueOf(bundle.getInt("counter")));
        if (list != null) {
            if (arrayList != null) {
                Iterator<MessageRecord> it = arrayList.iterator();
                while (it.hasNext()) {
                    ad.p(list, it.next(), true);
                }
            }
            QLog.i("BaseGuildMessageProcessor.GuildGuestMessageProcessor", 1, "notifyLocalList, counter: " + bundle.getInt("counter"));
            synchronized (list) {
                list.notify();
            }
            return;
        }
        QLog.e("BaseGuildMessageProcessor.GuildGuestMessageProcessor", 1, "notifyLocalList, locallist is null! counter: " + bundle.getInt("counter"));
    }

    private void N(Object... objArr) {
        List<synclogic$ChannelMsg> list = (List) objArr[1];
        int i3 = ((Bundle) objArr[2]).getInt("pull_multi_msg_sub_type");
        long currentTimeMillis = System.currentTimeMillis();
        for (synclogic$ChannelMsg synclogic_channelmsg : list) {
            ArrayList<MessageRecord> H = H(synclogic_channelmsg);
            String valueOf = String.valueOf(synclogic_channelmsg.channel_id.get());
            Iterator<MessageRecord> it = H.iterator();
            while (it.hasNext()) {
                Q(it.next());
            }
            if (synclogic_channelmsg.polling_interval.has()) {
                long j3 = synclogic_channelmsg.polling_interval.get();
                if (j3 > 0) {
                    GuildGuestNextPullSummaryParamsRepository.f230809d.c(valueOf, new GuestNextPullSummaryMsgParams(synclogic_channelmsg.rsp_end_seq.get(), j3 + currentTimeMillis));
                }
            }
            long j16 = synclogic_channelmsg.rsp_begin_seq.get();
            com.tencent.imcore.message.f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230314a).F(10014).y(10014);
            if (i3 == 2) {
                y16.g(String.valueOf(valueOf), 10014, j16, H);
            } else if (i3 == 4) {
                G(H, j16, valueOf, y16);
            }
        }
    }

    private void O(Object... objArr) {
        List list = (List) objArr[1];
        Bundle bundle = (Bundle) objArr[2];
        int i3 = bundle.getInt("pull_multi_msg_sub_type");
        synclogic$ChannelMsg synclogic_channelmsg = (synclogic$ChannelMsg) I(list);
        if (synclogic_channelmsg != null && !synclogic_channelmsg.rpt_msgs.get().isEmpty()) {
            M(bundle, H(synclogic_channelmsg));
        } else if (i3 == 3) {
            M(bundle, null);
        }
    }

    public static void P(com.tencent.mobileqq.guild.message.base.r rVar) {
        if (rVar instanceof com.tencent.mobileqq.guild.message.base.b) {
            f230579c = (com.tencent.mobileqq.guild.message.base.b) rVar;
        }
    }

    private void Q(MessageRecord messageRecord) {
        ((m) ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230314a).F(10014)).g1(messageRecord, null);
    }

    <T> T I(List<T> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    <T> T L(List<T> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.base.s
    public void a(Object... objArr) {
        if (objArr != null && objArr.length > 1) {
            Object obj = objArr[0];
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                if (intValue != 2) {
                    if (intValue == 3) {
                        O(objArr);
                        return;
                    }
                    return;
                }
                N(objArr);
            }
        }
    }
}
