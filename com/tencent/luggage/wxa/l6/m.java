package com.tencent.luggage.wxa.l6;

import android.widget.Toast;
import com.tencent.mobileqq.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 2;

    @NotNull
    public static final String NAME = "profile";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133093a = new a(null);

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
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f133094a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.xd.d dVar) {
            super(0);
            this.f133094a = dVar;
        }

        public final void a() {
            Toast.makeText(this.f133094a.getContext(), this.f133094a.getContext().getString(R.string.f242247u2), 0).show();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d env, JSONObject data, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.luggage.wxa.rn.a.a(new b(env));
        env.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121314j));
    }
}
