package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class StPicSpecUrlEntry {
    public int spec;
    public StPicUrl url;

    public StPicSpecUrlEntry() {
        this.url = new StPicUrl();
    }

    public int getSpec() {
        return this.spec;
    }

    public StPicUrl getUrl() {
        return this.url;
    }

    public void setSpec(int i3) {
        this.spec = i3;
    }

    public void setUrl(StPicUrl stPicUrl) {
        this.url = stPicUrl;
    }

    public StPicSpecUrlEntry(int i3, StPicUrl stPicUrl) {
        new StPicUrl();
        this.spec = i3;
        this.url = stPicUrl;
    }
}
