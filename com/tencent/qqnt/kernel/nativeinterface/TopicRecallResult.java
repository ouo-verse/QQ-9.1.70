package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TopicRecallResult {
    public int disappearSeconds;
    public String iconUrlDefault = "";
    public String iconUrlDark = "";
    public String title = "";
    public ArrayList<TopicAISubject> aiSubjects = new ArrayList<>();
    public String recallId = "";

    public ArrayList<TopicAISubject> getAiSubjects() {
        return this.aiSubjects;
    }

    public int getDisappearSeconds() {
        return this.disappearSeconds;
    }

    public String getIconUrlDark() {
        return this.iconUrlDark;
    }

    public String getIconUrlDefault() {
        return this.iconUrlDefault;
    }

    public String getRecallId() {
        return this.recallId;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "TopicRecallResult{iconUrlDefault=" + this.iconUrlDefault + ",iconUrlDark=" + this.iconUrlDark + ",title=" + this.title + ",aiSubjects=" + this.aiSubjects + ",recallId=" + this.recallId + ",disappearSeconds=" + this.disappearSeconds + ",}";
    }
}
