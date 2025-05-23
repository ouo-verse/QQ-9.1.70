package com.tencent.luggage.wxa.bf;

import com.tencent.luggage.wxa.xd.o;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    private static final int CTRL_INDEX = 908;

    @Deprecated
    @NotNull
    private static final String NAME = "loadWAFile";

    /* renamed from: a, reason: collision with root package name */
    public static final a f122592a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d env, JSONObject jSONObject, int i3) {
        String makeReturnJson;
        Intrinsics.checkNotNullParameter(env, "env");
        o.a a16 = w.f122594a.a(env, "Luggage.JsApiLoadWAFile", jSONObject);
        if (Intrinsics.areEqual(a16.f144873b, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS)) {
            makeReturnJson = makeReturnJsonWithNativeBuffer(env, a16.f144873b, a16.f144872a);
        } else {
            makeReturnJson = makeReturnJson(a16.f144873b, a16.f144872a);
        }
        env.a(i3, makeReturnJson);
    }
}
