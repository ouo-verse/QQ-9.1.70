package oicq.wlogin_sdk.request;

import java.net.Socket;
import java.security.SecureRandom;
import oicq.wlogin_sdk.request.oicq_request;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d0 extends oicq_request {

    /* renamed from: v, reason: collision with root package name */
    public int f422882v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f422883w = 5;

    public d0(u uVar) {
        this.f422914j = 2066;
        this.f422915k = 1;
        this.f422916l = "wtlogin.trans_emp";
        this.f422917m = uVar;
        if (uVar.f422964k != 0) {
            uVar.f422964k = 1;
        }
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public void a(Socket socket) {
        this.f422917m.f422971r = socket;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int b(boolean z16) {
        return 8080;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int c(byte[] bArr, int i3, int i16) {
        if (i16 < this.f422883w) {
            return -1009;
        }
        int i17 = bArr[i3] & 255;
        a((ErrMsg) null);
        util.LOGD(d0.class.getName(), "type=" + i17);
        return i17;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public Socket e() {
        String str;
        if (this.f422917m.f422971r != null) {
            str = "_transport_sk" + this.f422917m.f422971r.toString();
        } else {
            str = "_transport_sk null";
        }
        util.LOGD("_transport_sk", str);
        return this.f422917m.f422971r;
    }

    public byte[] a(byte[] bArr, byte[] bArr2, long j3, long j16, int i3) {
        int i16;
        if (bArr2 == null) {
            bArr2 = new byte[0];
            i16 = i3 == 0 ? 0 : 3;
        } else {
            i16 = i3 == 0 ? 1 : 2;
        }
        byte[] bArr3 = new byte[0];
        byte[] bArr4 = this.f422917m.f422968o;
        if (bArr4 != null && bArr4.length > 0) {
            byte[] bArr5 = new tlv_t172().get_tlv_172(this.f422917m.f422968o);
            byte[] bArr6 = new byte[bArr5.length + 2];
            util.int16_to_buf(bArr6, 0, 1);
            System.arraycopy(bArr5, 0, bArr6, 2, bArr5.length);
            bArr3 = bArr6;
        }
        int length = bArr2.length + 13 + 1 + bArr3.length;
        this.f422882v = length;
        byte[] bArr7 = new byte[bArr.length + length];
        util.int8_to_buf(bArr7, 0, i16);
        util.int16_to_buf(bArr7, 1, bArr.length);
        util.int64_to_buf32(bArr7, 3, j3);
        util.int64_to_buf32(bArr7, 7, j16);
        util.int16_to_buf(bArr7, 11, bArr2.length);
        System.arraycopy(bArr2, 0, bArr7, 13, bArr2.length);
        int length2 = bArr2.length + 13;
        util.int8_to_buf(bArr7, length2, bArr3.length);
        int i17 = length2 + 1;
        System.arraycopy(bArr3, 0, bArr7, i17, bArr3.length);
        System.arraycopy(bArr, 0, bArr7, i17 + bArr3.length, bArr.length);
        return c(bArr7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        if (r0 < 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
    
        oicq.wlogin_sdk.tools.util.LOGI("use kc decrypt_body failed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0044, code lost:
    
        if (r0 < 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(TransReqContext transReqContext) {
        int i3;
        int i16 = this.f422907c;
        if (i16 <= 17) {
            return -1009;
        }
        int i17 = (i16 - 15) - 2;
        this.f422908d = i17;
        oicq_request.EncryptionMethod encryptionMethod = transReqContext.requestEm;
        if (encryptionMethod == oicq_request.EncryptionMethod.EM_ECDH) {
            u uVar = this.f422917m;
            if (uVar.f422964k == 0) {
                i3 = a(this.f422909e, 16, i17, uVar.f422966m);
                if (i3 < 0) {
                    util.LOGI("use ecdh decrypt_body failed");
                    i3 = a(this.f422909e, 16, this.f422908d, this.f422917m.f422955b);
                }
            } else {
                i3 = a(this.f422909e, 16, i17, uVar.f422955b);
            }
        } else if (encryptionMethod == oicq_request.EncryptionMethod.EM_ST) {
            i3 = a(this.f422909e, 16, i17, transReqContext.wtSessionTicketKey);
            if (i3 < 0) {
                u.f422936m0.attr_api(2494911);
                util.LOGI("use session key decrypt_body failed", "");
                i3 = -1025;
            }
        } else {
            util.LOGI("unknown encryption method " + transReqContext.requestEm, "");
            i3 = -1024;
        }
        if (i3 < 0) {
            return i3;
        }
        byte[] bArr = this.f422909e;
        int i18 = this.f422908d;
        if (i18 < this.f422883w) {
            return -1009;
        }
        int i19 = bArr[16] & 255;
        a((ErrMsg) null);
        util.LOGD(d0.class.getName(), "type=" + i19);
        if (i19 == 0) {
            int i26 = this.f422883w;
            int i27 = i26 + 16;
            int i28 = i18 - i26;
            byte[] bArr2 = new byte[i28];
            System.arraycopy(bArr, i27, bArr2, 0, i28);
            transReqContext.set_body(bArr2);
            return i19;
        }
        if (i19 != 180) {
            return i19;
        }
        int i29 = this.f422883w + 2 + 16;
        tlv_t172 tlv_t172Var = new tlv_t172();
        int i36 = tlv_t172Var.get_tlv(bArr, i29, (this.f422907c - i29) - 1);
        if (i36 <= 0) {
            return i36;
        }
        u uVar2 = this.f422917m;
        uVar2.f422964k = 2;
        uVar2.f422968o = tlv_t172Var.get_data();
        util.LOGI("request_transport get rollback sig");
        return i19;
    }

    public synchronized int a(long j3, TransReqContext transReqContext, byte[] bArr, byte[] bArr2, long j16, long j17, WUserSigInfo wUserSigInfo) {
        int i3;
        int i16;
        int i17;
        byte[] bArr3;
        byte[] bArr4;
        if (util.roleCmdMap.containsKey(Long.valueOf(j17))) {
            this.f422916l = util.roleCmdMap.get(Long.valueOf(j17));
        }
        SecureRandom secureRandom = u.f422943t;
        int i18 = 0;
        int i19 = 0;
        i3 = 0;
        while (true) {
            byte[] bArr5 = transReqContext._body;
            long currentTimeMillis = (System.currentTimeMillis() / 1000) + u.f422926c0;
            if (bArr5 == null) {
                bArr5 = new byte[i18];
            }
            int length = bArr5.length + 4;
            byte[] bArr6 = new byte[length];
            util.int64_to_buf32(bArr6, i18, currentTimeMillis);
            System.arraycopy(bArr5, i18, bArr6, 4, bArr5.length);
            if (bArr != null && bArr.length > 0) {
                bArr6 = cryptor.encrypt(bArr6, i18, length, bArr2);
            }
            if (bArr6 != null && bArr6.length > 0) {
                if (oicq_request.EncryptionMethod.EM_ST == transReqContext.requestEm && ((bArr3 = transReqContext.wtSessionTicketKey) == null || bArr3.length == 0 || (bArr4 = transReqContext.wtSessionTicket) == null || bArr4.length == 0)) {
                    transReqContext.requestEm = oicq_request.EncryptionMethod.EM_ECDH;
                    u.f422936m0.attr_api(2413503);
                    util.LOGI("using wt st encrypt body but no st key", "" + j3);
                }
                int i26 = (bArr == null || bArr.length <= 0) ? i18 : 1;
                byte[] bArr7 = bArr == null ? new byte[i18] : bArr;
                int i27 = 1 == i26 ? 1 : i18;
                byte[] bArr8 = new byte[i18];
                byte[] bArr9 = this.f422917m.f422968o;
                if (bArr9 != null && bArr9.length > 0) {
                    byte[] bArr10 = new tlv_t172().get_tlv_172(this.f422917m.f422968o);
                    byte[] bArr11 = new byte[bArr10.length + 2];
                    util.int16_to_buf(bArr11, i18, 1);
                    System.arraycopy(bArr10, i18, bArr11, 2, bArr10.length);
                    bArr8 = bArr11;
                }
                int length2 = bArr7.length + 13 + 1 + bArr8.length;
                this.f422882v = length2;
                byte[] bArr12 = new byte[bArr6.length + length2];
                util.int8_to_buf(bArr12, i18, i27);
                util.int16_to_buf(bArr12, 1, bArr6.length);
                i17 = i19;
                util.int64_to_buf32(bArr12, 3, j16);
                byte[] bArr13 = bArr6;
                util.int64_to_buf32(bArr12, 7, j17);
                util.int16_to_buf(bArr12, 11, bArr7.length);
                System.arraycopy(bArr7, 0, bArr12, 13, bArr7.length);
                int length3 = bArr7.length + 13;
                util.int8_to_buf(bArr12, length3, bArr8.length);
                int i28 = length3 + 1;
                System.arraycopy(bArr8, 0, bArr12, i28, bArr8.length);
                System.arraycopy(bArr13, 0, bArr12, i28 + bArr8.length, bArr13.length);
                a(j3, a(bArr12, transReqContext.requestEm, transReqContext.wtSessionTicket, transReqContext.wtSessionTicketKey), transReqContext.requestEm);
                i3 = a(String.valueOf(j3), false, wUserSigInfo);
                if (i3 != 0) {
                    break;
                }
                i3 = a(transReqContext);
                if (i3 != 0 || bArr == null || bArr.length <= 0) {
                    i16 = 0;
                } else {
                    byte[] bArr14 = transReqContext.get_body();
                    i16 = 0;
                    transReqContext.set_body(cryptor.decrypt(bArr14, 0, bArr14.length, bArr2));
                }
                if (i3 != 180) {
                    break;
                }
            } else {
                i16 = i18;
                i17 = i19;
            }
            int i29 = i17 + 1;
            if (i17 >= 1) {
                break;
            }
            i18 = i16;
            i19 = i29;
        }
        util.LOGI("request_transport rsp: ret=" + i3);
        return i3;
    }

    public synchronized int a(long j3, TransReqContext transReqContext, byte[] bArr, byte[] bArr2, byte[] bArr3, long j16, long j17, WUserSigInfo wUserSigInfo) {
        byte[] bArr4;
        byte[] encrypt;
        byte[] bArr5;
        int i3;
        int i16 = u.f422953z;
        long length = transReqContext._body.length;
        int i17 = this.f422922r;
        this.f422922r = i17 + 1;
        long j18 = i17;
        byte[] bytes = String.valueOf(j3).getBytes();
        byte[] bytes2 = new String("wtlogin_conn_trans").getBytes();
        byte[] bArr6 = new byte[8];
        byte[] bArr7 = u.D;
        byte[] bArr8 = bArr3 == null ? new byte[0] : bArr3;
        int length2 = bytes.length + 16 + 4 + 16 + 4 + bArr8.length + 4 + bytes2.length + 4 + 8 + 1 + 4 + 4 + bArr7.length + 4;
        byte[] bArr9 = new byte[length2];
        util.int64_to_buf32(bArr9, 0, length2 + length);
        util.int64_to_buf32(bArr9, 4, (length2 - 4) - 4);
        util.int64_to_buf32(bArr9, 8, j18);
        util.int32_to_buf(bArr9, 12, bytes.length + 4);
        System.arraycopy(bytes, 0, bArr9, 16, bytes.length);
        int length3 = bytes.length + 16;
        util.int64_to_buf32(bArr9, length3, j16);
        int i18 = length3 + 4;
        util.int64_to_buf32(bArr9, i18, j16);
        int i19 = i18 + 16;
        util.int32_to_buf(bArr9, i19, bArr8.length + 4);
        int i26 = i19 + 4;
        System.arraycopy(bArr8, 0, bArr9, i26, bArr8.length);
        int length4 = i26 + bArr8.length;
        util.int32_to_buf(bArr9, length4, bytes2.length + 4);
        int i27 = length4 + 4;
        System.arraycopy(bytes2, 0, bArr9, i27, bytes2.length);
        int length5 = i27 + bytes2.length;
        util.int32_to_buf(bArr9, length5, 12);
        int i28 = length5 + 4;
        System.arraycopy(bArr6, 0, bArr9, i28, 8);
        int i29 = i28 + 8;
        util.int8_to_buf(bArr9, i29, 0);
        int i36 = i29 + 1;
        util.int64_to_buf32(bArr9, i36, 0L);
        int i37 = i36 + 4;
        util.int32_to_buf(bArr9, i37, bArr7.length + 4);
        int i38 = i37 + 4;
        System.arraycopy(bArr7, 0, bArr9, i38, bArr7.length);
        util.int64_to_buf32(bArr9, i38 + bArr7.length, length + 4);
        byte[] bArr10 = transReqContext._body;
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + u.f422926c0;
        if (bArr10 == null) {
            encrypt = new byte[0];
            bArr4 = bArr2;
        } else if (bArr == null) {
            int i39 = length2 + 4;
            byte[] bArr11 = new byte[bArr10.length + i39];
            util.int64_to_buf32(bArr11, 0, currentTimeMillis);
            System.arraycopy(bArr9, 0, bArr11, 4, length2);
            System.arraycopy(bArr10, 0, bArr11, i39, bArr10.length);
            bArr4 = bArr2;
            bArr5 = bArr11;
            if (bArr5 != null || bArr5.length <= 0) {
                i3 = 0;
            } else {
                a(8001, this.f422914j, this.f422910f, j3, 0, 2, i16, 0, a(bArr5, bArr, j16, j17, 1));
                int a16 = a(String.valueOf(j3), true, wUserSigInfo);
                if (a16 == 0 && (a16 = a(transReqContext)) == 0 && bArr != null) {
                    byte[] bArr12 = transReqContext.get_body();
                    transReqContext.set_body(cryptor.decrypt(bArr12, 0, bArr12.length, bArr4));
                }
                i3 = a16;
            }
        } else {
            int i46 = length2 + 4;
            int length6 = bArr10.length + i46;
            byte[] bArr13 = new byte[length6];
            util.int64_to_buf32(bArr13, 0, currentTimeMillis);
            System.arraycopy(bArr9, 0, bArr13, 4, length2);
            System.arraycopy(bArr10, 0, bArr13, i46, bArr10.length);
            bArr4 = bArr2;
            encrypt = cryptor.encrypt(bArr13, 0, length6, bArr4);
        }
        bArr5 = encrypt;
        if (bArr5 != null) {
        }
        i3 = 0;
        return i3;
    }
}
