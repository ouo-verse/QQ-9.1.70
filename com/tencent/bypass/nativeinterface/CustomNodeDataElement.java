package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CustomNodeDataElement {
    final HashMap<String, String> mAttrMap;
    final String mIndex;
    final String mLink;
    final String mNodeId;
    final String mText;

    public CustomNodeDataElement(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull HashMap<String, String> hashMap) {
        this.mText = str;
        this.mLink = str2;
        this.mNodeId = str3;
        this.mIndex = str4;
        this.mAttrMap = hashMap;
    }

    @NonNull
    public HashMap<String, String> getAttrMap() {
        return this.mAttrMap;
    }

    @NonNull
    public String getIndex() {
        return this.mIndex;
    }

    @NonNull
    public String getLink() {
        return this.mLink;
    }

    @NonNull
    public String getNodeId() {
        return this.mNodeId;
    }

    @NonNull
    public String getText() {
        return this.mText;
    }

    public String toString() {
        return "CustomNodeDataElement{mText=" + this.mText + ",mLink=" + this.mLink + ",mNodeId=" + this.mNodeId + ",mIndex=" + this.mIndex + ",mAttrMap=" + this.mAttrMap + "}";
    }
}
