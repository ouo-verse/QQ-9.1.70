package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;

/* loaded from: classes19.dex */
public abstract class PicUpHandler extends BaseHandler {
    static IPatchRedirector $redirector_;

    public PicUpHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    protected abstract void handleSucResp(FromServiceMsg fromServiceMsg, byte[] bArr, RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo, ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq);

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoResp, (Object) protoReq);
            return;
        }
        FromServiceMsg fromServiceMsg = protoResp.resp;
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        RichProto.RichProtoReq richProtoReq = (RichProto.RichProtoReq) protoReq.busiData;
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        StatictisInfo statictisInfo = protoResp.statisInfo;
        if (fromServiceMsg.getResultCode() != 1000) {
            String str3 = (String) fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_CONNERROR, "");
            if (!str3.equals(n.V) && !str3.equals("")) {
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQUEST_MSF_CON_ERRO, str3, fromServiceMsg.getBusinessFailMsg(), statictisInfo, richProtoResp.resps);
            } else {
                int resultCode = fromServiceMsg.getResultCode();
                if (resultCode != 1002 && resultCode != 1013) {
                    String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
                    if (businessFailMsg == null) {
                        str2 = "";
                    } else {
                        str2 = businessFailMsg;
                    }
                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQUEST_MSF_ERROR, String.valueOf(resultCode), str2, statictisInfo, richProtoResp.resps);
                } else {
                    String timeoutReasonForRichMedia = BaseHandler.getTimeoutReasonForRichMedia(fromServiceMsg);
                    String businessFailMsg2 = fromServiceMsg.getBusinessFailMsg();
                    if (businessFailMsg2 == null) {
                        str = "";
                    } else {
                        str = businessFailMsg2;
                    }
                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT, timeoutReasonForRichMedia, str, statictisInfo, richProtoResp.resps);
                }
            }
        } else {
            handleSucResp(fromServiceMsg, wupBuffer, richProtoReq, richProtoResp, statictisInfo, protoResp, protoReq);
        }
        RichProtoProc.onBusiProtoResp(richProtoReq, richProtoResp);
    }
}
