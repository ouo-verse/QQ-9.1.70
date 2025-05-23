package com.tencent.luggage.wxa.xd;

import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class w0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 755;

    @NotNull
    public static final String NAME = "returnCopyUrl";

    /* renamed from: a, reason: collision with root package name */
    public static final a f144889a = new a(null);

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
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.r4.d dVar, JSONObject jSONObject, int i3) {
        String str;
        boolean z16;
        String str2;
        if (dVar != null) {
            if (jSONObject != null) {
                str = jSONObject.optString("url");
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "data?.optString(\"url\") ?: \"\"");
            }
            boolean z17 = true;
            if (jSONObject != null && jSONObject.optBoolean("shortLinkEnable", false)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                j1.f144855a.a(y.MP_SHORT_LINK, str);
            } else {
                j1.f144855a.a(y.PAGE_PATH, str);
            }
            com.tencent.luggage.wxa.tn.g.a(com.tencent.luggage.wxa.tn.z.c(), null, str);
            if (str.length() != 0) {
                z17 = false;
            }
            if (z17) {
                str2 = "fail:empty url";
            } else {
                str2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
            dVar.a(i3, makeReturnJson(str2));
        }
    }
}
