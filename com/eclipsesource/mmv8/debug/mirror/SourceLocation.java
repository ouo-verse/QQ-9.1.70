package com.eclipsesource.mmv8.debug.mirror;

import com.tencent.component.media.image.ProgressTracer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SourceLocation {
    private final int column;
    private final int line;
    private final int position;
    private final String scriptName;
    private String sourceText;

    public SourceLocation(String str, int i3, int i16, int i17, String str2) {
        this.scriptName = str;
        this.position = i3;
        this.line = i16;
        this.column = i17;
        this.sourceText = str2;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int getPosition() {
        return this.position;
    }

    public String getScriptName() {
        return this.scriptName;
    }

    public String getSourceText() {
        return this.sourceText;
    }

    public String toString() {
        return this.scriptName + ProgressTracer.SEPARATOR + this.position + ProgressTracer.SEPARATOR + this.line + ProgressTracer.SEPARATOR + this.column + ProgressTracer.SEPARATOR + this.sourceText;
    }
}
