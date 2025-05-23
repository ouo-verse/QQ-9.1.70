package m23;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.pb.qqvalue.qqvalue$GetQQValueReq;
import com.tencent.pb.qqvalue.qqvalue$GetQQValueRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c implements com.tencent.mobileqq.apollo.handler.d {
    private void b(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        qqvalue$GetQQValueRsp qqvalue_getqqvaluersp = new qqvalue$GetQQValueRsp();
        if (bArr == null) {
            return;
        }
        try {
            qqvalue_getqqvaluersp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException unused) {
            qqvalue_getqqvaluersp = null;
        }
        if (qqvalue_getqqvaluersp != null && qqvalue_getqqvaluersp.qq_value.has() && qqvalue_getqqvaluersp.qq_value.uin.has()) {
            b.b().e(qqvalue_getqqvaluersp.qq_value.uin.get() + "", qqvalue_getqqvaluersp.qq_value);
        }
    }

    public static void c() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null && !TextUtils.isEmpty(qQAppInterface.getCurrentUin())) {
            NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), com.tencent.mobileqq.apollo.utils.a.b());
            newIntent.putExtra("cmd", "qqvalue.GetQQValue");
            qqvalue$GetQQValueReq qqvalue_getqqvaluereq = new qqvalue$GetQQValueReq();
            qqvalue_getqqvaluereq.uin.set(Long.valueOf(qQAppInterface.getCurrentUin()).longValue());
            newIntent.putExtra("data", qqvalue_getqqvaluereq.toByteArray());
            newIntent.putExtra("timeout", 30000);
            qQAppInterface.startServlet(newIntent);
        }
    }

    @Override // com.tencent.mobileqq.apollo.handler.d
    public void a(com.tencent.mobileqq.apollo.handler.b bVar, Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        b(intent, fromServiceMsg, bArr);
    }
}
