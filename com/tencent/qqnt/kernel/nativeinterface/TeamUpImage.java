package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpImage implements Serializable {
    public int height;
    public int width;
    long serialVersionUID = 1;
    public String picUrl = "";
    public String md5 = "";

    public int getHeight() {
        return this.height;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "TeamUpImage{width=" + this.width + ",height=" + this.height + ",picUrl=" + this.picUrl + ",md5=" + this.md5 + ",}";
    }
}
