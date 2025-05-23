package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public interface CentralDirectoryParsingZipExtraField extends ZipExtraField {
    void parseFromCentralDirectoryData(byte[] bArr, int i3, int i16) throws ZipException;
}
