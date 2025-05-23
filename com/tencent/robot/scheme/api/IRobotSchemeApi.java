package com.tencent.robot.scheme.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/scheme/api/IRobotSchemeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createAdelieJumpParserClass", "Ljava/lang/Class;", "", "createQRobotJumpParserClass", "createRobotAIOJumpParserClass", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotSchemeApi extends QRouteApi {
    @NotNull
    Class<? extends Object> createAdelieJumpParserClass();

    @NotNull
    Class<? extends Object> createQRobotJumpParserClass();

    @NotNull
    Class<? extends Object> createRobotAIOJumpParserClass();
}
