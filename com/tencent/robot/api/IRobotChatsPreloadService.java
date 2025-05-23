package com.tencent.robot.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

@Service(process = {""})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/api/IRobotChatsPreloadService;", "Lmqq/app/api/IRuntimeService;", "preloadRobotBackgroundForChats", "", "robotUin", "", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public interface IRobotChatsPreloadService extends IRuntimeService {
    void preloadRobotBackgroundForChats(@Nullable String robotUin);
}
