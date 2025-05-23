package com.tencent.luggage.wxa.xd;

import com.tencent.luggage.wxa.uk.c0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class q0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 916;

    @NotNull
    public static final String NAME = "getRandomValues";

    /* renamed from: a, reason: collision with root package name */
    public static final a f144878a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null) {
            return;
        }
        int i16 = -1;
        if (jSONObject != null) {
            i16 = jSONObject.optInt("length", -1);
        }
        if (i16 <= 0) {
            dVar.a(i3, makeReturnJson("fail: illegal length"));
            return;
        }
        byte[] bArr = new byte[i16];
        new SecureRandom().nextBytes(bArr);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ByteBuffer a16 = com.tencent.luggage.wxa.uk.c0.a(bArr);
        Intrinsics.checkNotNullExpressionValue(a16, "wrapDirectByteBuffer(byteArray)");
        linkedHashMap.put("randomValues", a16);
        if (c0.b.FAIL_SIZE_EXCEED_LIMIT == com.tencent.luggage.wxa.uk.c0.a(dVar.getJsRuntime(), linkedHashMap, (c0.a) dVar.a(c0.a.class))) {
            dVar.a(i3, makeReturnJson("fail: internal error"));
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetRandomValues", "invoke, convert NativeBuffer fail");
        } else {
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, linkedHashMap));
        }
    }
}
