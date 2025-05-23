package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$DeleteFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class c extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        if (i3 != 0) {
            c(false, i3, bundle, "", HardCodeUtil.qqStr(R.string.ufw));
            return;
        }
        oidb_0x6d6$RspBody oidb_0x6d6_rspbody = new oidb_0x6d6$RspBody();
        try {
            oidb_0x6d6_rspbody.mergeFrom(bArr);
            oidb_0x6d6$DeleteFileRspBody oidb_0x6d6_deletefilerspbody = oidb_0x6d6_rspbody.delete_file_rsp.get();
            if (oidb_0x6d6_deletefilerspbody.int32_ret_code.has()) {
                if (oidb_0x6d6_deletefilerspbody.int32_ret_code.get() == 0) {
                    c(true, 0, bundle, oidb_0x6d6_deletefilerspbody.str_ret_msg.get(), oidb_0x6d6_deletefilerspbody.str_client_wording.get());
                } else {
                    c(false, oidb_0x6d6_deletefilerspbody.int32_ret_code.get(), bundle, oidb_0x6d6_deletefilerspbody.str_ret_msg.get(), oidb_0x6d6_deletefilerspbody.str_client_wording.get());
                }
            } else {
                c(false, -1, bundle, "", HardCodeUtil.qqStr(R.string.f172816ug0));
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            c(false, -1, bundle, "", HardCodeUtil.qqStr(R.string.ufs));
        }
    }

    protected abstract void c(boolean z16, int i3, Bundle bundle, String str, String str2);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
