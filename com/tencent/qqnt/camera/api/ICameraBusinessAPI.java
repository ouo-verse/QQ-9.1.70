package com.tencent.qqnt.camera.api;

import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.camera.data.CameraReq;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/camera/api/ICameraBusinessAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/qqnt/camera/data/CameraReq;", "req", "", "requestCode", "", "business", "", "isForbidVideoAbility", "", "startCameraAndCallback", "camera_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface ICameraBusinessAPI extends QRouteApi {
    void startCameraAndCallback(@NotNull a context, @NotNull CameraReq req, int requestCode, @NotNull String business, boolean isForbidVideoAbility);
}
