package com.tencent.mobileqq.ark.api;

import c91.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import d91.b;
import d91.d;
import d91.f;
import d91.g;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@QRouteFactory
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkConfig extends QRouteApi {
    Map<String, List<a>> getAPIFrequencyConfig();

    b getArkAIKeyWordConfig();

    f getArkFavConfig();

    g getArkPlatformConfig();

    boolean isPANonShow();

    <T extends d> T loadConfig(Class<T> cls);

    void setPANonShow(String str);
}
