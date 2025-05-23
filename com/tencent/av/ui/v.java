package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes3.dex */
public class v implements View.OnTouchListener {
    ImageView D;
    ImageView E;
    ShimmerTextView F;
    ImageView G;
    int H;

    /* renamed from: f, reason: collision with root package name */
    final int f76632f;

    /* renamed from: d, reason: collision with root package name */
    public QavPanel.n f76630d = null;

    /* renamed from: e, reason: collision with root package name */
    boolean f76631e = false;

    /* renamed from: h, reason: collision with root package name */
    int f76633h = -1;

    /* renamed from: i, reason: collision with root package name */
    Rect f76634i = new Rect();

    /* renamed from: m, reason: collision with root package name */
    Rect f76635m = new Rect();
    Rect C = new Rect();

    public v(Context context, ImageView imageView, ImageView imageView2, ShimmerTextView shimmerTextView, ImageView imageView3) {
        this.D = imageView;
        this.E = imageView2;
        this.F = shimmerTextView;
        this.G = imageView3;
        this.H = context.getResources().getDimensionPixelSize(R.dimen.a6c);
        this.f76632f = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void d(int i3) {
        Rect rect = this.f76634i;
        Rect rect2 = this.f76635m;
        int i16 = rect2.left + i3;
        int i17 = this.f76633h;
        rect.left = i16 - i17;
        int i18 = (rect2.right + i3) - i17;
        rect.right = i18;
        int i19 = this.H;
        if (i18 >= i19) {
            rect.right = i19;
            rect.left = i19 - this.D.getWidth();
        }
        Rect rect3 = this.f76634i;
        if (rect3.left <= 0) {
            rect3.left = 0;
            rect3.right = 0 + this.D.getWidth();
        }
        ImageView imageView = this.D;
        Rect rect4 = this.f76634i;
        int i26 = rect4.left;
        Rect rect5 = this.f76635m;
        imageView.layout(i26, rect5.top, rect4.right, rect5.bottom);
        ImageView imageView2 = this.G;
        int i27 = this.f76634i.left;
        Rect rect6 = this.C;
        imageView2.layout(i27, rect6.top, rect6.right, rect6.bottom);
    }

    void a() {
        this.f76635m.top = this.D.getTop();
        this.f76635m.bottom = this.D.getBottom();
        this.f76635m.left = this.D.getLeft();
        this.f76635m.right = this.D.getRight();
        this.f76634i.left = this.D.getLeft();
        this.f76634i.right = this.D.getRight();
        this.C.top = this.G.getTop();
        this.C.bottom = this.G.getBottom();
        this.C.left = this.G.getLeft();
        this.C.right = this.G.getRight();
        this.f76631e = false;
    }

    public void b() {
        d(this.f76633h);
        this.F.setVisibility(0);
        this.E.setVisibility(0);
    }

    public void c(QavPanel.n nVar) {
        this.f76630d = nVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f76631e) {
                        d(rawX);
                    } else if (Math.abs(rawX - this.f76633h) > this.f76632f) {
                        this.f76631e = true;
                        this.F.setVisibility(4);
                        this.E.setVisibility(4);
                    }
                }
            } else {
                int i3 = this.f76634i.right;
                int i16 = this.H;
                if (i3 == i16) {
                    QavPanel.n nVar = this.f76630d;
                    if (nVar != null) {
                        nVar.a(true);
                    }
                } else if (i3 < i16) {
                    ImageView imageView = this.D;
                    Rect rect = this.f76635m;
                    imageView.layout(rect.left, rect.top, rect.right, rect.bottom);
                    ImageView imageView2 = this.G;
                    Rect rect2 = this.C;
                    imageView2.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
                    this.F.setVisibility(0);
                    this.E.setVisibility(0);
                    QavPanel.n nVar2 = this.f76630d;
                    if (nVar2 != null) {
                        nVar2.a(false);
                    }
                }
            }
        } else {
            this.f76633h = rawX;
            a();
        }
        return true;
    }
}
