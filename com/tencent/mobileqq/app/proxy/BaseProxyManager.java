package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.imcore.proxy.db.ThreadRegulatorProxy;
import com.tencent.mobileqq.imcore.proxy.msg.MsgProxyUtilsProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* loaded from: classes11.dex */
public class BaseProxyManager implements Manager {
    static IPatchRedirector $redirector_ = null;
    private static final int STATE_NOT_SAVE = -1;
    private static final int STATE_SAVE_DELAY = 0;
    private static final int STATE_SAVE_IMMEDIATELY = 1;
    private static final String TAG = "Q.msg.MsgProxy";
    private static final int WRITE_THREAD_TIME_INTERVAL_MAX = 10000;
    private static final int WRITE_THREAD_TIME_INTERVAL_MIN = 2000;
    private static int checkAppMemoryCount;
    private static int mWriteThreadInterval;

    /* renamed from: db, reason: collision with root package name */
    protected SQLiteDatabase f196490db;
    private DBDelayManager dbDelayManager;
    volatile boolean isDestroyed;
    boolean isSaveDBAtOnceFlag;
    private ArrayList<ProxyObserver> listenerArray;
    protected Vector<MsgQueueItem> msgQueue;
    protected final Object msgQueueLock;
    public Object transSaveLock;
    private Thread writeThread;
    private long writeThreadStartTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41222);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            mWriteThreadInterval = 10000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public BaseProxyManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.msgQueueLock = new Object();
        this.isSaveDBAtOnceFlag = false;
        this.transSaveLock = new Object();
        this.listenerArray = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAppMemory() {
        int i3 = checkAppMemoryCount + 1;
        checkAppMemoryCount = i3;
        if (i3 % 6 == 5) {
            double maxMemory = ((float) ((Runtime.getRuntime().totalMemory() / 1024) / 1024)) / ((float) ((Runtime.getRuntime().maxMemory() / 1024) / 1024));
            if (maxMemory > 0.8d) {
                int i16 = mWriteThreadInterval / 2;
                mWriteThreadInterval = i16;
                mWriteThreadInterval = Math.max(i16, 2000);
            } else if (maxMemory < 0.5d) {
                int i17 = mWriteThreadInterval + 2000;
                mWriteThreadInterval = i17;
                mWriteThreadInterval = Math.min(i17, 10000);
            }
        }
    }

    public void addMsgQueue(String str, int i3, String str2, String str3, String[] strArr, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            addMsgQueue(str, i3, str2, null, str3, strArr, i16, proxyListener);
        } else {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), str2, str3, strArr, Integer.valueOf(i16), proxyListener);
        }
    }

    public void addMsgQueueAndNotify(String str, int i3, String str2, Entity entity, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), str2, entity, Integer.valueOf(i16), proxyListener);
        } else {
            doAddMsgQueue(str, i3, str2, entity, i16, proxyListener);
            saveNotify();
        }
    }

    public void addMsgQueueDonotNotify(String str, int i3, String str2, Entity entity, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), str2, entity, Integer.valueOf(i16), proxyListener);
            return;
        }
        doAddMsgQueue(str, i3, str2, entity, i16, proxyListener);
        if (this.isDestroyed) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addMsgQueue after destroy");
            }
            saveNotify();
        }
    }

    public void addProxyObserver(ProxyObserver proxyObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) proxyObserver);
        } else if (!this.listenerArray.contains(proxyObserver)) {
            this.listenerArray.add(proxyObserver);
        }
    }

    public void clearMsgQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        synchronized (this.msgQueueLock) {
            this.msgQueue.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dealAddQueue(MsgQueueItem msgQueueItem, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgQueueItem, (Object) str);
        } else {
            this.msgQueue.add(msgQueueItem);
        }
    }

    public void doAddMsgQueue(String str, int i3, String str2, Entity entity, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), str2, entity, Integer.valueOf(i16), proxyListener);
            return;
        }
        MsgQueueItem msgQueueItem = new MsgQueueItem(str, i3, str2, entity, i16, proxyListener);
        synchronized (this.msgQueueLock) {
            try {
                dealAddQueue(msgQueueItem, str2);
            } catch (OutOfMemoryError unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "addMsgQueue oom, " + str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doAfterTransSaveToDatabase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        }
    }

    protected void doOnCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.writeThread = new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.app.proxy.BaseProxyManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseProxyManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BaseProxyManager.this.writeThreadStartTime = System.currentTimeMillis();
                    while (!BaseProxyManager.this.isDestroyed) {
                        synchronized (BaseProxyManager.this.msgQueueLock) {
                            try {
                                BaseProxyManager.this.checkAppMemory();
                                BaseProxyManager.this.msgQueueLock.wait(BaseProxyManager.mWriteThreadInterval);
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.w(BaseProxyManager.TAG, 2, "writeRunable Exception:", e16);
                                }
                            }
                        }
                        ThreadRegulatorProxy.checkInNextBusiness();
                        if (!BaseProxyManager.this.msgQueue.isEmpty() || BaseProxyManager.this.dbDelayManager.getQueue().size() > 0) {
                            if (BaseProxyManager.this.isSaveDBAtOnce()) {
                                BaseProxyManager.this.transSaveToDatabase();
                                BaseProxyManager.this.dbDelayManager.transSaveToDatabase();
                            }
                        }
                    }
                }
            });
            this.isDestroyed = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteDatabase getDatabase() {
        if (this.f196490db == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return null;
            }
            this.f196490db = peekAppRuntime.getWritableDatabase();
        }
        return this.f196490db;
    }

    public Object getMsgQueueLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.msgQueueLock;
    }

    public Vector<MsgQueueItem> getQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Vector) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.msgQueue;
    }

    protected int getSaveInDBState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return 1;
    }

    protected synchronized void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    boolean isSaveDBAtOnce() {
        if (!this.isSaveDBAtOnceFlag) {
            int saveInDBState = getSaveInDBState();
            if (saveInDBState == 0) {
                if (System.currentTimeMillis() - this.writeThreadStartTime > 30000) {
                    this.isSaveDBAtOnceFlag = true;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "isSaveDBAtOnce timeout30s isSaveDBAtOnceFlag:" + this.isSaveDBAtOnceFlag);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            if (saveInDBState == 1) {
                this.isSaveDBAtOnceFlag = true;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "isSaveDBAtOnce unActionLoginB isSaveDBAtOnceFlag:" + this.isSaveDBAtOnceFlag);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            if (this.listenerArray.isEmpty()) {
                return;
            }
            Iterator<ProxyObserver> it = this.listenerArray.iterator();
            while (it.hasNext()) {
                it.next().notifyEvent(i3);
            }
        }
    }

    public void notifyRefreshTroopMember() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            notifyEvent(2000);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.isDestroyed = true;
        if (this.writeThread != null) {
            try {
                synchronized (this.msgQueueLock) {
                    this.msgQueueLock.notifyAll();
                }
            } catch (Throwable th5) {
                QLog.d(TAG, 1, "onDestroy, e=", th5);
            }
        }
    }

    public void removeProxyObserver(ProxyObserver proxyObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) proxyObserver);
        } else if (this.listenerArray.contains(proxyObserver)) {
            this.listenerArray.remove(proxyObserver);
        }
    }

    public void saveNotify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (this.isDestroyed) {
            transSaveToDatabase();
            this.dbDelayManager.transSaveToDatabase();
        } else {
            synchronized (this.msgQueueLock) {
                this.msgQueueLock.notify();
            }
        }
    }

    public void start() {
        Thread thread;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!this.isDestroyed && (thread = this.writeThread) != null && thread.getState() == Thread.State.NEW) {
            init();
            this.writeThread.setName("QQ_DB");
            this.writeThread.start();
        }
    }

    public void transSaveToDatabase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory(peekAppRuntime.getAccount()).createEntityManager();
        transSaveToDatabase(createEntityManager);
        createEntityManager.close();
    }

    protected void transSaveToDatabaseIndeed(EntityManager entityManager, List<MsgQueueItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) entityManager, (Object) list);
            return;
        }
        if (list.isEmpty()) {
            return;
        }
        EntityTransaction entityTransaction = null;
        try {
            try {
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                for (MsgQueueItem msgQueueItem : list) {
                    String str = msgQueueItem.tableName;
                    ProxyListener proxyListener = msgQueueItem.listener;
                    switch (msgQueueItem.action) {
                        case 0:
                            entityManager.persistOrReplace(msgQueueItem.item);
                            if (proxyListener != null) {
                                proxyListener.onInsertFinish(str);
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            SQLiteDatabase database = getDatabase();
                            if (database != null) {
                                int update = database.update(str, msgQueueItem.value, msgQueueItem.whereClause, msgQueueItem.whereArgs);
                                if (proxyListener != null) {
                                    proxyListener.onUpdateFinish(str, update);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        case 2:
                            int delete = getDatabase().delete(str, msgQueueItem.whereClause, msgQueueItem.whereArgs);
                            if (proxyListener != null) {
                                proxyListener.onDeleteFinish(str, delete);
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            entityManager.persistOrReplace(msgQueueItem.item);
                            if (proxyListener != null) {
                                proxyListener.onInsertFinish(str);
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            entityManager.update(msgQueueItem.item);
                            if (proxyListener != null) {
                                proxyListener.onUpdateFinish(str, 1);
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            entityManager.remove(msgQueueItem.item);
                            if (proxyListener != null) {
                                proxyListener.onDeleteFinish(str, 1);
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            int delete2 = getDatabase().delete(str, msgQueueItem.whereClause, msgQueueItem.whereArgs);
                            if (proxyListener != null) {
                                proxyListener.onDeleteFinish(str, delete2);
                                break;
                            } else {
                                break;
                            }
                    }
                }
                entityTransaction.commit();
                notifyEvent(1000);
            } catch (Exception e16) {
                e16.printStackTrace();
                notifyEvent(1001);
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "writeRunable write exception: " + list.size(), e16);
                }
                if (entityTransaction == null) {
                    return;
                }
            }
            entityTransaction.end();
        } catch (Throwable th5) {
            if (entityTransaction != null) {
                entityTransaction.end();
            }
            throw th5;
        }
    }

    public void addMsgQueue(String str, int i3, String str2, ContentValues contentValues, String str3, String[] strArr, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), str2, contentValues, str3, strArr, Integer.valueOf(i16), proxyListener);
            return;
        }
        MsgQueueItem msgQueueItem = new MsgQueueItem(str, i3, str2, contentValues, str3, strArr, i16, proxyListener);
        synchronized (this.msgQueueLock) {
            try {
                dealAddQueue(msgQueueItem, str2);
            } catch (OutOfMemoryError unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "addMsgQueue oom, " + str2);
                }
            }
        }
        if (this.isDestroyed) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addMsgQueue after destroy");
            }
            saveNotify();
        } else {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null || !MobileQQ.sMobileQQ.peekAppRuntime().isBackgroundPause) {
                return;
            }
            saveNotify();
        }
    }

    public void transSaveToDatabase(EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) entityManager);
            return;
        }
        synchronized (this.transSaveLock) {
            synchronized (this.msgQueueLock) {
                if (this.msgQueue.isEmpty()) {
                    return;
                }
                Vector<MsgQueueItem> vector = this.msgQueue;
                this.msgQueue = new Vector<>();
                transSaveToDatabaseIndeed(entityManager, vector);
                doAfterTransSaveToDatabase();
            }
        }
    }

    public BaseProxyManager(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.msgQueueLock = new Object();
        this.isSaveDBAtOnceFlag = false;
        this.transSaveLock = new Object();
        this.listenerArray = new ArrayList<>();
        this.dbDelayManager = appRuntime.getCacheManagerInner().getDBDelayManager();
        this.msgQueue = new Vector<>();
        doOnCreate();
    }

    public void addMsgQueue(String str, int i3, String str2, Entity entity, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), str2, entity, Integer.valueOf(i16), proxyListener);
            return;
        }
        doAddMsgQueue(str, i3, str2, entity, i16, proxyListener);
        if (this.isDestroyed) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addMsgQueue after destroy");
            }
            saveNotify();
        } else {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null || !MobileQQ.sMobileQQ.peekAppRuntime().isBackgroundPause) {
                return;
            }
            saveNotify();
        }
    }

    public void transSaveToDatabase(String str, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
            return;
        }
        synchronized (this.transSaveLock) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.msgQueueLock) {
                if (this.msgQueue.isEmpty()) {
                    return;
                }
                Iterator<MsgQueueItem> it = this.msgQueue.iterator();
                while (it.hasNext()) {
                    MsgQueueItem next = it.next();
                    if (MsgProxyUtilsProxy.isSaveConversation(next.frindUin, str, next.type, i3) && ((i16 = next.action) == 1 || i16 == 2 || i16 == 0)) {
                        arrayList.add(next);
                    }
                }
                this.msgQueue.remove(arrayList);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    return;
                }
                transSaveToDatabaseIndeed(peekAppRuntime.getEntityManagerFactory(peekAppRuntime.getAccount()).createEntityManager(), arrayList);
                doAfterTransSaveToDatabase();
            }
        }
    }
}
