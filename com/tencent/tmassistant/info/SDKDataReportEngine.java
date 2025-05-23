package com.tencent.tmassistant.info;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.SDKDataReportRequest;
import com.tencent.tmassistant.common.jce.SDKDataReportResponse;
import com.tencent.tmassistantbase.network.PostHttpRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class SDKDataReportEngine extends PostHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    private Callback f380398a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface Callback {
        void a();

        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Callback callback) {
        this.f380398a = callback;
    }

    @Override // com.tencent.tmassistantbase.network.PostHttpRequest
    protected void onFinished(byte[] bArr, byte[] bArr2, int i3) {
        byte[] bArr3;
        if (bArr2 != null && i3 == 0) {
            Response unpackPackage = ProtocolPackage.unpackPackage(bArr2);
            if (unpackPackage != null && (bArr3 = unpackPackage.body) != null) {
                JceStruct unpageageJceResponse = ProtocolPackage.unpageageJceResponse(bArr3, (Class<? extends JceStruct>) SDKDataReportResponse.class);
                if (unpageageJceResponse instanceof SDKDataReportResponse) {
                    if (((SDKDataReportResponse) unpageageJceResponse).ret == 0) {
                        Callback callback = this.f380398a;
                        if (callback != null) {
                            callback.a();
                            return;
                        }
                        return;
                    }
                    Callback callback2 = this.f380398a;
                    if (callback2 != null) {
                        callback2.a(i3);
                        return;
                    }
                    return;
                }
                Callback callback3 = this.f380398a;
                if (callback3 != null) {
                    callback3.a(i3);
                    return;
                }
                return;
            }
            Callback callback4 = this.f380398a;
            if (callback4 != null) {
                callback4.a(i3);
                return;
            }
            return;
        }
        Callback callback5 = this.f380398a;
        if (callback5 != null) {
            callback5.a(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SDKDataReportRequest sDKDataReportRequest) {
        byte[] buildPostData;
        if (sDKDataReportRequest == null || (buildPostData = ProtocolPackage.buildPostData(ProtocolPackage.buildRequest(sDKDataReportRequest))) == null) {
            return false;
        }
        return sendRequest(buildPostData);
    }
}
