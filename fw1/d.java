package fw1;

import com.tencent.qphone.base.util.QLog;
import tencent.im.group_pro_proto.synclogic.synclogic$FirstViewRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d extends a {
    @Override // fw1.a
    public void a(b bVar, Object... objArr) {
        boolean z16;
        if (objArr != null && objArr.length >= 1 && objArr[0] != null) {
            synclogic$FirstViewRsp synclogic_firstviewrsp = new synclogic$FirstViewRsp();
            try {
                synclogic_firstviewrsp.mergeFrom((byte[]) objArr[0]);
                if (synclogic_firstviewrsp.result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f(z16);
                bVar.e(synclogic_firstviewrsp.result.get());
                bVar.d(synclogic_firstviewrsp.err_msg.get().toStringUtf8());
                return;
            } catch (Exception e16) {
                QLog.e("ReportFirstViewProtocolParser", 1, "parse error! " + e16);
                bVar.f(false);
                bVar.e(-1);
                bVar.d("client parse synclogic.FirstViewRsp error!");
                return;
            }
        }
        QLog.d("ReportFirstViewProtocolParser", 1, "args error!");
    }

    @Override // fw1.a
    public String b() {
        return "ReportFirstViewProtocolParser";
    }
}
