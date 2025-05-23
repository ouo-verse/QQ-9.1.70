package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetShareInfoServlet extends MiniAppAbstractServlet {
    private static final String CMD_STRING = "LightAppSvc.mini_app_share.AdaptShareInfo";
    public static final String JSON_DATA = "jsonData";
    public static final String MINI_APP_NEED_ONLY_PREVIEW = "miniAppNeedOnlyPreview";
    public static final String NEED_SHARE_CALLBACK = "needShareCallBack";
    private static final String TAG = "MiniAppGetShareInfoServ";

    public MiniAppGetShareInfoServlet() {
        this.observerId = 1012;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        MiniProgramShare$StAdaptShareInfoRsp miniProgramShare$StAdaptShareInfoRsp = new MiniProgramShare$StAdaptShareInfoRsp();
        miniProgramShare$StAdaptShareInfoRsp.mergeFrom(bArr);
        COMM.StCommonExt stCommonExt = miniProgramShare$StAdaptShareInfoRsp.extInfo;
        if (stCommonExt != null && stCommonExt.mapInfo != null) {
            for (int i3 = 0; i3 < miniProgramShare$StAdaptShareInfoRsp.extInfo.mapInfo.size(); i3++) {
                COMM.Entry entry = miniProgramShare$StAdaptShareInfoRsp.extInfo.mapInfo.get(i3);
                if ("needShareCallBack".equals(entry.key.get()) && "true".equals(entry.value.get())) {
                    bundle.putBoolean("needShareCallBack", true);
                }
            }
        }
        bundle.putString("jsonData", miniProgramShare$StAdaptShareInfoRsp.jsonData.get());
        notifyObserver(intent, 1012, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_data");
        byte[] encode = new GetShareInfoRequest(byteArrayExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
