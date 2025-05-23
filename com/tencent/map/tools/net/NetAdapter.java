package com.tencent.map.tools.net;

import android.content.Context;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.mapsdk.internal.md;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface NetAdapter {
    boolean cancel();

    NetResponse doGet(NetRequest netRequest);

    NetResponse doPost(NetRequest netRequest);

    NetResponse doRequest(NetRequest netRequest);

    HashSet<Class<? extends md>> getNetFlowProcessor();

    HashMap<String, String> getNetFlowRuleList();

    List<HttpProxyRule> getProxyRuleList();

    HashMap<String, Map<String, String>> getRegionHostList();

    String getSecretKey();

    void initNet(Context context, NetConfig netConfig);

    boolean isForceHttps();

    boolean isLogEnable();

    NetResponse openStream(NetRequest netRequest);
}
