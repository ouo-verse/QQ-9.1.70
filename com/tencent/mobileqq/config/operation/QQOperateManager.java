package com.tencent.mobileqq.config.operation;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQOperateManager {

    /* renamed from: h, reason: collision with root package name */
    private static QQOperateManager f202890h;

    /* renamed from: i, reason: collision with root package name */
    private static Object f202891i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static String f202892j;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<QQOperationViopTipTask> f202893a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<QQOperationTaskRecord> f202894b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<QQOperationVoipTipsTaskExcuteRecord> f202895c = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<a> f202896d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<QQOperationViopTipTask> f202897e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private long f202898f = System.currentTimeMillis();

    /* renamed from: g, reason: collision with root package name */
    int f202899g;

    QQOperateManager() {
    }

    public static void c() {
        if (f202890h == null) {
            return;
        }
        synchronized (f202891i) {
            f202890h.i();
            f202890h = null;
        }
    }

    public static QQOperateManager d(QQAppInterface qQAppInterface) {
        QQOperateManager qQOperateManager;
        synchronized (f202891i) {
            QQOperateManager qQOperateManager2 = f202890h;
            if (qQOperateManager2 == null || !qQOperateManager2.g() || !qQAppInterface.getCurrentAccountUin().equals(f202892j)) {
                f202890h = new QQOperateManager();
                f202892j = qQAppInterface.getCurrentAccountUin();
                f202890h.f(qQAppInterface);
            }
            qQOperateManager = f202890h;
        }
        return qQOperateManager;
    }

    private void f(QQAppInterface qQAppInterface) {
        boolean z16;
        boolean z17;
        this.f202893a.clear();
        this.f202894b.clear();
        this.f202895c.clear();
        this.f202897e.clear();
        this.f202896d.clear();
        if (TextUtils.isEmpty(f202892j)) {
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        this.f202899g = defaultSharedPreferences.getInt(f202892j + "QQOperationVoIPRequestCount", 0);
        long j3 = defaultSharedPreferences.getLong(f202892j + "QQOperationVoIPRequestCountTime", 0L);
        if (this.f202899g == 0 || j3 == 0 || !h(j3)) {
            this.f202899g = 0;
            defaultSharedPreferences.edit().putInt(f202892j + "QQOperationVoIPRequestCount", 0).putLong(f202892j + "QQOperationVoIPRequestCountTime", System.currentTimeMillis()).commit();
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        try {
            try {
                List<? extends Entity> query = createEntityManager.query(QQOperationViopTipTask.class, new QQOperationViopTipTask().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
                if (query != null && query.size() > 0) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QQOperateVoIP", 4, "init data config_task_size = " + query.size());
                    }
                    this.f202893a.addAll((ArrayList) query);
                    Iterator<QQOperationViopTipTask> it = this.f202893a.iterator();
                    while (it.hasNext()) {
                        QQOperationViopTipTask next = it.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        Date endDate = next.getEndDate();
                        Date beginDate = next.getBeginDate();
                        if ((endDate != null && currentTimeMillis > endDate.getTime()) || (beginDate != null && currentTimeMillis < beginDate.getTime())) {
                            this.f202893a.remove(next);
                            if (endDate != null && currentTimeMillis > endDate.getTime()) {
                                createEntityManager.remove(next);
                            }
                        }
                    }
                }
                List<? extends Entity> query2 = createEntityManager.query(QQOperationTaskRecord.class, new QQOperationTaskRecord().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
                if (query2 != null && query2.size() > 0) {
                    this.f202894b.addAll((ArrayList) query2);
                    Iterator<QQOperationTaskRecord> it5 = this.f202894b.iterator();
                    while (it5.hasNext()) {
                        QQOperationTaskRecord next2 = it5.next();
                        Iterator<QQOperationViopTipTask> it6 = this.f202893a.iterator();
                        while (true) {
                            if (it6.hasNext()) {
                                if (next2.taskid == it6.next().taskid) {
                                    z17 = true;
                                    break;
                                }
                            } else {
                                z17 = false;
                                break;
                            }
                        }
                        if (!z17) {
                            this.f202894b.remove(next2);
                            createEntityManager.remove(next2);
                        }
                        if (!h(next2.recordTime)) {
                            next2.hasShowedUins = "";
                            next2.recordTime = System.currentTimeMillis();
                            createEntityManager.persistOrReplace(next2);
                        }
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQOperateVoIP", 4, "init data task_record_size = " + this.f202894b.size());
                }
                List<? extends Entity> query3 = createEntityManager.query(QQOperationVoipTipsTaskExcuteRecord.class, new QQOperationVoipTipsTaskExcuteRecord().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
                if (query3 != null && query3.size() > 0) {
                    this.f202895c.addAll((ArrayList) query3);
                    Iterator<QQOperationVoipTipsTaskExcuteRecord> it7 = this.f202895c.iterator();
                    while (it7.hasNext()) {
                        QQOperationVoipTipsTaskExcuteRecord next3 = it7.next();
                        if (!h(next3.time)) {
                            this.f202895c.remove(next3);
                            createEntityManager.remove(next3);
                        }
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQOperateVoIP", 4, "init data task_excuted_record_size = " + this.f202895c.size());
                }
                Iterator<QQOperationVoipTipsTaskExcuteRecord> it8 = this.f202895c.iterator();
                while (it8.hasNext()) {
                    QQOperationVoipTipsTaskExcuteRecord next4 = it8.next();
                    int i3 = next4.taskid;
                    if (i3 != -1) {
                        QQOperationViopTipTask e16 = e(i3);
                        if (e16 != null) {
                            this.f202897e.add(e16);
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.d("QQOperateVoIP", 4, "init data net_task_show_size = " + this.f202897e.size());
                        }
                    } else {
                        Iterator<a> it9 = this.f202896d.iterator();
                        while (true) {
                            if (it9.hasNext()) {
                                a next5 = it9.next();
                                if (next5.f202902b == next4.uinType && next5.f202901a == next4.tipType) {
                                    z16 = true;
                                    break;
                                }
                            } else {
                                z16 = false;
                                break;
                            }
                        }
                        if (!z16) {
                            a aVar = new a();
                            aVar.f202902b = next4.uinType;
                            aVar.f202901a = next4.tipType;
                            this.f202896d.add(aVar);
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.d("QQOperateVoIP", 4, "init data native_task_show_size = " + this.f202896d.size());
                        }
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQOperateVoIP", 4, "do Init tipsTask :" + this.f202893a);
                    QLog.d("QQOperateVoIP", 4, "do Init taskRecord :" + this.f202894b);
                    QLog.d("QQOperateVoIP", 4, "do Init excuteRecord :" + this.f202895c);
                    QLog.d("QQOperateVoIP", 4, "do Init netShowList :" + this.f202897e);
                    QLog.d("QQOperateVoIP", 4, "do Init nativeShowList :" + this.f202896d);
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        } finally {
            createEntityManager.close();
        }
    }

    public static boolean h(long j3) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        calendar.setTimeInMillis(j3);
        if (calendar2.get(5) == calendar.get(5)) {
            return true;
        }
        return false;
    }

    public void b(QQAppInterface qQAppInterface, QQOperationVoipTipsTaskExcuteRecord qQOperationVoipTipsTaskExcuteRecord) {
        if (qQOperationVoipTipsTaskExcuteRecord == null) {
            return;
        }
        synchronized (f202891i) {
            QQOperationVoipTipsTaskExcuteRecord j3 = j(qQOperationVoipTipsTaskExcuteRecord);
            boolean z16 = true;
            if (j3 == null) {
                this.f202895c.add(qQOperationVoipTipsTaskExcuteRecord);
            } else {
                j3.count++;
                qQOperationVoipTipsTaskExcuteRecord = j3;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QQOperateVoIP", 4, "addVoipTipTaskExcuteRecord record.taskid = " + qQOperationVoipTipsTaskExcuteRecord.taskid + " TodayRecord : " + this.f202895c);
            }
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            boolean z17 = false;
            if (qQOperationVoipTipsTaskExcuteRecord.taskid == -1) {
                Iterator<a> it = this.f202896d.iterator();
                while (true) {
                    if (it.hasNext()) {
                        a next = it.next();
                        if (next.f202902b == qQOperationVoipTipsTaskExcuteRecord.uinType && next.f202901a == qQOperationVoipTipsTaskExcuteRecord.tipType) {
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    a aVar = new a();
                    aVar.f202902b = qQOperationVoipTipsTaskExcuteRecord.uinType;
                    aVar.f202901a = qQOperationVoipTipsTaskExcuteRecord.tipType;
                    this.f202896d.add(aVar);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQOperateVoIP", 4, "Update TodayNativeShow :" + this.f202896d);
                }
            } else {
                Iterator<QQOperationViopTipTask> it5 = this.f202897e.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    } else if (it5.next().taskid == qQOperationVoipTipsTaskExcuteRecord.taskid) {
                        z17 = true;
                        break;
                    }
                }
                if (!z17) {
                    this.f202897e.add(e(qQOperationVoipTipsTaskExcuteRecord.taskid));
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQOperateVoIP", 4, "Update TodayNetShow :" + this.f202897e);
                }
                Iterator<QQOperationTaskRecord> it6 = this.f202894b.iterator();
                QQOperationTaskRecord qQOperationTaskRecord = null;
                while (it6.hasNext()) {
                    QQOperationTaskRecord next2 = it6.next();
                    if (next2.taskid == qQOperationVoipTipsTaskExcuteRecord.taskid) {
                        next2.addUinShowCount(qQOperationVoipTipsTaskExcuteRecord.uin);
                        if (!next2.hasShowedUins.contains(qQOperationVoipTipsTaskExcuteRecord.uin + "_" + qQOperationVoipTipsTaskExcuteRecord.uinType)) {
                            next2.hasShowedUins += qQOperationVoipTipsTaskExcuteRecord.uin + "_" + qQOperationVoipTipsTaskExcuteRecord.uinType + "|";
                            next2.aioCount++;
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.d("QQOperateVoIP", 4, "QQOperationTaskRecord record.taskid = " + next2.taskid + " existTaskRecord.showCount = " + next2.showCount + " existTaskRecord.aioCount = " + next2.aioCount);
                        }
                        qQOperationTaskRecord = next2;
                    }
                }
                if (qQOperationTaskRecord == null) {
                    qQOperationTaskRecord = new QQOperationTaskRecord();
                    qQOperationTaskRecord.taskid = qQOperationVoipTipsTaskExcuteRecord.taskid;
                    qQOperationTaskRecord.aioCount = 1;
                    qQOperationTaskRecord.addUinShowCount(qQOperationVoipTipsTaskExcuteRecord.uin);
                    qQOperationTaskRecord.recordTime = System.currentTimeMillis();
                    qQOperationTaskRecord.hasShowedUins = qQOperationVoipTipsTaskExcuteRecord.uin + "_" + qQOperationVoipTipsTaskExcuteRecord.uinType + "|";
                    this.f202894b.add(qQOperationTaskRecord);
                }
                qQOperationTaskRecord.setStatus(1000);
                createEntityManager.persistOrReplace(qQOperationTaskRecord);
            }
            qQOperationVoipTipsTaskExcuteRecord.setStatus(1000);
            createEntityManager.persistOrReplace(qQOperationVoipTipsTaskExcuteRecord);
            createEntityManager.close();
        }
    }

    public QQOperationViopTipTask e(int i3) {
        Iterator<QQOperationViopTipTask> it = this.f202893a.iterator();
        while (it.hasNext()) {
            QQOperationViopTipTask next = it.next();
            if (next.taskid == i3) {
                return next;
            }
        }
        return null;
    }

    public boolean g() {
        return h(this.f202898f);
    }

    public void i() {
        final int i3 = this.f202899g;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.config.operation.QQOperateManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(QQOperateManager.f202892j)) {
                    PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putInt(QQOperateManager.f202892j + "QQOperationVoIPRequestCount", i3).commit();
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQOperateVoIP", 4, "onDestroy.......");
                }
            }
        }, 8, null, true);
    }

    public QQOperationVoipTipsTaskExcuteRecord j(QQOperationVoipTipsTaskExcuteRecord qQOperationVoipTipsTaskExcuteRecord) {
        String str;
        Iterator<QQOperationVoipTipsTaskExcuteRecord> it = this.f202895c.iterator();
        while (it.hasNext()) {
            QQOperationVoipTipsTaskExcuteRecord next = it.next();
            if (next != null && next.taskid == qQOperationVoipTipsTaskExcuteRecord.taskid && next.tipType == qQOperationVoipTipsTaskExcuteRecord.tipType && (str = next.uin) != null && str.equals(qQOperationVoipTipsTaskExcuteRecord.uin) && next.uinType == qQOperationVoipTipsTaskExcuteRecord.uinType) {
                return next;
            }
        }
        return null;
    }
}
