package com.tencent.biz.TroopRedpoint;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes2.dex */
class TroopRedTouchHandler$1$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f78328d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Bundle f78329e;

    @Override // java.lang.Runnable
    public void run() {
        Bundle bundle;
        if (QLog.isColorLevel()) {
            QLog.d("TroopRedTouchHandler", 2, "getRedPointInfo onReceive :" + this.f78328d);
        }
        if (this.f78328d && (bundle = this.f78329e) != null) {
            bundle.getByteArray("data");
            throw null;
        }
    }
}
