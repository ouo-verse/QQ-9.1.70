package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAppTopRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSetUserAppTopServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_EXTENDINFO = "key_extendinfo";
    public static final String KEY_FROM_NEW_DOWNLOAD = "key_from_new_download";
    public static final String KEY_NEW_INDEX = "key_new_index";
    public static final String KEY_OLD_INDEX = "key_old_index";
    public static final String KEY_TOP_TYPE = "key_top_type";
    public static final String KEY_VERSION_TYPE = "key_version_type";
    public static final String TAG = "MiniAppSetUserAppTopServlet";

    public MiniAppSetUserAppTopServlet() {
        this.observerId = 1007;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        COMM.StCommonExt stCommonExt;
        INTERFACE$StSetUserAppTopRsp iNTERFACE$StSetUserAppTopRsp = new INTERFACE$StSetUserAppTopRsp();
        iNTERFACE$StSetUserAppTopRsp.mergeFrom(bArr);
        long j3 = bundle.getLong("retCode");
        String string = bundle.getString("errMsg");
        if (j3 == 0 && (stCommonExt = iNTERFACE$StSetUserAppTopRsp.extInfo) != null) {
            bundle.putByteArray("key_extendinfo", stCommonExt.toByteArray());
            notifyObserver(intent, 1007, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1007, false, bundle, MiniAppObserver.class);
        QLog.e(TAG, 1, "MiniAppSetUserAppTopServlet retCode : " + j3 + "; errMsg : " + string);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        String stringExtra = intent.getStringExtra("key_appid");
        int intExtra = intent.getIntExtra(KEY_TOP_TYPE, 0);
        int intExtra2 = intent.getIntExtra("key_version_type", 3);
        int intExtra3 = intent.getIntExtra(KEY_OLD_INDEX, 0);
        int intExtra4 = intent.getIntExtra(KEY_NEW_INDEX, 0);
        int intExtra5 = intent.getIntExtra(KEY_FROM_NEW_DOWNLOAD, 0);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        int intExtra6 = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
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
        byte[] encode = new SetUserAppTopRequest(stCommonExt, stringExtra, intExtra, intExtra2, intExtra3, intExtra4, intExtra5).encode(intent, intExtra6, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand("LightAppSvc.mini_app_userapp.SetUserAppTop");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSend. intent: " + intent.toString());
        }
        super.onSend(intent, packet);
    }
}
