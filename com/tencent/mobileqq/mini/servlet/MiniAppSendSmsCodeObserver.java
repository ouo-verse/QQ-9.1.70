package com.tencent.mobileqq.mini.servlet;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_0x87a$RspBody;
import tencent.im.oidb.oidb_0x87c$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSendSmsCodeObserver implements BusinessObserver {
    private static final String TAG = "MiniAppSendSmsCodeObserver";

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        String string = bundle.getString("cmd");
        try {
            if (!z16) {
                String string2 = bundle.getString(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_MSG, "");
                int i16 = bundle.getInt(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_CODE);
                QLog.e(TAG, 1, "MiniAppSendSmsCodeObserver onReceive error, code is : " + i16 + ", error msg is : " + string2 + " cmd is : " + string);
                onFailedResponse(string, i16, string2);
                return;
            }
            byte[] byteArray = bundle.getByteArray("data");
            if (byteArray == null) {
                QLog.e(TAG, 1, "MiniAppSendSmsCodeObserver onReceive success but data is null");
                onFailedResponse(string, -1, "data is null");
                return;
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.mergeFrom(byteArray);
            int i17 = oidb_sso_oidbssopkg.uint32_result.get();
            if (i17 != 0) {
                String str = oidb_sso_oidbssopkg.str_error_msg.get();
                onFailedResponse(string, i17, str);
                QLog.e(TAG, 1, "sso result error, ret : " + i17 + "  error : " + str);
                return;
            }
            byte[] byteArray2 = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            if (MiniAppSendSmsCodeServlet.CMD_GET_SMS_CODE.equals(string)) {
                oidb_0x87a$RspBody oidb_0x87a_rspbody = new oidb_0x87a$RspBody();
                oidb_0x87a_rspbody.mergeFrom(byteArray2);
                sendSmsCodeSuccess(oidb_0x87a_rspbody);
            } else if (MiniAppSendSmsCodeServlet.CMD_VERIFY_SMS_CODE.equals(string)) {
                oidb_0x87c$RspBody oidb_0x87c_rspbody = new oidb_0x87c$RspBody();
                oidb_0x87c_rspbody.mergeFrom(byteArray2);
                verifySmsCodeSuccess(oidb_0x87c_rspbody);
            }
        } catch (Throwable th5) {
            onFailedResponse(string, -1, th5.getMessage());
        }
    }

    public void sendSmsCodeSuccess(oidb_0x87a$RspBody oidb_0x87a_rspbody) {
    }

    public void verifySmsCodeSuccess(oidb_0x87c$RspBody oidb_0x87c_rspbody) {
    }

    public void onFailedResponse(String str, int i3, String str2) {
    }
}
