package com.tencent.luggage.wxa.dg;

import com.tencent.luggage.wxa.k0.d;
import com.tencent.luggage.wxa.kj.v;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = -2;

    @Deprecated
    @NotNull
    public static final String NAME = "saveInitialRenderingCache";

    /* renamed from: a, reason: collision with root package name */
    public static final C6139a f124246a = new C6139a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.dg.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6139a {
        public C6139a() {
        }

        public /* synthetic */ C6139a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        if (vVar != null) {
            d.a(vVar.b(com.tencent.luggage.wxa.pj.a.class));
        }
        a(vVar, i3, this);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return false;
    }

    public static final void a(v vVar, int i3, a aVar) {
        if (vVar != null) {
            vVar.a(i3, aVar.makeReturnJson("fail:not supported"));
        }
    }
}
