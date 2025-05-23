package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotFeature {
    public int autoTts;
    public StoryBaseInfo storyInfo = new StoryBaseInfo();

    public int getAutoTts() {
        return this.autoTts;
    }

    public StoryBaseInfo getStoryInfo() {
        return this.storyInfo;
    }

    public String toString() {
        return "RobotFeature{autoTts=" + this.autoTts + ",storyInfo=" + this.storyInfo + ",}";
    }
}
