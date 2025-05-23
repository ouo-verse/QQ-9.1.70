package com.tencent.mobileqq.search.presenter;

import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends qn2.f {

    /* renamed from: e, reason: collision with root package name */
    private f f283652e;

    /* renamed from: f, reason: collision with root package name */
    private xn2.c f283653f;

    /* renamed from: h, reason: collision with root package name */
    private b f283654h;

    public h(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
        this.f283652e = new f(iFaceDecoder);
        this.f283653f = new xn2.c(iFaceDecoder);
        this.f283654h = new b(iFaceDecoder, 268435456);
    }

    @Override // qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        boolean z16 = yVar instanceof com.tencent.mobileqq.search.model.k;
        if (!z16 && !(yVar instanceof lo2.c)) {
            QLog.e("MostUsedResultPresenter", 2, "unresolved model");
            return;
        }
        if (z16) {
            com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) yVar;
            int a16 = com.tencent.mobileqq.search.util.m.a(kVar.H());
            if (a16 == 2) {
                this.f283652e.a(yVar, cVar);
                return;
            }
            if (a16 == 1) {
                this.f283653f.a(yVar, cVar);
                return;
            }
            QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + kVar.H());
            return;
        }
        if (yVar instanceof lo2.c) {
            lo2.c cVar2 = (lo2.c) yVar;
            if (com.tencent.mobileqq.search.util.m.a(cVar2.L()) == 3) {
                this.f283654h.a(yVar, cVar);
                return;
            }
            QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + cVar2.L());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // qn2.f
    public void h(y yVar, sn2.c cVar) {
        super.h(yVar, cVar);
    }
}
