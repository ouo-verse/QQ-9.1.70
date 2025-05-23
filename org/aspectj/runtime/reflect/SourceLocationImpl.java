package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.SourceLocation;

/* compiled from: P */
/* loaded from: classes29.dex */
class SourceLocationImpl implements SourceLocation {
    String fileName;
    int line;
    Class withinType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SourceLocationImpl(Class cls, String str, int i3) {
        this.withinType = cls;
        this.fileName = str;
        this.line = i3;
    }

    @Override // org.aspectj.lang.reflect.SourceLocation
    public int getColumn() {
        return -1;
    }

    @Override // org.aspectj.lang.reflect.SourceLocation
    public String getFileName() {
        return this.fileName;
    }

    @Override // org.aspectj.lang.reflect.SourceLocation
    public int getLine() {
        return this.line;
    }

    @Override // org.aspectj.lang.reflect.SourceLocation
    public Class getWithinType() {
        return this.withinType;
    }

    public String toString() {
        return getFileName() + ":" + getLine();
    }
}
