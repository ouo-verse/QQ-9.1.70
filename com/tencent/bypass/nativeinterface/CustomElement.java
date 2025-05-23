package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CustomElement {
    public static final int CUSTOM_NODE_DATA_TYPE = 2;
    public static final int CUSTOM_REPLACE_TYPE = 0;
    public static final int CUSTOM_STYLE_TYPE = 1;
    final int mElementType;
    final String mLink;
    final CustomNodeDataElement mNodeDataElement;
    final CustomReplaceElement mReplaceElement;
    final CustomStyleElement mStyleElement;
    final String mText;

    public CustomElement(@NonNull String str, @NonNull String str2, int i3, @NonNull CustomReplaceElement customReplaceElement, @NonNull CustomStyleElement customStyleElement, @NonNull CustomNodeDataElement customNodeDataElement) {
        this.mText = str;
        this.mLink = str2;
        this.mElementType = i3;
        this.mReplaceElement = customReplaceElement;
        this.mStyleElement = customStyleElement;
        this.mNodeDataElement = customNodeDataElement;
    }

    public int getElementType() {
        return this.mElementType;
    }

    @NonNull
    public String getLink() {
        return this.mLink;
    }

    @NonNull
    public CustomNodeDataElement getNodeDataElement() {
        return this.mNodeDataElement;
    }

    @NonNull
    public CustomReplaceElement getReplaceElement() {
        return this.mReplaceElement;
    }

    @NonNull
    public CustomStyleElement getStyleElement() {
        return this.mStyleElement;
    }

    @NonNull
    public String getText() {
        return this.mText;
    }

    public String toString() {
        return "CustomElement{mText=" + this.mText + ",mLink=" + this.mLink + ",mElementType=" + this.mElementType + ",mReplaceElement=" + this.mReplaceElement + ",mStyleElement=" + this.mStyleElement + ",mNodeDataElement=" + this.mNodeDataElement + "}";
    }
}
