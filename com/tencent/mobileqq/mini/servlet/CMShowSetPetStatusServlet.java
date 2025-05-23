package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class CMShowSetPetStatusServlet extends MSFServlet {
    public static final String CMD_STRING = "apollo_router_weight.pet_core_linkcmd_set_status";
    public static final String EXTRA_PET_ID = "petId";
    public static final String EXTRA_PET_STATUS = "petStatus";
    private static final int PACKAGE_HEAD_LENGTH = 4;
    public static final int RET_CODE_SUCCESS = 0;

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] wupBuffer;
        Bundle bundle = new Bundle();
        bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && (wupBuffer = fromServiceMsg.getWupBuffer()) != null) {
            int length = wupBuffer.length - 4;
            byte[] bArr = new byte[length];
            PkgTools.copyData(bArr, 0, wupBuffer, 4, length);
            try {
                WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                webSSOAgent$UniSsoServerRsp.mergeFrom(bArr);
                bundle.putLong("retCode", webSSOAgent$UniSsoServerRsp.ret.get());
                bundle.putString("errMsg", webSSOAgent$UniSsoServerRsp.errmsg.get());
                notifyObserver(intent, 1087, webSSOAgent$UniSsoServerRsp.ret.get() == 0, bundle, MiniAppObserver.class);
                return;
            } catch (Throwable th5) {
                QLog.e(MSFServlet.TAG, 1, "[onReceive] process response error!", th5);
            }
        }
        notifyObserver(intent, 1087, false, bundle, MiniAppObserver.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra(EXTRA_PET_ID, -1);
        int intExtra2 = intent.getIntExtra(EXTRA_PET_STATUS, -1);
        WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
        webSSOAgent$UniSsoServerReqComm.platform.set(109L);
        webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
        webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
        WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
        webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", intExtra);
            jSONObject.put("status", intExtra2);
        } catch (JSONException e16) {
            QLog.e(MSFServlet.TAG, 1, "[onSend] params error!", e16);
        }
        webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
        byte[] byteArray = webSSOAgent$UniSsoServerReq.toByteArray();
        byte[] bArr = new byte[byteArray.length + 4];
        PkgTools.dWord2Byte(bArr, 0, byteArray.length + 4);
        PkgTools.copyData(bArr, 4, byteArray, byteArray.length);
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(bArr);
    }
}
