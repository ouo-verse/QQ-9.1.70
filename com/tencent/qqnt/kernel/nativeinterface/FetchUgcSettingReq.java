package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FetchUgcSettingReq {
    public int FilterConversation;
    public int FilterLabels;
    public int FilterPromptMaxLength;
    public int FilterRecycle;
    public int FilterTtsList;

    public int getFilterConversation() {
        return this.FilterConversation;
    }

    public int getFilterLabels() {
        return this.FilterLabels;
    }

    public int getFilterPromptMaxLength() {
        return this.FilterPromptMaxLength;
    }

    public int getFilterRecycle() {
        return this.FilterRecycle;
    }

    public int getFilterTtsList() {
        return this.FilterTtsList;
    }

    public String toString() {
        return "FetchUgcSettingReq{FilterTtsList=" + this.FilterTtsList + ",FilterLabels=" + this.FilterLabels + ",FilterPromptMaxLength=" + this.FilterPromptMaxLength + ",FilterConversation=" + this.FilterConversation + ",FilterRecycle=" + this.FilterRecycle + ",}";
    }
}
