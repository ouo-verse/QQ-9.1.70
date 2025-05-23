package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StoryBaseInfo {
    public long storyId;
    public int storyType;
    public String name = "";
    public String title = "";
    public String introduce = "";
    public String pic = "";
    public String dayBackground = "";
    public String nightBackground = "";
    public String dayBackgroundColor = "";
    public String nightBackgroundColor = "";
    public String dayDynamicPic = "";
    public String nightDynamicPic = "";
    public String callbackData = "";

    public String getCallbackData() {
        return this.callbackData;
    }

    public String getDayBackground() {
        return this.dayBackground;
    }

    public String getDayBackgroundColor() {
        return this.dayBackgroundColor;
    }

    public String getDayDynamicPic() {
        return this.dayDynamicPic;
    }

    public String getIntroduce() {
        return this.introduce;
    }

    public String getName() {
        return this.name;
    }

    public String getNightBackground() {
        return this.nightBackground;
    }

    public String getNightBackgroundColor() {
        return this.nightBackgroundColor;
    }

    public String getNightDynamicPic() {
        return this.nightDynamicPic;
    }

    public String getPic() {
        return this.pic;
    }

    public long getStoryId() {
        return this.storyId;
    }

    public int getStoryType() {
        return this.storyType;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "StoryBaseInfo{storyId=" + this.storyId + ",name=" + this.name + ",title=" + this.title + ",introduce=" + this.introduce + ",pic=" + this.pic + ",dayBackground=" + this.dayBackground + ",nightBackground=" + this.nightBackground + ",dayBackgroundColor=" + this.dayBackgroundColor + ",nightBackgroundColor=" + this.nightBackgroundColor + ",dayDynamicPic=" + this.dayDynamicPic + ",nightDynamicPic=" + this.nightDynamicPic + ",storyType=" + this.storyType + ",callbackData=" + this.callbackData + ",}";
    }
}
