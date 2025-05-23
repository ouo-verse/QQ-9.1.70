package com.tencent.luggage.wxa.ol;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g1 f136743a = new g1();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f136744a = new a();

        public a() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.br.b it) {
            Intrinsics.checkNotNullParameter(it, "it");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SecureInputLogic", "customPasswdSm3");
            it.e();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.br.b) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f136745a = new b();

        public b() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.br.b it) {
            Intrinsics.checkNotNullParameter(it, "it");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SecureInputLogic", "customPasswdSha256");
            it.d();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.br.b) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f136746a = new c();

        public c() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.br.b it) {
            Intrinsics.checkNotNullParameter(it, "it");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SecureInputLogic", "customPasswdSha1");
            it.c();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.br.b) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final d f136747a = new d();

        public d() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.br.b it) {
            Intrinsics.checkNotNullParameter(it, "it");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SecureInputLogic", "customPasswdMd5");
            it.b();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.br.b) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f136748a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(1);
            this.f136748a = str;
        }

        public final void a(com.tencent.luggage.wxa.br.b it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.b(this.f136748a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.br.b) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f136749a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(1);
            this.f136749a = str;
        }

        public final void a(com.tencent.luggage.wxa.br.b it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.a(this.f136749a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.br.b) obj);
            return Unit.INSTANCE;
        }
    }

    static {
        n0.f136895a.a();
    }

    public static final void a(JSONObject data, com.tencent.luggage.wxa.vl.i params) {
        JSONArray optJSONArray;
        int length;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(params, "params");
        if (params instanceof com.tencent.luggage.wxa.vl.f) {
            if (data.has("viewId")) {
                ((com.tencent.luggage.wxa.vl.f) params).X = Integer.valueOf(data.optInt("viewId"));
            } else {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SecureInputLogic", "prepareInvokeParams, viewId is null");
            }
        }
        JSONObject optJSONObject = data.optJSONObject("safePassword");
        if (optJSONObject == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.SecureInputLogic", "prepareInvokeParams, safePasswordJsonObj is null");
            return;
        }
        if (optJSONObject.has("certPath") && !optJSONObject.isNull("certPath")) {
            params.H = optJSONObject.optString("certPath");
        }
        if (optJSONObject.has("passwordLength") && !optJSONObject.isNull("passwordLength")) {
            params.I = Integer.valueOf(optJSONObject.optInt("passwordLength"));
        }
        if (optJSONObject.has("salt") && !optJSONObject.isNull("salt")) {
            params.J = optJSONObject.optString("salt");
        }
        if (optJSONObject.has("timestamp") && !optJSONObject.isNull("timestamp")) {
            params.K = Long.valueOf(optJSONObject.optLong("timestamp"));
        }
        if (optJSONObject.has("nonce") && !optJSONObject.isNull("nonce")) {
            params.L = Long.valueOf(optJSONObject.optLong("nonce"));
        }
        if (!optJSONObject.has("customHash") || (optJSONArray = optJSONObject.optJSONArray("customHash")) == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            String safePasswordCompat = optJSONArray.optString(i3);
            if (!TextUtils.isEmpty(safePasswordCompat)) {
                Intrinsics.checkNotNullExpressionValue(safePasswordCompat, "safePasswordCompat");
                arrayList.add(safePasswordCompat);
            }
        }
        params.M = arrayList;
    }

    public static final void b(JSONObject data, com.tencent.luggage.wxa.vl.i params) {
        JSONArray optJSONArray;
        int length;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(params, "params");
        if (params instanceof com.tencent.luggage.wxa.vl.f) {
            if (data.has("view-id")) {
                ((com.tencent.luggage.wxa.vl.f) params).X = Integer.valueOf(data.optInt("view-id"));
            } else {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SecureInputLogic", "prepareInvokeSameLayerParams, viewId is null");
            }
        }
        JSONObject optJSONObject = data.optJSONObject("safe-password");
        if (optJSONObject == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.SecureInputLogic", "prepareInvokeSameLayerParams, safePasswordJsonObj is null");
            return;
        }
        if (optJSONObject.has("cert-path") && !optJSONObject.isNull("cert-path")) {
            params.H = optJSONObject.optString("cert-path");
        }
        if (optJSONObject.has("password-length") && !optJSONObject.isNull("password-length")) {
            params.I = Integer.valueOf(optJSONObject.optInt("password-length"));
        }
        if (optJSONObject.has("salt") && !optJSONObject.isNull("salt")) {
            params.J = optJSONObject.optString("salt");
        }
        if (optJSONObject.has("timestamp") && !optJSONObject.isNull("timestamp")) {
            params.K = Long.valueOf(optJSONObject.optLong("timestamp"));
        }
        if (optJSONObject.has("nonce") && !optJSONObject.isNull("nonce")) {
            params.L = Long.valueOf(optJSONObject.optLong("nonce"));
        }
        if (optJSONObject.has("custom-hash") && (optJSONArray = optJSONObject.optJSONArray("custom-hash")) != null && (length = optJSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                String safePasswordCompat = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(safePasswordCompat)) {
                    Intrinsics.checkNotNullExpressionValue(safePasswordCompat, "safePasswordCompat");
                    arrayList.add(safePasswordCompat);
                }
            }
            params.M = arrayList;
        }
    }

    public final void a(com.tencent.luggage.wxa.vl.i iVar, com.tencent.luggage.wxa.vl.i newParams) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(newParams, "newParams");
        Integer num = newParams.I;
        if (num != null) {
            iVar.I = num;
        }
        String str = newParams.J;
        if (str != null) {
            iVar.J = str;
        }
        Long l3 = newParams.K;
        if (l3 != null) {
            iVar.K = l3;
        }
        Long l16 = newParams.L;
        if (l16 != null) {
            iVar.L = l16;
        }
        Intrinsics.checkNotNullExpressionValue(newParams.M, "newParams.safePasswordCompatList");
        if (!r0.isEmpty()) {
            iVar.M = newParams.M;
        }
    }

    public final String a(com.tencent.luggage.wxa.br.b secureInput, List rawSafePasswordCompatList, long j3, long j16) {
        Intrinsics.checkNotNullParameter(secureInput, "secureInput");
        Intrinsics.checkNotNullParameter(rawSafePasswordCompatList, "rawSafePasswordCompatList");
        secureInput.a();
        Iterator it = a(rawSafePasswordCompatList).iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(secureInput);
        }
        return secureInput.a(j3, j16);
    }

    public final List a(List list) {
        List emptyList;
        if (list.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        int i3 = 0;
        while (i3 < size) {
            String str = (String) list.get(i3);
            if (Intrinsics.areEqual("sm3", str)) {
                arrayList.add(a.f136744a);
            } else if (Intrinsics.areEqual("sha256", str)) {
                arrayList.add(b.f136745a);
            } else if (Intrinsics.areEqual("sha1", str)) {
                arrayList.add(c.f136746a);
            } else if (Intrinsics.areEqual("md5", str)) {
                arrayList.add(d.f136747a);
            } else if (Intrinsics.areEqual("addSaltBefore", str)) {
                i3++;
                arrayList.add(new e((String) list.get(i3)));
            } else if (Intrinsics.areEqual("addSaltAfter", str)) {
                i3++;
                arrayList.add(new f((String) list.get(i3)));
            }
            i3++;
        }
        return arrayList;
    }
}
