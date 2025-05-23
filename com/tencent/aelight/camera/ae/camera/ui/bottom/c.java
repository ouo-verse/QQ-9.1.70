package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.view.View;
import com.tencent.biz.videostory.capture.widgets.Pivot;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c implements lf0.c {

    /* renamed from: a, reason: collision with root package name */
    private Pivot f62570a = Pivot.a(1);

    /* renamed from: b, reason: collision with root package name */
    private Pivot f62571b = Pivot.b(1);

    /* renamed from: c, reason: collision with root package name */
    private float f62572c = 0.8f;

    /* renamed from: d, reason: collision with root package name */
    private float f62573d = 0.2f;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private c f62574a = new c();

        /* renamed from: b, reason: collision with root package name */
        private float f62575b = 1.0f;

        public c a() {
            c cVar = this.f62574a;
            cVar.f62573d = this.f62575b - cVar.f62572c;
            return this.f62574a;
        }

        public a b(float f16) {
            this.f62575b = f16;
            return this;
        }

        public a c(float f16) {
            this.f62574a.f62572c = f16;
            return this;
        }
    }

    @Override // lf0.c
    public void a(View view, float f16) {
        this.f62570a.c(view);
        this.f62571b.c(view);
        float abs = this.f62572c + (this.f62573d * (1.0f - Math.abs(f16)));
        view.setScaleX(abs);
        view.setScaleY(abs);
        View findViewById = view.findViewById(R.id.s4b);
        View findViewById2 = view.findViewById(R.id.s4p);
        if (findViewById != null) {
            findViewById.setAlpha(Math.abs(f16));
        }
        if (findViewById2 != null) {
            findViewById2.setAlpha(Math.abs(f16));
        }
        ms.a.a("AECircleScaleTransformer", "position: " + f16 + " view: " + view.toString());
    }
}
