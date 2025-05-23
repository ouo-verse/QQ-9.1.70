package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_RAFFLE.GameRaffleInfo$Pack;
import NS_MINI_GAME_RAFFLE.GameRaffleInfo$StDoGameRaffleRsp;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DoGameRaffleServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_RESULT_DATA = "key_result_data";
    public static final String KEY_UIN = "key_uin";
    public static final String TAG = "GetGameRaffleMaterialServlet";

    public DoGameRaffleServlet() {
        this.observerId = 1090;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        GameRaffleInfo$StDoGameRaffleRsp onResponse = DoGameRaffleRequest.onResponse(bArr);
        if (onResponse != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("state", Integer.valueOf(onResponse.state.get()));
                jSONObject.putOpt("onlinePrizeImg", onResponse.onlinePrizeImg.get());
                jSONObject.putOpt("active_id", Integer.valueOf(onResponse.active_id.get()));
            } catch (Throwable th5) {
                QLog.i("GetGameRaffleMaterialServlet", 1, "onProcessData", th5);
            }
            GameRaffleInfo$Pack gameRaffleInfo$Pack = onResponse.pack.get();
            if (gameRaffleInfo$Pack != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("pack_id", gameRaffleInfo$Pack.pack_id.get());
                    jSONObject2.putOpt("state", Integer.valueOf(gameRaffleInfo$Pack.state.get()));
                    jSONObject2.putOpt("type", Integer.valueOf(gameRaffleInfo$Pack.type.get()));
                    jSONObject2.putOpt("ctime", Integer.valueOf(gameRaffleInfo$Pack.ctime.get()));
                    jSONObject2.putOpt(WidgetCacheConstellationData.MONEY, Integer.valueOf(gameRaffleInfo$Pack.money.get()));
                    jSONObject2.putOpt("business_id", Integer.valueOf(gameRaffleInfo$Pack.business_id.get()));
                    jSONObject2.putOpt("signature", gameRaffleInfo$Pack.signature.get());
                    jSONObject2.putOpt("url", gameRaffleInfo$Pack.url.get());
                    jSONObject2.putOpt("mtime", Integer.valueOf(gameRaffleInfo$Pack.mtime.get()));
                    jSONObject2.putOpt("order", gameRaffleInfo$Pack.order.get());
                    jSONObject2.putOpt("uin", Long.valueOf(gameRaffleInfo$Pack.uin.get()));
                    jSONObject2.putOpt("send_uin", Long.valueOf(gameRaffleInfo$Pack.send_uin.get()));
                    jSONObject2.putOpt("wishing", gameRaffleInfo$Pack.wishing.get());
                    jSONObject2.putOpt("promotion_id", Integer.valueOf(gameRaffleInfo$Pack.promotion_id.get()));
                    jSONObject2.putOpt(CheckForwardServlet.KEY_REQ_ID, gameRaffleInfo$Pack.req_id.get());
                    jSONObject2.putOpt("business_name", gameRaffleInfo$Pack.business_name.get());
                    jSONObject2.putOpt("business_logo", gameRaffleInfo$Pack.business_logo.get());
                    jSONObject2.putOpt("business_cover", gameRaffleInfo$Pack.business_cover.get());
                    jSONObject2.putOpt("business_video_cover", gameRaffleInfo$Pack.business_video_cover.get());
                    jSONObject2.putOpt("business_video", gameRaffleInfo$Pack.business_video.get());
                    jSONObject2.putOpt("business_name_pic", gameRaffleInfo$Pack.business_name_pic.get());
                    jSONObject.putOpt("pack", jSONObject2);
                } catch (Throwable th6) {
                    QLog.i("GetGameRaffleMaterialServlet", 1, "onProcessData", th6);
                }
            }
            bundle.putString("key_result_data", jSONObject.toString());
            notifyObserver(intent, 1090, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1090, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_appid");
        String stringExtra2 = intent.getStringExtra("key_uin");
        byte[] encode = new DoGameRaffleRequest(stringExtra, stringExtra2).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(DoGameRaffleRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
