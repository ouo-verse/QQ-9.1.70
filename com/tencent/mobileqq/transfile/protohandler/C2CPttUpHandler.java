package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.slf4j.Marker;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346$RspBody;

/* loaded from: classes19.dex */
public class C2CPttUpHandler extends BaseHandler {
    static IPatchRedirector $redirector_;
    private static int s0x346Seq;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76048);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            s0x346Seq = 0;
        }
    }

    public C2CPttUpHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0163, code lost:
    
        if (r12.forceViaOffline != false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        int i3 = 500;
        cmd0x346_reqbody.uint32_cmd.set(500);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i16 = s0x346Seq;
        s0x346Seq = i16 + 1;
        pBUInt32Field.set(i16);
        cmd0x346_reqbody.uint32_business_id.set(17);
        cmd0x346_reqbody.uint32_client_type.set(104);
        if (list.size() == 1) {
            RichProto.RichProtoReq.PttUpReq pttUpReq = (RichProto.RichProtoReq.PttUpReq) list.get(0);
            cmd0x346$ApplyUploadReq cmd0x346_applyuploadreq = new cmd0x346$ApplyUploadReq();
            cmd0x346_applyuploadreq.uint64_sender_uin.set(Long.parseLong(pttUpReq.selfUin));
            try {
                String str = pttUpReq.peerUin;
                if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                    str = str.substring(1);
                }
                cmd0x346_applyuploadreq.uint64_recver_uin.set(Long.valueOf(str).longValue());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            cmd0x346_applyuploadreq.uint32_file_type.set(2);
            cmd0x346_applyuploadreq.str_file_name.set(pttUpReq.fileName);
            cmd0x346_applyuploadreq.uint64_file_size.set(pttUpReq.fileSize);
            cmd0x346_applyuploadreq.bytes_10m_md5.set(ByteStringMicro.copyFrom(pttUpReq.md5));
            cmd0x346_reqbody.msg_apply_upload_req.set(cmd0x346_applyuploadreq);
            cmd0x346$ExtensionReq cmd0x346_extensionreq = new cmd0x346$ExtensionReq();
            cmd0x346_extensionreq.uint64_id.set(3L);
            cmd0x346_extensionreq.uint32_ptt_format.set(pttUpReq.voiceType);
            cmd0x346_extensionreq.uint32_ptt_time.set(pttUpReq.voiceLength);
            int handlerNetType = BaseHandler.getHandlerNetType();
            cmd0x346_extensionreq.uint32_net_type.set(handlerNetType);
            cmd0x346_extensionreq.uint32_voice_type.set(pttUpReq.audioPanelType);
            if (QLog.isColorLevel()) {
                QLog.d("RecordParams", 2, "C2CPttUp: panel[" + pttUpReq.audioPanelType + "] type[" + pttUpReq.voiceType + "] length[" + pttUpReq.voiceLength + "] size[" + pttUpReq.fileSize + "]");
                if (QLog.isColorLevel()) {
                    QLog.d("RecordParams", 2, "C2CPttUp: net[" + handlerNetType + "]");
                }
            }
            int i17 = pttUpReq.uinType;
            if (i17 != 0) {
                if (i17 != 1004) {
                    if (i17 != 1006) {
                        if (i17 != 1020) {
                            if (i17 != 9999) {
                                if (i17 != 10002 && i17 != 10004) {
                                    if (i17 != 1000) {
                                        if (i17 != 1001) {
                                            if (i17 != 1008) {
                                                if (i17 == 1009) {
                                                    i3 = 103;
                                                }
                                                i3 = 0;
                                            } else {
                                                i3 = 101;
                                            }
                                        }
                                    }
                                }
                                i3 = 100;
                            } else {
                                i3 = 114;
                            }
                        }
                        i3 = 104;
                    } else {
                        cmd0x346_extensionreq.str_dst_phonenum.set(pttUpReq.peerUin);
                        i3 = 102;
                    }
                } else {
                    i3 = 105;
                }
            }
            cmd0x346_extensionreq.uint64_type.set(i3);
            int i18 = pttUpReq.uinType;
            if (i18 == 1008) {
                cmd0x346_extensionreq.uint32_file_type.set(3);
            } else if (i18 == 9999) {
                cmd0x346_extensionreq.uint32_file_type.set(102);
            }
            cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
            return cmd0x346_reqbody.toByteArray();
        }
        throw new RuntimeException("only support one request");
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.C2CPttUpResp());
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        String str;
        String str2;
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
                cmd0x346$ApplyUploadRsp cmd0x346_applyuploadrsp = cmd0x346_rspbody.msg_apply_upload_rsp.get();
                RichProto.RichProtoResp.C2CPttUpResp c2CPttUpResp = (RichProto.RichProtoResp.C2CPttUpResp) richProtoResp.resps.get(0);
                if (c2CPttUpResp != null) {
                    if (fromServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP)) {
                        c2CPttUpResp.isSendByQuickHttp = ((Boolean) fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP, Boolean.FALSE)).booleanValue();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("http_sideway", 2, "C2CPttUpHandler.onProtoResp:isSendByQuickHttp=" + c2CPttUpResp.isSendByQuickHttp);
                    }
                    int i3 = cmd0x346_applyuploadrsp.int32_ret_code.get();
                    if (i3 == 0) {
                        c2CPttUpResp.uuid = cmd0x346_applyuploadrsp.bytes_uuid.get().toStringUtf8();
                        if (cmd0x346_applyuploadrsp.bool_file_exist.has() && cmd0x346_applyuploadrsp.bool_file_exist.get()) {
                            c2CPttUpResp.isExist = true;
                        } else {
                            if (cmd0x346_applyuploadrsp.uint32_pack_size.has()) {
                                c2CPttUpResp.blockSize = cmd0x346_applyuploadrsp.uint32_pack_size.get();
                            }
                            String bytes2HexStr = HexUtil.bytes2HexStr(cmd0x346_applyuploadrsp.bytes_upload_key.get().toByteArray());
                            c2CPttUpResp.mUkey = bytes2HexStr;
                            String str3 = cmd0x346_applyuploadrsp.str_upload_ip.get();
                            if (str3 == null) {
                                str3 = cmd0x346_applyuploadrsp.str_upload_domain.get();
                            }
                            if (bytes2HexStr != null && str3 != null) {
                                List<String> list = cmd0x346_applyuploadrsp.rpt_str_uploadip_list.get();
                                if (list != null && list.size() > 0) {
                                    for (String str4 : list) {
                                        ServerAddr serverAddr = new ServerAddr();
                                        serverAddr.mIp = str4;
                                        c2CPttUpResp.ipList.add(serverAddr);
                                    }
                                }
                                setResult(0, 0, "", "", statictisInfo, c2CPttUpResp);
                            } else {
                                throw new Exception("ukey or ip missing");
                            }
                        }
                    } else {
                        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i3), "", statictisInfo, c2CPttUpResp);
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
            protoReq.ssoCmd = RichMediaConstants.CMD_TEMP_PTT_UPLOAD;
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
