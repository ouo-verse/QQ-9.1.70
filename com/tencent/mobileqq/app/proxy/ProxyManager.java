package com.tencent.mobileqq.app.proxy;

import android.os.Looper;
import com.tencent.imcore.message.f;
import com.tencent.imcore.message.n;
import com.tencent.imcore.message.z;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* loaded from: classes11.dex */
public class ProxyManager extends QProxyManager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f196530d;

    @Deprecated
    public ProxyManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.mobileqq.app.proxy.QProxyManager
    protected long beforeQueueActionInTransSaveToDatabase(long j3, long j16, boolean z16, boolean z17) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), Boolean.valueOf(z17))).longValue();
        }
        if (z16 && z17) {
            long nanoTime = (System.nanoTime() - j3) / 1000;
            HashMap<String, String> hashMap = new HashMap<>();
            if (Looper.myLooper() == Looper.getMainLooper()) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put(StatisticCollector.SqliteOptCostInfo.MAINTHREAD_TAG, str);
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTYPE_TAG, "begintrans");
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTOTALCOST_TAG, String.valueOf(nanoTime));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.WALSWITCH_TAG, String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.SQLITE_OPERATE_DETAIL_COST, true, nanoTime, 0L, hashMap, (String) null, false);
            return nanoTime;
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.app.proxy.QProxyManager
    protected void beforeTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            super.beforeTrans();
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxyManager
    public void doAddMsgQueue(String str, int i3, String str2, Entity entity, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), str2, entity, Integer.valueOf(i16), proxyListener);
        } else {
            super.doAddMsgQueue(str, i3, str2, entity, i16, proxyListener);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxyManager
    protected void doAfterTransSaveToDatabase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            super.doAfterTransSaveToDatabase();
            this.f196530d.getMsgCache().Y();
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.QProxyManager
    protected long doMessageActionDel(EntityManager entityManager, boolean z16, boolean z17, long j3, MsgQueueItem msgQueueItem, String str, ProxyListener proxyListener) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, this, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), msgQueueItem, str, proxyListener)).longValue();
        }
        long doMessageActionDel = super.doMessageActionDel(entityManager, z16, z17, j3, msgQueueItem, str, proxyListener);
        if (z16 && StatisticCollector.getSqliteSwitchBySample(6)) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (z17) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put(StatisticCollector.SqliteOptCostInfo.MAINTHREAD_TAG, str2);
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTYPE_TAG, "delete");
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTOTALCOST_TAG, String.valueOf(doMessageActionDel));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.WALSWITCH_TAG, String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.SQLITE_OPERATE_DETAIL_COST, true, doMessageActionDel, 0L, hashMap, (String) null, false);
        }
        return doMessageActionDel;
    }

    @Override // com.tencent.mobileqq.app.proxy.QProxyManager
    protected long doMessageActionInsert(EntityManager entityManager, boolean z16, boolean z17, long j3, MsgQueueItem msgQueueItem, String str, ProxyListener proxyListener) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, this, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), msgQueueItem, str, proxyListener)).longValue();
        }
        long doMessageActionInsert = super.doMessageActionInsert(entityManager, z16, z17, j3, msgQueueItem, str, proxyListener);
        if (z16 && StatisticCollector.getSqliteSwitchBySample(4)) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (z17) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put(StatisticCollector.SqliteOptCostInfo.MAINTHREAD_TAG, str2);
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTYPE_TAG, "insert");
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTOTALCOST_TAG, String.valueOf(doMessageActionInsert));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.WALSWITCH_TAG, String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.SQLITE_OPERATE_DETAIL_COST, true, doMessageActionInsert, 0L, hashMap, (String) null, false);
        }
        return doMessageActionInsert;
    }

    @Override // com.tencent.mobileqq.app.proxy.QProxyManager
    protected long doMessageActionUpdate(EntityManager entityManager, boolean z16, boolean z17, long j3, long j16, MsgQueueItem msgQueueItem, String str, ProxyListener proxyListener) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, this, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Long.valueOf(j16), msgQueueItem, str, proxyListener)).longValue();
        }
        long doMessageActionUpdate = super.doMessageActionUpdate(entityManager, z16, z17, j3, j16, msgQueueItem, str, proxyListener);
        if (z16 && StatisticCollector.getSqliteSwitchBySample(5)) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (z17) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put(StatisticCollector.SqliteOptCostInfo.MAINTHREAD_TAG, str2);
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTYPE_TAG, "update");
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTOTALCOST_TAG, String.valueOf(doMessageActionUpdate));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.WALSWITCH_TAG, String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.SQLITE_OPERATE_DETAIL_COST, true, doMessageActionUpdate, 0L, hashMap, (String) null, false);
        }
        return doMessageActionUpdate;
    }

    public ConfessProxy e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ConfessProxy) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return (ConfessProxy) getProxy(13);
    }

    @Override // com.tencent.mobileqq.app.proxy.QProxyManager
    protected void endTrans(EntityTransaction entityTransaction, boolean z16, boolean z17, long j3, int i3, int i16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, entityTransaction, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.endTrans(entityTransaction, z16, z17, j3, i3, i16);
        if (entityTransaction != null && z16) {
            long nanoTime = (System.nanoTime() - j3) / 1000;
            HashMap<String, String> hashMap = new HashMap<>();
            if (z17) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put(StatisticCollector.SqliteOptCostInfo.MAINTHREAD_TAG, str);
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTYPE_TAG, "trans");
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTOTALCOST_TAG, String.valueOf(nanoTime));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTCOUNT_TAG, String.valueOf(i3));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTMSGCOUNT_TAG, String.valueOf(i16));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTONECOST_TAG, String.valueOf(((float) nanoTime) / i3));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTSCENE_TAG, "trans");
            hashMap.put(StatisticCollector.SqliteOptCostInfo.WALSWITCH_TAG, String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.SQLITE_OPERATE_COST, true, nanoTime, 0L, hashMap, (String) null, false);
        }
    }

    public n f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (n) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return (n) getProxy(11);
    }

    public DataLineMsgProxy g(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DataLineMsgProxy) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        if (i3 == 1) {
            i16 = 4;
        } else if (i3 == 2) {
            i16 = 15;
        } else {
            i16 = 3;
        }
        DataLineMsgProxy dataLineMsgProxy = (DataLineMsgProxy) getProxy(i16);
        dataLineMsgProxy.init();
        return dataLineMsgProxy;
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxyManager
    protected int getSaveInDBState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.f196530d.mAutomator.getInActionLoginB();
    }

    public FileManagerProxy h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (FileManagerProxy) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (FileManagerProxy) getProxy(6);
    }

    public f i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (f) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (f) getProxy(1);
    }

    public z j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (z) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (z) getProxy(0);
    }

    public MultiMsgProxy k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MultiMsgProxy) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (MultiMsgProxy) getProxy(2);
    }

    public QCallProxy l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (QCallProxy) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return (QCallProxy) getProxy(12);
    }

    @Deprecated
    public RecentUserProxy m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (RecentUserProxy) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f196530d.getRecentUserProxy();
    }

    public com.tencent.mobileqq.troop.filemanager.a n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.troop.filemanager.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return (com.tencent.mobileqq.troop.filemanager.a) getProxy(7);
    }

    @Override // com.tencent.mobileqq.app.proxy.QProxyManager, com.tencent.mobileqq.app.proxy.BaseProxyManager, mqq.manager.Manager
    public synchronized void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    public ProxyManager(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f196530d = qQAppInterface;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
        }
    }
}
