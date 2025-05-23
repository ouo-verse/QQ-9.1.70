package com.qzone.common.account;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager;

/* compiled from: P */
/* loaded from: classes39.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ QzoneFakeFeedLogicManager f44899d;

    public /* synthetic */ c(QzoneFakeFeedLogicManager qzoneFakeFeedLogicManager) {
        this.f44899d = qzoneFakeFeedLogicManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44899d.restoreDbFakeFeedList();
    }
}
