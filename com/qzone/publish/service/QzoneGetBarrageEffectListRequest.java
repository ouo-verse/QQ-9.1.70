package com.qzone.publish.service;

import NS_MOBILE_MATERIAL.material_cate_get_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetBarrageEffectListRequest extends QZoneRequest {
    public static final int APPID = 128;
    private static final String CMD = "Material.GetCate";
    private static final String UNIKEY = "GetCate";

    public QzoneGetBarrageEffectListRequest(long j3) {
        super("Material.GetCate");
        material_cate_get_req material_cate_get_reqVar = new material_cate_get_req();
        material_cate_get_reqVar.lUin = j3;
        material_cate_get_reqVar.iAppid = 128;
        material_cate_get_reqVar.strCateId = "ShuoShuoListKey";
        this.req = material_cate_get_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNIKEY;
    }
}
