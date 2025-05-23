package com.google.android.exoplayer2.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class CryptoInfo {
    public int clearBlocks;
    public int encryptedBlocks;
    private final MediaCodec.CryptoInfo frameworkCryptoInfo;

    /* renamed from: iv, reason: collision with root package name */
    public byte[] f32940iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    private final PatternHolderV24 patternHolder;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @TargetApi(24)
    /* loaded from: classes2.dex */
    public static final class PatternHolderV24 {
        private final MediaCodec.CryptoInfo frameworkCryptoInfo;
        private final MediaCodec.CryptoInfo.Pattern pattern;

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i3, int i16) {
            this.pattern.set(i3, i16);
            this.frameworkCryptoInfo.setPattern(this.pattern);
        }

        PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.frameworkCryptoInfo = cryptoInfo;
            this.pattern = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo;
        int i3 = Util.SDK_INT;
        byte b16 = 0;
        if (i3 >= 16) {
            cryptoInfo = newFrameworkCryptoInfoV16();
        } else {
            cryptoInfo = null;
        }
        this.frameworkCryptoInfo = cryptoInfo;
        this.patternHolder = i3 >= 24 ? new PatternHolderV24(cryptoInfo) : null;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo newFrameworkCryptoInfoV16() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void updateFrameworkCryptoInfoV16() {
        MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
        cryptoInfo.numSubSamples = this.numSubSamples;
        cryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
        cryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
        cryptoInfo.key = this.key;
        cryptoInfo.iv = this.f32940iv;
        cryptoInfo.mode = this.mode;
        if (Util.SDK_INT >= 24) {
            this.patternHolder.set(this.encryptedBlocks, this.clearBlocks);
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        return this.frameworkCryptoInfo;
    }

    public void set(int i3, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i16, int i17, int i18) {
        this.numSubSamples = i3;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.f32940iv = bArr2;
        this.mode = i16;
        this.encryptedBlocks = i17;
        this.clearBlocks = i18;
        if (Util.SDK_INT >= 16) {
            updateFrameworkCryptoInfoV16();
        }
    }
}
