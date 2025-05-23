package com.tencent.robot.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/api/IRobotDebugApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isRobotUin", "", "uin", "", "(Ljava/lang/Long;)Z", "isSupportCalculateTtsCostTime", "isSupportInputCamera", "isSupportInputFile", "isSupportInputMenu", "isSupportInputPic", "isSupportInputSlashPanel", "isSupportInputStory", "isUseDebugInputConfig", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotDebugApi extends QRouteApi {
    boolean isRobotUin(@Nullable Long uin);

    boolean isSupportCalculateTtsCostTime();

    boolean isSupportInputCamera();

    boolean isSupportInputFile();

    boolean isSupportInputMenu();

    boolean isSupportInputPic();

    boolean isSupportInputSlashPanel();

    boolean isSupportInputStory();

    boolean isUseDebugInputConfig();
}
