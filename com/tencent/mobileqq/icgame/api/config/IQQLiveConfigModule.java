package com.tencent.mobileqq.icgame.api.config;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.data.config.ConfigData;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IQQLiveConfigModule extends IQQLiveModule {
    ConfigData getConfigData();

    void init(IQQLiveSDK iQQLiveSDK, ConfigData configData);
}
