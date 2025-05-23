package com.tencent.luggage.wxa.ig;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 1133;

    @NotNull
    private static final String NAME = "batchGetStorage";

    /* renamed from: a, reason: collision with root package name */
    public static final a f130265a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (dVar != null) {
            dVar.a(i3, com.tencent.luggage.wxa.ig.a.f130261a.a(this, dVar, jSONObject));
        }
    }
}
