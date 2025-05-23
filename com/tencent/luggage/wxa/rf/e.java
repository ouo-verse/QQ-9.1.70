package com.tencent.luggage.wxa.rf;

import com.tencent.luggage.wxa.xd.f0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEnumTableID;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 788;

    @NotNull
    public static final String NAME = "isSupportNFC";

    /* renamed from: a, reason: collision with root package name */
    public static final a f139633a = new a(null);

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
        HashMap hashMapOf;
        if (dVar == null) {
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(f0.class));
        if (!com.tencent.luggage.wxa.tf.d.c()) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", Integer.valueOf(GProEnumTableID.ENUMTABLEIDQGROUPFEEDACTOPT)));
            dVar.a(i3, j.a(this, GProEnumTableID.ENUMTABLEIDQGROUPFEEDACTOPT, "fail", hashMapOf));
        } else {
            dVar.a(i3, j.a(this, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, null, 4, null));
        }
    }
}
