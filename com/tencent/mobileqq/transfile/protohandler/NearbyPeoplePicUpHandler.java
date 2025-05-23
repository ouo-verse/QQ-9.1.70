package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x6ff.subcmd0x501$ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501$RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501$SubCmd0x501ReqBody;

/* loaded from: classes19.dex */
public class NearbyPeoplePicUpHandler extends BaseHandler {
    static IPatchRedirector $redirector_ = null;
    public static final int CIRCLE_SERVICE_TYPE = 5;
    public static final String CMD_GET_IP_LIST = "HttpConn.0x6ff_501";

    public NearbyPeoplePicUpHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        subcmd0x501$ReqBody subcmd0x501_reqbody = new subcmd0x501$ReqBody();
        subcmd0x501$SubCmd0x501ReqBody subcmd0x501_subcmd0x501reqbody = new subcmd0x501$SubCmd0x501ReqBody();
        if (list != null && list.size() == 1) {
            subcmd0x501_subcmd0x501reqbody.uint64_uin.set(Long.parseLong(((RichProto.RichProtoReq.NearbyPeoplePicUpReq) list.get(0)).uin));
            subcmd0x501_subcmd0x501reqbody.uint32_idc_id.set(0);
            subcmd0x501_subcmd0x501reqbody.uint32_appid.set(16);
            subcmd0x501_subcmd0x501reqbody.uint32_login_sig_type.set(1);
            subcmd0x501_subcmd0x501reqbody.uint32_request_flag.set(3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            subcmd0x501_subcmd0x501reqbody.rpt_uint32_service_types.set(arrayList);
            subcmd0x501_reqbody.msg_subcmd_0x501_req_body.set(subcmd0x501_subcmd0x501reqbody);
            return subcmd0x501_reqbody.toByteArray();
        }
        throw new RuntimeException("only support one request");
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.NearbyPeoplePicUpResp());
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) protoResp, (Object) protoReq);
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
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQUEST_MSF_ERROR, BaseMessageHandler.getTimeoutReason(fromServiceMsg), "", statictisInfo, richProtoResp.resps);
            } else {
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT, BaseMessageHandler.getTimeoutReason(fromServiceMsg), "", statictisInfo, richProtoResp.resps);
            }
        } else {
            try {
                ByteStringMicro byteStringMicro = new subcmd0x501$RspBody().mergeFrom(wupBuffer).msg_subcmd_0x501_rsp_body.get().bytes_httpconn_sig_session.get();
                if (byteStringMicro != null && byteStringMicro.toByteArray().length > 0) {
                    bArr = byteStringMicro.toByteArray();
                } else {
                    bArr = null;
                }
                RichProto.RichProtoResp.NearbyPeoplePicUpResp nearbyPeoplePicUpResp = (RichProto.RichProtoResp.NearbyPeoplePicUpResp) richProtoResp.resps.get(0);
                nearbyPeoplePicUpResp.sessionKey = bArr;
                setResult(0, 0, "", "", statictisInfo, nearbyPeoplePicUpResp);
            } catch (Exception e16) {
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason("P", -9529L), e16.getMessage() + " hex:" + HexUtil.bytes2HexStr(wupBuffer), statictisInfo, richProtoResp.resps);
            }
        }
        RichProtoProc.onBusiProtoResp(richProtoReq, richProtoResp);
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoHandler
    public void sendRichProtoReq(RichProto.RichProtoReq richProtoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) richProtoReq);
            return;
        }
        if (richProtoReq != null && richProtoReq.reqs != null && richProtoReq.protoReqMgr != null) {
            ProtoReqManagerImpl.ProtoReq protoReq = new ProtoReqManagerImpl.ProtoReq();
            protoReq.ssoCmd = CMD_GET_IP_LIST;
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
