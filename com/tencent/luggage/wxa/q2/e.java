package com.tencent.luggage.wxa.q2;

import com.tencent.luggage.wxa.t9.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 711;

    @NotNull
    public static final String NAME = "getOAID";

    /* renamed from: a, reason: collision with root package name */
    public static final a f137816a = new a(null);

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
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String h16 = l.h();
        w.d("Luggage.JsApiGetOAID", "getOAID oaid=" + h16);
        HashMap hashMap = new HashMap();
        Intrinsics.checkNotNull(h16);
        hashMap.put("result", h16);
        Intrinsics.checkNotNull(dVar);
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
