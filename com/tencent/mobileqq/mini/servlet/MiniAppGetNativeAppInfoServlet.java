package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetNAppForJumpRsp;
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
public class MiniAppGetNativeAppInfoServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_APP_NAME = "key_app_id";
    public static final String KEY_DOWNLOAD_URL = "key_download_url";
    public static final String KEY_ERR_MSG = "err_msg";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_NATIVE_APP_ID = "key_native_app_id";
    public static final String KEY_ONLY_OPEN = "key_only_open";
    public static final String KEY_PACKAGE_NAME = "key_package_name";
    public static final String KEY_RET_CODE = "ret_code";
    public static final String KEY_SCENE = "key_scene";
    public static final String TAG = "MiniAppGetAppInfoByIdServlet";

    public MiniAppGetNativeAppInfoServlet() {
        this.observerId = 1030;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        PBStringField pBStringField;
        INTERFACE$StGetNAppForJumpRsp iNTERFACE$StGetNAppForJumpRsp = new INTERFACE$StGetNAppForJumpRsp();
        iNTERFACE$StGetNAppForJumpRsp.mergeFrom(bArr);
        if (iNTERFACE$StGetNAppForJumpRsp.appName != null && iNTERFACE$StGetNAppForJumpRsp.native_appid != null && (pBStringField = iNTERFACE$StGetNAppForJumpRsp.android_pkg) != null) {
            bundle.putString(KEY_PACKAGE_NAME, pBStringField.get());
            bundle.putString("key_app_id", iNTERFACE$StGetNAppForJumpRsp.appName.get());
            bundle.putString(KEY_NATIVE_APP_ID, iNTERFACE$StGetNAppForJumpRsp.native_appid.get());
            bundle.putInt(KEY_ONLY_OPEN, iNTERFACE$StGetNAppForJumpRsp.onlyOpen.get());
            bundle.putString(KEY_DOWNLOAD_URL, iNTERFACE$StGetNAppForJumpRsp.android_donwload_url.get());
            notifyObserver(intent, 1030, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1030, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        String stringExtra = intent.getStringExtra("key_app_id");
        String stringExtra2 = intent.getStringExtra(KEY_NATIVE_APP_ID);
        String stringExtra3 = intent.getStringExtra(KEY_PACKAGE_NAME);
        int intExtra = intent.getIntExtra("key_scene", -1);
        int intExtra2 = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
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
        byte[] encode = new GetNativeAppInfoRequest(stCommonExt, stringExtra, stringExtra2, stringExtra3, intExtra).encode(intent, intExtra2, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetNativeAppInfoRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
