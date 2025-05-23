package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ZipExtraField {
    byte[] getCentralDirectoryData();

    ZipShort getCentralDirectoryLength();

    ZipShort getHeaderId();

    byte[] getLocalFileDataData();

    ZipShort getLocalFileDataLength();

    void parseFromLocalFileData(byte[] bArr, int i3, int i16) throws ZipException;
}
