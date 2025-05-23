package com.tencent.gdt.tangram.net.qzone.embedded.msf;

import com.qq.taf.jce.JceStruct;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes31.dex */
class AdQZoneRequest extends QZoneRequest {
    private String cmd;

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return this.cmd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdQZoneRequest(String str, JceStruct jceStruct) {
        super(str, true);
        this.cmd = str;
        this.req = jceStruct;
    }
}
