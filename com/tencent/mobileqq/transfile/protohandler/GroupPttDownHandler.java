package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388$GetPttUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388$GetPttUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388$IPv6Info;
import tencent.im.cs.cmd0x388.cmd0x388$ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388$RspBody;

/* loaded from: classes19.dex */
public class GroupPttDownHandler extends BaseHandler {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.richmedia.GroupPttDownHandler";

    public GroupPttDownHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void handleError(FromServiceMsg fromServiceMsg, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo) {
        String str;
        String str2;
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
            return;
        }
        String timeoutReason2 = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
        String businessFailMsg2 = fromServiceMsg.getBusinessFailMsg();
        if (businessFailMsg2 == null) {
            str = "";
        } else {
            str = businessFailMsg2;
        }
        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT, timeoutReason2, str, statictisInfo, richProtoResp.resps);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x01cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleSuccess(ProtoReqManagerImpl.ProtoReq protoReq, FromServiceMsg fromServiceMsg, byte[] bArr, RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo) {
        List<cmd0x388$GetPttUrlRsp> list;
        RichProto.RichProtoResp.GroupPttDownResp groupPttDownResp;
        boolean z16;
        int i3;
        RichProto.RichProtoResp.GroupPttDownResp groupPttDownResp2;
        try {
            try {
                list = new cmd0x388$RspBody().mergeFrom(bArr).rpt_msg_getptt_url_rsp.get();
            } catch (Exception e16) {
                e = e16;
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason("P", -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, richProtoResp.resps);
                return false;
            }
        } catch (Exception e17) {
            e = e17;
        }
        if (list != null && list.size() != 0) {
            for (cmd0x388$GetPttUrlRsp cmd0x388_getptturlrsp : list) {
                try {
                    groupPttDownResp = (RichProto.RichProtoResp.GroupPttDownResp) richProtoResp.resps.get((int) cmd0x388_getptturlrsp.uint64_file_id.get());
                } catch (Exception e18) {
                    e = e18;
                    groupPttDownResp = null;
                }
                if (groupPttDownResp != null) {
                    try {
                        groupPttDownResp.isSendByQuickHttp = ((Boolean) fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP, Boolean.FALSE)).booleanValue();
                        if (QLog.isColorLevel()) {
                            try {
                                QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + groupPttDownResp.isSendByQuickHttp);
                            } catch (Exception e19) {
                                e = e19;
                                if (groupPttDownResp != null) {
                                }
                            }
                        }
                        if (cmd0x388_getptturlrsp.uint32_transfer_type.get() == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        groupPttDownResp.mIsHttps = z16;
                        i3 = cmd0x388_getptturlrsp.uint32_result.get();
                    } catch (Exception e26) {
                        e = e26;
                    }
                    if (i3 == 0) {
                        try {
                            groupPttDownResp.urlPath = cmd0x388_getptturlrsp.bytes_down_para.get().toStringUtf8();
                            List<Integer> list2 = cmd0x388_getptturlrsp.rpt_uint32_down_ip.get();
                            List<Integer> list3 = cmd0x388_getptturlrsp.rpt_uint32_down_port.get();
                            for (int i16 = 0; i16 < list2.size(); i16++) {
                                ServerAddr serverAddr = new ServerAddr();
                                serverAddr.mIp = PkgTools.int2IPNet(list2.get(i16).intValue() & 4294967295L);
                                serverAddr.port = list3.get(i16).intValue();
                                groupPttDownResp.mIpList.add(i16, serverAddr);
                            }
                            if (cmd0x388_getptturlrsp.rpt_msg_down_ip6.has() && cmd0x388_getptturlrsp.rpt_msg_down_ip6.size() > 0) {
                                List<cmd0x388$IPv6Info> list4 = cmd0x388_getptturlrsp.rpt_msg_down_ip6.get();
                                for (int i17 = 0; i17 < list4.size(); i17++) {
                                    ServerAddr serverAddr2 = new ServerAddr();
                                    serverAddr2.mIp = InetAddress.getByAddress(list4.get(i17).bytes_ip6.get().toByteArray()).getHostAddress();
                                    serverAddr2.port = list4.get(i17).uint32_port.get();
                                    serverAddr2.isIpv6 = true;
                                    groupPttDownResp.mIpv6List.add(i17, serverAddr2);
                                }
                            }
                            if (cmd0x388_getptturlrsp.rpt_str_domain.has()) {
                                groupPttDownResp.domainV4V6 = cmd0x388_getptturlrsp.rpt_str_domain.get();
                            }
                            groupPttDownResp2 = groupPttDownResp;
                            try {
                                setResult(0, 0, "", "", statictisInfo, groupPttDownResp);
                            } catch (Exception e27) {
                                e = e27;
                            }
                        } catch (Exception e28) {
                            e = e28;
                            if (groupPttDownResp != null) {
                            }
                        }
                    } else {
                        groupPttDownResp2 = groupPttDownResp;
                        if (cmd0x388_getptturlrsp.uint32_allow_retry.get() == 1) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "onProtoResp :group ptt server not allow retry");
                            }
                            groupPttDownResp2.isAllowRetry = false;
                        }
                        if (shouldRetryByRetCodeForGroup(i3)) {
                            try {
                                int i18 = this.mReqUrlCount + 1;
                                this.mReqUrlCount = i18;
                                if (i18 < 2) {
                                    try {
                                        richProtoReq.protoReqMgr.sendProtoReq(protoReq);
                                        return true;
                                    } catch (Exception e29) {
                                        e = e29;
                                    }
                                }
                            } catch (Exception e36) {
                                e = e36;
                            }
                        }
                        try {
                            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i3), "", statictisInfo, groupPttDownResp2);
                        } catch (Exception e37) {
                            e = e37;
                        }
                    }
                    groupPttDownResp = groupPttDownResp2;
                    if (groupPttDownResp != null) {
                        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason("P", -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, groupPttDownResp);
                    }
                }
            }
            return false;
        }
        throw new Exception("resps size is 0");
    }

    void addOne(int i3, RichProto.RichProtoReq.ReqCommon reqCommon, cmd0x388$ReqBody cmd0x388_reqbody) {
        int i16;
        RichProto.RichProtoReq.GroupPttDownReq groupPttDownReq = (RichProto.RichProtoReq.GroupPttDownReq) reqCommon;
        cmd0x388$GetPttUrlReq cmd0x388_getptturlreq = new cmd0x388$GetPttUrlReq();
        cmd0x388_getptturlreq.setHasFlag(true);
        cmd0x388_getptturlreq.uint64_file_id.set(i3);
        cmd0x388_getptturlreq.uint64_dst_uin.set(Long.valueOf(groupPttDownReq.selfUin).longValue());
        cmd0x388_getptturlreq.uint64_group_code.set(Long.parseLong(groupPttDownReq.peerUin));
        cmd0x388_getptturlreq.bytes_file_md5.set(ByteStringMicro.copyFrom(groupPttDownReq.md5));
        long j3 = groupPttDownReq.groupFileID;
        if (j3 != 0) {
            cmd0x388_getptturlreq.uint64_fileid.set(j3);
        }
        cmd0x388_getptturlreq.uint32_req_platform_type.set(9);
        cmd0x388_getptturlreq.uint32_req_term.set(5);
        cmd0x388_getptturlreq.uint32_inner_ip.set(0);
        PBUInt32Field pBUInt32Field = cmd0x388_getptturlreq.uint32_bu_type;
        if (groupPttDownReq.uinType == 1) {
            i16 = 3;
        } else {
            i16 = 4;
        }
        pBUInt32Field.set(i16);
        cmd0x388_getptturlreq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
        cmd0x388_getptturlreq.uint32_codec.set(groupPttDownReq.voiceType);
        String str = groupPttDownReq.groupFileKey;
        if (str != null) {
            try {
                cmd0x388_getptturlreq.bytes_file_key.set(ByteStringMicro.copyFrom(str.getBytes("utf-8")));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        cmd0x388_getptturlreq.uint32_is_auto.set(groupPttDownReq.downType);
        cmd0x388_getptturlreq.uint32_req_transfer_type.set(2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "constructReqBody GroupPttDownReq = " + groupPttDownReq.toString());
        }
        cmd0x388_reqbody.rpt_msg_getptt_url_req.add(cmd0x388_getptturlreq);
    }

    byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        cmd0x388$ReqBody cmd0x388_reqbody = new cmd0x388$ReqBody();
        cmd0x388_reqbody.setHasFlag(true);
        cmd0x388_reqbody.uint32_subcmd.set(4);
        for (int i3 = 0; i3 < list.size(); i3++) {
            addOne(i3, list.get(i3), cmd0x388_reqbody);
        }
        int netType = NetworkCenter.getInstance().getNetType();
        int i16 = 3;
        if (netType != 1) {
            if (netType != 2) {
                if (netType != 3) {
                    if (netType == 4) {
                        i16 = 8;
                    }
                } else {
                    i16 = 7;
                }
            }
            i16 = 6;
        }
        String apnType = NetworkCenter.getInstance().getApnType();
        if (apnType != null && apnType.contains("wap")) {
            i16 = 5;
        }
        cmd0x388_reqbody.uint32_net_type.set(i16);
        return cmd0x388_reqbody.toByteArray();
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.GroupPttDownResp());
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
        if (fromServiceMsg == null) {
            return;
        }
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        RichProto.RichProtoReq richProtoReq = (RichProto.RichProtoReq) protoReq.busiData;
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        StatictisInfo statictisInfo = protoResp.statisInfo;
        if (fromServiceMsg.getResultCode() != 1000) {
            handleError(fromServiceMsg, richProtoResp, statictisInfo);
        } else if (handleSuccess(protoReq, fromServiceMsg, wupBuffer, richProtoReq, richProtoResp, statictisInfo)) {
            return;
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
            protoReq.ssoCmd = RichMediaConstants.CMD_LONGCONN_GROUPPTT_DOWN;
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
