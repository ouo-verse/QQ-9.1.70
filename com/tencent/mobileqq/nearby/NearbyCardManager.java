package com.tencent.mobileqq.nearby;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ay;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x686.Oidb_0x686$CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyCharmNotify;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd$SelfInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyCardManager implements Manager, b {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f252503d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f252504e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f252505f = Integer.MIN_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private int f252506h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private long f252507i = 0;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f252508m = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> C = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> D = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> E = new ConcurrentHashMap<>();

    public NearbyCardManager(QQAppInterface qQAppInterface) {
        r(qQAppInterface);
    }

    public static void v(Object obj, String str, Object obj2, Object obj3) {
        QQAppInterface qQAppInterface = (QQAppInterface) obj;
        Oidb_0x686$CharmEvent oidb_0x686$CharmEvent = (Oidb_0x686$CharmEvent) obj2;
        Oidb_0x686$NearbyCharmNotify oidb_0x686$NearbyCharmNotify = (Oidb_0x686$NearbyCharmNotify) obj3;
        l.c(LogTag.NEARBY, "updateNearbyPeopleCard", str, oidb_0x686$CharmEvent, oidb_0x686$NearbyCharmNotify);
        if (qQAppInterface == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (oidb_0x686$CharmEvent == null && oidb_0x686$NearbyCharmNotify == null) {
            return;
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        NearbyPeopleCard nearbyPeopleCard = !StringUtil.isEmpty(str) ? (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "uin=?", new String[]{str}) : null;
        if (nearbyPeopleCard == null) {
            return;
        }
        if (oidb_0x686$CharmEvent != null && oidb_0x686$CharmEvent.uint32_new_charm.get() > 0 && oidb_0x686$CharmEvent.uint32_cur_level_threshold.get() > oidb_0x686$CharmEvent.uint32_next_level_threshold.get()) {
            nearbyPeopleCard.charm = oidb_0x686$CharmEvent.uint32_new_charm.get();
            nearbyPeopleCard.charmLevel = oidb_0x686$CharmEvent.uint32_new_charm_level.get();
            nearbyPeopleCard.curThreshold = oidb_0x686$CharmEvent.uint32_cur_level_threshold.get();
            nearbyPeopleCard.nextThreshold = oidb_0x686$CharmEvent.uint32_next_level_threshold.get();
        } else if (oidb_0x686$NearbyCharmNotify != null) {
            nearbyPeopleCard.charm = oidb_0x686$NearbyCharmNotify.uint32_new_charm.get();
            nearbyPeopleCard.charmLevel = oidb_0x686$NearbyCharmNotify.uint32_new_charm_level.get();
            nearbyPeopleCard.curThreshold = oidb_0x686$NearbyCharmNotify.uint32_cur_level_threshold.get();
            nearbyPeopleCard.nextThreshold = oidb_0x686$NearbyCharmNotify.uint32_next_level_threshold.get();
            nearbyPeopleCard.profPercent = oidb_0x686$NearbyCharmNotify.uint32_new_prof_percent.get();
        }
        createEntityManager.update(nearbyPeopleCard);
        createEntityManager.close();
    }

    public static void w(Object obj) {
        final QQAppInterface qQAppInterface = (QQAppInterface) obj;
        if (QLog.isDevelopLevel()) {
            QLog.d(LogTag.NEARBY_PEOPLE_CARD, 4, "updateNearbyProfileCardHead");
        }
        qQAppInterface.deleteStrangerFace(qQAppInterface.getCurrentAccountUin(), 200);
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory(qQAppInterface.getAccount()).createEntityManager();
        if (createEntityManager != null) {
            NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "uin=?", new String[]{qQAppInterface.getCurrentAccountUin()});
            if (nearbyPeopleCard != null) {
                long j3 = nearbyPeopleCard.tinyId;
                if (j3 > 0) {
                    qQAppInterface.deleteStrangerFace(String.valueOf(j3), 202);
                }
            }
            createEntityManager.close();
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.NearbyCardManager.1
            @Override // java.lang.Runnable
            public void run() {
                QQAppInterface qQAppInterface2 = QQAppInterface.this;
                qQAppInterface2.refreshStrangerFace(qQAppInterface2.getCurrentAccountUin(), 200, true);
                long longValue = ((Long) com.tencent.mobileqq.nearby.api.e.m(QQAppInterface.this.getAccount(), INearbySPUtil.SP_KEY_SELF_TINNYID, 0L)).longValue();
                if (longValue == 0) {
                    QQAppInterface qQAppInterface3 = QQAppInterface.this;
                    EntityManager createEntityManager2 = qQAppInterface3.getEntityManagerFactory(qQAppInterface3.getAccount()).createEntityManager();
                    if (createEntityManager2 != null) {
                        NearbyPeopleCard nearbyPeopleCard2 = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager2, NearbyPeopleCard.class, "uin=?", new String[]{QQAppInterface.this.getCurrentAccountUin()});
                        if (nearbyPeopleCard2 != null) {
                            longValue = nearbyPeopleCard2.tinyId;
                        }
                        createEntityManager2.close();
                    }
                }
                if (longValue != 0) {
                    QQAppInterface.this.refreshStrangerFace(String.valueOf(longValue), 202, true);
                }
            }
        }, 2000L);
    }

    @Override // com.tencent.mobileqq.nearby.b
    public void a(int i3) {
        if (i3 != o()) {
            t(i3);
            com.tencent.mobileqq.nearby.api.e.t(l().getAccount(), INearbySPUtil.SP_KEY_SELF_AGE, Integer.valueOf(o()));
        }
    }

    @Override // com.tencent.mobileqq.nearby.b
    public int b() {
        Card r16;
        if (o() == Integer.MIN_VALUE && (r16 = ((FriendsManager) l().getManager(QQManagerFactory.FRIENDS_MANAGER)).r(l().getCurrentAccountUin())) != null && (r16.age != 0 || !TextUtils.isEmpty(r16.strNick))) {
            byte b16 = r16.age;
            a(-2147483648 != b16 ? b16 : (byte) -2147483648);
        }
        return o();
    }

    @Override // com.tencent.mobileqq.nearby.b
    public ConcurrentHashMap<String, Integer> c() {
        return this.E;
    }

    @Override // com.tencent.mobileqq.nearby.b
    public void d(int i3) {
        com.tencent.mobileqq.hotchat.a a16;
        int p16 = p();
        if (i3 == 0) {
            u(1);
        } else if (i3 != 1) {
            u(0);
        } else {
            u(2);
        }
        if (p16 != p()) {
            ay hotChatMng = l().getHotChatMng(false);
            if (hotChatMng != null && (a16 = hotChatMng.a(false)) != null) {
                a16.a(l().getCurrentAccountUin(), null, i3, NetConnInfoCenter.getServerTime());
            }
            com.tencent.mobileqq.nearby.api.e.t(l().getAccount(), INearbySPUtil.SP_KEY_SELF_GENDER, Integer.valueOf(p()));
        }
    }

    @Override // com.tencent.mobileqq.nearby.b
    public boolean f() {
        return ((Boolean) com.tencent.mobileqq.nearby.api.e.m(l().getCurrentAccountUin(), INearbySPUtil.SP_KEY_SELF_GOD_FLAG, Boolean.FALSE)).booleanValue();
    }

    @Override // com.tencent.mobileqq.nearby.b
    public long g() {
        return this.f252507i;
    }

    @Override // com.tencent.mobileqq.nearby.b
    public int getSelfGender() {
        int i3;
        if (p() == Integer.MIN_VALUE) {
            Card q16 = ((FriendsManager) l().getManager(QQManagerFactory.FRIENDS_MANAGER)).q(l().getCurrentAccountUin());
            if (q16 != null) {
                i3 = q16.shGender;
            } else {
                NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(l().getEntityManagerFactory(l().getCurrentAccountUin()).createEntityManager(), NearbyPeopleCard.class, "uin=?", new String[]{l().getCurrentAccountUin()});
                i3 = nearbyPeopleCard != null ? nearbyPeopleCard.gender : -1;
            }
            d(i3);
        }
        return p();
    }

    @Override // com.tencent.mobileqq.nearby.b
    public void h(Object obj) {
        oidb_0x8dd$SelfInfo oidb_0x8dd_selfinfo = (oidb_0x8dd$SelfInfo) obj;
        if (oidb_0x8dd_selfinfo == null) {
            return;
        }
        EntityManager createEntityManager = l().getEntityManagerFactory(l().getCurrentAccountUin()).createEntityManager();
        if (createEntityManager != null) {
            boolean z16 = true;
            boolean z17 = false;
            NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "uin=?", new String[]{l().getCurrentAccountUin()});
            if (nearbyPeopleCard == null && oidb_0x8dd_selfinfo.uint64_tinyid.get() > 0) {
                nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "tinyId=?", new String[]{String.valueOf(oidb_0x8dd_selfinfo.uint64_tinyid.get())});
            }
            if (nearbyPeopleCard == null) {
                nearbyPeopleCard = new NearbyPeopleCard();
            }
            if (oidb_0x8dd_selfinfo.uint64_tinyid.get() > 0) {
                nearbyPeopleCard.tinyId = oidb_0x8dd_selfinfo.uint64_tinyid.get();
                nearbyPeopleCard.uin = l().getCurrentAccountUin();
            }
            int i3 = oidb_0x8dd_selfinfo.uint32_vote_num.get();
            if (oidb_0x8dd_selfinfo.uint32_vote_num.has() && i3 > 0) {
                nearbyPeopleCard.likeCount = i3;
            }
            int i16 = oidb_0x8dd_selfinfo.uint32_vote_increment.get();
            if (oidb_0x8dd_selfinfo.uint32_vote_increment.has() && i16 > 0) {
                nearbyPeopleCard.likeCountInc = i16;
            }
            nearbyPeopleCard.gender = (byte) oidb_0x8dd_selfinfo.uint32_gender.get();
            nearbyPeopleCard.nickname = oidb_0x8dd_selfinfo.bytes_nick.get().toStringUtf8();
            nearbyPeopleCard.age = oidb_0x8dd_selfinfo.uint32_age.get();
            if (nearbyPeopleCard.getStatus() == 1000) {
                createEntityManager.persistOrReplace(nearbyPeopleCard);
            } else if (nearbyPeopleCard.getStatus() == 1001 || nearbyPeopleCard.getStatus() == 1002) {
                createEntityManager.update(nearbyPeopleCard);
            }
            Card q16 = ((FriendsManager) l().getManager(QQManagerFactory.FRIENDS_MANAGER)).q(l().getCurrentAccountUin());
            if (q16 != null) {
                int i17 = oidb_0x8dd_selfinfo.uint32_vote_num.get();
                if (oidb_0x8dd_selfinfo.uint32_vote_num.has() && i17 > 0) {
                    q16.lVoteCount = i17;
                    z17 = true;
                }
                int i18 = oidb_0x8dd_selfinfo.uint32_vote_increment.get();
                if (!oidb_0x8dd_selfinfo.uint32_vote_increment.has() || i18 <= 0) {
                    z16 = z17;
                } else {
                    q16.iVoteIncrement = i18;
                }
                if (z16) {
                    com.tencent.mobileqq.nearby.api.e.v(l().getAccount(), q16.lVoteCount, q16.iVoteIncrement);
                    createEntityManager.update(q16);
                }
            }
            createEntityManager.close();
        }
        d(oidb_0x8dd_selfinfo.uint32_gender.get());
        a(oidb_0x8dd_selfinfo.uint32_age.get());
        com.tencent.mobileqq.nearby.api.e.t(l().getAccount(), INearbySPUtil.SP_KEY_SELF_THIRD_LINE_INFO, oidb_0x8dd_selfinfo.str_third_line_info.get());
        com.tencent.mobileqq.nearby.api.e.t(l().getAccount(), INearbySPUtil.SP_KEY_SELF_THIRD_LINE_ICON, oidb_0x8dd_selfinfo.str_third_line_icon.get());
    }

    public synchronized void i(String str, long j3) {
        if (!TextUtils.isEmpty(str) && j3 > 0) {
            m().put(str, Long.valueOf(j3));
        }
    }

    public void j(String str, long j3) {
        if (TextUtils.isEmpty(str) || j3 <= 0) {
            return;
        }
        n().put(str, Long.valueOf(j3));
    }

    public synchronized void k() {
        if (m() != null) {
            m().clear();
        }
    }

    public QQAppInterface l() {
        return this.f252503d;
    }

    public ConcurrentHashMap<String, Long> m() {
        return this.f252508m;
    }

    public ConcurrentHashMap<String, Long> n() {
        return this.C;
    }

    public int o() {
        return this.f252506h;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        synchronized (this) {
            k();
        }
    }

    public int p() {
        return this.f252505f;
    }

    public void r(QQAppInterface qQAppInterface) {
        this.f252503d = qQAppInterface;
    }

    public void s(boolean z16) {
        this.f252504e = z16;
    }

    public void t(int i3) {
        this.f252506h = i3;
    }

    public void u(int i3) {
        this.f252505f = i3;
    }

    public static boolean q(String str) {
        return str != null && str.length() >= 18;
    }

    @Override // com.tencent.mobileqq.nearby.b
    public int e(int i3) {
        if (i3 == 0 || i3 == 1) {
            int selfGender = getSelfGender();
            char c16 = selfGender == 1 ? (char) 0 : selfGender == 2 ? (char) 1 : '\uffff';
            if (c16 == 0 || c16 == 1) {
                return c16 == 1 ? i3 == 1 ? 3 : 2 : i3 == 1 ? 1 : 4;
            }
        }
        return 0;
    }
}
