package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class JarMarker implements ZipExtraField {
    private static final ZipShort ID = new ZipShort(51966);
    private static final ZipShort NULL = new ZipShort(0);
    private static final byte[] NO_BYTES = new byte[0];
    private static final JarMarker DEFAULT = new JarMarker();

    public static JarMarker getInstance() {
        return DEFAULT;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return NO_BYTES;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return NULL;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return ID;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return NO_BYTES;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return NULL;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i3, int i16) throws ZipException {
        if (i16 == 0) {
        } else {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }
}
