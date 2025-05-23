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
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346$AddrList;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346$DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346$ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346$ExtensionRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346$RspBody;

/* loaded from: classes19.dex */
public class C2CPttDownHandler extends BaseHandler {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.richmedia.C2CPttDownHandler";
    int busiType;

    public C2CPttDownHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.busiType = 17;
        }
    }

    byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        int i3 = 1;
        if (list.size() == 1) {
            int i16 = 0;
            RichProto.RichProtoReq.C2CPttDownReq c2CPttDownReq = (RichProto.RichProtoReq.C2CPttDownReq) list.get(0);
            if ("ftn".equals(c2CPttDownReq.storageSource)) {
                this.busiType = 3;
            } else if ("pttcenter".equals(c2CPttDownReq.storageSource)) {
                this.busiType = 17;
            }
            cmd0x346$ApplyDownloadReq cmd0x346_applydownloadreq = new cmd0x346$ApplyDownloadReq();
            cmd0x346_applydownloadreq.uint64_uin.set(Long.parseLong(c2CPttDownReq.selfUin));
            cmd0x346_applydownloadreq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(c2CPttDownReq.uuid));
            PBUInt32Field pBUInt32Field = cmd0x346_applydownloadreq.uint32_owner_type;
            if (!c2CPttDownReq.isSelfSend) {
                i3 = 2;
            }
            pBUInt32Field.set(i3);
            cmd0x346_reqbody.uint32_cmd.set(1200);
            cmd0x346_reqbody.uint32_seq.set(0);
            cmd0x346_reqbody.uint32_business_id.set(this.busiType);
            cmd0x346_reqbody.uint32_client_type.set(104);
            cmd0x346_reqbody.msg_apply_download_req.set(cmd0x346_applydownloadreq);
            if (c2CPttDownReq.uinType != 0) {
                cmd0x346$ExtensionReq cmd0x346_extensionreq = new cmd0x346$ExtensionReq();
                cmd0x346_extensionreq.uint64_id.set(3L);
                int i17 = c2CPttDownReq.uinType;
                if (i17 != 1000) {
                    if (i17 != 1001) {
                        if (i17 != 1004) {
                            if (i17 != 1006) {
                                if (i17 != 1020) {
                                    if (i17 != 9999) {
                                        if (i17 != 10002 && i17 != 10004) {
                                            if (i17 != 1008) {
                                                if (i17 == 1009) {
                                                    i16 = 103;
                                                }
                                            } else {
                                                i16 = 101;
                                            }
                                        }
                                    } else {
                                        i16 = 114;
                                    }
                                }
                            } else {
                                i16 = 102;
                            }
                        } else {
                            i16 = 105;
                        }
                        cmd0x346_extensionreq.uint64_type.set(i16);
                        cmd0x346_extensionreq.uint32_ptt_format.set(c2CPttDownReq.voiceType);
                        cmd0x346_extensionreq.uint32_file_type.set(c2CPttDownReq.busiType);
                        cmd0x346_extensionreq.uint32_is_auto.set(c2CPttDownReq.downType);
                        cmd0x346_extensionreq.uint32_req_transfer_type.set(2);
                        cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
                    }
                    i16 = 100;
                    cmd0x346_extensionreq.uint64_type.set(i16);
                    cmd0x346_extensionreq.uint32_ptt_format.set(c2CPttDownReq.voiceType);
                    cmd0x346_extensionreq.uint32_file_type.set(c2CPttDownReq.busiType);
                    cmd0x346_extensionreq.uint32_is_auto.set(c2CPttDownReq.downType);
                    cmd0x346_extensionreq.uint32_req_transfer_type.set(2);
                    cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
                }
                i16 = 104;
                cmd0x346_extensionreq.uint64_type.set(i16);
                cmd0x346_extensionreq.uint32_ptt_format.set(c2CPttDownReq.voiceType);
                cmd0x346_extensionreq.uint32_file_type.set(c2CPttDownReq.busiType);
                cmd0x346_extensionreq.uint32_is_auto.set(c2CPttDownReq.downType);
                cmd0x346_extensionreq.uint32_req_transfer_type.set(2);
                cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
            } else {
                cmd0x346$ExtensionReq cmd0x346_extensionreq2 = new cmd0x346$ExtensionReq();
                cmd0x346_extensionreq2.uint32_ptt_format.set(c2CPttDownReq.voiceType);
                cmd0x346_extensionreq2.uint32_is_auto.set(c2CPttDownReq.downType);
                cmd0x346_extensionreq2.uint32_req_transfer_type.set(2);
                cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq2);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "constructReqBody C2CPttDownReq = " + c2CPttDownReq.toString());
            }
            return cmd0x346_reqbody.toByteArray();
        }
        throw new RuntimeException("only support one request");
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.C2CPttDownResp());
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        cmd0x346$AddrList cmd0x346_addrlist;
        String str;
        String str2;
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
        } else {
            try {
                cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
                cmd0x346_rspbody.mergeFrom(wupBuffer);
                cmd0x346$ApplyDownloadRsp cmd0x346_applydownloadrsp = cmd0x346_rspbody.msg_apply_download_rsp.get();
                RichProto.RichProtoResp.C2CPttDownResp c2CPttDownResp = (RichProto.RichProtoResp.C2CPttDownResp) richProtoResp.resps.get(0);
                if (c2CPttDownResp != null) {
                    c2CPttDownResp.isSendByQuickHttp = ((Boolean) fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP, Boolean.FALSE)).booleanValue();
                    if (QLog.isColorLevel()) {
                        QLog.e("http_sideway", 2, "C2CPttDownHandler.onProtoResp:isSendByQuickHttp=" + c2CPttDownResp.isSendByQuickHttp);
                    }
                    int i3 = cmd0x346_applydownloadrsp.int32_ret_code.get();
                    cmd0x346$ExtensionRsp cmd0x346_extensionrsp = cmd0x346_rspbody.msg_extension_rsp.get();
                    if (i3 == 0) {
                        cmd0x346$DownloadInfo cmd0x346_downloadinfo = cmd0x346_applydownloadrsp.msg_download_info.get();
                        if (cmd0x346_downloadinfo != null && cmd0x346_downloadinfo.str_download_url.has()) {
                            c2CPttDownResp.downloadUrl = cmd0x346_downloadinfo.str_download_url.get();
                            List<String> list = cmd0x346_downloadinfo.rpt_str_downloadip_list.get();
                            if (list != null && list.size() > 0) {
                                for (String str3 : list) {
                                    ServerAddr serverAddr = new ServerAddr();
                                    serverAddr.mIp = str3;
                                    c2CPttDownResp.mIpList.add(serverAddr);
                                }
                            }
                            if (cmd0x346_extensionrsp != null && cmd0x346_extensionrsp.server_addr_ipv6_list.has() && (cmd0x346_addrlist = cmd0x346_extensionrsp.server_addr_ipv6_list.get()) != null) {
                                List<String> list2 = cmd0x346_addrlist.rpt_str_ip.get();
                                int i16 = cmd0x346_addrlist.uint32_port.get();
                                if (list2 != null && list2.size() > 0) {
                                    for (String str4 : list2) {
                                        ServerAddr serverAddr2 = new ServerAddr();
                                        serverAddr2.mIp = str4;
                                        serverAddr2.port = i16;
                                        serverAddr2.isIpv6 = true;
                                        c2CPttDownResp.mIpv6List.add(serverAddr2);
                                    }
                                }
                                c2CPttDownResp.domainV4V6 = cmd0x346_addrlist.rpt_str_domain.get();
                            }
                            setResult(0, 0, "", "", statictisInfo, c2CPttDownResp);
                        } else {
                            throw new Exception("no url");
                        }
                    } else {
                        if (cmd0x346_extensionrsp != null && cmd0x346_extensionrsp.uint32_allow_retry.get() == 1) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "onReceive :c2c ptt server not allow retry");
                            }
                            c2CPttDownResp.isAllowRetry = false;
                        }
                        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i3), "", statictisInfo, c2CPttDownResp);
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
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.ssoCmd = RichMediaConstants.CMD_TEMP_PTT_DOWNLOAD;
            if (this.busiType == 3) {
                protoReq.ssoCmd = RichMediaConstants.CMD_OFFLINEFILE_PTT_DOWN;
            }
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
