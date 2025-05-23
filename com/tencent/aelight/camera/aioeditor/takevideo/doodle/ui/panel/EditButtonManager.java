package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditButtonManager {

    /* renamed from: a, reason: collision with root package name */
    private final int[][] f68605a;

    /* renamed from: b, reason: collision with root package name */
    private final View f68606b;

    /* renamed from: c, reason: collision with root package name */
    private final View f68607c;

    /* renamed from: f, reason: collision with root package name */
    protected final int f68610f;

    /* renamed from: g, reason: collision with root package name */
    protected int f68611g;

    /* renamed from: l, reason: collision with root package name */
    private ValueAnimator f68616l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f68617m;

    /* renamed from: p, reason: collision with root package name */
    protected f f68620p;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Integer, d> f68608d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final List<e> f68609e = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final int[] f68612h = new int[2];

    /* renamed from: i, reason: collision with root package name */
    private final int[] f68613i = new int[2];

    /* renamed from: j, reason: collision with root package name */
    private final int[] f68614j = new int[2];

    /* renamed from: k, reason: collision with root package name */
    private final int[] f68615k = new int[2];

    /* renamed from: n, reason: collision with root package name */
    private int f68618n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f68619o = 0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (EditButtonManager.this.f68616l == null) {
                EditButtonManager.this.p();
            }
            EditButtonManager.this.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f68624d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f68625e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f68626f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f68627h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ e f68628i;

        b(boolean z16, d dVar, e eVar, d dVar2, e eVar2) {
            this.f68624d = z16;
            this.f68625e = dVar;
            this.f68626f = eVar;
            this.f68627h = dVar2;
            this.f68628i = eVar2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Log.d("[EditButton]", "onAnimation Update, value = " + floatValue);
            if (!this.f68624d) {
                EditButtonManager.this.q();
                return;
            }
            this.f68625e.f68634b.getMeasuredWidth();
            if (this.f68626f != null) {
                this.f68626f.f68640a.getLayoutParams().width = (int) (this.f68627h.f68634b.getMeasuredWidth() * (2.0f - floatValue));
                this.f68626f.f68640a.requestLayout();
            }
            if (this.f68628i != null) {
                int measuredWidth = this.f68625e.f68634b.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = this.f68628i.f68641b.getMeasuredWidth();
                }
                this.f68628i.f68640a.getLayoutParams().width = (int) (measuredWidth * (floatValue + 1.0f));
                this.f68628i.f68640a.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f68630d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f68631e;

        c(boolean z16, e eVar) {
            this.f68630d = z16;
            this.f68631e = eVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e eVar;
            if (this.f68630d && (eVar = this.f68631e) != null) {
                EditButtonManager.this.l(eVar, false);
            }
            EditButtonManager.this.f68616l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        int f68633a;

        /* renamed from: b, reason: collision with root package name */
        View f68634b;

        /* renamed from: c, reason: collision with root package name */
        e f68635c;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ EditButtonManager f68637d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f68638e;

            a(EditButtonManager editButtonManager, int i3) {
                this.f68637d = editButtonManager;
                this.f68638e = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                d dVar = d.this;
                e eVar = dVar.f68635c;
                if (eVar != null) {
                    eVar.f68643d = this.f68638e;
                }
                EditButtonManager.this.o(this.f68638e);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        d(int i3, View view) {
            this.f68633a = i3;
            this.f68634b = view;
            view.setOnClickListener(new a(EditButtonManager.this, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        View f68640a;

        /* renamed from: b, reason: collision with root package name */
        View f68641b;

        /* renamed from: c, reason: collision with root package name */
        int[] f68642c;

        /* renamed from: d, reason: collision with root package name */
        int f68643d;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ EditButtonManager f68645d;

            a(EditButtonManager editButtonManager) {
                this.f68645d = editButtonManager;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                e eVar = e.this;
                EditButtonManager.this.o(eVar.f68643d);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        e(View view, View view2, int[] iArr) {
            this.f68640a = view;
            this.f68641b = view2;
            this.f68642c = iArr;
            this.f68643d = iArr[0];
            view2.setOnClickListener(new a(EditButtonManager.this));
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface f {
        void a(View view, int i3);
    }

    public EditButtonManager(View view, int[][] iArr) {
        this.f68605a = iArr;
        this.f68606b = view;
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.f68611g = 0;
        this.f68610f = j(0);
        this.f68607c = view.findViewById(R.id.x_i);
    }

    private int j(int i3) {
        this.f68608d.clear();
        this.f68609e.clear();
        int i16 = 0;
        for (int[] iArr : this.f68605a) {
            boolean z16 = true;
            if (iArr.length == 1) {
                k(i16, iArr[0], null);
                i16++;
            } else if (iArr.length == 4) {
                int i17 = i16 + 1;
                e eVar = new e(r(iArr[0]), r(iArr[1]), new int[]{i16, i17});
                this.f68609e.add(eVar);
                k(i16, iArr[2], eVar);
                k(i17, iArr[3], eVar);
                if (i16 != i3 && i17 != i3) {
                    z16 = false;
                }
                l(eVar, z16);
                i16 += 2;
            }
        }
        return i16;
    }

    private void k(int i3, int i16, e eVar) {
        d dVar = new d(i3, r(i16));
        dVar.f68634b.setVisibility(0);
        dVar.f68635c = eVar;
        this.f68608d.put(Integer.valueOf(i3), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(e eVar, boolean z16) {
        eVar.f68641b.setVisibility(z16 ? 8 : 0);
        for (int i3 : eVar.f68642c) {
            i(i3).f68634b.setVisibility(z16 ? 0 : 8);
        }
    }

    private void n(int i3) {
        this.f68607c.getLocationOnScreen(this.f68612h);
        this.f68607c.offsetLeftAndRight(i3 - this.f68612h[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Log.d("[EditButton]", "update FunGroup Layout");
        d i3 = i(this.f68611g);
        i3.f68634b.getMeasuredWidth();
        for (e eVar : this.f68609e) {
            int measuredWidth = eVar.f68641b.getMeasuredWidth();
            if (measuredWidth <= 0) {
                measuredWidth = i(eVar.f68642c[0]).f68634b.getMeasuredWidth();
            }
            if (measuredWidth > 0) {
                if (eVar == i3.f68635c) {
                    int i16 = measuredWidth * 2;
                    if (eVar.f68640a.getMeasuredWidth() != i16) {
                        eVar.f68640a.getLayoutParams().width = i16;
                        eVar.f68640a.requestLayout();
                    }
                } else if (eVar.f68640a.getMeasuredWidth() != measuredWidth) {
                    eVar.f68640a.getLayoutParams().width = measuredWidth;
                    eVar.f68640a.requestLayout();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        d i3 = i(this.f68611g);
        if (i3.f68634b.getVisibility() == 0) {
            i3.f68634b.getLocationOnScreen(this.f68615k);
        } else {
            e eVar = i3.f68635c;
            if (eVar != null) {
                eVar.f68640a.getLocationOnScreen(this.f68615k);
            }
        }
        ValueAnimator valueAnimator = this.f68616l;
        if (valueAnimator == null && this.f68617m == null) {
            this.f68618n = this.f68615k[0];
        } else {
            float floatValue = valueAnimator == null ? 0.0f : ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f68618n = this.f68618n + ((int) ((this.f68615k[0] - r2) * floatValue));
        }
        n(this.f68618n);
    }

    private View r(int i3) {
        View findViewById = this.f68606b.findViewById(i3);
        Objects.requireNonNull(findViewById);
        return findViewById;
    }

    protected void h(d dVar, d dVar2) {
        final e eVar = dVar.f68635c;
        final e eVar2 = dVar2.f68635c;
        boolean z16 = eVar != eVar2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration((Math.abs(dVar2.f68633a - dVar.f68633a) * 25) + 150);
        ofFloat.addUpdateListener(new b(z16, dVar2, eVar, dVar, eVar2));
        ofFloat.addListener(new c(z16, eVar));
        ValueAnimator valueAnimator = this.f68616l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f68617m = ofFloat;
            this.f68606b.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.4
                @Override // java.lang.Runnable
                public void run() {
                    EditButtonManager editButtonManager = EditButtonManager.this;
                    editButtonManager.f68616l = editButtonManager.f68617m;
                    EditButtonManager.this.f68617m = null;
                    EditButtonManager.this.f68616l.start();
                    e eVar3 = eVar;
                    e eVar4 = eVar2;
                    if (eVar3 == eVar4 || eVar4 == null) {
                        return;
                    }
                    EditButtonManager.this.l(eVar4, true);
                }
            });
        } else {
            this.f68616l = ofFloat;
            ofFloat.start();
            if (eVar == eVar2 || eVar2 == null) {
                return;
            }
            l(eVar2, true);
        }
    }

    protected d i(int i3) {
        d dVar = this.f68608d.get(Integer.valueOf(i3));
        Objects.requireNonNull(dVar);
        return dVar;
    }

    public void m(f fVar) {
        this.f68620p = fVar;
    }

    protected void o(int i3) {
        int i16;
        if (i3 < 0 || i3 >= this.f68610f || (i16 = this.f68611g) == i3) {
            return;
        }
        d i17 = i(i16);
        d i18 = i(i3);
        this.f68611g = i3;
        h(i17, i18);
        f fVar = this.f68620p;
        if (fVar != null) {
            fVar.a(i18.f68634b, i3);
        }
    }
}
