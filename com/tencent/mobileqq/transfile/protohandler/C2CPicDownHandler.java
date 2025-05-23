package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.r;
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
import java.net.UnknownHostException;
import java.util.List;
import org.slf4j.Marker;
import tencent.im.cs.cmd0x352.cmd0x352$GetImgUrlReq;
import tencent.im.cs.cmd0x352.cmd0x352$GetImgUrlRsp;
import tencent.im.cs.cmd0x352.cmd0x352$IPv6Info;
import tencent.im.cs.cmd0x352.cmd0x352$ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352$RspBody;

/* loaded from: classes19.dex */
public class C2CPicDownHandler extends PicDownHandler {
    static IPatchRedirector $redirector_;

    public C2CPicDownHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void handleResponse(RichProto.RichProtoReq.C2CPicDownReq c2CPicDownReq, cmd0x352$GetImgUrlRsp cmd0x352_getimgurlrsp, RichProto.RichProtoResp.PicDownResp picDownResp) throws UnknownHostException {
        String stringUtf8;
        String stringUtf82;
        String stringUtf83;
        ByteStringMicro byteStringMicro = cmd0x352_getimgurlrsp.bytes_thumb_down_para.get();
        ByteStringMicro byteStringMicro2 = cmd0x352_getimgurlrsp.bytes_original_down_para.get();
        ByteStringMicro byteStringMicro3 = cmd0x352_getimgurlrsp.bytes_big_down_para.get();
        String str = null;
        if (byteStringMicro == null) {
            stringUtf8 = null;
        } else {
            stringUtf8 = byteStringMicro.toStringUtf8();
        }
        if (byteStringMicro2 == null) {
            stringUtf82 = null;
        } else {
            stringUtf82 = byteStringMicro2.toStringUtf8();
        }
        if (byteStringMicro3 == null) {
            stringUtf83 = null;
        } else {
            stringUtf83 = byteStringMicro3.toStringUtf8();
        }
        int i3 = c2CPicDownReq.fileType;
        if (i3 == 65537) {
            str = stringUtf8;
        } else if (i3 == 1) {
            str = stringUtf83;
        } else if (i3 == 131075) {
            str = stringUtf82;
        }
        picDownResp.urlPath = str;
        if (cmd0x352_getimgurlrsp.rpt_uint32_down_ip.has() && cmd0x352_getimgurlrsp.rpt_uint32_down_ip.size() > 0 && cmd0x352_getimgurlrsp.rpt_uint32_down_port.has() && cmd0x352_getimgurlrsp.rpt_uint32_down_port.size() > 0) {
            List<Integer> list = cmd0x352_getimgurlrsp.rpt_uint32_down_ip.get();
            List<Integer> list2 = cmd0x352_getimgurlrsp.rpt_uint32_down_port.get();
            for (int i16 = 0; i16 < list.size(); i16++) {
                ServerAddr serverAddr = new ServerAddr();
                serverAddr.mIp = PkgTools.int2IPNet(list.get(i16).intValue() & 4294967295L);
                serverAddr.port = list2.get(i16).intValue();
                picDownResp.mIpList.add(i16, serverAddr);
            }
        }
        if (cmd0x352_getimgurlrsp.rpt_msg_down_ip6.has() && cmd0x352_getimgurlrsp.rpt_msg_down_ip6.size() > 0) {
            List<cmd0x352$IPv6Info> list3 = cmd0x352_getimgurlrsp.rpt_msg_down_ip6.get();
            for (int i17 = 0; i17 < list3.size(); i17++) {
                ServerAddr serverAddr2 = new ServerAddr();
                serverAddr2.mIp = InetAddress.getByAddress(list3.get(i17).bytes_ip6.get().toByteArray()).getHostAddress();
                serverAddr2.port = list3.get(i17).uint32_port.get();
                serverAddr2.isIpv6 = true;
                picDownResp.mIpv6List.add(i17, serverAddr2);
            }
        }
        if (cmd0x352_getimgurlrsp.bytes_down_domain.has()) {
            ServerAddr serverAddr3 = new ServerAddr();
            serverAddr3.mIp = cmd0x352_getimgurlrsp.bytes_down_domain.get().toStringUtf8();
            serverAddr3.port = 80;
            picDownResp.mIpList.add(serverAddr3);
            picDownResp.domain = serverAddr3.mIp;
        }
        if (cmd0x352_getimgurlrsp.uint32_https_url_flag.has()) {
            picDownResp.protocolType = cmd0x352_getimgurlrsp.uint32_https_url_flag.get();
        }
    }

    void addOne(int i3, RichProto.RichProtoReq.ReqCommon reqCommon, cmd0x352$ReqBody cmd0x352_reqbody) {
        byte[] bArr;
        int i16;
        RichProto.RichProtoReq.C2CPicDownReq c2CPicDownReq = (RichProto.RichProtoReq.C2CPicDownReq) reqCommon;
        cmd0x352$GetImgUrlReq cmd0x352_getimgurlreq = new cmd0x352$GetImgUrlReq();
        int i17 = 1;
        cmd0x352_getimgurlreq.setHasFlag(true);
        cmd0x352_getimgurlreq.uint64_src_uin.set(Long.valueOf(c2CPicDownReq.peerUin).longValue());
        cmd0x352_getimgurlreq.uint32_pic_up_timestamp.set(c2CPicDownReq.msgTime);
        try {
            String str = c2CPicDownReq.selfUin;
            if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                str = str.substring(1);
            }
            cmd0x352_getimgurlreq.uint64_dst_uin.set(Long.valueOf(str).longValue());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            bArr = c2CPicDownReq.uuid.getBytes("utf-8");
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
            bArr = null;
        }
        cmd0x352_getimgurlreq.bytes_file_resid.set(ByteStringMicro.copyFrom(bArr));
        cmd0x352_getimgurlreq.bool_address_book.set(c2CPicDownReq.isContact);
        if ("ftn".equals(c2CPicDownReq.storageSource)) {
            cmd0x352_getimgurlreq.uint32_src_file_type.set(2);
        } else if ("picplatform".equals(c2CPicDownReq.storageSource)) {
            cmd0x352_getimgurlreq.uint32_src_file_type.set(1);
        } else {
            cmd0x352_getimgurlreq.uint32_src_file_type.set(255);
        }
        cmd0x352_getimgurlreq.uint32_req_term.set(5);
        cmd0x352_getimgurlreq.bool_address_book.set(c2CPicDownReq.isContact);
        cmd0x352_getimgurlreq.uint32_req_platform_type.set(9);
        cmd0x352_getimgurlreq.uint32_bu_type.set(1);
        int i18 = c2CPicDownReq.fileType;
        if (i18 == 65537) {
            i16 = 4;
        } else if (i18 == 1) {
            i16 = 6;
            i17 = 8;
        } else if (i18 == 131075) {
            i16 = 16;
            i17 = 2;
        } else {
            i17 = 0;
            i16 = 0;
        }
        cmd0x352_getimgurlreq.uint32_url_type.set(i16);
        cmd0x352_getimgurlreq.uint32_url_flag.set(i17);
        cmd0x352_getimgurlreq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
        cmd0x352_getimgurlreq.uint32_req_transfer_type.set(c2CPicDownReq.protocolType);
        cmd0x352_reqbody.rpt_msg_getimg_url_req.add(cmd0x352_getimgurlreq);
    }

    byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        cmd0x352$ReqBody cmd0x352_reqbody = new cmd0x352$ReqBody();
        cmd0x352_reqbody.setHasFlag(true);
        cmd0x352_reqbody.uint32_subcmd.set(2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            addOne(i3, list.get(i3), cmd0x352_reqbody);
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
        cmd0x352_reqbody.uint32_net_type.set(i16);
        return cmd0x352_reqbody.toByteArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.qfix.redirect.IPatchRedirector] */
    /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.cs.cmd0x352.cmd0x352$RspBody, com.tencent.mobileqq.pb.MessageMicro] */
    /* JADX WARN: Type inference failed for: r11v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object[]] */
    @Override // com.tencent.mobileqq.transfile.protohandler.PicDownHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean handleSucResponse(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq, FromServiceMsg fromServiceMsg, byte[] bArr, RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo) {
        List<cmd0x352$GetImgUrlRsp> list;
        ?? r18;
        int i3;
        String str;
        RichProto.RichProtoResp.PicDownResp picDownResp;
        RichProto.RichProtoResp.PicDownResp picDownResp2;
        FromServiceMsg fromServiceMsg2 = fromServiceMsg;
        ?? r112 = bArr;
        String str2 = "P";
        ?? r06 = $redirector_;
        int i16 = 2;
        int i17 = 0;
        if (r06 != 0 && r06.hasPatch((short) 3)) {
            return ((Boolean) r06.redirect((short) 3, new Object[]{this, protoResp, protoReq, fromServiceMsg2, r112, richProtoReq, richProtoResp, statictisInfo})).booleanValue();
        }
        try {
            list = ((cmd0x352$RspBody) new cmd0x352$RspBody().mergeFrom(r112)).rpt_msg_getimg_url_rsp.get();
            try {
            } catch (Exception e16) {
                e = e16;
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(r112, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, richProtoResp.resps);
                return true;
            }
        } catch (Exception e17) {
            e = e17;
            r112 = str2;
        }
        if (list != null && list.size() != 0) {
            for (cmd0x352$GetImgUrlRsp cmd0x352_getimgurlrsp : list) {
                try {
                    RichProto.RichProtoResp.PicDownResp picDownResp3 = (RichProto.RichProtoResp.PicDownResp) richProtoResp.resps.get(i17);
                    try {
                        RichProto.RichProtoReq.C2CPicDownReq c2CPicDownReq = (RichProto.RichProtoReq.C2CPicDownReq) richProtoReq.reqs.get(i17);
                        if (picDownResp3 != null) {
                            if (fromServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP)) {
                                try {
                                    picDownResp3.isSendByQuickHttp = ((Boolean) fromServiceMsg2.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP, Boolean.FALSE)).booleanValue();
                                } catch (Exception e18) {
                                    e = e18;
                                    r18 = i17;
                                    i3 = i16;
                                    str = str2;
                                    picDownResp = picDownResp3;
                                    if (picDownResp == null) {
                                        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, picDownResp);
                                    }
                                    i16 = i3;
                                    str2 = str;
                                    i17 = r18;
                                    fromServiceMsg2 = fromServiceMsg;
                                }
                            }
                            int i18 = cmd0x352_getimgurlrsp.uint32_result.get();
                            if (i18 == 0) {
                                handleResponse(c2CPicDownReq, cmd0x352_getimgurlrsp, picDownResp3);
                                picDownResp2 = picDownResp3;
                                r18 = i17;
                                i3 = i16;
                                str = str2;
                                try {
                                    setResult(0, 0, "", "", statictisInfo, picDownResp2);
                                } catch (Exception e19) {
                                    e = e19;
                                    picDownResp = picDownResp2;
                                    r18 = r18;
                                    if (picDownResp == null) {
                                    }
                                    i16 = i3;
                                    str2 = str;
                                    i17 = r18;
                                    fromServiceMsg2 = fromServiceMsg;
                                }
                            } else {
                                picDownResp2 = picDownResp3;
                                r18 = i17;
                                i3 = i16;
                                str = str2;
                                if (C2CPicUpHandler.shouldRetryByRetCode(i18)) {
                                    int i19 = this.mReqUrlCount + 1;
                                    this.mReqUrlCount = i19;
                                    if (i19 < i3) {
                                        richProtoReq.protoReqMgr.sendProtoReq(protoReq);
                                        return r18;
                                    }
                                }
                                if (i18 == 201 && QLog.isColorLevel()) {
                                    r.a("Download_C2C_Pic_Request_Error_Param_Check", c2CPicDownReq.uuid);
                                }
                                long j3 = i18;
                                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(j3), ProcessorReport.getUrlReason(j3), statictisInfo, picDownResp2);
                            }
                        } else {
                            r18 = i17;
                            i3 = i16;
                            str = str2;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        picDownResp2 = picDownResp3;
                        r18 = i17;
                        i3 = i16;
                        str = str2;
                    }
                } catch (Exception e27) {
                    e = e27;
                    r18 = i17;
                    i3 = i16;
                    str = str2;
                    picDownResp = null;
                }
                i16 = i3;
                str2 = str;
                i17 = r18;
                fromServiceMsg2 = fromServiceMsg;
            }
            return true;
        }
        throw new Exception("resps null");
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.PicDownResp());
        }
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
            protoReq.ssoCmd = RichMediaConstants.CMD_LONGCONN_OFFPIC_DOWN;
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
