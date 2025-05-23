package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public interface ReportProxy {
    public static final String COUNTER_EVENT_LOAD = "guild_mini_container_load";
    public static final String COUNTER_EVENT_WHITE_SCREEN = "guild_mini_container_white_screen";

    void report(String str, Map<String, String> map);

    void reportContainerTimeCost(Map<String, String> map, long j3);

    void reportCounter(String str, boolean z16, HashMap<String, String> hashMap);

    void reportMiniGameCenterDC00087(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, String> map);
}
