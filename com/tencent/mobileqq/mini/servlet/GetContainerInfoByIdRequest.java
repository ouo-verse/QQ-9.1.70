package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.CONTAINER_INTERFACE$GetMiniAppConfigReq;
import NS_MINI_INTERFACE.CONTAINER_INTERFACE$GetMiniAppConfigRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetContainerInfoByIdRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "trpc.group_pro.configdistribution.ConfigDistributionSvr.SsoGetMiniAppConfig";
    public static final int MINI_APP_SCENE_ID = 1;
    public static final String TAG = "GetContainerInfoByIdRequest";
    private CONTAINER_INTERFACE$GetMiniAppConfigReq miniAppConfigReq;

    public GetContainerInfoByIdRequest(COMM.StCommonExt stCommonExt, String str, int i3, int i16, String str2, String str3, String str4) {
        CONTAINER_INTERFACE$GetMiniAppConfigReq cONTAINER_INTERFACE$GetMiniAppConfigReq = new CONTAINER_INTERFACE$GetMiniAppConfigReq();
        this.miniAppConfigReq = cONTAINER_INTERFACE$GetMiniAppConfigReq;
        cONTAINER_INTERFACE$GetMiniAppConfigReq.appid.set(str);
        this.miniAppConfigReq.common_info.model_type.set(1);
        this.miniAppConfigReq.common_info.scene_id.set(1);
    }

    public static CONTAINER_INTERFACE$GetMiniAppConfigRsp onResponse(byte[] bArr) {
        CONTAINER_INTERFACE$GetMiniAppConfigRsp cONTAINER_INTERFACE$GetMiniAppConfigRsp = new CONTAINER_INTERFACE$GetMiniAppConfigRsp();
        try {
            cONTAINER_INTERFACE$GetMiniAppConfigRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return cONTAINER_INTERFACE$GetMiniAppConfigRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.miniAppConfigReq.toByteArray();
    }
}
