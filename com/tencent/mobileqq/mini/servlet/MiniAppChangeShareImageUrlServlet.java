package com.tencent.mobileqq.mini.servlet;

import NS_MINI_SHARE.MiniProgramShare$StAdaptSharePicReq;
import NS_MINI_SHARE.MiniProgramShare$StAdaptSharePicRsp;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppChangeShareImageUrlServlet extends MiniAppAbstractServlet {
    private static final String CMD_STRING = "LightAppSvc.mini_app_share.AdaptSharePic";
    public static final String KEY_OLD_IMAGE_URL = "key_old_image_url";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
            try {
                stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                MiniProgramShare$StAdaptSharePicRsp miniProgramShare$StAdaptSharePicRsp = new MiniProgramShare$StAdaptSharePicRsp();
                miniProgramShare$StAdaptSharePicRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                bundle.putString("imageUrl", miniProgramShare$StAdaptSharePicRsp.picUrl.get());
                notifyObserver(intent, 1029, true, bundle, MiniAppObserver.class);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                notifyObserver(intent, 1029, false, bundle, MiniAppObserver.class);
            }
        } else {
            notifyObserver(intent, 1029, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(final Intent intent, Packet packet) {
        byte[] encode = new ProtoBufRequest() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppChangeShareImageUrlServlet.1
            @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
            public byte[] getBusiBuf() {
                MiniProgramShare$StAdaptSharePicReq miniProgramShare$StAdaptSharePicReq = new MiniProgramShare$StAdaptSharePicReq();
                miniProgramShare$StAdaptSharePicReq.srcPicUrl.set(intent.getStringExtra(MiniAppChangeShareImageUrlServlet.KEY_OLD_IMAGE_URL));
                return miniProgramShare$StAdaptSharePicReq.toByteArray();
            }
        }.encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
