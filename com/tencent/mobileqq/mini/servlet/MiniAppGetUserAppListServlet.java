package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppListRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetUserAppListServlet extends MiniAppAbstractServlet {
    public static final int GET_USER_APP_LIST = 1;
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_NUM = "key_num";
    public static final String KEY_UIN = "key_uin";
    public static final String TAG = "MiniAppGetUserAppListServlet";

    private void savaMiniAppInfo(final INTERFACE$StGetUserAppListRsp iNTERFACE$StGetUserAppListRsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServlet.1
            @Override // java.lang.Runnable
            public void run() {
                PBRepeatMessageField<INTERFACE$StUserAppInfo> pBRepeatMessageField;
                List<INTERFACE$StUserAppInfo> list;
                INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo;
                INTERFACE$StGetUserAppListRsp iNTERFACE$StGetUserAppListRsp2 = iNTERFACE$StGetUserAppListRsp;
                if (iNTERFACE$StGetUserAppListRsp2 == null || (pBRepeatMessageField = iNTERFACE$StGetUserAppListRsp2.userAppList) == null || (list = pBRepeatMessageField.get()) == null || list.size() <= 0 || !(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
                    return;
                }
                try {
                    for (INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo : list) {
                        if (iNTERFACE$StUserAppInfo != null && (iNTERFACE$StApiAppInfo = iNTERFACE$StUserAppInfo.appInfo.get()) != null && iNTERFACE$StApiAppInfo.type.get() == 3) {
                            MiniAppInfo.saveMiniAppShowInfoEntity(iNTERFACE$StApiAppInfo);
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e("miniapp-db", 1, "save showInfo error,", th5);
                }
            }
        }, 32, null, true);
    }

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
                    bundle.putParcelable("getUserAppList", fromServiceMsg);
                    notifyObserver(intent, 1010, true, bundle, MiniAppObserver.class);
                    INTERFACE$StGetUserAppListRsp iNTERFACE$StGetUserAppListRsp = new INTERFACE$StGetUserAppListRsp();
                    iNTERFACE$StGetUserAppListRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                    savaMiniAppInfo(iNTERFACE$StGetUserAppListRsp);
                } else {
                    bundle.putLong("retCode", fromServiceMsg.getBusinessFailCode());
                    bundle.putString("errMsg", fromServiceMsg.getBusinessFailMsg());
                    notifyObserver(intent, 1010, false, bundle, MiniAppObserver.class);
                }
            } else {
                QLog.e(TAG, 1, "onReceive. inform MiniAppGetUserAppListServlet response is null.");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + ", onReceive exception: " + Log.getStackTraceString(th5));
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        long longExtra = intent.getLongExtra("key_uin", 0L);
        long longExtra2 = intent.getLongExtra("key_num", 10L);
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        if (byteArrayExtra != null) {
            COMM.StCommonExt stCommonExt2 = new COMM.StCommonExt();
            try {
                stCommonExt2.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom exception!");
                }
                e16.printStackTrace();
            }
            stCommonExt = stCommonExt2;
        } else {
            stCommonExt = null;
        }
        byte[] encode = new GetUserAppListRequest(stCommonExt, longExtra, longExtra2).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetUserAppListRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
