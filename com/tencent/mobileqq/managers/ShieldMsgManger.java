package com.tencent.mobileqq.managers;

import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ShieldMsgManger implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQConcurrentHashMap<String, ShieldListInfo> f243673d;

    /* renamed from: e, reason: collision with root package name */
    private Object f243674e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f243675f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.managers.ShieldMsgManger$2, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f243676d;
        final /* synthetic */ ShieldMsgManger this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.i(this.f243676d);
            }
        }
    }

    public ShieldMsgManger(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f243674e = new Object();
        this.f243675f = qQAppInterface;
        if (qQAppInterface != null) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.managers.ShieldMsgManger.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShieldMsgManger.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ShieldMsgManger.this.f();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 2, null, false);
            return;
        }
        throw new IllegalArgumentException("ShieldMsgManger this.app = null");
    }

    private String b(String str) {
        String trim = str.trim();
        if (!trim.startsWith(Marker.ANY_NON_NULL_MARKER) && trim.length() == 11) {
            return "+86" + str;
        }
        return trim;
    }

    private BaseTransaction d(Entity entity) {
        if (entity.getStatus() == 1000) {
            return new PersistOrReplaceTransaction(entity);
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return null;
        }
        return new UpdateTransaction(entity);
    }

    private ShieldListInfo e(int i3, String str) {
        synchronized (this.f243674e) {
            if (this.f243673d == null) {
                f();
            }
            if (this.f243673d != null && str != null && str.length() > 0) {
                if (i3 == 2) {
                    str = b(str);
                }
                return this.f243673d.get(str);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int size;
        String str;
        synchronized (this.f243674e) {
            EntityManager createEntityManager = this.f243675f.getEntityManagerFactory().createEntityManager();
            try {
                try {
                    QQConcurrentHashMap<String, ShieldListInfo> qQConcurrentHashMap = new QQConcurrentHashMap<>(Business.Conversation, "ShieldListInfo");
                    List<? extends Entity> query = createEntityManager.query(ShieldListInfo.class);
                    if (query == null) {
                        size = 0;
                    } else {
                        size = query.size();
                    }
                    for (int i3 = 0; i3 < size; i3++) {
                        ShieldListInfo shieldListInfo = (ShieldListInfo) query.get(i3);
                        if (shieldListInfo != null && (str = shieldListInfo.uin) != null) {
                            qQConcurrentHashMap.put(str, shieldListInfo);
                        }
                    }
                    this.f243673d = qQConcurrentHashMap;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ShieldMsgManger", 2, e16.toString());
                    }
                }
            } finally {
                createEntityManager.close();
            }
        }
    }

    private boolean g(int i3, String str) {
        ShieldListInfo e16 = e(i3, str);
        if (e16 != null) {
            return e16.isShieldMsg();
        }
        return false;
    }

    public boolean h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        c();
        boolean g16 = g(1, str);
        if (QLog.isColorLevel()) {
            QLog.d("ShieldMsgManger", 2, "isUinInShieldList:" + str + ",result:" + g16);
        }
        return g16;
    }

    public boolean i(List<ShieldListInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) list)).booleanValue();
        }
        if (list == null || list.size() <= 0) {
            return true;
        }
        synchronized (this.f243674e) {
            EntityManager createEntityManager = this.f243675f.getEntityManagerFactory().createEntityManager();
            ArrayList arrayList = new ArrayList();
            if (this.f243673d == null) {
                f();
            }
            int size = list.size();
            BaseTransaction baseTransaction = null;
            for (int i3 = 0; i3 < size; i3++) {
                ShieldListInfo shieldListInfo = list.get(i3);
                ShieldListInfo shieldListInfo2 = this.f243673d.get(shieldListInfo.uin);
                if (shieldListInfo.flags != 0 || shieldListInfo2 != null) {
                    if (shieldListInfo2 != null && (shieldListInfo2.getStatus() == 1001 || shieldListInfo2.getStatus() == 1002)) {
                        int i16 = shieldListInfo.flags;
                        if (i16 != shieldListInfo2.flags) {
                            shieldListInfo2.flags = i16;
                            shieldListInfo2.source_id = shieldListInfo.source_id;
                            shieldListInfo2.source_sub_id = shieldListInfo.source_sub_id;
                            baseTransaction = d(shieldListInfo2);
                        } else if (i16 == 1) {
                            int i17 = shieldListInfo2.source_id;
                            int i18 = shieldListInfo.source_id;
                            if (i17 != i18) {
                                shieldListInfo2.flags = i16;
                                shieldListInfo2.source_id = i18;
                                shieldListInfo2.source_sub_id = shieldListInfo.source_sub_id;
                                baseTransaction = d(shieldListInfo2);
                            }
                        }
                    } else {
                        baseTransaction = d(shieldListInfo);
                        this.f243673d.put(shieldListInfo.uin, shieldListInfo);
                    }
                    if (baseTransaction != null) {
                        arrayList.add(baseTransaction);
                        baseTransaction = null;
                    }
                }
            }
            createEntityManager.doMultiDBOperateByTransaction(arrayList);
        }
        c();
        return true;
    }

    public boolean j(ConcurrentHashMap<String, ShieldListInfo> concurrentHashMap) {
        boolean i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) concurrentHashMap)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShieldMsgManger", 2, "<---saveShieldListTotal : begin....");
        }
        synchronized (this.f243674e) {
            SQLiteDatabase writableDatabase = this.f243675f.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.execSQL("delete from " + new ShieldListInfo().getTableName());
            }
            QQConcurrentHashMap<String, ShieldListInfo> qQConcurrentHashMap = this.f243673d;
            if (qQConcurrentHashMap != null && qQConcurrentHashMap.size() > 0) {
                this.f243673d.clear();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(concurrentHashMap.get(it.next()));
            }
            i3 = i(arrayList);
        }
        return i3;
    }

    public void k(int i3, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) list);
        } else {
            l(i3, list, 0);
        }
    }

    public void l(int i3, List<Long> list, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), list, Integer.valueOf(i16));
            return;
        }
        ShieldListHandler shieldListHandler = (ShieldListHandler) this.f243675f.getBusinessHandler(BusinessHandlerFactory.SHIELD_LIST_HANDLER);
        int size = list.size();
        long[] jArr = new long[size];
        for (int i17 = 0; i17 < size; i17++) {
            jArr[i17] = list.get(i17).longValue();
        }
        shieldListHandler.U2(i3, jArr, i16);
    }

    public void m(int i3, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) list);
        } else {
            n(i3, list, 0);
        }
    }

    public void n(int i3, List<Long> list, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), list, Integer.valueOf(i16));
            return;
        }
        ShieldListHandler shieldListHandler = (ShieldListHandler) this.f243675f.getBusinessHandler(BusinessHandlerFactory.SHIELD_LIST_HANDLER);
        int size = list.size();
        long[] jArr = new long[size];
        for (int i17 = 0; i17 < size; i17++) {
            jArr[i17] = list.get(i17).longValue();
        }
        shieldListHandler.W2(i3, jArr, i16);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    private void c() {
    }
}
