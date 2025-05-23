package com.tencent.libra.extension;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.rlottie.AXrLottieDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r01.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\"\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u00103\u001a\u0004\u0018\u000100\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0019\u00103\u001a\u0004\u0018\u0001008\u0006\u00a2\u0006\f\n\u0004\b\u0017\u00101\u001a\u0004\b&\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/libra/extension/LibraRLottieAnimateDrawable;", "Landroid/graphics/drawable/Drawable;", "Lr01/c;", "", "start", "stop", "", "isRunning", "", "loopCount", "setLoopCount", "getDuration", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "getFrameCount", AIInput.KEY_FRAME, "i", "l", "getDrawable", "recycle", "Lr01/d;", "listener", "r", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "callback", "registerAnimationCallback", "unregisterAnimationCallback", "com/tencent/libra/extension/LibraRLottieAnimateDrawable$frameChangedListener$1", "d", "Lcom/tencent/libra/extension/LibraRLottieAnimateDrawable$frameChangedListener$1;", "frameChangedListener", "e", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "animatableCallback", "f", "Lr01/d;", "libraAnimationListener", "Landroid/os/Handler;", h.F, "Landroid/os/Handler;", "mUIHandler", "Lcom/tencent/rlottie/AXrLottieDrawable;", "Lcom/tencent/rlottie/AXrLottieDrawable;", "()Lcom/tencent/rlottie/AXrLottieDrawable;", "drawable", "<init>", "(Lcom/tencent/rlottie/AXrLottieDrawable;)V", "libra-extension-rlottie_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraRLottieAnimateDrawable extends Drawable implements r01.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LibraRLottieAnimateDrawable$frameChangedListener$1 frameChangedListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Animatable2Compat.AnimationCallback animatableCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private d libraAnimationListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Handler mUIHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AXrLottieDrawable drawable;

    public LibraRLottieAnimateDrawable(@Nullable AXrLottieDrawable aXrLottieDrawable) {
        this.drawable = aXrLottieDrawable;
        LibraRLottieAnimateDrawable$frameChangedListener$1 libraRLottieAnimateDrawable$frameChangedListener$1 = new LibraRLottieAnimateDrawable$frameChangedListener$1(this);
        this.frameChangedListener = libraRLottieAnimateDrawable$frameChangedListener$1;
        this.mUIHandler = new Handler(Looper.getMainLooper());
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.y0(libraRLottieAnimateDrawable$frameChangedListener$1);
        }
    }

    @Override // r01.c
    public /* synthetic */ void c(boolean z16) {
        r01.b.i(this, z16);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ void clearAnimationCallbacks() {
        r01.b.b(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.draw(canvas);
        }
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final AXrLottieDrawable getDrawable() {
        return this.drawable;
    }

    @Override // r01.c
    @Nullable
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // r01.c
    public int getDuration() {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable == null) {
            return 0;
        }
        return (int) aXrLottieDrawable.Y();
    }

    @Override // r01.c
    public int getFrameCount() {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable == null) {
            return 0;
        }
        return aXrLottieDrawable.X();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable == null) {
            return -2;
        }
        return aXrLottieDrawable.getOpacity();
    }

    @Override // r01.c
    public void i(int frame) {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.s0(frame);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable == null) {
            return false;
        }
        return aXrLottieDrawable.isRunning();
    }

    @Override // r01.c
    public int l() {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable == null) {
            return 0;
        }
        return aXrLottieDrawable.Z();
    }

    @Override // r01.c
    public void r(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.libraAnimationListener = listener;
    }

    @Override // r01.c
    public void recycle() {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.recycle();
        }
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NotNull Animatable2Compat.AnimationCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.animatableCallback = callback;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.setColorFilter(colorFilter);
        }
    }

    @Override // r01.c
    public void setLoopCount(int loopCount) {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.p0(loopCount);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.stop();
        }
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NotNull Animatable2Compat.AnimationCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.animatableCallback = null;
        this.libraAnimationListener = null;
        AXrLottieDrawable aXrLottieDrawable = this.drawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.y0(null);
            return true;
        }
        return true;
    }
}
