package com.tencent.mobileqq.together;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqAioMedia.heartbeat.heartbeat.CmdAIOMediaHeartbeatReq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.aio.media.VideoWriteReply;
import tencent.aio.media.VideoWriteRequest;
import tencent.aio.media.aio_media$DynamicInfo;
import tencent.aio.media.aio_media$ReqCreateRoom;
import tencent.aio.media.aio_media$ReqGetDynamicInfo;
import tencent.aio.media.aio_media$ReqLatestPlayingState;
import tencent.aio.media.aio_media$RspGetDynamicInfo;
import tencent.aio.media.aio_media$RspLatestPlayingState;
import tr2.b;
import tr2.c;
import tr2.d;
import tr2.e;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TogetherOperationHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f293313d;

    public TogetherOperationHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f293313d = qQAppInterface;
    }

    private boolean E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState serviceType is listener");
            }
            return true;
        }
        aio_media$RspLatestPlayingState J2 = J2(toServiceMsg, fromServiceMsg, obj);
        if (J2 != null && J2.enum_media_type.has()) {
            int i3 = J2.enum_media_type.get();
            e w3 = ((b) this.f293313d.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).w(i3);
            if (w3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState receive type= " + i3);
                }
                return true;
            }
            w3.e(toServiceMsg, J2);
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState is null or type is empty");
        }
        return true;
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        boolean isSuccess = fromServiceMsg.isSuccess();
        if (QLog.isColorLevel()) {
            QLog.d("TogetherOperationHandler", 2, "handleOperateTogetherWatchRsp isSuccess:", Boolean.valueOf(isSuccess), " errorCode:", Integer.valueOf(fromServiceMsg.getResultCode()));
        }
        Bundle bundle = toServiceMsg.extraData;
        if (isSuccess) {
            try {
                VideoWriteReply videoWriteReply = new VideoWriteReply();
                videoWriteReply.mergeFrom((byte[]) obj);
                String str2 = "";
                if (!videoWriteReply.errmsg.has()) {
                    str = "";
                } else {
                    str = videoWriteReply.errmsg.get();
                }
                if (videoWriteReply.jumpUrl.has()) {
                    str2 = videoWriteReply.jumpUrl.get();
                }
                int i3 = videoWriteReply.result.get();
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherOperationHandler", 2, "handleOperateTogetherWatchRsp errorTip:", str, " errorCode:", Integer.valueOf(i3), " jumpURL=", str2);
                }
                bundle.putString("error_msg", str);
                bundle.putInt("error_code", i3);
                bundle.putString("jump_url", str2);
                isSuccess = i3 == 0;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherOperationHandler", 2, "InvalidProtocolBufferMicroException");
                }
            }
        } else {
            bundle.putInt("error_code", fromServiceMsg.getResultCode());
        }
        notifyUI(4, isSuccess, bundle);
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("QQAIOMediaSvc.heartbeat".equals(fromServiceMsg.getServiceCmd())) {
            toServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1);
        }
    }

    private aio_media$RspLatestPlayingState J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.isSuccess()) {
            aio_media$RspLatestPlayingState aio_media_rsplatestplayingstate = new aio_media$RspLatestPlayingState();
            try {
                aio_media_rsplatestplayingstate.mergeFrom((byte[]) obj);
                return aio_media_rsplatestplayingstate;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherOperationHandler", 2, "parseResBdy, success=" + fromServiceMsg.isSuccess() + " code=" + fromServiceMsg.getResultCode());
            return null;
        }
        return null;
    }

    public void D2() {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherOperationHandler", 2, "getFakePanelData");
            }
            MessageMicro<aio_media$ReqGetDynamicInfo> messageMicro = new MessageMicro<aio_media$ReqGetDynamicInfo>() { // from class: tencent.aio.media.aio_media$ReqGetDynamicInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], aio_media$ReqGetDynamicInfo.class);
            };
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f293313d.getCurrentAccountUin(), "QQAIOMediaSvc.get_dynamic_info");
            toServiceMsg.putWupBuffer(messageMicro.toByteArray());
            toServiceMsg.setTimeout(30000L);
            sendPbReq(toServiceMsg);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherOperationHandler", 2, "getFakePanelData, exception", e16);
            }
        }
    }

    public void F2(int i3, int i16, String str, int i17) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherOperationHandler", 2, "getPlayingState, service=" + i3 + ",sessionType= " + i16 + ", uin=" + str + ", by=" + i17);
        }
        try {
            aio_media$ReqLatestPlayingState aio_media_reqlatestplayingstate = new aio_media$ReqLatestPlayingState();
            aio_media_reqlatestplayingstate.enum_aio_type.set(i16);
            aio_media_reqlatestplayingstate.uint64_id.set(Long.valueOf(str).longValue());
            aio_media_reqlatestplayingstate.uint32_version.set(2);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f293313d.getCurrentAccountUin(), "QQAIOMediaSvc.get_latest_playing_state");
            toServiceMsg.extraData.putInt("KEY_SERVICE_TYPE", i3);
            toServiceMsg.extraData.putInt("KEY_SESSION_TYPE", i16);
            toServiceMsg.extraData.putString("KEY_SESSION_UIN", str);
            toServiceMsg.extraData.putInt("KEY_REFRESH_SESSION_BY", i17);
            toServiceMsg.putWupBuffer(aio_media_reqlatestplayingstate.toByteArray());
            toServiceMsg.setTimeout(30000L);
            sendPbReq(toServiceMsg);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherOperationHandler", 2, "getPlayingState, exception", e16);
            }
        }
    }

    public void I2(int i3, String str, String str2, String str3, int i16, String str4, int i17, int i18) {
        long j3;
        long j16;
        if (QLog.isColorLevel()) {
            QLog.d("TogetherOperationHandler", 2, "operateTogetherWatch");
        }
        try {
            j3 = Long.parseLong(str4);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TogetherOperationHandler", 2, "operateTogetherWatch, exception", e16);
            }
            j3 = -1;
        }
        if (j3 == -1) {
            return;
        }
        VideoWriteRequest videoWriteRequest = new VideoWriteRequest();
        videoWriteRequest.categoryId.set(i3);
        if (i17 == 1) {
            j16 = j3;
        } else {
            j16 = -1;
        }
        if (i17 != 2) {
            j3 = -1;
        }
        if (j16 != -1) {
            videoWriteRequest.gid.set(j16);
        }
        if (j3 != -1) {
            videoWriteRequest.targetUin.set(j3);
        }
        if (!TextUtils.isEmpty(str)) {
            videoWriteRequest.matchId.set(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            videoWriteRequest.roomTitle.set(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            videoWriteRequest.roomCover.set(str3);
        }
        videoWriteRequest.operType.set(i16);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f293313d.getCurrentAccountUin(), "QQAIOMediaSvc.VideoWrite");
        toServiceMsg.putWupBuffer(videoWriteRequest.toByteArray());
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.extraData.putInt("KEY_SESSION_TYPE", i17);
        toServiceMsg.extraData.putString("KEY_SESSION_UIN", str4);
        toServiceMsg.extraData.putInt("KEY_FROM", i18);
        sendPbReq(toServiceMsg);
    }

    public void K2(int i3, int i16, String str, String str2, int i17) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherOperationHandler", 2, "reqCreateRoom, service=" + i3 + ",sessionType= " + i16 + ", uin=" + str + ", songId=" + str2 + ", from=" + i17);
        }
        try {
            aio_media$ReqCreateRoom aio_media_reqcreateroom = new aio_media$ReqCreateRoom();
            aio_media_reqcreateroom.enum_aio_type.set(i16);
            aio_media_reqcreateroom.uint64_id.set(Long.valueOf(str).longValue());
            if (!TextUtils.isEmpty(str2)) {
                aio_media_reqcreateroom.str_song_id.set(str2);
            }
            aio_media_reqcreateroom.enum_media_type.set(i3);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f293313d.getCurrentAccountUin(), "QQAIOMediaSvc.create_room");
            toServiceMsg.extraData.putInt("KEY_SERVICE_TYPE", i3);
            toServiceMsg.extraData.putInt("KEY_SESSION_TYPE", i16);
            toServiceMsg.extraData.putString("KEY_SESSION_UIN", str);
            toServiceMsg.extraData.putInt("KEY_FROM", i17);
            if (!TextUtils.isEmpty(str2)) {
                toServiceMsg.extraData.putString("KEY_SONG_ID", str2);
            }
            toServiceMsg.putWupBuffer(aio_media_reqcreateroom.toByteArray());
            toServiceMsg.setTimeout(30000L);
            sendPbReq(toServiceMsg);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherOperationHandler", 2, "getPlayingState, exception", e16);
            }
        }
    }

    public long L2(int i3, int i16, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        CmdAIOMediaHeartbeatReq cmdAIOMediaHeartbeatReq = new CmdAIOMediaHeartbeatReq();
        cmdAIOMediaHeartbeatReq.enum_aio_type.set(i16);
        cmdAIOMediaHeartbeatReq.enum_media_type.set(i3);
        cmdAIOMediaHeartbeatReq.uint64_id.set(Long.valueOf(str).longValue());
        ToServiceMsg createToServiceMsg = createToServiceMsg("QQAIOMediaSvc.heartbeat");
        createToServiceMsg.putWupBuffer(cmdAIOMediaHeartbeatReq.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        createToServiceMsg.extraData.putInt("KEY_SERVICE_TYPE", i3);
        createToServiceMsg.extraData.putInt("KEY_SESSION_TYPE", i16);
        createToServiceMsg.extraData.putString("KEY_SESSION_UIN", str);
        createToServiceMsg.extraData.putLong("KEY_TS", elapsedRealtime);
        sendPbReq(createToServiceMsg);
        return elapsedRealtime;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("QQAIOMediaSvc.get_latest_playing_state");
            this.allowCmdSet.add("QQAIOMediaSvc.get_dynamic_info");
            this.allowCmdSet.add("QQAIOMediaSvc.create_room");
            this.allowCmdSet.add("QQAIOMediaSvc.heartbeat");
            this.allowCmdSet.add("QQAIOMediaSvc.VideoWrite");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && !msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            if ("QQAIOMediaSvc.get_latest_playing_state".equals(fromServiceMsg.getServiceCmd())) {
                if (E2(toServiceMsg, fromServiceMsg, obj)) {
                    return;
                }
            } else if ("QQAIOMediaSvc.get_dynamic_info".equals(fromServiceMsg.getServiceCmd())) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherOperationHandler", 2, "Rsp CMD_GET_FAKE_DATA, isSuccess=", Boolean.valueOf(fromServiceMsg.isSuccess()));
                }
                if (fromServiceMsg.isSuccess()) {
                    aio_media$RspGetDynamicInfo aio_media_rspgetdynamicinfo = new aio_media$RspGetDynamicInfo();
                    try {
                        aio_media_rspgetdynamicinfo.mergeFrom((byte[]) obj);
                        b.q(this.f293313d).i();
                        if (aio_media_rspgetdynamicinfo.get().msg_music_info.has()) {
                            c cVar = new c();
                            cVar.f437177a = 1001;
                            cVar.f437184h = true;
                            cVar.f437185i = aio_media_rspgetdynamicinfo.get().msg_music_info.get().uint32_user_num.get();
                            List<Long> list = aio_media_rspgetdynamicinfo.get().msg_music_info.get().rpt_uint64_uins.get();
                            cVar.f437186j = new ArrayList<>(list.size());
                            for (Long l3 : list) {
                                cVar.f437186j.add(l3 + "");
                            }
                            b.q(this.f293313d).H(cVar);
                        }
                        if (aio_media_rspgetdynamicinfo.get().msg_video_info.has()) {
                            c cVar2 = new c();
                            cVar2.f437177a = 1002;
                            cVar2.f437184h = true;
                            cVar2.f437185i = aio_media_rspgetdynamicinfo.get().msg_video_info.get().uint32_user_num.get();
                            List<Long> list2 = aio_media_rspgetdynamicinfo.get().msg_video_info.get().rpt_uint64_uins.get();
                            cVar2.f437186j = new ArrayList<>(list2.size());
                            for (Long l16 : list2) {
                                cVar2.f437186j.add(l16 + "");
                            }
                            b.q(this.f293313d).H(cVar2);
                        }
                        if (aio_media_rspgetdynamicinfo.get().msg_ksing_info.has()) {
                            c cVar3 = new c();
                            cVar3.f437177a = 1003;
                            cVar3.f437184h = true;
                            cVar3.f437185i = aio_media_rspgetdynamicinfo.get().msg_ksing_info.get().uint32_user_num.get();
                            List<Long> list3 = aio_media_rspgetdynamicinfo.get().msg_ksing_info.get().rpt_uint64_uins.get();
                            cVar3.f437186j = new ArrayList<>(list3.size());
                            for (Long l17 : list3) {
                                cVar3.f437186j.add(l17 + "");
                            }
                            b.q(this.f293313d).H(cVar3);
                        }
                        if (aio_media_rspgetdynamicinfo.get().msg_play_info.has()) {
                            c cVar4 = new c();
                            cVar4.f437177a = 1004;
                            cVar4.f437184h = true;
                            cVar4.f437185i = aio_media_rspgetdynamicinfo.get().msg_play_info.get().uint32_user_num.get();
                            List<Long> list4 = aio_media_rspgetdynamicinfo.get().msg_play_info.get().rpt_uint64_uins.get();
                            cVar4.f437186j = new ArrayList<>(list4.size());
                            for (Long l18 : list4) {
                                cVar4.f437186j.add(l18 + "");
                            }
                            b.q(this.f293313d).H(cVar4);
                        }
                        if (aio_media_rspgetdynamicinfo.get().rpt_dynamic_info.has()) {
                            for (aio_media$DynamicInfo aio_media_dynamicinfo : aio_media_rspgetdynamicinfo.get().rpt_dynamic_info.get()) {
                                if (aio_media_dynamicinfo != null && aio_media_dynamicinfo.int32_media_type.get() == 16) {
                                    c cVar5 = new c();
                                    cVar5.f437177a = 1005;
                                    cVar5.f437184h = true;
                                    cVar5.f437185i = aio_media_dynamicinfo.uint32_user_num.get();
                                    List<Long> list5 = aio_media_dynamicinfo.rpt_uint64_uins.get();
                                    cVar5.f437186j = new ArrayList<>(list5.size());
                                    for (Long l19 : list5) {
                                        cVar5.f437186j.add(l19 + "");
                                    }
                                    b.q(this.f293313d).H(cVar5);
                                }
                            }
                        }
                        notifyUI(3, true, null);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.d("TogetherOperationHandler", 2, "InvalidProtocolBufferMicroException");
                        }
                    }
                }
            } else if ("QQAIOMediaSvc.VideoWrite".equals(fromServiceMsg.getServiceCmd())) {
                G2(toServiceMsg, fromServiceMsg, obj);
            }
            H2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
