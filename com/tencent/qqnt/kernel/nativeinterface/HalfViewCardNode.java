package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class HalfViewCardNode {
    public AIWriteInfo aIWriteInfo;
    public int action;
    public AIDrawInfo aiDrawInfo;
    public int nodeType;
    public SearchInfo searchInfo;
    public StoryBaseInfo storyBaseInfo;
    public String layoutId = "";
    public String attrId = "";
    public String data = "";

    public AIWriteInfo getAIWriteInfo() {
        return this.aIWriteInfo;
    }

    public int getAction() {
        return this.action;
    }

    public AIDrawInfo getAiDrawInfo() {
        return this.aiDrawInfo;
    }

    public String getAttrId() {
        return this.attrId;
    }

    public String getData() {
        return this.data;
    }

    public String getLayoutId() {
        return this.layoutId;
    }

    public int getNodeType() {
        return this.nodeType;
    }

    public SearchInfo getSearchInfo() {
        return this.searchInfo;
    }

    public StoryBaseInfo getStoryBaseInfo() {
        return this.storyBaseInfo;
    }

    public String toString() {
        return "HalfViewCardNode{layoutId=" + this.layoutId + ",attrId=" + this.attrId + ",action=" + this.action + ",data=" + this.data + ",nodeType=" + this.nodeType + ",storyBaseInfo=" + this.storyBaseInfo + ",searchInfo=" + this.searchInfo + ",aiDrawInfo=" + this.aiDrawInfo + ",aIWriteInfo=" + this.aIWriteInfo + ",}";
    }
}
