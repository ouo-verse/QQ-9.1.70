package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSchemeConfig;

/* compiled from: P */
/* loaded from: classes17.dex */
public class GuildSchemaConfig implements IGuildSchemaConfig {
    private final GProSchemeConfig info;

    public GuildSchemaConfig(GProSchemeConfig gProSchemeConfig) {
        this.info = gProSchemeConfig;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSchemaConfig
    public String getSchema() {
        return this.info.getSchema();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSchemaConfig
    public String getText() {
        return this.info.getText();
    }

    public String toString() {
        return "GuildSchemaConfig{mSchema=" + this.info.getSchema() + ",mText=" + this.info.getText() + "}";
    }
}
