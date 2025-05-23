package com.tencent.mobileqq.persistence;

import com.tencent.imcore.message.core.MsgLock;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.db.DBThreadMonitor;
import com.tencent.mobileqq.imcore.proxy.db.ThreadTraceHelperProxy;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes16.dex */
public class EntityTransaction {

    /* renamed from: db, reason: collision with root package name */
    private SQLiteDatabase f258305db;
    private final SQLiteOpenHelper dbHelper;
    public final Lock mLock = new MsgLock("EntityTransaction");
    private DBThreadMonitor mDBThreadMonitor = new DBThreadMonitor("EntityTransaction");

    /* JADX INFO: Access modifiers changed from: package-private */
    public EntityTransaction(SQLiteOpenHelper sQLiteOpenHelper) {
        this.dbHelper = sQLiteOpenHelper;
    }

    @Deprecated
    public void begin() {
        Thread currentThread = Thread.currentThread();
        ThreadTraceHelperProxy.addWaitingTransThread(currentThread.getId(), currentThread.getName());
        this.mLock.lock();
        this.mDBThreadMonitor.addCompetitionThread();
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        this.f258305db = writableDatabase;
        if (SQLiteOpenHelper.WAL_ENABLE) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
        ThreadTraceHelperProxy.removeWaitingTransThread(currentThread.getId());
        ThreadTraceHelperProxy.setCurrentTransThread(currentThread.getId(), currentThread.getName());
    }

    @Deprecated
    public void commit() {
        this.f258305db.setTransactionSuccessful();
    }

    @Deprecated
    public void end() {
        try {
            this.f258305db.endTransaction();
            this.f258305db = null;
            if (!((ReentrantLock) this.mLock).isHeldByCurrentThread()) {
                return;
            }
        } catch (Exception unused) {
            if (!((ReentrantLock) this.mLock).isHeldByCurrentThread()) {
                return;
            }
        } catch (Throwable th5) {
            if (((ReentrantLock) this.mLock).isHeldByCurrentThread()) {
                ThreadTraceHelperProxy.setCurrentTransThread(-1L, null);
                this.mLock.unlock();
                this.mDBThreadMonitor.finishThread();
            }
            throw th5;
        }
        ThreadTraceHelperProxy.setCurrentTransThread(-1L, null);
        this.mLock.unlock();
        this.mDBThreadMonitor.finishThread();
    }
}
