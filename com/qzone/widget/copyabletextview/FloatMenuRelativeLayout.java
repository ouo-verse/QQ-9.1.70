package com.qzone.widget.copyabletextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.qzone.proxy.feedcomponent.text.TouchBehaviorListener;
import com.qzone.widget.copyabletextview.component.SelectableTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.util.QZLog;
import ip.b;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes37.dex */
public class FloatMenuRelativeLayout extends RelativeLayout implements TouchBehaviorListener {
    private View C;

    /* renamed from: d, reason: collision with root package name */
    private b f60740d;

    /* renamed from: e, reason: collision with root package name */
    private int f60741e;

    /* renamed from: f, reason: collision with root package name */
    private float f60742f;

    /* renamed from: h, reason: collision with root package name */
    private float f60743h;

    /* renamed from: i, reason: collision with root package name */
    private CopyableTextView f60744i;

    /* renamed from: m, reason: collision with root package name */
    private float f60745m;

    public FloatMenuRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60740d = new b();
        this.f60741e = -1;
        this.f60742f = 0.0f;
        this.f60743h = -1.0f;
        this.f60744i = null;
        c(context);
    }

    private void b(CopyableTextView copyableTextView) {
        View k3 = copyableTextView.k();
        this.C = k3;
        if (k3.getParent() != null) {
            ((ViewGroup) this.C.getParent()).removeView(this.C);
        }
        addView(this.C, new RelativeLayout.LayoutParams(R.dimen.f158608kc, R.dimen.f158607kb));
    }

    private void c(Context context) {
        this.f60740d.f(2, this);
        this.f60740d.f(4, this);
        this.f60745m = getContext().getResources().getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final float f16, final float f17, final String str, final CopyableTextView copyableTextView) {
        this.f60744i = copyableTextView;
        b(copyableTextView);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        int[] iArr = new int[2];
        ViewUtils.getChildPos(copyableTextView, this, iArr);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158608kc);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158607kb);
        layoutParams.leftMargin = (((int) f16) + iArr[0]) - (dimensionPixelSize / 2);
        if (getWidth() - layoutParams.leftMargin < dimensionPixelSize) {
            layoutParams.leftMargin = getWidth() - dimensionPixelSize;
        }
        layoutParams.topMargin = (int) (((iArr[1] + f17) + ((getContext().getResources().getDisplayMetrics().density * (-10.0f)) + 0.5f)) - dimensionPixelSize2);
        this.C.setLayoutParams(layoutParams);
        this.C.setVisibility(0);
        if (this.C.getMeasuredHeight() == 0 || this.C.getMeasuredWidth() == 0) {
            post(new Runnable() { // from class: com.qzone.widget.copyabletextview.FloatMenuRelativeLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    FloatMenuRelativeLayout.this.d(f16, f17, str, copyableTextView);
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        CopyableTextView copyableTextView;
        CopyableTextView copyableTextView2;
        boolean b16 = this.f60740d.b(motionEvent);
        if (!b16) {
            try {
                b16 = super.dispatchTouchEvent(motionEvent);
            } catch (Exception e16) {
                QZLog.e("FloatMenuRelativeLayout", e16.getStackTrace().toString());
            }
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mMotionTarget");
                declaredField.setAccessible(true);
                if (!ViewUtils.isChildOf((View) declaredField.get(this), this.C) && (copyableTextView2 = this.f60744i) != null) {
                    copyableTextView2.q();
                }
            } catch (NoSuchFieldException unused) {
                View view = this.C;
                if (view != null && view.getVisibility() == 0) {
                    float x16 = motionEvent.getX();
                    float y16 = motionEvent.getY();
                    if ((x16 <= this.C.getLeft() || x16 >= this.C.getRight() || y16 <= this.C.getTop() || y16 >= this.C.getBottom()) && (copyableTextView = this.f60744i) != null) {
                        copyableTextView.q();
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return b16;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        try {
            CopyableTextView copyableTextView = this.f60744i;
            if (copyableTextView == null) {
                return;
            }
            SelectableTextView n3 = copyableTextView.n();
            if (!n3.g() || n3.getLayout() == null) {
                return;
            }
            int[] iArr = new int[2];
            ViewUtils.getChildPos(this.f60744i, this, iArr);
            Layout layout = n3.getLayout();
            float f16 = (float) ((this.f60745m * 1.5d) + 0.5d);
            int d16 = n3.d();
            int c16 = n3.c();
            int lineForOffset = layout.getLineForOffset(d16);
            int i3 = c16 - 1;
            int lineForOffset2 = layout.getLineForOffset(i3);
            int paddingLeft = n3.getPaddingLeft();
            int paddingTop = n3.getPaddingTop();
            float primaryHorizontal = iArr[0] + layout.getPrimaryHorizontal(d16) + n3.getLeft() + paddingLeft;
            float primaryHorizontal2 = layout.getPrimaryHorizontal(i3) + iArr[0] + n3.getPaint().measureText(n3.getText(), i3, c16) + getPaddingLeft();
            float lineBottom = layout.getLineBottom(lineForOffset) + n3.getTop() + paddingTop + iArr[1];
            float lineBottom2 = layout.getLineBottom(lineForOffset2) + getPaddingTop() + paddingTop + iArr[1];
            float lineAscent = layout.getLineAscent(lineForOffset) - layout.getLineDescent(lineForOffset);
            Paint paint = new Paint();
            paint.setColor(this.f60744i.o());
            canvas.drawRect(primaryHorizontal - f16, lineBottom + lineAscent, primaryHorizontal + f16, lineBottom, paint);
            canvas.drawRect(primaryHorizontal2 - f16, lineBottom2 + lineAscent, primaryHorizontal2 + f16, lineBottom2, paint);
            Drawable m3 = this.f60744i.m();
            Drawable l3 = this.f60744i.l();
            if (m3 == null || l3 == null) {
                return;
            }
            canvas.save();
            float f17 = f16 * (-1.0f);
            canvas.translate((primaryHorizontal - m3.getIntrinsicWidth()) - f17, lineBottom - (((-1.0f) * lineAscent) + ((this.f60745m * 5.0f) + 0.5f)));
            m3.draw(canvas);
            canvas.translate((primaryHorizontal2 - primaryHorizontal) - f17, (lineBottom2 - lineBottom) - lineAscent);
            l3.draw(canvas);
            canvas.restore();
        } catch (Exception unused) {
        }
    }

    public FloatMenuRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60740d = new b();
        this.f60741e = -1;
        this.f60742f = 0.0f;
        this.f60743h = -1.0f;
        this.f60744i = null;
        c(context);
    }

    public FloatMenuRelativeLayout(Context context) {
        super(context);
        this.f60740d = new b();
        this.f60741e = -1;
        this.f60742f = 0.0f;
        this.f60743h = -1.0f;
        this.f60744i = null;
        c(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0188  */
    @Override // com.qzone.proxy.feedcomponent.text.TouchBehaviorListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInvoke(int i3, float f16, float f17, int i16) {
        CopyableTextView copyableTextView;
        float f18;
        boolean z16;
        int i17;
        boolean z17;
        if ((i3 == 4 && ((i16 & 32) == 32 || (i16 & 64) == 64)) || (copyableTextView = this.f60744i) == null) {
            return false;
        }
        SelectableTextView n3 = copyableTextView.n();
        if (n3.g()) {
            int[] iArr = new int[2];
            ViewUtils.getChildPos(this.f60744i, this, iArr);
            Layout layout = this.f60744i.n().getLayout();
            if (layout == null) {
                return false;
            }
            int d16 = n3.d();
            int c16 = n3.c();
            int lineForOffset = layout.getLineForOffset(d16);
            int i18 = c16 - 1;
            int lineForOffset2 = layout.getLineForOffset(i18);
            float primaryHorizontal = layout.getPrimaryHorizontal(d16) + this.f60744i.getPaddingLeft() + iArr[0];
            float primaryHorizontal2 = layout.getPrimaryHorizontal(i18) + this.f60744i.getPaddingLeft() + iArr[0] + n3.getPaint().measureText(n3.getText(), i18, c16);
            float lineBottom = layout.getLineBottom(lineForOffset) + this.f60744i.getPaddingTop() + iArr[1];
            int lineBottom2 = layout.getLineBottom(lineForOffset2) + this.f60744i.getPaddingTop();
            int i19 = iArr[1];
            float f19 = lineBottom2 + i19;
            float f26 = SelectableTextView.E;
            if (i16 == 0) {
                if (Math.abs(f16 - primaryHorizontal) < SelectableTextView.E && Math.abs(f17 - lineBottom) < SelectableTextView.E) {
                    this.f60741e = 1;
                } else {
                    float abs = Math.abs(f16 - primaryHorizontal2);
                    float f27 = SelectableTextView.E;
                    if (abs < f27 && Math.abs(((f17 - f19) - f26) - (f27 / 2.0f)) < (SelectableTextView.E * 3.0f) / 2.0f) {
                        this.f60741e = 2;
                    } else {
                        this.f60741e = -1;
                        this.f60740d.e(2);
                    }
                }
                return true;
            }
            if ((f17 - i19) - f26 >= 0.0f) {
                int lineForVertical = layout.getLineForVertical((int) ((f17 - i19) - f26));
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f16 - iArr[0]);
                if (this.f60741e == 2 && offsetForHorizontal == layout.getLineEnd(lineForVertical) - 1) {
                    float f28 = lineForVertical;
                    if (f28 != this.f60743h) {
                        f18 = primaryHorizontal;
                        this.f60742f = n3.getPaint().measureText(n3.getText(), offsetForHorizontal - 1, offsetForHorizontal);
                        this.f60743h = f28;
                    } else {
                        f18 = primaryHorizontal;
                    }
                    z16 = false;
                    if ((f16 - iArr[0]) - layout.getPrimaryHorizontal(offsetForHorizontal) > this.f60742f / 2.0f) {
                        offsetForHorizontal++;
                    }
                } else {
                    f18 = primaryHorizontal;
                    z16 = false;
                }
                int i26 = this.f60741e;
                if (i26 == 1) {
                    if (offsetForHorizontal < c16) {
                        z17 = n3.h(offsetForHorizontal, c16);
                        i17 = 2;
                    } else if (offsetForHorizontal > c16) {
                        z17 = n3.h(c16, offsetForHorizontal);
                        i17 = 2;
                        this.f60741e = 2;
                    } else {
                        i17 = 2;
                        z17 = z16;
                    }
                    z16 = true;
                    if (z17) {
                        if (lineForOffset2 != lineForOffset) {
                            d((getRight() - getLeft()) / i17, ((lineBottom + layout.getLineAscent(lineForOffset)) - layout.getLineDescent(lineForOffset)) - iArr[1], null, this.f60744i);
                        } else {
                            d((f18 + primaryHorizontal2) / 2.0f, ((lineBottom + layout.getLineAscent(lineForOffset)) - layout.getLineDescent(lineForOffset)) - iArr[1], null, this.f60744i);
                        }
                    }
                    return z16;
                }
                i17 = 2;
                if (i26 != 2) {
                    if (i16 == 2) {
                        this.f60741e = -1;
                    }
                    z17 = z16;
                    if (z17) {
                    }
                    return z16;
                }
                if (offsetForHorizontal < d16) {
                    z17 = n3.h(offsetForHorizontal, d16);
                    this.f60741e = 1;
                } else {
                    if (offsetForHorizontal > d16) {
                        z17 = n3.h(d16, offsetForHorizontal);
                    }
                    z17 = z16;
                }
                z16 = true;
                if (z17) {
                }
                return z16;
            }
            return false;
        }
        this.f60741e = -1;
        this.f60740d.e(2);
        this.f60740d.e(3);
        return false;
    }
}
