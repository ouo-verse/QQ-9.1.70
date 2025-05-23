package oicq.wlogin_sdk.tlv_type;

import android.content.Context;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t52d extends tlv_t {
    public tlv_t52d() {
        this._cmd = 1325;
    }

    public byte[] get_tlv_52d(Context context) {
        String str;
        byte[] bArr = util.get_android_dev_info(context);
        if (bArr != null && bArr.length > 0) {
            set_data(bArr, bArr.length);
            str = "get_tlv_52d success " + bArr.length;
        } else {
            str = "get_tlv_52d failed";
        }
        util.LOGI(str, "");
        return get_buf();
    }
}
