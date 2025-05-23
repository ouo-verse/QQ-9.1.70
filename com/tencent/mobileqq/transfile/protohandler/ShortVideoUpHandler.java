package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;
import pttcenterservice.PttShortVideo$DataHole;
import pttcenterservice.PttShortVideo$ExtensionReq;
import pttcenterservice.PttShortVideo$PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo$PttShortVideoFileInfoExtend;
import pttcenterservice.PttShortVideo$PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo$PttShortVideoUploadResp;
import pttcenterservice.PttShortVideo$ReqBody;
import pttcenterservice.PttShortVideo$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ShortVideoUpHandler extends BaseHandler {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.richmedia.ShortVideoUpHandler";

    public ShortVideoUpHandler() {
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

    byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        PttShortVideo$ReqBody pttShortVideo$ReqBody = new PttShortVideo$ReqBody();
        pttShortVideo$ReqBody.setHasFlag(true);
        if (list.size() == 1) {
            RichProto.RichProtoReq.ShortVideoUpReq shortVideoUpReq = (RichProto.RichProtoReq.ShortVideoUpReq) list.get(0);
            PttShortVideo$PttShortVideoUploadReq pttShortVideo$PttShortVideoUploadReq = new PttShortVideo$PttShortVideoUploadReq();
            pttShortVideo$PttShortVideoUploadReq.setHasFlag(true);
            pttShortVideo$PttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(shortVideoUpReq.selfUin));
            pttShortVideo$PttShortVideoUploadReq.uint64_touin.set(Long.parseLong(shortVideoUpReq.peerUin));
            pttShortVideo$PttShortVideoUploadReq.uint32_chat_type.set(shortVideoUpReq.chatType);
            pttShortVideo$PttShortVideoUploadReq.uint32_client_type.set(shortVideoUpReq.clientType);
            String str = shortVideoUpReq.troopUin;
            if (str != null) {
                pttShortVideo$PttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(str));
            } else {
                pttShortVideo$PttShortVideoUploadReq.uint64_group_code.set(0L);
            }
            if (shortVideoUpReq.uinType == 10014) {
                pttShortVideo$PttShortVideoUploadReq.uint32_sub_business_type.set(shortVideoUpReq.subBusiType);
            }
            pttShortVideo$PttShortVideoUploadReq.uint32_agent_type.set(shortVideoUpReq.agentType);
            pttShortVideo$PttShortVideoUploadReq.uint32_business_type.set(shortVideoUpReq.busiType);
            pttShortVideo$PttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
            PttShortVideo$PttShortVideoFileInfo pttShortVideo$PttShortVideoFileInfo = new PttShortVideo$PttShortVideoFileInfo();
            pttShortVideo$PttShortVideoFileInfo.str_file_name.set(shortVideoUpReq.fileName);
            pttShortVideo$PttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(shortVideoUpReq.md5));
            pttShortVideo$PttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(shortVideoUpReq.thumbFileMd5));
            pttShortVideo$PttShortVideoFileInfo.uint64_file_size.set(shortVideoUpReq.fileSize);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_res_length.set(shortVideoUpReq.fileResLength);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_res_width.set(shortVideoUpReq.fileResWidth);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_format.set(shortVideoUpReq.format);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_time.set(shortVideoUpReq.fileTime);
            pttShortVideo$PttShortVideoFileInfo.uint64_thumb_file_size.set(shortVideoUpReq.thumbFileSize);
            if (shortVideoUpReq.bitrateInKilo > 0) {
                PttShortVideo$PttShortVideoFileInfoExtend pttShortVideo$PttShortVideoFileInfoExtend = new PttShortVideo$PttShortVideoFileInfoExtend();
                pttShortVideo$PttShortVideoFileInfoExtend.uint32_bit_rate.set(shortVideoUpReq.bitrateInKilo);
                pttShortVideo$PttShortVideoFileInfo.bytes_extend.set(ByteStringMicro.copyFrom(pttShortVideo$PttShortVideoFileInfoExtend.toByteArray()));
            }
            pttShortVideo$PttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(pttShortVideo$PttShortVideoFileInfo);
            pttShortVideo$PttShortVideoUploadReq.uint32_codec_format.set(shortVideoUpReq.sourceVideoCodecFormat);
            PttShortVideo$ExtensionReq pttShortVideo$ExtensionReq = new PttShortVideo$ExtensionReq();
            pttShortVideo$ExtensionReq.uint32_sub_busi_type.set(shortVideoUpReq.subBusiType);
            pttShortVideo$ExtensionReq.uint32_user_cnt.set(shortVideoUpReq.userCnt);
            pttShortVideo$ReqBody.uint32_cmd.set(300);
            pttShortVideo$ReqBody.uint32_seq.set(shortVideoUpReq.seq);
            pttShortVideo$ReqBody.msg_PttShortVideoUpload_Req.set(pttShortVideo$PttShortVideoUploadReq);
            pttShortVideo$ReqBody.rpt_msg_extension_req.add(pttShortVideo$ExtensionReq);
            return pttShortVideo$ReqBody.toByteArray();
        }
        throw new RuntimeException("only support one request");
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.ShortVideoUpResp());
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        RichProto.RichProtoResp.RespCommon respCommon;
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
                PttShortVideo$PttShortVideoUploadResp pttShortVideo$PttShortVideoUploadResp = new PttShortVideo$RspBody().mergeFrom(wupBuffer).msg_PttShortVideoUpload_Resp.get();
                if (pttShortVideo$PttShortVideoUploadResp != null) {
                    try {
                        RichProto.RichProtoResp.ShortVideoUpResp shortVideoUpResp = (RichProto.RichProtoResp.ShortVideoUpResp) richProtoResp.resps.get(0);
                        try {
                            int i3 = pttShortVideo$PttShortVideoUploadResp.int32_ret_code.get();
                            if (i3 == 0) {
                                if (1 == pttShortVideo$PttShortVideoUploadResp.uint32_file_exist.get()) {
                                    shortVideoUpResp.isExist = true;
                                    shortVideoUpResp.fileId = pttShortVideo$PttShortVideoUploadResp.str_fileid.get();
                                } else {
                                    byte[] byteArray = pttShortVideo$PttShortVideoUploadResp.bytes_ukey.get().toByteArray();
                                    if ((pttShortVideo$PttShortVideoUploadResp.rpt_same_area_out_addr.size() > 0 || pttShortVideo$PttShortVideoUploadResp.rpt_diff_area_out_addr.size() > 0) && byteArray != null && byteArray.length != 0) {
                                        shortVideoUpResp.fileId = pttShortVideo$PttShortVideoUploadResp.str_fileid.get();
                                        List<PttShortVideo$DataHole> list = pttShortVideo$PttShortVideoUploadResp.rpt_data_hole.get();
                                        if (list != null && list.size() > 0) {
                                            shortVideoUpResp.startOffset = list.get(0).uint64_begin.get();
                                        }
                                    } else {
                                        throw new Exception("check ip, port, ukey");
                                    }
                                }
                                shortVideoUpResp.videoAttr = pttShortVideo$PttShortVideoUploadResp.uint32_is_hot_file.get();
                                shortVideoUpResp.videoKandianType = pttShortVideo$PttShortVideoUploadResp.uint32_long_video_carry_watch_point_type.get();
                                setResult(0, 0, "", "", statictisInfo, shortVideoUpResp);
                            } else {
                                if (shouldRetryByRetCode(i3)) {
                                    int i16 = this.mReqUrlCount + 1;
                                    this.mReqUrlCount = i16;
                                    if (i16 < 2) {
                                        richProtoReq.protoReqMgr.sendProtoReq(protoReq);
                                        return;
                                    }
                                }
                                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i3), "", statictisInfo, shortVideoUpResp);
                            }
                        } catch (Exception e16) {
                            e = e16;
                            respCommon = shortVideoUpResp;
                            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason("P", -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(wupBuffer), statictisInfo, respCommon);
                            RichProtoProc.onBusiProtoResp(richProtoReq, richProtoResp);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        respCommon = null;
                    }
                } else {
                    throw new Exception("svUpResp null");
                }
            } catch (Exception e18) {
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason("P", -9529L), e18.getMessage() + " hex:" + HexUtil.bytes2HexStr(wupBuffer), statictisInfo, richProtoResp.resps);
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
            if (richProtoReq.reqs.size() == 1) {
                int i3 = richProtoReq.reqs.get(0).uinType;
                if (i3 == 0) {
                    protoReq.ssoCmd = RichMediaConstants.CMD_SHORT_VIDEO_UP;
                } else if (1 != i3 && 3000 != i3 && 10014 != i3) {
                    protoReq.ssoCmd = RichMediaConstants.CMD_SHORT_VIDEO_UP;
                } else {
                    protoReq.ssoCmd = RichMediaConstants.CMD_GROUP_SHORT_VIDEO_UP;
                }
                protoReq.reqBody = constructReqBody(richProtoReq.reqs);
                protoReq.busiData = richProtoReq;
                protoReq.callback = this;
                inner_sendToProtoReq(richProtoReq, protoReq);
                return;
            }
            throw new RuntimeException("only support one request");
        }
    }
}
