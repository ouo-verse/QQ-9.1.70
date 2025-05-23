package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetProfileRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes33.dex */
public class MiniAppGetProfileServlet extends MiniAppAbstractServlet {
    public static final String TAG = "MiniAppGetProfileServlet";
    private String appId;

    public MiniAppGetProfileServlet() {
        this.observerId = 1001;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetProfileRsp iNTERFACE$StGetProfileRsp = new INTERFACE$StGetProfileRsp();
        iNTERFACE$StGetProfileRsp.mergeFrom(bArr);
        INTERFACE$StApiUserInfo iNTERFACE$StApiUserInfo = iNTERFACE$StGetProfileRsp.user;
        if (iNTERFACE$StApiUserInfo != null) {
            bundle.putString("nick", iNTERFACE$StApiUserInfo.nick.get());
            bundle.putString("avatar", iNTERFACE$StGetProfileRsp.user.avatar.get());
            bundle.putInt("gender", iNTERFACE$StGetProfileRsp.user.gender.get());
            bundle.putString("country", iNTERFACE$StGetProfileRsp.user.address.country.get());
            bundle.putString("province", iNTERFACE$StGetProfileRsp.user.address.province.get());
            bundle.putString("city", iNTERFACE$StGetProfileRsp.user.address.city.get());
            bundle.putString(IjkMediaMeta.IJKM_KEY_LANGUAGE, iNTERFACE$StGetProfileRsp.user.language.get());
            bundle.putString("rawData", iNTERFACE$StGetProfileRsp.rawData.get());
            bundle.putString("signature", iNTERFACE$StGetProfileRsp.signature.get());
            bundle.putString(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, iNTERFACE$StGetProfileRsp.encryptedData.get());
            bundle.putString("iv", iNTERFACE$StGetProfileRsp.f24961iv.get());
            bundle.putString("key_appid", this.appId);
            notifyObserver(intent, 1001, true, bundle, MiniAppObserver.class);
            return;
        }
        QLog.e(TAG, 2, "inform MiniAppGetProfileServlet result.user == null");
        notifyObserver(intent, 1001, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        this.appId = intent.getStringExtra("key_appid");
        intent.getLongExtra("key_uin", 0L);
        byte[] encode = new GetProfileRequest(this.appId, intent.getBooleanExtra(MiniAppAbstractServlet.KEY_WITH_CREDENTIAL, false), intent.getStringExtra(MiniAppAbstractServlet.KEY_LANG)).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetProfileRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
