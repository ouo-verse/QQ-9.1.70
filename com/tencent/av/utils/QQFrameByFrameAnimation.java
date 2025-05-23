package com.tencent.av.utils;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQFrameByFrameAnimation {

    /* renamed from: c, reason: collision with root package name */
    int[] f76773c;

    /* renamed from: a, reason: collision with root package name */
    View f76771a = null;

    /* renamed from: b, reason: collision with root package name */
    al f76772b = null;

    /* renamed from: d, reason: collision with root package name */
    int f76774d = 300;

    /* renamed from: e, reason: collision with root package name */
    int f76775e = 0;

    /* renamed from: f, reason: collision with root package name */
    int f76776f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f76777g = 0;

    /* renamed from: h, reason: collision with root package name */
    Handler f76778h = new Handler();

    /* renamed from: i, reason: collision with root package name */
    Runnable f76779i = new Runnable() { // from class: com.tencent.av.utils.QQFrameByFrameAnimation.1
        @Override // java.lang.Runnable
        public void run() {
            QQFrameByFrameAnimation qQFrameByFrameAnimation = QQFrameByFrameAnimation.this;
            int i3 = qQFrameByFrameAnimation.f76777g;
            if (i3 > 0 && qQFrameByFrameAnimation.f76776f >= i3) {
                qQFrameByFrameAnimation.h();
                return;
            }
            int i16 = qQFrameByFrameAnimation.f76775e;
            if (i16 > 0 && qQFrameByFrameAnimation.f76776f / qQFrameByFrameAnimation.f76773c.length >= i16) {
                qQFrameByFrameAnimation.h();
                return;
            }
            qQFrameByFrameAnimation.a();
            QQFrameByFrameAnimation.this.f76778h.postDelayed(this, r0.f76774d);
            al alVar = QQFrameByFrameAnimation.this.f76772b;
            if (alVar != null) {
                alVar.a();
                QQFrameByFrameAnimation qQFrameByFrameAnimation2 = QQFrameByFrameAnimation.this;
                int[] iArr = qQFrameByFrameAnimation2.f76773c;
                if (iArr.length > 0 && qQFrameByFrameAnimation2.f76776f % iArr.length == 0) {
                    qQFrameByFrameAnimation2.f76772b.c();
                }
            }
        }
    };

    void a() {
        int[] iArr;
        int i3 = this.f76776f + 1;
        this.f76776f = i3;
        View view = this.f76771a;
        if (view != null && (iArr = this.f76773c) != null && iArr.length > 0) {
            int i16 = iArr[i3 % iArr.length];
            if (view instanceof ImageButton) {
                view.setBackgroundResource(i16);
            } else if (view instanceof Button) {
                Drawable drawable = view.getResources().getDrawable(i16);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                ((Button) this.f76771a).setCompoundDrawables(null, drawable, null, null);
            }
        }
    }

    public void b(al alVar) {
        this.f76772b = alVar;
    }

    public void c(int i3) {
        this.f76774d = i3;
    }

    public void d(int i3) {
        this.f76777g = i3;
    }

    public void e(int[] iArr) {
        this.f76773c = iArr;
    }

    public void f(View view) {
        this.f76771a = view;
    }

    public void g() {
        int[] iArr;
        View view = this.f76771a;
        if (view != null && (iArr = this.f76773c) != null && iArr.length > 0) {
            this.f76776f = 0;
            if (view instanceof ImageButton) {
                view.setBackgroundResource(iArr[0]);
            }
            View view2 = this.f76771a;
            if (view2 instanceof Button) {
                Drawable drawable = view2.getResources().getDrawable(this.f76773c[0]);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                ((Button) this.f76771a).setCompoundDrawables(null, drawable, null, null);
            }
            this.f76778h.postDelayed(this.f76779i, this.f76774d);
            al alVar = this.f76772b;
            if (alVar != null) {
                alVar.d();
            }
        }
    }

    public void h() {
        this.f76778h.removeCallbacks(this.f76779i);
        al alVar = this.f76772b;
        if (alVar != null) {
            alVar.b();
        }
    }
}
