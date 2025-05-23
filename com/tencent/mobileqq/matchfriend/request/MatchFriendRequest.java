package com.tencent.mobileqq.matchfriend.request;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.QQStrangerRecentContactHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.servlet.IRelationSSORequestHandler;
import com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl.GrayCtrl$EntranceCtrlReq;
import com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl.GrayCtrl$EntranceCtrlRsp;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$SendInterMsgReq;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$SendInterMsgRsp;
import com.tencent.trpcprotocol.kuolie.login_svr.login_svr.LoginSvr$LoginInfoReportReq;
import com.tencent.trpcprotocol.kuolie.login_svr.login_svr.LoginSvr$LoginInfoReportRsp;
import com.tencent.trpcprotocol.kuolie.login_svr.login_svr.LoginSvr$LogoutReq;
import com.tencent.trpcprotocol.kuolie.login_svr.login_svr.LoginSvr$LogoutRsp;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetAIOHintReq;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetAIOHintRsp;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetIceBreakingTopicReq;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetIceBreakingTopicRsp;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetVoiceLinkTopicReq;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetVoiceLinkTopicRsp;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$TopicInfo;
import com.tencent.trpcprotocol.kuolie.report.report.report$HearBeatReq;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$HidePluginOption;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$Options;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$SetOptionsReq;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$SetOptionsRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$BatchGetMiniUserInfoReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$BatchGetMiniUserInfoRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$ControlFlag;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$DocumentConfig;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetArkInfoReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetArkInfoRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetMasterControlReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetMasterControlRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.qqstranger.add_friend.add_friend.addFriend$SsoCanAddFriendReq;
import com.tencent.trpcprotocol.qqstranger.add_friend.add_friend.addFriend$SsoCanAddFriendRsp;
import com.tencent.trpcprotocol.qqstranger.add_friend.add_friend.addFriend$SsoIsFriendReq;
import com.tencent.trpcprotocol.qqstranger.add_friend.add_friend.addFriend$SsoIsFriendRsp;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$GetAIOSignReq;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$GetAIOSignRsp;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$SoulMatchData;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$SsoAIOReportReq;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$SsoAIOReportRsp;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$SsoCanGreetReq;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$SsoCanGreetRsp;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$SsoCanPushMessageNoticeReq;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$SsoCanPushMessageNoticeRsp;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$SsoGreetReportReq;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$SsoGreetReportRsp;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$SsoSetFirstRelationOriginReq;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$SsoSetFirstRelationOriginRsp;
import com.tencent.trpcprotocol.qqstranger.security.security.Security$GetShieldUserReq;
import com.tencent.trpcprotocol.qqstranger.security.security.Security$GetShieldUserRsp;
import com.tencent.trpcprotocol.qqstranger.security.security.Security$ReportUserReq;
import com.tencent.trpcprotocol.qqstranger.security.security.Security$ShieldReq;
import com.tencent.trpcprotocol.qqstranger.security.security.Security$ShieldRsp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendRequest {

    /* renamed from: a, reason: collision with root package name */
    private static final int f245532a = (com.tencent.mobileqq.ark.f.f199484d - BaseChatItemLayout.f178049g0) - BaseChatItemLayout.f178050h0;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245541d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f245542e;

        a(com.tencent.relation.common.servlet.a aVar, String str) {
            this.f245541d = aVar;
            this.f245542e = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    aioMsg$GetAIOSignRsp aiomsg_getaiosignrsp = new aioMsg$GetAIOSignRsp();
                    aiomsg_getaiosignrsp.mergeFrom((byte[]) obj);
                    if (aiomsg_getaiosignrsp.ret_code.get() != 0) {
                        MatchFriendRequest.N(this.f245541d, this.f245542e, 4, false, null);
                    } else {
                        byte[] byteArray = aiomsg_getaiosignrsp.sign.get().toByteArray();
                        MatchFriendRequest.N(this.f245541d, this.f245542e, 4, true, byteArray);
                        QLog.i("MatchFriendRequest", 1, "[getAioSign] success sign length:" + byteArray.length);
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getAioSign] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[getAioSign] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f245543d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f245544e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f245545f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f245546h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245547i;

        b(String str, int i3, boolean z16, String str2, com.tencent.relation.common.servlet.a aVar) {
            this.f245543d = str;
            this.f245544e = i3;
            this.f245545f = z16;
            this.f245546h = str2;
            this.f245547i = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0089  */
        @Override // com.tencent.mobileqq.app.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpdate(int i3, boolean z16, Object obj) {
            boolean z17;
            userInfo$GetArkInfoRsp userinfo_getarkinforsp;
            boolean z18 = true;
            if (!z16 || obj == null) {
                QLog.e("MatchFriendRequest", 1, "[getArkMiniProfileCardInfo] isSuccess:" + z16 + ", data:" + obj);
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                try {
                    userinfo_getarkinforsp = new userInfo$GetArkInfoRsp();
                    userinfo_getarkinforsp.mergeFrom((byte[]) obj);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getArkMiniProfileCardInfo] error", e16);
                }
                if (userinfo_getarkinforsp.ret_code.get() == 0) {
                    String str = userinfo_getarkinforsp.ark_user_info.get();
                    MatchFriendRequest.E(str, Long.parseLong(this.f245543d), this.f245544e, this.f245545f, this.f245546h);
                    MatchFriendRequest.N(this.f245547i, this.f245546h, 6, true, str);
                    QLog.i("MatchFriendRequest", 1, "[getArkMiniProfileCardInfo] success arkInfo length:" + str.length());
                } else {
                    QLog.e("MatchFriendRequest", 1, "[getArkMiniProfileCardInfo] fail");
                    if (z18) {
                        return;
                    }
                    MatchFriendRequest.N(this.f245547i, this.f245546h, 6, false, null);
                    return;
                }
            }
            z18 = z17;
            if (z18) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245548d;

        c(com.tencent.relation.common.servlet.a aVar) {
            this.f245548d = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0079  */
        @Override // com.tencent.mobileqq.app.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpdate(int i3, boolean z16, Object obj) {
            boolean z17;
            boolean z18 = true;
            if (!z16 || obj == null) {
                QLog.e("MatchFriendRequest", 1, "[getUserShield] isSuccess:" + z16 + ", data:" + obj);
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                try {
                    Security$GetShieldUserRsp security$GetShieldUserRsp = new Security$GetShieldUserRsp();
                    security$GetShieldUserRsp.mergeFrom((byte[]) obj);
                    int i16 = security$GetShieldUserRsp.ret_code.get();
                    boolean z19 = security$GetShieldUserRsp.is_shield.get();
                    QLog.i("MatchFriendRequest", 1, "[getUserShield] success retCode:" + i16 + " isShield:" + z19);
                    if (i16 == 0) {
                        this.f245548d.notifyUI(7, true, Boolean.valueOf(z19));
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getUserShield] error", e16);
                }
                if (z18) {
                    return;
                }
                this.f245548d.notifyUI(7, false, null);
                return;
            }
            z18 = z17;
            if (z18) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class d implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f245549d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f245550e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245551f;

        d(AppInterface appInterface, long j3, com.tencent.relation.common.servlet.a aVar) {
            this.f245549d = appInterface;
            this.f245550e = j3;
            this.f245551f = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0081  */
        @Override // com.tencent.mobileqq.app.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpdate(int i3, boolean z16, Object obj) {
            boolean z17;
            boolean z18 = true;
            if (!z16 || obj == null) {
                QLog.e("MatchFriendRequest", 1, "[setUserShield] isSuccess:" + z16 + ", data:" + obj);
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                try {
                    Security$ShieldRsp security$ShieldRsp = new Security$ShieldRsp();
                    security$ShieldRsp.mergeFrom((byte[]) obj);
                    int i16 = security$ShieldRsp.ret_code.get();
                    boolean z19 = security$ShieldRsp.is_shield.get();
                    QLog.i("MatchFriendRequest", 1, "[setUserShield] success retCode:" + i16 + " isShield:" + z19);
                    if (i16 == 0) {
                        MatchFriendRequest.T(this.f245549d, this.f245550e, z19);
                        this.f245551f.notifyUI(8, true, Boolean.valueOf(z19));
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[setUserShield] error", e16);
                }
                if (z18) {
                    return;
                }
                this.f245551f.notifyUI(8, false, null);
                return;
            }
            z18 = z17;
            if (z18) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class f implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245552d;

        f(com.tencent.relation.common.servlet.a aVar) {
            this.f245552d = aVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    userInfo$BatchGetMiniUserInfoRsp userinfo_batchgetminiuserinforsp = new userInfo$BatchGetMiniUserInfoRsp();
                    userinfo_batchgetminiuserinforsp.mergeFrom((byte[]) obj);
                    if (userinfo_batchgetminiuserinforsp.code.get() == 0) {
                        List<userInfo$MiniInfo> list = userinfo_batchgetminiuserinforsp.infos.get();
                        if (list != null && list.size() != 0) {
                            ArrayList arrayList = new ArrayList();
                            for (userInfo$MiniInfo userinfo_miniinfo : list) {
                                arrayList.add(new Pair(Long.valueOf(userinfo_miniinfo.tiny_id.get()), Integer.valueOf(userinfo_miniinfo.gender.get())));
                            }
                            this.f245552d.notifyUI(20, true, arrayList);
                            QLog.i("MatchFriendRequest", 1, "[batchGetUserGender] success list size:" + list.size());
                            return;
                        }
                        this.f245552d.notifyUI(20, false, null);
                        QLog.e("MatchFriendRequest", 1, "[batchGetUserGender] infoList is null");
                        return;
                    }
                    this.f245552d.notifyUI(20, false, null);
                    QLog.i("MatchFriendRequest", 1, "[batchGetUserGender] fail");
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[batchGetUserGender] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[batchGetUserGender] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class g implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.matchfriend.api.a f245553d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245554e;

        g(com.tencent.mobileqq.matchfriend.api.a aVar, com.tencent.relation.common.servlet.a aVar2) {
            this.f245553d = aVar;
            this.f245554e = aVar2;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    addFriend$SsoIsFriendRsp addfriend_ssoisfriendrsp = new addFriend$SsoIsFriendRsp();
                    addfriend_ssoisfriendrsp.mergeFrom((byte[]) obj);
                    int i16 = addfriend_ssoisfriendrsp.ret_code.get();
                    boolean z17 = addfriend_ssoisfriendrsp.is_friend.get();
                    QLog.i("MatchFriendRequest", 1, "[getIsFriend] success retCode:" + i16 + " isFriend:" + z17);
                    if (i16 == 0) {
                        com.tencent.mobileqq.matchfriend.api.a aVar = this.f245553d;
                        if (aVar != null) {
                            aVar.a(true, z17);
                        } else {
                            this.f245554e.notifyUI(12, true, Boolean.valueOf(z17));
                        }
                    } else {
                        com.tencent.mobileqq.matchfriend.api.a aVar2 = this.f245553d;
                        if (aVar2 != null) {
                            aVar2.a(false, false);
                        }
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getIsFriend] error", e16);
                    com.tencent.mobileqq.matchfriend.api.a aVar3 = this.f245553d;
                    if (aVar3 != null) {
                        aVar3.a(false, false);
                        return;
                    }
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[getIsFriend] isSuccess:" + z16 + ", data:" + obj);
            com.tencent.mobileqq.matchfriend.api.a aVar4 = this.f245553d;
            if (aVar4 != null) {
                aVar4.a(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class h implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245555d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f245556e;

        h(com.tencent.relation.common.servlet.a aVar, int i3) {
            this.f245555d = aVar;
            this.f245556e = i3;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    addFriend$SsoCanAddFriendRsp addfriend_ssocanaddfriendrsp = new addFriend$SsoCanAddFriendRsp();
                    addfriend_ssocanaddfriendrsp.mergeFrom((byte[]) obj);
                    int i16 = addfriend_ssocanaddfriendrsp.ret_code.get();
                    boolean z17 = addfriend_ssocanaddfriendrsp.is_pass.get();
                    String str = addfriend_ssocanaddfriendrsp.remind_text.get();
                    QLog.i("MatchFriendRequest", 2, "[getCanAddFriend] success retCode:" + i16 + " isPass:" + z17 + " remindText:" + str);
                    if (i16 == 0) {
                        this.f245555d.notifyUI(this.f245556e, true, new Object[]{Boolean.valueOf(z17), str});
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getCanAddFriend] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[getCanAddFriend] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class j implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f245558d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppInterface f245559e;

        j(boolean z16, AppInterface appInterface) {
            this.f245558d = z16;
            this.f245559e = appInterface;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    UserConfig$SetOptionsRsp userConfig$SetOptionsRsp = new UserConfig$SetOptionsRsp();
                    userConfig$SetOptionsRsp.mergeFrom((byte[]) obj);
                    int i16 = userConfig$SetOptionsRsp.ret_code.get();
                    QLog.i("MatchFriendRequest", 1, "[reportDynamicEntrance] success retCode:" + i16 + "; errMsg:" + userConfig$SetOptionsRsp.err_msg.get());
                    if (i16 != 0) {
                        return;
                    }
                    com.tencent.mobileqq.matchfriend.utils.b.d().o(this.f245558d);
                    MatchFriendRequest.W(this.f245559e);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[reportDynamicEntrance] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[reportDynamicEntrance] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class k implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245560d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f245561e;

        k(com.tencent.relation.common.servlet.a aVar, String str) {
            this.f245560d = aVar;
            this.f245561e = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    Prompt$GetAIOHintRsp prompt$GetAIOHintRsp = new Prompt$GetAIOHintRsp();
                    prompt$GetAIOHintRsp.mergeFrom((byte[]) obj);
                    int i16 = prompt$GetAIOHintRsp.ret_code.get();
                    String str = prompt$GetAIOHintRsp.hint.get();
                    if (i16 != 0 || TextUtils.isEmpty(str)) {
                        return;
                    }
                    MatchFriendRequest.N(this.f245560d, this.f245561e, 16, true, str);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getAioHint] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[getAioHint] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class l implements com.tencent.relation.common.servlet.c {
        l() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            byte[] byteArray = bundle.getByteArray("rsp_data");
            if (z16 && byteArray != null) {
                try {
                    aioMsg$SsoCanPushMessageNoticeRsp aiomsg_ssocanpushmessagenoticersp = new aioMsg$SsoCanPushMessageNoticeRsp();
                    aiomsg_ssocanpushmessagenoticersp.mergeFrom(byteArray);
                    int i16 = aiomsg_ssocanpushmessagenoticersp.ret_code.get();
                    QLog.i("MatchFriendRequest", 1, "updateNotificationSwitch, retCode=" + i16 + ", retMsg=" + aiomsg_ssocanpushmessagenoticersp.ret_msg.get());
                    if (i16 == 0) {
                        QLog.i("MatchFriendRequest", 1, "updateNotificationSwitch rsp.is_pass " + aiomsg_ssocanpushmessagenoticersp.is_pass.get());
                        com.tencent.mobileqq.matchfriend.utils.b.d().s(aiomsg_ssocanpushmessagenoticersp.is_pass.get());
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[updateNotificationSwitch] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[updateNotificationSwitch] isSuccess:" + z16 + ", data:" + byteArray);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class m implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245562d;

        m(com.tencent.relation.common.servlet.a aVar) {
            this.f245562d = aVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    Prompt$GetVoiceLinkTopicRsp prompt$GetVoiceLinkTopicRsp = new Prompt$GetVoiceLinkTopicRsp();
                    prompt$GetVoiceLinkTopicRsp.mergeFrom((byte[]) obj);
                    int i16 = prompt$GetVoiceLinkTopicRsp.ret_code.get();
                    if (i16 == 0) {
                        QLog.i("MatchFriendRequest", 1, "[getVoiceLinkIceBreakTopic] topic size:" + prompt$GetVoiceLinkTopicRsp.topic_infos.size());
                        ArrayList arrayList = new ArrayList();
                        for (Prompt$TopicInfo prompt$TopicInfo : prompt$GetVoiceLinkTopicRsp.topic_infos.get()) {
                            com.tencent.mobileqq.matchfriend.bean.a aVar = new com.tencent.mobileqq.matchfriend.bean.a();
                            aVar.f244049a = prompt$TopicInfo.color.get();
                            aVar.f244050b = prompt$TopicInfo.topic_name.get();
                            arrayList.add(aVar);
                        }
                        this.f245562d.notifyUI(19, true, arrayList);
                        return;
                    }
                    QLog.i("MatchFriendRequest", 1, "[getVoiceLinkIceBreakTopic] fail retCode:" + i16 + " error msg:" + prompt$GetVoiceLinkTopicRsp.err_msg.get());
                    this.f245562d.notifyUI(19, false, null);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getVoiceLinkIceBreakTopic] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[getVoiceLinkIceBreakTopic] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class n implements com.tencent.relation.common.servlet.b {
        n() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            QLog.d("MatchFriendRequest", 1, "[SsoSendInterMsg] sendInviteGrayTip isSuccess=" + z16);
            if (z16 && (obj instanceof byte[])) {
                InteractiveMsgServicePB$SendInterMsgRsp interactiveMsgServicePB$SendInterMsgRsp = new InteractiveMsgServicePB$SendInterMsgRsp();
                try {
                    interactiveMsgServicePB$SendInterMsgRsp.mergeFrom((byte[]) obj);
                    if (interactiveMsgServicePB$SendInterMsgRsp.rsp_head.ret_code.get() != 0) {
                        QLog.i("MatchFriendRequest", 1, "[SsoSendInterMsg] sendInviteGrayTip rsp error: msgId=" + interactiveMsgServicePB$SendInterMsgRsp.msg_id.get() + ",msgTime=" + interactiveMsgServicePB$SendInterMsgRsp.msg_time.get());
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[SsoSendInterMsg] sendInviteGrayTip error: ", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class o implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f245563d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.b f245564e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245565f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f245566h;

        o(int i3, com.tencent.relation.common.servlet.b bVar, com.tencent.relation.common.servlet.a aVar, int i16) {
            this.f245563d = i3;
            this.f245564e = bVar;
            this.f245565f = aVar;
            this.f245566h = i16;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    userInfo$GetMasterControlRsp userinfo_getmastercontrolrsp = new userInfo$GetMasterControlRsp();
                    userinfo_getmastercontrolrsp.mergeFrom((byte[]) obj);
                    int i16 = userinfo_getmastercontrolrsp.ret_code.get();
                    userInfo$ControlFlag userinfo_controlflag = null;
                    if (i16 == 0) {
                        if (userinfo_getmastercontrolrsp.control_flag.has() && userinfo_getmastercontrolrsp.control_flag.size() > 0) {
                            userinfo_controlflag = userinfo_getmastercontrolrsp.control_flag.get(0);
                        }
                        Object[] z17 = MatchFriendRequest.z(userinfo_controlflag, this.f245563d);
                        com.tencent.relation.common.servlet.b bVar = this.f245564e;
                        if (bVar != null) {
                            bVar.onUpdate(0, true, z17);
                            return;
                        } else {
                            this.f245565f.notifyUI(this.f245566h, true, z17);
                            return;
                        }
                    }
                    QLog.i("MatchFriendRequest", 1, "[getMasterControl] fail retCode:" + i16 + " error msg:" + userinfo_getmastercontrolrsp.ret_msg.get());
                    com.tencent.relation.common.servlet.b bVar2 = this.f245564e;
                    if (bVar2 != null) {
                        bVar2.onUpdate(0, false, null);
                        return;
                    } else {
                        this.f245565f.notifyUI(this.f245566h, false, null);
                        return;
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getMasterControl] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[getMasterControl] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class p implements com.tencent.relation.common.servlet.c {
        p() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            Object valueOf;
            boolean z17;
            byte[] byteArray = bundle.getByteArray("rsp_data");
            if (!z16 || byteArray == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[logout], isSuccess:");
                sb5.append(z16);
                sb5.append(", data:");
                if (byteArray == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(byteArray.length);
                }
                sb5.append(valueOf);
                QLog.e("MatchFriendRequest", 1, sb5.toString());
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return;
            }
            try {
                LoginSvr$LogoutRsp loginSvr$LogoutRsp = new LoginSvr$LogoutRsp();
                loginSvr$LogoutRsp.mergeFrom(byteArray);
                QLog.i("MatchFriendRequest", 1, "[logout] retCode:" + loginSvr$LogoutRsp.ret_code.get() + ", errMsg:" + loginSvr$LogoutRsp.err_msg.get());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("MatchFriendRequest", 1, "[logout] error", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class q implements com.tencent.relation.common.servlet.c {
        q() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            Object valueOf;
            byte[] byteArray = bundle.getByteArray("rsp_data");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[heartbeat], isSuccess:");
            sb5.append(z16);
            sb5.append(", data:");
            if (byteArray == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(byteArray.length);
            }
            sb5.append(valueOf);
            QLog.i("MatchFriendRequest", 1, sb5.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class r implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f245567d;

        r(AppInterface appInterface) {
            this.f245567d = appInterface;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    GrayCtrl$EntranceCtrlRsp grayCtrl$EntranceCtrlRsp = new GrayCtrl$EntranceCtrlRsp();
                    grayCtrl$EntranceCtrlRsp.mergeFrom((byte[]) obj);
                    int i16 = grayCtrl$EntranceCtrlRsp.ret_code.get();
                    boolean z17 = i16 == 0 ? grayCtrl$EntranceCtrlRsp.display.get() : false;
                    QLog.i("MatchFriendRequest", 1, "[getMatchFriendEntrance] retCode:" + i16 + ", display:" + z17);
                    MatchFriendRequest.Q(this.f245567d, z17);
                    if (z17) {
                        QQStrangerRecentContactHelper.f244865a.i();
                        MatchFriendRequest.W(this.f245567d);
                        return;
                    } else {
                        com.tencent.mobileqq.matchfriend.utils.b.d().s(false);
                        return;
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getMatchFriendEntrance] error", e16);
                    return;
                }
            }
            if (obj == null) {
                QQStrangerRecentContactHelper.f244865a.i();
            }
            QLog.e("MatchFriendRequest", 1, "[getMatchFriendEntrance] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class s implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245568d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f245569e;

        s(com.tencent.relation.common.servlet.a aVar, String str) {
            this.f245568d = aVar;
            this.f245569e = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    Relation$SsoSetFirstRelationOriginRsp relation$SsoSetFirstRelationOriginRsp = new Relation$SsoSetFirstRelationOriginRsp();
                    relation$SsoSetFirstRelationOriginRsp.mergeFrom((byte[]) obj);
                    int i16 = relation$SsoSetFirstRelationOriginRsp.ret_code.get();
                    QLog.i("MatchFriendRequest", 1, "[setFirstRelationOrigin] retCode:" + i16 + ", retMsg:" + relation$SsoSetFirstRelationOriginRsp.ret_msg.get());
                    MatchFriendRequest.N(this.f245568d, this.f245569e, 15, i16 == 0, null);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[setFirstRelationOrigin] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[setFirstRelationOrigin] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class t implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245570d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f245571e;

        t(com.tencent.relation.common.servlet.a aVar, String str) {
            this.f245570d = aVar;
            this.f245571e = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x00c2  */
        @Override // com.tencent.mobileqq.app.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpdate(int i3, boolean z16, Object obj) {
            boolean z17;
            boolean z18;
            String str;
            int i16;
            int i17;
            String str2;
            boolean z19 = true;
            if (!z16 || obj == null) {
                QLog.e("MatchFriendRequest", 1, "[getCanGreet] isSuccess:" + z16 + ", data:" + obj);
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                try {
                    aioMsg$SsoCanGreetRsp aiomsg_ssocangreetrsp = new aioMsg$SsoCanGreetRsp();
                    aiomsg_ssocangreetrsp.mergeFrom((byte[]) obj);
                    z18 = aiomsg_ssocangreetrsp.is_pass.get();
                    str = aiomsg_ssocangreetrsp.remind_text.get();
                    i16 = aiomsg_ssocangreetrsp.hit_type.get();
                    i17 = aiomsg_ssocangreetrsp.ret_code.get();
                    str2 = aiomsg_ssocangreetrsp.ret_msg.get();
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getCanGreet] error", e16);
                }
                if (i17 != 0) {
                    QLog.e("MatchFriendRequest", 1, "[getCanGreet] retCode:" + i17 + ", retMsg:" + str2);
                    if (z19) {
                        return;
                    }
                    MatchFriendRequest.N(this.f245570d, this.f245571e, 2, false, null);
                    return;
                }
                Object[] objArr = {Boolean.valueOf(z18), str, Integer.valueOf(i16)};
                QLog.i("MatchFriendRequest", 1, "[getCanGreet] isPass:" + z18 + ", remindText:" + str + ", hitType:" + i16);
                MatchFriendRequest.N(this.f245570d, this.f245571e, 2, true, objArr);
            }
            z19 = z17;
            if (z19) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class u implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245572d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f245573e;

        u(com.tencent.relation.common.servlet.a aVar, String str) {
            this.f245572d = aVar;
            this.f245573e = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    aioMsg$SsoGreetReportRsp aiomsg_ssogreetreportrsp = new aioMsg$SsoGreetReportRsp();
                    aiomsg_ssogreetreportrsp.mergeFrom((byte[]) obj);
                    int i16 = aiomsg_ssogreetreportrsp.ret_code.get();
                    String str = aiomsg_ssogreetreportrsp.ret_msg.get();
                    if (i16 != 0) {
                        QLog.e("MatchFriendRequest", 1, "[greetReport] retCode:" + i16 + ", retMsg:" + str);
                    } else {
                        QLog.i("MatchFriendRequest", 1, "[greetReport] success");
                        MatchFriendRequest.N(this.f245572d, this.f245573e, 3, true, null);
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[greetReport] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[greetReport] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class v implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245574d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f245575e;

        v(com.tencent.relation.common.servlet.a aVar, String str) {
            this.f245574d = aVar;
            this.f245575e = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    aioMsg$SsoAIOReportRsp aiomsg_ssoaioreportrsp = new aioMsg$SsoAIOReportRsp();
                    aiomsg_ssoaioreportrsp.mergeFrom((byte[]) obj);
                    int i16 = aiomsg_ssoaioreportrsp.ret_code.get();
                    String str = aiomsg_ssoaioreportrsp.ret_msg.get();
                    if (i16 != 0) {
                        QLog.e("MatchFriendRequest", 1, "[aioReport] retCode:" + i16 + ", retMsg:" + str);
                    } else {
                        QLog.i("MatchFriendRequest", 1, "[aioReport] success");
                        MatchFriendRequest.N(this.f245574d, this.f245575e, 34, true, null);
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[aioReport] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[aioReport] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class w implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f245576d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245577e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f245578f;

        w(long j3, com.tencent.relation.common.servlet.a aVar, String str) {
            this.f245576d = j3;
            this.f245577e = aVar;
            this.f245578f = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    Prompt$GetIceBreakingTopicRsp prompt$GetIceBreakingTopicRsp = new Prompt$GetIceBreakingTopicRsp();
                    prompt$GetIceBreakingTopicRsp.mergeFrom((byte[]) obj);
                    if (prompt$GetIceBreakingTopicRsp.ret_code.get() == 0) {
                        String str = prompt$GetIceBreakingTopicRsp.ark_message.get();
                        String str2 = prompt$GetIceBreakingTopicRsp.topic_id.get();
                        com.tencent.mobileqq.matchfriend.utils.b.d().t(String.valueOf(this.f245576d), str2);
                        MatchFriendRequest.F(str, this.f245576d);
                        MatchFriendRequest.N(this.f245577e, this.f245578f, 5, true, str2);
                        QLog.i("MatchFriendRequest", 1, "[getIceBreakingTopic] success arkMessage length:" + str.length() + ", topicId:" + str2);
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[getIceBreakingTopic] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendRequest", 1, "[getIceBreakingTopic] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(final String str, final long j3, final int i3, final boolean z16, final String str2) {
        Object obj;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof QQAppInterface)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("appRuntime is not QQAppInterface:");
            if (waitAppRuntime == null) {
                obj = "null";
            } else {
                obj = waitAppRuntime.getClass();
            }
            sb5.append(obj);
            QLog.e("MatchFriendRequest", 1, sb5.toString());
            return;
        }
        final QQAppInterface qQAppInterface = (QQAppInterface) waitAppRuntime;
        if (!TextUtils.isEmpty(str)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.request.MatchFriendRequest.12
                @Override // java.lang.Runnable
                public void run() {
                    MatchFriendRequest.I(QQAppInterface.this, String.valueOf(j3), i3, str);
                    com.tencent.mobileqq.matchfriend.utils.b.d().q(String.valueOf(j3), true);
                    if (z16) {
                        MatchFriendRequest.v(QQAppInterface.this, j3, str2);
                    }
                }
            }, 32, null, true);
        } else if (z16) {
            v(qQAppInterface, j3, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(final String str, final long j3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.request.MatchFriendRequest.13
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                if (waitAppRuntime instanceof QQAppInterface) {
                    MatchFriendRequest.J((QQAppInterface) waitAppRuntime, String.valueOf(j3), str);
                    com.tencent.mobileqq.matchfriend.utils.b.d().r(String.valueOf(j3), true);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("appRuntime is not QQAppInterface:");
                if (waitAppRuntime == null) {
                    obj = "null";
                } else {
                    obj = waitAppRuntime.getClass();
                }
                sb5.append(obj);
                QLog.e("MatchFriendRequest", 1, sb5.toString());
            }
        }, 32, null, true);
    }

    private static int H(userInfo$GetMasterControlReq userinfo_getmastercontrolreq, int i3, int i16) {
        if (i3 != 101) {
            if (i3 == 102) {
                userinfo_getmastercontrolreq.source.set(com.tencent.mobileqq.matchfriend.data.b.f244063b);
                userinfo_getmastercontrolreq.req_flag.add(102);
                userinfo_getmastercontrolreq.mc_type.set(0);
                return 23;
            }
            QLog.e("MatchFriendRequest", 1, "[getMasterControl] flagId is not support");
            return 0;
        }
        userinfo_getmastercontrolreq.source.set(com.tencent.mobileqq.matchfriend.data.b.f244062a);
        userinfo_getmastercontrolreq.req_flag.add(101);
        if (i16 == 1) {
            userinfo_getmastercontrolreq.mc_type.set(1);
            return 30;
        }
        if (i16 == 2) {
            userinfo_getmastercontrolreq.mc_type.set(2);
            return 31;
        }
        QLog.e("MatchFriendRequest", 1, "getMasterControl, fromType invalid");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(QQAppInterface qQAppInterface, String str, String str2) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("MatchFriendRequest", 2, "insertIcebreakerTopic arkMessage:" + str2);
            }
            com.tencent.mobileqq.matchfriend.nt.d.f244175a.b(qQAppInterface, str, w(qQAppInterface, str, str2), false);
            return;
        }
        QLog.e("MatchFriendRequest", 1, "insertIcebreakerTopic but matchUin or app is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(com.tencent.relation.common.servlet.a aVar, String str, int i3, boolean z16, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            com.tencent.relation.common.servlet.b u16 = aVar.u1(str);
            if (u16 != null) {
                u16.onUpdate(i3, z16, obj);
                return;
            }
            return;
        }
        aVar.notifyUI(i3, z16, obj);
    }

    public static void P(AppInterface appInterface, long j3) {
        Security$ReportUserReq security$ReportUserReq = new Security$ReportUserReq();
        security$ReportUserReq.account_type.set(2);
        security$ReportUserReq.account_id.set(String.valueOf(j3));
        ((com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4)).Z0("QQStranger.UserInfo.SsoReportUser", security$ReportUserReq.toByteArray(), new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(AppInterface appInterface, boolean z16) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_for_match_friend_" + appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences == null) {
            QLog.e("MatchFriendRequest", 1, "getMatchFriendEntrance sp is null");
        } else {
            sharedPreferences.edit().putBoolean("key_match_friend_entrance", z16).commit();
        }
    }

    public static void R(AppInterface appInterface, String str) {
        InteractiveMsgServicePB$SendInterMsgReq interactiveMsgServicePB$SendInterMsgReq = new InteractiveMsgServicePB$SendInterMsgReq();
        interactiveMsgServicePB$SendInterMsgReq.peer_open_id.set(str);
        interactiveMsgServicePB$SendInterMsgReq.scene_id.set(3);
        ((com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4)).Z0("QQStranger.InteractiveMsgSvr.SsoSendInterMsg", interactiveMsgServicePB$SendInterMsgReq.toByteArray(), new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(AppInterface appInterface, long j3, boolean z16) {
        ArrayList arrayList = new ArrayList();
        ShieldListInfo shieldListInfo = new ShieldListInfo();
        shieldListInfo.uin = String.valueOf(j3);
        shieldListInfo.source_id = 172;
        shieldListInfo.source_sub_id = 0;
        if (z16) {
            shieldListInfo.flags = 1;
        } else {
            shieldListInfo.flags = 0;
        }
        arrayList.add(shieldListInfo);
        ((ShieldMsgManger) appInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).i(arrayList);
    }

    private static boolean V(boolean z16) {
        boolean k3 = com.tencent.mobileqq.matchfriend.utils.b.d().k();
        boolean e16 = com.tencent.mobileqq.matchfriend.utils.b.d().e();
        if (QLog.isColorLevel()) {
            QLog.d("MatchFriendRequest", 2, "updateDynamicEntranceSwitch, local:" + e16 + "; real:" + z16);
        }
        return (k3 && e16 == z16) ? false : true;
    }

    public static void W(AppRuntime appRuntime) {
        ((IRelationSSORequestHandler) QRoute.api(IRelationSSORequestHandler.class)).request(appRuntime, "QQStranger.AIOMsg.SsoCanPushMessageNotice", new MessageMicro<aioMsg$SsoCanPushMessageNoticeReq>() { // from class: com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$SsoCanPushMessageNoticeReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], aioMsg$SsoCanPushMessageNoticeReq.class);
        }.toByteArray(), new l());
    }

    private static JSONObject i(JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
            JSONObject jSONObject3 = new JSONObject(jSONObject2.optString(LocalDataJsPlugin.NAME_SPACE));
            if (!com.tencent.mobileqq.matchfriend.utils.e.b(jSONObject3.optInt("origin_id"))) {
                jSONObject3.put("origin_id", i3);
                jSONObject2.put(LocalDataJsPlugin.NAME_SPACE, jSONObject3.toString());
                jSONObject.put(TtmlNode.TAG_METADATA, jSONObject2);
            }
        } catch (JSONException unused) {
            QLog.e("MatchFriendRequest", 2, "adjustArkMatchFriendSource function metaJson is null");
        }
        return jSONObject;
    }

    public static void k(AppInterface appInterface, List<String> list) {
        userInfo$BatchGetMiniUserInfoReq userinfo_batchgetminiuserinforeq = new userInfo$BatchGetMiniUserInfoReq();
        userinfo_batchgetminiuserinforeq.account_type.set(2);
        userinfo_batchgetminiuserinforeq.account_ids.set(list);
        userinfo_batchgetminiuserinforeq.mini_info_ids.add(14);
        userinfo_batchgetminiuserinforeq.mini_info_ids.add(7);
        userinfo_batchgetminiuserinforeq.mini_info_ids.add(24);
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.UserInfo.SsoBatchGetMiniUserInfo", userinfo_batchgetminiuserinforeq.toByteArray(), new f(aVar));
    }

    private static long m(QQAppInterface qQAppInterface, String str) {
        List<MessageRecord> E = qQAppInterface.getMessageFacade().E(str, 1046, null, 50);
        if (E == null || E.isEmpty() || E.get(0) == null) {
            return 0L;
        }
        return E.get(0).time;
    }

    public static void n(AppInterface appInterface, long j3, String str) {
        Prompt$GetAIOHintReq prompt$GetAIOHintReq = new Prompt$GetAIOHintReq();
        prompt$GetAIOHintReq.tiny_id.set(j3);
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.prompt.SsoGetAIOHint", prompt$GetAIOHintReq.toByteArray(), new k(aVar, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(QQAppInterface qQAppInterface, String str, int i3, String str2) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("MatchFriendRequest", 2, "insertArkMiniProfileCard arkMessage:" + str2);
            }
            com.tencent.mobileqq.matchfriend.nt.d.f244175a.b(qQAppInterface, str, q(qQAppInterface, str, i3, str2), true);
            return;
        }
        QLog.e("MatchFriendRequest", 1, "insertIcebreakerTopic but matchUin or app is empty");
    }

    public static void L(AppRuntime appRuntime, com.tencent.relation.common.servlet.c cVar) {
        K(appRuntime, 0, 0, cVar);
    }

    public static void s(AppInterface appInterface, String str, int i3) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[getCanAddFriend] app is null");
            return;
        }
        addFriend$SsoCanAddFriendReq addfriend_ssocanaddfriendreq = new addFriend$SsoCanAddFriendReq();
        if (TextUtils.isEmpty(str)) {
            QLog.e("MatchFriendRequest", 1, "[getCanAddFriend] openId is null");
            return;
        }
        addfriend_ssocanaddfriendreq.to_openid.set(str);
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.AddFriend.SsoCanAddFriend", addfriend_ssocanaddfriendreq.toByteArray(), new h(aVar, i3));
    }

    public static void v(AppInterface appInterface, long j3, String str) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[getIceBreakingTopic] app is null");
            return;
        }
        if (com.tencent.mobileqq.matchfriend.utils.b.d().h(String.valueOf(j3))) {
            QLog.i("MatchFriendRequest", 1, "[getIceBreakingTopic] has topic");
            return;
        }
        Prompt$GetIceBreakingTopicReq prompt$GetIceBreakingTopicReq = new Prompt$GetIceBreakingTopicReq();
        prompt$GetIceBreakingTopicReq.tiny_id.set(j3);
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.prompt.SsoGetIceBreakingTopic", prompt$GetIceBreakingTopicReq.toByteArray(), new w(j3, aVar, str));
    }

    public static void x(AppInterface appInterface, String str, com.tencent.mobileqq.matchfriend.api.a aVar) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[getIsFriend] app is null");
            if (aVar != null) {
                aVar.a(false, false);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("MatchFriendRequest", 1, "[getIsFriend] openId is null");
            if (aVar != null) {
                aVar.a(false, false);
                return;
            }
            return;
        }
        addFriend$SsoIsFriendReq addfriend_ssoisfriendreq = new addFriend$SsoIsFriendReq();
        addfriend_ssoisfriendreq.to_openid.set(str);
        com.tencent.relation.common.servlet.a aVar2 = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar2.Z0("QQStranger.AddFriend.SsoIsFriend", addfriend_ssoisfriendreq.toByteArray(), new g(aVar, aVar2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object[] z(userInfo$ControlFlag userinfo_controlflag, int i3) {
        Object[] objArr = {Boolean.FALSE, ""};
        if (userinfo_controlflag == null) {
            return objArr;
        }
        if (i3 == 101) {
            if (userinfo_controlflag.flag_id.get() == 101 && userinfo_controlflag.value.get() == 1) {
                objArr[0] = Boolean.TRUE;
                objArr[1] = userinfo_controlflag.document_config.body.get();
                QLog.i("MatchFriendRequest", 1, "[getMasterControl] flagId:" + i3 + " tips:" + objArr[1]);
            }
        } else if (i3 == 102 && userinfo_controlflag.flag_id.get() == 102 && (userinfo_controlflag.value.get() == 1 || userinfo_controlflag.value.get() == 2)) {
            objArr[0] = Boolean.TRUE;
            objArr[1] = userinfo_controlflag.document_config.body.get();
            QLog.i("MatchFriendRequest", 1, "[getMasterControl] flagId:" + i3 + " tips:" + objArr[1]);
        }
        return objArr;
    }

    private static long l(List<ChatMessage> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(list.size() - 1).shmsgseq + 1;
        }
        return Math.abs(new Random().nextInt());
    }

    private static MessageForArkApp q(QQAppInterface qQAppInterface, String str, int i3, String str2) {
        ArkAppMessage arkAppMessage = new ArkAppMessage();
        try {
            JSONObject i16 = i(new JSONObject(str2).optJSONObject(PublicAccountMessageUtilImpl.META_NAME), i3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "normal");
            jSONObject.put("showSender", 0);
            jSONObject.put("hintWidth", f245532a);
            jSONObject.put("hintHeight", 96);
            arkAppMessage.appId = "com.tencent.mobileqq.qqstranger.minicard";
            arkAppMessage.appName = "com.tencent.mobileqq.qqstranger.minicard";
            arkAppMessage.appDesc = "\u964c\u751f\u4eba\u4ea4\u53cbmini\u8d44\u6599\u5361\u52a8\u6001\u5316\u4e0b\u53d1";
            arkAppMessage.appView = "qqstranger_mini_profilecard";
            arkAppMessage.appMinVersion = "1.0.0.0";
            arkAppMessage.config = jSONObject.toString();
            arkAppMessage.metaList = i16 != null ? i16.toString() : null;
            long l3 = l(qQAppInterface.getMessageFacade().l1(str, 1046));
            long m3 = m(qQAppInterface, str);
            long serverTimeMillis = m3 == 0 ? NetConnInfoCenter.getServerTimeMillis() / 1000 : m3 - 1;
            MessageForArkApp messageForArkApp = (MessageForArkApp) com.tencent.mobileqq.service.message.q.d(-4071);
            messageForArkApp.init(qQAppInterface.getCurrentAccountUin(), str, qQAppInterface.getCurrentAccountUin(), "mini profile ark message", serverTimeMillis, -4071, 1046, l3);
            messageForArkApp.ark_app_message = arkAppMessage;
            messageForArkApp.frienduin = str;
            messageForArkApp.mNeedTimeStamp = false;
            messageForArkApp.isread = true;
            messageForArkApp.shmsgseq = l3;
            messageForArkApp.getBytes();
            messageForArkApp.parse();
            return messageForArkApp;
        } catch (Exception e16) {
            QLog.e("MatchFriendRequest", 1, "ArkMiniProfileCardMessage error", e16);
            return null;
        }
    }

    public static void r(AppInterface appInterface, String str) {
        s(appInterface, str, 13);
    }

    private static MessageForArkApp w(QQAppInterface qQAppInterface, String str, String str2) {
        ArkAppMessage arkAppMessage = new ArkAppMessage();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONObject optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            String optString = jSONObject.optString("app");
            String optString2 = jSONObject.optString("view");
            String optString3 = jSONObject.optString("prompt");
            String optString4 = jSONObject.optString("ver");
            arkAppMessage.appId = optString;
            arkAppMessage.appName = optString;
            arkAppMessage.promptText = optString3;
            arkAppMessage.appView = optString2;
            arkAppMessage.appMinVersion = optString4;
            arkAppMessage.config = optJSONObject != null ? optJSONObject.toString() : null;
            arkAppMessage.metaList = optJSONObject2 != null ? optJSONObject2.toString() : null;
            long l3 = l(qQAppInterface.getMessageFacade().l1(str, 1046));
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
            MessageForArkApp messageForArkApp = (MessageForArkApp) com.tencent.mobileqq.service.message.q.d(-4072);
            messageForArkApp.init(qQAppInterface.getCurrentAccountUin(), str, qQAppInterface.getCurrentAccountUin(), "mini profile ark message", serverTimeMillis, -4072, 1046, l3);
            messageForArkApp.ark_app_message = arkAppMessage;
            messageForArkApp.frienduin = str;
            messageForArkApp.mNeedTimeStamp = false;
            messageForArkApp.isread = true;
            messageForArkApp.shmsgseq = l3;
            messageForArkApp.getBytes();
            messageForArkApp.parse();
            return messageForArkApp;
        } catch (Exception e16) {
            QLog.e("MatchFriendRequest", 1, "initIcebreakerTopicMessage error", e16);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class e implements com.tencent.relation.common.servlet.b {
        e() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (!z16 || obj == null) {
                QLog.e("MatchFriendRequest", 1, "[reportMatchFriendJubao] isSuccess:" + z16 + ", data:" + obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class i implements com.tencent.relation.common.servlet.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.c f245557d;

        i(com.tencent.relation.common.servlet.c cVar) {
            this.f245557d = cVar;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            Object valueOf;
            boolean z17;
            LoginSvr$LoginInfoReportRsp loginSvr$LoginInfoReportRsp;
            int i16;
            String str;
            boolean z18;
            boolean z19;
            int i17;
            Bundle bundle2;
            com.tencent.relation.common.servlet.c cVar;
            byte[] byteArray = bundle.getByteArray("rsp_data");
            boolean z26 = true;
            if (!z16 || byteArray == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[loginInfoReport], isSuccess:");
                sb5.append(z16);
                sb5.append(", data:");
                if (byteArray == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(byteArray.length);
                }
                sb5.append(valueOf);
                QLog.e("MatchFriendRequest", 1, sb5.toString());
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                try {
                    loginSvr$LoginInfoReportRsp = new LoginSvr$LoginInfoReportRsp();
                    loginSvr$LoginInfoReportRsp.mergeFrom(byteArray);
                    i16 = loginSvr$LoginInfoReportRsp.ret_code.get();
                    str = loginSvr$LoginInfoReportRsp.open_id.get();
                    z18 = loginSvr$LoginInfoReportRsp.is_new_user.get();
                    z19 = loginSvr$LoginInfoReportRsp.new_register.get();
                    i17 = loginSvr$LoginInfoReportRsp.user_type.get();
                    QLog.i("MatchFriendRequest", 1, "[loginInfoReport] retCode:" + i16 + ", openId:" + str);
                    bundle2 = new Bundle();
                    bundle2.putString("key_open_id", str);
                    bundle2.putBoolean("key_is_new_user", z18);
                    bundle2.putBoolean("ket_is_new_register", z19);
                    bundle2.putInt("key_user_type", i17);
                    com.tencent.relation.common.utils.g.b().c(str);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendRequest", 1, "[loginInfoReport] error", e16);
                }
                if (i16 != 0) {
                    if (i16 == 2) {
                        if (this.f245557d != null) {
                            bundle2.putBoolean("key_is_forbid", true);
                            if (loginSvr$LoginInfoReportRsp.document_config.has()) {
                                userInfo$DocumentConfig userinfo_documentconfig = loginSvr$LoginInfoReportRsp.document_config.get();
                                bundle2.putString("key_forbid_title", userinfo_documentconfig.title.get());
                                bundle2.putString("key_forbid_body", userinfo_documentconfig.body.get());
                                bundle2.putString("key_forbid_tips", userinfo_documentconfig.tips.get());
                                bundle2.putInt("key_forbid_window_type", userinfo_documentconfig.window_type.get());
                            }
                            this.f245557d.onReceive(0, true, bundle2);
                        }
                    }
                    if (z26 || (cVar = this.f245557d) == null) {
                    }
                    cVar.onReceive(0, false, new Bundle());
                    return;
                }
                if (this.f245557d != null) {
                    bundle2.putBoolean("key_is_forbid", false);
                    bundle2.putString("key_open_id", str);
                    bundle2.putBoolean("key_is_new_user", z18);
                    bundle2.putBoolean("ket_is_new_register", z19);
                    bundle2.putInt("key_user_type", i17);
                    this.f245557d.onReceive(0, true, bundle2);
                }
            }
            z26 = z17;
            if (z26) {
            }
        }
    }

    public static void A(AppInterface appInterface) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[getMatchFriendEntrance] app is null");
            return;
        }
        GrayCtrl$EntranceCtrlReq grayCtrl$EntranceCtrlReq = new GrayCtrl$EntranceCtrlReq();
        grayCtrl$EntranceCtrlReq.qq_mode.set(SimpleUIUtil.getCurrentMode(StudyModeManager.t()));
        ((com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4)).Z0("trpc.kuolie.gray_ctrl.GrayCtrl.SsoEntranceCtrl", grayCtrl$EntranceCtrlReq.toByteArray(), new r(appInterface));
    }

    public static void B(AppInterface appInterface, long j3) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[getUserShield] app is null");
            return;
        }
        Security$GetShieldUserReq security$GetShieldUserReq = new Security$GetShieldUserReq();
        security$GetShieldUserReq.tiny_id.set(j3);
        security$GetShieldUserReq.source.set("AndroidSettingShield");
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.UserInfo.SsoGetShieldUser", security$GetShieldUserReq.toByteArray(), new c(aVar));
    }

    public static void C(AppInterface appInterface, long j3, long j16) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[getVoiceLinkIceBreakTopic] app is null");
            return;
        }
        Prompt$GetVoiceLinkTopicReq prompt$GetVoiceLinkTopicReq = new Prompt$GetVoiceLinkTopicReq();
        prompt$GetVoiceLinkTopicReq.account_type.set(2);
        prompt$GetVoiceLinkTopicReq.self_account_id.set(String.valueOf(j16));
        prompt$GetVoiceLinkTopicReq.account_id.set(String.valueOf(j3));
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.prompt.SsoGetVoiceLinkTopic", prompt$GetVoiceLinkTopicReq.toByteArray(), new m(aVar));
    }

    public static void D(AppInterface appInterface, long j3, String str) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[greetReport] app is null");
            return;
        }
        aioMsg$SsoGreetReportReq aiomsg_ssogreetreportreq = new aioMsg$SsoGreetReportReq();
        aiomsg_ssogreetreportreq.to_tinyid.set(j3);
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.AIOMsg.SsoGreetReport", aiomsg_ssogreetreportreq.toByteArray(), new u(aVar, str));
    }

    public static void G(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.e("MatchFriendRequest", 1, "[heartbeat] app is null");
        } else {
            ((IRelationSSORequestHandler) QRoute.api(IRelationSSORequestHandler.class)).request(appRuntime, "QQStranger.Report.SsoHeartBeat", new MessageMicro<report$HearBeatReq>() { // from class: com.tencent.trpcprotocol.kuolie.report.report.report$HearBeatReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], report$HearBeatReq.class);
            }.toByteArray(), new q());
        }
    }

    public static void K(AppRuntime appRuntime, int i3, int i16, com.tencent.relation.common.servlet.c cVar) {
        if (appRuntime == null) {
            QLog.e("MatchFriendRequest", 1, "[loginInfoReport] app is null");
            return;
        }
        LoginSvr$LoginInfoReportReq loginSvr$LoginInfoReportReq = new LoginSvr$LoginInfoReportReq();
        loginSvr$LoginInfoReportReq.login_source.set(i3);
        loginSvr$LoginInfoReportReq.sub_source.set(i16);
        ((IRelationSSORequestHandler) QRoute.api(IRelationSSORequestHandler.class)).request(appRuntime, "QQStranger.login_svr.SsoLoginInfoReport", loginSvr$LoginInfoReportReq.toByteArray(), new i(cVar));
    }

    public static void M(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.e("MatchFriendRequest", 1, "[logout] app is null");
        } else {
            ((IRelationSSORequestHandler) QRoute.api(IRelationSSORequestHandler.class)).request(appRuntime, "QQStranger.login_svr.SsoLogout", new MessageMicro<LoginSvr$LogoutReq>() { // from class: com.tencent.trpcprotocol.kuolie.login_svr.login_svr.LoginSvr$LogoutReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], LoginSvr$LogoutReq.class);
            }.toByteArray(), new p());
        }
    }

    public static void S(AppInterface appInterface, long j3, int i3, String str) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[setFirstRelationOrigin] app is null");
            return;
        }
        Relation$SsoSetFirstRelationOriginReq relation$SsoSetFirstRelationOriginReq = new Relation$SsoSetFirstRelationOriginReq();
        relation$SsoSetFirstRelationOriginReq.to_tinyid.set(j3);
        relation$SsoSetFirstRelationOriginReq.origin_id.set(i3);
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.Relation.SsoSetFirstRelationOrigin", relation$SsoSetFirstRelationOriginReq.toByteArray(), new s(aVar, str));
    }

    public static void U(AppInterface appInterface, long j3, boolean z16) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[setUserShield] app is null");
            return;
        }
        Security$ShieldReq security$ShieldReq = new Security$ShieldReq();
        security$ShieldReq.tiny_id.set(j3);
        security$ShieldReq.is_shield.set(z16);
        security$ShieldReq.source.set("AndroidSettingShield");
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.UserInfo.SsoSetShieldUser", security$ShieldReq.toByteArray(), new d(appInterface, j3, aVar));
    }

    public static void j(AppInterface appInterface, long j3, int i3, int i16, long j16, String str) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[aioReport] app is null");
            return;
        }
        aioMsg$SsoAIOReportReq aiomsg_ssoaioreportreq = new aioMsg$SsoAIOReportReq();
        aiomsg_ssoaioreportreq.to_tinyid.set(j3);
        aiomsg_ssoaioreportreq.aio_action.set(i3);
        aiomsg_ssoaioreportreq.aio_source.set(i16);
        aioMsg$SoulMatchData aiomsg_soulmatchdata = new aioMsg$SoulMatchData();
        aiomsg_soulmatchdata.topic_id.set(j16);
        aiomsg_ssoaioreportreq.ext_data.set(ByteStringMicro.copyFrom(aiomsg_soulmatchdata.toByteArray()));
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.AIOMsg.SsoAIOReport", aiomsg_ssoaioreportreq.toByteArray(), new v(aVar, str));
    }

    public static void o(AppInterface appInterface, long j3, String str) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[getAioSign] app is null");
            return;
        }
        aioMsg$GetAIOSignReq aiomsg_getaiosignreq = new aioMsg$GetAIOSignReq();
        aiomsg_getaiosignreq.to_tinyid.set(j3);
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.AIOMsg.SsoGetAIOSign", aiomsg_getaiosignreq.toByteArray(), new a(aVar, str));
    }

    public static void p(AppInterface appInterface, String str, String str2, int i3, boolean z16, String str3) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[getArkMiniProfileCardInfo] app is null");
            return;
        }
        userInfo$GetArkInfoReq userinfo_getarkinforeq = new userInfo$GetArkInfoReq();
        userinfo_getarkinforeq.self_account_id.set(str);
        userinfo_getarkinforeq.account_id.set(str2);
        userinfo_getarkinforeq.account_type.set(2);
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.UserInfo.SsoGetArkInfo", userinfo_getarkinforeq.toByteArray(), new b(str2, i3, z16, str3, aVar));
    }

    public static void t(AppInterface appInterface, long j3, String str) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[getCanGreet] app is null");
            return;
        }
        aioMsg$SsoCanGreetReq aiomsg_ssocangreetreq = new aioMsg$SsoCanGreetReq();
        aiomsg_ssocangreetreq.to_tinyid.set(j3);
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.AIOMsg.SsoCanGreet", aiomsg_ssocangreetreq.toByteArray(), new t(aVar, str));
    }

    public static void u(AppInterface appInterface, com.tencent.relation.common.servlet.b bVar) {
        y(appInterface, 102, 0, bVar);
    }

    private static void y(AppInterface appInterface, int i3, int i16, com.tencent.relation.common.servlet.b bVar) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "[getMasterControl] app is null");
            return;
        }
        userInfo$GetMasterControlReq userinfo_getmastercontrolreq = new userInfo$GetMasterControlReq();
        int H = H(userinfo_getmastercontrolreq, i3, i16);
        if (H <= 0) {
            return;
        }
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0("QQStranger.UserInfo.SsoGetMasterControl", userinfo_getmastercontrolreq.toByteArray(), new o(i3, bVar, aVar, H));
    }

    public static boolean O(AppInterface appInterface) {
        if (appInterface == null) {
            QLog.e("MatchFriendRequest", 1, "reportDynamicEntrance fail, app is null");
            return false;
        }
        if (!((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).getMatchFriendEntrance(appInterface)) {
            return false;
        }
        boolean isPluginOpen = ((ILebaHelperService) appInterface.getRuntimeService(ILebaHelperService.class, "")).isPluginOpen(4038L);
        if (!V(isPluginOpen)) {
            return true;
        }
        UserConfig$SetOptionsReq userConfig$SetOptionsReq = new UserConfig$SetOptionsReq();
        userConfig$SetOptionsReq.option_ids.set(Collections.singletonList(5));
        UserConfig$Options userConfig$Options = new UserConfig$Options();
        UserConfig$HidePluginOption userConfig$HidePluginOption = new UserConfig$HidePluginOption();
        userConfig$HidePluginOption.hide.set(!isPluginOpen);
        userConfig$Options.hide_plugin_option.set(userConfig$HidePluginOption);
        userConfig$SetOptionsReq.options.set(userConfig$Options);
        ((com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4)).Z0("QQStranger.user_config.SsoSetOptions", userConfig$SetOptionsReq.toByteArray(), new j(isPluginOpen, appInterface));
        return true;
    }
}
