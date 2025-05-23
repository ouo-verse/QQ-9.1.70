package com.tencent.mobileqq.onlinestatus.location;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
class LocationHandler$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f255915d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        if (QLog.isColorLevel()) {
            QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked. call over time runnable");
        }
        if (this.f255915d) {
            QQToast.makeText(MobileQQ.sMobileQQ, "\u4f4d\u7f6e\u83b7\u53d6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
        }
    }
}
