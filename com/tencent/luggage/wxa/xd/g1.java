package com.tencent.luggage.wxa.xd;

import android.util.SparseLongArray;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class g1 {

    /* renamed from: d, reason: collision with root package name */
    public static final a f144794d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Lazy f144795a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f144796b;

    /* renamed from: c, reason: collision with root package name */
    public SparseLongArray f144797c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f144798a;

        /* renamed from: b, reason: collision with root package name */
        public long f144799b;

        public b(int i3, long j3) {
            this.f144798a = i3;
            this.f144799b = j3;
        }

        public final int a() {
            return this.f144798a;
        }

        public final long b() {
            return this.f144799b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f144798a == bVar.f144798a && this.f144799b == bVar.f144799b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f144798a * 31) + androidx.fragment.app.a.a(this.f144799b);
        }

        public String toString() {
            return "InvokeData(count=" + this.f144798a + ", totalCost=" + this.f144799b + ')';
        }

        public final void a(int i3) {
            this.f144798a = i3;
        }

        public final void a(long j3) {
            this.f144799b = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f144800a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            return new LinkedHashMap();
        }
    }

    public g1() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(c.f144800a);
        this.f144795a = lazy;
        this.f144796b = true;
        this.f144797c = new SparseLongArray();
    }

    public final synchronized void a(int i3) {
        if (this.f144796b) {
            return;
        }
        this.f144797c.put(i3, System.currentTimeMillis());
    }

    public final synchronized JSONObject b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry entry : c().entrySet()) {
            String str = (String) entry.getKey();
            b bVar = (b) entry.getValue();
            long b16 = bVar.b() / bVar.a();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(bVar.a());
            jSONArray.put(b16);
            Unit unit = Unit.INSTANCE;
            jSONObject.put(str, jSONArray);
        }
        return jSONObject;
    }

    public final Map c() {
        return (Map) this.f144795a.getValue();
    }

    public final synchronized void d() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.JsInvokeCostManager", this + " start");
        this.f144796b = false;
    }

    public final synchronized void e() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.JsInvokeCostManager", this + " stop");
        this.f144796b = true;
    }

    public final synchronized void a(int i3, String apiName) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        if (this.f144796b) {
            return;
        }
        long j3 = this.f144797c.get(i3, -1L);
        if (j3 < 0) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.JsInvokeCostManager", "get startTime fail, id:" + i3);
            return;
        }
        a(apiName, System.currentTimeMillis() - j3);
    }

    public final synchronized void a(String apiName, long j3) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        if (this.f144796b) {
            return;
        }
        b bVar = (b) c().get(apiName);
        if (bVar == null) {
            c().put(apiName, new b(1, j3));
        } else {
            bVar.a(bVar.a() + 1);
            bVar.a(bVar.b() + j3);
        }
    }

    public final synchronized void a() {
        c().clear();
    }
}
