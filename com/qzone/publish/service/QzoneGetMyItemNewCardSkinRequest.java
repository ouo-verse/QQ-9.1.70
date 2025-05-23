package com.qzone.publish.service;

import NS_MOBILE_MATERIAL.material_get_my_item_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetMyItemNewCardSkinRequest extends QZoneRequest {
    public static final int APPID = 140;
    private static final String CMD = "Material.GetMyItem";
    private static final String UNIKEY = "GetMyItem";

    public QzoneGetMyItemNewCardSkinRequest(long j3) {
        super(CMD);
        material_get_my_item_req material_get_my_item_reqVar = new material_get_my_item_req();
        material_get_my_item_reqVar.lUin = j3;
        material_get_my_item_reqVar.iAppid = 140;
        this.req = material_get_my_item_reqVar;
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
