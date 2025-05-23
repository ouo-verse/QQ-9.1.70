package com.tencent.aelight.camera.aebase;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.service.PeakJceServiceBase;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends PeakJceServiceBase {

    /* renamed from: f, reason: collision with root package name */
    PeakAppInterface f66026f;

    public d(PeakAppInterface peakAppInterface) {
        this.f66026f = peakAppInterface;
    }

    @Override // com.tencent.mobileqq.service.PeakJceServiceBase
    public AppInterface b() {
        return this.f66026f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.service.PeakJceServiceBase
    public synchronized void g() {
        super.g();
        com.tencent.aelight.camera.ae.config.c cVar = new com.tencent.aelight.camera.ae.config.c();
        com.tencent.mobileqq.service.qzone.d dVar = new com.tencent.mobileqq.service.qzone.d();
        a(cVar);
        a(dVar);
        super.j();
    }

    public void k(ToServiceMsg toServiceMsg) {
        d(toServiceMsg, com.tencent.mobileqq.servlet.b.class);
    }

    public void l(boolean z16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        super.e(z16, toServiceMsg, fromServiceMsg, null);
    }
}
