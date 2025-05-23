package com.tencent.biz.subscribe.videoplayer;

import android.view.TextureView;
import com.tencent.biz.subscribe.videoplayer.a;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
class VideoFrameCheckHelper$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ WeakReference f96301d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ WeakReference f96302e;
    final /* synthetic */ a this$0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        final boolean z16;
        QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame");
        if (System.currentTimeMillis() - a.c(null) >= 4000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f96301d.get() != 0 && this.f96302e.get() != 0) {
            if (a.e(null, (TextureView) this.f96302e.get()) && !z16) {
                a.d(null, (TextureView) this.f96302e.get(), (a.InterfaceC0973a) this.f96301d.get());
                QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame again");
                return;
            }
            a.b(null).post(new Runnable() { // from class: com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper$1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoFrameCheckHelper$1.this.f96301d.get() != 0) {
                        ((a.InterfaceC0973a) VideoFrameCheckHelper$1.this.f96301d.get()).a(z16);
                    }
                }
            });
            a.a(null).removeCallbacksAndMessages(null);
            QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame stop isReachMaxTime:" + z16);
            return;
        }
        QLog.d("VideoFrameCheckHelper", 1, "reference recycled");
    }
}
