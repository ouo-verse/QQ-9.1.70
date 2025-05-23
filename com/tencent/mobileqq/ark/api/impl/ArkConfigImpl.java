package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.base.ArkAppCenter;
import com.tencent.mobileqq.ark.config.processor.ArkConfProcessor;
import com.tencent.mobileqq.ark.config.qqmc.ArkEnvironmentConfigParser;
import com.tencent.mobileqq.ark.config.qqmc.ArkFavConfigParser;
import com.tencent.mobileqq.ark.config.qqmc.ArkPlatformConfParser;
import d91.d;
import d91.f;
import d91.g;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkConfigImpl implements IArkConfig {
    @Override // com.tencent.mobileqq.ark.api.IArkConfig
    public Map<String, List<c91.a>> getAPIFrequencyConfig() {
        return com.tencent.mobileqq.ark.b.f199162d;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkConfig
    public d91.b getArkAIKeyWordConfig() {
        return ArkEnvironmentConfigParser.d();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkConfig
    public f getArkFavConfig() {
        return ArkFavConfigParser.c();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkConfig
    public g getArkPlatformConfig() {
        return ArkPlatformConfParser.d();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkConfig
    public boolean isPANonShow() {
        return ArkAppCenter.o();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkConfig
    public <T extends d> T loadConfig(Class<T> cls) {
        return (T) ArkConfProcessor.a(cls);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkConfig
    public void setPANonShow(String str) {
        ArkAppCenter.x(str);
    }
}
