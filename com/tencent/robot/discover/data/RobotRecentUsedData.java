package com.tencent.robot.discover.data;

import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import java.io.Serializable;
import java.util.List;
import k34.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/discover/data/RobotRecentUsedData;", "Lk34/a;", "Ljava/io/Serializable;", "", "getItemType", "", "getItemId", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", "robots", "Ljava/util/List;", "getRobots", "()Ljava/util/List;", "totalNum", "I", "getTotalNum", "()I", "<init>", "(Ljava/util/List;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotRecentUsedData implements a, Serializable {

    @NotNull
    private final List<GroupRobot> robots;
    private final int totalNum;

    public RobotRecentUsedData(@NotNull List<GroupRobot> robots, int i3) {
        Intrinsics.checkNotNullParameter(robots, "robots");
        this.robots = robots;
        this.totalNum = i3;
    }

    @Override // k34.a
    @NotNull
    public String getItemId() {
        return "7";
    }

    @Override // k34.a
    public int getItemType() {
        return 7;
    }

    @NotNull
    public final List<GroupRobot> getRobots() {
        return this.robots;
    }

    public final int getTotalNum() {
        return this.totalNum;
    }
}
