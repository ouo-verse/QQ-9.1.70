package com.tencent.mobileqq.service.message;

import AccostSvc.RespClientMsg;
import AccostSvc.RespDeleteBlackList;
import AccostSvc.RespGetBlackList;
import AccostSvc.RespInsertBlackList;
import AccostSvc.SvrMsg;
import MessageSvcPack.SvcResponseDelMsgV2;
import MessageSvcPack.SvcResponseDelRoamMsg;
import MessageSvcPack.SvcResponseGetMsgV2;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import MessageSvcPack.SvcResponseSetRoamMsg;
import OnlinePushPack.SvcReqPushMsg;
import PushAdMsg.AdMsgInfo;
import PushNotifyPack.RequestPushNotify;
import PushNotifyPack.SvcRequestPushReadedNotify;
import QQService.RespGetSign;
import QQService.RespOffFilePack;
import QQService.RespTmpChatPicDownload;
import QQService.SCPushStreamMsg;
import QQService.SCRespUploadStreamMsg;
import QQService.StreamData;
import QQService.StreamInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f286285a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(FromServiceMsg fromServiceMsg, SvcResponseGetMsgV2 svcResponseGetMsgV2);

        String b(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public byte[] f286309a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f286310b;

        public c(byte[] bArr, byte[] bArr2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, k.this, bArr, bArr2);
            } else {
                this.f286309a = bArr;
                this.f286310b = bArr2;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f286312a;

        /* renamed from: b, reason: collision with root package name */
        public short f286313b;

        /* renamed from: c, reason: collision with root package name */
        public int f286314c;

        /* renamed from: d, reason: collision with root package name */
        public StreamInfo f286315d;

        /* renamed from: e, reason: collision with root package name */
        public int f286316e;

        public d(String str, short s16, int i3, StreamInfo streamInfo, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Short.valueOf(s16), Integer.valueOf(i3), streamInfo, Integer.valueOf(i16));
                return;
            }
            this.f286312a = str;
            this.f286313b = s16;
            this.f286314c = i3;
            this.f286315d = streamInfo;
            this.f286316e = i16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45131);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            com.tencent.imcore.message.s.a();
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcReqPushMsg) k(fromServiceMsg.getWupBuffer(), "req", new SvcReqPushMsg());
    }

    private Object b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        SvcResponseDelMsgV2 svcResponseDelMsgV2 = (SvcResponseDelMsgV2) k(fromServiceMsg.getWupBuffer(), "resp_DelMsgV2", new SvcResponseDelMsgV2());
        if (svcResponseDelMsgV2 != null) {
            return svcResponseDelMsgV2;
        }
        return null;
    }

    private Object c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcResponseDelRoamMsg) k(fromServiceMsg.getWupBuffer(), "resp_DelRoamMsg", new SvcResponseDelRoamMsg());
    }

    private Object d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        RespDeleteBlackList respDeleteBlackList = (RespDeleteBlackList) k(fromServiceMsg.getWupBuffer(), "RespDeleteBlackList", new RespDeleteBlackList());
        fromServiceMsg.extraData.putString("deleteUin", toServiceMsg.extraData.getString("deleteUin"));
        if (respDeleteBlackList.stHeader.eReplyCode != 0) {
            return null;
        }
        return respDeleteBlackList;
    }

    private Object e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (RespGetBlackList) k(fromServiceMsg.getWupBuffer(), "RespGetBlackList", new RespGetBlackList());
    }

    private Object f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        SvcResponseGetMsgV2 svcResponseGetMsgV2 = (SvcResponseGetMsgV2) k(fromServiceMsg.getWupBuffer(), "resp_GetMsgV2", new SvcResponseGetMsgV2());
        if (svcResponseGetMsgV2 != null) {
            f286285a.a(fromServiceMsg, svcResponseGetMsgV2);
            return svcResponseGetMsgV2;
        }
        return null;
    }

    private Object g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3;
        RespOffFilePack respOffFilePack = (RespOffFilePack) k(fromServiceMsg.getWupBuffer(), "RespOffFilePack", new RespOffFilePack());
        toServiceMsg.extraData.getLong("msgTime");
        byte b16 = toServiceMsg.extraData.getByte("type");
        toServiceMsg.extraData.getString("friendUin");
        if (respOffFilePack != null && respOffFilePack.iReplyCode == 0) {
            byte[] bArr = respOffFilePack.vBody;
            byte b17 = bArr[0];
            long longData = PkgTools.getLongData(bArr, 1);
            int shortData = PkgTools.getShortData(respOffFilePack.vBody, 5);
            byte[] bArr2 = new byte[shortData];
            PkgTools.copyData(bArr2, 0, respOffFilePack.vBody, 7, shortData);
            String uTFString = PkgTools.getUTFString(bArr2, 0, shortData);
            int i3 = 7 + shortData;
            if (QLog.isColorLevel()) {
                QLog.d(BaseMessageHandler.TAG, 2, "<<<<decodeGetOffLineFileResp cSubCmd:" + ((int) b17));
            }
            if (b17 != 1) {
                if (b17 != 2) {
                    if (b17 != 3) {
                        if (b17 != 6) {
                            return null;
                        }
                        int shortData2 = PkgTools.getShortData(respOffFilePack.vBody, i3);
                        byte[] bArr3 = new byte[shortData2];
                        PkgTools.copyData(bArr3, 0, respOffFilePack.vBody, i3 + 2, shortData2);
                        return new b(longData, uTFString, b17, b16, bArr3);
                    }
                    byte[] bArr4 = respOffFilePack.vBody;
                    byte b18 = bArr4[i3];
                    int i16 = i3 + 1;
                    PkgTools.getShortData(bArr4, i16);
                    int i17 = i16 + 2;
                    PkgTools.getShortData(respOffFilePack.vBody, i17);
                    int i18 = i17 + 2;
                    PkgTools.getShortData(respOffFilePack.vBody, i18);
                    int i19 = i18 + 2;
                    PkgTools.getShortData(respOffFilePack.vBody, i19);
                    int i26 = i19 + 2;
                    byte[] bArr5 = respOffFilePack.vBody;
                    byte b19 = bArr5[i26];
                    int i27 = i26 + 1;
                    long longData2 = PkgTools.getLongData(bArr5, i27);
                    int i28 = i27 + 4;
                    int shortData3 = PkgTools.getShortData(respOffFilePack.vBody, i28);
                    int i29 = i28 + 2;
                    PkgTools.copyData(new byte[shortData3], 0, respOffFilePack.vBody, i29, shortData3);
                    int i36 = i29 + shortData3;
                    int shortData4 = PkgTools.getShortData(respOffFilePack.vBody, i36);
                    int i37 = i36 + 2;
                    byte[] bArr6 = new byte[shortData4];
                    PkgTools.copyData(bArr6, 0, respOffFilePack.vBody, i37, shortData4);
                    int i38 = i37 + shortData4;
                    byte[] bArr7 = respOffFilePack.vBody;
                    int i39 = bArr7[i38];
                    int i46 = i38 + 1;
                    PkgTools.copyData(new byte[i39], 0, bArr7, i46, i39);
                    int i47 = i46 + i39;
                    byte[] bArr8 = respOffFilePack.vBody;
                    int i48 = bArr8[i47];
                    int i49 = i47 + 1;
                    PkgTools.copyData(new byte[i48], 0, bArr8, i49, i48);
                    int i56 = i49 + i48;
                    int shortData5 = PkgTools.getShortData(respOffFilePack.vBody, i56);
                    int i57 = i56 + 2;
                    byte[] bArr9 = new byte[shortData5];
                    PkgTools.copyData(bArr9, 0, respOffFilePack.vBody, i57, shortData5);
                    String uTFString2 = PkgTools.getUTFString(bArr9, 0, shortData5);
                    int i58 = i57 + shortData5;
                    byte[] bArr10 = respOffFilePack.vBody;
                    byte b26 = bArr10[i58];
                    int i59 = i58 + 1;
                    long longData3 = PkgTools.getLongData(bArr10, i59);
                    int i65 = i59 + 4;
                    long longData4 = PkgTools.getLongData(respOffFilePack.vBody, i65);
                    int i66 = i65 + 4;
                    PkgTools.getShortData(respOffFilePack.vBody, i66);
                    int i67 = i66 + 2;
                    PkgTools.getLongData(respOffFilePack.vBody, i67);
                    long longData5 = PkgTools.getLongData(respOffFilePack.vBody, i67 + 4);
                    if (QLog.isColorLevel()) {
                        QLog.i(BaseMessageHandler.TAG, 2, "<<<<decodeGetOffLineFileResp dwUploadTime = " + longData5);
                    }
                    return new b(longData, uTFString, b17, b16, longData2, HexUtil.bytes2HexStr(bArr6), longData4, toServiceMsg.extraData.getLong("msgTime"), toServiceMsg.extraData.getShort("msgSeq"), longData3, uTFString2, toServiceMsg.extraData.getLong("delUin"));
                }
                return new b(longData, uTFString, b17, b16);
            }
            long longLongData = PkgTools.getLongLongData(respOffFilePack.vBody, i3);
            int i68 = i3 + 8;
            long longLongData2 = PkgTools.getLongLongData(respOffFilePack.vBody, i68);
            int i69 = i68 + 8;
            long longData6 = PkgTools.getLongData(respOffFilePack.vBody, i69);
            int i75 = i69 + 4;
            long longData7 = PkgTools.getLongData(respOffFilePack.vBody, i75);
            int i76 = i75 + 4;
            short shortData6 = PkgTools.getShortData(respOffFilePack.vBody, i76);
            int i77 = i76 + 2;
            int shortData7 = PkgTools.getShortData(respOffFilePack.vBody, i77);
            int i78 = i77 + 2;
            byte[] bArr11 = new byte[shortData7];
            PkgTools.copyData(bArr11, 0, respOffFilePack.vBody, i78, shortData7);
            int i79 = i78 + shortData7;
            int shortData8 = PkgTools.getShortData(respOffFilePack.vBody, i79);
            int i85 = i79 + 2;
            byte[] bArr12 = new byte[shortData8];
            PkgTools.copyData(bArr12, 0, respOffFilePack.vBody, i85, shortData8);
            int i86 = i85 + shortData8;
            byte[] bArr13 = respOffFilePack.vBody;
            byte b27 = bArr13[i86];
            long longData8 = PkgTools.getLongData(bArr13, i86 + 1);
            if (QLog.isColorLevel()) {
                QLog.d("wk", 2, "" + longData + "|" + longData7 + "|" + ((int) shortData6) + "|" + bArr11 + "|" + bArr12 + "|" + ((int) b27));
            }
            return new b(longData, uTFString, b17, b16, longLongData, longLongData2, longData6, longData7, shortData6, bArr11, bArr12, b27, longData8);
        }
        Bundle bundle = fromServiceMsg.extraData;
        if (respOffFilePack == null) {
            j3 = StatictisInfo.DETAIL_REASON_DECODE_FAIL;
        } else {
            j3 = respOffFilePack.iReplyCode;
        }
        bundle.putLong("ServerReplyCode", j3);
        return null;
    }

    private Object h(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        RespTmpChatPicDownload respTmpChatPicDownload = (RespTmpChatPicDownload) k(fromServiceMsg.getWupBuffer(), "RespTmpChatPicDownload", new RespTmpChatPicDownload());
        if (respTmpChatPicDownload == null) {
            return null;
        }
        return respTmpChatPicDownload;
    }

    private Object i(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        RespInsertBlackList respInsertBlackList = (RespInsertBlackList) k(fromServiceMsg.getWupBuffer(), "RespInsertBlackList", new RespInsertBlackList());
        fromServiceMsg.extraData.putString("insertUin", toServiceMsg.extraData.getString("insertUin"));
        if (respInsertBlackList.stHeader.eReplyCode != 0) {
            return null;
        }
        return respInsertBlackList;
    }

    private Object j(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        byte[] bArr = new byte[wupBuffer.length - 4];
        System.arraycopy(wupBuffer, 4, bArr, 0, wupBuffer.length - 4);
        return (RequestPushNotify) k(bArr, "req_PushNotify", new RequestPushNotify());
    }

    private <T> T k(byte[] bArr, String str, T t16) {
        if (bArr == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            return (T) uniPacket.getByClass(str, t16);
        } catch (OutOfMemoryError e16) {
            QLog.i("MessageFactoryReceiver", 1, "decodePacket", e16);
            return null;
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }

    private Object l(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        SvcResponsePullGroupMsgSeq svcResponsePullGroupMsgSeq = (SvcResponsePullGroupMsgSeq) k(fromServiceMsg.getWupBuffer(), "resp_PullGroupMsgSeq", new SvcResponsePullGroupMsgSeq());
        if (QLog.isColorLevel()) {
            QLog.d(BaseMessageHandler.TAG, 2, "decodePullGroupMsgNumResp res" + svcResponsePullGroupMsgSeq);
        }
        return svcResponsePullGroupMsgSeq;
    }

    private Object m(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (AdMsgInfo) k(fromServiceMsg.getWupBuffer(), "PushADMsg", new AdMsgInfo());
    }

    private Object n(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcRequestPushReadedNotify) k(fromServiceMsg.getWupBuffer(), "req", new SvcRequestPushReadedNotify());
    }

    private Object p(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (RespClientMsg) k(fromServiceMsg.getWupBuffer(), "RespClientMsg", new RespClientMsg());
    }

    private Object q(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3;
        RespGetSign respGetSign = (RespGetSign) k(fromServiceMsg.getWupBuffer(), "RespGetSign", new RespGetSign());
        if (respGetSign != null && respGetSign.iReplyCode == 0) {
            return new c(respGetSign.vKey, respGetSign.vSign);
        }
        if (respGetSign == null) {
            j3 = StatictisInfo.DETAIL_REASON_DECODE_FAIL;
        } else {
            j3 = respGetSign.iReplyCode;
        }
        x(toServiceMsg, j3);
        fromServiceMsg.extraData.putLong("ServerReplyCode", j3);
        return null;
    }

    private Object r(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvrMsg) k(fromServiceMsg.getWupBuffer(), "SvrMsg", new SvrMsg());
    }

    private Object s(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        SCPushStreamMsg sCPushStreamMsg = (SCPushStreamMsg) k(fromServiceMsg.getWupBuffer(), "SCPushStreamMsg", new SCPushStreamMsg());
        if (sCPushStreamMsg == null) {
            return null;
        }
        StreamInfo streamInfo = sCPushStreamMsg.stStreamInfo;
        StreamData streamData = sCPushStreamMsg.stStreamData;
        long j3 = sCPushStreamMsg.lKey;
        Object[] objArr = {Long.valueOf(j3), streamInfo, streamData, Long.valueOf(sCPushStreamMsg.bubbleID), Long.valueOf(sCPushStreamMsg.subBubbleId), Long.valueOf(sCPushStreamMsg.diyAddonId)};
        if (QLog.isColorLevel()) {
            QLog.d(BaseMessageHandler.TAG, 2, "decodeServerPushStream: iSeq:" + sCPushStreamMsg.iSeq + ", lKey: " + j3 + ", vipBubbleID:" + objArr[3] + ", subBubbleId:" + objArr[4] + ", diyAddonId:" + objArr[5]);
        }
        return objArr;
    }

    private Object t(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        SCRespUploadStreamMsg sCRespUploadStreamMsg = (SCRespUploadStreamMsg) k(fromServiceMsg.getWupBuffer(), "SCRespUploadStreamMsg", new SCRespUploadStreamMsg());
        if (sCRespUploadStreamMsg == null) {
            return null;
        }
        StreamInfo streamInfo = sCRespUploadStreamMsg.stStreamInfo;
        return new d(f286285a.b(streamInfo.iMsgId), sCRespUploadStreamMsg.shResetSeq, streamInfo.shFlowLayer, streamInfo, sCRespUploadStreamMsg.result);
    }

    private Object u(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcResponseSetRoamMsg) k(fromServiceMsg.getWupBuffer(), "resp_SetRoamMsg", new SvcResponseSetRoamMsg());
    }

    private Object v(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("push", 2, "decodeVideoChatStatus");
            return null;
        }
        return null;
    }

    private void x(ToServiceMsg toServiceMsg, long j3) {
        w(toServiceMsg, 1001, "", j3);
    }

    public static void y(a aVar) {
        f286285a = aVar;
    }

    public Object o(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d(BaseMessageHandler.TAG, 2, "decodeRespMsg cmd: " + serviceCmd);
        }
        if ("MessageSvc.PushNotify".equalsIgnoreCase(serviceCmd)) {
            return j(toServiceMsg, fromServiceMsg);
        }
        if ("MessageSvc.GetMsgV4".equalsIgnoreCase(serviceCmd)) {
            return f(toServiceMsg, fromServiceMsg);
        }
        if ("MessageSvc.DelMsgV2".equalsIgnoreCase(serviceCmd)) {
            return b(toServiceMsg, fromServiceMsg);
        }
        if ("TransService.ReqOffFilePack".equalsIgnoreCase(serviceCmd)) {
            return g(toServiceMsg, fromServiceMsg);
        }
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(serviceCmd)) {
            return h(toServiceMsg, fromServiceMsg);
        }
        if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(serviceCmd)) {
            return u(toServiceMsg, fromServiceMsg);
        }
        if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(serviceCmd)) {
            return c(toServiceMsg, fromServiceMsg);
        }
        if ("ADMsgSvc.PushMsg".equalsIgnoreCase(serviceCmd)) {
            return m(toServiceMsg, fromServiceMsg);
        }
        if (MiniConst.Spark.CMD_PUSH_SPARK_REWARD.equalsIgnoreCase(serviceCmd)) {
            return a(toServiceMsg, fromServiceMsg);
        }
        if ("MessageSvc.PushReaded".equalsIgnoreCase(serviceCmd)) {
            return n(toServiceMsg, fromServiceMsg);
        }
        if ("TransService.ReqGetSign".equalsIgnoreCase(serviceCmd)) {
            return q(toServiceMsg, fromServiceMsg);
        }
        if ("StreamSvr.RespUploadStreamMsg".equalsIgnoreCase(serviceCmd)) {
            return t(toServiceMsg, fromServiceMsg);
        }
        if ("MessageSvc.SendVideoMsg".equalsIgnoreCase(serviceCmd)) {
            return v(toServiceMsg, fromServiceMsg);
        }
        if ("StreamSvr.PushStreamMsg".equalsIgnoreCase(serviceCmd)) {
            return s(toServiceMsg, fromServiceMsg);
        }
        if ("AccostSvc.ClientMsg".equals(serviceCmd)) {
            return p(toServiceMsg, fromServiceMsg);
        }
        if ("AccostSvc.ReqInsertBlackList".equals(serviceCmd)) {
            return i(toServiceMsg, fromServiceMsg);
        }
        if ("AccostSvc.ReqDeleteBlackList".equals(serviceCmd)) {
            return d(toServiceMsg, fromServiceMsg);
        }
        if ("AccostSvc.ReqGetBlackList".equals(serviceCmd)) {
            return e(toServiceMsg, fromServiceMsg);
        }
        if ("AccostSvc.SvrMsg".equals(serviceCmd)) {
            return r(toServiceMsg, fromServiceMsg);
        }
        if ("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(serviceCmd)) {
            return l(toServiceMsg, fromServiceMsg);
        }
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public byte f286286a;

        /* renamed from: b, reason: collision with root package name */
        public long f286287b;

        /* renamed from: c, reason: collision with root package name */
        public String f286288c;

        /* renamed from: d, reason: collision with root package name */
        public long f286289d;

        /* renamed from: e, reason: collision with root package name */
        public String f286290e;

        /* renamed from: f, reason: collision with root package name */
        public long f286291f;

        /* renamed from: g, reason: collision with root package name */
        public long f286292g;

        /* renamed from: h, reason: collision with root package name */
        public short f286293h;

        /* renamed from: i, reason: collision with root package name */
        public long f286294i;

        /* renamed from: j, reason: collision with root package name */
        public String f286295j;

        /* renamed from: k, reason: collision with root package name */
        public byte f286296k;

        /* renamed from: l, reason: collision with root package name */
        public long f286297l;

        /* renamed from: m, reason: collision with root package name */
        public byte[] f286298m;

        /* renamed from: n, reason: collision with root package name */
        public long f286299n;

        /* renamed from: o, reason: collision with root package name */
        public long f286300o;

        /* renamed from: p, reason: collision with root package name */
        public long f286301p;

        /* renamed from: q, reason: collision with root package name */
        public long f286302q;

        /* renamed from: r, reason: collision with root package name */
        public short f286303r;

        /* renamed from: s, reason: collision with root package name */
        public byte[] f286304s;

        /* renamed from: t, reason: collision with root package name */
        public byte[] f286305t;

        /* renamed from: u, reason: collision with root package name */
        public byte f286306u;

        /* renamed from: v, reason: collision with root package name */
        public long f286307v;

        public b(long j3, String str, byte b16, byte b17, long j16, String str2, long j17, long j18, short s16, long j19, String str3, long j26) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, k.this, Long.valueOf(j3), str, Byte.valueOf(b16), Byte.valueOf(b17), Long.valueOf(j16), str2, Long.valueOf(j17), Long.valueOf(j18), Short.valueOf(s16), Long.valueOf(j19), str3, Long.valueOf(j26));
                return;
            }
            this.f286287b = j3;
            this.f286288c = str;
            this.f286296k = b16;
            this.f286286a = b17;
            this.f286289d = j16;
            this.f286290e = str2;
            this.f286291f = j17;
            this.f286292g = j18;
            this.f286293h = s16;
            this.f286294i = j19;
            this.f286295j = str3;
            this.f286297l = j26;
        }

        public b(long j3, String str, byte b16, byte b17, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, k.this, Long.valueOf(j3), str, Byte.valueOf(b16), Byte.valueOf(b17), bArr);
                return;
            }
            this.f286287b = j3;
            this.f286288c = str;
            this.f286296k = b16;
            this.f286286a = b17;
            this.f286298m = bArr;
        }

        public b(long j3, String str, byte b16, byte b17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, k.this, Long.valueOf(j3), str, Byte.valueOf(b16), Byte.valueOf(b17));
                return;
            }
            this.f286287b = j3;
            this.f286288c = str;
            this.f286296k = b16;
            this.f286286a = b17;
        }

        public b(long j3, String str, byte b16, byte b17, long j16, long j17, long j18, long j19, short s16, byte[] bArr, byte[] bArr2, byte b18, long j26) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, k.this, Long.valueOf(j3), str, Byte.valueOf(b16), Byte.valueOf(b17), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Short.valueOf(s16), bArr, bArr2, Byte.valueOf(b18), Long.valueOf(j26));
                return;
            }
            this.f286287b = j3;
            this.f286288c = str;
            this.f286296k = b16;
            this.f286286a = b17;
            this.f286299n = j16;
            this.f286300o = j17;
            this.f286301p = j18;
            this.f286302q = j19;
            this.f286303r = s16;
            this.f286304s = bArr;
            this.f286305t = bArr2;
            this.f286306u = b18;
            this.f286307v = j26;
        }
    }

    private void w(ToServiceMsg toServiceMsg, int i3, String str, long j3) {
    }
}
