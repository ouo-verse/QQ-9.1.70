package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.s;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.cj;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$MsgBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class r extends com.tencent.mobileqq.troop.api.config.p {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Comparator<String> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            return Long.compare(Long.parseLong(str), Long.parseLong(str2));
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class b implements s.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QQAppInterface> f186616a;

        /* renamed from: b, reason: collision with root package name */
        private final com.tencent.mobileqq.troop.unreadmsg.a f186617b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f186618c;

        b(QQAppInterface qQAppInterface, com.tencent.mobileqq.troop.unreadmsg.a aVar, long[] jArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, aVar, jArr);
                return;
            }
            this.f186616a = new WeakReference<>(qQAppInterface);
            this.f186617b = aVar;
            this.f186618c = jArr;
        }

        @Override // com.tencent.av.utils.s.d
        public void a(int i3, s.f fVar, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), fVar, Integer.valueOf(i16));
                return;
            }
            QQAppInterface qQAppInterface = this.f186616a.get();
            if (qQAppInterface != null) {
                if (i3 == 0) {
                    cj gAudioHandler = qQAppInterface.getGAudioHandler();
                    com.tencent.mobileqq.troop.unreadmsg.a aVar = this.f186617b;
                    gAudioHandler.r(1, aVar.f301845b, aVar.f301847d, this.f186618c, 2, 0, 0, -1);
                    return;
                }
                return;
            }
            QLog.e("TroopOnlinePushProcessor", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference null");
        }
    }

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void h(QQAppInterface qQAppInterface, long[] jArr, int i3, int i16, int i17, submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum subCmd0x1UpdateAppUnreadNum, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        long j3;
        if (!subCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has()) {
            return;
        }
        submsgtype0x26$AppTipNotify submsgtype0x26_apptipnotify = subCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.get();
        if (!submsgtype0x26_apptipnotify.uint32_action.has()) {
            return;
        }
        long b16 = bv.b(aVar.f301845b, 0L);
        if (jArr != null && jArr.length > 0) {
            j3 = jArr[0];
        } else {
            j3 = 0;
        }
        if (b16 > 0 && j3 > 0) {
            if (submsgtype0x26_apptipnotify.uint32_action.get() == 100) {
                boolean equals = TextUtils.equals(qQAppInterface.getCurrentAccountUin(), String.valueOf(j3));
                VideoMsgTools.m(qQAppInterface, 1, 13, false, aVar.f301845b, Long.toString(j3), equals, null, equals, 2, new Object[0]);
                i(qQAppInterface, jArr, i3, i16, i17, j3, b16);
                QLog.i("TroopOnlinePushProcessor", 1, "handle begin group video sync push");
                return;
            }
            if (submsgtype0x26_apptipnotify.uint32_action.get() == 101) {
                VideoMsgTools.m(qQAppInterface, 1, 14, false, aVar.f301845b, qQAppInterface.getCurrentAccountUin(), false, null, false, 2, new Object[0]);
                QLog.i("TroopOnlinePushProcessor", 1, "handle end group video sync push");
            }
        }
    }

    private void i(QQAppInterface qQAppInterface, long[] jArr, int i3, int i16, int i17, long j3, long j16) {
        AVNotifyCenter aVNotifyCenter = qQAppInterface.getAVNotifyCenter();
        if (aVNotifyCenter != null) {
            aVNotifyCenter.X0(j16, true);
            aVNotifyCenter.a1(8, j16, 2, i3, i16, i17, 20, 1);
            aVNotifyCenter.I0(6, 1, j16, jArr, 1L);
            aVNotifyCenter.B0(10, j16, 2);
            AVNotifyCenter.i Q = aVNotifyCenter.Q(j16, 2);
            if (Q != null) {
                Q.f73814h = true;
            }
            aVNotifyCenter.m0(21, 1, j16, j3);
        }
    }

    private void j(QQAppInterface qQAppInterface, long[] jArr, int i3, int i16, int i17, submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum subCmd0x1UpdateAppUnreadNum, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        long j3;
        long j16;
        if (subCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has()) {
            submsgtype0x26$AppTipNotify submsgtype0x26_apptipnotify = subCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.get();
            if (submsgtype0x26_apptipnotify.uint32_action.has() && submsgtype0x26_apptipnotify.uint32_action.get() == 1) {
                try {
                    j3 = Long.parseLong(aVar.f301845b);
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                    j3 = 0;
                }
                if (jArr != null && jArr.length > 0) {
                    j16 = jArr[0];
                } else {
                    j16 = 0;
                }
                if (j3 > 0 && j16 > 0) {
                    AVNotifyCenter aVNotifyCenter = qQAppInterface.getAVNotifyCenter();
                    if (aVNotifyCenter != null) {
                        long j17 = j3;
                        aVNotifyCenter.a1(8, j3, 2, i3, i16, i17, 20, 1);
                        aVNotifyCenter.X0(j17, true);
                        aVNotifyCenter.m0(21, 1, j17, 0L);
                    }
                    VideoMsgTools.m(qQAppInterface, 1, 13, false, aVar.f301845b, Long.toString(j16), TextUtils.equals(qQAppInterface.getCurrentAccountUin(), String.valueOf(j16)), null, TextUtils.equals(qQAppInterface.getCurrentAccountUin(), String.valueOf(j16)), 2, new Object[0]);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.p
    protected void a(@NonNull AppInterface appInterface, @NonNull String str, @NonNull String str2, @NonNull TroopInfo troopInfo, @NonNull ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appInterface, str, str2, troopInfo, arrayList);
            return;
        }
        if (arrayList.size() <= 9 && !arrayList.contains(str2)) {
            arrayList.add(str2);
            Collections.sort(arrayList, new a());
            String A = GroupIconHelper.A(GroupIconHelper.I(arrayList, troopInfo), false);
            troopInfo.updateHeadMemberList(A);
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateHeaderUinNew(troopInfo.troopuin, A, "TroopOnlinePushProcessor");
            GroupIconHelper groupIconHelper = ((ITroopAvatarService) appInterface.getRuntimeService(ITroopAvatarService.class, "")).getGroupIconHelper();
            if (groupIconHelper != null) {
                groupIconHelper.P(str);
            }
            QLog.d("TroopOnlinePushProcessor", 2, "onHandleMemberAdd");
            AvatarInfoCheck.b(4, str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.p
    protected void b(@NonNull AppInterface appInterface, @NonNull String str, @NonNull String str2, TroopInfo troopInfo) {
        ArrayList<String> troopMemberForTroopHead;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, appInterface, str, str2, troopInfo);
            return;
        }
        if (troopInfo != null && !troopInfo.hasSetTroopHead() && (troopMemberForTroopHead = ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopMemberForTroopHead(str)) != null && troopMemberForTroopHead.contains(str2)) {
            troopMemberForTroopHead.remove(str2);
            String A = GroupIconHelper.A(GroupIconHelper.I(troopMemberForTroopHead, troopInfo), false);
            troopInfo.extDBInfo.headerUinsNew = A;
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateHeaderUinNew(troopInfo.troopuin, A, "TroopOnlinePushProcessor");
            ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchNewTroopHeadUinList(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.p
    protected void c(String str, List<String> list, List<String> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, list, list2);
            return;
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str);
        if (troopInfoFromCache != null && troopInfoFromCache.isNewTroop && !troopInfoFromCache.hasSetTroopHead()) {
            ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchNewTroopHeadUinList(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.p
    public void d(@NonNull AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.p
    public void e(@NonNull AppInterface appInterface, com.tencent.mobileqq.troop.unreadmsg.a aVar, submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum subCmd0x1UpdateAppUnreadNum, long[] jArr, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInterface, aVar, subCmd0x1UpdateAppUnreadNum, jArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (appInterface instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            long j3 = aVar.f301844a;
            if (j3 == 21) {
                com.tencent.av.utils.s.g().j(qQAppInterface, aVar.f301845b, new b(qQAppInterface, aVar, jArr));
                return;
            }
            if (j3 == 23) {
                j(qQAppInterface, jArr, i3, i16, i17, subCmd0x1UpdateAppUnreadNum, aVar);
                ((com.tencent.mobileqq.intervideo.groupvideo.h) qQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).g(aVar.f301845b, 1);
                qQAppInterface.getGAudioHandler().r(1, aVar.f301845b, aVar.f301847d, jArr, 14, i3, i16, i17);
                h(qQAppInterface, jArr, i3, i16, i17, subCmd0x1UpdateAppUnreadNum, aVar);
                return;
            }
            if (j3 == 1104651886) {
                qQAppInterface.getGAudioHandler().r(1, aVar.f301845b, aVar.f301847d, jArr, 10, i3, i16, i17);
                return;
            }
            if (j3 == 1102858908) {
                int i18 = aVar.f301847d;
                if (i18 == -1 || i18 > 0) {
                    ChatActivityUtils.V(qQAppInterface, aVar.f301845b, -1);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.p
    public void f(@NonNull AppInterface appInterface, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        ITroopBatchAddFriendService iTroopBatchAddFriendService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, (Object) aVar);
            return;
        }
        if (appInterface instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            long j3 = aVar.f301844a;
            if (j3 == 101509131) {
                if (aVar.f301847d > 0 && (iTroopBatchAddFriendService = (ITroopBatchAddFriendService) qQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")) != null) {
                    iTroopBatchAddFriendService.getTroopBatchAddFriendMgr().I(aVar.f301845b);
                    return;
                }
                return;
            }
            if (j3 == 101796525) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopOnlinePushProcessor", 2, "handleTroopNewsOnlinePush() for watching together.");
                }
                ((tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).x(aVar.f301845b, aVar.f301847d, aVar.f301846c, aVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.p
    public void g(@NonNull AppInterface appInterface, com.tencent.mobileqq.troop.entereffect.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) fVar);
        } else if (appInterface instanceof QQAppInterface) {
            ac.s((QQAppInterface) appInterface, fVar.f295259b, fVar.f295260c, 1, 0);
        }
    }
}
