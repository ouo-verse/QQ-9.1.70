package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class p extends m {
    @Override // com.tencent.biz.m, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        if (QLog.isColorLevel()) {
            QLog.i("TrpcProtoServlet", 2, "onReceive");
        }
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (fromServiceMsg.isSuccess()) {
            bArr = fh.a(fromServiceMsg.getWupBuffer());
        } else {
            extras.putString("data_error_msg", fromServiceMsg.getBusinessFailMsg());
            extras.putInt("data_error_code", fromServiceMsg.getBusinessFailCode());
            bArr = null;
        }
        extras.putByteArray("data", bArr);
        extras.putParcelable("fromServiceMsg", fromServiceMsg);
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), extras, null);
        if (QLog.isColorLevel()) {
            QLog.i("TrpcProtoServlet", 2, "onReceive exit");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet
    public void sendToMSF(Intent intent, ToServiceMsg toServiceMsg) {
        if (intent.hasExtra("moduleId")) {
            toServiceMsg.extraData.putString("moduleId", intent.getStringExtra("moduleId"));
            if (intent.getBooleanExtra("bNTRequest", false)) {
                toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG, 32);
            }
        }
        super.sendToMSF(intent, toServiceMsg);
    }
}
