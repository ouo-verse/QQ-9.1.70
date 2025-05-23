package com.tenpay.ndk;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QWssl {
    public static final int GCM_TAG_IV_LEN = 16;
    private KeyInfo keyInfo = new KeyInfo();
    private EncInfo encInfo = new EncInfo();
    private DecInfo decInfo = new DecInfo();

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class DecInfo {
        public String decText;
        public byte[] decTextBytes;
        public int expireTime;
        public int tlsCode;

        public String toString() {
            return String.format("tls_code=%d, dec_text=%s, expire_time=%d", Integer.valueOf(this.tlsCode), this.decText, Integer.valueOf(this.expireTime));
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class EncInfo {
        public byte[] encBytes;
        public String encText;
        public byte[] tagBytes;
        public String tagText;

        public String toString() {
            return String.format("enc_text=%s, tag_text=%s", this.encText, this.tagText);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class KeyInfo {
        public String calcSecret;
        public byte[] calcSecretBytes;
        public long keygenTime;
        public String pubKey;
        public byte[] pubKeyBytes;

        public String toString() {
            return String.format("pub_key=%s, calc_secret=%s", this.pubKey, this.calcSecret);
        }
    }

    public QWssl(Context context) {
        CftSoLoader.loadSo(context);
        QwsslSoLoader.loadSo();
    }

    private native String nAes256EcmDecrypt(String str, String str2, String str3, String str4);

    private native byte[] nAes256EcmDecryptBytes(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    private native EncInfo nAes256EcmEncrypt(EncInfo encInfo, String str, String str2, String str3);

    private native EncInfo nAes256EcmEncryptBytes(EncInfo encInfo, byte[] bArr, byte[] bArr2, byte[] bArr3);

    private native KeyInfo nEcdh(KeyInfo keyInfo);

    private native KeyInfo nEcdhBytes(KeyInfo keyInfo);

    private native DecInfo nQwDecryptBL(DecInfo decInfo, byte[] bArr, int i3, String str);

    public String aes256EcmDecrypt(String str, String str2, String str3, String str4) {
        String nAes256EcmDecrypt;
        synchronized (this) {
            nAes256EcmDecrypt = nAes256EcmDecrypt(str, str2, str3, str4);
        }
        return nAes256EcmDecrypt;
    }

    public byte[] aes256EcmDecryptBytes(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] nAes256EcmDecryptBytes;
        synchronized (this) {
            nAes256EcmDecryptBytes = nAes256EcmDecryptBytes(bArr, bArr2, bArr3, bArr4);
        }
        return nAes256EcmDecryptBytes;
    }

    public EncInfo aes256EcmEncrypt(String str, String str2, String str3) {
        EncInfo nAes256EcmEncrypt;
        synchronized (this) {
            nAes256EcmEncrypt = nAes256EcmEncrypt(this.encInfo, str, str2, str3);
        }
        return nAes256EcmEncrypt;
    }

    public EncInfo aes256EcmEncryptBytes(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        EncInfo nAes256EcmEncryptBytes;
        synchronized (this) {
            nAes256EcmEncryptBytes = nAes256EcmEncryptBytes(this.encInfo, bArr, bArr2, bArr3);
        }
        return nAes256EcmEncryptBytes;
    }

    public native byte[] base64Decode(String str);

    public native String base64Encode(byte[] bArr, int i3);

    public KeyInfo ecdh() {
        KeyInfo nEcdh;
        synchronized (QWssl.class) {
            nEcdh = nEcdh(this.keyInfo);
            nEcdh.keygenTime = System.currentTimeMillis();
        }
        return nEcdh;
    }

    public KeyInfo ecdhBytes() {
        KeyInfo nEcdhBytes;
        synchronized (QWssl.class) {
            nEcdhBytes = nEcdhBytes(this.keyInfo);
            nEcdhBytes.keygenTime = System.currentTimeMillis();
        }
        return nEcdhBytes;
    }

    public DecInfo qwDecryptBL(byte[] bArr, int i3, String str) {
        DecInfo nQwDecryptBL;
        synchronized (this) {
            nQwDecryptBL = nQwDecryptBL(this.decInfo, bArr, i3, str);
        }
        return nQwDecryptBL;
    }
}
