package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.hn.xa;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends com.tencent.luggage.wxa.bj.a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f135197f = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public final xa f135198e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(int i3, String str, xa action) {
        super(a.EnumC6074a.TRANSFER, i3, str);
        Intrinsics.checkNotNullParameter(action, "action");
        this.f135198e = action;
        if (action.f129028d == 3) {
            if (action.f129031g == null) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.CgiExceptionWithAction", "action.action_code == 3 but alert_msg_info is null");
                return;
            }
            com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.CgiExceptionWithAction", "action.action_code == 3, show alert{ " + action.f129031g.f127729d + TokenParser.SP + action.f129031g.f127730e + " }");
            d0 d0Var = d0.f135160a;
            com.tencent.luggage.wxa.hn.h hVar = action.f129031g;
            Intrinsics.checkNotNullExpressionValue(hVar, "action.alert_msg_info");
            d0Var.a(hVar);
        }
    }

    public final xa a() {
        return this.f135198e;
    }
}
