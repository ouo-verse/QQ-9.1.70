package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAppLikeRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSetUserAppLikeServlet extends MiniAppAbstractServlet {
    public static final String KEY_DO_LIKE = "do_like";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_EXTENDINFO = "key_extendinfo";
    public static final String KEY_MINI_APPID = "key_mini_appid";
    public static final String TAG = "MiniAppSetUserAppLikeServlet";

    public MiniAppSetUserAppLikeServlet() {
        this.observerId = 1009;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StSetUserAppLikeRsp iNTERFACE$StSetUserAppLikeRsp = new INTERFACE$StSetUserAppLikeRsp();
        iNTERFACE$StSetUserAppLikeRsp.mergeFrom(bArr);
        COMM.StCommonExt stCommonExt = iNTERFACE$StSetUserAppLikeRsp.extInfo;
        if (stCommonExt != null) {
            bundle.putByteArray("key_extendinfo", stCommonExt.toByteArray());
            notifyObserver(intent, 1009, true, bundle, MiniAppObserver.class);
        } else {
            notifyObserver(intent, 1009, false, bundle, MiniAppObserver.class);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        String stringExtra = intent.getStringExtra("key_mini_appid");
        int intExtra = intent.getIntExtra(KEY_DO_LIKE, 0);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        int intExtra2 = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
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
        byte[] encode = new SetUserAppLikeRequest(stCommonExt, stringExtra, intExtra).encode(intent, intExtra2, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand("LightAppSvc.mini_app_userapp.SetUserAppLike");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSend. intent: " + intent.toString());
        }
        super.onSend(intent, packet);
    }
}
