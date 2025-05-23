package com.tencent.biz.qqcircle.manager;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$RspEntry;

/* loaded from: classes4.dex */
public class QCirclePublishPromoteDataManager {

    /* renamed from: c, reason: collision with root package name */
    private static volatile QCirclePublishPromoteDataManager f91483c;

    /* renamed from: a, reason: collision with root package name */
    private volatile e40.f f91484a;

    /* renamed from: b, reason: collision with root package name */
    private volatile e40.g f91485b;

    QCirclePublishPromoteDataManager() {
    }

    public static QCirclePublishPromoteDataManager f() {
        if (f91483c == null) {
            synchronized (QCirclePublishPromoteDataManager.class) {
                if (f91483c == null) {
                    f91483c = new QCirclePublishPromoteDataManager();
                }
            }
        }
        return f91483c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQCircleTianShu$AdItem h(QQCircleTianShu$RspEntry qQCircleTianShu$RspEntry) {
        if (qQCircleTianShu$RspEntry != null && qQCircleTianShu$RspEntry.has()) {
            List<QQCircleTianShu$AdItem> list = qQCircleTianShu$RspEntry.value.lst.get();
            if (list != null && !list.isEmpty()) {
                return list.get(0);
            }
            QLog.d("QCirclePublishPromoteDataManager", 1, "parseAdItem, adItems is null");
            return null;
        }
        QLog.d("QCirclePublishPromoteDataManager", 1, "parseAdItem, tianShuInfo is null ");
        return null;
    }

    public e40.g g() {
        return this.f91485b;
    }

    public void i(final QQCircleTianShu$RspEntry qQCircleTianShu$RspEntry, final QQCircleTianShu$RspEntry qQCircleTianShu$RspEntry2) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.manager.QCirclePublishPromoteDataManager.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QCirclePublishPromoteDataManager", 1, "start parse button Ad ");
                QQCircleTianShu$AdItem h16 = QCirclePublishPromoteDataManager.this.h(qQCircleTianShu$RspEntry);
                if (h16 != null && h16.has()) {
                    QCirclePublishPromoteDataManager.this.f91484a = new e40.f(h16);
                    QLog.d("QCirclePublishPromoteDataManager", 1, "button Ad: " + QCirclePublishPromoteDataManager.this.f91484a);
                }
                QLog.d("QCirclePublishPromoteDataManager", 1, "start parse toast Ad ");
                QQCircleTianShu$AdItem h17 = QCirclePublishPromoteDataManager.this.h(qQCircleTianShu$RspEntry2);
                if (h17 != null && h17.has()) {
                    QCirclePublishPromoteDataManager.this.f91485b = new e40.g(h17);
                    QLog.d("QCirclePublishPromoteDataManager", 1, "toast Ad: " + QCirclePublishPromoteDataManager.this.f91485b);
                }
            }
        });
    }
}
