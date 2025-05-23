package com.tencent.mobileqq.app.proxy;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.UpgradeUtil;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.sqtable.QProxyManagerTableInterceptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import cooperation.qlink.ReliableReportProxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.inject.MqqInjectorManager;

/* loaded from: classes11.dex */
public class QProxyManager extends BaseProxyManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Q.msg.MsgProxy";

    @ConfigInject(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 2)
    public static ArrayList<Class<? extends a>> sInterceptClassList;

    @ConfigInject(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 2)
    public static ArrayList<Class<? extends BaseProxy>> sLazyProxyClassList;

    @ConfigInject(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 2)
    public static ArrayList<Class<? extends BaseProxy>> sLazyProxyNewClassList;

    @ConfigInject(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 2)
    public static ArrayList<Class<? extends IProxyService>> sProxyService;
    Set<BaseProxy> lazyProxySet;
    SparseArray<BaseProxy> mProxyArray;
    private IProxyService mProxyService;
    private a proxyManagerIntercept;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41285);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        ArrayList<Class<? extends IProxyService>> arrayList = new ArrayList<>();
        sProxyService = arrayList;
        arrayList.add(d.class);
        ArrayList<Class<? extends BaseProxy>> arrayList2 = new ArrayList<>();
        sLazyProxyClassList = arrayList2;
        arrayList2.add(QCallProxy.class);
        sLazyProxyClassList.add(ConfessProxy.class);
        ArrayList<Class<? extends BaseProxy>> arrayList3 = new ArrayList<>();
        sLazyProxyNewClassList = arrayList3;
        arrayList3.add(DataLineMsgIpadProxy.class);
        sLazyProxyNewClassList.add(DataLineMsgPcProxy.class);
        sLazyProxyNewClassList.add(FileManagerProxy.class);
        sLazyProxyNewClassList.add(MultiMsgProxy.class);
        sLazyProxyNewClassList.add(QCallProxy.class);
        sLazyProxyNewClassList.add(ConfessProxy.class);
        sLazyProxyNewClassList.add(ReliableReportProxy.class);
        ArrayList<Class<? extends a>> arrayList4 = new ArrayList<>();
        sInterceptClassList = arrayList4;
        arrayList4.add(QProxyManagerTableInterceptor.class);
    }

    @Deprecated
    public QProxyManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.lazyProxySet = new HashSet();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    private long doQueueAction(EntityManager entityManager, boolean z16, boolean z17, long j3, long j16, MsgQueueItem msgQueueItem, String str, ProxyListener proxyListener) {
        switch (msgQueueItem.action) {
            case 0:
                return doMessageActionInsert(entityManager, z16, z17, j3, msgQueueItem, str, proxyListener);
            case 1:
                return doMessageActionUpdate(entityManager, z16, z17, j3, j16, msgQueueItem, str, proxyListener);
            case 2:
                return doMessageActionDel(entityManager, z16, z17, j3, msgQueueItem, str, proxyListener);
            case 3:
                entityManager.persistOrReplace(msgQueueItem.item);
                if (proxyListener != null) {
                    proxyListener.onInsertFinish(str);
                }
                return j16;
            case 4:
                entityManager.update(msgQueueItem.item);
                if (proxyListener != null) {
                    proxyListener.onUpdateFinish(str, 1);
                }
                return j16;
            case 5:
                entityManager.remove(msgQueueItem.item);
                if (proxyListener != null) {
                    proxyListener.onDeleteFinish(str, 1);
                }
                return j16;
            case 6:
                int delete = getDatabase().delete(str, msgQueueItem.whereClause, msgQueueItem.whereArgs);
                if (proxyListener != null) {
                    proxyListener.onDeleteFinish(str, delete);
                }
                return j16;
            default:
                return j16;
        }
    }

    private void injectData(AppRuntime appRuntime) {
        try {
            IProxyService newInstance = sProxyService.get(0).newInstance();
            this.mProxyService = newInstance;
            this.mProxyArray = newInstance.getBusinessProxy(appRuntime, this);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, th5, new Object[0]);
        }
    }

    protected long beforeQueueActionInTransSaveToDatabase(long j3, long j16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), Boolean.valueOf(z17))).longValue();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beforeTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.proxy.BaseProxyManager
    public final void dealAddQueue(MsgQueueItem msgQueueItem, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgQueueItem, (Object) str);
            return;
        }
        a aVar = this.proxyManagerIntercept;
        if (aVar != null && aVar.a(str)) {
            return;
        }
        super.dealAddQueue(msgQueueItem, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long doMessageActionDel(EntityManager entityManager, boolean z16, boolean z17, long j3, MsgQueueItem msgQueueItem, String str, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, this, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), msgQueueItem, str, proxyListener)).longValue();
        }
        long nanoTime = System.nanoTime();
        int delete = getDatabase().delete(str, msgQueueItem.whereClause, msgQueueItem.whereArgs);
        long nanoTime2 = (System.nanoTime() - nanoTime) / 1000;
        if (proxyListener != null) {
            proxyListener.onDeleteFinish(str, delete);
        }
        return nanoTime2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long doMessageActionInsert(EntityManager entityManager, boolean z16, boolean z17, long j3, MsgQueueItem msgQueueItem, String str, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, this, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), msgQueueItem, str, proxyListener)).longValue();
        }
        if (com.tencent.mobileqq.imcore.proxy.msg.b.b(msgQueueItem.item)) {
            return 0L;
        }
        long nanoTime = System.nanoTime();
        entityManager.persistOrReplace(msgQueueItem.item);
        long nanoTime2 = (System.nanoTime() - nanoTime) / 1000;
        if (proxyListener != null) {
            proxyListener.onInsertFinish(str);
        }
        return nanoTime2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long doMessageActionUpdate(EntityManager entityManager, boolean z16, boolean z17, long j3, long j16, MsgQueueItem msgQueueItem, String str, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, this, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Long.valueOf(j16), msgQueueItem, str, proxyListener)).longValue();
        }
        if (UpgradeUtil.isDeprecatedTable(str)) {
            return 0L;
        }
        long nanoTime = System.nanoTime();
        SQLiteDatabase database = getDatabase();
        if (database != null) {
            int update = database.update(str, msgQueueItem.value, msgQueueItem.whereClause, msgQueueItem.whereArgs);
            j16 = (System.nanoTime() - nanoTime) / 1000;
            if (proxyListener != null) {
                proxyListener.onUpdateFinish(str, update);
            }
        }
        return j16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void endTrans(EntityTransaction entityTransaction, boolean z16, boolean z17, long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, entityTransaction, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (entityTransaction != null) {
            entityTransaction.end();
        }
    }

    Class[] getLazyClassArray() {
        ArrayList<Class<? extends BaseProxy>> arrayList;
        if (MqqInjectorManager.instance().getSwitch(MobileQQ.sMobileQQ, "KEY_DELAY_LOAD_PROXY", true, false)) {
            arrayList = sLazyProxyNewClassList;
        } else {
            arrayList = sLazyProxyClassList;
        }
        Class[] clsArr = new Class[arrayList.size()];
        arrayList.toArray(clsArr);
        return clsArr;
    }

    public <T extends BaseProxy> T getProxy(int i3) {
        SparseArray<BaseProxy> sparseArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 >= 0 && (sparseArray = this.mProxyArray) != null && sparseArray.size() > 0) {
            try {
                return (T) this.mProxyArray.get(i3);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "Wrong type cast, confirm the return proxy type", e16);
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxyManager
    protected synchronized void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.mProxyArray.size() && !this.isDestroyed; i3++) {
            BaseProxy valueAt = this.mProxyArray.valueAt(i3);
            if (valueAt != null) {
                if (isLazyProxy(valueAt)) {
                    this.lazyProxySet.add(valueAt);
                } else {
                    TraceUtils.traceBegin("i." + valueAt);
                    long currentTimeMillis = System.currentTimeMillis();
                    valueAt.init();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "ProxyInit , proxy=" + valueAt.getClass().getName() + "cost=" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    TraceUtils.traceEnd();
                }
            }
        }
    }

    public synchronized void init_lazy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!this.isDestroyed && !this.lazyProxySet.isEmpty()) {
            for (BaseProxy baseProxy : this.lazyProxySet) {
                TraceUtils.traceBegin("i." + baseProxy);
                long currentTimeMillis = System.currentTimeMillis();
                baseProxy.init();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "ProxyInit , proxy=" + baseProxy.getClass().getName() + "cost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                TraceUtils.traceEnd();
            }
            this.lazyProxySet.clear();
        }
    }

    synchronized boolean isLazyProxy(BaseProxy baseProxy) {
        Class<?>[] lazyClassArray = getLazyClassArray();
        if (lazyClassArray != null && lazyClassArray.length > 0) {
            for (Class<?> cls : lazyClassArray) {
                if (baseProxy.getClass() == cls) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxyManager, mqq.manager.Manager
    public synchronized void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.isDestroyed = true;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.proxy.QProxyManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QProxyManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QProxyManager.this.transSaveToDatabase();
                }
            }
        }, 8, null, false);
        if (this.msgQueue != null) {
            synchronized (this.msgQueueLock) {
                if (this.msgQueue != null) {
                    this.msgQueueLock.notify();
                }
            }
        }
        for (int i3 = 0; i3 < this.mProxyArray.size(); i3++) {
            this.mProxyArray.valueAt(i3).destroy();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x01a3 A[Catch: all -> 0x01c4, TRY_LEAVE, TryCatch #2 {all -> 0x01c4, blocks: (B:34:0x0195, B:36:0x01a3), top: B:33:0x0195 }] */
    @Override // com.tencent.mobileqq.app.proxy.BaseProxyManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void transSaveToDatabaseIndeed(EntityManager entityManager, List<MsgQueueItem> list) {
        boolean z16;
        long j3;
        boolean z17;
        int i3;
        int i16;
        boolean z18;
        QProxyManager qProxyManager;
        boolean z19;
        boolean z26;
        int i17;
        String str;
        ProxyListener proxyListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) entityManager, (Object) list);
            return;
        }
        if (entityManager == null) {
            QLog.e(TAG, 1, "transSaveToDatabaseIndeed em == null");
            return;
        }
        if (list.isEmpty()) {
            return;
        }
        beforeTrans();
        boolean isSQLiteReportVersion = this.mProxyService.isSQLiteReportVersion();
        int i18 = 0;
        if (isSQLiteReportVersion && this.mProxyService.getSQLiteSwitchBySample()) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i19 = 2;
        EntityTransaction entityTransaction = null;
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "transSaveToDatabase: isMainThread = " + z19);
                    }
                } catch (Exception e16) {
                    e = e16;
                    j3 = -1;
                    i3 = 0;
                    z17 = z19;
                    i16 = 2;
                    try {
                        e.printStackTrace();
                        notifyEvent(1001);
                        if (QLog.isColorLevel()) {
                        }
                        qProxyManager = this;
                        z18 = z16;
                        qProxyManager.endTrans(entityTransaction, z18, z17, j3, i3, i18);
                    } catch (Throwable th5) {
                        th = th5;
                        endTrans(entityTransaction, z16, z17, j3, i3, i18);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    j3 = -1;
                    i3 = 0;
                    z17 = z19;
                    endTrans(entityTransaction, z16, z17, j3, i3, i18);
                    throw th;
                }
            }
            try {
                EntityTransaction transaction = entityManager.getTransaction();
                try {
                    long nanoTime = System.nanoTime();
                    try {
                        transaction.begin();
                        long beforeQueueActionInTransSaveToDatabase = beforeQueueActionInTransSaveToDatabase(nanoTime, -1L, isSQLiteReportVersion, z16);
                        i3 = 0;
                        i17 = 0;
                        long j16 = beforeQueueActionInTransSaveToDatabase;
                        for (MsgQueueItem msgQueueItem : list) {
                            try {
                                int i26 = i3 + 1;
                                try {
                                    str = msgQueueItem.tableName;
                                    proxyListener = msgQueueItem.listener;
                                    if (QLog.isColorLevel()) {
                                        try {
                                            if (this.mProxyService.isMessageRecord(msgQueueItem.item)) {
                                                i17++;
                                            }
                                        } catch (Exception e17) {
                                            e = e17;
                                            z17 = z19;
                                            i16 = i19;
                                            entityTransaction = transaction;
                                            j3 = nanoTime;
                                            i18 = i17;
                                            i3 = i26;
                                            e.printStackTrace();
                                            notifyEvent(1001);
                                            if (QLog.isColorLevel()) {
                                            }
                                            qProxyManager = this;
                                            z18 = z16;
                                            qProxyManager.endTrans(entityTransaction, z18, z17, j3, i3, i18);
                                        } catch (Throwable th7) {
                                            th = th7;
                                            z17 = z19;
                                            entityTransaction = transaction;
                                            j3 = nanoTime;
                                            i18 = i17;
                                            i3 = i26;
                                            endTrans(entityTransaction, z16, z17, j3, i3, i18);
                                            throw th;
                                        }
                                    }
                                    z26 = z19;
                                    i16 = i19;
                                } catch (Exception e18) {
                                    e = e18;
                                    z26 = z19;
                                    i16 = i19;
                                } catch (Throwable th8) {
                                    th = th8;
                                    z26 = z19;
                                }
                                try {
                                    j16 = doQueueAction(entityManager, isSQLiteReportVersion, z19, -1L, j16, msgQueueItem, str, proxyListener);
                                    i19 = i16;
                                    i3 = i26;
                                    z19 = z26;
                                } catch (Exception e19) {
                                    e = e19;
                                    entityTransaction = transaction;
                                    j3 = nanoTime;
                                    i18 = i17;
                                    i3 = i26;
                                    z17 = z26;
                                    e.printStackTrace();
                                    notifyEvent(1001);
                                    if (QLog.isColorLevel()) {
                                        QLog.i(TAG, i16, "writeRunable write exception: size=" + list.size(), e);
                                    }
                                    qProxyManager = this;
                                    z18 = z16;
                                    qProxyManager.endTrans(entityTransaction, z18, z17, j3, i3, i18);
                                } catch (Throwable th9) {
                                    th = th9;
                                    entityTransaction = transaction;
                                    j3 = nanoTime;
                                    i18 = i17;
                                    i3 = i26;
                                    z17 = z26;
                                    endTrans(entityTransaction, z16, z17, j3, i3, i18);
                                    throw th;
                                }
                            } catch (Exception e26) {
                                e = e26;
                                z26 = z19;
                                i16 = i19;
                            } catch (Throwable th10) {
                                th = th10;
                                z26 = z19;
                            }
                        }
                        z26 = z19;
                        i16 = i19;
                    } catch (Exception e27) {
                        e = e27;
                        z26 = z19;
                        i16 = 2;
                        i3 = 0;
                        entityTransaction = transaction;
                        j3 = nanoTime;
                    } catch (Throwable th11) {
                        th = th11;
                        z26 = z19;
                        i3 = 0;
                        entityTransaction = transaction;
                        j3 = nanoTime;
                    }
                    try {
                        transaction.commit();
                        notifyEvent(1000);
                        qProxyManager = this;
                        entityTransaction = transaction;
                        z18 = z16;
                        z17 = z26;
                        j3 = nanoTime;
                        i18 = i17;
                    } catch (Exception e28) {
                        e = e28;
                        entityTransaction = transaction;
                        j3 = nanoTime;
                        i18 = i17;
                        z17 = z26;
                        e.printStackTrace();
                        notifyEvent(1001);
                        if (QLog.isColorLevel()) {
                        }
                        qProxyManager = this;
                        z18 = z16;
                        qProxyManager.endTrans(entityTransaction, z18, z17, j3, i3, i18);
                    } catch (Throwable th12) {
                        th = th12;
                        entityTransaction = transaction;
                        j3 = nanoTime;
                        i18 = i17;
                        z17 = z26;
                        endTrans(entityTransaction, z16, z17, j3, i3, i18);
                        throw th;
                    }
                } catch (Exception e29) {
                    e = e29;
                    z26 = z19;
                    i16 = 2;
                    j3 = -1;
                    i3 = 0;
                    entityTransaction = transaction;
                } catch (Throwable th13) {
                    th = th13;
                    z26 = z19;
                    j3 = -1;
                    i3 = 0;
                    entityTransaction = transaction;
                }
            } catch (Exception e36) {
                e = e36;
                z26 = z19;
                i16 = 2;
                j3 = -1;
                i3 = 0;
            } catch (Throwable th14) {
                th = th14;
                z26 = z19;
                j3 = -1;
                i3 = 0;
            }
        } catch (Exception e37) {
            e = e37;
            i16 = 2;
            j3 = -1;
            z17 = false;
            i3 = 0;
        } catch (Throwable th15) {
            th = th15;
            j3 = -1;
            z17 = false;
            i3 = 0;
        }
        qProxyManager.endTrans(entityTransaction, z18, z17, j3, i3, i18);
    }

    public QProxyManager(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.lazyProxySet = new HashSet();
        injectData(appRuntime);
        try {
            this.proxyManagerIntercept = sInterceptClassList.get(0).newInstance();
        } catch (Throwable th5) {
            QLog.d(TAG, 1, th5, new Object[0]);
        }
    }
}
