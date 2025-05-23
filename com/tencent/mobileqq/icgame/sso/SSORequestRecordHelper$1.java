package com.tencent.mobileqq.icgame.sso;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
class SSORequestRecordHelper$1 implements Runnable {
    final /* synthetic */ l this$0;

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        this.this$0.c();
        concurrentHashMap = this.this$0.f237792b;
        concurrentHashMap.clear();
        this.this$0.f237791a = false;
    }
}
