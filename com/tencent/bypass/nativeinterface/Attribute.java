package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class Attribute {
    public static final int CODE_ELEMENT_TYPE = 2;
    public static final int CUSTOM_ELEMENT_TYPE = 3;
    public static final int STR_ELEMENT_TYPE = 1;
    public static final int UNKNOWN_TYPE = 0;
    final CodeElement mCodeElement;
    final CustomElement mCustomElement;
    final StrElement mStrElement;
    final int mType;

    public Attribute(int i3, @NonNull StrElement strElement, @NonNull CodeElement codeElement, @NonNull CustomElement customElement) {
        this.mType = i3;
        this.mStrElement = strElement;
        this.mCodeElement = codeElement;
        this.mCustomElement = customElement;
    }

    @NonNull
    public CodeElement getCodeElement() {
        return this.mCodeElement;
    }

    @NonNull
    public CustomElement getCustomElement() {
        return this.mCustomElement;
    }

    @NonNull
    public StrElement getStrElement() {
        return this.mStrElement;
    }

    public int getType() {
        return this.mType;
    }

    public String toString() {
        return "Attribute{mType=" + this.mType + ",mStrElement=" + this.mStrElement + ",mCodeElement=" + this.mCodeElement + ",mCustomElement=" + this.mCustomElement + "}";
    }
}
