package com.tencent.luggage.wxa.l6;

import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -3;

    @NotNull
    public static final String NAME = "preVerifyJSAPI";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133086a = new a(null);

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
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k6.b f133087a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f133088b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f133089c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.k6.b bVar, int i3, l lVar) {
            super(0);
            this.f133087a = bVar;
            this.f133088b = i3;
            this.f133089c = lVar;
        }

        public final void a() {
            this.f133087a.a(this.f133088b, this.f133089c.b(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k6.b f133090a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f133091b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f133092c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.k6.b bVar, int i3, l lVar) {
            super(1);
            this.f133090a = bVar;
            this.f133091b = i3;
            this.f133092c = lVar;
        }

        public final void a(String str) {
            boolean z16;
            String str2;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                str2 = "fail";
            } else {
                str2 = "fail_" + str;
            }
            this.f133090a.a(this.f133091b, this.f133092c.b(str2));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.INSTANCE;
        }
    }

    public final String b(String str) {
        String jSONObject = new JSONObject().put("err_msg", "pre_verify_jsapi:" + str).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n           \u2026)\n            .toString()");
        return jSONObject;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.k6.b env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        if (jSONObject == null) {
            return;
        }
        env.p().a(jSONObject, new b(env, i3, this), new c(env, i3, this));
    }
}
