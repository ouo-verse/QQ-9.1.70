package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetHotSearchAppsServlet extends MiniAppAbstractServlet {
    public static final String KEY_EXT_INFO = "key_hot_search_ext_info";
    public static final String KEY_GET_HOT_SEARCH_APPS = "getHotSearchApps";
    public static final String KEY_GET_HOT_SEARCH_APPS_RSP = "getHotSearchAppsResponse";
    public static final String TAG = "MiniAppGetHotSearchAppsServlet";

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
                    bundle.putLong("retCode", stQWebRsp.retCode.get());
                    bundle.putString("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
                    bundle.putParcelable(KEY_GET_HOT_SEARCH_APPS, fromServiceMsg);
                    notifyObserver(intent, 1071, true, bundle, MiniAppObserver.class);
                } else {
                    bundle.putLong("retCode", fromServiceMsg.getBusinessFailCode());
                    bundle.putString("errMsg", fromServiceMsg.getBusinessFailMsg());
                    notifyObserver(intent, 1071, false, bundle, MiniAppObserver.class);
                }
            } else {
                QLog.e(TAG, 1, "onReceive. inform MiniAppGetHotSearchAppsServlet response is null.");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + ", onReceive exception: " + Log.getStackTraceString(th5));
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_hot_search_ext_info");
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (Exception e16) {
                QLog.e(TAG, 2, "onSend. mergeFrom exception!" + Log.getStackTraceString(e16));
            }
        } else {
            stCommonExt = null;
        }
        byte[] encode = new GetHotSearchAppsRequest(stCommonExt).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetHotSearchAppsRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
