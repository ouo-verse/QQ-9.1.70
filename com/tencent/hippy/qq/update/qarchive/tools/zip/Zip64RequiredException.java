package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Zip64RequiredException extends ZipException {
    static final String ARCHIVE_TOO_BIG_MESSAGE = "archive's size exceeds the limit of 4GByte.";
    static final String TOO_MANY_ENTRIES_MESSAGE = "archive contains more than 65535 entries.";
    private static final long serialVersionUID = 20110809;

    public Zip64RequiredException(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getEntryTooBigMessage(ZipEntry zipEntry) {
        return zipEntry.getName() + "'s size exceeds the limit of 4GByte.";
    }
}
