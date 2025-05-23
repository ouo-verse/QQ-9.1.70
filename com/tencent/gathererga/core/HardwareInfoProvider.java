package com.tencent.gathererga.core;

import android.content.Context;

/* loaded from: classes6.dex */
public interface HardwareInfoProvider extends com.tencent.gathererga.core.internal.c {
    public static final String HARMONY_OS = "harmony";
    public static final int HARMONY_PURE_MODE_UNKNOWN = -1;

    f getAndroidId(e eVar);

    f getBoard(e eVar);

    f getBrand(e eVar);

    f getDevice(e eVar);

    f getDeviceHeightAndWidth(e eVar);

    f getDeviceId(e eVar);

    f getDeviceId0(e eVar);

    f getDeviceId1(e eVar);

    f getDpi(e eVar);

    f getFileNode(e eVar, String str);

    f getHarmonyOsVersion(e eVar);

    f getHarmonyPureMode(e eVar);

    f getImei(e eVar);

    f getImei0(e eVar);

    f getImei1(e eVar);

    f getImsi(e eVar);

    f getImsi0(e eVar);

    f getImsi1(e eVar);

    f getIsHarmonyOs(e eVar);

    f getManufacturer(e eVar);

    f getMeid(e eVar);

    f getMeid0(e eVar);

    f getMeid1(e eVar);

    f getModel(e eVar);

    f getOpenHarmonyVersion(e eVar);

    f getRamSize(e eVar);

    f getRomSize(e eVar);

    f getScreenWidthBucket(e eVar);

    f getTime(e eVar);

    @Override // com.tencent.gathererga.core.internal.c
    /* synthetic */ void onInit(Context context);
}
