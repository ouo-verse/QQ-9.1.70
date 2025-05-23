package fw1;

import com.tencent.qphone.base.util.QLog;
import tencent.im.group_pro_proto.synclogic.synclogic$MultiChannelMsgRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends a {
    @Override // fw1.a
    public void a(b bVar, Object... objArr) {
        boolean z16;
        if (objArr != null && objArr.length >= 1 && objArr[0] != null) {
            synclogic$MultiChannelMsgRsp synclogic_multichannelmsgrsp = new synclogic$MultiChannelMsgRsp();
            try {
                synclogic_multichannelmsgrsp.mergeFrom((byte[]) objArr[0]);
                if (synclogic_multichannelmsgrsp.result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f(z16);
                bVar.e(synclogic_multichannelmsgrsp.result.get());
                bVar.d(synclogic_multichannelmsgrsp.err_msg.get().toStringUtf8());
                return;
            } catch (Exception e16) {
                QLog.e("ReportChannelMsgProtocolParser", 1, "parse error! " + e16);
                bVar.f(false);
                bVar.e(-1);
                bVar.d("client parse synclogic.MultiChannelMsgRsp error!");
                return;
            }
        }
        QLog.d("ReportChannelMsgProtocolParser", 1, "args error!");
    }

    @Override // fw1.a
    public String b() {
        return "ReportChannelMsgProtocolParser";
    }
}
