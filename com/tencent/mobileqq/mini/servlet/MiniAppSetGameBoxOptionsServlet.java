package com.tencent.mobileqq.mini.servlet;

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
public class MiniAppSetGameBoxOptionsServlet extends MiniAppAbstractServlet {
    public static final String CMD_STRING = "miniapp.trpc.minigame.game_box_svr.GameBoxPB2.SetBoxDisplayOptionSSO";
    public static final String KEY_ALLOW_DISPLAY = "isAllowDisplay";
    public static final String KEY_APPID = "appId";
    public static final String KEY_RESULT = "set_result";
    public static final String TAG = "MiniAppSetGameBoxOptionsServlet";

    public MiniAppSetGameBoxOptionsServlet() {
        this.observerId = 1104;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        QLog.i(TAG, 4, "onSend");
        byte[] encode = new SetGameBoxOptionsRequest(intent.getStringExtra("appId"), intent.getBooleanExtra(KEY_ALLOW_DISPLAY, false)).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        QLog.i(TAG, 1, "[onProcessData]");
        if (SetGameBoxOptionsRequest.onResponse(bArr) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        QLog.d(TAG, 2, "[onProcessData] data:" + jSONObject);
        bundle.putString(KEY_RESULT, jSONObject.toString());
        notifyObserver(intent, 1104, true, bundle, MiniAppObserver.class);
    }
}
