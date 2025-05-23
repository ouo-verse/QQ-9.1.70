package com.tencent.gathererga.core;

import android.content.Context;

/* loaded from: classes6.dex */
public interface UserInfoProvider extends com.tencent.gathererga.core.internal.c {
    f getBootTime(e eVar);

    f getBssid(e eVar);

    f getCarrier(e eVar, boolean z16);

    f getCountry(e eVar);

    f getCurrentVolume(e eVar, int i3);

    f getIpAddress(e eVar);

    f getLanguage(e eVar);

    f getLatitude(e eVar);

    f getLocalCountry(e eVar);

    f getLongitude(e eVar);

    f getMaxVolume(e eVar, int i3);

    f getMinVolume(e eVar, int i3);

    f getMobileNetworkType(e eVar);

    f getNetworkType(e eVar);

    f getScreenOrientation(e eVar);

    f getTimeZone(e eVar);

    f getTimeZoneID(e eVar);

    f getUserAgent(e eVar);

    f getWebviewUa(e eVar);

    f isRooted(e eVar);

    @Override // com.tencent.gathererga.core.internal.c
    /* synthetic */ void onInit(Context context);
}
