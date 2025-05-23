package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StInteractiveTemplate;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ModifyFriendInteractiveStorageServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_INTERACTIVE_TEMPLATE = "key_interactive_template";
    public static final String KEY_OPERATION = "key_operation";
    public static final String KEY_OPNUM = "key_opnum";
    public static final String KEY_QUIET = "key_quiet";
    public static final String KEY_SHARE_ID = "KEY_SHARE_ID";
    public static final String KEY_TO_USER = "key_to_user";
    public static final String TAG = "ModifyFriendInteractiveStorageServlet";
    private int index;

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReceive.");
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                if (fromServiceMsg.isSuccess()) {
                    bundle.putParcelable("modifyFriendInteractiveStorage", fromServiceMsg);
                    bundle.putLong("retCode", stQWebRsp.retCode.get());
                    bundle.putString("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
                    notifyObserver(intent, 1058, true, bundle, MiniAppObserver.class);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onReceive. MiniRewardedVideoAdServlet rsp = " + stQWebRsp);
                    }
                    notifyObserver(intent, 1058, false, bundle, MiniAppObserver.class);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive. inform MiniRewardedVideoAdServlet resultcode fail.");
                }
                notifyObserver(intent, 1058, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + "onReceive error");
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, this.index);
            notifyObserver(intent, 1058, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        this.index = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        String stringExtra = intent.getStringExtra(KEY_TO_USER);
        String stringExtra2 = intent.getStringExtra(KEY_SHARE_ID);
        String stringExtra3 = intent.getStringExtra("key_appid");
        int intExtra = intent.getIntExtra(KEY_OPNUM, -1);
        String stringExtra4 = intent.getStringExtra(KEY_OPERATION);
        HashMap hashMap = (HashMap) intent.getSerializableExtra("key_data");
        CloudStorage$StInteractiveTemplate cloudStorage$StInteractiveTemplate = null;
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom extData exception!");
                }
                e16.printStackTrace();
            }
        } else {
            stCommonExt = null;
        }
        boolean booleanExtra = intent.getBooleanExtra(KEY_QUIET, false);
        byte[] byteArrayExtra2 = intent.getByteArrayExtra(KEY_INTERACTIVE_TEMPLATE);
        if (byteArrayExtra2 != null) {
            cloudStorage$StInteractiveTemplate = new CloudStorage$StInteractiveTemplate();
            try {
                cloudStorage$StInteractiveTemplate.mergeFrom(byteArrayExtra2);
            } catch (InvalidProtocolBufferMicroException e17) {
                QLog.e(TAG, 2, "onSend. mergeFrom interactiveTemplateBytes exception!", e17);
            }
        }
        byte[] encode = new ModifyFriendInteractiveStorageReq(stCommonExt, stringExtra3, stringExtra, stringExtra2, intExtra, stringExtra4, hashMap, booleanExtra, cloudStorage$StInteractiveTemplate).encode(intent, this.index, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(ModifyFriendInteractiveStorageReq.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
