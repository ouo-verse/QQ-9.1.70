package c11;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r01.c;
import r01.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B%\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u001d\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0010\u0010\u0014B\u001d\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0010\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0019"}, d2 = {"Lc11/a;", "Lcom/tencent/image/ApngDrawable;", "Lr01/c;", "", "start", "stop", "", "isRunning", "", "loopCount", "setLoopCount", "Ljava/io/File;", "file", "Landroid/content/res/Resources;", "res", "cacheStaticFrame", "<init>", "(Ljava/io/File;Landroid/content/res/Resources;Z)V", "Lcom/tencent/image/ApngImage;", "apngImage", "(Lcom/tencent/image/ApngImage;Landroid/content/res/Resources;)V", "Lc11/a$a;", "apngState", "(Lc11/a$a;Landroid/content/res/Resources;)V", "a", "libra-extension-apng-lib_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a extends ApngDrawable implements c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lc11/a$a;", "Lcom/tencent/image/ApngDrawable$ApngState;", "Landroid/graphics/drawable/Drawable;", "newDrawable", "Landroid/content/res/Resources;", "res", "Lcom/tencent/image/ApngImage;", "apngImage", "<init>", "(Lcom/tencent/image/ApngImage;)V", "libra-extension-apng-lib_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: c11.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0160a extends ApngDrawable.ApngState {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0160a(@NotNull ApngImage apngImage) {
            super(apngImage);
            Intrinsics.checkNotNullParameter(apngImage, "apngImage");
        }

        @Override // com.tencent.image.ApngDrawable.ApngState, android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public Drawable newDrawable() {
            return new a(this, (Resources) null);
        }

        @Override // com.tencent.image.ApngDrawable.ApngState, android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public Drawable newDrawable(@Nullable Resources res) {
            return new a(this, res);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull File file, @Nullable Resources resources, boolean z16) {
        this(new ApngImage(file, z16), resources);
        Intrinsics.checkNotNullParameter(file, "file");
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
        ApngImage image = getImage();
        Intrinsics.checkNotNullExpressionValue(image, "image");
        return !image.getPause();
    }

    @Override // r01.c
    public /* synthetic */ int l() {
        return r01.b.e(this);
    }

    @Override // r01.c
    public /* synthetic */ void r(d dVar) {
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

    @Override // android.graphics.drawable.Animatable
    public void start() {
        resume();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        pauseIfNoReferences();
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return r01.b.k(this, animationCallback);
    }

    public /* synthetic */ a(File file, Resources resources, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, resources, (i3 & 4) != 0 ? false : z16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull ApngImage apngImage, @Nullable Resources resources) {
        this(new C0160a(apngImage), resources);
        Intrinsics.checkNotNullParameter(apngImage, "apngImage");
    }

    public a(@Nullable C0160a c0160a, @Nullable Resources resources) {
        super(c0160a, resources);
    }

    @Override // r01.c
    public void setLoopCount(int loopCount) {
    }
}
