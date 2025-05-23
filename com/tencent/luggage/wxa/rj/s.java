package com.tencent.luggage.wxa.rj;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.luggage.wxa.tj.d;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s extends com.tencent.luggage.wxa.ml.d {
    public final d.c T;
    public final r U;
    public final ViewGroup V;
    public final Button W;
    public final Button X;
    public final Button Y;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList arrayListOf;
            if (s.this.o()) {
                d.c cVar = s.this.T;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(s.this.U.b());
                cVar.a(1, arrayListOf, 0, s.this.m().e());
                com.tencent.luggage.wxa.ml.r j3 = s.this.j();
                if (j3 != null) {
                    j3.b(s.this);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList arrayListOf;
            d.c cVar = s.this.T;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(s.this.U.b());
            e41.c.a(cVar, 2, arrayListOf, 0, false, 12, null);
            com.tencent.luggage.wxa.ml.r j3 = s.this.j();
            if (j3 != null) {
                j3.b(s.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList arrayListOf;
            if (s.this.o()) {
                d.c cVar = s.this.T;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(s.this.U.b());
                cVar.a(1, arrayListOf, 0, s.this.m().e());
                com.tencent.luggage.wxa.ml.r j3 = s.this.j();
                if (j3 != null) {
                    j3.b(s.this);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList arrayListOf;
            if (s.this.o()) {
                d.c cVar = s.this.T;
                String a16 = s.this.U.a();
                Intrinsics.checkNotNull(a16);
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(a16);
                cVar.a(1, arrayListOf, 0, s.this.m().e());
                com.tencent.luggage.wxa.ml.r j3 = s.this.j();
                if (j3 != null) {
                    j3.b(s.this);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList arrayListOf;
            d.c cVar = s.this.T;
            String a16 = s.this.U.a();
            Intrinsics.checkNotNull(a16);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(a16);
            e41.c.a(cVar, 2, arrayListOf, 0, false, 12, null);
            com.tencent.luggage.wxa.ml.r j3 = s.this.j();
            if (j3 != null) {
                j3.b(s.this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context context, com.tencent.luggage.wxa.wj.c windowAndroid, d.c listener, r scopeProvider) {
        super(context, windowAndroid, listener);
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowAndroid, "windowAndroid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(scopeProvider, "scopeProvider");
        this.T = listener;
        this.U = scopeProvider;
        ViewGroup viewGroup = (ViewGroup) k().findViewById(R.id.f96815ip);
        this.V = viewGroup;
        Button button = (Button) k().findViewById(R.id.s6q);
        this.W = button;
        Button button2 = (Button) k().findViewById(R.id.smw);
        this.X = button2;
        Button button3 = (Button) k().findViewById(R.id.i6k);
        this.Y = button3;
        String a16 = scopeProvider.a();
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            d().setVisibility(0);
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            h().setOnClickListener(new a());
            i().setOnClickListener(new b());
            return;
        }
        d().setVisibility(8);
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        if (button != null) {
            button.setOnClickListener(new c());
        }
        if (button2 != null) {
            button2.setOnClickListener(new d());
        }
        if (button3 != null) {
            button3.setOnClickListener(new e());
        }
    }

    @Override // com.tencent.luggage.wxa.ml.d, com.tencent.luggage.wxa.tj.d
    public void a(List list) {
    }
}
