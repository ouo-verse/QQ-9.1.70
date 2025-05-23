package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g implements Comparator<FileInfo> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(FileInfo fileInfo, FileInfo fileInfo2) {
        if (fileInfo.m()) {
            if (!fileInfo2.m()) {
                return -1000;
            }
        } else if (fileInfo2.m()) {
            return 1000;
        }
        return fileInfo.j().compareToIgnoreCase(fileInfo2.j());
    }
}
