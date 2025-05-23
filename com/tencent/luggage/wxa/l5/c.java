package com.tencent.luggage.wxa.l5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.g6.g;
import com.tencent.luggage.wxa.g6.i;
import com.tencent.luggage.wxa.g6.k;
import com.tencent.luggage.wxa.g6.u;
import com.tencent.luggage.wxa.ml.t;
import com.tencent.luggage.wxa.mo.a0;
import com.tencent.luggage.wxa.uk.b0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.qid.QidPagView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final k f133041a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f133042b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f133043c;

    /* renamed from: d, reason: collision with root package name */
    public final Intent f133044d;

    /* renamed from: e, reason: collision with root package name */
    public final LuggageActivityHelper.d f133045e;

    /* renamed from: f, reason: collision with root package name */
    public final C6422c f133046f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements DialogInterface.OnShowListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface dialogInterface) {
            c.this.f133046f.onStart();
            c.this.f133046f.onResume();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            c.this.f133046f.onPause();
            c.this.f133046f.onStop();
            c.this.f133046f.o();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.l5.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6422c extends g {

        /* renamed from: j, reason: collision with root package name */
        public final Rect f133049j;

        /* renamed from: k, reason: collision with root package name */
        public final RectF f133050k;

        /* renamed from: l, reason: collision with root package name */
        public final Path f133051l;

        /* renamed from: m, reason: collision with root package name */
        public final RectF f133052m;

        public C6422c(Context context) {
            super(context, null, 2, null);
            setWillNotDraw(false);
            this.f133049j = new Rect();
            this.f133050k = new RectF();
            this.f133051l = new Path();
            this.f133052m = new RectF();
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int c16 = a0.c(context, R.dimen.f159633dk3);
            this.f133049j.setEmpty();
            getGlobalVisibleRect(this.f133049j);
            this.f133052m.setEmpty();
            RectF rectF = this.f133052m;
            Rect rect = this.f133049j;
            rectF.set(0.0f, 0.0f, rect.right - rect.left, rect.bottom - rect.top);
            this.f133050k.setEmpty();
            RectF rectF2 = this.f133050k;
            rectF2.left = 0.0f;
            rectF2.top = 0.0f;
            Rect rect2 = this.f133049j;
            rectF2.right = rect2.right - rect2.left;
            rectF2.bottom = rect2.bottom - rect2.top;
            this.f133051l.rewind();
            float f16 = c16;
            this.f133051l.addRoundRect(this.f133052m, f16, f16, Path.Direction.CW);
            this.f133051l.close();
            canvas.clipPath(this.f133051l);
            super.draw(canvas);
        }

        @Override // com.tencent.luggage.wxa.g6.g
        public u f() {
            return new i(this);
        }

        @Override // com.tencent.luggage.wxa.g6.g
        public void r() {
            super.r();
            c.this.f133041a.dismiss();
        }
    }

    public c(k dialog, Context context, int[] iArr, Intent intent, LuggageActivityHelper.d onResult) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        this.f133041a = dialog;
        this.f133042b = context;
        this.f133043c = iArr;
        this.f133044d = intent;
        this.f133045e = onResult;
        C6422c c6422c = new C6422c(context);
        this.f133046f = c6422c;
        if (this.f133043c == null && b0.c(context)) {
            int[] iArr2 = {com.tencent.luggage.wxa.kn.a.a(context, QidPagView.DESIGN_PAG_WIDTH), com.tencent.luggage.wxa.kn.a.a(context, 295)};
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
            t.a(context, iArr2, displayMetrics);
            this.f133043c = r0;
            Intrinsics.checkNotNull(r0);
            int[] iArr3 = {iArr2[0]};
            int[] iArr4 = this.f133043c;
            Intrinsics.checkNotNull(iArr4);
            iArr4[1] = iArr2[1];
        }
        int[] iArr5 = this.f133043c;
        if (iArr5 != null) {
            Intrinsics.checkNotNull(iArr5);
            if (iArr5[0] != 0) {
                int[] iArr6 = this.f133043c;
                Intrinsics.checkNotNull(iArr6);
                if (iArr6[1] != 0) {
                    int[] iArr7 = this.f133043c;
                    if (iArr7 != null) {
                        Intrinsics.checkNotNull(iArr7);
                        if (iArr7[0] == Integer.MAX_VALUE) {
                            int[] iArr8 = this.f133043c;
                            Intrinsics.checkNotNull(iArr8);
                            if (iArr8[1] == Integer.MAX_VALUE) {
                                layoutParams = new ViewGroup.LayoutParams(-1, -1);
                                dialog.setContentView(c6422c, layoutParams);
                                c6422c.a(context, intent, onResult);
                                dialog.setOnShowListener(new a());
                                dialog.setOnDismissListener(new b());
                            }
                        }
                    }
                    int[] iArr9 = this.f133043c;
                    Intrinsics.checkNotNull(iArr9);
                    c6422c.setMinimumHeight(iArr9[1]);
                    int[] iArr10 = this.f133043c;
                    Intrinsics.checkNotNull(iArr10);
                    int i3 = iArr10[0];
                    int[] iArr11 = this.f133043c;
                    Intrinsics.checkNotNull(iArr11);
                    layoutParams = new ViewGroup.LayoutParams(i3, iArr11[1]);
                    dialog.setContentView(c6422c, layoutParams);
                    c6422c.a(context, intent, onResult);
                    dialog.setOnShowListener(new a());
                    dialog.setOnDismissListener(new b());
                }
            }
        }
        layoutParams = new ViewGroup.LayoutParams(-1, -2);
        dialog.setContentView(c6422c, layoutParams);
        c6422c.a(context, intent, onResult);
        dialog.setOnShowListener(new a());
        dialog.setOnDismissListener(new b());
    }
}
