package com.tencent.luggage.wxa.bf;

import com.tencent.luggage.wxa.xd.o;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class w extends com.tencent.luggage.wxa.xd.v {
    private static final int CTRL_INDEX = 909;

    @NotNull
    private static final String NAME = "loadWAFileSync";

    /* renamed from: a, reason: collision with root package name */
    public static final a f122594a = new a(null);

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.ic.d env, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(env, "env");
        o.a a16 = f122594a.a(env, "Luggage.JsApiLoadWAFileSync", jSONObject);
        if (Intrinsics.areEqual(a16.f144873b, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS)) {
            String makeReturnJsonWithNativeBuffer = makeReturnJsonWithNativeBuffer(env, a16.f144873b, a16.f144872a);
            Intrinsics.checkNotNullExpressionValue(makeReturnJsonWithNativeBuffer, "{\n            makeReturn\u2026sg, ret.values)\n        }");
            return makeReturnJsonWithNativeBuffer;
        }
        String makeReturnJson = makeReturnJson(a16.f144873b, a16.f144872a);
        Intrinsics.checkNotNullExpressionValue(makeReturnJson, "{\n            makeReturn\u2026sg, ret.values)\n        }");
        return makeReturnJson;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o.a a(com.tencent.luggage.wxa.ic.d dVar, String TAG, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            Intrinsics.checkNotNullParameter(TAG, "TAG");
            String optString = jSONObject != null ? jSONObject.optString("filename") : null;
            com.tencent.luggage.wxa.tn.w.d(TAG, "invokeSync with filename:" + optString + ", appId:" + dVar.getAppId());
            if (optString == null || optString.length() == 0) {
                return new o.a("fail:invalid data", new Object[0]);
            }
            com.tencent.luggage.wxa.rc.q i3 = dVar.i();
            if (i3 == null) {
                return a(TAG, dVar);
            }
            InputStream a16 = i3.a(optString);
            if (a16 != null) {
                try {
                    o.a a17 = new o.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]).a("arrayBuffer", w.f122594a.a(a16));
                    Intrinsics.checkNotNullExpressionValue(a17, "CallResult(\"ok\").put(\"arrayBuffer\", buffer)");
                    CloseableKt.closeFinally(a16, null);
                    return a17;
                } finally {
                }
            } else {
                return a(TAG, optString, dVar);
            }
        }

        public static final o.a a(String str, com.tencent.luggage.wxa.ic.d dVar) {
            com.tencent.luggage.wxa.tn.w.b(str, "invokeSync get NULL reader, appId:" + dVar.getAppId());
            return new o.a("fail:internal error", new Object[0]);
        }

        public static final o.a a(String str, String str2, com.tencent.luggage.wxa.ic.d dVar) {
            com.tencent.luggage.wxa.tn.w.b(str, "invokeSync filename(" + str2 + ") not found, appId:" + dVar.getAppId());
            return new o.a("fail:file doesn't exist", new Object[0]);
        }

        public final ByteBuffer a(InputStream inputStream) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(inputStream.available());
            if (inputStream instanceof com.tencent.luggage.wxa.h6.a) {
                buffer.put(((com.tencent.luggage.wxa.h6.a) inputStream).a());
            } else {
                buffer.put(ByteBuffer.wrap(com.tencent.luggage.wxa.tk.c.a(inputStream)));
            }
            Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
            return buffer;
        }
    }
}
