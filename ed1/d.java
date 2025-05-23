package ed1;

import PushNotifyPack.C2CMsgReadedNotify;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$C2CTmpMsgHead;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$UinPairMsg;
import msf.msgsvc.msg_svc$PbC2CReadedReportReq;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;
import org.json.JSONObject;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype34;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {
    public static long a(long j3, msg_comm$UinPairMsg msg_comm_uinpairmsg, AppInterface appInterface) {
        if (msg_comm_uinpairmsg != null) {
            try {
                if (msg_comm_uinpairmsg.service_type.has() && msg_comm_uinpairmsg.service_type.get() == 164) {
                    if (msg_comm_uinpairmsg.uint64_to_tiny_id.has()) {
                        String valueOf = String.valueOf(msg_comm_uinpairmsg.uint64_to_tiny_id.get());
                        String valueOf2 = String.valueOf(j3);
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "convertTinyToUin is called, fromTinyId: " + j3 + "toTinyId :" + valueOf);
                        }
                        return Long.parseLong(((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().f(valueOf2, valueOf));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "convertTinyToUin is called, but toTinyId is not contained.");
                        return j3;
                    }
                    return j3;
                }
                return j3;
            } catch (Exception e16) {
                QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 1, "convertTinyToUin is called", e16);
                return j3;
            }
        }
        return j3;
    }

    public static String b(msg_comm$UinPairMsg msg_comm_uinpairmsg, AppInterface appInterface, int i3) {
        long j3 = msg_comm_uinpairmsg.peer_uin.get();
        if (i3 == 10007 && appInterface != null) {
            return String.valueOf(a(j3, msg_comm_uinpairmsg, appInterface));
        }
        return String.valueOf(j3);
    }

    public static void c(AppInterface appInterface, msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq, long j3, ConversationInfo conversationInfo) {
        if (j3 != 0 && conversationInfo != null && appInterface != null) {
            Pair<String, String> e16 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().e(conversationInfo.uin);
            if (e16 == null) {
                QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "tinyItemByUin is null");
                return;
            }
            try {
                long longValue = Long.valueOf((String) e16.first).longValue();
                long longValue2 = Long.valueOf((String) e16.second).longValue();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "createMsgReadConfirm is called");
                }
                if (appInterface.getCurrentAccountUin() == null) {
                    return;
                }
                if (longValue != 0 && longValue2 != 0) {
                    msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
                    uinPairReadInfo.peer_uin.set(longValue);
                    uinPairReadInfo.last_read_time.set((int) j3);
                    uinPairReadInfo.aio_type.set(3);
                    uinPairReadInfo.uint64_to_tiny_id.set(longValue2);
                    msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "msgReadedReportUin : " + longValue + ", toIinyId = " + longValue2);
                        return;
                    }
                    return;
                }
                QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "peeruin & toTinyid exception!");
            } catch (NumberFormatException e17) {
                QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, e17, new Object[0]);
            }
        }
    }

    public static void d(AppInterface appInterface, msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq, String str, long j3) {
        Pair<String, String> e16;
        if (j3 == 0 || appInterface == null || (e16 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().e(str)) == null) {
            return;
        }
        try {
            long parseLong = Long.parseLong((String) e16.first);
            long parseLong2 = Long.parseLong((String) e16.second);
            if (QLog.isColorLevel()) {
                QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "createMsgReadConfirm is called curFriendUin = " + str);
            }
            if (appInterface.getCurrentAccountUin() == null) {
                return;
            }
            if (parseLong != 0 && parseLong2 != 0) {
                msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
                uinPairReadInfo.peer_uin.set(parseLong);
                uinPairReadInfo.last_read_time.set((int) j3);
                uinPairReadInfo.aio_type.set(3);
                uinPairReadInfo.uint64_to_tiny_id.set(parseLong2);
                msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
                msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo);
                byte[] F0 = ((e) appInterface.getMsgCache()).F0();
                if (F0 != null) {
                    msg_svc_pbc2creadedreportreq.sync_cookie.set(ByteStringMicro.copyFrom(F0));
                }
                if (msg_svc_pbmsgreadedreportreq == null) {
                    msg_svc_pbmsgreadedreportreq = new msg_svc$PbMsgReadedReportReq();
                }
                msg_svc_pbmsgreadedreportreq.c2c_read_report.set(msg_svc_pbc2creadedreportreq);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "msgReadedReportUin : " + parseLong + ", toIinyId = " + parseLong2);
                    return;
                }
                return;
            }
            QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "peeruin & toTinyid exception!");
        } catch (NumberFormatException e17) {
            QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, e17, new Object[0]);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:18|19|(1:21)(1:140)|22|(1:24)(1:139)|25|26|27|(4:29|30|31|(7:33|35|36|(1:38)|40|(1:42)(1:129)|(22:44|(1:46)(1:120)|47|(1:49)(1:119)|50|(1:52)(1:118)|53|(1:55)(1:117)|56|(1:58)(1:116)|59|(1:61)(1:115)|62|(1:64)|65|(1:69)|(1:71)|72|(6:75|(1:77)(1:97)|78|(5:80|81|82|83|84)(2:95|96)|85|73)|98|99|(6:101|102|103|104|105|107)(1:113))(5:121|122|123|124|126)))(1:136)|132|35|36|(0)|40|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00eb, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #7 {all -> 0x00eb, blocks: (B:36:0x00cb, B:38:0x00d1), top: B:35:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fe A[Catch: Exception -> 0x02d0, InvalidProtocolBufferMicroException -> 0x02d6, TryCatch #11 {InvalidProtocolBufferMicroException -> 0x02d6, Exception -> 0x02d0, blocks: (B:12:0x0031, B:14:0x003d, B:16:0x0047, B:18:0x0051, B:21:0x0070, B:22:0x007f, B:24:0x0088, B:25:0x0093, B:40:0x00f5, B:42:0x00fe, B:44:0x010b, B:46:0x0113, B:47:0x011f, B:49:0x0127, B:50:0x0136, B:52:0x013e, B:53:0x014b, B:55:0x0153, B:56:0x0162, B:58:0x016c, B:59:0x0177, B:61:0x017f, B:62:0x018a, B:64:0x0192, B:65:0x0198, B:67:0x01ae, B:69:0x01b8, B:71:0x01c3, B:72:0x01cc, B:73:0x01d0, B:75:0x01d6, B:77:0x0203, B:78:0x0231, B:80:0x0237, B:97:0x022b, B:131:0x00f0), top: B:11:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010b A[Catch: Exception -> 0x02d0, InvalidProtocolBufferMicroException -> 0x02d6, TryCatch #11 {InvalidProtocolBufferMicroException -> 0x02d6, Exception -> 0x02d0, blocks: (B:12:0x0031, B:14:0x003d, B:16:0x0047, B:18:0x0051, B:21:0x0070, B:22:0x007f, B:24:0x0088, B:25:0x0093, B:40:0x00f5, B:42:0x00fe, B:44:0x010b, B:46:0x0113, B:47:0x011f, B:49:0x0127, B:50:0x0136, B:52:0x013e, B:53:0x014b, B:55:0x0153, B:56:0x0162, B:58:0x016c, B:59:0x0177, B:61:0x017f, B:62:0x018a, B:64:0x0192, B:65:0x0198, B:67:0x01ae, B:69:0x01b8, B:71:0x01c3, B:72:0x01cc, B:73:0x01d0, B:75:0x01d6, B:77:0x0203, B:78:0x0231, B:80:0x0237, B:97:0x022b, B:131:0x00f0), top: B:11:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(msg_comm$Msg msg_comm_msg, im_msg_body$Elem im_msg_body_elem, List<MessageRecord> list, AppInterface appInterface, com.tencent.mobileqq.service.message.a aVar) {
        int i3;
        String str;
        int i16;
        int i17;
        Integer num;
        hummer_commelem$MsgElemInfo_servtype34.GameSession gameSession;
        String str2;
        String str3;
        String str4;
        String str5;
        long j3;
        long j16;
        int i18;
        String str6;
        long j17;
        long j18;
        IGameMsgManagerService iGameMsgManagerService;
        AppInterface appInterface2 = appInterface;
        if (im_msg_body_elem != null && list != null && appInterface2 != null && list.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "decodePBMsgElems_GameInterComm");
            }
            String currentAccountUin = appInterface.getCurrentAccountUin();
            int i19 = 1;
            try {
                if (34 == im_msg_body_elem.common_elem.uint32_service_type.get() && im_msg_body_elem.common_elem.uint32_business_type.get() == 1 && im_msg_body_elem.common_elem.bytes_pb_elem.has()) {
                    hummer_commelem$MsgElemInfo_servtype34 hummer_commelem_msgeleminfo_servtype34 = new hummer_commelem$MsgElemInfo_servtype34();
                    hummer_commelem_msgeleminfo_servtype34.mergeFrom(im_msg_body_elem.common_elem.bytes_pb_elem.get().toByteArray());
                    if (!hummer_commelem_msgeleminfo_servtype34.from_nickname.has()) {
                        str = "";
                    } else {
                        str = hummer_commelem_msgeleminfo_servtype34.from_nickname.get().toStringUtf8();
                    }
                    if (hummer_commelem_msgeleminfo_servtype34.push_window_flag.has()) {
                        i16 = hummer_commelem_msgeleminfo_servtype34.push_window_flag.get();
                    } else {
                        i16 = 0;
                    }
                    String stringUtf8 = hummer_commelem_msgeleminfo_servtype34.bytes_ext.get().toStringUtf8();
                    try {
                        iGameMsgManagerService = (IGameMsgManagerService) appInterface2.getRuntimeService(IGameMsgManagerService.class, "");
                    } catch (Throwable th5) {
                        th = th5;
                        i17 = 0;
                    }
                    if (!TextUtils.isEmpty(stringUtf8)) {
                        JSONObject jSONObject = new JSONObject(stringUtf8);
                        i17 = jSONObject.optInt("r");
                        try {
                            iGameMsgManagerService.onGameMsgRRecv(i17);
                        } catch (Throwable th6) {
                            th = th6;
                            num = null;
                            QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, th, new Object[0]);
                            int i26 = i17;
                            if (!hummer_commelem_msgeleminfo_servtype34.game_session.has()) {
                            }
                            if (gameSession == null) {
                            }
                        }
                        if (jSONObject.has("g")) {
                            num = Integer.valueOf(jSONObject.optInt("g"));
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "game pubAcc redPoint,ext = ", stringUtf8, ",windowFlag:", Integer.valueOf(i16));
                            }
                            int i262 = i17;
                            if (!hummer_commelem_msgeleminfo_servtype34.game_session.has()) {
                                gameSession = hummer_commelem_msgeleminfo_servtype34.game_session.get();
                            } else {
                                gameSession = null;
                            }
                            if (gameSession == null) {
                                if (!gameSession.from_role_id.has()) {
                                    str2 = "";
                                } else {
                                    str2 = gameSession.from_role_id.get().toStringUtf8();
                                }
                                if (!gameSession.from_open_id.has()) {
                                    str3 = "";
                                } else {
                                    str3 = gameSession.from_open_id.get().toStringUtf8();
                                }
                                if (!gameSession.to_role_id.has()) {
                                    str4 = "";
                                } else {
                                    str4 = gameSession.to_role_id.get().toStringUtf8();
                                }
                                if (!gameSession.to_open_id.has()) {
                                    str5 = "";
                                } else {
                                    str5 = gameSession.to_open_id.get().toStringUtf8();
                                }
                                long j19 = 0;
                                if (gameSession.game_appid.has()) {
                                    j3 = gameSession.game_appid.get();
                                } else {
                                    j3 = 0;
                                }
                                if (gameSession.from_tiny_id.has()) {
                                    j16 = gameSession.from_tiny_id.get();
                                } else {
                                    j16 = 0;
                                }
                                if (gameSession.to_tiny_id.has()) {
                                    j19 = gameSession.to_tiny_id.get();
                                }
                                long j26 = j19;
                                IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) appInterface2.getRuntimeService(IGameMsgBoxManager.class, "");
                                if (((IGameMsgManagerService) appInterface2.getRuntimeService(IGameMsgManagerService.class, "")).isShowInMsgBox() && iGameMsgBoxManager.isGameInGameBox(String.valueOf(j3))) {
                                    ((IGameMsgManagerService) appInterface2.getRuntimeService(IGameMsgManagerService.class, "")).onGameMsgRRecv(1);
                                }
                                if (num != null) {
                                    ((IGameMsgManagerService) appInterface2.getRuntimeService(IGameMsgManagerService.class, "")).notifyReceiveGameMsgSayHiMessage(str2, str4);
                                }
                                for (MessageRecord messageRecord : list) {
                                    long j27 = j26;
                                    String str7 = str4;
                                    String jsonStr = TinyInfo.toJsonStr(str2, str3, str4, str5, j3, j16, j27, i16, str, i262);
                                    h(appInterface2, str2);
                                    messageRecord.saveExtInfoToExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO, jsonStr);
                                    if (!aVar.f286162q) {
                                        String f16 = ((IMessageFacade) appInterface2.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().f(String.valueOf(j27), String.valueOf(j16));
                                        messageRecord.frienduin = f16;
                                        i(msg_comm_msg, appInterface2, aVar, f16, currentAccountUin);
                                        aVar.f286338a = Long.parseLong(messageRecord.frienduin);
                                    } else {
                                        aVar.f286149d = aVar.f286338a;
                                    }
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("toTinyId = ");
                                        str6 = str2;
                                        j18 = j27;
                                        try {
                                            sb5.append(j18);
                                            sb5.append(", fromTinyId = ");
                                            i18 = i262;
                                            long j28 = j16;
                                            sb5.append(j28);
                                            j17 = j28;
                                            sb5.append(", ctx.senderUin = ");
                                            sb5.append(aVar.f286149d);
                                            sb5.append(", ctx.friendUin = ");
                                            sb5.append(aVar.f286338a);
                                            sb5.append(", mr = ");
                                            sb5.append(messageRecord.getBaseInfoString());
                                            QLog.d("Q.tiny_msg.decoder.TinyMsgCodecdecodePBMsgGameInterCommElem", 2, sb5.toString());
                                        } catch (InvalidProtocolBufferMicroException e16) {
                                            e = e16;
                                            i3 = 1;
                                            QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", i3, "decodePBMsgGameInterCommElem error", e);
                                            return;
                                        } catch (Exception e17) {
                                            e = e17;
                                            i3 = 1;
                                            QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", i3, "decodePBMsgGameInterCommElem error", e);
                                            return;
                                        }
                                    } else {
                                        i18 = i262;
                                        str6 = str2;
                                        j17 = j16;
                                        j18 = j27;
                                    }
                                    appInterface2 = appInterface;
                                    str4 = str7;
                                    j26 = j18;
                                    i262 = i18;
                                    str2 = str6;
                                    j16 = j17;
                                    i19 = 1;
                                }
                                if (QLog.isColorLevel()) {
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str;
                                    try {
                                        objArr[1] = Integer.valueOf(i16);
                                        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, String.format("decodePBMsgGameInterCommElem fromNickName:%s windowFlag:%d", objArr));
                                        return;
                                    } catch (InvalidProtocolBufferMicroException e18) {
                                        e = e18;
                                        i3 = 1;
                                        QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", i3, "decodePBMsgGameInterCommElem error", e);
                                        return;
                                    } catch (Exception e19) {
                                        e = e19;
                                        i3 = 1;
                                        QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", i3, "decodePBMsgGameInterCommElem error", e);
                                        return;
                                    }
                                }
                                return;
                            }
                            i3 = 1;
                            try {
                                QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 1, "decodePBMsgGameInterCommElem error gameSession is null!");
                                return;
                            } catch (InvalidProtocolBufferMicroException e26) {
                                e = e26;
                                QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", i3, "decodePBMsgGameInterCommElem error", e);
                                return;
                            } catch (Exception e27) {
                                e = e27;
                                QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", i3, "decodePBMsgGameInterCommElem error", e);
                                return;
                            }
                        }
                    } else {
                        i17 = 0;
                    }
                    num = null;
                    if (QLog.isColorLevel()) {
                    }
                    int i2622 = i17;
                    if (!hummer_commelem_msgeleminfo_servtype34.game_session.has()) {
                    }
                    if (gameSession == null) {
                    }
                }
            } catch (InvalidProtocolBufferMicroException e28) {
                e = e28;
                i3 = i19;
            } catch (Exception e29) {
                e = e29;
                i3 = i19;
            }
        }
    }

    public static void f(AppInterface appInterface, String str, C2CMsgReadedNotify c2CMsgReadedNotify) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "handlePushReadNotify is called peerUin = " + str + ", cr.uint64_to_tiny_id = " + c2CMsgReadedNotify.uint64_to_tiny_id);
            }
            String f16 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().f(str, String.valueOf(c2CMsgReadedNotify.uint64_to_tiny_id));
            ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).setReadFrom(f16, 10007, c2CMsgReadedNotify.lLastReadTime);
            if (c2CMsgReadedNotify.lLastReadTime >= 0) {
                ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).removeNotification(f16, 10007);
            }
        } catch (Exception e16) {
            QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, "handlePushReadNotify error", e16);
        }
    }

    public static boolean g(MessageRecord messageRecord) {
        if (messageRecord.istroop != 10007) {
            return true;
        }
        if (((IGameMsgBoxABTestApi) QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab() && StudyModeManager.t()) {
            return false;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO);
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            return true;
        }
        TinyInfo tinyInfo = new TinyInfo();
        tinyInfo.parseFromJson(extInfoFromExtStr);
        if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "isNeedTips windowflag = " + tinyInfo.windowFlag);
        }
        if ((tinyInfo.windowFlag & 1) == 1) {
            return true;
        }
        return false;
    }

    private static void h(AppInterface appInterface, String str) {
        ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetail(str);
    }

    private static void i(msg_comm$Msg msg_comm_msg, AppInterface appInterface, com.tencent.mobileqq.service.message.a aVar, String str, String str2) {
        if (msg_comm_msg.msg_head.has()) {
            msg_comm$C2CTmpMsgHead msg_comm_c2ctmpmsghead = msg_comm_msg.msg_head.get().c2c_tmp_msg_head.get();
            if (!aVar.f286157l && msg_comm_c2ctmpmsghead.sig.has()) {
                byte[] byteArray = msg_comm_c2ctmpmsghead.sig.get().toByteArray();
                ((e) appInterface.getMsgCache()).P(str, str2, byteArray);
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 4, "saveTokenSig tempHead.sig.get()----> sig:" + HexUtil.bytes2HexStr(byteArray) + ",length:" + byteArray.length);
                }
            }
        }
    }
}
