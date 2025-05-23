package com.tencent.luggage.wxa.jf;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 1306;

    @NotNull
    public static final String NAME = "postMessageToReferrerMiniProgram";

    /* renamed from: a, reason: collision with root package name */
    public static final a f131016a = new a(null);

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
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f131017a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c5.e f131018b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f131019c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131020d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f131021e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ i f131022f;

        public b(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.c5.e eVar, Object obj, com.tencent.luggage.wxa.ic.d dVar, int i3, i iVar) {
            this.f131017a = gVar;
            this.f131018b = eVar;
            this.f131019c = obj;
            this.f131020d = dVar;
            this.f131021e = i3;
            this.f131022f = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.ic.l h06 = this.f131017a.h0();
            if (h06 != null) {
                h06.a(new c().setData("appid", this.f131018b.getAppId()).setData(WadlProxyConsts.EXTRA_DATA, this.f131019c));
            }
            this.f131020d.a(this.f131021e, this.f131022f.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d env, JSONObject data, int i3) {
        com.tencent.luggage.wxa.c5.e eVar;
        com.tencent.luggage.wxa.ic.g Q;
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        Object opt = data.opt(WadlProxyConsts.EXTRA_DATA);
        if (opt == null) {
            env.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        com.tencent.luggage.wxa.ic.g runtime = env.getRuntime();
        Unit unit = null;
        if (runtime instanceof com.tencent.luggage.wxa.c5.e) {
            eVar = (com.tencent.luggage.wxa.c5.e) runtime;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            if (1 == eVar.S().N.f125847a) {
                try {
                    Q = eVar.d0();
                } catch (IllegalAccessError unused) {
                    Q = eVar.Q();
                }
                if (Q != null) {
                    Q.c(new b(Q, eVar, opt, env, i3, this));
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    env.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
                    return;
                }
            } else {
                env.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.h.f121354d));
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            env.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
        }
    }
}
