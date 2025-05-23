package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ArkToMarkdownMsgTemplateInfo {
    public ArrayList<ArkToMarkdownMsgTemplateInfoElement> templateElementList = new ArrayList<>();
    public long updateIntervalSec;

    public ArrayList<ArkToMarkdownMsgTemplateInfoElement> getTemplateElementList() {
        return this.templateElementList;
    }

    public long getUpdateIntervalSec() {
        return this.updateIntervalSec;
    }

    public String toString() {
        return "ArkToMarkdownMsgTemplateInfo{updateIntervalSec=" + this.updateIntervalSec + ",templateElementList=" + this.templateElementList + ",}";
    }
}
