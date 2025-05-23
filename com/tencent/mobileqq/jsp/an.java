package com.tencent.mobileqq.jsp;

import NS_MOBILE_EXTRA.mobile_get_urlinfo_rsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.publish.business.protocol.QZoneGetUrlInfoRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.ProtocolUtils;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class an extends MSFServlet {
    static IPatchRedirector $redirector_;

    public an() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("WebShareServlet", 2, "onReceive, cmd=" + serviceCmd);
        }
        if ("SQQzoneSvc.getUrlInfo".equals(serviceCmd)) {
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            Bundle bundle = new Bundle();
            JceStruct decode = ProtocolUtils.decode(wupBuffer, QZoneGetUrlInfoRequest.CMD_STRING);
            if (fromServiceMsg.isSuccess() && (decode instanceof mobile_get_urlinfo_rsp)) {
                mobile_get_urlinfo_rsp mobile_get_urlinfo_rspVar = (mobile_get_urlinfo_rsp) decode;
                if (QLog.isColorLevel()) {
                    QLog.d("WebShareServlet", 2, "onReceive, mobile_get_urlinfo_rsp, ret=" + mobile_get_urlinfo_rspVar.ret + ", title=" + mobile_get_urlinfo_rspVar.title + ", summary=" + mobile_get_urlinfo_rspVar.summary + ", images=" + mobile_get_urlinfo_rspVar.images);
                }
                bundle.putInt("extra_ret", mobile_get_urlinfo_rspVar.ret);
                bundle.putString("extra_title", mobile_get_urlinfo_rspVar.title);
                bundle.putString("extra_summary", mobile_get_urlinfo_rspVar.summary);
                bundle.putStringArrayList("extra_images", mobile_get_urlinfo_rspVar.images);
            }
            notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        String stringExtra = intent.getStringExtra(WadlProxyConsts.EXTRA_CMD);
        if (QLog.isColorLevel()) {
            QLog.d("WebShareServlet", 2, "onSend, cmd=" + stringExtra);
        }
        if ("SQQzoneSvc.getUrlInfo".equals(stringExtra)) {
            String stringExtra2 = intent.getStringExtra("extra_url");
            if (QLog.isColorLevel()) {
                QLog.d("WebShareServlet", 2, "onSend, CMD_GET_URL_INFO, url=" + stringExtra2);
            }
            if (!TextUtils.isEmpty(stringExtra2)) {
                byte[] encode = new z(stringExtra2).encode();
                packet.setSSOCommand("SQQzoneSvc.getUrlInfo");
                packet.putSendData(encode);
            } else if (QLog.isColorLevel()) {
                QLog.e("WebShareServlet", 2, "onSend, url is null!!!");
            }
        }
    }
}
