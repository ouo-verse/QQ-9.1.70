package com.tencent.luggage.wxa.l6;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 0;

    @NotNull
    public static final String NAME = "log";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133098a = new a(null);

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

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.k6.b env, JSONObject jSONObject, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(env, "env");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("msg:");
        if (jSONObject != null) {
            str = jSONObject.optString("msg");
        } else {
            str = null;
        }
        sb5.append(str);
        w.d("Luggage.STANDALONE.HTMLWebViewJsApiSystemLog", sb5.toString());
        env.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
