package com.tencent.mobileqq.wxmini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetTeenagerConfigRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.GetTeenagerConfigRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d extends c {
    public d() {
        this.f327817d = 1093;
    }

    @Override // com.tencent.mobileqq.wxmini.servlet.c
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetTeenagerConfigRsp iNTERFACE$StGetTeenagerConfigRsp = new INTERFACE$StGetTeenagerConfigRsp();
        iNTERFACE$StGetTeenagerConfigRsp.mergeFrom(bArr);
        if (iNTERFACE$StGetTeenagerConfigRsp.appIDs != null && iNTERFACE$StGetTeenagerConfigRsp.frequencySwitch != null && iNTERFACE$StGetTeenagerConfigRsp.timeInterval != null && iNTERFACE$StGetTeenagerConfigRsp.extInfo != null) {
            QLog.d("WxAppGetTeenagerConfigServlet", 1, "MiniAppGetTeenagerConfigServlet frequencySwitch : " + iNTERFACE$StGetTeenagerConfigRsp.frequencySwitch + "; timeInterval : " + iNTERFACE$StGetTeenagerConfigRsp.timeInterval);
            bundle.putString(MiniAppGetTeenagerConfigServlet.KEY_APPID_LIST, getAppIdString(iNTERFACE$StGetTeenagerConfigRsp.appIDs.get()));
            bundle.putInt(MiniAppGetTeenagerConfigServlet.KEY_FREQUENCY_SWITCH, iNTERFACE$StGetTeenagerConfigRsp.frequencySwitch.get());
            bundle.putInt(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, iNTERFACE$StGetTeenagerConfigRsp.timeInterval.get());
            notifyObserver(intent, this.f327817d, true, bundle, WxMiniAppObserver.class);
            return;
        }
        notifyObserver(intent, this.f327817d, false, bundle, WxMiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.wxmini.servlet.c, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra(MiniAppGetTeenagerConfigServlet.KEY_REQUEST_EXT_INFO);
        byte[] a16 = new a(stringExtra).a(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (a16 == null) {
            a16 = new byte[4];
        }
        packet.setSSOCommand(GetTeenagerConfigRequest.CMD_STRING);
        packet.putSendData(fh.b(a16));
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
        QLog.e("WxAppGetTeenagerConfigServlet", 1, "remote appId whiteList is empty.");
        return "";
    }
}
