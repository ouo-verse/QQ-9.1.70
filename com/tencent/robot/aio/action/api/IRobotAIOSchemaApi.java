package com.tencent.robot.aio.action.api;

import com.tencent.aio.api.runtime.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/aio/action/api/IRobotAIOSchemaApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "uid", "from", "showStoryListFloat", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes25.dex */
public interface IRobotAIOSchemaApi extends QRouteApi {
    void onCreate(@NotNull a aioContext);

    void onDestroy(@NotNull a aioContext);

    void showStoryListFloat(@NotNull String uid, @NotNull String from);
}
