package com.tencent.rtmp.video.a;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rtmp.video.BaseBridge;
import com.tencent.rtmp.video.VirtualDisplayListener;
import com.tencent.rtmp.video.a.f;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class i implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final f f368849a;

    /* renamed from: b, reason: collision with root package name */
    private final Surface f368850b;

    /* renamed from: c, reason: collision with root package name */
    private final int f368851c;

    /* renamed from: d, reason: collision with root package name */
    private final int f368852d;

    /* renamed from: e, reason: collision with root package name */
    private final MediaProjection f368853e;

    /* renamed from: f, reason: collision with root package name */
    private final VirtualDisplayListener f368854f;

    i(f fVar, Surface surface, int i3, int i16, MediaProjection mediaProjection, VirtualDisplayListener virtualDisplayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fVar, surface, Integer.valueOf(i3), Integer.valueOf(i16), mediaProjection, virtualDisplayListener);
            return;
        }
        this.f368849a = fVar;
        this.f368850b = surface;
        this.f368851c = i3;
        this.f368852d = i16;
        this.f368853e = mediaProjection;
        this.f368854f = virtualDisplayListener;
    }

    public static Runnable a(f fVar, Surface surface, int i3, int i16, MediaProjection mediaProjection, VirtualDisplayListener virtualDisplayListener) {
        return new i(fVar, surface, i3, i16, mediaProjection, virtualDisplayListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.f368849a;
        Surface surface = this.f368850b;
        int i3 = this.f368851c;
        int i16 = this.f368852d;
        MediaProjection mediaProjection = this.f368853e;
        VirtualDisplayListener virtualDisplayListener = this.f368854f;
        if (surface == null) {
            BaseBridge.printLog("VirtualDisplayManager", "surface is null!");
            virtualDisplayListener.onStartFinish(false, false);
            return;
        }
        f.a aVar = new f.a((byte) 0);
        aVar.f368842a = surface;
        aVar.f368843b = i3;
        aVar.f368844c = i16;
        aVar.f368845d = virtualDisplayListener;
        aVar.f368846e = null;
        fVar.f368835d.put(surface, aVar);
        fVar.f368834c.c(fVar.f368839h);
        MediaProjection mediaProjection2 = fVar.f368836e;
        if (mediaProjection2 == null && mediaProjection == null) {
            if (!fVar.f368837f) {
                fVar.f368837f = true;
                f.a();
                return;
            } else {
                fVar.f368834c.c(fVar.f368838g);
                fVar.f368834c.a(fVar.f368838g, TimeUnit.SECONDS.toMillis(1L));
                return;
            }
        }
        if (mediaProjection != null && mediaProjection2 != mediaProjection) {
            BaseBridge.printLog("VirtualDisplayManager", "start capture with media projection from user:".concat(String.valueOf(mediaProjection)));
            fVar.a(mediaProjection);
        } else {
            fVar.b();
        }
    }
}
