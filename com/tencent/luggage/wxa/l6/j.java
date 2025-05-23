package com.tencent.luggage.wxa.l6;

import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xo.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 250;

    @NotNull
    public static final String NAME = "openWeApp";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133078a = new a(null);

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
    public static final class b implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k6.b f133079a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f133080b;

        public b(com.tencent.luggage.wxa.k6.b bVar, Ref.ObjectRef objectRef) {
            this.f133079a = bVar;
            this.f133080b = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(String str) {
            com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
            Ref.ObjectRef objectRef = this.f133080b;
            bVar.f124086d = str;
            bVar.f124089g = (String) objectRef.element;
            new com.tencent.luggage.wxa.l3.j(bVar, com.tencent.luggage.wxa.j4.o.f130858a.a(), null, null, null, null, false, false, 252, null);
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.p6.c.class));
            this.f133079a.getContext();
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k6.b f133081a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f133082b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f133083c;

        public c(com.tencent.luggage.wxa.k6.b bVar, int i3, j jVar) {
            this.f133081a = bVar;
            this.f133082b = i3;
            this.f133083c = jVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            w.b("MicroMsg.JsApiOpenWeApp", "openWeApp fail: " + obj);
            this.f133081a.a(this.f133082b, this.f133083c.makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public String ERR_MSG_TAG() {
        return "err_msg";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.lang.CharSequence, java.lang.Object, java.lang.String] */
    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.k6.b env, JSONObject data, int i3) {
        boolean contains$default;
        String queryParameter;
        ?? replace$default;
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        String optString = data.optString("userName");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? relativeURL = data.optString("relativeURL");
        objectRef.element = relativeURL;
        Intrinsics.checkNotNullExpressionValue(relativeURL, "relativeURL");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) relativeURL, (CharSequence) "render_data", false, 2, (Object) null);
        if (contains$default && (queryParameter = Uri.parse((String) objectRef.element).getQueryParameter("widgetData")) != null) {
            JSONObject jSONObject = new JSONObject(queryParameter);
            jSONObject.remove("render_data");
            T relativeURL2 = objectRef.element;
            Intrinsics.checkNotNullExpressionValue(relativeURL2, "relativeURL");
            replace$default = StringsKt__StringsJVMKt.replace$default((String) relativeURL2, "(widgetData=.*&)|(widgetData=.*$)", ContainerUtils.FIELD_DELIMITER, false, 4, (Object) null);
            objectRef.element = replace$default;
            objectRef.element = ((String) objectRef.element) + "&widgetData=" + jSONObject;
        }
        data.optInt("appVersion", 0);
        com.tencent.luggage.wxa.i3.m.f129333a.a(optString).a(new b(env, objectRef)).a(new c(env, i3, this));
    }
}
