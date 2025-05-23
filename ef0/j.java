package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$MoveFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class j extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        if (i3 != 0) {
            c(false, i3, null);
            return;
        }
        oidb_0x6d6$RspBody oidb_0x6d6_rspbody = new oidb_0x6d6$RspBody();
        try {
            oidb_0x6d6_rspbody.mergeFrom(bArr);
            oidb_0x6d6$MoveFileRspBody oidb_0x6d6_movefilerspbody = oidb_0x6d6_rspbody.move_file_rsp.get();
            if (oidb_0x6d6_movefilerspbody.int32_ret_code.has()) {
                if (oidb_0x6d6_movefilerspbody.int32_ret_code.get() == 0) {
                    c(true, 0, oidb_0x6d6_movefilerspbody.str_parent_folder_id.get());
                } else {
                    c(false, oidb_0x6d6_movefilerspbody.int32_ret_code.get(), null);
                }
            } else {
                c(false, -1, null);
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            c(false, -1, null);
        }
    }

    protected abstract void c(boolean z16, int i3, String str);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
