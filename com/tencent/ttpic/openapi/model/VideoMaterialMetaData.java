package com.tencent.ttpic.openapi.model;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoMaterialMetaData {
    public static final String WEB_PREFIX = "http";
    public String category;

    /* renamed from: id, reason: collision with root package name */
    public String f381705id;
    public long lastModified = 0;
    public String path;
    public String thumbPath;
    public String url;

    public VideoMaterialMetaData(String str, String str2, String str3, String str4) {
        this.f381705id = str;
        this.path = str2;
        this.url = str3;
        this.thumbPath = str4;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }
}
