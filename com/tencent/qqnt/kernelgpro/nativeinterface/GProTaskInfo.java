package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProTaskInfo {
    public String icon;

    /* renamed from: id, reason: collision with root package name */
    public String f359314id;
    public String name;
    public String progressText;
    public int status;

    public GProTaskInfo() {
        this.f359314id = "";
        this.icon = "";
        this.name = "";
        this.progressText = "";
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.f359314id;
    }

    public String getName() {
        return this.name;
    }

    public String getProgressText() {
        return this.progressText;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "GProTaskInfo{id=" + this.f359314id + ",icon=" + this.icon + ",status=" + this.status + ",name=" + this.name + ",progressText=" + this.progressText + ",}";
    }

    public GProTaskInfo(String str, String str2, int i3, String str3, String str4) {
        this.f359314id = str;
        this.icon = str2;
        this.status = i3;
        this.name = str3;
        this.progressText = str4;
    }
}
