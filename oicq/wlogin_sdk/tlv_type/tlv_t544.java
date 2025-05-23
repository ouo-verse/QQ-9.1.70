package oicq.wlogin_sdk.tlv_type;

import com.tencent.mobileqq.fe.e;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t544 extends tlv_t {
    public tlv_t544() {
        this._cmd = 1348;
    }

    private byte[] errInfo(byte b16) {
        byte[] bArr = new byte[4];
        bArr[2] = b16;
        return makeByte(bArr, 4);
    }

    private byte[] makeByte(byte[] bArr, int i3) {
        fill_head(this._cmd);
        fill_body(bArr, i3);
        set_length();
        return get_buf();
    }

    public static void report(String str, String str2) {
        if (e.b().e()) {
            QSec.getInstance().reportLog("chk_point", str, str2, util.buf_to_string(u.D));
            util.LOGI("544: report: " + str + " num:" + str2);
        }
    }

    public byte[] get_tlv_544(long j3, String str, int i3) {
        util.LOGI("get_tlv_544() called with: userID = [" + j3 + "], moudleID = [" + str + "], _sub_cmd = [" + i3 + "]");
        byte[] bytes = util.SDK_VERSION.getBytes();
        byte[] bArr = new byte[u.D.length + 10 + 2 + bytes.length + 4];
        util.int64_to_buf(bArr, 0, j3);
        util.int16_to_buf(bArr, 8, u.D.length);
        byte[] bArr2 = u.D;
        System.arraycopy(bArr2, 0, bArr, 10, bArr2.length);
        int length = u.D.length + 10;
        util.int16_to_buf(bArr, length, bytes.length);
        int i16 = length + 2;
        System.arraycopy(bytes, 0, bArr, i16, bytes.length);
        util.int32_to_buf(bArr, i16 + bytes.length, i3);
        return new tlv_t544().get_tlv_544(String.valueOf(j3), str, bArr);
    }

    public byte[] get_tlv_544(String str, String str2, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        try {
            if (e.b().i()) {
                bArr2 = QSec.getInstance().getLiteSign(str2, bArr);
                QSec.getInstance().reportLog("sign_point", str2, util.buf_to_string(bArr2), util.buf_to_string(u.D));
                util.LOGI("544: get_tlv_544 [" + str2 + "], sign: " + util.buf_to_string(bArr2) + " salt: " + util.buf_to_string(bArr));
            }
            return makeByte(bArr2, bArr2.length);
        } catch (Exception e16) {
            byte[] errInfo = errInfo((byte) 1);
            e16.printStackTrace();
            return errInfo;
        }
    }
}
