package com.tencent.sonic.sdk;

/* compiled from: P */
/* loaded from: classes25.dex */
interface SonicSessionCallback {
    void onSessionDataUpdated(String str);

    void onSessionDestroy();

    void onSessionFirstLoad(String str);

    void onSessionHitCache();

    void onSessionHttpError(int i3);

    void onSessionLoadLocalCache(String str);

    void onSessionSaveCache(String str, String str2, String str3);

    void onSessionTemplateChanged(String str);

    void onSessionUnAvailable();

    void onSonicSessionRefresh();

    void onSonicSessionStart();
}
