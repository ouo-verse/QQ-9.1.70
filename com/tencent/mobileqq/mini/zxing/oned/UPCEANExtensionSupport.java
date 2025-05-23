package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.ReaderException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.common.BitArray;

/* loaded from: classes33.dex */
final class UPCEANExtensionSupport {
    private static final int[] EXTENSION_START_PATTERN = {1, 1, 2};
    private final UPCEANExtension2Support twoSupport = new UPCEANExtension2Support();
    private final UPCEANExtension5Support fiveSupport = new UPCEANExtension5Support();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Result decodeRow(int i3, BitArray bitArray, int i16) throws NotFoundException {
        int[] findGuardPattern = UPCEANReader.findGuardPattern(bitArray, i16, false, EXTENSION_START_PATTERN);
        try {
            return this.fiveSupport.decodeRow(i3, bitArray, findGuardPattern);
        } catch (ReaderException unused) {
            return this.twoSupport.decodeRow(i3, bitArray, findGuardPattern);
        }
    }
}
