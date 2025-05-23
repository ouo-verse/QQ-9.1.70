package com.tencent.av.zplan.avatar.resmgr;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVAvatarResInfo implements Serializable {
    public String dir;
    public String fileName;

    /* renamed from: id, reason: collision with root package name */
    public String f77300id;
    public boolean isZip;
    public String md5;
    public String url;

    public AVAvatarResInfo() {
        this.f77300id = "";
        this.url = "";
        this.md5 = "";
        this.dir = "";
        this.fileName = "";
        this.isZip = true;
    }

    public String toString() {
        return "ResInfo{id = " + this.f77300id + ", url = " + this.url + ", md5 = " + this.md5 + ", dir = " + this.dir + ", fileName = " + this.fileName + "}";
    }

    public AVAvatarResInfo(String str, String str2, String str3) {
        this.fileName = "";
        this.isZip = true;
        this.f77300id = str;
        this.url = str2;
        this.md5 = str3;
        this.dir = "";
        int lastIndexOf = str2.lastIndexOf(".");
        if (lastIndexOf > 0) {
            this.fileName = str3 + str2.substring(lastIndexOf);
            return;
        }
        this.fileName = str3;
    }
}
