package com.tencent.qqnt.emotion.pic.libra;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.tencent.image.GifDrawable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/c;", "Lcom/tencent/image/GifDrawable;", "Lr01/c;", "Lr01/e;", "", "start", "stop", "", "isRunning", "", "loopCount", "setLoopCount", "getByteSize", "Ljava/io/File;", "f", "Landroid/content/res/Resources;", "res", "cacheStaticFrame", "<init>", "(Ljava/io/File;Landroid/content/res/Resources;Z)V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c extends GifDrawable implements r01.c, r01.e {
    public /* synthetic */ c(File file, Resources resources, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, resources, (i3 & 4) != 0 ? false : z16);
    }

    @Override // r01.c
    public /* synthetic */ void c(boolean z16) {
        r01.b.i(this, z16);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ void clearAnimationCallbacks() {
        r01.b.b(this);
    }

    @Override // com.tencent.image.GifDrawable, r01.e
    public int getByteSize() {
        return super.getByteSize();
    }

    @Override // r01.c
    public /* synthetic */ Drawable getDrawable() {
        return r01.b.c(this);
    }

    @Override // r01.c
    public /* synthetic */ int getDuration() {
        return r01.b.d(this);
    }

    @Override // r01.c
    public /* synthetic */ int getFrameCount() {
        return r01.b.f(this);
    }

    @Override // r01.c
    public /* synthetic */ void i(int i3) {
        r01.b.j(this, i3);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return useAnimation();
    }

    @Override // r01.c
    public /* synthetic */ int l() {
        return r01.b.e(this);
    }

    @Override // r01.c
    public /* synthetic */ void r(r01.d dVar) {
        r01.b.a(this, dVar);
    }

    @Override // r01.c
    public /* synthetic */ void recycle() {
        r01.b.g(this);
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        r01.b.h(this, animationCallback);
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return r01.b.k(this, animationCallback);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public c(@NotNull File f16, @NotNull Resources res, boolean z16) {
        super(f16, res, z16);
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(res, "res");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    @Override // r01.c
    public void setLoopCount(int loopCount) {
    }
}
