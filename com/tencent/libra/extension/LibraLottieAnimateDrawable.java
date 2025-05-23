package com.tencent.libra.extension;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.aekit.plugin.core.AIInput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r01.c;
import r01.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/libra/extension/LibraLottieAnimateDrawable;", "Lcom/airbnb/lottie/LottieDrawable;", "Lr01/c;", "", "loopCount", "", "setLoopCount", "getFrameCount", AIInput.KEY_FRAME, "i", "l", "Landroid/graphics/drawable/Drawable;", "getDrawable", "recycle", "Lr01/d;", "listener", "r", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "callback", "registerAnimationCallback", "", "unregisterAnimationCallback", "com/tencent/libra/extension/LibraLottieAnimateDrawable$animatorListener$1", "d", "Lcom/tencent/libra/extension/LibraLottieAnimateDrawable$animatorListener$1;", "animatorListener", "e", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "animatableCallback", "f", "Lr01/d;", "libraAnimationListener", "Landroid/os/Handler;", h.F, "Landroid/os/Handler;", "mUIHandler", "<init>", "()V", "libra-extension-lottie_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraLottieAnimateDrawable extends LottieDrawable implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LibraLottieAnimateDrawable$animatorListener$1 animatorListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Animatable2Compat.AnimationCallback animatableCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private d libraAnimationListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Handler mUIHandler;

    public LibraLottieAnimateDrawable() {
        LibraLottieAnimateDrawable$animatorListener$1 libraLottieAnimateDrawable$animatorListener$1 = new LibraLottieAnimateDrawable$animatorListener$1(this);
        this.animatorListener = libraLottieAnimateDrawable$animatorListener$1;
        this.mUIHandler = new Handler(Looper.getMainLooper());
        addAnimatorListener(libraLottieAnimateDrawable$animatorListener$1);
    }

    @Override // r01.c
    public /* synthetic */ void c(boolean z16) {
        r01.b.i(this, z16);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ void clearAnimationCallbacks() {
        r01.b.b(this);
    }

    @Override // r01.c
    public /* synthetic */ int getDuration() {
        return r01.b.d(this);
    }

    @Override // r01.c
    public int getFrameCount() {
        return getFrame();
    }

    @Override // r01.c
    public void i(int frame) {
        setFrame(frame);
    }

    @Override // r01.c
    public int l() {
        return (int) getMaxFrame();
    }

    @Override // r01.c
    public void r(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.libraAnimationListener = listener;
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NotNull Animatable2Compat.AnimationCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.animatableCallback = callback;
    }

    @Override // r01.c
    public void setLoopCount(int loopCount) {
        super.setRepeatCount(loopCount);
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NotNull Animatable2Compat.AnimationCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.animatableCallback = null;
        this.libraAnimationListener = null;
        removeAnimatorListener(this.animatorListener);
        return true;
    }

    @Override // r01.c
    @Nullable
    public Drawable getDrawable() {
        return this;
    }

    @Override // r01.c
    public void recycle() {
    }
}
