package oicq.wlogin_sdk.code2d;

import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {
    public static int _seq = 0;
    public static d _status = new d();
    public static int _version = 50;
    public static final int reservedBufTypeClientType = 1;
    public static final int reservedBufTypeUin = 2;
    public int _role = 114;
    public int _cmd = 0;
    public int _sub_cmd = 0;
    public int _head_len = 43;
    public int stxLen = 1;
    public int ptDBPkgHeadLen = 28;
    public int ptCldPkgHeadLen = 14;

    public int fill_staff(byte[] bArr, byte[] bArr2, int i3) {
        util.int16_to_buf(bArr, i3, bArr2.length);
        int i16 = i3 + 2;
        System.arraycopy(bArr2, 0, bArr, i16, bArr2.length);
        return i16 + bArr2.length;
    }

    public byte[] getAppInfo(long j3, long j16) {
        byte[] bArr = new byte[u.G.length + 2 + 2 + u.I.length + 2 + u.J.length + 28];
        util.int64_to_buf32(bArr, 0, 22L);
        util.int64_to_buf32(bArr, 4, j3);
        util.int64_to_buf32(bArr, 8, j16);
        byte[] bArr2 = u.D;
        System.arraycopy(bArr2, 0, bArr, 12, bArr2.length);
        fill_staff(bArr, u.J, fill_staff(bArr, u.I, fill_staff(bArr, u.G, u.D.length + 12)));
        return bArr;
    }

    public int get_cmd() {
        return this._cmd;
    }

    public byte[] get_request(long j3, boolean z16, byte[] bArr) {
        int length = this._head_len + bArr.length + 1;
        byte[] bArr2 = new byte[length];
        util.int8_to_buf(bArr2, 0, 2);
        util.int16_to_buf(bArr2, 1, length);
        util.int16_to_buf(bArr2, 3, this._cmd);
        util.int8_to_buf(bArr2, 26, 3);
        if (z16) {
            util.int16_to_buf(bArr2, 27, 0);
        } else {
            util.int16_to_buf(bArr2, 27, 1);
        }
        util.int16_to_buf(bArr2, 29, _version);
        int i3 = _seq;
        _seq = i3 + 1;
        util.int32_to_buf(bArr2, 31, i3);
        util.int64_to_buf(bArr2, 35, j3);
        System.arraycopy(bArr, 0, bArr2, 43, bArr.length);
        util.int8_to_buf(bArr2, bArr.length + 43, 3);
        return bArr2;
    }

    public byte[] get_response(byte[] bArr, int i3) {
        int length = bArr.length;
        int i16 = this._head_len;
        if (length <= i16) {
            return null;
        }
        int length2 = bArr.length - i16;
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, i16, bArr2, 0, length2);
        return bArr2;
    }
}
