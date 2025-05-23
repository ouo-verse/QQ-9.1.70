package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByLinkRsp;
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
public class MiniAppGetAppInfoByLinkForSDKServlet extends MiniAppAbstractServlet {
    public static final String TAG = "[mini] MiniAppGetAppInfoByLinkForSDKServlet";

    public MiniAppGetAppInfoByLinkForSDKServlet() {
        this.observerId = 1056;
    }

    private void savaMiniAppInfo(final Intent intent, final INTERFACE$StGetAppInfoByLinkRsp iNTERFACE$StGetAppInfoByLinkRsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByLinkForSDKServlet.1
            @Override // java.lang.Runnable
            public void run() {
                String stringExtra = intent.getStringExtra(MiniAppAbstractServlet.KEY_LINK);
                int intExtra = intent.getIntExtra(MiniAppAbstractServlet.KEY_LINK_TYPE, 0);
                MiniAppInfo.saveMiniAppByLinkEntity(stringExtra, intExtra, iNTERFACE$StGetAppInfoByLinkRsp.shareTicket.get(), iNTERFACE$StGetAppInfoByLinkRsp.appInfo);
                MiniAppInfo.saveMiniAppInfoEntity(iNTERFACE$StGetAppInfoByLinkRsp.appInfo);
                MiniAppInfo.saveMiniAppShowInfoEntity(iNTERFACE$StGetAppInfoByLinkRsp.appInfo);
                MiniAppInfo.saveMiniAppByAppInfoLinkEntity(stringExtra, intExtra, iNTERFACE$StGetAppInfoByLinkRsp.shareTicket.get(), iNTERFACE$StGetAppInfoByLinkRsp.appInfo);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetAppInfoByLinkRsp iNTERFACE$StGetAppInfoByLinkRsp = new INTERFACE$StGetAppInfoByLinkRsp();
        iNTERFACE$StGetAppInfoByLinkRsp.mergeFrom(bArr);
        INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = iNTERFACE$StGetAppInfoByLinkRsp.appInfo;
        if (iNTERFACE$StApiAppInfo != null) {
            if (iNTERFACE$StApiAppInfo.type.get() == 3) {
                savaMiniAppInfo(intent, iNTERFACE$StGetAppInfoByLinkRsp);
            }
            com.tencent.qqmini.sdk.launcher.model.MiniAppInfo from = com.tencent.qqmini.sdk.launcher.model.MiniAppInfo.from(iNTERFACE$StGetAppInfoByLinkRsp.appInfo);
            String str = iNTERFACE$StGetAppInfoByLinkRsp.shareTicket.get();
            bundle.putParcelable("mini_app_info_data", from);
            bundle.putString("shareTicket", str);
            QLog.i(TAG, 1, "[MiniEng]" + from.downloadUrl + "," + from.fileSize);
            notifyObserver(intent, this.observerId, true, bundle, MiniAppObserver.class);
            return;
        }
        QLog.i(TAG, 1, "[MiniEng]inform MiniAppGetAppInfoByLinkServlet result.appInfo==null");
        notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra(MiniAppAbstractServlet.KEY_LINK);
        int intExtra = intent.getIntExtra(MiniAppAbstractServlet.KEY_LINK_TYPE, 0);
        intent.getLongExtra("key_uin", 0L);
        byte[] encode = new GetAppInfoByLinkRequest(stringExtra, intExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetAppInfoByLinkRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
