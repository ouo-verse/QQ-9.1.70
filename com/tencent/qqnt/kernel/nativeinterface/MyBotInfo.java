package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MyBotInfo {
    public long uin;
    public String uid = "";
    public String botAvatar = "";
    public String botName = "";
    public String botPrompt = "";
    public String botWelcomeMsg = "";
    public String botDesc = "";
    public BotGender botGender = BotGender.values()[0];
    public String c2cDayBackground = "";
    public String c2cNightBackground = "";
    public String avatarDominantColor = "";
    public String dayDynamicPic = "";
    public String nightDynamicPic = "";
    public String dayColor = "";
    public String nightColor = "";
    public String imgDesc = "";
    public String ttsId = "";
    public String ttsName = "";
    public byte[] imgInfo = new byte[0];
    public ArrayList<RobotActivityLabel> robotActivityLabelList = new ArrayList<>();
    public ArrayList<RobotPromptConversation> robotPromptConversationList = new ArrayList<>();

    public String getAvatarDominantColor() {
        return this.avatarDominantColor;
    }

    public String getBotAvatar() {
        return this.botAvatar;
    }

    public String getBotDesc() {
        return this.botDesc;
    }

    public BotGender getBotGender() {
        return this.botGender;
    }

    public String getBotName() {
        return this.botName;
    }

    public String getBotPrompt() {
        return this.botPrompt;
    }

    public String getBotWelcomeMsg() {
        return this.botWelcomeMsg;
    }

    public String getC2cDayBackground() {
        return this.c2cDayBackground;
    }

    public String getC2cNightBackground() {
        return this.c2cNightBackground;
    }

    public String getDayColor() {
        return this.dayColor;
    }

    public String getDayDynamicPic() {
        return this.dayDynamicPic;
    }

    public String getImgDesc() {
        return this.imgDesc;
    }

    public byte[] getImgInfo() {
        return this.imgInfo;
    }

    public String getNightColor() {
        return this.nightColor;
    }

    public String getNightDynamicPic() {
        return this.nightDynamicPic;
    }

    public ArrayList<RobotActivityLabel> getRobotActivityLabelList() {
        return this.robotActivityLabelList;
    }

    public ArrayList<RobotPromptConversation> getRobotPromptConversationList() {
        return this.robotPromptConversationList;
    }

    public String getTtsId() {
        return this.ttsId;
    }

    public String getTtsName() {
        return this.ttsName;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "MyBotInfo{uid=" + this.uid + ",uin=" + this.uin + ",botAvatar=" + this.botAvatar + ",botName=" + this.botName + ",botPrompt=" + this.botPrompt + ",botWelcomeMsg=" + this.botWelcomeMsg + ",botDesc=" + this.botDesc + ",botGender=" + this.botGender + ",c2cDayBackground=" + this.c2cDayBackground + ",c2cNightBackground=" + this.c2cNightBackground + ",avatarDominantColor=" + this.avatarDominantColor + ",dayDynamicPic=" + this.dayDynamicPic + ",nightDynamicPic=" + this.nightDynamicPic + ",dayColor=" + this.dayColor + ",nightColor=" + this.nightColor + ",imgDesc=" + this.imgDesc + ",ttsId=" + this.ttsId + ",ttsName=" + this.ttsName + ",imgInfo=" + this.imgInfo + ",robotActivityLabelList=" + this.robotActivityLabelList + ",robotPromptConversationList=" + this.robotPromptConversationList + ",}";
    }
}
