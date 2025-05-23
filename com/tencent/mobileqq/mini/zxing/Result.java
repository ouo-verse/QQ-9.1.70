package com.tencent.mobileqq.mini.zxing;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Result {
    private final BarcodeFormat format;
    private final int numBits;
    private final byte[] rawBytes;
    private Map<ResultMetadataType, Object> resultMetadata;
    private ResultPoint[] resultPoints;
    private final String text;
    private final long timestamp;

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, resultPointArr, barcodeFormat, System.currentTimeMillis());
    }

    public void addResultPoints(ResultPoint[] resultPointArr) {
        ResultPoint[] resultPointArr2 = this.resultPoints;
        if (resultPointArr2 == null) {
            this.resultPoints = resultPointArr;
            return;
        }
        if (resultPointArr == null || resultPointArr.length <= 0) {
            return;
        }
        ResultPoint[] resultPointArr3 = new ResultPoint[resultPointArr2.length + resultPointArr.length];
        System.arraycopy(resultPointArr2, 0, resultPointArr3, 0, resultPointArr2.length);
        System.arraycopy(resultPointArr, 0, resultPointArr3, resultPointArr2.length, resultPointArr.length);
        this.resultPoints = resultPointArr3;
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.format;
    }

    public int getNumBits() {
        return this.numBits;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.resultMetadata;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public String getText() {
        return this.text;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void putMetadata(ResultMetadataType resultMetadataType, Object obj) {
        if (this.resultMetadata == null) {
            this.resultMetadata = new HashMap();
        }
        this.resultMetadata.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.text;
    }

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j3) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, resultPointArr, barcodeFormat, j3);
    }

    public Result(String str, byte[] bArr, int i3, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j3) {
        this.text = str;
        this.rawBytes = bArr;
        this.numBits = i3;
        this.resultPoints = resultPointArr;
        this.format = barcodeFormat;
        this.resultMetadata = null;
        this.timestamp = j3;
    }

    public void putAllMetadata(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.resultMetadata;
            if (map2 == null) {
                this.resultMetadata = map;
            } else {
                map2.putAll(map);
            }
        }
    }
}
