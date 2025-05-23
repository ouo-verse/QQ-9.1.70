package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.BinaryBitmap;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Map;

/* loaded from: classes33.dex */
public final class UPCAReader extends UPCEANReader {
    private final UPCEANReader ean13Reader = new EAN13Reader();

    private static Result maybeReturnResult(Result result) throws FormatException {
        String text = result.getText();
        if (text.charAt(0) == '0') {
            Result result2 = new Result(text.substring(1), null, result.getResultPoints(), BarcodeFormat.UPC_A);
            if (result.getResultMetadata() != null) {
                result2.putAllMetadata(result.getResultMetadata());
            }
            return result2;
        }
        throw FormatException.getFormatInstance();
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.OneDReader, com.tencent.mobileqq.mini.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb5) throws NotFoundException {
        return this.ean13Reader.decodeMiddle(bitArray, iArr, sb5);
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
    public Result decodeRow(int i3, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return maybeReturnResult(this.ean13Reader.decodeRow(i3, bitArray, iArr, map));
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_A;
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.OneDReader, com.tencent.mobileqq.mini.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap, map));
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.UPCEANReader, com.tencent.mobileqq.mini.zxing.oned.OneDReader
    public Result decodeRow(int i3, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return maybeReturnResult(this.ean13Reader.decodeRow(i3, bitArray, map));
    }
}
