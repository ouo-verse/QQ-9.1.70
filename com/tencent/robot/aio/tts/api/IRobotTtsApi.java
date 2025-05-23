package com.tencent.robot.aio.tts.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTSList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H&J*\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0013H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/aio/tts/api/IRobotTtsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "calculateCurrentTtsId", "", "robotUin", "robotTTsList", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTTSList;", "calculateCurrentTtsName", "clearOldVersionLocalPickTtsId", "", "createAutoTtsMsgBytes", "msgRandom", "", "msgSeq", "msgTime", "streamGroupId", "", "getLatestRobotTtsId", "callback", "Lkotlin/Function2;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes25.dex */
public interface IRobotTtsApi extends QRouteApi {
    @NotNull
    String calculateCurrentTtsId(@Nullable String robotUin, @Nullable RobotTTSList robotTTsList);

    @NotNull
    String calculateCurrentTtsName(@Nullable String robotUin, @Nullable RobotTTSList robotTTsList);

    void clearOldVersionLocalPickTtsId(@Nullable String robotUin);

    @NotNull
    String createAutoTtsMsgBytes(long msgRandom, long msgSeq, long msgTime, int streamGroupId);

    void getLatestRobotTtsId(@NotNull String robotUin, @NotNull Function2<? super Integer, ? super String, Unit> callback);
}
