package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.ReaderException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultMetadataType;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.ResultPointCallback;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes33.dex */
public abstract class UPCEANReader extends OneDReader {
    static final int[][] L_AND_G_PATTERNS;
    static final int[][] L_PATTERNS;
    private static final float MAX_AVG_VARIANCE = 0.48f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    static final int[] START_END_PATTERN = {1, 1, 1};
    static final int[] MIDDLE_PATTERN = {1, 1, 1, 1, 1};
    static final int[] END_PATTERN = {1, 1, 1, 1, 1, 1};
    private final StringBuilder decodeRowStringBuffer = new StringBuilder(20);
    private final UPCEANExtensionSupport extensionReader = new UPCEANExtensionSupport();
    private final EANManufacturerOrgSupport eanManSupport = new EANManufacturerOrgSupport();

    static boolean checkStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i3 = length - 1;
        return getStandardUPCEANChecksum(charSequence.subSequence(0, i3)) == Character.digit(charSequence.charAt(i3), 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeDigit(BitArray bitArray, int[] iArr, int i3, int[][] iArr2) throws NotFoundException {
        OneDReader.recordPattern(bitArray, i3, iArr);
        int length = iArr2.length;
        float f16 = MAX_AVG_VARIANCE;
        int i16 = -1;
        for (int i17 = 0; i17 < length; i17++) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i17], 0.7f);
            if (patternMatchVariance < f16) {
                i16 = i17;
                f16 = patternMatchVariance;
            }
        }
        if (i16 >= 0) {
            return i16;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] findGuardPattern(BitArray bitArray, int i3, boolean z16, int[] iArr) throws NotFoundException {
        return findGuardPattern(bitArray, i3, z16, iArr, new int[iArr.length]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] findStartGuardPattern(BitArray bitArray) throws NotFoundException {
        int[] iArr = new int[START_END_PATTERN.length];
        int[] iArr2 = null;
        boolean z16 = false;
        int i3 = 0;
        while (!z16) {
            int[] iArr3 = START_END_PATTERN;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = findGuardPattern(bitArray, i3, false, iArr3, iArr);
            int i16 = iArr2[0];
            int i17 = iArr2[1];
            int i18 = i16 - (i17 - i16);
            if (i18 >= 0) {
                z16 = bitArray.isRange(i18, i16, false);
            }
            i3 = i17;
        }
        return iArr2;
    }

    static int getStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i3 = 0;
        for (int i16 = length - 1; i16 >= 0; i16 -= 2) {
            int charAt = charSequence.charAt(i16) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i3 += charAt;
        }
        int i17 = i3 * 3;
        for (int i18 = length - 2; i18 >= 0; i18 -= 2) {
            int charAt2 = charSequence.charAt(i18) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i17 += charAt2;
        }
        return (1000 - i17) % 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkChecksum(String str) throws FormatException {
        return checkStandardUPCEANChecksum(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb5) throws NotFoundException;

    @Override // com.tencent.mobileqq.mini.zxing.oned.OneDReader
    public Result decodeRow(int i3, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return decodeRow(i3, bitArray, findStartGuardPattern(bitArray), map);
    }

    abstract BarcodeFormat getBarcodeFormat();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        L_PATTERNS = iArr;
        int[][] iArr2 = new int[20];
        L_AND_G_PATTERNS = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i3 = 10; i3 < 20; i3++) {
            int[] iArr3 = L_PATTERNS[i3 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i16 = 0; i16 < iArr3.length; i16++) {
                iArr4[i16] = iArr3[(iArr3.length - i16) - 1];
            }
            L_AND_G_PATTERNS[i3] = iArr4;
        }
    }

    private static int[] findGuardPattern(BitArray bitArray, int i3, boolean z16, int[] iArr, int[] iArr2) throws NotFoundException {
        int size = bitArray.getSize();
        int nextUnset = z16 ? bitArray.getNextUnset(i3) : bitArray.getNextSet(i3);
        int length = iArr.length;
        boolean z17 = z16;
        int i16 = 0;
        int i17 = nextUnset;
        while (nextUnset < size) {
            if (bitArray.get(nextUnset) != z17) {
                iArr2[i16] = iArr2[i16] + 1;
            } else {
                if (i16 != length - 1) {
                    i16++;
                } else {
                    if (OneDReader.patternMatchVariance(iArr2, iArr, 0.7f) < MAX_AVG_VARIANCE) {
                        return new int[]{i17, nextUnset};
                    }
                    i17 += iArr2[0] + iArr2[1];
                    int i18 = i16 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i18);
                    iArr2[i18] = 0;
                    iArr2[i16] = 0;
                    i16--;
                }
                iArr2[i16] = 1;
                z17 = !z17;
            }
            nextUnset++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    int[] decodeEnd(BitArray bitArray, int i3) throws NotFoundException {
        return findGuardPattern(bitArray, i3, false, START_END_PATTERN);
    }

    public Result decodeRow(int i3, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i16;
        String lookupCountryIdentifier;
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        boolean z16 = true;
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((iArr[0] + iArr[1]) / 2.0f, i3));
        }
        StringBuilder sb5 = this.decodeRowStringBuffer;
        sb5.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, sb5);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(decodeMiddle, i3));
        }
        int[] decodeEnd = decodeEnd(bitArray, decodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((decodeEnd[0] + decodeEnd[1]) / 2.0f, i3));
        }
        int i17 = decodeEnd[1];
        int i18 = (i17 - decodeEnd[0]) + i17;
        if (i18 < bitArray.getSize() && bitArray.isRange(i17, i18, false)) {
            String sb6 = sb5.toString();
            if (sb6.length() >= 8) {
                if (checkChecksum(sb6)) {
                    BarcodeFormat barcodeFormat = getBarcodeFormat();
                    float f16 = i3;
                    Result result = new Result(sb6, null, new ResultPoint[]{new ResultPoint((iArr[1] + iArr[0]) / 2.0f, f16), new ResultPoint((decodeEnd[1] + decodeEnd[0]) / 2.0f, f16)}, barcodeFormat);
                    try {
                        Result decodeRow = this.extensionReader.decodeRow(i3, bitArray, decodeEnd[1]);
                        result.putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, decodeRow.getText());
                        result.putAllMetadata(decodeRow.getResultMetadata());
                        result.addResultPoints(decodeRow.getResultPoints());
                        i16 = decodeRow.getText().length();
                    } catch (ReaderException unused) {
                        i16 = 0;
                    }
                    int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
                    if (iArr2 != null) {
                        int length = iArr2.length;
                        int i19 = 0;
                        while (true) {
                            if (i19 >= length) {
                                z16 = false;
                                break;
                            }
                            if (i16 == iArr2[i19]) {
                                break;
                            }
                            i19++;
                        }
                        if (!z16) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                    }
                    if ((barcodeFormat == BarcodeFormat.EAN_13 || barcodeFormat == BarcodeFormat.UPC_A) && (lookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(sb6)) != null) {
                        result.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, lookupCountryIdentifier);
                    }
                    return result;
                }
                throw ChecksumException.getChecksumInstance();
            }
            throw FormatException.getFormatInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
