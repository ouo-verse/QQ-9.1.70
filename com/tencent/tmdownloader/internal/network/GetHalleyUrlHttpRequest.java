package com.tencent.tmdownloader.internal.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.GetHalleyUrlReq;
import com.tencent.tmassistant.common.jce.GetHalleyUrlRsp;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class GetHalleyUrlHttpRequest extends PostHttpRequest {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "GetHalleyUrlHttpRequest";
    protected IGetHalleyUrlHttpListener mListener;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11807);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public GetHalleyUrlHttpRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mListener = null;
        }
    }

    @Override // com.tencent.tmassistantbase.network.PostHttpRequest
    protected void onFinished(byte[] bArr, byte[] bArr2, int i3) {
        byte[] bArr3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bArr, bArr2, Integer.valueOf(i3));
            return;
        }
        String str = TAG;
        r.b(str, "onFinished errorCode: " + i3);
        JceStruct bytes2JceObj = ProtocolPackage.bytes2JceObj(ProtocolPackage.unpackRequestPackage(bArr).body, GetHalleyUrlReq.class);
        if (bArr2 == null) {
            r.b(str, "onFinished response is null!");
            r.b(str, "exit");
            this.mListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq) bytes2JceObj, null, false);
            return;
        }
        Response unpackPackage = ProtocolPackage.unpackPackage(bArr2);
        if (unpackPackage != null && (bArr3 = unpackPackage.body) != null) {
            JceStruct unpageageJceResponse = ProtocolPackage.unpageageJceResponse(bArr3, (Class<? extends JceStruct>) GetHalleyUrlRsp.class);
            r.b(str, "halleyTest GetHalleyUrlHttpRequest finish jceResponse = " + unpageageJceResponse);
            if (unpageageJceResponse != null) {
                IGetHalleyUrlHttpListener iGetHalleyUrlHttpListener = this.mListener;
                if (iGetHalleyUrlHttpListener != null && i3 == 0) {
                    if (unpageageJceResponse instanceof GetHalleyUrlRsp) {
                        GetHalleyUrlRsp getHalleyUrlRsp = (GetHalleyUrlRsp) unpageageJceResponse;
                        if (getHalleyUrlRsp.ret == 0) {
                            iGetHalleyUrlHttpListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq) bytes2JceObj, getHalleyUrlRsp, true);
                        } else {
                            iGetHalleyUrlHttpListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq) bytes2JceObj, getHalleyUrlRsp, false);
                        }
                    }
                } else {
                    iGetHalleyUrlHttpListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq) bytes2JceObj, null, false);
                }
            } else {
                this.mListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq) bytes2JceObj, null, false);
            }
        } else {
            this.mListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq) bytes2JceObj, null, false);
        }
        r.b(str, "exit");
    }

    public void sendHalleyUrlRequest(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        GetHalleyUrlReq getHalleyUrlReq = new GetHalleyUrlReq();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        getHalleyUrlReq.origins = arrayList;
        super.sendRequest(ProtocolPackage.buildPostData(ProtocolPackage.buildRequest(getHalleyUrlReq)));
    }

    public void setGetHalleyUrlHttpListener(IGetHalleyUrlHttpListener iGetHalleyUrlHttpListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iGetHalleyUrlHttpListener);
        } else {
            this.mListener = iGetHalleyUrlHttpListener;
        }
    }
}
