package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CodeNode {
    public static final int SYNTAX_TYPE = 1;
    public static final int TEXT_TYPE = 2;
    public static final int UNKNOWN_TYPE = 0;
    final Syntax mSyntax;
    final Text mText;
    final int mType;

    public CodeNode(int i3, @NonNull Syntax syntax, @NonNull Text text) {
        this.mType = i3;
        this.mSyntax = syntax;
        this.mText = text;
    }

    @NonNull
    public Syntax getSyntax() {
        return this.mSyntax;
    }

    @NonNull
    public Text getText() {
        return this.mText;
    }

    public int getType() {
        return this.mType;
    }

    public String toString() {
        return "CodeNode{mType=" + this.mType + ",mSyntax=" + this.mSyntax + ",mText=" + this.mText + "}";
    }
}
