package com.tencent.mobileqq.transfile.protohandler;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.slf4j.Marker;
import tencent.im.cs.cmd0x352.cmd0x352$ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352$RspBody;
import tencent.im.cs.cmd0x352.cmd0x352$TryUpImgReq;
import tencent.im.cs.cmd0x352.cmd0x352$TryUpImgRsp;

/* loaded from: classes19.dex */
public class C2CPicUpHandler extends PicUpHandler {
    static IPatchRedirector $redirector_;
    int mReqNetType;

    public C2CPicUpHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean shouldRetryByRetCode(int i3) {
        if (i3 != 196 && i3 != 197 && i3 != 199 && i3 != 201 && i3 != 202 && i3 != 206 && i3 != 207 && i3 != 208) {
            return true;
        }
        return false;
    }

    void addOne(int i3, RichProto.RichProtoReq.ReqCommon reqCommon, cmd0x352$ReqBody cmd0x352_reqbody) {
        RichProto.RichProtoReq.PicUpReq picUpReq = (RichProto.RichProtoReq.PicUpReq) reqCommon;
        cmd0x352$TryUpImgReq cmd0x352_tryupimgreq = new cmd0x352$TryUpImgReq();
        cmd0x352_tryupimgreq.uint64_file_id.set(i3);
        cmd0x352_tryupimgreq.setHasFlag(true);
        cmd0x352_tryupimgreq.uint64_src_uin.set(Long.valueOf(picUpReq.selfUin).longValue());
        try {
            String str = picUpReq.peerUin;
            if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                str = str.substring(1);
            }
            cmd0x352_tryupimgreq.uint64_dst_uin.set(Long.valueOf(str).longValue());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        cmd0x352_tryupimgreq.uint64_file_size.set(picUpReq.fileSize);
        cmd0x352_tryupimgreq.bytes_file_md5.set(ByteStringMicro.copyFrom(picUpReq.md5));
        cmd0x352_tryupimgreq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(picUpReq.fileName));
        cmd0x352_tryupimgreq.uint32_src_term.set(5);
        cmd0x352_tryupimgreq.bool_address_book.set(picUpReq.isContact);
        cmd0x352_tryupimgreq.uint32_platform_type.set(9);
        setBuType(cmd0x352_tryupimgreq);
        cmd0x352_tryupimgreq.bool_pic_original.set(picUpReq.isRaw);
        cmd0x352_tryupimgreq.uint32_pic_width.set(picUpReq.width);
        cmd0x352_tryupimgreq.uint32_pic_height.set(picUpReq.height);
        cmd0x352_tryupimgreq.uint32_pic_type.set(picUpReq.picType);
        cmd0x352_tryupimgreq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
        cmd0x352_tryupimgreq.bool_reject_tryfast.set(false);
        cmd0x352_tryupimgreq.uint32_srv_upload.set(picUpReq.typeHotPic);
        if (!TextUtils.isEmpty(picUpReq.transferUrl)) {
            cmd0x352_tryupimgreq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(picUpReq.transferUrl));
        }
        cmd0x352_reqbody.rpt_msg_tryup_img_req.add(cmd0x352_tryupimgreq);
    }

    byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        cmd0x352$ReqBody cmd0x352_reqbody = new cmd0x352$ReqBody();
        cmd0x352_reqbody.setHasFlag(true);
        cmd0x352_reqbody.uint32_subcmd.set(1);
        for (int i3 = 0; i3 < list.size(); i3++) {
            addOne(i3, list.get(i3), cmd0x352_reqbody);
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
        cmd0x352_reqbody.uint32_net_type.set(i16);
        return cmd0x352_reqbody.toByteArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.transfile.protohandler.PicUpHandler, com.tencent.mobileqq.transfile.protohandler.BaseHandler
    protected void handleSucResp(FromServiceMsg fromServiceMsg, byte[] bArr, RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo, ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        char c16;
        String str;
        RichProto.RichProtoResp.C2CPicUpResp c2CPicUpResp;
        RichProto.RichProtoResp.C2CPicUpResp c2CPicUpResp2;
        char c17;
        String str2 = fromServiceMsg;
        String str3 = "P";
        IPatchRedirector iPatchRedirector = $redirector_;
        char c18 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str2, bArr, richProtoReq, richProtoResp, statictisInfo, protoResp, protoReq);
            return;
        }
        try {
            List<cmd0x352$TryUpImgRsp> list = new cmd0x352$RspBody().mergeFrom(bArr).rpt_msg_tryup_img_rsp.get();
            try {
                if (list != null && list.size() != 0) {
                    FromServiceMsg fromServiceMsg2 = str2;
                    for (cmd0x352$TryUpImgRsp cmd0x352_tryupimgrsp : list) {
                        try {
                            RichProto.RichProtoResp.C2CPicUpResp c2CPicUpResp3 = (RichProto.RichProtoResp.C2CPicUpResp) richProtoResp.resps.get((int) cmd0x352_tryupimgrsp.uint64_file_id.get());
                            if (c2CPicUpResp3 != null) {
                                try {
                                    if (fromServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP)) {
                                        try {
                                            c2CPicUpResp3.isSendByQuickHttp = ((Boolean) fromServiceMsg2.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP, Boolean.FALSE)).booleanValue();
                                        } catch (Exception e16) {
                                            e = e16;
                                            c16 = c18;
                                            str = str3;
                                            c2CPicUpResp = c2CPicUpResp3;
                                            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, c2CPicUpResp);
                                            str3 = str;
                                            c18 = c16;
                                            fromServiceMsg2 = fromServiceMsg;
                                        }
                                    }
                                    int i3 = cmd0x352_tryupimgrsp.uint32_result.get();
                                    if (i3 == 0) {
                                        try {
                                            parseResp(cmd0x352_tryupimgrsp, c2CPicUpResp3);
                                            str = str3;
                                            try {
                                                setResult(0, 0, "", "", statictisInfo, c2CPicUpResp3);
                                                c16 = 2;
                                            } catch (Exception e17) {
                                                e = e17;
                                                c2CPicUpResp = c2CPicUpResp3;
                                                c16 = 2;
                                                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, c2CPicUpResp);
                                                str3 = str;
                                                c18 = c16;
                                                fromServiceMsg2 = fromServiceMsg;
                                            }
                                        } catch (Exception e18) {
                                            e = e18;
                                            c2CPicUpResp2 = c2CPicUpResp3;
                                            str = str3;
                                            c16 = c18;
                                            c2CPicUpResp = c2CPicUpResp2;
                                            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, c2CPicUpResp);
                                            str3 = str;
                                            c18 = c16;
                                            fromServiceMsg2 = fromServiceMsg;
                                        }
                                    } else {
                                        c2CPicUpResp2 = c2CPicUpResp3;
                                        str = str3;
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
                                                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i3), "", statictisInfo, c2CPicUpResp2);
                                                } catch (Exception e19) {
                                                    e = e19;
                                                    c2CPicUpResp = c2CPicUpResp2;
                                                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, c2CPicUpResp);
                                                    str3 = str;
                                                    c18 = c16;
                                                    fromServiceMsg2 = fromServiceMsg;
                                                }
                                            } catch (Exception e26) {
                                                e = e26;
                                                c16 = c17;
                                            }
                                        } catch (Exception e27) {
                                            e = e27;
                                            c16 = 2;
                                        }
                                    }
                                } catch (Exception e28) {
                                    e = e28;
                                    c2CPicUpResp2 = c2CPicUpResp3;
                                    c16 = c18;
                                    str = str3;
                                }
                            } else {
                                c16 = c18;
                                str = str3;
                            }
                        } catch (Exception e29) {
                            e = e29;
                            c16 = c18;
                            str = str3;
                            c2CPicUpResp = null;
                        }
                        str3 = str;
                        c18 = c16;
                        fromServiceMsg2 = fromServiceMsg;
                    }
                    return;
                }
                throw new Exception("resps null");
            } catch (Exception e36) {
                e = e36;
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str2, -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, richProtoResp.resps);
            }
        } catch (Exception e37) {
            e = e37;
            str2 = str3;
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.C2CPicUpResp());
        }
    }

    void parseResp(cmd0x352$TryUpImgRsp cmd0x352_tryupimgrsp, RichProto.RichProtoResp.C2CPicUpResp c2CPicUpResp) {
        if (cmd0x352_tryupimgrsp.bytes_up_resid.has()) {
            c2CPicUpResp.mResid = cmd0x352_tryupimgrsp.bytes_up_resid.get().toStringUtf8();
        }
        if (cmd0x352_tryupimgrsp.bytes_up_uuid.has()) {
            c2CPicUpResp.mUuid = cmd0x352_tryupimgrsp.bytes_up_uuid.get().toStringUtf8();
        }
        c2CPicUpResp.startOffset = cmd0x352_tryupimgrsp.uint64_up_offset.get();
        if (QLog.isColorLevel()) {
            QLog.d(BdhLogUtil.Tag, 2, " TryUpLoad : Offset:" + c2CPicUpResp.startOffset + " Value:" + cmd0x352_tryupimgrsp.uint64_up_offset.get());
        }
        boolean z16 = true;
        if (cmd0x352_tryupimgrsp.bool_file_exit.has() && cmd0x352_tryupimgrsp.bool_file_exit.get()) {
            c2CPicUpResp.isExist = true;
        } else {
            c2CPicUpResp.mUkey = HexUtil.bytes2HexStr(cmd0x352_tryupimgrsp.bytes_up_ukey.get().toByteArray());
            c2CPicUpResp.blockSize = (int) cmd0x352_tryupimgrsp.uint64_block_size.get();
            if (NetworkCenter.getInstance().getNetType() == this.mReqNetType) {
                z16 = false;
            }
            c2CPicUpResp.networkChange = z16;
        }
        if (cmd0x352_tryupimgrsp.bytes_original_down_para.has()) {
            c2CPicUpResp.mOriginalDownPara = cmd0x352_tryupimgrsp.bytes_original_down_para.get().toStringUtf8();
        }
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
            setSsoCmd(protoReq);
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }

    protected void setBuType(cmd0x352$TryUpImgReq cmd0x352_tryupimgreq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cmd0x352_tryupimgreq);
        } else {
            cmd0x352_tryupimgreq.uint32_bu_type.set(1);
        }
    }

    protected void setSsoCmd(ProtoReqManagerImpl.ProtoReq protoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) protoReq);
        } else {
            protoReq.ssoCmd = "LongConn.OffPicUp";
        }
    }
}
