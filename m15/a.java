package m15;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private C10758a f416013a;

    /* renamed from: b, reason: collision with root package name */
    private int f416014b;

    /* renamed from: c, reason: collision with root package name */
    private int f416015c;

    public a() {
        this.f416014b = -1;
        this.f416015c = -1;
        this.f416013a = new C10758a();
    }

    private void g(Drawable drawable) {
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            Rect bounds2 = getBounds();
            if (bounds2 != null && bounds != null) {
                bounds2.left = Math.min(bounds.left, bounds2.left);
                bounds2.right = Math.max(bounds.right, bounds2.right);
                bounds2.top = Math.min(bounds.top, bounds2.top);
                bounds2.bottom = Math.max(bounds.bottom, bounds2.bottom);
                setBounds(bounds2);
                this.f416014b = Math.max(this.f416014b, bounds2.right - bounds2.left);
                this.f416015c = Math.max(this.f416015c, bounds2.bottom - bounds2.top);
            }
        }
    }

    private void m(Drawable drawable, int i3, int i16) {
        if (drawable != null) {
            drawable.setBounds(drawable.getBounds().left + i3, drawable.getBounds().top + i16, drawable.getBounds().right + i3, drawable.getBounds().bottom + i16);
        }
    }

    public Drawable.ConstantState a() {
        return this.f416013a;
    }

    public int b() {
        Drawable drawable;
        C10758a c10758a = this.f416013a;
        if (c10758a != null && (drawable = c10758a.f416018c) != null) {
            return Math.abs(drawable.getBounds().left - getBounds().left);
        }
        return 0;
    }

    public int c() {
        Drawable drawable;
        C10758a c10758a = this.f416013a;
        if (c10758a != null && (drawable = c10758a.f416018c) != null) {
            return Math.abs(drawable.getBounds().top - getBounds().top);
        }
        return 0;
    }

    public boolean d() {
        C10758a c10758a = this.f416013a;
        if (c10758a != null && c10758a.f416017b != null) {
            return false;
        }
        if (c10758a != null) {
            if (c10758a.f416020e != null || c10758a.f416022g != null || c10758a.f416021f != null || c10758a.f416019d != null) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        C10758a c10758a = this.f416013a;
        if (c10758a != null) {
            Drawable drawable = c10758a.f416020e;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            Drawable drawable2 = c10758a.f416022g;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
            Drawable drawable3 = c10758a.f416023h;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
            Drawable drawable4 = c10758a.f416021f;
            if (drawable4 != null) {
                drawable4.draw(canvas);
            }
            Drawable drawable5 = c10758a.f416018c;
            if (drawable5 != null) {
                drawable5.draw(canvas);
            }
            Drawable drawable6 = c10758a.f416019d;
            if (drawable6 != null) {
                drawable6.draw(canvas);
            }
            Drawable drawable7 = c10758a.f416017b;
            if (drawable7 != null) {
                drawable7.draw(canvas);
            }
        }
    }

    public void e(Drawable drawable) {
        C10758a c10758a = this.f416013a;
        if (c10758a != null) {
            c10758a.f416020e = drawable;
            g(drawable);
        }
    }

    public void f(Drawable drawable) {
        C10758a c10758a = this.f416013a;
        if (c10758a != null) {
            c10758a.f416018c = drawable;
            g(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f416013a.f416016a;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        this.f416013a.f416016a = getChangingConfigurations();
        return this.f416013a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f416015c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f416014b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public void h(Drawable drawable) {
        C10758a c10758a = this.f416013a;
        if (c10758a != null) {
            c10758a.f416017b = drawable;
            g(drawable);
        }
    }

    public void i(Drawable drawable) {
        C10758a c10758a = this.f416013a;
        if (c10758a != null) {
            c10758a.f416021f = drawable;
            g(drawable);
        }
    }

    public void j(Drawable drawable) {
        C10758a c10758a = this.f416013a;
        if (c10758a != null) {
            c10758a.f416023h = drawable;
            g(drawable);
        }
    }

    public void k(Drawable drawable) {
        C10758a c10758a = this.f416013a;
        if (c10758a != null) {
            c10758a.f416019d = drawable;
            g(drawable);
        }
    }

    public void l(Drawable drawable) {
        C10758a c10758a = this.f416013a;
        if (c10758a != null) {
            c10758a.f416022g = drawable;
            g(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        if (getBounds() != null) {
            int i19 = getBounds().left;
            int i26 = getBounds().top;
            if (i19 != i3 || i26 != i16) {
                int i27 = i3 - i19;
                int i28 = i16 - i26;
                m(this.f416013a.f416020e, i27, i28);
                m(this.f416013a.f416021f, i27, i28);
                m(this.f416013a.f416022g, i27, i28);
                m(this.f416013a.f416018c, i27, i28);
                m(this.f416013a.f416019d, i27, i28);
                m(this.f416013a.f416023h, i27, i28);
                m(this.f416013a.f416017b, i27, i28);
            }
        }
        super.setBounds(i3, i16, i17, i18);
    }

    public a(C10758a c10758a) {
        this.f416014b = -1;
        this.f416015c = -1;
        this.f416013a = c10758a;
        if (c10758a != null) {
            g(c10758a.f416020e);
            g(c10758a.f416018c);
            g(c10758a.f416019d);
            g(c10758a.f416021f);
            g(c10758a.f416022g);
            g(c10758a.f416023h);
            g(c10758a.f416017b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: m15.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static final class C10758a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f416016a;

        /* renamed from: b, reason: collision with root package name */
        Drawable f416017b;

        /* renamed from: c, reason: collision with root package name */
        Drawable f416018c;

        /* renamed from: d, reason: collision with root package name */
        Drawable f416019d;

        /* renamed from: e, reason: collision with root package name */
        Drawable f416020e;

        /* renamed from: f, reason: collision with root package name */
        Drawable f416021f;

        /* renamed from: g, reason: collision with root package name */
        Drawable f416022g;

        /* renamed from: h, reason: collision with root package name */
        Drawable f416023h;

        C10758a() {
            this.f416017b = null;
            this.f416018c = null;
            this.f416019d = null;
            this.f416020e = null;
            this.f416021f = null;
            this.f416022g = null;
            this.f416023h = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f416016a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(new C10758a(this));
        }

        C10758a(C10758a c10758a) {
            this.f416017b = null;
            this.f416018c = null;
            this.f416019d = null;
            this.f416020e = null;
            this.f416021f = null;
            this.f416022g = null;
            this.f416023h = null;
            Drawable drawable = c10758a.f416018c;
            if (drawable != null && drawable.getConstantState() != null) {
                Drawable newDrawable = c10758a.f416018c.getConstantState().newDrawable();
                this.f416018c = newDrawable;
                newDrawable.setBounds(c10758a.f416018c.getBounds());
            }
            Drawable drawable2 = c10758a.f416019d;
            if (drawable2 != null && drawable2.getConstantState() != null) {
                Drawable newDrawable2 = c10758a.f416019d.getConstantState().newDrawable();
                this.f416019d = newDrawable2;
                newDrawable2.setBounds(c10758a.f416019d.getBounds());
            }
            Drawable drawable3 = c10758a.f416020e;
            if (drawable3 != null && drawable3.getConstantState() != null) {
                Drawable newDrawable3 = c10758a.f416020e.getConstantState().newDrawable();
                this.f416020e = newDrawable3;
                newDrawable3.setBounds(c10758a.f416020e.getBounds());
            }
            Drawable drawable4 = c10758a.f416021f;
            if (drawable4 != null && drawable4.getConstantState() != null) {
                Drawable newDrawable4 = c10758a.f416021f.getConstantState().newDrawable();
                this.f416021f = newDrawable4;
                newDrawable4.setBounds(c10758a.f416021f.getBounds());
            }
            Drawable drawable5 = c10758a.f416022g;
            if (drawable5 != null && drawable5.getConstantState() != null) {
                Drawable newDrawable5 = c10758a.f416022g.getConstantState().newDrawable();
                this.f416022g = newDrawable5;
                newDrawable5.setBounds(c10758a.f416022g.getBounds());
            }
            Drawable drawable6 = c10758a.f416023h;
            if (drawable6 != null && drawable6.getConstantState() != null) {
                Drawable newDrawable6 = c10758a.f416023h.getConstantState().newDrawable();
                this.f416023h = newDrawable6;
                newDrawable6.setBounds(c10758a.f416023h.getBounds());
            }
            Drawable drawable7 = c10758a.f416017b;
            if (drawable7 != null && drawable7.getConstantState() != null) {
                Drawable newDrawable7 = c10758a.f416017b.getConstantState().newDrawable();
                this.f416017b = newDrawable7;
                newDrawable7.setBounds(c10758a.f416017b.getBounds());
            }
            this.f416016a = c10758a.f416016a;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
