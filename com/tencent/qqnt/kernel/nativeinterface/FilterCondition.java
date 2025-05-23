package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FilterCondition {
    public int fileCategory;
    public FileFilterType filterType = FileFilterType.values()[0];

    public int getFileCategory() {
        return this.fileCategory;
    }

    public FileFilterType getFilterType() {
        return this.filterType;
    }
}
