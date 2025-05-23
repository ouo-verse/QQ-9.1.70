package com.tencent.open.appcommon;

import android.content.Intent;
import android.os.Bundle;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.open.agent.report.SSOSendReporter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import mqq.app.MSFServlet;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpensdkServlet extends MSFServlet {

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f340640e = {"ConnAuthSvr.get_auth_api_list", BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST, "ConnAuthSvr.sdk_auth_api", BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f340641f = {-10001, -10003, -10004, -10005, -10006, -10106, 110509};

    /* renamed from: h, reason: collision with root package name */
    private static final HashSet<String> f340642h = new HashSet<String>() { // from class: com.tencent.open.appcommon.OpensdkServlet.1
        {
            add("ConnAuthSvr.get_auth_api_list");
            add(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST);
            add("ConnAuthSvr.sdk_auth_api");
            add(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI);
            add("ConnAuthSvr.get_app_info");
            add(MainService.CMD_PRE_AUTH);
            add("QQConnectLogin.pre_auth_emp");
            add("QQConnectLogin.auth");
            add("QQConnectLogin.auth_emp");
            add("QQConnectLogin.get_promote_page");
            add("QQConnectLogin.get_promote_page_emp");
            add("QQConnectLogin.submit_promote_page");
            add("QQConnectLogin.submit_promote_page_emp");
            add(BaseConstants.CMD_CONNAUTHSVR_GETAPPINFO);
            add("ConnAuthSvr.fast_qq_login");
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private HashSet<String> f340643d = new HashSet<>();

    public static boolean a(String str) {
        return f340642h.contains(str);
    }

    private void b(String str, String str2, boolean z16, Bundle bundle) {
        HashMap hashMap = new HashMap();
        Object obj = bundle.get("code");
        hashMap.put("errMsg", bundle.getString("errorMsg", ""));
        hashMap.put("isSuccess", String.valueOf(z16));
        hashMap.put("errCode", String.valueOf(obj));
        hashMap.put("cmd", str2);
        hashMap.put(AlbumCacheData.LOGINUIN, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
        QQBeaconReport.report(str, "open_sdk_sso_request_event", hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0145 A[Catch: Exception -> 0x0278, TryCatch #3 {Exception -> 0x0278, blocks: (B:31:0x013b, B:33:0x0145, B:39:0x0155, B:41:0x017d, B:42:0x0196, B:45:0x01a1, B:48:0x01af, B:49:0x01b7, B:50:0x01cb, B:52:0x01d1, B:54:0x0247, B:56:0x0257, B:58:0x01b3, B:60:0x0236, B:35:0x014f), top: B:30:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0155 A[Catch: Exception -> 0x0278, TryCatch #3 {Exception -> 0x0278, blocks: (B:31:0x013b, B:33:0x0145, B:39:0x0155, B:41:0x017d, B:42:0x0196, B:45:0x01a1, B:48:0x01af, B:49:0x01b7, B:50:0x01cb, B:52:0x01d1, B:54:0x0247, B:56:0x0257, B:58:0x01b3, B:60:0x0236, B:35:0x014f), top: B:30:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0247 A[Catch: Exception -> 0x0278, TryCatch #3 {Exception -> 0x0278, blocks: (B:31:0x013b, B:33:0x0145, B:39:0x0155, B:41:0x017d, B:42:0x0196, B:45:0x01a1, B:48:0x01af, B:49:0x01b7, B:50:0x01cb, B:52:0x01d1, B:54:0x0247, B:56:0x0257, B:58:0x01b3, B:60:0x0236, B:35:0x014f), top: B:30:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0257 A[Catch: Exception -> 0x0278, TRY_LEAVE, TryCatch #3 {Exception -> 0x0278, blocks: (B:31:0x013b, B:33:0x0145, B:39:0x0155, B:41:0x017d, B:42:0x0196, B:45:0x01a1, B:48:0x01af, B:49:0x01b7, B:50:0x01cb, B:52:0x01d1, B:54:0x0247, B:56:0x0257, B:58:0x01b3, B:60:0x0236, B:35:0x014f), top: B:30:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0236 A[Catch: Exception -> 0x0278, TryCatch #3 {Exception -> 0x0278, blocks: (B:31:0x013b, B:33:0x0145, B:39:0x0155, B:41:0x017d, B:42:0x0196, B:45:0x01a1, B:48:0x01af, B:49:0x01b7, B:50:0x01cb, B:52:0x01d1, B:54:0x0247, B:56:0x0257, B:58:0x01b3, B:60:0x0236, B:35:0x014f), top: B:30:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0152 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0138  */
    @Override // mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        int length;
        int i3;
        boolean z17;
        String str;
        StringBuilder sb5;
        if (fromServiceMsg == null) {
            return;
        }
        QLog.d("OpensdkServlet", 1, "onReceive cmd: " + fromServiceMsg.getServiceCmd() + " success: " + fromServiceMsg.isSuccess() + " result: " + fromServiceMsg.getResultCode());
        Bundle bundle = new Bundle();
        bundle.putInt("code", fromServiceMsg.getResultCode());
        boolean booleanExtra = intent.getBooleanExtra("use_open_sdk_ticket", false);
        bundle.putBoolean("use_open_sdk_ticket", booleanExtra);
        int[] iArr = f340641f;
        int length2 = iArr.length;
        for (int i16 = 0; i16 < length2; i16++) {
            if (iArr[i16] == fromServiceMsg.getResultCode()) {
                bundle.putInt("code", 110509);
            }
        }
        bundle.putString("ssoAccount", fromServiceMsg.getUin());
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        if (wupBuffer != null && wupBuffer.length > 4) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wupBuffer);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            try {
                try {
                    int readInt = dataInputStream.readInt() - 4;
                    z16 = booleanExtra;
                    try {
                        byte[] bArr = new byte[readInt];
                        System.arraycopy(wupBuffer, 4, bArr, 0, readInt);
                        bundle.putByteArray("data", bArr);
                        try {
                            byteArrayInputStream.close();
                            dataInputStream.close();
                        } catch (Exception e16) {
                            e = e16;
                            sb5 = new StringBuilder();
                            sb5.append("onReceive close stream error: ");
                            sb5.append(e);
                            QLog.e("OpensdkServlet", 1, sb5.toString());
                            if (fromServiceMsg.isSuccess()) {
                            }
                            String serviceCmd = fromServiceMsg.getServiceCmd();
                            String[] strArr = f340640e;
                            length = strArr.length;
                            i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                }
                                i3++;
                            }
                            if (!z17) {
                            }
                            if (!z16) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        QLog.e("OpensdkServlet", 1, "onReceive unpack error: " + e);
                        try {
                            byteArrayInputStream.close();
                            dataInputStream.close();
                        } catch (Exception e18) {
                            e = e18;
                            sb5 = new StringBuilder();
                            sb5.append("onReceive close stream error: ");
                            sb5.append(e);
                            QLog.e("OpensdkServlet", 1, sb5.toString());
                            if (fromServiceMsg.isSuccess()) {
                            }
                            String serviceCmd2 = fromServiceMsg.getServiceCmd();
                            String[] strArr2 = f340640e;
                            length = strArr2.length;
                            i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                }
                                i3++;
                            }
                            if (!z17) {
                            }
                            if (!z16) {
                            }
                        }
                        if (fromServiceMsg.isSuccess()) {
                        }
                        String serviceCmd22 = fromServiceMsg.getServiceCmd();
                        String[] strArr22 = f340640e;
                        length = strArr22.length;
                        i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                            }
                            i3++;
                        }
                        if (!z17) {
                        }
                        if (!z16) {
                        }
                    }
                } finally {
                }
            } catch (Exception e19) {
                e = e19;
                z16 = booleanExtra;
            }
        } else {
            z16 = booleanExtra;
            if (1002 == fromServiceMsg.getResultCode()) {
                QLog.d("OpenSdkServlet", 1, "onReceive timeout!!!");
                bundle.putInt("code", 1002);
            }
        }
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("errorMsg", fromServiceMsg.getBusinessFailMsg());
        } else {
            bundle.putString("errorMsg", "");
        }
        try {
            String serviceCmd222 = fromServiceMsg.getServiceCmd();
            String[] strArr222 = f340640e;
            length = strArr222.length;
            i3 = 0;
            while (true) {
                if (i3 >= length) {
                    if (strArr222[i3].equals(serviceCmd222)) {
                        z17 = true;
                        break;
                    }
                    i3++;
                } else {
                    z17 = false;
                    break;
                }
            }
            if (!z17) {
                String str2 = fromServiceMsg.getUin() + "_" + fromServiceMsg.getServiceCmd();
                ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
                if (toServiceMsg != null) {
                    str2 = str2 + "_" + toServiceMsg.getAttribute("time_stamp");
                }
                if (this.f340643d.contains(str2)) {
                    this.f340643d.remove(str2);
                    if (fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP) == null) {
                        bundle.putBoolean("isShort", false);
                    } else {
                        bundle.putBoolean("isShort", true);
                    }
                    boolean isSuccess = fromServiceMsg.isSuccess();
                    str = BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP;
                    notifyObserver(intent, 0, isSuccess, bundle, d.class);
                } else {
                    str = BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("OpenSdkServlet", 2, " Rsp msgKey = " + str2 + " \nappId = " + fromServiceMsg.getAppId() + " appSeq = " + fromServiceMsg.getAppSeq() + " resultCode = " + fromServiceMsg.getResultCode() + " serviceCmd =  " + fromServiceMsg.getServiceCmd() + " uin = " + fromServiceMsg.getUin() + " isShort = " + fromServiceMsg.getAttribute(str));
                }
            } else {
                notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, d.class);
            }
            if (!z16) {
                b(fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd(), fromServiceMsg.isSuccess(), bundle);
            } else {
                SSOSendReporter.c(fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd(), intent.getBooleanExtra("is_oidb_sso_downgrade", false), fromServiceMsg.isSuccess(), bundle.getInt("code", -1), bundle.getString("errorMsg", ""));
            }
        } catch (Exception e26) {
            QLog.e("OpenSdkServlet", 1, "Exception", e26);
        }
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(Intent intent) {
        super.service(intent);
        String stringExtra = intent.getStringExtra("cmd");
        String stringExtra2 = intent.getStringExtra("uin");
        ToServiceMsg toServiceMsg = new ToServiceMsg(null, stringExtra2, stringExtra);
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
            toServiceMsg.setTimeout(intent.getLongExtra("timeout", 40000L));
            toServiceMsg.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
            boolean booleanExtra = intent.getBooleanExtra("use_open_sdk_ticket", false);
            if (booleanExtra) {
                QLog.d("OpensdkServlet", 1, "service use sso for open sdk");
                toServiceMsg.setUin(stringExtra2);
                toServiceMsg.setUinType((byte) 6);
            }
            int intExtra = intent.getIntExtra(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, -1);
            if (intent.getBooleanExtra("key_support_retry", false)) {
                toServiceMsg.setIsSupportRetry(true);
            }
            String[] strArr = f340640e;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (strArr[i3].equals(stringExtra)) {
                    if (intExtra == -1) {
                        intExtra = 1;
                    }
                    toServiceMsg.setQuickSend(true, intExtra);
                    long currentTimeMillis = System.currentTimeMillis();
                    toServiceMsg.addAttribute("time_stamp", Long.valueOf(currentTimeMillis));
                    String str = stringExtra2 + "_" + stringExtra + "_" + currentTimeMillis;
                    if (QLog.isColorLevel()) {
                        QLog.d("OpenSdkServlet", 2, "Send msgKey = " + str);
                    }
                    this.f340643d.add(str);
                } else {
                    i3++;
                }
            }
            intent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            sendToMSF(intent, toServiceMsg);
            QLog.d("OpensdkServlet", 1, "service cmd: " + stringExtra);
            if (!booleanExtra) {
                SSOSendReporter.b(stringExtra2, stringExtra, intent.getBooleanExtra("is_oidb_sso_downgrade", false));
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
    }
}
