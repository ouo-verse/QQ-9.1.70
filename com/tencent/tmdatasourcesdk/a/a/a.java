package com.tencent.tmdatasourcesdk.a.a;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppDetailParam;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.GetAppSimpleDetailRequest;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.GetAppSimpleDetailResponse;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends PostHttpRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    protected ITMAssistantExchangeURLListenner f380587i;

    public a(ITMAssistantExchangeURLListenner iTMAssistantExchangeURLListenner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iTMAssistantExchangeURLListenner);
        } else {
            this.f380587i = iTMAssistantExchangeURLListenner;
        }
    }

    public boolean b(ArrayList<AppDetailParam> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList)).booleanValue();
        }
        GetAppSimpleDetailRequest getAppSimpleDetailRequest = new GetAppSimpleDetailRequest();
        if (arrayList != null && arrayList.size() > 0) {
            r.b("GetAppSimpleDetailHttpRequest", "appDetailParams size = " + arrayList.size());
            getAppSimpleDetailRequest.appReqList = arrayList;
            super.sendRequest(ProtocolPackage.buildPostData(ProtocolPackage.buildRequest(getAppSimpleDetailRequest)));
            return true;
        }
        r.a("GetAppSimpleDetailHttpRequest", "appDetailParams is null");
        return false;
    }

    @Override // com.tencent.tmassistantbase.network.PostHttpRequest
    protected void onFinished(byte[] bArr, byte[] bArr2, int i3) {
        Object valueOf;
        byte[] bArr3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bArr, bArr2, Integer.valueOf(i3));
            return;
        }
        if (bArr2 == null) {
            r.a("GetAppSimpleDetailHttpRequest", "response is null");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("request length = ");
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append(",response length = ");
        sb5.append(bArr2.length);
        sb5.append(",errorCode = ");
        sb5.append(i3);
        r.b("GetAppSimpleDetailHttpRequest", sb5.toString());
        if (this.f380587i != null && i3 == 0) {
            if (bArr2.length > 4) {
                Response unpackPackage = ProtocolPackage.unpackPackage(bArr2);
                JceStruct bytes2JceObj = ProtocolPackage.bytes2JceObj(((Request) ProtocolPackage.bytes2JceObj(bArr, Request.class)).body, GetAppSimpleDetailRequest.class);
                if (unpackPackage != null && (bArr3 = unpackPackage.body) != null) {
                    JceStruct unpageageJceResponse = ProtocolPackage.unpageageJceResponse(bytes2JceObj, bArr3);
                    if (unpageageJceResponse instanceof GetAppSimpleDetailResponse) {
                        GetAppSimpleDetailResponse getAppSimpleDetailResponse = (GetAppSimpleDetailResponse) unpageageJceResponse;
                        if (getAppSimpleDetailResponse.ret == 0) {
                            ArrayList<AppSimpleDetail> arrayList = getAppSimpleDetailResponse.appSimpleDetailList;
                            if (arrayList != null && arrayList.size() > 0) {
                                this.f380587i.onExchangedURLSucceed(arrayList, true);
                                return;
                            } else {
                                r.c("GetAppSimpleDetailHttpRequest", " appDetails \u4e3a\u7a7a!!");
                                this.f380587i.onExchangedURLSucceed(null, false);
                                return;
                            }
                        }
                        r.c("GetAppSimpleDetailHttpRequest", " \u540e\u53f0\u8fd4\u56de\u7684ret\u9519\u8bef\uff0c\u9519\u8bef\u503c\u4e3a\uff1a" + getAppSimpleDetailResponse.ret);
                        this.f380587i.onExchangedURLSucceed(null, false);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        r.c("GetAppSimpleDetailHttpRequest", " error happened!!");
        if (this.f380587i != null) {
            r.c("GetAppSimpleDetailHttpRequest", "mListener.onExchangedURLSucceed");
            this.f380587i.onExchangedURLSucceed(null, false);
        }
    }
}
