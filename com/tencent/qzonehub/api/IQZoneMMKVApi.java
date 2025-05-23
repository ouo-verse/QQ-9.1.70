package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneMMKVApi extends QRouteApi {
    boolean getBooleanValue(String str, boolean z16);

    byte[] getBytes(String str, byte[] bArr);

    float getFloatValue(String str, float f16);

    int getIntValue(String str, int i3);

    long getLongValue(String str, long j3);

    String getStringValue(String str, String str2);

    void handleSaveFeatureSwitch(Map<Integer, Boolean> map, String str);

    void saveBoolean(String str, boolean z16);

    void saveBytes(String str, byte[] bArr);

    void saveFloat(String str, float f16);

    void saveInt(String str, int i3);

    void saveLong(String str, long j3);

    void saveString(String str, String str2);
}
