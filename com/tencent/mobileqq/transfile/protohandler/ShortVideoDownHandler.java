package com.tencent.mobileqq.transfile.protohandler;

import android.os.Build;
import com.qq.taf.jce.HexUtil;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import pttcenterservice.PttShortVideo$CodecConfigReq;
import pttcenterservice.PttShortVideo$ExtensionReq;
import pttcenterservice.PttShortVideo$PttShortVideoAddr;
import pttcenterservice.PttShortVideo$PttShortVideoDownloadReq;
import pttcenterservice.PttShortVideo$PttShortVideoDownloadResp;
import pttcenterservice.PttShortVideo$QuicParameter;
import pttcenterservice.PttShortVideo$ReqBody;
import pttcenterservice.PttShortVideo$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ShortVideoDownHandler extends BaseHandler {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.richmedia.ShortVideoDownHandler";

    public ShortVideoDownHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private ArrayList<ServerAddr> parseSrvAddlist(RichProto.RichProtoResp.ShortVideoDownResp shortVideoDownResp, List<String> list, boolean z16) {
        ArrayList<ServerAddr> arrayList = new ArrayList<>();
        if (list != null) {
            for (String str : list) {
                try {
                    ServerAddr serverAddr = new ServerAddr();
                    URL url = new URL(str);
                    serverAddr.mIp = url.getHost();
                    serverAddr.port = url.getPort();
                    serverAddr.isIpv6 = z16;
                    arrayList.add(serverAddr);
                    if (str.startsWith("https://")) {
                        shortVideoDownResp.mIsHttps = true;
                    } else {
                        shortVideoDownResp.mIsHttps = false;
                    }
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "parseSrvAddlist err.", e16);
                }
            }
        }
        return arrayList;
    }

    byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        PttShortVideo$ReqBody pttShortVideo$ReqBody = new PttShortVideo$ReqBody();
        pttShortVideo$ReqBody.setHasFlag(true);
        if (list.size() == 1) {
            RichProto.RichProtoReq.ShortVideoDownReq shortVideoDownReq = (RichProto.RichProtoReq.ShortVideoDownReq) list.get(0);
            PttShortVideo$PttShortVideoDownloadReq pttShortVideo$PttShortVideoDownloadReq = new PttShortVideo$PttShortVideoDownloadReq();
            pttShortVideo$PttShortVideoDownloadReq.uint64_touin.set(Long.parseLong(shortVideoDownReq.selfUin));
            pttShortVideo$PttShortVideoDownloadReq.uint32_chat_type.set(shortVideoDownReq.chatType);
            if (shortVideoDownReq.chatType == 0) {
                pttShortVideo$PttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(shortVideoDownReq.peerUin));
            } else {
                pttShortVideo$PttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(shortVideoDownReq.secondUin));
            }
            pttShortVideo$PttShortVideoDownloadReq.uint32_client_type.set(shortVideoDownReq.clientType);
            pttShortVideo$PttShortVideoDownloadReq.str_fileid.set(shortVideoDownReq.fileId);
            String str = shortVideoDownReq.troopUin;
            if (str != null) {
                pttShortVideo$PttShortVideoDownloadReq.uint64_group_code.set(Long.parseLong(str));
            } else {
                pttShortVideo$PttShortVideoDownloadReq.uint64_group_code.set(0L);
            }
            pttShortVideo$PttShortVideoDownloadReq.bytes_file_md5.set(ByteStringMicro.copyFrom(shortVideoDownReq.md5));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "download md5 = " + shortVideoDownReq.md5);
            }
            pttShortVideo$PttShortVideoDownloadReq.uint32_agent_type.set(shortVideoDownReq.agentType);
            pttShortVideo$PttShortVideoDownloadReq.uint32_business_type.set(shortVideoDownReq.busiType);
            pttShortVideo$PttShortVideoDownloadReq.uint32_flag_support_large_size.set(1);
            pttShortVideo$PttShortVideoDownloadReq.uint32_flag_client_quic_proto_enable.set(1);
            pttShortVideo$PttShortVideoDownloadReq.uint32_file_type.set(shortVideoDownReq.fileType);
            pttShortVideo$PttShortVideoDownloadReq.uint32_down_type.set(shortVideoDownReq.downType);
            pttShortVideo$PttShortVideoDownloadReq.uint32_scene_type.set(shortVideoDownReq.sceneType);
            pttShortVideo$PttShortVideoDownloadReq.uint32_need_inner_addr.set(0);
            if (shortVideoDownReq.busiType == 0) {
                pttShortVideo$PttShortVideoDownloadReq.uint32_req_transfer_type.set(1);
            } else {
                pttShortVideo$PttShortVideoDownloadReq.uint32_req_transfer_type.set(2);
            }
            pttShortVideo$PttShortVideoDownloadReq.uint32_target_codec_format.set(shortVideoDownReq.targetVideoCodecFormat);
            if (shortVideoDownReq.targetVideoCodecFormat == 1) {
                PttShortVideo$CodecConfigReq pttShortVideo$CodecConfigReq = new PttShortVideo$CodecConfigReq();
                pttShortVideo$CodecConfigReq.str_platform_chipinfo.set("android_" + Build.HARDWARE + "_" + AVCoreSystemInfo.getCpuModel());
                pttShortVideo$CodecConfigReq.str_os_version.set(String.valueOf(ah.K()));
                pttShortVideo$CodecConfigReq.str_device_name.set(ah.s());
                pttShortVideo$PttShortVideoDownloadReq.msg_codec_config.set(pttShortVideo$CodecConfigReq);
            }
            int i3 = shortVideoDownReq.sourceVideoCodecFormat;
            if (i3 >= 0) {
                pttShortVideo$PttShortVideoDownloadReq.uint32_source_codec_format.set(i3);
            }
            pttShortVideo$PttShortVideoDownloadReq.uint32_req_host_type.set(11);
            PttShortVideo$ExtensionReq pttShortVideo$ExtensionReq = new PttShortVideo$ExtensionReq();
            pttShortVideo$ExtensionReq.uint32_sub_busi_type.set(shortVideoDownReq.subBusiType);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "constructReqBody ShortVideoDownReq = " + shortVideoDownReq.toString());
            }
            pttShortVideo$ReqBody.uint32_cmd.set(400);
            pttShortVideo$ReqBody.uint32_seq.set(shortVideoDownReq.seq);
            pttShortVideo$ReqBody.msg_PttShortVideoDownload_Req.set(pttShortVideo$PttShortVideoDownloadReq);
            pttShortVideo$ReqBody.rpt_msg_extension_req.add(pttShortVideo$ExtensionReq);
            int i16 = shortVideoDownReq.busiType;
            if (i16 != 1022 && i16 != 1021) {
                return pttShortVideo$ReqBody.toByteArray();
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(RichMediaConstants.OIDB_CMD_VIDEO_EMOTICON_UP_OR_DOWNLOAD);
            oidb_sso_oidbssopkg.uint32_service_type.set(1);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(pttShortVideo$ReqBody.toByteArray()));
            return oidb_sso_oidbssopkg.toByteArray();
        }
        throw new RuntimeException("only support one request");
    }

    public void handleAddr(RichProto.RichProtoResp.ShortVideoDownResp shortVideoDownResp, PttShortVideo$PttShortVideoDownloadResp pttShortVideo$PttShortVideoDownloadResp) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) shortVideoDownResp, (Object) pttShortVideo$PttShortVideoDownloadResp);
            return;
        }
        PttShortVideo$PttShortVideoAddr pttShortVideo$PttShortVideoAddr = pttShortVideo$PttShortVideoDownloadResp.msg_download_addr.get();
        if (pttShortVideo$PttShortVideoAddr != null) {
            int i3 = pttShortVideo$PttShortVideoAddr.uint32_host_type.get();
            shortVideoDownResp.mHostType = i3;
            if (i3 == 0) {
                shortVideoDownResp.mIpList = parseSrvAddlist(shortVideoDownResp, pttShortVideo$PttShortVideoAddr.rpt_str_host.get(), false);
                shortVideoDownResp.mIpv6List = parseSrvAddlist(shortVideoDownResp, pttShortVideo$PttShortVideoAddr.rpt_str_host_ipv6.get(), true);
                if (pttShortVideo$PttShortVideoAddr.rpt_str_domain.has() && pttShortVideo$PttShortVideoAddr.rpt_str_domain.size() > 0) {
                    str = pttShortVideo$PttShortVideoAddr.rpt_str_domain.get(0);
                } else {
                    str = "";
                }
                if (str != null && str.length() > 0) {
                    str = InnerDns.getHostFromUrl(str);
                }
                shortVideoDownResp.mDomain = str;
            }
            shortVideoDownResp.mUrl = pttShortVideo$PttShortVideoAddr.str_url_args.get();
        }
    }

    public void handleRespBody(byte[] bArr, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bArr, richProtoResp, statictisInfo);
            return;
        }
        try {
            PttShortVideo$RspBody pttShortVideo$RspBody = new PttShortVideo$RspBody();
            pttShortVideo$RspBody.mergeFrom(bArr);
            PttShortVideo$PttShortVideoDownloadResp pttShortVideo$PttShortVideoDownloadResp = pttShortVideo$RspBody.msg_PttShortVideoDownload_Resp.get();
            RichProto.RichProtoResp.ShortVideoDownResp shortVideoDownResp = (RichProto.RichProtoResp.ShortVideoDownResp) richProtoResp.resps.get(0);
            int i3 = pttShortVideo$PttShortVideoDownloadResp.int32_ret_code.get();
            if (i3 == 0) {
                shortVideoDownResp.mUkey = HexUtil.bytes2HexStr(pttShortVideo$PttShortVideoDownloadResp.bytes_downloadkey.get().toByteArray());
                shortVideoDownResp.md5 = pttShortVideo$PttShortVideoDownloadResp.bytes_file_md5.get().toByteArray();
                handleAddr(shortVideoDownResp, pttShortVideo$PttShortVideoDownloadResp);
                handleSupportQuic(shortVideoDownResp, pttShortVideo$PttShortVideoDownloadResp);
                shortVideoDownResp.mVideoCodecFormat = pttShortVideo$PttShortVideoDownloadResp.uint32_codec_format.get();
                setResult(0, 0, "", "", statictisInfo, shortVideoDownResp);
                return;
            }
            if (i3 == -5100026) {
                setResult(-1, AppConstants.RichMediaErrorCode.ERR_BAN_DOWNLOAD, ProcessorReport.getUrlReason(i3), "", statictisInfo, shortVideoDownResp);
            } else if (i3 == -5100528) {
                setResult(-1, AppConstants.RichMediaErrorCode.ERR_REJECT_VIDEO_AUTO_DOWN, ProcessorReport.getUrlReason(i3), "", statictisInfo, shortVideoDownResp);
            } else {
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i3), "", statictisInfo, shortVideoDownResp);
            }
            if (pttShortVideo$RspBody.uint32_allow_retry.get() == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onProtoResp : shortVideo server not allow retry");
                }
                shortVideoDownResp.isAllowRetry = false;
            }
        } catch (Exception e16) {
            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason("P", -9529L), e16.getMessage() + " hex:" + HexUtil.bytes2HexStr(bArr), statictisInfo, richProtoResp.resps);
        }
    }

    public void handleSupportQuic(RichProto.RichProtoResp.ShortVideoDownResp shortVideoDownResp, PttShortVideo$PttShortVideoDownloadResp pttShortVideo$PttShortVideoDownloadResp) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) shortVideoDownResp, (Object) pttShortVideo$PttShortVideoDownloadResp);
            return;
        }
        boolean z17 = true;
        if (pttShortVideo$PttShortVideoDownloadResp.uint32_flag_server_quic_proto_enable.has()) {
            if (pttShortVideo$PttShortVideoDownloadResp.uint32_flag_server_quic_proto_enable.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "quic_proto_enable : " + pttShortVideo$PttShortVideoDownloadResp.uint32_flag_server_quic_proto_enable.get());
            }
        } else {
            z16 = false;
        }
        if (pttShortVideo$PttShortVideoDownloadResp.bytes_server_quic_para.has()) {
            ByteStringMicro byteStringMicro = pttShortVideo$PttShortVideoDownloadResp.bytes_server_quic_para.get();
            PttShortVideo$QuicParameter pttShortVideo$QuicParameter = new PttShortVideo$QuicParameter();
            try {
                pttShortVideo$QuicParameter.mergeFrom(byteStringMicro.toByteArray());
                if (z16 && pttShortVideo$QuicParameter.uint32_enable_quic.get() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (pttShortVideo$QuicParameter.uint32_encryption_ver.has()) {
                    int i3 = pttShortVideo$QuicParameter.uint32_encryption_ver.get();
                    if (i3 != 1) {
                        z17 = false;
                    }
                    shortVideoDownResp.mIsQuicEncryption = z17;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "encryption_ver : " + i3);
                    }
                }
                if (pttShortVideo$QuicParameter.uint32_fec_ver.has()) {
                    shortVideoDownResp.mQuicFec = pttShortVideo$QuicParameter.uint32_fec_ver.get();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "fec_ver : " + shortVideoDownResp.mQuicFec);
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 4, e16, new Object[0]);
            }
        }
        shortVideoDownResp.mIsSupportQuic = z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "supportQuic: " + z16);
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.ShortVideoDownResp());
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        int i3;
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
            if (richProtoReq.reqs.size() == 1 && ((i3 = ((RichProto.RichProtoReq.ShortVideoDownReq) richProtoReq.reqs.get(0)).busiType) == 1022 || i3 == 1021)) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                try {
                    oidb_sso_oidbssopkg.mergeFrom(wupBuffer);
                    wupBuffer = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e(TAG, 1, "[onProtoResp] for video emoticon failed. ", e16);
                }
            }
            handleRespBody(wupBuffer, richProtoResp, statictisInfo);
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
                    protoReq.ssoCmd = RichMediaConstants.CMD_SHORT_VIDEO_DOWN;
                } else if (1 != i3 && 3000 != i3 && 10014 != i3) {
                    protoReq.ssoCmd = RichMediaConstants.CMD_SHORT_VIDEO_DOWN;
                } else {
                    protoReq.ssoCmd = RichMediaConstants.CMD_GROUP_SHORT_VIDEO_DOWN;
                }
                int i16 = ((RichProto.RichProtoReq.ShortVideoDownReq) richProtoReq.reqs.get(0)).busiType;
                if (i16 == 1022 || i16 == 1021) {
                    protoReq.ssoCmd = RichMediaConstants.CMD_VIDEO_EMOTICON_DOWN;
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
