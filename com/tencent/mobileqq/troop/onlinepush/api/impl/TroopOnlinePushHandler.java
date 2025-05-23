package com.tencent.mobileqq.troop.onlinepush.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.mobileqq.troop.api.config.ah;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.entereffect.f;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.homework.b;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.observer.i;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.troopreddot.handler.TroopRedDotHandler;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$AppNotifyContent;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$AppNotifyUser;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$MsgBody;
import tencent.qun.group_effect.push_msg$PushMsg;

/* loaded from: classes19.dex */
public class TroopOnlinePushHandler extends TroopBaseHandler implements com.tencent.mobileqq.troop.onlinepush.api.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    HashMap<String, Long> f298056e;

    /* loaded from: classes19.dex */
    private class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f298057a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f298058b;

        /* renamed from: c, reason: collision with root package name */
        private List<com.tencent.mobileqq.troop.unreadmsg.a> f298059c;

        /* renamed from: d, reason: collision with root package name */
        private com.tencent.mobileqq.troop.unreadmsg.a f298060d;

        /* renamed from: e, reason: collision with root package name */
        private int f298061e;

        /* renamed from: f, reason: collision with root package name */
        private StringBuilder f298062f;

        /* renamed from: g, reason: collision with root package name */
        private submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum f298063g;

        public a(boolean z16, List<com.tencent.mobileqq.troop.unreadmsg.a> list, com.tencent.mobileqq.troop.unreadmsg.a aVar, int i3, StringBuilder sb5, submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum subCmd0x1UpdateAppUnreadNum) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopOnlinePushHandler.this, Boolean.valueOf(z16), list, aVar, Integer.valueOf(i3), sb5, subCmd0x1UpdateAppUnreadNum);
                return;
            }
            this.f298058b = z16;
            this.f298059c = list;
            this.f298060d = aVar;
            this.f298061e = i3;
            this.f298062f = sb5;
            this.f298063g = subCmd0x1UpdateAppUnreadNum;
        }

        private void d() {
            if (QLog.isColorLevel()) {
                QLog.d(ITroopEnterEffectService.TAG, 2, "onLinePush receive 0x210_0x26_cmd0x1, [Enter Troop]");
            }
            if (this.f298063g.msg_app_tip_notify.has()) {
                submsgtype0x26$AppTipNotify submsgtype0x26_apptipnotify = this.f298063g.msg_app_tip_notify.get();
                push_msg$PushMsg push_msg_pushmsg = new push_msg$PushMsg();
                try {
                    push_msg_pushmsg.mergeFrom(submsgtype0x26_apptipnotify.bytes_text.get().toByteArray());
                    if (push_msg_pushmsg.f436068rc.get() == 0) {
                        TroopOnlinePushHandler.this.b3(new f(push_msg_pushmsg.effect_info.get().effect_id.get(), "" + push_msg_pushmsg.uin.get(), "" + push_msg_pushmsg.group_code.get(), push_msg_pushmsg.svip_level.get(), push_msg_pushmsg.svip_type.get(), push_msg_pushmsg.group_level.get(), push_msg_pushmsg.set_mode.get()));
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(ITroopEnterEffectService.TAG, 2, "onLinePush receive 0x210_0x8ca error: " + QLog.getStackTraceString(e16));
                    }
                }
            }
        }

        private void e() {
            AppInterface e16 = bg.e();
            if (e16 == null) {
                QLog.e(LogTag.TAG_TROOP_HOMEWORK_RANKID_UPDATE, 1, "failed to get app interface");
            } else {
                ((b) e16.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName())).w2(this.f298060d.f301845b, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
            }
        }

        private void f() {
            int i3 = this.f298060d.f301847d;
            if (i3 == -1 || i3 > 0) {
                this.f298058b = true;
            }
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "handleTroopNewsOnlinePush, troopUin=" + this.f298060d.f301845b + ", nNewNum=" + this.f298060d.f301847d);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00d7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void g() {
            long[] jArr;
            int i3;
            int i16;
            int i17;
            long j3;
            if (this.f298063g.msg_app_tip_notify.has()) {
                submsgtype0x26$AppTipNotify submsgtype0x26_apptipnotify = this.f298063g.msg_app_tip_notify.get();
                if (submsgtype0x26_apptipnotify.opt_msg_app_notify_content.has()) {
                    submsgtype0x26$AppNotifyContent submsgtype0x26_appnotifycontent = submsgtype0x26_apptipnotify.opt_msg_app_notify_content.get();
                    List<submsgtype0x26$AppNotifyUser> list = submsgtype0x26_appnotifycontent.opt_msg_app_notify_user.get();
                    jArr = new long[list.size()];
                    for (int i18 = 0; i18 < list.size(); i18++) {
                        jArr[i18] = list.get(i18).opt_uint64_uin.get();
                    }
                    int i19 = submsgtype0x26_appnotifycontent.room_mode.get();
                    int i26 = submsgtype0x26_appnotifycontent.game_id.get();
                    i3 = submsgtype0x26_appnotifycontent.live_extra_mode.get();
                    i16 = i19;
                    i17 = i26;
                    ah.a().g(((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime, this.f298060d, this.f298063g, jArr, i16, i17, i3);
                    j3 = this.f298060d.f301844a;
                    if (j3 != 2) {
                        ITroopSPUtilApi iTroopSPUtilApi = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
                        String currentAccountUin = ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime.getCurrentAccountUin();
                        com.tencent.mobileqq.troop.unreadmsg.a aVar = this.f298060d;
                        iTroopSPUtilApi.setGroupGroupNewsInfo(currentAccountUin, ITroopSPUtilApi.KEY_ALBUM_NEW_PHOTOES, aVar.f301845b, aVar.f301847d);
                        IRedPointUtilsApi iRedPointUtilsApi = (IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class);
                        AppInterface appInterface = ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime;
                        com.tencent.mobileqq.troop.unreadmsg.a aVar2 = this.f298060d;
                        iRedPointUtilsApi.updateRedPointInfo(appInterface, aVar2.f301845b, "troop", 2, aVar2.f301847d);
                        ITroopSPUtilApi iTroopSPUtilApi2 = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
                        String currentAccountUin2 = ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime.getCurrentAccountUin();
                        com.tencent.mobileqq.troop.unreadmsg.a aVar3 = this.f298060d;
                        iTroopSPUtilApi2.setGroupGroupNewsInfo(currentAccountUin2, ITroopSPUtilApi.KEY_ALBUM_MESSAGE, aVar3.f301845b, aVar3.f301846c);
                        return;
                    }
                    if (j3 == 1) {
                        ITroopSPUtilApi iTroopSPUtilApi3 = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
                        String currentAccountUin3 = ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime.getCurrentAccountUin();
                        com.tencent.mobileqq.troop.unreadmsg.a aVar4 = this.f298060d;
                        iTroopSPUtilApi3.setGroupGroupNewsInfo(currentAccountUin3, ITroopSPUtilApi.KEY_FILE_NEW, aVar4.f301845b, aVar4.f301847d);
                        return;
                    }
                    if (j3 == 1101236949) {
                        ITroopSPUtilApi iTroopSPUtilApi4 = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
                        String currentAccountUin4 = ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime.getCurrentAccountUin();
                        com.tencent.mobileqq.troop.unreadmsg.a aVar5 = this.f298060d;
                        iTroopSPUtilApi4.setGroupGroupNewsInfo(currentAccountUin4, ITroopSPUtilApi.KEY_TROOP_NOTIFICATION_NEW, aVar5.f301845b, aVar5.f301847d);
                        return;
                    }
                    if (j3 == 1101484419) {
                        ITroopSPUtilApi iTroopSPUtilApi5 = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
                        String currentAccountUin5 = ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime.getCurrentAccountUin();
                        com.tencent.mobileqq.troop.unreadmsg.a aVar6 = this.f298060d;
                        iTroopSPUtilApi5.setGroupGroupNewsInfo(currentAccountUin5, ITroopSPUtilApi.KEY_GROUP_ACTIVITY_NEW, aVar6.f301845b, aVar6.f301847d);
                        return;
                    }
                    if (j3 == 1102858908) {
                        f();
                        return;
                    }
                    if (j3 == 1105933138) {
                        j();
                        return;
                    } else if (j3 == 1106180084) {
                        d();
                        return;
                    } else {
                        if (j3 == 102304636) {
                            e();
                            return;
                        }
                        return;
                    }
                }
            }
            jArr = null;
            i3 = -1;
            i16 = 0;
            i17 = 0;
            ah.a().g(((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime, this.f298060d, this.f298063g, jArr, i16, i17, i3);
            j3 = this.f298060d.f301844a;
            if (j3 != 2) {
            }
        }

        private void h() {
            boolean z16;
            ah.a().h(((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime, this.f298060d);
            com.tencent.mobileqq.troop.unreadmsg.a aVar = this.f298060d;
            long j3 = aVar.f301844a;
            if (j3 == 101618516) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopOnlinePushHandler", 2, "onLinePush receive 0x210_0x26_cmd0x1 troop mini app entrance.");
                }
                if (this.f298060d.f301847d != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setAIOTroopMiniAppEntranceRedPoint(((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime, this.f298060d.f301845b, z16);
                TroopOnlinePushHandler.this.e3(i.f298026h, true, new Object[]{this.f298060d.f301845b, Boolean.valueOf(z16)});
                return;
            }
            if (j3 == 1104445552) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopOnlinePushHandler", 2, "onLinePush receive 0x210_0x26_cmd0x1 homework.");
                }
                IHWTroopUtilsApi iHWTroopUtilsApi = (IHWTroopUtilsApi) QRoute.api(IHWTroopUtilsApi.class);
                AppInterface appInterface = ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime;
                com.tencent.mobileqq.troop.unreadmsg.a aVar2 = this.f298060d;
                iHWTroopUtilsApi.setAIOHomeworkBtnRedPoint(appInterface, aVar2.f301845b, aVar2.f301847d);
                TroopOnlinePushHandler.this.e3(i.f298024e, true, new Object[]{this.f298060d.f301845b, String.valueOf(1104445552), Boolean.FALSE});
                return;
            }
            if (j3 != 1106588005) {
                if (j3 == 1106664488) {
                    i();
                    return;
                }
                if (j3 == 1106717414) {
                    ((tt2.a) ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopSurveyHandlerName())).e2(this.f298060d, this.f298063g, 2);
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "handleTroopNewsOnlinePush() msginfo handled by Oidb0xb36");
                        return;
                    }
                    return;
                }
                if (j3 == 101818344) {
                    if (this.f298063g.msg_app_tip_notify.has()) {
                        submsgtype0x26$AppTipNotify submsgtype0x26_apptipnotify = this.f298063g.msg_app_tip_notify.get();
                        if (submsgtype0x26_apptipnotify.bytes_text.has()) {
                            ((ITroopHonorService) ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime.getRuntimeService(ITroopHonorService.class, "")).updatePushTroopHonor(this.f298060d.f301845b, submsgtype0x26_apptipnotify.bytes_text.get().toByteArray(), 0);
                            ((ITroopManagerService) ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime.getRuntimeService(ITroopManagerService.class, "")).handleTroopMemberNewLevelChange(this.f298060d.f301845b, submsgtype0x26_apptipnotify.bytes_text.get().toByteArray(), 0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (j3 == 101872323) {
                    if (aVar.f301847d > 0) {
                        ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp(((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime, this.f298060d.f301845b, true);
                        TroopOnlinePushHandler.this.e3(i.f298027i, true, new Object[]{this.f298060d.f301845b});
                        return;
                    } else {
                        ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp(((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime, this.f298060d.f301845b, false);
                        return;
                    }
                }
                if (j3 == 101913298) {
                    IRedPointUtilsApi iRedPointUtilsApi = (IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class);
                    AppInterface appInterface2 = ((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime;
                    com.tencent.mobileqq.troop.unreadmsg.a aVar3 = this.f298060d;
                    iRedPointUtilsApi.updateRedPointInfo(appInterface2, aVar3.f301845b, "troop", 5, aVar3.f301847d);
                }
            }
        }

        private void i() {
            if (this.f298060d.f301847d == -1) {
                ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setGroupTIMFileNewsInfo(((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime.getCurrentAccountUin(), ITroopSPUtilApi.KEY_GROUP_FILE_REDDOT_TIM, this.f298060d.f301845b, true);
            } else {
                ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).removeGroupTIMFileNewsInfo(((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime.getCurrentAccountUin(), ITroopSPUtilApi.KEY_GROUP_FILE_REDDOT_TIM, this.f298060d.f301845b);
            }
            TroopOnlinePushHandler.this.e3(i.D, true, new Object[]{"" + this.f298060d.f301845b, Boolean.TRUE});
        }

        private void j() {
            if (this.f298060d.f301847d == -1) {
                ah.a().f(((BaseBusinessHandler) TroopOnlinePushHandler.this).appRuntime, this.f298060d.f301845b);
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopOnlinePushHandlerQ.hotchat.aio_post_red_point", 2, "handleTroopNewsOnlinePush, msgInfo.nNewNum:" + this.f298060d.f301847d);
            }
        }

        private void m() {
            com.tencent.mobileqq.troop.unreadmsg.a aVar = new com.tencent.mobileqq.troop.unreadmsg.a();
            this.f298060d = aVar;
            aVar.f301844a = this.f298063g.msg_app_id.uint64_app_id.get();
            this.f298060d.f301845b = String.valueOf(this.f298063g.uint64_group_code.get());
            this.f298060d.f301847d = this.f298063g.sint32_unread_num.get();
            int i3 = this.f298061e;
            com.tencent.mobileqq.troop.unreadmsg.a aVar2 = this.f298060d;
            this.f298061e = i3 + aVar2.f301847d;
            aVar2.f301846c = this.f298063g.sint32_album_cnt.get();
        }

        public com.tencent.mobileqq.troop.unreadmsg.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.troop.unreadmsg.a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f298060d;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f298061e;
        }

        public a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            if (this.f298063g == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("Q.troopgetnews..troop.notification_center", 4, "unreadNum is null");
                }
                this.f298057a = true;
                return this;
            }
            m();
            g();
            h();
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = this.f298062f;
                sb5.append("add photoinfo, groupCode = ");
                sb5.append(this.f298060d.f301845b);
                sb5.append(", appid = ");
                sb5.append(this.f298060d.f301844a);
                sb5.append(", messageNum = ");
                sb5.append(this.f298060d.f301846c);
                sb5.append(", newPhotoes = ");
                sb5.append(this.f298060d.f301847d);
            }
            this.f298059c.add(this.f298060d);
            this.f298057a = false;
            return this;
        }

        boolean k() {
            return this.f298057a;
        }

        public boolean l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.f298058b;
        }
    }

    public TroopOnlinePushHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f298056e = new HashMap<>(50);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3(f fVar) {
        ITroopEnterEffectService iTroopEnterEffectService = (ITroopEnterEffectService) this.appRuntime.getRuntimeService(ITroopEnterEffectService.class, "all");
        if (iTroopEnterEffectService.getTroopEnterEffectConfig().f295226a) {
            iTroopEnterEffectService.addTroopEnterEffectData(fVar);
            ah.a().i(this.appRuntime, fVar);
            notifyUI(com.tencent.mobileqq.troop.onlinepush.api.b.TYPE_NOTIFY_TROOP_ENTER_EFFECT_PUSH, true, fVar);
        } else if (QLog.isColorLevel()) {
            QLog.d(ITroopEnterEffectService.TAG, 2, "handleTroopEnterEffectPush function not enable");
        }
    }

    private void d3(submsgtype0x26$MsgBody.SubCmd0x4UpdateApp subCmd0x4UpdateApp) {
        long j3 = subCmd0x4UpdateApp.msg_app_id.uint64_app_id.get();
        String str = subCmd0x4UpdateApp.uint64_group_code.get() + "";
        if (j3 == 1105933138) {
            ah.a().f(this.appRuntime, str);
            return;
        }
        if (subCmd0x4UpdateApp.sint32_unread_num.get() == 0 && j3 == 1102858908) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlinePushHandler", 2, "handleTroopNewsOnlinePush, deleteFeedInfo, troopUin=" + str);
            }
            int i3 = i.C;
            Boolean bool = Boolean.TRUE;
            e3(i3, true, new Object[]{str, bool, bool});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(int i3, boolean z16, Object obj) {
        ((qt2.a) this.appRuntime.getBusinessHandler(TroopRedDotHandler.class.getName())).b(i3, z16, obj);
    }

    public void a3(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("TroopOnlinePushHandler", 2, "handleMemberExit, troopUin=" + str + ",memberUin=" + str2 + " isFromOfflinePush=" + z16);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = "del_" + str + "_" + str2;
        if (this.f298056e.containsKey(str3) && currentTimeMillis - this.f298056e.get(str3).longValue() < 2000) {
            return;
        }
        this.f298056e.put(str3, Long.valueOf(currentTimeMillis));
        TroopInfo troopInfo = ((ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
        ah.a().d(this.appRuntime, str, str2, troopInfo);
        if (troopInfo != null && !z16) {
            troopInfo.setMemberNumClient(troopInfo.getMemberNumClient() - 1);
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateMemberNumClient(str, troopInfo.getMemberNumClient(), "TroopOnlinePushHandler");
            ((ITroopCreateInfoService) this.appRuntime.getRuntimeService(ITroopCreateInfoService.class, "")).deleteInInviteList(str, str2);
            if (QLog.isColorLevel()) {
                QLog.d("TroopOnlinePushHandler", 2, "handleMemberExit memberNumClient:" + troopInfo.getMemberNumClient() + "  wMemberNum:" + troopInfo.wMemberNum + " troopUin:" + troopInfo.troopuin);
            }
        }
        notifyUI(com.tencent.mobileqq.troop.onlinepush.api.b.TYPE_NOTIFY_TROOP_MEMBER_CHANGED, true, null);
    }

    public void c3(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            return;
        }
        submsgtype0x26$MsgBody submsgtype0x26_msgbody = new submsgtype0x26$MsgBody();
        try {
            submsgtype0x26_msgbody.mergeFrom(bArr);
            if (QLog.isDevelopLevel()) {
                QLog.w("TroopOnlinePushHandler", 1, "handleTroopNewsOnlinePush, cmd[" + submsgtype0x26_msgbody.uint32_sub_cmd.get() + "]");
            }
            if (submsgtype0x26_msgbody.uint32_sub_cmd.get() == 4) {
                if (!submsgtype0x26_msgbody.msg_subcmd_0x4_push_body.has() && QLog.isColorLevel()) {
                    QLog.e("TroopOnlinePushHandler", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
                }
                submsgtype0x26$MsgBody.SubCmd0x4UpdateApp subCmd0x4UpdateApp = submsgtype0x26_msgbody.msg_subcmd_0x4_push_body.get();
                if (subCmd0x4UpdateApp.msg_app_id.has() && subCmd0x4UpdateApp.msg_app_id.uint64_app_id.has() && subCmd0x4UpdateApp.uint64_group_code.has() && subCmd0x4UpdateApp.sint32_unread_num.has()) {
                    d3(subCmd0x4UpdateApp);
                }
            }
            if (submsgtype0x26_msgbody.uint32_sub_cmd.has() && submsgtype0x26_msgbody.uint32_sub_cmd.get() == 1) {
                try {
                    if (!submsgtype0x26_msgbody.rpt_msg_subcmd_0x1_push_body.has()) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("TroopOnlinePushHandler", 4, "rpt_msg_subcmd_0x1_push_body.has() = false");
                            return;
                        }
                        return;
                    }
                    List<submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum> list = submsgtype0x26_msgbody.rpt_msg_subcmd_0x1_push_body.get();
                    if (list == null) {
                        if (QLog.isDevelopLevel()) {
                            QLog.e("TroopOnlinePushHandler", 4, "rpt_msg_subcmd_0x1_push_body is null");
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    StringBuilder sb5 = new StringBuilder();
                    Iterator<submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum> it = list.iterator();
                    com.tencent.mobileqq.troop.unreadmsg.a aVar = null;
                    boolean z16 = false;
                    int i3 = 0;
                    while (it.hasNext()) {
                        com.tencent.mobileqq.troop.unreadmsg.a aVar2 = aVar;
                        a c16 = new a(z16, arrayList, aVar, i3, sb5, it.next()).c();
                        if (c16.k()) {
                            aVar = aVar2;
                        } else {
                            z16 = c16.l();
                            aVar = c16.a();
                            i3 = c16.b();
                        }
                    }
                    com.tencent.mobileqq.troop.unreadmsg.a aVar3 = aVar;
                    if (QLog.isDevelopLevel()) {
                        QLog.i("TroopOnlinePushHandler", 4, sb5.toString());
                    }
                    if (i3 != 0) {
                        e3(i.f298028m, true, new Object[]{Boolean.TRUE, arrayList, -1});
                    } else {
                        e3(i.f298028m, true, new Object[]{Boolean.TRUE, arrayList, 0});
                    }
                    if (z16) {
                        e3(i.C, true, new Object[]{aVar3.f301845b, Boolean.FALSE, Boolean.TRUE});
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("TroopOnlinePushHandler", 4, "handleTroopNewsOnlinePush|exception = " + e16.toString());
                        return;
                    }
                    return;
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.e("TroopOnlinePushHandler", 4, "handleTroopNewsOnlinePush : msgBody is null or NotSupportSubCMd :" + submsgtype0x26_msgbody.uint32_sub_cmd.get());
            }
        } catch (Exception unused) {
            if (QLog.isDevelopLevel()) {
                QLog.e("TroopOnlinePushHandler", 4, "handleTroopNewsOnlinePush : fail to parse submsgtype0x26.");
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopOnlinePushHandler";
    }

    @Override // com.tencent.mobileqq.troop.onlinepush.api.a
    public void handleMemberExit(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        } else {
            a3(str, str2, false);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.troop.onlinepush.api.b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
        }
    }
}
