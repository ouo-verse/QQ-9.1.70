package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProContentRecommendDocument implements Serializable {
    public long channelId;
    public long guildId;
    long serialVersionUID = 1;
    public String guildName = "";
    public String guildAvatar = "";
    public String docCover = "";
    public String docTitle = "";

    public long getChannelId() {
        return this.channelId;
    }

    public String getDocCover() {
        return this.docCover;
    }

    public String getDocTitle() {
        return this.docTitle;
    }

    public String getGuildAvatar() {
        return this.guildAvatar;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String toString() {
        return "GProContentRecommendDocument{guildId=" + this.guildId + ",channelId=" + this.channelId + ",guildName=" + this.guildName + ",guildAvatar=" + this.guildAvatar + ",docCover=" + this.docCover + ",docTitle=" + this.docTitle + ",}";
    }
}
