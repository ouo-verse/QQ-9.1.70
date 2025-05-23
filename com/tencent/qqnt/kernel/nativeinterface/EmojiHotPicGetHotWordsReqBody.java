package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class EmojiHotPicGetHotWordsReqBody {
    public int aioType;
    public long channelID;
    public String composeNick;
    public long groupCode;
    public String guestUid;
    public long guildID;
    public int pageIndex;
    public int pageSize;
    public int sceneType;
    public long srcUin;

    public EmojiHotPicGetHotWordsReqBody() {
    }

    public int getAioType() {
        return this.aioType;
    }

    public long getChannelID() {
        return this.channelID;
    }

    public String getComposeNick() {
        return this.composeNick;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGuestUid() {
        return this.guestUid;
    }

    public long getGuildID() {
        return this.guildID;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getSceneType() {
        return this.sceneType;
    }

    public long getSrcUin() {
        return this.srcUin;
    }

    public EmojiHotPicGetHotWordsReqBody(long j3, int i3, int i16, int i17, int i18, String str, long j16, long j17, long j18, String str2) {
        this.srcUin = j3;
        this.pageSize = i3;
        this.pageIndex = i16;
        this.sceneType = i17;
        this.aioType = i18;
        this.guestUid = str;
        this.groupCode = j16;
        this.guildID = j17;
        this.channelID = j18;
        this.composeNick = str2;
    }
}
