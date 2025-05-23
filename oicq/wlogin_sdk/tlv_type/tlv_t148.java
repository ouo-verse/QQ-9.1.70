package oicq.wlogin_sdk.tlv_type;

import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t148 extends tlv_t {
    public tlv_t148() {
        this._cmd = AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE;
    }

    public byte[] get_tlv_148(byte[] bArr, long j3, long j16, long j17, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        if (bArr == null) {
            bArr4 = new byte[0];
        } else {
            bArr4 = bArr;
        }
        if (bArr2 == null) {
            bArr5 = new byte[0];
        } else {
            bArr5 = bArr2;
        }
        if (bArr3 == null) {
            bArr6 = new byte[0];
        } else {
            bArr6 = bArr3;
        }
        int limit_len = limit_len(bArr4, 32);
        int limit_len2 = limit_len(bArr5, 32);
        int limit_len3 = limit_len(bArr6, 32);
        int i3 = limit_len + 2;
        int i16 = i3 + 4;
        int i17 = i16 + 4;
        int i18 = i17 + 4;
        int i19 = i18 + 2;
        int i26 = i19 + limit_len2;
        int i27 = i26 + 2;
        int i28 = i27 + limit_len3;
        byte[] bArr7 = new byte[i28];
        util.int16_to_buf(bArr7, 0, limit_len);
        System.arraycopy(bArr4, 0, bArr7, 2, limit_len);
        util.int64_to_buf32(bArr7, i3, j3);
        util.int64_to_buf32(bArr7, i16, j16);
        util.int64_to_buf32(bArr7, i17, j17);
        util.int16_to_buf(bArr7, i18, limit_len2);
        System.arraycopy(bArr5, 0, bArr7, i19, limit_len2);
        util.int16_to_buf(bArr7, i26, limit_len3);
        System.arraycopy(bArr6, 0, bArr7, i27, limit_len3);
        fill_head(this._cmd);
        fill_body(bArr7, i28);
        set_length();
        return get_buf();
    }
}
