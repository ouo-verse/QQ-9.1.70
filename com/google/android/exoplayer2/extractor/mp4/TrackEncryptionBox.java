package com.google.android.exoplayer2.extractor.mp4;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TrackEncryptionBox {
    private static final String TAG = "TrackEncryptionBox";
    public final TrackOutput.CryptoData cryptoData;
    public final byte[] defaultInitializationVector;
    public final int initializationVectorSize;
    public final boolean isEncrypted;

    @Nullable
    public final String schemeType;

    public TrackEncryptionBox(boolean z16, @Nullable String str, int i3, byte[] bArr, int i16, int i17, @Nullable byte[] bArr2) {
        boolean z17;
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        Assertions.checkArgument((bArr2 == null) ^ z17);
        this.isEncrypted = z16;
        this.schemeType = str;
        this.initializationVectorSize = i3;
        this.defaultInitializationVector = bArr2;
        this.cryptoData = new TrackOutput.CryptoData(schemeToCryptoMode(str), bArr, i16, i17);
    }

    private static int schemeToCryptoMode(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C.CENC_TYPE_cbc1)) {
                    c16 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals(C.CENC_TYPE_cbcs)) {
                    c16 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals(C.CENC_TYPE_cenc)) {
                    c16 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals(C.CENC_TYPE_cens)) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 1:
                return 2;
            default:
                Log.w(TAG, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
