package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
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
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388$ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388$RspBody;
import tencent.im.cs.cmd0x388.cmd0x388$TryUpImgReq;
import tencent.im.cs.cmd0x388.cmd0x388$TryUpImgRsp;
import tencent.im.cs.cmd0x388.cmd0x388$TryUpInfo4Busi;

/* compiled from: P */
/* loaded from: classes19.dex */
public class BDHCommonUpHandler extends BaseHandler {
    static IPatchRedirector $redirector_;
    int mReqNetType;

    public BDHCommonUpHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void handleBusSuc(RichProto.RichProtoResp.BDHCommonUpResp bDHCommonUpResp, cmd0x388$TryUpImgRsp cmd0x388_tryupimgrsp) throws Exception {
        if (cmd0x388_tryupimgrsp.msg_info4busi.has()) {
            cmd0x388$TryUpInfo4Busi cmd0x388_tryupinfo4busi = cmd0x388_tryupimgrsp.msg_info4busi.get();
            if (cmd0x388_tryupinfo4busi.bytes_down_domain.has()) {
                bDHCommonUpResp.downDomain = cmd0x388_tryupinfo4busi.bytes_down_domain.get().toStringUtf8();
            }
            if (cmd0x388_tryupinfo4busi.bytes_big_down_url.has()) {
                bDHCommonUpResp.bigDownUrl = cmd0x388_tryupinfo4busi.bytes_big_down_url.get().toStringUtf8();
            }
            if (cmd0x388_tryupinfo4busi.bytes_original_down_url.has()) {
                bDHCommonUpResp.orgiDownUrl = cmd0x388_tryupinfo4busi.bytes_original_down_url.get().toStringUtf8();
            }
            if (cmd0x388_tryupinfo4busi.bytes_thumb_down_url.has()) {
                bDHCommonUpResp.thumbDownUrl = cmd0x388_tryupinfo4busi.bytes_thumb_down_url.get().toStringUtf8();
            }
            if (cmd0x388_tryupinfo4busi.bytes_file_resid.has()) {
                bDHCommonUpResp.resid = cmd0x388_tryupinfo4busi.bytes_file_resid.get().toStringUtf8();
            }
        }
        bDHCommonUpResp.groupFileID = cmd0x388_tryupimgrsp.uint64_fileid.get();
        List<Integer> list = cmd0x388_tryupimgrsp.rpt_uint32_up_ip.get();
        List<Integer> list2 = cmd0x388_tryupimgrsp.rpt_uint32_up_port.get();
        boolean z16 = false;
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                long intValue = list2.get(i3).intValue();
                ServerAddr serverAddr = new ServerAddr();
                serverAddr.mIp = PkgTools.int2IPNet(list.get(i3).intValue() & 4294967295L);
                serverAddr.port = (int) intValue;
                bDHCommonUpResp.mIpList.add(i3, serverAddr);
            }
        }
        if (cmd0x388_tryupimgrsp.bool_file_exit.has() && cmd0x388_tryupimgrsp.bool_file_exit.get()) {
            bDHCommonUpResp.isExist = true;
            return;
        }
        String bytes2HexStr = HexUtil.bytes2HexStr(cmd0x388_tryupimgrsp.bytes_up_ukey.get().toByteArray());
        if (bytes2HexStr != null && !bytes2HexStr.equals("") && list != null && list.size() != 0) {
            bDHCommonUpResp.mUkey = bytes2HexStr;
            bDHCommonUpResp.blockSize = (int) cmd0x388_tryupimgrsp.uint64_block_size.get();
            bDHCommonUpResp.transferedSize = (int) cmd0x388_tryupimgrsp.uint64_up_offset.get();
            if (NetworkCenter.getInstance().getNetType() != this.mReqNetType) {
                z16 = true;
            }
            bDHCommonUpResp.networkChange = z16;
            bDHCommonUpResp.startOffset = cmd0x388_tryupimgrsp.uint64_up_offset.get();
            if (QLog.isColorLevel()) {
                QLog.d(BdhLogUtil.Tag, 2, " Channel:" + cmd0x388_tryupimgrsp.bool_new_big_chan.get());
            }
            if (cmd0x388_tryupimgrsp.bool_new_big_chan.has() && cmd0x388_tryupimgrsp.bool_new_big_chan.get()) {
                bDHCommonUpResp.isUseBdh = true;
                return;
            }
            return;
        }
        throw new Exception("check ukey,iplist");
    }

    public static boolean shouldRetryByRetCode(int i3) {
        if (i3 != 196 && i3 != 194 && i3 != 197 && i3 != 199 && i3 != 200 && i3 != 201 && i3 != 203 && i3 != 202 && i3 != 120509 && i3 != 400010 && i3 != 400011) {
            return true;
        }
        return false;
    }

    void addOne(int i3, RichProto.RichProtoReq.ReqCommon reqCommon, cmd0x388$ReqBody cmd0x388_reqbody) {
        int i16;
        RichProto.RichProtoReq.PicUpReq picUpReq = (RichProto.RichProtoReq.PicUpReq) reqCommon;
        cmd0x388$TryUpImgReq cmd0x388_tryupimgreq = new cmd0x388$TryUpImgReq();
        cmd0x388_tryupimgreq.setHasFlag(true);
        cmd0x388_tryupimgreq.uint64_src_uin.set(Long.valueOf(picUpReq.selfUin).longValue());
        cmd0x388_tryupimgreq.uint64_group_code.set(Long.valueOf(picUpReq.peerUin).longValue());
        cmd0x388_tryupimgreq.uint64_file_id.set(i3);
        cmd0x388_tryupimgreq.uint64_file_size.set(picUpReq.fileSize);
        cmd0x388_tryupimgreq.bytes_file_md5.set(ByteStringMicro.copyFrom(picUpReq.md5));
        cmd0x388_tryupimgreq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(picUpReq.fileName));
        cmd0x388_tryupimgreq.uint32_src_term.set(5);
        cmd0x388_tryupimgreq.uint32_platform_type.set(9);
        cmd0x388_tryupimgreq.uint32_pic_width.set(picUpReq.width);
        cmd0x388_tryupimgreq.uint32_pic_height.set(picUpReq.height);
        cmd0x388_tryupimgreq.uint32_pic_type.set(picUpReq.picType);
        PBUInt32Field pBUInt32Field = cmd0x388_tryupimgreq.uint32_bu_type;
        if (picUpReq.uinType == 1) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        pBUInt32Field.set(i16);
        cmd0x388_tryupimgreq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
        if (picUpReq.isRaw) {
            cmd0x388_tryupimgreq.uint32_original_pic.set(1);
        }
        cmd0x388_reqbody.rpt_msg_tryup_img_req.add(cmd0x388_tryupimgreq);
    }

    byte[] constructReqBody(RichProto.RichProtoReq richProtoReq) {
        if (richProtoReq == null) {
            return null;
        }
        List<RichProto.RichProtoReq.ReqCommon> list = richProtoReq.reqs;
        cmd0x388$ReqBody cmd0x388_reqbody = new cmd0x388$ReqBody();
        cmd0x388_reqbody.setHasFlag(true);
        cmd0x388_reqbody.uint32_subcmd.set(1);
        cmd0x388_reqbody.uint32_command_id.set(richProtoReq.commandId);
        byte[] bArr = richProtoReq.extention;
        if (bArr != null) {
            cmd0x388_reqbody.bytes_extension.set(ByteStringMicro.copyFrom(bArr));
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            addOne(i3, list.get(i3), cmd0x388_reqbody);
        }
        int netType = NetworkCenter.getInstance().getNetType();
        this.mReqNetType = netType;
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
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    protected void handleSucResp(FromServiceMsg fromServiceMsg, byte[] bArr, RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo, ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        char c16;
        String str;
        RichProto.RichProtoResp.BDHCommonUpResp bDHCommonUpResp;
        RichProto.RichProtoResp.BDHCommonUpResp bDHCommonUpResp2;
        RichProto.RichProtoResp.BDHCommonUpResp bDHCommonUpResp3;
        char c17;
        FromServiceMsg fromServiceMsg2 = fromServiceMsg;
        String str2 = "P";
        IPatchRedirector iPatchRedirector = $redirector_;
        char c18 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, fromServiceMsg2, bArr, richProtoReq, richProtoResp, statictisInfo, protoResp, protoReq);
            return;
        }
        try {
            List<cmd0x388$TryUpImgRsp> list = new cmd0x388$RspBody().mergeFrom(bArr).rpt_msg_tryup_img_rsp.get();
            try {
                if (list != null && list.size() != 0) {
                    for (cmd0x388$TryUpImgRsp cmd0x388_tryupimgrsp : list) {
                        try {
                            bDHCommonUpResp2 = (RichProto.RichProtoResp.BDHCommonUpResp) richProtoResp.resps.get((int) cmd0x388_tryupimgrsp.uint64_file_id.get());
                        } catch (Exception e16) {
                            e = e16;
                            c16 = c18;
                            str = str2;
                            bDHCommonUpResp = null;
                        }
                        if (bDHCommonUpResp2 == null) {
                            continue;
                        } else {
                            try {
                                if (fromServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP)) {
                                    try {
                                        bDHCommonUpResp2.isSendByQuickHttp = ((Boolean) fromServiceMsg2.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP, Boolean.FALSE)).booleanValue();
                                    } catch (Exception e17) {
                                        e = e17;
                                        c16 = c18;
                                        str = str2;
                                        bDHCommonUpResp = bDHCommonUpResp2;
                                        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, bDHCommonUpResp);
                                        str2 = str;
                                        c18 = c16;
                                        fromServiceMsg2 = fromServiceMsg;
                                    }
                                }
                                int i3 = cmd0x388_tryupimgrsp.uint32_result.get();
                                if (i3 == 0) {
                                    try {
                                        handleBusSuc(bDHCommonUpResp2, cmd0x388_tryupimgrsp);
                                        str = str2;
                                    } catch (Exception e18) {
                                        e = e18;
                                        bDHCommonUpResp3 = bDHCommonUpResp2;
                                        str = str2;
                                        c16 = c18;
                                        bDHCommonUpResp = bDHCommonUpResp3;
                                        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, bDHCommonUpResp);
                                        str2 = str;
                                        c18 = c16;
                                        fromServiceMsg2 = fromServiceMsg;
                                    }
                                    try {
                                        setResult(0, 0, "", "", statictisInfo, bDHCommonUpResp2);
                                        c16 = 2;
                                    } catch (Exception e19) {
                                        e = e19;
                                        bDHCommonUpResp = bDHCommonUpResp2;
                                        c16 = 2;
                                        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, bDHCommonUpResp);
                                        str2 = str;
                                        c18 = c16;
                                        fromServiceMsg2 = fromServiceMsg;
                                    }
                                } else {
                                    bDHCommonUpResp3 = bDHCommonUpResp2;
                                    str = str2;
                                    try {
                                        if (shouldRetryByRetCode(i3)) {
                                            int i16 = this.mReqUrlCount + 1;
                                            this.mReqUrlCount = i16;
                                            c17 = 2;
                                            if (i16 < 2) {
                                                richProtoReq.protoReqMgr.sendProtoReq(protoReq);
                                                return;
                                            }
                                        } else {
                                            c17 = 2;
                                        }
                                        try {
                                            c16 = c17;
                                            try {
                                                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i3), "", statictisInfo, bDHCommonUpResp3);
                                            } catch (Exception e26) {
                                                e = e26;
                                                bDHCommonUpResp = bDHCommonUpResp3;
                                                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, bDHCommonUpResp);
                                                str2 = str;
                                                c18 = c16;
                                                fromServiceMsg2 = fromServiceMsg;
                                            }
                                        } catch (Exception e27) {
                                            e = e27;
                                            c16 = c17;
                                        }
                                    } catch (Exception e28) {
                                        e = e28;
                                        c16 = 2;
                                    }
                                }
                            } catch (Exception e29) {
                                e = e29;
                                bDHCommonUpResp3 = bDHCommonUpResp2;
                                c16 = c18;
                                str = str2;
                            }
                            str2 = str;
                            c18 = c16;
                            fromServiceMsg2 = fromServiceMsg;
                        }
                    }
                    return;
                }
                throw new Exception("resps null");
            } catch (Exception e36) {
                e = e36;
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(fromServiceMsg2, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, richProtoResp.resps);
            }
        } catch (Exception e37) {
            e = e37;
            fromServiceMsg2 = str2;
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.BDHCommonUpResp());
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) protoResp, (Object) protoReq);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("BDHCommonUpHandler", 1, "onProtoResp: " + protoResp.resp.getResultCode());
        }
        super.onProtoResp(protoResp, protoReq);
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
            protoReq.ssoCmd = RichMediaConstants.CMD_LONGCONN_BDH_COMMON_UP;
            protoReq.reqBody = constructReqBody(richProtoReq);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
