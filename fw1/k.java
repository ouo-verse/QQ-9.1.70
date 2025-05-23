package fw1;

import com.tencent.qphone.base.util.QLog;
import tencent.im.group_pro_proto.oidb0xf62.Oidb0xf62$RspBody;

/* compiled from: P */
/* loaded from: classes14.dex */
public class k extends a {
    @Override // fw1.a
    public void a(b bVar, Object... objArr) {
        boolean z16;
        if (objArr != null && objArr.length >= 1 && objArr[0] != null) {
            try {
                Oidb0xf62$RspBody mergeFrom = new Oidb0xf62$RspBody().mergeFrom((byte[]) objArr[0]);
                if (mergeFrom.result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f(z16);
                bVar.e(mergeFrom.result.get());
                bVar.d(mergeFrom.errmsg.get().toStringUtf8());
                return;
            } catch (Exception e16) {
                QLog.e("ReportSendMsgProtocolPraser", 1, "parse error! " + e16);
                bVar.f(false);
                bVar.e(-1);
                bVar.d("client parse Oidb0xf62 error!");
                return;
            }
        }
        QLog.d("ReportSendMsgProtocolPraser", 1, "args error!");
    }

    @Override // fw1.a
    public String b() {
        return "ReportSendMsgProtocolPraser";
    }
}
