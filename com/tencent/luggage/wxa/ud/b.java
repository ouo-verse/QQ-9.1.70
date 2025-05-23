package com.tencent.luggage.wxa.ud;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.luggage.wxa.c5.e;
import com.tencent.luggage.wxa.kj.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.magicbrush.ui.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.ud.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f142286b = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ud.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6797b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f142287a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142288b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f142289c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f142290d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f142291e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f142292f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f142293g;

        public RunnableC6797b(g gVar, int i3, int i16, b bVar, int i17, int i18, int i19) {
            this.f142287a = gVar;
            this.f142288b = i3;
            this.f142289c = i16;
            this.f142290d = bVar;
            this.f142291e = i17;
            this.f142292f = i18;
            this.f142293g = i19;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Float f16;
            com.tencent.luggage.wxa.m4.b J;
            c0 customViewContainer;
            Context context;
            Resources resources;
            DisplayMetrics displayMetrics;
            this.f142287a.setOpaque(false);
            float f17 = this.f142288b;
            float f18 = this.f142289c;
            com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) this.f142290d.b().t();
            if (dVar != null && (context = dVar.getContext()) != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                f16 = Float.valueOf(displayMetrics.density);
            } else {
                f16 = null;
            }
            if (f16 != null) {
                f16.floatValue();
                if (f17 <= 0.0f) {
                    f17 = 100 * f16.floatValue();
                }
                if (f18 <= 0.0f) {
                    f18 = 100 * f16.floatValue();
                }
            }
            float[] fArr = {this.f142291e, this.f142292f, f17, f18, this.f142293g};
            com.tencent.luggage.wxa.r4.d dVar2 = (com.tencent.luggage.wxa.r4.d) this.f142290d.b().t();
            if (dVar2 != null && (J = dVar2.J()) != null && (customViewContainer = J.getCustomViewContainer()) != null) {
                g gVar = this.f142287a;
                customViewContainer.a((View) gVar, gVar.getVirtualElementId(), 0, fArr, 0, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f142295b;

        public c(g gVar) {
            this.f142295b = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.m4.b J;
            c0 customViewContainer;
            com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) b.this.b().t();
            if (dVar != null && (J = dVar.J()) != null && (customViewContainer = J.getCustomViewContainer()) != null) {
                customViewContainer.f(this.f142295b.getVirtualElementId());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f142296a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142297b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f142298c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f142299d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f142300e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f142301f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ g f142302g;

        public d(int i3, int i16, int i17, int i18, int i19, b bVar, g gVar) {
            this.f142296a = i3;
            this.f142297b = i16;
            this.f142298c = i17;
            this.f142299d = i18;
            this.f142300e = i19;
            this.f142301f = bVar;
            this.f142302g = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.m4.b J;
            c0 customViewContainer;
            float[] fArr = {this.f142296a, this.f142297b, this.f142298c, this.f142299d, this.f142300e};
            com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) this.f142301f.b().t();
            if (dVar != null && (J = dVar.J()) != null && (customViewContainer = J.getCustomViewContainer()) != null) {
                customViewContainer.a(this.f142302g.getVirtualElementId(), fArr, 0, Boolean.FALSE);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.tencent.luggage.wxa.w1.a logicImpl) {
        super(logicImpl);
        Intrinsics.checkNotNullParameter(logicImpl, "logicImpl");
    }

    @Override // com.tencent.magicbrush.b.e
    public void a(g view, int i3, int i16, int i17, int i18, int i19) {
        Intrinsics.checkNotNullParameter(view, "view");
        e B = b().B();
        if (B != null) {
            B.e(new d(i3, i16, i17, i18, i19, this, view));
        }
    }

    @Override // com.tencent.magicbrush.b.e
    public void b(g view, int i3, int i16, int i17, int i18, int i19) {
        Intrinsics.checkNotNullParameter(view, "view");
        w.d("MicroMsg.GlobalParentScreenCanvasViewDelegate", "hy: inserting magicbrush view in global parent screen canvas view delegate " + view.getVirtualElementId());
        e B = b().B();
        if (B != null) {
            B.e(new RunnableC6797b(view, i17, i18, this, i3, i16, i19));
        }
    }

    @Override // com.tencent.magicbrush.b.e
    public void a(g view) {
        Intrinsics.checkNotNullParameter(view, "view");
        w.d("MicroMsg.GlobalParentScreenCanvasViewDelegate", "hy: removing magicbrush view in global parent screen canvas view delegate " + view.getVirtualElementId());
        e B = b().B();
        if (B != null) {
            B.e(new c(view));
        }
    }
}
