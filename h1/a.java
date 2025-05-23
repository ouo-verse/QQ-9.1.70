package h1;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.g;
import j1.f;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a extends Drawable implements f, TintAwareDrawable {

    /* renamed from: d, reason: collision with root package name */
    private b f404034d;

    @Override // android.graphics.drawable.Drawable
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f404034d = new b(this.f404034d);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f404034d;
        if (bVar.f404036b) {
            bVar.f404035a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f404034d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f404034d.f404035a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f404034d.f404035a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f404034d.f404035a.setState(iArr)) {
            onStateChange = true;
        }
        boolean e16 = h1.b.e(iArr);
        b bVar = this.f404034d;
        if (bVar.f404036b != e16) {
            bVar.f404036b = e16;
            return true;
        }
        return onStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f404034d.f404035a.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f404034d.f404035a.setColorFilter(colorFilter);
    }

    @Override // j1.f
    public void setShapeAppearanceModel(@NonNull g gVar) {
        this.f404034d.f404035a.setShapeAppearanceModel(gVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i3) {
        this.f404034d.f404035a.setTint(i3);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f404034d.f404035a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.f404034d.f404035a.setTintMode(mode);
    }

    public a(g gVar) {
        this(new b(new MaterialShapeDrawable(gVar)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        MaterialShapeDrawable f404035a;

        /* renamed from: b, reason: collision with root package name */
        boolean f404036b;

        public b(MaterialShapeDrawable materialShapeDrawable) {
            this.f404035a = materialShapeDrawable;
            this.f404036b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(@NonNull b bVar) {
            this.f404035a = (MaterialShapeDrawable) bVar.f404035a.getConstantState().newDrawable();
            this.f404036b = bVar.f404036b;
        }
    }

    a(b bVar) {
        this.f404034d = bVar;
    }
}
