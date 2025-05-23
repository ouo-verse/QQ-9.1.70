package com.tencent.map.tools.net.adapter;

import android.content.Context;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetConfig;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.mapsdk.internal.lr;
import com.tencent.mapsdk.internal.md;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class URLNetImpl implements NetAdapter {
    private NetAdapter mProxy = new lr();

    @Override // com.tencent.map.tools.net.NetAdapter
    public boolean cancel() {
        return this.mProxy.cancel();
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doGet(NetRequest netRequest) {
        return this.mProxy.doGet(netRequest);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doPost(NetRequest netRequest) {
        return this.mProxy.doPost(netRequest);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doRequest(NetRequest netRequest) {
        return this.mProxy.doRequest(netRequest);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public HashSet<Class<? extends md>> getNetFlowProcessor() {
        return this.mProxy.getNetFlowProcessor();
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public HashMap<String, String> getNetFlowRuleList() {
        return this.mProxy.getNetFlowRuleList();
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public List<HttpProxyRule> getProxyRuleList() {
        return this.mProxy.getProxyRuleList();
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public HashMap<String, Map<String, String>> getRegionHostList() {
        return this.mProxy.getRegionHostList();
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public String getSecretKey() {
        return this.mProxy.getSecretKey();
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public void initNet(Context context, NetConfig netConfig) {
        this.mProxy.initNet(context, netConfig);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public boolean isForceHttps() {
        return this.mProxy.isForceHttps();
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public boolean isLogEnable() {
        return this.mProxy.isLogEnable();
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse openStream(NetRequest netRequest) {
        return this.mProxy.openStream(netRequest);
    }

    public void setProxyAdapter(NetAdapter netAdapter) {
        this.mProxy = netAdapter;
    }
}
