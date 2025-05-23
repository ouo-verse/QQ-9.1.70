package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpTemplate {
    public int templateId;
    public String title = "";
    public ArrayList<TeamUpContentItem> contentList = new ArrayList<>();
    public ArrayList<TeamUpOption> options = new ArrayList<>();
    public ArrayList<TeamUpAttachment> attachments = new ArrayList<>();

    public ArrayList<TeamUpAttachment> getAttachments() {
        return this.attachments;
    }

    public ArrayList<TeamUpContentItem> getContentList() {
        return this.contentList;
    }

    public ArrayList<TeamUpOption> getOptions() {
        return this.options;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "TeamUpTemplate{templateId=" + this.templateId + ",title=" + this.title + ",contentList=" + this.contentList + ",options=" + this.options + ",attachments=" + this.attachments + ",}";
    }
}
