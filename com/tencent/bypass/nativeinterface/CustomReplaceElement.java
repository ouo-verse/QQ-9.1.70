package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CustomReplaceElement {
    final HashMap<String, String> mAttrMap;
    final String mLink;
    final String mReplaceNodeId;
    final String mText;

    public CustomReplaceElement(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull HashMap<String, String> hashMap) {
        this.mText = str;
        this.mLink = str2;
        this.mReplaceNodeId = str3;
        this.mAttrMap = hashMap;
    }

    @NonNull
    public HashMap<String, String> getAttrMap() {
        return this.mAttrMap;
    }

    @NonNull
    public String getLink() {
        return this.mLink;
    }

    @NonNull
    public String getReplaceNodeId() {
        return this.mReplaceNodeId;
    }

    @NonNull
    public String getText() {
        return this.mText;
    }

    public String toString() {
        return "CustomReplaceElement{mText=" + this.mText + ",mLink=" + this.mLink + ",mReplaceNodeId=" + this.mReplaceNodeId + ",mAttrMap=" + this.mAttrMap + "}";
    }
}
