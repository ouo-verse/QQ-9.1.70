package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchEmotionList {
    public ArrayList<SearchPicture> pics = new ArrayList<>();
    public String stringExtension = "";

    public ArrayList<SearchPicture> getPics() {
        return this.pics;
    }

    public String getStringExtension() {
        return this.stringExtension;
    }

    public String toString() {
        return "SearchEmotionList{pics=" + this.pics + ",stringExtension=" + this.stringExtension + ",}";
    }
}
