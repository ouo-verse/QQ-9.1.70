package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TemplateGroup {

    /* renamed from: id, reason: collision with root package name */
    public long f359229id;
    public ArrayList<RobotTemplateInfo> templateList = new ArrayList<>();
    public int type;

    public long getId() {
        return this.f359229id;
    }

    public ArrayList<RobotTemplateInfo> getTemplateList() {
        return this.templateList;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "TemplateGroup{id=" + this.f359229id + ",type=" + this.type + ",templateList=" + this.templateList + ",}";
    }
}
