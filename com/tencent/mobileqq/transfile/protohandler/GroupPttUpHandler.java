package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388$ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388$RspBody;
import tencent.im.cs.cmd0x388.cmd0x388$TryUpPttReq;
import tencent.im.cs.cmd0x388.cmd0x388$TryUpPttRsp;

/* loaded from: classes19.dex */
public class GroupPttUpHandler extends BaseHandler {
    static IPatchRedirector $redirector_;

    public GroupPttUpHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    void addOne(int i3, RichProto.RichProtoReq.ReqCommon reqCommon, cmd0x388$ReqBody cmd0x388_reqbody) {
        int i16;
        RichProto.RichProtoReq.PttUpReq pttUpReq = (RichProto.RichProtoReq.PttUpReq) reqCommon;
        cmd0x388$TryUpPttReq cmd0x388_tryuppttreq = new cmd0x388$TryUpPttReq();
        cmd0x388_tryuppttreq.setHasFlag(true);
        cmd0x388_tryuppttreq.uint64_src_uin.set(Long.valueOf(pttUpReq.selfUin).longValue());
        cmd0x388_tryuppttreq.uint64_group_code.set(Long.valueOf(pttUpReq.peerUin).longValue());
        cmd0x388_tryuppttreq.uint64_file_id.set(i3);
        cmd0x388_tryuppttreq.uint64_file_size.set(pttUpReq.fileSize);
        cmd0x388_tryuppttreq.bytes_file_md5.set(ByteStringMicro.copyFrom(pttUpReq.md5));
        cmd0x388_tryuppttreq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(pttUpReq.fileName));
        cmd0x388_tryuppttreq.uint32_src_term.set(5);
        cmd0x388_tryuppttreq.uint32_platform_type.set(9);
        PBUInt32Field pBUInt32Field = cmd0x388_tryuppttreq.uint32_bu_type;
        if (pttUpReq.uinType == 1) {
            i16 = 3;
        } else {
            i16 = 4;
        }
        pBUInt32Field.set(i16);
        cmd0x388_tryuppttreq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
        cmd0x388_tryuppttreq.uint32_voice_length.set(pttUpReq.voiceLength);
        cmd0x388_tryuppttreq.uint32_codec.set(pttUpReq.voiceType);
        cmd0x388_tryuppttreq.uint32_voice_type.set(pttUpReq.audioPanelType);
        cmd0x388_tryuppttreq.bool_new_up_chan.set(true);
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "GroupPttUp: panel[" + pttUpReq.audioPanelType + "] type[" + pttUpReq.voiceType + "] length[" + pttUpReq.voiceLength + "] size[" + pttUpReq.fileSize + "]");
        }
        cmd0x388_reqbody.rpt_msg_tryup_ptt_req.add(cmd0x388_tryuppttreq);
    }

    byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        cmd0x388$ReqBody cmd0x388_reqbody = new cmd0x388$ReqBody();
        cmd0x388_reqbody.setHasFlag(true);
        cmd0x388_reqbody.uint32_subcmd.set(3);
        for (int i3 = 0; i3 < list.size(); i3++) {
            addOne(i3, list.get(i3), cmd0x388_reqbody);
        }
        int handlerNetType = BaseHandler.getHandlerNetType();
        cmd0x388_reqbody.uint32_net_type.set(handlerNetType);
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "GroupPttUp: net[" + handlerNetType + "]");
        }
        return cmd0x388_reqbody.toByteArray();
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.GroupPttUpResp());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v3, types: [long] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [long] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.tencent.qphone.base.remote.FromServiceMsg] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.protohandler.GroupPttUpHandler, java.lang.Object] */
    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        StatictisInfo statictisInfo;
        String str;
        byte[] bArr;
        String str2;
        String str3;
        FromServiceMsg fromServiceMsg;
        String str4;
        RichProto.RichProtoResp.GroupPttUpResp groupPttUpResp;
        String str5;
        String str6;
        long j3;
        RichProto.RichProtoResp.GroupPttUpResp groupPttUpResp2;
        String str7;
        String str8;
        ?? r102 = " hex:";
        String str9 = "P";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) protoResp, (Object) protoReq);
            return;
        }
        ?? r122 = protoResp.resp;
        byte[] wupBuffer = r122.getWupBuffer();
        RichProto.RichProtoReq richProtoReq = (RichProto.RichProtoReq) protoReq.busiData;
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        StatictisInfo statictisInfo2 = protoResp.statisInfo;
        String str10 = "";
        if (r122.getResultCode() != 1000) {
            int resultCode = r122.getResultCode();
            if (resultCode != 1002 && resultCode != 1013) {
                String timeoutReason = BaseMessageHandler.getTimeoutReason(r122);
                String businessFailMsg = r122.getBusinessFailMsg();
                if (businessFailMsg == null) {
                    str8 = "";
                } else {
                    str8 = businessFailMsg;
                }
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQUEST_MSF_ERROR, timeoutReason, str8, statictisInfo2, richProtoResp.resps);
            } else {
                String timeoutReason2 = BaseMessageHandler.getTimeoutReason(r122);
                String businessFailMsg2 = r122.getBusinessFailMsg();
                if (businessFailMsg2 == null) {
                    str7 = "";
                } else {
                    str7 = businessFailMsg2;
                }
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT, timeoutReason2, str7, statictisInfo2, richProtoResp.resps);
            }
        } else {
            try {
                List<cmd0x388$TryUpPttRsp> list = new cmd0x388$RspBody().mergeFrom(wupBuffer).rpt_msg_tryup_ptt_rsp.get();
                try {
                    if (list != null && list.size() != 0) {
                        r102 = r102;
                        FromServiceMsg fromServiceMsg2 = r122;
                        for (cmd0x388$TryUpPttRsp cmd0x388_tryuppttrsp : list) {
                            try {
                                RichProto.RichProtoResp.GroupPttUpResp groupPttUpResp3 = (RichProto.RichProtoResp.GroupPttUpResp) richProtoResp.resps.get((int) cmd0x388_tryuppttrsp.uint64_file_id.get());
                                try {
                                    groupPttUpResp3.isSendByQuickHttp = ((Boolean) fromServiceMsg2.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP, Boolean.FALSE)).booleanValue();
                                    if (QLog.isColorLevel()) {
                                        try {
                                            QLog.e("http_sideway", 2, "GroupPttUpHandler.onProtoResp:isSendByQuickHttp=" + groupPttUpResp3.isSendByQuickHttp);
                                        } catch (Exception e16) {
                                            e = e16;
                                            statictisInfo = statictisInfo2;
                                            str2 = r102;
                                            str3 = str9;
                                            fromServiceMsg = fromServiceMsg2;
                                            bArr = wupBuffer;
                                            r102 = -9529;
                                            groupPttUpResp = groupPttUpResp3;
                                            str4 = str10;
                                            r122 = str3;
                                            try {
                                                String serverReason = ProcessorReport.getServerReason(r122, r102);
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append(e.getMessage());
                                                str5 = str2;
                                                try {
                                                    sb5.append(str5);
                                                    sb5.append(HexUtil.bytes2HexStr(bArr));
                                                    str6 = str5;
                                                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, serverReason, sb5.toString(), statictisInfo, groupPttUpResp);
                                                    str9 = r122;
                                                    str10 = str4;
                                                    statictisInfo2 = statictisInfo;
                                                    wupBuffer = bArr;
                                                    fromServiceMsg2 = fromServiceMsg;
                                                    r102 = str6;
                                                } catch (Exception e17) {
                                                    e = e17;
                                                    str = str5;
                                                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(r122, r102), e.getMessage() + str + HexUtil.bytes2HexStr(bArr), statictisInfo, richProtoResp.resps);
                                                    RichProtoProc.onBusiProtoResp(richProtoReq, richProtoResp);
                                                }
                                            } catch (Exception e18) {
                                                e = e18;
                                                str = str2;
                                            }
                                        }
                                    }
                                    int i3 = cmd0x388_tryuppttrsp.uint32_result.get();
                                    if (i3 == 0) {
                                        groupPttUpResp3.groupFileID = cmd0x388_tryuppttrsp.uint64_fileid.get();
                                        if (cmd0x388_tryuppttrsp.bytes_file_key.has()) {
                                            groupPttUpResp3.groupFileKey = cmd0x388_tryuppttrsp.bytes_file_key.get().toByteArray();
                                        }
                                        if (cmd0x388_tryuppttrsp.bool_file_exit.has() && cmd0x388_tryuppttrsp.bool_file_exit.get()) {
                                            groupPttUpResp3.isExist = true;
                                            str2 = r102;
                                            str3 = str9;
                                            fromServiceMsg = fromServiceMsg2;
                                            bArr = wupBuffer;
                                        } else {
                                            List<Integer> list2 = cmd0x388_tryuppttrsp.rpt_uint32_up_ip.get();
                                            List<Integer> list3 = cmd0x388_tryuppttrsp.rpt_uint32_up_port.get();
                                            if (list2 != null) {
                                                try {
                                                    if (list2.size() > 0) {
                                                        int i16 = 0;
                                                        r102 = r102;
                                                        fromServiceMsg2 = fromServiceMsg2;
                                                        while (i16 < list2.size()) {
                                                            fromServiceMsg = fromServiceMsg2;
                                                            bArr = wupBuffer;
                                                            long intValue = list2.get(i16).intValue() & 4294967295L;
                                                            try {
                                                                str2 = r102;
                                                                str3 = str9;
                                                                long intValue2 = list3.get(i16).intValue();
                                                                try {
                                                                    ServerAddr serverAddr = new ServerAddr();
                                                                    serverAddr.mIp = PkgTools.int2IPNet(intValue);
                                                                    serverAddr.port = (int) intValue2;
                                                                    groupPttUpResp3.ipList.add(i16, serverAddr);
                                                                    i16++;
                                                                    wupBuffer = bArr;
                                                                    fromServiceMsg2 = fromServiceMsg;
                                                                    r102 = str2;
                                                                    str9 = str3;
                                                                } catch (Exception e19) {
                                                                    e = e19;
                                                                    str4 = str10;
                                                                    statictisInfo = statictisInfo2;
                                                                    r102 = -9529;
                                                                    groupPttUpResp = groupPttUpResp3;
                                                                    r122 = str3;
                                                                    String serverReason2 = ProcessorReport.getServerReason(r122, r102);
                                                                    StringBuilder sb52 = new StringBuilder();
                                                                    sb52.append(e.getMessage());
                                                                    str5 = str2;
                                                                    sb52.append(str5);
                                                                    sb52.append(HexUtil.bytes2HexStr(bArr));
                                                                    str6 = str5;
                                                                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, serverReason2, sb52.toString(), statictisInfo, groupPttUpResp);
                                                                    str9 = r122;
                                                                    str10 = str4;
                                                                    statictisInfo2 = statictisInfo;
                                                                    wupBuffer = bArr;
                                                                    fromServiceMsg2 = fromServiceMsg;
                                                                    r102 = str6;
                                                                }
                                                            } catch (Exception e26) {
                                                                e = e26;
                                                                str2 = r102;
                                                                str3 = str9;
                                                            }
                                                        }
                                                    }
                                                } catch (Exception e27) {
                                                    e = e27;
                                                    str2 = r102;
                                                    str3 = str9;
                                                    fromServiceMsg = fromServiceMsg2;
                                                    bArr = wupBuffer;
                                                }
                                            }
                                            str2 = r102;
                                            str3 = str9;
                                            fromServiceMsg = fromServiceMsg2;
                                            bArr = wupBuffer;
                                            try {
                                                String bytes2HexStr = HexUtil.bytes2HexStr(cmd0x388_tryuppttrsp.bytes_up_ukey.get().toByteArray());
                                                if (bytes2HexStr != null && !bytes2HexStr.equals(str10) && list2 != null && list2.size() != 0) {
                                                    groupPttUpResp3.mUkey = bytes2HexStr;
                                                    groupPttUpResp3.blockSize = (int) cmd0x388_tryuppttrsp.uint64_block_size.get();
                                                    groupPttUpResp3.transferedSize = (int) cmd0x388_tryuppttrsp.uint64_up_offset.get();
                                                } else {
                                                    throw new Exception("check ukey,iplist");
                                                }
                                            } catch (Exception e28) {
                                                e = e28;
                                                groupPttUpResp2 = groupPttUpResp3;
                                                str4 = str10;
                                                statictisInfo = statictisInfo2;
                                                j3 = -9529;
                                                groupPttUpResp = groupPttUpResp2;
                                                r102 = j3;
                                                r122 = str3;
                                                String serverReason22 = ProcessorReport.getServerReason(r122, r102);
                                                StringBuilder sb522 = new StringBuilder();
                                                sb522.append(e.getMessage());
                                                str5 = str2;
                                                sb522.append(str5);
                                                sb522.append(HexUtil.bytes2HexStr(bArr));
                                                str6 = str5;
                                                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, serverReason22, sb522.toString(), statictisInfo, groupPttUpResp);
                                                str9 = r122;
                                                str10 = str4;
                                                statictisInfo2 = statictisInfo;
                                                wupBuffer = bArr;
                                                fromServiceMsg2 = fromServiceMsg;
                                                r102 = str6;
                                            }
                                        }
                                        j3 = -9529;
                                        groupPttUpResp2 = groupPttUpResp3;
                                        str4 = str10;
                                        statictisInfo = statictisInfo2;
                                        try {
                                            setResult(0, 0, "", "", statictisInfo2, groupPttUpResp2);
                                        } catch (Exception e29) {
                                            e = e29;
                                            groupPttUpResp = groupPttUpResp2;
                                            r102 = j3;
                                            r122 = str3;
                                            String serverReason222 = ProcessorReport.getServerReason(r122, r102);
                                            StringBuilder sb5222 = new StringBuilder();
                                            sb5222.append(e.getMessage());
                                            str5 = str2;
                                            sb5222.append(str5);
                                            sb5222.append(HexUtil.bytes2HexStr(bArr));
                                            str6 = str5;
                                            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, serverReason222, sb5222.toString(), statictisInfo, groupPttUpResp);
                                            str9 = r122;
                                            str10 = str4;
                                            statictisInfo2 = statictisInfo;
                                            wupBuffer = bArr;
                                            fromServiceMsg2 = fromServiceMsg;
                                            r102 = str6;
                                        }
                                    } else {
                                        statictisInfo = statictisInfo2;
                                        str2 = r102;
                                        str3 = str9;
                                        fromServiceMsg = fromServiceMsg2;
                                        bArr = wupBuffer;
                                        str4 = str10;
                                        if (shouldRetryByRetCodeForGroup(i3)) {
                                            int i17 = this.mReqUrlCount + 1;
                                            this.mReqUrlCount = i17;
                                            if (i17 < 2) {
                                                richProtoReq.protoReqMgr.sendProtoReq(protoReq);
                                                return;
                                            }
                                        }
                                        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i3), "", statictisInfo, groupPttUpResp3);
                                    }
                                    str6 = str2;
                                    r122 = str3;
                                } catch (Exception e36) {
                                    e = e36;
                                    statictisInfo = statictisInfo2;
                                    str2 = r102;
                                    str3 = str9;
                                    fromServiceMsg = fromServiceMsg2;
                                    bArr = wupBuffer;
                                    j3 = -9529;
                                    groupPttUpResp2 = groupPttUpResp3;
                                    str4 = str10;
                                }
                            } catch (Exception e37) {
                                e = e37;
                                statictisInfo = statictisInfo2;
                                str2 = r102;
                                str3 = str9;
                                fromServiceMsg = fromServiceMsg2;
                                bArr = wupBuffer;
                                r102 = -9529;
                                str4 = str10;
                                groupPttUpResp = null;
                            }
                            str9 = r122;
                            str10 = str4;
                            statictisInfo2 = statictisInfo;
                            wupBuffer = bArr;
                            fromServiceMsg2 = fromServiceMsg;
                            r102 = str6;
                        }
                    } else {
                        throw new Exception("resps null");
                    }
                } catch (Exception e38) {
                    e = e38;
                }
            } catch (Exception e39) {
                e = e39;
                statictisInfo = statictisInfo2;
                str = r102;
                r122 = str9;
                bArr = wupBuffer;
                r102 = -9529;
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
            protoReq.ssoCmd = RichMediaConstants.CMD_LONGCONN_GROUPPTT_UP;
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
