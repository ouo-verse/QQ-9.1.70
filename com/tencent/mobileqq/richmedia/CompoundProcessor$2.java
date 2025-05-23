package com.tencent.mobileqq.richmedia;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

/* loaded from: classes18.dex */
class CompoundProcessor$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f281315d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        QQToast.makeText(BaseApplicationImpl.sApplication, this.f281315d, 0).show(200);
    }
}
