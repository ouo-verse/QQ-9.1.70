package com.tencent.qqmini.sdk.core.utils;

import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileCompare implements Comparator<FileInfo> {
    @Override // java.util.Comparator
    public int compare(FileInfo fileInfo, FileInfo fileInfo2) {
        if (fileInfo.isDirectory()) {
            if (!fileInfo2.isDirectory()) {
                return -1000;
            }
        } else if (fileInfo2.isDirectory()) {
            return 1000;
        }
        return fileInfo.getName().compareToIgnoreCase(fileInfo2.getName());
    }
}
