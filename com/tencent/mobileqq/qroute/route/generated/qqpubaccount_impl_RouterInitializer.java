package com.tencent.mobileqq.qroute.route.generated;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.qroute.route.InterceptorMetaData;
import com.tencent.mobileqq.qroute.route.RouteMetaData;
import com.tencent.mobileqq.qroute.route.f;
import com.tencent.mobileqq.qroute.route.i;
import java.lang.reflect.Constructor;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class qqpubaccount_impl_RouterInitializer implements i, f {
    private Constructor interceptorMetaDataConstructor;
    private Constructor routeMetaDataConstructor;

    public qqpubaccount_impl_RouterInitializer() {
        Class cls = Integer.TYPE;
        this.routeMetaDataConstructor = RouteMetaData.class.getConstructor(cls, String.class, String.class, cls, String.class, String.class, String.class);
        this.interceptorMetaDataConstructor = InterceptorMetaData.class.getConstructor(cls, String.class, String.class, String.class, String.class, String.class);
    }

    @Override // com.tencent.mobileqq.qroute.route.i
    public void loadIntoRoute(Map map) {
        map.put(IPublicAccountBrowser.ROUTE_NAME, (RouteMetaData) this.routeMetaDataConstructor.newInstance(new Integer(0), "", "", new Integer(0), "com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl", IPublicAccountBrowser.ROUTE_NAME, "com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl"));
        map.put(IPublicAccountDetailActivity.ROUTE_NAME, (RouteMetaData) this.routeMetaDataConstructor.newInstance(new Integer(0), "", "", new Integer(0), "com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl", IPublicAccountDetailActivity.ROUTE_NAME, "com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl"));
    }

    @Override // com.tencent.mobileqq.qroute.route.f
    public void loadIntoInterceptor(Map map) {
    }
}
