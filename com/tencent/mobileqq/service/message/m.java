package com.tencent.mobileqq.service.message;

import AccostSvc.ClientMsg;
import AccostSvc.Msg;
import AccostSvc.MsgItem;
import AccostSvc.ReqDeleteBlackList;
import AccostSvc.ReqGetBlackList;
import AccostSvc.ReqHeader;
import AccostSvc.ReqInsertBlackList;
import AccostSvc.RespHeader;
import AccostSvc.RespSvrMsg;
import AccostSvc.RichMsg;
import AccostSvc.SvrMsg;
import AccostSvc.UserInfo;
import MessageSvcPack.AccostMsg;
import MessageSvcPack.SvcDelMsgInfo;
import MessageSvcPack.SvcRequestDelMsgV2;
import MessageSvcPack.SvcRequestDelRoamMsg;
import MessageSvcPack.SvcRequestGetMsgV2;
import MessageSvcPack.SvcRequestSendVideoMsg;
import MessageSvcPack.SvcRequestSetRoamMsgAllUser;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.DeviceInfo;
import OnlinePushPack.SvcRespPushMsg;
import QQService.CSRespPushStreamMsg;
import QQService.CSUploadStreamMsg;
import QQService.ReqGetSign;
import QQService.ReqOffFilePack;
import QQService.ReqTmpChatPicDownload;
import QQService.StreamData;
import QQService.StreamInfo;
import SharpSvrPack.MultiVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.api.IBaseHandlerService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import tencent.im.cs.ptt_reserve.ptt_reserve$ReserveStruct;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static a f286317b;

    /* renamed from: a, reason: collision with root package name */
    AtomicInteger f286318a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        short a(String str);

        void b(SvcRequestSendVideoMsg svcRequestSendVideoMsg, String str);

        byte[] c(String str, short s16);

        boolean d(String str);

        byte[] e(String str);

        int f(String str);

        short g(String str);

        boolean removeStreamTaskToMemoryPool(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45135);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            com.tencent.imcore.message.s.a();
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286318a = new AtomicInteger();
        }
    }

    private long b(String str) {
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

    private boolean c(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("OnlinePush");
        uniPacket.setFuncName("SvcRespPushMsg");
        uniPacket.setRequestId(toServiceMsg.extraData.getInt("seq"));
        SvcRespPushMsg svcRespPushMsg = new SvcRespPushMsg();
        svcRespPushMsg.lUin = toServiceMsg.extraData.getLong("lUin");
        svcRespPushMsg.svrip = toServiceMsg.extraData.getInt("svrip");
        if (svcRespPushMsg.lUin < 10000) {
            return false;
        }
        if (toServiceMsg.extraData.getSerializable("delMsgInfos") != null) {
            ArrayList<DelMsgInfo> arrayList = (ArrayList) toServiceMsg.extraData.getSerializable("delMsgInfos");
            svcRespPushMsg.vDelInfos = arrayList;
            Iterator<DelMsgInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                DelMsgInfo next = it.next();
                if (QLog.isColorLevel()) {
                    QLog.d(BaseMessageHandler.TAG, 2, "createC2COnlinePushBuff uin: " + next.lFromUin + " seq: " + ((int) next.shMsgSeq));
                }
                if (next.vMsgCookies != null && QLog.isColorLevel()) {
                    QLog.d(BaseMessageHandler.TAG, 2, "createC2COnlinePushBuff Cookies: " + HexUtil.bytes2HexStr(next.vMsgCookies));
                }
            }
        }
        if (toServiceMsg.extraData.getByteArray("bytes_push_token") != null) {
            svcRespPushMsg.bytes_push_token = (byte[]) toServiceMsg.extraData.getByteArray("bytes_push_token").clone();
        }
        int i3 = toServiceMsg.extraData.getInt("service_type");
        if (i3 != -1) {
            svcRespPushMsg.service_type = i3;
        }
        Serializable serializable = toServiceMsg.extraData.getSerializable("deviceInfo");
        if (serializable != null && (serializable instanceof DeviceInfo)) {
            svcRespPushMsg.deviceInfo = (DeviceInfo) serializable;
            if (QLog.isColorLevel()) {
                QLog.d("MessageFactorySender", 2, "createC2COnlinePushBuff serviceType=" + i3 + " device=" + svcRespPushMsg.deviceInfo.strOSVer);
            }
        }
        uniPacket.put("resp", svcRespPushMsg);
        return true;
    }

    private boolean e(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        byte[] e16;
        int i3;
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.shVersion = (short) 0;
        reqHeader.lMID = t(Long.parseLong(toServiceMsg.getUin()));
        reqHeader.iAppID = AppSetting.f();
        long j3 = toServiceMsg.extraData.getLong("to");
        String string = toServiceMsg.extraData.getString("msg");
        boolean z16 = toServiceMsg.extraData.getBoolean("hello");
        byte b16 = toServiceMsg.extraData.getByte("cType");
        String string2 = toServiceMsg.extraData.getString("pyNickname");
        long j16 = toServiceMsg.extraData.getLong("msgSeq");
        if (string2 == null) {
            string2 = "";
        }
        if (b16 == 18) {
            e16 = string.getBytes();
        } else {
            e16 = f286317b.e(string);
        }
        long j17 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        MsgItem msgItem = new MsgItem(b16, e16);
        ArrayList arrayList = new ArrayList();
        arrayList.add(msgItem);
        UserInfo userInfo = new UserInfo();
        userInfo.nickname = string2;
        RichMsg richMsg = new RichMsg(arrayList, "", userInfo, 0);
        long longValue = Long.valueOf(toServiceMsg.getUin()).longValue();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ClientMsg clientMsg = new ClientMsg(reqHeader, new Msg((short) 5, j16, longValue, j3, currentTimeMillis, i3, richMsg.toByteArray(), 0L, 0L));
        uniPacket.setServantName("AccostObj");
        uniPacket.setFuncName("CMD_CLT_Msg");
        uniPacket.put("ClientMsg", clientMsg);
        toServiceMsg.setTimeout(j17);
        return true;
    }

    private boolean f(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setEncodeName("utf-8");
        uniPacket.setServantName("MessageSvc");
        uniPacket.setFuncName("DelMsgV2");
        SvcRequestDelMsgV2 svcRequestDelMsgV2 = new SvcRequestDelMsgV2();
        svcRequestDelMsgV2.lUin = Long.parseLong(toServiceMsg.getUin());
        svcRequestDelMsgV2.vDelInfos = new ArrayList<>();
        svcRequestDelMsgV2.vAccostMsg = new ArrayList<>();
        long[] longArray = toServiceMsg.extraData.getLongArray("fromUin");
        int[] intArray = toServiceMsg.extraData.getIntArray("msgTime");
        short[] shortArray = toServiceMsg.extraData.getShortArray("msgSeq");
        if (longArray != null && longArray.length > 0) {
            for (int i3 = 0; i3 < longArray.length; i3++) {
                SvcDelMsgInfo svcDelMsgInfo = new SvcDelMsgInfo();
                svcDelMsgInfo.lFromUin = longArray[i3];
                svcDelMsgInfo.uMsgTime = intArray[i3];
                svcDelMsgInfo.shMsgSeq = shortArray[i3];
                svcRequestDelMsgV2.vDelInfos.add(svcDelMsgInfo);
                if (QLog.isColorLevel()) {
                    QLog.d("MessageFactorySender", 2, "createDelMessageBuff i: " + i3 + " fromUin:" + longArray[i3] + " msgTime: " + intArray[i3] + " msgSeq:" + ((int) shortArray[i3]));
                }
            }
        }
        long[] longArray2 = toServiceMsg.extraData.getLongArray("accostFromUin");
        long[] longArray3 = toServiceMsg.extraData.getLongArray("accostToUin");
        long[] longArray4 = toServiceMsg.extraData.getLongArray("accostMsgId");
        short[] shortArray2 = toServiceMsg.extraData.getShortArray("accostMsgType");
        if (longArray2 != null && longArray2.length > 0) {
            for (int i16 = 0; i16 < longArray2.length; i16++) {
                AccostMsg accostMsg = new AccostMsg();
                accostMsg.lFromMID = longArray2[i16];
                accostMsg.lToMID = longArray3[i16];
                accostMsg.uMsgID = longArray4[i16];
                accostMsg.shMsgType = shortArray2[i16];
                accostMsg.strMsg = new byte[1];
                svcRequestDelMsgV2.vAccostMsg.add(accostMsg);
                if (QLog.isColorLevel()) {
                    QLog.d("MessageFactorySender", 2, "createDelMessageBuff i: " + i16 + " accostFromUin:" + longArray2[i16] + " accostMsgId: " + longArray4[i16] + " accostMsgType:" + ((int) shortArray2[i16]));
                }
            }
        }
        uniPacket.put("req_DelMsgV2", svcRequestDelMsgV2);
        return true;
    }

    private boolean g(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("MessageSvc.DelRoamMsg");
        uniPacket.setFuncName("DelRoamMsg");
        Bundle bundle = toServiceMsg.extraData;
        SvcRequestDelRoamMsg svcRequestDelRoamMsg = new SvcRequestDelRoamMsg();
        svcRequestDelRoamMsg.lUin = b(toServiceMsg.getUin());
        svcRequestDelRoamMsg.lPeerUin = b(bundle.getString("uin"));
        svcRequestDelRoamMsg.cVerifyType = (byte) 0;
        uniPacket.put("req_DelRoamMsg", svcRequestDelRoamMsg);
        return true;
    }

    private boolean h(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.shVersion = (short) 0;
        reqHeader.lMID = t(Long.parseLong(toServiceMsg.getUin()));
        reqHeader.iAppID = AppSetting.f();
        String string = toServiceMsg.extraData.getString("deleteUin");
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(string));
        ReqDeleteBlackList reqDeleteBlackList = new ReqDeleteBlackList(reqHeader, arrayList, 0);
        uniPacket.setServantName("AccostObj");
        uniPacket.setFuncName("CMD_DELETE_BlackList");
        uniPacket.put("ReqDeleteBlackList", reqDeleteBlackList);
        toServiceMsg.setTimeout(10000L);
        return true;
    }

    private boolean i(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.shVersion = (short) 0;
        reqHeader.lMID = t(Long.parseLong(toServiceMsg.getUin()));
        reqHeader.iAppID = AppSetting.f();
        long j3 = toServiceMsg.extraData.getLong("lNextMid");
        if (j3 < 0) {
            return false;
        }
        ReqGetBlackList reqGetBlackList = new ReqGetBlackList(reqHeader, j3, 1, 0);
        uniPacket.setServantName("AccostObj");
        uniPacket.setFuncName("CMD_GET_BlackList");
        uniPacket.put("ReqGetBlackList", reqGetBlackList);
        toServiceMsg.setTimeout(10000L);
        return true;
    }

    private synchronized boolean j(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("MessageSvc");
        uniPacket.setFuncName("GetMsgV4");
        SvcRequestGetMsgV2 svcRequestGetMsgV2 = new SvcRequestGetMsgV2();
        long b16 = b(toServiceMsg.getUin());
        svcRequestGetMsgV2.lUin = b16;
        if (b16 == 0) {
            return false;
        }
        int i3 = toServiceMsg.extraData.getInt("lastSeq");
        byte b17 = toServiceMsg.extraData.getByte("cChannel");
        byte[] byteArray = toServiceMsg.extraData.getByteArray("vCookies");
        int i16 = toServiceMsg.extraData.getInt("cSyncFlag");
        byte b18 = toServiceMsg.extraData.getByte("onlineSyncFlag");
        byte[] byteArray2 = toServiceMsg.extraData.getByteArray("vSyncCookie");
        svcRequestGetMsgV2.uDateTime = i3;
        svcRequestGetMsgV2.cMsgStoreType = (byte) 1;
        svcRequestGetMsgV2.cRecivePic = (byte) 1;
        svcRequestGetMsgV2.shAbility = (short) 15;
        svcRequestGetMsgV2.cChannel = b17;
        svcRequestGetMsgV2.vCookies = byteArray;
        svcRequestGetMsgV2.cSyncFlag = i16;
        svcRequestGetMsgV2.shLatestRambleNumber = (short) 20;
        svcRequestGetMsgV2.shOtherRambleNumber = (short) 3;
        svcRequestGetMsgV2.cChannelEx = (byte) 1;
        svcRequestGetMsgV2.vSyncCookie = byteArray2;
        svcRequestGetMsgV2.cRambleFlag = (byte) 0;
        svcRequestGetMsgV2.cUnFilter = (byte) 0;
        svcRequestGetMsgV2.cInst = (byte) 0;
        svcRequestGetMsgV2.cOnlineSyncFlag = b18;
        svcRequestGetMsgV2.cContextFlag = (byte) 1;
        svcRequestGetMsgV2.lGeneralAbi = 1L;
        uniPacket.put("req_GetMsgV2", svcRequestGetMsgV2);
        return true;
    }

    private boolean k(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.shVersion = (short) 0;
        reqHeader.lMID = t(Long.parseLong(toServiceMsg.getUin()));
        reqHeader.iAppID = AppSetting.f();
        String string = toServiceMsg.extraData.getString("insertUin");
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(string));
        ReqInsertBlackList reqInsertBlackList = new ReqInsertBlackList(reqHeader, arrayList, 0);
        uniPacket.setServantName("AccostObj");
        uniPacket.setFuncName("CMD_INSERT_BlackList");
        uniPacket.put("ReqInsertBlackList", reqInsertBlackList);
        toServiceMsg.setTimeout(10000L);
        return true;
    }

    private boolean l(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("MultiVideo");
        uniPacket.setFuncName("MultiVideos2cack");
        Bundle bundle = toServiceMsg.extraData;
        MultiVideoMsg multiVideoMsg = new MultiVideoMsg();
        multiVideoMsg.ver = bundle.getByte("ver");
        multiVideoMsg.type = bundle.getByte("type");
        multiVideoMsg.csCmd = bundle.getShort("cscmd");
        multiVideoMsg.subCmd = bundle.getShort("subcmd");
        multiVideoMsg.from_uin = b(String.valueOf(bundle.getLong(ShortVideoConstants.FROM_UIN)));
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(bundle.getLong("to_uin")));
        multiVideoMsg.to_uin = arrayList;
        multiVideoMsg.msg_time = bundle.getLong(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME);
        multiVideoMsg.msg_type = bundle.getLong(QQHealthReportApiImpl.MSG_TYPE_KEY);
        multiVideoMsg.msg_seq = bundle.getLong("msg_seq");
        multiVideoMsg.msg_uid = bundle.getLong("msg_uid");
        multiVideoMsg.video_buff = bundle.getByteArray("video_buff");
        uniPacket.put("MultiVideoMsg", multiVideoMsg);
        return true;
    }

    private boolean m(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        int length;
        int i3;
        uniPacket.setServantName("TransService");
        uniPacket.setFuncName("ReqOffFilePack");
        Bundle bundle = toServiceMsg.extraData;
        int i16 = bundle.getInt("offfile_type");
        ReqOffFilePack reqOffFilePack = new ReqOffFilePack();
        reqOffFilePack.lUIN = b(toServiceMsg.getUin());
        byte[] byteArray = bundle.getByteArray("filepath");
        if (byteArray == null) {
            length = 0;
        } else {
            length = byteArray.length;
        }
        long b16 = b(bundle.getString("uin"));
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3 && i16 != 4) {
                        if (i16 == 5 && byteArray != null) {
                            byte[] bArr = new byte[length + 10];
                            reqOffFilePack.vBody = bArr;
                            bArr[0] = 3;
                            bArr[1] = 6;
                            PkgTools.word2Byte(bArr, 2, (short) 0);
                            PkgTools.word2Byte(reqOffFilePack.vBody, 4, (short) 0);
                            PkgTools.word2Byte(reqOffFilePack.vBody, 6, (short) 1);
                            PkgTools.word2Byte(reqOffFilePack.vBody, 8, (short) length);
                            PkgTools.copyData(reqOffFilePack.vBody, 10, byteArray, length);
                        }
                    } else {
                        bundle.getInt("vip_level");
                        reqOffFilePack.vBody = y(bundle.getByteArray(PreloadTRTCPlayerParams.KEY_SIG), byteArray, bundle.getByteArray("filename"), bundle.getByteArray("filemd5"), bundle.getLong(MediaDBValues.FILESIZE));
                    }
                } else {
                    byte b17 = bundle.getByte("result");
                    if (byteArray != null) {
                        i3 = length + 8;
                    } else {
                        i3 = 8;
                    }
                    byte[] bArr2 = new byte[i3];
                    reqOffFilePack.vBody = bArr2;
                    bArr2[0] = 2;
                    bArr2[1] = b17;
                    PkgTools.dWord2Byte(bArr2, 2, b16);
                    PkgTools.word2Byte(reqOffFilePack.vBody, 6, (short) length);
                    PkgTools.copyData(reqOffFilePack.vBody, 8, byteArray, length);
                }
            } else {
                byte[] bArr3 = new byte[13];
                reqOffFilePack.vBody = bArr3;
                bArr3[0] = 6;
                PkgTools.dWord2Byte(bArr3, 1, b16);
                PkgTools.dWord2Byte(reqOffFilePack.vBody, 5, 0L);
                PkgTools.dWord2Byte(reqOffFilePack.vBody, 9, 0L);
            }
        } else if (byteArray != null) {
            byte[] bArr4 = new byte[length + 10];
            reqOffFilePack.vBody = bArr4;
            bArr4[0] = 3;
            bArr4[1] = 6;
            PkgTools.word2Byte(bArr4, 2, (short) 0);
            PkgTools.word2Byte(reqOffFilePack.vBody, 4, (short) 0);
            PkgTools.word2Byte(reqOffFilePack.vBody, 6, (short) 1);
            PkgTools.word2Byte(reqOffFilePack.vBody, 8, (short) length);
            PkgTools.copyData(reqOffFilePack.vBody, 10, byteArray, length);
        }
        uniPacket.put("ReqOffFilePack", reqOffFilePack);
        return true;
    }

    private boolean n(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        short s16;
        uniPacket.setServantName("StreamSvr");
        uniPacket.setFuncName("GetCSUploadStreamMsgBuf");
        long a16 = a(Long.valueOf(toServiceMsg.extraData.getString("uin")).longValue());
        String string = toServiceMsg.extraData.getString("filepath");
        String string2 = toServiceMsg.extraData.getString("selfuin");
        String string3 = toServiceMsg.extraData.getString("uin");
        Short valueOf = Short.valueOf(toServiceMsg.extraData.getShort("PackSeq"));
        int i3 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_SEQ);
        long j3 = toServiceMsg.extraData.getLong(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM);
        long j16 = toServiceMsg.extraData.getLong("VoiceType");
        long j17 = toServiceMsg.extraData.getLong("VoiceLength");
        long j18 = toServiceMsg.extraData.getLong("SubBubbleId");
        int i16 = toServiceMsg.extraData.getInt("DiyTextId");
        StreamInfo streamInfo = new StreamInfo();
        streamInfo.lFromUIN = b(string2);
        streamInfo.lToUIN = b(string3);
        streamInfo.iMsgId = f286317b.f(string);
        streamInfo.type = 1;
        streamInfo.iSendTime = 0;
        streamInfo.shPackNum = f286317b.g(string);
        streamInfo.shFlowLayer = f286317b.a(string);
        streamInfo.pttTime = j17;
        streamInfo.pttFormat = j16;
        streamInfo.subBubbleId = j18;
        int x16 = x();
        streamInfo.netType = x16;
        if (valueOf.shortValue() == 1) {
            ptt_reserve$ReserveStruct ptt_reserve_reservestruct = new ptt_reserve$ReserveStruct();
            ptt_reserve_reservestruct.uint32_change_voice.set(0);
            ptt_reserve_reservestruct.uint32_autototext_voice.set(0);
            im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
            im_msg_body_generalflags.uint32_bubble_sub_id.set((int) j18);
            im_msg_body_generalflags.uint32_bubble_diy_text_id.set(i16);
            ptt_reserve_reservestruct.bytes_general_flags.set(ByteStringMicro.copyFrom(im_msg_body_generalflags.toByteArray()));
            streamInfo.vPbData = ptt_reserve_reservestruct.toByteArray();
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "C2CStreamUp: type[" + j16 + "] length[" + j17 + "]");
            if (QLog.isColorLevel()) {
                QLog.d("RecordParams", 2, "C2CStreamUp: net[" + x16 + "]");
            }
        }
        StreamData streamData = new StreamData();
        short shortValue = valueOf.shortValue();
        streamData.shPackSeq = shortValue;
        if (shortValue < streamInfo.shPackNum) {
            s16 = 0;
            streamInfo.shPackNum = (short) 0;
        } else {
            s16 = 0;
        }
        streamData.vData = f286317b.c(string, valueOf.shortValue());
        boolean d16 = f286317b.d(string);
        if (d16) {
            streamInfo.shPackNum = s16;
            streamInfo.oprType = (short) 1;
            f286317b.removeStreamTaskToMemoryPool(string);
        }
        if (QLog.isColorLevel()) {
            QLog.d("StreamPtt", 2, "shPackSeq:" + valueOf + " shPackNum:" + ((int) streamInfo.shPackNum) + ",layer:" + ((int) streamInfo.shFlowLayer) + ",msgId:" + streamInfo.iMsgId + " cancelled:" + d16);
        }
        new QQService.ReqHeader((short) 0, uniPacket.getRequestId(), a16);
        if (i3 == 0 && j3 == 0) {
            uniPacket.put("CSUploadStreamMsg", d(uniPacket, streamInfo, streamData, (short) 1));
            return true;
        }
        streamInfo.msgSeq = i3;
        streamInfo.random = j3;
        uniPacket.put("CSUploadStreamMsg", d(uniPacket, streamInfo, streamData, (short) 10));
        return true;
    }

    private boolean o(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("StreamSvr");
        uniPacket.setFuncName("GetCSRespPushStreamMsgBuf");
        String string = toServiceMsg.extraData.getString("filepath");
        String string2 = toServiceMsg.extraData.getString("selfuin");
        String string3 = toServiceMsg.extraData.getString("uin");
        Short valueOf = Short.valueOf(toServiceMsg.extraData.getShort("PackSeq"));
        long j3 = toServiceMsg.extraData.getLong("lkey");
        StreamInfo streamInfo = new StreamInfo();
        streamInfo.lFromUIN = b(string3);
        streamInfo.lToUIN = b(string2);
        streamInfo.iMsgId = f286317b.f(string);
        streamInfo.type = 1;
        streamInfo.iSendTime = 0;
        streamInfo.shPackNum = (short) 0;
        streamInfo.shFlowLayer = f286317b.a(string);
        if (QLog.isColorLevel()) {
            QLog.d(BuddyTransfileProcessor.STREAM_TAG_R, 2, "createReqpushStreamMsg ---streaminfo.lFromUIN= " + streamInfo.lFromUIN + "---streaminfo.shFlowLayer = " + ((int) streamInfo.shFlowLayer) + "---streaminfo.lToUIN = " + streamInfo.lToUIN + "---streaminfo.iMsgId = " + streamInfo.iMsgId + "---PackSeq = " + valueOf + "---lKey = " + j3);
        }
        uniPacket.put("CSRespPushStreamMsg", new CSRespPushStreamMsg((short) 1, uniPacket.getRequestId(), streamInfo, valueOf.shortValue(), j3));
        return true;
    }

    private boolean p(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        SvrMsg svrMsg = (SvrMsg) toServiceMsg.extraData.getSerializable("SvrMsg");
        ReqHeader reqHeader = svrMsg.stHeader;
        RespSvrMsg respSvrMsg = new RespSvrMsg(new RespHeader(reqHeader.shVersion, reqHeader.lMID, 0, ""), svrMsg.stMsg);
        uniPacket.setEncodeName("utf-8");
        uniPacket.setServantName("AccostObj");
        uniPacket.setFuncName("CMD_SVR_Msg");
        uniPacket.put("RespSvrMsg", respSvrMsg);
        return true;
    }

    private boolean q(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("TransService");
        uniPacket.setFuncName("ReqGetSign");
        Bundle bundle = toServiceMsg.extraData;
        ReqGetSign reqGetSign = new ReqGetSign();
        reqGetSign.lUIN = b(toServiceMsg.getUin());
        reqGetSign.uSSOVer = bundle.getInt("ssover");
        reqGetSign.uAppID = bundle.getInt("app_id");
        reqGetSign.cA2Type = bundle.getByte("a2type");
        reqGetSign.vA2 = new byte[0];
        reqGetSign.vCiphertext = bundle.getByteArray("enkey");
        uniPacket.put("ReqGetSign", reqGetSign);
        return true;
    }

    private boolean r(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("TransService");
        uniPacket.setFuncName("ReqTmpChatPicDownload");
        Bundle bundle = toServiceMsg.extraData;
        ReqTmpChatPicDownload reqTmpChatPicDownload = new ReqTmpChatPicDownload();
        reqTmpChatPicDownload.lUIN = b(toServiceMsg.getUin());
        int i3 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i3 + 1;
        reqTmpChatPicDownload.lSeq = i3;
        reqTmpChatPicDownload.strFlieKey = bundle.getString("filekey");
        reqTmpChatPicDownload.getPicSize = bundle.getByte("picscale");
        uniPacket.put("ReqTmpChatPicDownload", reqTmpChatPicDownload);
        return true;
    }

    private boolean s(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("MessageSvc.SetRoamMsgAllUser");
        uniPacket.setFuncName("SetRoamMsgAllUser");
        Bundle bundle = toServiceMsg.extraData;
        SvcRequestSetRoamMsgAllUser svcRequestSetRoamMsgAllUser = new SvcRequestSetRoamMsgAllUser();
        svcRequestSetRoamMsgAllUser.lUin = b(toServiceMsg.getUin());
        svcRequestSetRoamMsgAllUser.shType = bundle.getShort("shType");
        svcRequestSetRoamMsgAllUser.cValue = bundle.getByte("cValue");
        svcRequestSetRoamMsgAllUser.cVerifyType = (byte) 0;
        uniPacket.put("req_SetRoamMsgAllUser", svcRequestSetRoamMsgAllUser);
        return true;
    }

    public static long t(long j3) {
        return j3 | 0;
    }

    private boolean u(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        String str;
        uniPacket.setServantName("MessageSvc");
        uniPacket.setFuncName("SendVideoMsg");
        Bundle bundle = toServiceMsg.extraData;
        SvcRequestSendVideoMsg svcRequestSendVideoMsg = new SvcRequestSendVideoMsg();
        svcRequestSendVideoMsg.lUin = b(toServiceMsg.getUin());
        svcRequestSendVideoMsg.lPeerUin = b(bundle.getString("uin"));
        svcRequestSendVideoMsg.uDateTime = ((int) System.currentTimeMillis()) / 1000;
        svcRequestSendVideoMsg.cVerifyType = bundle.getByte("cVerifyType");
        svcRequestSendVideoMsg.vMsg = bundle.getByteArray("vMsg");
        uniPacket.put("req_SendVideoMsg", svcRequestSendVideoMsg);
        byte[] bArr = svcRequestSendVideoMsg.vMsg;
        if (bArr != null) {
            str = String.valueOf((int) bArr[2]);
        } else {
            str = "null";
        }
        f286317b.b(svcRequestSendVideoMsg, str);
        return true;
    }

    private boolean v(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("VideoSvc");
        uniPacket.setFuncName("SendVideoMsg");
        Bundle bundle = toServiceMsg.extraData;
        VideoCallMsg videoCallMsg = new VideoCallMsg();
        videoCallMsg.ver = (byte) 1;
        videoCallMsg.type = (byte) 1;
        videoCallMsg.lUin = b(toServiceMsg.getUin());
        videoCallMsg.lPeerUin = bundle.getLong("toUin");
        videoCallMsg.uDateTime = ((int) System.currentTimeMillis()) / 1000;
        videoCallMsg.cVerifyType = (byte) 0;
        videoCallMsg.uSeqId = 0;
        videoCallMsg.uSessionId = 0;
        videoCallMsg.vMsg = bundle.getByteArray("vMsg");
        uniPacket.put("VideoCallMsg", videoCallMsg);
        return true;
    }

    public static void z(a aVar) {
        f286317b = aVar;
    }

    long a(long j3) {
        return j3 & 281474976710655L;
    }

    @NotNull
    public CSUploadStreamMsg d(UniPacket uniPacket, StreamInfo streamInfo, StreamData streamData, short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CSUploadStreamMsg) iPatchRedirector.redirect((short) 4, this, uniPacket, streamInfo, streamData, Short.valueOf(s16));
        }
        return new CSUploadStreamMsg(s16, uniPacket.getRequestId(), streamInfo, streamData, this.f286318a.incrementAndGet());
    }

    public boolean w(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if ("MessageSvc.DelMsgV2".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
            return f(toServiceMsg, uniPacket);
        }
        if ("MessageSvc.GetMsgV4".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
            return j(toServiceMsg, uniPacket);
        }
        if ("TransService.ReqGetSign".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101532", false)) {
                return q(toServiceMsg, uniPacket);
            }
        } else {
            if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return r(toServiceMsg, uniPacket);
            }
            if ("TransService.ReqOffFilePack".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return m(toServiceMsg, uniPacket);
            }
            if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return s(toServiceMsg, uniPacket);
            }
            if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return g(toServiceMsg, uniPacket);
            }
            if ("MessageSvc.SendVideoMsg".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return u(toServiceMsg, uniPacket);
            }
            if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return n(toServiceMsg, uniPacket);
            }
            if ("StreamSvr.RespPushStreamMsg".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return o(toServiceMsg, uniPacket);
            }
            if ("VideoCCSvc.Adaptation".equals(toServiceMsg.getServiceCmd())) {
                return v(toServiceMsg, uniPacket);
            }
            if ("MultiVideo.s2cack".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return l(toServiceMsg, uniPacket);
            }
            if (BaseConstants.CMD_RESPPUSH.equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return c(toServiceMsg, uniPacket);
            }
            if ("AccostSvc.ClientMsg".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return e(toServiceMsg, uniPacket);
            }
            if ("AccostSvc.ReqInsertBlackList".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return k(toServiceMsg, uniPacket);
            }
            if ("AccostSvc.ReqDeleteBlackList".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return h(toServiceMsg, uniPacket);
            }
            if ("AccostSvc.ReqGetBlackList".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return i(toServiceMsg, uniPacket);
            }
            if ("AccostSvc.SvrMsg".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                return p(toServiceMsg, uniPacket);
            }
        }
        return false;
    }

    public int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return ((IBaseHandlerService) QRoute.api(IBaseHandlerService.class)).getHandlerNetType();
    }

    public byte[] y(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j3) {
        int length;
        int length2;
        int length3;
        int length4;
        int length5;
        int length6;
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, this, bArr, bArr2, bArr3, bArr4, Long.valueOf(j3));
        }
        if (bArr == null) {
            length = 2;
        } else {
            length = bArr.length + 2;
        }
        int i19 = length + 5;
        if (bArr == null) {
            length2 = 2;
        } else {
            length2 = bArr.length + 2;
        }
        int i26 = i19 + length2 + 6;
        if (bArr3 == null) {
            length3 = 2;
        } else {
            length3 = bArr3.length + 2;
        }
        int i27 = i26 + length3;
        if (bArr4 == null) {
            length4 = 1;
        } else {
            length4 = bArr4.length + 1;
        }
        int i28 = i27 + length4;
        if (bArr4 == null) {
            length5 = 1;
        } else {
            length5 = bArr4.length + 1;
        }
        int i29 = i28 + length5;
        if (bArr2 == null) {
            length6 = 2;
        } else {
            length6 = bArr2.length + 2;
        }
        byte[] bArr5 = new byte[i29 + length6];
        bArr5[0] = 1;
        PkgTools.dWord2Byte(bArr5, 1, 0L);
        int i36 = 7;
        if (bArr != null) {
            PkgTools.word2Byte(bArr5, 5, (short) bArr.length);
            PkgTools.copyData(bArr5, 7, bArr, bArr.length);
            i36 = 7 + bArr.length;
        } else {
            PkgTools.word2Byte(bArr5, 5, (short) 0);
        }
        if (bArr != null) {
            PkgTools.word2Byte(bArr5, i36, (short) bArr.length);
            int i37 = i36 + 2;
            PkgTools.copyData(bArr5, i37, bArr, bArr.length);
            i3 = i37 + bArr.length;
        } else {
            PkgTools.word2Byte(bArr5, i36, (short) 0);
            i3 = i36 + 2;
        }
        PkgTools.word2Byte(bArr5, i3, (short) 0);
        int i38 = i3 + 2;
        PkgTools.dWord2Byte(bArr5, i38, j3);
        int i39 = i38 + 4;
        if (bArr3 != null) {
            PkgTools.word2Byte(bArr5, i39, (short) bArr3.length);
            int i46 = i39 + 2;
            PkgTools.copyData(bArr5, i46, bArr3, bArr3.length);
            i16 = i46 + bArr3.length;
        } else {
            PkgTools.word2Byte(bArr5, i39, (short) 0);
            i16 = i39 + 2;
        }
        if (bArr4 != null) {
            bArr5[i16] = (byte) bArr4.length;
            int i47 = i16 + 1;
            PkgTools.copyData(bArr5, i47, bArr4, bArr4.length);
            i17 = i47 + bArr4.length;
        } else {
            bArr5[i16] = 0;
            i17 = i16 + 1;
        }
        if (bArr4 != null) {
            bArr5[i17] = (byte) bArr4.length;
            int i48 = i17 + 1;
            PkgTools.copyData(bArr5, i48, bArr4, bArr4.length);
            i18 = i48 + bArr4.length;
        } else {
            bArr5[i17] = 0;
            i18 = i17 + 1;
        }
        if (bArr2 != null) {
            PkgTools.word2Byte(bArr5, i18, (short) bArr2.length);
            PkgTools.copyData(bArr5, i18 + 2, bArr2, bArr2.length);
        } else {
            PkgTools.word2Byte(bArr5, i18, (short) 0);
        }
        return bArr5;
    }
}
