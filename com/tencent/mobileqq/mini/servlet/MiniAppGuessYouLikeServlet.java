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
public class MiniAppGuessYouLikeServlet extends MiniAppAbstractServlet {
    public static final int DEFAULT_COUNT = 8;
    public static final String KEY_EXT_INFO = "key_search_guess_you_like_ext_info";
    public static final String KEY_SEARCH_GUESS_YOU_LIKE = "searchGuessYouLike";
    public static final String KEY_SEARCH_GUESS_YOU_LIKE_COUNT = "searchGuessYouLikeCount";
    public static final String KEY_SEARCH_GUESS_YOU_LIKE_RSP = "searchGuessYouLikeResponse";
    public static final String TAG = "MiniAppGuessYouLikeServlet";

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
                    bundle.putParcelable(KEY_SEARCH_GUESS_YOU_LIKE, fromServiceMsg);
                    notifyObserver(intent, 1086, true, bundle, MiniAppObserver.class);
                } else {
                    bundle.putLong("retCode", fromServiceMsg.getBusinessFailCode());
                    bundle.putString("errMsg", fromServiceMsg.getBusinessFailMsg());
                    notifyObserver(intent, 1086, false, bundle, MiniAppObserver.class);
                }
            } else {
                QLog.e(TAG, 1, "onReceive. inform MiniAppGuessYouLikeServlet response is null.");
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
        byte[] byteArrayExtra = intent.getByteArrayExtra(KEY_EXT_INFO);
        int intExtra2 = intent.getIntExtra(KEY_SEARCH_GUESS_YOU_LIKE_COUNT, 8);
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
        byte[] encode = new GuessYouLikeRequest(stCommonExt, intExtra2).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GuessYouLikeRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
