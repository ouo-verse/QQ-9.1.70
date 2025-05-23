package com.tencent.mobileqq.qroute.route.generated;

import com.tencent.mobileqq.qroute.route.InterceptorMetaData;
import com.tencent.mobileqq.qroute.route.RouteMetaData;
import com.tencent.mobileqq.qroute.route.f;
import com.tencent.mobileqq.qroute.route.i;
import java.lang.reflect.Constructor;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class qqnearby_impl_RouterInitializer implements i, f {
    private Constructor interceptorMetaDataConstructor;
    private Constructor routeMetaDataConstructor;

    public qqnearby_impl_RouterInitializer() {
        Class cls = Integer.TYPE;
        this.routeMetaDataConstructor = RouteMetaData.class.getConstructor(cls, String.class, String.class, cls, String.class, String.class, String.class);
        this.interceptorMetaDataConstructor = InterceptorMetaData.class.getConstructor(cls, String.class, String.class, String.class, String.class, String.class);
    }

    @Override // com.tencent.mobileqq.qroute.route.i
    public void loadIntoRoute(Map map) {
        map.put("/gvideo/plugin/installer", (RouteMetaData) this.routeMetaDataConstructor.newInstance(new Integer(0), "", "", new Integer(0), "cooperation.groupvideo.GVideoPluginInstallerActivity", "/gvideo/plugin/installer", "cooperation.groupvideo.GVideoPluginInstallerActivity"));
        map.put("/gvideo/translucent/browser", (RouteMetaData) this.routeMetaDataConstructor.newInstance(new Integer(0), "", "", new Integer(0), "cooperation.groupvideo.GVideoTranslucentBrowerActivity", "/gvideo/translucent/browser", "cooperation.groupvideo.GVideoTranslucentBrowerActivity"));
        map.put("/share/toqq/activity", (RouteMetaData) this.routeMetaDataConstructor.newInstance(new Integer(0), "", "", new Integer(0), "com.tencent.mobileqq.intervideo.now.ShareToQQActivity", "/share/toqq/activity", "com.tencent.mobileqq.intervideo.now.ShareToQQActivity"));
    }

    @Override // com.tencent.mobileqq.qroute.route.f
    public void loadIntoInterceptor(Map map) {
    }
}
