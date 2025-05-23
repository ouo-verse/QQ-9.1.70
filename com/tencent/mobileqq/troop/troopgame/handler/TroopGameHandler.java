package com.tencent.mobileqq.troop.troopgame.handler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.api.f;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.mobileqq.troop.troopgame.api.a;
import com.tencent.mobileqq.troop.troopgame.data.GradeDistributedInfo;
import com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopMetaDreamGameInfo;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopOperationRepo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$GetSwitchReq;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$GetSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$SetSwitchReq;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$SetSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$ShowQuickAuthorizeReq;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$ShowQuickAuthorizeRsp;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$GetGradeDistributeInfoReq;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$GetGradeDistributeInfoRsp;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$GetGroupUserInfoReq;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$GetGroupUserInfoRsp;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$GetGroupUserSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$GradeDistributed;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$SetGroupUserSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard$GradeDistributed;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard$NotifyUpdateReq;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard$QueryGroupInfoReq;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard$QueryGroupInfoRsp;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$GameAreaRole;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$GameDetail;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$GetGameDetailAndSkinWallReq;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$GetGameDetailAndSkinWallRsp;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$GetSkinsRspPBV2;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$MDUserProfile;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$SeriesDisplay;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$Skin;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$SummaryPBV2;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$UserHeroInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$ClientInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$ReqBody;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$RspBody;
import tencent.im.oidb.cmd0xf3c.oidb_0xf3c$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.trpcprotocol.SmobaMotorcadeSvrPB$IsUserInMotorcadeReq;
import tencent.trpcprotocol.SmobaMotorcadeSvrPB$IsUserInMotorcadeRsp;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGameHandler extends TroopBaseHandler implements com.tencent.mobileqq.troop.troopgame.api.a, WadlTrpcListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    HashSet<String> f300289e;

    /* renamed from: f, reason: collision with root package name */
    private AppInterface f300290f;

    /* renamed from: h, reason: collision with root package name */
    protected Set<String> f300291h;

    /* renamed from: i, reason: collision with root package name */
    private ITroopMemberInfoService.b f300292i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements ITroopMemberInfoService.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGameHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
        public void b(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
        public void c(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
        public void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                ((ITroopGameApi) QRoute.api(ITroopGameApi.class)).handleJoinOrExitTroop(str, false, false);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
        public void e(String str, List<TroopMemberInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) list);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
        public void f(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            } else if (TroopGameHandler.this.f300290f.getCurrentUin().equals(str2)) {
                ((ITroopGameApi) QRoute.api(ITroopGameApi.class)).handleJoinOrExitTroop(str, false, true);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
        public void g(ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC8809a f300294a;

        b(a.InterfaceC8809a interfaceC8809a) {
            this.f300294a = interfaceC8809a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGameHandler.this, (Object) interfaceC8809a);
            }
        }

        private void d(final a.InterfaceC8809a interfaceC8809a, final boolean z16, final boolean z17) {
            if (interfaceC8809a == null) {
                return;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                interfaceC8809a.a(z16, z17);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopgame.handler.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.InterfaceC8809a.this.a(z16, z17);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NonNull TroopTrpcRemoteResponse troopTrpcRemoteResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopTrpcRemoteResponse);
                return;
            }
            QLog.w("TroopGameHandler", 1, "[onError] isUserInGameTeam. code:" + troopTrpcRemoteResponse.code + ", msg: " + troopTrpcRemoteResponse.f293941msg);
            d(this.f300294a, false, false);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NonNull TroopTrpcRemoteResponse troopTrpcRemoteResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopTrpcRemoteResponse);
                return;
            }
            SmobaMotorcadeSvrPB$IsUserInMotorcadeRsp smobaMotorcadeSvrPB$IsUserInMotorcadeRsp = new SmobaMotorcadeSvrPB$IsUserInMotorcadeRsp();
            try {
                smobaMotorcadeSvrPB$IsUserInMotorcadeRsp.mergeFrom(troopTrpcRemoteResponse.data);
                d(this.f300294a, true, smobaMotorcadeSvrPB$IsUserInMotorcadeRsp.is_in_motorcade.get());
            } catch (InvalidProtocolBufferMicroException unused) {
                d(this.f300294a, false, false);
            }
        }
    }

    public TroopGameHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f300289e = new HashSet<>();
        this.f300292i = new a();
        this.f300290f = appInterface;
        this.f300289e.add(WadlProxyConsts.CMD_TRPC_GAME_QUERRYGROUPINFO);
        this.f300289e.add(WadlProxyConsts.CMD_TRPC_GAME_QUERY_CARDINFO);
        this.f300289e.add(WadlProxyConsts.CMD_TRPC_GAME_QUERY_METADREAM_TROOP_INFO);
        this.f300289e.add(WadlProxyConsts.CMD_TRPC_GAME_QUERY_METADREAM_MEMBER_INFO);
        this.f300289e.add(WadlProxyConsts.CMD_TRPC_GAME_QUERY_METADREAM_USER_SWITCH);
        this.f300289e.add(WadlProxyConsts.CMD_TRPC_GAME_SET_METADREAM_USER_SWITCH);
        this.f300289e.add(WadlProxyConsts.CMD_TRPC_GAME_QUERY_GAME_INFO_USER_SWITCH);
        this.f300289e.add(WadlProxyConsts.CMD_TRPC_GAME_SET_GAME_INFO_USER_SWITCH);
        this.f300289e.add(WadlProxyConsts.CMD_TRPC_GAME_QUERY_GAME_INFO_QUICK_AUTH);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
        ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) this.f300290f.getRuntimeService(ITroopMemberInfoService.class, "");
        if (iTroopMemberInfoService != null) {
            iTroopMemberInfoService.addTroopMemberUpdateObserver(this.f300292i);
        }
    }

    private TrpcProxy.TrpcListReq G2(String str, byte[] bArr, int i3) {
        TrpcProxy.TrpcMsg trpcMsg = new TrpcProxy.TrpcMsg();
        trpcMsg.clientRPCName.set(str);
        TrpcProxy.TrpcOptions trpcOptions = new TrpcProxy.TrpcOptions();
        trpcOptions.currentSerializationType.set(4);
        trpcOptions.serializationType.set(0);
        trpcOptions.requestType.set(i3);
        TrpcProxy.TrpcInovkeReq trpcInovkeReq = new TrpcProxy.TrpcInovkeReq();
        trpcInovkeReq.f106730msg.set(trpcMsg);
        trpcInovkeReq.data.set(ByteStringMicro.copyFrom(bArr));
        trpcInovkeReq.options.set(trpcOptions);
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(trpcInovkeReq);
        return trpcListReq;
    }

    private void H2(String str, String str2, String str3, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        bundle.putString("memberUin", str2);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(G2(str3, bArr, 0), bundle);
    }

    private void I2(String str, String str2, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(G2(str2, bArr, 0), bundle);
    }

    private void L2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null) {
            QLog.d("TroopGameHandler", 1, "handleGetGameInfoQuickAuth ret=" + j3);
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    QqCardSvrPB$ShowQuickAuthorizeRsp qqCardSvrPB$ShowQuickAuthorizeRsp = new QqCardSvrPB$ShowQuickAuthorizeRsp();
                    qqCardSvrPB$ShowQuickAuthorizeRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_INFO_QUICK_AUTH, true, new Object[]{qqCardSvrPB$ShowQuickAuthorizeRsp});
                    return;
                } catch (Exception e16) {
                    QLog.d("TroopGameHandler", 1, "handleGetGameInfoQuickAuth Exception: " + e16);
                    return;
                }
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_INFO_QUICK_AUTH, false, new Object[]{null});
            return;
        }
        QLog.d("TroopGameHandler", 1, "handleGetGameInfoQuickAuth request | rsp is null");
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_INFO_QUICK_AUTH, false, null);
    }

    private void M2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString("memberUin");
            QLog.d("TroopGameHandler", 1, "handleGetGameInfoUserSwitch ret=" + j3 + ", memberUin=" + string);
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    QqCardSvrPB$GetSwitchRsp qqCardSvrPB$GetSwitchRsp = new QqCardSvrPB$GetSwitchRsp();
                    qqCardSvrPB$GetSwitchRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_INFO_SWITCH, true, new Object[]{string, qqCardSvrPB$GetSwitchRsp});
                    return;
                } catch (Exception e16) {
                    QLog.d("TroopGameHandler", 1, "handleGetGameInfoUserSwitch Exception: " + e16);
                    return;
                }
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_INFO_SWITCH, false, new Object[]{string, null});
            return;
        }
        QLog.d("TroopGameHandler", 1, "handleGetGameInfoUserSwitch request | rsp | extra is null");
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_INFO_SWITCH, false, null);
    }

    private void N2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString("troopUin");
            String string2 = intent.getExtras().getString("memberUin");
            QLog.d("TroopGameHandler", 1, "handleGetMyTroopMetaDreamUserSwitch ret=" + j3 + ", troopUin=" + string + ", memberUin=" + string2);
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    MessageMicro<metadream_qgroup_datacard$GetGroupUserSwitchRsp> messageMicro = new MessageMicro<metadream_qgroup_datacard$GetGroupUserSwitchRsp>() { // from class: com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$GetGroupUserSwitchRsp
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"switch_err", ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, "uin", "download_url", "auth_url"}, new Object[]{0, 0, 0L, "", ""}, metadream_qgroup_datacard$GetGroupUserSwitchRsp.class);
                        public final PBEnumField switch_err = PBField.initEnum(0);
                        public final PBEnumField switch_status = PBField.initEnum(0);
                        public final PBUInt64Field uin = PBField.initUInt64(0);
                        public final PBStringField download_url = PBField.initString("");
                        public final PBStringField auth_url = PBField.initString("");
                    };
                    messageMicro.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_META_DREAM_SWITCH, true, new Object[]{string, string2, messageMicro});
                    return;
                } catch (Exception e16) {
                    QLog.d("TroopGameHandler", 1, "handleSetMyTroopMetaDreamUserSwitchResp Exception: " + e16);
                    return;
                }
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_META_DREAM_SWITCH, false, new Object[]{string, string2, null});
            return;
        }
        QLog.d("TroopGameHandler", 1, "handleGetMyTroopMetaDreamUserSwitch request | rsp | extra is null");
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_META_DREAM_SWITCH, false, null);
    }

    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            String string = toServiceMsg.extraData.getString("troopUin");
            long j3 = toServiceMsg.extraData.getInt("appid");
            oidb_0xf3c$RspBody oidb_0xf3c_rspbody = new oidb_0xf3c$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xf3c_rspbody);
            if (parseOIDBPkg == 0) {
                TroopGameActivityInfo troopGameActivityInfo = new TroopGameActivityInfo();
                troopGameActivityInfo.activityValue = oidb_0xf3c_rspbody.active_num.get();
                troopGameActivityInfo.rankNum = oidb_0xf3c_rspbody.rank_num.get();
                troopGameActivityInfo.rankEntrance = oidb_0xf3c_rspbody.rank_entrance.get().toStringUtf8();
                troopGameActivityInfo.iconUrl = oidb_0xf3c_rspbody.icon.get().toStringUtf8();
                troopGameActivityInfo.rankText = oidb_0xf3c_rspbody.rank_text.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                    QLog.i("TroopGameHandler", 1, "handleGetTroopGameActivityInfo succ, info = " + troopGameActivityInfo.toString());
                }
                notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_GET_TROOP_GAME_ACTIVITY_INFO, true, new Object[]{string, Long.valueOf(j3), troopGameActivityInfo});
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopGameHandler", 1, "handleGetTroopGameActivityInfo failed, result = " + parseOIDBPkg);
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_GET_TROOP_GAME_ACTIVITY_INFO, false, new Object[]{string, Long.valueOf(j3), null});
        }
    }

    private void P2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString("troopUin");
            QLog.d("TroopGameHandler", 1, "handleGetTroopGameCardResp troopUin=" + string);
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    sgame_qgroup_datacard$QueryGroupInfoRsp sgame_qgroup_datacard_querygroupinforsp = new sgame_qgroup_datacard$QueryGroupInfoRsp();
                    sgame_qgroup_datacard_querygroupinforsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    TroopGameInfo troopGameInfo = new TroopGameInfo();
                    for (sgame_qgroup_datacard$GradeDistributed sgame_qgroup_datacard_gradedistributed : sgame_qgroup_datacard_querygroupinforsp.gradeDistributedList.get()) {
                        if (sgame_qgroup_datacard_gradedistributed != null) {
                            GradeDistributedInfo gradeDistributedInfo = new GradeDistributedInfo();
                            gradeDistributedInfo.grade = sgame_qgroup_datacard_gradedistributed.grade.get();
                            gradeDistributedInfo.userCount = sgame_qgroup_datacard_gradedistributed.userCount.get();
                            troopGameInfo.gradeDistributedList.add(gradeDistributedInfo);
                        }
                    }
                    troopGameInfo.fightScore = sgame_qgroup_datacard_querygroupinforsp.fightScore.get();
                    troopGameInfo.fightScoreRank = sgame_qgroup_datacard_querygroupinforsp.fightScoreRank.get();
                    troopGameInfo.weekGPlayGameCount = sgame_qgroup_datacard_querygroupinforsp.weekPlayGameCount.get();
                    troopGameInfo.weekPlayUserCount = sgame_qgroup_datacard_querygroupinforsp.weekPlayUserCount.get();
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_GAME_CARD, true, new Object[]{string, troopGameInfo});
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopGameHandler", 1, "handleGetTroopGameCardResp Exception: " + e16);
                    }
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_GAME_CARD, false, new Object[]{string, null});
                    e16.printStackTrace();
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameHandler", 1, "handleGetTroopGameCardResp failed, ret: " + j3);
            }
            if (j3 == 200018) {
                notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_GAME_CARD, true, new Object[]{string, null});
                return;
            } else {
                notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_GAME_CARD, false, new Object[]{string, null});
                return;
            }
        }
        QLog.d("TroopGameHandler", 1, "handleGetTroopGameCardResp request | rsp | extra is null");
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_GAME_CARD, false, null);
    }

    private void Q2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        String str;
        if (intent != null && trpcInovkeRsp != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString("troopUin");
            String string2 = intent.getExtras().getString("memberUin");
            QLog.d("TroopGameHandler", 1, "handleGetTroopMemberGameCardV2 ret=" + j3 + ",troopUin=" + string + ",memberUin=" + string2);
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    sgame_skin_wall$GetGameDetailAndSkinWallRsp sgame_skin_wall_getgamedetailandskinwallrsp = new sgame_skin_wall$GetGameDetailAndSkinWallRsp();
                    sgame_skin_wall_getgamedetailandskinwallrsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    sgame_skin_wall$GameDetail sgame_skin_wall_gamedetail = sgame_skin_wall_getgamedetailandskinwallrsp.game_detail.get();
                    sgame_skin_wall$GetSkinsRspPBV2 sgame_skin_wall_getskinsrsppbv2 = sgame_skin_wall_getgamedetailandskinwallrsp.skin_wall.get();
                    ProfileGameInfo profileGameInfo = new ProfileGameInfo();
                    profileGameInfo.mGrade = sgame_skin_wall_gamedetail.grade.get();
                    profileGameInfo.seasonWinRate = sgame_skin_wall_gamedetail.season_win_rate.get();
                    profileGameInfo.gamesTotal = sgame_skin_wall_gamedetail.games_total.get();
                    profileGameInfo.mvpTotal = sgame_skin_wall_gamedetail.mvp_total.get();
                    profileGameInfo.bestOccupation = sgame_skin_wall_gamedetail.best_occupation.get();
                    profileGameInfo.encrptOpenId = sgame_skin_wall_gamedetail.encrpt_open_id.get();
                    profileGameInfo.partition = sgame_skin_wall_gamedetail.partition.get();
                    profileGameInfo.platid = sgame_skin_wall_gamedetail.platid.get();
                    profileGameInfo.area = sgame_skin_wall_gamedetail.area.get();
                    for (int i3 = 0; i3 < sgame_skin_wall_gamedetail.best_hero_list.size(); i3++) {
                        sgame_skin_wall$UserHeroInfo sgame_skin_wall_userheroinfo = sgame_skin_wall_gamedetail.best_hero_list.get(i3);
                        if (sgame_skin_wall_userheroinfo != null) {
                            profileGameInfo.bestHeroList.add(new ProfileGameInfo.UserHeroInfo(sgame_skin_wall_userheroinfo.hero_id.get(), sgame_skin_wall_userheroinfo.icon.get(), sgame_skin_wall_userheroinfo.skill.get()));
                        }
                    }
                    sgame_skin_wall$SummaryPBV2 sgame_skin_wall_summarypbv2 = sgame_skin_wall_getskinsrsppbv2.summary.get();
                    profileGameInfo.currSkinCount = sgame_skin_wall_summarypbv2.owned.get();
                    profileGameInfo.skinTotal = sgame_skin_wall_summarypbv2.total.get();
                    profileGameInfo.skinPrice = sgame_skin_wall_summarypbv2.price.get();
                    profileGameInfo.skinHonor = sgame_skin_wall_summarypbv2.honor.get();
                    profileGameInfo.skinHonorIcon = sgame_skin_wall_summarypbv2.honor_badge_url.get();
                    sgame_skin_wall$GameAreaRole sgame_skin_wall_gamearearole = sgame_skin_wall_getskinsrsppbv2.role_info.get();
                    profileGameInfo.skinRoleId = sgame_skin_wall_gamearearole.role_id.get();
                    profileGameInfo.skinPartition = sgame_skin_wall_gamearearole.partition.get();
                    for (sgame_skin_wall$SeriesDisplay sgame_skin_wall_seriesdisplay : sgame_skin_wall_getskinsrsppbv2.series.get()) {
                        sgame_skin_wall$Skin sgame_skin_wall_skin = sgame_skin_wall_seriesdisplay.first_skin.get();
                        String str2 = sgame_skin_wall_seriesdisplay.name.get();
                        int i16 = sgame_skin_wall_seriesdisplay.owns_skin_num.get();
                        int size = sgame_skin_wall_seriesdisplay.skins.get().size();
                        if (sgame_skin_wall_skin == null) {
                            str = "";
                        } else {
                            str = sgame_skin_wall_skin.icon.get();
                        }
                        profileGameInfo.skinGroupList.add(new ProfileGameInfo.SkinGroupInfo(str2, i16, size, str));
                    }
                    QLog.d("TroopGameHandler", 1, "handleGetTroopMemberGameCardV2 gameInfo=" + profileGameInfo);
                    ITroopGameCardService iTroopGameCardService = (ITroopGameCardService) this.f300290f.getRuntimeService(ITroopGameCardService.class, "");
                    if (iTroopGameCardService != null) {
                        MemberGradeLevelInfo memberGradeLevelInfo = new MemberGradeLevelInfo();
                        memberGradeLevelInfo.memberuin = string2;
                        memberGradeLevelInfo.gradeLevel = profileGameInfo.mGrade;
                        iTroopGameCardService.saveMemberGradeLevelInfo(memberGradeLevelInfo);
                    }
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, true, new Object[]{string, string2, profileGameInfo});
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopGameHandler", 1, "handleGetTroopMemberGameCardResp Exception: " + e16);
                    }
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, false, new Object[]{string, string2, null});
                    e16.printStackTrace();
                    return;
                }
            }
            if (j3 == 200004) {
                MemberGradeLevelInfo memberGradeLevelInfo2 = new MemberGradeLevelInfo();
                memberGradeLevelInfo2.memberuin = string2;
                memberGradeLevelInfo2.gradeLevel = 0;
                ITroopGameCardService iTroopGameCardService2 = (ITroopGameCardService) this.f300290f.getRuntimeService(ITroopGameCardService.class, "");
                if (iTroopGameCardService2 != null) {
                    iTroopGameCardService2.saveMemberGradeLevelInfo(memberGradeLevelInfo2);
                }
                notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, true, new Object[]{string, string2, null});
                return;
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, false, new Object[]{string, string2, null});
            return;
        }
        QLog.d("TroopGameHandler", 1, "handleGetTroopMemberGameCardV2 request | rsp | extra is null");
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, false, null);
    }

    private void R2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString("troopUin");
            String string2 = intent.getExtras().getString("memberUin");
            QLog.d("TroopGameHandler", 1, "handleGetTroopMemberMetaDreamCardResp troopUin=" + string + ", memberUin=" + string2);
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    metadream_qgroup_datacard$GetGroupUserInfoRsp metadream_qgroup_datacard_getgroupuserinforsp = new metadream_qgroup_datacard$GetGroupUserInfoRsp();
                    metadream_qgroup_datacard_getgroupuserinforsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_MEMBER_META_DREAM_CARD, true, new Object[]{string, string2, metadream_qgroup_datacard_getgroupuserinforsp});
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopGameHandler", 1, "handleGetTroopMemberMetaDreamCardResp Exception: " + e16);
                    }
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_MEMBER_META_DREAM_CARD, false, new Object[]{string, string2, null});
                    e16.printStackTrace();
                    return;
                }
            }
            QLog.d("TroopGameHandler", 1, "handleGetTroopMemberMetaDreamCardResp failed, ret: " + j3);
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_MEMBER_META_DREAM_CARD, false, new Object[]{string, string2, null});
            return;
        }
        QLog.d("TroopGameHandler", 1, "handleGetTroopMemberMetaDreamCardResp request | rsp | extra is null");
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_MEMBER_META_DREAM_CARD, false, null);
    }

    private void S2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString("troopUin");
            String string2 = intent.getExtras().getString("memberUin");
            QLog.d("TroopGameHandler", 1, "handleGetTroopMemberYuanMengCard ret=" + j3 + ",troopUin=" + string + ",memberUin=" + string2);
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    sgame_skin_wall$GetGameDetailAndSkinWallRsp sgame_skin_wall_getgamedetailandskinwallrsp = new sgame_skin_wall$GetGameDetailAndSkinWallRsp();
                    sgame_skin_wall_getgamedetailandskinwallrsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    sgame_skin_wall$MDUserProfile sgame_skin_wall_mduserprofile = sgame_skin_wall_getgamedetailandskinwallrsp.md_user_profile.get();
                    QLog.d("TroopGameHandler", 1, "handleGetTroopMemberYuanMengCard userProfile=" + sgame_skin_wall_mduserprofile);
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_YUAN_MENG_CARD, true, new Object[]{string, string2, sgame_skin_wall_mduserprofile});
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopGameHandler", 1, "handleGetTroopMemberYuanMengCard Exception: " + e16);
                    }
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_YUAN_MENG_CARD, false, new Object[]{string, string2, null});
                    e16.printStackTrace();
                    return;
                }
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_YUAN_MENG_CARD, false, new Object[]{string, string2, null});
            return;
        }
        QLog.d("TroopGameHandler", 1, "handleGetTroopMemberYuanMengCard request | rsp | extra is null");
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_YUAN_MENG_CARD, false, null);
    }

    private void T2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString("troopUin");
            QLog.d("TroopGameHandler", 1, "handleGetTroopMetaDreamCardResp troopUin=" + string);
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    metadream_qgroup_datacard$GetGradeDistributeInfoRsp metadream_qgroup_datacard_getgradedistributeinforsp = new metadream_qgroup_datacard$GetGradeDistributeInfoRsp();
                    metadream_qgroup_datacard_getgradedistributeinforsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    TroopMetaDreamGameInfo troopMetaDreamGameInfo = new TroopMetaDreamGameInfo();
                    for (metadream_qgroup_datacard$GradeDistributed metadream_qgroup_datacard_gradedistributed : metadream_qgroup_datacard_getgradedistributeinforsp.info.get()) {
                        if (metadream_qgroup_datacard_gradedistributed != null) {
                            troopMetaDreamGameInfo.getGradeDistributedList().add(new TroopMetaDreamGameInfo.b(metadream_qgroup_datacard_gradedistributed.name.get(), metadream_qgroup_datacard_gradedistributed.count.get(), metadream_qgroup_datacard_gradedistributed.icon.get(), metadream_qgroup_datacard_gradedistributed.color.get()));
                        }
                    }
                    troopMetaDreamGameInfo.setRecentGameNum(metadream_qgroup_datacard_getgradedistributeinforsp.recent_game_num.get());
                    troopMetaDreamGameInfo.setRecentUserNum(metadream_qgroup_datacard_getgradedistributeinforsp.recent_user_num.get());
                    troopMetaDreamGameInfo.setRankPageUrl(metadream_qgroup_datacard_getgradedistributeinforsp.rank_page_url.get());
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_META_DREAM_CARD, true, new Object[]{string, troopMetaDreamGameInfo});
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopGameHandler", 1, "handleGetTroopMetaDreamCardResp Exception: " + e16);
                    }
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_META_DREAM_CARD, false, new Object[]{string, null});
                    e16.printStackTrace();
                    return;
                }
            }
            QLog.d("TroopGameHandler", 1, "handleGetTroopMetaDreamCardResp failed, ret: " + j3);
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_META_DREAM_CARD, false, new Object[]{string, null});
            return;
        }
        QLog.d("TroopGameHandler", 1, "handleGetTroopMetaDreamCardResp request | rsp | extra is null");
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_META_DREAM_CARD, false, null);
    }

    private void U2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && intent.getExtras() != null) {
            QLog.d("TroopGameHandler", 1, "handleSetGameInfoUserSwitch ret=" + j3 + ",range=" + intent.getExtras().getInt(DownloaderConstant.KEY_RANGE));
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    QqCardSvrPB$SetSwitchRsp qqCardSvrPB$SetSwitchRsp = new QqCardSvrPB$SetSwitchRsp();
                    qqCardSvrPB$SetSwitchRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_SET_MEMBER_GAME_INFO_SWITCH, true, new Object[]{qqCardSvrPB$SetSwitchRsp});
                    return;
                } catch (Exception e16) {
                    QLog.d("TroopGameHandler", 1, "handleSetGameInfoUserSwitch Exception: " + e16);
                    return;
                }
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_SET_MEMBER_GAME_INFO_SWITCH, false, new Object[]{null});
            return;
        }
        QLog.d("TroopGameHandler", 1, "handleSetGameInfoUserSwitch request | rsp | extras is null");
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_SET_MEMBER_GAME_INFO_SWITCH, false, null);
    }

    private void V2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString("troopUin");
            String string2 = intent.getExtras().getString("memberUin");
            QLog.d("TroopGameHandler", 1, "handleSetMyTroopMetaDreamUserSwitchResp ret=" + j3 + ",troopUin=" + string + ",memberUin=" + string2);
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    MessageMicro<metadream_qgroup_datacard$SetGroupUserSwitchRsp> messageMicro = new MessageMicro<metadream_qgroup_datacard$SetGroupUserSwitchRsp>() { // from class: com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$SetGroupUserSwitchRsp
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"switch_err", "uin", "download_url", "auth_url"}, new Object[]{0, 0L, "", ""}, metadream_qgroup_datacard$SetGroupUserSwitchRsp.class);
                        public final PBEnumField switch_err = PBField.initEnum(0);
                        public final PBUInt64Field uin = PBField.initUInt64(0);
                        public final PBStringField download_url = PBField.initString("");
                        public final PBStringField auth_url = PBField.initString("");
                    };
                    messageMicro.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_SET_MEMBER_META_DREAM_SWITCH, true, new Object[]{string, string2, messageMicro});
                    return;
                } catch (Exception e16) {
                    QLog.d("TroopGameHandler", 1, "handleSetMyTroopMetaDreamUserSwitchResp Exception: " + e16);
                    return;
                }
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_SET_MEMBER_META_DREAM_SWITCH, false, new Object[]{string, string2, null});
            return;
        }
        QLog.d("TroopGameHandler", 1, "handleSetMyTroopMetaDreamUserSwitchResp request | rsp | extra is null");
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_SET_MEMBER_META_DREAM_SWITCH, false, null);
    }

    private void W2(long j3, ToServiceMsg toServiceMsg, int i3) {
        if (i3 == 15) {
            int i16 = toServiceMsg.extraData.getInt("who");
            int i17 = toServiceMsg.extraData.getInt("changeFlag");
            QLog.d("TroopGameHandler", 2, "saveTroopInfoWith0x8fcRsp who=" + i16 + ",changeFlag=" + i17);
            TroopInfo troopInfo = ((ITroopInfoService) this.f300290f.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(String.valueOf(j3));
            if (troopInfo != null) {
                if (Arrays.asList(1, 2, 4, 16, 64).contains(Integer.valueOf(i16))) {
                    if ((i17 & i16) == 0) {
                        troopInfo.cmduinFlagEx3Grocery &= ~i16;
                    } else {
                        troopInfo.cmduinFlagEx3Grocery |= i16;
                    }
                    if (i16 == 64) {
                        troopInfo.cmduinFlagEx3Grocery |= 128;
                    }
                }
                TroopOperationRepo.INSTANCE.updateGameCardSwitch(String.valueOf(j3), troopInfo.cmduinFlagEx3Grocery);
                HashMap hashMap = new HashMap();
                hashMap.put(getCurrentAccountUin(), Long.valueOf(troopInfo.cmduinFlagEx3Grocery));
                ((ITroopMemberExtDBApi) QRoute.api(ITroopMemberExtDBApi.class)).updateTroopMemberFlagEx3(String.valueOf(j3), hashMap, "TroopGameHandler");
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void A1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        QLog.d("TroopGameHandler", 1, "notifyTroopGameCardUpdate troopUin=" + str);
        try {
            sgame_qgroup_datacard$NotifyUpdateReq sgame_qgroup_datacard_notifyupdatereq = new sgame_qgroup_datacard$NotifyUpdateReq();
            sgame_qgroup_datacard_notifyupdatereq.groupId.set(Long.valueOf(str).longValue());
            TrpcProxy.TrpcListReq G2 = G2(WadlProxyConsts.CMD_TRPC_GAME_NOTIFYUPDATEREQ, sgame_qgroup_datacard_notifyupdatereq.toByteArray(), 1);
            Bundle bundle = new Bundle();
            bundle.putString("troopUin", str);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(G2, bundle);
        } catch (Exception e16) {
            QLog.d("TroopGameHandler", 1, "notifyTroopGameCardUpdate Exception: " + e16);
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void J(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        QLog.d("TroopGameHandler", 1, "getTroopMetaDreamCardInfo: " + str);
        try {
            metadream_qgroup_datacard$GetGradeDistributeInfoReq metadream_qgroup_datacard_getgradedistributeinforeq = new metadream_qgroup_datacard$GetGradeDistributeInfoReq();
            metadream_qgroup_datacard_getgradedistributeinforeq.group_code.set(Long.parseLong(str));
            I2(str, WadlProxyConsts.CMD_TRPC_GAME_QUERY_METADREAM_TROOP_INFO, metadream_qgroup_datacard_getgradedistributeinforeq.toByteArray());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameHandler", 1, "getTroopMetaDreamCardInfo Exception: " + e16);
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_META_DREAM_CARD, false, new Object[]{str, null});
            e16.printStackTrace();
        }
    }

    public void J2(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) str2);
            return;
        }
        QLog.d("TroopGameHandler", 1, "getTroopMemberGameCardV2 troopUin=,memberUin=" + str2);
        try {
            sgame_skin_wall$GetGameDetailAndSkinWallReq sgame_skin_wall_getgamedetailandskinwallreq = new sgame_skin_wall$GetGameDetailAndSkinWallReq();
            sgame_skin_wall_getgamedetailandskinwallreq.group_id.set(Long.valueOf(str).longValue());
            sgame_skin_wall_getgamedetailandskinwallreq.show_uin.set(Long.valueOf(str2).longValue());
            sgame_skin_wall_getgamedetailandskinwallreq.needs.add(1);
            sgame_skin_wall_getgamedetailandskinwallreq.needs.add(2);
            H2(str, str2, WadlProxyConsts.CMD_TRPC_GAME_QUERY_CARDINFO, sgame_skin_wall_getgamedetailandskinwallreq.toByteArray());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameHandler", 1, "getTroopMemberGameCardV2 Exception: " + e16);
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, false, new Object[]{str, str2, null});
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void K(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        QLog.d("TroopGameHandler", 1, "getTroopGameCardInfo: " + str);
        try {
            sgame_qgroup_datacard$QueryGroupInfoReq sgame_qgroup_datacard_querygroupinforeq = new sgame_qgroup_datacard$QueryGroupInfoReq();
            sgame_qgroup_datacard_querygroupinforeq.groupId.set(Long.valueOf(str).longValue());
            I2(str, WadlProxyConsts.CMD_TRPC_GAME_QUERRYGROUPINFO, sgame_qgroup_datacard_querygroupinforeq.toByteArray());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameHandler", 1, "getTroopGameCardInfo Exception: " + e16);
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_GAME_CARD, false, new Object[]{str, null});
            e16.printStackTrace();
        }
    }

    public void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg == null) {
            QLog.e("TroopGameHandler", 2, "handle0x8fc_20 failed. req is NULL!");
            return;
        }
        int i16 = toServiceMsg.extraData.getInt("key_subcmd");
        if (i16 != 15) {
            i3 = 0;
        } else {
            i3 = com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_MODIFY_MEMBER_GAME_CARD_SWITCH;
        }
        if (i3 == 0) {
            return;
        }
        if (fromServiceMsg == null) {
            QLog.e("TroopGameHandler", 2, "handle0x8fc_20 failed. resp is NULL!");
            notifyUI(i3, false, null);
            return;
        }
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
            Oidb_0x8fc$RspBody oidb_0x8fc$RspBody = new Oidb_0x8fc$RspBody();
            try {
                oidb_0x8fc$RspBody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                if (oidb_0x8fc$RspBody.uint64_group_code.has()) {
                    j3 = oidb_0x8fc$RspBody.uint64_group_code.get();
                } else {
                    try {
                        String string = toServiceMsg.extraData.getString("troopUin");
                        if (!TextUtils.isEmpty(string)) {
                            j3 = Long.parseLong(string);
                        }
                    } catch (Exception unused) {
                    }
                    j3 = 0;
                }
                int i17 = mergeFrom.uint32_result.get();
                String str = "";
                if (i17 != 0) {
                    if (oidb_0x8fc$RspBody.strErrInfo.has()) {
                        str = oidb_0x8fc$RspBody.strErrInfo.get();
                    }
                    QLog.e("TroopGameHandler", 2, "handle0x8fc_20 failed. resultCode = " + i17);
                    notifyUI(i3, false, new Object[]{Long.valueOf(j3), Long.valueOf((long) i17), str});
                    return;
                }
                W2(j3, toServiceMsg, i16);
                notifyUI(i3, true, new Object[]{Long.valueOf(j3), 0L, ""});
            } catch (InvalidProtocolBufferMicroException unused2) {
                QLog.e("TroopGameHandler", 2, "handle0x8fc_20 failed. InvalidProtocolBufferMicroException!");
                notifyUI(i3, false, null);
            }
        } catch (InvalidProtocolBufferMicroException unused3) {
            QLog.e("TroopGameHandler", 2, "handle0x8fc_20 failed. InvalidProtocolBufferMicroException!");
            notifyUI(i3, false, null);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void N0(long j3, boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), str);
            return;
        }
        QLog.i("TroopGameHandler", 1, "[notifyModifyTroopGameSwitch] tUin:" + j3 + ", isSus:" + z16 + ", code:" + i3 + ", msg:" + str);
        notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_MODIFY_TROOP_GAME_CARD_SWITCH, z16, new Object[]{Long.valueOf(j3), Integer.valueOf(i3), str});
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void R0(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.d("TroopGameHandler", 2, "modifyShowGameCardSwitch troopUin=" + str + ",who=" + i3 + ",changeFlag=" + i16);
        Oidb_0x8fc$ReqBody oidb_0x8fc$ReqBody = new Oidb_0x8fc$ReqBody();
        oidb_0x8fc$ReqBody.uint64_group_code.set(Long.parseLong(str));
        ArrayList arrayList = new ArrayList();
        Oidb_0x8fc$MemberInfo oidb_0x8fc$MemberInfo = new Oidb_0x8fc$MemberInfo();
        oidb_0x8fc$MemberInfo.uint64_uin.set(Long.parseLong(this.f300290f.getCurrentAccountUin()));
        oidb_0x8fc$MemberInfo.uint32_cmduin_flag_ex3_mask.set(i3);
        oidb_0x8fc$MemberInfo.uint32_cmduin_flag_ex3_grocery.set(i16);
        arrayList.add(oidb_0x8fc$MemberInfo);
        oidb_0x8fc$ReqBody.rpt_mem_level_info.set(arrayList);
        Oidb_0x8fc$ClientInfo oidb_0x8fc$ClientInfo = new Oidb_0x8fc$ClientInfo();
        oidb_0x8fc$ClientInfo.uint32_implat.set(109);
        oidb_0x8fc$ClientInfo.string_clientver.set(ah.P());
        oidb_0x8fc$ReqBody.msg_client_info.set(oidb_0x8fc$ClientInfo);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2300);
        oidb_sso_oidbssopkg.uint32_service_type.set(20);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x8fc$ReqBody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x8fc_20");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putInt("key_subcmd", 15);
        createToServiceMsg.extraData.putInt("who", i3);
        createToServiceMsg.extraData.putInt("changeFlag", i16);
        createToServiceMsg.extraData.putString("troopUin", str);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void T0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        QLog.d("TroopGameHandler", 1, "getGameInfoUserSwitch uin=" + str);
        try {
            QqCardSvrPB$GetSwitchReq qqCardSvrPB$GetSwitchReq = new QqCardSvrPB$GetSwitchReq();
            qqCardSvrPB$GetSwitchReq.uin.set(Long.valueOf(str).longValue());
            Bundle bundle = new Bundle();
            bundle.putString("memberUin", str);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(G2(WadlProxyConsts.CMD_TRPC_GAME_QUERY_GAME_INFO_USER_SWITCH, qqCardSvrPB$GetSwitchReq.toByteArray(), 0), bundle);
        } catch (Exception e16) {
            QLog.d("TroopGameHandler", 1, "getGameInfoUserSwitch Exception: " + e16);
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_INFO_SWITCH, false, new Object[]{str, null});
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void U0(String str, a.InterfaceC8809a interfaceC8809a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, (Object) interfaceC8809a);
            return;
        }
        SmobaMotorcadeSvrPB$IsUserInMotorcadeReq smobaMotorcadeSvrPB$IsUserInMotorcadeReq = new SmobaMotorcadeSvrPB$IsUserInMotorcadeReq();
        smobaMotorcadeSvrPB$IsUserInMotorcadeReq.group_id.set(Long.parseLong(str));
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.smoba_motorcade_svr.SmobaMotorcadeSvr", "/trpc.iqun.smoba_motorcade_svr.SmobaMotorcadeSvr/IsUserInMotorcade", smobaMotorcadeSvrPB$IsUserInMotorcadeReq.toByteArray(), 1, null, new b(interfaceC8809a));
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void g2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        QLog.d("TroopGameHandler", 1, "setGameInfoUserSwitch range=" + i3);
        try {
            QqCardSvrPB$SetSwitchReq qqCardSvrPB$SetSwitchReq = new QqCardSvrPB$SetSwitchReq();
            qqCardSvrPB$SetSwitchReq.status.set(i3);
            Bundle bundle = new Bundle();
            bundle.putInt(DownloaderConstant.KEY_RANGE, i3);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(G2(WadlProxyConsts.CMD_TRPC_GAME_SET_GAME_INFO_USER_SWITCH, qqCardSvrPB$SetSwitchReq.toByteArray(), 0), bundle);
        } catch (Exception e16) {
            QLog.d("TroopGameHandler", 1, "setGameInfoUserSwitch Exception: " + e16);
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_SET_MEMBER_GAME_INFO_SWITCH, false, new Object[]{null});
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f300291h == null) {
            HashSet hashSet = new HashSet();
            this.f300291h = hashSet;
            hashSet.add("OidbSvc.0x8fc_20");
            this.f300291h.add("OidbSvcTcp.0xf3c_1");
        }
        return this.f300291h;
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashSet) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f300289e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "TroopGameHandler";
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void k2(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            return;
        }
        QLog.d("TroopGameHandler", 1, "getTroopMemberMetaDreamCard: " + str + "::" + str2);
        try {
            metadream_qgroup_datacard$GetGroupUserInfoReq metadream_qgroup_datacard_getgroupuserinforeq = new metadream_qgroup_datacard$GetGroupUserInfoReq();
            metadream_qgroup_datacard_getgroupuserinforeq.group_code.set(Long.parseLong(str));
            metadream_qgroup_datacard_getgroupuserinforeq.to_uin.set(Long.parseLong(str2));
            H2(str, str2, WadlProxyConsts.CMD_TRPC_GAME_QUERY_METADREAM_MEMBER_INFO, metadream_qgroup_datacard_getgroupuserinforeq.toByteArray());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameHandler", 1, "getTroopMetaDreamCardInfo Exception: " + e16);
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_TROOP_MEMBER_META_DREAM_CARD, false, new Object[]{str, null});
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return com.tencent.mobileqq.troop.troopgame.api.b.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
        ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) this.f300290f.getRuntimeService(ITroopMemberInfoService.class, "");
        if (iTroopMemberInfoService != null) {
            iTroopMemberInfoService.removeTroopMemberUpdateObserver(this.f300292i);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0x8fc_20".equals(fromServiceMsg.getServiceCmd())) {
                K2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvcTcp.0xf3c_1".equals(fromServiceMsg.getServiceCmd())) {
                    O2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, intent, str, Long.valueOf(j3), trpcInovkeRsp);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameHandler", 2, "onTrpcRsp cmd=" + str + ",ret=" + j3);
        }
        if (str.equals(WadlProxyConsts.CMD_TRPC_GAME_QUERRYGROUPINFO)) {
            P2(intent, j3, trpcInovkeRsp);
            return;
        }
        if (str.equals(WadlProxyConsts.CMD_TRPC_GAME_QUERY_METADREAM_TROOP_INFO)) {
            T2(intent, j3, trpcInovkeRsp);
            return;
        }
        if (str.equals(WadlProxyConsts.CMD_TRPC_GAME_QUERY_METADREAM_MEMBER_INFO)) {
            R2(intent, j3, trpcInovkeRsp);
            return;
        }
        if (str.equals(WadlProxyConsts.CMD_TRPC_GAME_QUERY_CARDINFO)) {
            int i3 = 14;
            if (intent != null && intent.getExtras() != null) {
                i3 = intent.getExtras().getInt("gameType", 14);
            }
            if (i3 != 16) {
                Q2(intent, j3, trpcInovkeRsp);
                return;
            } else {
                S2(intent, j3, trpcInovkeRsp);
                return;
            }
        }
        if (str.equals(WadlProxyConsts.CMD_TRPC_GAME_QUERY_GAME_INFO_USER_SWITCH)) {
            M2(intent, j3, trpcInovkeRsp);
            return;
        }
        if (str.equals(WadlProxyConsts.CMD_TRPC_GAME_SET_GAME_INFO_USER_SWITCH)) {
            U2(intent, j3, trpcInovkeRsp);
            return;
        }
        if (str.equals(WadlProxyConsts.CMD_TRPC_GAME_QUERY_GAME_INFO_QUICK_AUTH)) {
            L2(intent, j3, trpcInovkeRsp);
        } else if (str.equals(WadlProxyConsts.CMD_TRPC_GAME_QUERY_METADREAM_USER_SWITCH)) {
            N2(intent, j3, trpcInovkeRsp);
        } else if (str.equals(WadlProxyConsts.CMD_TRPC_GAME_SET_METADREAM_USER_SWITCH)) {
            V2(intent, j3, trpcInovkeRsp);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void r2(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2);
            return;
        }
        QLog.d("TroopGameHandler", 1, "getTroopMemberYuanMengCard troopUin=", str, ",memberUin=" + str2);
        try {
            sgame_skin_wall$GetGameDetailAndSkinWallReq sgame_skin_wall_getgamedetailandskinwallreq = new sgame_skin_wall$GetGameDetailAndSkinWallReq();
            sgame_skin_wall_getgamedetailandskinwallreq.group_id.set(Long.valueOf(str).longValue());
            sgame_skin_wall_getgamedetailandskinwallreq.show_uin.set(Long.valueOf(str2).longValue());
            sgame_skin_wall_getgamedetailandskinwallreq.needs.add(3);
            TrpcProxy.TrpcListReq G2 = G2(WadlProxyConsts.CMD_TRPC_GAME_QUERY_CARDINFO, sgame_skin_wall_getgamedetailandskinwallreq.toByteArray(), 0);
            Bundle bundle = new Bundle();
            bundle.putString("troopUin", str);
            bundle.putString("memberUin", str2);
            bundle.putInt("gameType", 16);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(G2, bundle);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameHandler", 1, "getTroopMemberYuanMengCard Exception: " + e16);
            }
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, false, new Object[]{str, str2, null});
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void s2(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
        } else {
            J2(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.a
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QLog.d("TroopGameHandler", 1, "getGameInfoQuickAuth");
        try {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(G2(WadlProxyConsts.CMD_TRPC_GAME_QUERY_GAME_INFO_QUICK_AUTH, new MessageMicro<QqCardSvrPB$ShowQuickAuthorizeReq>() { // from class: com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$ShowQuickAuthorizeReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QqCardSvrPB$ShowQuickAuthorizeReq.class);
            }.toByteArray(), 0), null);
        } catch (Exception e16) {
            QLog.d("TroopGameHandler", 1, "getGameInfoQuickAuth Exception: " + e16);
            notifyUI(com.tencent.mobileqq.troop.troopgame.api.b.TYPE_NOTIFY_GET_MEMBER_GAME_INFO_QUICK_AUTH, false, new Object[]{null});
            e16.printStackTrace();
        }
    }
}
