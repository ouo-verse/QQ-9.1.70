package com.tencent.qqnt.aio.anisticker.drawable;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.anisticker.drawable.e;
import com.tencent.rlottie.AXrLottieDrawable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/drawable/e;", "Lcom/tencent/qqnt/aio/anisticker/drawable/f;", "", "isRunning", "isAllow", "", "c", "", "repeatCount", h.F, AIInput.KEY_FRAME, "a", "Lcom/tencent/qqnt/aio/anisticker/drawable/g;", "callback", "g", "e", "d", "f", "Landroid/graphics/drawable/Drawable;", "getDrawable", "recycle", "start", "stop", "Lcom/tencent/rlottie/AXrLottieDrawable;", "Lcom/tencent/rlottie/AXrLottieDrawable;", "getLottieDrawable", "()Lcom/tencent/rlottie/AXrLottieDrawable;", "lottieDrawable", "<init>", "(Lcom/tencent/rlottie/AXrLottieDrawable;)V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AXrLottieDrawable lottieDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/aio/anisticker/drawable/e$a", "Lcom/tencent/rlottie/AXrLottieDrawable$c;", "Lcom/tencent/rlottie/AXrLottieDrawable;", "p0", "", "p1", "", "onFrameChanged", "", "onRepeat", "endAnimation", DKHippyEvent.EVENT_STOP, "onStart", "onRecycle", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements AXrLottieDrawable.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f348839a;

        a(g gVar) {
            this.f348839a = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(g gVar, int i3) {
            if (gVar != null) {
                gVar.a(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(g gVar) {
            if (gVar != null) {
                gVar.onStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(g gVar, boolean z16) {
            if (gVar != null) {
                gVar.onStop(z16);
            }
        }

        @Override // com.tencent.rlottie.AXrLottieDrawable.c
        public void onFrameChanged(@Nullable AXrLottieDrawable p06, int p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06, p16);
            }
        }

        @Override // com.tencent.rlottie.AXrLottieDrawable.c
        public void onRecycle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.rlottie.AXrLottieDrawable.c
        public void onRepeat(final int p06, boolean p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(p06), Boolean.valueOf(p16));
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final g gVar = this.f348839a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.drawable.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.d(g.this, p06);
                }
            });
        }

        @Override // com.tencent.rlottie.AXrLottieDrawable.c
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final g gVar = this.f348839a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.drawable.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.e(g.this);
                }
            });
        }

        @Override // com.tencent.rlottie.AXrLottieDrawable.c
        public void onStop(final boolean endAnimation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, endAnimation);
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final g gVar = this.f348839a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.drawable.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.f(g.this, endAnimation);
                }
            });
        }
    }

    public e(@Nullable AXrLottieDrawable aXrLottieDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aXrLottieDrawable);
        } else {
            this.lottieDrawable = aXrLottieDrawable;
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void a(int frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, frame);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.s0(frame);
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void c(boolean isAllow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isAllow);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.c(isAllow);
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable == null) {
            return 0;
        }
        return aXrLottieDrawable.X();
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void e(@Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.y0(null);
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable == null) {
            return 0;
        }
        return aXrLottieDrawable.Z();
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void g(@Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
            return;
        }
        if (callback == null) {
            AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
            if (aXrLottieDrawable != null) {
                aXrLottieDrawable.y0(null);
                return;
            }
            return;
        }
        AXrLottieDrawable aXrLottieDrawable2 = this.lottieDrawable;
        if (aXrLottieDrawable2 != null) {
            aXrLottieDrawable2.y0(new a(callback));
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    @Nullable
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Drawable) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.lottieDrawable;
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void h(int repeatCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, repeatCount);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.p0(repeatCount);
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable == null || !aXrLottieDrawable.isRunning()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void recycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.recycle();
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.start();
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.stop();
        }
    }
}
