package com.tencent.mobileqq.transfile.protohandler;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.multimsg.i;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.longconn.multimsg.MultiMsg$Ipv4Info;
import tencent.im.longconn.multimsg.MultiMsg$Ipv6Info;
import tencent.im.longconn.multimsg.MultiMsg$MultiMsgApplyDownReq;
import tencent.im.longconn.multimsg.MultiMsg$MultiMsgApplyDownRsp;
import tencent.im.longconn.multimsg.MultiMsg$ReqBody;
import tencent.im.longconn.multimsg.MultiMsg$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class MultiMsgDownHandler extends BaseHandler {
    static IPatchRedirector $redirector_;
    int mReqNetType;

    public MultiMsgDownHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void addOne(int i3, RichProto.RichProtoReq.ReqCommon reqCommon, MultiMsg$ReqBody multiMsg$ReqBody) {
        RichProto.RichProtoReq.MultiMsgDownReq multiMsgDownReq = (RichProto.RichProtoReq.MultiMsgDownReq) reqCommon;
        MultiMsg$MultiMsgApplyDownReq multiMsg$MultiMsgApplyDownReq = new MultiMsg$MultiMsgApplyDownReq();
        multiMsg$MultiMsgApplyDownReq.setHasFlag(true);
        multiMsg$MultiMsgApplyDownReq.bytes_msg_resid.set(ByteStringMicro.copyFrom(multiMsgDownReq.msgResId));
        multiMsg$MultiMsgApplyDownReq.uint32_msg_type.set(MultiMsgUpHandler.convertMsgType(multiMsgDownReq.uinType));
        multiMsg$MultiMsgApplyDownReq.uint64_src_uin.set(Long.valueOf(multiMsgDownReq.selfUin).longValue());
        try {
            multiMsg$MultiMsgApplyDownReq.bytes_msg_key.set(ByteStringMicro.copyFrom(getHttpConnKey()));
            byte[] httpConnSig = getHttpConnSig();
            String bytes2HexStr = BdhUtils.bytes2HexStr(httpConnSig);
            if (i.k()) {
                QLog.d("MultiMsg_TAG", 1, "[constructReqBody] getSig=" + bytes2HexStr + ", selfUin=" + multiMsgDownReq.selfUin);
            }
            multiMsg$MultiMsgApplyDownReq.bytes_msg_sig.set(ByteStringMicro.copyFrom(httpConnSig));
        } catch (Exception e16) {
            QLog.e("MultiMsg_TAG", 1, e16, new Object[0]);
        }
        List<ExcitingTransferHostInfo> bDHServerIp = getBDHServerIp(false);
        QLog.i("MultiMsg_TAG_opt", 1, "Multimsg download handler addone bdh serverIP4  " + bDHServerIp);
        if (bDHServerIp.size() > 0) {
            for (ExcitingTransferHostInfo excitingTransferHostInfo : bDHServerIp) {
                if (excitingTransferHostInfo != null) {
                    MultiMsg$Ipv4Info multiMsg$Ipv4Info = new MultiMsg$Ipv4Info();
                    multiMsg$Ipv4Info.uint32_ip_v4_addr.set(f.H(excitingTransferHostInfo.mstrIp));
                    if (QLog.isDevelopLevel()) {
                        QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler ipv4:  " + excitingTransferHostInfo.mstrIp);
                    }
                    multiMsg$Ipv4Info.uint32_ip_v4_port.set(excitingTransferHostInfo.mport);
                    multiMsg$Ipv4Info.uint32_is_https_addr.set(excitingTransferHostInfo.mIsHttps ? 1 : 0);
                    multiMsg$MultiMsgApplyDownReq.rpt_ip_v4_info.add(multiMsg$Ipv4Info);
                }
            }
        }
        List<ExcitingTransferHostInfo> bDHServerIp2 = getBDHServerIp(true);
        QLog.i("MultiMsg_TAG_opt", 1, "Multimsg download handler addone bdh serverIP6 =  " + bDHServerIp2);
        if (bDHServerIp2.size() > 0) {
            for (ExcitingTransferHostInfo excitingTransferHostInfo2 : bDHServerIp2) {
                if (excitingTransferHostInfo2 != null) {
                    MultiMsg$Ipv6Info multiMsg$Ipv6Info = new MultiMsg$Ipv6Info();
                    try {
                        multiMsg$Ipv6Info.bytes_ip_v6_addr.set(ByteStringMicro.copyFrom(InetAddress.getByName(excitingTransferHostInfo2.mstrIp).getAddress()));
                    } catch (UnknownHostException e17) {
                        e17.printStackTrace();
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler ipv6:  " + excitingTransferHostInfo2.mstrIp);
                    }
                    multiMsg$Ipv6Info.uint32_ip_v6_port.set(excitingTransferHostInfo2.mport);
                    multiMsg$Ipv6Info.uint32_is_https_addr.set(excitingTransferHostInfo2.mIsHttps ? 1 : 0);
                    multiMsg$MultiMsgApplyDownReq.rpt_ip_v6_info.add(multiMsg$Ipv6Info);
                }
            }
        }
        multiMsg$ReqBody.rpt_multimsg_applydown_req.add(multiMsg$MultiMsgApplyDownReq);
        if (multiMsgDownReq.multiMsgType == 0) {
            multiMsg$ReqBody.uint32_bu_type.set(2);
        }
    }

    private byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        int netType = NetworkCenter.getInstance().getNetType();
        this.mReqNetType = netType;
        int i3 = 3;
        if (netType != 1) {
            if (netType != 2) {
                if (netType != 3) {
                    if (netType != 4) {
                        i3 = 255;
                    } else {
                        i3 = 8;
                    }
                } else {
                    i3 = 7;
                }
            } else {
                i3 = 6;
            }
        }
        String apnType = NetworkCenter.getInstance().getApnType();
        if (apnType != null && apnType.contains("wap")) {
            i3 = 5;
        }
        MultiMsg$ReqBody multiMsg$ReqBody = new MultiMsg$ReqBody();
        multiMsg$ReqBody.setHasFlag(true);
        multiMsg$ReqBody.uint32_subcmd.set(2);
        multiMsg$ReqBody.uint32_term_type.set(5);
        multiMsg$ReqBody.uint32_platform_type.set(9);
        multiMsg$ReqBody.uint32_net_type.set(i3);
        multiMsg$ReqBody.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
        multiMsg$ReqBody.uint32_req_channel_type.set(2);
        for (int i16 = 0; i16 < list.size(); i16++) {
            addOne(i16, list.get(i16), multiMsg$ReqBody);
        }
        return multiMsg$ReqBody.toByteArray();
    }

    public static List<ExcitingTransferHostInfo> getBDHServerIp(boolean z16) {
        ArrayList arrayList = new ArrayList();
        if (MobileQQ.sProcessId == 1) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            ConfigManager configManager = ConfigManager.getInstance(BaseApplication.getContext(), qQAppInterface.getHwEngine());
            if (configManager != null) {
                List<EndPoint> otherTypeIp = configManager.getOtherTypeIp(qQAppInterface.getApp().getBaseContext(), 21, z16);
                if (otherTypeIp != null && otherTypeIp.size() > 0) {
                    for (EndPoint endPoint : otherTypeIp) {
                        if (endPoint != null && !TextUtils.isEmpty(endPoint.host)) {
                            arrayList.add(new ExcitingTransferHostInfo(endPoint.host, endPoint.port, true));
                        }
                    }
                } else {
                    HwServlet.getConfig(qQAppInterface, qQAppInterface.getCurrentUin());
                }
            }
        }
        return arrayList;
    }

    public static byte[] getHttpConnKey() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return new byte[0];
        }
        if (i.k()) {
            QLog.d("MultiMsg_TAG", 1, "[getHttpConnKey] get session uin = " + peekAppRuntime.getAccount());
        }
        byte[] sessionKey = SessionInfo.getInstance(peekAppRuntime.getAccount()).getSessionKey();
        if (sessionKey == null) {
            return new byte[0];
        }
        return sessionKey;
    }

    public static byte[] getHttpConnSig() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return new byte[0];
        }
        byte[] httpconn_sig_session = SessionInfo.getInstance(peekAppRuntime.getAccount()).getHttpconn_sig_session();
        if (httpconn_sig_session != null && httpconn_sig_session.length != 0) {
            return httpconn_sig_session;
        }
        HwServlet.getConfig(peekAppRuntime, peekAppRuntime.getAccount());
        return new byte[0];
    }

    void handleSSORespError(FromServiceMsg fromServiceMsg, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo, int i3) {
        if (i3 != 1002 && i3 != 1013) {
            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQUEST_MSF_ERROR, BaseMessageHandler.getTimeoutReason(fromServiceMsg), "", statictisInfo, richProtoResp.resps);
        } else {
            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT, BaseMessageHandler.getTimeoutReason(fromServiceMsg), "", statictisInfo, richProtoResp.resps);
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.MultiMsgDownResp());
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        int i3;
        String stringUtf8;
        int i16;
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
            handleSSORespError(fromServiceMsg, richProtoResp, statictisInfo, fromServiceMsg.getResultCode());
        } else {
            try {
                List<MultiMsg$MultiMsgApplyDownRsp> list = new MultiMsg$RspBody().mergeFrom(wupBuffer).rpt_multimsg_applydown_rsp.get();
                int i17 = 0;
                while (i17 < list.size()) {
                    MultiMsg$MultiMsgApplyDownRsp multiMsg$MultiMsgApplyDownRsp = list.get(i17);
                    RichProto.RichProtoResp.MultiMsgDownResp multiMsgDownResp = (RichProto.RichProtoResp.MultiMsgDownResp) richProtoResp.resps.get(i17);
                    int i18 = multiMsg$MultiMsgApplyDownRsp.uint32_result.get();
                    if (i18 == 0) {
                        ByteStringMicro byteStringMicro = multiMsg$MultiMsgApplyDownRsp.bytes_thumb_down_para.get();
                        if (byteStringMicro == null) {
                            stringUtf8 = null;
                        } else {
                            stringUtf8 = byteStringMicro.toStringUtf8();
                        }
                        byte[] byteArray = multiMsg$MultiMsgApplyDownRsp.bytes_msg_resid.get().toByteArray();
                        byte[] byteArray2 = multiMsg$MultiMsgApplyDownRsp.bytes_msg_key.get().toByteArray();
                        if (multiMsg$MultiMsgApplyDownRsp.msg_extern_info.has()) {
                            i16 = multiMsg$MultiMsgApplyDownRsp.msg_extern_info.get().uint32_channel_type.get();
                        } else {
                            i16 = 0;
                        }
                        multiMsgDownResp.mChannelType = i16;
                        multiMsgDownResp.urlParam = stringUtf8;
                        multiMsgDownResp.resId = byteArray;
                        multiMsgDownResp.msgkey = byteArray2;
                        List<Integer> list2 = multiMsg$MultiMsgApplyDownRsp.rpt_uint32_down_ip.get();
                        List<Integer> list3 = multiMsg$MultiMsgApplyDownRsp.rpt_uint32_down_port.get();
                        if (list2 != null) {
                            int i19 = 0;
                            while (i19 < list2.size()) {
                                long intValue = list3.get(i19).intValue();
                                ServerAddr serverAddr = new ServerAddr();
                                serverAddr.mIp = PkgTools.int2IPNet(list2.get(i19).intValue() & 4294967295L);
                                serverAddr.port = (int) intValue;
                                multiMsgDownResp.ipList.add(i19, serverAddr);
                                i19++;
                                i17 = i17;
                                list3 = list3;
                            }
                        }
                        i3 = i17;
                        List<ByteStringMicro> list4 = multiMsg$MultiMsgApplyDownRsp.rpt_bytes_down_ip_v6.get();
                        List<Integer> list5 = multiMsg$MultiMsgApplyDownRsp.rpt_uint32_down_v6_port.get();
                        if (list4 != null) {
                            for (int i26 = 0; i26 < list4.size(); i26++) {
                                ServerAddr serverAddr2 = new ServerAddr();
                                serverAddr2.mIp = InetAddress.getByAddress(list4.get(i26).toByteArray()).getHostAddress();
                                serverAddr2.port = list5.get(i26).intValue();
                                serverAddr2.isIpv6 = true;
                                multiMsgDownResp.mIpv6List.add(i26, serverAddr2);
                            }
                        }
                        setResult(0, 0, "", "", statictisInfo, multiMsgDownResp);
                    } else {
                        i3 = i17;
                        if (i18 == 196) {
                            ReportController.n(null, "CliOper", "", "", "0X8006627", "0X8006627", 0, 1, 0, "", "", "", "");
                        }
                        if (shouldRetryByRetCodeForGroup(i18)) {
                            int i27 = this.mReqUrlCount + 1;
                            this.mReqUrlCount = i27;
                            if (i27 < 2) {
                                richProtoReq.protoReqMgr.sendProtoReq(protoReq);
                                return;
                            }
                        }
                        setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i18), "", statictisInfo, multiMsgDownResp);
                    }
                    i17 = i3 + 1;
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
            protoReq.ssoCmd = RichMediaConstants.CMD_LONGCONN_MULTIMSG_DOWN;
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
