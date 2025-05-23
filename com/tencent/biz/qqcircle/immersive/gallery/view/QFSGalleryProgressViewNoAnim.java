package com.tencent.biz.qqcircle.immersive.gallery.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes4.dex */
public class QFSGalleryProgressViewNoAnim extends View {
    private static final float E = cx.a(9.0f);
    private int C;
    private a D;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f86475d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f86476e;

    /* renamed from: f, reason: collision with root package name */
    private int f86477f;

    /* renamed from: h, reason: collision with root package name */
    private int f86478h;

    /* renamed from: i, reason: collision with root package name */
    private int f86479i;

    /* renamed from: m, reason: collision with root package name */
    private int f86480m;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i3, int i16);
    }

    public QFSGalleryProgressViewNoAnim(Context context) {
        super(context);
        this.f86480m = -1;
    }

    private void a(Canvas canvas, int i3) {
        Drawable drawable;
        if (canvas == null) {
            return;
        }
        if (i3 >= this.C) {
            QLog.e(b(), 1, "[drawSelectType] pos = " + i3 + ", pos is error");
            return;
        }
        for (int i16 = 0; i16 < this.C; i16++) {
            if (i16 <= i3) {
                drawable = this.f86475d;
            } else {
                drawable = this.f86476e;
            }
            if (drawable == null) {
                QLog.e(b(), 1, "[drawSelectType] drawable is null i = " + i16 + ", pos = " + i3);
            } else {
                drawable.setBounds(0, 0, this.f86478h, this.f86479i);
                canvas.translate((this.f86478h + this.f86477f) * i16, 0.0f);
                drawable.draw(canvas);
                canvas.translate((-i16) * (this.f86478h + this.f86477f), 0.0f);
            }
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null && context != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.H6);
            Drawable drawable = obtainStyledAttributes.getDrawable(y91.a.K6);
            this.f86475d = drawable;
            if (drawable == null) {
                this.f86475d = new ColorDrawable(getResources().getColor(R.color.cky));
            }
            int i3 = obtainStyledAttributes.getInt(y91.a.J6, 255);
            Drawable drawable2 = this.f86475d;
            if (drawable2 != null) {
                drawable2.setAlpha(i3);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(y91.a.M6);
            this.f86476e = drawable3;
            if (drawable3 == null) {
                this.f86476e = new ColorDrawable(getResources().getColor(R.color.ckf));
            }
            int i16 = obtainStyledAttributes.getInt(y91.a.L6, 255);
            Drawable drawable4 = this.f86476e;
            if (drawable4 != null) {
                drawable4.setAlpha(i16);
            }
            this.f86477f = (int) (obtainStyledAttributes.getDimension(y91.a.I6, E) + 0.5f);
            obtainStyledAttributes.recycle();
        }
    }

    private void d() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.a(this.f86480m, this.C);
        }
    }

    protected String b() {
        return "QFSGalleryProgressViewNoAnim";
    }

    public void e() {
        this.f86480m = 0;
        d();
    }

    public void f(int i3) {
        this.f86480m = i3;
        invalidate();
        d();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (this.C <= 0) {
            return;
        }
        int width = getWidth();
        int i3 = this.C;
        this.f86478h = (width - ((i3 - 1) * this.f86477f)) / i3;
        this.f86479i = getHeight();
        a(canvas, this.f86480m);
        canvas.restore();
    }

    public void setPosChangeListener(a aVar) {
        this.D = aVar;
    }

    public void setTotalCount(int i3) {
        this.C = i3;
        invalidate();
        d();
    }

    public QFSGalleryProgressViewNoAnim(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f86480m = -1;
        c(context, attributeSet);
    }

    public QFSGalleryProgressViewNoAnim(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f86480m = -1;
        c(context, attributeSet);
    }
}
