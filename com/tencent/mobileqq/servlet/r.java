package com.tencent.mobileqq.servlet;

import SharpSvrPack.MultiVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.utils.ae;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.audioplayer.f;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xa02.cmd0xa02$ReqBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02$RspBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02$TinyID;
import tencent.im.oidb.cmd0xa02.cmd0xa02$TinyID2UserAccInfo;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r extends MSFServlet {
    static IPatchRedirector $redirector_;

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private long a(String str) {
        long parseLong;
        if (str == null) {
            return 0L;
        }
        if (str.length() > 0) {
            try {
                parseLong = Long.parseLong(str);
                if (parseLong < 10000) {
                    return 0L;
                }
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return parseLong;
    }

    private void b(VideoCallMsg videoCallMsg) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (videoCallMsg == null) {
            AVCoreLog.printAllUserLog("VideoConfigServlet", "handleVideoConfigMessage error videoMsg = null");
            return;
        }
        byte[] bArr = videoCallMsg.vMsg;
        if (bArr != null) {
            int[] j3 = pu.c.j(bArr);
            boolean z19 = true;
            if (j3 != null) {
                QLog.d("VideoConfigServlet", 1, "handleVideoConfigMessage receive ptt info. ", Arrays.toString(j3));
                int i3 = j3[0];
                int i16 = j3[1];
                if (j3[2] == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QQAudioHelper.r(0, new f.a(i3, i16, z16));
                int i17 = j3[3];
                int i18 = j3[4];
                if (j3[5] == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                QQAudioHelper.r(1, new f.a(i17, i18, z17));
                int i19 = j3[6];
                int i26 = j3[7];
                if (j3[8] == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                QQAudioHelper.r(2, new f.a(i19, i26, z18));
                int i27 = j3[9];
                int i28 = j3[10];
                if (j3[11] != 1) {
                    z19 = false;
                }
                QQAudioHelper.r(3, new f.a(i27, i28, z19));
            } else {
                QLog.d("VideoConfigServlet", 1, "handleVideoConfigMessage no ptt info.");
            }
        }
        pu.c.p(String.valueOf(AppSetting.f()), getAppRuntime().getApplication(), videoCallMsg.vMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (intent != null) {
            if ("VideoCCSvc.Adaptation".equalsIgnoreCase(serviceCmd)) {
                QLog.w("VideoConfigServlet", 1, "VideoConfigServlet, isSuccess[" + fromServiceMsg.isSuccess() + "]");
                if (fromServiceMsg.isSuccess()) {
                    b((VideoCallMsg) decodePacket(fromServiceMsg.getWupBuffer(), "VideoCallMsg", new VideoCallMsg()));
                    return;
                }
                return;
            }
            if ("OidbSvc.0xa02".equalsIgnoreCase(serviceCmd)) {
                if (fromServiceMsg.isSuccess()) {
                    try {
                        int length = fromServiceMsg.getWupBuffer().length - 4;
                        byte[] bArr = new byte[length];
                        PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
                        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                        oidb_sso_oidbssopkg.mergeFrom(bArr);
                        if (oidb_sso_oidbssopkg.uint32_result.get() != 0) {
                            AVCoreLog.printColorLog("VideoConfigServlet", "cmd0xa02 onReceive uint32_result = " + oidb_sso_oidbssopkg.uint32_result.get());
                        } else if (oidb_sso_oidbssopkg.bytes_bodybuffer.has()) {
                            cmd0xa02$RspBody cmd0xa02_rspbody = new cmd0xa02$RspBody();
                            cmd0xa02_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                            List<cmd0xa02$TinyID2UserAccInfo> list = cmd0xa02_rspbody.rpt_tinyid2useracc_info.get();
                            AVCoreLog.printColorLog("VideoConfigServlet", "cmd0xa02 onReceive list = " + list.toString());
                            new ArrayList();
                            ArrayList<AVPhoneUserInfo> i3 = ae.i(list);
                            QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
                            if (qQAppInterface != null) {
                                qQAppInterface.getAVNotifyCenter().P0(i3);
                            }
                        }
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                AVCoreLog.printColorLog("VideoConfigServlet", "cmd0xa02 onReceive not success!");
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        Bundle extras = intent.getExtras();
        if (QQAudioHelper.j()) {
            QQAudioHelper.m("VideoConfigServlet.onSend", extras, true);
        }
        if (extras == null) {
            return;
        }
        int i3 = extras.getInt("reqType", 0);
        if (i3 == 8) {
            packet.setServantName("MultiVideo");
            packet.setFuncName("MultiVideoMsg");
            packet.setSSOCommand("MultiVideo.c2s");
            packet.addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.TRUE);
            MultiVideoMsg multiVideoMsg = new MultiVideoMsg();
            multiVideoMsg.ver = extras.getByte("ver");
            multiVideoMsg.type = extras.getByte("type");
            multiVideoMsg.csCmd = extras.getShort("cscmd");
            multiVideoMsg.from_uin = a(String.valueOf(extras.getLong(ShortVideoConstants.FROM_UIN)));
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(extras.getLong("toUin")));
            multiVideoMsg.to_uin = arrayList;
            multiVideoMsg.msg_time = extras.getLong(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME);
            multiVideoMsg.msg_type = extras.getLong(QQHealthReportApiImpl.MSG_TYPE_KEY);
            multiVideoMsg.msg_seq = extras.getLong("msg_seq");
            multiVideoMsg.msg_uid = extras.getLong("msg_uid");
            multiVideoMsg.video_buff = extras.getByteArray("vMsg");
            packet.addRequestPacket("MultiVideoMsg", multiVideoMsg);
            return;
        }
        if (i3 == 15) {
            cmd0xa02$ReqBody cmd0xa02_reqbody = new cmd0xa02$ReqBody();
            ArrayList arrayList2 = (ArrayList) extras.getSerializable("tinyid_list");
            if (arrayList2.size() > 0) {
                for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                    cmd0xa02$TinyID cmd0xa02_tinyid = new cmd0xa02$TinyID();
                    cmd0xa02_tinyid.uint64_tinyid.set(((Long) arrayList2.get(i16)).longValue());
                    cmd0xa02_reqbody.rpt_tinyid.add(cmd0xa02_tinyid);
                }
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.uint32_command.set(2562);
                oidb_sso_oidbssopkg.uint32_service_type.set(0);
                oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0xa02_reqbody.toByteArray()));
                byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
                byte[] bArr = new byte[byteArray.length + 4];
                PkgTools.dWord2Byte(bArr, 0, byteArray.length + 4);
                PkgTools.copyData(bArr, 4, byteArray, byteArray.length);
                packet.setSSOCommand("OidbSvc.0xa02");
                packet.putSendData(bArr);
                AVCoreLog.printColorLog("VideoConfigServlet", "cmd0xa02 onSend");
                return;
            }
            return;
        }
        packet.setServantName("VideoSvc");
        packet.setFuncName("SendVideoMsg");
        packet.setSSOCommand("VideoCCSvc.Adaptation");
        VideoCallMsg videoCallMsg = new VideoCallMsg();
        videoCallMsg.ver = (byte) 1;
        videoCallMsg.type = (byte) 1;
        videoCallMsg.lUin = a(getAppRuntime().getAccount());
        videoCallMsg.lPeerUin = 0L;
        videoCallMsg.uDateTime = (int) (System.currentTimeMillis() / 1000);
        videoCallMsg.cVerifyType = (byte) 0;
        videoCallMsg.uSeqId = 0;
        videoCallMsg.uSessionId = 0;
        videoCallMsg.vMsg = pu.c.g(videoCallMsg.lUin, String.valueOf(AppSetting.f()), getAppRuntime().getApplication());
        packet.addRequestPacket("VideoCallMsg", videoCallMsg);
    }
}
