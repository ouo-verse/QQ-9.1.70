package com.tencent.aelight.camera.util.api;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IVSConfigManager extends QRouteApi {
    public static final String SMART_CUT_PIC_COUNT = "SmartCutPicCount";
    public static final long SMART_CUT_PIC_COUNT_DEFVALUE = 10;
    public static final String SMART_CUT_PIC_INTERVAL = "SmartCutPicSpacing";
    public static final long SMART_CUT_PIC_INTERVAL_DEFVALUE = 500;
    public static final String SMART_CUT_PIC_MAX_BYTE = "SmartCutPicMaxByte";
    public static final long SMART_CUT_PIC_MAX_BYTE_DEFVALUE = 90000;
    public static final String SMART_CUT_PIC_QUALITY_AND = "SmartCutPicQuality_And";
    public static final long SMART_CUT_PIC_QUALITY_AND_DEFVALUE = 80;
    public static final String SMART_CUT_PIC_WIDTH = "SmartCutPicWidth";
    public static final long SMART_CUT_PIC_WIDTH_DEFVALUE = 224;

    <V> V getValue(@NonNull String str, @NonNull V v3);

    <V> void setValue(String str, V v3);
}
