package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSchoolNoticeMediaContent {
    public String coverUrl;
    public long duration;
    public int fileType;
    public int height;
    public String md5;
    public String name;
    public long size;
    public String url;
    public int width;

    public GroupSchoolNoticeMediaContent() {
        this.url = "";
        this.md5 = "";
        this.name = "";
        this.coverUrl = "";
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getFileType() {
        return this.fileType;
    }

    public int getHeight() {
        return this.height;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GroupSchoolNoticeMediaContent{url=" + this.url + ",md5=" + this.md5 + ",name=" + this.name + ",size=" + this.size + ",duration=" + this.duration + ",coverUrl=" + this.coverUrl + ",fileType=" + this.fileType + ",height=" + this.height + ",width=" + this.width + ",}";
    }

    public GroupSchoolNoticeMediaContent(String str, String str2, String str3, long j3, long j16, String str4, int i3, int i16, int i17) {
        this.url = str;
        this.md5 = str2;
        this.name = str3;
        this.size = j3;
        this.duration = j16;
        this.coverUrl = str4;
        this.fileType = i3;
        this.height = i16;
        this.width = i17;
    }
}
