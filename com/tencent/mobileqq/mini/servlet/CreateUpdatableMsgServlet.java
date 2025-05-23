package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CreateUpdatableMsgServlet extends MiniAppAbstractServlet {
    public static final String KEY_FROM = "key_from";
    public static final String KEY_SCENE = "key_scene";
    public static final String KEY_SERVICE_TYPE = "key_service_type";
    public static final String KEY_SIG = "key_sig";
    public static final String KEY_SUB_SCENE = "key_sub_scene";
    public static final String KEY_TEMPLATE_ID = "key_template_id";
    public static final String KEY_UIN = "key_uin";
    public static final String TAG = "[mini] CreateUpdatableMsgServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                if (fromServiceMsg.isSuccess()) {
                    PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                    stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                    long j3 = stQWebRsp.retCode.get();
                    String stringUtf8 = stQWebRsp.errMsg.get().toStringUtf8();
                    bundle.putLong("retCode", j3);
                    bundle.putString("errMsg", stringUtf8);
                    notifyObserver(intent, MiniAppObserver.MINI_APP_CREATE_UPDATABLE_MSG, j3 == 0, bundle, MiniAppObserver.class);
                } else {
                    bundle.putLong("retCode", fromServiceMsg.getBusinessFailCode());
                    bundle.putString("errMsg", fromServiceMsg.getBusinessFailMsg());
                    QLog.e(TAG, 2, "inform CreateUpdatableMsgServlet isSuccess false");
                    notifyObserver(intent, MiniAppObserver.MINI_APP_CREATE_UPDATABLE_MSG, false, bundle, MiniAppObserver.class);
                }
            } else {
                QLog.e(TAG, 2, "inform CreateUpdatableMsgServlet resultcode fail.");
                notifyObserver(intent, MiniAppObserver.MINI_APP_CREATE_UPDATABLE_MSG, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "onReceive exception:" + th5);
            notifyObserver(null, MiniAppObserver.MINI_APP_CREATE_UPDATABLE_MSG, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] encode = new CreateUpdatableMsgRequest(intent.getStringExtra("key_appid"), intent.getStringExtra(KEY_TEMPLATE_ID), intent.getIntExtra("key_from", -1), intent.getIntExtra("key_scene", -1), intent.getIntExtra(KEY_SUB_SCENE, -1), intent.getStringExtra("key_uin"), intent.getIntExtra(KEY_SERVICE_TYPE, 0), intent.getByteArrayExtra(KEY_SIG)).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CreateUpdatableMsgRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
