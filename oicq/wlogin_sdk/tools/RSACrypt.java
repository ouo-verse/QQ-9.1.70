package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.util.Log;
import java.security.KeyPair;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RSACrypt {
    public static final String DEFAULT_PRIV_KEY = "3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9";
    public static final String DEFAULT_PUB_KEY = "30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001";
    private Context _context;
    private byte[] _pub_key = new byte[0];
    private byte[] _priv_key = new byte[0];

    public RSACrypt(Context context) {
        this._context = context;
        try {
            util.loadLibrary("wtecdh", context);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private native byte[] decryptdata(byte[] bArr, byte[] bArr2);

    private native byte[] encryptdata(byte[] bArr, byte[] bArr2);

    private native int genrsakey();

    public byte[] DecryptData(byte[] bArr, byte[] bArr2) {
        int length;
        byte[] bArr3 = null;
        if (bArr2 == null) {
            util.LOGI("DecryptData data is null", "");
            return null;
        }
        if (bArr == null && ((bArr = util.get_rsa_privkey(this._context)) == null || bArr.length == 0)) {
            bArr = util.string_to_buf(DEFAULT_PRIV_KEY);
        }
        try {
            bArr3 = decryptdata(bArr, bArr2);
            if (bArr3 == null || bArr3.length == 0) {
                bArr3 = decryptdata(util.string_to_buf(DEFAULT_PRIV_KEY), bArr2);
            }
        } catch (UnsatisfiedLinkError e16) {
            util.LOGI("DecryptData UnsatisfiedLinkError " + Log.getStackTraceString(e16), "");
        }
        if (bArr3 == null) {
            try {
                bArr3 = util.RSADecrypt(bArr2, util.RSAPrivKeyFromJNI(bArr));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("dedata first:");
                int i3 = 0;
                if (bArr3 == null) {
                    length = 0;
                } else {
                    length = bArr3.length;
                }
                sb5.append(length);
                util.LOGI(sb5.toString(), "");
                if (bArr3 == null || bArr3.length == 0) {
                    bArr3 = util.RSADecrypt(bArr2, util.RSAPrivKeyFromJNI(util.string_to_buf(DEFAULT_PRIV_KEY)));
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("dedata second:");
                    if (bArr3 != null) {
                        i3 = bArr3.length;
                    }
                    sb6.append(i3);
                    util.LOGI(sb6.toString(), "");
                }
            } catch (Exception e17) {
                util.LOGI("DecryptData java decrypt exception " + e17.toString(), "");
            }
        }
        return bArr3;
    }

    public byte[] EncryptData(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr == null || bArr2 == null) {
            return null;
        }
        try {
            bArr3 = encryptdata(bArr, bArr2);
        } catch (UnsatisfiedLinkError unused) {
        }
        if (bArr3 == null) {
            return util.RSAEncrypt(bArr2, util.RSAPubKeyFromJNI(bArr));
        }
        return bArr3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
    
        if (r2 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        monitor-enter(oicq.wlogin_sdk.tools.RSACrypt.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008b, code lost:
    
        r0 = oicq.wlogin_sdk.tools.util.get_rsa_pubkey(r6._context);
        r2 = oicq.wlogin_sdk.tools.util.get_rsa_privkey(r6._context);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
    
        if (r0 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009a, code lost:
    
        if (r0.length <= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009c, code lost:
    
        if (r2 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009f, code lost:
    
        if (r2.length <= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
    
        r6._pub_key = (byte[]) r0.clone();
        r6._priv_key = (byte[]) r2.clone();
        r0 = "rsa has saved";
        r2 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b7, code lost:
    
        oicq.wlogin_sdk.tools.util.LOGI(r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d9, code lost:
    
        monitor-exit(oicq.wlogin_sdk.tools.RSACrypt.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
    
        oicq.wlogin_sdk.tools.util.LOGI("saversa begin", "");
        oicq.wlogin_sdk.tools.util.save_rsa_pubkey(r6._context, r6._pub_key);
        oicq.wlogin_sdk.tools.util.save_rsa_privkey(r6._context, r6._priv_key);
        r0 = "saversa end";
        r2 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0171 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int GenRSAKey() {
        int i3;
        int i16;
        String str;
        String str2;
        String str3;
        String str4;
        int genrsakey;
        byte[] bArr = util.get_rsa_pubkey(this._context);
        byte[] bArr2 = util.get_rsa_privkey(this._context);
        int i17 = 0;
        if (bArr != null && bArr.length > 0 && bArr2 != null && bArr2.length > 0) {
            this._pub_key = (byte[]) bArr.clone();
            this._priv_key = (byte[]) bArr2.clone();
            return 0;
        }
        try {
            synchronized (RSACrypt.class) {
                try {
                    byte[] bArr3 = util.get_rsa_pubkey(this._context);
                    byte[] bArr4 = util.get_rsa_privkey(this._context);
                    if (bArr3 != null && bArr3.length > 0 && bArr4 != null && bArr4.length > 0) {
                        this._pub_key = (byte[]) bArr3.clone();
                        this._priv_key = (byte[]) bArr4.clone();
                        util.LOGI("rsa has generated", "");
                        i17 = 1;
                        genrsakey = 0;
                    } else {
                        util.LOGI("rsa begin", "");
                        genrsakey = genrsakey();
                        try {
                            util.LOGI("rsa end " + genrsakey, "");
                        } catch (Throwable th5) {
                            int i18 = i17;
                            i17 = genrsakey;
                            th = th5;
                            i16 = i18;
                            while (true) {
                                try {
                                    try {
                                        break;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        i3 = i17;
                                        i17 = i16;
                                        if (i17 == 0) {
                                            return i3;
                                        }
                                        synchronized (RSACrypt.class) {
                                            byte[] bArr5 = util.get_rsa_pubkey(this._context);
                                            byte[] bArr6 = util.get_rsa_privkey(this._context);
                                            if (bArr5 != null && bArr5.length > 0 && bArr6 != null && bArr6.length > 0) {
                                                this._pub_key = (byte[]) bArr5.clone();
                                                this._priv_key = (byte[]) bArr6.clone();
                                                str = "rsa has saved";
                                                str2 = "";
                                            } else {
                                                util.LOGI("saversa begin", "");
                                                util.save_rsa_pubkey(this._context, this._pub_key);
                                                util.save_rsa_privkey(this._context, this._priv_key);
                                                str = "saversa end";
                                                str2 = "";
                                            }
                                            util.LOGI(str, str2);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    i16 = 0;
                }
            }
        } catch (UnsatisfiedLinkError unused) {
            i16 = 0;
        } catch (Throwable th9) {
            th = th9;
            i3 = 0;
            if (i17 == 0) {
            }
        }
        try {
            break;
            throw th;
        } catch (UnsatisfiedLinkError unused2) {
            KeyPair generateRSAKeyPair = util.generateRSAKeyPair();
            if (generateRSAKeyPair != null) {
                this._pub_key = util.RSAPubKeyFromJava(generateRSAKeyPair.getPublic().getEncoded());
                this._priv_key = util.RSAPrivKeyFromJava(generateRSAKeyPair.getPrivate().getEncoded());
            }
            if (i16 != 0) {
                return i17;
            }
            synchronized (RSACrypt.class) {
                byte[] bArr7 = util.get_rsa_pubkey(this._context);
                byte[] bArr8 = util.get_rsa_privkey(this._context);
                if (bArr7 != null && bArr7.length > 0 && bArr8 != null && bArr8.length > 0) {
                    this._pub_key = (byte[]) bArr7.clone();
                    this._priv_key = (byte[]) bArr8.clone();
                    str3 = "rsa has saved";
                    str4 = "";
                } else {
                    util.LOGI("saversa begin", "");
                    util.save_rsa_pubkey(this._context, this._pub_key);
                    util.save_rsa_privkey(this._context, this._priv_key);
                    str3 = "saversa end";
                    str4 = "";
                }
                util.LOGI(str3, str4);
                return i17;
            }
        }
    }

    public byte[] get_priv_key() {
        return this._priv_key;
    }

    public byte[] get_pub_key() {
        return this._pub_key;
    }

    public void set_priv_key(byte[] bArr) {
        this._priv_key = bArr;
    }

    public void set_pub_key(byte[] bArr) {
        this._pub_key = bArr;
    }
}
