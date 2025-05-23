package com.tencent.robot.aio.background.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH&J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/aio/background/api/IRobotBackgroundService;", "Lmqq/app/api/IRuntimeService;", "cleanRobotBackground", "", "robotUin", "", "getBackgroundUrlFromCache", "robotCoreInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "isProfile", "", "loadBackgroundAsync", "troopUin", "callback", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public interface IRobotBackgroundService extends IRuntimeService {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ String a(IRobotBackgroundService iRobotBackgroundService, String str, RobotCoreInfo robotCoreInfo, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    robotCoreInfo = null;
                }
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                return iRobotBackgroundService.getBackgroundUrlFromCache(str, robotCoreInfo, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBackgroundUrlFromCache");
        }
    }

    void cleanRobotBackground(@Nullable String robotUin);

    @NotNull
    String getBackgroundUrlFromCache(@Nullable String robotUin, @Nullable RobotCoreInfo robotCoreInfo, boolean isProfile);

    void loadBackgroundAsync(@NotNull String robotUin, @Nullable String troopUin, @NotNull IGetGroupRobotProfileCallback callback);
}
