package com.tencent.biz.pubaccount.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountProxy extends QRouteApi {
    Class getImplClass(Class cls);

    String getImplName(Class cls);

    boolean isPublicAccountBrowser(Activity activity);

    void setDataManagerAfterMsgSync();
}
