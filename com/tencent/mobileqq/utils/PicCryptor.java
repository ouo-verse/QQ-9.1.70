package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes20.dex */
public class PicCryptor implements HttpNetReq.IFlowDecoder {

    /* renamed from: a, reason: collision with root package name */
    private int f307052a;

    /* renamed from: b, reason: collision with root package name */
    private int f307053b;

    /* renamed from: c, reason: collision with root package name */
    private int f307054c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f307055d;

    /* renamed from: e, reason: collision with root package name */
    private int f307056e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f307057f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f307058g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f307059h;

    /* renamed from: i, reason: collision with root package name */
    private int f307060i;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f307063l;

    /* renamed from: m, reason: collision with root package name */
    public HttpNetReq f307064m;

    /* renamed from: k, reason: collision with root package name */
    private boolean f307062k = true;

    /* renamed from: n, reason: collision with root package name */
    public long f307065n = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f307061j = 0;

    static {
        SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), "piccryptor");
    }

    public PicCryptor(byte[] bArr) {
        this.f307058g = bArr;
    }

    public static String a(byte[] bArr) {
        String hexStr = com.tencent.mobileqq.utils.httputils.PkgTools.toHexStr(bArr);
        if (hexStr != null) {
            return hexStr.toLowerCase();
        }
        throw new IllegalArgumentException("byte2Hex error, byte not null");
    }

    public static byte[] b(String str) throws IllegalArgumentException {
        byte[] hexToBytes = com.tencent.mobileqq.utils.httputils.PkgTools.hexToBytes(str);
        if (hexToBytes != null) {
            return hexToBytes;
        }
        throw new IllegalArgumentException("hex2byte error, hexStr length must even");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
    
        if (r8.f307062k == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        r8.f307062k = false;
        r9 = java.lang.Math.min(20, r0);
        java.lang.System.arraycopy(r1, 0, new byte[r9], 0, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0081, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] c(byte[] bArr) throws Exception {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            int i16 = this.f307060i;
            byte[] bArr3 = this.f307059h;
            if (i16 < bArr3.length) {
                byte b16 = bArr[i3];
                int i17 = i16 + 1;
                this.f307060i = i17;
                bArr2[i3] = (byte) (bArr3[i16] ^ b16);
                if (i17 == this.f307053b) {
                    this.f307061j = 2;
                    int i18 = i3 + 1;
                    int i19 = length - i18;
                    if (i19 == 1 && bArr[i18] == 41) {
                        int i26 = length - 1;
                        byte[] bArr4 = new byte[i26];
                        System.arraycopy(bArr2, 0, bArr4, 0, i26);
                        bArr2 = bArr4;
                        break;
                    }
                    if (i19 != 0) {
                        throw new IllegalArgumentException("Invalid encrypt data end format");
                    }
                }
                i3++;
            } else {
                throw new Exception("decryptKey len overflow! bodyLen:" + this.f307053b + ",encryptLen:" + this.f307059h.length);
            }
        }
    }

    public static void d(boolean z16, String str) {
        if (z16) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    private int e() {
        String replace;
        int indexOf;
        String str = this.f307064m.mReqProperties.get("Range");
        if (TextUtils.isEmpty(str) || (indexOf = (replace = str.replace("bytes=", "")).indexOf("-")) == -1) {
            return 0;
        }
        return Integer.valueOf(replace.substring(0, indexOf)).intValue();
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) throws Exception {
        byte[] decrypt = new Cryptor().decrypt(bArr, bArr2);
        if (decrypt != null && decrypt.length >= 0) {
            return decrypt;
        }
        throw new Exception("Tea Decrypt Error ! ");
    }

    @Override // com.tencent.mobileqq.transfile.HttpNetReq.IFlowDecoder
    public byte[] decode(byte[] bArr) throws Exception {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i3 = this.f307061j;
        byte[] bArr2 = null;
        if (i3 == 0) {
            byte[] bArr3 = this.f307063l;
            if (bArr3 != null) {
                byte[] bArr4 = new byte[bArr3.length + bArr.length];
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
                this.f307063l = bArr4;
            } else {
                this.f307063l = bArr;
            }
            byte[] g16 = g(this.f307063l);
            if (this.f307061j == 1 && g16 != null) {
                bArr2 = c(g16);
            }
        } else if (i3 == 1) {
            bArr2 = c(bArr);
        } else if (bArr.length != 1 || bArr[0] != 41) {
            throw new Exception("pic data len is error!");
        }
        this.f307065n += SystemClock.uptimeMillis() - uptimeMillis;
        return bArr2;
    }

    public byte[] g(byte[] bArr) throws Exception {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        allocate.put(bArr);
        allocate.rewind();
        if (allocate.get() == 40) {
            z16 = true;
        } else {
            z16 = false;
        }
        d(z16, "Invalid encrypt data start format");
        this.f307052a = allocate.getInt();
        int i3 = allocate.getInt();
        this.f307053b = i3;
        if (this.f307052a > 0 && i3 > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        d(z17, "head or body length is not negative");
        if (this.f307052a + 1 + 8 > bArr.length) {
            return null;
        }
        short s16 = allocate.getShort();
        this.f307054c = s16;
        if (s16 == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        d(z18, "magic num not equal 1!");
        byte[] bArr2 = new byte[this.f307052a - 2];
        this.f307055d = bArr2;
        allocate.get(bArr2);
        byte[] f16 = f(this.f307055d, this.f307058g);
        ByteBuffer allocate2 = ByteBuffer.allocate(f16.length);
        allocate2.put(f16);
        allocate2.rewind();
        short s17 = allocate2.getShort();
        this.f307056e = s17;
        if (s17 > 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        d(z19, "seed len is no allow negative");
        try {
            byte[] bArr3 = new byte[this.f307056e];
            this.f307057f = bArr3;
            allocate2.get(bArr3);
            String substring = getISSACSequence(a(this.f307057f), this.f307053b + e()).substring(e() * 2);
            if (substring == null) {
                return null;
            }
            long maxMemory = Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            if (maxMemory >= substring.length() * 3) {
                this.f307059h = b(substring);
                this.f307061j = 1;
                this.f307060i = 0;
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    messageDigest.update(this.f307059h);
                    a(messageDigest.digest());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                int capacity = allocate.capacity() - allocate.position();
                if (capacity <= 0) {
                    return null;
                }
                byte[] bArr4 = new byte[capacity];
                allocate.get(bArr4);
                return bArr4;
            }
            QLog.e("PicCryptor", 1, "checkMemoryForEncrypt : memory is not enough ! remainMemory = " + maxMemory + ", flowKeyHexStr.length() = " + substring.length());
            throw new Exception("applying memory too large!");
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public native String getISSACSequence(String str, int i3);

    @Override // com.tencent.mobileqq.transfile.HttpNetReq.IFlowDecoder
    public boolean isFinish() {
        if (this.f307061j == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.transfile.HttpNetReq.IFlowDecoder
    public void reset() {
        this.f307061j = 0;
        this.f307062k = true;
        this.f307063l = null;
        this.f307060i = 0;
        this.f307065n = 0L;
    }
}
