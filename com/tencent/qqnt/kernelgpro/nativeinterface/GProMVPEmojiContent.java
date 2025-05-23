package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPEmojiContent implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    public String f359298id;
    long serialVersionUID;
    public String type;

    public GProMVPEmojiContent() {
        this.serialVersionUID = 1L;
        this.f359298id = "";
        this.type = "";
    }

    public String getId() {
        return this.f359298id;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "GProMVPEmojiContent{id=" + this.f359298id + ",type=" + this.type + ",}";
    }

    public GProMVPEmojiContent(String str, String str2) {
        this.serialVersionUID = 1L;
        this.f359298id = str;
        this.type = str2;
    }
}
