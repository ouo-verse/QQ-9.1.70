package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7$DeleteFolderRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class d extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        if (i3 != 0) {
            c(false, i3);
            return;
        }
        oidb_0x6d7$RspBody oidb_0x6d7_rspbody = new oidb_0x6d7$RspBody();
        try {
            oidb_0x6d7_rspbody.mergeFrom(bArr);
            oidb_0x6d7$DeleteFolderRspBody oidb_0x6d7_deletefolderrspbody = oidb_0x6d7_rspbody.delete_folder_rsp.get();
            if (oidb_0x6d7_deletefolderrspbody.int32_ret_code.has()) {
                if (oidb_0x6d7_deletefolderrspbody.int32_ret_code.get() == 0) {
                    c(true, 0);
                } else {
                    c(false, oidb_0x6d7_deletefolderrspbody.int32_ret_code.get());
                }
            } else {
                c(false, -1);
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            c(false, -1);
        }
    }

    protected abstract void c(boolean z16, int i3);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
