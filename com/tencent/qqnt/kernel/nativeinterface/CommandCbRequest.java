package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CommandCbRequest {
    public long botAppId;
    public String botUid;
    public long botUin;
    public long c2cUin;
    public String callbackData;
    public long channelId;
    public int chatType;
    public int dmFlag;
    public String featureId;
    public long groupId;
    public long guildId;
    public StoryAction storyAction;

    public CommandCbRequest() {
        this.featureId = "";
        this.callbackData = "";
        this.storyAction = StoryAction.values()[0];
        this.botUid = "";
    }

    public long getBotAppId() {
        return this.botAppId;
    }

    public String getBotUid() {
        return this.botUid;
    }

    public long getBotUin() {
        return this.botUin;
    }

    public long getC2cUin() {
        return this.c2cUin;
    }

    public String getCallbackData() {
        return this.callbackData;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getDmFlag() {
        return this.dmFlag;
    }

    public String getFeatureId() {
        return this.featureId;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public StoryAction getStoryAction() {
        return this.storyAction;
    }

    public String toString() {
        return "CommandCbRequest{guildId=" + this.guildId + ",channelId=" + this.channelId + ",botAppId=" + this.botAppId + ",botUin=" + this.botUin + ",featureId=" + this.featureId + ",callbackData=" + this.callbackData + ",dmFlag=" + this.dmFlag + ",groupId=" + this.groupId + ",c2cUin=" + this.c2cUin + ",chatType=" + this.chatType + ",storyAction=" + this.storyAction + ",botUid=" + this.botUid + ",}";
    }

    public CommandCbRequest(long j3, long j16, long j17, long j18, String str, String str2, int i3, long j19, long j26, int i16, StoryAction storyAction, String str3) {
        this.featureId = "";
        this.callbackData = "";
        StoryAction storyAction2 = StoryAction.values()[0];
        this.guildId = j3;
        this.channelId = j16;
        this.botAppId = j17;
        this.botUin = j18;
        this.featureId = str;
        this.callbackData = str2;
        this.dmFlag = i3;
        this.groupId = j19;
        this.c2cUin = j26;
        this.chatType = i16;
        this.storyAction = storyAction;
        this.botUid = str3;
    }
}
