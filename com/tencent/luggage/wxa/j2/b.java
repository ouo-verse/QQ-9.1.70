package com.tencent.luggage.wxa.j2;

import com.tencent.luggage.wxa.bk.e;
import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.s3.f;
import com.tencent.luggage.wxa.t9.l;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 435;

    @NotNull
    public static final String NAME = "adDataReport";

    /* renamed from: a, reason: collision with root package name */
    public static final a f130768a = new a(null);

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
    /* renamed from: com.tencent.luggage.wxa.j2.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6324b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f130769b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130770c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f130771d;

        public C6324b(d dVar, int i3, b bVar) {
            this.f130769b = dVar;
            this.f130770c = i3;
            this.f130771d = bVar;
        }

        public final void a(com.tencent.luggage.wxa.hn.d dVar) {
            if (dVar.f127440e == 0) {
                this.f130769b.a(this.f130770c, this.f130771d.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                return;
            }
            this.f130769b.a(this.f130770c, this.f130771d.makeReturnJson("fail:" + dVar.f127441f));
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((com.tencent.luggage.wxa.hn.d) obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(d component, JSONObject data, int i3) {
        i iVar;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(data, "data");
        StringBuilder sb5 = new StringBuilder();
        g runtime = component.getRuntime();
        i iVar2 = null;
        if (runtime != null) {
            iVar = runtime.S();
        } else {
            iVar = null;
        }
        if (iVar instanceof com.tencent.luggage.wxa.j4.d) {
            g runtime2 = component.getRuntime();
            if (runtime2 != null) {
                iVar2 = runtime2.S();
            }
            Intrinsics.checkNotNull(iVar2, "null cannot be cast to non-null type com.tencent.luggage.sdk.config.AppBrandInitConfigLU");
            e i16 = ((com.tencent.luggage.wxa.j4.d) iVar2).i();
            Intrinsics.checkNotNullExpressionValue(i16, "component?.runtime?.init\u2026dInitConfigLU).statObject");
            sb5.append(i16.f122984c + ',' + i16.f122985d + ',' + i16.f122982a + ',' + i16.f122983b + ',');
        }
        sb5.append(data.optString("adInfo"));
        sb5.append(',' + l.a(false));
        String appId = component.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
        String c16 = f.c();
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "reportStr.toString()");
        com.tencent.luggage.wxa.j2.a.a(appId, c16, 15175, sb6, w0.d()).b(new C6324b(component, i3, this));
    }
}
