package com.tencent.gdtad.statistics.metric;

import android.content.Context;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.ams.monitor.metric.i;
import com.tencent.ams.monitor.metric.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private static volatile e f109503b;

    /* renamed from: a, reason: collision with root package name */
    private k f109504a;

    e() {
        boolean z16;
        k a16 = com.tencent.ams.monitor.metric.e.a(new f());
        this.f109504a = a16;
        if (a16 == null) {
            QLog.e("GdtMetricService", 1, "[constructor] error, service is null");
            return;
        }
        if (1 == MobileQQ.sProcessId) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            a16.setReportEnabled(new WeakReference<>(BaseApplication.getContext()), true);
        }
    }

    public static e b() {
        if (f109503b == null) {
            synchronized (e.class) {
                if (f109503b == null) {
                    f109503b = new e();
                }
            }
        }
        return f109503b;
    }

    public void a(WeakReference<Context> weakReference) {
        k kVar = this.f109504a;
        if (kVar == null) {
            QLog.e("GdtMetricService", 1, "[flush] error, service is null");
        } else {
            kVar.flush(weakReference);
        }
    }

    public void c(WeakReference<Context> weakReference, CopyOnWriteArrayList<IAdMetric> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            CopyOnWriteArrayList<i> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            ArrayList arrayList = new ArrayList();
            Iterator<IAdMetric> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                IAdMetric next = it.next();
                if (!(next instanceof i)) {
                    QLog.e("GdtMetricService", 1, "[handle] error, metric is not instanceof IAdMetric");
                } else if (next.isEnabled()) {
                    copyOnWriteArrayList2.add((i) next);
                } else {
                    arrayList.add(Long.valueOf(((i) next).getId()));
                }
            }
            if (!arrayList.isEmpty()) {
                QLog.i("GdtMetricService", 1, "[handle] ignored, idListNotEnabled.size():" + arrayList.size() + " idListNotEnabled:" + arrayList);
            }
            k kVar = this.f109504a;
            if (kVar == null) {
                QLog.e("GdtMetricService", 1, "[handle] error, service is null");
                return;
            } else {
                kVar.handle(weakReference, copyOnWriteArrayList2);
                return;
            }
        }
        QLog.e("GdtMetricService", 1, "[handle] error, metrics is null or empty");
    }

    public void d(WeakReference<Context> weakReference, boolean z16) {
        k kVar = this.f109504a;
        if (kVar == null) {
            QLog.e("GdtMetricService", 1, "[setReportEnabled] error, service is null");
        } else {
            kVar.setReportEnabled(weakReference, z16);
        }
    }
}
