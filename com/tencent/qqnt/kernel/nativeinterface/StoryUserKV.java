package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StoryUserKV {
    public boolean isClear;
    public StoryKeyType keyType = StoryKeyType.values()[0];
    public StoryBaseInfo storyInfo = new StoryBaseInfo();

    public boolean getIsClear() {
        return this.isClear;
    }

    public StoryKeyType getKeyType() {
        return this.keyType;
    }

    public StoryBaseInfo getStoryInfo() {
        return this.storyInfo;
    }

    public String toString() {
        return "StoryUserKV{keyType=" + this.keyType + ",storyInfo=" + this.storyInfo + ",isClear=" + this.isClear + ",}";
    }
}
