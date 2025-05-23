package com.tencent.ecommerce.base.config.mock;

import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import kotlin.Metadata;
import vf0.ECTabExpEntityInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/base/config/mock/IECTabRemoteConfigMockModel;", "", "", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "Lvf0/a;", "getTabConfig", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface IECTabRemoteConfigMockModel {
    ECTabExpEntityInfo getTabConfig(String expName);
}
