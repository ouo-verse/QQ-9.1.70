package com.tencent.luggage.wxa.ol;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public final j f136988a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f136989b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f136990c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f136991d = false;

    /* renamed from: e, reason: collision with root package name */
    public final c f136992e = new a();

    /* renamed from: f, reason: collision with root package name */
    public final c f136993f = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends c {
        public a() {
            super(null);
        }

        @Override // com.tencent.luggage.wxa.ol.y0.c
        public boolean c(View view) {
            if (view.getId() == R.id.srg) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.luggage.wxa.ol.y0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public j b(View view) {
            return (j) view.findViewById(R.id.srh);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends c {
        public b() {
            super(null);
        }

        @Override // com.tencent.luggage.wxa.ol.y0.c
        public boolean c(View view) {
            return view instanceof com.tencent.luggage.wxa.kj.z;
        }

        @Override // com.tencent.luggage.wxa.ol.y0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.kj.z b(View view) {
            return (com.tencent.luggage.wxa.kj.z) view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public View f136996a;

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [android.view.ViewParent] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7 */
        public final View a(View view) {
            View view2 = this.f136996a;
            if (view2 != null && ViewCompat.isAttachedToWindow(view2)) {
                return this.f136996a;
            }
            if (view != null && ViewCompat.isAttachedToWindow(view)) {
                for (View view3 = view.getParent(); view3 instanceof View; view3 = view3.getParent()) {
                    View view4 = view3;
                    if (c(view4)) {
                        View b16 = b(view4);
                        this.f136996a = b16;
                        return b16;
                    }
                }
            }
            return null;
        }

        public abstract View b(View view);

        public abstract boolean c(View view);
    }

    public y0(j jVar) {
        this.f136988a = jVar;
    }

    public boolean a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return b(motionEvent);
    }

    public final boolean b(MotionEvent motionEvent) {
        com.tencent.luggage.wxa.kj.z zVar;
        boolean b16 = this.f136988a.getDuplicateDispatch().b(motionEvent);
        com.tencent.luggage.wxa.ll.a.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | " + b16, motionEvent);
        if (2 == motionEvent.getActionMasked()) {
            if (b16 && !this.f136989b && (zVar = (com.tencent.luggage.wxa.kj.z) this.f136993f.a(this.f136988a)) != null) {
                this.f136990c = zVar.e();
                zVar.setPullDownEnabled(false);
                zVar.requestDisallowInterceptTouchEvent(true);
                this.f136989b = true;
            }
            if (b16) {
                this.f136991d = true;
            } else if (this.f136991d) {
                this.f136991d = false;
            }
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 3) {
                return b16;
            }
            a();
        }
        return false;
    }

    public final void a() {
        if (this.f136989b) {
            com.tencent.luggage.wxa.kj.z zVar = (com.tencent.luggage.wxa.kj.z) this.f136993f.a(this.f136988a);
            if (zVar != null) {
                zVar.setPullDownEnabled(this.f136990c);
            }
            this.f136989b = false;
        }
    }
}
