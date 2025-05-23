package com.tencent.map.tools.net;

import android.os.Bundle;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.mapsdk.internal.md;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetConfig {
    private Bundle mArguments;
    private HashMap<String, String> mNetFlowRuleList;
    private List<HttpProxyRule> mProxyRuleList;
    private HashMap<String, Map<String, String>> mRegionHostList;
    private String mSecretKey;
    private Class<? extends md> processorClass;
    private AdapterType mAdapterType = AdapterType.URL;
    private boolean mForceHttps = true;
    private boolean mIsLogEnable = false;

    NetConfig() {
    }

    public static NetConfig create() {
        return new NetConfig();
    }

    public AdapterType getAdapterType() {
        return this.mAdapterType;
    }

    public Bundle getArguments() {
        return this.mArguments;
    }

    public HashMap<String, String> getNetFlowRuleList() {
        return this.mNetFlowRuleList;
    }

    public Class<? extends md> getProcessor() {
        return this.processorClass;
    }

    public List<HttpProxyRule> getProxyRuleList() {
        return this.mProxyRuleList;
    }

    public HashMap<String, Map<String, String>> getRegionHostList() {
        return this.mRegionHostList;
    }

    public String getSecretKey() {
        return this.mSecretKey;
    }

    public boolean isForceHttps() {
        return this.mForceHttps;
    }

    public boolean isLogEnable() {
        return this.mIsLogEnable;
    }

    public NetConfig setAdapterType(AdapterType adapterType) {
        this.mAdapterType = adapterType;
        return this;
    }

    public NetConfig setArguments(Bundle bundle) {
        this.mArguments = bundle;
        return this;
    }

    public NetConfig setForceHttps(boolean z16) {
        this.mForceHttps = z16;
        return this;
    }

    public NetConfig setLogEnable(boolean z16) {
        this.mIsLogEnable = z16;
        return this;
    }

    public NetConfig setNetFlowRuleList(HashMap<String, String> hashMap) {
        this.mNetFlowRuleList = hashMap;
        return this;
    }

    public NetConfig setProcessor(Class<? extends md> cls) {
        this.processorClass = cls;
        return this;
    }

    public NetConfig setProxyRuleList(List<HttpProxyRule> list) {
        this.mProxyRuleList = list;
        return this;
    }

    public NetConfig setRegionHostList(HashMap<String, Map<String, String>> hashMap) {
        this.mRegionHostList = hashMap;
        return this;
    }

    public NetConfig setSecretKey(String str) {
        this.mSecretKey = str;
        return this;
    }
}
