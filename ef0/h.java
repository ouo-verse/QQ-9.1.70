package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetSpaceRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class h extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        if (i3 == 0 && bArr != null) {
            oidb_0x6d8$RspBody oidb_0x6d8_rspbody = new oidb_0x6d8$RspBody();
            try {
                oidb_0x6d8_rspbody.mergeFrom(bArr);
                if (!oidb_0x6d8_rspbody.group_space_rsp.has()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFileProtocol", 2, "no group_space_rsp rsp.");
                    }
                    c(false, 0L, 0L, 0);
                    return;
                } else {
                    oidb_0x6d8$GetSpaceRspBody oidb_0x6d8_getspacerspbody = oidb_0x6d8_rspbody.group_space_rsp.get();
                    c(true, oidb_0x6d8_getspacerspbody.uint64_total_space.get(), oidb_0x6d8_getspacerspbody.uint64_used_space.get(), i3);
                    return;
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                c(false, 0L, 0L, 0);
                return;
            }
        }
        c(false, 0L, 0L, 0);
    }

    public abstract void c(boolean z16, long j3, long j16, int i3);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
