package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;
import tencent.im.longconn.multimsg.MultiMsg$MultiMsgApplyUpReq;
import tencent.im.longconn.multimsg.MultiMsg$MultiMsgApplyUpRsp;
import tencent.im.longconn.multimsg.MultiMsg$ReqBody;
import tencent.im.longconn.multimsg.MultiMsg$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class MultiMsgUpHandler extends BaseHandler {
    static IPatchRedirector $redirector_;
    int mReqNetType;

    public MultiMsgUpHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void addOne(int i3, RichProto.RichProtoReq.ReqCommon reqCommon, MultiMsg$ReqBody multiMsg$ReqBody) {
        RichProto.RichProtoReq.MultiMsgUpReq multiMsgUpReq = (RichProto.RichProtoReq.MultiMsgUpReq) reqCommon;
        MultiMsg$MultiMsgApplyUpReq multiMsg$MultiMsgApplyUpReq = new MultiMsg$MultiMsgApplyUpReq();
        multiMsg$MultiMsgApplyUpReq.setHasFlag(true);
        multiMsg$MultiMsgApplyUpReq.uint64_dst_uin.set(Long.valueOf(multiMsgUpReq.peerUin).longValue());
        multiMsg$MultiMsgApplyUpReq.uint64_msg_size.set(multiMsgUpReq.size);
        multiMsg$MultiMsgApplyUpReq.bytes_msg_md5.set(ByteStringMicro.copyFrom(multiMsgUpReq.md5));
        multiMsg$MultiMsgApplyUpReq.uint32_msg_type.set(convertMsgType(multiMsgUpReq.uinType));
        multiMsg$MultiMsgApplyUpReq.uint32_apply_id.set(0);
        multiMsg$ReqBody.rpt_multimsg_applyup_req.add(multiMsg$MultiMsgApplyUpReq);
        if (multiMsgUpReq.multiMsgType == 1) {
            multiMsg$ReqBody.uint32_bu_type.set(1);
        }
        if (multiMsgUpReq.multiMsgType == 0) {
            multiMsg$ReqBody.uint32_bu_type.set(2);
        }
    }

    private byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        int netType = NetworkCenter.getInstance().getNetType();
        this.mReqNetType = netType;
        int i3 = 3;
        if (netType != 1) {
            if (netType != 2) {
                if (netType != 3) {
                    if (netType != 4) {
                        i3 = 255;
                    } else {
                        i3 = 8;
                    }
                } else {
                    i3 = 7;
                }
            } else {
                i3 = 6;
            }
        }
        String apnType = NetworkCenter.getInstance().getApnType();
        if (apnType != null && apnType.contains("wap")) {
            i3 = 5;
        }
        MultiMsg$ReqBody multiMsg$ReqBody = new MultiMsg$ReqBody();
        multiMsg$ReqBody.setHasFlag(true);
        multiMsg$ReqBody.uint32_subcmd.set(1);
        multiMsg$ReqBody.uint32_term_type.set(5);
        multiMsg$ReqBody.uint32_platform_type.set(9);
        multiMsg$ReqBody.uint32_net_type.set(i3);
        multiMsg$ReqBody.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
        multiMsg$ReqBody.uint32_bu_type.set(0);
        for (int i16 = 0; i16 < list.size(); i16++) {
            addOne(i16, list.get(i16), multiMsg$ReqBody);
        }
        return multiMsg$ReqBody.toByteArray();
    }

    public static int convertMsgType(int i3) {
        if (i3 == 1 || i3 == 3000) {
            return 3;
        }
        if (i3 != 1039) {
            if (i3 != 1040) {
                return 1;
            }
            return 15;
        }
        return 255;
    }

    void handleSSORespError(FromServiceMsg fromServiceMsg, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo, int i3) {
        if (i3 != 1002 && i3 != 1013) {
            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQUEST_MSF_ERROR, BaseMessageHandler.getTimeoutReason(fromServiceMsg), "", statictisInfo, richProtoResp.resps);
        } else {
            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT, BaseMessageHandler.getTimeoutReason(fromServiceMsg), "", statictisInfo, richProtoResp.resps);
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.MultiMsgUpResp());
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
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
            handleSSORespError(fromServiceMsg, richProtoResp, statictisInfo, fromServiceMsg.getResultCode());
        } else {
            try {
                List<MultiMsg$MultiMsgApplyUpRsp> list = new MultiMsg$RspBody().mergeFrom(wupBuffer).rpt_multimsg_applyup_rsp.get();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    MultiMsg$MultiMsgApplyUpRsp multiMsg$MultiMsgApplyUpRsp = list.get(i3);
                    RichProto.RichProtoResp.MultiMsgUpResp multiMsgUpResp = (RichProto.RichProtoResp.MultiMsgUpResp) richProtoResp.resps.get(i3);
                    int i16 = multiMsg$MultiMsgApplyUpRsp.uint32_result.get();
                    if (i16 == 0) {
                        byte[] byteArray = multiMsg$MultiMsgApplyUpRsp.bytes_msg_resid.get().toByteArray();
                        byte[] byteArray2 = multiMsg$MultiMsgApplyUpRsp.bytes_msg_ukey.get().toByteArray();
                        byte[] byteArray3 = multiMsg$MultiMsgApplyUpRsp.bytes_msg_key.get().toByteArray();
                        byte[] byteArray4 = multiMsg$MultiMsgApplyUpRsp.bytes_msg_sig.get().toByteArray();
                        multiMsgUpResp.resId = byteArray;
                        multiMsgUpResp.ukey = byteArray2;
                        multiMsgUpResp.msgKey = byteArray3;
                        multiMsgUpResp.msgSig = byteArray4;
                        List<Integer> list2 = multiMsg$MultiMsgApplyUpRsp.rpt_uint32_up_ip.get();
                        List<Integer> list3 = multiMsg$MultiMsgApplyUpRsp.rpt_uint32_up_port.get();
                        int i17 = 0;
                        while (i17 < list2.size()) {
                            long intValue = list2.get(i17).intValue() & 4294967295L;
                            List<Integer> list4 = list2;
                            long intValue2 = list3.get(i17).intValue();
                            ServerAddr serverAddr = new ServerAddr();
                            serverAddr.mIp = PkgTools.int2IPNet(intValue);
                            serverAddr.port = (int) intValue2;
                            multiMsgUpResp.ipList.add(i17, serverAddr);
                            i17++;
                            list2 = list4;
                            list3 = list3;
                        }
                        multiMsgUpResp.blockSize = (int) multiMsg$MultiMsgApplyUpRsp.uint64_block_size.get();
                        multiMsgUpResp.transferedSize = (int) multiMsg$MultiMsgApplyUpRsp.uint64_up_offset.get();
                        setResult(0, 0, "", "", statictisInfo, multiMsgUpResp);
                    } else {
                        if (shouldRetryByRetCodeForGroup(i16)) {
                            int i18 = this.mReqUrlCount + 1;
                            this.mReqUrlCount = i18;
                            if (i18 < 2) {
                                richProtoReq.protoReqMgr.sendProtoReq(protoReq);
                                return;
                            }
                        }
                        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i16), "", statictisInfo, multiMsgUpResp);
                    }
                }
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
            protoReq.ssoCmd = RichMediaConstants.CMD_LONGCONN_MULTIMSG_UP;
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
