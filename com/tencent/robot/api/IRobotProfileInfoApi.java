package com.tencent.robot.api;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J(\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\n\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/api/IRobotProfileInfoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "fetchRobotProfileInfo", "", "robotUin", "", "troopUin", "callback", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "fetchRobotProfileInfoFromServer", "getBKN", "getRecentRobotProfileCache", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "getRobotCoreInfoFromFriendsCache", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "getRobotProfileInfoFromLocal", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotProfileInfoApi extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(IRobotProfileInfoApi iRobotProfileInfoApi, String str, String str2, IGetGroupRobotProfileCallback iGetGroupRobotProfileCallback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str2 = "";
                }
                if ((i3 & 4) != 0) {
                    iGetGroupRobotProfileCallback = null;
                }
                iRobotProfileInfoApi.fetchRobotProfileInfoFromServer(str, str2, iGetGroupRobotProfileCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchRobotProfileInfoFromServer");
        }
    }

    void fetchRobotProfileInfo(@NotNull String robotUin, @Nullable String troopUin, @NotNull IGetGroupRobotProfileCallback callback);

    void fetchRobotProfileInfoFromServer(@NotNull String robotUin, @Nullable String troopUin, @Nullable IGetGroupRobotProfileCallback callback);

    @NotNull
    String getBKN();

    @Nullable
    GroupRobotProfile getRecentRobotProfileCache(@NotNull String robotUin);

    @Nullable
    RobotCoreInfo getRobotCoreInfoFromFriendsCache(@NotNull String robotUin);

    void getRobotProfileInfoFromLocal(@NotNull String robotUin, @Nullable String troopUin, @NotNull IGetGroupRobotProfileCallback callback);

    void onCreate();

    void onDestroy();
}
