package com.tencent.mobileqq.qroute.route.generated;

import com.tencent.mobileqq.qroute.route.InterceptorMetaData;
import com.tencent.mobileqq.qroute.route.RouteMetaData;
import com.tencent.mobileqq.qroute.route.f;
import com.tencent.mobileqq.qroute.route.i;
import java.lang.reflect.Constructor;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class base_proj_nt_ext_impl_RouterInitializer implements i, f {
    private Constructor interceptorMetaDataConstructor;
    private Constructor routeMetaDataConstructor;

    public base_proj_nt_ext_impl_RouterInitializer() {
        Class cls = Integer.TYPE;
        this.routeMetaDataConstructor = RouteMetaData.class.getConstructor(cls, String.class, String.class, cls, String.class, String.class, String.class);
        this.interceptorMetaDataConstructor = InterceptorMetaData.class.getConstructor(cls, String.class, String.class, String.class, String.class, String.class);
    }

    @Override // com.tencent.mobileqq.qroute.route.i
    public void loadIntoRoute(Map map) {
        map.put("/base/activity/FlashPic", (RouteMetaData) this.routeMetaDataConstructor.newInstance(new Integer(0), "", "", new Integer(0), "com.tencent.qqnt.aio.flashpic.FlashPicActivity", "/base/activity/FlashPic", "com.tencent.qqnt.aio.flashpic.FlashPicActivity"));
        map.put("/base/chathistory/main", (RouteMetaData) this.routeMetaDataConstructor.newInstance(new Integer(0), "", "", new Integer(0), "com.tencent.mobileqq.activity.history.NTChatHistoryActivity", "/base/chathistory/main", "com.tencent.mobileqq.activity.history.NTChatHistoryActivity"));
    }

    @Override // com.tencent.mobileqq.qroute.route.f
    public void loadIntoInterceptor(Map map) {
    }
}
