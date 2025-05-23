package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserHealthDataRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppUserHealthDataServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_CLOID_ID = "key_clouldId";
    public static final String KEY_ENCRYPTED_DATA = "key_encrypted_data";
    public static final String KEY_EXT_INFO = "key_ext_info";
    public static final String KEY_RET_IV = "key_ret_iv";
    public static final String TAG = "MiniAppUserHealthDataServlet";

    public MiniAppUserHealthDataServlet() {
        this.observerId = 1041;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetUserHealthDataRsp iNTERFACE$StGetUserHealthDataRsp = new INTERFACE$StGetUserHealthDataRsp();
        iNTERFACE$StGetUserHealthDataRsp.mergeFrom(bArr);
        if (iNTERFACE$StGetUserHealthDataRsp.encryptedData != null) {
            bundle.putString("key_app_id", iNTERFACE$StGetUserHealthDataRsp.appid.get());
            bundle.putByteArray("key_ext_info", iNTERFACE$StGetUserHealthDataRsp.extInfo.toByteArray());
            bundle.putString(KEY_ENCRYPTED_DATA, iNTERFACE$StGetUserHealthDataRsp.encryptedData.get());
            bundle.putString(KEY_RET_IV, iNTERFACE$StGetUserHealthDataRsp.f24962iv.get());
            bundle.putString(KEY_CLOID_ID, iNTERFACE$StGetUserHealthDataRsp.cloudID.get());
            notifyObserver(intent, 1041, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1041, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        String stringExtra = intent.getStringExtra("key_app_id");
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext_info");
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom exception!");
                }
                e16.printStackTrace();
            }
        } else {
            stCommonExt = null;
        }
        byte[] encode = new GetUserHealthDataRequest(stCommonExt, stringExtra).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetUserHealthDataRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
