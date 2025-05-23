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
public final class a extends k {

    /* renamed from: b, reason: collision with root package name */
    public static final C6383a f131972b = new C6383a(null);

    @NotNull
    private static final String NAME = "hideStatusBar";
    private static final int CTRL_INDEX = 471;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kg.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6383a {
        public C6383a() {
        }

        public /* synthetic */ C6383a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a() {
        super(i.class);
    }

    @Override // com.tencent.luggage.wxa.yf.k
    public void a(com.tencent.luggage.wxa.ic.d env, JSONObject data, int i3, i ext) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        ext.a();
        env.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
