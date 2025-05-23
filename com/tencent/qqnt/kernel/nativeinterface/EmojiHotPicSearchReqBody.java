package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class EmojiHotPicSearchReqBody {
    public int aioType;
    public long channelID;
    public long groupCode;
    public String guestUid;
    public long guildID;
    public boolean isSupportCompose;
    public boolean isSupportMall;
    public int pageIndex;
    public int pageSize;
    public int sceneType;
    public byte[] sessionInfo;
    public long srcUin;
    public String userText;

    public EmojiHotPicSearchReqBody() {
        this.userText = "";
    }

    public int getAioType() {
        return this.aioType;
    }

    public long getChannelID() {
        return this.channelID;
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

    public boolean getIsSupportCompose() {
        return this.isSupportCompose;
    }

    public boolean getIsSupportMall() {
        return this.isSupportMall;
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

    public byte[] getSessionInfo() {
        return this.sessionInfo;
    }

    public long getSrcUin() {
        return this.srcUin;
    }

    public String getUserText() {
        return this.userText;
    }

    public EmojiHotPicSearchReqBody(long j3, String str, int i3, int i16, byte[] bArr, int i17, int i18, String str2, long j16, long j17, long j18, boolean z16) {
        this.srcUin = j3;
        this.userText = str;
        this.pageSize = i3;
        this.pageIndex = i16;
        this.sessionInfo = bArr;
        this.sceneType = i17;
        this.aioType = i18;
        this.guestUid = str2;
        this.groupCode = j16;
        this.guildID = j17;
        this.channelID = j18;
        this.isSupportCompose = z16;
    }
}
