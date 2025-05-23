package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class r extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = -2;

    @Deprecated
    @NotNull
    public static final String NAME = "rewriteRoute";

    /* renamed from: a, reason: collision with root package name */
    public static final a f145744a = new a(null);

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
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145745a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145746b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f145747c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f145748d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ r f145749e;

        public b(com.tencent.luggage.wxa.ic.d dVar, int i3, String str, int i16, r rVar) {
            this.f145745a = dVar;
            this.f145746b = i3;
            this.f145747c = str;
            this.f145748d = i16;
            this.f145749e = rVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            try {
                boolean b16 = this.f145745a.getRuntime().Y().b(this.f145746b, this.f145747c);
                com.tencent.luggage.wxa.ic.d dVar = this.f145745a;
                int i3 = this.f145748d;
                r rVar = this.f145749e;
                if (b16) {
                    str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                } else {
                    str = "fail";
                }
                dVar.a(i3, rVar.makeReturnJson(str));
            } catch (UnsupportedOperationException unused) {
                this.f145745a.a(this.f145748d, this.f145749e.makeReturnJson("fail:not supported"));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        String str;
        boolean z16;
        int i16;
        if (dVar == null) {
            return;
        }
        if (jSONObject != null) {
            str = jSONObject.optString("url");
        } else {
            str = null;
        }
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        if (jSONObject != null) {
            i16 = jSONObject.optInt("webviewId", 0);
        } else {
            i16 = 0;
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.JsApiRewriteRoute", "invoke rewriteRoute, webviewId:" + i16 + ", url:" + str2);
        dVar.a(new b(dVar, i16, str2, i3, this));
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }
}
