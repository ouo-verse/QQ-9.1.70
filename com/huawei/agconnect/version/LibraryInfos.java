package com.huawei.agconnect.version;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LibraryInfos {
    private static final LibraryInfos INSTANCE = new LibraryInfos();
    private String libraryType = "Java";

    LibraryInfos() {
    }

    public static LibraryInfos getInstance() {
        return INSTANCE;
    }

    public String getLibraryType() {
        return this.libraryType;
    }

    public void registerLibraryType(String str) {
        this.libraryType = str;
    }
}
