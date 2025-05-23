package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StCheckNavigateRightRsp;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppCheckNavigateRightServlet extends MiniAppAbstractServlet {
    public static final String KEY_ACTION_CODE = "key_action_code";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_NAVIGATE_WORDING = "key_navigate_wording";
    public static final String KEY_SKIP_LOCAL_CHECK = "key_skip_local_check";
    public static final String KEY_TARGET_APP_ID = "target_app_id";
    public static final String TAG = "MiniAppCheckNavigateRightServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            try {
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                INTERFACE$StCheckNavigateRightRsp iNTERFACE$StCheckNavigateRightRsp = new INTERFACE$StCheckNavigateRightRsp();
                iNTERFACE$StCheckNavigateRightRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                int i3 = iNTERFACE$StCheckNavigateRightRsp.actionCode.get();
                int i16 = iNTERFACE$StCheckNavigateRightRsp.skipLocalCheck.get();
                String str = iNTERFACE$StCheckNavigateRightRsp.wording.get();
                bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                bundle.putInt(KEY_ACTION_CODE, i3);
                bundle.putInt(KEY_SKIP_LOCAL_CHECK, i16);
                bundle.putString(KEY_NAVIGATE_WORDING, str);
                COMM.StCommonExt stCommonExt = iNTERFACE$StCheckNavigateRightRsp.extInfo;
                if (stCommonExt != null) {
                    bundle.putByteArray("key_ext", stCommonExt.toByteArray());
                }
                notifyObserver(intent, 1023, true, bundle, MiniAppObserver.class);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                notifyObserver(intent, 1023, false, bundle, MiniAppObserver.class);
            }
        } else {
            notifyObserver(intent, 1023, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_appid");
        String stringExtra2 = intent.getStringExtra(KEY_TARGET_APP_ID);
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        if (byteArrayExtra != null) {
            try {
                new COMM.StCommonExt().mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom exception!");
                }
                e16.printStackTrace();
            }
        }
        byte[] encode = new CheckNavigateRightRequest(stringExtra, stringExtra2).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand("LightAppSvc.mini_app_info.CheckNavigateRight");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
