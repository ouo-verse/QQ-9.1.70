package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$RspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$TransFileRspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class o extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        if (i3 != 0) {
            c(false, i3, null, bundle);
            return;
        }
        oidb_0x6d9$RspBody oidb_0x6d9_rspbody = new oidb_0x6d9$RspBody();
        try {
            oidb_0x6d9_rspbody.mergeFrom(bArr);
            oidb_0x6d9$TransFileRspBody oidb_0x6d9_transfilerspbody = oidb_0x6d9_rspbody.trans_file_rsp.get();
            if (oidb_0x6d9_transfilerspbody.int32_ret_code.has()) {
                c(true, 0, oidb_0x6d9_transfilerspbody, bundle);
            } else {
                c(false, -1, null, bundle);
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            c(false, -1, null, bundle);
        }
    }

    public abstract void c(boolean z16, int i3, oidb_0x6d9$TransFileRspBody oidb_0x6d9_transfilerspbody, Bundle bundle);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
