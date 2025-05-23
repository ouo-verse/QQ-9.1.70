package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_MISC.MISC$StTrans4RoomidRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.xaction.log.b;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppTranRoomIdServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_GROUP_ID = "key_group_id";
    public static final String KEY_OPEN_ID = "key_open_id";
    public static final String KEY_ROOM_ID = "key_room_id";
    public static final String KEY_TINY_ID = "key_tiny_id";
    public static final String TAG = "MiniAppGetTinyIdServlet";

    public MiniAppTranRoomIdServlet() {
        this.observerId = 1024;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        MISC$StTrans4RoomidRsp mISC$StTrans4RoomidRsp = new MISC$StTrans4RoomidRsp();
        mISC$StTrans4RoomidRsp.mergeFrom(bArr);
        long j3 = bundle.getLong("retCode");
        b.a("MiniAppGetTinyIdServlet", 1, "onProcessData roomid:" + mISC$StTrans4RoomidRsp.roomid.get());
        if (j3 == 0) {
            bundle.putString("key_open_id", mISC$StTrans4RoomidRsp.openid.get());
            bundle.putLong("key_tiny_id", mISC$StTrans4RoomidRsp.tinyid.get());
            bundle.putLong("key_room_id", mISC$StTrans4RoomidRsp.roomid.get());
            notifyObserver(intent, 1037, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1037, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_app_id");
        String stringExtra2 = intent.getStringExtra(KEY_GROUP_ID);
        byte[] encode = new GetTransRoomIdRequest(stringExtra, stringExtra2).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetTransRoomIdRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
