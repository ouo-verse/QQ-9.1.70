package com.tencent.luggage.wxa.lj;

import com.tencent.luggage.wxa.xd.o1;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q extends com.tencent.luggage.wxa.xd.p {
    public static final int CTRL_INDEX = 1374;

    @NotNull
    public static final String NAME = "onMenuButtonBoundingClientRectWeightChange";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133551a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void a(com.tencent.luggage.wxa.ic.l lVar) {
        if (lVar == null) {
            return;
        }
        com.tencent.luggage.wxa.kj.v a16 = o1.a(lVar);
        Map map = null;
        if (a16 != null) {
            try {
                if (k.a((com.tencent.luggage.wxa.ic.d) lVar)) {
                    map = k.a(o1.b(lVar));
                }
                if (map == null) {
                    map = k.b(a16);
                }
                if (map != null && com.tencent.luggage.wxa.tn.e.f141559a) {
                    k.a(o1.b(lVar));
                }
            } catch (Exception unused) {
            }
        }
        if (map == null) {
            map = k.a(o1.b(lVar));
        }
        setData(map).setContext(lVar).dispatch();
    }
}
