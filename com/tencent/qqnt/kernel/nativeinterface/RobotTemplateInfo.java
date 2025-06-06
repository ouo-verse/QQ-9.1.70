package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotTemplateInfo {

    /* renamed from: id, reason: collision with root package name */
    public long f359210id;
    public int type;
    public String title = "";
    public String desc = "";
    public String image = "";
    public String extInfo = "";

    public String getDesc() {
        return this.desc;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public long getId() {
        return this.f359210id;
    }

    public String getImage() {
        return this.image;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "RobotTemplateInfo{id=" + this.f359210id + ",type=" + this.type + ",title=" + this.title + ",desc=" + this.desc + ",image=" + this.image + ",extInfo=" + this.extInfo + ",}";
    }
}
