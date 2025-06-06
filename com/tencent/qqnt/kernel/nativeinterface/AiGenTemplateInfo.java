package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AiGenTemplateInfo {
    public long nextOffset;
    public String title = "";
    public ArrayList<TemplateGroup> templateGroupList = new ArrayList<>();

    public long getNextOffset() {
        return this.nextOffset;
    }

    public ArrayList<TemplateGroup> getTemplateGroupList() {
        return this.templateGroupList;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "AiGenTemplateInfo{title=" + this.title + ",nextOffset=" + this.nextOffset + ",templateGroupList=" + this.templateGroupList + ",}";
    }
}
