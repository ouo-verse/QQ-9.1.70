package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotStoryActionSetReq {
    public String robotUid = "";
    public StoryUserKV storyKV = new StoryUserKV();

    public String getRobotUid() {
        return this.robotUid;
    }

    public StoryUserKV getStoryKV() {
        return this.storyKV;
    }

    public String toString() {
        return "RobotStoryActionSetReq{robotUid=" + this.robotUid + ",storyKV=" + this.storyKV + ",}";
    }
}
