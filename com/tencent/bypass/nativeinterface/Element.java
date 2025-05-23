package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class Element {
    final HashMap<String, Attribute> mAttributes;
    final ArrayList<Element> mChildren;
    final String mText;
    final int mType;

    public Element(@NonNull String str, @NonNull HashMap<String, Attribute> hashMap, int i3, @NonNull ArrayList<Element> arrayList) {
        this.mText = str;
        this.mAttributes = hashMap;
        this.mType = i3;
        this.mChildren = arrayList;
    }

    @NonNull
    public HashMap<String, Attribute> getAttributes() {
        return this.mAttributes;
    }

    @NonNull
    public ArrayList<Element> getChildren() {
        return this.mChildren;
    }

    @NonNull
    public String getText() {
        return this.mText;
    }

    public int getType() {
        return this.mType;
    }

    public String toString() {
        return "Element{mText=" + this.mText + ",mAttributes=" + this.mAttributes + ",mType=" + this.mType + ",mChildren=" + this.mChildren + "}";
    }
}
