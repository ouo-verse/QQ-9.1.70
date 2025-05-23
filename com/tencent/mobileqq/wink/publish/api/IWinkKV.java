package com.tencent.mobileqq.wink.publish.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkKV extends QRouteApi {
    Map<String, Object> getAll();

    boolean getBoolean(String str);

    double getDouble(String str);

    float getFloat(String str);

    int getInt(String str);

    String getString(String str);

    void putAll(Map<String, Object> map);

    void putBoolean(String str, boolean z16);

    void putDouble(String str, double d16);

    void putFloat(String str, float f16);

    void putInt(String str, int i3);

    void putString(String str, String str2);
}
