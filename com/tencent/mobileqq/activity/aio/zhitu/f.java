package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.zhitu.gate.ZhituSafeGate$RspBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends MSFServlet {
    private void a(Intent intent, int i3, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        bundle.putInt("ErrorCode", i3);
        bundle.putParcelable("FromServerMsg", fromServiceMsg);
        bundle.putString("UniqueKey", intent.getStringExtra("ZhituReqKey"));
        notifyObserver(intent, 0, false, bundle, b.class);
    }

    private byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 4];
        PkgTools.dWord2Byte(bArr2, 0, bArr.length + 4);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        return bArr2;
    }

    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        return new String[]{"AIMessage.Text2Image", "MQInference.ZhituReport"};
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ZhituResponse zhituResponse;
        if (QLog.isColorLevel()) {
            QLog.d("ZhituServlet", 2, "onReceive with code: " + fromServiceMsg.getResultCode());
        }
        String stringExtra = intent.getStringExtra("ZhituCMD");
        if (stringExtra.equals("MQInference.ZhituReport")) {
            return;
        }
        boolean z16 = true;
        if (stringExtra.equals("ZhituGate.Check")) {
            if (fromServiceMsg.isSuccess()) {
                AppRuntime appRuntime = getAppRuntime();
                if (appRuntime != null && (appRuntime instanceof AppInterface)) {
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr = new byte[length];
                    PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
                    fromServiceMsg.putWupBuffer(bArr);
                    try {
                        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                        ZhituSafeGate$RspBody zhituSafeGate$RspBody = new ZhituSafeGate$RspBody();
                        zhituSafeGate$RspBody.mergeFrom(wupBuffer);
                        int i3 = zhituSafeGate$RspBody.int32_result.get();
                        if (i3 == 0) {
                            int i16 = zhituSafeGate$RspBody.gate_info.get().uint32_state.get();
                            ZhituManager I = ZhituManager.I((QQAppInterface) appRuntime);
                            if (i16 != 1) {
                                z16 = false;
                            }
                            I.R0(z16);
                            ZhituManager.I((QQAppInterface) appRuntime).P0(System.currentTimeMillis());
                        } else if (QLog.isColorLevel()) {
                            QLog.d("ZhituServlet", 2, "onReceive CMD_SAFE_GATE failed result: " + i3);
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.e("ZhituServlet", 2, "onReceive CMD_SAFE_GATE has exception: ", e16);
                        return;
                    }
                }
                return;
            }
            int resultCode = fromServiceMsg.getResultCode();
            if (QLog.isColorLevel()) {
                QLog.d("ZhituServlet", 2, "onReceive CMD_SAFE_GATE not Success code is : " + resultCode);
                return;
            }
            return;
        }
        if (!fromServiceMsg.isSuccess()) {
            a(intent, 1, fromServiceMsg);
            return;
        }
        byte[] wupBuffer2 = fromServiceMsg.getWupBuffer();
        if (wupBuffer2 != null) {
            String str = new String(Arrays.copyOfRange(wupBuffer2, 4, wupBuffer2.length));
            try {
                if (!TextUtils.isEmpty(str)) {
                    zhituResponse = (ZhituResponse) JSONUtils.c(new JSONObject(str), ZhituResponse.class);
                } else {
                    zhituResponse = new ZhituResponse();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("ErrorCode", 0);
                bundle.putParcelable("Response", zhituResponse);
                bundle.putString("UniqueKey", intent.getStringExtra("ZhituReqKey"));
                bundle.putInt("StartIdx", intent.getIntExtra("StartIdx", 0));
                bundle.putString("QueryText", intent.getStringExtra("QueryText"));
                notifyObserver(intent, 0, true, bundle, b.class);
                return;
            } catch (JSONException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("ZhituServlet", 2, "parse json error with str:\n" + str + "\n" + e17);
                }
                a(intent, 3, fromServiceMsg);
                return;
            }
        }
        a(intent, 2, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ZhituCMD");
        packet.setSSOCommand(stringExtra);
        if (QLog.isColorLevel()) {
            QLog.d("ZhituServlet", 2, "onSend with cmd: " + stringExtra);
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("ZhituRequestBytes");
        if (byteArrayExtra != null) {
            packet.putSendData(b(byteArrayExtra));
            return;
        }
        throw new IllegalArgumentException("no bytes to send");
    }
}
