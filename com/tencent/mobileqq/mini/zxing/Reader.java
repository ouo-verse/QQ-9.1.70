package com.tencent.mobileqq.mini.zxing;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface Reader {
    Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException;

    Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
