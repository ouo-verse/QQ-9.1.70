package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CryptoOptions {
    private final SFrame sframe;
    private final Srtp srtp;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Builder {
        private boolean enableAes128Sha1_32CryptoCipher;
        private boolean enableEncryptedRtpHeaderExtensions;
        private boolean enableGcmCryptoSuites;
        private boolean requireFrameEncryption;

        public CryptoOptions createCryptoOptions() {
            return new CryptoOptions(this.enableGcmCryptoSuites, this.enableAes128Sha1_32CryptoCipher, this.enableEncryptedRtpHeaderExtensions, this.requireFrameEncryption);
        }

        public Builder setEnableAes128Sha1_32CryptoCipher(boolean z16) {
            this.enableAes128Sha1_32CryptoCipher = z16;
            return this;
        }

        public Builder setEnableEncryptedRtpHeaderExtensions(boolean z16) {
            this.enableEncryptedRtpHeaderExtensions = z16;
            return this;
        }

        public Builder setEnableGcmCryptoSuites(boolean z16) {
            this.enableGcmCryptoSuites = z16;
            return this;
        }

        public Builder setRequireFrameEncryption(boolean z16) {
            this.requireFrameEncryption = z16;
            return this;
        }

        Builder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class SFrame {
        private final boolean requireFrameEncryption;

        @CalledByNative("SFrame")
        public boolean getRequireFrameEncryption() {
            return this.requireFrameEncryption;
        }

        SFrame(boolean z16) {
            this.requireFrameEncryption = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class Srtp {
        private final boolean enableAes128Sha1_32CryptoCipher;
        private final boolean enableEncryptedRtpHeaderExtensions;
        private final boolean enableGcmCryptoSuites;

        @CalledByNative("Srtp")
        public boolean getEnableAes128Sha1_32CryptoCipher() {
            return this.enableAes128Sha1_32CryptoCipher;
        }

        @CalledByNative("Srtp")
        public boolean getEnableEncryptedRtpHeaderExtensions() {
            return this.enableEncryptedRtpHeaderExtensions;
        }

        @CalledByNative("Srtp")
        public boolean getEnableGcmCryptoSuites() {
            return this.enableGcmCryptoSuites;
        }

        Srtp(boolean z16, boolean z17, boolean z18) {
            this.enableGcmCryptoSuites = z16;
            this.enableAes128Sha1_32CryptoCipher = z17;
            this.enableEncryptedRtpHeaderExtensions = z18;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @CalledByNative
    public SFrame getSFrame() {
        return this.sframe;
    }

    @CalledByNative
    public Srtp getSrtp() {
        return this.srtp;
    }

    CryptoOptions(boolean z16, boolean z17, boolean z18, boolean z19) {
        this.srtp = new Srtp(z16, z17, z18);
        this.sframe = new SFrame(z19);
    }
}
