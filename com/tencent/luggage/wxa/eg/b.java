package com.tencent.luggage.wxa.eg;

import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.LinkedList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = 652;

    @Deprecated
    @NotNull
    public static final String NAME = "operateRealtimeData";

    /* renamed from: a, reason: collision with root package name */
    public static final a f124735a = new a(null);

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
    /* renamed from: com.tencent.luggage.wxa.eg.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6164b extends p {

        @Deprecated
        public static final int CTRL_INDEX = 653;

        @Deprecated
        @NotNull
        public static final String NAME = "onRealtimeDataResponse";

        /* renamed from: a, reason: collision with root package name */
        public static final a f124736a = new a(null);

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.eg.b$b$a */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum c {
        HIGH,
        LOW,
        IMMEDIATE;


        /* renamed from: a, reason: collision with root package name */
        public static final a f124737a = new a(null);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final c a(String str) {
                boolean equals;
                Intrinsics.checkNotNullParameter(str, "str");
                for (c cVar : c.values()) {
                    equals = StringsKt__StringsJVMKt.equals(cVar.name(), str, true);
                    if (equals) {
                        return cVar;
                    }
                }
                return c.LOW;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: l, reason: collision with root package name */
        public static final a f124742l = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public String f124743a;

        /* renamed from: b, reason: collision with root package name */
        public String f124744b;

        /* renamed from: c, reason: collision with root package name */
        public int f124745c;

        /* renamed from: d, reason: collision with root package name */
        public int f124746d;

        /* renamed from: e, reason: collision with root package name */
        public int f124747e;

        /* renamed from: f, reason: collision with root package name */
        public int f124748f;

        /* renamed from: g, reason: collision with root package name */
        public int f124749g;

        /* renamed from: h, reason: collision with root package name */
        public c f124750h;

        /* renamed from: i, reason: collision with root package name */
        public long f124751i;

        /* renamed from: j, reason: collision with root package name */
        public int f124752j;

        /* renamed from: k, reason: collision with root package name */
        public EnumC6165b f124753k;

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
        /* renamed from: com.tencent.luggage.wxa.eg.b$d$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public enum EnumC6165b {
            Enqueued(1),
            Succeed(2),
            Failed(3);


            /* renamed from: a, reason: collision with root package name */
            public final int f124758a;

            EnumC6165b(int i3) {
                this.f124758a = i3;
            }

            public final int b() {
                return this.f124758a;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public /* synthetic */ class c {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f124759a;

            static {
                int[] iArr = new int[c.values().length];
                iArr[c.IMMEDIATE.ordinal()] = 1;
                iArr[c.HIGH.ordinal()] = 2;
                iArr[c.LOW.ordinal()] = 3;
                f124759a = iArr;
            }
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f124744b = str;
        }

        public final void b(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f124743a = str;
        }

        public final String c() {
            String str = this.f124743a;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instanceId");
            return null;
        }

        public final c d() {
            c cVar = this.f124750h;
            if (cVar != null) {
                return cVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("priority");
            return null;
        }

        public final void e() {
            String str;
            LinkedList linkedList = new LinkedList();
            linkedList.add(c());
            linkedList.add(b());
            linkedList.add(String.valueOf(this.f124745c));
            linkedList.add(String.valueOf(this.f124746d));
            linkedList.add(String.valueOf(this.f124747e));
            linkedList.add(String.valueOf(this.f124748f));
            linkedList.add(String.valueOf(this.f124749g));
            int i3 = c.f124759a[d().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        str = "3";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    str = "2";
                }
            } else {
                str = "1";
            }
            linkedList.add(str);
            linkedList.add(String.valueOf(this.f124751i));
            linkedList.add(String.valueOf(this.f124752j));
            linkedList.add(String.valueOf(a().b()));
            String join = StringUtils.join(linkedList, ",");
            w.a("Luggage.JsApiOperateRealtimeReport.ReportKVItem", "report 26761, " + join);
            com.tencent.luggage.wxa.zj.d dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
            if (dVar != null) {
                dVar.a(26761, join);
            }
        }

        public final void a(int i3) {
            this.f124748f = i3;
        }

        public final String b() {
            String str = this.f124744b;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("appId");
            return null;
        }

        public final void c(int i3) {
            this.f124752j = i3;
        }

        public final void a(c cVar) {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.f124750h = cVar;
        }

        public final void b(int i3) {
            this.f124749g = i3;
        }

        public final void a(long j3) {
            this.f124751i = j3;
        }

        public final EnumC6165b a() {
            EnumC6165b enumC6165b = this.f124753k;
            if (enumC6165b != null) {
                return enumC6165b;
            }
            Intrinsics.throwUninitializedPropertyAccessException("action");
            return null;
        }

        public final void a(EnumC6165b enumC6165b) {
            Intrinsics.checkNotNullParameter(enumC6165b, "<set-?>");
            this.f124753k = enumC6165b;
        }

        public final void a(com.tencent.luggage.wxa.ic.d dVar) {
            g runtime;
            i S = (dVar == null || (runtime = dVar.getRuntime()) == null) ? null : runtime.S();
            com.tencent.luggage.wxa.j4.d dVar2 = S instanceof com.tencent.luggage.wxa.j4.d ? (com.tencent.luggage.wxa.j4.d) S : null;
            String k3 = dVar2 != null ? dVar2.k() : null;
            if (k3 == null) {
                k3 = "";
            }
            b(k3);
            String appId = dVar != null ? dVar.getAppId() : null;
            a(appId != null ? appId : "");
            this.f124745c = dVar2 != null ? dVar2.V : 0;
            this.f124746d = (dVar2 != null ? dVar2.d() : -1) + 1;
            this.f124747e = (dVar2 != null ? dVar2.I : -1000) + 1000;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null || jSONObject == null) {
            return;
        }
        try {
            String content = jSONObject.getString("content");
            if (content.length() >= 65536) {
                dVar.a(i3, makeReturnJson("fail too large data"));
                return;
            }
            try {
                int i16 = jSONObject.getInt("type");
                try {
                    c.a aVar = c.f124737a;
                    String string = jSONObject.getString("priority");
                    Intrinsics.checkNotNullExpressionValue(string, "data.getString(\"priority\")");
                    c a16 = aVar.a(string);
                    try {
                        int i17 = jSONObject.getInt("id");
                        try {
                            e eVar = e.f124762a;
                            Intrinsics.checkNotNullExpressionValue(content, "content");
                            eVar.a(dVar, i17, i16, content, a16);
                            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                        } catch (Exception e16) {
                            dVar.a(i3, makeReturnJson("fail:internal error " + e16.getMessage()));
                        }
                    } catch (JSONException unused) {
                        dVar.a(i3, makeReturnJson("fail:invalid data id"));
                    }
                } catch (JSONException unused2) {
                    dVar.a(i3, makeReturnJson("fail:invalid data priority"));
                }
            } catch (JSONException unused3) {
                dVar.a(i3, makeReturnJson("fail:invalid data type"));
            }
        } catch (JSONException unused4) {
            dVar.a(i3, makeReturnJson("fail:invalid data content"));
        }
    }
}
