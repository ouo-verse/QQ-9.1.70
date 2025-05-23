package com.qzone.common.protocol.request;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.ditto.area.DittoHost;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneUniversalRequest extends QZoneRequest {

    @NeedParcel
    private byte[] buffer;

    @NeedParcel
    private String bufferType;
    private DittoHost.SilentRequestCallback callback;

    @NeedParcel
    private String cmd;

    public DittoHost.SilentRequestCallback getCallback() {
        return this.callback;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public byte[] getRawReq() {
        return this.buffer;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getRawReqType() {
        return this.bufferType;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return this.cmd;
    }

    public QzoneUniversalRequest(String str, String str2, byte[] bArr, DittoHost.SilentRequestCallback silentRequestCallback) {
        super(str, true);
        this.cmd = str;
        this.buffer = bArr;
        this.callback = silentRequestCallback;
        this.bufferType = str2;
        try {
            JceStruct jceStruct = (JceStruct) Class.forName(str2).newInstance();
            jceStruct.readFrom(new JceInputStream(bArr));
            this.req = jceStruct;
        } catch (Exception e16) {
            j.d("Universal", "new req err" + e16.getMessage(), e16);
        }
    }
}
