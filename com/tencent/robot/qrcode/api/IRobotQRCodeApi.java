package com.tencent.robot.qrcode.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.data.RobotShareState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/qrcode/api/IRobotQRCodeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "openRobotQRCodeCard", "", "context", "Landroid/content/Context;", "qrCodeInfo", "Lcom/tencent/robot/data/RobotInfo;", "from", "", "queryRobotShareState", "callback", "Lkotlin/Function1;", "Lcom/tencent/robot/data/RobotShareState;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotQRCodeApi extends QRouteApi {
    void openRobotQRCodeCard(@NotNull Context context, @NotNull RobotInfo qrCodeInfo, int from);

    void queryRobotShareState(@Nullable Function1<? super RobotShareState, Unit> callback);
}
