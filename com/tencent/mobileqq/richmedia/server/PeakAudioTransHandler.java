package com.tencent.mobileqq.richmedia.server;

import android.text.TextUtils;
import com.tencent.av.business.handler.a;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$InfoC2SCreateSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$InfoC2SCreateSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$InfoC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$InfoHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$InfoReqBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$InfoRspBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SChangeSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SChangeSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SExitSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SHeartBeatReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SJoinSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SJoinSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SRawDataReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntReqBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntRspBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntS2CNotifyExitReq;
import com.tencent.mobileqq.audiotrans.AudioTransCommon$NetAddr;
import com.tencent.mobileqq.audiotrans.AudioTransCommon$TranslateResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.richmedia.conn.ConnManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import rm2.a;
import rm2.c;

/* loaded from: classes18.dex */
public class PeakAudioTransHandler extends BusinessHandler {

    /* renamed from: m, reason: collision with root package name */
    private static final Object f281747m = 2000;

    /* renamed from: d, reason: collision with root package name */
    public long f281748d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f281749e;

    /* renamed from: f, reason: collision with root package name */
    private ConnManager f281750f;

    /* renamed from: h, reason: collision with root package name */
    private a f281751h;

    /* renamed from: i, reason: collision with root package name */
    private Random f281752i;

    public PeakAudioTransHandler(AppInterface appInterface) {
        super(appInterface);
        this.f281749e = false;
        this.f281752i = new Random();
        this.f281751h = new a();
        this.f281750f = new ConnManager(appInterface, this.f281751h);
    }

    private AudioTransClientTransInfo$IntReqBody D2(int i3, byte[] bArr, int i16, int i17, boolean z16, int i18) {
        AudioTransClientTransInfo$IntReqBody audioTransClientTransInfo$IntReqBody = new AudioTransClientTransInfo$IntReqBody();
        if (i3 == 1) {
            AudioTransClientTransInfo$IntC2SJoinSessionReq audioTransClientTransInfo$IntC2SJoinSessionReq = new AudioTransClientTransInfo$IntC2SJoinSessionReq();
            audioTransClientTransInfo$IntC2SJoinSessionReq.uint32_client_ver.set(1);
            audioTransClientTransInfo$IntC2SJoinSessionReq.enum_term.set(4);
            audioTransClientTransInfo$IntC2SJoinSessionReq.enum_net_type.set(i18);
            audioTransClientTransInfo$IntC2SJoinSessionReq.enum_business_direction.set(1);
            audioTransClientTransInfo$IntC2SJoinSessionReq.enum_data_source.set(2);
            audioTransClientTransInfo$IntC2SJoinSessionReq.bool_translate.set(z16);
            audioTransClientTransInfo$IntReqBody.msg_join_session_req.set(audioTransClientTransInfo$IntC2SJoinSessionReq);
        } else if (i3 == 3) {
            audioTransClientTransInfo$IntReqBody.msg_exit_session_req.set(new AudioTransClientTransInfo$IntC2SExitSessionReq());
        } else if (i3 == 7) {
            AudioTransClientTransInfo$IntC2SRawDataReq audioTransClientTransInfo$IntC2SRawDataReq = new AudioTransClientTransInfo$IntC2SRawDataReq();
            if (bArr != null) {
                audioTransClientTransInfo$IntC2SRawDataReq.bytes_data.set(ByteStringMicro.copyFrom(bArr, i16, i17));
            }
            audioTransClientTransInfo$IntC2SRawDataReq.str_key.set("audio_trans");
            audioTransClientTransInfo$IntReqBody.msg_raw_data_req.set(audioTransClientTransInfo$IntC2SRawDataReq);
        } else if (i3 == 5) {
            AudioTransClientTransInfo$IntC2SChangeSessionReq audioTransClientTransInfo$IntC2SChangeSessionReq = new AudioTransClientTransInfo$IntC2SChangeSessionReq();
            audioTransClientTransInfo$IntC2SChangeSessionReq.bool_translate.set(z16);
            audioTransClientTransInfo$IntReqBody.msg_change_session_req.set(audioTransClientTransInfo$IntC2SChangeSessionReq);
        } else if (i3 == 9) {
            audioTransClientTransInfo$IntReqBody.msg_heart_beat_req.set(new AudioTransClientTransInfo$IntC2SHeartBeatReq());
        }
        return audioTransClientTransInfo$IntReqBody;
    }

    private AudioTransClientTransInfo$IntHead E2(int i3, String str) {
        AudioTransClientTransInfo$IntHead audioTransClientTransInfo$IntHead = new AudioTransClientTransInfo$IntHead();
        audioTransClientTransInfo$IntHead.str_session_id.set(str);
        audioTransClientTransInfo$IntHead.str_uin.set(this.appRuntime.getAccount());
        audioTransClientTransInfo$IntHead.uint32_seq.set(this.f281752i.nextInt());
        audioTransClientTransInfo$IntHead.enum_body_type.set(i3);
        return audioTransClientTransInfo$IntHead;
    }

    private void G2(byte[] bArr, byte[] bArr2) {
        long j3;
        try {
            AudioTransClientTransInfo$InfoHead mergeFrom = new AudioTransClientTransInfo$InfoHead().mergeFrom(bArr);
            if (mergeFrom.uint32_error_no.has()) {
                AudioTransClientTransInfo$InfoRspBody mergeFrom2 = new AudioTransClientTransInfo$InfoRspBody().mergeFrom(bArr2);
                if (mergeFrom.uint32_error_no.get() == 0) {
                    AudioTransClientTransInfo$InfoC2SCreateSessionRsp audioTransClientTransInfo$InfoC2SCreateSessionRsp = mergeFrom2.msg_create_session_rsp.get();
                    int i3 = audioTransClientTransInfo$InfoC2SCreateSessionRsp.enum_channel_type.get();
                    String str = mergeFrom.str_session_id.get();
                    if (i3 == 1) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PeakAudioTransHandler", 2, "channelType is CT_SSO");
                        }
                        int i16 = audioTransClientTransInfo$InfoC2SCreateSessionRsp.uint32_combine_num.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("PeakAudioTransHandler", 2, "combineNum = " + i16);
                        }
                        List<AudioTransCommon$NetAddr> list = audioTransClientTransInfo$InfoC2SCreateSessionRsp.rpt_msg_interface_list.get();
                        ArrayList<com.tencent.mobileqq.richmedia.conn.a> arrayList = new ArrayList<>();
                        for (AudioTransCommon$NetAddr audioTransCommon$NetAddr : list) {
                            String e16 = com.tencent.av.business.handler.a.e(audioTransCommon$NetAddr.fixed32_IP.get());
                            int i17 = audioTransCommon$NetAddr.uint32_port.get();
                            if (QLog.isColorLevel()) {
                                QLog.d("PeakAudioTransHandler", 2, "fixed32_IP = " + e16 + "uint32_port = " + i17);
                            }
                            com.tencent.mobileqq.richmedia.conn.a aVar = new com.tencent.mobileqq.richmedia.conn.a(e16, i17);
                            aVar.C = i16;
                            arrayList.add(aVar);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            j3 = Long.valueOf(str).longValue();
                        } else {
                            j3 = 0;
                        }
                        if (!arrayList.isEmpty()) {
                            if (this.f281751h.j()) {
                                this.f281751h.b(2);
                                com.tencent.mobileqq.richmedia.conn.a aVar2 = arrayList.get(0);
                                this.f281750f.k(arrayList);
                                this.f281750f.i(aVar2, j3);
                                if (QLog.isColorLevel()) {
                                    QLog.e("PeakAudioTransHandler", 1, "create delay = " + (System.currentTimeMillis() - this.f281748d));
                                    return;
                                }
                                return;
                            }
                            QLog.e("PeakAudioTransHandler", 1, "session not in opening state");
                            notifyUI(3, true, new Object[]{Long.valueOf(j3), 0});
                            return;
                        }
                        QLog.e("PeakAudioTransHandler", 1, "sessionIpList is null");
                        return;
                    }
                    if (i3 == 2) {
                        QLog.d("PeakAudioTransHandler", 2, "channelType is CT_RELAY");
                        return;
                    }
                    return;
                }
                AudioTransClientTransInfo$InfoC2SFailedRsp audioTransClientTransInfo$InfoC2SFailedRsp = mergeFrom2.msg_failed_rsp.get();
                QLog.d("PeakAudioTransHandler", 2, "create session rsp failed, errcode:" + audioTransClientTransInfo$InfoC2SFailedRsp.uint32_errcode.get() + "  msg:" + audioTransClientTransInfo$InfoC2SFailedRsp.str_errmsg.get());
                return;
            }
            QLog.e("PeakAudioTransHandler", 2, "response not return uint32_error_no");
        } catch (InvalidProtocolBufferMicroException e17) {
            e17.printStackTrace();
            QLog.e("PeakAudioTransHandler", 2, "exception = " + e17.getMessage());
        }
    }

    private void H2(byte[] bArr, byte[] bArr2) {
        int i3;
        int i16;
        long j3;
        try {
            AudioTransClientTransInfo$IntHead mergeFrom = new AudioTransClientTransInfo$IntHead().mergeFrom(bArr);
            if (mergeFrom.uint32_error_no.has()) {
                i3 = mergeFrom.uint32_error_no.get();
            } else {
                i3 = 0;
            }
            if (mergeFrom.enum_body_type.has()) {
                i16 = mergeFrom.enum_body_type.get();
            } else {
                i16 = 0;
            }
            if (mergeFrom.str_session_id.has()) {
                j3 = Long.valueOf(mergeFrom.str_session_id.get()).longValue();
            } else {
                j3 = 0;
            }
            QLog.d("PeakAudioTransHandler", 2, "onReceive result:" + i3 + " sessionid:" + j3 + " bodyType:" + i16);
            AudioTransClientTransInfo$IntRspBody mergeFrom2 = new AudioTransClientTransInfo$IntRspBody().mergeFrom(bArr2);
            if (i3 == 0) {
                if (i16 == 2) {
                    AudioTransClientTransInfo$IntC2SJoinSessionRsp audioTransClientTransInfo$IntC2SJoinSessionRsp = mergeFrom2.msg_join_session_rsp.get();
                    int i17 = audioTransClientTransInfo$IntC2SJoinSessionRsp.uint32_combine_num.get();
                    int i18 = audioTransClientTransInfo$IntC2SJoinSessionRsp.uint32_heartbeat_duration.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("PeakAudioTransHandler", 2, "combineNum = " + i17 + "\nheartBeatDuration = " + i18);
                    }
                    notifyUI(1, true, new Object[]{Long.valueOf(j3), Integer.valueOf(i17), Integer.valueOf(i18)});
                    return;
                }
                if (i16 == 4) {
                    this.f281751h.b(0);
                    notifyUI(2, true, new Object[]{Long.valueOf(j3), Integer.valueOf(i3)});
                    J2(j3, false);
                    return;
                }
                if (i16 != 8) {
                    if (i16 == 6) {
                        AudioTransClientTransInfo$IntC2SChangeSessionRsp audioTransClientTransInfo$IntC2SChangeSessionRsp = mergeFrom2.msg_change_session_rsp.get();
                        int i19 = audioTransClientTransInfo$IntC2SChangeSessionRsp.uint32_combine_num.get();
                        QLog.d("PeakAudioTransHandler", 2, "enum_channel_type = " + audioTransClientTransInfo$IntC2SChangeSessionRsp.enum_channel_type.get() + "  uint32_combine_num = " + i19);
                        notifyUI(4, true, new Object[]{Long.valueOf(j3), Integer.valueOf(i19)});
                        return;
                    }
                    if (i16 == 10 && QLog.isColorLevel()) {
                        QLog.d("PeakAudioTransHandler", 2, "onReceiveOther INT_C2S_HEART_BEAT_RSP heartbeat !");
                        return;
                    }
                    return;
                }
                return;
            }
            AudioTransClientTransInfo$IntC2SFailedRsp audioTransClientTransInfo$IntC2SFailedRsp = mergeFrom2.msg_failed_rsp.get();
            QLog.d("PeakAudioTransHandler", 2, "create session rsp fail msg: " + mergeFrom.uint32_error_no.get() + " uint32_errcode = " + audioTransClientTransInfo$IntC2SFailedRsp.uint32_errcode.get() + " str_errmsg = " + audioTransClientTransInfo$IntC2SFailedRsp.str_errmsg.get());
            F2(j3);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            QLog.e("PeakAudioTransHandler", 2, "exception = " + e16.getMessage(), e16);
        }
    }

    public void F2(long j3) {
        this.f281751h.n();
        notifyUI(3, true, new Object[]{Long.valueOf(j3), 0});
    }

    public void I2(int i3, byte[] bArr) {
        int i16;
        long j3;
        int i17;
        int i18;
        a.C0737a c16 = com.tencent.av.business.handler.a.c(bArr);
        byte[] bArr2 = c16.f73287a;
        byte[] bArr3 = c16.f73288b;
        try {
            AudioTransClientTransInfo$IntHead mergeFrom = new AudioTransClientTransInfo$IntHead().mergeFrom(bArr2);
            if (mergeFrom.enum_body_type.has()) {
                i16 = mergeFrom.enum_body_type.get();
            } else {
                i16 = 0;
            }
            if (mergeFrom.str_session_id.has()) {
                j3 = Long.valueOf(mergeFrom.str_session_id.get()).longValue();
            } else {
                j3 = 0;
            }
            if (mergeFrom.uint32_error_no.has()) {
                i17 = mergeFrom.uint32_error_no.get();
            } else {
                i17 = 0;
            }
            if (i17 == 0) {
                AudioTransClientTransInfo$IntReqBody mergeFrom2 = new AudioTransClientTransInfo$IntReqBody().mergeFrom(bArr3);
                switch (i16) {
                    case 9:
                        QLog.d("PeakAudioTransHandler", 2, "onReceivePush heartbeat req:");
                        return;
                    case 10:
                        QLog.d("PeakAudioTransHandler", 2, "onReceivePush heartbeat rsp:");
                        return;
                    case 11:
                        AudioTransCommon$TranslateResult mergeFrom3 = new AudioTransCommon$TranslateResult().mergeFrom(mergeFrom2.msg_push_data_req.get().translate_result.get().toByteArray());
                        int i19 = mergeFrom3.int32_end_seq.get();
                        int i26 = mergeFrom3.int32_start_seq.get();
                        String stringUtf8 = mergeFrom3.bytes_tar_text.get().toStringUtf8();
                        int i27 = mergeFrom3.int32_status.get();
                        String stringUtf82 = mergeFrom3.bytes_src_text.get().toStringUtf8();
                        if (QLog.isColorLevel()) {
                            QLog.d("PeakAudioTransHandler", 2, "onReceivePush strChinese:" + stringUtf82 + " strEnglish:" + stringUtf8);
                        }
                        notifyUI(0, true, new Object[]{Long.valueOf(j3), Integer.valueOf(i26), Integer.valueOf(i19), Integer.valueOf(i27), stringUtf82, stringUtf8});
                        return;
                    case 12:
                    default:
                        return;
                    case 13:
                        AudioTransClientTransInfo$IntS2CNotifyExitReq audioTransClientTransInfo$IntS2CNotifyExitReq = mergeFrom2.msg_notify_exit_req.get();
                        if (audioTransClientTransInfo$IntS2CNotifyExitReq.uint32_reason.has()) {
                            i18 = audioTransClientTransInfo$IntS2CNotifyExitReq.uint32_reason.get();
                        } else {
                            i18 = -1;
                        }
                        QLog.d("PeakAudioTransHandler", 2, "onReceivePush exit:" + i18);
                        notifyUI(2, true, new Object[]{Long.valueOf(j3), Integer.valueOf(i17)});
                        return;
                }
            }
            notifyUI(3, true, new Object[]{Long.valueOf(j3), Integer.valueOf(i17)});
            QLog.e("PeakAudioTransHandler", 2, "onReceivePush error:" + i17);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            QLog.e("PeakAudioTransHandler", 2, "onReceivePush exception = " + e16.getMessage(), e16);
        }
    }

    public void J2(long j3, boolean z16) {
        if (!this.f281751h.g()) {
            if (QLog.isColorLevel()) {
                QLog.e("PeakAudioTransHandler", 2, "processNextEvent state legal lSessionID = " + j3);
            }
            F2(j3);
            return;
        }
        int d16 = this.f281751h.d();
        QLog.d("PeakAudioTransHandler", 2, "nextEvent = " + d16);
        if (d16 != 0) {
            if (d16 != 1) {
                if (d16 != 2) {
                    if (d16 != 3) {
                        if (d16 != 4) {
                            if (QLog.isColorLevel()) {
                                QLog.d("PeakAudioTransHandler", 2, "processNextEvent list is null");
                                return;
                            }
                            return;
                        } else if (z16) {
                            QLog.d("PeakAudioTransHandler", 2, "processNextEvent close tcp");
                            this.f281750f.f(j3);
                            return;
                        } else {
                            QLog.d("PeakAudioTransHandler", 2, "processNextEvent already closed");
                            return;
                        }
                    }
                    if (!z16) {
                        K2(null, "TransInfoCreate.CreateSession", null, 0, 0, false);
                        return;
                    }
                    QLog.d("PeakAudioTransHandler", 2, "processNextEvent already open nextEvent = " + d16);
                    F2(j3);
                    return;
                }
                if (!z16) {
                    K2(null, "TransInfoCreate.CreateSession", null, 0, 0, true);
                    return;
                }
                QLog.d("PeakAudioTransHandler", 2, "processNextEvent already open nextEvent = " + d16);
                F2(j3);
                return;
            }
            if (!z16) {
                K2(null, "TransInfoCreate.CreateSession", null, 0, 0, false);
                return;
            }
            QLog.d("PeakAudioTransHandler", 2, "processNextEvent already open nextEvent = " + d16);
            return;
        }
        if (!z16) {
            K2(null, "TransInfoCreate.CreateSession", null, 0, 0, true);
            return;
        }
        QLog.d("PeakAudioTransHandler", 2, "processNextEvent already open nextEvent = " + d16);
    }

    public void K2(String str, String str2, byte[] bArr, int i3, int i16, boolean z16) {
        L2(str, str2, bArr, i3, i16, z16, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void L2(String str, String str2, byte[] bArr, int i3, int i16, boolean z16, int i17) {
        long j3;
        int i18;
        int i19 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("PeakAudioTransHandler", 2, "sendCmdToService cmd = " + str2 + " len:" + i16 + " sessionid:" + str + " withEnglish:" + z16);
        }
        if (str != null) {
            j3 = Long.valueOf(str).longValue();
        } else {
            j3 = -1;
        }
        if (!this.f281751h.g()) {
            if (QLog.isColorLevel()) {
                QLog.e("PeakAudioTransHandler", 2, "sendCmdToService state legal cmd = " + str2);
            }
            F2(j3);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(str2);
        int i26 = 1;
        if ("TransInfoCreate.CreateSession".equals(str2)) {
            AudioTransClientTransInfo$InfoHead audioTransClientTransInfo$InfoHead = new AudioTransClientTransInfo$InfoHead();
            audioTransClientTransInfo$InfoHead.str_session_id.set(String.valueOf(0));
            audioTransClientTransInfo$InfoHead.str_uin.set(this.appRuntime.getAccount());
            audioTransClientTransInfo$InfoHead.uint32_seq.set(this.f281752i.nextInt());
            audioTransClientTransInfo$InfoHead.enum_body_type.set(1);
            AudioTransClientTransInfo$InfoReqBody audioTransClientTransInfo$InfoReqBody = new AudioTransClientTransInfo$InfoReqBody();
            AudioTransClientTransInfo$InfoC2SCreateSessionReq audioTransClientTransInfo$InfoC2SCreateSessionReq = new AudioTransClientTransInfo$InfoC2SCreateSessionReq();
            audioTransClientTransInfo$InfoC2SCreateSessionReq.enum_business_type.set(3);
            audioTransClientTransInfo$InfoC2SCreateSessionReq.enum_term.set(4);
            audioTransClientTransInfo$InfoC2SCreateSessionReq.enum_business_direction.set(1);
            audioTransClientTransInfo$InfoC2SCreateSessionReq.uint32_client_ver.set(1);
            audioTransClientTransInfo$InfoC2SCreateSessionReq.enum_net_type.set(i17);
            audioTransClientTransInfo$InfoC2SCreateSessionReq.bool_translate.set(z16);
            audioTransClientTransInfo$InfoC2SCreateSessionReq.rpt_member_list.set(Arrays.asList(audioTransClientTransInfo$InfoHead.str_uin.get()));
            audioTransClientTransInfo$InfoReqBody.msg_create_session_req.set(audioTransClientTransInfo$InfoC2SCreateSessionReq);
            byte[] d16 = com.tencent.av.business.handler.a.d(audioTransClientTransInfo$InfoHead.toByteArray(), audioTransClientTransInfo$InfoReqBody.toByteArray());
            this.f281748d = System.currentTimeMillis();
            createToServiceMsg.putWupBuffer(d16);
            if (!this.f281751h.h()) {
                if (QLog.isColorLevel()) {
                    QLog.e("PeakAudioTransHandler", 2, "sendCmdToService create last session not close state = " + this.f281751h.e());
                }
                this.f281751h.a(!z16 ? 1 : 0);
                return;
            }
            if (this.f281750f.h()) {
                sendPbReq(createToServiceMsg);
                this.f281751h.b(1);
                return;
            } else {
                QLog.e("PeakAudioTransHandler", 2, "sendCmdToService create network is not available");
                return;
            }
        }
        if (!"TransInfo.JoinSession".equals(str2)) {
            if ("TransInfo.ExitSession".equals(str2)) {
                i18 = 3;
            } else if ("TransInfo.ChangeSession".equals(str2)) {
                i18 = 5;
            } else if ("TransInfo.RawData".equals(str2)) {
                i26 = 7;
            } else if ("TransInfo.HeartBeat".equals(str2)) {
                i26 = 9;
            } else {
                QLog.e("PeakAudioTransHandler", 2, "unknown cmd");
                i18 = -1;
            }
            createToServiceMsg.putWupBuffer(com.tencent.av.business.handler.a.d(E2(i18, str).toByteArray(), D2(i18, bArr, i3, i16, z16, i17).toByteArray()));
            if (this.f281751h.i()) {
                if (QLog.isColorLevel()) {
                    QLog.e("PeakAudioTransHandler", 2, "sendCmdToService other  session not open ! state =" + this.f281751h.e());
                }
                if (i18 == 5) {
                    if (!z16) {
                        i19 = 3;
                    }
                } else {
                    i19 = -1;
                }
                if (i19 != -1) {
                    this.f281751h.a(i19);
                    return;
                }
                return;
            }
            if (this.f281750f.h()) {
                sendPbReq(createToServiceMsg);
                if (i18 == 3) {
                    this.f281751h.b(3);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("PeakAudioTransHandler", 2, "sendCmdToService others network is not available");
            }
            if (i18 == 3) {
                this.f281751h.n();
                return;
            }
            return;
        }
        i18 = i26;
        createToServiceMsg.putWupBuffer(com.tencent.av.business.handler.a.d(E2(i18, str).toByteArray(), D2(i18, bArr, i3, i16, z16, i17).toByteArray()));
        if (this.f281751h.i()) {
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return c.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.isSuccess()) {
            a.C0737a c16 = com.tencent.av.business.handler.a.c(fromServiceMsg.getWupBuffer());
            byte[] bArr = c16.f73287a;
            byte[] bArr2 = c16.f73288b;
            if ("TransInfoCreate.CreateSession".equals(fromServiceMsg.getServiceCmd())) {
                G2(bArr, bArr2);
                return;
            } else {
                H2(bArr, bArr2);
                return;
            }
        }
        QLog.e("PeakAudioTransHandler", 2, "onReceive fail, error msg is " + fromServiceMsg.getBusinessFailMsg());
    }
}
