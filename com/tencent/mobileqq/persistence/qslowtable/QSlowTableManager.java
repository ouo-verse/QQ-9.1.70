package com.tencent.mobileqq.persistence.qslowtable;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.g;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QSlowTableManager implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private a f258333d;

    /* renamed from: e, reason: collision with root package name */
    protected g f258334e = null;

    /* renamed from: f, reason: collision with root package name */
    private Object f258335f = new Object();

    /* renamed from: h, reason: collision with root package name */
    QQAppInterface f258336h;

    public QSlowTableManager(QQAppInterface qQAppInterface) {
        this.f258336h = qQAppInterface;
    }

    private SQLiteOpenHelper d() {
        if (!this.f258336h.getCurrentAccountUin().equals("0")) {
            return c().build(this.f258336h.getCurrentAccountUin());
        }
        return null;
    }

    public int b(String str, String str2, String[] strArr) {
        QLog.d("QSlowTableManager", 1, "deleteSlowTable() : tableName = [" + str + "], whereClause = [" + str2 + "], whereArgs = [" + Arrays.toString(strArr) + "]");
        int i3 = 0;
        if (f() == null) {
            QLog.e("QSlowTableManager", 2, "deleteSlowTable db = null!");
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        try {
            DeleteTransaction deleteTransaction = new DeleteTransaction(str, str2, strArr);
            arrayList.add(deleteTransaction);
            e().doMultiDBOperateByTransaction(arrayList);
            i3 = deleteTransaction.getResult().intValue();
        } catch (Exception e16) {
            QLog.e("QSlowTableManager", 1, "delete slowtable excep: ", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QSlowTableManager", 2, "delete slowtable=" + str + " ,count=" + i3 + " ,whereClause:" + str2);
        } else if (i3 > 0) {
            QLog.d("QSlowTableManager", 1, "deleteSlowTable count:" + i3);
        }
        return i3;
    }

    public a c() {
        String currentUin = this.f258336h.getCurrentUin();
        if (currentUin != null) {
            a aVar = this.f258333d;
            if (aVar != null) {
                return aVar;
            }
            synchronized (this) {
                if (this.f258333d == null) {
                    this.f258333d = new a(currentUin);
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (!QSlowTableManager.this.f258333d.verifyAuthentication()) {
                                    QLog.e("QSlowTableManager", 1, "db verifyAuthentication failed!");
                                }
                            } catch (Exception e16) {
                                QLog.e("QSlowTableManager", 1, "db verifyAuthentication Exception", e16);
                            }
                        }
                    }, 8, null, false);
                }
            }
            return this.f258333d;
        }
        throw new IllegalStateException("uin is null");
    }

    public g e() {
        g gVar = this.f258334e;
        if (gVar == null || !gVar.isOpen()) {
            synchronized (this.f258335f) {
                g gVar2 = this.f258334e;
                if (gVar2 == null || !gVar2.isOpen()) {
                    this.f258334e = (g) c().b();
                }
            }
        }
        return this.f258334e;
    }

    public SQLiteDatabase f() {
        SQLiteOpenHelper d16 = d();
        if (d16 != null) {
            return d16.getWritableDatabase();
        }
        return null;
    }

    public void g(String str, List<MessageRecord> list) {
        StringBuilder sb5;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            try {
                try {
                    for (MessageRecord messageRecord : list) {
                        messageRecord.setStatus(1000);
                        arrayList.add(new PersistOrReplaceTransaction(messageRecord));
                    }
                    e().doMultiDBOperateByTransaction(arrayList);
                    Iterator<MessageRecord> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().getStatus() == 1001) {
                            i3++;
                        }
                    }
                    sb5 = new StringBuilder();
                } catch (Exception e16) {
                    QLog.e("QSlowTableManager", 1, "insert slowtable excep: ", e16);
                    sb5 = new StringBuilder();
                }
                sb5.append("insertSlowTable totalCount:");
                sb5.append(list.size());
                sb5.append(" ,succCount:");
                sb5.append(i3);
                QLog.d("QSlowTableManager", 1, sb5.toString());
                return;
            } catch (Throwable th5) {
                QLog.d("QSlowTableManager", 1, "insertSlowTable totalCount:" + list.size() + " ,succCount:" + i3);
                throw th5;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QSlowTableManager", 2, "insertSlowTable return by non msg");
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        g gVar = this.f258334e;
        if (gVar != null && gVar.isOpen()) {
            this.f258334e.close();
        }
        a aVar = this.f258333d;
        if (aVar != null) {
            aVar.close();
        }
    }
}
