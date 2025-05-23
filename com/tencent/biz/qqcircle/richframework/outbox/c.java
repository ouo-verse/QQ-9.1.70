package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f91910a;

    /* renamed from: b, reason: collision with root package name */
    private final a f91911b = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        volatile long f91912a;

        /* renamed from: b, reason: collision with root package name */
        volatile IDBManagerWrapper f91913b;

        /* renamed from: c, reason: collision with root package name */
        IDBManagerWrapper.OnCloseListener f91914c = new C0924a();

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.richframework.outbox.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class C0924a implements IDBManagerWrapper.OnCloseListener {
            C0924a() {
            }

            @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper.OnCloseListener
            public void onClosed(IDBManagerWrapper iDBManagerWrapper) {
                synchronized (a.class) {
                    a.this.f91912a = 0L;
                    a.this.f91913b = null;
                }
            }
        }

        a() {
        }
    }

    public c(String str) {
        this.f91910a = "sender_queue";
        this.f91910a = str;
    }

    private void a(a aVar) {
        if (aVar == null) {
            return;
        }
        long longAccountUin = HostDataTransUtils.getLongAccountUin();
        if (longAccountUin != aVar.f91912a || aVar.f91913b == null || aVar.f91913b.isClosed()) {
            aVar.f91912a = longAccountUin;
            aVar.f91913b = QCircleHostQzoneHelper.getCacheManager(QCircleOutboxCacheData.class, longAccountUin, this.f91910a);
            aVar.f91913b.addCloseListener(aVar.f91914c);
        }
    }

    public void b(b bVar) {
        synchronized (a.class) {
            a(this.f91911b);
            this.f91911b.f91913b.deleteData("cache_key=?", new String[]{bVar.getCacheKey()});
        }
    }

    public ArrayList<b> c() {
        ArrayList<b> arrayList;
        synchronized (a.class) {
            a(this.f91911b);
            arrayList = new ArrayList<>();
            try {
                ArrayList<? extends IDBCacheDataWrapper> queryData = this.f91911b.f91913b.queryData();
                if (queryData != null) {
                    int size = queryData.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        QCircleOutboxCacheData qCircleOutboxCacheData = (QCircleOutboxCacheData) queryData.get(i3);
                        if (qCircleOutboxCacheData != null && qCircleOutboxCacheData.getQueueTask() != null) {
                            b queueTask = qCircleOutboxCacheData.getQueueTask();
                            if (!queueTask.isNullTask()) {
                                queueTask.d("QCircleOutboxTaskCacheManager", "restoreTask");
                                queueTask.setState(2);
                                arrayList.add(qCircleOutboxCacheData.getQueueTask());
                            } else {
                                b(queueTask);
                                QLog.w("QCircleOutboxTaskCacheManager", 1, "remove null task, id:" + queueTask.getTaskId());
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("QCircleOutboxTaskCacheManager", 1, "restoreTasks exception :" + e16.toString());
            }
        }
        return arrayList;
    }

    public void d(b bVar) {
        synchronized (a.class) {
            if (!bVar.isNullTask()) {
                a(this.f91911b);
                this.f91911b.f91913b.saveData(new QCircleOutboxCacheData(bVar), 1);
            } else {
                QLog.w("QCircleOutboxTaskCacheManager", 1, "save null task, id:" + bVar.getTaskId());
            }
        }
    }

    public void e(b bVar) {
        synchronized (a.class) {
            a(this.f91911b);
            this.f91911b.f91913b.updateData(new QCircleOutboxCacheData(bVar), "cache_key=?", new String[]{bVar.getCacheKey()});
        }
    }
}
