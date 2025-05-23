package com.tencent.aelight.camera.ae.album.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEAlbumMediaBaseModel implements Serializable {
    private String mOriginPath;
    private String path;

    public AEAlbumMediaBaseModel(String str) {
        this.path = str;
    }

    public String getOriginPath() {
        return this.mOriginPath;
    }

    public String getPath() {
        return this.path;
    }

    public void setOriginPath(String str) {
        this.mOriginPath = str;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
