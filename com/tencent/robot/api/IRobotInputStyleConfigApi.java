package com.tencent.robot.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\f\u001a\u00020\u0007H&J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/api/IRobotInputStyleConfigApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "robotUin", "", "", "getPlusPanelAppIdList", "Lcom/tencent/robot/aio/input/styleconfig/a;", "inputStyleConfig", "", "saveInputStyleConfigToMMKV", "getInputStyleConfigFromMMKV", "createDefaultInputStyleConfig", "deleteInputStyleConfigFromMMKV", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes25.dex */
public interface IRobotInputStyleConfigApi extends QRouteApi {
    @NotNull
    com.tencent.robot.aio.input.styleconfig.a createDefaultInputStyleConfig();

    void deleteInputStyleConfigFromMMKV(@Nullable String robotUin);

    @Nullable
    com.tencent.robot.aio.input.styleconfig.a getInputStyleConfigFromMMKV(@Nullable String robotUin);

    @NotNull
    List<Integer> getPlusPanelAppIdList(@Nullable String robotUin);

    void saveInputStyleConfigToMMKV(@Nullable String robotUin, @NotNull com.tencent.robot.aio.input.styleconfig.a inputStyleConfig);
}
