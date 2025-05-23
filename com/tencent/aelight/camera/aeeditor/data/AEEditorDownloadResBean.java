package com.tencent.aelight.camera.aeeditor.data;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorDownloadResBean implements Serializable {
    public static final int PRE_DOWNLOAD_FALSE = 0;
    public static final int PRE_DOWNLOAD_TRUE = 1;
    private String fontFamily;

    /* renamed from: id, reason: collision with root package name */
    private String f66099id;
    private String md5;
    private int preDownload;
    private String url;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    @interface PreDownloadFlag {
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public String getId() {
        return this.f66099id;
    }

    public String getMd5() {
        return this.md5;
    }

    public int getPreDownload() {
        return this.preDownload;
    }

    public String getUrl() {
        return this.url;
    }

    public void setFontFamily(String str) {
        this.fontFamily = str;
    }

    public void setId(String str) {
        this.f66099id = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setPreDownload(int i3) {
        this.preDownload = i3;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
