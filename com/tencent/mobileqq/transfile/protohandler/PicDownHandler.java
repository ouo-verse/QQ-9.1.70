package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.qphone.base.remote.FromServiceMsg;

/* loaded from: classes19.dex */
public abstract class PicDownHandler extends BaseHandler {
    static IPatchRedirector $redirector_;

    public PicDownHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void handleRespIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    protected abstract boolean handleSucResponse(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq, FromServiceMsg fromServiceMsg, byte[] bArr, RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo);

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        boolean handleSucResponse;
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
            int resultCode = fromServiceMsg.getResultCode();
            if (resultCode != 1002 && resultCode != 1013) {
                String timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
                String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
                if (businessFailMsg == null) {
                    str2 = "";
                } else {
                    str2 = businessFailMsg;
                }
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQUEST_MSF_ERROR, timeoutReason, str2, statictisInfo, richProtoResp.resps);
            } else {
                String timeoutReason2 = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
                String businessFailMsg2 = fromServiceMsg.getBusinessFailMsg();
                if (businessFailMsg2 == null) {
                    str = "";
                } else {
                    str = businessFailMsg2;
                }
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT, timeoutReason2, str, statictisInfo, richProtoResp.resps);
            }
            handleSucResponse = true;
        } else {
            handleSucResponse = handleSucResponse(protoResp, protoReq, fromServiceMsg, wupBuffer, richProtoReq, richProtoResp, statictisInfo);
        }
        if (handleSucResponse) {
            RichProtoProc.onBusiProtoResp(richProtoReq, richProtoResp);
        }
    }
}
