package com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class RightTextRecyclerLayout extends FrameLayout implements NestedScrollingParent3 {
    private float C;
    private boolean D;
    private boolean E;
    private final List<b> F;
    private a G;
    private NestedScrollingParentHelper H;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f91101d;

    /* renamed from: e, reason: collision with root package name */
    private String f91102e;

    /* renamed from: f, reason: collision with root package name */
    private int f91103f;

    /* renamed from: h, reason: collision with root package name */
    private int f91104h;

    /* renamed from: i, reason: collision with root package name */
    private float f91105i;

    /* renamed from: m, reason: collision with root package name */
    private Scroller f91106m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f91107a;

        /* renamed from: b, reason: collision with root package name */
        public final float f91108b;

        /* renamed from: c, reason: collision with root package name */
        int f91109c;

        public b(int i3, float f16) {
            this.f91107a = i3;
            this.f91108b = f16;
        }
    }

    public RightTextRecyclerLayout(@NonNull Context context) {
        super(context);
        this.f91101d = new Paint();
        this.E = true;
        this.F = new ArrayList();
        l(context);
    }

    private void a() {
        int size = this.F.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.F.get(i3);
            if (bVar.f91109c == 0) {
                bVar.f91109c = b(i3);
            }
        }
    }

    private int b(int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 <= i3; i17++) {
            i16 += this.F.get(i17).f91107a;
        }
        return i16;
    }

    private void e(int i3) {
        int size = this.F.size();
        for (int i16 = 0; i16 < size; i16++) {
            b bVar = this.F.get(i16);
            int i17 = bVar.f91109c;
            float f16 = this.C;
            float f17 = i17;
            if (f16 < f17) {
                float f18 = f16 + (i3 / bVar.f91108b);
                this.C = f18;
                if (f18 >= f17) {
                    this.C = f17;
                    return;
                }
                return;
            }
        }
    }

    private void f(@NonNull int[] iArr, int i3) {
        float f16 = this.C;
        if (f16 < 0.0f) {
            float f17 = i3;
            if ((-f16) < f17) {
                iArr[0] = -((int) f16);
                this.C = 0.0f;
            } else {
                this.C = f16 + f17;
                iArr[0] = i3;
            }
            invalidate();
        }
    }

    private void g(@NonNull int[] iArr, int i3) {
        float f16 = this.C;
        if (f16 > 0.0f) {
            if (f16 < (-i3)) {
                iArr[0] = -((int) f16);
                this.C = 0.0f;
            } else {
                this.C = f16 + i3;
                iArr[0] = i3;
            }
            invalidate();
        }
    }

    private void h(Canvas canvas) {
        if (this.E && !TextUtils.isEmpty(this.f91102e)) {
            int width = getWidth();
            int height = getHeight();
            int textSize = (int) ((width - this.f91101d.getTextSize()) - this.f91103f);
            int k3 = (int) (((height - k()) / 2) + i());
            int length = this.f91102e.length();
            for (int i3 = 0; i3 < length; i3++) {
                float f16 = k3;
                canvas.drawText(String.valueOf(this.f91102e.charAt(i3)), textSize, f16, this.f91101d);
                k3 = (int) (f16 + i() + this.f91104h);
            }
        }
    }

    private float i() {
        if (this.f91105i == 0.0f) {
            this.f91105i = Math.abs(this.f91101d.ascent());
        }
        return this.f91105i;
    }

    private NestedScrollingParentHelper j() {
        if (this.H == null) {
            this.H = new NestedScrollingParentHelper(this);
        }
        return this.H;
    }

    private int k() {
        return (int) ((i() * this.f91102e.length()) + (this.f91104h * (r0 - 1)));
    }

    private void l(Context context) {
        this.f91106m = new Scroller(context);
        this.f91101d.setAntiAlias(true);
    }

    private void m() {
        if (!this.D) {
            return;
        }
        int size = this.F.size() - 1;
        while (true) {
            if (size >= 0) {
                if (this.C >= this.F.get(size).f91109c) {
                    break;
                } else {
                    size--;
                }
            } else {
                size = -1;
                break;
            }
        }
        a aVar = this.G;
        if (aVar != null) {
            aVar.b(size);
        }
    }

    public void c(b bVar) {
        if (bVar != null && bVar.f91107a > 0 && bVar.f91108b >= 1.0f) {
            this.F.add(bVar);
            return;
        }
        throw new IllegalArgumentException("step error");
    }

    public void d() {
        this.F.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        h(canvas);
        canvas.save();
        canvas.translate(-this.C, 0.0f);
        super.dispatchDraw(canvas);
        canvas.restore();
        if (this.f91106m.computeScrollOffset()) {
            this.C = this.f91106m.getCurrX();
            invalidate();
        }
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.D = false;
            }
        } else {
            this.D = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f16, float f17, boolean z16) {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f16, float f17) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17) {
        if (i3 < 0) {
            g(iArr, i3);
        } else {
            f(iArr, i3);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3, int i16) {
        j().onNestedScrollAccepted(view, view2, i3, i16);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3, int i16) {
        this.f91106m.forceFinished(true);
        a();
        if ((i3 & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i3) {
        j().onStopNestedScroll(view, i3);
        float f16 = this.C;
        if (f16 != 0.0f) {
            this.f91106m.startScroll((int) f16, 0, -((int) f16), 0);
            invalidate();
        }
        a aVar = this.G;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setListener(a aVar) {
        this.G = aVar;
    }

    public void setMarginEnd(int i3) {
        this.f91103f = i3;
    }

    public void setText(String str) {
        this.f91102e = str;
    }

    public void setTextColor(int i3) {
        this.f91101d.setColor(i3);
    }

    public void setTextMargin(int i3) {
        this.f91104h = i3;
    }

    public void setTextSize(int i3) {
        this.f91101d.setTextSize(i3);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19, @NonNull int[] iArr) {
        if (!this.D || this.F.isEmpty()) {
            return;
        }
        if (i17 > 0) {
            e(i17);
        } else {
            this.C += i17 / 2.0f;
        }
        iArr[0] = i17;
        this.E = this.C > 0.0f;
        invalidate();
    }

    public RightTextRecyclerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f91101d = new Paint();
        this.E = true;
        this.F = new ArrayList();
        l(context);
    }

    public RightTextRecyclerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f91101d = new Paint();
        this.E = true;
        this.F = new ArrayList();
        l(context);
    }
}
