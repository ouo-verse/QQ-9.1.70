package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes20.dex */
class QVipUtils$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f307237d;

    @Override // java.lang.Runnable
    public void run() {
        QQToast.makeText(BaseApplication.getContext(), 1, this.f307237d, 0).show();
    }
}
