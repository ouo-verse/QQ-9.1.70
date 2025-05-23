package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class m extends com.tencent.luggage.wxa.xd.v {

    @Deprecated
    public static final int CTRL_INDEX = -2;

    @Deprecated
    @NotNull
    public static final String NAME = "initReadyAfterRenderingCache";

    /* renamed from: a, reason: collision with root package name */
    public static final a f145725a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.kj.v vVar, JSONObject jSONObject) {
        if (vVar != null) {
            vVar.e(NAME);
        }
        String makeReturnJson = makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        Intrinsics.checkNotNullExpressionValue(makeReturnJson, "makeReturnJson(\"ok\")");
        return makeReturnJson;
    }
}
