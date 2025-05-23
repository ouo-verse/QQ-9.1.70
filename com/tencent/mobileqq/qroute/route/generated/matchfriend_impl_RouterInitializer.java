package com.tencent.mobileqq.qroute.route.generated;

import com.tencent.mobileqq.matchfriend.reborn.media.QQStrangerWinkOutputRouter;
import com.tencent.mobileqq.qroute.route.InterceptorMetaData;
import com.tencent.mobileqq.qroute.route.RouteMetaData;
import com.tencent.mobileqq.qroute.route.f;
import com.tencent.mobileqq.qroute.route.i;
import java.lang.reflect.Constructor;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class matchfriend_impl_RouterInitializer implements i, f {
    private Constructor interceptorMetaDataConstructor;
    private Constructor routeMetaDataConstructor;

    public matchfriend_impl_RouterInitializer() {
        Class cls = Integer.TYPE;
        this.routeMetaDataConstructor = RouteMetaData.class.getConstructor(cls, String.class, String.class, cls, String.class, String.class, String.class);
        this.interceptorMetaDataConstructor = InterceptorMetaData.class.getConstructor(cls, String.class, String.class, String.class, String.class, String.class);
    }

    @Override // com.tencent.mobileqq.qroute.route.i
    public void loadIntoRoute(Map map) {
        map.put(QQStrangerWinkOutputRouter.ROUTE_PATH, (RouteMetaData) this.routeMetaDataConstructor.newInstance(new Integer(0), "", "", new Integer(-1), "com.tencent.mobileqq.matchfriend.reborn.media.QQStrangerWinkOutputRouter", QQStrangerWinkOutputRouter.ROUTE_PATH, "com.tencent.mobileqq.matchfriend.reborn.media.QQStrangerWinkOutputRouter"));
    }

    @Override // com.tencent.mobileqq.qroute.route.f
    public void loadIntoInterceptor(Map map) {
    }
}
