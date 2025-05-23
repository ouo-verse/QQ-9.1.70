package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SquareStatus {
    public String bigIcon;
    public String icon;

    /* renamed from: id, reason: collision with root package name */
    public int f359221id;
    public String title;
    public String type;

    public SquareStatus() {
        this.title = "";
        this.type = "";
        this.icon = "";
        this.bigIcon = "";
    }

    public String getBigIcon() {
        return this.bigIcon;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.f359221id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "SquareStatus{id=" + this.f359221id + ",title=" + this.title + ",type=" + this.type + ",icon=" + this.icon + ",bigIcon=" + this.bigIcon + ",}";
    }

    public SquareStatus(int i3, String str, String str2, String str3, String str4) {
        this.f359221id = i3;
        this.title = str;
        this.type = str2;
        this.icon = str3;
        this.bigIcon = str4;
    }
}
