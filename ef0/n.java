package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.im.cs.group_file_common.group_file_common$FeedsResult;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$FeedsRspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class n extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        group_file_common$FeedsResult group_file_common_feedsresult;
        int i16 = 102;
        int i17 = 0;
        if (i3 != 0) {
            c(false, i3, "", 102, 0, bundle);
            return;
        }
        oidb_0x6d9$RspBody oidb_0x6d9_rspbody = new oidb_0x6d9$RspBody();
        try {
            oidb_0x6d9_rspbody.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException unused) {
            c(false, i3, "", 102, 0, bundle);
        }
        if (!oidb_0x6d9_rspbody.feeds_info_rsp.has()) {
            c(false, i3, "", 102, 0, bundle);
            return;
        }
        oidb_0x6d9$FeedsRspBody oidb_0x6d9_feedsrspbody = oidb_0x6d9_rspbody.feeds_info_rsp.get();
        if (!oidb_0x6d9_feedsrspbody.int32_ret_code.has()) {
            c(false, i3, "", 102, 0, bundle);
            return;
        }
        int i18 = oidb_0x6d9_feedsrspbody.int32_ret_code.get();
        String str = oidb_0x6d9_feedsrspbody.str_client_wording.get();
        if (oidb_0x6d9_feedsrspbody.rpt_feeds_result_list.has() && (group_file_common_feedsresult = oidb_0x6d9_feedsrspbody.rpt_feeds_result_list.get().get(0)) != null) {
            if (group_file_common_feedsresult.uint32_bus_id.has()) {
                i16 = group_file_common_feedsresult.uint32_bus_id.get();
            }
            if (group_file_common_feedsresult.uint32_dead_time.has()) {
                i17 = group_file_common_feedsresult.uint32_dead_time.get();
            }
        }
        c(true, i18, str, i16, i17, bundle);
    }

    public abstract void c(boolean z16, int i3, String str, int i16, int i17, Bundle bundle);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
