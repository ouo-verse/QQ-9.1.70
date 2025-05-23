package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface TrackOutput {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class CryptoData {
        public final int clearBlocks;
        public final int cryptoMode;
        public final int encryptedBlocks;
        public final byte[] encryptionKey;

        public CryptoData(int i3, byte[] bArr, int i16, int i17) {
            this.cryptoMode = i3;
            this.encryptionKey = bArr;
            this.encryptedBlocks = i16;
            this.clearBlocks = i17;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CryptoData.class != obj.getClass()) {
                return false;
            }
            CryptoData cryptoData = (CryptoData) obj;
            if (this.cryptoMode == cryptoData.cryptoMode && this.encryptedBlocks == cryptoData.encryptedBlocks && this.clearBlocks == cryptoData.clearBlocks && Arrays.equals(this.encryptionKey, cryptoData.encryptionKey)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.cryptoMode * 31) + Arrays.hashCode(this.encryptionKey)) * 31) + this.encryptedBlocks) * 31) + this.clearBlocks;
        }
    }

    void format(Format format);

    int sampleData(ExtractorInput extractorInput, int i3, boolean z16) throws IOException, InterruptedException;

    void sampleData(ParsableByteArray parsableByteArray, int i3);

    void sampleMetadata(long j3, int i3, int i16, int i17, CryptoData cryptoData);
}
