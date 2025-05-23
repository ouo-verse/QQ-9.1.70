package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetFileCountRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class e extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        if (i3 == 0 && bArr != null) {
            oidb_0x6d8$RspBody oidb_0x6d8_rspbody = new oidb_0x6d8$RspBody();
            try {
                oidb_0x6d8_rspbody.mergeFrom(bArr);
                if (!oidb_0x6d8_rspbody.group_file_cnt_rsp.has()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFileProtocol", 2, "no group_file_cnt_rsp rsp.");
                    }
                    c(false, false, 0, 0, 0);
                    return;
                } else {
                    oidb_0x6d8$GetFileCountRspBody oidb_0x6d8_getfilecountrspbody = oidb_0x6d8_rspbody.group_file_cnt_rsp.get();
                    c(true, oidb_0x6d8_getfilecountrspbody.bool_file_too_many.get(), oidb_0x6d8_getfilecountrspbody.uint32_all_file_count.get(), oidb_0x6d8_getfilecountrspbody.uint32_limit_count.get(), i3);
                    return;
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                c(false, false, 0, 0, 0);
                return;
            }
        }
        c(false, false, 0, 0, 0);
    }

    public abstract void c(boolean z16, boolean z17, int i3, int i16, int i17);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
