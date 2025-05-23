package com.tencent.av.config.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IConfigParser extends QRouteApi {
    public static final String DEFAULT_VALUE = "unknown";

    String getData();

    int getIntValue(String str, int i3);

    int[] getIntValues(String str);

    String getStringValue(String str, String str2);

    String[] getStringValues(String str);

    boolean isEmpty();

    void setData(String str);
}
