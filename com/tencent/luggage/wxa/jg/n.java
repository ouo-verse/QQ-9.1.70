package com.tencent.luggage.wxa.jg;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    private static final int CTRL_INDEX = 919;

    @Deprecated
    @NotNull
    private static final String NAME = "getSystemInfoAsync";

    /* renamed from: a, reason: collision with root package name */
    public static final a f131114a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, n nVar) {
        if (dVar != null) {
            dVar.a(i3, nVar.makeReturnJson("fail:not supported"));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.xd.o oVar;
        m mVar = null;
        if (dVar != null) {
            oVar = dVar.a("getSystemInfo");
        } else {
            oVar = null;
        }
        if (oVar instanceof m) {
            mVar = (m) oVar;
        }
        if (mVar == null) {
            a(dVar, i3, this);
        } else if (dVar != null) {
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, (Map<String, ? extends Object>) mVar.b(dVar)));
        }
    }
}
