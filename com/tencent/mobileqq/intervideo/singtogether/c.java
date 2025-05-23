package com.tencent.mobileqq.intervideo.singtogether;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.intervideo.yiqikan.k;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import tencent.aio.media.aio_media$ResultInfo;
import tencent.aio.media.aio_media$RspLatestPlayingState;
import tencent.im.oidb.cmd0x857.TroopTips0x857$SingChangePushInfo;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50$KSingRelationInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x127.submsgtype0x127$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x129.submsgtype0x129$MsgBody;
import tr2.b;
import tr2.e;
import tr2.f;
import tr2.g;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements e {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f238442a;

    public c(QQAppInterface qQAppInterface) {
        this.f238442a = qQAppInterface;
    }

    public static boolean i(byte[] bArr) {
        Oidb_0xd50$KSingRelationInfo oidb_0xd50$KSingRelationInfo = new Oidb_0xd50$KSingRelationInfo();
        try {
            oidb_0xd50$KSingRelationInfo.mergeFrom(bArr);
            if (oidb_0xd50$KSingRelationInfo.flag.get() != 1) {
                return false;
            }
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private void j(QQAppInterface qQAppInterface, int i3, int i16, long j3, long j16, long j17, String str, long j18, long j19) {
        String valueOf;
        SingTogetherSession singTogetherSession = (SingTogetherSession) g.a(4, 2, String.valueOf(j16));
        if (i16 == 1) {
            if (j3 == 0) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(j3);
            }
            singTogetherSession.C = valueOf;
        }
        if (i16 == 1 || i16 == 3 || i16 == 4) {
            singTogetherSession.L = i3;
        }
        h(qQAppInterface, singTogetherSession, i16, j3, str, j17, j18, null);
        if ((i16 == 5 || i16 == 2) && !TextUtils.isEmpty(str)) {
            k.j(qQAppInterface, j16, 0, str, i16, j18, j19, 131087);
        }
    }

    @Override // tr2.e
    public void a(int i3, int i16, String str) {
        f(str, -1);
    }

    @Override // tr2.e
    public void b(QQAppInterface qQAppInterface, long j3, long j16, Object obj) {
        long j17;
        int i3;
        long j18;
        long j19;
        String str;
        String valueOf;
        if (!(obj instanceof TroopTips0x857$SingChangePushInfo)) {
            if (QLog.isColorLevel()) {
                QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, params not right");
                return;
            }
            return;
        }
        TroopTips0x857$SingChangePushInfo troopTips0x857$SingChangePushInfo = (TroopTips0x857$SingChangePushInfo) obj;
        if (troopTips0x857$SingChangePushInfo != null) {
            if (troopTips0x857$SingChangePushInfo.uint64_seq.has()) {
                j17 = troopTips0x857$SingChangePushInfo.uint64_seq.get();
            } else {
                j17 = -1;
            }
            int i16 = -1;
            if (troopTips0x857$SingChangePushInfo.uint32_action_type.has()) {
                i3 = troopTips0x857$SingChangePushInfo.uint32_action_type.get();
            } else {
                i3 = -1;
            }
            if (troopTips0x857$SingChangePushInfo.uint64_group_id.has()) {
                j18 = troopTips0x857$SingChangePushInfo.uint64_group_id.get();
            } else {
                j18 = -1;
            }
            if (troopTips0x857$SingChangePushInfo.uint64_oper_uin.has()) {
                j19 = troopTips0x857$SingChangePushInfo.uint64_oper_uin.get();
            } else {
                j19 = -1;
            }
            if (troopTips0x857$SingChangePushInfo.uint32_join_nums.has()) {
                i16 = troopTips0x857$SingChangePushInfo.uint32_join_nums.get();
            }
            if (troopTips0x857$SingChangePushInfo.bytes_gray_tips.has()) {
                str = troopTips0x857$SingChangePushInfo.bytes_gray_tips.get().toStringUtf8();
            } else {
                str = null;
            }
            String str2 = str;
            if (QLog.isColorLevel()) {
                QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, seq=" + j17 + ", actionType=" + i3 + ", groupid=" + j18 + ", uin=" + j19 + ", joinNum=" + i16 + ", tips=" + str2);
            }
            long r16 = ((tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).r(4, 1, j18);
            if (QLog.isColorLevel()) {
                QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, oldSeq=" + r16);
            }
            if (j17 < r16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, skip pushinfo, old seq=" + r16);
                    return;
                }
                return;
            }
            SingTogetherSession singTogetherSession = (SingTogetherSession) g.a(4, 1, String.valueOf(j18));
            if (i3 == 1) {
                if (j19 == -1) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(j19);
                }
                singTogetherSession.C = valueOf;
            }
            if (i3 == 1 || i3 == 3 || i3 == 4) {
                singTogetherSession.f437190h = i16;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, session" + singTogetherSession);
            }
            long j26 = j18;
            h(qQAppInterface, singTogetherSession, i3, j19, str2, j17, j3, troopTips0x857$SingChangePushInfo);
            if ((i3 == 5 || i3 == 2) && !TextUtils.isEmpty(str2) && j26 != -1) {
                k.j(qQAppInterface, j26, 1, str2, i3, j3, j16, 131087);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, pushinfo is null.");
        }
    }

    @Override // tr2.e
    public void c(Object obj) {
        if (obj == null) {
            return;
        }
        f s16 = ((tr2.b) this.f238442a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).s(4, 2, String.valueOf(obj));
        if (s16 instanceof SingTogetherSession) {
            s16.f437191i = 3;
            s16.f437192m = 3;
            g.l(this.f238442a, s16.f437189f, false, s16.f437188e, 16777216);
            g(true, (SingTogetherSession) s16, 1007, "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    @Override // tr2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(QQAppInterface qQAppInterface, byte[] bArr, long j3, long j16, boolean z16) {
        String str;
        int i3;
        int i16;
        long j17;
        long j18;
        long j19;
        String stringUtf8;
        String str2;
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "decodePush0x210_0x127, msgSeq = " + j3 + " msgTime = " + j16 + " selfUin:" + currentAccountUin + " isOffline = " + z16);
        }
        if (bArr != null && !TextUtils.isEmpty(currentAccountUin)) {
            try {
                if (!z16) {
                    submsgtype0x127$MsgBody submsgtype0x127_msgbody = new submsgtype0x127$MsgBody();
                    submsgtype0x127_msgbody.mergeFrom(bArr);
                    i3 = submsgtype0x127_msgbody.join_state.get();
                    i16 = submsgtype0x127_msgbody.uint32_action_type.get();
                    j17 = submsgtype0x127_msgbody.uint64_oper_uin.has() ? submsgtype0x127_msgbody.uint64_oper_uin.get() : 0L;
                    j18 = submsgtype0x127_msgbody.uint64_friend_uin.has() ? submsgtype0x127_msgbody.uint64_friend_uin.get() : 0L;
                    j19 = submsgtype0x127_msgbody.uint64_seq.has() ? submsgtype0x127_msgbody.uint64_seq.get() : 0L;
                    stringUtf8 = submsgtype0x127_msgbody.bytes_gray_tips.get().toStringUtf8();
                } else {
                    submsgtype0x129$MsgBody submsgtype0x129_msgbody = new submsgtype0x129$MsgBody();
                    submsgtype0x129_msgbody.mergeFrom(bArr);
                    i3 = submsgtype0x129_msgbody.join_state.get();
                    i16 = submsgtype0x129_msgbody.uint32_action_type.get();
                    j17 = submsgtype0x129_msgbody.uint64_oper_uin.has() ? submsgtype0x129_msgbody.uint64_oper_uin.get() : 0L;
                    j18 = submsgtype0x129_msgbody.uint64_friend_uin.has() ? submsgtype0x129_msgbody.uint64_friend_uin.get() : 0L;
                    j19 = submsgtype0x129_msgbody.uint64_seq.has() ? submsgtype0x129_msgbody.uint64_seq.get() : 0L;
                    stringUtf8 = submsgtype0x129_msgbody.bytes_gray_tips.get().toStringUtf8();
                }
                int i17 = i16;
                long j26 = j18;
                long j27 = j19;
                long j28 = j17;
                int i18 = i3;
                String str3 = stringUtf8;
                try {
                    if (QLog.isColorLevel()) {
                        str2 = "SingTogetherParser";
                        try {
                            QLog.d(str2, 2, "decodePush0x210, actionType = " + i17 + " friend_uin = " + j26 + " oper_uin = " + j28 + " gray_tips = " + str3 + " timeStamp = " + j27 + " c2cJoinState" + i18 + " isOffLine=" + z16);
                        } catch (Exception e16) {
                            e = e16;
                            str = str2;
                            if (QLog.isColorLevel()) {
                                return;
                            }
                            QLog.d(str, 2, "decodePush0x210_0x127f decode error, e=", e);
                            return;
                        }
                    } else {
                        str2 = "SingTogetherParser";
                    }
                    if (j26 == 0) {
                        QLog.d(str2, 1, "filter friendUin: " + j26 + ", operatorUin: " + j28);
                        return;
                    }
                    if (z16) {
                        if (i17 != 1 && i17 != 2) {
                            QLog.d(str2, 1, "filter offline msg, msgType:" + i17);
                            return;
                        }
                        long j29 = qQAppInterface.getPreferences().getLong("inccheckupdatetimeStamp17", 0L);
                        if (j27 / 1000 < j29) {
                            QLog.d(str2, 1, String.format("filter offline msg, timestamp: %s < incUpdateTimeStamp: %s", Long.valueOf(j27 / 1000), Long.valueOf(j29)));
                            return;
                        }
                    }
                    long r16 = ((tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).r(4, 2, j26);
                    if (j27 < r16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(str2, 2, "handleSingTogetherGroupPush, skip pushinfo, old seq=" + r16);
                            return;
                        }
                        return;
                    }
                    str = str2;
                    try {
                        j(qQAppInterface, i18, i17, j28, j26, j27, str3, j3, j16);
                    } catch (Exception e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    str = "SingTogetherParser";
                }
            } catch (Exception e19) {
                e = e19;
                str = "SingTogetherParser";
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "decodePush0x210_0x127 pbData = null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x022c  */
    @Override // tr2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(ToServiceMsg toServiceMsg, aio_media$RspLatestPlayingState aio_media_rsplatestplayingstate) {
        int i3;
        String str;
        int i16;
        Object obj;
        int i17;
        int i18 = -1;
        if (toServiceMsg != null) {
            i3 = toServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
        } else {
            i3 = -1;
        }
        String str2 = "";
        if (toServiceMsg == null) {
            str = "";
        } else {
            str = toServiceMsg.extraData.getString("KEY_SESSION_UIN");
        }
        if (toServiceMsg != null) {
            i16 = toServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");
        } else {
            i16 = -1;
        }
        if (toServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("SingTogetherParser", 2, "handleGetSingPlayingState, req == null || resp == null || data == null");
                return;
            }
            return;
        }
        boolean z16 = true;
        if (i3 != 2 && i3 != 1) {
            if (QLog.isColorLevel()) {
                QLog.d("SingTogetherParser", 2, "sessionType not right =" + i3);
                return;
            }
            return;
        }
        tr2.b bVar = (tr2.b) this.f238442a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        SingTogetherSession singTogetherSession = (SingTogetherSession) bVar.s(4, i3, str);
        if (singTogetherSession == null) {
            singTogetherSession = (SingTogetherSession) g.a(4, i3, str);
            bVar.c(4, i3, str, singTogetherSession);
        }
        boolean z17 = false;
        if (singTogetherSession.a()) {
            try {
                aio_media$ResultInfo aio_media_resultinfo = aio_media_rsplatestplayingstate.msg_result.get();
                if (aio_media_resultinfo != null) {
                    i18 = aio_media_resultinfo.uint32_result.get();
                }
                if (i18 == 0) {
                    StringBuilder sb5 = new StringBuilder("handleGetPlayingState seesion=");
                    try {
                        singTogetherSession.f437191i = aio_media_rsplatestplayingstate.enum_aio_state.get();
                        singTogetherSession.f437192m = aio_media_rsplatestplayingstate.enum_user_state.get();
                        if (!aio_media_rsplatestplayingstate.uint64_create_uin.has()) {
                            obj = "";
                        } else {
                            obj = Long.valueOf(aio_media_rsplatestplayingstate.uint64_create_uin.get());
                        }
                        singTogetherSession.C = String.valueOf(obj);
                        singTogetherSession.E = aio_media_resultinfo.uint64_svr_time.get();
                        singTogetherSession.I = aio_media_rsplatestplayingstate.uint64_aio_identification.get();
                        sb5.append(" status=");
                        sb5.append(singTogetherSession.f437191i);
                        sb5.append(" userState=");
                        sb5.append(singTogetherSession.f437192m);
                        sb5.append(" creator=");
                        sb5.append(singTogetherSession.C);
                        sb5.append(" timeStamp=");
                        sb5.append(singTogetherSession.E);
                        if (aio_media_rsplatestplayingstate.msg_ksing_info.has()) {
                            singTogetherSession.P = aio_media_rsplatestplayingstate.msg_ksing_info.uint32_type.get();
                            singTogetherSession.M = aio_media_rsplatestplayingstate.msg_ksing_info.uint64_id.get();
                            singTogetherSession.N = aio_media_rsplatestplayingstate.msg_ksing_info.bytes_name.get().toStringUtf8();
                            singTogetherSession.Q = aio_media_rsplatestplayingstate.msg_ksing_info.bytes_jump.get().toStringUtf8();
                            singTogetherSession.R = aio_media_rsplatestplayingstate.msg_ksing_info.bytes_cover.get().toStringUtf8();
                            singTogetherSession.T = aio_media_rsplatestplayingstate.msg_ksing_info.bytes_song.get().toStringUtf8();
                            singTogetherSession.S = aio_media_rsplatestplayingstate.msg_ksing_info.uint64_singer.get();
                            sb5.append(" roomType=");
                            sb5.append(singTogetherSession.P);
                            sb5.append(" roomId=");
                            sb5.append(singTogetherSession.M);
                            sb5.append(" roomName=");
                            sb5.append(singTogetherSession.N);
                            sb5.append(" jumpUrl=");
                            sb5.append(singTogetherSession.Q);
                            sb5.append(" roomCover=");
                            sb5.append(singTogetherSession.R);
                            sb5.append(" songName=");
                            sb5.append(singTogetherSession.T);
                            sb5.append(" singerUin=");
                            sb5.append(singTogetherSession.S);
                        }
                        if (i3 == 1) {
                            singTogetherSession.f437190h = aio_media_rsplatestplayingstate.uint32_joined_num.get();
                            sb5.append(" joinNum=");
                            sb5.append(singTogetherSession.f437190h);
                        } else {
                            if (aio_media_rsplatestplayingstate.enum_c2c_join_state.has()) {
                                i17 = aio_media_rsplatestplayingstate.enum_c2c_join_state.get();
                            } else {
                                i17 = singTogetherSession.L;
                            }
                            singTogetherSession.L = i17;
                            sb5.append(" c2cStatus=");
                            sb5.append(singTogetherSession.L);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("SingTogetherParser", 2, sb5.toString());
                        }
                    } catch (Exception e16) {
                        e = e16;
                        z17 = true;
                        QLog.d("SingTogetherParser", 1, "handleGetSingPlayingState exception", e);
                        if (!TextUtils.isEmpty(singTogetherSession.C)) {
                        }
                        g(z17, singTogetherSession, i16, str2);
                        if (!QLog.isColorLevel()) {
                        }
                    }
                } else {
                    if (aio_media_resultinfo != null && aio_media_resultinfo.bytes_errmsg.get() != null) {
                        str2 = aio_media_resultinfo.bytes_errmsg.get().toStringUtf8();
                    }
                    QLog.d("SingTogetherParser", 1, String.format("handleGetSingPlayingState, result = %s, errTips = %s", Integer.valueOf(i18), str2));
                    z16 = false;
                }
                z17 = z16;
            } catch (Exception e17) {
                e = e17;
            }
            if (!TextUtils.isEmpty(singTogetherSession.C)) {
                if (singTogetherSession.f437188e == 2) {
                    ac.E(this.f238442a, singTogetherSession.C);
                } else {
                    ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(singTogetherSession.f437189f, singTogetherSession.C, "SingTogetherParser", null);
                }
            }
        }
        g(z17, singTogetherSession, i16, str2);
        if (!QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "handleGetSingPlayingState, isSuccess=" + z17 + ", session= " + singTogetherSession + ", by=" + i16);
        }
    }

    @Override // tr2.e
    public void f(String str, int i3) {
        f s16 = ((tr2.b) this.f238442a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).s(4, 1, str);
        if (s16 instanceof SingTogetherSession) {
            s16.f437191i = 3;
            s16.f437192m = 3;
            g.l(this.f238442a, s16.f437189f, false, s16.f437188e, 16777216);
            g(true, (SingTogetherSession) s16, 1007, "");
        }
    }

    public void g(boolean z16, SingTogetherSession singTogetherSession, int i3, String str) {
        tr2.b bVar = (tr2.b) this.f238442a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        b.g o16 = bVar.o(4, singTogetherSession.f437188e, singTogetherSession.f437189f, i3);
        if (z16 && i3 == 1003) {
            int i16 = o16.f437165a.getInt("action_type");
            String string = o16.f437165a.getString("tips");
            long j3 = o16.f437165a.getLong("seq");
            long j16 = o16.f437165a.getLong("msgSeq");
            bVar.j(singTogetherSession, i16, string, j3, j16, o16.f437166b);
            bVar.l(singTogetherSession, i16, string, j3, j16, o16.f437166b);
        }
        if (singTogetherSession.f437191i == 3) {
            g.l(this.f238442a, singTogetherSession.f437189f, false, singTogetherSession.f437188e, 16777216);
        } else {
            g.l(this.f238442a, singTogetherSession.f437189f, true, singTogetherSession.f437188e, 16777216);
        }
        bVar.k(z16, singTogetherSession, i3, str);
        bVar.K(4, singTogetherSession.f437188e, singTogetherSession.f437189f, i3);
    }

    public void h(QQAppInterface qQAppInterface, SingTogetherSession singTogetherSession, int i3, long j3, String str, long j16, long j17, TroopTips0x857$SingChangePushInfo troopTips0x857$SingChangePushInfo) {
        Friends u16;
        if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "handleSingTogetherPush");
        }
        tr2.b bVar = (tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        bVar.T(4, singTogetherSession.f437188e, singTogetherSession.f437189f, j16);
        SingTogetherSession singTogetherSession2 = (SingTogetherSession) bVar.s(singTogetherSession.f437187d, singTogetherSession.f437188e, singTogetherSession.f437189f);
        if (singTogetherSession2 != null) {
            if (i3 == 1 || i3 == 3 || i3 == 4) {
                singTogetherSession2.f437190h = singTogetherSession.f437190h;
            }
            if (i3 == 1 && !TextUtils.isEmpty(singTogetherSession.C)) {
                singTogetherSession2.C = singTogetherSession.C;
            }
            if (i3 == 1 || i3 == 3 || i3 == 4) {
                singTogetherSession2.L = singTogetherSession.L;
            }
        } else {
            bVar.c(singTogetherSession.f437187d, singTogetherSession.f437188e, singTogetherSession.f437189f, singTogetherSession);
            singTogetherSession2 = singTogetherSession;
        }
        if (i3 == 1) {
            g.l(qQAppInterface, singTogetherSession2.f437189f, true, singTogetherSession2.f437188e, 16777216);
        } else if (i3 == 2) {
            singTogetherSession2.f437191i = 3;
            singTogetherSession2.f437192m = 3;
            g.l(qQAppInterface, singTogetherSession2.f437189f, false, singTogetherSession2.f437188e, 16777216);
        } else if (qQAppInterface.getCurrentAccountUin().equals(String.valueOf(j3)) && (i3 == 3 || i3 == 4 || i3 == 5)) {
            g.l(qQAppInterface, singTogetherSession2.f437189f, true, singTogetherSession2.f437188e, 16777216);
        }
        if ((singTogetherSession2.f437188e != 2 || ((u16 = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).u(singTogetherSession2.f437189f)) != null && u16.isFriend())) && !TextUtils.isEmpty(singTogetherSession2.f437189f)) {
            b.g o16 = bVar.o(4, singTogetherSession2.f437188e, singTogetherSession2.f437189f, 1003);
            o16.f437165a.putInt("action_type", i3);
            o16.f437165a.putString("tips", str);
            o16.f437165a.putLong("seq", j16);
            o16.f437165a.putLong("msgSeq", j17);
            o16.f437166b = troopTips0x857$SingChangePushInfo;
            if (!qQAppInterface.getCurrentAccountUin().equals(String.valueOf(j3)) && (i3 == 2 || i3 == 4 || i3 == 3)) {
                g(true, singTogetherSession2, 1003, "");
            } else {
                bVar.I(4, singTogetherSession2.f437188e, singTogetherSession2.f437189f, 1003);
            }
        }
    }
}
