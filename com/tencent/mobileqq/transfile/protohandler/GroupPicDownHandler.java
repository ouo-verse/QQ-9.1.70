package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388$GetImgUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388$GetImgUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388$IPv6Info;
import tencent.im.cs.cmd0x388.cmd0x388$ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388$RspBody;

/* loaded from: classes19.dex */
public class GroupPicDownHandler extends PicDownHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GroupPicDownHandler";

    public GroupPicDownHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void handleResponse(RichProto.RichProtoReq.GroupPicDownReq groupPicDownReq, cmd0x388$GetImgUrlRsp cmd0x388_getimgurlrsp, RichProto.RichProtoResp.PicDownResp picDownResp) throws UnknownHostException {
        String str;
        int i3 = groupPicDownReq.fileType;
        if (i3 == 65537) {
            str = cmd0x388_getimgurlrsp.bytes_thumb_down_para.get().toStringUtf8();
        } else if (i3 == 1) {
            str = cmd0x388_getimgurlrsp.bytes_big_down_para.get().toStringUtf8();
        } else if (i3 == 131075) {
            str = cmd0x388_getimgurlrsp.bytes_original_down_para.get().toStringUtf8();
        } else {
            str = null;
        }
        picDownResp.urlPath = str;
        if (cmd0x388_getimgurlrsp.rpt_uint32_down_ip.has() && cmd0x388_getimgurlrsp.rpt_uint32_down_ip.size() > 0 && cmd0x388_getimgurlrsp.rpt_uint32_down_port.has() && cmd0x388_getimgurlrsp.rpt_uint32_down_port.size() > 0) {
            List<Integer> list = cmd0x388_getimgurlrsp.rpt_uint32_down_ip.get();
            List<Integer> list2 = cmd0x388_getimgurlrsp.rpt_uint32_down_port.get();
            for (int i16 = 0; i16 < list.size(); i16++) {
                ServerAddr serverAddr = new ServerAddr();
                serverAddr.mIp = PkgTools.int2IPNet(list.get(i16).intValue() & 4294967295L);
                serverAddr.port = list2.get(i16).intValue();
                picDownResp.mIpList.add(i16, serverAddr);
            }
        }
        if (cmd0x388_getimgurlrsp.rpt_msg_down_ip6.has() && cmd0x388_getimgurlrsp.rpt_msg_down_ip6.size() > 0) {
            List<cmd0x388$IPv6Info> list3 = cmd0x388_getimgurlrsp.rpt_msg_down_ip6.get();
            for (int i17 = 0; i17 < list3.size(); i17++) {
                ServerAddr serverAddr2 = new ServerAddr();
                serverAddr2.mIp = InetAddress.getByAddress(list3.get(i17).bytes_ip6.get().toByteArray()).getHostAddress();
                serverAddr2.port = list3.get(i17).uint32_port.get();
                serverAddr2.isIpv6 = true;
                picDownResp.mIpv6List.add(i17, serverAddr2);
            }
        }
        if (cmd0x388_getimgurlrsp.bytes_down_domain.has()) {
            ServerAddr serverAddr3 = new ServerAddr();
            serverAddr3.mIp = cmd0x388_getimgurlrsp.bytes_down_domain.get().toStringUtf8();
            serverAddr3.port = 80;
            picDownResp.mIpList.add(serverAddr3);
            picDownResp.domain = serverAddr3.mIp;
        }
        if (cmd0x388_getimgurlrsp.uint32_https_url_flag.has()) {
            picDownResp.protocolType = cmd0x388_getimgurlrsp.uint32_https_url_flag.get();
        }
    }

    private static long parseLong(String str) {
        if (str == null) {
            QLog.i(TAG, 1, "[parseLong] input is null, stack=" + QLog.getStackTraceString(new RuntimeException()));
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e16) {
            QLog.i(TAG, 1, "[parseLong] exc=" + e16 + " stack=" + QLog.getStackTraceString(e16));
            return 0L;
        }
    }

    void addOne(int i3, RichProto.RichProtoReq.ReqCommon reqCommon, cmd0x388$ReqBody cmd0x388_reqbody) {
        RichProto.RichProtoReq.GroupPicDownReq groupPicDownReq = (RichProto.RichProtoReq.GroupPicDownReq) reqCommon;
        cmd0x388$GetImgUrlReq cmd0x388_getimgurlreq = new cmd0x388$GetImgUrlReq();
        cmd0x388_getimgurlreq.setHasFlag(true);
        cmd0x388_getimgurlreq.uint64_file_id.set(i3);
        cmd0x388_getimgurlreq.uint64_dst_uin.set(parseLong(groupPicDownReq.selfUin));
        cmd0x388_getimgurlreq.uint64_group_code.set(parseLong(groupPicDownReq.peerUin));
        cmd0x388_getimgurlreq.bytes_file_md5.set(ByteStringMicro.copyFrom(groupPicDownReq.md5));
        cmd0x388_getimgurlreq.uint32_pic_up_timestamp.set(groupPicDownReq.msgTime);
        long j3 = groupPicDownReq.groupFileID;
        if (j3 != 0) {
            cmd0x388_getimgurlreq.uint64_fileid.set(j3);
        }
        int i16 = groupPicDownReq.fileType;
        int i17 = 2;
        if (i16 == 65537) {
            cmd0x388_getimgurlreq.uint32_url_flag.set(1);
            cmd0x388_getimgurlreq.uint32_url_type.set(2);
        } else if (i16 == 1) {
            cmd0x388_getimgurlreq.uint32_url_flag.set(8);
            cmd0x388_getimgurlreq.uint32_url_type.set(3);
        } else if (i16 == 131075) {
            cmd0x388_getimgurlreq.uint32_url_flag.set(2);
            cmd0x388_getimgurlreq.uint32_url_type.set(4);
        }
        cmd0x388_getimgurlreq.uint32_req_platform_type.set(9);
        cmd0x388_getimgurlreq.uint32_req_term.set(5);
        cmd0x388_getimgurlreq.uint32_inner_ip.set(0);
        PBUInt32Field pBUInt32Field = cmd0x388_getimgurlreq.uint32_bu_type;
        if (groupPicDownReq.uinType == 1) {
            i17 = 1;
        }
        pBUInt32Field.set(i17);
        cmd0x388_getimgurlreq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
        cmd0x388_getimgurlreq.uint32_req_transfer_type.set(groupPicDownReq.protocolType);
        cmd0x388_reqbody.rpt_msg_getimg_url_req.add(cmd0x388_getimgurlreq);
        QLog.i(TAG, 1, "addOne, req=" + groupPicDownReq);
    }

    byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        cmd0x388$ReqBody cmd0x388_reqbody = new cmd0x388$ReqBody();
        cmd0x388_reqbody.setHasFlag(true);
        cmd0x388_reqbody.uint32_subcmd.set(2);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.qfix.redirect.IPatchRedirector] */
    /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.cs.cmd0x388.cmd0x388$RspBody, com.tencent.mobileqq.pb.MessageMicro] */
    /* JADX WARN: Type inference failed for: r11v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r19v8 */
    /* JADX WARN: Type inference failed for: r19v9 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object[]] */
    @Override // com.tencent.mobileqq.transfile.protohandler.PicDownHandler
    protected boolean handleSucResponse(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq, FromServiceMsg fromServiceMsg, byte[] bArr, RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo) {
        List<cmd0x388$GetImgUrlRsp> list;
        ?? r19;
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
            list = ((cmd0x388$RspBody) new cmd0x388$RspBody().mergeFrom(r112)).rpt_msg_getimg_url_rsp.get();
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
            for (cmd0x388$GetImgUrlRsp cmd0x388_getimgurlrsp : list) {
                try {
                    RichProto.RichProtoResp.PicDownResp picDownResp3 = (RichProto.RichProtoResp.PicDownResp) richProtoResp.resps.get((int) cmd0x388_getimgurlrsp.uint64_file_id.get());
                    try {
                        RichProto.RichProtoReq.GroupPicDownReq groupPicDownReq = (RichProto.RichProtoReq.GroupPicDownReq) richProtoReq.reqs.get(i17);
                        if (picDownResp3 != null) {
                            if (fromServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP)) {
                                try {
                                    picDownResp3.isSendByQuickHttp = ((Boolean) fromServiceMsg2.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP, Boolean.FALSE)).booleanValue();
                                } catch (Exception e18) {
                                    e = e18;
                                    r19 = i17;
                                    i3 = i16;
                                    str = str2;
                                    picDownResp = picDownResp3;
                                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, picDownResp);
                                    i16 = i3;
                                    str2 = str;
                                    i17 = r19;
                                    fromServiceMsg2 = fromServiceMsg;
                                }
                            }
                            int i18 = cmd0x388_getimgurlrsp.uint32_result.get();
                            if (i18 == 0) {
                                handleResponse(groupPicDownReq, cmd0x388_getimgurlrsp, picDownResp3);
                                picDownResp2 = picDownResp3;
                                r19 = i17;
                                i3 = i16;
                                str = str2;
                                try {
                                    setResult(0, 0, "", "", statictisInfo, picDownResp2);
                                } catch (Exception e19) {
                                    e = e19;
                                    picDownResp = picDownResp2;
                                    r19 = r19;
                                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, picDownResp);
                                    i16 = i3;
                                    str2 = str;
                                    i17 = r19;
                                    fromServiceMsg2 = fromServiceMsg;
                                }
                            } else {
                                picDownResp2 = picDownResp3;
                                r19 = i17;
                                i3 = i16;
                                str = str2;
                                if (shouldRetryByRetCodeForGroup(i18)) {
                                    int i19 = this.mReqUrlCount + 1;
                                    this.mReqUrlCount = i19;
                                    if (i19 < i3) {
                                        richProtoReq.protoReqMgr.sendProtoReq(protoReq);
                                        return r19;
                                    }
                                }
                                long j3 = i18;
                                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(j3), ProcessorReport.getUrlReason(j3), statictisInfo, picDownResp2);
                            }
                        } else {
                            r19 = i17;
                            i3 = i16;
                            str = str2;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        picDownResp2 = picDownResp3;
                        r19 = i17;
                        i3 = i16;
                        str = str2;
                    }
                } catch (Exception e27) {
                    e = e27;
                    r19 = i17;
                    i3 = i16;
                    str = str2;
                    picDownResp = null;
                }
                i16 = i3;
                str2 = str;
                i17 = r19;
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
            protoReq.ssoCmd = RichMediaConstants.CMD_LONGCONN_GROUPPIC_DOWN;
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
