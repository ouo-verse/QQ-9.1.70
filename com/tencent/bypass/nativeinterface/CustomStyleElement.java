package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CustomStyleElement {
    public static final int CUSTOM_STYLE_END_STATE = 2;
    public static final int CUSTOM_STYLE_START_STATE = 1;
    public static final int CUSTOM_STYLE_UNKNOWN_STATE = 0;
    final HashMap<String, String> mAttrMap;
    final String mLink;
    final String mNodeId;
    final String mNodeType;
    final int mState;
    final String mText;

    public CustomStyleElement(int i3, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull HashMap<String, String> hashMap) {
        this.mState = i3;
        this.mText = str;
        this.mLink = str2;
        this.mNodeId = str3;
        this.mNodeType = str4;
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
    public String getNodeId() {
        return this.mNodeId;
    }

    @NonNull
    public String getNodeType() {
        return this.mNodeType;
    }

    public int getState() {
        return this.mState;
    }

    @NonNull
    public String getText() {
        return this.mText;
    }

    public String toString() {
        return "CustomStyleElement{mState=" + this.mState + ",mText=" + this.mText + ",mLink=" + this.mLink + ",mNodeId=" + this.mNodeId + ",mNodeType=" + this.mNodeType + ",mAttrMap=" + this.mAttrMap + "}";
    }
}
