package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAvatarRsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* loaded from: classes33.dex */
public class PersonalizeSetAvatarServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_BUSIINFO = "mini_app_busi_info";
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_APP_ITEMID = "mini_app_itemid";
    public static final String KEY_APP_SET_TYPE = "mini_app_settype";
    public static final String KEY_APP_UIN = "key_app_uin";
    public static final String KEY_EXT = "key_ext";
    public static final String TAG = "PersonalizeSetAvatarServlet";

    public PersonalizeSetAvatarServlet() {
        this.observerId = 1034;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        new INTERFACE$StSetUserAvatarRsp().mergeFrom(bArr);
        notifyObserver(intent, 1034, bundle.getLong("retCode") == 0, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        String stringExtra = intent.getStringExtra("key_app_id");
        String stringExtra2 = intent.getStringExtra(KEY_APP_UIN);
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = "self";
        }
        String str = stringExtra2;
        int intExtra = intent.getIntExtra(KEY_APP_SET_TYPE, 0);
        String stringExtra3 = intent.getStringExtra(KEY_APP_ITEMID);
        intent.getStringExtra("key_app_id");
        String stringExtra4 = intent.getStringExtra(KEY_APP_BUSIINFO);
        int intExtra2 = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
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
        byte[] encode = new SetAvatarRequest(stCommonExt, stringExtra, str, intExtra, stringExtra3, stringExtra4).encode(intent, intExtra2, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(SetAvatarRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
