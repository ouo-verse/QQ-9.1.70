package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetTeenagerConfigRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetTeenagerConfigServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID_LIST = "remoteAppIDWhiteList";
    public static final String KEY_FREQUENCY_SWITCH = "frequencySwitch";
    public static final String KEY_REQUEST_EXT_INFO = "requestExtInfo";
    public static final String KEY_TIME_INTERVAL = "timeInterval";
    public static final String TAG = "MiniAppGetTeenagerConfigServlet";

    public MiniAppGetTeenagerConfigServlet() {
        this.observerId = 1093;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetTeenagerConfigRsp iNTERFACE$StGetTeenagerConfigRsp = new INTERFACE$StGetTeenagerConfigRsp();
        iNTERFACE$StGetTeenagerConfigRsp.mergeFrom(bArr);
        if (iNTERFACE$StGetTeenagerConfigRsp.appIDs != null && iNTERFACE$StGetTeenagerConfigRsp.frequencySwitch != null && iNTERFACE$StGetTeenagerConfigRsp.timeInterval != null && iNTERFACE$StGetTeenagerConfigRsp.extInfo != null) {
            QLog.d(TAG, 1, "MiniAppGetTeenagerConfigServlet frequencySwitch : " + iNTERFACE$StGetTeenagerConfigRsp.frequencySwitch + "; timeInterval : " + iNTERFACE$StGetTeenagerConfigRsp.timeInterval);
            bundle.putString(KEY_APPID_LIST, getAppIdString(iNTERFACE$StGetTeenagerConfigRsp.appIDs.get()));
            bundle.putInt(KEY_FREQUENCY_SWITCH, iNTERFACE$StGetTeenagerConfigRsp.frequencySwitch.get());
            bundle.putInt(KEY_TIME_INTERVAL, iNTERFACE$StGetTeenagerConfigRsp.timeInterval.get());
            notifyObserver(intent, this.observerId, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra(KEY_REQUEST_EXT_INFO);
        byte[] encode = new GetTeenagerConfigRequest(stringExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetTeenagerConfigRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }

    private String getAppIdString(List<String> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < list.size() - 1; i3++) {
                sb5.append(list.get(i3));
                sb5.append(",");
            }
            sb5.append(list.get(list.size() - 1));
            return sb5.toString();
        }
        QLog.e(TAG, 1, "remote appId whiteList is empty.");
        return "";
    }
}
