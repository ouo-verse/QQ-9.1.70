package pl2;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes16.dex */
public class j extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        QLog.i("Q.qwallet.payGdtAdServlet", 1, "[onReceive] cmd=" + intent.getStringExtra("cmd") + ", success=" + fromServiceMsg.isSuccess() + ", retCode=" + fromServiceMsg.getResultCode());
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(WadlProxyConsts.EXTRA_RESULT_CODE, fromServiceMsg.getResultCode());
        bundle.putString("cmd", intent.getStringExtra("cmd"));
        bundle.putByteArray("data", bArr);
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("cmd");
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        long longExtra = intent.getLongExtra("timeout", 30000L);
        packet.setSSOCommand(stringExtra);
        packet.setTimeout(longExtra);
        packet.putSendData(byteArrayExtra);
        QLog.i("Q.qwallet.payGdtAdServlet", 1, "[onSend] cmd=" + stringExtra);
    }
}
