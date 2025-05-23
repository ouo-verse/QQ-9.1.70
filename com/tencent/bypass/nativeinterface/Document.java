package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class Document {
    final ArrayList<Element> mElements;

    public Document(@NonNull ArrayList<Element> arrayList) {
        this.mElements = arrayList;
    }

    @NonNull
    public ArrayList<Element> getElements() {
        return this.mElements;
    }

    public String toString() {
        return "Document{mElements=" + this.mElements + "}";
    }
}
