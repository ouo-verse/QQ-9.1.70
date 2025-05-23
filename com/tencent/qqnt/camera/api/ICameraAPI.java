package com.tencent.qqnt.camera.api;

import android.app.Activity;
import com.tencent.aio.api.runtime.a;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.camera.data.CameraReq;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/camera/api/ICameraAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/qqnt/camera/data/CameraReq;", "req", "Law3/a;", "callback", "", "startCameraAndCallback", "Lcom/tencent/aio/data/AIOContact;", "aioContact", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "startCameraForOldSessionType", "camera_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface ICameraAPI extends QRouteApi {
    void startCameraAndCallback(@NotNull a context, @NotNull CameraReq req, @NotNull aw3.a callback);

    void startCameraForOldSessionType(@NotNull AIOContact aioContact, @NotNull a context, @NotNull Activity activity);
}
