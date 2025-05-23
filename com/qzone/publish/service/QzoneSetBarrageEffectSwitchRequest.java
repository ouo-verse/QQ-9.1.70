package com.qzone.publish.service;

import NS_MOBILE_MATERIAL.material_set_switch_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneSetBarrageEffectSwitchRequest extends QZoneRequest {
    private static final String CMD = "Material.SetSwitch";
    private static final String UNIKEY = "SetSwitch";

    public QzoneSetBarrageEffectSwitchRequest(long j3) {
        super(CMD);
        material_set_switch_req material_set_switch_reqVar = new material_set_switch_req();
        material_set_switch_reqVar.lUin = j3;
        material_set_switch_reqVar.iAppid = 128;
        this.req = material_set_switch_reqVar;
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
