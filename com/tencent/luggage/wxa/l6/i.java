package com.tencent.luggage.wxa.l6;

import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 295;

    @NotNull
    public static final String NAME = "invokeMiniProgramAPI";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133076a = new a(null);

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
    /* loaded from: classes8.dex */
    public static final class b extends com.tencent.luggage.wxa.xd.p {

        @Deprecated
        private static final int CTRL_INDEX = 301;

        @Deprecated
        @NotNull
        private static final String NAME = "WEB_INVOKE_APPSERVICE";

        /* renamed from: a, reason: collision with root package name */
        public static final a f133077a = new a(null);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
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
        if (jSONObject != null) {
            str = jSONObject.optString("name");
        } else {
            str = null;
        }
        if (str == null) {
            env.a(i3, com.tencent.luggage.wxa.l6.a.f133053a.d());
        } else {
            env.a(new b().setData("name", str).setData("arg", jSONObject.opt("arg")), new int[]{0});
            env.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }
}
