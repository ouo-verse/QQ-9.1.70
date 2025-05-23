package e0;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import f0.d;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class e<Z> extends i<ImageView, Z> implements d.a {

    @Nullable
    private Animatable D;

    public e(ImageView imageView) {
        super(imageView);
    }

    private void m(@Nullable Z z16) {
        if (z16 instanceof Animatable) {
            Animatable animatable = (Animatable) z16;
            this.D = animatable;
            animatable.start();
            return;
        }
        this.D = null;
    }

    private void o(@Nullable Z z16) {
        n(z16);
        m(z16);
    }

    @Override // e0.i, e0.a, e0.h
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        Animatable animatable = this.D;
        if (animatable != null) {
            animatable.stop();
        }
        o(null);
        d(drawable);
    }

    @Override // f0.d.a
    public void d(Drawable drawable) {
        ((ImageView) this.f395285d).setImageDrawable(drawable);
    }

    @Override // e0.a, e0.h
    public void e(@Nullable Drawable drawable) {
        super.e(drawable);
        o(null);
        d(drawable);
    }

    @Override // e0.i, e0.a, e0.h
    public void f(@Nullable Drawable drawable) {
        super.f(drawable);
        o(null);
        d(drawable);
    }

    @Override // e0.h
    public void g(@NonNull Z z16, @Nullable f0.d<? super Z> dVar) {
        if (dVar != null && dVar.a(z16, this)) {
            m(z16);
        } else {
            o(z16);
        }
    }

    @Override // f0.d.a
    @Nullable
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.f395285d).getDrawable();
    }

    protected abstract void n(@Nullable Z z16);

    @Override // e0.a, b0.f
    public void onStart() {
        Animatable animatable = this.D;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // e0.a, b0.f
    public void onStop() {
        Animatable animatable = this.D;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
