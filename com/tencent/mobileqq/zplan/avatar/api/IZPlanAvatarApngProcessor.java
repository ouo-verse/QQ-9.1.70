package com.tencent.mobileqq.zplan.avatar.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanAvatarApngProcessor extends QRouteApi {

    /* loaded from: classes21.dex */
    public interface a {
        void a(boolean z16, int i3);
    }

    void init(AppInterface appInterface);

    void process(int i3, boolean z16);

    void setProcessFinishListener(a aVar);
}
