package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class o0 extends l {

    @Deprecated
    public static final int CTRL_INDEX = 533;

    @Deprecated
    @NotNull
    public static final String NAME = "setDisplayOrientation";

    /* renamed from: b, reason: collision with root package name */
    public static final a f145732b = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public o0() {
        super(com.tencent.luggage.wxa.mj.e.class);
    }

    @Override // com.tencent.luggage.wxa.yf.l
    public String a(com.tencent.luggage.wxa.ic.d env, JSONObject data, com.tencent.luggage.wxa.mj.e ext) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        int optInt = data.optInt("orientation", 0);
        String str = optInt != -90 ? optInt != 90 ? "portrait" : "landscape" : "landscapeLeft";
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.PrivateJsApiSetDisplayOrientation", "set display orientation:%s", str);
        ext.a(str);
        String makeReturnJson = makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        Intrinsics.checkNotNullExpressionValue(makeReturnJson, "makeReturnJson(\"ok\")");
        return makeReturnJson;
    }
}
