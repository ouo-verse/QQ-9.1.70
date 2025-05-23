package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.hippykotlin.demo.pages.foundation.model.QQKuiklySupport;
import com.tencent.kuikly.core.module.Module;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQKuiklyAdModule extends Module {
    public static final Companion Companion = new Companion();

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    static {
        MapsKt__MapsKt.mapOf(TuplesKt.to("handleClick", new QQKuiklySupport()), TuplesKt.to("getDeviceInfo", new QQKuiklySupport()), TuplesKt.to("getViewPosInfo", new QQKuiklySupport()), TuplesKt.to("openAdFeedBackDialog", new QQKuiklySupport()), TuplesKt.to("jumpAppSchema", new QQKuiklySupport()), TuplesKt.to("initQZoneAdReqDeviceInfo", new QQKuiklySupport()), TuplesKt.to("getQZoneAdReqParam", new QQKuiklySupport()));
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QQKuiklyAdModule";
    }
}
