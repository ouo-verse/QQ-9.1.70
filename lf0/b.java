package lf0;

import android.support.annotation.FloatRange;
import android.view.View;
import com.tencent.biz.videostory.capture.widgets.Pivot;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private Pivot f414437a = Pivot.a(1);

    /* renamed from: b, reason: collision with root package name */
    private Pivot f414438b = Pivot.b(1);

    /* renamed from: c, reason: collision with root package name */
    private float f414439c = 0.8f;

    /* renamed from: d, reason: collision with root package name */
    private float f414440d = 0.2f;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private b f414441a = new b();

        /* renamed from: b, reason: collision with root package name */
        private float f414442b = 1.0f;

        public b a() {
            b bVar = this.f414441a;
            bVar.f414440d = this.f414442b - bVar.f414439c;
            return this.f414441a;
        }

        public a b(@FloatRange(from = 0.01d) float f16) {
            this.f414441a.f414439c = f16;
            return this;
        }
    }

    @Override // lf0.c
    public void a(View view, float f16) {
        this.f414437a.c(view);
        this.f414438b.c(view);
        float abs = this.f414439c + (this.f414440d * (1.0f - Math.abs(f16)));
        view.setScaleX(abs);
        view.setScaleY(abs);
    }
}
