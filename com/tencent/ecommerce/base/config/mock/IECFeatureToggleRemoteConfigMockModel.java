package com.tencent.ecommerce.base.config.mock;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0003H&\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/config/mock/IECFeatureToggleRemoteConfigMockModel;", "", "getFeatureToggleConfig", "T", "toggleName", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface IECFeatureToggleRemoteConfigMockModel {
    <T> T getFeatureToggleConfig(String toggleName, T defaultValue);
}
