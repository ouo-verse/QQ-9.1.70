package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProUserInfo extends Serializable {
    int getAllowScreenShare();

    String getAvatarMeta();

    String getAvatarPendant();

    IGProBusinessData getBusinessInfo();

    IGProClientIdentityInfo getClientIdentity();

    IGProClientPresenceInfo getClientPresence();

    String getDisplayName();

    IGProVoiceInfo getGProVoiceInfo();

    int getGender();

    int getGroupType();

    int getLevelRoleId();

    String getMemberName();

    ArrayList<Integer> getMyRoles();

    String getNickName();

    eu getPersonalMedal();

    int getPlatform();

    int getRobotMuteStatus();

    int getRobotPunishmentStatus();

    String getRobotTestGuilds();

    int getRobotType();

    IGProRoleManagementTag getRoleManagementTag();

    long getShutUpExpireTime();

    String getTinyId();

    long getUserJoinTime();

    int getUserOnlineState();

    int getUserType();

    @Nullable
    byte[] getVasPlateData();

    boolean isMuteSeat();

    boolean isVisitorRole();

    boolean isVoiceless();

    void setGroupType(int i3);

    void setRoleManagementTag(long j3, String str, long j16);

    void setShutUpExpireTime(long j3);

    void setUserType(int i3);
}
