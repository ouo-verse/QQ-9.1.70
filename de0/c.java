package de0;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c<T extends View> {

    /* renamed from: a, reason: collision with root package name */
    private final T f393647a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f393648b = null;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f393649c = null;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f393650d = null;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f393651e = null;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f393652f = null;

    /* renamed from: g, reason: collision with root package name */
    private Drawable[] f393653g = null;

    /* renamed from: h, reason: collision with root package name */
    private Drawable[] f393654h = null;

    /* renamed from: i, reason: collision with root package name */
    private be0.a f393655i;

    public c(T t16) {
        this.f393647a = t16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static be0.a a(View view) {
        be0.a N;
        if ((view instanceof a) && (N = ((a) view).N()) != null) {
            return N;
        }
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return a((View) parent);
        }
        return null;
    }

    private void k(View view) {
        if (this.f393648b == null) {
            this.f393648b = view.getBackground();
        }
        Drawable drawable = this.f393648b;
        if (drawable != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    private void l(TextView textView) {
        boolean z16;
        Drawable drawable;
        Drawable drawable2;
        if (this.f393653g == null && this.f393654h == null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            this.f393654h = compoundDrawablesRelative;
            if (compoundDrawablesRelative != null && (compoundDrawablesRelative[0] != null || compoundDrawablesRelative[2] != null)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                Drawable[] drawableArr = this.f393654h;
                if (drawableArr[0] == null && (drawable2 = compoundDrawables[0]) != null) {
                    drawableArr[0] = drawable2;
                }
                if (drawableArr[2] == null && (drawable = compoundDrawables[2]) != null) {
                    drawableArr[2] = drawable;
                }
            } else {
                this.f393654h = null;
                this.f393653g = textView.getCompoundDrawables();
            }
        }
        Drawable[] drawableArr2 = this.f393654h;
        if (drawableArr2 != null) {
            textView.setCompoundDrawablesRelative(drawableArr2[0], drawableArr2[1], drawableArr2[2], drawableArr2[3]);
            return;
        }
        Drawable[] drawableArr3 = this.f393653g;
        if (drawableArr3 != null) {
            textView.setCompoundDrawables(drawableArr3[0], drawableArr3[1], drawableArr3[2], drawableArr3[3]);
        }
    }

    private void m(ImageView imageView) {
        if (this.f393649c == null) {
            this.f393649c = imageView.getDrawable();
        }
        Drawable drawable = this.f393649c;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    private void n() {
        if (this.f393655i == null) {
            return;
        }
        T t16 = this.f393647a;
        if (t16 instanceof ImageView) {
            m((ImageView) t16);
        }
        T t17 = this.f393647a;
        if (t17 instanceof TextView) {
            o((TextView) t17);
            l((TextView) this.f393647a);
        }
        k(this.f393647a);
    }

    private void o(TextView textView) {
        if (this.f393650d == null) {
            this.f393650d = textView.getTextColors();
        }
        ColorStateList colorStateList = this.f393650d;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        if (this.f393652f == null) {
            this.f393652f = textView.getHintTextColors();
        }
        ColorStateList colorStateList2 = this.f393652f;
        if (colorStateList2 != null) {
            textView.setHintTextColor(colorStateList2);
        }
        if (this.f393651e == null) {
            this.f393651e = textView.getLinkTextColors();
        }
        ColorStateList colorStateList3 = this.f393651e;
        if (colorStateList3 != null) {
            textView.setLinkTextColor(colorStateList3);
        }
    }

    public void b() {
        this.f393655i = a(this.f393647a);
        n();
    }

    public void c() {
        this.f393655i = a(this.f393647a);
        n();
    }

    public Drawable d(Drawable drawable) {
        be0.a aVar;
        this.f393648b = drawable;
        if (drawable != null && (aVar = this.f393655i) != null) {
            return aVar.e(this.f393647a.getContext(), drawable);
        }
        return drawable;
    }

    @NonNull
    public Drawable[] e(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        be0.a aVar;
        this.f393653g = new Drawable[]{drawable, drawable2, drawable3, drawable4};
        this.f393654h = null;
        if ((drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) || (aVar = this.f393655i) == null) {
            return new Drawable[]{drawable, drawable2, drawable3, drawable4};
        }
        Drawable[] drawableArr = new Drawable[4];
        if (drawable != null) {
            Drawable e16 = aVar.e(this.f393647a.getContext(), drawable);
            drawableArr[0] = e16;
            e16.setBounds(drawable.getBounds());
        }
        if (drawable2 != null) {
            Drawable e17 = this.f393655i.e(this.f393647a.getContext(), drawable2);
            drawableArr[1] = e17;
            e17.setBounds(drawable2.getBounds());
        }
        if (drawable3 != null) {
            Drawable e18 = this.f393655i.e(this.f393647a.getContext(), drawable3);
            drawableArr[2] = e18;
            e18.setBounds(drawable3.getBounds());
        }
        if (drawable4 != null) {
            Drawable e19 = this.f393655i.e(this.f393647a.getContext(), drawable4);
            drawableArr[3] = e19;
            e19.setBounds(drawable4.getBounds());
        }
        return drawableArr;
    }

    @NonNull
    public Drawable[] f(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        be0.a aVar;
        this.f393654h = new Drawable[]{drawable, drawable2, drawable3, drawable4};
        this.f393653g = null;
        if ((drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) || (aVar = this.f393655i) == null) {
            return new Drawable[]{drawable, drawable2, drawable3, drawable4};
        }
        Drawable[] drawableArr = new Drawable[4];
        if (drawable != null) {
            Drawable e16 = aVar.e(this.f393647a.getContext(), drawable);
            drawableArr[0] = e16;
            e16.setBounds(drawable.getBounds());
        }
        if (drawable2 != null) {
            Drawable e17 = this.f393655i.e(this.f393647a.getContext(), drawable2);
            drawableArr[1] = e17;
            e17.setBounds(drawable2.getBounds());
        }
        if (drawable3 != null) {
            Drawable e18 = this.f393655i.e(this.f393647a.getContext(), drawable3);
            drawableArr[2] = e18;
            e18.setBounds(drawable3.getBounds());
        }
        if (drawable4 != null) {
            Drawable e19 = this.f393655i.e(this.f393647a.getContext(), drawable4);
            drawableArr[3] = e19;
            e19.setBounds(drawable4.getBounds());
        }
        return drawableArr;
    }

    public ColorStateList g(ColorStateList colorStateList) {
        be0.a aVar;
        this.f393651e = colorStateList;
        if (colorStateList != null && (aVar = this.f393655i) != null) {
            return aVar.d(colorStateList);
        }
        return colorStateList;
    }

    public Drawable h(Drawable drawable) {
        be0.a aVar;
        this.f393649c = drawable;
        if (drawable != null && (aVar = this.f393655i) != null) {
            return aVar.e(this.f393647a.getContext(), drawable);
        }
        return drawable;
    }

    public ColorStateList i(ColorStateList colorStateList) {
        be0.a aVar;
        this.f393651e = colorStateList;
        if (colorStateList != null && (aVar = this.f393655i) != null) {
            return aVar.d(colorStateList);
        }
        return colorStateList;
    }

    public ColorStateList j(ColorStateList colorStateList) {
        be0.a aVar;
        this.f393650d = colorStateList;
        if (colorStateList != null && (aVar = this.f393655i) != null) {
            return aVar.d(colorStateList);
        }
        return colorStateList;
    }
}
