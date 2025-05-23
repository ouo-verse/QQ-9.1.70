package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
class ExceptionTracker$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f306949d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Exception f306950e;

    @Override // java.lang.Runnable
    public void run() {
        if (QLog.isColorLevel()) {
            QLog.e(this.f306949d, 2, "ExceptinTracker", this.f306950e);
        }
        throw new IllegalArgumentException(this.f306950e);
    }
}
