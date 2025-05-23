package com.tencent.biz.qui.quibutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import de0.b;
import de0.c;
import ie0.a;
import td0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIButton extends Button implements SkinnableView, b {
    private boolean C;
    private CharSequence D;
    private int E;
    private c<QUIButton> F;
    private ee0.b G;
    private final d H;

    /* renamed from: d, reason: collision with root package name */
    private int f95111d;

    /* renamed from: e, reason: collision with root package name */
    private int f95112e;

    /* renamed from: f, reason: collision with root package name */
    private int f95113f;

    /* renamed from: h, reason: collision with root package name */
    private int f95114h;

    /* renamed from: i, reason: collision with root package name */
    private int f95115i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f95116m;

    public QUIButton(Context context) {
        this(context, null);
    }

    private ColorStateList b() {
        int i3 = this.f95111d;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        return a.f().h(getContext(), R.color.qui_button_text_primary_outline, this.f95115i);
                    }
                    return a.f().h(getContext(), R.color.qui_button_text_error, this.f95115i);
                }
                return a.f().h(getContext(), R.color.qui_button_text_ghost, this.f95115i);
            }
            return a.f().h(getContext(), R.color.qui_button_text_secondary, this.f95115i);
        }
        return a.f().h(getContext(), R.color.qui_button_text_primary, this.f95115i);
    }

    private int c() {
        int i3 = this.f95112e;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return 0;
                }
                return getResources().getDimensionPixelSize(R.dimen.d_0);
            }
            return getResources().getDimensionPixelSize(R.dimen.d_6);
        }
        return getResources().getDimensionPixelSize(R.dimen.d9r);
    }

    private int d() {
        int i3 = this.f95111d;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return 0;
                        }
                        return a.f().g(getContext(), R.color.qui_button_text_primary_outline_disable, this.f95115i);
                    }
                    return a.f().g(getContext(), R.color.qui_button_text_error_disable, this.f95115i);
                }
                return a.f().g(getContext(), R.color.qui_button_text_ghost_disable, this.f95115i);
            }
            return a.f().g(getContext(), R.color.qui_button_text_secondary_disable, this.f95115i);
        }
        return a.f().g(getContext(), R.color.qui_button_text_primary_disable, this.f95115i);
    }

    @NonNull
    private c<QUIButton> e() {
        if (this.F == null) {
            this.F = new c<>(this);
        }
        return this.F;
    }

    private int f() {
        int i3 = this.f95112e;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return 0;
                    }
                    return getResources().getDimensionPixelSize(R.dimen.d9z);
                }
                return getResources().getDimensionPixelSize(R.dimen.d_3);
            }
            return getResources().getDimensionPixelSize(R.dimen.d9v);
        }
        return getResources().getDimensionPixelSize(R.dimen.d9q);
    }

    private int g() {
        if (this.f95111d != 1) {
            return 1;
        }
        return 2;
    }

    private int h() {
        int i3 = this.f95111d;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return 0;
                        }
                        return a.f().g(getContext(), R.color.qui_button_text_primary_outline_pressed, this.f95115i);
                    }
                    return a.f().g(getContext(), R.color.qui_button_text_error_pressed, this.f95115i);
                }
                return a.f().g(getContext(), R.color.qui_button_text_ghost_pressed, this.f95115i);
            }
            return a.f().g(getContext(), R.color.qui_button_text_secondary_pressed, this.f95115i);
        }
        return a.f().g(getContext(), R.color.qui_button_text_primary_pressed, this.f95115i);
    }

    private void k() {
        setGravity(this.f95114h);
        setSingleLine();
        p();
        l();
        setBackground(this.G.a(getContext(), this.f95111d, this.f95112e, this.f95115i));
    }

    private void l() {
        setTextSize(0, this.f95113f);
        setTextColor(b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View.OnClickListener onClickListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.f95116m || this.C) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void p() {
        int b16;
        int i3 = this.f95112e;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    b16 = 0;
                } else {
                    b16 = e.b(getContext(), 8.0f);
                }
            } else {
                b16 = e.b(getContext(), 12.0f);
            }
        } else {
            b16 = e.b(getContext(), 8.0f);
        }
        setPadding(b16, 0, b16, 0);
    }

    private void q() {
        int i3 = this.f95112e;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        setWidth(getResources().getDimensionPixelSize(R.dimen.d_1));
                        setHeight(getResources().getDimensionPixelSize(R.dimen.d9y));
                        return;
                    }
                    return;
                }
                setWidth(getResources().getDimensionPixelSize(R.dimen.d_7));
                setHeight(getResources().getDimensionPixelSize(R.dimen.d_2));
                return;
            }
            setWidth(getResources().getDimensionPixelSize(R.dimen.d9x));
            setHeight(getResources().getDimensionPixelSize(R.dimen.d9u));
            return;
        }
        setWidth(getResources().getDimensionPixelSize(R.dimen.d9s));
        setHeight(getResources().getDimensionPixelSize(R.dimen.d9p));
    }

    private void t() {
        setBackground(this.G.a(getContext(), this.f95111d, this.f95112e, this.f95115i));
    }

    public int i() {
        return this.f95112e;
    }

    public int j() {
        return this.f95111d;
    }

    public boolean m() {
        return this.f95116m;
    }

    public void o() {
        setTextColor(b());
        setBackground(this.G.a(getContext(), this.f95111d, this.f95112e, this.f95115i));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        float width;
        if (this.f95116m && this.E != 0) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            if (compoundDrawables != null && compoundDrawables.length > 0) {
                drawable = compoundDrawables[0];
            } else {
                drawable = null;
            }
            if (drawable != null) {
                int width2 = drawable.getBounds().width();
                int compoundDrawablePadding = getCompoundDrawablePadding();
                CharSequence text = getText();
                if (!TextUtils.isEmpty(text)) {
                    width = ((((getWidth() / 2.0f) - getPaddingLeft()) - width2) - compoundDrawablePadding) - (getPaint().measureText(text.toString()) / 2.0f);
                } else {
                    width = ((getWidth() / 2.0f) - getPaddingLeft()) - (width2 / 2.0f);
                }
                canvas.translate(width, 0.0f);
            }
        }
        super.onDraw(canvas);
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        if (this.f95115i == 1000) {
            t();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r() {
        Drawable drawable;
        if (this.f95111d == 3) {
            return;
        }
        d dVar = this.H;
        if (dVar != null) {
            drawable = dVar.a(g());
        } else {
            drawable = 0;
        }
        if (drawable == 0) {
            ud0.d.b("QUIButton", ud0.d.f438811e, "loading drawable is null, type=" + this.f95111d);
            return;
        }
        int i3 = this.f95112e;
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                this.D = getText();
                setText("");
                setCompoundDrawablePadding(0);
            }
        } else {
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.d9t));
        }
        int gravity = getGravity();
        if (gravity == 17) {
            this.E = gravity;
            setGravity(19);
        }
        int f16 = f();
        drawable.setBounds(0, 0, f16, f16);
        setCompoundDrawables(drawable, null, null, null);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        setBackgroundPressed();
        this.f95116m = true;
    }

    public void s() {
        if (this.f95111d == 3 || !this.f95116m) {
            return;
        }
        this.f95116m = false;
        int i3 = this.f95112e;
        if (i3 == 2 || i3 == 3) {
            setText(this.D);
            this.D = null;
        }
        int i16 = this.E;
        if (i16 != 0) {
            setGravity(i16);
            this.E = 0;
        }
        Object[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0) {
            Object obj = compoundDrawables[0];
            if (obj instanceof Animatable) {
                ((Animatable) obj).stop();
            }
        }
        setCompoundDrawables(null, null, null, null);
        o();
    }

    public void setBackgroundDisabled() {
        setTextColor(d());
        setBackground(this.G.c(getContext(), this.f95111d, this.f95112e, this.f95115i));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(e().d(drawable));
    }

    public void setBackgroundPressed() {
        setTextColor(h());
        setBackground(this.G.d(getContext(), this.f95111d, this.f95112e, this.f95115i));
    }

    public void setClickableWhenLoading(boolean z16) {
        this.C = z16;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable final View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            super.setOnClickListener(new View.OnClickListener() { // from class: ee0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QUIButton.this.n(onClickListener, view);
                }
            });
        } else {
            super.setOnClickListener(null);
        }
    }

    public void setQUIButtonResHelper(ee0.b bVar) {
        this.G = bVar;
        setBackground(bVar.a(getContext(), this.f95111d, this.f95112e, this.f95115i));
    }

    public void setSizeType(int i3) {
        this.f95112e = i3;
        this.f95113f = c();
        q();
        setTextSize(0, this.f95113f);
        p();
        setBackground(this.G.a(getContext(), this.f95111d, this.f95112e, this.f95115i));
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        int i3;
        if (this.f95116m && ((i3 = this.f95112e) == 2 || i3 == 3)) {
            this.D = charSequence;
        } else {
            super.setText(charSequence, bufferType);
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(e().j(colorStateList));
    }

    public void setThemeId(int i3) {
        this.f95115i = i3;
        setTextColor(b());
        setBackground(this.G.a(getContext(), this.f95111d, this.f95112e, this.f95115i));
    }

    public void setType(int i3) {
        this.f95111d = i3;
        setTextColor(b());
        setBackground(this.G.a(getContext(), this.f95111d, this.f95112e, this.f95115i));
    }

    @Override // de0.b
    public void x() {
        e().c();
    }

    public QUIButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QUIButton(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public QUIButton(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f95116m = false;
        this.F = null;
        this.G = ee0.b.g();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ee0.c.f396129c0);
        this.f95111d = obtainStyledAttributes.getInteger(ee0.c.f396139h0, 0);
        this.f95112e = obtainStyledAttributes.getInteger(ee0.c.f396135f0, 0);
        this.f95113f = obtainStyledAttributes.getDimensionPixelSize(ee0.c.f396131d0, c());
        this.f95114h = obtainStyledAttributes.getInteger(ee0.c.f396133e0, 17);
        this.f95115i = obtainStyledAttributes.getInteger(ee0.c.f396137g0, 1000);
        this.C = obtainStyledAttributes.getBoolean(ee0.c.f396141i0, false);
        obtainStyledAttributes.recycle();
        this.H = (d) ud0.c.a(d.class);
        k();
    }
}
