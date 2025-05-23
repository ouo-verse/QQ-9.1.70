package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetTeamUpTemplateListRsp {
    public ArrayList<TeamUpTemplate> templates = new ArrayList<>();

    public ArrayList<TeamUpTemplate> getTemplates() {
        return this.templates;
    }

    public String toString() {
        return "GetTeamUpTemplateListRsp{templates=" + this.templates + ",}";
    }
}
