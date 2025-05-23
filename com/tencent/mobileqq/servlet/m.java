package com.tencent.mobileqq.servlet;

import QMF_PROTOCAL.QmfDownstream;
import QzoneCombine.ClientOnlineNotfiyRsp;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.ClientOnlineRequest;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.WNSStream;
import java.io.IOException;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class m extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        long longExtra = intent.getLongExtra("lastPushMsgTime", 0L);
        String stringExtra = intent.getStringExtra("key_uin");
        String string = BaseApplication.getContext().getSharedPreferences("QZoneOnLineServlet", 0).getString("key_attach_info" + stringExtra, "");
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(string);
        if (QLog.isDevelopLevel()) {
            QLog.d("NotifyQZoneServer", 4, "onSend lastPushMsgTime:" + longExtra + ",attachinfo:" + string);
        }
        ClientOnlineRequest clientOnlineRequest = new ClientOnlineRequest(longExtra, hexStr2Bytes);
        byte[] encode = clientOnlineRequest.encode();
        if (encode == null) {
            QLog.e("NotifyQZoneServer", 1, "onSend request encode result is null.cmd=" + clientOnlineRequest.uniKey());
            encode = new byte[4];
        }
        packet.setTimeout(30000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + clientOnlineRequest.uniKey());
        packet.putSendData(encode);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ClientOnlineNotfiyRsp clientOnlineNotfiyRsp;
        if (fromServiceMsg == null) {
            QLog.e("NotifyQZoneServer", 1, "fromServiceMsg==null");
            return;
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            try {
                QmfDownstream unpack = new WNSStream().unpack(fh.a(fromServiceMsg.getWupBuffer()));
                if (unpack == null || (clientOnlineNotfiyRsp = (ClientOnlineNotfiyRsp) common.config.service.d.a(ClientOnlineNotfiyRsp.class, unpack.BusiBuff)) == null) {
                    return;
                }
                byte[] bArr = clientOnlineNotfiyRsp.AttachInfo;
                SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("QZoneOnLineServlet", 0).edit();
                String bytes2HexStr = HexUtil.bytes2HexStr(bArr);
                edit.putString("key_attach_info" + intent.getStringExtra("key_uin"), bytes2HexStr);
                if (QLog.isDevelopLevel()) {
                    QLog.d("NotifyQZoneServer", 4, "onReceive attachinfo:" + bytes2HexStr);
                }
                edit.apply();
                return;
            } catch (IOException e16) {
                QLog.e("NotifyQZoneServer", 1, e16, new Object[0]);
                return;
            }
        }
        QLog.e("NotifyQZoneServer", 1, "onReceive fromServiceMsg.getResultCode():" + fromServiceMsg.getResultCode());
    }
}
