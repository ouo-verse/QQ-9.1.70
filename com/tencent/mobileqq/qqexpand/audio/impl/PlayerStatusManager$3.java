package com.tencent.mobileqq.qqexpand.audio.impl;

/* loaded from: classes35.dex */
class PlayerStatusManager$3 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f263443d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        if (a.a(null) != null) {
            a.a(null).onAudioFinishPlay(this.f263443d);
        }
    }
}
