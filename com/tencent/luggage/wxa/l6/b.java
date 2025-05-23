package com.tencent.luggage.wxa.l6;

import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 84;

    @NotNull
    public static final String NAME = "checkJsApi";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133058a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public String ERR_MSG_TAG() {
        return "err_msg";
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039 A[Catch: JSONException -> 0x0062, TryCatch #0 {JSONException -> 0x0062, blocks: (B:9:0x001a, B:11:0x0027, B:13:0x002d, B:18:0x0039, B:20:0x0044, B:24:0x0047), top: B:8:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invoke(com.tencent.luggage.wxa.k6.b env, JSONObject jSONObject, int i3) {
        JSONArray jSONArray;
        boolean z16;
        Intrinsics.checkNotNullParameter(env, "env");
        if (jSONObject != null) {
            jSONArray = jSONObject.optJSONArray("jsApiList");
        } else {
            jSONArray = null;
        }
        if (jSONArray == null) {
            env.a(i3, "fail:param is empty");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            int length = jSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                String optString = jSONArray.optString(i16);
                if (optString != null && optString.length() != 0) {
                    z16 = false;
                    if (z16) {
                        jSONObject2.put(optString, env.j().containsKey(optString));
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
            env.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new JSONObject().put("checkResult", jSONObject2.toString())));
        } catch (JSONException unused) {
            env.a(i3, makeReturnJson("fail"));
        }
    }
}
