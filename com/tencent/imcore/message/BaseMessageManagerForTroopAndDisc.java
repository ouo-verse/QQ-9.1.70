package com.tencent.imcore.message;

import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageForGrayTips;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class BaseMessageManagerForTroopAndDisc extends BaseMessageManager {
    static IPatchRedirector $redirector_;
    public static long G;
    protected static a H;
    private MessageRecord E;
    private ai F;

    /* compiled from: P */
    /* renamed from: com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f116308d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f116309e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f116310f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f116311h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f116312i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Bundle f116313m;
        final /* synthetic */ BaseMessageManagerForTroopAndDisc this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long min = Math.min(this.f116308d, this.f116309e);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg.trooptroop_pull_msg", 2, "--->>pkgIndex : " + this.f116310f + " beginSeq:" + this.f116311h + " fixEndSeq:" + min);
            }
            this.this$0.f116282e.putAioInParallelPullMsgMark(this.f116312i, this.f116311h, min);
            BaseMessageManagerForTroopAndDisc.H.g(this.this$0.f116281d, this.f116312i, this.f116311h, min, true, this.f116313m, 0);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc$4, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ aj f116318d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f116319e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f116320f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f116321h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f116322i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f116323m;
        final /* synthetic */ BaseMessageManagerForTroopAndDisc this$0;

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            int i3;
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.this$0.U(this.f116318d);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage begin");
            }
            int i16 = 0;
            int i17 = 0;
            while (true) {
                z16 = true;
                i16++;
                List<ChatMessage> r16 = this.this$0.r(this.f116319e, this.f116320f);
                if (r16 != null) {
                    for (ChatMessage chatMessage : r16) {
                        if (!ad.B(chatMessage)) {
                            i3 = (int) chatMessage.shmsgseq;
                            break;
                        }
                    }
                }
                i3 = 0;
                long j16 = i3;
                j3 = this.f116321h;
                if (j16 > 1 + j3) {
                    z16 = false;
                }
                if (i17 == i3 || j16 <= j3) {
                    break;
                }
                if (i16 % 500 == 0 && QLog.isColorLevel()) {
                    QLog.w("Q.msg.BaseMessageManager", 2, "dead loop warning, firstSeq: " + this.f116322i + " seq: " + i3 + ", unread: " + this.f116321h);
                }
                int i18 = (int) (j16 - this.f116321h);
                if (this.this$0.K0(this.f116319e, this.f116320f, i18).size() != i18 && i18 > 15) {
                    i18 = 15;
                }
                aj ajVar = this.f116318d;
                ajVar.f116543u = i18;
                ajVar.f116535m = 0;
                this.this$0.n(this.f116319e, this.f116320f, i18, ajVar);
                i17 = i3;
            }
            if (z16 && this.f116323m) {
                BaseMessageManagerForTroopAndDisc baseMessageManagerForTroopAndDisc = this.this$0;
                int i19 = this.f116320f;
                String str = this.f116319e;
                baseMessageManagerForTroopAndDisc.U0(i19, str, j3, baseMessageManagerForTroopAndDisc.r(str, i19));
            }
            aj ajVar2 = this.f116318d;
            ajVar2.f116532j = z16;
            this.this$0.f116282e.setChangeAndNotify(ajVar2);
            this.this$0.f116282e.getFacadeHandler().post(new Runnable() { // from class: com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.4.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Map<String, Boolean> refreshActionMap = AnonymousClass4.this.this$0.f116282e.getRefreshActionMap();
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    if (refreshActionMap.containsKey(ao.f(anonymousClass4.f116319e, anonymousClass4.f116320f))) {
                        Map<String, Boolean> refreshActionMap2 = AnonymousClass4.this.this$0.f116282e.getRefreshActionMap();
                        AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                        refreshActionMap2.remove(ao.f(anonymousClass42.f116319e, anonymousClass42.f116320f));
                    }
                }
            });
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage end");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        Object a(AppRuntime appRuntime, String str, com.tencent.mobileqq.troop.data.c cVar, Object obj, MessageRecord messageRecord, boolean z16);

        void b(AppRuntime appRuntime, ArrayList<MessageRecord> arrayList);

        List<MessageRecord> c(MessageRecord messageRecord);

        boolean d(AppRuntime appRuntime, MessageRecord messageRecord);

        boolean e(AppRuntime appRuntime, long j3, long j16, long j17, boolean z16, Bundle bundle);

        void f(AppRuntime appRuntime, IConversationFacade iConversationFacade, IMessageFacade iMessageFacade, String str, int i3, long j3, RecentUserProxy recentUserProxy, RecentUser recentUser);

        boolean g(AppRuntime appRuntime, String str, long j3, long j16, boolean z16, Bundle bundle, int i3);

        byte[] h(MessageRecord messageRecord, MessageRecord messageRecord2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36482);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            G = 0L;
            s.a();
        }
    }

    public BaseMessageManagerForTroopAndDisc(AppRuntime appRuntime, MsgPool msgPool) {
        super(appRuntime, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) msgPool);
        } else {
            this.E = null;
            this.F = null;
        }
    }

    private void B0(String str, int i3, int i16, aj ajVar, long j3, MessageRecord messageRecord, int i17, List<MessageRecord> list, long j16, boolean z16) {
        long id5;
        aj ajVar2;
        if ((list.isEmpty() && j16 > 0) || (!z16 && list.size() < i16)) {
            long C0 = C0(str, i3, list, j16);
            f y16 = y(i3);
            if (messageRecord == null) {
                id5 = 0;
            } else {
                id5 = messageRecord.getId();
            }
            List<MessageRecord> Z = y16.Z(str, i3, id5, i17, C0, i16 - list.size(), null);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam fail step 0 , size = " + Z.size() + ",seq = " + C0 + " , timestamp = " + System.currentTimeMillis());
            }
            if (Z.isEmpty()) {
                ajVar2 = ajVar;
                ajVar2.f116525c = true;
            } else {
                ajVar2 = ajVar;
                list.addAll(0, Z);
            }
            ajVar2.f116527e = true;
            ajVar2.E = list.size();
            ajVar2.D = 0L;
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam addRoamMsgToList uniseq = " + j3 + " , locallist = " + list.size() + " , timestamp = " + System.currentTimeMillis());
        }
        y(i3).e(str, i3, j3, list);
    }

    private long C0(String str, int i3, List<MessageRecord> list, long j3) {
        StringBuilder sb5;
        long j16;
        if (!list.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (MessageRecord messageRecord : list) {
                if (messageRecord.shmsgseq == list.get(0).shmsgseq) {
                    StringBuilder sb6 = new StringBuilder();
                    if (messageRecord.getId() > 0) {
                        sb5 = new StringBuilder();
                        sb5.append("id&");
                        j16 = messageRecord.getId();
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append("uniseq&");
                        j16 = messageRecord.uniseq;
                    }
                    sb5.append(j16);
                    sb6.append(sb5.toString());
                    sb6.append(ContainerUtils.FIELD_DELIMITER);
                    sb6.append(messageRecord.shmsgseq);
                    hashMap.put(sb6.toString(), messageRecord);
                }
            }
            list.addAll(0, y(i3).p0(str, i3, list.get(0).shmsgseq, hashMap));
            return list.get(0).shmsgseq - 1;
        }
        return j3;
    }

    private HashMap<String, MessageRecord> E0(String str, int i3, List<MessageRecord> list) {
        StringBuilder sb5;
        long j3;
        HashMap<String, MessageRecord> hashMap = new HashMap<>();
        if (list != null && !list.isEmpty()) {
            MessageRecord H2 = y(i3).H(str, i3, Z0(list));
            if (H2 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refresh find msg in cache id = " + H2.getId() + ", msg = " + H2.getLogColorContent() + ", uniseq = " + H2.uniseq + " , msgtime = " + H2.time + " , shMsgSeq = " + H2.shmsgseq + " , extra = " + H2.extraflag);
                }
                if (!list.isEmpty()) {
                    for (MessageRecord messageRecord : list) {
                        if (messageRecord.shmsgseq == H2.shmsgseq) {
                            StringBuilder sb6 = new StringBuilder();
                            if (messageRecord.getId() > 0) {
                                sb5 = new StringBuilder();
                                sb5.append("id&");
                                j3 = messageRecord.getId();
                            } else {
                                sb5 = new StringBuilder();
                                sb5.append("uniseq&");
                                j3 = messageRecord.uniseq;
                            }
                            sb5.append(j3);
                            sb6.append(sb5.toString());
                            sb6.append(ContainerUtils.FIELD_DELIMITER);
                            sb6.append(messageRecord.shmsgseq);
                            hashMap.put(sb6.toString(), messageRecord);
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "refresh can't find msg in cache !!");
            }
            return hashMap;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
        }
        return hashMap;
    }

    private int F0(long j3, List<MessageRecord> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).uniseq == j3) {
                return i3;
            }
        }
        return 0;
    }

    private int G0(List<MessageRecord> list, int i3) {
        int i16 = i3;
        while (i3 < list.size() - 1) {
            long j3 = list.get(i3).shmsgseq;
            i3++;
            if (j3 != list.get(i3).shmsgseq) {
                break;
            }
            i16++;
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + i16);
            }
        }
        return i16;
    }

    private int H0(List<MessageRecord> list) {
        int i3 = 0;
        int i16 = 0;
        while (i3 < list.size() - 1) {
            long j3 = list.get(i3).shmsgseq;
            i3++;
            if (j3 != list.get(i3).shmsgseq) {
                break;
            }
            i16++;
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + i16);
            }
        }
        return i16;
    }

    private int I0(List<MessageRecord> list, int i3) {
        while (i3 > 0 && list.get(i3 - 1).shmsgseq == list.get(i3).shmsgseq) {
            i3--;
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + i3);
            }
        }
        return i3;
    }

    private ai J0() {
        if (this.F == null) {
            this.F = new ai(this);
        }
        return this.F;
    }

    private void L0(String str, int i3, int i16, HashMap<String, MessageRecord> hashMap, List<MessageRecord> list, int i17, List<MessageRecord> list2, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 1, timestamp = " + System.currentTimeMillis());
        }
        int i18 = i17 - i16;
        long j16 = list.get(i18).shmsgseq;
        int I0 = I0(list, i18);
        if (I0 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 2, timestamp = " + System.currentTimeMillis());
            }
            int G0 = G0(list, i18) + 1;
            if (G0 > i17) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 3, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
                }
                list2.addAll(y(i3).p0(str, i3, j3, hashMap));
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 4, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
                    return;
                }
                return;
            }
            list2.addAll(list.subList(G0, i17));
            int size = i16 - list2.size();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 5, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
            }
            f y16 = y(i3);
            long j17 = j16 - size;
            if (j17 < 0) {
                j17 = 0;
            }
            list2.addAll(0, y16.W(str, i3, j17, j16));
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 6, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
                return;
            }
            return;
        }
        list2.addAll(list.subList(I0, i17));
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 7, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
        }
    }

    private void M0(String str, int i3, int i16, HashMap<String, MessageRecord> hashMap, List<MessageRecord> list, int i17, List<MessageRecord> list2) {
        long j3;
        long j16 = list.get(0).shmsgseq;
        int H0 = H0(list) + 1;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 0, sameSeq = " + j16 + ",itemListStartPoint = " + H0 + ", timestamp = " + System.currentTimeMillis());
        }
        if (H0 > i17) {
            list2.addAll(y(i3).p0(str, i3, j16, hashMap));
        } else {
            list2.addAll(list.subList(H0, i17));
        }
        int size = i16 - list2.size();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 1, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
        }
        long j17 = (j16 - size) + 1;
        if (j17 >= 0) {
            j3 = j17;
        } else {
            j3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "getLocalListRefreshReadCacheAndDB() called with: beginSeq = [" + j3 + "],endSeq=[" + j16 + "]");
        }
        list2.addAll(0, y(i3).W(str, i3, j3, j16));
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 2, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
        }
    }

    private void P0(MessageRecord messageRecord, MessageRecord messageRecord2) {
        boolean z16 = !messageRecord2.isValid;
        this.f116282e.updateGroupMsgSeqAndTimeByUniseq(messageRecord.frienduin, messageRecord.istroop, messageRecord2.uniseq, messageRecord.shmsgseq, messageRecord.time);
        if (messageRecord2.msgtype == -2017) {
            this.f116282e.updateMsgContentByUniseq(messageRecord.frienduin, 1, messageRecord2.uniseq, H.h(messageRecord2, messageRecord));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam text msg rewrite success");
        }
        if (z16) {
            messageRecord2.shmsgseq = messageRecord.shmsgseq;
            messageRecord2.time = messageRecord.time;
            messageRecord2.setExtraFlag(0);
            BaseMessageManager.D.t(this.f116281d, null, messageRecord2);
        }
    }

    private boolean Q0(List<MessageRecord> list, List<MessageRecord> list2, MessageRecord messageRecord, boolean z16) {
        MessageRecord sendingTroopMsgItem;
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam msg rewrite sending msg  mr.senderuin: " + messageRecord.senderuin + " mr.msgtype: " + messageRecord.msgtype + " mr.frienduin: " + messageRecord.frienduin + " mr.shmsgseq: " + messageRecord.shmsgseq + " mr.time:" + messageRecord.time + " mr.msg: " + messageRecord.getLogColorContent());
            }
            String str = messageRecord.senderuin;
            if (str != null && str.equalsIgnoreCase(this.f116281d.getAccount()) && (sendingTroopMsgItem = this.f116282e.getSendingTroopMsgItem(messageRecord.frienduin, messageRecord.istroop, messageRecord, list2)) != null) {
                P0(messageRecord, sendingTroopMsgItem);
                return true;
            }
            list.add(messageRecord);
            return false;
        }
        return false;
    }

    private boolean V0(MessageRecord messageRecord) {
        List<MessageRecord> c16 = H.c(messageRecord);
        if (messageRecord.isLongMsg() && c16 != null) {
            Iterator<MessageRecord> it = c16.iterator();
            while (it.hasNext()) {
                if (it.next().extraflag != 0) {
                    return true;
                }
            }
            return false;
        }
        if (messageRecord.extraflag != 0) {
            return true;
        }
        return false;
    }

    private long Z0(List<MessageRecord> list) {
        for (MessageRecord messageRecord : list) {
            if (!W0(messageRecord) && messageRecord.shmsgseq > 0) {
                return messageRecord.uniseq;
            }
        }
        return 0L;
    }

    private boolean b1(List<MessageRecord> list) {
        Iterator<MessageRecord> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shmsgseq > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean d1(int i3, aj ajVar, boolean z16) {
        if (z16) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        }
        ajVar.f116524b = null;
        M(ajVar, i3);
        return true;
    }

    private void e1(List<MessageRecord> list, long j3, List<MessageRecord> list2) {
        for (MessageRecord messageRecord : list) {
            if (messageRecord.shmsgseq < j3) {
                list2.add(messageRecord);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint invalid: id = " + messageRecord.getId() + ", msg = " + messageRecord.getLogColorContent() + " , msgtime = " + messageRecord.time + " , shMsgSeq = " + messageRecord.shmsgseq + " , extra = " + messageRecord.extraflag);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint valid: id = " + messageRecord.getId() + ", msg = " + messageRecord.getLogColorContent() + " , msgtime = " + messageRecord.time + " , shMsgSeq = " + messageRecord.shmsgseq + " , extra = " + messageRecord.extraflag);
            }
        }
        list.removeAll(list2);
        list2.clear();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 1, size = " + list.size() + ", timestamp = " + System.currentTimeMillis());
        }
    }

    public static void g1(a aVar) {
        H = aVar;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public long A(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord)).longValue();
        }
        return messageRecord.shmsgseq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A0(String str, int i3, long j3) {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        } else if (str != null && j3 >= 0 && (appRuntime = this.f116281d) != null) {
            RecentUserProxy recentUserCache = ((IRecentUserProxyService) appRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
            H.f(this.f116281d, this.f116283f, this.f116282e, str, i3, j3, recentUserCache, recentUserCache.findRecentUserByUin(str, i3));
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void B(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, Bundle bundle) {
        List<MessageRecord> list3;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), list, list2, bundle);
            return;
        }
        if (J0().m(str, i3, list, list2, bundle)) {
            return;
        }
        boolean z16 = bundle.getBoolean("success");
        long j16 = bundle.getLong("beginSeq", -1L);
        long j17 = bundle.getLong("endSeq", -1L);
        boolean z17 = bundle.getBoolean("key_from_parallel_pull", false);
        if (i3 == 1 && z17 && list != null && !list.isEmpty()) {
            list3 = K0(str, i3, list.size());
        } else {
            list3 = this.f116282e.getPullCache().get(Integer.valueOf(bundle.getInt("counter")));
        }
        List<MessageRecord> list4 = list3;
        IMessageFacade iMessageFacade = this.f116282e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("refresh roam step 1 , result = ");
        sb5.append(list == null ? -1 : list.size());
        sb5.append(" , success = ");
        sb5.append(z16);
        sb5.append(" , beginSeq = ");
        sb5.append(j16);
        sb5.append(" , endSeq = ");
        sb5.append(j17);
        iMessageFacade.qLogColor(sb5.toString(), " , time = [" + System.currentTimeMillis() + "]");
        this.f116282e.getPullCache().remove(Integer.valueOf(bundle.getInt("counter")));
        if (list4 != null) {
            List<MessageRecord> arrayList = list2 == null ? new ArrayList() : list2;
            if (list == null || list.isEmpty()) {
                j3 = j17;
            } else {
                ArrayList arrayList2 = new ArrayList();
                f y16 = y(i3);
                long j18 = j16 - 15;
                long j19 = j18 > 0 ? j18 : 0L;
                long j26 = j16 - 1;
                j3 = j17;
                arrayList2.addAll(y16.W(str, i3, j19, j26 > 0 ? j26 : 0L));
                arrayList2.addAll(list4);
                R0(list, arrayList, arrayList2);
            }
            bundle.putBoolean("success", z16);
            if (!arrayList.isEmpty()) {
                y(arrayList.get(0).istroop).d(arrayList, null);
            }
            Iterator<MessageRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                S0(list4, it.next());
            }
            synchronized (list4) {
                list4.notify();
            }
        } else {
            j3 = j17;
        }
        if (z17) {
            this.f116282e.clearInAioParallerPullMsgMark(str, j16, j3);
        }
    }

    public void D0(String str, ArrayList<MessageRecord> arrayList) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) arrayList);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<MessageRecord> it = arrayList.iterator();
        int i16 = -1;
        boolean z17 = false;
        while (it.hasNext()) {
            MessageRecord next = it.next();
            com.tencent.mobileqq.troop.data.c cVar = next.mMessageInfo;
            if (cVar != null && !next.isread) {
                if (next.istroop == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.f116281d.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
                RecentUser findRecentUserByUin = recentUserCache.findRecentUserByUin(str, next.istroop);
                if (cVar.h()) {
                    int f16 = cVar.f();
                    if (com.tencent.mobileqq.troop.data.c.a(f16, findRecentUserByUin.msgType)) {
                        findRecentUserByUin.msgType = f16;
                        i3 = f16;
                        findRecentUserByUin.f203116msg = H.a(this.f116281d, str, cVar, findRecentUserByUin.f203116msg, next, z16);
                        recentUserCache.saveRecentUser(findRecentUserByUin);
                        i16 = next.istroop;
                        z17 = true;
                    } else {
                        i3 = f16;
                    }
                    if (z16 && (i3 == 25 || i3 == 23)) {
                        if (H.d(this.f116281d, next)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            ThreadManager.getSubThreadHandler().post(new Runnable(arrayList2) { // from class: com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f116314d;

                {
                    this.f116314d = arrayList2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseMessageManagerForTroopAndDisc.this, (Object) arrayList2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        BaseMessageManagerForTroopAndDisc.H.b(BaseMessageManagerForTroopAndDisc.this.f116281d, this.f116314d);
                    }
                }
            });
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "markAtOrReplyMeMsgInTroop_" + arrayList2.size());
            }
        }
        if (z17) {
            IMessageFacade iMessageFacade = this.f116282e;
            iMessageFacade.setChangeAndNotify(iMessageFacade.getLastMessage(str, i16));
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void K(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) message);
        } else {
            message.nickName = N0(message.senderuin, message.frienduin);
        }
    }

    public List<MessageRecord> K0(String str, int i3, int i16) {
        long j3;
        ArrayList arrayList;
        ArrayList arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i16 > 0) {
            System.currentTimeMillis();
            List<MessageRecord> l3 = y(i3).l(str, i3);
            if (l3 != null && !l3.isEmpty()) {
                long Z0 = Z0(l3);
                MessageRecord H2 = y(i3).H(str, i3, Z0);
                HashMap<String, MessageRecord> E0 = E0(str, i3, l3);
                List<MessageRecord> p16 = y(i3).p(str, i3);
                int F0 = F0(Z0, p16);
                synchronized (this) {
                    ArrayList arrayList3 = new ArrayList();
                    if (H2 == null) {
                        j3 = 0;
                    } else {
                        j3 = H2.shmsgseq;
                    }
                    if (F0 == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 0, timestamp = " + System.currentTimeMillis());
                        }
                        f y16 = y(i3);
                        long j16 = j3 - i16;
                        if (j16 < 0) {
                            j16 = 0;
                        }
                        long j17 = j3 - 1;
                        if (j17 < 0) {
                            j17 = 0;
                        }
                        arrayList3.addAll(y16.W(str, i3, j16, j17));
                        arrayList3.addAll(y(i3).p0(str, i3, j3, E0));
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 1, timestamp = " + System.currentTimeMillis());
                        }
                        arrayList = arrayList3;
                    } else {
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("refresh read cache step 0, cacheIndex = ");
                            sb5.append(F0);
                            sb5.append(" timestamp = ");
                            arrayList = arrayList3;
                            sb5.append(System.currentTimeMillis());
                            QLog.d("Q.msg.BaseMessageManager", 2, sb5.toString());
                        } else {
                            arrayList = arrayList3;
                        }
                        if (F0 >= i16) {
                            L0(str, i3, i16, E0, p16, F0, arrayList, j3);
                        } else {
                            M0(str, i3, i16, E0, p16, F0, arrayList);
                        }
                    }
                    int i17 = 0;
                    while (i17 < arrayList.size()) {
                        ArrayList arrayList4 = arrayList;
                        MessageRecord messageRecord = arrayList4.get(i17);
                        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fetchTroopMemberInfoFromDB(messageRecord.frienduin, messageRecord.senderuin, null, "Q.msg.BaseMessageManager-getLocalList", null);
                        i17++;
                        arrayList = arrayList4;
                    }
                    arrayList2 = arrayList;
                }
                return arrayList2;
            }
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
            }
            return new ArrayList();
        }
        throw new IllegalArgumentException("COUNT MUST > 0 !");
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void L(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) message);
        } else {
            message.nickName = O0(message.senderuin, message.frienduin);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imcore.message.BaseMessageManager
    public void M(aj ajVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ajVar, i3);
            return;
        }
        String str = ajVar.f116541s;
        List<MessageRecord> l3 = y(i3).l(str, i3);
        if (ajVar.f116537o < 3 && ao.o(l3)) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more sticker msg");
            }
            ajVar.f116537o++;
            n(str, i3, 15, ajVar);
            return;
        }
        if (ao.m(str, i3, l3) && ajVar.f116528f && ajVar.f116536n < 1) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more long msg");
            }
            ajVar.f116536n++;
            n(str, i3, 15, ajVar);
            return;
        }
        super.M(ajVar, i3);
    }

    protected abstract String N0(String str, String str2);

    protected abstract String O0(String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R0(List<MessageRecord> list, List<MessageRecord> list2, List<MessageRecord> list3) {
        boolean z16;
        for (MessageRecord messageRecord : list) {
            Iterator<MessageRecord> it = list3.iterator();
            while (true) {
                z16 = false;
                if (it.hasNext()) {
                    if (ad.e(it.next(), messageRecord, false, true)) {
                        z16 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!Q0(list2, list3, messageRecord, z16) && QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 2 , mr.msg = " + messageRecord.getLogColorContent() + " , mr.seq = " + messageRecord.shmsgseq + " , mr.msgtype = " + messageRecord.msgtype + ", isExist = " + z16 + " , extra = " + messageRecord.extraflag);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S0(List<MessageRecord> list, MessageRecord messageRecord) {
        if (messageRecord.getId() < 0) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "refresh insert db error ! , mr.msg = " + messageRecord.getLogColorContent() + " , mr.seq = " + messageRecord.shmsgseq + " , mr.uniseq = " + messageRecord.uniseq + " , extra = " + messageRecord.extraflag);
                return;
            }
            return;
        }
        ad.p(list, messageRecord, true);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 3 , mr.msg = " + messageRecord.getLogColorContent() + " , mr.seq = " + messageRecord.shmsgseq + " , mr.uniseq = " + messageRecord.uniseq + " , extra = " + messageRecord.extraflag);
        }
    }

    public boolean T0(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) messageRecord)).booleanValue();
        }
        MessageRecord messageRecord2 = this.E;
        if (messageRecord2 == null) {
            return false;
        }
        List<MessageRecord> c16 = H.c(messageRecord2);
        if (messageRecord.isLongMsg() && c16 != null) {
            boolean z16 = false;
            for (MessageRecord messageRecord3 : c16) {
                if (messageRecord3.extraflag != 0) {
                    return false;
                }
                if (messageRecord3.frienduin.equals(messageRecord.frienduin) && messageRecord3.istroop == messageRecord.istroop && messageRecord3.uniseq == messageRecord.uniseq) {
                    z16 = true;
                }
            }
            return z16;
        }
        MessageRecord messageRecord4 = this.E;
        if (messageRecord4 != messageRecord || messageRecord4.extraflag != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U0(int i3, String str, long j3, List<ChatMessage> list) {
        long j16;
        if (list != null && list.size() != 0) {
            Iterator<ChatMessage> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    ChatMessage next = it.next();
                    if (!ad.B(next)) {
                        j16 = next.shmsgseq;
                        break;
                    }
                } else {
                    j16 = 0;
                    break;
                }
            }
            if (j16 <= j3 && j3 != 0 && j16 != 0) {
                long K0 = com.tencent.mobileqq.service.message.e.K0();
                Iterator<ChatMessage> it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    ChatMessage next2 = it5.next();
                    if (next2.shmsgseq == j3) {
                        K0 = next2.time;
                        break;
                    }
                }
                long j17 = K0;
                String currentAccountUin = this.f116281d.getCurrentAccountUin();
                MessageRecord createMsgRecordByMsgType = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS);
                createMsgRecordByMsgType.init(currentAccountUin, str, currentAccountUin, "", j17, MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS, i3, 0L);
                createMsgRecordByMsgType.shmsgseq = j3;
                ArrayList<MessageRecord> arrayList = new ArrayList<>();
                arrayList.add(createMsgRecordByMsgType);
                this.f116282e.addMessage(arrayList, currentAccountUin, false, false);
                ArrayList arrayList2 = new ArrayList();
                Iterator<ChatMessage> it6 = list.iterator();
                while (it6.hasNext()) {
                    arrayList2.add(it6.next());
                }
                ad.o(arrayList2, createMsgRecordByMsgType, false);
                list.clear();
                int indexOf = arrayList2.indexOf(createMsgRecordByMsgType);
                if (indexOf > 0) {
                    if (((IMessageForGrayTips) this.f116281d.getRuntimeService(IMessageForGrayTips.class, "")).isMessageForSplitLineTips((MessageRecord) arrayList2.get(indexOf - 1))) {
                        arrayList2.remove(createMsgRecordByMsgType);
                    }
                }
                Iterator it7 = arrayList2.iterator();
                while (it7.hasNext()) {
                    list.add((ChatMessage) ((MessageRecord) it7.next()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean W0(MessageRecord messageRecord) {
        return messageRecord instanceof MessageForUniteGrayTip;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X0(List<MessageRecord> list) {
        if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            synchronized (list) {
                try {
                    list.wait(35000L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Y0(aj ajVar, long j3, boolean z16) {
        if (j3 <= 0) {
            ajVar.f116525c = true;
            return false;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a1(String str, int i3, long j3, long j16, Bundle bundle) {
        if (i3 == 3000) {
            H.e(this.f116281d, Long.valueOf(str).longValue(), j3, j16, true, bundle);
        } else if (i3 == 1) {
            H.g(this.f116281d, str, j3, j16, true, bundle, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c1(int i3, aj ajVar, List<MessageRecord> list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
        }
        ajVar.f116524b = null;
        M(ajVar, i3);
        return true;
    }

    public void f1(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) messageRecord);
        } else {
            this.E = messageRecord;
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void m(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) messageRecord);
        } else {
            ThreadManagerV2.post(new Runnable(messageRecord, V0(messageRecord), System.currentTimeMillis()) { // from class: com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ MessageRecord f116315d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f116316e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f116317f;

                {
                    this.f116315d = messageRecord;
                    this.f116316e = r7;
                    this.f116317f = r8;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BaseMessageManagerForTroopAndDisc.this, messageRecord, Boolean.valueOf(r7), Long.valueOf(r8));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest " + this.f116315d.getLogColorContent() + " holdFlag: " + this.f116316e);
                    }
                    if (!this.f116316e) {
                        BaseMessageManager.D.x(BaseMessageManagerForTroopAndDisc.this.f116281d, this.f116315d, 15000L);
                        return;
                    }
                    BaseMessageManagerForTroopAndDisc.this.f1(this.f116315d);
                    BaseMessageManagerForTroopAndDisc.this.b0();
                    long currentTimeMillis = 15000 - (System.currentTimeMillis() - this.f116317f);
                    if (BaseMessageManagerForTroopAndDisc.this.T0(this.f116315d)) {
                        BaseMessageManager.D.x(BaseMessageManagerForTroopAndDisc.this.f116281d, this.f116315d, currentTimeMillis);
                    } else {
                        BaseMessageManager.b bVar = BaseMessageManager.D;
                        AppRuntime appRuntime = BaseMessageManagerForTroopAndDisc.this.f116281d;
                        MessageRecord messageRecord2 = this.f116315d;
                        bVar.d(appRuntime, messageRecord2.frienduin, messageRecord2.istroop, BaseMessageProcessor.f116326f, BaseMessageProcessor.f116335o);
                    }
                    BaseMessageManagerForTroopAndDisc.this.f1(null);
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void n(String str, int i3, int i16, aj ajVar) {
        long j3;
        int i17;
        MessageRecord messageRecord;
        long j16;
        long j17;
        List<MessageRecord> list;
        int i18;
        long j18;
        List<MessageRecord> list2;
        long j19;
        MessageRecord messageRecord2;
        long j26;
        char c16;
        boolean z16;
        int size;
        long j27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16), ajVar);
            return;
        }
        if (i16 > 0) {
            List<MessageRecord> l3 = y(i3).l(str, i3);
            if (c1(i3, ajVar, l3)) {
                return;
            }
            long Z0 = Z0(l3);
            if (Z0 == 0 && !l3.isEmpty()) {
                Z0 = l3.get(l3.size() - 1).shmsgseq + 1;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "doRefreshMessageListHead() called set tail headMsgUniseq = [" + Z0 + "]");
                }
            }
            boolean b16 = b1(l3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "doRefreshMessageListHead() called with: uin = [" + str + "], type = [" + i3 + "], count = [" + i16 + "], context = [" + ajVar + "], aio head msg headMsgUniseq = [" + Z0 + "]");
            }
            if (d1(i3, ajVar, b16)) {
                return;
            }
            MessageRecord H2 = y(i3).H(str, i3, Z0);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "doRefreshMessageListHead() called with: aio head msg = [" + H2 + "]");
            }
            if (H2 == null) {
                j3 = 0;
            } else {
                j3 = H2.shmsgseq;
            }
            if (j3 == 0) {
                j3 = Z0;
            }
            if (H2 == null) {
                i17 = 3;
            } else {
                i17 = H2.versionCode;
            }
            List<MessageRecord> K0 = K0(str, i3, i16);
            if (K0 != null && !K0.isEmpty()) {
                int size2 = K0.size() - 1;
                long j28 = j3;
                int i19 = 0;
                while (true) {
                    if (size2 >= 0) {
                        MessageRecord messageRecord3 = K0.get(size2);
                        if (QLog.isColorLevel()) {
                            messageRecord = H2;
                            StringBuilder sb5 = new StringBuilder();
                            j16 = Z0;
                            sb5.append("doRefreshMessageListHead() called with: messageRecord = [");
                            sb5.append(messageRecord3);
                            sb5.append("]");
                            QLog.d("Q.msg.BaseMessageManager", 2, sb5.toString());
                        } else {
                            messageRecord = H2;
                            j16 = Z0;
                        }
                        if (!W0(messageRecord3)) {
                            long j29 = messageRecord3.shmsgseq;
                            if (j28 - j29 > 1) {
                                break;
                            }
                            i19++;
                            j28 = j29;
                        }
                        size2--;
                        H2 = messageRecord;
                        Z0 = j16;
                    } else {
                        messageRecord = H2;
                        j16 = Z0;
                        break;
                    }
                }
                list = K0;
                j17 = j28;
                i18 = i19;
            } else {
                messageRecord = H2;
                j16 = Z0;
                j17 = j3;
                list = K0;
                i18 = 0;
            }
            ajVar.E = i18;
            long j36 = j17 - 1;
            List<MessageRecord> list3 = list;
            int i26 = i16 - i18;
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                j18 = j3;
                sb6.append("doRefreshMessageListHead() called with: localSize = [");
                sb6.append(i18);
                sb6.append("], lastContinuedSeq = [");
                sb6.append(j17);
                sb6.append("], needSize = [");
                sb6.append(i26);
                sb6.append("], count = [");
                sb6.append(i16);
                sb6.append("]");
                QLog.d("Q.msg.BaseMessageManager", 2, sb6.toString());
            } else {
                j18 = j3;
            }
            if (i26 < 0) {
                i26 = 0;
            }
            long j37 = (j36 - i26) + 1;
            long M0 = ((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).M0(str, i3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 0, delSeq = " + M0 + ", endSeq = " + j36 + ",beginSeq = " + j37 + ",lastContinuedSeq = " + j17 + ",localSeqEnd = " + j18 + ", timestamp = " + System.currentTimeMillis());
            }
            boolean Y0 = Y0(ajVar, j36, true);
            if (j36 <= M0) {
                ajVar.f116525c = true;
                Y0 = false;
            } else if (j37 <= M0) {
                j37 = M0 + 1;
            }
            if (j37 < 0) {
                j37 = 0;
            }
            e1(list3, j37, new ArrayList());
            if (!ajVar.f116527e && j36 >= j37 && j36 > 0 && Y0) {
                Bundle bundle = new Bundle();
                int addAndGet = this.f116282e.getPullCounter().addAndGet(1);
                bundle.putInt("counter", addAndGet);
                bundle.putBoolean("success", false);
                this.f116282e.getPullCache().put(Integer.valueOf(addAndGet), list3);
                if (QLog.isColorLevel()) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("refresh roam step 0 , timestamp = ");
                    j27 = j37;
                    sb7.append(System.currentTimeMillis());
                    QLog.d("Q.msg.BaseMessageManager", 2, sb7.toString());
                } else {
                    j27 = j37;
                }
                messageRecord2 = messageRecord;
                j26 = j16;
                j19 = j36;
                list2 = list3;
                a1(str, i3, j27, j19, bundle);
                this.f116282e.getAutoPullCache().put(ao.f(str, i3), Boolean.FALSE);
                X0(list2);
                boolean z17 = bundle.getBoolean("success");
                if (QLog.isColorLevel()) {
                    c16 = 2;
                    QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 4 , size = " + list2.size() + " , timestamp = " + System.currentTimeMillis());
                } else {
                    c16 = 2;
                }
                if (this.f116282e.getAutoPullCache().containsKey(ao.f(str, i3)) && this.f116282e.getAutoPullCache().get(ao.f(str, i3)).booleanValue()) {
                    this.f116282e.qLogColor("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                    ajVar.f116524b = null;
                    M(ajVar, i3);
                    return;
                }
                ajVar.D = (j19 - j27) + 1;
                ajVar.E = list2.size() - ajVar.D;
                z16 = z17;
            } else {
                list2 = list3;
                j19 = j36;
                messageRecord2 = messageRecord;
                j26 = j16;
                c16 = 2;
                z16 = true;
            }
            B0(str, i3, i16, ajVar, j26, messageRecord2, i17, list2, j19, z16);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg", 2, "context.isLocalOnly = " + ajVar.f116527e);
            }
            I(list2);
            List<MessageRecord> list4 = list2;
            y(i3).a(str, i3, list4);
            ajVar.f116524b = list4;
            IMessageFacade iMessageFacade = this.f116282e;
            StringBuilder sb8 = new StringBuilder();
            sb8.append("troop refresh finish , context = ");
            sb8.append(ajVar);
            sb8.append(" , size = ");
            if (list4 == null) {
                size = -1;
            } else {
                size = list4.size();
            }
            sb8.append(size);
            iMessageFacade.qLogColor(sb8.toString(), ", timestamp = " + System.currentTimeMillis());
            M(ajVar, i3);
            return;
        }
        throw new IllegalArgumentException("COUNT MUST > 0 !");
    }
}
