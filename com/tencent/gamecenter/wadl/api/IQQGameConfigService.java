package com.tencent.gamecenter.wadl.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameConfigService extends QRouteApi {
    public static final String KEY_CONF_COMM = "comminfo";

    void checkConfigUpdate(boolean z16, long j3);

    <T> T getConfig(String str);

    void handlePushConfigCheck(String str);

    void loadConfig(String str);
}
