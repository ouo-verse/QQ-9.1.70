package com.tencent.mobileqq.troop.robot.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import h44.OpenRobotProfileCardArgs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RobotUtilApiImpl implements IRobotUtilApi {
    private static final String TAG = "RobotUtilApiImpl";
    private MMKVOptionEntity entity = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");

    private boolean isTroopOwnerOrAdmin(AppRuntime appRuntime, String str) {
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
            if (findTroopInfo != null) {
                return findTroopInfo.isOwnerOrAdmin();
            }
            QLog.e(TAG, 2, "ROBOT RED isTroopOwnerOrAdminOrMember troopInfo IS null");
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public ArrayList<String> SplitUinListFromString(String str) {
        String[] split;
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str) && (split = str.split("_")) != null && split.length > 0) {
            for (int i3 = 0; i3 < split.length; i3++) {
                if (!TextUtils.isEmpty(split[i3])) {
                    arrayList.add(split[i3]);
                } else {
                    QLog.e(TAG, 2, "RobotRed SplitUinListFromString I empty " + i3);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RobotRed SplitUinListFromString size  " + arrayList.size() + " listString " + str);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public boolean canInviteRobotInGroup(AppRuntime appRuntime, @NonNull String str) {
        TroopInfo findTroopInfo;
        if (appRuntime == null || (findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str)) == null) {
            return false;
        }
        if (findTroopInfo.isOwnerOrAdmin(appRuntime.getCurrentUin())) {
            return true;
        }
        if (findTroopInfo.cGroupOption == 3 || findTroopInfo.groupExt.inviteRobotMemberSwitch == 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public String convertUinListToString(ArrayList<String> arrayList) {
        String str = "";
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                str = str + arrayList.get(i3) + "_";
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "RobotRed convertUinListToString  " + str);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public boolean getBeAllMemberShowRed(AppRuntime appRuntime) {
        SharedPreferences robotSP = getRobotSP(appRuntime);
        if (robotSP == null) {
            return false;
        }
        boolean z16 = robotSP.getBoolean(IRobotUtilApi.SP_ROBOT_RED_BE_ROLE_FOR_MEMBER, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RobotRed getIfTheRightRoleInTroopShowRobotRedDot bNeedShowed: " + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public ArrayList<String> getHistoryRobotListFromSp(AppRuntime appRuntime) {
        SharedPreferences robotSP = getRobotSP(appRuntime);
        if (robotSP == null) {
            return new ArrayList<>();
        }
        ArrayList<String> SplitUinListFromString = SplitUinListFromString(robotSP.getString(IRobotUtilApi.SP_HISTORY_ROBOT_UIN_RED_LIST, ""));
        if (SplitUinListFromString == null) {
            SplitUinListFromString = new ArrayList<>();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RobotRed getHistoryRobotListFromSp size  " + SplitUinListFromString.size());
        }
        return SplitUinListFromString;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public boolean getIfRobotRedInfoNeedUpdate(AppRuntime appRuntime) {
        SharedPreferences robotSP = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getRobotSP(appRuntime);
        boolean z16 = true;
        if (robotSP == null) {
            return true;
        }
        long j3 = robotSP.getLong(IRobotUtilApi.SP_ROBOT_RED_INFO_EXPIRE_TIME, 3600L);
        long j16 = robotSP.getLong(IRobotUtilApi.SP_ROBOT_RED_INFO_UPDATE_TIME, 0L);
        long serverTime = NetConnInfoCenter.getServerTime();
        long j17 = serverTime - j16;
        if (j17 < j3 && j17 > 0) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RobotRed getIfRobotRedInfoNeedUpdate: " + j3 + " update :" + j16 + " now\uff1a" + serverTime + " needUpdate\uff1a" + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public boolean getIfTheRightRoleInTroopShowRobotRedDot(AppRuntime appRuntime, String str) {
        if (!TextUtils.isEmpty(str) && str != "0") {
            if (getBeAllMemberShowRed(appRuntime)) {
                return true;
            }
            boolean isTroopOwnerOrAdmin = isTroopOwnerOrAdmin(appRuntime, str);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "RobotRed getIfTheRightRoleInTroopShowRobotRedDot isTroopOwnerOrAdminOrMember: " + isTroopOwnerOrAdmin);
            }
            return isTroopOwnerOrAdmin;
        }
        QLog.e(TAG, 2, "getNeedShowRobotRedDotAio WITH wrong troopUin");
        return false;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public boolean getNeedShowRobotRedDotAio(AppRuntime appRuntime, String str) {
        SharedPreferences robotSP;
        if (!TextUtils.isEmpty(str) && str != "0") {
            if (!((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getIfTheRightRoleInTroopShowRobotRedDot(appRuntime, str) || (robotSP = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getRobotSP(appRuntime)) == null) {
                return false;
            }
            boolean z16 = robotSP.getBoolean(IRobotUtilApi.SP_ROBOT_RED_IN_TROOP_AIO, false);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "RobotRed needShowRobotRedDotAio bNeedShowed: " + z16);
            }
            return z16;
        }
        QLog.e(TAG, 2, "getNeedShowRobotRedDotAio WITH wrong troopUin");
        return false;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public ArrayList<String> getNewRobotListFromSp(AppRuntime appRuntime) {
        SharedPreferences robotSP = getRobotSP(appRuntime);
        if (robotSP == null) {
            return new ArrayList<>();
        }
        ArrayList<String> SplitUinListFromString = SplitUinListFromString(robotSP.getString(IRobotUtilApi.SP_NEW_ROBOT_UIN_RED_LIST, ""));
        if (SplitUinListFromString == null) {
            SplitUinListFromString = new ArrayList<>();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RobotRed getNewRobotListFromSp size  " + SplitUinListFromString.size());
        }
        return SplitUinListFromString;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public String getRobotAioBar(Context context, String str) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str + "_" + AppConstants.Preferences.ROBOT_AIO_BAR, "");
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_STORY, 2, "getRobotAioBar,aio_bar:" + string);
        }
        return string;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public boolean getRobotItemRedShowed(AppRuntime appRuntime) {
        SharedPreferences robotSP = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getRobotSP(appRuntime);
        if (robotSP == null) {
            return false;
        }
        boolean z16 = robotSP.getBoolean(IRobotUtilApi.SP_ROBOT_RED_ITEM_IN_CHAT_SETTING, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RobotRed getRobotItemRedShowed bNeedShowed: " + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public SharedPreferences getRobotSP(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.e(TAG, 2, "RobotRed  get sp by app is null");
            return null;
        }
        String currentUin = appRuntime.getCurrentUin();
        if (currentUin != null && !TextUtils.isEmpty(currentUin)) {
            return appRuntime.getApplicationContext().getSharedPreferences(IRobotUtilApi.SP_ROBOT_IN_TROOP_NAME + currentUin, 0);
        }
        QLog.e(TAG, 2, "RobotRed get sp by uin is null");
        return null;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public String getRobotVoiceTail(Context context, String str) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str + "_" + AppConstants.Preferences.ROBOT_VOICE_TAIL, "");
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_STORY, 2, "getRobotVoiceTail,aio_bar:" + string);
        }
        return string;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public int getTroopRobotPanelVersion(String str, String str2) {
        return this.entity.decodeInt("troop_robot_panel_version_" + str + str2, 0);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public boolean isRobotSafeGrayTipAdded(String str) {
        return this.entity.decodeStringSet(QMMKVFile.getKeyWithUin(IRobotUtilApi.MMKV_SCENE_ID, IRobotUtilApi.KEY_SAFE_GRAY_TIP_ADDED_SET), Collections.emptySet()).contains(str);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public boolean isRobotSwitchOn(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return false;
        }
        return ((ITroopRobotService) appRuntime.getRuntimeService(ITroopRobotService.class, "all")).isRobotSwichOn();
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public void openRobotProfileCard(Context context, String str, String str2) {
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, str2, str, 0, 0, null));
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public boolean setHistoryRobotListToSp(AppRuntime appRuntime, ArrayList<String> arrayList) {
        boolean z16 = false;
        if (arrayList != null) {
            String convertUinListToString = convertUinListToString(arrayList);
            SharedPreferences robotSP = getRobotSP(appRuntime);
            if (robotSP != null) {
                robotSP.edit().putString(IRobotUtilApi.SP_HISTORY_ROBOT_UIN_RED_LIST, convertUinListToString).apply();
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "RobotRed setHistoryRobotListToSp size  " + arrayList.size());
            }
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public void setNeedShowRobotRedDotAio(AppRuntime appRuntime, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RobotRed setHasShowRobotRedDotAio bShowed: " + z16);
        }
        SharedPreferences robotSP = getRobotSP(appRuntime);
        if (robotSP == null) {
            return;
        }
        robotSP.edit().putBoolean(IRobotUtilApi.SP_ROBOT_RED_IN_TROOP_AIO, z16).apply();
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public boolean setNewRobotListToSp(AppRuntime appRuntime, ArrayList<String> arrayList) {
        boolean z16 = false;
        if (arrayList != null) {
            String convertUinListToString = convertUinListToString(arrayList);
            SharedPreferences robotSP = getRobotSP(appRuntime);
            if (robotSP != null) {
                robotSP.edit().putString(IRobotUtilApi.SP_NEW_ROBOT_UIN_RED_LIST, convertUinListToString).apply();
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "RobotRed setNewRobotListToSp size  " + arrayList.size());
            }
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public void setRobotItemRedShowed(AppRuntime appRuntime, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RobotRed setRobotItemRedShowed bShowed: " + z16);
        }
        SharedPreferences robotSP = getRobotSP(appRuntime);
        if (robotSP == null) {
            return;
        }
        robotSP.edit().putBoolean(IRobotUtilApi.SP_ROBOT_RED_ITEM_IN_CHAT_SETTING, z16).apply();
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public void setRobotRedForAllMembers(AppRuntime appRuntime, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RobotRed setRobotRedForAllMembers bShowed: " + z16);
        }
        SharedPreferences robotSP = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getRobotSP(appRuntime);
        if (robotSP == null) {
            return;
        }
        robotSP.edit().putBoolean(IRobotUtilApi.SP_ROBOT_RED_BE_ROLE_FOR_MEMBER, z16).apply();
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public void setRobotRedInfoUpdate(AppRuntime appRuntime, long j3) {
        SharedPreferences robotSP = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getRobotSP(appRuntime);
        if (robotSP == null) {
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        robotSP.edit().putLong(IRobotUtilApi.SP_ROBOT_RED_INFO_EXPIRE_TIME, j3).apply();
        robotSP.edit().putLong(IRobotUtilApi.SP_ROBOT_RED_INFO_UPDATE_TIME, serverTime).apply();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RobotRed setRobotRedInfoUpdate expireTime  " + j3 + " update time: " + serverTime);
        }
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public void setRobotSafeGrayTipAdded(String str, boolean z16) {
        String keyWithUin = QMMKVFile.getKeyWithUin(IRobotUtilApi.MMKV_SCENE_ID, IRobotUtilApi.KEY_SAFE_GRAY_TIP_ADDED_SET);
        Set<String> decodeStringSet = this.entity.decodeStringSet(keyWithUin, new HashSet());
        if (z16) {
            decodeStringSet.add(str);
        } else {
            decodeStringSet.remove(str);
        }
        this.entity.encodeStringSet(keyWithUin, decodeStringSet);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public void updateRobotAioBar(Context context, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str + "_" + AppConstants.Preferences.ROBOT_AIO_BAR, str2);
        edit.commit();
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public void updateRobotVoiceTail(Context context, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str + "_" + AppConstants.Preferences.ROBOT_VOICE_TAIL, str2);
        edit.commit();
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public void updateTroopRobotConfig(boolean z16, String str) {
        ((ITroopRobotService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ITroopRobotService.class, "all")).updateConfig(z16, str);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
    public void updateTroopRobotPanelVersion(String str, String str2, int i3) {
        this.entity.encodeInt("troop_robot_panel_version_" + str + str2, i3);
    }
}
