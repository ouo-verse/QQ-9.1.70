package com.tencent.mobileqq.app.activateFriends;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.activateFriend.biz.c;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.db.d;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb$MsgBody;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb$MsgInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$MsgBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ActivateFriendsManager extends Observable implements Manager {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private int E;
    public int F;
    private long G;
    private long H;
    private long I;
    private long J;
    private Handler K;
    private com.tencent.mobileqq.activity.activateFriend.biz.c L;
    private Runnable M;
    Set<Integer> N;
    private int P;

    /* renamed from: d, reason: collision with root package name */
    private volatile Set<Long> f195232d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Set<Long> f195233e;

    /* renamed from: f, reason: collision with root package name */
    private volatile Set<Long> f195234f;

    /* renamed from: h, reason: collision with root package name */
    private volatile Set<Long> f195235h;

    /* renamed from: i, reason: collision with root package name */
    private final WeakReference<QQAppInterface> f195236i;

    /* renamed from: m, reason: collision with root package name */
    private SharedPreferences f195237m;

    public ActivateFriendsManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.C = 1;
        this.D = 2;
        this.E = 3;
        this.F = 1;
        this.M = new Runnable() { // from class: com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActivateFriendsManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                QQAppInterface qQAppInterface2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z17 = true;
                if (Math.abs(System.currentTimeMillis() - ActivateFriendsManager.this.G) > ActivateFriendsManager.this.H) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (Math.abs(System.currentTimeMillis() - ActivateFriendsManager.this.I) <= ActivateFriendsManager.this.J) {
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ActivateFriends.Manager", 2, "checkRunnable | lastBirthdayCheckInStamp = " + ActivateFriendsManager.this.G + " | checkBirthdayInterval = " + ActivateFriendsManager.this.H + " | lastMemorialCheckInStamp = " + ActivateFriendsManager.this.I + " | checkMemorialInterval = " + ActivateFriendsManager.this.J + " | isBirthday = " + z16 + " | isMemorial = " + z17);
                }
                if ((!z16 && !z17) || (qQAppInterface2 = (QQAppInterface) ActivateFriendsManager.this.f195236i.get()) == null) {
                    return;
                }
                a.g(qQAppInterface2, z16, z17);
                ActivateFriendsManager activateFriendsManager = ActivateFriendsManager.this;
                activateFriendsManager.F = activateFriendsManager.C;
            }
        };
        this.N = new HashSet();
        this.P = Integer.MIN_VALUE;
        this.f195236i = new WeakReference<>(qQAppInterface);
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(QQConstants.PREF_ACTIVATE_FRIENDS + qQAppInterface.getCurrentAccountUin(), 0);
        this.f195237m = sharedPreferences;
        this.G = sharedPreferences.getLong("key_check_stamp", 0L);
        this.I = this.f195237m.getLong("key_memorial_check_stamp", 0L);
        this.H = this.f195237m.getLong("key_check_interval", 120000L);
        this.J = this.f195237m.getLong("key_memorial_check_interval", 120000L);
        this.K = new Handler(ThreadManagerV2.getSubThreadLooper());
        com.tencent.mobileqq.activity.activateFriend.biz.c cVar = new com.tencent.mobileqq.activity.activateFriend.biz.c();
        this.L = cVar;
        qQAppInterface.addObserver(cVar);
    }

    public static void C(QQAppInterface qQAppInterface, submsgtype0xeb$MsgBody submsgtype0xeb_msgbody) {
        if (submsgtype0xeb_msgbody == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(1024);
        if (QLog.isColorLevel()) {
            sb5.append("activiate_friends|onReceiveReadedActivateFriendsPush|");
        }
        List<com.tencent.mobileqq.reminder.db.b> msgList = d.a(qQAppInterface).getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
        HashSet hashSet = new HashSet(msgList.size());
        if (QLog.isColorLevel()) {
            sb5.append((String) null);
            sb5.append("get unread msgs|");
        }
        for (com.tencent.mobileqq.reminder.db.b bVar : msgList) {
            if (!bVar.getIsread()) {
                String extInfoFromExtStr = bVar.getExtInfoFromExtStr("key_msg_ext_msg_seq");
                if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                    hashSet.add(extInfoFromExtStr);
                    if (QLog.isColorLevel()) {
                        sb5.append(extInfoFromExtStr);
                        sb5.append("|");
                    }
                }
            }
        }
        boolean z16 = false;
        if (submsgtype0xeb_msgbody.rpt_msg_info.has()) {
            Iterator<submsgtype0xeb$MsgInfo> it = submsgtype0xeb_msgbody.rpt_msg_info.get().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String num = Integer.toString(it.next().uint32_msg_seq.get());
                if (hashSet.contains(num)) {
                    if (QLog.isColorLevel()) {
                        sb5.append("we have ");
                        sb5.append(num);
                        sb5.append(" in unread msgs|");
                    }
                    z16 = true;
                }
            }
        } else if (QLog.isColorLevel()) {
            sb5.append("rpt_msg_info is null|");
        }
        if (z16) {
            d.a(qQAppInterface).setReaded(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ActivateFriends.Manager", 2, sb5.toString());
        }
    }

    public static int E(byte[] bArr) {
        try {
            SubMsgType0x76$MsgBody subMsgType0x76$MsgBody = new SubMsgType0x76$MsgBody();
            subMsgType0x76$MsgBody.mergeFrom(bArr);
            return subMsgType0x76$MsgBody.uint32_msg_type.get();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Manager", 2, "ParseMessageType catch error.", e16);
                return 1;
            }
            return 1;
        }
    }

    public static String o(Context context) {
        return context.getString(new int[]{R.string.f170158hm, R.string.f170163hr, R.string.f170162hq, R.string.f170156hk, R.string.f170155hj, R.string.f170160ho, R.string.f170159hn, R.string.f170154hi, R.string.f170157hl, R.string.f170161hp}[new Random().nextInt(10)]);
    }

    private String p() {
        QQAppInterface qQAppInterface = this.f195236i.get();
        if (qQAppInterface == null) {
            return "";
        }
        return qQAppInterface.getCurrentAccountUin();
    }

    private Set<Long> q(int i3) {
        if (i3 == 2) {
            if (this.f195235h != null) {
                return this.f195235h;
            }
            HashSet hashSet = new HashSet(6);
            String string = this.f195237m.getString("key_uin_expired_" + i3, "");
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Manager", 2, "getUinWishedSet, str = " + string + ", type = " + i3);
            }
            String[] split = string.split("-");
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(Long.valueOf(Long.parseLong(str)));
                }
            }
            this.f195235h = hashSet;
        }
        return this.f195235h;
    }

    public static String r(Context context, SubMsgType0x76$MsgBody subMsgType0x76$MsgBody) {
        return d.a(MobileQQ.sMobileQQ.peekAppRuntime()).getMessageDescrpition(subMsgType0x76$MsgBody);
    }

    private Set<Long> v(int i3) {
        Set<Long> set;
        if (i3 == 1) {
            set = this.f195232d;
        } else if (i3 == 2) {
            set = this.f195233e;
        } else {
            set = null;
        }
        if (set == null) {
            set = new HashSet<>(6);
            String string = this.f195237m.getString("key_uin_sended_" + i3, "");
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Manager", 2, "getUinSendedSet, str = " + string + ", msgType = " + i3);
            }
            for (String str : string.split("-")) {
                if (!TextUtils.isEmpty(str)) {
                    set.add(Long.valueOf(Long.parseLong(str)));
                }
            }
            if (i3 == 1) {
                this.f195232d = set;
            } else {
                this.f195233e = set;
            }
        }
        return set;
    }

    private Set<Long> w(int i3) {
        if (i3 == 2) {
            if (this.f195234f != null) {
                return this.f195234f;
            }
            HashSet hashSet = new HashSet(6);
            String string = this.f195237m.getString("key_uin_wished_" + i3, "");
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Manager", 2, "getUinWishedSet, str = " + string + ", type = " + i3);
            }
            String[] split = string.split("-");
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(Long.valueOf(Long.parseLong(str)));
                }
            }
            this.f195234f = hashSet;
        }
        return this.f195234f;
    }

    public boolean A(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3)).booleanValue();
        }
        if (this.P == i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.P = i3;
        return z16;
    }

    public void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        int i16 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Manager", 2, "onReceivePushMessage  msgType = " + i3);
        }
        this.f195237m.edit().putString("key_uin_sended_" + i3, "").commit();
        this.f195237m.edit().putString("key_uin_wished_" + i3, "").commit();
        this.f195237m.edit().putString("key_uin_expired_" + i3, "").commit();
        if (i3 == 1) {
            this.f195232d = new HashSet();
        } else if (i3 == 2) {
            this.f195233e = new HashSet();
        }
        if (i3 == 2 || i3 == 3) {
            if (i3 == 2) {
                i16 = 1;
            }
            LpReportInfo_pf00064.allReport(220, 1, i16);
            ReportController.o(this.f195236i.get(), "dc00898", "", "", "0X8007210", "0X8007211", 0, 0, "", "", "", "");
            this.f195237m.edit().putLong("key_last_birth_msg_stamp", e.K0()).commit();
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActivateFriendsManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQAppInterface qQAppInterface = (QQAppInterface) ActivateFriendsManager.this.f195236i.get();
                    if (qQAppInterface == null) {
                        return;
                    }
                    qQAppInterface.notifyObservers(b.class, 115, true, null);
                }
            });
        }
    }

    public void D(long[] jArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) jArr, i3);
            return;
        }
        HashSet hashSet = new HashSet(6);
        hashSet.addAll(v(i3));
        int size = hashSet.size();
        for (long j3 : jArr) {
            hashSet.add(Long.valueOf(j3));
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            sb5.append((Long) it.next());
            sb5.append("-");
        }
        this.f195237m.edit().putString("key_uin_sended_" + i3, sb5.toString()).commit();
        if (i3 == 1) {
            this.f195232d = hashSet;
        } else {
            this.f195233e = hashSet;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Manager", 2, "onSendTimingMsgSuc, send count = " + jArr.length + ", orginal count = " + size + ", new count = " + hashSet.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(long j3) {
        if (j3 < 120000) {
            j3 = 120000;
        }
        this.G = System.currentTimeMillis();
        this.H = j3;
        this.f195237m.edit().putLong("key_check_stamp", System.currentTimeMillis()).putLong("key_check_interval", j3).commit();
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Manager", 2, "saveBirthdayCheckInStamp=" + this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(long j3) {
        if (j3 < 120000) {
            j3 = 120000;
        }
        this.I = System.currentTimeMillis();
        this.J = j3;
        this.f195237m.edit().putLong("key_memorial_check_stamp", System.currentTimeMillis()).putLong("key_memorial_check_interval", j3).commit();
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Manager", 2, "saveMemorialCheckInStamp=" + this.J);
        }
    }

    public void H(long j3, Map<Long, Integer> map, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), map, Integer.valueOf(i3));
            return;
        }
        if (!p().equals(Long.toString(j3))) {
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Manager", 2, "currentUin:" + p() + " do not equals to QzoneUin" + Long.toString(j3));
                return;
            }
            return;
        }
        if (map != null && map.size() != 0 && i3 == 2) {
            HashSet hashSet = new HashSet(6);
            HashSet hashSet2 = new HashSet(6);
            if (w(i3) != null && w(i3).size() != 0) {
                hashSet.addAll(w(i3));
            }
            int size = hashSet.size();
            Set<Map.Entry<Long, Integer>> entrySet = map.entrySet();
            StringBuilder sb5 = new StringBuilder("QZone FriendUin :");
            for (Map.Entry<Long, Integer> entry : entrySet) {
                Long key = entry.getKey();
                Integer value = entry.getValue();
                if (key != null && value.intValue() == 1) {
                    sb5.append(Long.toString(key.longValue()) + "_" + value + "|");
                    hashSet.add(key);
                } else if (key != null && value.intValue() == 2) {
                    sb5.append(Long.toString(key.longValue()) + "_" + value + "|");
                    hashSet2.add(key);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Manager", 2, sb5.toString());
            }
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                sb6.append((Long) it.next());
                sb6.append("-");
            }
            Iterator it5 = hashSet2.iterator();
            while (it5.hasNext()) {
                sb7.append((Long) it5.next());
                sb7.append("-");
            }
            this.f195237m.edit().putString("key_uin_wished_" + i3, sb6.toString()).commit();
            this.f195237m.edit().putString("key_uin_expired_" + i3, sb7.toString()).commit();
            this.f195234f = hashSet;
            this.f195235h = hashSet2;
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Manager", 2, "WishedFriends count = " + map.size() + ", orginal count = " + size + ", new count = " + hashSet.size());
            }
        }
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.K.removeCallbacks(this.M);
        this.F = this.D;
        QQAppInterface qQAppInterface = this.f195236i.get();
        if (qQAppInterface == null) {
            return;
        }
        a.h(qQAppInterface, false, true, false, true);
    }

    public void J(int i3, long[] jArr, long[] jArr2, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), jArr, jArr2, str);
        } else {
            K(i3, jArr, jArr2, str, -1);
        }
    }

    public void K(int i3, long[] jArr, long[] jArr2, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), jArr, jArr2, str, Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("sendMessages | uin = ");
            if (jArr != null && jArr.length != 0) {
                for (long j3 : jArr) {
                    sb5.append(s(String.valueOf(j3)));
                    sb5.append(",");
                }
            } else {
                sb5.append("null");
            }
            sb5.append(" | time = ");
            if (jArr2 != null && jArr2.length != 0) {
                for (long j16 : jArr2) {
                    sb5.append(j16);
                    sb5.append(",");
                }
            } else {
                sb5.append("null");
            }
            sb5.append(" | giftId = ");
            sb5.append(i16);
            QLog.d("ActivateFriends.Manager", 2, sb5.toString());
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(i3, jArr, str, i16, jArr2) { // from class: com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f195238d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long[] f195239e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f195240f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f195241h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ long[] f195242i;

            {
                this.f195238d = i3;
                this.f195239e = jArr;
                this.f195240f = str;
                this.f195241h = i16;
                this.f195242i = jArr2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ActivateFriendsManager.this, Integer.valueOf(i3), jArr, str, Integer.valueOf(i16), jArr2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QQAppInterface qQAppInterface = (QQAppInterface) ActivateFriendsManager.this.f195236i.get();
                if (qQAppInterface == null) {
                    return;
                }
                int i18 = this.f195238d;
                if (i18 == 1) {
                    for (long j17 : this.f195239e) {
                        SessionInfo sessionInfo = new SessionInfo();
                        sessionInfo.f179557e = String.valueOf(j17);
                        sessionInfo.f179555d = 0;
                        sessionInfo.f179563i = ac.H(qQAppInterface, String.valueOf(j17));
                        ChatActivityFacade.d dVar = new ChatActivityFacade.d();
                        dVar.f175137a = false;
                        ChatActivityFacade.M0(qQAppInterface, qQAppInterface.getApp(), sessionInfo, this.f195240f, null, dVar);
                    }
                    ActivateFriendsManager.this.D(this.f195239e, 1);
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_rt_type", 0);
                    qQAppInterface.notifyObservers(b.class, 113, true, bundle);
                    return;
                }
                if (i18 == 2 && (i17 = this.f195241h) != -1 && !a.j(qQAppInterface, this.f195240f, this.f195239e, this.f195242i, i17)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("key_rt_type", 2);
                    qQAppInterface.notifyObservers(b.class, 113, false, bundle2);
                }
            }
        });
    }

    public void L(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Manager", 2, "isOpen: ", Boolean.valueOf(z16), " isRemote: ", Boolean.valueOf(z17));
            QLog.d("ActivateFriends.Manager", 2, "stack:", new Throwable());
        }
        QQAppInterface qQAppInterface = this.f195236i.get();
        if (qQAppInterface == null) {
            return;
        }
        if (z17) {
            ((CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).X4(z16);
            return;
        }
        this.f195237m.edit().putBoolean(qQAppInterface.getApp().getString(R.string.cxm) + qQAppInterface.getCurrentAccountUin(), z16).commit();
    }

    public boolean M(byte[] bArr) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr)).booleanValue();
        }
        int E = E(bArr);
        synchronized (this.N) {
            if (!this.N.contains(Integer.valueOf(E))) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.N.add(Integer.valueOf(E));
        }
        return z16;
    }

    public boolean N(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr)).booleanValue();
        }
        try {
            SubMsgType0x76$MsgBody subMsgType0x76$MsgBody = new SubMsgType0x76$MsgBody();
            subMsgType0x76$MsgBody.mergeFrom(bArr);
            boolean z16 = subMsgType0x76$MsgBody.bool_strong_notify.get();
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Manager", 2, "shouldMsgTips | " + z16);
            }
            return z16;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Manager", 2, "IsMessageTipsInBackground catch error.", e16);
                return false;
            }
            return false;
        }
    }

    public void k(WeakReference<c.a> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference);
        } else {
            this.L.a(weakReference);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActivateFriendsManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                long j3 = ActivateFriendsManager.this.f195237m.getLong("key_last_birth_msg_stamp", 0L);
                if (QLog.isColorLevel()) {
                    QLog.d("ActivateFriends.Manager", 2, "local birth timestamp = " + j3);
                }
                if (e.K0() - j3 > 259200) {
                    ActivateFriendsManager.this.K.removeCallbacks(ActivateFriendsManager.this.M);
                    ActivateFriendsManager activateFriendsManager = ActivateFriendsManager.this;
                    activateFriendsManager.F = activateFriendsManager.E;
                    QQAppInterface qQAppInterface = (QQAppInterface) ActivateFriendsManager.this.f195236i.get();
                    if (qQAppInterface == null) {
                        return;
                    }
                    a.h(qQAppInterface, false, true, false, true);
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManager.getSubThreadHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.K.removeCallbacks(this.M);
            this.K.postDelayed(this.M, 60000L);
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        synchronized (this.N) {
            this.N.clear();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        this.K.removeCallbacks(this.M);
        QQAppInterface qQAppInterface = this.f195236i.get();
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.L);
        }
    }

    String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() <= 3) {
            return str;
        }
        return str.substring(str.length() - 3, str.length());
    }

    public boolean t(boolean z16) {
        TempGetProfileDetailProcessor tempGetProfileDetailProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, z16)).booleanValue();
        }
        QQAppInterface qQAppInterface = this.f195236i.get();
        if (qQAppInterface == null) {
            return true;
        }
        if (z16 && (tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(qQAppInterface, TempGetProfileDetailProcessor.class)) != null) {
            tempGetProfileDetailProcessor.getActivateFriendSwitch();
        }
        return this.f195237m.getBoolean(qQAppInterface.getApp().getString(R.string.cxm) + p(), true);
    }

    public boolean u(boolean z16) {
        TempGetProfileDetailProcessor tempGetProfileDetailProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, z16)).booleanValue();
        }
        QQAppInterface qQAppInterface = this.f195236i.get();
        if (qQAppInterface == null) {
            return false;
        }
        if (z16 && (tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(qQAppInterface, TempGetProfileDetailProcessor.class)) != null) {
            tempGetProfileDetailProcessor.getActivateFriendSwitch();
        }
        return this.f195237m.getBoolean(qQAppInterface.getApp().getString(R.string.cxm) + qQAppInterface.getCurrentAccountUin(), false);
    }

    public boolean x(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
        }
        if (q(i3) == null || q(i3).size() == 0) {
            return false;
        }
        return q(i3).contains(Long.valueOf(j3));
    }

    public boolean y(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
        }
        return v(i3).contains(Long.valueOf(j3));
    }

    public boolean z(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
        }
        if (w(i3) == null || w(i3).size() == 0) {
            return false;
        }
        return w(i3).contains(Long.valueOf(j3));
    }
}
