package com.qzone.publish.business.protocol;

import com.qzone.publish.business.process.QZoneMediaDealWithManager;
import com.qzone.publish.business.process.base.a;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a implements a.InterfaceC0438a {

    /* renamed from: a, reason: collision with root package name */
    private final List<com.qzone.publish.business.process.base.a> f51077a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f51078b = 0;

    /* renamed from: c, reason: collision with root package name */
    private com.qzone.publish.business.process.base.a f51079c;

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void a(com.qzone.publish.business.process.base.a aVar, Object obj, Object obj2, float f16) {
        this.f51079c = aVar;
        QZLog.d("QZoneMediaProcessStatusWrapper", 4, "onProcessIng " + f16);
    }

    public synchronized void g(com.qzone.publish.business.process.base.a aVar) {
        if (aVar == null) {
            return;
        }
        QZLog.d("QZoneMediaProcessStatusWrapper", 1, "addProcess " + aVar.toString());
        this.f51077a.add(aVar);
        aVar.a(this);
    }

    public com.qzone.publish.business.process.base.a i() {
        return this.f51079c;
    }

    public int j() {
        return this.f51078b;
    }

    public void h() {
        QZLog.d("QZoneMediaProcessStatusWrapper", 1, "cancel ");
        QZoneMediaDealWithManager.o().j(this.f51077a);
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void c(com.qzone.publish.business.process.base.a aVar, Object obj, Object obj2) {
        if (aVar == null) {
            return;
        }
        this.f51079c = aVar;
        QZLog.d("QZoneMediaProcessStatusWrapper", 1, "onProcessStart " + aVar.toString());
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void d(com.qzone.publish.business.process.base.a aVar, Object obj, Object obj2) {
        if (aVar == null) {
            return;
        }
        this.f51079c = null;
        this.f51078b++;
        QZLog.d("QZoneMediaProcessStatusWrapper", 1, "onProcessSucceed " + aVar.toString());
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void b(com.qzone.publish.business.process.base.a aVar, Object obj) {
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void e(com.qzone.publish.business.process.base.a aVar, Object obj) {
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    public void f(com.qzone.publish.business.process.base.a aVar, Object obj, int i3, String str) {
    }
}
