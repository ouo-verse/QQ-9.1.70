package com.tencent.mobileqq.timiqqid.net;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.jvm.functions.Function0;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends MSFServlet {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String c(FromServiceMsg fromServiceMsg) {
        return "onReceive,cmd:" + fromServiceMsg.getServiceCmd() + ",seq:" + fromServiceMsg.getRequestSsoSeq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String d(String str) {
        return "onSend,cmd:" + str;
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, final FromServiceMsg fromServiceMsg) {
        YoloLog.d("QQIDServlet", new Function0() { // from class: com.tencent.mobileqq.timiqqid.net.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String c16;
                c16 = g.c(FromServiceMsg.this);
                return c16;
            }
        });
        Bundle bundle = new Bundle();
        boolean z16 = false;
        if (fromServiceMsg.isSuccess()) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (i3 != 0) {
                    QLog.e("QQIDServlet", 1, "oidb head error code:" + i3 + ",message:" + oidb_sso_oidbssopkg.str_error_msg.get());
                    bundle.putInt("result_code", i3);
                } else {
                    z16 = true;
                }
                bundle.putByteArray("rsp_data", oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            } catch (Exception unused) {
                bundle.putInt("result_code", -1);
            }
        } else {
            bundle.putInt("result_code", fromServiceMsg.getResultCode());
        }
        notifyObserver(intent, 0, z16, bundle, null);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        final String stringExtra = intent.getStringExtra("sso_cmd");
        byte[] byteArrayExtra = intent.getByteArrayExtra("req_data");
        packet.setSSOCommand(stringExtra);
        if (byteArrayExtra != null) {
            packet.putSendData(fh.b(byteArrayExtra));
        }
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        YoloLog.d("QQIDServlet", new Function0() { // from class: com.tencent.mobileqq.timiqqid.net.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String d16;
                d16 = g.d(stringExtra);
                return d16;
            }
        });
    }
}
