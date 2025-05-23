package com.tencent.mobileqq.guild.robot.driver.audio;

/* compiled from: P */
/* loaded from: classes14.dex */
class UpMicCacheObservable$1 implements Runnable {
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.setChanged();
        this.this$0.notifyObservers();
    }
}
