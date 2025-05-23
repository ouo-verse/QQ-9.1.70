package com.tencent.mobileqq.commonutils.zip;

import java.io.IOException;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QZipIOException extends IOException {
    public static boolean isInvalidEntry(ZipEntry zipEntry) {
        String name;
        if (zipEntry != null && (name = zipEntry.getName()) != null && (name.contains("../") || name.contains("..\\"))) {
            return true;
        }
        return false;
    }
}
