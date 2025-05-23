package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProThirdBar implements Serializable {
    long serialVersionUID = 1;

    /* renamed from: id, reason: collision with root package name */
    public String f359315id = "";
    public String icon = "";
    public String title = "";
    public String desc = "";
    public String buttonText = "";
    public String contentScheme = "";
    public String buttonScheme = "";

    public String getButtonScheme() {
        return this.buttonScheme;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public String getContentScheme() {
        return this.contentScheme;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.f359315id;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProThirdBar{id=" + this.f359315id + ",icon=" + this.icon + ",title=" + this.title + ",desc=" + this.desc + ",buttonText=" + this.buttonText + ",contentScheme=" + this.contentScheme + ",buttonScheme=" + this.buttonScheme + ",}";
    }
}
