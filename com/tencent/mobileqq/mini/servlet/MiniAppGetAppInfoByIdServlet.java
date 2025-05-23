package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByIdRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetAppInfoByIdServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_APP_INFO_DATA = "mini_app_info_data";
    public static final String KEY_APP_INFO_PB_DATA = "mini_app_info_pb_data";
    public static final String KEY_ENV_VERSION = "key_env_version";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_FIRST_PATH = "key_first_path";
    public static final String KEY_FROM_APP_ID = "key_from_app_id";
    public static final int NO_REQUIRED = 0;
    public static final int REQUIRED = 1;
    public static final String TAG = "MiniAppGetAppInfoByIdServlet";

    public MiniAppGetAppInfoByIdServlet() {
        this.observerId = 1024;
    }

    private void savaMiniAppInfo(final Intent intent, final INTERFACE$StGetAppInfoByIdRsp iNTERFACE$StGetAppInfoByIdRsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByIdServlet.1
            @Override // java.lang.Runnable
            public void run() {
                String stringExtra = intent.getStringExtra("key_first_path");
                MiniAppInfo.saveMiniAppByIdEntity(stringExtra, iNTERFACE$StGetAppInfoByIdRsp.appInfo);
                MiniAppInfo.saveMiniAppInfoEntity(iNTERFACE$StGetAppInfoByIdRsp.appInfo);
                MiniAppInfo.saveMiniAppShowInfoEntity(iNTERFACE$StGetAppInfoByIdRsp.appInfo);
                MiniAppInfo.saveMiniAppInfoByIdEntity(stringExtra, iNTERFACE$StGetAppInfoByIdRsp.appInfo);
            }
        }, 32, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [byte[], java.io.Serializable] */
    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetAppInfoByIdRsp iNTERFACE$StGetAppInfoByIdRsp = new INTERFACE$StGetAppInfoByIdRsp();
        iNTERFACE$StGetAppInfoByIdRsp.mergeFrom(bArr);
        INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = iNTERFACE$StGetAppInfoByIdRsp.appInfo;
        if (iNTERFACE$StApiAppInfo != null) {
            if (iNTERFACE$StApiAppInfo.type.get() == 3) {
                savaMiniAppInfo(intent, iNTERFACE$StGetAppInfoByIdRsp);
            }
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo2 = iNTERFACE$StGetAppInfoByIdRsp.appInfo;
            bundle.putSerializable("mini_app_info_data", MiniAppInfo.from(iNTERFACE$StApiAppInfo2));
            bundle.putSerializable("mini_app_info_pb_data", iNTERFACE$StApiAppInfo2.toByteArray());
            notifyObserver(intent, 1024, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1024, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        String stringExtra = intent.getStringExtra("key_app_id");
        String stringExtra2 = intent.getStringExtra("key_first_path");
        String stringExtra3 = intent.getStringExtra("key_env_version");
        String stringExtra4 = intent.getStringExtra("key_from_app_id");
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        String str = stringExtra2 == null ? "" : stringExtra2;
        String str2 = stringExtra3 == null ? "" : stringExtra3;
        if (byteArrayExtra != null) {
            COMM.StCommonExt stCommonExt2 = new COMM.StCommonExt();
            try {
                stCommonExt2.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("MiniAppGetAppInfoByIdServlet", 2, "onSend. mergeFrom exception!");
                }
                e16.printStackTrace();
            }
            stCommonExt = stCommonExt2;
        } else {
            stCommonExt = null;
        }
        byte[] encode = new GetAppInfoByIdRequest(stCommonExt, stringExtra, 1, 0, str, str2, stringExtra4).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetAppInfoByIdRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
