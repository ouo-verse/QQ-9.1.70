package com.tencent.qzonehub.api.utils;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneHardwareRestriction extends QRouteApi {
    public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/files/";
    public static final int BUFFER_SIZE = 1024;
    public static final int HARDWARE_HIGHLEVEL = 2;
    public static final int HARDWARE_LOWLEVEL = 0;
    public static final int HARDWARE_MIDDLELEVEL = 1;
    public static final int HARDWARE_SUPERLEVEL = 3;
    public static final String TAG = "QzoneHardwareRestriction";

    boolean equalHardwareRestriction(int i3, int i16);

    long getAvailableMem();

    long getCpuMaxFreq();

    int getCurrentCpuFreSumLevel();

    int getCurrentCpuLevel();

    int getCurrentMemLevel();

    int getCurrentMemLevelNew();

    @SuppressLint({"NewApi"})
    int getNumberOfCores();

    long getSDCardAllSize();

    long getSDCardAvailableSize();

    long getSystemAvailableSize();

    long getTotalMem();

    boolean meetHardwareRestriction(int i3, int i16);
}
