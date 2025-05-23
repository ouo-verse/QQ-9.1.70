package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DevlockBase {
    private static int _seq;
    public static DevlockRst rst = new DevlockRst();
    private int _head_len = 110;
    private int _version = 32;
    public int _msgType = 0;
    public int Role = 505;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static int f422759a = 5;

        /* renamed from: b, reason: collision with root package name */
        public static int f422760b = 7;

        /* renamed from: c, reason: collision with root package name */
        public static int f422761c = 8;
    }

    public byte[] _get_request(long j3, long j16, byte[] bArr) {
        int length = this._head_len + 1 + bArr.length + 1;
        byte[] bArr2 = new byte[length];
        util.int8_to_buf(bArr2, 0, 2);
        util.int16_to_buf(bArr2, 1, length);
        util.int64_to_buf32(bArr2, 3, j3);
        util.int16_to_buf(bArr2, 9, this._msgType);
        util.int64_to_buf32(bArr2, 11, j16);
        int i3 = _seq;
        _seq = i3 + 1;
        util.int32_to_buf(bArr2, 27, i3);
        util.int16_to_buf(bArr2, 39, u.f422951x);
        util.int16_to_buf(bArr2, 43, this._version);
        util.int8_to_buf(bArr2, 45, 0);
        System.arraycopy(bArr, 0, bArr2, 111, bArr.length);
        util.int8_to_buf(bArr2, bArr.length + 111, 3);
        return bArr2;
    }

    public int get_msgType() {
        return this._msgType;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0086 A[LOOP:0: B:10:0x0022->B:33:0x0086, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int parse_rsp(byte[] bArr) {
        d dVar;
        if (bArr != null) {
            int length = bArr.length;
            int i3 = this._head_len;
            if (length >= i3 + 2) {
                int i16 = 2;
                int length2 = (bArr.length - i3) - 2;
                byte[] bArr2 = new byte[length2];
                System.arraycopy(bArr, i3 + 1, bArr2, 0, length2);
                if (2 > length2) {
                    return -1009;
                }
                int buf_to_int16 = util.buf_to_int16(bArr2, 0);
                int i17 = 0;
                for (int i18 = 0; i18 < buf_to_int16; i18++) {
                    byte[] pickup_TLV = pickup_TLV(bArr2, i16);
                    if (pickup_TLV == null) {
                        return -1009;
                    }
                    i16 += pickup_TLV.length;
                    int buf_to_int162 = util.buf_to_int16(pickup_TLV, 0);
                    if (buf_to_int162 != 1) {
                        if (buf_to_int162 != 6) {
                            if (buf_to_int162 != 8) {
                                if (buf_to_int162 != 11) {
                                    if (buf_to_int162 != 14) {
                                        if (buf_to_int162 != 3) {
                                            if (buf_to_int162 != 4) {
                                                if (buf_to_int162 != 18) {
                                                    if (buf_to_int162 != 19) {
                                                        i17 = 0;
                                                        if (i17 == 0) {
                                                            return i17;
                                                        }
                                                    } else {
                                                        dVar = rst.transferInfo;
                                                    }
                                                } else {
                                                    dVar = rst.devGuideInfo;
                                                }
                                            } else {
                                                dVar = rst.mbMobileInfo;
                                            }
                                        } else {
                                            dVar = rst.devSetupInfo;
                                        }
                                    } else {
                                        dVar = rst.mbGuideInfo;
                                    }
                                } else {
                                    dVar = rst.sppKey;
                                }
                            } else {
                                dVar = rst.querySig;
                            }
                        } else {
                            dVar = rst.smsInfo;
                        }
                    } else {
                        dVar = rst.commRsp;
                    }
                    i17 = dVar.set_buf(pickup_TLV, pickup_TLV.length);
                    if (i17 == 0) {
                    }
                }
                if (i17 == 0) {
                    return rst.commRsp.RetCode;
                }
                return i17;
            }
        }
        return -1009;
    }

    public byte[] pickup_TLV(byte[] bArr, int i3) {
        if (bArr == null || bArr.length < i3 + 4) {
            return null;
        }
        int buf_to_int16 = util.buf_to_int16(bArr, i3 + 2) + 4;
        if (bArr.length < i3 + buf_to_int16) {
            return null;
        }
        byte[] bArr2 = new byte[buf_to_int16];
        System.arraycopy(bArr, i3, bArr2, 0, buf_to_int16);
        return bArr2;
    }
}
