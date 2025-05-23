package com.tencent.mobileqq.troop.utils;

import android.database.Cursor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletContent;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class aw {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Boolean> f302088a;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, as> f302089b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, Boolean> f302090c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76785);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f302088a = new ConcurrentHashMap<>();
        f302089b = new ConcurrentHashMap<>();
        f302090c = new HashMap<>();
    }

    public aw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static as d(QQAppInterface qQAppInterface, String str) {
        Boolean bool;
        String str2;
        if (str == null) {
            QLog.e("TroopNotificationHelper", 1, "HasUnReadRepeatTroopNotification, troopUin is NULL!");
        } else if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. troop = " + str);
        }
        ConcurrentHashMap<String, as> concurrentHashMap = f302089b;
        as asVar = concurrentHashMap.get(str);
        if (asVar != null) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("HasUnReadRepeatTroopNotification. found in mTroopNotificationRepeatAIOFlag. type = ");
                sb5.append(asVar.f302082b);
                sb5.append(", feedsId = ");
                if (TextUtils.isEmpty(asVar.f302081a)) {
                    str2 = "";
                } else {
                    str2 = asVar.f302081a;
                }
                sb5.append(str2);
                QLog.d("TroopNotificationHelper", 2, sb5.toString());
            }
            return asVar;
        }
        TroopInfo k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. nothing in DB. return null");
            }
            return null;
        }
        TroopExtDBInfo troopExtDBInfo = k3.extDBInfo;
        String str3 = troopExtDBInfo.feedsId;
        if (str3 == null) {
            ConcurrentHashMap<String, Boolean> concurrentHashMap2 = f302088a;
            if (concurrentHashMap2.containsKey(str) && (bool = concurrentHashMap2.get(str)) != null && bool.booleanValue()) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification = false, but mTroopNotificationAIOFlag is set. Checking old version DB.");
                }
                EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                List<? extends Entity> query = createEntityManager.query(TroopNotificationCache.class, true, "troopUin=? and read=?", new String[]{str, "0"}, null, null, null, null);
                createEntityManager.close();
                if (query != null && query.size() > 0 && query.get(0) != null && ((TroopNotificationCache) query.get(0)).feedsId != null) {
                    r(qQAppInterface, ((TroopNotificationCache) query.get(0)).feedsId, str, 0);
                    as asVar2 = concurrentHashMap.get(str);
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification(Old Flag). type = 0");
                    }
                    return asVar2;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. feedisId is empty. return null");
                return null;
            }
            return null;
        }
        as asVar3 = new as(str3, troopExtDBInfo.troopRepeatType);
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. type = " + asVar3.f302082b);
        }
        return asVar3;
    }

    public static void e(String str, QQAppInterface qQAppInterface) {
        if (str != null && qQAppInterface != null) {
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            List<? extends Entity> query = createEntityManager.query(TroopNotificationCache.class, TroopNotificationCache.class.getSimpleName(), false, "troopUin=?", new String[]{str}, (String) null, (String) null, (String) null, (String) null);
            if (query == null) {
                return;
            }
            for (int i3 = 0; i3 < query.size(); i3++) {
                createEntityManager.remove((TroopNotificationCache) query.get(i3));
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationHelper", 2, aw.class.getSimpleName() + "-->clearTroopNotification. troop = " + str);
            }
        }
    }

    public static void f(final long j3, final RemindGroupBulletinMsg remindGroupBulletinMsg) {
        if (remindGroupBulletinMsg != null && !TextUtils.isEmpty(remindGroupBulletinMsg.getFeedId())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.av
                @Override // java.lang.Runnable
                public final void run() {
                    aw.j(RemindGroupBulletinMsg.this, j3);
                }
            }, 32, null, false);
            return;
        }
        QLog.d("TroopNotificationHelper", 1, "getTroopNotification troopUin=" + j3 + " feedId is empty.");
    }

    public static void g(final FirstGroupBulletinInfo firstGroupBulletinInfo) {
        if (firstGroupBulletinInfo != null && firstGroupBulletinInfo.getFirstContents() != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.au
                @Override // java.lang.Runnable
                public final void run() {
                    aw.k(FirstGroupBulletinInfo.this);
                }
            }, 32, null, false);
        } else {
            QLog.d("TroopNotificationHelper", 1, "getTroopNotificationFirstBulletinNotify firstGroupBulletinInfo is empty.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
    
        if (r0.moveToFirst() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005b, code lost:
    
        r3 = r0.getColumnIndex("troopUin");
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0060, code lost:
    
        if (r3 == (-1)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0062, code lost:
    
        r5 = r0.getLong(r3);
        r3 = com.tencent.mobileqq.troop.utils.aw.f302088a;
        r7 = java.lang.String.valueOf(r5);
        r8 = java.lang.Boolean.TRUE;
        r3.put(r7, r8);
        r3 = r0.getColumnIndex("feedType");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0075, code lost:
    
        if (r3 == (-1)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007d, code lost:
    
        if (r0.getInt(r3) != 34) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0083, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0085, code lost:
    
        com.tencent.qphone.base.util.QLog.d("TroopNotificationHelper", 2, "newGuideMap add " + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009a, code lost:
    
        com.tencent.mobileqq.troop.utils.aw.f302090c.put(java.lang.String.valueOf(r5), r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a7, code lost:
    
        if (r0.moveToNext() != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "initTroopNotificationFlag");
        }
        f302088a.clear();
        f302090c.clear();
        f302089b.clear();
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        Cursor query = createEntityManager.query(true, TroopNotificationCache.class.getSimpleName(), new String[]{"troopUin", "feedType", "serviceID"}, "read=?", new String[]{String.valueOf(0)}, "troopUin", (String) null, (String) null, (String) null);
        if (query != null) {
            try {
                try {
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopNotificationHelper", 2, "initTroopNotificationFlag Exception");
                    }
                    createEntityManager.close();
                }
            } finally {
                query.close();
            }
        }
        createEntityManager.close();
    }

    public static boolean i(QQAppInterface qQAppInterface, String str, String str2) {
        boolean z16 = false;
        if (str2 == null) {
            QLog.e("TroopNotificationHelper", 1, "isTroopNotificationRead, feedsId is NULL!");
            return false;
        }
        if (str2.isEmpty()) {
            QLog.e("TroopNotificationHelper", 1, "isTroopNotificationRead, feedsId is empty!");
            return false;
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        List<? extends Entity> query = createEntityManager.query(TroopNotificationCache.class, true, "troopUin=? and read=? and feedsId=?", new String[]{str, "1", str2}, null, null, null, null);
        createEntityManager.close();
        if (query != null && query.size() > 0) {
            z16 = true;
        }
        if (str == null) {
            QLog.e("TroopNotificationHelper", 1, "isTroopNotificationRead, troopCode is NULL!");
        } else if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "isTroopNotificationRead. feedsId = " + str2 + ", troop = " + str);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(RemindGroupBulletinMsg remindGroupBulletinMsg, long j3) {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        String feedId = remindGroupBulletinMsg.getFeedId();
        QLog.d("TroopNotificationHelper", 1, "getTroopNotification troopUin=" + j3 + " feedsId=" + feedId);
        com.tencent.mobileqq.troop.announcement.api.a aVar = (com.tencent.mobileqq.troop.announcement.api.a) qQAppInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName());
        if (aVar.e1(feedId)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationHelper", 2, "notice is loading");
            }
        } else {
            aVar.p2(0, j3, j3, 0L, feedId, 0, (short) 23, false, false, true);
            createEntityManager.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(FirstGroupBulletinInfo firstGroupBulletinInfo) {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        long fromUin = firstGroupBulletinInfo.getFromUin();
        int appid = firstGroupBulletinInfo.getAppid();
        long groupId = firstGroupBulletinInfo.getGroupId();
        long groupCode = firstGroupBulletinInfo.getGroupCode();
        ArrayList<FirstGroupBulletContent> firstContents = firstGroupBulletinInfo.getFirstContents();
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<FirstGroupBulletContent> it = firstContents.iterator();
        while (it.hasNext()) {
            FirstGroupBulletContent next = it.next();
            String feedid = next.getFeedid();
            int grouptime = next.getGrouptime();
            QLog.d("TroopNotificationHelper", 1, "getTroopNotification troopUin=" + groupId + " feedsId=" + feedid);
            com.tencent.mobileqq.troop.announcement.api.a aVar = (com.tencent.mobileqq.troop.announcement.api.a) qQAppInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName());
            if (aVar.e1(feedid)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopNotificationHelper", 2, "notice is loading");
                }
            } else {
                TroopNotificationCache troopNotificationCache = (TroopNotificationCache) DBMethodProxy.find(createEntityManager, TroopNotificationCache.class, "troopUin=? and feedsId=?", new String[]{String.valueOf(groupCode), feedid});
                if (troopNotificationCache != null && troopNotificationCache.time == grouptime) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopNotificationHelper", 2, "notice has exist!");
                    }
                } else {
                    com.tencent.mobileqq.troop.navigatebar.expriment.a.e(String.valueOf(groupCode), feedid, elapsedRealtime);
                    aVar.p2(appid, groupId, groupCode, fromUin, feedid, grouptime, (short) 23, false, false, false);
                    createEntityManager = createEntityManager;
                    elapsedRealtime = elapsedRealtime;
                    groupId = groupId;
                }
            }
        }
        createEntityManager.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(QQAppInterface qQAppInterface, String str) {
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        List<TroopNotificationCache> J = troopManager.J(str);
        if (J != null && QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "readTroopNotification--->troopNotificationCaches size:" + J.size());
        }
        troopManager.p0(str);
        o(qQAppInterface, str);
        p(qQAppInterface, str);
    }

    public static void m(final QQAppInterface qQAppInterface, final String str) {
        if (str == null) {
            QLog.e("TroopNotificationHelper", 1, "readTroopNotification, troopUin is NULL!");
        } else if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "readTroopNotification troop:" + str);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.at
            @Override // java.lang.Runnable
            public final void run() {
                aw.l(QQAppInterface.this, str);
            }
        }, 32, null, true);
    }

    public static void n(QQAppInterface qQAppInterface, String str, List<TroopNotificationCache> list, int i3, int i16, String str2, boolean z16) {
        String str3;
        if (str == null) {
            QLog.e("TroopNotificationHelper", 1, "saveTroopNotificationsAndShowTips, troopUin is NULL!");
        } else if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("saveTroopNotificationsAndShowTips. troop = ");
            sb5.append(str);
            sb5.append(", feedsId = ");
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                str3 = str2;
            }
            sb5.append(str3);
            QLog.d("TroopNotificationHelper", 2, sb5.toString());
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        int i17 = 0;
        boolean z17 = false;
        for (TroopNotificationCache troopNotificationCache : list) {
            if (troopNotificationCache.userUin == qQAppInterface.getLongAccountUin()) {
                troopNotificationCache.read = true;
            } else {
                troopNotificationCache.read = false;
                i17++;
            }
            troopNotificationCache.currentUin = qQAppInterface.getCurrentAccountUin();
            createEntityManager.persist(troopNotificationCache);
            if (troopNotificationCache.serviceID == 27) {
                z17 = true;
            }
        }
        createEntityManager.close();
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "setUnReadFlag = " + i17 + ", isTroopNotification = " + z17);
        }
        if (i17 == 0) {
            return;
        }
        r(qQAppInterface, str2, str, z16 ? 1 : 0);
        q(qQAppInterface, str);
    }

    public static void o(QQAppInterface qQAppInterface, String str) {
        if (str == null) {
            QLog.e("TroopNotificationHelper", 1, "setReadNewAIOTroopNotification, troopCode is NULL!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "setReadNewTroopNotification, troop = " + str);
        }
        f302088a.remove(str);
    }

    public static void p(QQAppInterface qQAppInterface, String str) {
        if (str == null) {
            QLog.e("TroopNotificationHelper", 1, "setReadRepeatTroopNotification, troopUin is NULL!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "setReadRepeatTroopNotification. troop = " + str);
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) qQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationHelper", 2, "setReadRepeatTroopNotification. type: " + findTroopInfo.extDBInfo.troopRepeatType);
            }
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateTroopNotificationData(str, "", 0);
        }
        f302089b.remove(str);
    }

    public static void q(QQAppInterface qQAppInterface, String str) {
        if (str == null) {
            QLog.e("TroopNotificationHelper", 1, "setUnReadAIONewTroopNotification, troopCode is NULL!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "setUnReadAIONewTroopNotification. troop = " + str);
        }
        f302088a.put(str, Boolean.TRUE);
        TroopNewGuidePopWindow.k0("https://gdynamic.qpic.cn/gdynamic/");
    }

    public static void r(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        if (str == null) {
            QLog.e("TroopNotificationHelper", 1, "setUnReadRepeatTroopNotification, feeds_id is NULL!");
            return;
        }
        if (str2 == null) {
            QLog.e("TroopNotificationHelper", 1, "setUnReadRepeatTroopNotification, troopUin is NULL!");
        } else if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "setUnReadRepeatTroopNotification, type = " + i3 + ", troop = " + str2 + ", feedsId = " + str);
        }
        if (((ITroopInfoService) qQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str2) == null) {
            QLog.e("TroopNotificationHelper", 2, "setUnReadRepeatTroopNotification, troopInfo not found!");
            return;
        }
        ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateTroopNotificationData(str2, str, i3);
        as asVar = new as(str, i3);
        f302089b.put(str2, asVar);
        ((com.tencent.mobileqq.troop.announcement.api.a) qQAppInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName())).a(com.tencent.mobileqq.troop.announcement.api.b.f293933h, true, new Object[]{str2, asVar});
    }
}
