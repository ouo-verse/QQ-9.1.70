package com.tencent.now.app.common.widget.apng;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends Drawable implements com.tencent.now.app.common.widget.apng.a {
    private static final byte[] D = {-119, 80, 78, 71, 13, 10, 26, 10};
    private final Rect C;

    /* renamed from: d, reason: collision with root package name */
    private boolean f337969d;

    /* renamed from: e, reason: collision with root package name */
    private a f337970e;

    /* renamed from: f, reason: collision with root package name */
    private int f337971f;

    /* renamed from: h, reason: collision with root package name */
    private int f337972h;

    /* renamed from: i, reason: collision with root package name */
    private int f337973i;

    /* renamed from: m, reason: collision with root package name */
    boolean f337974m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        ApngImage f337975a;

        /* renamed from: b, reason: collision with root package name */
        int f337976b;

        /* renamed from: c, reason: collision with root package name */
        int f337977c = 119;

        /* renamed from: d, reason: collision with root package name */
        int f337978d = 160;

        /* renamed from: e, reason: collision with root package name */
        Paint f337979e = new Paint(6);

        public a(ApngImage apngImage) {
            this.f337975a = apngImage;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f337976b;
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

    public b(File file, Resources resources) throws IOException {
        this(file, resources, false);
    }

    private void a() {
        this.f337972h = this.f337970e.f337975a.v(this.f337971f);
        this.f337973i = this.f337970e.f337975a.u(this.f337971f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f337969d) {
            Gravity.apply(this.f337970e.f337977c, this.f337972h, this.f337973i, getBounds(), this.C);
            this.f337969d = false;
        }
        a aVar = this.f337970e;
        aVar.f337975a.n(canvas, this.C, aVar.f337979e, this.f337974m);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        this.f337970e.f337975a.R(this);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f337970e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f337973i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f337972h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable, com.tencent.now.app.common.widget.apng.a
    public void invalidateSelf() {
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f337969d = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f337970e.f337979e.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f337970e.f337979e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.f337970e.f337979e.setDither(z16);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.f337970e.f337979e.setFilterBitmap(z16);
    }

    public b(File file, Resources resources, boolean z16) throws IOException {
        this(new ApngImage(file, z16), resources);
    }

    public b(ApngImage apngImage, Resources resources) {
        this(new a(apngImage), resources);
        this.f337970e.f337978d = this.f337971f;
    }

    public b(a aVar, Resources resources) {
        this.f337971f = 160;
        this.f337974m = true;
        this.C = new Rect();
        this.f337970e = aVar;
        aVar.f337975a.f(this);
        if (resources != null) {
            this.f337971f = resources.getDisplayMetrics().densityDpi;
        } else {
            this.f337971f = aVar.f337978d;
        }
        a();
    }
}
