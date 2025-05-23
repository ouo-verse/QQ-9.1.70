package com.tencent.luggage.wxa.kg;

import com.tencent.luggage.wxa.mj.i;
import com.tencent.luggage.wxa.yf.k;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends k {

    /* renamed from: b, reason: collision with root package name */
    public static final a f131979b = new a(null);

    @Deprecated
    @NotNull
    private static final String NAME = "showStatusBar";

    @Deprecated
    private static final int CTRL_INDEX = 470;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c() {
        super(i.class);
    }

    @Override // com.tencent.luggage.wxa.yf.k
    public void a(com.tencent.luggage.wxa.ic.d env, JSONObject data, int i3, i ext) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        ext.b();
        env.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
