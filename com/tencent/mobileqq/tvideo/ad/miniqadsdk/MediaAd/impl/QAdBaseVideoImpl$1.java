package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl;

import android.view.ViewGroup;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
class QAdBaseVideoImpl$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ViewGroup f303627d;
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.this$0) {
            c cVar = this.this$0;
            if (cVar.f303632h == null) {
                return;
            }
            if (cVar.C != 0 && this.this$0.C != 7) {
                this.this$0.f303630e.K(this.f303627d);
                n.e(c.M, "VideoController atachTo QAdPlayerManager");
                c cVar2 = this.this$0;
                cVar2.f303632h.y(cVar2.v());
                return;
            }
            n.e(c.M, "updatePlayerView return status = " + this.this$0.C);
        }
    }
}
