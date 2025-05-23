package com.tencent.rtmp.video.a;

import android.media.projection.MediaProjection;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rtmp.video.BaseBridge;
import com.tencent.rtmp.video.VirtualDisplayListener;
import com.tencent.rtmp.video.a.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class k implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final f f368857a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaProjection f368858b;

    k(f fVar, MediaProjection mediaProjection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar, (Object) mediaProjection);
        } else {
            this.f368857a = fVar;
            this.f368858b = mediaProjection;
        }
    }

    public static Runnable a(f fVar, MediaProjection mediaProjection) {
        return new k(fVar, mediaProjection);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.f368857a;
        MediaProjection mediaProjection = this.f368858b;
        fVar.f368837f = false;
        if (mediaProjection == null) {
            HashMap hashMap = new HashMap(fVar.f368835d);
            fVar.f368835d.clear();
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                VirtualDisplayListener virtualDisplayListener = ((f.a) it.next()).f368845d;
                if (virtualDisplayListener != null) {
                    virtualDisplayListener.onStartFinish(false, true);
                }
            }
            f.d();
            return;
        }
        BaseBridge.printLog("VirtualDisplayManager", "Got session ".concat(String.valueOf(mediaProjection)));
        fVar.f368836e = mediaProjection;
        mediaProjection.registerCallback(fVar.f368840i, fVar.f368833b);
        fVar.b();
        f.b(fVar.f368836e);
        fVar.f368834c.a(fVar.f368839h, TimeUnit.SECONDS.toMillis(1L));
    }
}
