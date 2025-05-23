package com.tencent.luggage.wxa.jg;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p extends com.tencent.luggage.wxa.xd.v {

    @Deprecated
    private static final int CTRL_INDEX = 918;

    @Deprecated
    @NotNull
    private static final String NAME = "getSystemInfoSync";

    /* renamed from: a, reason: collision with root package name */
    public static final a f131115a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.xd.o oVar;
        m mVar = null;
        if (dVar != null) {
            oVar = dVar.a("getSystemInfo");
        } else {
            oVar = null;
        }
        if (oVar instanceof m) {
            mVar = (m) oVar;
        }
        if (mVar == null) {
            String makeReturnJson = makeReturnJson("fail:not supported");
            Intrinsics.checkNotNullExpressionValue(makeReturnJson, "makeReturnJson(Constants\u2026ApiMsg.API_NOT_SUPPORTED)");
            return makeReturnJson;
        }
        String makeReturnJson2 = makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, (Map<String, ? extends Object>) mVar.b(dVar));
        Intrinsics.checkNotNullExpressionValue(makeReturnJson2, "makeReturnJson(\"ok\", legacyImpl.getInfo(env))");
        return makeReturnJson2;
    }
}
