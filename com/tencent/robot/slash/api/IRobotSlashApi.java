package com.tencent.robot.slash.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.robot.slash.manager.b;
import com.tencent.robot.slash.manager.c;
import com.tencent.robot.slash.manager.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import z34.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/slash/api/IRobotSlashApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/view/View;", "anchorView", "Lcom/tencent/robot/slash/manager/d;", "createSlashManagerFromAIO", "Lcom/tencent/robot/slash/manager/b;", "createRobotFunctionManager", "Lcom/tencent/robot/slash/manager/c;", "createRobotMenuManager", "Lf54/a;", "createRobotSearchManager", "Lz34/a;", "createRobotDrawManager", "Ld74/a;", "createRobotWriteManager", "Lg34/c;", "createRobotPromptFunctionManager", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotSlashApi extends QRouteApi {
    @NotNull
    a createRobotDrawManager(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull View anchorView);

    @NotNull
    b createRobotFunctionManager(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull View anchorView);

    @NotNull
    c createRobotMenuManager(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull View anchorView);

    @NotNull
    g34.c createRobotPromptFunctionManager(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull View anchorView);

    @NotNull
    f54.a createRobotSearchManager(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull View anchorView);

    @NotNull
    d74.a createRobotWriteManager(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull View anchorView);

    @NotNull
    d createSlashManagerFromAIO(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull View anchorView);
}
