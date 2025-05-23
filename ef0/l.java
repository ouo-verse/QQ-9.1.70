package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$CopyToRspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class l extends ProtoUtils.TroopProtocolObserver {
    public l() {
        super(false);
    }

    protected void b(int i3, byte[] bArr, Bundle bundle) {
        int i16 = 102;
        if (i3 != 0) {
            c(false, i3, 102, null, null, null, bundle);
            return;
        }
        oidb_0x6d9$RspBody oidb_0x6d9_rspbody = new oidb_0x6d9$RspBody();
        try {
            oidb_0x6d9_rspbody.mergeFrom(bArr);
            if (!oidb_0x6d9_rspbody.copy_to_rsp.has()) {
                c(false, i3, 102, null, null, null, bundle);
                return;
            }
            oidb_0x6d9$CopyToRspBody oidb_0x6d9_copytorspbody = oidb_0x6d9_rspbody.copy_to_rsp.get();
            if (!oidb_0x6d9_copytorspbody.int32_ret_code.has()) {
                c(false, i3, 102, null, null, null, bundle);
                return;
            }
            int i17 = oidb_0x6d9_copytorspbody.int32_ret_code.get();
            String str = oidb_0x6d9_copytorspbody.str_client_wording.get();
            String str2 = oidb_0x6d9_copytorspbody.str_ret_msg.get();
            String str3 = oidb_0x6d9_copytorspbody.str_save_file_path.get();
            if (oidb_0x6d9_copytorspbody.uint32_bus_id.has()) {
                i16 = oidb_0x6d9_copytorspbody.uint32_bus_id.get();
            }
            c(true, i17, i16, str3, str2, str, bundle);
        } catch (InvalidProtocolBufferMicroException unused) {
            c(false, i3, 102, null, null, null, bundle);
        }
    }

    public abstract void c(boolean z16, int i3, int i16, String str, String str2, String str3, Bundle bundle);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
