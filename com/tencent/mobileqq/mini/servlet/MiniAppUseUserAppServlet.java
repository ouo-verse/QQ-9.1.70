package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StUseUserAppRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppUseUserAppServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_RECOMMEND = "key_recommend";
    public static final String KEY_REFER = "key_refer";
    public static final String KEY_SOURCE = "key_source";
    public static final String KEY_VERSION_TYPE = "key_version_type";
    public static final String KEY_VIA = "key_via";
    public static final String TAG = "MiniAppUseUserAppServlet";

    public MiniAppUseUserAppServlet() {
        this.observerId = 1014;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StUseUserAppRsp iNTERFACE$StUseUserAppRsp = new INTERFACE$StUseUserAppRsp();
        iNTERFACE$StUseUserAppRsp.mergeFrom(bArr);
        COMM.StCommonExt stCommonExt = iNTERFACE$StUseUserAppRsp.extInfo;
        if (stCommonExt != null) {
            bundle.putByteArray("key_ext", stCommonExt.toByteArray());
            if (!iNTERFACE$StUseUserAppRsp.recommendModule.isEmpty()) {
                bundle.putByteArray(KEY_RECOMMEND, bArr);
            }
            notifyObserver(intent, 1014, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1014, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        String stringExtra = intent.getStringExtra("key_appid");
        int intExtra = intent.getIntExtra("key_version_type", 3);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        int intExtra2 = intent.getIntExtra("key_source", 1);
        String stringExtra2 = intent.getStringExtra("key_refer");
        String stringExtra3 = intent.getStringExtra("key_via");
        int intExtra3 = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
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
        byte[] encode = new UseUserAppRequest(stCommonExt, stringExtra, intExtra, intExtra2, stringExtra2, stringExtra3).encode(intent, intExtra3, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand("LightAppSvc.mini_app_userapp.UseUserApp");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSend. intent: " + intent.toString());
        }
        super.onSend(intent, packet);
    }
}
