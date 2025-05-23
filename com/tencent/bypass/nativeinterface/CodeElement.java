package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CodeElement {
    final ArrayList<CodeNode> mCodeNodes;

    public CodeElement(@NonNull ArrayList<CodeNode> arrayList) {
        this.mCodeNodes = arrayList;
    }

    @NonNull
    public ArrayList<CodeNode> getCodeNodes() {
        return this.mCodeNodes;
    }

    public String toString() {
        return "CodeElement{mCodeNodes=" + this.mCodeNodes + "}";
    }
}
