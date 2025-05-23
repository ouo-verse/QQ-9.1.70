package com.tencent.luggage.wxa.n4;

import com.tencent.luggage.wxa.e5.f;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C6496a f135287b = new C6496a(null);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f135288a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.n4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6496a {
        public C6496a() {
        }

        public /* synthetic */ C6496a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f135289a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static com.tencent.luggage.wxa.n4.b f135290b;

        public final com.tencent.luggage.wxa.n4.b a() {
            return f135290b;
        }

        public final void a(com.tencent.luggage.wxa.n4.b bVar) {
            f135290b = bVar;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public a() {
        this.f135288a = new HashMap();
    }

    public final void a(JSONObject wxConfig) {
        Intrinsics.checkNotNullParameter(wxConfig, "wxConfig");
        if (this.f135288a.isEmpty()) {
            return;
        }
        try {
            HashMap hashMap = this.f135288a;
            Intrinsics.checkNotNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
            wxConfig.put("expt", new JSONObject(hashMap));
        } catch (JSONException e16) {
            w.b("Luggage.ExptMapping", "applyToWxConfig get exception:" + e16, e16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f135291a = new c();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.n4.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6497a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f135292a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6497a(a aVar) {
                super(1);
                this.f135292a = aVar;
            }

            public final void a(String str) {
                boolean z16;
                String str2;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    HashMap hashMap = this.f135292a.f135288a;
                    com.tencent.luggage.wxa.n4.b a16 = b.f135289a.a();
                    if (a16 != null) {
                        str2 = a16.b(str);
                    } else {
                        str2 = null;
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    hashMap.put(str, str2);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((String) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f135293a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(a aVar) {
                super(1);
                this.f135293a = aVar;
            }

            public final void a(String str) {
                boolean z16;
                JSONObject jSONObject;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    HashMap hashMap = this.f135293a.f135288a;
                    com.tencent.luggage.wxa.n4.b a16 = b.f135289a.a();
                    if (a16 == null || (jSONObject = a16.a(str)) == null) {
                        jSONObject = new JSONObject();
                    }
                    hashMap.put(str, jSONObject);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((String) obj);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:10|11|(1:31)|(7:26|27|17|18|19|(1:21)|23)|16|17|18|19|(0)|23) */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        
            com.tencent.luggage.wxa.tn.w.b("Luggage.ExptMapping", "createForFeatureValue(" + r8 + ") fill mapping get exception:" + r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[Catch: JSONException -> 0x0063, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0063, blocks: (B:19:0x0050, B:21:0x005a), top: B:18:0x0050 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final a a(String str, String str2) {
            JSONArray jSONArray;
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (str == null || str.length() == 0) {
                return null;
            }
            try {
                JSONArray jSONArray2 = new JSONArray(str);
                if (!(str2 == null || str2.length() == 0)) {
                    try {
                        jSONArray = new JSONArray(str2);
                    } catch (JSONException e16) {
                        w.b("Luggage.ExptMapping", "createForFeatureValue(" + str2 + ") toJSONArray get exception:" + e16);
                    }
                    a aVar = new a(defaultConstructorMarker);
                    f.a(jSONArray2, new C6497a(aVar));
                    if (jSONArray != null) {
                        f.a(jSONArray, new b(aVar));
                    }
                    return aVar;
                }
                jSONArray = null;
                a aVar2 = new a(defaultConstructorMarker);
                f.a(jSONArray2, new C6497a(aVar2));
                if (jSONArray != null) {
                }
                return aVar2;
            } catch (JSONException e17) {
                w.b("Luggage.ExptMapping", "createForFeatureValue(" + str + ") toJSONArray get exception:" + e17);
                return null;
            }
        }

        public static final a a() {
            return new a(null);
        }
    }
}
