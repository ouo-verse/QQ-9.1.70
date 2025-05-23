package com.tencent.rtmp.video.a;

import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rtmp.video.BaseBridge;
import com.tencent.rtmp.video.VirtualDisplayWrapper;
import com.tencent.rtmp.video.a.f;

/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class j implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final f f368855a;

    /* renamed from: b, reason: collision with root package name */
    private final Surface f368856b;

    j(f fVar, Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar, (Object) surface);
        } else {
            this.f368855a = fVar;
            this.f368856b = surface;
        }
    }

    public static Runnable a(f fVar, Surface surface) {
        return new j(fVar, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VirtualDisplayWrapper virtualDisplayWrapper;
        f fVar = this.f368855a;
        Surface surface = this.f368856b;
        if (surface != null) {
            f.a remove = fVar.f368835d.remove(surface);
            if (remove != null && (virtualDisplayWrapper = remove.f368846e) != null) {
                virtualDisplayWrapper.release();
                BaseBridge.printLog("VirtualDisplayManager", "VirtualDisplay released, " + remove.f368846e);
            }
            fVar.c();
        }
    }
}
