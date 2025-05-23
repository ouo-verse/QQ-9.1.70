package com.tencent.mobileqq.mini.zxing;

import com.tencent.mobileqq.mini.zxing.oned.MultiFormatOneDReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MultiFormatReader implements Reader {
    private static final Reader[] EMPTY_READER_ARRAY = new Reader[0];
    private Map<DecodeHintType, ?> hints;
    private Reader[] readers;

    private Result decodeInternal(BinaryBitmap binaryBitmap) throws NotFoundException {
        Reader[] readerArr = this.readers;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                try {
                    return reader.decode(binaryBitmap, this.hints);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.tencent.mobileqq.mini.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException {
        setHints(null);
        return decodeInternal(binaryBitmap);
    }

    public Result decodeWithState(BinaryBitmap binaryBitmap) throws NotFoundException {
        if (this.readers == null) {
            setHints(null);
        }
        return decodeInternal(binaryBitmap);
    }

    @Override // com.tencent.mobileqq.mini.zxing.Reader
    public void reset() {
        Reader[] readerArr = this.readers;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                reader.reset();
            }
        }
    }

    public void setHints(Map<DecodeHintType, ?> map) {
        this.hints = map;
        boolean z16 = true;
        boolean z17 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODABAR) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF)) {
                z16 = false;
            }
            if (z16 && !z17) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
            if (z16 && z17) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z17) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
            if (z17) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
        }
        this.readers = (Reader[]) arrayList.toArray(EMPTY_READER_ARRAY);
    }

    @Override // com.tencent.mobileqq.mini.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        setHints(map);
        return decodeInternal(binaryBitmap);
    }
}
