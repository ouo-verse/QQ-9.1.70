package com.tencent.imcore.message;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.UinType;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.api.IMessageHandlerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public class C2CMessageManager extends BaseMessageManager {
    static IPatchRedirector $redirector_;
    protected static a E;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        void a(AppRuntime appRuntime, MessageRecord messageRecord);

        void b(AppRuntime appRuntime, MessageRecord messageRecord);

        boolean c(AppRuntime appRuntime, MessageRecord messageRecord, int i3);

        boolean d(AppRuntime appRuntime, String str);

        boolean dump();

        boolean e(AppRuntime appRuntime, MessageRecord messageRecord, String str, int i3);

        void f(AppRuntime appRuntime, int i3);

        boolean g(MessageRecord messageRecord);

        boolean h(AppRuntime appRuntime, MessageRecord messageRecord, String str, int i3, BaseMessageManager.a aVar);

        int i(AppRuntime appRuntime);

        boolean isRedPacketMsg(MessageRecord messageRecord);

        boolean j(AppRuntime appRuntime);

        boolean k(AppRuntime appRuntime, String str);

        void l(C2CMessageManager c2CMessageManager, MessageRecord messageRecord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f116363a;

        /* renamed from: b, reason: collision with root package name */
        private long f116364b;

        /* renamed from: c, reason: collision with root package name */
        private MessageRecord f116365c;

        /* renamed from: d, reason: collision with root package name */
        private int f116366d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public MessageRecord h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f116365c;
        }

        public long i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.f116364b;
        }

        boolean j() {
            return this.f116363a;
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private MessageRecord f116367a;

        /* renamed from: b, reason: collision with root package name */
        private EntityManager f116368b;

        /* renamed from: c, reason: collision with root package name */
        private Map<String, RecentUser> f116369c;

        /* renamed from: d, reason: collision with root package name */
        private RecentUserProxy f116370d;

        /* renamed from: e, reason: collision with root package name */
        private IConversationFacade f116371e;

        /* renamed from: f, reason: collision with root package name */
        private String f116372f;

        /* renamed from: g, reason: collision with root package name */
        private int f116373g;

        /* renamed from: h, reason: collision with root package name */
        private long f116374h;

        public c(MessageRecord messageRecord, EntityManager entityManager, Map<String, RecentUser> map, RecentUserProxy recentUserProxy, IConversationFacade iConversationFacade, String str, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, C2CMessageManager.this, messageRecord, entityManager, map, recentUserProxy, iConversationFacade, str, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            this.f116367a = messageRecord;
            this.f116368b = entityManager;
            this.f116369c = map;
            this.f116370d = recentUserProxy;
            this.f116371e = iConversationFacade;
            this.f116372f = str;
            this.f116373g = i3;
            this.f116374h = j3;
        }

        public long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.f116374h;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f116373g;
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f116372f;
        }

        public c d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (c) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            Iterator<com.tencent.imcore.message.msgboxappender.b> it = C2CMessageManager.this.f116282e.getRegistry().n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object[] a16 = it.next().a(C2CMessageManager.this, this.f116367a, this.f116368b, this.f116369c, this.f116370d, this.f116371e, this.f116372f, this.f116373g, this.f116374h);
                if (((Boolean) a16[0]).booleanValue()) {
                    this.f116372f = (String) a16[1];
                    this.f116373g = ((Integer) a16[2]).intValue();
                    this.f116374h = ((Long) a16[3]).longValue();
                    break;
                }
            }
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36775);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            s.a();
        }
    }

    public C2CMessageManager(AppRuntime appRuntime, MsgPool msgPool) {
        super(appRuntime, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) msgPool);
        }
    }

    private boolean A0(MessageRecord messageRecord, int i3) {
        return E.c(this.f116281d, messageRecord, i3);
    }

    private ArrayList<MessageRecord> C0(String str, List<MessageRecord> list, List<MessageRecord> list2, long j3, long j16) {
        ArrayList arrayList;
        ArrayList<MessageRecord> arrayList2 = new ArrayList<>();
        this.f116282e.qLogColor("C2CMsgFilter basetime=" + j3 + ",lowtime=" + j16, "");
        if (list != null && !list.isEmpty()) {
            Iterator<MessageRecord> it = list.iterator();
            long j17 = -1;
            long j18 = Long.MAX_VALUE;
            while (it.hasNext()) {
                long j19 = it.next().time;
                if (j18 >= j19) {
                    j18 = j19;
                }
                if (j17 <= j19) {
                    j17 = j19;
                }
            }
            List<MessageRecord> P0 = P0(str, 0, j18 - 30, 30 + j17);
            if (list2 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
            }
            ArrayList arrayList3 = arrayList;
            MessageRecord createMsgRecordByMsgType = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(-1000);
            MessageRecord createMsgRecordByMsgType2 = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(-1000);
            W0(list, j3, arrayList2, P0, arrayList3, createMsgRecordByMsgType, createMsgRecordByMsgType2);
            if (j3 > 0 && arrayList3 != null) {
                createMsgRecordByMsgType.time = j16;
                createMsgRecordByMsgType2.time = j3;
                for (MessageRecord messageRecord : P0(str, 0, j16, j3)) {
                    if (!ao.C(messageRecord.msgtype) && messageRecord.time <= j3) {
                        this.f116282e.qLogColor("addmsg ptt = " + messageRecord.getId(), "");
                        ad.q(arrayList3, messageRecord, true);
                    }
                }
            }
            if (list2 != null) {
                list2.addAll(arrayList3);
            }
            return arrayList2;
        }
        return arrayList2;
    }

    private boolean D0(String str, int i3, aj ajVar, ArrayList<MessageRecord> arrayList, int i16) {
        if (ao.o(arrayList) && ajVar.f116537o < 3) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + ajVar.f116537o);
            }
            M(ajVar, i3);
            return true;
        }
        int size = arrayList.size();
        if (arrayList.size() > 0) {
            ajVar.f116546x = true;
        }
        QLog.i("Q.msg.BaseMessageManager", 1, "refresh C2C ,size=" + size + ",count=" + i16);
        if (com.tencent.imcore.message.config.a.b() && ajVar.f116539q && size > 0 && size < i16 && ajVar.f116538p < com.tencent.imcore.message.config.a.a()) {
            QLog.i("Q.msg.BaseMessageManager", 1, "repull C2C" + ajVar.f116538p);
            ajVar.f116538p = ajVar.f116538p + 1;
            n(str, i3, i16 - arrayList.size(), ajVar);
            return true;
        }
        return false;
    }

    private void E0(ArrayList<MessageRecord> arrayList, ArrayList<MessageRecord> arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            MessageRecord messageRecord = arrayList.get(size);
            Iterator<MessageRecord> it = arrayList2.iterator();
            while (it.hasNext()) {
                MessageRecord next = it.next();
                if (ad.b(next, messageRecord, true)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead filterMr " + next.getLogColorContent() + ",uniseq=" + next.uniseq);
                    }
                    arrayList3.add(messageRecord);
                } else if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead not find filterMr " + next.getLogColorContent() + ",mr=" + messageRecord.getLogColorContent());
                }
            }
        }
        arrayList.removeAll(arrayList3);
    }

    private boolean F0(int i3, MessageRecord messageRecord, String str) {
        if (messageRecord.isLongMsg() && ((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).p1(messageRecord)) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
            }
            return true;
        }
        if ((i3 == 1044 && str.equals(AppConstants.MATCH_CHAT_UIN)) || i3 == 1046 || TextUtils.equals(messageRecord.senderuin, AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN)) {
            return true;
        }
        if (i3 == 10008 && str.equals(AppConstants.QCIRCLE_CHAT_UIN)) {
            return true;
        }
        return false;
    }

    private List<MessageRecord> G0(List<MessageRecord> list, long j3, long j16) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (MessageRecord messageRecord : list) {
                long j17 = messageRecord.time;
                if (j17 > j3 && j17 < j16) {
                    arrayList.add(messageRecord);
                }
            }
        }
        return arrayList;
    }

    private void I0(b bVar, String str, int i3, int i16, long j3, List<MessageRecord> list, ArrayList<MessageRecord> arrayList) {
        bVar.f116364b = bVar.f116365c.time;
        if (bVar.f116366d >= i16) {
            for (int i17 = bVar.f116366d - i16; i17 < bVar.f116366d; i17++) {
                MessageRecord messageRecord = list.get(i17);
                if (messageRecord.time >= j3) {
                    arrayList.add(messageRecord);
                }
            }
            J(arrayList, "all in cache");
            this.f116282e.dumpmsgs("all in cache", arrayList);
        } else {
            MessageRecord messageRecord2 = list.get(0);
            for (MessageRecord messageRecord3 : list.subList(0, bVar.f116366d)) {
                if (messageRecord3.time >= j3) {
                    arrayList.add(messageRecord3);
                }
            }
            this.f116282e.dumpmsgs("cache part", arrayList);
            J(arrayList, "cache part");
            int size = i16 - arrayList.size();
            arrayList.addAll(0, y(i3).V(str, i3, messageRecord2.time, size, String.format("time>=%d or (time=%d and _id<%d)", Long.valueOf(j3), Long.valueOf(messageRecord2.time), Long.valueOf(messageRecord2.getId()))));
            this.f116282e.dumpmsgs("cache + db", arrayList);
            J(arrayList, "cache + db");
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead memdb:size:" + arrayList.size() + ",miss:" + size);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead fromTime:" + bVar.f116364b);
        }
    }

    private boolean J0(b bVar, String str, int i3, int i16, aj ajVar, boolean z16, long j3, long j16, ArrayList<MessageRecord> arrayList) {
        boolean z17;
        bVar.f116365c = y(i3).H(str, i3, j3);
        if (bVar.f116365c != null) {
            bVar.f116364b = bVar.f116365c.time;
            this.f116282e.qLogColor("refreshC2CMessageListHead uniseq=" + j3 + ", aioBase.getId():" + bVar.f116365c.getId(), "");
            arrayList.addAll(y(i3).V(str, i3, bVar.f116364b, i16, String.format("time>=%d or (time=%d and _id<%d)", Long.valueOf(j16), Long.valueOf(bVar.f116364b), Long.valueOf(bVar.f116365c.getId()))));
            J(arrayList, "only load in db");
            this.f116282e.qLogColor("refreshC2CMessageListHead Db fromTime:" + bVar.f116364b, "");
            this.f116282e.dumpmsgs("only load in db", arrayList);
            return false;
        }
        if (z16) {
            O0(str, i3, i16, ajVar, arrayList, null, 0L);
            I(arrayList);
            y(i3).a(str, i3, arrayList);
            ajVar.f116524b = arrayList;
            if (ajVar.f116525c) {
                e1(str, i3);
            }
            J(arrayList, "get Roam Msg when aioBase is null");
            this.f116282e.qLogColor("refresh C2C finish , context = " + ajVar + " , size = " + arrayList.size(), ", timestamp = " + System.currentTimeMillis());
            if (ao.o(arrayList) && ajVar.f116537o < 3) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + ajVar.f116537o);
                }
                M(ajVar, i3);
            } else {
                this.f116282e.setChangeAndNotify(ajVar);
            }
            z17 = true;
        } else {
            this.f116282e.qLogColor("refresh from empty C2C msg", "");
            z17 = true;
            ajVar.f116525c = true;
            ajVar.f116527e = true;
            ajVar.f116524b = new ArrayList();
            this.f116282e.setChangeAndNotify(ajVar);
        }
        bVar.f116363a = z17;
        return z17;
    }

    private MessageRecord K0(MessageRecord messageRecord) {
        return y(messageRecord.istroop).e0(messageRecord.frienduin, messageRecord.istroop, messageRecord.time, messageRecord.senderuin, messageRecord.f203106msg);
    }

    private long L0(String str) {
        Pair<Long, Long> m06 = ((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).m0(str);
        if (m06 == null) {
            return 0L;
        }
        return ((Long) m06.first).longValue();
    }

    private long M0(boolean z16, long j3) {
        if (z16) {
            return Math.max(j3, NetConnInfoCenter.getServerTime() - 86400);
        }
        return j3;
    }

    private RecentUser N0(Map<String, RecentUser> map, RecentUserProxy recentUserProxy, String str, int i3, int i16, boolean z16) {
        RecentUser findRecentUserByUin;
        if (i3 != 1032) {
            findRecentUserByUin = recentUserProxy.findRecentUserByUin(str, i16);
        } else {
            findRecentUserByUin = recentUserProxy.findRecentUserByUin(str, i3);
        }
        if (z16) {
            findRecentUserByUin.lFlag = 16L;
        }
        if (map.containsKey(ao.f(findRecentUserByUin.uin, findRecentUserByUin.getType()))) {
            return map.get(ao.f(findRecentUserByUin.uin, findRecentUserByUin.getType()));
        }
        return findRecentUserByUin;
    }

    private void O0(String str, int i3, int i16, aj ajVar, ArrayList<MessageRecord> arrayList, MessageRecord messageRecord, long j3) {
        arrayList.size();
        ajVar.getClass();
    }

    private List<MessageRecord> P0(String str, int i3, long j3, long j16) {
        return Q0(str, i3, Math.min(j3, j16), Math.max(j3, j16));
    }

    @NotNull
    private ArrayList<MessageRecord> R0(List<MessageRecord> list, MessageRecord messageRecord) {
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MessageRecord messageRecord2 = list.get(i3);
            if (messageRecord2.time != messageRecord.time) {
                break;
            }
            arrayList.add(messageRecord2);
        }
        return arrayList;
    }

    private boolean T0(String str, int i3, int i16, aj ajVar, boolean z16, long j3, long j16, ArrayList<MessageRecord> arrayList, boolean z17) {
        int size;
        if (!ajVar.f116527e && j16 != 0 && (z17 || z16)) {
            return false;
        }
        U0(str, i3, j3, i16, ajVar, arrayList);
        I(arrayList);
        y(i3).a(str, i3, arrayList);
        ajVar.f116524b = arrayList;
        if (ajVar.f116525c) {
            e1(str, i3);
        }
        IMessageFacade iMessageFacade = this.f116282e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("refresh load local C2C msg only FIN , context = ");
        sb5.append(ajVar);
        sb5.append(", size = ");
        if (arrayList == null) {
            size = -1;
        } else {
            size = arrayList.size();
        }
        sb5.append(size);
        iMessageFacade.qLogColor(sb5.toString(), ", timestamp = " + System.currentTimeMillis());
        if (ao.o(arrayList) && ajVar.f116537o < 3) {
            M(ajVar, i3);
            return true;
        }
        this.f116282e.setChangeAndNotify(ajVar);
        return true;
    }

    private void W0(List<MessageRecord> list, long j3, ArrayList<MessageRecord> arrayList, List<MessageRecord> list2, List<MessageRecord> list3, MessageRecord messageRecord, MessageRecord messageRecord2) {
        boolean z16;
        boolean z17;
        for (MessageRecord messageRecord3 : list) {
            messageRecord.time = messageRecord3.time - 30;
            long j16 = messageRecord3.time + 30;
            messageRecord2.time = j16;
            List<MessageRecord> G0 = G0(list2, messageRecord.time, j16);
            if (list2 != null && list2.size() != 0) {
                Iterator<MessageRecord> it = G0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        MessageRecord next = it.next();
                        if (ad.b(next, messageRecord3, true)) {
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("C2CMsgFilter shmsgseq equals?");
                                if (messageRecord3.shmsgseq == next.shmsgseq) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                sb5.append(z17);
                                sb5.append(",msg=");
                                sb5.append(messageRecord3.getLogColorContent());
                                sb5.append("time:");
                                sb5.append(messageRecord3.time);
                                sb5.append("<->");
                                sb5.append(next.time);
                                sb5.append(", type=");
                                sb5.append(next.msgtype);
                                sb5.append("-");
                                sb5.append(messageRecord3.msgtype);
                                QLog.i("Q.msg.BaseMessageManager", 2, sb5.toString());
                            }
                            if (list3 != null && j3 != -1 && next.time <= j3) {
                                list3.add(next);
                            }
                            z16 = true;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "C2CMsgFilter not eq: msg=" + messageRecord3.getLogColorContent() + "time:" + messageRecord3.time + ",type:" + messageRecord3.msgtype + ",msg.con : " + messageRecord3.getLogColorContent());
                    }
                    if (list3 != null) {
                        list3.add(messageRecord3);
                    }
                    arrayList.add(messageRecord3);
                }
            } else {
                arrayList.add(messageRecord3);
                if (list3 != null) {
                    list3.add(messageRecord3);
                }
            }
        }
    }

    private boolean X0(int i3, aj ajVar, boolean z16, List<MessageRecord> list) {
        if ((list == null || list.isEmpty()) && !z16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
            }
            ajVar.f116524b = null;
            M(ajVar, i3);
            return true;
        }
        return false;
    }

    private boolean Y0(String str, int i3, int i16, aj ajVar) {
        if (S0(i3)) {
            ajVar.getClass();
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead TYPE ERROR! TYPE = " + i3);
            }
            ajVar.f116525c = true;
            ajVar.f116524b = null;
            M(ajVar, i3);
            return true;
        }
        return false;
    }

    private void Z0(String str, int i3, int i16, aj ajVar, boolean z16, long j3, MessageRecord messageRecord, ArrayList<MessageRecord> arrayList, boolean z17, Bundle bundle, long j16, int i17) {
        boolean z18;
        if (!bundle.getBoolean("timeout")) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + arrayList.size());
            }
            y(i3).e(str, i3, j16, arrayList);
            boolean z19 = bundle.getBoolean("success");
            boolean z26 = bundle.getBoolean("complete");
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + z19 + ", complete?" + z26);
            }
            if (z16 || (z19 && !z26)) {
                z18 = z26;
            } else {
                ajVar.f116527e = true;
                z18 = z26;
                U0(str, i3, arrayList.isEmpty() ? j16 : arrayList.get(0).uniseq, arrayList.isEmpty() ? i16 : i16 - arrayList.size(), ajVar, arrayList);
            }
            if (!z17) {
                ajVar.f116547y = bundle.getLong("tempEct");
                ajVar.f116548z = bundle.getLong("tempRandom");
                this.f116282e.qLogColor("update tempEct:" + ajVar.f116547y + ", rand=" + ajVar.f116548z, "");
            }
            if (z16 && arrayList.size() < i16 && z18) {
                O0(str, i3, i16, ajVar, arrayList, messageRecord, j3);
                return;
            }
            return;
        }
        this.f116282e.qLogColor("pull timeout", "");
        ajVar.f116527e = true;
        U0(str, i3, arrayList.isEmpty() ? j16 : arrayList.get(0).uniseq, i17, ajVar, arrayList);
    }

    private boolean a1(String str, int i3, int i16, aj ajVar, boolean z16, List<MessageRecord> list, long j3, MessageRecord messageRecord, ArrayList<MessageRecord> arrayList, boolean z17) {
        int i17;
        long j16;
        Bundle bundle = new Bundle();
        int addAndGet = this.f116282e.getPullCounter().addAndGet(1);
        bundle.putInt("counter", addAndGet);
        bundle.putBoolean("timeout", true);
        bundle.putLong(NowProxyConstants.AccountInfoKey.UID, Long.valueOf(str).longValue());
        bundle.putBoolean("canUpdateEct", z17);
        this.f116282e.getPullCache().put(Integer.valueOf(addAndGet), arrayList);
        ArrayList<MessageRecord> R0 = R0(list, messageRecord);
        long j17 = messageRecord.uniseq;
        int size = arrayList.size();
        if (arrayList.isEmpty()) {
            i17 = i16;
        } else {
            i17 = i16 - size;
        }
        bundle.putLong("baseTime", j3);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i17 + ",time=" + j3 + ",timeFilterList:" + R0.size());
        }
        int i18 = i17;
        if (!z17) {
            j16 = ajVar.f116548z;
        } else {
            j16 = 0;
        }
        ajVar.f116539q = true;
        ((IMessageHandlerService) QRoute.api(IMessageHandlerService.class)).getRoamMsgInOneDay(this.f116281d, str, j3, (short) i18, bundle, j16);
        bundle.putInt("size_req", i18);
        this.f116282e.getAutoPullCache().put(ao.f(str, i3), Boolean.FALSE);
        synchronized (arrayList) {
            try {
                arrayList.wait(35000L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
        j.c(this.f116281d, bundle, ajVar);
        if (this.f116282e.getAutoPullCache().containsKey(ao.f(str, i3)) && this.f116282e.getAutoPullCache().get(ao.f(str, i3)).booleanValue()) {
            ajVar.f116524b = null;
            this.f116282e.qLogColor("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
            this.f116282e.setChangeAndNotify(ajVar);
            return true;
        }
        if (bundle.getBoolean("timeout") && QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager", 2, "timeout!");
        }
        this.f116282e.qLogColor("after pull locallist" + arrayList.size(), "");
        this.f116282e.dumpmsgs("after pull locallist", arrayList);
        J(arrayList, "after pull msg break localList");
        E0(arrayList, R0);
        Z0(str, i3, i16, ajVar, z16, j3, messageRecord, arrayList, z17, bundle, j17, i18);
        return false;
    }

    private void b1(MessageRecord messageRecord, IConversationFacade iConversationFacade, int i3) {
        if (i3 != 3000 && i3 != 1 && i3 != 7000) {
            String str = messageRecord.frienduin;
            String str2 = AppConstants.LBS_HELLO_UIN;
            if (String.valueOf(str2).equals(str)) {
                str = messageRecord.senderuin;
            }
            if (i3 == 1001 && !messageRecord.isSend() && E.isRedPacketMsg(messageRecord)) {
                if (ao.B(messageRecord)) {
                    ReportController.o(this.f116281d, "CliOper", "", "", "0X8005C8E", "0X8005C8E", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(this.f116281d, "CliOper", "", "", "0X8005C8F", "0X8005C8F", 0, 0, "", "", "", "");
                }
            }
            if (ao.c(i3) != 1009 && iConversationFacade.isInMsgBox(str, 1009)) {
                String str3 = AppConstants.SAME_STATE_BOX_UIN;
                iConversationFacade.moveBoxToMessageTab(str3, 1009, str, messageRecord.istroop);
                W(str3, 1009, str, this.f116281d.getCurrentAccountUin());
            }
            if (ao.c(i3) != 1001 && iConversationFacade.isInMsgBox(str, 1001)) {
                iConversationFacade.moveBoxToMessageTab(str2, 1001, str, messageRecord.istroop);
                String str4 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                if (iConversationFacade.isInMsgBox(str, 1001, str4)) {
                    W(str4, 1001, str, this.f116281d.getCurrentAccountUin());
                } else {
                    W(str2, 1001, str, this.f116281d.getCurrentAccountUin());
                }
            }
            if (ao.c(i3) != 1010 && iConversationFacade.isInMsgBox(str, 1010)) {
                String str5 = AppConstants.DATE_UIN;
                iConversationFacade.moveBoxToMessageTab(str5, 1010, str, messageRecord.istroop);
                String str6 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
                if (iConversationFacade.isInMsgBox(str, 1010, str6)) {
                    W(str6, 1010, str, this.f116281d.getCurrentAccountUin());
                } else {
                    W(str5, 1010, str, this.f116281d.getCurrentAccountUin());
                }
            }
            if (ao.c(i3) != 1044 && iConversationFacade.isInMsgBox(str, 1044)) {
                String str7 = AppConstants.MATCH_CHAT_UIN;
                if (iConversationFacade.isInMsgBox(str, 1044, str7)) {
                    W(str7, 1044, str, this.f116281d.getCurrentAccountUin());
                }
            }
            if (ao.c(i3) != 10008 && iConversationFacade.isInMsgBox(str, 10008)) {
                String str8 = AppConstants.QCIRCLE_CHAT_UIN;
                if (iConversationFacade.isInMsgBox(str, 10008, str8)) {
                    W(str8, 10008, str, this.f116281d.getCurrentAccountUin());
                }
            }
        }
    }

    private List<MessageRecord> c1(String str, List<MessageRecord> list, long j3, long j16) {
        ArrayList arrayList = new ArrayList();
        ArrayList<MessageRecord> C0 = C0(str, list, arrayList, j3, j16);
        this.f116282e.dumpmsgs("needSave", C0);
        this.f116282e.dumpmsgs("msgInDB", arrayList);
        if (C0 != null && !C0.isEmpty()) {
            y(C0.get(0).istroop).d(C0, null);
        }
        for (MessageRecord messageRecord : C0) {
            if (messageRecord.getId() < 0) {
                this.f116282e.qLogColor("refresh C2C insert db error ! , mr.seq = " + messageRecord.shmsgseq + " , mr.uniseq = " + messageRecord.uniseq + ", mr.uid=" + messageRecord.msgUid, "mr.msg = " + messageRecord.getLogColorContent());
                MessageRecord K0 = K0(messageRecord);
                if (K0 == null) {
                    arrayList.remove(messageRecord);
                } else {
                    this.f116282e.qLogColor("refresh C2C insert db error ! , m.seq = " + K0.shmsgseq + " , mr.uniseq = " + K0.uniseq + ", m.uid=" + K0.msgUid, "");
                    arrayList.set(arrayList.indexOf(messageRecord), K0);
                }
            } else {
                this.f116282e.qLogColor("refresh C2C roam step 3 , mr.seq = " + messageRecord.shmsgseq + " , mr.uniseq = " + messageRecord.uniseq, "mr.msg = " + messageRecord.getLogColorContent());
            }
        }
        this.f116282e.qLogColor("setC2CRoamMessageResult needsave=" + C0.size(), "");
        return arrayList;
    }

    public static void d1(a aVar) {
        E = aVar;
    }

    private void e1(String str, int i3) {
        List<MessageRecord> aIOList;
        if ((1000 == i3 || 1004 == i3) && (aIOList = this.f116282e.getAIOList(str, i3)) != null && !aIOList.isEmpty()) {
            for (MessageRecord messageRecord : aIOList) {
                if (!messageRecord.isSend() && !ad.D(messageRecord.msgtype)) {
                    ((ChatMessage) aIOList.get(0)).mNeedGrayTips = true;
                    return;
                }
            }
        }
    }

    private void f1(Map<String, RecentUser> map, RecentUserProxy recentUserProxy, String str, int i3, long j3, RecentUser recentUser) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache start");
        }
        if (recentUserProxy.isUinInRecent(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache uin " + str);
            }
            recentUser.uin = str;
            recentUser.setType(ao.c(recentUser.getType()));
            if (j3 > recentUser.lastmsgtime) {
                recentUser.lastmsgtime = j3;
            }
            map.put(ao.f(str, i3), recentUser);
        }
    }

    private int g1(MessageRecord messageRecord, BaseMessageManager.a aVar, Map<String, RecentUser> map, RecentUserProxy recentUserProxy, String str, String str2, int i3, long j3, int i16, boolean z16) {
        RecentUser N0 = N0(map, recentUserProxy, str, i3, i16, z16);
        if (ad.D(messageRecord.msgtype)) {
            return i3;
        }
        if ((i3 == 1008 && !E.d(this.f116281d, str)) || BaseMessageManager.D.f(this.f116281d, messageRecord)) {
            return i3;
        }
        if (str.equals(AppConstants.NEARBY_LBS_HELLO_UIN)) {
            QLog.i("Q.msg.BaseMessageManager.NEARBY_MSG", 2, "mr.senderUin = " + messageRecord.senderuin);
            return i3;
        }
        if (i3 == 1009 && str.equals(AppConstants.SAME_STATE_BOX_UIN)) {
            n1(recentUserProxy, j3, N0);
            return i3;
        }
        if (i3 == 1032 && str.equals(AppConstants.CONFESS_UIN)) {
            j1(messageRecord, recentUserProxy, j3, N0);
            return i3;
        }
        if (E.e(this.f116281d, messageRecord, str, i3)) {
            l1(messageRecord, aVar, str, i3);
            return i3;
        }
        if (E.h(this.f116281d, messageRecord, str, i3, aVar)) {
            return i3;
        }
        int i17 = messageRecord.msgtype;
        if (i17 == -1034) {
            f1(map, recentUserProxy, str, i3, j3, N0);
            return i3;
        }
        if (i17 == -5010 && messageRecord.isSend()) {
            k1(messageRecord, map, str, i3, j3, N0);
            return i3;
        }
        if ((messageRecord.isBlessMsg || messageRecord.isCheckNeedShowInListTypeMsg) && messageRecord.isSend()) {
            i1(messageRecord, map, str, i3, j3, N0);
            return i3;
        }
        if (messageRecord.frienduin.equals(AppConstants.MAYKNOW_RECOMMEND_UIN) && messageRecord.istroop == 0) {
            m1(map, str, i3, j3, N0, "add recentUserCache MAYKNOW_RECOMMEND_UIN");
            return i3;
        }
        if (messageRecord.frienduin.equals(AppConstants.FRIEND_ANNIVER_UIN) && messageRecord.istroop == 0) {
            m1(map, str, i3, j3, N0, "add recentUserCache FRIEND_ANNIVER_UIN");
            return i3;
        }
        if (messageRecord.frienduin.equals(AppConstants.FRIEND_SYSTEM_MSG_UIN) && messageRecord.istroop == 0) {
            m1(map, str, i3, j3, N0, "add recentUserCache FRIEND_SYSTEM_MSG_UIN");
            return i3;
        }
        if (F0(i3, messageRecord, str)) {
            return i3;
        }
        return h1(messageRecord, map, str, str2, i3, j3, N0);
    }

    private int h1(MessageRecord messageRecord, Map<String, RecentUser> map, String str, String str2, int i3, long j3, RecentUser recentUser) {
        boolean z16;
        recentUser.uin = str;
        if (i3 == 1000 || i3 == 1020 || i3 == 1004) {
            if (E.k(this.f116281d, str)) {
                i3 = 0;
                recentUser.setType(0);
                recentUser.troopUin = "";
            } else if (!TextUtils.equals(str2, this.f116281d.getAccount()) && !TextUtils.equals(str2, str)) {
                recentUser.troopUin = str2;
            }
        }
        recentUser.setType(ao.c(recentUser.getType()));
        if (messageRecord instanceof MessageForUniteGrayTip) {
            z16 = ((MessageForUniteGrayTip) messageRecord).tipParam.f213689l;
        } else {
            z16 = true;
        }
        if (j3 > recentUser.lastmsgtime && z16) {
            recentUser.lastmsgtime = j3;
        }
        recentUser.updatedByRegisterProxy = messageRecord.fromRegisterProxy;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache ELSE");
        }
        map.put(ao.f(str, i3), recentUser);
        return i3;
    }

    private void i1(MessageRecord messageRecord, Map<String, RecentUser> map, String str, int i3, long j3, RecentUser recentUser) {
        if ((messageRecord.isBlessMsg && messageRecord.needUpdateMsgTag) || (messageRecord.isCheckNeedShowInListTypeMsg && messageRecord.needNeedShowInList)) {
            recentUser.uin = str;
            recentUser.setType(0);
            if (j3 > recentUser.lastmsgtime) {
                recentUser.lastmsgtime = j3;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache isBlessMsg");
            }
            map.put(ao.f(str, i3), recentUser);
        }
    }

    private void j1(MessageRecord messageRecord, RecentUserProxy recentUserProxy, long j3, RecentUser recentUser) {
        if (j3 > recentUser.lastmsgtime && E.g(messageRecord)) {
            recentUser.lastmsgtime = j3;
        }
        recentUser.setType(ao.c(recentUser.getType()));
        recentUserProxy.saveRecentUser(recentUser);
    }

    private void k1(MessageRecord messageRecord, Map<String, RecentUser> map, String str, int i3, long j3, RecentUser recentUser) {
        int i16 = messageRecord.istroop;
        if (i16 != 3000 && i16 != 1 && !messageRecord.frienduin.equals(messageRecord.selfuin)) {
            recentUser.setType(ao.c(recentUser.getType()));
            if (j3 > recentUser.lastmsgtime) {
                recentUser.lastmsgtime = j3;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache MSG_TYPE_DINGDONG_SCHEDULE_MSG");
            }
            map.put(ao.f(str, i3), recentUser);
        }
    }

    private void l1(MessageRecord messageRecord, BaseMessageManager.a aVar, String str, int i3) {
        String f16 = ao.f(str, i3);
        if (aVar.f116301f.containsKey(f16)) {
            aVar.f116301f.get(f16).add(messageRecord);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(messageRecord);
        aVar.f116301f.put(f16, arrayList);
    }

    private void m1(Map<String, RecentUser> map, String str, int i3, long j3, RecentUser recentUser, String str2) {
        recentUser.uin = AppConstants.RECOMMEND_CONTACT_UIN;
        recentUser.setType(4000);
        recentUser.displayName = this.f116281d.getApplication().getApplicationContext().getString(R.string.cil);
        if (j3 > recentUser.lastmsgtime) {
            recentUser.lastmsgtime = j3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, str2);
        }
        map.put(ao.f(str, i3), recentUser);
    }

    private void n1(RecentUserProxy recentUserProxy, long j3, RecentUser recentUser) {
        if (j3 > recentUser.lastmsgtime) {
            recentUser.lastmsgtime = j3;
        }
        recentUser.setType(ao.c(recentUser.getType()));
        recentUserProxy.saveRecentUser(recentUser);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public long A(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageRecord)).longValue();
        }
        return messageRecord.time;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void B(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, Bundle bundle) {
        int size;
        List<MessageRecord> list3;
        List<MessageRecord> list4;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), list, list2, bundle);
            return;
        }
        boolean z17 = bundle.getBoolean("success");
        boolean z18 = bundle.getBoolean("complete");
        List<MessageRecord> list5 = this.f116282e.getPullCache().get(Integer.valueOf(bundle.getInt("counter")));
        bundle.putBoolean("timeout", false);
        long j3 = bundle.getLong("baseTime");
        long j16 = bundle.getLong("lowTime");
        IMessageFacade iMessageFacade = this.f116282e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setC2CRoamMessageResult success=");
        sb5.append(z17);
        sb5.append(",complete=");
        sb5.append(z18);
        sb5.append(",res_size=");
        int i16 = -1;
        if (list == null) {
            size = -1;
        } else {
            size = list.size();
        }
        sb5.append(size);
        sb5.append(",baseT=");
        sb5.append(j3);
        sb5.append(",lowTime=");
        sb5.append(j16);
        iMessageFacade.qLogColor(sb5.toString(), "");
        if (list == null) {
            list3 = new ArrayList();
        } else {
            list3 = list;
        }
        if (list2 == null) {
            list4 = new ArrayList<>();
        } else {
            list4 = list2;
        }
        if (z17) {
            List<MessageRecord> c16 = c1(str, list3, j3, j16);
            if (list5 != null && !list5.isEmpty()) {
                long j17 = list5.get(0).time;
                ArrayList arrayList = new ArrayList();
                for (MessageRecord messageRecord : list5) {
                    if (messageRecord.time == j17) {
                        arrayList.add(messageRecord);
                    }
                }
                int i17 = 0;
                for (MessageRecord messageRecord2 : c16) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (ad.b((MessageRecord) it.next(), messageRecord2, true)) {
                                z16 = true;
                                break;
                            }
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16) {
                        list5.add(i17, messageRecord2);
                        i17++;
                        list4.add(messageRecord2);
                    }
                }
            } else if (list5 != null) {
                list5.addAll(c16);
            }
            IMessageFacade iMessageFacade2 = this.f116282e;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("setC2CRoamMessageResult locallist:");
            if (list5 != null) {
                i16 = list5.size();
            }
            sb6.append(i16);
            iMessageFacade2.qLogColor(sb6.toString(), "");
        }
        if (list5 != null) {
            synchronized (list5) {
                list5.notify();
            }
        }
    }

    public void B0(MessageRecord messageRecord, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, messageRecord, str, str2);
            return;
        }
        MessageRecord createMsgRecordByMsgType = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(messageRecord.msgtype);
        MessageRecord.copyMessageRecordBaseField(createMsgRecordByMsgType, messageRecord);
        createMsgRecordByMsgType.senderuin = str2;
        createMsgRecordByMsgType.frienduin = str;
        if (TextUtils.equals(AppConstants.LBS_HELLO_UIN, str)) {
            messageRecord.saveExtInfoToExtStr(AppConstants.Key.KEY_MSG_IN_CONVESATION_BOX, AppConstants.Key.KEY_MSG_IN_CONVESATION_BOX);
        }
        if (ao.c(messageRecord.istroop) == 1032) {
            createMsgRecordByMsgType.istroop = 1032;
        } else {
            createMsgRecordByMsgType.istroop = messageRecord.istroop;
        }
        if (!ad.D(messageRecord.msgtype)) {
            y(messageRecord.istroop).k(createMsgRecordByMsgType.frienduin, createMsgRecordByMsgType.istroop, createMsgRecordByMsgType.senderuin, createMsgRecordByMsgType.selfuin, createMsgRecordByMsgType.getExtraKey());
            c0(createMsgRecordByMsgType, null, false, true, 1);
        }
    }

    b H0(String str, int i3, int i16, aj ajVar, boolean z16, long j3, long j16, long j17, List<MessageRecord> list, ArrayList<MessageRecord> arrayList) {
        int size;
        b bVar = new b(null);
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        int i17 = 0;
        while (true) {
            if (i17 >= size) {
                break;
            }
            MessageRecord messageRecord = list.get(i17);
            if (messageRecord.uniseq == j3) {
                bVar.f116365c = messageRecord;
                bVar.f116366d = i17;
                break;
            }
            i17++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead cacheIndex:" + bVar.f116366d + ", itemList:" + list);
        }
        if (bVar.f116365c == null) {
            if (J0(bVar, str, i3, i16, ajVar, z16, j3, j16, arrayList)) {
                return bVar;
            }
        } else {
            I0(bVar, str, i3, i16, j17, list, arrayList);
        }
        bVar.f116363a = false;
        return bVar;
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
        super.M(ajVar, i3);
    }

    List<MessageRecord> Q0(String str, int i3, long j3, long j16) {
        List<MessageRecord> p16 = y(i3).p(str, i3);
        ArrayList arrayList = new ArrayList();
        if (p16 != null) {
            for (MessageRecord messageRecord : p16) {
                long j17 = messageRecord.time;
                if (j17 >= j3 && j17 <= j16) {
                    break;
                }
                arrayList.add(messageRecord);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB fromCache=" + arrayList.size());
            }
        }
        List<MessageRecord> V = y(i3).V(str, i3, j16, -1, String.format("time>=%d or time=%d", Long.valueOf(j3), Long.valueOf(j16)));
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB from=" + j3 + ",to=" + j16 + ",size=" + V.size());
        }
        Iterator<MessageRecord> it = ao.a(arrayList, V).iterator();
        while (it.hasNext()) {
            ad.q(arrayList, it.next(), false);
        }
        return arrayList;
    }

    protected boolean S0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        UinType valueOf = UinType.valueOf(i3);
        if (valueOf != null) {
            return valueOf.isInvalidUinTypeWhenRefresh();
        }
        if (i3 != 0 && i3 != 1000 && i3 != 1004 && i3 != 9501 && i3 != 1044 && i3 != 1045 && i3 != 10007 && i3 != 10008 && i3 != 10010 && i3 != 1046 && i3 != 1001) {
            return true;
        }
        return false;
    }

    public void U0(String str, int i3, long j3, int i16, aj ajVar, ArrayList<MessageRecord> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), ajVar, arrayList);
        } else {
            V0(str, i3, j3, i16, ajVar, arrayList, true);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void V(MessageRecord messageRecord, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, messageRecord, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in SubThread!");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in MainThread!");
        }
        E.a(this.f116281d, messageRecord);
        super.V(messageRecord, z16, z17);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void V0(String str, int i3, long j3, int i16, aj ajVar, ArrayList<MessageRecord> arrayList, boolean z16) {
        long j16;
        long j17;
        long j18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), ajVar, arrayList, Boolean.valueOf(z16));
            return;
        }
        MessageRecord H = y(i3).H(str, i3, j3);
        IMessageFacade iMessageFacade = this.f116282e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("loadFromLocal uniseq=");
        sb5.append(j3);
        sb5.append(",count=");
        sb5.append(i16);
        sb5.append(", fromtime=");
        if (H == null) {
            j16 = -1;
        } else {
            j16 = H.time;
        }
        sb5.append(j16);
        iMessageFacade.qLogColor(sb5.toString(), "");
        if (H != null) {
            long j19 = H.time;
            long id5 = H.getId();
            List<MessageRecord> p16 = y(i3).p(str, i3);
            ArrayList arrayList2 = new ArrayList();
            if (p16 != null) {
                for (MessageRecord messageRecord : p16) {
                    if (messageRecord.time > j19 || ad.b(H, messageRecord, true)) {
                        break;
                    } else {
                        arrayList2.add(messageRecord);
                    }
                }
                this.f116282e.dumpmsgs("loadFromLocal load from Cache", arrayList2);
            }
            if (arrayList.size() < i16 && arrayList2.size() > 0) {
                arrayList.addAll(0, arrayList2.subList(Math.max(arrayList2.size() - (i16 - arrayList.size()), 0), arrayList2.size()));
                if (arrayList.size() > 0) {
                    j18 = Math.min(j19, arrayList.get(0).time);
                    j17 = Math.max(Math.min(id5, arrayList.get(0).getId()), 0L);
                    if (arrayList.size() < i16) {
                        List<MessageRecord> q06 = y(i3).q0(str, i3, j17, H.versionCode, j18, i16, String.format(" or (time=%d and _id<%d) ", Long.valueOf(j18), Long.valueOf(j17)));
                        this.f116282e.qLogColor("queryTimedMessageDBUnion list size" + q06.size() + ", getID=" + H.getId(), "");
                        if (q06.isEmpty()) {
                            ajVar.f116525c = true;
                        } else {
                            if (q06.size() < i16) {
                                ajVar.f116525c = true;
                            }
                            this.f116282e.dumpmsgs("loadFromLocal load from DB", q06);
                            arrayList.addAll(0, q06);
                        }
                    }
                    ajVar.f116527e = z16;
                    return;
                }
            }
            j17 = id5;
            j18 = j19;
            if (arrayList.size() < i16) {
            }
            ajVar.f116527e = z16;
            return;
        }
        ajVar.f116527e = z16;
        ajVar.f116525c = true;
        this.f116282e.qLogColor("loadFromLocal complete", "");
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void a(MessageRecord messageRecord, EntityManager entityManager, boolean z16, boolean z17, boolean z18, boolean z19, BaseMessageManager.a aVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, messageRecord, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), aVar);
            return;
        }
        if (messageRecord == null) {
            return;
        }
        Map<String, RecentUser> map = aVar.f116296a;
        RecentUserProxy recentUserProxy = aVar.f116306k;
        IConversationFacade iConversationFacade = aVar.f116307l;
        if (messageRecord.time == 0) {
            messageRecord.time = com.tencent.mobileqq.service.message.e.K0();
        }
        if (messageRecord.msgseq == 0) {
            messageRecord.msgseq = (int) messageRecord.time;
        }
        String str = messageRecord.frienduin;
        String str2 = messageRecord.senderuin;
        int i16 = messageRecord.istroop;
        long j3 = messageRecord.time;
        b1(messageRecord, iConversationFacade, i16);
        if (A0(messageRecord, i16)) {
            return;
        }
        c d16 = new c(messageRecord, entityManager, map, recentUserProxy, iConversationFacade, str, i16, j3).d();
        String c16 = d16.c();
        int b16 = d16.b();
        long a16 = d16.a();
        int i17 = messageRecord.istroop;
        Iterator<com.tencent.imcore.message.adder.i> it = this.f116282e.getRegistry().f().iterator();
        boolean z26 = false;
        while (true) {
            if (it.hasNext()) {
                i3 = i17;
                boolean[] a17 = it.next().a(this.f116281d, this.f116282e, messageRecord, entityManager, recentUserProxy, c16, i17, z26, b16);
                z26 = a17[0];
                if (a17[1]) {
                    break;
                } else {
                    i17 = i3;
                }
            } else {
                i3 = i17;
                break;
            }
        }
        int g16 = g1(messageRecord, aVar, map, recentUserProxy, c16, str2, b16, a16, i3, z26);
        E.l(this, messageRecord);
        if (g16 == 1036) {
            this.f116282e.setIncomingMsg(null);
        }
        if (messageRecord.istroop == 10007) {
            com.tencent.mobileqq.imcore.proxy.business.d.a((BaseQQAppInterface) this.f116281d, recentUserProxy, messageRecord, false);
        }
        super.a(messageRecord, entityManager, z16, z17, z18, z19, aVar);
        if (com.tencent.mobileqq.imcore.proxy.business.h.a((BaseQQAppInterface) this.f116281d, messageRecord.frienduin, messageRecord.istroop) && !messageRecord.isSend()) {
            com.tencent.mobileqq.imcore.proxy.business.h.c((BaseQQAppInterface) this.f116281d, false);
        }
        E.b(this.f116281d, messageRecord);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imcore.message.BaseMessageManager
    public void b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, i3);
        } else {
            super.b(str, i3);
            E.f(this.f116281d, i3);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void e(String str, int i3, int i16, aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16), ajVar);
            return;
        }
        super.e(str, i3, i16, ajVar);
        ajVar.f116538p = 0;
        ajVar.f116539q = false;
        ajVar.f116546x = false;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void m(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) messageRecord);
        } else {
            ThreadManagerV2.post(new Runnable(messageRecord) { // from class: com.tencent.imcore.message.C2CMessageManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ MessageRecord f116362d;

                {
                    this.f116362d = messageRecord;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CMessageManager.this, (Object) messageRecord);
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
                        QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest " + this.f116362d.getLogColorContent());
                    }
                    BaseMessageManager.D.x(C2CMessageManager.this.f116281d, this.f116362d, 15000L);
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void n(String str, int i3, int i16, aj ajVar) {
        long j3;
        boolean z16;
        long j16;
        boolean z17;
        int i17;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), ajVar);
            return;
        }
        if (Y0(str, i3, i16, ajVar)) {
            j.a(this.f116281d, false, "3", "3", ajVar);
            return;
        }
        ajVar.getClass();
        List<MessageRecord> l3 = y(i3).l(str, i3);
        if (X0(i3, ajVar, false, l3)) {
            j.a(this.f116281d, false, "3", "21", ajVar);
            return;
        }
        if (E.dump() && l3 != null) {
            this.f116282e.dumpmsgs("current Aio", l3.subList(0, Math.min(i16, l3.size())));
        }
        if (l3 != null && !l3.isEmpty()) {
            j3 = l3.get(0).uniseq;
        } else {
            j3 = 0;
        }
        long L0 = L0(str);
        long M0 = M0(false, L0);
        List<MessageRecord> p16 = y(i3).p(str, i3);
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        this.f116282e.qLogColor("refreshC2CMessageListHead isLocalOnly=" + ajVar.f116527e + ",uniseq=" + j3 + ",ect=" + L0 + ", possibleBreakTime=" + M0, " ,getC2CRoamingSetting" + E.i(this.f116281d) + ",getC2CRoamingSettingServerFlagFeature=" + E.j(this.f116281d));
        if (E.i(this.f116281d) == 0 && !E.j(this.f116281d)) {
            z16 = true;
            ajVar.f116527e = true;
        } else {
            z16 = true;
        }
        am a16 = new am(l3, j3).a();
        long b16 = a16.b();
        if (T0(str, i3, i16, ajVar, false, b16, M0, arrayList, a16.c())) {
            if (ajVar.f116527e) {
                str2 = "2";
            } else {
                str2 = "22";
            }
            j.a(this.f116281d, false, str2, "3", ajVar);
            return;
        }
        b H0 = H0(str, i3, i16, ajVar, false, b16, L0, M0, p16, arrayList);
        if (H0.j()) {
            j.a(this.f116281d, false, "21", "3", ajVar);
            return;
        }
        MessageRecord h16 = H0.h();
        long i18 = H0.i();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead locallist size " + arrayList.size());
        }
        if (L0 > i18) {
            long min = Math.min(i18, ajVar.f116547y);
            this.f116282e.qLogColor("ect > fromTime!! newEct:" + min, "");
            j16 = min;
            z17 = false;
        } else {
            j16 = L0;
            z17 = true;
        }
        this.f116282e.dumpmsgs("before pull locallist", arrayList);
        this.f116282e.qLogColor("before pull locallist" + arrayList.size(), "");
        J(arrayList, "before pull localList");
        j.b(this.f116281d, arrayList, i16, j16, ajVar);
        int size = arrayList.size();
        ajVar.E += size;
        if (j16 > 0 && arrayList.size() < i16) {
            i17 = size;
            if (a1(str, i3, i16, ajVar, false, l3, j16, h16, arrayList, z17)) {
                return;
            }
        } else {
            i17 = size;
        }
        ajVar.D += arrayList.size() - i17;
        I(arrayList);
        y(i3).a(str, i3, arrayList);
        ajVar.f116524b = arrayList;
        if (ajVar.f116525c) {
            e1(str, i3);
        }
        J(arrayList, "after pull localList");
        if (D0(str, i3, ajVar, arrayList, i16)) {
            return;
        }
        QLog.i("Q.msg.BaseMessageManager", 1, "refresh C2C finish context=" + ajVar + ",size=" + arrayList.size() + ",count=" + i16);
        this.f116282e.setChangeAndNotify(ajVar);
    }
}
