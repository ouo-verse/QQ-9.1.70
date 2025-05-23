package com.tencent.luggage.wxa.x6;

import com.tencent.luggage.wxa.v3.m;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 214;

    @NotNull
    public static final String NAME = "checkIsSupportFacialRecognition";

    /* renamed from: a, reason: collision with root package name */
    public static final C6901a f144593a = new C6901a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.x6.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6901a {
        public C6901a() {
        }

        public /* synthetic */ C6901a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f144594a = new b();

        public final Triple a() {
            if (!com.tencent.luggage.wxa.v3.f.c()) {
                return new Triple(10002, "No necessary model found", 0);
            }
            Triple a16 = m.f143124a.a();
            if (a16 == null) {
                return new Triple(0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, 1);
            }
            return a16;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d env, JSONObject data, int i3) {
        String sb5;
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        Triple a16 = b.f144594a.a();
        int intValue = ((Number) a16.component1()).intValue();
        String str = (String) a16.component2();
        int intValue2 = ((Number) a16.component3()).intValue();
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(intValue));
        hashMap.put("libVersionCode", Integer.valueOf(intValue2));
        if (intValue == 0) {
            sb5 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("fail ");
            if (str == null) {
                str = "";
            }
            sb6.append(str);
            sb5 = sb6.toString();
        }
        env.a(i3, makeReturnJson(sb5, hashMap));
    }
}
