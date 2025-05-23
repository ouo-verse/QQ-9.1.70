package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
class VideoAnimationUtils$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ WeakReference f301988d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f301989e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ FrameSprite.a f301990f;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        SpriteVideoView spriteVideoView = (SpriteVideoView) this.f301988d.get();
        if (spriteVideoView != null) {
            spriteVideoView.x(this.f301989e, this.f301990f);
        }
    }
}
