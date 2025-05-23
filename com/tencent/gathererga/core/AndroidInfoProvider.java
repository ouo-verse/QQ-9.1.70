package com.tencent.gathererga.core;

import android.content.Context;

/* loaded from: classes6.dex */
public interface AndroidInfoProvider extends com.tencent.gathererga.core.internal.c {
    f getBuildId(e eVar);

    f getChromeVersionName(e eVar, a aVar);

    f getKernelVersion(e eVar);

    f getManufacturerOSVersion(e eVar);

    f getOsVersion(e eVar);

    f getProcVersion(e eVar);

    f getUUID(e eVar, String str);

    f getVersionCodeName(e eVar);

    f getVersionIncremental(e eVar);

    f getVersionReleaseOrCodename(e eVar);

    f getVmVersion(e eVar);

    @Override // com.tencent.gathererga.core.internal.c
    /* synthetic */ void onInit(Context context);

    f sdCardFreeSpace(e eVar);
}
