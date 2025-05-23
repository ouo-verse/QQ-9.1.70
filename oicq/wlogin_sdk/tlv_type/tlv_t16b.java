package oicq.wlogin_sdk.tlv_type;

import java.util.List;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t16b extends tlv_t {
    public tlv_t16b() {
        this._cmd = 363;
    }

    public byte[] get_tlv_16b(List<String> list) {
        int i3;
        int i16;
        if (list != null) {
            i3 = list.size();
            i16 = 0;
            for (int i17 = 0; i17 < i3; i17++) {
                i16 += 2;
                if (list.get(i17) != null) {
                    i16 += list.get(i17).length();
                }
            }
        } else {
            i3 = 0;
            i16 = 0;
        }
        int i18 = 2;
        int i19 = i16 + 2;
        byte[] bArr = new byte[i19];
        util.int16_to_buf(bArr, 0, i3);
        if (list != null) {
            for (int i26 = 0; i26 < i3; i26++) {
                if (list.get(i26) != null) {
                    byte[] bytes = list.get(i26).getBytes();
                    util.int16_to_buf(bArr, i18, bytes.length);
                    int i27 = i18 + 2;
                    System.arraycopy(bytes, 0, bArr, i27, bytes.length);
                    i18 = i27 + bytes.length;
                } else {
                    util.int16_to_buf(bArr, i18, 0);
                    i18 += 2;
                }
            }
        }
        fill_head(this._cmd);
        fill_body(bArr, i19);
        set_length();
        return get_buf();
    }
}
