package com.tencent.biz.pubaccount.api.impl;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.api.IPublicAccountReportManager;
import com.tencent.biz.pubaccount.util.PAReportInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* loaded from: classes32.dex */
public class PublicAccountReportManagerImpl implements IPublicAccountReportManager, Handler.Callback, Manager {
    public static final int ACTION_QUERY_DB = 100001;
    public static final int ACTION_REPORT = 100002;
    public static final int LOAD_PA_COUNT = 20;
    public static final int MSG_REPORT_RECORD_MAX_COUNT = 80;
    public static final String TAG = "PAReport";
    private QQAppInterface app;

    /* renamed from: em, reason: collision with root package name */
    private EntityManager f79519em;
    private MqqWeakReferenceHandler mHandlerRunInSubThread;
    private volatile int mCount = -1;
    private volatile boolean isInited = false;
    private List<PAReportInfo> mReporting = new ArrayList();

    public PublicAccountReportManagerImpl() {
    }

    private void init(QQAppInterface qQAppInterface) {
        if (this.isInited) {
            return;
        }
        synchronized (this) {
            if (!this.isInited) {
                this.app = qQAppInterface;
                this.f79519em = qQAppInterface.getEntityManagerFactory().createEntityManager();
                this.mHandlerRunInSubThread = new MqqWeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
                this.isInited = true;
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReportManager
    public void addReporting(final Entity entity) {
        this.mHandlerRunInSubThread.post(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountReportManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                Entity entity2 = entity;
                if (entity2 instanceof PAReportInfo) {
                    PAReportInfo pAReportInfo = (PAReportInfo) entity2;
                    if (PublicAccountReportManagerImpl.this.mCount == -1) {
                        PublicAccountReportManagerImpl publicAccountReportManagerImpl = PublicAccountReportManagerImpl.this;
                        publicAccountReportManagerImpl.mCount = publicAccountReportManagerImpl.app.getReadableDatabase().getCount(PAReportInfo.class.getSimpleName());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("PAReport", 2, "before insert into db mCount = " + PublicAccountReportManagerImpl.this.mCount);
                    }
                    if (PublicAccountReportManagerImpl.this.mCount >= 80) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PAReport", 2, "databases message records is out of 80 delete the first _id ");
                        }
                        String format = String.format("delete from %s where _id = (select min(_id) from %s)", pAReportInfo.getTableName(), pAReportInfo.getTableName());
                        SQLiteDatabase writableDatabase = PublicAccountReportManagerImpl.this.app.getWritableDatabase();
                        if (writableDatabase == null) {
                            return;
                        }
                        if (writableDatabase.execSQL(format)) {
                            synchronized (PublicAccountReportManagerImpl.this.mReporting) {
                                PublicAccountReportManagerImpl.this.mReporting.clear();
                            }
                            PublicAccountReportManagerImpl.this.mCount--;
                        }
                    }
                    PublicAccountReportManagerImpl.this.mCount++;
                    PublicAccountReportManagerImpl.this.f79519em.persist(pAReportInfo);
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 100001) {
            queryDatabases();
            return true;
        }
        if (i3 != 100002) {
            return false;
        }
        reporting();
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            init((QQAppInterface) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.f79519em.close();
        synchronized (this.mReporting) {
            this.mReporting.clear();
        }
        this.mCount = -1;
    }

    public void queryDatabases() {
        if (QLog.isColorLevel()) {
            QLog.d("PAReport", 2, "queryDatabases ... size = " + this.mReporting.size() + ", count = " + this.mCount);
        }
        if (this.mCount == -1 && this.app.getReadableDatabase() != null) {
            this.mCount = this.app.getReadableDatabase().getCount(PAReportInfo.class.getSimpleName());
        }
        List<? extends Entity> query = this.f79519em.query(PAReportInfo.class, true, null, null, null, null, null, String.valueOf(20));
        if (query != null) {
            synchronized (this.mReporting) {
                this.mReporting.addAll(query);
            }
        }
        this.mHandlerRunInSubThread.sendEmptyMessage(100002);
    }

    public void reporting() {
        if (QLog.isColorLevel()) {
            QLog.d("PAReport", 2, "reporting ... size = " + this.mReporting.size() + ", count = " + this.mCount);
        }
        if (this.mReporting.size() <= 0) {
            return;
        }
        PAReportInfo pAReportInfo = this.mReporting.get(0);
        if (this.f79519em.remove(pAReportInfo)) {
            this.mCount--;
            synchronized (this.mReporting) {
                if (this.mReporting.size() > 0) {
                    this.mReporting.remove(0);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (String str : pAReportInfo.msgIds.split("\\|")) {
                arrayList.add(str);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReportManager
    public void scheduleReport() {
        if (QLog.isColorLevel()) {
            QLog.d("PAReport", 2, "scheduleReport ... size = " + this.mReporting.size() + ", count = " + this.mCount);
        }
        if (this.mReporting.size() == 0 && this.mCount == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("PAReport", 2, "scheduleReport ... No need query DB");
            }
        } else {
            if (this.mReporting.size() == 0) {
                if (this.mHandlerRunInSubThread.hasMessages(100001)) {
                    return;
                }
                this.mHandlerRunInSubThread.sendEmptyMessageDelayed(100001, 3000L);
                return;
            }
            this.mHandlerRunInSubThread.sendEmptyMessage(100002);
        }
    }

    public PublicAccountReportManagerImpl(QQAppInterface qQAppInterface) {
        init(qQAppInterface);
    }
}
