package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$GetGuildInviteCodeRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetGuildJoinUrlServlet extends MiniAppAbstractServlet {
    public static final String BUNDLE_KEY_URL = "share_url";
    public static final String CMD_NAME = "GetGuildInviteCode";
    public static final String CMD_STRING = "LightAppSvc.mini_app_user_channel_info.GetGuildInviteCode";
    public static final String REQUEST_KEY_GUILD_ID = "guildId";
    private static final String TAG = "GetGuildJoinSignServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$GetGuildInviteCodeRsp iNTERFACE$GetGuildInviteCodeRsp = new INTERFACE$GetGuildInviteCodeRsp();
        iNTERFACE$GetGuildInviteCodeRsp.mergeFrom(bArr);
        bundle.putString(BUNDLE_KEY_URL, iNTERFACE$GetGuildInviteCodeRsp.invite_url.get());
        notifyObserver(intent, this.observerId, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        QLog.i(TAG, 4, "onSend");
        byte[] encode = new GetGuildJoinUrlRequest(intent.getStringExtra("guildId")).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
