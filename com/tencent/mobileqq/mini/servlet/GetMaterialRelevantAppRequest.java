package com.tencent.mobileqq.mini.servlet;

import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial$GetMaterialRelevantAppReq;

/* compiled from: P */
/* loaded from: classes33.dex */
class GetMaterialRelevantAppRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "miniapp.Openmaterial.GetMaterialRelevantApp";
    private final MiniAppFileMaterial$GetMaterialRelevantAppReq mReq;

    public GetMaterialRelevantAppRequest(String str, String str2) {
        MiniAppFileMaterial$GetMaterialRelevantAppReq miniAppFileMaterial$GetMaterialRelevantAppReq = new MiniAppFileMaterial$GetMaterialRelevantAppReq();
        this.mReq = miniAppFileMaterial$GetMaterialRelevantAppReq;
        miniAppFileMaterial$GetMaterialRelevantAppReq.mime_type.set(str);
        if (str2 != null) {
            miniAppFileMaterial$GetMaterialRelevantAppReq.extra.set(str2);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.mReq.toByteArray();
    }
}
