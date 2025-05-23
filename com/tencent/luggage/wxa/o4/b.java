package com.tencent.luggage.wxa.o4;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = -2;

    @Deprecated
    @NotNull
    public static final String NAME = "responseClientRequest";

    /* renamed from: a, reason: collision with root package name */
    public static final a f136145a = new a(null);

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
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null) {
            return;
        }
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("id", 0);
            boolean optBoolean = jSONObject.optBoolean(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
            w.d("Luggage.WXA.JsApiResponseClientRequest", "invoke requestId:" + optInt + ", support:" + optBoolean);
            com.tencent.luggage.wxa.cj.a.f123531h.a(dVar).a(optInt, optBoolean, jSONObject.opt("data"));
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
            return;
        }
        dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
    }
}
