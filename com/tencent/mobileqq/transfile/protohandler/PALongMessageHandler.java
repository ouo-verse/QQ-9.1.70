package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$LongMsgUrlResponse;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

/* loaded from: classes19.dex */
public class PALongMessageHandler extends BaseHandler {
    static IPatchRedirector $redirector_;

    public PALongMessageHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        long j3;
        if (list != null && list.size() != 0) {
            RichProto.RichProtoReq.LongStructMessageDownReq longStructMessageDownReq = (RichProto.RichProtoReq.LongStructMessageDownReq) list.get(0);
            mobileqq_mp$LongMsgUrlRequest mobileqq_mp_longmsgurlrequest = new mobileqq_mp$LongMsgUrlRequest();
            try {
                j3 = Long.parseLong(longStructMessageDownReq.peerUin);
            } catch (Exception unused) {
                j3 = 0;
            }
            mobileqq_mp_longmsgurlrequest.puin.set(j3);
            mobileqq_mp_longmsgurlrequest.str_fileid.set(longStructMessageDownReq.strFileid);
            return mobileqq_mp_longmsgurlrequest.toByteArray();
        }
        return new byte[0];
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        richProtoResp.resps.add(new RichProto.RichProtoResp.LongStructMessageDownResp());
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoResp, (Object) protoReq);
            return;
        }
        RichProto.RichProtoReq richProtoReq = (RichProto.RichProtoReq) protoReq.busiData;
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        FromServiceMsg fromServiceMsg = protoResp.resp;
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        StatictisInfo statictisInfo = protoResp.statisInfo;
        if (fromServiceMsg.getResultCode() == 1000) {
            try {
                if (richProtoResp.resps.size() > 0) {
                    mobileqq_mp$LongMsgUrlResponse mergeFrom = new mobileqq_mp$LongMsgUrlResponse().mergeFrom(wupBuffer);
                    RichProto.RichProtoResp.LongStructMessageDownResp longStructMessageDownResp = (RichProto.RichProtoResp.LongStructMessageDownResp) richProtoResp.resps.get(0);
                    longStructMessageDownResp.retInfo = mergeFrom.ret_info.get();
                    longStructMessageDownResp.strUrl = mergeFrom.str_url.get();
                    longStructMessageDownResp.strFileMd5 = mergeFrom.str_file_md5.get();
                }
            } catch (Exception unused) {
            }
        } else {
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
        }
        RichProtoProc.onBusiProtoResp(richProtoReq, richProtoResp);
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoHandler
    public void sendRichProtoReq(RichProto.RichProtoReq richProtoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) richProtoReq);
            return;
        }
        if (richProtoReq != null && richProtoReq.reqs != null && richProtoReq.protoReqMgr != null) {
            ProtoReqManagerImpl.ProtoReq protoReq = new ProtoReqManagerImpl.ProtoReq();
            protoReq.ssoCmd = RichMediaConstants.CMD_LONGCONN_LONG_STRUCT_MESSAGE_DOWN;
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
