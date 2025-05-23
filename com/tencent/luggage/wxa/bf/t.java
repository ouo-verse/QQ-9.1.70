package com.tencent.luggage.wxa.bf;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.m4.c;
import com.tencent.luggage.wxa.mc.m;
import com.tencent.luggage.wxa.uk.x;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;

    @NotNull
    public static final String NAME = "loadJsFiles";

    /* renamed from: a, reason: collision with root package name */
    public static final a f122564a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(String str, c.a[] aVarArr, boolean[] zArr, Object[] objArr, long j3, long j16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f122574a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONArray f122575b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122576c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ t f122577d;

        public c(com.tencent.luggage.wxa.kj.v vVar, JSONArray jSONArray, int i3, t tVar) {
            this.f122574a = vVar;
            this.f122575b = jSONArray;
            this.f122576c = i3;
            this.f122577d = tVar;
        }

        @Override // com.tencent.luggage.wxa.bf.t.b
        public void a(String str, c.a[] scripts, boolean[] results, Object[] extras, long j3, long j16) {
            Intrinsics.checkNotNullParameter(scripts, "scripts");
            Intrinsics.checkNotNullParameter(results, "results");
            Intrinsics.checkNotNullParameter(extras, "extras");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("invoke with appId:");
            sb5.append(this.f122574a.getAppId());
            sb5.append(" paths:");
            sb5.append(this.f122575b);
            sb5.append(" key:");
            sb5.append(str);
            sb5.append(", results:");
            String arrays = Arrays.toString(results);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            sb5.append(arrays);
            com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.JsApiLoadJsFiles", sb5.toString());
            this.f122574a.a(this.f122576c, this.f122577d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
            b bVar = (b) this.f122574a.f(b.class);
            if (bVar != null) {
                bVar.a(str, scripts, results, extras, j3, j16);
            }
        }
    }

    public static final void a(com.tencent.luggage.wxa.ic.g gVar, JSONArray jSONArray, com.tencent.luggage.wxa.ei.j jVar, com.tencent.luggage.wxa.mc.m mVar, String str, b bVar) {
        f122564a.a(gVar, jSONArray, jVar, mVar, str, bVar);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.kj.v vVar, JSONObject jSONObject, int i3) {
        if (vVar == null || jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("paths");
        String optString = jSONObject.optString("key");
        a aVar = f122564a;
        com.tencent.luggage.wxa.ic.g runtime = vVar.getRuntime();
        Intrinsics.checkNotNullExpressionValue(runtime, "env.runtime");
        aVar.a(runtime, optJSONArray, vVar.getJsRuntime(), vVar.C(), optString, new c(vVar, optJSONArray, i3, this));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bf.t$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6054a implements x.e {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean[] f122565a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f122566b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ValueCallback f122567c;

            public C6054a(boolean[] zArr, int i3, ValueCallback valueCallback) {
                this.f122565a = zArr;
                this.f122566b = i3;
                this.f122567c = valueCallback;
            }

            @Override // com.tencent.luggage.wxa.uk.x.e
            public void a(String str) {
                this.f122565a[this.f122566b] = true;
                ValueCallback valueCallback = this.f122567c;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(str);
                }
            }

            @Override // com.tencent.luggage.wxa.uk.x.e
            public void b(String str) {
                this.f122565a[this.f122566b] = false;
                ValueCallback valueCallback = this.f122567c;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(str);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements ValueCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f122568a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f122569b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c.a[] f122570c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean[] f122571d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Object[] f122572e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ long f122573f;

            public b(b bVar, String str, c.a[] aVarArr, boolean[] zArr, Object[] objArr, long j3) {
                this.f122568a = bVar;
                this.f122569b = str;
                this.f122570c = aVarArr;
                this.f122571d = zArr;
                this.f122572e = objArr;
                this.f122573f = j3;
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onReceiveValue(String str) {
                long c16 = com.tencent.luggage.wxa.tn.w0.c();
                b bVar = this.f122568a;
                if (bVar != null) {
                    bVar.a(this.f122569b, this.f122570c, this.f122571d, this.f122572e, this.f122573f, c16);
                }
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c.a a(m.a aVar) {
            c.a aVar2 = new c.a();
            aVar2.a(aVar);
            aVar2.f134097k = aVar.f134342h;
            return aVar2;
        }

        public final void a(com.tencent.luggage.wxa.ic.g runtime, JSONArray jSONArray, com.tencent.luggage.wxa.ei.j jVar, com.tencent.luggage.wxa.mc.m mVar, String str, b bVar) {
            String str2;
            c.a aVar;
            int i3;
            int i16;
            boolean[] zArr;
            Object[] objArr;
            boolean[] zArr2;
            JSONArray jSONArray2 = jSONArray;
            Intrinsics.checkNotNullParameter(runtime, "runtime");
            if (jSONArray2 == null || jSONArray.length() <= 0) {
                if (bVar != null) {
                    bVar.a(str, new c.a[0], new boolean[0], new Object[0], com.tencent.luggage.wxa.tn.w0.c(), com.tencent.luggage.wxa.tn.w0.c());
                    return;
                }
                return;
            }
            if (jVar == null || mVar == null) {
                return;
            }
            String appId = runtime.getAppId();
            long c16 = com.tencent.luggage.wxa.tn.w0.c();
            c.a[] aVarArr = new c.a[jSONArray.length()];
            int length = jSONArray.length();
            boolean[] zArr3 = new boolean[length];
            for (int i17 = 0; i17 < length; i17++) {
                zArr3[i17] = false;
            }
            Object[] objArr2 = new Object[jSONArray.length()];
            int length2 = jSONArray.length();
            int i18 = 0;
            while (i18 < length2) {
                b bVar2 = null;
                String optString = jSONArray2.optString(i18, null);
                if (optString == null) {
                    i3 = i18;
                    i16 = length2;
                    zArr2 = zArr3;
                    objArr = objArr2;
                } else {
                    if (i18 == jSONArray.length() - 1) {
                        str2 = optString;
                        aVar = null;
                        i3 = i18;
                        i16 = length2;
                        zArr = zArr3;
                        objArr = objArr2;
                        bVar2 = new b(bVar, str, aVarArr, zArr3, objArr2, c16);
                    } else {
                        str2 = optString;
                        aVar = null;
                        i3 = i18;
                        i16 = length2;
                        zArr = zArr3;
                        objArr = objArr2;
                    }
                    m.a openReadPartialInfo = mVar.openReadPartialInfo(str2);
                    if (openReadPartialInfo == null) {
                        com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.JsApiLoadJsFiles", "loadJsFiles appId[" + appId + "] path[" + str2 + "] EMPTY");
                        if (bVar2 != null) {
                            bVar2.onReceiveValue("404");
                        }
                        aVarArr[i3] = aVar;
                        zArr[i3] = false;
                        objArr[i3] = aVar;
                        zArr2 = zArr;
                    } else {
                        c.a a16 = a(openReadPartialInfo);
                        a16.f134095i = str2;
                        aVarArr[i3] = a16;
                        InputStream b16 = mVar.b(str2);
                        Intrinsics.checkNotNull(b16);
                        String iOUtils = IOUtils.toString(b16, Charsets.UTF_8);
                        if (iOUtils == null) {
                            iOUtils = "";
                        }
                        a16.f134096j = iOUtils;
                        a16.f134097k = iOUtils.length();
                        zArr2 = zArr;
                        com.tencent.luggage.wxa.uk.x.a(jVar, iOUtils, new C6054a(zArr, i3, bVar2));
                    }
                }
                i18 = i3 + 1;
                jSONArray2 = jSONArray;
                zArr3 = zArr2;
                length2 = i16;
                objArr2 = objArr;
            }
        }
    }
}
