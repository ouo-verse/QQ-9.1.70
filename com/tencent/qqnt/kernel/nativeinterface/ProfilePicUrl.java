package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class ProfilePicUrl {
    public String picPath;
    public String picUrl;

    public ProfilePicUrl() {
        this.picUrl = "";
        this.picPath = "";
    }

    public String getPicPath() {
        return this.picPath;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public ProfilePicUrl(String str, String str2) {
        this.picUrl = str;
        this.picPath = str2;
    }
}
