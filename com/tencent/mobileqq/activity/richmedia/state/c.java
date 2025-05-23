package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends e {
    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void a() {
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (QLog.isColorLevel()) {
            QLog.d("RMVideoIdleState", 2, "[@] realDeleteVideoSegment ...");
        }
        u16.Q.F(100);
        u16.f(3);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void b() {
        RMVideoStateMgr.u().Q.y();
        if (QLog.isColorLevel()) {
            QLog.d("RMVideoIdleState", 2, "[@] initState end");
        }
    }
}
