package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotCoreInfo {
    public boolean allowAddGroup;
    public boolean allowInvitedToGroup;
    public long appid;
    public boolean ban;
    public long friendUV;
    public long hotNumber;
    public int offline;
    public long robotUin;
    public int serialNumber;
    public int testStatus;
    public long tinyId;
    public String name = "";
    public String robotAvatar = "";
    public String desc = "";
    public ArrayList<RobotCoreFeature> features = new ArrayList<>();
    public ArrayList<String> tags = new ArrayList<>();
    public String uid = "";
    public String creatorName = "";
    public String creatorUid = "";
    public RobotTTSList ttsList = new RobotTTSList();
    public String bgDay = "";
    public String bgNight = "";
    public String avatarDominantColor = "";
    public String dayDynamicPic = "";
    public String nightDynamicPic = "";
    public String dayColor = "";
    public String nightColor = "";
    public AioConfig aioConfig = new AioConfig();
    public RobotBackGround infoBg = new RobotBackGround();
    public InputBox inputBox = new InputBox();
    public ArrayList<RealtimeBgSource> realtimeSpeechCfg = new ArrayList<>();
    public RobotBaseBizType bizType = RobotBaseBizType.values()[0];
    public String robotTag = "";
    public ProfileSimpleInfo baseSimpleProfile = new ProfileSimpleInfo();
    public String jumpUrl = "";

    public AioConfig getAioConfig() {
        return this.aioConfig;
    }

    public boolean getAllowAddGroup() {
        return this.allowAddGroup;
    }

    public boolean getAllowInvitedToGroup() {
        return this.allowInvitedToGroup;
    }

    public long getAppid() {
        return this.appid;
    }

    public String getAvatarDominantColor() {
        return this.avatarDominantColor;
    }

    public boolean getBan() {
        return this.ban;
    }

    public ProfileSimpleInfo getBaseSimpleProfile() {
        return this.baseSimpleProfile;
    }

    public String getBgDay() {
        return this.bgDay;
    }

    public String getBgNight() {
        return this.bgNight;
    }

    public RobotBaseBizType getBizType() {
        return this.bizType;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public String getCreatorUid() {
        return this.creatorUid;
    }

    public String getDayColor() {
        return this.dayColor;
    }

    public String getDayDynamicPic() {
        return this.dayDynamicPic;
    }

    public String getDesc() {
        return this.desc;
    }

    public ArrayList<RobotCoreFeature> getFeatures() {
        return this.features;
    }

    public long getFriendUV() {
        return this.friendUV;
    }

    public long getHotNumber() {
        return this.hotNumber;
    }

    public RobotBackGround getInfoBg() {
        return this.infoBg;
    }

    public InputBox getInputBox() {
        return this.inputBox;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getNightColor() {
        return this.nightColor;
    }

    public String getNightDynamicPic() {
        return this.nightDynamicPic;
    }

    public int getOffline() {
        return this.offline;
    }

    public ArrayList<RealtimeBgSource> getRealtimeSpeechCfg() {
        return this.realtimeSpeechCfg;
    }

    public String getRobotAvatar() {
        return this.robotAvatar;
    }

    public String getRobotTag() {
        return this.robotTag;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public int getTestStatus() {
        return this.testStatus;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public RobotTTSList getTtsList() {
        return this.ttsList;
    }

    public String getUid() {
        return this.uid;
    }
}
