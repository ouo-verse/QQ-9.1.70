package com.tencent.aegiskmm.bean;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/aegiskmm/bean/AegisLogType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "PV", "API", "API_SPEED", "CUSTOM_TIME", "CUSTOM_EVENT", "ASSETS_SPEED", "PAGE_PERFORMANCE", "WEB_VITALS", "NATIVE_LOAD_EVENT", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public enum AegisLogType {
    NORMAL("normal"),
    PV("pv"),
    API(DTConstants.TAG.API),
    API_SPEED("api_speed"),
    CUSTOM_TIME("custom_time"),
    CUSTOM_EVENT("custom_event"),
    ASSETS_SPEED("assets_speed"),
    PAGE_PERFORMANCE("page_performance"),
    WEB_VITALS("web_vitals"),
    NATIVE_LOAD_EVENT("native_load_event");

    AegisLogType(String str) {
    }
}
