package com.tencent.tmassistantsdk.internal.logreport;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.a.a;
import com.tencent.tmassistant.common.jce.ReportLogRequest;
import com.tencent.tmassistant.common.jce.ReportLogResponse;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.GlobalUtil;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends PostHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    protected c f380555a = null;

    public boolean a(byte b16, a.C9992a c9992a) {
        if (c9992a == null) {
            return false;
        }
        return super.sendRequest(ProtocolPackage.buildPostData(ProtocolPackage.buildRequest((ReportLogRequest) ProtocolPackage.buildReportRequest(b16, c9992a.f380376b, GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext()), GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()), ""))));
    }

    @Override // com.tencent.tmassistantbase.network.PostHttpRequest
    protected void onFinished(byte[] bArr, byte[] bArr2, int i3) {
        byte[] bArr3;
        if (bArr2 == null) {
            c cVar = this.f380555a;
            if (cVar != null) {
                cVar.a(this, false);
                return;
            }
            return;
        }
        c cVar2 = this.f380555a;
        if (cVar2 != null) {
            if (bArr2.length > 4 && i3 == 0) {
                Response unpackPackage = ProtocolPackage.unpackPackage(bArr2);
                JceStruct bytes2JceObj = ProtocolPackage.bytes2JceObj(((Request) ProtocolPackage.bytes2JceObj(bArr, Request.class)).body, ReportLogRequest.class);
                if (unpackPackage != null && (bArr3 = unpackPackage.body) != null) {
                    JceStruct unpageageJceResponse = ProtocolPackage.unpageageJceResponse(bytes2JceObj, bArr3);
                    if (unpageageJceResponse instanceof ReportLogResponse) {
                        if (((ReportLogResponse) unpageageJceResponse).ret == 0) {
                            this.f380555a.a(this, true);
                            return;
                        } else {
                            this.f380555a.a(this, false);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            cVar2.a(this, false);
        }
    }

    public void a(c cVar) {
        this.f380555a = cVar;
    }
}
