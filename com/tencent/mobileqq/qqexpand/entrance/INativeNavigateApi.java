package com.tencent.mobileqq.qqexpand.entrance;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface INativeNavigateApi extends QRouteApi {
    void navigateBySchema(String str);

    void navigateMiniApp(String str);

    void navigateWebView(String str);

    void navigateWithoutSchema(String str, Map<Object, Object> map, Map<Object, Object> map2);
}
