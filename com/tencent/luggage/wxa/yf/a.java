package com.tencent.luggage.wxa.yf;

import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends com.tencent.luggage.wxa.xd.p {
    private static final int CTRL_INDEX = 881;

    @NotNull
    private static final String NAME = "onNavigateBackIntercept";

    /* renamed from: a, reason: collision with root package name */
    public static final C6953a f145629a = new C6953a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.yf.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6953a {
        public C6953a() {
        }

        public /* synthetic */ C6953a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(com.tencent.luggage.wxa.ic.g rt5, int i3) {
            com.tencent.luggage.wxa.kj.v pageView;
            Intrinsics.checkNotNullParameter(rt5, "rt");
            a aVar = new a(null);
            com.tencent.luggage.wxa.tn.w.d("AppBrandOnNavigateBackInterceptEvent", "[dispatch] type=" + i3);
            HashMap hashMap = new HashMap(1);
            hashMap.put("type", Integer.valueOf(i3));
            aVar.setData(hashMap).setContext(rt5.h0()).dispatch();
            com.tencent.luggage.wxa.kj.p Y = rt5.Y();
            if (Y != null && (pageView = Y.getPageView()) != null) {
                aVar.setData(hashMap).setContext(pageView).dispatch();
            }
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public a() {
    }
}
