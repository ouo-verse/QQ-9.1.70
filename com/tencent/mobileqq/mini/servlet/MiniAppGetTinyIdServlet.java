package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StTinyidOpenidPair;
import NS_MINI_INTERFACE.INTERFACE$StTrans4TinyidRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import java.util.List;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetTinyIdServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_OPEN_ID = "key_open_id";
    public static final String KEY_TINY_ID = "key_tiny_id";
    public static final String TAG = "MiniAppGetTinyIdServlet";

    public MiniAppGetTinyIdServlet() {
        this.observerId = 1024;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StTrans4TinyidRsp iNTERFACE$StTrans4TinyidRsp = new INTERFACE$StTrans4TinyidRsp();
        iNTERFACE$StTrans4TinyidRsp.mergeFrom(bArr);
        if (iNTERFACE$StTrans4TinyidRsp.tinyidOpenids.isEmpty()) {
            notifyObserver(intent, 1036, false, bundle, MiniAppObserver.class);
            return;
        }
        List<INTERFACE$StTinyidOpenidPair> list = iNTERFACE$StTrans4TinyidRsp.tinyidOpenids.get();
        if (list.size() == 0) {
            notifyObserver(intent, 1036, false, bundle, MiniAppObserver.class);
            return;
        }
        bundle.putString("key_open_id", list.get(0).openid.get());
        bundle.putLong("key_tiny_id", list.get(0).tinyid.get());
        notifyObserver(intent, 1036, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_app_id");
        byte[] encode = new GetTinyIdRequest(stringExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetTinyIdRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
