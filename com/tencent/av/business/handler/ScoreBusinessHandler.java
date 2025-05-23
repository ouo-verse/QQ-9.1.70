package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.av.utils.ar;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x1172.cmd0x1172$Cmd0x1172Request;
import tencent.im.oidb.cmd0x1172.cmd0x1172$Cmd0x1172Response;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ScoreBusinessHandler extends BusinessHandler {
    public ScoreBusinessHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            cmd0x1172$Cmd0x1172Response cmd0x1172_cmd0x1172response = new cmd0x1172$Cmd0x1172Response();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x1172_cmd0x1172response);
            if (parseOIDBPkg != 0) {
                String str = "";
                String string = fromServiceMsg.extraData.getString("str_error_msg", "");
                if (cmd0x1172_cmd0x1172response.str_error.has()) {
                    str = cmd0x1172_cmd0x1172response.str_error.get();
                }
                QLog.i("ScoreBusinessHandler", 1, "handleGetVideoCallQualityInfo is business.errorTip: " + str + "\uff0coidb.errorCode: " + parseOIDBPkg + "\uff0coidb.errorMsg: " + string + "\uff0cmsf.respCode: " + fromServiceMsg.getResultCode());
                return;
            }
            ar.i(this.appRuntime, cmd0x1172_cmd0x1172response, toServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScoreBusinessHandler", 2, "handleGetVideoCallQualityInfo req == null || res == null");
        }
    }

    public void D2(int i3, String str, int i16, String str2) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("ScoreBusinessHandler", 1, "videoMsg == null");
            return;
        }
        cmd0x1172$Cmd0x1172Request cmd0x1172_cmd0x1172request = new cmd0x1172$Cmd0x1172Request();
        cmd0x1172_cmd0x1172request.uin.set(this.appRuntime.getLongAccountUin());
        cmd0x1172_cmd0x1172request.video_event.set(i3);
        cmd0x1172_cmd0x1172request.video_msg.set(str);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0x1172_0", 4466, 0, cmd0x1172_cmd0x1172request.toByteArray());
        makeOIDBPkg.extraData.putLong("uin", this.appRuntime.getLongAccountUin());
        makeOIDBPkg.extraData.putInt("uinType", i16);
        makeOIDBPkg.extraData.putString("peerUin", str2);
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0x1172_0");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null && !msgCmdFilter(fromServiceMsg.getServiceCmd()) && "OidbSvcTrpcTcp.0x1172_0".equals(fromServiceMsg.getServiceCmd())) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
