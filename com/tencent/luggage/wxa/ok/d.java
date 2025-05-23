package com.tencent.luggage.wxa.ok;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.mobileqq.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final View f136574a;

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f136575b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f136576c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f136577d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f136578a;

        public a(com.tencent.luggage.wxa.ic.g gVar) {
            this.f136578a = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.luggage.wxa.ic.g gVar = this.f136578a;
            if (gVar == null) {
                return;
            }
            if (gVar instanceof com.tencent.luggage.wxa.c5.e) {
                ((com.tencent.luggage.wxa.c5.e) gVar).a((com.tencent.luggage.wxa.fd.i) null, com.tencent.luggage.wxa.li.a.WeakNetReload.b());
            } else {
                gVar.d1();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f136579a;

        static {
            int[] iArr = new int[e.b.values().length];
            iArr[e.b.PORTRAIT.ordinal()] = 1;
            iArr[e.b.UNSPECIFIED.ordinal()] = 2;
            f136579a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextView invoke() {
            return (TextView) d.this.f136574a.findViewById(R.id.ssq);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ok.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6557d extends Lambda implements Function0 {
        public C6557d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ImageView invoke() {
            return (ImageView) d.this.f136574a.findViewById(R.id.ssr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function0 {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Button invoke() {
            return (Button) d.this.f136574a.findViewById(R.id.ssn);
        }
    }

    public d(View.OnClickListener onClickListener, View root) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(root, "root");
        this.f136574a = root;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new C6557d());
        this.f136575b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new e());
        this.f136576c = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new c());
        this.f136577d = lazy3;
        Button c16 = c();
        if (c16 != null) {
            c16.setOnClickListener(onClickListener);
        }
    }

    public final ImageView b() {
        return (ImageView) this.f136575b.getValue();
    }

    public final Button c() {
        return (Button) this.f136576c.getValue();
    }

    public final Context a() {
        return this.f136574a.getContext();
    }

    public final void a(e.b orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        int i3 = b.f136579a[orientation.ordinal()];
        if (i3 != 1 && i3 != 2) {
            ImageView b16 = b();
            if (b16 != null) {
                com.tencent.luggage.wxa.lo.j.a(b16, a().getResources().getDimensionPixelSize(R.dimen.c2w));
            }
            com.tencent.luggage.wxa.lo.j.b(this.f136574a, a().getResources().getDimensionPixelSize(R.dimen.c2u));
        } else {
            ImageView b17 = b();
            if (b17 != null) {
                com.tencent.luggage.wxa.lo.j.a(b17, a().getResources().getDimensionPixelSize(R.dimen.c2v));
            }
            com.tencent.luggage.wxa.lo.j.b(this.f136574a, a().getResources().getDimensionPixelSize(R.dimen.c2t));
        }
        this.f136574a.requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(com.tencent.luggage.wxa.ic.g gVar, View root) {
        this(new a(gVar), root);
        Intrinsics.checkNotNullParameter(root, "root");
    }
}
