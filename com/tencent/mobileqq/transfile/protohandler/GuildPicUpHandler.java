package com.tencent.mobileqq.transfile.protohandler;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
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

/* loaded from: classes19.dex */
public class GuildPicUpHandler extends PicUpHandler {
    static IPatchRedirector $redirector_;
    int mReqNetType;

    public GuildPicUpHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void handleSucResult(StatictisInfo statictisInfo, cmd0x388$TryUpImgRsp cmd0x388_tryupimgrsp, RichProto.RichProtoResp.GuildPicUpResp guildPicUpResp) throws Exception {
        guildPicUpResp.groupFileID = cmd0x388_tryupimgrsp.uint64_fileid.get();
        if (cmd0x388_tryupimgrsp.bytes_download_index.has()) {
            guildPicUpResp.mDownLoadIndex = cmd0x388_tryupimgrsp.bytes_download_index.get().toByteArray();
        } else {
            QLog.d(BaseHandler.TAG, 1, "handleSucResult: Guild_mDownLoadIndex is null");
        }
        boolean z16 = false;
        if (cmd0x388_tryupimgrsp.bool_file_exit.has() && cmd0x388_tryupimgrsp.bool_file_exit.get()) {
            guildPicUpResp.isExist = true;
            List<Integer> list = cmd0x388_tryupimgrsp.rpt_uint32_up_ip.get();
            List<Integer> list2 = cmd0x388_tryupimgrsp.rpt_uint32_up_port.get();
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    long intValue = list2.get(i3).intValue();
                    ServerAddr serverAddr = new ServerAddr();
                    serverAddr.mIp = PkgTools.int2IPNet(list.get(i3).intValue() & 4294967295L);
                    serverAddr.port = (int) intValue;
                    guildPicUpResp.mIpList.add(i3, serverAddr);
                }
            }
        } else {
            List<Integer> list3 = cmd0x388_tryupimgrsp.rpt_uint32_up_ip.get();
            List<Integer> list4 = cmd0x388_tryupimgrsp.rpt_uint32_up_port.get();
            if (list3 != null && list3.size() > 0) {
                for (int i16 = 0; i16 < list3.size(); i16++) {
                    long intValue2 = list4.get(i16).intValue();
                    ServerAddr serverAddr2 = new ServerAddr();
                    serverAddr2.mIp = PkgTools.int2IPNet(list3.get(i16).intValue() & 4294967295L);
                    serverAddr2.port = (int) intValue2;
                    guildPicUpResp.mIpList.add(i16, serverAddr2);
                }
            }
            String bytes2HexStr = HexUtil.bytes2HexStr(cmd0x388_tryupimgrsp.bytes_up_ukey.get().toByteArray());
            if (bytes2HexStr != null && !bytes2HexStr.equals("") && list3 != null && list3.size() != 0) {
                guildPicUpResp.mUkey = bytes2HexStr;
                guildPicUpResp.blockSize = (int) cmd0x388_tryupimgrsp.uint64_block_size.get();
                guildPicUpResp.transferedSize = (int) cmd0x388_tryupimgrsp.uint64_up_offset.get();
                if (NetworkCenter.getInstance().getNetType() != this.mReqNetType) {
                    z16 = true;
                }
                guildPicUpResp.networkChange = z16;
                guildPicUpResp.startOffset = cmd0x388_tryupimgrsp.uint64_up_offset.get();
                if (QLog.isColorLevel()) {
                    QLog.d(BdhLogUtil.Tag, 2, " Channel:" + cmd0x388_tryupimgrsp.bool_new_big_chan.get());
                }
                if (cmd0x388_tryupimgrsp.bool_new_big_chan.has() && cmd0x388_tryupimgrsp.bool_new_big_chan.get()) {
                    guildPicUpResp.isUseBdh = true;
                }
            } else {
                throw new Exception("check ukey,iplist");
            }
        }
        setResult(0, 0, "", "", statictisInfo, guildPicUpResp);
    }

    void addOne(int i3, RichProto.RichProtoReq.ReqCommon reqCommon, cmd0x388$ReqBody cmd0x388_reqbody) {
        RichProto.RichProtoReq.PicUpReq picUpReq = (RichProto.RichProtoReq.PicUpReq) reqCommon;
        cmd0x388$TryUpImgReq cmd0x388_tryupimgreq = new cmd0x388$TryUpImgReq();
        cmd0x388_tryupimgreq.setHasFlag(true);
        cmd0x388_tryupimgreq.uint64_src_uin.set(Long.parseLong(picUpReq.selfUin));
        cmd0x388_tryupimgreq.uint64_group_code.set(Long.parseLong(picUpReq.peerUin));
        cmd0x388_tryupimgreq.uint64_file_id.set(i3);
        cmd0x388_tryupimgreq.uint64_file_size.set(picUpReq.fileSize);
        cmd0x388_tryupimgreq.bytes_file_md5.set(ByteStringMicro.copyFrom(picUpReq.md5));
        cmd0x388_tryupimgreq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(picUpReq.fileName));
        cmd0x388_tryupimgreq.uint32_src_term.set(5);
        cmd0x388_tryupimgreq.uint32_platform_type.set(9);
        cmd0x388_tryupimgreq.uint32_pic_width.set(picUpReq.width);
        cmd0x388_tryupimgreq.uint32_pic_height.set(picUpReq.height);
        cmd0x388_tryupimgreq.uint32_pic_type.set(picUpReq.picType);
        cmd0x388_tryupimgreq.uint32_app_pic_type.set(picUpReq.busiType);
        cmd0x388_tryupimgreq.uint32_bu_type.set(211);
        cmd0x388_tryupimgreq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
        cmd0x388_tryupimgreq.uint32_srv_upload.set(picUpReq.typeHotPic);
        cmd0x388_tryupimgreq.uint64_qqmeet_channel_id.set(Long.parseLong(picUpReq.peerUin));
        cmd0x388_tryupimgreq.uint64_qqmeet_guild_id.set(Long.parseLong(picUpReq.secondUin));
        if (picUpReq.isRaw) {
            cmd0x388_tryupimgreq.uint32_original_pic.set(1);
        }
        if (!TextUtils.isEmpty(picUpReq.transferUrl)) {
            cmd0x388_tryupimgreq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(picUpReq.transferUrl));
        }
        cmd0x388_reqbody.rpt_msg_tryup_img_req.add(cmd0x388_tryupimgreq);
    }

    byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> list) {
        cmd0x388$ReqBody cmd0x388_reqbody = new cmd0x388$ReqBody();
        cmd0x388_reqbody.setHasFlag(true);
        cmd0x388_reqbody.uint32_subcmd.set(1);
        cmd0x388_reqbody.uint32_command_id.set(83);
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
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v6, types: [long] */
    @Override // com.tencent.mobileqq.transfile.protohandler.PicUpHandler, com.tencent.mobileqq.transfile.protohandler.BaseHandler
    protected void handleSucResp(FromServiceMsg fromServiceMsg, byte[] bArr, RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo, ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        RichProto.RichProtoResp.GuildPicUpResp guildPicUpResp;
        String str5;
        String str6;
        String str7;
        String str8;
        RichProto.RichProtoResp.GuildPicUpResp guildPicUpResp2;
        RichProto.RichProtoResp.GuildPicUpResp guildPicUpResp3;
        long j3;
        int i16;
        long j16 = this;
        FromServiceMsg fromServiceMsg2 = fromServiceMsg;
        String str9 = " hex:";
        String str10 = "P";
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, j16, fromServiceMsg2, bArr, richProtoReq, richProtoResp, statictisInfo, protoResp, protoReq);
            return;
        }
        try {
            List<cmd0x388$TryUpImgRsp> list = new cmd0x388$RspBody().mergeFrom(bArr).rpt_msg_tryup_img_rsp.get();
            try {
                if (list != null && list.size() != 0) {
                    GuildPicUpHandler guildPicUpHandler = j16;
                    for (cmd0x388$TryUpImgRsp cmd0x388_tryupimgrsp : list) {
                        try {
                            guildPicUpResp2 = (RichProto.RichProtoResp.GuildPicUpResp) richProtoResp.resps.get((int) cmd0x388_tryupimgrsp.uint64_file_id.get());
                        } catch (Exception e16) {
                            e = e16;
                            i3 = i17;
                            str3 = str10;
                            str4 = str9;
                            j16 = -9529;
                            guildPicUpResp = null;
                        }
                        if (guildPicUpResp2 != null) {
                            try {
                                if (fromServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP)) {
                                    try {
                                        guildPicUpResp2.isSendByQuickHttp = ((Boolean) fromServiceMsg2.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP, Boolean.FALSE)).booleanValue();
                                    } catch (Exception e17) {
                                        e = e17;
                                        i3 = i17;
                                        str3 = str10;
                                        str4 = str9;
                                        j16 = -9529;
                                        guildPicUpResp = guildPicUpResp2;
                                        str5 = str3;
                                        try {
                                            String serverReason = ProcessorReport.getServerReason(str5, j16);
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(e.getMessage());
                                            str6 = str4;
                                        } catch (Exception e18) {
                                            e = e18;
                                            str = str5;
                                            str2 = str4;
                                        }
                                        try {
                                            sb5.append(str6);
                                            sb5.append(HexUtil.bytes2HexStr(bArr));
                                            str7 = str6;
                                            str8 = str5;
                                            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, serverReason, sb5.toString(), statictisInfo, guildPicUpResp);
                                            guildPicUpHandler = this;
                                            fromServiceMsg2 = fromServiceMsg;
                                            i17 = i3;
                                            str9 = str7;
                                            str10 = str8;
                                        } catch (Exception e19) {
                                            e = e19;
                                            str2 = str6;
                                            str = str5;
                                            setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getServerReason(str, j16), e.getMessage() + str2 + HexUtil.bytes2HexStr(bArr), statictisInfo, richProtoResp.resps);
                                            return;
                                        }
                                    }
                                }
                                i16 = cmd0x388_tryupimgrsp.uint32_result.get();
                            } catch (Exception e26) {
                                e = e26;
                                guildPicUpResp3 = guildPicUpResp2;
                                i3 = i17;
                                str3 = str10;
                                str4 = str9;
                                j3 = -9529;
                            }
                            if (i16 == 0 && cmd0x388_tryupimgrsp.bytes_download_index.has()) {
                                guildPicUpHandler.handleSucResult(statictisInfo, cmd0x388_tryupimgrsp, guildPicUpResp2);
                            } else {
                                if (guildPicUpHandler.shouldRetryByRetCodeForGroup(i16)) {
                                    int i18 = guildPicUpHandler.mReqUrlCount + 1;
                                    guildPicUpHandler.mReqUrlCount = i18;
                                    if (i18 < i17) {
                                        richProtoReq.protoReqMgr.sendProtoReq(protoReq);
                                        return;
                                    }
                                }
                                j3 = -9529;
                                guildPicUpResp3 = guildPicUpResp2;
                                i3 = i17;
                                str3 = str10;
                                str4 = str9;
                                try {
                                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, ProcessorReport.getUrlReason(i16), "", statictisInfo, guildPicUpResp3);
                                    str8 = str3;
                                    str7 = str4;
                                } catch (Exception e27) {
                                    e = e27;
                                    guildPicUpResp = guildPicUpResp3;
                                    j16 = j3;
                                    str5 = str3;
                                    String serverReason2 = ProcessorReport.getServerReason(str5, j16);
                                    StringBuilder sb52 = new StringBuilder();
                                    sb52.append(e.getMessage());
                                    str6 = str4;
                                    sb52.append(str6);
                                    sb52.append(HexUtil.bytes2HexStr(bArr));
                                    str7 = str6;
                                    str8 = str5;
                                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, serverReason2, sb52.toString(), statictisInfo, guildPicUpResp);
                                    guildPicUpHandler = this;
                                    fromServiceMsg2 = fromServiceMsg;
                                    i17 = i3;
                                    str9 = str7;
                                    str10 = str8;
                                }
                                guildPicUpHandler = this;
                                fromServiceMsg2 = fromServiceMsg;
                                i17 = i3;
                                str9 = str7;
                                str10 = str8;
                            }
                        }
                        i3 = i17;
                        str3 = str10;
                        str4 = str9;
                        str8 = str3;
                        str7 = str4;
                        guildPicUpHandler = this;
                        fromServiceMsg2 = fromServiceMsg;
                        i17 = i3;
                        str9 = str7;
                        str10 = str8;
                    }
                    return;
                }
                throw new Exception("resps null");
            } catch (Exception e28) {
                e = e28;
            }
        } catch (Exception e29) {
            e = e29;
            str = str10;
            str2 = str9;
            j16 = -9529;
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.BaseHandler
    void initResps(RichProto.RichProtoReq richProtoReq) {
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        richProtoResp.resps.clear();
        for (int i3 = 0; i3 < richProtoReq.reqs.size(); i3++) {
            richProtoResp.resps.add(i3, new RichProto.RichProtoResp.GuildPicUpResp());
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
            protoReq.ssoCmd = RichMediaConstants.CMD_LONGCONN_GUILDPIC_UP;
            protoReq.reqBody = constructReqBody(richProtoReq.reqs);
            protoReq.busiData = richProtoReq;
            protoReq.callback = this;
            inner_sendToProtoReq(richProtoReq, protoReq);
        }
    }
}
