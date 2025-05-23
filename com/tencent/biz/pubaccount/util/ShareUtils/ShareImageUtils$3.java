package com.tencent.biz.pubaccount.util.ShareUtils;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes4.dex */
class ShareImageUtils$3 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f80192d;

    @Override // java.lang.Runnable
    public void run() {
        QQToast.makeText(BaseApplication.getContext(), this.f80192d, 0).show();
    }
}
