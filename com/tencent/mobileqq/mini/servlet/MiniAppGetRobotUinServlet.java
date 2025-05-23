package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetRobotUinRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetRobotUinServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_COMMON_EXT = "key_common_ext";
    public static final String KEY_ROBOT_RESULT_UIN = "key_robot_result_uin";
    private static final String TAG = "MiniAppGetRobotUinServlet";

    public MiniAppGetRobotUinServlet() {
        this.observerId = 1045;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetRobotUinRsp iNTERFACE$StGetRobotUinRsp = new INTERFACE$StGetRobotUinRsp();
        iNTERFACE$StGetRobotUinRsp.mergeFrom(bArr);
        String str = iNTERFACE$StGetRobotUinRsp.uin.get();
        if (str != null) {
            bundle.putString(KEY_ROBOT_RESULT_UIN, str);
            notifyObserver(intent, 1045, true, bundle, MiniAppObserver.class);
        } else {
            notifyObserver(intent, 1045, false, bundle, MiniAppObserver.class);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_common_ext");
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onSend. StCommonExt mergeFrom exception!", th5);
            }
        } else {
            stCommonExt = null;
        }
        byte[] encode = new GetRobotUinRequest(stCommonExt, intent.getStringExtra("key_app_id")).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetRobotUinRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
