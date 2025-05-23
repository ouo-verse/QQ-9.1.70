package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class d implements BusinessObserver {
    public abstract void a(com.tencent.mobileqq.ar.arengine.b bVar);

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("ARLBSObserver", 2, "type=" + i3 + ", isSuccess=" + z16);
        }
        if (i3 == 1) {
            try {
                a((com.tencent.mobileqq.ar.arengine.b) obj);
            } catch (Exception unused) {
                a(new com.tencent.mobileqq.ar.arengine.b());
            }
        }
    }
}
