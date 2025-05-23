package com.tencent.robot.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeature;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Service(process = {""})
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J \u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00030\u0016H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0012H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0012H&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/api/IRobotPersonalInfoService;", "Lmqq/app/api/IRuntimeService;", "addRobotListener", "", "uid", "", "listener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRobotListener;", "addToCache", "storyBaseInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/StoryBaseInfo;", "doOnDrawCompleteAfter", "fillStoryBaseInfo", "Landroid/os/Bundle;", "uin", "chatType", "", "getMsgRecordStatus", "", "getRobotPersonalInfoAsync", "robotUid", "callback", "Lkotlin/Function2;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;", "getStoryBaseInfo", "putMsgRecordStatus", "isClear", "removeFromCache", "removeRobotListener", "updateAutoTtsSwitchState", "isAutoTtsSwitchOpened", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public interface IRobotPersonalInfoService extends IRuntimeService {
    void addRobotListener(@NotNull String uid, @NotNull IKernelRobotListener listener);

    void addToCache(@NotNull String uid, @NotNull StoryBaseInfo storyBaseInfo);

    void doOnDrawCompleteAfter();

    @NotNull
    Bundle fillStoryBaseInfo(@NotNull String uid, @NotNull String uin, int chatType);

    boolean getMsgRecordStatus(@NotNull String uid);

    void getRobotPersonalInfoAsync(@NotNull String robotUid, @NotNull Function2<? super Boolean, ? super RobotFeature, Unit> callback);

    @Nullable
    StoryBaseInfo getStoryBaseInfo(@NotNull String uid);

    void putMsgRecordStatus(@NotNull String uid, boolean isClear);

    void removeFromCache(@NotNull String uid);

    void removeRobotListener(@NotNull String uid, @Nullable IKernelRobotListener listener);

    void updateAutoTtsSwitchState(boolean isAutoTtsSwitchOpened);
}
