package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetConfig;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class lq implements NetAdapter {

    /* renamed from: b, reason: collision with root package name */
    private static final String f149232b = "NetImpl";

    /* renamed from: a, reason: collision with root package name */
    protected Bundle f149233a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f149235d;

    /* renamed from: e, reason: collision with root package name */
    private List<HttpProxyRule> f149236e;

    /* renamed from: i, reason: collision with root package name */
    private String f149240i;

    /* renamed from: c, reason: collision with root package name */
    private boolean f149234c = true;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, String> f149237f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private final HashSet<Class<? extends md>> f149238g = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<String, Map<String, String>> f149239h = new HashMap<>();

    private void a(boolean z16) {
        this.f149234c = z16;
    }

    private void b(boolean z16) {
        this.f149235d = z16;
    }

    protected abstract NetResponse a(NetRequest netRequest);

    protected abstract void a();

    protected abstract NetResponse b(NetRequest netRequest);

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doGet(NetRequest netRequest) {
        return a(netRequest);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doPost(NetRequest netRequest) {
        return b(netRequest);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public HashSet<Class<? extends md>> getNetFlowProcessor() {
        return this.f149238g;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public HashMap<String, String> getNetFlowRuleList() {
        return this.f149237f;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public List<HttpProxyRule> getProxyRuleList() {
        return this.f149236e;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public HashMap<String, Map<String, String>> getRegionHostList() {
        return this.f149239h;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public String getSecretKey() {
        return this.f149240i;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public void initNet(Context context, NetConfig netConfig) {
        try {
            this.f149234c = netConfig.isForceHttps();
            this.f149235d = netConfig.isLogEnable();
            this.f149236e = netConfig.getProxyRuleList();
            this.f149237f.putAll(netConfig.getNetFlowRuleList());
            this.f149240i = netConfig.getSecretKey();
            this.f149238g.add(netConfig.getProcessor());
            HashMap<String, Map<String, String>> regionHostList = netConfig.getRegionHostList();
            if (regionHostList != null) {
                this.f149239h.putAll(regionHostList);
            }
            this.f149233a = netConfig.getArguments();
            a();
        } catch (Exception e16) {
            LogUtil.e(f149232b, "initNet error:" + e16.toString());
        }
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public boolean isForceHttps() {
        return this.f149234c;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public boolean isLogEnable() {
        return this.f149235d;
    }

    private void a(List<HttpProxyRule> list) {
        this.f149236e = list;
    }

    private void b(String str) {
        this.f149240i = str;
    }

    private void a(HashMap<String, String> hashMap) {
        this.f149237f.putAll(hashMap);
    }

    private void b(HashMap<String, Map<String, String>> hashMap) {
        if (hashMap != null) {
            this.f149239h.putAll(hashMap);
        }
    }

    private void a(Class<? extends md> cls) {
        this.f149238g.add(cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str) {
        if (str != null) {
            String[] split = str.split(";");
            int length = split.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                String str2 = split[i3];
                if (str2.contains(HttpMsg.CHARSET)) {
                    String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2.length > 1) {
                        return split2[1].trim();
                    }
                } else {
                    i3++;
                }
            }
        }
        return "GBK";
    }
}
