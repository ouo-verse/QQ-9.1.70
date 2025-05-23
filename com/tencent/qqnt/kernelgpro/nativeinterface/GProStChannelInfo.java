package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStChannelInfo implements Serializable {
    public int hotIndex;
    public boolean isSquare;
    public int movePostSection;
    public int privateType;
    long serialVersionUID = 1;
    public GProStChannelSign sign = new GProStChannelSign();
    public String name = "";
    public String iconUrl = "";
    public String guildName = "";
    public String hotIcon = "";
    public String memberCount = "";
    public GProStGuildLabel label = new GProStGuildLabel();
    public ArrayList<GProMedalInfo> medals = new ArrayList<>();

    public String getGuildName() {
        return this.guildName;
    }

    public String getHotIcon() {
        return this.hotIcon;
    }

    public int getHotIndex() {
        return this.hotIndex;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public boolean getIsSquare() {
        return this.isSquare;
    }

    public GProStGuildLabel getLabel() {
        return this.label;
    }

    public ArrayList<GProMedalInfo> getMedals() {
        return this.medals;
    }

    public String getMemberCount() {
        return this.memberCount;
    }

    public int getMovePostSection() {
        return this.movePostSection;
    }

    public String getName() {
        return this.name;
    }

    public int getPrivateType() {
        return this.privateType;
    }

    public GProStChannelSign getSign() {
        return this.sign;
    }

    public String toString() {
        return "GProStChannelInfo{sign=" + this.sign + ",name=" + this.name + ",iconUrl=" + this.iconUrl + ",privateType=" + this.privateType + ",guildName=" + this.guildName + ",hotIcon=" + this.hotIcon + ",hotIndex=" + this.hotIndex + ",movePostSection=" + this.movePostSection + ",isSquare=" + this.isSquare + ",memberCount=" + this.memberCount + ",label=" + this.label + ",medals=" + this.medals + ",}";
    }
}
