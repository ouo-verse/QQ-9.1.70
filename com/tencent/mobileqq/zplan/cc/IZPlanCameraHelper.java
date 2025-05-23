package com.tencent.mobileqq.zplan.cc;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/IZPlanCameraHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "loadCameraSdkSo", "", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes21.dex */
public interface IZPlanCameraHelper extends QRouteApi {
    void loadCameraSdkSo();
}
