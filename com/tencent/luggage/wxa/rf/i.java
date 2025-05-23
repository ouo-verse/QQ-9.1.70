package com.tencent.luggage.wxa.rf;

import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEnumTableID;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f139660a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f139661b;

    static {
        Map mapOf;
        Integer valueOf = Integer.valueOf(TVKEventId.PLAYER_STATE_VIDEO_SIZE_CHANGE);
        com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.e.f121315k;
        Integer valueOf2 = Integer.valueOf(TVKEventId.PLAYER_STATE_AUDIO_EFFECT_TYPE_INFO);
        com.tencent.luggage.wxa.af.c cVar2 = com.tencent.luggage.wxa.af.b.f121275z;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, com.tencent.luggage.wxa.af.e.f121305a), TuplesKt.to(Integer.valueOf(GProEnumTableID.ENUMTABLEIDQGROUPFEEDACTOPT), com.tencent.luggage.wxa.af.b.f121245k), TuplesKt.to(13001, com.tencent.luggage.wxa.af.b.f121249m), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_UPDATE_VIEW), com.tencent.luggage.wxa.af.b.f121247l), TuplesKt.to(valueOf, cVar), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_IS_USE_PROXY), com.tencent.luggage.wxa.af.b.f121251n), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_HDR_INFO_CHANGED), cVar), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_VIDEO_POST_PROCESS_INFO), com.tencent.luggage.wxa.af.b.f121253o), TuplesKt.to(valueOf2, cVar2), TuplesKt.to(13010, com.tencent.luggage.wxa.af.b.f121243j), TuplesKt.to(13019, com.tencent.luggage.wxa.af.b.f121255p), TuplesKt.to(13011, cVar), TuplesKt.to(13012, com.tencent.luggage.wxa.af.b.f121257q), TuplesKt.to(13021, com.tencent.luggage.wxa.af.b.f121259r), TuplesKt.to(13018, com.tencent.luggage.wxa.af.b.f121261s), TuplesKt.to(13022, com.tencent.luggage.wxa.af.b.f121263t), TuplesKt.to(13023, com.tencent.luggage.wxa.af.b.f121265u), TuplesKt.to(13013, com.tencent.luggage.wxa.af.b.f121267v), TuplesKt.to(13014, com.tencent.luggage.wxa.af.b.f121269w), TuplesKt.to(13015, com.tencent.luggage.wxa.af.b.f121271x), TuplesKt.to(13024, com.tencent.luggage.wxa.af.b.f121273y), TuplesKt.to(13017, cVar2));
        f139661b = mapOf;
    }

    public final com.tencent.luggage.wxa.af.c a(int i3) {
        return (com.tencent.luggage.wxa.af.c) f139661b.get(Integer.valueOf(i3));
    }
}
