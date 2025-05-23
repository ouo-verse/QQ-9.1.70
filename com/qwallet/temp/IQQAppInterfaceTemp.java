package com.qwallet.temp;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQQAppInterfaceTemp extends QRouteApi {
    int getALLGeneralSettingRing(AppInterface appInterface);

    int getALLGeneralSettingVibrate(AppInterface appInterface);

    boolean isPttRecordingOrPlaying(AppInterface appInterface);

    boolean isRingerSilent(AppInterface appInterface);

    boolean isVideoChatting(AppRuntime appRuntime);

    void refreshAppBadge(AppRuntime appRuntime);
}
