package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.im.cs.group_file_common.group_file_common$FileInfo;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetFileInfoRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class i extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        if (i3 != 0) {
            c(false, i3, null);
            return;
        }
        oidb_0x6d8$RspBody oidb_0x6d8_rspbody = new oidb_0x6d8$RspBody();
        try {
            oidb_0x6d8_rspbody.mergeFrom(bArr);
            oidb_0x6d8$GetFileInfoRspBody oidb_0x6d8_getfileinforspbody = oidb_0x6d8_rspbody.file_info_rsp.get();
            if (oidb_0x6d8_getfileinforspbody.int32_ret_code.has()) {
                if (oidb_0x6d8_getfileinforspbody.int32_ret_code.get() == 0) {
                    group_file_common$FileInfo group_file_common_fileinfo = oidb_0x6d8_getfileinforspbody.file_info.get();
                    if (group_file_common_fileinfo != null) {
                        c(true, 0, group_file_common_fileinfo);
                    }
                } else {
                    c(false, oidb_0x6d8_getfileinforspbody.int32_ret_code.get(), null);
                }
            } else if (oidb_0x6d8_getfileinforspbody.file_info.has()) {
                group_file_common$FileInfo group_file_common_fileinfo2 = oidb_0x6d8_getfileinforspbody.file_info.get();
                if (group_file_common_fileinfo2 != null) {
                    c(true, 0, group_file_common_fileinfo2);
                }
            } else {
                c(false, -1, null);
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            c(false, -1, null);
        }
    }

    protected abstract void c(boolean z16, int i3, group_file_common$FileInfo group_file_common_fileinfo);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
