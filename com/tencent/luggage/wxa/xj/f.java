package com.tencent.luggage.wxa.xj;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class f {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f145085a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145086b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f145087c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f145088d;

        public a(Ref.IntRef intRef, int i3, View view, Function0 function0) {
            this.f145085a = intRef;
            this.f145086b = i3;
            this.f145087c = view;
            this.f145088d = function0;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Ref.IntRef intRef = this.f145085a;
            int i3 = intRef.element + 1;
            intRef.element = i3;
            if (i3 < this.f145086b) {
                return;
            }
            this.f145087c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f145088d.invoke();
        }
    }

    public static final /* synthetic */ void b(View view, int i3, Function0 function0) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(new Ref.IntRef(), i3, view, function0));
    }
}
