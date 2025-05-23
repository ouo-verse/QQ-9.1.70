package com.tencent.robot.timbre.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.robot.timbre.api.IRobotTimbreSettingApi;
import com.tencent.robot.timbre.setting.RobotTimbreSettingFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/timbre/api/impl/RobotTimbreSettingApiImpl;", "Lcom/tencent/robot/timbre/api/IRobotTimbreSettingApi;", "()V", "startRobotTimbreSetting", "", "context", "Landroid/content/Context;", "robotUin", "", "robotUid", "groupId", "", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotTimbreSettingApiImpl implements IRobotTimbreSettingApi {
    @Override // com.tencent.robot.timbre.api.IRobotTimbreSettingApi
    public void startRobotTimbreSetting(@NotNull Context context, @NotNull String robotUin, @Nullable String robotUid, long groupId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intent intent = new Intent();
        intent.putExtra("key_uin", robotUin);
        intent.putExtra("key_groupID", groupId);
        if (robotUid != null && robotUid.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            intent.putExtra("key_uid", robotUid);
        }
        QPublicFragmentActivity.start(context, intent, RobotTimbreSettingFragment.class);
    }
}
