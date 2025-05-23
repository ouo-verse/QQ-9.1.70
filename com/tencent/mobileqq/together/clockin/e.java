package com.tencent.mobileqq.together.clockin;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private a f293369d;

    public e(a aVar) {
        this.f293369d = aVar;
    }

    public void b(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ClockView", 2, "notifyChanged : nEventId = " + i3);
        }
        a aVar = this.f293369d;
        if (aVar != null) {
            aVar.b(i3);
        }
    }
}
