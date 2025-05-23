package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import android.widget.ImageView;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RedDotImageView extends AsyncImageView {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f60650d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f60651e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f60652f;

    /* renamed from: h, reason: collision with root package name */
    private float f60653h;

    /* renamed from: i, reason: collision with root package name */
    private int f60654i;

    /* renamed from: m, reason: collision with root package name */
    private int f60655m;

    /* compiled from: P */
    /* renamed from: com.qzone.widget.RedDotImageView$1, reason: invalid class name */
    /* loaded from: classes37.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f60656d;
        final /* synthetic */ RedDotImageView this$0;

        @Override // java.lang.Runnable
        public void run() {
            long uin = LoginData.getInstance().getUin();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f60656d);
            sb5.append(uin);
            this.this$0.h(u5.b.G(sb5.toString(), 1) == 1);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.widget.RedDotImageView$2, reason: invalid class name */
    /* loaded from: classes37.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f60657d;
        final /* synthetic */ RedDotImageView this$0;

        @Override // java.lang.Runnable
        public void run() {
            u5.b.q0(this.f60657d + LoginData.getInstance().getUin(), 0);
            this.this$0.h(false);
        }
    }

    public RedDotImageView(Context context) {
        this(context, null);
    }

    public static int g(int i3, int i16, int i17) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                i3 = size;
            }
        } else if (size < i3) {
            i3 = 16777216 | size;
        }
        return i3 | ((-16777216) & i17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Drawable drawable;
        super.drawableStateChanged();
        if (!this.f60652f || (drawable = getDrawable()) == null) {
            return;
        }
        if (StateSet.stateSetMatches(ImageView.PRESSED_WINDOW_FOCUSED_STATE_SET, getDrawableState())) {
            drawable.setAlpha(66);
        } else {
            drawable.setAlpha(255);
        }
        invalidate();
    }

    public boolean f() {
        return this.f60651e;
    }

    public void h(boolean z16) {
        if (this.f60651e != z16) {
            this.f60651e = z16;
            if (z16 && this.f60650d == null) {
                this.f60650d = getResources().getDrawable(R.drawable.skin_tips_dot);
            }
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        int i3 = this.C;
        if (i3 != 0) {
            int width = getWidth() - this.C;
            int height = getHeight() - this.C;
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                drawable2.setBounds(i3, i3, width, height);
                drawable2.draw(canvas);
            }
        } else {
            super.onDraw(canvas);
        }
        if (!this.f60651e || (drawable = this.f60650d) == null) {
            return;
        }
        drawable.setState(getDrawableState());
        this.f60650d.setBounds((getWidth() - ((int) (this.f60650d.getIntrinsicWidth() * this.f60653h))) - this.f60655m, this.f60654i, getWidth() - this.f60655m, ((int) (this.f60650d.getIntrinsicHeight() * this.f60653h)) + this.f60654i);
        this.f60650d.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.C == 0) {
            super.onMeasure(i3, i16);
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 1;
        }
        int i17 = this.C;
        setMeasuredDimension(g(Math.max(intrinsicWidth + (i17 * 2), getSuggestedMinimumWidth()), i3, 0), g(Math.max(intrinsicHeight + (i17 * 2), getSuggestedMinimumHeight()), i16, 0));
    }

    public void setOffSet(int i3, int i16) {
        this.f60654i = i3;
        this.f60655m = i16;
    }

    public void setPressedFadeIcon(boolean z16) {
        this.f60652f = z16;
    }

    public void setRedDotscale(float f16) {
        this.f60653h = f16;
    }

    public void setRedIcon(Drawable drawable) {
        this.f60650d = drawable;
    }

    public RedDotImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60650d = null;
        this.f60651e = false;
        this.f60652f = false;
        this.f60653h = 1.0f;
        this.f60654i = 0;
        this.f60655m = 0;
        this.C = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410026d7);
        if (obtainStyledAttributes != null) {
            this.C = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public RedDotImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60650d = null;
        this.f60651e = false;
        this.f60652f = false;
        this.f60653h = 1.0f;
        this.f60654i = 0;
        this.f60655m = 0;
        this.C = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410026d7);
        if (obtainStyledAttributes != null) {
            this.C = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
            obtainStyledAttributes.recycle();
        }
    }
}
