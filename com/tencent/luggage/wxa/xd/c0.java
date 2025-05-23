package com.tencent.luggage.wxa.xd;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c0 extends p {
    public static final int CTRL_INDEX = 590;

    @NotNull
    public static final String NAME = "onKeyboardHeightChange";

    /* renamed from: a, reason: collision with root package name */
    public static final a f144739a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void a(int i3, com.tencent.luggage.wxa.ic.l service, com.tencent.luggage.wxa.kj.v page) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(page, "page");
        a(this, i3, service, page, null, 8, null);
    }

    public static /* synthetic */ void a(c0 c0Var, int i3, com.tencent.luggage.wxa.ic.l lVar, com.tencent.luggage.wxa.kj.v vVar, Integer num, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            num = null;
        }
        c0Var.a(i3, lVar, vVar, num);
    }

    public final void a(int i3, com.tencent.luggage.wxa.ic.l service, com.tencent.luggage.wxa.kj.v page, Integer num) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(page, "page");
        setData("height", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(page.getContext(), i3)));
        if (num != null) {
            setData("inputId", Integer.valueOf(num.intValue()));
        }
        setContext(service).dispatch();
        setContext(page).dispatch();
    }

    public final void a(int i3, d dVar, d dVar2, Integer num) {
        Context context;
        if (dVar2 == null || (context = dVar2.getContext()) == null) {
            context = dVar != null ? dVar.getContext() : null;
        }
        setData("height", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(context, i3)));
        if (num != null) {
            setData("viewId", Integer.valueOf(num.intValue()));
        }
        setContext(dVar).dispatch();
        setContext(dVar2).dispatch();
    }
}
