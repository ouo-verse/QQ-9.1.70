package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$RspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$UploadFileRspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class p extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        if (i3 != 0) {
            c(false, i3, null, bundle);
            return;
        }
        oidb_0x6d6$RspBody oidb_0x6d6_rspbody = new oidb_0x6d6$RspBody();
        try {
            oidb_0x6d6_rspbody.mergeFrom(bArr);
            oidb_0x6d6$UploadFileRspBody oidb_0x6d6_uploadfilerspbody = oidb_0x6d6_rspbody.upload_file_rsp.get();
            if (oidb_0x6d6_uploadfilerspbody.int32_ret_code.has()) {
                c(true, 0, oidb_0x6d6_uploadfilerspbody, bundle);
            } else {
                c(false, -1, null, bundle);
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            c(false, -1, null, bundle);
        }
    }

    public abstract void c(boolean z16, int i3, oidb_0x6d6$UploadFileRspBody oidb_0x6d6_uploadfilerspbody, Bundle bundle);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
