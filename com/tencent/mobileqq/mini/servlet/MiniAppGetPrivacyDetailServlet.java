package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$GetPrivacyInfoResponse;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* loaded from: classes33.dex */
public class MiniAppGetPrivacyDetailServlet extends MiniAppAbstractServlet {
    public static final String BUNDLE_RESULT_CODE = "ret_code";
    public static final String CMD_NAME = "GetPrivacyInfo";
    public static final String CMD_STRING = "LightAppSvc.mini_app_privacy.GetPrivacyInfo";
    private static final int CODE_SHOW_DIALOG = 1;
    public static final String KEY_AUTHORITY_NAME = "authority";
    public static final String KEY_PRIVACY_PRIVACY_TITLE = "title";
    public static final String KEY_PRIVACY_URL = "url";
    public static final String KEY_SERVICE_TERMS_NAME = "service_terms_name";
    public static final String KEY_SERVICE_TERMS_URL = "service_terms_url";
    public static final String KEY_SHOW = "show";
    public static final String REQUEST_KEY_APP_ID = "app_id";
    public static final String REQUEST_KEY_EVENT_NAME = "event_name";
    private static final String TAG = "MiniAppGetPrivacyDetailServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$GetPrivacyInfoResponse iNTERFACE$GetPrivacyInfoResponse = new INTERFACE$GetPrivacyInfoResponse();
        iNTERFACE$GetPrivacyInfoResponse.mergeFrom(bArr);
        QLog.d(TAG, 2, "onProcessData");
        bundle.putString("title", iNTERFACE$GetPrivacyInfoResponse.privacy_info.name.get());
        bundle.putString("url", iNTERFACE$GetPrivacyInfoResponse.privacy_info.url.get());
        bundle.putString(KEY_AUTHORITY_NAME, iNTERFACE$GetPrivacyInfoResponse.privacy_info.authority.get());
        bundle.putString(KEY_SERVICE_TERMS_NAME, iNTERFACE$GetPrivacyInfoResponse.privacy_info.service_terms_name.get());
        bundle.putString(KEY_SERVICE_TERMS_URL, iNTERFACE$GetPrivacyInfoResponse.privacy_info.service_terms_url.get());
        bundle.putBoolean("show", iNTERFACE$GetPrivacyInfoResponse.need_pop_out.get() == 1);
        bundle.putInt("ret_code", iNTERFACE$GetPrivacyInfoResponse.ret_code.get());
        notifyObserver(intent, this.observerId, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        QLog.i(TAG, 4, "onSend");
        byte[] encode = new PrivacyDetailRequest(intent.getStringExtra("app_id"), intent.getStringExtra("event_name")).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
