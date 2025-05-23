package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pttcenterservice.PttShortVideo$DataHole;
import pttcenterservice.PttShortVideo$PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo$PttShortVideoFileInfoExtend;
import pttcenterservice.PttShortVideo$PttShortVideoRetweetReq;
import pttcenterservice.PttShortVideo$PttShortVideoRetweetResp;
import pttcenterservice.PttShortVideo$ReqBody;
import pttcenterservice.PttShortVideo$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ShortVideoForwardHandler extends BaseHandler {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.richmedia.ShortVideoForwardHandler";

    public ShortVideoForwardHandler() {
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
            RichProto.RichProtoReq.ShortVideoForwardReq shortVideoForwardReq = (RichProto.RichProtoReq.ShortVideoForwardReq) list.get(0);
            PttShortVideo$PttShortVideoRetweetReq pttShortVideo$PttShortVideoRetweetReq = new PttShortVideo$PttShortVideoRetweetReq();
            pttShortVideo$PttShortVideoRetweetReq.setHasFlag(true);
            pttShortVideo$PttShortVideoRetweetReq.uint64_from_uin.set(Long.parseLong(shortVideoForwardReq.fromUin));
            pttShortVideo$PttShortVideoRetweetReq.uint64_to_uin.set(Long.parseLong(shortVideoForwardReq.peerUin));
            pttShortVideo$PttShortVideoRetweetReq.uint32_from_chat_type.set(shortVideoForwardReq.fromChatType);
            pttShortVideo$PttShortVideoRetweetReq.uint32_to_chat_type.set(shortVideoForwardReq.toChatType);
            pttShortVideo$PttShortVideoRetweetReq.uint32_from_busi_type.set(shortVideoForwardReq.fromBusiType);
            pttShortVideo$PttShortVideoRetweetReq.uint32_to_busi_type.set(shortVideoForwardReq.toBusiType);
            pttShortVideo$PttShortVideoRetweetReq.uint32_client_type.set(shortVideoForwardReq.clientType);
            pttShortVideo$PttShortVideoRetweetReq.uint32_agent_type.set(shortVideoForwardReq.agentType);
            PBStringField pBStringField = pttShortVideo$PttShortVideoRetweetReq.str_fileid;
            String str = shortVideoForwardReq.uuid;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            pBStringField.set(str);
            String str3 = shortVideoForwardReq.troopUin;
            if (str3 != null) {
                try {
                    pttShortVideo$PttShortVideoRetweetReq.uint64_group_code.set(Long.parseLong(str3));
                } catch (NumberFormatException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "NumberFormatException e = " + e16);
                    }
                    pttShortVideo$PttShortVideoRetweetReq.uint64_group_code.set(0L);
                }
            } else {
                pttShortVideo$PttShortVideoRetweetReq.uint64_group_code.set(0L);
            }
            pttShortVideo$PttShortVideoRetweetReq.uint32_flag_support_large_size.set(1);
            int i3 = shortVideoForwardReq.sourceVideoCodecFormat;
            if (i3 >= 0) {
                pttShortVideo$PttShortVideoRetweetReq.uint32_codec_format.set(i3);
            }
            PttShortVideo$PttShortVideoFileInfo pttShortVideo$PttShortVideoFileInfo = new PttShortVideo$PttShortVideoFileInfo();
            PBStringField pBStringField2 = pttShortVideo$PttShortVideoFileInfo.str_file_name;
            String str4 = shortVideoForwardReq.fileName;
            if (str4 != null) {
                str2 = str4;
            }
            pBStringField2.set(str2);
            pttShortVideo$PttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(shortVideoForwardReq.md5));
            pttShortVideo$PttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(shortVideoForwardReq.thumbFileMd5));
            pttShortVideo$PttShortVideoFileInfo.uint64_file_size.set(shortVideoForwardReq.fileSize);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_res_length.set(shortVideoForwardReq.fileResLength);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_res_width.set(shortVideoForwardReq.fileResWidth);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_format.set(shortVideoForwardReq.format);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_time.set(shortVideoForwardReq.fileTime);
            pttShortVideo$PttShortVideoFileInfo.uint64_thumb_file_size.set(shortVideoForwardReq.thumbFileSize);
            if (shortVideoForwardReq.bitrateInKilo > 0) {
                PttShortVideo$PttShortVideoFileInfoExtend pttShortVideo$PttShortVideoFileInfoExtend = new PttShortVideo$PttShortVideoFileInfoExtend();
                pttShortVideo$PttShortVideoFileInfoExtend.uint32_bit_rate.set(shortVideoForwardReq.bitrateInKilo);
                pttShortVideo$PttShortVideoFileInfo.bytes_extend.set(ByteStringMicro.copyFrom(pttShortVideo$PttShortVideoFileInfoExtend.toByteArray()));
            }
            pttShortVideo$PttShortVideoRetweetReq.msg_PttShortVideoFileInfo.set(pttShortVideo$PttShortVideoFileInfo);
            pttShortVideo$ReqBody.uint32_cmd.set(500);
            pttShortVideo$ReqBody.uint32_seq.set(shortVideoForwardReq.seq);
            pttShortVideo$ReqBody.rpt_msg_short_video_retweet_req.add(pttShortVideo$PttShortVideoRetweetReq);
            return pttShortVideo$ReqBody.toByteArray();
        }
        throw new RuntimeException("only support one request");
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        int size = richProtoReq.reqs.size();
        for (int i3 = 0; i3 < size; i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.ShortVideoForwardResp());
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
                PttShortVideo$PttShortVideoRetweetResp pttShortVideo$PttShortVideoRetweetResp = new PttShortVideo$RspBody().mergeFrom(wupBuffer).rpt_msg_short_video_retweet_resp.get(0);
                if (pttShortVideo$PttShortVideoRetweetResp != null) {
                    try {
                        RichProto.RichProtoResp.ShortVideoForwardResp shortVideoForwardResp = (RichProto.RichProtoResp.ShortVideoForwardResp) richProtoResp.resps.get(0);
                        try {
                            int i3 = pttShortVideo$PttShortVideoRetweetResp.int32_ret_code.get();
                            if (i3 == 0) {
                                if (1 == pttShortVideo$PttShortVideoRetweetResp.uint32_file_exist.get()) {
                                    shortVideoForwardResp.isExist = true;
                                    shortVideoForwardResp.fileId = pttShortVideo$PttShortVideoRetweetResp.str_fileid.get();
                                } else {
                                    byte[] byteArray = pttShortVideo$PttShortVideoRetweetResp.bytes_ukey.get().toByteArray();
                                    if ((pttShortVideo$PttShortVideoRetweetResp.rpt_same_area_out_addr.size() > 0 || pttShortVideo$PttShortVideoRetweetResp.rpt_diff_area_out_addr.size() > 0) && byteArray != null && byteArray.length != 0) {
                                        shortVideoForwardResp.fileId = pttShortVideo$PttShortVideoRetweetResp.str_fileid.get();
                                        List<PttShortVideo$DataHole> list = pttShortVideo$PttShortVideoRetweetResp.rpt_data_hole.get();
                                        if (list != null && list.size() > 0) {
                                            shortVideoForwardResp.startOffset = list.get(0).uint64_begin.get();
                                        }
                                    } else {
                                        throw new Exception("check ip, port, ukey");
                                    }
                                }
                                shortVideoForwardResp.videoAttr = pttShortVideo$PttShortVideoRetweetResp.uint32_is_hot_file.get();
                                shortVideoForwardResp.videoKandianType = pttShortVideo$PttShortVideoRetweetResp.uint32_long_video_carry_watch_point_type.get();
                                setResult(0, 0, "", "", statictisInfo, shortVideoForwardResp);
                            } else if (i3 == -5100026) {
                                setResult(-1, AppConstants.RichMediaErrorCode.ERR_BAN_DOWNLOAD, ProcessorReport.getUrlReason(i3), "", statictisInfo, shortVideoForwardResp);
                            } else {
                                if (shouldRetryByRetCode(i3)) {
                                    int i16 = this.mReqUrlCount + 1;
                                    this.mReqUrlCount = i16;
                                    if (i16 < 2) {
                                        richProtoReq.protoReqMgr.sendProtoReq(protoReq);
                                        return;
                                    }
                                }
                                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i3), "", statictisInfo, shortVideoForwardResp);
                            }
                        } catch (Exception e16) {
                            e = e16;
                            respCommon = shortVideoForwardResp;
                            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason("P", -9529L), e.getMessage() + " hex:" + HexUtil.bytes2HexStr(wupBuffer), statictisInfo, respCommon);
                            RichProtoProc.onBusiProtoResp(richProtoReq, richProtoResp);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        respCommon = null;
                    }
                } else {
                    throw new Exception("forwardResp null");
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
                protoReq.ssoCmd = RichMediaConstants.CMD_SHORT_VIDEO_FORWARD;
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
