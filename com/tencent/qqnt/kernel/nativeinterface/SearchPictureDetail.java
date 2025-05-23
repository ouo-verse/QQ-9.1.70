package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class SearchPictureDetail {
    public SearchPicture large = new SearchPicture();
    public SearchPicture small = new SearchPicture();

    public SearchPicture getLarge() {
        return this.large;
    }

    public SearchPicture getSmall() {
        return this.small;
    }

    public String toString() {
        return "SearchPictureDetail{large=" + this.large + ",small=" + this.small + ",}";
    }
}
