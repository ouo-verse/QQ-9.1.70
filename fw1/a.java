package fw1;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class a {
    private void c(FromServiceMsg fromServiceMsg, b bVar) {
        bVar.e(fromServiceMsg.getResultCode()).d(fromServiceMsg.getBusinessFailMsg()).f(fromServiceMsg.isSuccess());
    }

    public abstract void a(b bVar, Object... objArr);

    public abstract String b();

    public b d(FromServiceMsg fromServiceMsg, Object... objArr) {
        b bVar = new b(-1, "client error", false);
        if (!fromServiceMsg.isSuccess()) {
            QLog.d(b(), 1, "fromServiceMsg.isSuccess()");
            c(fromServiceMsg, bVar);
        } else {
            a(bVar, objArr);
        }
        return bVar;
    }
}
