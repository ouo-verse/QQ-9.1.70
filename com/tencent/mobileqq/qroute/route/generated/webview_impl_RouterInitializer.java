package com.tencent.mobileqq.qroute.route.generated;

import com.tencent.mobileqq.emotionintegrate.media.QQEmoticonWinkOutputRouter;
import com.tencent.mobileqq.qroute.route.InterceptorMetaData;
import com.tencent.mobileqq.qroute.route.RouteMetaData;
import com.tencent.mobileqq.qroute.route.f;
import com.tencent.mobileqq.qroute.route.i;
import java.lang.reflect.Constructor;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class webview_impl_RouterInitializer implements i, f {
    private Constructor interceptorMetaDataConstructor;
    private Constructor routeMetaDataConstructor;

    public webview_impl_RouterInitializer() {
        Class cls = Integer.TYPE;
        this.routeMetaDataConstructor = RouteMetaData.class.getConstructor(cls, String.class, String.class, cls, String.class, String.class, String.class);
        this.interceptorMetaDataConstructor = InterceptorMetaData.class.getConstructor(cls, String.class, String.class, String.class, String.class, String.class);
    }

    @Override // com.tencent.mobileqq.qroute.route.i
    public void loadIntoRoute(Map map) {
        map.put(QQEmoticonWinkOutputRouter.ROUTE_PATH, (RouteMetaData) this.routeMetaDataConstructor.newInstance(new Integer(0), "", "", new Integer(-1), "com.tencent.mobileqq.emotionintegrate.media.QQEmoticonWinkOutputRouter", QQEmoticonWinkOutputRouter.ROUTE_PATH, "com.tencent.mobileqq.emotionintegrate.media.QQEmoticonWinkOutputRouter"));
    }

    @Override // com.tencent.mobileqq.qroute.route.f
    public void loadIntoInterceptor(Map map) {
    }
}
