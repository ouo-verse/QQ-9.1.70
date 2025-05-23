package com.tencent.gamecenter.wadl.biz;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        String str;
        String str2;
        int i3;
        boolean z16;
        int i16;
        int i17;
        byte[] bArr2;
        if (fromServiceMsg != null) {
            bArr = fromServiceMsg.getTrpcRspErrorMsg();
        } else {
            bArr = null;
        }
        if (bArr != null && bArr.length > 0) {
            str = new String(bArr);
        } else {
            str = null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onReceive... ");
        if (fromServiceMsg != null) {
            str2 = ",failCode=" + fromServiceMsg.getBusinessFailCode() + "  errMsg:" + fromServiceMsg.getBusinessFailMsg() + "  trpcRet:" + fromServiceMsg.getTrpcRspRetCode() + "  trpcFunRet:" + fromServiceMsg.getTrpcRspFuncRetCode() + "  trpcErrMsg:" + str;
        } else {
            str2 = "";
        }
        sb5.append(str2);
        QLog.d("Wadl_WadlBusinessServlet", 1, sb5.toString());
        long currentTimeMillis = System.currentTimeMillis();
        if (fromServiceMsg != null) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            i3 = fromServiceMsg.getResultCode();
            i16 = fromServiceMsg.getTrpcRspRetCode();
            i17 = fromServiceMsg.getTrpcRspFuncRetCode();
            z16 = isSuccess;
        } else {
            i3 = -1;
            z16 = false;
            i16 = -1;
            i17 = -1;
        }
        if (z16) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            byte[] bArr3 = new byte[length];
            PkgTools.copyData(bArr3, 0, fromServiceMsg.getWupBuffer(), 4, length);
            bArr2 = bArr3;
        } else {
            bArr2 = null;
        }
        if (intent == null) {
            QLog.w("Wadl_WadlBusinessServlet", 1, "onReceive fail, request is null");
            return;
        }
        int intExtra = intent.getIntExtra(WadlProxyConsts.KEY_SSO_TYPE, 0);
        if (intExtra != 1 && intExtra != 3) {
            if (intExtra == 0) {
                ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).onRespWebSso(intent, z16, bArr2);
            } else if (intExtra == 2) {
                Bundle bundle = new Bundle();
                bundle.putInt(WadlProxyConsts.EXTRA_RESULT_CODE, i3);
                bundle.putString(WadlProxyConsts.EXTRA_CMD, intent.getStringExtra(WadlProxyConsts.EXTRA_CMD));
                bundle.putByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP, bArr2);
                notifyObserver(intent, 0, z16, bundle, null);
                ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).onRespTrpcSso(intent, z16, i16, i17, bArr2);
            }
        } else {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).onRespTrpcSso(intent, z16, i16, i17, bArr2);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Wadl_WadlBusinessServlet", 4, "onReceive success=" + z16 + ",cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] bArr;
        boolean z16;
        byte[] byteArrayExtra = intent.getByteArrayExtra(WadlProxyConsts.PARAM_WEBSSO_REQ);
        int intExtra = intent.getIntExtra(WadlProxyConsts.KEY_SSO_TYPE, 0);
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onSend...ssoType:");
            sb5.append(intExtra);
            sb5.append(",data is null:");
            if (byteArrayExtra == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("Wadl_WadlBusinessServlet", 4, sb5.toString());
        }
        if (intExtra == 1) {
            packet.setSSOCommand(WadlProxyConsts.GAME_CENTER_TRPC);
        } else if (intExtra == 2) {
            packet.setSSOCommand(intent.getStringExtra(WadlProxyConsts.EXTRA_CMD));
        } else if (intExtra == 3) {
            packet.setSSOCommand(WadlProxyConsts.SPRING_TRPC);
        } else {
            packet.setSSOCommand(WadlProxyConsts.GAME_CENTER_WEB_SSO);
        }
        if (intent.hasExtra(WadlProxyConsts.PARAM_TIME_OUT)) {
            packet.setTimeout(intent.getLongExtra(WadlProxyConsts.PARAM_TIME_OUT, 10000L));
        }
        if (byteArrayExtra != null) {
            bArr = new byte[byteArrayExtra.length + 4];
            PkgTools.DWord2Byte(bArr, 0, byteArrayExtra.length + 4);
            PkgTools.copyData(bArr, 4, byteArrayExtra, byteArrayExtra.length);
        } else {
            bArr = new byte[4];
            PkgTools.DWord2Byte(bArr, 0, 4L);
        }
        packet.putSendData(bArr);
    }
}
