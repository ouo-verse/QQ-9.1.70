package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.kj.w0;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class q0 extends k {

    @Deprecated
    public static final int CTRL_INDEX = 584;

    @Deprecated
    @NotNull
    public static final String NAME = "private_setPageOrientation";

    /* renamed from: b, reason: collision with root package name */
    public static final a f145743b = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public q0() {
        super(w0.class);
    }

    public static final void b(com.tencent.luggage.wxa.ic.d dVar, int i3, q0 q0Var) {
        dVar.a(i3, q0Var.makeReturnJson("fail:invalid data"));
    }

    @Override // com.tencent.luggage.wxa.yf.k
    public void a(com.tencent.luggage.wxa.ic.d env, JSONObject data, int i3, w0 ext) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        String optString = data.optString("orientation", null);
        if (optString == null) {
            a(env, i3, this);
            return;
        }
        if (e.b.a(optString) == null) {
            b(env, i3, this);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(getName(), optString);
        Unit unit = Unit.INSTANCE;
        ext.a(optString, hashMap);
        env.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }

    public static final void a(com.tencent.luggage.wxa.ic.d dVar, int i3, q0 q0Var) {
        dVar.a(i3, q0Var.makeReturnJson("fail:invalid data"));
    }
}
