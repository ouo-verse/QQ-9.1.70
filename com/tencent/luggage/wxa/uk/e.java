package com.tencent.luggage.wxa.uk;

import android.content.Context;
import com.tencent.luggage.wxa.uk.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements t {

    /* renamed from: b, reason: collision with root package name */
    public static final a f142670b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f142671a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements t.a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.tencent.luggage.wxa.uk.t.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(com.tencent.luggage.wxa.xd.f fVar) {
            Context c16;
            if (fVar == null || (c16 = fVar.getContext()) == null) {
                c16 = com.tencent.luggage.wxa.tn.z.c();
            }
            Intrinsics.checkNotNullExpressionValue(c16, "componentView?.context ?\u2026ationContext.getContext()");
            return new e(c16);
        }
    }

    public e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f142671a = context;
    }

    @Override // com.tencent.luggage.wxa.uk.t
    public g0 a() {
        return a(this.f142671a.getResources().getConfiguration().orientation);
    }

    @Override // com.tencent.luggage.wxa.uk.t
    public String getName() {
        return "AndroidOrientationGetter";
    }

    public final g0 a(int i3) {
        if (i3 == 1) {
            return g0.PORTRAIT;
        }
        if (i3 != 2) {
            return g0.UNSPECIFIED;
        }
        return g0.LANDSCAPE;
    }
}
