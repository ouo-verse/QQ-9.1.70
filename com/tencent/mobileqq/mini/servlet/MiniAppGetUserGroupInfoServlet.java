package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserGroupInfoRsp;
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
public class MiniAppGetUserGroupInfoServlet extends MiniAppAbstractServlet {
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_EXTRA_JSON_DATA = "extra_json_data";
    public static final String KEY_GROUP_CLASS = "group_class";
    public static final String KEY_GROUP_ID = "group_id";
    public static final String TAG = "MiniAppGetUserGroupInfoServlet";

    public MiniAppGetUserGroupInfoServlet() {
        this.observerId = 1062;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetUserGroupInfoRsp iNTERFACE$StGetUserGroupInfoRsp = new INTERFACE$StGetUserGroupInfoRsp();
        if (bArr != null) {
            iNTERFACE$StGetUserGroupInfoRsp.mergeFrom(bArr);
            PBStringField pBStringField = iNTERFACE$StGetUserGroupInfoRsp.userGroupInfo;
            if (pBStringField != null) {
                bundle.putString(KEY_EXTRA_JSON_DATA, pBStringField.get());
                notifyObserver(intent, 1062, true, bundle, MiniAppObserver.class);
            } else {
                notifyObserver(intent, 1062, false, bundle, MiniAppObserver.class);
            }
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        String stringExtra = intent.getStringExtra("key_appid");
        String stringExtra2 = intent.getStringExtra("group_id");
        long longExtra = intent.getLongExtra("group_class", -1L);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        if (byteArrayExtra != null) {
            COMM.StCommonExt stCommonExt2 = new COMM.StCommonExt();
            try {
                stCommonExt2.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom extData exception!");
                }
            }
            stCommonExt = stCommonExt2;
        } else {
            stCommonExt = null;
        }
        byte[] encode = new GetUserGroupInfoRequest(stringExtra, stringExtra2, longExtra, stCommonExt).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetUserGroupInfoRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
