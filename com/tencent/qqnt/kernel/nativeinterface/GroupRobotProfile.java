package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GroupRobotProfile {
    public int c2cSubscribeMsgTplCnt;
    public boolean canResetHistory;
    public int groupSubscribeMsgTplCnt;
    public boolean isFriend;
    public boolean isGroupReceive;
    public boolean isReceive;
    public int robotMembership;
    public int subscribeMsgTplCnt;
    public int userMembership;
    public RobotBaseInfo robotData = new RobotBaseInfo();
    public ArrayList<RobotUsingLabel> usingLabels = new ArrayList<>();
    public ArrayList<RobotPanelInfo> panels = new ArrayList<>();
    public ArrayList<RobotFeatureInfo> commands = new ArrayList<>();
    public ArrayList<ImageInfo> previewImages = new ArrayList<>();
    public String jumpUrl = "";
    public String panelTitle = "";
    public String previewImagesTitle = "";
    public GroupTraceInfo traceInfo = new GroupTraceInfo();
    public String c2cDayBackground = "";
    public String c2cNightBackground = "";
    public String avatarDominantColor = "";
    public String dayDynamicPic = "";
    public String nightDynamicPic = "";
    public String dayColor = "";
    public String nightColor = "";
    public RobotBackGround infoBg = new RobotBackGround();
    public byte[] promptMsg = new byte[0];
    public GroupRobotQzoneInfo qzoneInfo = new GroupRobotQzoneInfo();
    public RobotTTSList ttsList = new RobotTTSList();
    public InputBox inputBox = new InputBox();
    public ArrayList<RealtimeBgSource> realtimeSpeechCfg = new ArrayList<>();
    public AioConfig aioConfig = new AioConfig();
    public RobotFeature robotFeature = new RobotFeature();
    public RobotMetricsInfo robotMetricsInfo = new RobotMetricsInfo();
    public QueryHalfViewDataRsp allStorySet = new QueryHalfViewDataRsp();
    public BlacklistInfo blacklistInfo = new BlacklistInfo();
    public ArrayList<RobotLabel> robotLabelList = new ArrayList<>();
    public ArrayList<RobotGroupInfo> robotGroupInfoList = new ArrayList<>();
    public RobotEntranceCards entranceCards = new RobotEntranceCards();

    public AioConfig getAioConfig() {
        return this.aioConfig;
    }

    public QueryHalfViewDataRsp getAllStorySet() {
        return this.allStorySet;
    }

    public String getAvatarDominantColor() {
        return this.avatarDominantColor;
    }

    public BlacklistInfo getBlacklistInfo() {
        return this.blacklistInfo;
    }

    public String getC2cDayBackground() {
        return this.c2cDayBackground;
    }

    public String getC2cNightBackground() {
        return this.c2cNightBackground;
    }

    public int getC2cSubscribeMsgTplCnt() {
        return this.c2cSubscribeMsgTplCnt;
    }

    public boolean getCanResetHistory() {
        return this.canResetHistory;
    }

    public ArrayList<RobotFeatureInfo> getCommands() {
        return this.commands;
    }

    public String getDayColor() {
        return this.dayColor;
    }

    public String getDayDynamicPic() {
        return this.dayDynamicPic;
    }

    public RobotEntranceCards getEntranceCards() {
        return this.entranceCards;
    }

    public int getGroupSubscribeMsgTplCnt() {
        return this.groupSubscribeMsgTplCnt;
    }

    public RobotBackGround getInfoBg() {
        return this.infoBg;
    }

    public InputBox getInputBox() {
        return this.inputBox;
    }

    public boolean getIsFriend() {
        return this.isFriend;
    }

    public boolean getIsGroupReceive() {
        return this.isGroupReceive;
    }

    public boolean getIsReceive() {
        return this.isReceive;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getNightColor() {
        return this.nightColor;
    }

    public String getNightDynamicPic() {
        return this.nightDynamicPic;
    }

    public String getPanelTitle() {
        return this.panelTitle;
    }

    public ArrayList<RobotPanelInfo> getPanels() {
        return this.panels;
    }

    public ArrayList<ImageInfo> getPreviewImages() {
        return this.previewImages;
    }

    public String getPreviewImagesTitle() {
        return this.previewImagesTitle;
    }

    public byte[] getPromptMsg() {
        return this.promptMsg;
    }

    public GroupRobotQzoneInfo getQzoneInfo() {
        return this.qzoneInfo;
    }

    public ArrayList<RealtimeBgSource> getRealtimeSpeechCfg() {
        return this.realtimeSpeechCfg;
    }

    public RobotBaseInfo getRobotData() {
        return this.robotData;
    }

    public RobotFeature getRobotFeature() {
        return this.robotFeature;
    }

    public ArrayList<RobotGroupInfo> getRobotGroupInfoList() {
        return this.robotGroupInfoList;
    }

    public ArrayList<RobotLabel> getRobotLabelList() {
        return this.robotLabelList;
    }

    public int getRobotMembership() {
        return this.robotMembership;
    }

    public RobotMetricsInfo getRobotMetricsInfo() {
        return this.robotMetricsInfo;
    }

    public int getSubscribeMsgTplCnt() {
        return this.subscribeMsgTplCnt;
    }

    public GroupTraceInfo getTraceInfo() {
        return this.traceInfo;
    }

    public RobotTTSList getTtsList() {
        return this.ttsList;
    }

    public int getUserMembership() {
        return this.userMembership;
    }

    public ArrayList<RobotUsingLabel> getUsingLabels() {
        return this.usingLabels;
    }

    public String toString() {
        return "GroupRobotProfile{robotData=" + this.robotData + ",userMembership=" + this.userMembership + ",robotMembership=" + this.robotMembership + ",isFriend=" + this.isFriend + ",usingLabels=" + this.usingLabels + ",panels=" + this.panels + ",commands=" + this.commands + ",previewImages=" + this.previewImages + ",isReceive=" + this.isReceive + ",canResetHistory=" + this.canResetHistory + ",isGroupReceive=" + this.isGroupReceive + ",jumpUrl=" + this.jumpUrl + ",subscribeMsgTplCnt=" + this.subscribeMsgTplCnt + ",panelTitle=" + this.panelTitle + ",previewImagesTitle=" + this.previewImagesTitle + ",traceInfo=" + this.traceInfo + ",c2cDayBackground=" + this.c2cDayBackground + ",c2cNightBackground=" + this.c2cNightBackground + ",avatarDominantColor=" + this.avatarDominantColor + ",dayDynamicPic=" + this.dayDynamicPic + ",nightDynamicPic=" + this.nightDynamicPic + ",dayColor=" + this.dayColor + ",nightColor=" + this.nightColor + ",infoBg=" + this.infoBg + ",promptMsg=" + this.promptMsg + ",qzoneInfo=" + this.qzoneInfo + ",ttsList=" + this.ttsList + ",inputBox=" + this.inputBox + ",realtimeSpeechCfg=" + this.realtimeSpeechCfg + ",aioConfig=" + this.aioConfig + ",robotFeature=" + this.robotFeature + ",robotMetricsInfo=" + this.robotMetricsInfo + ",allStorySet=" + this.allStorySet + ",blacklistInfo=" + this.blacklistInfo + ",robotLabelList=" + this.robotLabelList + ",c2cSubscribeMsgTplCnt=" + this.c2cSubscribeMsgTplCnt + ",groupSubscribeMsgTplCnt=" + this.groupSubscribeMsgTplCnt + ",robotGroupInfoList=" + this.robotGroupInfoList + ",entranceCards=" + this.entranceCards + ",}";
    }
}
