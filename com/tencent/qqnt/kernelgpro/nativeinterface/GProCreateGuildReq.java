package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCreateGuildReq {
    public int ignoreGeneralizationWords;
    public int isSetName;
    public int isUploadAvatar;
    public String guildName = "";
    public GProSource src = new GProSource();
    public String profile = "";
    public ArrayList<Long> invitedUinList = new ArrayList<>();

    public String getGuildName() {
        return this.guildName;
    }

    public int getIgnoreGeneralizationWords() {
        return this.ignoreGeneralizationWords;
    }

    public ArrayList<Long> getInvitedUinList() {
        return this.invitedUinList;
    }

    public int getIsSetName() {
        return this.isSetName;
    }

    public int getIsUploadAvatar() {
        return this.isUploadAvatar;
    }

    public String getProfile() {
        return this.profile;
    }

    public GProSource getSrc() {
        return this.src;
    }

    public String toString() {
        return "GProCreateGuildReq{guildName=" + this.guildName + ",src=" + this.src + ",isUploadAvatar=" + this.isUploadAvatar + ",isSetName=" + this.isSetName + ",ignoreGeneralizationWords=" + this.ignoreGeneralizationWords + ",profile=" + this.profile + ",invitedUinList=" + this.invitedUinList + ",}";
    }
}
