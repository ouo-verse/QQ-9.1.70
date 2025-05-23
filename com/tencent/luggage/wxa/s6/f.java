package com.tencent.luggage.wxa.s6;

import android.content.Context;
import com.tencent.luggage.wxa.kj.p;
import java.util.LinkedList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f extends com.tencent.luggage.wxa.p5.d {
    public static final a W = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.s6.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6707a extends f {

            /* renamed from: a0, reason: collision with root package name */
            public final /* synthetic */ LinkedList f140077a0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6707a(Context context, com.tencent.luggage.wxa.c5.e eVar, LinkedList linkedList) {
                super(context, eVar);
                this.f140077a0 = linkedList;
            }

            @Override // com.tencent.luggage.wxa.p5.d, com.tencent.luggage.wxa.kj.p.e0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h a(p container, String str) {
                Intrinsics.checkNotNullParameter(container, "container");
                h hVar = (h) this.f140077a0.pollFirst();
                if (hVar == null) {
                    return h.INSTANCE.a();
                }
                return hVar;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a(Context context, com.tencent.luggage.wxa.c5.e rt5) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rt5, "rt");
            return new d(context, rt5);
        }

        public final f a(Context context, com.tencent.luggage.wxa.c5.e rt5, h preloadedPageView) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rt5, "rt");
            Intrinsics.checkNotNullParameter(preloadedPageView, "preloadedPageView");
            LinkedList linkedList = new LinkedList();
            linkedList.add(preloadedPageView);
            return new C6707a(context, rt5, linkedList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, com.tencent.luggage.wxa.c5.e rt5) {
        super(context, rt5);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rt5, "rt");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, com.tencent.luggage.wxa.c5.e rt5, p.e0 e0Var) {
        super(context, rt5, e0Var);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rt5, "rt");
    }
}
