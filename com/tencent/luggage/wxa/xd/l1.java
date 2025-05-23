package com.tencent.luggage.wxa.xd;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class l1 extends k1 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f144863b = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(JSONObject config, String workerType) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(workerType, "workerType");
            m1.f144865a.a(config, "workerContentType", workerType);
        }
    }

    public static final void a(JSONObject jSONObject, String str) {
        f144863b.a(jSONObject, str);
    }
}
