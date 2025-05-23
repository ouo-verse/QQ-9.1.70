package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public interface RequestStrategyProxy {
    String addHttpForwardingInfo(String str, Map<String, String> map);

    void addHttpForwardingInfo(JSONObject jSONObject);

    boolean isIPV6Only();

    boolean isOpenIpv6Request();

    void notifyNetWorkStatusChange();
}
