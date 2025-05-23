package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelRobotListener {
    void onRobotAIOEventChanged(RobotAIOEvent robotAIOEvent);

    void onRobotCoreInfoChanged(RobotCoreInfo robotCoreInfo);

    void onRobotFeatureChanged(GroupRobotProfile groupRobotProfile);

    void onRobotFriendListChanged();

    void onRobotListChanged();

    void onRobotProfileChanged(GroupRobotProfile groupRobotProfile);

    void onRobotTabListChanged(String str);
}
