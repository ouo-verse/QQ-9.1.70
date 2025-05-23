package com.qzone.album.protocol;

import NS_MOBILE_MATERIAL.material_cate_get_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetFontListRequest extends QZoneRequest {
    private static final String CMD = "Material.GetCate";
    private static final String UNIKEY = "GetCate";
    private int mType;

    public QzoneGetFontListRequest(long j3, int i3) {
        super("Material.GetCate");
        this.mType = i3;
        material_cate_get_req material_cate_get_reqVar = new material_cate_get_req();
        material_cate_get_reqVar.lUin = j3;
        material_cate_get_reqVar.iAppid = 102;
        material_cate_get_reqVar.strCateId = getCateId();
        this.req = material_cate_get_reqVar;
    }

    protected String getCateId() {
        return "CustomFontShuoShuoAndroidV2";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public int getType() {
        return this.mType;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNIKEY;
    }
}
