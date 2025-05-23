package com.tencent.luggage.wxa.l6;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = 96;

    @Deprecated
    @NotNull
    public static final String NAME = "startRecord";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133075a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public String ERR_MSG_TAG() {
        return "err_msg";
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.k6.b env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        env.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        env.r();
    }
}
