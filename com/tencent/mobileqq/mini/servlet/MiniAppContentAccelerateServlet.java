package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StContentAccelerateRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.app.PreCacheManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppContentAccelerateServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_DATA_URL = "key_dataurl";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_NEED_CODE = "key_need_code";
    public static final String KEY_REQ_HEADER = "mini_req_header";
    public static final String KEY_RSP_DATA = "mini_rsp_data";
    public static final String TAG = "MiniAppContentAccelerateServlet";

    public MiniAppContentAccelerateServlet() {
        this.observerId = 1070;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StContentAccelerateRsp iNTERFACE$StContentAccelerateRsp = new INTERFACE$StContentAccelerateRsp();
        iNTERFACE$StContentAccelerateRsp.mergeFrom(bArr);
        if (iNTERFACE$StContentAccelerateRsp.cacheData.get() != null && iNTERFACE$StContentAccelerateRsp.cacheData.get().size() > 0) {
            PreCacheManager.ContentAccelerateRsp contentAccelerateRsp = new PreCacheManager.ContentAccelerateRsp();
            contentAccelerateRsp.rspHeaders = iNTERFACE$StContentAccelerateRsp.rspHeaders.get();
            contentAccelerateRsp.cacheData = iNTERFACE$StContentAccelerateRsp.cacheData.get().toByteArray();
            contentAccelerateRsp.httpReturnCode = iNTERFACE$StContentAccelerateRsp.httpReturnCode.get();
            bundle.putParcelable(KEY_RSP_DATA, contentAccelerateRsp);
            notifyObserver(intent, 1070, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1070, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        String stringExtra = intent.getStringExtra("key_app_id");
        String stringExtra2 = intent.getStringExtra(KEY_DATA_URL);
        int intExtra = intent.getIntExtra(KEY_NEED_CODE, 0);
        Map map = (Map) intent.getSerializableExtra(KEY_REQ_HEADER);
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
        byte[] encode = new ContentAccelerateRequest(stCommonExt, stringExtra, stringExtra2, intExtra, map).encode(intent, intExtra2, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand("LightAppSvc.mini_accelerate_proxy.ContentAccelerate");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
