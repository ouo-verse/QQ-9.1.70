package com.tencent.luggage.wxa.l6;

import com.tencent.luggage.wxa.jg.j;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 16;

    @NotNull
    public static final String NAME = "getNetworkType";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133073a = new a(null);

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
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f133074a;

        static {
            int[] iArr = new int[j.g.values().length];
            iArr[j.g.Wifi.ordinal()] = 1;
            iArr[j.g.Mobile_2g.ordinal()] = 2;
            iArr[j.g.Mobile_3g.ordinal()] = 3;
            iArr[j.g.Mobile_4g.ordinal()] = 4;
            iArr[j.g.Mobile_5g.ordinal()] = 5;
            f133074a = iArr;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.k6.b env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        JSONObject put = new JSONObject().put("simtype", 0);
        int i16 = b.f133074a[com.tencent.luggage.wxa.jg.j.a(z.c()).ordinal()];
        if (i16 == 1) {
            env.a(i3, a(this, "network_type:wifi", null, 2, null));
            return;
        }
        if (i16 == 2) {
            put.put("subtype", QADNetStatus.G_2);
            env.a(i3, a("network_type:wwan", put));
            return;
        }
        if (i16 == 3) {
            put.put("subtype", QADNetStatus.G_3);
            env.a(i3, a("network_type:wwan", put));
        } else if (i16 == 4) {
            put.put("subtype", QADNetStatus.G_4);
            env.a(i3, a("network_type:wwan", put));
        } else if (i16 != 5) {
            env.a(i3, a(this, "network_type:fail", null, 2, null));
        } else {
            put.put("subtype", QADNetStatus.G_5);
            env.a(i3, a("network_type:wwan", put));
        }
    }

    public static /* synthetic */ String a(g gVar, String str, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            jSONObject = null;
        }
        return gVar.a(str, jSONObject);
    }

    public final String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.put("err_msg", str).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "values ?: JSONObject()).\u2026G_TAG, errMsg).toString()");
        return jSONObject2;
    }
}
