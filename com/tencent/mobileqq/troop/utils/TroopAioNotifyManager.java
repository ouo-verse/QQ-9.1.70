package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopAIONotifyItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioNotifyManager {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.utils.TroopAioNotifyManager$2, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f301866d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TroopAIONotifyItem f301867e;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                synchronized (TroopAioNotifyManager.class) {
                    EntityManager createEntityManager = this.f301866d.getEntityManagerFactory().createEntityManager();
                    int delete = createEntityManager.delete(this.f301867e.getTableName(), "id=?", new String[]{this.f301867e.f294764id});
                    createEntityManager.close();
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "setNotifyItemReaded, id=" + this.f301867e.f294764id + ", ret=" + delete);
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "setNotifyItemReaded, exp:" + e16.toString());
                }
            }
        }
    }

    public TroopAioNotifyManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized void a(QQAppInterface qQAppInterface, List<TroopAIONotifyItem> list) {
        synchronized (TroopAioNotifyManager.class) {
            if (list != null) {
                int size = list.size();
                if (size != 0) {
                    try {
                        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                        for (int i3 = 0; i3 < size; i3++) {
                            createEntityManager.remove(list.get(i3));
                        }
                        createEntityManager.close();
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "delLocalNotifyItems, size:" + size);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "delLocalNotifyItems, exp:" + e16.toString());
                        }
                    }
                }
            }
        }
    }

    public static synchronized List<TroopAIONotifyItem> b(QQAppInterface qQAppInterface, String str) {
        synchronized (TroopAioNotifyManager.class) {
            ArrayList arrayList = new ArrayList();
            try {
                EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                int i3 = 0;
                List query = createEntityManager.query(TroopAIONotifyItem.class, false, "troopUin=?", new String[]{str}, null, null, null, null);
                createEntityManager.close();
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getLocalNotifyItems, size=");
                    if (query != null) {
                        i3 = query.size();
                    }
                    sb5.append(i3);
                    QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, sb5.toString());
                }
                if (query != null) {
                    return query;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "getLocalNotifyItems, exp:" + e16.toString());
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized List<TroopAIONotifyItem> c(QQAppInterface qQAppInterface, List<TroopAIONotifyItem> list, List<TroopAIONotifyItem> list2) {
        int i3;
        int i16;
        ArrayList arrayList;
        boolean z16;
        synchronized (TroopAioNotifyManager.class) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i17 = 0;
            boolean z17 = false;
            while (true) {
                i3 = 2;
                i16 = 1;
                if (i17 >= list.size()) {
                    break;
                }
                TroopAIONotifyItem troopAIONotifyItem = list.get(i17);
                if (QLog.isColorLevel()) {
                    QLog.i(".troop.notify_feeds.data.detail", 2, "mergeItemList, fromServer=" + troopAIONotifyItem);
                }
                int i18 = troopAIONotifyItem.type;
                if (i18 == 1) {
                    if (arrayList2.size() == 0) {
                        arrayList2.add(troopAIONotifyItem);
                    }
                    z17 = true;
                } else if (i18 == 2) {
                    arrayList3.add(troopAIONotifyItem);
                }
                i17++;
            }
            long serverTime = NetConnInfoCenter.getServerTime();
            ArrayList arrayList4 = new ArrayList();
            int size = list2.size() - 1;
            while (size >= 0) {
                TroopAIONotifyItem troopAIONotifyItem2 = list2.get(size);
                if (QLog.isColorLevel()) {
                    QLog.i(".troop.notify_feeds.data.detail", i3, "mergeItemList, fromDb=" + troopAIONotifyItem2);
                }
                int i19 = troopAIONotifyItem2.type;
                if (i19 == i16) {
                    if (z17) {
                        list2.remove(size);
                        arrayList4.add(troopAIONotifyItem2);
                        if (QLog.isColorLevel()) {
                            QLog.i(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, i3, "mergeItemList, hasNewAppNotify removeLocalAppItem, id=" + troopAIONotifyItem2.f294764id + ", " + troopAIONotifyItem2.title);
                        }
                    }
                } else if (i19 == i3) {
                    boolean contains = arrayList3.contains(troopAIONotifyItem2);
                    if (troopAIONotifyItem2.expireTime < serverTime) {
                        z16 = i16;
                    } else {
                        z16 = 0;
                    }
                    if (contains || z16 != 0) {
                        list2.remove(size);
                        arrayList4.add(troopAIONotifyItem2);
                        if (QLog.isColorLevel()) {
                            QLog.i(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "mergeItemList, removeLocalPushItem, hasUpdate=" + contains + ", isExpired=" + z16 + ", id=" + troopAIONotifyItem2.f294764id + ", " + troopAIONotifyItem2.title);
                        }
                    }
                }
                size--;
                i3 = 2;
                i16 = 1;
            }
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            for (int i26 = 0; i26 < list2.size(); i26++) {
                TroopAIONotifyItem troopAIONotifyItem3 = list2.get(i26);
                int i27 = troopAIONotifyItem3.type;
                if (i27 == 1) {
                    if (!z17) {
                        if (arrayList5.size() == 0) {
                            arrayList5.add(troopAIONotifyItem3);
                        } else {
                            arrayList4.add(troopAIONotifyItem3);
                            if (QLog.isColorLevel()) {
                                QLog.i(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "mergeItemList, moreThanOne removeLocalAppItem, id=" + troopAIONotifyItem3.f294764id + ", " + troopAIONotifyItem3.title);
                            }
                        }
                    }
                } else if (i27 == 2) {
                    arrayList6.add(troopAIONotifyItem3);
                }
            }
            a(qQAppInterface, arrayList4);
            arrayList = new ArrayList();
            arrayList.addAll(arrayList2);
            arrayList.addAll(arrayList3);
            e(qQAppInterface, arrayList);
            arrayList.clear();
            if (z17) {
                arrayList.addAll(arrayList2);
                arrayList.addAll(arrayList3);
                arrayList.addAll(arrayList6);
            } else {
                arrayList.addAll(arrayList5);
                arrayList.addAll(arrayList3);
                arrayList.addAll(arrayList6);
            }
        }
        return arrayList;
    }

    public static void d(QQAppInterface qQAppInterface, String str) {
        boolean z16;
        nt2.a aVar = (nt2.a) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_AIO_NOTIFY_HANDLER);
        Integer G = ChatActivityUtils.G(str, qQAppInterface.getCurrentAccountUin());
        if (G != null && G.intValue() == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "reqNotifyItems, troopUin=" + str + ", hasNewNotify=" + z16);
        }
        if (z16) {
            aVar.s1(Long.valueOf(str).longValue());
            ((qt2.a) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).v2(str, 1102858908);
            ChatActivityUtils.V(qQAppInterface, str, 0);
            return;
        }
        ThreadManagerV2.post(new Runnable(str, aVar) { // from class: com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f301864e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ nt2.a f301865f;

            {
                this.f301864e = str;
                this.f301865f = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, str, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f301865f.b(com.tencent.mobileqq.troop.observer.d.f298010e, true, new Object[]{this.f301864e, TroopAioNotifyManager.c(QQAppInterface.this, new ArrayList(), TroopAioNotifyManager.b(QQAppInterface.this, this.f301864e))});
                }
            }
        }, 8, null, true);
    }

    public static synchronized void e(QQAppInterface qQAppInterface, List<TroopAIONotifyItem> list) {
        synchronized (TroopAioNotifyManager.class) {
            if (list != null) {
                int size = list.size();
                if (size != 0) {
                    try {
                        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                        for (int i3 = 0; i3 < size; i3++) {
                            TroopAIONotifyItem troopAIONotifyItem = list.get(i3);
                            if (troopAIONotifyItem.getStatus() == 1000) {
                                createEntityManager.persistOrReplace(troopAIONotifyItem);
                            } else {
                                createEntityManager.update(troopAIONotifyItem);
                            }
                        }
                        createEntityManager.close();
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "saveNotifyItems, size=" + size);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "saveNotifyItems, exp:" + e16.toString());
                        }
                    }
                }
            }
        }
    }
}
