package com.tencent.mobileqq.listentogether;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.together.TogetherOperationHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqAioMedia.heartbeat.heartbeat.CmdAIOMediaHeartbeatRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.aio.media.aio_media$ReqMediaOperation;
import tencent.aio.media.aio_media$ReqReportDownloadFail;
import tencent.aio.media.aio_media$ReqRoomOperation;
import tencent.aio.media.aio_media$ReqShareTrans;
import tencent.aio.media.aio_media$ReqShareTransCheck;
import tencent.aio.media.aio_media$ReqSongExtendedInfo;
import tencent.aio.media.aio_media$ReqSongPlayShowInfo;
import tencent.aio.media.aio_media$ResultInfo;
import tencent.aio.media.aio_media$RspCreateRoom;
import tencent.aio.media.aio_media$RspLatestPlayingState;
import tencent.aio.media.aio_media$RspMediaOperation;
import tencent.aio.media.aio_media$RspReportDownloadFail;
import tencent.aio.media.aio_media$RspRoomOperation;
import tencent.aio.media.aio_media$RspShareTrans;
import tencent.aio.media.aio_media$RspShareTransCheck;
import tencent.aio.media.aio_media$RspSongExtendedInfo;
import tencent.aio.media.aio_media$RspSongPlayShowInfo;
import tencent.aio.media.aio_media$Song;
import tencent.aio.media.aio_media$SongExtendedReqParam;
import tencent.aio.media.aio_media$TypeMusic;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ListenTogetherHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private ListenTogetherManager f240850d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f240851e;

    public ListenTogetherHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f240851e = qQAppInterface;
        this.f240850d = (ListenTogetherManager) qQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long D2(long j3, long j16) {
        final int i3;
        long j17;
        long j18;
        long serverTime = NetConnInfoCenter.getServerTime() * 1000;
        final long currentTimeMillis = System.currentTimeMillis() - j3;
        final long j19 = serverTime - j16;
        if (j19 > currentTimeMillis) {
            j18 = currentTimeMillis / 2;
        } else if (j19 < -500) {
            j18 = currentTimeMillis / 2;
        } else {
            if (j19 < 0) {
                i3 = 3;
                j17 = 0;
            } else {
                i3 = 1;
                j17 = j19;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ListenTogether.handler", 2, String.format("calcuSeekInterval, t1: %s, t2: %s, requestInterval: %s, serverInterval: %s, reportType: %s, interval: %s", Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(currentTimeMillis), Long.valueOf(j19), Integer.valueOf(i3), Long.valueOf(j17)));
            }
            final long j26 = j17;
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.ListenTogetherHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server_request", String.valueOf(j19 - currentTimeMillis));
                    hashMap.put("serverInterval", String.valueOf(j19));
                    hashMap.put("requestInterval", String.valueOf(currentTimeMillis));
                    hashMap.put(AdMetricTag.Report.TYPE, String.valueOf(i3));
                    hashMap.put(WidgetCacheConstellationData.INTERVAL, String.valueOf(j26));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "listen_together_seek_adjust", true, 0L, 0L, hashMap, "", false);
                }
            });
            return j17;
        }
        j17 = j18;
        i3 = 2;
        if (QLog.isColorLevel()) {
        }
        final long j262 = j17;
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.ListenTogetherHandler.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("server_request", String.valueOf(j19 - currentTimeMillis));
                hashMap.put("serverInterval", String.valueOf(j19));
                hashMap.put("requestInterval", String.valueOf(currentTimeMillis));
                hashMap.put(AdMetricTag.Report.TYPE, String.valueOf(i3));
                hashMap.put(WidgetCacheConstellationData.INTERVAL, String.valueOf(j262));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "listen_together_seek_adjust", true, 0L, 0L, hashMap, "", false);
            }
        });
        return j17;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        aio_media$RspSongPlayShowInfo aio_media_rspsongplayshowinfo;
        aio_media$ResultInfo aio_media_resultinfo;
        int i17;
        String str2 = "";
        if (toServiceMsg == null) {
            str = "";
        } else {
            str = toServiceMsg.extraData.getString("KEY_SESSION_UIN");
        }
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            ArrayList arrayList = null;
            if (fromServiceMsg.isSuccess()) {
                try {
                    aio_media_rspsongplayshowinfo = new aio_media$RspSongPlayShowInfo();
                    aio_media_rspsongplayshowinfo.mergeFrom((byte[]) obj);
                    aio_media_resultinfo = aio_media_rspsongplayshowinfo.msg_result.get();
                    i17 = aio_media_resultinfo != null ? aio_media_resultinfo.uint32_result.get() : -1;
                } catch (Exception e16) {
                    e = e16;
                    z16 = false;
                    i3 = 0;
                }
                if (i17 == 0) {
                    try {
                        i16 = aio_media_rspsongplayshowinfo.uint32_join_num.get();
                        try {
                            List<Long> list = aio_media_rspsongplayshowinfo.rpt_uint64_join_uins.get();
                            if (list != null && list.size() > 0) {
                                ArrayList arrayList2 = new ArrayList();
                                try {
                                    Iterator<Long> it = list.iterator();
                                    while (it.hasNext()) {
                                        arrayList2.add(String.valueOf(it.next()));
                                    }
                                    arrayList = arrayList2;
                                } catch (Exception e17) {
                                    e = e17;
                                    arrayList = arrayList2;
                                    i3 = i16;
                                    z16 = true;
                                    QLog.d("ListenTogether.handler", 1, "handleGetGroupJoinedUsers exception", e);
                                    z17 = z16;
                                    i16 = i3;
                                    if (z17) {
                                    }
                                    if (QLog.isColorLevel()) {
                                    }
                                }
                            }
                            z17 = true;
                        } catch (Exception e18) {
                            e = e18;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        z16 = true;
                        i3 = 0;
                    }
                    if (z17) {
                        notifyUI(17, true, new Object[]{str, Integer.valueOf(i16), arrayList});
                    } else {
                        notifyUI(17, false, new Object[]{str});
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ListenTogether.handler", 2, String.format("handleGetGroupJoinedUsers, isSuccess: %s, joinedNum: %s, joinedUinList: %s", Boolean.valueOf(z17), Integer.valueOf(i16), arrayList));
                        return;
                    }
                    return;
                }
                if (aio_media_resultinfo != null && aio_media_resultinfo.bytes_errmsg.get() != null) {
                    str2 = aio_media_resultinfo.bytes_errmsg.get().toStringUtf8();
                }
                QLog.d("ListenTogether.handler", 1, String.format("handleGetGroupJoinedUsers, result = %s, errTips = %s", Integer.valueOf(i17), str2));
            }
            z17 = false;
            i16 = 0;
            if (z17) {
            }
            if (QLog.isColorLevel()) {
            }
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            notifyUI(17, false, new Object[]{str});
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        ListenTogetherManager listenTogetherManager;
        int i3 = toServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
        String string = toServiceMsg.extraData.getString("KEY_SESSION_UIN");
        int i16 = toServiceMsg.extraData.getInt("KEY_OPERATOR");
        int i17 = toServiceMsg.extraData.getInt("KEY_OPVALUE");
        if (fromServiceMsg != null && obj != null) {
            try {
            } catch (Exception e16) {
                QLog.d("ListenTogether.handler", 1, String.format("handleMediaOperation exception, sessionType: %s, uin: %s, operatorType: %s", -1, Integer.valueOf(i3), string, Integer.valueOf(i16)), e16);
            }
            if (fromServiceMsg.isSuccess()) {
                aio_media$RspMediaOperation aio_media_rspmediaoperation = new aio_media$RspMediaOperation();
                aio_media_rspmediaoperation.mergeFrom((byte[]) obj);
                aio_media$ResultInfo aio_media_resultinfo = aio_media_rspmediaoperation.msg_result.get();
                r9 = aio_media_resultinfo != null ? aio_media_resultinfo.uint32_result.get() : -1;
                if (r9 == 0) {
                    z16 = true;
                    listenTogetherManager = this.f240850d;
                    if (listenTogetherManager != null) {
                        if (i16 == 1) {
                            listenTogetherManager.r1(z16, i3, string);
                        } else if (i16 == 2) {
                            listenTogetherManager.p1(z16, i3, string);
                        } else if (i16 == 3) {
                            listenTogetherManager.R0(z16, i3, string);
                        } else if (i16 == 4) {
                            listenTogetherManager.O0(z16, i3, string, i17);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        return;
                    }
                    QLog.d("ListenTogether.handler", 2, String.format("handleMediaOperation, result: %s, sessionType: %s, uin: %s, operatorType: %s, opValue: %d", Integer.valueOf(r9), Integer.valueOf(i3), string, Integer.valueOf(i16), Integer.valueOf(i17)));
                    return;
                }
            } else {
                QLog.d("ListenTogether.handler", 1, String.format("handleMediaOperation, rsp fail, sessionType: %s, uin: %s, operatorType: %s", Integer.valueOf(i3), string, Integer.valueOf(i16)));
            }
            z16 = false;
            listenTogetherManager = this.f240850d;
            if (listenTogetherManager != null) {
            }
            if (QLog.isColorLevel()) {
            }
        } else {
            ListenTogetherManager listenTogetherManager2 = this.f240850d;
            if (listenTogetherManager2 != null) {
                if (i16 == 1) {
                    listenTogetherManager2.r1(false, i3, string);
                } else if (i16 == 2) {
                    listenTogetherManager2.p1(false, i3, string);
                } else if (i16 == 3) {
                    listenTogetherManager2.R0(false, i3, string);
                } else if (i16 == 4) {
                    listenTogetherManager2.O0(false, i3, string, i17);
                }
            }
            QLog.d("ListenTogether.handler", 1, "handleMediaOperation, req == null || resp == null || data == null");
        }
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str = "";
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            aio_media$RspReportDownloadFail aio_media_rspreportdownloadfail = new aio_media$RspReportDownloadFail();
            try {
                aio_media_rspreportdownloadfail.mergeFrom((byte[]) obj);
                aio_media$ResultInfo aio_media_resultinfo = aio_media_rspreportdownloadfail.msg_result.get();
                int i3 = aio_media_resultinfo != null ? aio_media_resultinfo.uint32_result.get() : -1;
                if (aio_media_resultinfo != null) {
                    str = aio_media_resultinfo.bytes_errmsg.get().toStringUtf8();
                }
                this.f240850d.d0(i3 == 0, new Object[]{Integer.valueOf(i3), str});
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                return;
            }
        }
        this.f240850d.d0(false, new Object[]{-1, ""});
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        boolean z17;
        if (toServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) != 1) {
            return;
        }
        int i16 = toServiceMsg.extraData.getInt("KEY_SESSION_TYPE", -1);
        String str = "";
        String string = toServiceMsg.extraData.getString("KEY_SESSION_UIN", "");
        int i17 = toServiceMsg.extraData.getInt("KEY_FROM", -1);
        String string2 = toServiceMsg.extraData.getString("KEY_SONG_ID", "");
        if (fromServiceMsg.isSuccess()) {
            aio_media$RspCreateRoom aio_media_rspcreateroom = new aio_media$RspCreateRoom();
            try {
                aio_media_rspcreateroom.mergeFrom((byte[]) obj);
                aio_media$ResultInfo aio_media_resultinfo = aio_media_rspcreateroom.msg_result.get();
                i3 = aio_media_resultinfo.uint32_result.get();
                z17 = i3 == 0;
                if (!z17) {
                    try {
                        str = aio_media_resultinfo.bytes_errmsg.get().toStringUtf8();
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e = e16;
                        QLog.d("ListenTogether.handler", 1, "handleReqCreateRoom ex", e);
                        z16 = z17;
                        String str2 = str;
                        if (QLog.isColorLevel()) {
                        }
                        ListenTogetherManager.J(this.f240851e).c0(z16, i16, string, str2, i17, string2);
                    }
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                i3 = 0;
                z17 = false;
            }
            z16 = z17;
        } else {
            i3 = 0;
            z16 = false;
        }
        String str22 = str;
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.handler", 2, String.format("handleReqCreateRoom sessionType=%d uin=%s from=%d songId=%s res=%d wording=%s", Integer.valueOf(i16), MobileQQ.getShortUinStr(string), Integer.valueOf(i17), string2, Integer.valueOf(i3), str22));
        }
        ListenTogetherManager.J(this.f240851e).c0(z16, i16, string, str22, i17, string2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int i16 = -1;
        if (toServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) != 1) {
            return;
        }
        int i17 = toServiceMsg.extraData.getInt("KEY_SESSION_TYPE", -1);
        String str = "";
        String string = toServiceMsg.extraData.getString("KEY_SESSION_UIN", "");
        long j3 = toServiceMsg.extraData.getLong("KEY_TS", 0L);
        if (fromServiceMsg.isSuccess()) {
            CmdAIOMediaHeartbeatRsp cmdAIOMediaHeartbeatRsp = new CmdAIOMediaHeartbeatRsp();
            try {
                cmdAIOMediaHeartbeatRsp.mergeFrom((byte[]) obj);
                aio_media$ResultInfo aio_media_resultinfo = cmdAIOMediaHeartbeatRsp.msg_result.get();
                i3 = cmdAIOMediaHeartbeatRsp.interval.get();
                if (aio_media_resultinfo != null) {
                    try {
                        i16 = aio_media_resultinfo.uint32_result.get();
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e = e16;
                        QLog.d("ListenTogether.handler", 1, "handleReqHeartBeat ex", e);
                        if (QLog.isColorLevel()) {
                        }
                        if (i16 != 0) {
                        }
                    }
                }
                if (aio_media_resultinfo != null) {
                    str = aio_media_resultinfo.bytes_errmsg.get().toStringUtf8();
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                i3 = 0;
            }
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.handler", 2, String.format("handleReqHeartBeat interval=%d errCode=%d errWording=%s", Integer.valueOf(i3), Integer.valueOf(i16), str));
        }
        if (i16 != 0) {
            notifyUI(24, true, new Object[]{Integer.valueOf(i17), string, Long.valueOf(j3), Integer.valueOf(i3)});
        } else {
            notifyUI(24, false, new Object[]{Integer.valueOf(i17), string, Long.valueOf(j3), Integer.valueOf(i16), str});
        }
    }

    public static List<MusicInfo> T2(List<aio_media$Song> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                MusicInfo b16 = MusicInfo.b(list.get(i3));
                if (b16 != null) {
                    arrayList.add(b16);
                }
            }
        }
        return arrayList;
    }

    private void b3(int i3, String str, int i16, int i17) {
        ListenTogetherManager listenTogetherManager;
        try {
            aio_media$ReqMediaOperation aio_media_reqmediaoperation = new aio_media$ReqMediaOperation();
            aio_media_reqmediaoperation.enum_aio_type.set(i3);
            aio_media_reqmediaoperation.uint64_id.set(Long.valueOf(str).longValue());
            aio_media_reqmediaoperation.enum_operation.set(i16);
            if (i16 == 4) {
                aio_media_reqmediaoperation.enum_play_mode.set(i17);
            } else if (i16 == 3) {
                aio_media_reqmediaoperation.enum_cut_type.set(i17);
            }
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f240851e.getCurrentAccountUin(), "QQAIOMediaSvc.media_operation");
            toServiceMsg.extraData.putInt("KEY_SESSION_TYPE", i3);
            toServiceMsg.extraData.putString("KEY_SESSION_UIN", str);
            toServiceMsg.extraData.putInt("KEY_OPERATOR", i16);
            toServiceMsg.extraData.putInt("KEY_OPVALUE", i17);
            toServiceMsg.putWupBuffer(aio_media_reqmediaoperation.toByteArray());
            toServiceMsg.setTimeout(30000L);
            sendPbReq(toServiceMsg);
        } catch (NumberFormatException e16) {
            QLog.d("ListenTogether.handler", 1, "getSongExtendedInfo, exception", e16);
            if (i16 == 1) {
                ListenTogetherManager listenTogetherManager2 = this.f240850d;
                if (listenTogetherManager2 != null) {
                    listenTogetherManager2.r1(false, i3, str);
                }
            } else if (i16 == 2 && (listenTogetherManager = this.f240850d) != null) {
                listenTogetherManager.p1(false, i3, str);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.handler", 2, String.format("reqMediaOperator, sessionType: %s, uin: %s, operatorType: %s opValue: %d", Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17)));
        }
    }

    private void c3(int i3, String str, int i16, int i17) {
        try {
            aio_media$ReqRoomOperation aio_media_reqroomoperation = new aio_media$ReqRoomOperation();
            aio_media_reqroomoperation.enum_aio_type.set(i3);
            aio_media_reqroomoperation.uint64_id.set(Long.valueOf(str).longValue());
            aio_media_reqroomoperation.enum_room_operation.set(i16);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f240851e.getCurrentAccountUin(), "QQAIOMediaSvc.room_operation");
            toServiceMsg.extraData.putInt("KEY_SESSION_TYPE", i3);
            toServiceMsg.extraData.putString("KEY_SESSION_UIN", str);
            toServiceMsg.extraData.putInt("KEY_OPERATOR", i16);
            toServiceMsg.extraData.putInt("KEY_REFRESH_SESSION_BY", i17);
            toServiceMsg.putWupBuffer(aio_media_reqroomoperation.toByteArray());
            sendPbReq(toServiceMsg);
        } catch (NumberFormatException e16) {
            QLog.d("ListenTogether.handler", 1, "reqRoomOperation, exception", e16);
            ListenTogetherManager listenTogetherManager = this.f240850d;
            if (listenTogetherManager != null) {
                if (i16 == 1) {
                    listenTogetherManager.a1(false, new ListenTogetherSession(i3, str), i17);
                } else if (i16 == 2 || i16 == 3) {
                    listenTogetherManager.Z0(false, new ListenTogetherSession(i3, str), i16, true);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.handler", 2, String.format("reqRoomOperation, sessionType: %s, uin: %s, operatorType: %s, by: %d", Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17)));
        }
    }

    public void G2(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("ListenTogether.handler", 2, String.format("getGroupJoinedUsers, groupUin is empty!", new Object[0]));
            return;
        }
        try {
            aio_media$ReqSongPlayShowInfo aio_media_reqsongplayshowinfo = new aio_media$ReqSongPlayShowInfo();
            aio_media_reqsongplayshowinfo.uint64_id.set(Long.valueOf(str).longValue());
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f240851e.getCurrentAccountUin(), "QQAIOMediaSvc.get_play_show_info");
            toServiceMsg.extraData.putString("KEY_SESSION_UIN", str);
            toServiceMsg.putWupBuffer(aio_media_reqsongplayshowinfo.toByteArray());
            sendPbReq(toServiceMsg);
        } catch (NumberFormatException e16) {
            QLog.d("ListenTogether.handler", 1, "getGroupJoinedUsers, exception", e16);
            notifyUI(17, false, new Object[]{str});
        }
    }

    public void Q2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        if (fromServiceMsg != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    aio_media$RspShareTrans aio_media_rspsharetrans = new aio_media$RspShareTrans();
                    aio_media_rspsharetrans.mergeFrom((byte[]) obj);
                    int i3 = toServiceMsg.extraData.getInt("uintype");
                    String string = toServiceMsg.extraData.getString("uin");
                    String string2 = toServiceMsg.extraData.getString(AppConstants.Key.KEY_AIO_SHARE_MUSIC_SONG_ID);
                    aio_media$ResultInfo aio_media_resultinfo = aio_media_rspsharetrans.msg_result.get();
                    int i16 = aio_media_resultinfo != null ? aio_media_resultinfo.uint32_result.get() : -1;
                    if (aio_media_resultinfo == null) {
                        str = "";
                    } else {
                        str = aio_media_resultinfo.bytes_errmsg.get().toStringUtf8();
                    }
                    if (i16 == 0) {
                        this.f240850d.e0(true, new Object[]{Integer.valueOf(i3), string, string2});
                        return;
                    } else {
                        this.f240850d.e0(false, new Object[]{Integer.valueOf(i16), str});
                        return;
                    }
                }
            } catch (Exception unused) {
                this.f240850d.e0(false, new Object[]{-1, ""});
                return;
            }
        }
        this.f240850d.e0(false, new Object[]{-1, ""});
    }

    public void Y2(int i3, String str, String str2, String str3, String str4, List<String> list) {
        try {
            aio_media$ReqReportDownloadFail aio_media_reqreportdownloadfail = new aio_media$ReqReportDownloadFail();
            aio_media_reqreportdownloadfail.enum_aio_type.set(i3);
            aio_media_reqreportdownloadfail.uint64_id.set(Long.parseLong(str));
            aio_media_reqreportdownloadfail.str_song_id.set(str2);
            aio_media_reqreportdownloadfail.bytes_song_name.set(ByteStringMicro.copyFromUtf8(str3));
            aio_media_reqreportdownloadfail.bytes_song_url.set(ByteStringMicro.copyFromUtf8(str4));
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ByteStringMicro.copyFromUtf8(it.next()));
            }
            aio_media_reqreportdownloadfail.rpt_bytes_singer.set(arrayList);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f240851e.getCurrentAccountUin(), "QQAIOMediaSvc.report_download_fail");
            toServiceMsg.extraData.putString("uin", str);
            toServiceMsg.extraData.putInt("uintype", i3);
            toServiceMsg.putWupBuffer(aio_media_reqreportdownloadfail.toByteArray());
            sendPbReq(toServiceMsg);
            if (QLog.isColorLevel()) {
                QLog.d("ListenTogether.handler", 2, "checkAndShowAioShareMusic()-> request = " + toServiceMsg.toString());
            }
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
    }

    public void Z2(int i3, String str, String str2, int i16) {
        ((TogetherOperationHandler) this.f240851e.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).K2(1, i3, str, str2, i16);
    }

    public long a3(int i3, String str) {
        return ((TogetherOperationHandler) this.f240851e.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).L2(1, i3, str);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return e.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            return;
        }
        if ("QQAIOMediaSvc.get_latest_playing_state".equals(fromServiceMsg.getServiceCmd())) {
            if (1 == toServiceMsg.extraData.getInt("KEY_SERVICE_TYPE")) {
                J2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if ("QQAIOMediaSvc.get_song_extended_info".equals(fromServiceMsg.getServiceCmd())) {
            K2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQAIOMediaSvc.media_operation".equals(fromServiceMsg.getServiceCmd())) {
            L2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQAIOMediaSvc.room_operation".equals(fromServiceMsg.getServiceCmd())) {
            P2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQAIOMediaSvc.get_play_show_info".equals(fromServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQAIOMediaSvc.share_trans_check".equals(fromServiceMsg.getServiceCmd())) {
            R2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQAIOMediaSvc.share_trans".equals(fromServiceMsg.getServiceCmd())) {
            Q2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQAIOMediaSvc.report_download_fail".equals(fromServiceMsg.getServiceCmd())) {
            M2(toServiceMsg, fromServiceMsg, obj);
        } else if ("QQAIOMediaSvc.create_room".equals(fromServiceMsg.getServiceCmd())) {
            N2(toServiceMsg, fromServiceMsg, obj);
        } else if ("QQAIOMediaSvc.heartbeat".equals(fromServiceMsg.getServiceCmd())) {
            O2(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void E2(int i3, String str, int i16) {
        b3(i3, str, 4, i16);
    }

    public void F2(int i3, String str, int i16) {
        b3(i3, str, 3, i16);
    }

    public void S2(int i3, String str, int i16) {
        c3(i3, str, 1, i16);
    }

    public void checkAndShowAioShareMusic(JSONObject jSONObject) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("ListenTogether.handler", 2, " checkAndShowAioShareMusic\uff08\uff09 jsonObject = " + jSONObject);
            }
            int i3 = jSONObject.getInt("enum_aio_type");
            String string = jSONObject.getString("uint64_id");
            int i16 = jSONObject.getInt("uint32_share_appid");
            String string2 = jSONObject.getString("bytes_song_name");
            String string3 = jSONObject.getString("bytes_song_url");
            JSONArray jSONArray = jSONObject.getJSONArray("rpt_bytes_singer");
            aio_media$ReqShareTransCheck aio_media_reqsharetranscheck = new aio_media$ReqShareTransCheck();
            aio_media_reqsharetranscheck.enum_aio_type.set(i3);
            aio_media_reqsharetranscheck.uint64_id.set(Long.parseLong(string));
            aio_media_reqsharetranscheck.uint32_share_appid.set(i16);
            aio_media_reqsharetranscheck.bytes_song_name.set(ByteStringMicro.copyFromUtf8(string2));
            aio_media_reqsharetranscheck.bytes_song_url.set(ByteStringMicro.copyFromUtf8(string3));
            ArrayList arrayList = new ArrayList();
            for (int i17 = 0; i17 < jSONArray.length(); i17++) {
                arrayList.add(ByteStringMicro.copyFromUtf8(jSONArray.getJSONObject(i17).getString("singer")));
            }
            aio_media_reqsharetranscheck.rpt_bytes_singer.set(arrayList);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f240851e.getCurrentAccountUin(), "QQAIOMediaSvc.share_trans_check");
            toServiceMsg.extraData.putString("uin", string);
            toServiceMsg.extraData.putInt("uintype", i3);
            toServiceMsg.putWupBuffer(aio_media_reqsharetranscheck.toByteArray());
            sendPbReq(toServiceMsg);
        } catch (Exception unused) {
            this.f240850d.a0(false, null);
        }
    }

    private List<MusicInfo> U2(aio_media$TypeMusic aio_media_typemusic, long j3, long j16) {
        if (aio_media_typemusic == null) {
            return null;
        }
        long j17 = aio_media_typemusic.int32_progress_seek.get();
        List<MusicInfo> T2 = T2(aio_media_typemusic.rpt_msg_song_list.get());
        if (T2 == null || T2.size() <= 0) {
            return T2;
        }
        MusicInfo musicInfo = T2.get(0);
        long D2 = D2(j16, j3);
        if (D2 > 0) {
            musicInfo.D = j17 + D2;
        } else {
            musicInfo.D = j17;
        }
        QLog.i("ListenTogether.Seek", 1, "handler seek: " + musicInfo.D + " currentTime: " + System.currentTimeMillis());
        musicInfo.E = SystemClock.elapsedRealtime();
        musicInfo.F = SystemClock.elapsedRealtime();
        if (!QLog.isColorLevel()) {
            return T2;
        }
        QLog.d("ListenTogether.handler", 2, String.format("parseTypeMusic, seek: %s, serverTime: %s, interval: %s", Long.valueOf(j17), Long.valueOf(j3), Long.valueOf(D2)));
        return T2;
    }

    public void H2(int i3, String str, List<h> list, boolean z16) {
        if (list != null && list.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ListenTogether.handler", 2, String.format("getSongExtendedInfo, sessionType: %s, uin: %s, musicList: %s", Integer.valueOf(i3), str, list));
            }
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                aio_media$ReqSongExtendedInfo aio_media_reqsongextendedinfo = new aio_media$ReqSongExtendedInfo();
                aio_media_reqsongextendedinfo.enum_aio_type.set(i3);
                aio_media_reqsongextendedinfo.uint64_id.set(Long.valueOf(str).longValue());
                ArrayList arrayList2 = new ArrayList();
                for (h hVar : list) {
                    aio_media$SongExtendedReqParam aio_media_songextendedreqparam = new aio_media$SongExtendedReqParam();
                    aio_media_songextendedreqparam.str_song_id.set(hVar.f240974a);
                    aio_media_songextendedreqparam.bool_need_lyric.set(hVar.f240976c);
                    aio_media_songextendedreqparam.bool_need_url.set(hVar.f240975b);
                    arrayList2.add(aio_media_songextendedreqparam);
                    arrayList.add(hVar.f240974a);
                }
                aio_media_reqsongextendedinfo.rpt_msg_song_list.set(arrayList2);
                ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f240851e.getCurrentAccountUin(), "QQAIOMediaSvc.get_song_extended_info");
                toServiceMsg.extraData.putInt("KEY_SESSION_TYPE", i3);
                toServiceMsg.extraData.putString("KEY_SESSION_UIN", str);
                toServiceMsg.extraData.putBoolean("KEY_REQ_LYRIC", z16);
                toServiceMsg.extraData.putStringArrayList("KEY_REQ_MUSIC_ID_LIST", arrayList);
                toServiceMsg.putWupBuffer(aio_media_reqsongextendedinfo.toByteArray());
                toServiceMsg.setTimeout(30000L);
                sendPbReq(toServiceMsg);
                return;
            } catch (NumberFormatException e16) {
                ListenTogetherManager listenTogetherManager = this.f240850d;
                if (listenTogetherManager != null) {
                    listenTogetherManager.g1(false, null, z16);
                }
                QLog.d("ListenTogether.handler", 1, "getSongExtendedInfo, exception", e16);
                return;
            }
        }
        ListenTogetherManager listenTogetherManager2 = this.f240850d;
        if (listenTogetherManager2 != null) {
            listenTogetherManager2.g1(false, null, z16);
        }
        QLog.d("ListenTogether.handler", 1, String.format("getSongExtendedInfo, sessionType = %s, uin = %s, musicReaList is empty!", Integer.valueOf(i3), str));
    }

    public void V2(int i3, String str) {
        b3(i3, str, 2, 0);
    }

    public void W2(int i3, String str) {
        b3(i3, str, 1, 0);
    }

    public void X2(int i3, String str) {
        c3(i3, str, 2, 0);
    }

    public void d3(int i3, String str) {
        c3(i3, str, 3, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        ListenTogetherManager listenTogetherManager;
        boolean z17 = toServiceMsg != null ? toServiceMsg.extraData.getBoolean("KEY_REQ_LYRIC") : false;
        List<MusicInfo> list = null;
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            int i3 = toServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
            String string = toServiceMsg.extraData.getString("KEY_SESSION_UIN");
            try {
            } catch (Exception e16) {
                e = e16;
            }
            if (fromServiceMsg.isSuccess()) {
                aio_media$RspSongExtendedInfo aio_media_rspsongextendedinfo = new aio_media$RspSongExtendedInfo();
                aio_media_rspsongextendedinfo.mergeFrom((byte[]) obj);
                aio_media$ResultInfo aio_media_resultinfo = aio_media_rspsongextendedinfo.msg_result.get();
                r7 = aio_media_resultinfo != null ? aio_media_resultinfo.uint32_result.get() : -1;
                if (r7 == 0) {
                    list = T2(aio_media_rspsongextendedinfo.rpt_msg_song_list.get());
                    if (list == null || list.size() == 0) {
                        ArrayList arrayList = new ArrayList();
                        try {
                            ArrayList<String> stringArrayList = toServiceMsg.extraData.getStringArrayList("KEY_REQ_MUSIC_ID_LIST");
                            if (stringArrayList != null) {
                                for (String str : stringArrayList) {
                                    MusicInfo musicInfo = new MusicInfo();
                                    musicInfo.f240910d = str;
                                    arrayList.add(musicInfo);
                                    QLog.d("ListenTogether.handler", 1, "handleGetSongExtendedInfo, empty list, build musicInfo: " + str);
                                }
                            }
                            list = arrayList;
                        } catch (Exception e17) {
                            e = e17;
                            list = arrayList;
                            QLog.d("ListenTogether.handler", 1, "handleGetSongExtendedInfo", e);
                            z16 = false;
                            if (QLog.isColorLevel()) {
                            }
                            listenTogetherManager = this.f240850d;
                            if (listenTogetherManager != null) {
                            }
                        }
                    }
                    z16 = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("ListenTogether.handler", 2, String.format("handleGetSongExtendedInfo, sessionType: %s, uin: %s, isSuccess: %s, result: %s, musicList: %s", Integer.valueOf(i3), string, Boolean.valueOf(z16), Integer.valueOf(r7), list));
                    }
                    listenTogetherManager = this.f240850d;
                    if (listenTogetherManager != null) {
                        listenTogetherManager.g1(z16, list, z17);
                        return;
                    }
                    return;
                }
            } else {
                QLog.d("ListenTogether.handler", 1, String.format("handleGetSongExtendedInfo, rsp is failed", new Object[0]));
            }
            z16 = false;
            if (QLog.isColorLevel()) {
            }
            listenTogetherManager = this.f240850d;
            if (listenTogetherManager != null) {
            }
        } else {
            ListenTogetherManager listenTogetherManager2 = this.f240850d;
            if (listenTogetherManager2 != null) {
                listenTogetherManager2.g1(false, null, z17);
            }
            QLog.d("ListenTogether.handler", 1, "handleGetSongExtendedInfo, req == null || resp == null || data == null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void P2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        boolean z16;
        ListenTogetherManager listenTogetherManager;
        aio_media$ResultInfo aio_media_resultinfo;
        int i3;
        int i16 = toServiceMsg != null ? toServiceMsg.extraData.getInt("KEY_SESSION_TYPE") : -1;
        String str2 = "";
        if (toServiceMsg == null) {
            str = "";
        } else {
            str = toServiceMsg.extraData.getString("KEY_SESSION_UIN");
        }
        int i17 = toServiceMsg != null ? toServiceMsg.extraData.getInt("KEY_OPERATOR") : -1;
        int i18 = toServiceMsg != null ? toServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY") : -1;
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            ListenTogetherSession listenTogetherSession = new ListenTogetherSession(i16, str);
            if (fromServiceMsg.isSuccess() && listenTogetherSession.a()) {
                try {
                    aio_media$RspRoomOperation aio_media_rsproomoperation = new aio_media$RspRoomOperation();
                    aio_media_rsproomoperation.mergeFrom((byte[]) obj);
                    aio_media_resultinfo = aio_media_rsproomoperation.msg_result.get();
                    i3 = aio_media_resultinfo != null ? aio_media_resultinfo.uint32_result.get() : -1;
                } catch (Exception e16) {
                    QLog.d("ListenTogether.handler", 1, "handleReqRoomOperation exception", e16);
                }
                if (i3 != 0) {
                    if (aio_media_resultinfo != null && aio_media_resultinfo.bytes_errmsg.get() != null) {
                        str2 = aio_media_resultinfo.bytes_errmsg.get().toStringUtf8();
                    }
                    QLog.d("ListenTogether.handler", 1, String.format("handleReqRoomOperation, result = %s, errTips = %s", Integer.valueOf(i3), str2));
                } else {
                    z16 = true;
                    listenTogetherManager = this.f240850d;
                    if (listenTogetherManager != null) {
                        if (i17 == 1) {
                            listenTogetherManager.a1(z16, listenTogetherSession, i18);
                        } else if (i17 == 2 || i17 == 3) {
                            listenTogetherManager.Z0(z16, listenTogetherSession, i17, true);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        return;
                    }
                    QLog.d("ListenTogether.handler", 2, String.format("handleReqRoomOperation, isSuccess: %s, session: %s, operationType: %s", Boolean.valueOf(z16), listenTogetherSession, Integer.valueOf(i17)));
                    return;
                }
            }
            z16 = false;
            listenTogetherManager = this.f240850d;
            if (listenTogetherManager != null) {
            }
            if (QLog.isColorLevel()) {
            }
        } else if (this.f240850d != null) {
            ListenTogetherSession listenTogetherSession2 = (TextUtils.isEmpty(str) || i16 == -1) ? null : new ListenTogetherSession(i16, str);
            if (i17 == 1) {
                this.f240850d.a1(false, listenTogetherSession2, i18);
            } else if (i17 == 2 || i17 == 3) {
                this.f240850d.Z0(false, listenTogetherSession2, i17, true);
            }
        }
    }

    public void R2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    aio_media$RspShareTransCheck aio_media_rspsharetranscheck = new aio_media$RspShareTransCheck();
                    aio_media_rspsharetranscheck.mergeFrom((byte[]) obj);
                    aio_media$ResultInfo aio_media_resultinfo = aio_media_rspsharetranscheck.msg_result.get();
                    int i3 = aio_media_resultinfo != null ? aio_media_resultinfo.uint32_result.get() : -1;
                    String str = "";
                    if (i3 == 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("isSuccess", true);
                        jSONObject.put("enum_aio_state", aio_media_rspsharetranscheck.enum_aio_state.get());
                        jSONObject.put("enum_media_type", aio_media_rspsharetranscheck.enum_media_type.get());
                        jSONObject.put("bool_show_icon", aio_media_rspsharetranscheck.bool_show_icon.get());
                        jSONObject.put("str_song_id", aio_media_rspsharetranscheck.str_song_id.get());
                        jSONObject.put("uint32_duration", aio_media_rspsharetranscheck.uint32_duration.get());
                        jSONObject.put("uint64_create_uin", aio_media_rspsharetranscheck.uint64_create_uin.get());
                        jSONObject.put("bool_song_existed", aio_media_rspsharetranscheck.bool_song_existed.get());
                        jSONObject.put("bool_allow_member_start", aio_media_rspsharetranscheck.bool_allow_member_start.get());
                        jSONObject.put("bool_allow_member_add", aio_media_rspsharetranscheck.bool_allow_member_add.get());
                        if (!TextUtils.isEmpty(QQMusicPlayService.H())) {
                            str = QQMusicPlayService.H();
                        }
                        jSONObject.put("current_song_id", str);
                        this.f240850d.a0(true, jSONObject);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        if (aio_media_resultinfo != null) {
                            str = aio_media_resultinfo.bytes_errmsg.get().toStringUtf8();
                        }
                        QLog.d("AioShareMusicListenTogether.handler", 2, "handleCheckAndShowAioShareMusic() result = " + i3 + " errMsg = " + str);
                    }
                    this.f240850d.a0(false, null);
                    return;
                }
            } catch (Exception unused) {
                this.f240850d.a0(false, null);
                return;
            }
        }
        this.f240850d.a0(false, null);
    }

    public void startAioShareTogetherListen(JSONObject jSONObject) {
        try {
            int i3 = jSONObject.getInt("enum_aio_type");
            String string = jSONObject.getString("uint64_id");
            int i16 = jSONObject.getInt("uint32_share_appid");
            String string2 = jSONObject.getString("bytes_song_name");
            String string3 = jSONObject.getString("bytes_song_url");
            boolean z16 = jSONObject.getBoolean("bool_cut_song");
            String string4 = jSONObject.getString("str_song_id");
            int i17 = jSONObject.getInt("uint32_duration");
            String string5 = jSONObject.getString("uint64_sharer_uin");
            JSONArray jSONArray = jSONObject.getJSONArray("rpt_bytes_singer");
            String string6 = jSONObject.getString("bytes_cover");
            if (QLog.isColorLevel()) {
                QLog.d("ListenTogether.handler", 2, " startAioShareMusic\uff08\uff09 jsonStr = " + jSONObject.toString());
            }
            aio_media$ReqShareTrans aio_media_reqsharetrans = new aio_media$ReqShareTrans();
            aio_media_reqsharetrans.enum_aio_type.set(i3);
            aio_media_reqsharetrans.uint64_id.set(Long.parseLong(string));
            aio_media_reqsharetrans.uint32_share_appid.set(i16);
            aio_media_reqsharetrans.bytes_song_name.set(ByteStringMicro.copyFromUtf8(string2));
            aio_media_reqsharetrans.bytes_song_url.set(ByteStringMicro.copyFromUtf8(string3));
            ArrayList arrayList = new ArrayList();
            for (int i18 = 0; i18 < jSONArray.length(); i18++) {
                arrayList.add(ByteStringMicro.copyFromUtf8(jSONArray.getJSONObject(i18).getString("singer")));
            }
            aio_media_reqsharetrans.str_song_id.set(string4);
            aio_media_reqsharetrans.rpt_bytes_singer.set(arrayList);
            aio_media_reqsharetrans.bool_cut_song.set(z16);
            aio_media_reqsharetrans.uint32_duration.set(i17);
            aio_media_reqsharetrans.uint64_sharer_uin.set(Long.parseLong(string5));
            aio_media_reqsharetrans.bytes_cover.set(ByteStringMicro.copyFromUtf8(string6));
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f240851e.getCurrentAccountUin(), "QQAIOMediaSvc.share_trans");
            toServiceMsg.extraData.putString("uin", string);
            toServiceMsg.extraData.putInt("uintype", i3);
            toServiceMsg.extraData.putString(AppConstants.Key.KEY_AIO_SHARE_MUSIC_SONG_ID, string4);
            toServiceMsg.putWupBuffer(aio_media_reqsharetrans.toByteArray());
            sendPbReq(toServiceMsg);
        } catch (Exception unused) {
            this.f240850d.e0(false, new Object[]{-1, ""});
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        int i3;
        ListenTogetherSession listenTogetherSession;
        int i16;
        boolean z16;
        ListenTogetherManager listenTogetherManager;
        Exception exc;
        aio_media$RspLatestPlayingState aio_media_rsplatestplayingstate;
        aio_media$ResultInfo aio_media_resultinfo;
        int i17;
        int i18;
        int i19;
        int i26 = toServiceMsg != null ? toServiceMsg.extraData.getInt("KEY_SESSION_TYPE") : -1;
        String str2 = "";
        if (toServiceMsg == null) {
            str = "";
        } else {
            str = toServiceMsg.extraData.getString("KEY_SESSION_UIN");
        }
        int i27 = toServiceMsg != null ? toServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY") : -1;
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET) != null) {
                currentTimeMillis = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue();
            }
            long j3 = currentTimeMillis;
            ListenTogetherSession listenTogetherSession2 = new ListenTogetherSession(i26, str);
            if (fromServiceMsg.isSuccess() && listenTogetherSession2.a()) {
                try {
                    aio_media_rsplatestplayingstate = new aio_media$RspLatestPlayingState();
                    aio_media_rsplatestplayingstate.mergeFrom((byte[]) obj);
                    aio_media_resultinfo = aio_media_rsplatestplayingstate.msg_result.get();
                    if (aio_media_resultinfo != null) {
                        try {
                            i17 = aio_media_resultinfo.uint32_result.get();
                        } catch (Exception e16) {
                            exc = e16;
                            i16 = 2;
                            z16 = false;
                            QLog.d("ListenTogether.handler", 1, "handleGetPlayingState exception", exc);
                            listenTogetherManager = this.f240850d;
                            if (listenTogetherManager != null) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } else {
                        i17 = -1;
                    }
                } catch (Exception e17) {
                    e = e17;
                    i16 = 2;
                }
                if (i17 == 0) {
                    try {
                    } catch (Exception e18) {
                        e = e18;
                        i16 = 2;
                    }
                    if (aio_media_rsplatestplayingstate.enum_media_type.get() != 1) {
                        return;
                    }
                    long j16 = aio_media_resultinfo.uint64_svr_time.get();
                    listenTogetherSession2.f437191i = aio_media_rsplatestplayingstate.enum_aio_state.get();
                    i16 = 2;
                    try {
                        listenTogetherSession2.L = U2(aio_media_rsplatestplayingstate.msg_music.get(), j16, j3);
                        listenTogetherSession2.T = aio_media_rsplatestplayingstate.msg_music.get().bool_allow_member_start.get();
                        listenTogetherSession2.U = aio_media_rsplatestplayingstate.msg_music.get().bool_allow_member_add.get();
                        listenTogetherSession2.V = aio_media_rsplatestplayingstate.msg_music.get().enum_play_mode.get();
                        listenTogetherSession2.E = j16;
                        String valueOf = String.valueOf(aio_media_rsplatestplayingstate.uint64_create_uin.get());
                        listenTogetherSession2.C = valueOf;
                        if (!TextUtils.isEmpty(valueOf)) {
                            listenTogetherSession2.D = d72.b.k(this.f240851e, str, i26, listenTogetherSession2.C);
                        }
                        listenTogetherSession2.f437192m = aio_media_rsplatestplayingstate.enum_user_state.get();
                        listenTogetherSession2.R = aio_media_rsplatestplayingstate.msg_personal_setting.uint32_theme_id.get();
                        if (i26 == 1) {
                            i18 = aio_media_rsplatestplayingstate.uint32_joined_num.get();
                            i19 = 0;
                        } else {
                            i18 = 0;
                            i19 = aio_media_rsplatestplayingstate.enum_c2c_join_state.has() ? aio_media_rsplatestplayingstate.enum_c2c_join_state.get() : -1;
                        }
                        listenTogetherSession2.N = listenTogetherSession2.e(i18, i19);
                        listenTogetherSession2.P = aio_media_rsplatestplayingstate.enum_joined_aio_type.get();
                        listenTogetherSession2.Q = String.valueOf(aio_media_rsplatestplayingstate.uint64_joined_id.get());
                        listenTogetherSession2.S = aio_media_rsplatestplayingstate.bool_joined_is_creater.get();
                        listenTogetherSession2.I = aio_media_rsplatestplayingstate.uint64_aio_identification.get();
                        z16 = true;
                    } catch (Exception e19) {
                        e = e19;
                        exc = e;
                        z16 = true;
                        QLog.d("ListenTogether.handler", 1, "handleGetPlayingState exception", exc);
                        listenTogetherManager = this.f240850d;
                        if (listenTogetherManager != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                    listenTogetherManager = this.f240850d;
                    if (listenTogetherManager != null) {
                        listenTogetherManager.e1(z16, listenTogetherSession2, i27);
                    }
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(z16);
                        objArr[1] = listenTogetherSession2;
                        objArr[i16] = Integer.valueOf(i27);
                        QLog.d("ListenTogether.handler", i16, String.format("handleGetPlayingState, isSuccess: %s, session: %s, by: %s", objArr));
                        return;
                    }
                    return;
                }
                i16 = 2;
                if (aio_media_resultinfo != null) {
                    try {
                        if (aio_media_resultinfo.bytes_errmsg.get() != null) {
                            str2 = aio_media_resultinfo.bytes_errmsg.get().toStringUtf8();
                        }
                    } catch (Exception e26) {
                        e = e26;
                        exc = e;
                        z16 = false;
                        QLog.d("ListenTogether.handler", 1, "handleGetPlayingState exception", exc);
                        listenTogetherManager = this.f240850d;
                        if (listenTogetherManager != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                }
                QLog.d("ListenTogether.handler", 1, String.format("handleGetPlayingState, result = %s, errTips = %s", Integer.valueOf(i17), str2));
            } else {
                i16 = 2;
            }
            z16 = false;
            listenTogetherManager = this.f240850d;
            if (listenTogetherManager != null) {
            }
            if (QLog.isColorLevel()) {
            }
        } else {
            if (this.f240850d != null) {
                if (TextUtils.isEmpty(str)) {
                    i3 = -1;
                } else {
                    i3 = -1;
                    if (i26 != -1) {
                        listenTogetherSession = new ListenTogetherSession(i26, str);
                        this.f240850d.e1(false, listenTogetherSession, i3);
                    }
                }
                listenTogetherSession = null;
                this.f240850d.e1(false, listenTogetherSession, i3);
            }
            QLog.d("ListenTogether.handler", 1, "handleGetPlayingState, req == null || resp == null || data == null");
        }
    }
}
