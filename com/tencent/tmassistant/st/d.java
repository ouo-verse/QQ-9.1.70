package com.tencent.tmassistant.st;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends PostHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    protected c f380403a = null;

    /* renamed from: b, reason: collision with root package name */
    private StatReportRequest f380404b;

    public void a(c cVar) {
        this.f380403a = cVar;
    }

    @Override // com.tencent.tmassistantbase.network.PostHttpRequest
    protected void onFinished(byte[] bArr, byte[] bArr2, int i3) {
        int i16;
        byte[] bArr3;
        ReqHead reqHead;
        Response unpackPackage = ProtocolPackage.unpackPackage(bArr2);
        Request request = (Request) ProtocolPackage.bytes2JceObj(bArr, Request.class);
        if (request != null && (reqHead = request.head) != null) {
            i16 = reqHead.requestId;
        } else {
            i16 = 0;
        }
        if (bArr2 == null) {
            this.f380403a.onStatReportFinish(i16, null, null, i3);
            return;
        }
        if (unpackPackage != null && (bArr3 = unpackPackage.body) != null) {
            JceStruct unpageageJceResponse = ProtocolPackage.unpageageJceResponse(bArr3, (Class<? extends JceStruct>) StatReportResponse.class);
            if (unpageageJceResponse != null) {
                c cVar = this.f380403a;
                if (cVar != null && i3 == 0) {
                    if (unpageageJceResponse instanceof StatReportResponse) {
                        StatReportResponse statReportResponse = (StatReportResponse) unpageageJceResponse;
                        int i17 = statReportResponse.ret;
                        if (i17 == 0) {
                            cVar.onStatReportFinish(i16, null, statReportResponse, 0);
                            return;
                        } else {
                            cVar.onStatReportFinish(i16, null, statReportResponse, i17);
                            return;
                        }
                    }
                    return;
                }
                cVar.onStatReportFinish(i16, null, null, i3);
                return;
            }
            this.f380403a.onStatReportFinish(i16, null, null, i3);
            return;
        }
        this.f380403a.onStatReportFinish(i16, null, null, i3);
    }

    public int a(ArrayList<StatItem> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        if (this.f380404b == null) {
            this.f380404b = new StatReportRequest();
        }
        StatReportRequest statReportRequest = this.f380404b;
        statReportRequest.data = arrayList;
        Request buildRequest = ProtocolPackage.buildRequest(statReportRequest);
        int i3 = buildRequest.head.requestId;
        super.sendRequest(ProtocolPackage.buildPostData(buildRequest));
        return i3;
    }
}
