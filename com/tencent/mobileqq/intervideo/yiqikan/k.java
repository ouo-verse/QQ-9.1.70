package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tencent.aio.media.aio_media$ResultInfo;
import tencent.aio.media.aio_media$RspLatestPlayingState;
import tencent.im.oidb.cmd0x857.TroopTips0x857$VideoChangePushInfo;
import tr2.b;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k implements tr2.e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f238521a;

    public k(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f238521a = qQAppInterface;
        }
    }

    public static void j(QQAppInterface qQAppInterface, long j3, int i3, String str, int i16, long j16, long j17, int i17) {
        k(qQAppInterface, j3, i3, str, i16, j16, j17, i17, -1, -1);
    }

    public static void k(QQAppInterface qQAppInterface, long j3, int i3, String str, int i16, long j16, long j17, int i17, int i18, int i19) {
        if (QLog.isColorLevel()) {
            QLog.i("WatchTogetherParser", 2, "insertGrayTips begin uin:" + j3 + " uinType:" + i3 + " grayTips:" + str + " sub_type:" + i16 + " msgSeq:" + j16 + " msgTime:" + j17 + " grayId=" + i17);
        }
        if (TextUtils.isEmpty(str) || j3 <= 0) {
            return;
        }
        int i26 = (i16 == 2 || i16 == 5 || i16 == 3) ? MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL : MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI;
        String valueOf = String.valueOf(j3);
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(valueOf, valueOf, str, i3, i26, i17, com.tencent.mobileqq.service.message.e.K0());
        if (i18 >= 0 && i19 > 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_action", 60);
            bundle.putString("textColor", "");
            bundle.putString("image_resource", null);
            bundle.putString("key_action_DATA", j3 + "_" + i3);
            gVar.b(i18, i18 + i19, bundle);
        }
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.hasRead = 0;
        messageForUniteGrayTip.subType = i16;
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        messageForUniteGrayTip.tipParam.f213693p = j3 + "_" + i3 + "_watch_together_" + j16 + "_" + j17;
        boolean a16 = com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip);
        if (QLog.isColorLevel()) {
            QLog.i("WatchTogetherParser", 2, "insertGrayTips end  res:" + a16 + " grayTipKey:" + messageForUniteGrayTip.tipParam.f213693p);
        }
    }

    private void l(final QQAppInterface qQAppInterface, final long j3, final int i3, final long j16, final long j17, final boolean z16, final long j18) {
        if (i3 == 3 && j18 > 0 && j3 > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("WatchTogetherParser", 2, "insertGrayTipsWhenOthersJoin  uin:", Long.valueOf(j3), " isJoin=", Boolean.valueOf(z16), " operUin=", Long.valueOf(j18));
            }
            if (j18 == qQAppInterface.getLongAccountUin()) {
                if (QLog.isColorLevel()) {
                    QLog.d("WatchTogetherParser", 2, "insertGrayTipsWhenOthersJoin is curAccountUin:", Long.valueOf(j3));
                    return;
                }
                return;
            }
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(String.valueOf(j3), String.valueOf(j18), "WatchTogetherParser", new Function1() { // from class: com.tencent.mobileqq.intervideo.yiqikan.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit m3;
                    m3 = k.m(j18, qQAppInterface, z16, j3, i3, j16, j17, (TroopMemberNickInfo) obj);
                    return m3;
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WatchTogetherParser", 2, "insertGrayTipsWhenOthersJoin  uin:", Long.valueOf(j3), " actionType=", Integer.valueOf(i3), " operUin=", Long.valueOf(j18));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit m(long j3, QQAppInterface qQAppInterface, boolean z16, long j16, int i3, long j17, long j18, TroopMemberNickInfo troopMemberNickInfo) {
        String valueOf;
        if (troopMemberNickInfo != null) {
            valueOf = troopMemberNickInfo.getShowName();
        } else {
            valueOf = String.valueOf(j3);
        }
        String format = String.format(qQAppInterface.getApp().getString(R.string.f20563565), valueOf);
        if (z16) {
            j(qQAppInterface, j16, 1, format, i3, j17, j18, 131092);
            return null;
        }
        String string = qQAppInterface.getApp().getString(R.string.f20562564);
        k(qQAppInterface, j16, 1, format + string, i3, j17, j18, 131092, format.length(), string.length());
        return null;
    }

    @Override // tr2.e
    public void a(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        tr2.f s16 = ((tr2.b) this.f238521a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).s(2, 1, str);
        if (s16 instanceof WatchTogetherSession) {
            s16.f437191i = 3;
            s16.f437192m = 3;
            tr2.g.m(this.f238521a, str, false);
            h(true, (WatchTogetherSession) s16, 1007, "");
        }
    }

    @Override // tr2.e
    public void b(QQAppInterface qQAppInterface, long j3, long j16, Object obj) {
        long j17;
        int i3;
        long j18;
        long j19;
        boolean z16;
        String str;
        int i16;
        int i17;
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, Long.valueOf(j3), Long.valueOf(j16), obj);
            return;
        }
        if (!(obj instanceof TroopTips0x857$VideoChangePushInfo)) {
            if (QLog.isColorLevel()) {
                QLog.d("WatchTogetherParser", 2, "handleBusinessTogetherGroupPush, object is error");
                return;
            }
            return;
        }
        TroopTips0x857$VideoChangePushInfo troopTips0x857$VideoChangePushInfo = (TroopTips0x857$VideoChangePushInfo) obj;
        if (troopTips0x857$VideoChangePushInfo != null) {
            if (troopTips0x857$VideoChangePushInfo.uint64_seq.has()) {
                j17 = troopTips0x857$VideoChangePushInfo.uint64_seq.get();
            } else {
                j17 = -1;
            }
            int i18 = -1;
            if (troopTips0x857$VideoChangePushInfo.uint32_action_type.has()) {
                i3 = troopTips0x857$VideoChangePushInfo.uint32_action_type.get();
            } else {
                i3 = -1;
            }
            if (troopTips0x857$VideoChangePushInfo.uint64_group_id.has()) {
                j18 = troopTips0x857$VideoChangePushInfo.uint64_group_id.get();
            } else {
                j18 = -1;
            }
            if (troopTips0x857$VideoChangePushInfo.uint64_oper_uin.has()) {
                j19 = troopTips0x857$VideoChangePushInfo.uint64_oper_uin.get();
            } else {
                j19 = -1;
            }
            if (troopTips0x857$VideoChangePushInfo.uint32_join_nums.has()) {
                i18 = troopTips0x857$VideoChangePushInfo.uint32_join_nums.get();
            }
            if (troopTips0x857$VideoChangePushInfo.uint32_join_state.has() && troopTips0x857$VideoChangePushInfo.uint32_join_state.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (troopTips0x857$VideoChangePushInfo.bytes_gray_tips.has()) {
                str = troopTips0x857$VideoChangePushInfo.bytes_gray_tips.get().toStringUtf8();
            } else {
                str = null;
            }
            if (QLog.isColorLevel()) {
                i16 = 2;
                QLog.d("WatchTogetherParser", 2, "handleWatchTogetherGroupPush, seq=" + j17 + ", actionType=" + i3 + ", groupid=" + j18 + ", uin=" + j19 + ", joinNum=" + i18 + ", tips=" + str, " hasJoin=", Boolean.valueOf(z16));
            } else {
                i16 = 2;
            }
            long r16 = ((tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).r(i16, 1, j18);
            if (j17 < r16) {
                if (QLog.isColorLevel()) {
                    QLog.d("WatchTogetherParser", i16, "handleWatchTogetherGroupPush, skip pushinfo, old seq=" + r16);
                    return;
                }
                return;
            }
            WatchTogetherSession watchTogetherSession = (WatchTogetherSession) tr2.g.a(i16, 1, String.valueOf(j18));
            if (i3 == 1) {
                if (j19 == -1) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(j19);
                }
                watchTogetherSession.C = valueOf;
            }
            if (i3 == 1 || i3 == 3 || i3 == 4) {
                watchTogetherSession.f437190h = i18;
            }
            String str2 = str;
            long j26 = j19;
            int i19 = i3;
            i(qQAppInterface, watchTogetherSession, i3, j26, str2, j17, j3, troopTips0x857$VideoChangePushInfo);
            if ((i19 == 5 || i19 == 2) && !TextUtils.isEmpty(str2) && j18 != -1) {
                if (i19 == 5) {
                    i17 = 131085;
                } else {
                    i17 = 131084;
                }
                j(qQAppInterface, j18, 1, str2, i19, j3, j16, i17);
            }
            l(qQAppInterface, j18, i19, j3, j16, z16, j26);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WatchTogetherParser", 2, "handleWatchTogetherGroupPush, pushinfo is null.");
        }
    }

    @Override // tr2.e
    public void c(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, obj);
        }
    }

    @Override // tr2.e
    public void d(QQAppInterface qQAppInterface, byte[] bArr, long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, bArr, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0174  */
    @Override // tr2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(ToServiceMsg toServiceMsg, aio_media$RspLatestPlayingState aio_media_rsplatestplayingstate) {
        int i3;
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) aio_media_rsplatestplayingstate);
            return;
        }
        int i17 = -1;
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
                QLog.d("WatchTogetherParser", 2, "handleGetWatchPlayingState, req == null || resp == null || data == null");
                return;
            }
            return;
        }
        if (i3 == 2) {
            return;
        }
        tr2.b bVar = (tr2.b) this.f238521a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        boolean z16 = true;
        WatchTogetherSession watchTogetherSession = (WatchTogetherSession) bVar.s(2, 1, str);
        if (watchTogetherSession == null) {
            watchTogetherSession = (WatchTogetherSession) tr2.g.a(2, 1, str);
            bVar.c(2, 1, str, watchTogetherSession);
        }
        boolean z17 = false;
        if (watchTogetherSession.a()) {
            try {
                aio_media$ResultInfo aio_media_resultinfo = aio_media_rsplatestplayingstate.msg_result.get();
                if (aio_media_resultinfo != null) {
                    i17 = aio_media_resultinfo.uint32_result.get();
                }
                if (i17 == 0) {
                    try {
                        watchTogetherSession.f437191i = aio_media_rsplatestplayingstate.enum_aio_state.get();
                        watchTogetherSession.f437192m = aio_media_rsplatestplayingstate.enum_user_state.get();
                        watchTogetherSession.C = String.valueOf(aio_media_rsplatestplayingstate.uint64_create_uin.get());
                        watchTogetherSession.f437190h = aio_media_rsplatestplayingstate.uint32_joined_num.get();
                        watchTogetherSession.E = aio_media_resultinfo.uint64_svr_time.get();
                        watchTogetherSession.J = watchTogetherSession.I;
                        long j3 = aio_media_rsplatestplayingstate.uint64_aio_identification.get();
                        watchTogetherSession.I = j3;
                        if (j3 != watchTogetherSession.J) {
                            watchTogetherSession.K = 0;
                        }
                        if (watchTogetherSession.f437192m == 2 && watchTogetherSession.f437191i == 1) {
                            watchTogetherSession.K = 1;
                        }
                        if (aio_media_rsplatestplayingstate.msg_room_info.has()) {
                            watchTogetherSession.L = aio_media_rsplatestplayingstate.msg_room_info.uint32_type.get();
                            watchTogetherSession.N = aio_media_rsplatestplayingstate.msg_room_info.uint64_id.get();
                            watchTogetherSession.P = aio_media_rsplatestplayingstate.msg_room_info.bytes_name.get().toStringUtf8();
                            watchTogetherSession.M = aio_media_rsplatestplayingstate.msg_room_info.bytes_jump.get().toStringUtf8();
                            watchTogetherSession.Q = aio_media_rsplatestplayingstate.msg_room_info.bytes_cover.get().toStringUtf8();
                            watchTogetherSession.F = aio_media_rsplatestplayingstate.msg_room_info.enum_video_type.get();
                            watchTogetherSession.G = aio_media_rsplatestplayingstate.msg_room_info.enum_video_jump_type.get();
                            watchTogetherSession.H = aio_media_rsplatestplayingstate.msg_room_info.bytes_video_jump_value.get().toStringUtf8();
                        }
                    } catch (Exception e16) {
                        e = e16;
                        z17 = true;
                        QLog.d("WatchTogetherParser", 1, "handleGetWatchPlayingState exception", e);
                        if (!TextUtils.isEmpty(watchTogetherSession.C)) {
                        }
                        h(z17, watchTogetherSession, i16, str2);
                        if (!QLog.isColorLevel()) {
                        }
                    }
                } else {
                    if (aio_media_resultinfo != null && aio_media_resultinfo.bytes_errmsg.get() != null) {
                        str2 = aio_media_resultinfo.bytes_errmsg.get().toStringUtf8();
                    }
                    QLog.d("WatchTogetherParser", 1, String.format("handleGetWatchPlayingState, result = %s, errTips = %s", Integer.valueOf(i17), str2));
                    z16 = false;
                }
                z17 = z16;
            } catch (Exception e17) {
                e = e17;
            }
            if (!TextUtils.isEmpty(watchTogetherSession.C)) {
                ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(watchTogetherSession.f437189f, watchTogetherSession.C, "WatchTogetherParser", null);
            }
        }
        h(z17, watchTogetherSession, i16, str2);
        if (!QLog.isColorLevel()) {
            QLog.d("WatchTogetherParser", 2, "handleGetWatchPlayingState, isSuccess=" + z17 + ", session= " + watchTogetherSession + ", by=" + i16);
        }
    }

    @Override // tr2.e
    public void f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
            return;
        }
        tr2.f s16 = ((tr2.b) this.f238521a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).s(2, 1, str);
        if (s16 instanceof WatchTogetherSession) {
            s16.f437191i = 3;
            s16.f437192m = 3;
            tr2.g.m(this.f238521a, str, false);
            h(true, (WatchTogetherSession) s16, 1007, "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v2 */
    public void h(boolean z16, WatchTogetherSession watchTogetherSession, int i3, String str) {
        tr2.b bVar;
        boolean z17;
        ?? r56;
        int i16;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), watchTogetherSession, Integer.valueOf(i3), str);
            return;
        }
        tr2.b bVar2 = (tr2.b) this.f238521a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        b.g o16 = bVar2.o(2, 1, watchTogetherSession.f437189f, i3);
        if (z16 && i3 == 1003 && (o16.f437166b instanceof TroopTips0x857$VideoChangePushInfo)) {
            int i17 = o16.f437165a.getInt("action_type");
            String string = o16.f437165a.getString("tips");
            long j3 = o16.f437165a.getLong("seq");
            long j16 = o16.f437165a.getLong("msgSeq");
            bVar = bVar2;
            bVar2.j(watchTogetherSession, i17, string, j3, j16, (TroopTips0x857$VideoChangePushInfo) o16.f437166b);
            bVar.l(watchTogetherSession, i17, string, j3, j16, (TroopTips0x857$VideoChangePushInfo) o16.f437166b);
        } else {
            bVar = bVar2;
        }
        if (watchTogetherSession.f437191i == 3) {
            z17 = false;
            tr2.g.m(this.f238521a, watchTogetherSession.f437189f, false);
            r56 = 1;
        } else {
            z17 = false;
            r56 = 1;
            tr2.g.m(this.f238521a, watchTogetherSession.f437189f, true);
        }
        if (watchTogetherSession.f437191i == r56 && watchTogetherSession.f437192m == 2) {
            int i18 = watchTogetherSession.L;
            if (i18 != r56 && i18 != 0) {
                z18 = r56;
            } else {
                z18 = z17;
            }
            if (!TextUtils.isEmpty(watchTogetherSession.M) && !TextUtils.isEmpty(watchTogetherSession.H)) {
                z19 = r56;
            } else {
                z19 = z17;
            }
            if (z18 && z19 && f.h(watchTogetherSession.f437187d, watchTogetherSession.f437189f, watchTogetherSession.f437188e)) {
                if (QLog.isColorLevel()) {
                    QLog.d("WatchTogetherParser", (int) r56, "isSameFloatingInfo");
                }
                WatchTogetherFloatingData watchTogetherFloatingData = new WatchTogetherFloatingData();
                watchTogetherFloatingData.setCurUin(watchTogetherSession.f437189f);
                watchTogetherFloatingData.setCurType(watchTogetherSession.f437188e);
                watchTogetherFloatingData.setSmallUrl(watchTogetherSession.M);
                watchTogetherFloatingData.setBigUrl(watchTogetherSession.H);
                if (!((TroopManager) this.f238521a.getManager(QQManagerFactory.TROOP_MANAGER)).B(watchTogetherSession.f437189f).isOwnerOrAdmin() && !watchTogetherSession.C.equals(this.f238521a.getCurrentUin())) {
                    watchTogetherFloatingData.setIsAdm(z17);
                } else {
                    watchTogetherFloatingData.setIsAdm(r56);
                }
                f.l(BaseApplication.context, watchTogetherFloatingData);
            } else if (f.h(watchTogetherSession.f437187d, watchTogetherSession.f437189f, watchTogetherSession.f437188e)) {
                if (QLog.isColorLevel()) {
                    QLog.d("WatchTogetherParser", (int) r56, "isSameFloatingInfo but param error isSupportRoomType=" + z18 + " isUrlValid=" + z19);
                }
                f.k(z17, watchTogetherSession.f437189f, watchTogetherSession.f437188e, z17);
            }
        }
        if (watchTogetherSession.f437191i == 3 || (i16 = watchTogetherSession.f437192m) == r56 || i16 == 3) {
            if (QLog.isColorLevel()) {
                QLog.d("WatchTogetherParser", (int) r56, "session.state=" + watchTogetherSession.f437191i + " session.userState=" + watchTogetherSession.f437192m + " uin=" + watchTogetherSession.f437189f + " type=" + watchTogetherSession.f437188e);
            }
            WatchTogetherFloatingData watchTogetherFloatingData2 = new WatchTogetherFloatingData();
            watchTogetherFloatingData2.setCurUin(watchTogetherSession.f437189f);
            watchTogetherFloatingData2.setCurType(watchTogetherSession.f437188e);
            f.b(BaseApplication.context, watchTogetherFloatingData2);
        }
        tr2.b bVar3 = bVar;
        bVar3.k(z16, watchTogetherSession, i3, str);
        bVar3.K(2, r56, watchTogetherSession.f437189f, i3);
    }

    public void i(QQAppInterface qQAppInterface, WatchTogetherSession watchTogetherSession, int i3, long j3, String str, long j16, long j17, TroopTips0x857$VideoChangePushInfo troopTips0x857$VideoChangePushInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, qQAppInterface, watchTogetherSession, Integer.valueOf(i3), Long.valueOf(j3), str, Long.valueOf(j16), Long.valueOf(j17), troopTips0x857$VideoChangePushInfo);
            return;
        }
        tr2.b bVar = (tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        bVar.T(2, 1, watchTogetherSession.f437189f, j16);
        WatchTogetherSession watchTogetherSession2 = (WatchTogetherSession) bVar.s(watchTogetherSession.f437187d, watchTogetherSession.f437188e, watchTogetherSession.f437189f);
        if (watchTogetherSession2 != null) {
            if (i3 == 1 || i3 == 3 || i3 == 4) {
                watchTogetherSession2.f437190h = watchTogetherSession.f437190h;
            }
            if (i3 == 1 && !TextUtils.isEmpty(watchTogetherSession.C)) {
                watchTogetherSession2.C = watchTogetherSession.C;
            }
        } else {
            bVar.c(watchTogetherSession.f437187d, watchTogetherSession.f437188e, watchTogetherSession.f437189f, watchTogetherSession);
            watchTogetherSession2 = watchTogetherSession;
        }
        if (qQAppInterface.getCurrentAccountUin().equals(String.valueOf(j3))) {
            if (i3 != 3 && i3 != 1 && i3 != 4 && i3 != 5) {
                if (i3 == 2) {
                    tr2.g.m(qQAppInterface, watchTogetherSession2.f437189f, false);
                }
            } else {
                tr2.g.m(qQAppInterface, watchTogetherSession2.f437189f, true);
            }
        }
        if (!TextUtils.isEmpty(watchTogetherSession2.f437189f)) {
            b.g o16 = bVar.o(2, 1, watchTogetherSession2.f437189f, 1003);
            o16.f437165a.putInt("action_type", i3);
            o16.f437165a.putString("tips", str);
            o16.f437165a.putLong("seq", j16);
            o16.f437165a.putLong("msgSeq", j17);
            o16.f437166b = troopTips0x857$VideoChangePushInfo;
            bVar.I(2, 1, watchTogetherSession2.f437189f, 1003);
        }
    }
}
