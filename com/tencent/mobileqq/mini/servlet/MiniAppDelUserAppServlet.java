package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StDelUserAppRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppDelUserAppServlet extends MiniAppAbstractServlet {
    public static final String KET_IS_RECOMMEND = "key_is_recommend";
    public static final String KET_NOT_DELTOP = "key_NoDelTop";
    public static final String KET_SOURCE_TYPE = "key_source_type";
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_EXTENDINFO = "key_extendinfo";
    public static final String KEY_VERSION_TYPE = "key_version_type";
    public static final String TAG = "MiniAppDelUserAppServlet";

    public MiniAppDelUserAppServlet() {
        this.observerId = 1006;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StDelUserAppRsp iNTERFACE$StDelUserAppRsp = new INTERFACE$StDelUserAppRsp();
        iNTERFACE$StDelUserAppRsp.mergeFrom(bArr);
        COMM.StCommonExt stCommonExt = iNTERFACE$StDelUserAppRsp.extInfo;
        if (stCommonExt != null) {
            bundle.putByteArray("key_extendinfo", stCommonExt.toByteArray());
            notifyObserver(intent, 1006, true, bundle, MiniAppObserver.class);
        } else {
            notifyObserver(intent, 1006, false, bundle, MiniAppObserver.class);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        String stringExtra = intent.getStringExtra("key_appid");
        int intExtra = intent.getIntExtra("key_version_type", 3);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        int intExtra2 = intent.getIntExtra(KET_IS_RECOMMEND, 0);
        int intExtra3 = intent.getIntExtra(KET_SOURCE_TYPE, 1);
        int intExtra4 = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        int intExtra5 = intent.getIntExtra(KET_NOT_DELTOP, 0);
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
        byte[] encode = new DelUserAppRequest(stCommonExt, stringExtra, intExtra, intExtra2, intExtra3, intExtra5).encode(intent, intExtra4, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(DelUserAppRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
