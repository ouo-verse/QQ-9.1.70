package fw1;

import com.tencent.qphone.base.util.QLog;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelMsgRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i extends a {
    @Override // fw1.a
    public void a(b bVar, Object... objArr) {
        boolean z16;
        if (objArr != null && objArr.length >= 1 && objArr[0] != null) {
            synclogic$ChannelMsgRsp synclogic_channelmsgrsp = new synclogic$ChannelMsgRsp();
            try {
                synclogic_channelmsgrsp.mergeFrom((byte[]) objArr[0]);
                if (synclogic_channelmsgrsp.result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f(z16);
                bVar.e(synclogic_channelmsgrsp.result.get());
                bVar.d(synclogic_channelmsgrsp.err_msg.get().toStringUtf8());
                return;
            } catch (Exception e16) {
                QLog.e("ReportRoamMsgProtocolParser", 1, "parse error! " + e16);
                bVar.f(false);
                bVar.e(-1);
                bVar.d("client parse synclogic.ChannelMsgRsp error!");
                return;
            }
        }
        QLog.d("ReportRoamMsgProtocolParser", 1, "args error!");
    }

    @Override // fw1.a
    public String b() {
        return "ReportRoamMsgProtocolParser";
    }
}
