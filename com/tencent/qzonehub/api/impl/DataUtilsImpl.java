package com.tencent.qzonehub.api.impl;

import com.tencent.qzonehub.api.IDataUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes34.dex */
public class DataUtilsImpl implements IDataUtils {
    private static final String TAG = "DataUtilsImpl";

    @Override // com.tencent.qzonehub.api.IDataUtils
    public boolean closeDataObject(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof InputStream) {
            ((InputStream) obj).close();
            return true;
        }
        if (obj instanceof OutputStream) {
            ((OutputStream) obj).close();
            return true;
        }
        if (obj instanceof Reader) {
            ((Reader) obj).close();
            return true;
        }
        if (obj instanceof Writer) {
            ((Writer) obj).close();
            return true;
        }
        if (obj instanceof RandomAccessFile) {
            ((RandomAccessFile) obj).close();
            return true;
        }
        return false;
    }
}
