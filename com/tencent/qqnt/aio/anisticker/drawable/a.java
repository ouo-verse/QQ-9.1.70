package com.tencent.qqnt.aio.anisticker.drawable;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/drawable/a;", "Lcom/tencent/qqnt/aio/anisticker/drawable/f;", "", "isRunning", "isAllow", "", "c", "", "repeatCount", h.F, AIInput.KEY_FRAME, "a", "Lcom/tencent/qqnt/aio/anisticker/drawable/g;", "callback", "g", "e", "d", "f", "Landroid/graphics/drawable/Drawable;", "getDrawable", "recycle", "start", "stop", "Lr01/c;", "Lr01/c;", "getLottieDrawable", "()Lr01/c;", "lottieDrawable", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "b", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "animationCallback", "<init>", "(Lr01/c;)V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final r01.c lottieDrawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animatable2Compat.AnimationCallback animationCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/anisticker/drawable/a$a", "Lr01/d;", "", "loopNumber", "", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.anisticker.drawable.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9448a implements r01.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f348831a;

        C9448a(g gVar) {
            this.f348831a = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        @Override // r01.d
        public void a(int loopNumber) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, loopNumber);
            } else {
                this.f348831a.a(loopNumber);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/anisticker/drawable/a$b", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "onAnimationEnd", "onAnimationStart", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends Animatable2Compat.AnimationCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f348832a;

        b(g gVar) {
            this.f348832a = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(@Nullable Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            } else {
                this.f348832a.onStop(true);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationStart(@Nullable Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
            } else {
                this.f348832a.onStart();
            }
        }
    }

    public a(@Nullable r01.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        } else {
            this.lottieDrawable = cVar;
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void a(int frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, frame);
            return;
        }
        r01.c cVar = this.lottieDrawable;
        if (cVar != null) {
            cVar.i(frame);
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void c(boolean isAllow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isAllow);
            return;
        }
        r01.c cVar = this.lottieDrawable;
        if (cVar != null) {
            cVar.c(isAllow);
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        r01.c cVar = this.lottieDrawable;
        if (cVar == null) {
            return 0;
        }
        return cVar.getFrameCount();
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void e(@Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
            return;
        }
        Animatable2Compat.AnimationCallback animationCallback = this.animationCallback;
        if (animationCallback != null) {
            r01.c cVar = this.lottieDrawable;
            if (cVar != null) {
                Intrinsics.checkNotNull(animationCallback);
                cVar.unregisterAnimationCallback(animationCallback);
            }
            this.animationCallback = null;
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        r01.c cVar = this.lottieDrawable;
        if (cVar == null) {
            return 0;
        }
        return cVar.l();
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void g(@Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
            return;
        }
        if (callback == null) {
            return;
        }
        r01.c cVar = this.lottieDrawable;
        if (cVar != null) {
            cVar.r(new C9448a(callback));
        }
        b bVar = new b(callback);
        this.animationCallback = bVar;
        r01.c cVar2 = this.lottieDrawable;
        if (cVar2 != null) {
            Intrinsics.checkNotNull(bVar);
            cVar2.registerAnimationCallback(bVar);
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    @Nullable
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Drawable) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        r01.c cVar = this.lottieDrawable;
        if (cVar != null) {
            return cVar.getDrawable();
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void h(int repeatCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, repeatCount);
            return;
        }
        r01.c cVar = this.lottieDrawable;
        if (cVar != null) {
            cVar.setLoopCount(repeatCount);
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        r01.c cVar = this.lottieDrawable;
        if (cVar == null || !cVar.isRunning()) {
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
        r01.c cVar = this.lottieDrawable;
        if (cVar != null) {
            cVar.recycle();
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        r01.c cVar = this.lottieDrawable;
        if (cVar != null) {
            cVar.start();
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.drawable.f
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        r01.c cVar = this.lottieDrawable;
        if (cVar != null) {
            cVar.stop();
        }
    }
}
