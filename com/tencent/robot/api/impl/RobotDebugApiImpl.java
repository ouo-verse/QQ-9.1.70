package com.tencent.robot.api.impl;

import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.robot.api.IRobotDebugApi;
import kotlin.Metadata;
import kotlin.ranges.LongRange;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/api/impl/RobotDebugApiImpl;", "Lcom/tencent/robot/api/IRobotDebugApi;", "", "uin", "", "isRobotUin", "(Ljava/lang/Long;)Z", "isUseDebugInputConfig", "isSupportInputMenu", "isSupportInputPic", "isSupportInputCamera", "isSupportInputFile", "isSupportInputSlashPanel", "isSupportCalculateTtsCostTime", "isSupportInputStory", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotDebugApiImpl implements IRobotDebugApi {
    private static final long ROBOT_UIN_4_BEGIN = 4010000000L;
    private static final long ROBOT_UIN_4_END = 4019999999L;
    private static final long ROBOT_UIN_BABY_Q = 66600000;
    private static final long ROBOT_UIN_O_BEGIN = 2854196301L;
    private static final long ROBOT_UIN_O_END = 2854216399L;
    private static final long ROBOT_UIN_T_BEGIN = 3889000000L;
    private static final long ROBOT_UIN_T_END = 3889999999L;

    @Override // com.tencent.robot.api.IRobotDebugApi
    public boolean isRobotUin(@Nullable Long uin) {
        if (uin == null) {
            return false;
        }
        if (!new LongRange(ROBOT_UIN_O_BEGIN, ROBOT_UIN_O_END).contains(uin.longValue()) && uin.longValue() != 66600000 && !new LongRange(ROBOT_UIN_T_BEGIN, ROBOT_UIN_T_END).contains(uin.longValue()) && !new LongRange(ROBOT_UIN_4_BEGIN, ROBOT_UIN_4_END).contains(uin.longValue())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.robot.api.IRobotDebugApi
    public boolean isSupportCalculateTtsCostTime() {
        return false;
    }

    @Override // com.tencent.robot.api.IRobotDebugApi
    public boolean isSupportInputCamera() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("robot_input_support_camera_switch", false);
    }

    @Override // com.tencent.robot.api.IRobotDebugApi
    public boolean isSupportInputFile() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("robot_input_support_file_switch", false);
    }

    @Override // com.tencent.robot.api.IRobotDebugApi
    public boolean isSupportInputMenu() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("robot_input_support_menu_switch", false);
    }

    @Override // com.tencent.robot.api.IRobotDebugApi
    public boolean isSupportInputPic() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("robot_input_support_pic_switch", false);
    }

    @Override // com.tencent.robot.api.IRobotDebugApi
    public boolean isSupportInputSlashPanel() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("robot_input_support_panel_switch", false);
    }

    @Override // com.tencent.robot.api.IRobotDebugApi
    public boolean isSupportInputStory() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("robot_input_support_story_switch", false);
    }

    @Override // com.tencent.robot.api.IRobotDebugApi
    public boolean isUseDebugInputConfig() {
        return false;
    }
}
