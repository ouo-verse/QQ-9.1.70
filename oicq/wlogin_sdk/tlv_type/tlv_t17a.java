package oicq.wlogin_sdk.tlv_type;

import com.tencent.commonsdk.util.notification.NotificationUtil;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t17a extends tlv_t {
    public tlv_t17a() {
        this._cmd = NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN;
    }

    public byte[] get_tlv_17a(long j3) {
        byte[] bArr = new byte[4];
        util.int64_to_buf32(bArr, 0, j3);
        fill_head(this._cmd);
        fill_body(bArr, 4);
        set_length();
        return get_buf();
    }
}
