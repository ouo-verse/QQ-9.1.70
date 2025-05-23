package com.tencent.luggage.wxa.v2;

import com.tencent.luggage.wxa.v2.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum g implements e {
    ALBUM(1),
    CAMERA(2);


    /* renamed from: b, reason: collision with root package name */
    public static final a f143013b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f143017a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            e.a aVar = e.B;
            StringBuilder sb5 = new StringBuilder();
            String lowerCase = g.ALBUM.name().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            sb5.append(lowerCase);
            sb5.append(", ");
            String lowerCase2 = g.CAMERA.name().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            sb5.append(lowerCase2);
            return aVar.a(json, "sourceType", sb5.toString(), g.values());
        }
    }

    g(int i3) {
        this.f143017a = i3;
    }

    @Override // com.tencent.luggage.wxa.v2.e
    public /* synthetic */ boolean a(int i3) {
        return i41.a.a(this, i3);
    }

    @Override // com.tencent.luggage.wxa.v2.e
    public /* bridge */ /* synthetic */ String getName() {
        return name();
    }

    @Override // com.tencent.luggage.wxa.v2.e
    public int a() {
        return this.f143017a;
    }
}
