package com.tencent.biz.qqcircle.helpers;

import com.tencent.biz.qqcircle.manager.diffres.beans.QFSMessageResPackage;
import com.tencent.qphone.base.util.QLog;
import fa0.d;

/* compiled from: P */
/* loaded from: classes4.dex */
public class r implements d.a {

    /* renamed from: e, reason: collision with root package name */
    private static volatile r f84661e;

    /* renamed from: d, reason: collision with root package name */
    private final fa0.d<QFSMessageResPackage> f84662d = new fa0.d<>(QFSMessageResPackage.getDefaultResBean());

    r() {
    }

    public static r a() {
        if (f84661e == null) {
            synchronized (r.class) {
                if (f84661e == null) {
                    f84661e = new r();
                }
            }
        }
        return f84661e;
    }

    @Override // fa0.d.a
    public void A2() {
        QLog.d("QFSMessageResLoadHelper", 1, "onPreloadSucceed");
    }

    public void b() {
        if (!this.f84662d.r()) {
            QLog.d("QFSMessageResLoadHelper", 1, "preLoadRes");
            this.f84662d.x(this);
            this.f84662d.v();
        }
    }

    @Override // fa0.d.a
    public void h4() {
        QLog.e("QFSMessageResLoadHelper", 1, "onPreloadError");
    }
}
