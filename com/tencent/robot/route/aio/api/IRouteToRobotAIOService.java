package com.tencent.robot.route.aio.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/route/aio/api/IRouteToRobotAIOService;", "Lmqq/app/api/IRuntimeService;", "addFetchedRobotUinToCache", "", "robotUin", "", "isFetchedForRouteToAIO", "", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public interface IRouteToRobotAIOService extends IRuntimeService {
    void addFetchedRobotUinToCache(@Nullable String robotUin);

    boolean isFetchedForRouteToAIO(@Nullable String robotUin);
}
