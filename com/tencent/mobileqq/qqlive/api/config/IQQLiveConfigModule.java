package com.tencent.mobileqq.qqlive.api.config;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveConfigModule extends IQQLiveModule {
    ConfigData getConfigData();

    void init(IQQLiveSDK iQQLiveSDK, ConfigData configData);
}
