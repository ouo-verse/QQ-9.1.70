package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserInfoExtraRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetUserInfoExtraServlet extends MiniAppAbstractServlet {
    public static final String KEY_ERR_MSG = "err_msg";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_RET_CODE = "ret_code";
    public static final String KEY_RET_ENCRYPT_DATA = "ret_encrypt_data";
    public static final String KEY_RET_IV = "ret_iv";
    public static final String TAG = "MiniAppGetUserInfoExtraServlet";

    public MiniAppGetUserInfoExtraServlet() {
        this.observerId = 1032;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetUserInfoExtraRsp iNTERFACE$StGetUserInfoExtraRsp = new INTERFACE$StGetUserInfoExtraRsp();
        iNTERFACE$StGetUserInfoExtraRsp.mergeFrom(bArr);
        PBStringField pBStringField = iNTERFACE$StGetUserInfoExtraRsp.encryptedData;
        if (pBStringField != null) {
            bundle.putString(KEY_RET_ENCRYPT_DATA, pBStringField.get());
            bundle.putString(KEY_RET_IV, iNTERFACE$StGetUserInfoExtraRsp.f24963iv.get());
            notifyObserver(intent, 1032, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1032, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        String stringExtra = intent.getStringExtra("key_appid");
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
        byte[] encode = new GetUserInfoExtraRequest(stCommonExt, stringExtra).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetUserInfoExtraRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
