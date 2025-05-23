package com.tencent.qqnt.emotion.pic.libra;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b extends Drawable implements com.tencent.qqnt.emotion.pic.libra.a, r01.c {
    private static final byte[] G = {-119, 80, 78, 71, 13, 10, 26, 10};
    private int C;
    private Rect D;
    private boolean E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f356321d;

    /* renamed from: e, reason: collision with root package name */
    boolean f356322e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f356323f;

    /* renamed from: h, reason: collision with root package name */
    private a f356324h;

    /* renamed from: i, reason: collision with root package name */
    private int f356325i;

    /* renamed from: m, reason: collision with root package name */
    private int f356326m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        ApngImage f356327a;

        /* renamed from: b, reason: collision with root package name */
        int f356328b;

        /* renamed from: c, reason: collision with root package name */
        int f356329c = 119;

        /* renamed from: d, reason: collision with root package name */
        int f356330d = 160;

        /* renamed from: e, reason: collision with root package name */
        Paint f356331e = new Paint(6);

        public a(ApngImage apngImage) {
            this.f356327a = apngImage;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f356328b;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new b(this, (Resources) null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new b(this, resources);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.emotion.pic.libra.b$b, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC9615b {
        void onPlayRepeat(int i3);
    }

    public b(File file, Resources resources) throws IOException {
        this(file, resources, false);
    }

    private void a() {
        this.f356326m = this.f356324h.f356327a.q(this.f356325i);
        this.C = this.f356324h.f356327a.p(this.f356325i);
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
    public void draw(Canvas canvas) {
        Rect rect = null;
        if (this.f356323f) {
            if (this.E) {
                ApngImage apngImage = this.f356324h.f356327a;
                int i3 = apngImage.f356303d;
                int i16 = apngImage.f356305e;
                if (i16 > 0 && i3 > 0) {
                    Rect bounds = getBounds();
                    int height = bounds.height();
                    int width = bounds.width();
                    if (width == 0) {
                        this.D = null;
                    } else {
                        if (this.F < height) {
                            this.F = height;
                        }
                        int i17 = this.F;
                        if (i17 / width >= i16 / i3) {
                            int i18 = (width * i16) / i17;
                            int i19 = (int) ((i3 - i18) * 0.5d);
                            if (i17 > bounds.height()) {
                                i16 = (i16 * height) / this.F;
                            }
                            this.D = new Rect(i19, 0, i18 + i19, i16);
                        } else {
                            int i26 = (int) ((i16 - ((i17 * i3) / width)) * 0.5d);
                            this.D = new Rect(0, i26, i3, ((height * i3) / width) + i26);
                        }
                    }
                } else {
                    this.D = null;
                }
            }
            Gravity.apply(this.f356324h.f356329c, this.f356326m, this.C, getBounds(), this.f356321d);
            this.f356323f = false;
        }
        a aVar = this.f356324h;
        ApngImage apngImage2 = aVar.f356327a;
        if (this.E) {
            rect = this.D;
        }
        apngImage2.j(canvas, rect, this.f356321d, aVar.f356331e, this.f356322e);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f356324h;
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

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f356326m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // r01.c
    public /* synthetic */ void i(int i3) {
        r01.b.j(this, i3);
    }

    @Override // android.graphics.drawable.Drawable, com.tencent.qqnt.emotion.pic.libra.a
    public void invalidateSelf() {
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return !this.f356324h.f356327a.I;
    }

    @Override // r01.c
    public /* synthetic */ int l() {
        return r01.b.e(this);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f356323f = true;
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

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f356324h.f356331e.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f356324h.f356331e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.f356324h.f356331e.setDither(z16);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.f356324h.f356331e.setFilterBitmap(z16);
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return r01.b.k(this, animationCallback);
    }

    public b(File file, Resources resources, boolean z16) throws IOException {
        this(new ApngImage(file, z16), resources);
    }

    public b(ApngImage apngImage, Resources resources) {
        this(new a(apngImage), resources);
        this.f356324h.f356330d = this.f356325i;
    }

    public b(a aVar, Resources resources) {
        this.f356321d = new Rect();
        this.f356322e = true;
        this.f356323f = true;
        this.f356325i = 160;
        this.f356324h = aVar;
        aVar.f356327a.f(this);
        ApngImage apngImage = aVar.f356327a;
        if (apngImage.D) {
            apngImage.H = 0;
        }
        if (resources != null) {
            this.f356325i = resources.getDisplayMetrics().densityDpi;
        } else {
            this.f356325i = aVar.f356330d;
        }
        a();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    @Override // r01.c
    public void setLoopCount(int i3) {
    }
}
