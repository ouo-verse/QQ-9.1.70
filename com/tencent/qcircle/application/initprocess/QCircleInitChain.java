package com.tencent.qcircle.application.initprocess;

import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QCircleInitChain {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f342427a = new ArrayList();

    public QCircleInitChain a() {
        this.f342427a.add(new d());
        this.f342427a.add(new QCircleInitUploadProcess());
        this.f342427a.add(new c());
        return this;
    }

    public void b() {
        for (final a aVar : this.f342427a) {
            if (aVar.a()) {
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.qcircle.application.initprocess.QCircleInitChain.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.process();
                    }
                });
            } else {
                aVar.process();
            }
        }
    }
}
