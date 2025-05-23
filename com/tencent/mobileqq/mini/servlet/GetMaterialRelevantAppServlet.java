package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetMaterialRelevantAppServlet extends MiniAppAbstractServlet {
    public static final String KEY_EXTRA_INFO = "key_extra_info";
    public static final String KEY_MIME_TYPE = "key_mime_type";

    public GetMaterialRelevantAppServlet() {
        this.observerId = 1031;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        super.onProcessData(intent, bundle, bArr);
        bundle.putByteArray(MiniAppCmdUtil.KEY_RSP_DATA, bArr);
        notifyObserver(intent, this.observerId, true, bundle, null);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] encode = new GetMaterialRelevantAppRequest(intent.getStringExtra(KEY_MIME_TYPE), intent.getStringExtra(KEY_EXTRA_INFO)).encode(intent, MiniAppCmdUtil.getReqSeqIndex(), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetMaterialRelevantAppRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
