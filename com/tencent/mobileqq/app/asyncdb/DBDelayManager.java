package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DBDelayManager implements Manager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Q.db.Cache";
    private AppRuntime app;
    Vector<BaseDBQueueItem> baseQueue;
    boolean isDestroyed;

    public DBDelayManager(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
            return;
        }
        this.isDestroyed = false;
        this.app = appRuntime;
        this.baseQueue = new Vector<>();
        this.isDestroyed = false;
    }

    public void addQueue(Entity entity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            addQueue(entity, i3, 0, null);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) entity, i3);
        }
    }

    public void clearQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        synchronized (this.baseQueue) {
            this.baseQueue.clear();
        }
    }

    public Vector<BaseDBQueueItem> getQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Vector) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.baseQueue;
    }

    @Override // mqq.manager.Manager
    public synchronized void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isDestroyed = true;
            transSaveToDatabase();
        }
    }

    public void saveNotify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.app.getProxyManagerInner().saveNotify();
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void transSaveToDatabase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        transSaveToDatabase(createEntityManager);
        createEntityManager.close();
    }

    public void addQueue(Entity entity, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            addQueue(entity, i3, i16, null);
        } else {
            iPatchRedirector.redirect((short) 8, this, entity, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void addQueue(Entity entity, int i3, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            addQueue(entity, i3, 0, proxyListener);
        } else {
            iPatchRedirector.redirect((short) 9, this, entity, Integer.valueOf(i3), proxyListener);
        }
    }

    private void transSaveToDatabase(EntityManager entityManager) {
        synchronized (this.baseQueue) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "transSaveToDatabase writeRunable msgQueue size:" + this.baseQueue.size());
            }
            if (this.baseQueue.isEmpty()) {
                return;
            }
            List<BaseDBQueueItem> list = (List) this.baseQueue.clone();
            this.baseQueue.clear();
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (BaseDBQueueItem baseDBQueueItem : list) {
                        String tableName = baseDBQueueItem.item.getTableName();
                        ProxyListener proxyListener = baseDBQueueItem.listener;
                        int i3 = baseDBQueueItem.action;
                        if (i3 == 0) {
                            arrayList.add(new PersistOrReplaceTransaction(baseDBQueueItem.item));
                            if (proxyListener != null) {
                                proxyListener.onInsertFinish(tableName);
                            }
                        } else if (i3 == 1) {
                            arrayList.add(new UpdateTransaction(baseDBQueueItem.item));
                            if (proxyListener != null) {
                                proxyListener.onUpdateFinish(tableName, 1);
                            }
                        } else if (i3 == 2) {
                            arrayList.add(new RemoveTransaction(baseDBQueueItem.item));
                            if (proxyListener != null) {
                                proxyListener.onDeleteFinish(tableName, 1);
                            }
                        }
                    }
                    entityManager.doMultiDBOperateByTransaction(arrayList);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "writeRunable write exception: size=" + list.size(), e16);
                    }
                }
            }
        }
    }

    public void addQueue(Entity entity, int i3, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, entity, Integer.valueOf(i3), Integer.valueOf(i16), proxyListener);
            return;
        }
        BaseDBQueueItem baseDBQueueItem = new BaseDBQueueItem(entity, i3, i16, proxyListener);
        synchronized (this.baseQueue) {
            this.baseQueue.add(baseDBQueueItem);
        }
        if (this.isDestroyed) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addQueue after destroy");
            }
            saveNotify();
        } else {
            if (i16 != 0) {
                if (i16 != 1) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "addMsgQueue write notify");
                }
                saveNotify();
                return;
            }
            if (this.app.isBackgroundPause) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "addMsgQueue write notify");
                }
                saveNotify();
            }
        }
    }
}
