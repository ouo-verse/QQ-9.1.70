package com.tencent.luggage.wxa.ub;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.mobileqq.vas.qid.QidPagView;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f142168a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f142169b;

        public a(View view, Function0 function0) {
            this.f142168a = view;
            this.f142169b = function0;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.f142168a.getViewTreeObserver().isAlive()) {
                this.f142168a.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            this.f142169b.invoke();
            return false;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ub.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6793b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f142170a;

        public RunnableC6793b(View view) {
            this.f142170a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f142170a.requestLayout();
        }
    }

    public static final int c(Context context, int i3) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(context.getResources().getDisplayMetrics().density * i3);
        return roundToInt;
    }

    public static final int d(Context context, int i3) {
        int c16 = c(context, QidPagView.DESIGN_PAG_WIDTH);
        int max = Math.max(c16, context.getResources().getDisplayMetrics().widthPixels / 2);
        if (i3 < c16) {
            i3 = c16;
        } else if (i3 > max) {
            i3 = max;
        }
        return Math.min(i3, context.getResources().getDisplayMetrics().widthPixels);
    }

    public static final boolean b(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static final void b(View view, Function0 function0) {
        if (view.getViewTreeObserver().isAlive()) {
            view.getViewTreeObserver().addOnPreDrawListener(new a(view, function0));
        }
    }

    public static final void b(View view) {
        c0.a(new RunnableC6793b(view));
    }
}
