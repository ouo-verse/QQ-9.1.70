package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildTaskCardInfo {
    public int taskType;
    public GProGuildTaskCardLineText mainTitle = new GProGuildTaskCardLineText();
    public GProGuildTaskCardLineText subTitle = new GProGuildTaskCardLineText();
    public GProGuildTaskCardLineText progressComment = new GProGuildTaskCardLineText();
    public GProGuildTaskCardText button = new GProGuildTaskCardText();
    public String backgroundImg = "";
    public String iconImg = "";

    public String getBackgroundImg() {
        return this.backgroundImg;
    }

    public GProGuildTaskCardText getButton() {
        return this.button;
    }

    public String getIconImg() {
        return this.iconImg;
    }

    public GProGuildTaskCardLineText getMainTitle() {
        return this.mainTitle;
    }

    public GProGuildTaskCardLineText getProgressComment() {
        return this.progressComment;
    }

    public GProGuildTaskCardLineText getSubTitle() {
        return this.subTitle;
    }

    public int getTaskType() {
        return this.taskType;
    }

    public String toString() {
        return "GProGuildTaskCardInfo{taskType=" + this.taskType + ",mainTitle=" + this.mainTitle + ",subTitle=" + this.subTitle + ",progressComment=" + this.progressComment + ",button=" + this.button + ",backgroundImg=" + this.backgroundImg + ",iconImg=" + this.iconImg + ",}";
    }
}
