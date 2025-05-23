package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UgcSettingInfo {
    public int promptMaxLength;
    public RobotTTSList ttsList = new RobotTTSList();
    public ArrayList<PromptLabel> promptLabelList = new ArrayList<>();
    public UGCConversationSetting conversation = new UGCConversationSetting();
    public UGCRecycleSetting recycle = new UGCRecycleSetting();

    public UGCConversationSetting getConversation() {
        return this.conversation;
    }

    public ArrayList<PromptLabel> getPromptLabelList() {
        return this.promptLabelList;
    }

    public int getPromptMaxLength() {
        return this.promptMaxLength;
    }

    public UGCRecycleSetting getRecycle() {
        return this.recycle;
    }

    public RobotTTSList getTtsList() {
        return this.ttsList;
    }

    public String toString() {
        return "UgcSettingInfo{ttsList=" + this.ttsList + ",promptLabelList=" + this.promptLabelList + ",promptMaxLength=" + this.promptMaxLength + ",conversation=" + this.conversation + ",recycle=" + this.recycle + ",}";
    }
}
