package com.tencent.now.linkpkanchorplay.base;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CommonToggleButton extends CompoundButton {

    /* renamed from: d, reason: collision with root package name */
    private int f338125d;

    /* renamed from: e, reason: collision with root package name */
    private int f338126e;

    /* renamed from: f, reason: collision with root package name */
    private int f338127f;

    public CommonToggleButton(Context context) {
        super(context);
        d();
    }

    private void d() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, new a(true));
        stateListDrawable.addState(new int[0], new a(false));
        setBackgroundDrawable(stateListDrawable);
    }

    public void setCheckBackground(int i3) {
        this.f338126e = i3;
    }

    public void setThumbColor(int i3) {
        this.f338125d = i3;
    }

    public void setUnCheckBackground(int i3) {
        this.f338127f = i3;
    }

    public CommonToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonToggleButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, em3.a.f396743q2, i3, 0);
        this.f338125d = obtainStyledAttributes.getColor(em3.a.f396761s2, -16449505);
        this.f338126e = obtainStyledAttributes.getColor(em3.a.f396752r2, -1);
        this.f338127f = obtainStyledAttributes.getColor(em3.a.f396770t2, -3881788);
        obtainStyledAttributes.recycle();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends Drawable {

        /* renamed from: a, reason: collision with root package name */
        private boolean f338128a;

        /* renamed from: b, reason: collision with root package name */
        private int f338129b;

        public a(boolean z16) {
            this.f338129b = com.tencent.misc.utils.a.b(CommonToggleButton.this.getContext(), 1.5f);
            this.f338128a = z16;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f338128a) {
                RectF rectF = new RectF(0.0f, 0.0f, CommonToggleButton.this.getWidth(), CommonToggleButton.this.getHeight());
                Paint paint = new Paint(1);
                paint.setColor(CommonToggleButton.this.f338126e);
                canvas.drawRoundRect(rectF, CommonToggleButton.this.getHeight() / 2, CommonToggleButton.this.getHeight() / 2, paint);
                paint.setColor(CommonToggleButton.this.f338125d);
                canvas.drawCircle(CommonToggleButton.this.getWidth() - com.tencent.misc.utils.a.b(CommonToggleButton.this.getContext(), 12.0f), com.tencent.misc.utils.a.b(CommonToggleButton.this.getContext(), 12.0f), com.tencent.misc.utils.a.b(CommonToggleButton.this.getContext(), 8.0f), paint);
                return;
            }
            RectF rectF2 = new RectF(0.0f, 0.0f, CommonToggleButton.this.getWidth(), CommonToggleButton.this.getHeight());
            Paint paint2 = new Paint(1);
            paint2.setColor(CommonToggleButton.this.f338127f);
            canvas.drawRoundRect(rectF2, CommonToggleButton.this.getHeight() / 2, CommonToggleButton.this.getHeight() / 2, paint2);
            paint2.setColor(CommonToggleButton.this.f338125d);
            canvas.drawCircle(com.tencent.misc.utils.a.b(CommonToggleButton.this.getContext(), 12.0f), com.tencent.misc.utils.a.b(CommonToggleButton.this.getContext(), 12.0f), com.tencent.misc.utils.a.b(CommonToggleButton.this.getContext(), 8.0f), paint2);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }
}
