package oicq.wlogin_sdk.pow;

import android.os.Build;
import android.util.Log;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import oicq.wlogin_sdk.listener.SwitchListener;
import oicq.wlogin_sdk.report.event.EventConstant;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes28.dex */
public class ClientPow {

    /* renamed from: a, reason: collision with root package name */
    public boolean f422797a;

    public ClientPow() {
        this.f422797a = false;
        try {
            System.loadLibrary("pow");
            this.f422797a = true;
        } catch (UnsatisfiedLinkError e16) {
            util.LOGI(e16.toString(), "");
        }
    }

    public final int a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return 1;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            System.arraycopy(digest, 0, bArr2, 0, digest.length);
            return 0;
        } catch (NoSuchAlgorithmException e16) {
            util.LOGI(e16.toString(), "");
            return 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x01c9, code lost:
    
        r13 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] b(byte[] bArr) {
        byte[] bArr2;
        int i3;
        int i16;
        char c16;
        byte[] bArr3 = new byte[0];
        a aVar = new a();
        aVar.f422798a = bArr[0];
        int i17 = 1;
        aVar.f422799b = bArr[1];
        aVar.f422800c = bArr[2];
        aVar.f422801d = bArr[3];
        aVar.f422802e = aVar.a(bArr[4], bArr[5]);
        aVar.f422803f = new int[2];
        int i18 = 6;
        int i19 = 0;
        while (i19 < 2) {
            aVar.f422803f[i19] = bArr[i18];
            i19++;
            i18++;
        }
        int i26 = i18 + 1;
        int i27 = i26 + 1;
        int a16 = aVar.a(bArr[i18], bArr[i26]);
        aVar.f422804g = a16;
        if (a16 > 0) {
            aVar.f422805h = new byte[a16];
            int i28 = 0;
            while (i28 < aVar.f422804g) {
                aVar.f422805h[i28] = bArr[i27];
                i28++;
                i27++;
            }
        }
        int i29 = i27 + 1;
        byte b16 = bArr[i27];
        int i36 = i29 + 1;
        int a17 = aVar.a(b16, bArr[i29]);
        aVar.f422806i = a17;
        if (a17 > 0) {
            aVar.f422807j = new byte[a17];
            int i37 = 0;
            while (i37 < aVar.f422806i) {
                aVar.f422807j[i37] = bArr[i36];
                i37++;
                i36++;
            }
        }
        int i38 = i36 + 1;
        byte b17 = bArr[i36];
        int i39 = i38 + 1;
        int a18 = aVar.a(b17, bArr[i38]);
        aVar.f422808k = a18;
        if (a18 > 0) {
            aVar.f422809l = new byte[a18];
            int i46 = 0;
            while (i46 < aVar.f422808k) {
                aVar.f422809l[i46] = bArr[i39];
                i46++;
                i39++;
            }
        }
        if (aVar.f422801d == 1) {
            int i47 = i39 + 1;
            byte b18 = bArr[i39];
            int i48 = i47 + 1;
            int a19 = aVar.a(b18, bArr[i47]);
            aVar.f422810m = a19;
            if (a19 > 0) {
                aVar.f422811n = new byte[a19];
                int i49 = 0;
                while (i49 < aVar.f422810m) {
                    aVar.f422811n[i49] = bArr[i48];
                    i49++;
                    i48++;
                }
            }
            aVar.f422812o = aVar.a(bArr, i48);
            aVar.f422813p = aVar.a(bArr, i48 + 4);
        }
        long currentTimeMillis = System.currentTimeMillis();
        aVar.f422813p = 0;
        aVar.f422812o = 0;
        int i56 = aVar.f422799b;
        if (i56 != 1) {
            if (i56 != 2) {
                util.LOGI("not support algorithm=" + aVar.f422799b, "");
                return bArr3;
            }
            byte[] bArr4 = new byte[32];
            byte[] bArr5 = aVar.f422805h;
            int length = bArr5.length;
            byte[] bArr6 = new byte[length];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            BigInteger bigInteger = new BigInteger(bArr6);
            long j3 = 0;
            bArr2 = bArr3;
            long j16 = 0;
            while (true) {
                long currentTimeMillis2 = System.currentTimeMillis();
                int i57 = aVar.f422800c;
                if (i57 == i17) {
                    a(bArr6, bArr4);
                    BigInteger bigInteger2 = bigInteger;
                    long currentTimeMillis3 = j3 + (System.currentTimeMillis() - currentTimeMillis2);
                    if (Arrays.equals(bArr4, aVar.f422807j)) {
                        byte[] copyOf = Arrays.copyOf(bArr6, length);
                        aVar.f422811n = copyOf;
                        aVar.f422810m = copyOf.length;
                        util.LOGI("sha_cost:" + currentTimeMillis3 + " bignum_cost:" + j16, "");
                        i16 = aVar.f422813p;
                        break;
                    }
                    aVar.f422813p++;
                    long currentTimeMillis4 = System.currentTimeMillis();
                    byte[] bArr7 = bArr4;
                    BigInteger add = bigInteger2.add(BigInteger.ONE);
                    byte[] byteArray = add.toByteArray();
                    if (byteArray.length > length) {
                        util.LOGI("big number too large len:" + byteArray.length, "");
                        break;
                    }
                    System.arraycopy(byteArray, 0, bArr6, 0, byteArray.length);
                    j16 += System.currentTimeMillis() - currentTimeMillis4;
                    bigInteger = add;
                    bArr4 = bArr7;
                    j3 = currentTimeMillis3;
                    i17 = 1;
                } else if (i57 == 2) {
                    util.LOGI("hash func not support sm3", "");
                } else {
                    util.LOGI("error hash func", "");
                }
            }
            i3 = 0;
        } else {
            bArr2 = bArr3;
            byte[] bArr8 = new byte[32];
            byte[] bArr9 = aVar.f422805h;
            int length2 = bArr9.length;
            byte[] bArr10 = new byte[length2];
            System.arraycopy(bArr9, 0, bArr10, 0, bArr9.length);
            BigInteger bigInteger3 = new BigInteger(bArr10);
            while (true) {
                int i58 = aVar.f422800c;
                if (i58 == 1) {
                    a(bArr10, bArr8);
                    int i59 = aVar.f422802e;
                    if (i59 > 32) {
                        c16 = 1;
                    } else {
                        int i65 = 255;
                        for (int i66 = 0; i65 >= 0 && i66 < i59; i66++) {
                            if ((bArr8[i65 / 8] & (1 << (i65 % 8))) != 0) {
                                c16 = 2;
                                break;
                            }
                            i65--;
                        }
                        c16 = 0;
                    }
                    if (c16 == 0) {
                        byte[] copyOf2 = Arrays.copyOf(bArr10, length2);
                        aVar.f422811n = copyOf2;
                        aVar.f422810m = copyOf2.length;
                        i16 = aVar.f422813p;
                        break;
                    }
                    aVar.f422813p++;
                    bigInteger3 = bigInteger3.add(BigInteger.ONE);
                    byte[] byteArray2 = bigInteger3.toByteArray();
                    if (byteArray2.length > length2) {
                        util.LOGI("big number too large len:" + byteArray2.length, "");
                        break;
                    }
                    System.arraycopy(byteArray2, 0, bArr10, 0, byteArray2.length);
                } else {
                    i3 = 0;
                    if (i58 == 2) {
                        util.LOGI("hash func not support sm3", "");
                    } else {
                        util.LOGI("error hash func", "");
                    }
                    i16 = -1;
                }
            }
            i3 = 0;
        }
        if (i16 < 0) {
            return bArr2;
        }
        aVar.f422812o = (int) (System.currentTimeMillis() - currentTimeMillis);
        aVar.f422801d = 1;
        aVar.f422813p = i16;
        util.LOGI("cnt=" + aVar.f422813p + " cost=" + aVar.f422812o, "");
        ByteBuffer allocate = ByteBuffer.allocate(4096);
        allocate.put((byte) aVar.f422798a);
        allocate.put((byte) aVar.f422799b);
        allocate.put((byte) aVar.f422800c);
        allocate.put((byte) aVar.f422801d);
        allocate.putShort((short) aVar.f422802e);
        int i67 = i3;
        while (true) {
            int[] iArr = aVar.f422803f;
            if (i67 >= iArr.length) {
                break;
            }
            allocate.put((byte) iArr[i67]);
            i67++;
        }
        allocate.putShort((short) aVar.f422804g);
        if (aVar.f422804g > 0) {
            allocate.put(aVar.f422805h);
        }
        allocate.putShort((short) aVar.f422806i);
        if (aVar.f422806i > 0) {
            allocate.put(aVar.f422807j);
        }
        allocate.putShort((short) aVar.f422808k);
        if (aVar.f422808k > 0) {
            allocate.put(aVar.f422809l);
        }
        if (aVar.f422801d == 1) {
            allocate.putShort((short) aVar.f422810m);
            allocate.put(aVar.f422811n);
            allocate.putInt(aVar.f422812o);
            allocate.putInt(aVar.f422813p);
        }
        byte[] array = allocate.array();
        if (array != null && array.length > 0) {
            return array;
        }
        util.LOGI("pow st to buf failed.", "");
        return array;
    }

    public native byte[] nativeGetPow(byte[] bArr);

    public native byte[] nativeGetTestData();

    public byte[] a(byte[] bArr) {
        String str;
        SwitchListener switchListener;
        byte[] bArr2 = new byte[0];
        if (bArr == null || bArr.length == 0) {
            str = util.LOG_TAG_POW + " calPow inBuf is empty";
        } else {
            StringBuffer stringBuffer = new StringBuffer(util.LOG_TAG_POW + "_calPow");
            stringBuffer.append(",inBuf=");
            stringBuffer.append(util.getByteLength(bArr));
            if (this.f422797a && Build.VERSION.SDK_INT > 23 && ((switchListener = WtloginHelper.switchListener) == null || !switchListener.isSwitchOn("wt_pow_switch", false))) {
                try {
                    bArr2 = nativeGetPow(bArr);
                } catch (Exception e16) {
                    util.printThrowable(e16, util.LOG_TAG_POW + "nativeGetPow");
                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_POW_ERROR, "c_error", Log.getStackTraceString(e16)));
                }
                stringBuffer.append(",native=");
                stringBuffer.append(util.getByteLength(bArr2));
            }
            if (bArr2 == null || bArr2.length == 0) {
                try {
                    bArr2 = b(bArr);
                } catch (Exception e17) {
                    util.printThrowable(e17, util.LOG_TAG_POW + "calPowJavaImpl");
                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_POW_ERROR, "java_error", Log.getStackTraceString(e17)));
                }
                stringBuffer.append(",java=");
                stringBuffer.append(util.getByteLength(bArr2));
            }
            str = stringBuffer.toString();
        }
        util.LOGI(str, "");
        return bArr2;
    }
}
