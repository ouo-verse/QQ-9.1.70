package com.tencent.qqmini.sdk.core.utils;

import java.io.IOException;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes23.dex */
public class QZipIOException extends IOException {
    public static boolean isInvalidEntry(ZipEntry zipEntry) {
        String name;
        if (zipEntry != null && (name = zipEntry.getName()) != null && (name.contains("../") || name.contains("..\\"))) {
            return true;
        }
        return false;
    }
}
