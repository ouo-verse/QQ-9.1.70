package com.tencent.mobileqq.icgame.data.config;

import com.tencent.mobileqq.qqlive.data.config.CustomData;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveSDKConfig {
    public ConfigData appConfig;
    public CustomData customData;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Builder {
        private QQLiveSDKConfig config = new QQLiveSDKConfig();

        Builder() {
        }

        public Builder appConfig(ConfigData configData) {
            this.config.appConfig = configData;
            return this;
        }

        public QQLiveSDKConfig build() {
            return this.config;
        }

        public Builder customData(CustomData customData) {
            this.config.customData = customData;
            return this;
        }
    }

    QQLiveSDKConfig() {
    }

    public static Builder createBuilder() {
        return new Builder();
    }
}
