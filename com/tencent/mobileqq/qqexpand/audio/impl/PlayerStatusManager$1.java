package com.tencent.mobileqq.qqexpand.audio.impl;

/* loaded from: classes35.dex */
class PlayerStatusManager$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f263441d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        if (a.a(null) != null) {
            a.a(null).onAudioStartPlay(this.f263441d);
        }
    }
}
