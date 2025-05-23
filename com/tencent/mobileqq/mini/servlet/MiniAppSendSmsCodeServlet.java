package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_0x87a$ReqBody;
import tencent.im.oidb.oidb_0x87c$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSendSmsCodeServlet extends MSFServlet {
    public static final String CMD_GET_SMS_CODE = "OidbSvc.0x87a_112";
    public static final String CMD_VERIFY_SMS_CODE = "OidbSvc.0x87c_112";
    public static final String EXTRA_CMD = "cmd";
    public static final String EXTRA_DATA = "data";
    public static final String EXTRA_DATA_ERROR_CODE = "dataErrorCode";
    public static final String EXTRA_DATA_ERROR_MSG = "dataErrorMsg";
    public static final String KEY_PHONE_NUMBER = "phoneNumber";
    public static final int SERVICE_TYPE_GET_SMS_CODE = 112;
    public static final String TAG = "MiniAppSendSmsCodeServlet";

    private static void sendRequest(int i3, String str, int i16, byte[] bArr, BusinessObserver businessObserver) {
        if (BaseApplicationImpl.getApplication() == null) {
            QLog.e(TAG, 1, "sendRequest getApplication is null, command is " + str);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), LoginVerifyServlet.class);
        newIntent.setObserver(businessObserver);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public static void sendSmsCodeRequest(String str, String str2, BusinessObserver businessObserver) {
        oidb_0x87a$ReqBody oidb_0x87a_reqbody = new oidb_0x87a$ReqBody();
        oidb_0x87a_reqbody.str_country.set(str2);
        oidb_0x87a_reqbody.str_telephone.set(str);
        sendRequest(2170, CMD_GET_SMS_CODE, 112, oidb_0x87a_reqbody.toByteArray(), businessObserver);
    }

    public static void sendVerifySmsCodeRequest(String str, String str2, String str3, BusinessObserver businessObserver) {
        oidb_0x87c$ReqBody oidb_0x87c_reqbody = new oidb_0x87c$ReqBody();
        oidb_0x87c_reqbody.str_sms_code.set(str);
        oidb_0x87c_reqbody.str_country.set(str3);
        oidb_0x87c_reqbody.str_telephone.set(str2);
        sendRequest(2172, CMD_VERIFY_SMS_CODE, 112, oidb_0x87c_reqbody.toByteArray(), businessObserver);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onReceive");
        }
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        Bundle bundle = extras;
        if (fromServiceMsg.isSuccess()) {
            bArr = fh.a(fromServiceMsg.getWupBuffer());
        } else {
            bundle.putString(EXTRA_DATA_ERROR_MSG, fromServiceMsg.getBusinessFailMsg());
            bundle.putInt(EXTRA_DATA_ERROR_CODE, fromServiceMsg.getBusinessFailCode());
            bArr = null;
        }
        bundle.putByteArray("data", bArr);
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onReceive exit");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("cmd");
        QLog.i(TAG, 1, "onSend, cmd is " + stringExtra);
        packet.setSSOCommand(stringExtra);
        packet.putSendData(fh.b(byteArrayExtra));
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onSend exit");
        }
    }
}
