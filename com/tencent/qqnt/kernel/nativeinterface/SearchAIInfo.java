package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchAIInfo {
    public long robotUin;
    public String prompt = "";
    public String defaultText = "";
    public String model = "";
    public String questionId = "";
    public String robotUid = "";
    public SearchOpenSourceInfo openSourceInfo = new SearchOpenSourceInfo();
    public SearchModelListInfo modelListInfo = new SearchModelListInfo();
    public SearchModelInfo modelInfo = new SearchModelInfo();

    public String getDefaultText() {
        return this.defaultText;
    }

    public String getModel() {
        return this.model;
    }

    public SearchModelInfo getModelInfo() {
        return this.modelInfo;
    }

    public SearchModelListInfo getModelListInfo() {
        return this.modelListInfo;
    }

    public SearchOpenSourceInfo getOpenSourceInfo() {
        return this.openSourceInfo;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public String getQuestionId() {
        return this.questionId;
    }

    public String getRobotUid() {
        return this.robotUid;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "SearchAIInfo{prompt=" + this.prompt + ",defaultText=" + this.defaultText + ",model=" + this.model + ",questionId=" + this.questionId + ",robotUid=" + this.robotUid + ",robotUin=" + this.robotUin + ",openSourceInfo=" + this.openSourceInfo + ",modelListInfo=" + this.modelListInfo + ",modelInfo=" + this.modelInfo + ",}";
    }
}
