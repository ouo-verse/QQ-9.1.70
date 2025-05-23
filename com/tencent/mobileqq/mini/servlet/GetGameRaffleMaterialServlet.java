package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_RAFFLE.GameRaffleInfo$StGetGameRaffleMaterialRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetGameRaffleMaterialServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_RESULT_DATA = "key_result_data";
    public static final String KEY_UIN = "key_uin";
    public static final String TAG = "GetGameRaffleMaterialServlet";

    public GetGameRaffleMaterialServlet() {
        this.observerId = 1089;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        GameRaffleInfo$StGetGameRaffleMaterialRsp onResponse = GetGameRaffleMaterialRequest.onResponse(bArr);
        if (onResponse != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("raffleImg", onResponse.raffleImg.get());
                jSONObject.putOpt("shareImg", onResponse.shareImg.get());
                jSONObject.putOpt("shareBtn", onResponse.shareBtn.get());
                jSONObject.putOpt("openedPackImg", onResponse.openedPackImg.get());
                jSONObject.putOpt("backBtn", onResponse.backBtn.get());
                jSONObject.putOpt("wishingImg", onResponse.wishingImg.get());
                jSONObject.putOpt("promotion_id", Integer.valueOf(onResponse.promotion_id.get()));
                jSONObject.putOpt("active_id", Integer.valueOf(onResponse.active_id.get()));
                jSONObject.putOpt("watchAdBtn", onResponse.watchAdBtn.get());
            } catch (Throwable th5) {
                QLog.i("GetGameRaffleMaterialServlet", 1, "onProcessData", th5);
            }
            bundle.putString("key_result_data", jSONObject.toString());
            notifyObserver(intent, 1089, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1089, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_appid");
        intent.getStringExtra("key_uin");
        byte[] encode = new GetGameRaffleMaterialRequest(stringExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetGameRaffleMaterialRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
