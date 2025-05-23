package com.tencent.mobileqq.loginregister.servlet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends MSFServlet {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(int i3, Intent intent, FromServiceMsg fromServiceMsg) {
        if (i3 != 1020) {
            if (i3 != 1022) {
                if (i3 != 1025) {
                    if (i3 != 2217) {
                        switch (i3) {
                            case 1003:
                                d(intent, fromServiceMsg, i3);
                                return;
                            case 1004:
                                e(intent, fromServiceMsg, i3);
                                return;
                            case 1005:
                                g(intent, fromServiceMsg, i3);
                                return;
                            default:
                                return;
                        }
                    }
                    b(intent, fromServiceMsg, i3);
                    return;
                }
                h(intent, fromServiceMsg, i3);
                return;
            }
            c(intent, fromServiceMsg, i3);
            return;
        }
        f(intent, fromServiceMsg, i3);
    }

    private void b(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("promptInfo", (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, new byte[0]));
        if (fromServiceMsg.isSuccess()) {
            try {
                int intValue = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, -1)).intValue();
                String str = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_PHONE_PROTECT_UINS_URL, "");
                bundle.putInt("code", intValue);
                bundle.putString("protect_uins_url", str);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else if (fromServiceMsg.getBusinessFailCode() == 3001) {
            String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
            if (!TextUtils.isEmpty(businessFailMsg)) {
                try {
                    int intValue2 = Integer.valueOf(businessFailMsg).intValue();
                    byte[] bArr = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE, new byte[0]);
                    bundle.putInt("code", intValue2);
                    bundle.putByteArray(DeviceType.DeviceCategory.MOBILE, bArr);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, d.class);
    }

    private void c(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("promptInfo", (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, new byte[0]));
        if (fromServiceMsg.isSuccess()) {
            try {
                int intValue = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, -1)).intValue();
                int intValue2 = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESENDTIME, -1)).intValue();
                int intValue3 = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_TIMEOVER, -1)).intValue();
                String str = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_ERRMSG, "");
                String str2 = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_UIN, "");
                String str3 = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_NICK, "");
                String str4 = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_PICTURE_URL, "");
                bundle.putInt("code", intValue);
                bundle.putInt("next_chk_time", intValue2);
                bundle.putInt("total_time_over", intValue3);
                bundle.putString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, str);
                bundle.putString("uin", str2);
                bundle.putString("nick", str3);
                bundle.putString("faceUrl", str4);
                String str5 = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_PHONE_PROTECT_UINS_URL);
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("phone_protect_uins_url", str5);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, d.class);
    }

    private void d(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("promptInfo", (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, new byte[0]));
        if (fromServiceMsg.isSuccess()) {
            try {
                int intValue = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, -1)).intValue();
                byte[] bArr = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE, new byte[0]);
                bundle.putInt("code", intValue);
                bundle.putByteArray(DeviceType.DeviceCategory.MOBILE, bArr);
                if (intent.hasExtra("inviteCode")) {
                    bundle.putString("inviteCode", intent.getStringExtra("inviteCode"));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else if (fromServiceMsg.getBusinessFailCode() == 3001) {
            String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
            if (!TextUtils.isEmpty(businessFailMsg)) {
                try {
                    int intValue2 = Integer.valueOf(businessFailMsg).intValue();
                    byte[] bArr2 = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE, new byte[0]);
                    bundle.putInt("code", intValue2);
                    bundle.putByteArray(DeviceType.DeviceCategory.MOBILE, bArr2);
                    if (intent.hasExtra("inviteCode")) {
                        bundle.putString("inviteCode", intent.getStringExtra("inviteCode"));
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, d.class);
    }

    private void dispatchService(int i3, Intent intent) {
        if (i3 != 1020) {
            if (i3 != 1022) {
                if (i3 != 1025) {
                    if (i3 != 2217) {
                        switch (i3) {
                            case 1003:
                                l(intent);
                                return;
                            case 1004:
                                m(intent);
                                return;
                            case 1005:
                                o(intent);
                                return;
                            default:
                                return;
                        }
                    }
                    i(intent);
                    return;
                }
                j(intent);
                return;
            }
            k(intent);
            return;
        }
        n(intent);
    }

    private void e(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("promptInfo", (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, new byte[0]));
        if (fromServiceMsg.isSuccess()) {
            try {
                bundle.putInt("code", ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, -1)).intValue());
                String str = (String) fromServiceMsg.getAttribute("bind_qq_uin");
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("bind_qq_uin", str);
                }
                String str2 = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_ACCOUNT_NICK);
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("bind_qq_nick", str2);
                }
                String str3 = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_ACCOUNT_FACEURL);
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("bind_qq_face_url", str3);
                }
                String str4 = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_PHONE_PROTECT_UINS_URL);
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("phone_protect_uins_url", str4);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, d.class);
    }

    private void f(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("promptInfo", (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, new byte[0]));
        if (fromServiceMsg.isSuccess()) {
            try {
                int intValue = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, -1)).intValue();
                int intValue2 = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESENDTIME, -1)).intValue();
                int intValue3 = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_TIMEOVER, -1)).intValue();
                bundle.putInt("code", intValue);
                bundle.putInt("next_chk_time", intValue2);
                bundle.putInt("total_time_over", intValue3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, d.class);
    }

    private void g(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("promptInfo_error", (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, new byte[0]));
        if (fromServiceMsg.isSuccess()) {
            try {
                int intValue = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, -1)).intValue();
                byte[] bArr = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_CONTACTSIG, new byte[0]);
                String str = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_UIN, "");
                byte[] bArr2 = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_LH_SIG, null);
                byte[] bArr3 = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG, null);
                if (bArr2 != null && bArr2.length > 0) {
                    bundle.putByteArray("lhsig", bArr2);
                    if (QLog.isColorLevel()) {
                        QLog.d("RegisterServlet", 2, "LiangHao_lhsig= " + new String(bArr2));
                    }
                }
                bundle.putByteArray(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG, bArr3);
                bundle.putInt("code", intValue);
                bundle.putByteArray("promptInfo", bArr);
                bundle.putString("uin", str);
                if (QLog.isColorLevel()) {
                    QLog.d("RegisterServlet", 2, "onReceive code= " + intValue + ",uin=" + str);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("RegisterServlet", 2, "onReceive failed = " + fromServiceMsg.getBusinessFailCode());
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("lhuin"))) {
            bundle.putBoolean("reg_Lianghao", true);
        }
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, d.class);
    }

    private void h(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        if (wupBuffer != null && wupBuffer.length > 4) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wupBuffer);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            try {
                int readInt = dataInputStream.readInt() - 4;
                byte[] bArr = new byte[readInt];
                System.arraycopy(wupBuffer, 4, bArr, 0, readInt);
                bundle.putByteArray("data", bArr);
                bundle.putInt(QzoneIPCModule.RESULT_CODE, fromServiceMsg.getResultCode());
            } catch (Exception unused) {
            } catch (Throwable th5) {
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                } catch (Exception unused2) {
                }
                throw th5;
            }
            try {
                byteArrayInputStream.close();
                dataInputStream.close();
            } catch (Exception unused3) {
            }
        }
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, BusinessObserver.class);
    }

    private void i(Intent intent) {
        Long valueOf = Long.valueOf(intent.getLongExtra("appid", 0L));
        String stringExtra = intent.getStringExtra("appVersion");
        byte byteExtra = intent.getByteExtra(IjkMediaMeta.IJKM_KEY_LANGUAGE, (byte) 2);
        String stringExtra2 = intent.getStringExtra("wifi_mac");
        String stringExtra3 = intent.getStringExtra("os_language");
        int intExtra = intent.getIntExtra("qq_language", 0);
        String stringExtra4 = intent.getStringExtra("gps_location");
        HashMap<String, Object> hashMap = (HashMap) intent.getSerializableExtra("mapSt");
        String stringExtra5 = intent.getStringExtra(BaseConstants.ATTR_KET_PHONE_TOKEN);
        ToServiceMsg registerCommitMobileMsg = getAppRuntime().getService().msfSub.getRegisterCommitMobileMsg("", (byte) 0, byteExtra, (byte) 0, "", stringExtra, intent.getStringExtra(DeviceType.DeviceCategory.MOBILE), valueOf, hashMap);
        HashMap<String, Object> attributes = registerCommitMobileMsg.getAttributes();
        String str = "";
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        attributes.put("wifi_mac", stringExtra2);
        HashMap<String, Object> attributes2 = registerCommitMobileMsg.getAttributes();
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        attributes2.put("os_language", stringExtra3);
        registerCommitMobileMsg.getAttributes().put("qq_language", Integer.valueOf(intExtra));
        HashMap<String, Object> attributes3 = registerCommitMobileMsg.getAttributes();
        if (stringExtra4 != null) {
            str = stringExtra4;
        }
        attributes3.put("gps_location", str);
        if (stringExtra5 != null) {
            registerCommitMobileMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REG_PHONE_TOKEN, stringExtra5.getBytes());
        }
        sendToMSF(intent, registerCommitMobileMsg);
    }

    private void j(Intent intent) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(null, "0", intent.getStringExtra("cmd"));
        toServiceMsg.setTimeout(intent.getLongExtra("timeout", 30000L));
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(byteArrayExtra.length + 4);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeInt(byteArrayExtra.length + 4);
            dataOutputStream.write(byteArrayExtra);
            toServiceMsg.putWupBuffer(byteArrayOutputStream.toByteArray());
        } catch (Exception unused) {
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
                dataOutputStream.close();
            } catch (Exception unused2) {
            }
            throw th5;
        }
        try {
            byteArrayOutputStream.close();
            dataOutputStream.close();
        } catch (Exception unused3) {
            intent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            sendToMSF(intent, toServiceMsg);
        }
    }

    private void k(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getRegisterQueryUpSmsStatMsg());
    }

    private void l(Intent intent) {
        String stringExtra = intent.getStringExtra("countryCode");
        String stringExtra2 = intent.getStringExtra(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER);
        String stringExtra3 = intent.getStringExtra("inviteCode");
        Long valueOf = Long.valueOf(intent.getLongExtra("appid", 0L));
        String stringExtra4 = intent.getStringExtra("verifySig");
        String str = stringExtra + "-" + stringExtra2;
        String stringExtra5 = intent.getStringExtra("appVersion");
        byte byteExtra = intent.getByteExtra(IjkMediaMeta.IJKM_KEY_LANGUAGE, (byte) 2);
        String stringExtra6 = intent.getStringExtra("wifi_mac");
        String stringExtra7 = intent.getStringExtra("os_language");
        int intExtra = intent.getIntExtra("qq_language", 0);
        String stringExtra8 = intent.getStringExtra("gps_location");
        ToServiceMsg registerCommitMobileMsg = getAppRuntime().getService().msfSub.getRegisterCommitMobileMsg(stringExtra4, (byte) 0, byteExtra, (byte) 0, "", stringExtra5, str, valueOf, (HashMap) intent.getSerializableExtra("mapSt"));
        if (!TextUtils.isEmpty(stringExtra3)) {
            registerCommitMobileMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_INVITATION_CODE, stringExtra3);
        }
        HashMap<String, Object> attributes = registerCommitMobileMsg.getAttributes();
        String str2 = "";
        if (stringExtra6 == null) {
            stringExtra6 = "";
        }
        attributes.put("wifi_mac", stringExtra6);
        HashMap<String, Object> attributes2 = registerCommitMobileMsg.getAttributes();
        if (stringExtra7 == null) {
            stringExtra7 = "";
        }
        attributes2.put("os_language", stringExtra7);
        registerCommitMobileMsg.getAttributes().put("qq_language", Integer.valueOf(intExtra));
        HashMap<String, Object> attributes3 = registerCommitMobileMsg.getAttributes();
        if (stringExtra8 != null) {
            str2 = stringExtra8;
        }
        attributes3.put("gps_location", str2);
        sendToMSF(intent, registerCommitMobileMsg);
    }

    private void m(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getRegisterCommitSmsCodeMsg(intent.getStringExtra("code")));
    }

    private void n(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getRegisterSendReSendSmsMsg());
    }

    private void o(Intent intent) {
        String stringExtra = intent.getStringExtra(NotificationActivity.PASSWORD);
        String stringExtra2 = intent.getStringExtra("nick");
        String stringExtra3 = intent.getStringExtra("code");
        boolean z16 = true;
        if (intent.hasExtra("bindMobile")) {
            z16 = intent.getBooleanExtra("bindMobile", true);
        }
        String stringExtra4 = intent.getStringExtra("lhuin");
        String stringExtra5 = intent.getStringExtra("unBindlhUin");
        String stringExtra6 = intent.getStringExtra("appVersion");
        String stringExtra7 = intent.getStringExtra("profileSig");
        ToServiceMsg registerCommitPassMsg = getAppRuntime().getService().msfSub.getRegisterCommitPassMsg(stringExtra3, stringExtra, stringExtra2, z16, stringExtra4, stringExtra5, stringExtra6, (HashMap) intent.getSerializableExtra("mapSt"));
        if (!TextUtils.isEmpty(stringExtra7)) {
            registerCommitPassMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_PROFILE_SIG, stringExtra7.getBytes());
        }
        sendToMSF(intent, registerCommitPassMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (intent != null) {
            i3 = intent.getIntExtra("action", 0);
        } else {
            i3 = -1;
        }
        a(i3, intent, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) packet);
        }
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            super.service(intent);
            dispatchService(intent.getIntExtra("action", 0), intent);
        }
    }
}
