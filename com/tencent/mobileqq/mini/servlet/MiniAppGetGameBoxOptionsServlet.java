package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_BOX.MINI_GAME_BOX$QueryBoxOptionRsp;
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
public class MiniAppGetGameBoxOptionsServlet extends MiniAppAbstractServlet {
    public static final String CMD_STRING = "miniapp.trpc.minigame.game_box_svr.GameBoxPB2.QueryBoxOption";
    public static final String KEY_APPID = "appId";
    public static final String KEY_RESULT = "query_result";
    public static final String TAG = "MiniAppGetGameBoxOptionsServlet";

    public MiniAppGetGameBoxOptionsServlet() {
        this.observerId = 1103;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        MINI_GAME_BOX$QueryBoxOptionRsp onResponse = GetGameBoxOptionsRequest.onResponse(bArr);
        if (onResponse == null) {
            QLog.i(TAG, 1, "[onProcessData] rsp=null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isShowGameBoxFloatEnable", onResponse.is_display_open_btn.get());
            QLog.d(TAG, 2, "[onProcessData] data:" + jSONObject);
            bundle.putString("query_result", jSONObject.toString());
            notifyObserver(intent, 1103, true, bundle, MiniAppObserver.class);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[onProcessData], e:" + e16);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("appId");
        QLog.i(TAG, 1, "onSend: appId=" + stringExtra);
        byte[] encode = new GetGameBoxOptionsRequest(stringExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
