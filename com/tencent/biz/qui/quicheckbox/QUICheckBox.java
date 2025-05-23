package com.tencent.biz.qui.quicheckbox;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUICheckBox extends CheckBox {

    /* renamed from: d, reason: collision with root package name */
    private int f95117d;

    /* renamed from: e, reason: collision with root package name */
    private int f95118e;

    /* renamed from: f, reason: collision with root package name */
    private int f95119f;

    public QUICheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        g();
        f();
        d();
        a();
    }

    private void d() {
        setButtonDrawable((Drawable) null);
        setGravity(17);
        setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_on_brand_primary, this.f95119f));
    }

    private static void e(CheckBox checkBox, int i3, int i16) {
        checkBox.setWidth(i3);
        checkBox.setHeight(i3);
        ViewGroup.LayoutParams layoutParams = checkBox.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        layoutParams.width = i3;
        layoutParams.height = i3;
        checkBox.setLayoutParams(layoutParams);
        checkBox.setTextSize(0, i16);
    }

    private void f() {
        if (!isEnabled()) {
            if (this.f95117d == 2) {
                setBackground(a.d(getContext(), this.f95119f));
                return;
            } else {
                setBackground(a.b(getContext(), this.f95119f));
                return;
            }
        }
        Drawable a16 = a.a(getContext(), this.f95119f);
        int i3 = this.f95117d;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        a16 = a.h(getContext(), this.f95119f);
                    }
                } else {
                    a16 = a.i(getContext(), this.f95119f);
                }
            } else {
                a16 = a.c(getContext(), this.f95119f);
            }
        } else {
            a16 = a.g(getContext(), this.f95119f);
        }
        setBackground(a16);
    }

    private void g() {
        Resources resources = getResources();
        int i3 = this.f95118e;
        if (i3 == 0) {
            e(this, (int) resources.getDimension(R.dimen.d_s), (int) resources.getDimension(R.dimen.d_t));
            return;
        }
        if (i3 == 1) {
            e(this, (int) resources.getDimension(R.dimen.d_u), (int) resources.getDimension(R.dimen.d_v));
        } else if (i3 == 2) {
            e(this, (int) resources.getDimension(R.dimen.d_w), (int) resources.getDimension(R.dimen.d_x));
        } else {
            e(this, (int) resources.getDimension(R.dimen.d_s), (int) resources.getDimension(R.dimen.d_t));
        }
    }

    public void a() {
        int b16 = e.b(getContext(), 32.0f);
        b(b16, b16, b16, b16);
    }

    public void b(final int i3, final int i16, final int i17, final int i18) {
        post(new Runnable() { // from class: com.tencent.biz.qui.quicheckbox.QUICheckBox.1
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                QUICheckBox.this.getHitRect(rect);
                rect.top -= i3;
                rect.bottom += i16;
                rect.left -= i17;
                rect.right += i18;
                TouchDelegate touchDelegate = new TouchDelegate(rect, QUICheckBox.this);
                if (QUICheckBox.this.getParent() instanceof View) {
                    ((View) QUICheckBox.this.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        f();
    }

    public void setSizeType(int i3) {
        this.f95118e = i3;
        c();
    }

    public void setThemeId(int i3) {
        this.f95119f = i3;
        f();
        d();
    }

    public void setType(int i3) {
        this.f95117d = i3;
        c();
    }

    public QUICheckBox(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public QUICheckBox(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f95117d = 0;
        this.f95118e = 0;
        this.f95119f = 1000;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.G);
        this.f95117d = obtainStyledAttributes.getInteger(b.I, 0);
        this.f95118e = obtainStyledAttributes.getInteger(b.H, 0);
        obtainStyledAttributes.recycle();
        c();
    }

    public QUICheckBox(Context context) {
        super(context);
        this.f95117d = 0;
        this.f95118e = 0;
        this.f95119f = 1000;
        c();
    }

    public QUICheckBox(Context context, int i3, int i16) {
        super(context);
        this.f95119f = 1000;
        this.f95117d = i16;
        this.f95118e = i3;
        c();
    }
}
