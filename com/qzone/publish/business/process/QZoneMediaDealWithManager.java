package com.qzone.publish.business.process;

import android.text.TextUtils;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.qzone.publish.business.process.base.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneMediaDealWithManager implements a.InterfaceC0438a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile QZoneMediaDealWithManager f51034d;

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f51035a = new Runnable() { // from class: com.qzone.publish.business.process.QZoneMediaDealWithManager.1
        @Override // java.lang.Runnable
        public void run() {
            QZLog.d("upload2_QZoneMediaDealWithManager", 1, "mProgressTimeOutRunnable run");
            com.qzone.publish.business.process.base.a aVar = QZoneMediaDealWithManager.this.f51037c;
            if (aVar != null) {
                aVar.c(-201, g.a(-201));
            }
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final List<com.qzone.publish.business.process.base.a> f51036b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private volatile com.qzone.publish.business.process.base.a f51037c = null;

    private synchronized void h(com.qzone.publish.business.process.base.a aVar, boolean z16) {
        if (aVar == null) {
            return;
        }
        if (z16) {
            this.f51036b.add(0, aVar);
        } else {
            this.f51036b.add(aVar);
        }
        if (this.f51037c == null) {
            s(aVar);
        } else {
            QZLog.d("upload2_QZoneMediaDealWithManager", 1, "runProcess is busy add to list");
        }
    }

    private void i(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f51036b.size(); i3++) {
            com.qzone.publish.business.process.base.a aVar = this.f51036b.get(i3);
            if ((aVar instanceof d) && TextUtils.equals(((d) aVar).s(), str)) {
                arrayList.add(aVar);
            }
        }
        QZLog.d("upload2_QZoneMediaDealWithManager", 1, "cancelOldExportProcess processList.size: " + arrayList.size());
        j(arrayList);
    }

    private synchronized void n() {
        QZLog.d("upload2_QZoneMediaDealWithManager", 1, "executeFromProcessList");
        p();
        this.f51037c = null;
        if (this.f51036b.isEmpty()) {
            QZLog.d("upload2_QZoneMediaDealWithManager", 1, "executeFromProcessList mVideoProcessList is empty");
        } else {
            s(this.f51036b.get(0));
        }
    }

    public static QZoneMediaDealWithManager o() {
        if (f51034d == null) {
            synchronized (QZoneMediaDealWithManager.class) {
                if (f51034d == null) {
                    f51034d = new QZoneMediaDealWithManager();
                }
            }
        }
        return f51034d;
    }

    private void p() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).removeTask(this.f51035a);
    }

    private void r(long j3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).postDelayed(this.f51035a, j3);
    }

    private void s(com.qzone.publish.business.process.base.a aVar) {
        QZLog.d("upload2_QZoneMediaDealWithManager", 1, "startRunTask :" + aVar);
        r(aVar.j());
        this.f51037c = aVar;
        aVar.a(this);
        aVar.o();
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void a(com.qzone.publish.business.process.base.a aVar, Object obj, Object obj2, float f16) {
        if (aVar == this.f51037c) {
            q(aVar.j());
        }
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void b(com.qzone.publish.business.process.base.a aVar, Object obj) {
        QZLog.d("upload2_QZoneMediaDealWithManager", 1, "onProcessCancel :" + aVar);
        this.f51036b.remove(aVar);
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void d(com.qzone.publish.business.process.base.a aVar, Object obj, Object obj2) {
        QZLog.d("upload2_QZoneMediaDealWithManager", 1, "onProcessSucceed :" + aVar);
        this.f51036b.remove(aVar);
        if (aVar == this.f51037c) {
            n();
        }
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void e(com.qzone.publish.business.process.base.a aVar, Object obj) {
        if (aVar == this.f51037c) {
            q(aVar.j());
        }
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void f(com.qzone.publish.business.process.base.a aVar, Object obj, int i3, String str) {
        QZLog.d("upload2_QZoneMediaDealWithManager", 1, "onProcessFailed :" + aVar);
        this.f51036b.remove(aVar);
        if (aVar == this.f51037c) {
            n();
        }
    }

    public void k(String str) {
        QZLog.d("upload2_QZoneMediaDealWithManager", 1, "cancelExportProcess " + str);
        ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).cancelTask(str);
        i(str);
    }

    public void q(long j3) {
        p();
        r(j3);
    }

    public <T> com.qzone.publish.business.process.base.a l(T t16, QZoneProcessType qZoneProcessType, a.InterfaceC0438a<T> interfaceC0438a) {
        return m(t16, qZoneProcessType, interfaceC0438a, false);
    }

    public void j(List<com.qzone.publish.business.process.base.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        QZLog.d("upload2_QZoneMediaDealWithManager", 1, "cancelProcessList processList size:" + list.size());
        this.f51036b.removeAll(list);
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.qzone.publish.business.process.base.a aVar = list.get(i3);
            aVar.h();
            aVar.b();
        }
        com.qzone.publish.business.process.base.a aVar2 = this.f51037c;
        if (aVar2 == null || !list.contains(aVar2)) {
            return;
        }
        QZLog.d("upload2_QZoneMediaDealWithManager", 1, "cancelProcessList and executeNext");
        n();
    }

    public <T> com.qzone.publish.business.process.base.a m(T t16, QZoneProcessType qZoneProcessType, a.InterfaceC0438a<T> interfaceC0438a, boolean z16) {
        if (t16 == null) {
            return null;
        }
        for (com.qzone.publish.business.process.base.a aVar : this.f51036b) {
            if (aVar.k() == qZoneProcessType && aVar.m(t16)) {
                QZLog.d("upload2_QZoneMediaDealWithManager", 1, "createProcess by reuse processType:" + qZoneProcessType);
                aVar.a(interfaceC0438a);
                return aVar;
            }
        }
        QZLog.d("upload2_QZoneMediaDealWithManager", 1, "createProcess by QZoneProcessFactory processType:" + qZoneProcessType);
        com.qzone.publish.business.process.base.a a16 = b.a(t16, qZoneProcessType, interfaceC0438a);
        if (a16 instanceof d) {
            i(((d) a16).s());
        }
        if (a16 != null) {
            h(a16, z16);
        }
        return a16;
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void c(com.qzone.publish.business.process.base.a aVar, Object obj, Object obj2) {
    }
}
