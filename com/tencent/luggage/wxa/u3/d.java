package com.tencent.luggage.wxa.u3;

import com.tencent.ilinkservice.IlinkDeviceCallback;
import com.tencent.luggage.wxa.s3.h;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements IlinkDeviceCallback {

    /* renamed from: a, reason: collision with root package name */
    public final a f142112a;

    /* renamed from: b, reason: collision with root package name */
    public h.a f142113b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void onLoginComplete(int i3, int i16);
    }

    public d(a aVar, h.a aVar2) {
        this.f142112a = aVar;
        this.f142113b = aVar2;
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceCallback
    public void onFinishGetStrategy() {
        new com.tencent.luggage.wxa.u3.a().c();
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceCallback
    public void onLoginComplete(int i3, int i16, byte[] bArr, String str) {
        w.d("Wxa.WxaIlinkDeviceCallback", "errCode=[%d],detailRet=[%d]", Integer.valueOf(i3), Integer.valueOf(i16));
        this.f142112a.onLoginComplete(i3, i16);
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceCallback
    public void onUploadLogComplete(int i3) {
        h.a aVar = this.f142113b;
        if (aVar != null) {
            aVar.onUploadLogComplete(i3);
        }
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceCallback
    public void onNetStatusChanged(int i3) {
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceCallback
    public void onReceivePullLogCmd(byte[] bArr) {
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceCallback
    public void onSendMsgResult(int i3, int i16) {
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceCallback
    public void onReceiveMessage(String str, String str2, String str3, String str4, int i3) {
    }
}
