package com.tencent.mobileqq.troop.robot.api;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IRobotUtilApi extends QRouteApi {
    public static final String KEY_SAFE_GRAY_TIP_ADDED_SET = "safe_gray_tip_added_set";
    public static final String MMKV_SCENE_ID = "robot";
    public static final String SP_HISTORY_ROBOT_UIN_RED_LIST = "sp_history_robot_red_list";
    public static final String SP_NEW_ROBOT_UIN_RED_LIST = "sp_new_robot_red_list";
    public static final String SP_ROBOT_IN_TROOP_NAME = "sp_robot_in_troop";
    public static final String SP_ROBOT_RED_BE_ROLE_FOR_MEMBER = "sp_robot_red_limit_role_for_member";
    public static final String SP_ROBOT_RED_INFO_EXPIRE_TIME = "sp_robot_red_expire_time";
    public static final String SP_ROBOT_RED_INFO_UPDATE_TIME = "sp_robot_red_update_time";
    public static final String SP_ROBOT_RED_IN_TROOP_AIO = "sp_robot_red_int_troop_aio";
    public static final String SP_ROBOT_RED_ITEM_IN_CHAT_SETTING = "sp_robot_red_item_int_chat_setting";
    public static final String UIN_LIST_SEPARATOR = "_";

    ArrayList<String> SplitUinListFromString(String str);

    boolean canInviteRobotInGroup(AppRuntime appRuntime, @NonNull String str);

    String convertUinListToString(ArrayList<String> arrayList);

    boolean getBeAllMemberShowRed(AppRuntime appRuntime);

    ArrayList<String> getHistoryRobotListFromSp(AppRuntime appRuntime);

    boolean getIfRobotRedInfoNeedUpdate(AppRuntime appRuntime);

    boolean getIfTheRightRoleInTroopShowRobotRedDot(AppRuntime appRuntime, String str);

    boolean getNeedShowRobotRedDotAio(AppRuntime appRuntime, String str);

    ArrayList<String> getNewRobotListFromSp(AppRuntime appRuntime);

    String getRobotAioBar(Context context, String str);

    boolean getRobotItemRedShowed(AppRuntime appRuntime);

    SharedPreferences getRobotSP(AppRuntime appRuntime);

    String getRobotVoiceTail(Context context, String str);

    int getTroopRobotPanelVersion(String str, String str2);

    boolean isRobotSafeGrayTipAdded(String str);

    @Deprecated
    boolean isRobotSwitchOn(AppRuntime appRuntime);

    void openRobotProfileCard(Context context, String str, String str2);

    boolean setHistoryRobotListToSp(AppRuntime appRuntime, ArrayList<String> arrayList);

    void setNeedShowRobotRedDotAio(AppRuntime appRuntime, boolean z16);

    boolean setNewRobotListToSp(AppRuntime appRuntime, ArrayList<String> arrayList);

    void setRobotItemRedShowed(AppRuntime appRuntime, boolean z16);

    void setRobotRedForAllMembers(AppRuntime appRuntime, boolean z16);

    void setRobotRedInfoUpdate(AppRuntime appRuntime, long j3);

    void setRobotSafeGrayTipAdded(String str, boolean z16);

    void updateRobotAioBar(Context context, String str, String str2);

    void updateRobotVoiceTail(Context context, String str, String str2);

    void updateTroopRobotConfig(boolean z16, String str);

    void updateTroopRobotPanelVersion(String str, String str2, int i3);
}
