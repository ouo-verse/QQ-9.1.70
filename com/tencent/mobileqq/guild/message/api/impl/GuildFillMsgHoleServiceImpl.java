package com.tencent.mobileqq.guild.message.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildFillMsgHoleService;
import com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.IGuildRoamMessageHandler;
import com.tencent.mobileqq.guild.message.api.impl.onlinepush.GuildMessagePushHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import tencent.im.group_pro_proto.common.common$Msg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildFillMsgHoleServiceImpl implements IGuildFillMsgHoleService {
    private static final int MAX_FILL_MSG_TIMER = 10;
    private static final int MAX_PULL_MSG_PB_TIMEOUT = 2000;
    private static final int MAX_PULL_MSG_SIZE = 15;
    private static final String TAG = "GuildFillMsgHoleServiceImpl";
    private static b activeChannelInfo = new b();
    private static AtomicLong pullMsgSeq = new AtomicLong(1);
    private AppInterface app;
    private Comparator guildMsgComparator = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Comparator<common$Msg> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(common$Msg common_msg, common$Msg common_msg2) {
            if (GuildFillMsgHoleServiceImpl.this.getMsgSeq(common_msg) != GuildFillMsgHoleServiceImpl.this.getMsgSeq(common_msg2)) {
                return (int) (GuildFillMsgHoleServiceImpl.this.getMsgSeq(common_msg) - GuildFillMsgHoleServiceImpl.this.getMsgSeq(common_msg2));
            }
            return (!GuildFillMsgHoleServiceImpl.this.isRoamMsg(common_msg) ? 1 : 0) - (!GuildFillMsgHoleServiceImpl.this.isRoamMsg(common_msg2) ? 1 : 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private long f230132a = com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B;

        /* renamed from: b, reason: collision with root package name */
        private int f230133b = 0;

        b() {
        }

        public int a() {
            return this.f230133b;
        }

        public void b() {
            this.f230132a = com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B;
            this.f230133b = 10;
        }
    }

    private long fingMaxConsecutiveSeq(List<Long> list) {
        int size = list.size();
        if (size == 1) {
            return list.get(0).longValue();
        }
        long longValue = list.get(size - 1).longValue();
        for (int i3 = size - 2; i3 >= 0 && list.get(i3).longValue() == longValue - 1; i3--) {
            longValue = list.get(i3).longValue();
        }
        return longValue;
    }

    private long getLastMsgSeqInAioMsgList(String str) {
        List<MessageRecord> l3 = getMsgProxy().l(str, 10014);
        if (l3 == null) {
            return Long.MAX_VALUE;
        }
        if (l3.size() > 0) {
            ListIterator<MessageRecord> listIterator = l3.listIterator(l3.size());
            while (listIterator.hasPrevious()) {
                MessageRecord previous = listIterator.previous();
                if (!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(previous)) {
                    return previous.shmsgseq;
                }
            }
        }
        return 0L;
    }

    private String getLogOutForMsgs(List<common$Msg> list) {
        String str = "";
        for (common$Msg common_msg : list) {
            str = str + "[" + getMsgSeq(common_msg) + "," + (isRoamMsg(common_msg) ? 1 : 0) + "]";
        }
        return str;
    }

    private com.tencent.imcore.message.f getMsgProxy() {
        return ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageProxy((BaseQQAppInterface) this.app, 10014);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getMsgSeq(common$Msg common_msg) {
        return common_msg.head.content_head.get().msg_seq.get();
    }

    private List<Long> getMsgSeqsForMsgs(List<common$Msg> list) {
        ArrayList arrayList = new ArrayList();
        for (common$Msg common_msg : list) {
            if (isRoamMsg(common_msg)) {
                arrayList.add(Long.valueOf(getMsgSeq(common_msg)));
            }
        }
        return arrayList;
    }

    private boolean isMsgSameInMsgs(List<common$Msg> list, common$Msg common_msg) {
        for (common$Msg common_msg2 : list) {
            if (isRoamMsg(common_msg2) && getMsgSeq(common_msg2) == getMsgSeq(common_msg)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRoamMsg(common$Msg common_msg) {
        if (common_msg.ext_info.offline_flag.get() == 1) {
            return true;
        }
        return false;
    }

    private void mergeFillHoldMsg(List<common$Msg> list, List<common$Msg> list2) {
        for (common$Msg common_msg : list2) {
            if (!isMsgSameInMsgs(list, common_msg)) {
                list.add(common_msg);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFillMsgHoleService
    public boolean checkNeedFillMsgHole(List<common$Msg> list, int i3, Bundle bundle) {
        if (list.size() == 0) {
            return false;
        }
        long j3 = com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B;
        if (bundle != null) {
            j3 = bundle.getLong("channelId", j3);
        }
        if (j3 == com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B) {
            return false;
        }
        long activeChannelId = ((IGuildLocalFocusService) this.app.getRuntimeService(IGuildLocalFocusService.class, "")).getActiveChannelId();
        if (activeChannelId == com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B) {
            activeChannelInfo.b();
        }
        if (activeChannelId != j3) {
            return false;
        }
        List<Long> msgSeqsForMsgs = getMsgSeqsForMsgs(list);
        if (msgSeqsForMsgs.size() == 0) {
            return false;
        }
        Collections.sort(msgSeqsForMsgs);
        long longValue = msgSeqsForMsgs.get(msgSeqsForMsgs.size() - 1).longValue();
        long fingMaxConsecutiveSeq = fingMaxConsecutiveSeq(msgSeqsForMsgs);
        if ((longValue - fingMaxConsecutiveSeq) + 1 >= 15) {
            QLog.i(TAG, 1, "checkNeedFillMsgHole maxSourceSeq:" + longValue + " maxConsecutiveSeq:" + fingMaxConsecutiveSeq + " from:" + i3);
            return false;
        }
        long j16 = j3;
        long lastMsgSeqInAioMsgList = getLastMsgSeqInAioMsgList(String.valueOf(j3));
        if (fingMaxConsecutiveSeq <= lastMsgSeqInAioMsgList) {
            return false;
        }
        long j17 = lastMsgSeqInAioMsgList + 1;
        if (fingMaxConsecutiveSeq == j17) {
            return false;
        }
        if (i3 == 1) {
            longValue = fingMaxConsecutiveSeq - 1;
        } else if (i3 != 2) {
            longValue = 0;
        }
        if (longValue - j17 >= 15) {
            j17 = (longValue - 15) + 1;
        }
        long j18 = j17;
        IGuildRoamMessageHandler iGuildRoamMessageHandler = (IGuildRoamMessageHandler) this.app.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildRoamMsgHandlerName());
        Bundle bundle2 = new Bundle();
        bundle2.putInt("roam_msg_pull_from_source", i3);
        long j19 = longValue;
        bundle2.putLong("timeout", 2000L);
        long incrementAndGet = pullMsgSeq.incrementAndGet();
        bundle2.putLong("fill_msghole_seq", incrementAndGet);
        iGuildRoamMessageHandler.reqPullRoamMsg(String.valueOf(j16), j18, j19, bundle2);
        ((IGuildMsgFactory) this.app.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().h(Long.valueOf(incrementAndGet), list);
        QLog.i(TAG, 1, "checkNeedFillMsgHole channelId:" + j16 + " maxConsecutiveSeq:" + fingMaxConsecutiveSeq + " lastRoamMsgSeqInAioList:" + lastMsgSeqInAioMsgList + " needPullMsgSeqs: " + j18 + "-" + j19 + " sourceMsg:" + getLogOutForMsgs(list) + " getFillMsgHoleTimer:" + activeChannelInfo.a() + " pullSeq:" + incrementAndGet + " from:" + i3);
        ((GuildMessagePushHandler) this.app.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildPushMsgHandlerName())).K2().s().l(i3);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildFillMsgHoleService
    public void handleFillMsgHoleResp(String str, boolean z16, List<common$Msg> list, Bundle bundle) {
        long j3 = bundle.getLong("fill_msghole_seq", -1L);
        int i3 = bundle.getInt("roam_msg_pull_from_source", 0);
        List<common$Msg> c16 = ((IGuildMsgFactory) this.app.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().c(Long.valueOf(j3));
        if (c16 != null && c16.size() != 0) {
            st1.g gVar = (st1.g) this.app.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildPushMsgHandlerName());
            if (z16 && list != null && list.size() != 0) {
                if (i3 == 1) {
                    mergeFillHoldMsg(c16, list);
                } else if (i3 == 2) {
                    c16 = list;
                }
                Collections.sort(c16, this.guildMsgComparator);
                QLog.i(TAG, 1, "handleFillMsgHoleResp channelId:" + str + " pullSeq:" + j3 + " from:" + i3 + " msgsResp:" + getLogOutForMsgs(list));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleFillMsgHoleResp channelId:");
                sb5.append(str);
                sb5.append(" from:");
                sb5.append(i3);
                sb5.append(" sourceMsgs:");
                sb5.append(getLogOutForMsgs(c16));
                QLog.i(TAG, 1, sb5.toString());
            } else {
                QLog.i(TAG, 1, "handleFillMsgHoleResp channelId:" + str + " from:" + i3 + " pullSeq:" + j3 + " msgsResp:null");
            }
            if (i3 == 1) {
                gVar.p1(c16);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "handleFillMsgHoleResp sourceMsgs is empty why!!!");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = (AppInterface) appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
